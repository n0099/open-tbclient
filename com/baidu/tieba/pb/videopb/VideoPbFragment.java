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
import d.a.o0.b1.m.f;
import d.a.o0.h.a;
import d.a.o0.r.s.a;
import d.a.p0.h2.p.c;
import d.a.p0.i0.b;
import d.a.p0.u0.f2.a.c;
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
public class VideoPbFragment extends BaseFragment implements d.a.o0.b1.m.h, VoiceManager.j, d.a.p0.h2.o.b, TbRichTextView.r, d.a.p0.h2.o.a {
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
    public static final b.InterfaceC1456b Z1;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.p0.h2.o.i.a A;
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
    public d.a.p0.h2.o.j.a F;
    public boolean F0;
    public d.a.o0.w.w.c F1;
    public View.OnClickListener G;
    public boolean G0;
    public final View.OnClickListener G1;
    public TextView H;
    public ReplyPrivacyCheckController H0;
    public View.OnClickListener H1;
    public TextView I;
    public d.a.p0.u0.f2.a.c I0;
    public final AdapterView.OnItemClickListener I1;
    public ImageView J;
    public d.a.p0.u0.f2.a.c J0;
    public CustomMessageListener J1;
    public TBSpecificationBtn K;
    public d.a.p0.h2.k.e.v0 K0;
    public CustomMessageListener K1;
    public TbImageView L;
    public PermissionJudgePolicy L0;
    public final ItemCardHelper.b L1;
    public View M;
    public d.a.o0.w.w.g M0;
    public Runnable M1;
    public ValueAnimator N;
    public d.a.o0.w.w.e N0;
    public CustomMessageListener N1;
    public ValueAnimator O;
    public EditorTools O0;
    public final View.OnLongClickListener O1;
    public FallingView P;
    public d.a.p0.h2.k.e.u P0;
    public SortSwitchButton.f P1;
    public TbImageView Q;
    public PbFakeFloorModel Q0;
    public boolean R;
    public d.a.p0.i0.b R0;
    public View S;
    public int[] S0;
    public d.a.p0.h2.o.g.a T;
    public int T0;
    public d.a.o0.r.f0.c U;
    public int U0;
    public d.a.o0.h.a V;
    public int V0;
    public d.a.p0.h2.k.e.b1.f.a W;
    public int W0;
    public EmotionImageData X;
    public int X0;
    public d.a.o0.s.e.a Y;
    public boolean Y0;
    public ForumManageModel Z;
    public boolean Z0;
    public VoiceManager a0;
    public RightFloatLayerView a1;
    public d.a.c.e.k.b<GifView> b0;
    public final CustomMessageListener b1;
    public d.a.c.e.k.b<TextView> c0;
    public final PbModel.g c1;
    public final a.InterfaceC1192a d1;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f19684e;
    public d.a.o0.w.w.b e1;

    /* renamed from: f  reason: collision with root package name */
    public long f19685f;
    public final CustomMessageListener f1;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f19686g;
    public CustomMessageListener g1;

    /* renamed from: h  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f19687h;
    public final CustomMessageListener h1;

    /* renamed from: i  reason: collision with root package name */
    public CustomViewPager f19688i;
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
    public d.a.o0.w.w.b n1;
    public d.a.p0.h2.o.k.a o;
    public View o0;
    public final NewWriteModel.g o1;
    public d.a.p0.h2.o.e p;
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
    public d.a.p0.h2.p.h w0;
    public View.OnTouchListener w1;
    public d.a.p0.z.a x;
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
        public final /* synthetic */ VideoPbFragment f19689a;

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
            this.f19689a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19689a.Y0) {
                return;
            }
            this.f19689a.K4();
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19690e;

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
            this.f19690e = videoPbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f19690e.y() == null || this.f19690e.y().M0() == i2 + 1) {
                return;
            }
            VideoPbFragment videoPbFragment = this.f19690e;
            videoPbFragment.p4(videoPbFragment.k3(i2));
        }
    }

    /* loaded from: classes4.dex */
    public class a1 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19691a;

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
            this.f19691a = videoPbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                d.a.p0.h2.o.g.a aVar = this.f19691a.T;
                if (aVar != null) {
                    aVar.F();
                }
                boolean z = false;
                if (!d.a.c.e.p.j.z()) {
                    this.f19691a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.f19691a.y() != null && !this.f19691a.y().isLoading) {
                    this.f19691a.S4();
                    this.f19691a.y4();
                    z = true;
                    if (this.f19691a.y().D0() != null && this.f19691a.y().D0().f56898f != null && this.f19691a.y().D0().f56898f.size() > i2) {
                        int intValue = this.f19691a.y().D0().f56898f.get(i2).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.f19691a.y().U0()).param("fid", this.f19691a.y().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.f19691a.y().b2(intValue)) {
                            this.f19691a.R = true;
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
        public final /* synthetic */ VideoPbFragment f19692a;

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
            this.f19692a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            d.a.p0.h2.e eVar = (d.a.p0.h2.e) customResponsedMessage.getData();
            int b2 = eVar.b();
            if (b2 == 0) {
                this.f19692a.i4((d.a.p0.h2.h.r) eVar.a());
            } else if (b2 == 1) {
                this.f19692a.R2((ForumManageModel.b) eVar.a(), false);
            } else if (b2 != 2) {
            } else {
                if (eVar.a() == null) {
                    this.f19692a.g4(false, null);
                } else {
                    this.f19692a.g4(true, (MarkData) eVar.a());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19693a;

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
            this.f19693a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f19693a.a5();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19694a;

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
            this.f19694a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                d.a.o0.b1.m.f.c(this.f19694a.getPageContext(), this.f19694a, aVar.f51751a, aVar.f51752b, aVar.f51753c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19695a;

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
            this.f19695a = videoPbFragment;
        }

        @Override // d.a.p0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // d.a.p0.u0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f19695a.N0 != null && this.f19695a.N0.a() != null) {
                    this.f19695a.N0.a().A(new d.a.o0.w.a(45, 27, null));
                }
                this.f19695a.K2();
            }
        }

        @Override // d.a.p0.u0.f2.a.c.d
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
        public final /* synthetic */ VideoPbFragment f19699a;

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
            this.f19699a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.f19699a.getView() != null) {
                    VideoPbFragment videoPbFragment = this.f19699a;
                    videoPbFragment.hideLoadingView(videoPbFragment.getView());
                    this.f19699a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            BdTopToast bdTopToast = new BdTopToast(this.f19699a.getContext());
                            bdTopToast.i(true);
                            bdTopToast.h(this.f19699a.getString(R.string.block_user_success));
                            bdTopToast.j((ViewGroup) this.f19699a.getView());
                            this.f19699a.z4(type);
                            return;
                        }
                        String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f19699a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString();
                        BdTopToast bdTopToast2 = new BdTopToast(this.f19699a.getContext());
                        bdTopToast2.i(false);
                        bdTopToast2.h(string);
                        bdTopToast2.j((ViewGroup) this.f19699a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements Observer<d.a.o0.r.q.b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19700e;

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
            this.f19700e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable d.a.o0.r.q.b2 b2Var) {
            BdTypeRecyclerView m3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) || b2Var == null || b2Var.l1() == null) {
                return;
            }
            if (this.f19700e.o.c0() == null || !this.f19700e.o.c0().equals(b2Var.l1().video_url)) {
                if (!d.a.c.e.p.k.isEmpty(this.f19700e.o.c0())) {
                    this.f19700e.G0 = true;
                    if (this.f19700e.J3()) {
                        this.f19700e.f19688i.setCurrentItem(VideoPbFragment.Q1);
                    } else {
                        this.f19700e.f19688i.setCurrentItem(VideoPbFragment.S1);
                    }
                    if (!this.f19700e.J3() && (m3 = this.f19700e.m3()) != null) {
                        m3.scrollToPosition(0);
                    }
                }
                if (this.f19700e.p == null || !this.f19700e.p.k()) {
                    this.f19700e.l4();
                    this.f19700e.C2(b2Var);
                }
                this.f19700e.I3();
                if (this.f19700e.p != null && this.f19700e.p.l()) {
                    this.f19700e.p.s();
                }
                boolean z = !StringHelper.equals(this.f19700e.o.c0(), b2Var.l1().video_url);
                this.f19700e.o.setData(b2Var);
                if (this.f19700e.J3()) {
                    this.f19700e.o.W0(this.f19700e.f19688i.getCurrentItem() == 0);
                } else {
                    this.f19700e.o.W0(false);
                }
                if (z) {
                    this.f19700e.o.startPlay();
                    this.f19700e.o.z0();
                    return;
                }
                return;
            }
            this.f19700e.o.setData(b2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class c1 implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19701a;

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
            this.f19701a = videoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(d.a.p0.h2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, d.a.p0.h2.h.e eVar, String str, int i5) {
            String o3;
            d.a.o0.w.h m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
                this.f19701a.x4();
                this.f19701a.v3();
                if (this.f19701a.R) {
                    this.f19701a.R = false;
                }
                this.f19701a.F4(false);
                if (z && eVar != null) {
                    d.a.o0.r.q.b2 N = eVar.N();
                    ((VideoPbViewModel) ViewModelProviders.of(this.f19701a.getActivity()).get(VideoPbViewModel.class)).s(eVar, i3);
                    this.f19701a.b4(eVar);
                    this.f19701a.H4(eVar);
                    this.f19701a.h4(eVar);
                    this.f19701a.e4(z, i2, i3, i4, eVar, str, i5);
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.T().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.T().getBimg_end_time());
                    if (this.f19701a.V != null) {
                        this.f19701a.V.h(eVar.s());
                    }
                    AntiData d2 = eVar.d();
                    if (d2 != null) {
                        this.f19701a.C0 = d2.getVoice_message();
                        if (!StringUtils.isNull(this.f19701a.C0) && this.f19701a.N0 != null && this.f19701a.N0.a() != null && (m = this.f19701a.N0.a().m(6)) != null && !TextUtils.isEmpty(this.f19701a.C0)) {
                            ((View) m).setOnClickListener(this.f19701a.p1);
                        }
                    }
                    if (this.f19701a.H0 != null && N != null && N.H() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(N.H());
                        this.f19701a.H0.setLikeUserData(attentionHostData);
                    }
                    this.f19701a.F3(eVar);
                    if (this.f19701a.y() != null && this.f19701a.y().b1()) {
                        o3 = this.f19701a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else {
                        o3 = this.f19701a.o3();
                    }
                    if (!StringUtils.isNull(o3)) {
                        this.f19701a.N0.k0(TbSingleton.getInstance().getAdVertiComment(eVar.g0(), eVar.h0(), o3));
                    }
                } else {
                    if (i2 == 4 || i2 == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.f19701a.y().T0());
                            jSONObject.put("fid", this.f19701a.y().getForumId());
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
                    if ((this.f19701a.J3() && this.f19701a.n3() == null) || this.f19701a.Y2() == null) {
                        return;
                    }
                    ArrayList<PostData> arrayList = null;
                    if (this.f19701a.J3()) {
                        if (i2 != -1) {
                            if (this.f19701a.y() != null && this.f19701a.y().D0() != null) {
                                arrayList = this.f19701a.y().D0().E();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f19701a.n3().n1(this.f19701a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.f19701a.n3().h1()) {
                                this.f19701a.n3().o1(this.f19701a.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                this.f19701a.n3().o1(this.f19701a.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            this.f19701a.n3().n1("");
                        }
                        this.f19701a.n3().U0();
                    } else {
                        if (i2 != -1) {
                            if (this.f19701a.y() != null && this.f19701a.y().D0() != null) {
                                arrayList = this.f19701a.y().D0().E();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f19701a.Y2().t1(this.f19701a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.f19701a.Y2().k1()) {
                                this.f19701a.Y2().u1(this.f19701a.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                this.f19701a.Y2().u1(this.f19701a.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            this.f19701a.Y2().t1("");
                        }
                        this.f19701a.Y2().W0();
                    }
                }
                d.a.p0.g3.c.g().h(this.f19701a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19702a;

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
            this.f19702a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f19702a.T != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.p0.s3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f19702a.T.D) {
                d.a.p0.s3.a aVar = (d.a.p0.s3.a) customResponsedMessage.getData();
                this.f19702a.T.V();
                SparseArray<Object> sparseArray = (SparseArray) this.f19702a.T.O();
                DataRes dataRes = aVar.f62215a;
                if (aVar.f62217c == 0 && dataRes != null) {
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
                    this.f19702a.T.y0(r2, sparseArray);
                } else if (intValue == 1) {
                    this.f19702a.T.i0(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements Observer<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19703e;

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
            this.f19703e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                this.f19703e.f19688i.setCurrentItem(num.intValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19704a;

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
            this.f19704a = videoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.o0.r.s.a aVar) {
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
        public final /* synthetic */ VideoPbFragment f19705a;

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
            this.f19705a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19705a.T == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            d.a.p0.h2.o.g.a aVar = this.f19705a.T;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                d.a.p0.h2.h.e D0 = this.f19705a.y().D0();
                if (D0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    D0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.f19705a.U.c(this.f19705a.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f19705a.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.f19705a.T.E0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.f19705a.T.x0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (d.a.c.e.p.k.isEmpty(errorString2)) {
                        errorString2 = this.f19705a.getResources().getString(R.string.mute_fail);
                    }
                    this.f19705a.U.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements Observer<d.a.o0.r.q.b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19706e;

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
            this.f19706e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable d.a.o0.r.q.b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) {
                this.f19706e.o.Z0(b2Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19707e;

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
            this.f19707e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19707e.k4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19708a;

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
            this.f19708a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19708a.T == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            d.a.p0.h2.o.g.a aVar = this.f19708a.T;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.f19708a.U.c(this.f19708a.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (d.a.c.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = this.f19708a.getResources().getString(R.string.un_mute_fail);
                }
                this.f19708a.U.b(muteMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements Observer<d.a.o0.r.q.b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19709e;

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
            this.f19709e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable d.a.o0.r.q.b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) {
                this.f19709e.o.Y0(b2Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f1 implements d.a.o0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19710e;

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
            this.f19710e = videoPbFragment;
        }

        @Override // d.a.o0.w.b
        public void onAction(d.a.o0.w.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f53489c;
                if (obj instanceof d.a.o0.s.c.v) {
                    if (((d.a.o0.s.c.v) obj).f() == EmotionGroupType.BIG_EMOTION || ((d.a.o0.s.c.v) aVar.f53489c).f() == EmotionGroupType.USER_COLLECT) {
                        if (this.f19710e.L0 == null) {
                            this.f19710e.L0 = new PermissionJudgePolicy();
                        }
                        this.f19710e.L0.clearRequestPermissionList();
                        this.f19710e.L0.appendRequestPermission(this.f19710e.getBaseFragmentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                        if (this.f19710e.L0.startRequestPermission(this.f19710e.getBaseFragmentActivity())) {
                            return;
                        }
                        this.f19710e.N0.h((d.a.o0.s.c.v) aVar.f53489c);
                        this.f19710e.N0.z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.o0.w.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19711a;

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
            this.f19711a = videoPbFragment;
        }

        @Override // d.a.o0.w.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.p0.h2.k.e.v0 v0Var = this.f19711a.K0;
                if (v0Var == null || v0Var.g() == null || !this.f19711a.K0.g().d()) {
                    return !this.f19711a.J2(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                VideoPbFragment videoPbFragment = this.f19711a;
                videoPbFragment.showToast(videoPbFragment.K0.g().c());
                if (this.f19711a.P0 != null && this.f19711a.P0.b() != null && this.f19711a.P0.b().v()) {
                    this.f19711a.P0.b().t(this.f19711a.K0.h());
                }
                this.f19711a.K0.b(true);
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
        public final /* synthetic */ String f19712e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19713f;

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
            this.f19713f = videoPbFragment;
            this.f19712e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19713f.a1.k();
                if (!StringUtils.isNull(this.f19712e)) {
                    this.f19713f.O3(this.f19712e);
                }
                this.f19713f.w3();
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
        public final /* synthetic */ VideoPbFragment f19714e;

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
            this.f19714e = videoPbFragment;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.a.p0.h2.k.e.v0 v0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f19714e.K0) == null || v0Var.e() == null) {
                return;
            }
            if (!this.f19714e.K0.e().e()) {
                this.f19714e.K0.a(false);
            }
            this.f19714e.K0.e().l(false);
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
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) != null) || this.f19714e.O0 == null || this.f19714e.O0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2) || TextUtils.isEmpty(charSequence.toString().substring(i2, i5))) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19715a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f19716e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f19717f;

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
                this.f19717f = hVar;
                this.f19716e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19716e == null) {
                    return;
                }
                this.f19717f.f19715a.R4();
                this.f19717f.f19715a.Z3(this.f19716e.getmAdverSegmentData(), 2);
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

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
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
            public final /* synthetic */ h f19718e;

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
                this.f19718e = hVar;
            }

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f19718e.f19715a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f19718e.f19715a.getActivity(), 0, 26, 2)));
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
            this.f19715a = videoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.o0.s.c.i0 i0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) {
                if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f19715a.y() != null && this.f19715a.y().D0() != null) {
                        statisticItem.param("fid", this.f19715a.y().D0().n());
                    }
                    statisticItem.param("tid", this.f19715a.y().T0());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.f19715a.S4();
                this.f19715a.w4(z, postWriteCallBackData);
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
                        this.f19715a.showToast(str);
                        if (this.f19715a.N0.B() || this.f19715a.N0.D()) {
                            this.f19715a.N0.z(false, postWriteCallBackData);
                        }
                        this.f19715a.K0.k(postWriteCallBackData);
                        return;
                    } else if (i2 == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.f19715a.H0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.f19715a.getActivity(), this.f19715a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.f19715a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f19715a.getActivity());
                        if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                            aVar.setMessage(this.f19715a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            aVar.setMessage(postWriteCallBackData.getErrorString());
                        }
                        aVar.setNegativeButton(R.string.cancel, new b(this));
                        aVar.setPositiveButton(R.string.open_now, new c(this));
                        aVar.create(this.f19715a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (d.a.p0.r3.a.c(i2) || i0Var != null || i2 == 227001) {
                        return;
                    } else {
                        this.f19715a.D4(i2, antiData, str);
                        return;
                    }
                }
                if (PbReplySwitch.getInOn() && this.f19715a.y() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    this.f19715a.y().O(postWriteCallBackData.getPostId());
                    if (this.f19715a.J3() && this.f19715a.n3() != null) {
                        VideoPbFragment videoPbFragment = this.f19715a;
                        videoPbFragment.W0 = videoPbFragment.n3().X0();
                        VideoPbFragment videoPbFragment2 = this.f19715a;
                        videoPbFragment2.X0 = videoPbFragment2.n3().Y0();
                        this.f19715a.y().L1(this.f19715a.W0, this.f19715a.X0);
                    } else if (this.f19715a.Y2() != null) {
                        VideoPbFragment videoPbFragment3 = this.f19715a;
                        videoPbFragment3.W0 = videoPbFragment3.Y2().Z0();
                        VideoPbFragment videoPbFragment4 = this.f19715a;
                        videoPbFragment4.X0 = videoPbFragment4.Y2().a1();
                        this.f19715a.y().L1(this.f19715a.W0, this.f19715a.X0);
                    }
                }
                if (this.f19715a.f19688i != null) {
                    if (this.f19715a.J3()) {
                        this.f19715a.f19688i.setCurrentItem(VideoPbFragment.R1);
                    } else {
                        this.f19715a.f19688i.setCurrentItem(VideoPbFragment.S1);
                    }
                }
                this.f19715a.T.F();
                this.f19715a.K0.c();
                if (this.f19715a.N0 != null) {
                    VideoPbFragment videoPbFragment5 = this.f19715a;
                    videoPbFragment5.s4(videoPbFragment5.N0.C());
                }
                this.f19715a.t3();
                this.f19715a.F4(true);
                this.f19715a.y().Z0();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.f19715a.E4(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.f19715a.y().i0()) {
                        d.a.p0.h2.h.e D0 = this.f19715a.y().D0();
                        if (D0 != null && D0.N() != null && D0.N().H() != null && (userId = D0.N().H().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.f19715a.y().Y1()) {
                            this.f19715a.y4();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.f19715a.y().Y1()) {
                        this.f19715a.y4();
                    }
                } else if (floor != null) {
                    if (this.f19715a.J3() && this.f19715a.n3() != null) {
                        this.f19715a.n3().g1();
                    } else if (this.f19715a.Y2() != null) {
                        this.f19715a.Y2().j1();
                    }
                }
                if (postWriteCallBackData.getmAdverSegmentData() != null) {
                    d.a.c.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                VideoPbFragment videoPbFragment6 = this.f19715a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                videoPbFragment6.B2(z2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19719e;

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
            this.f19719e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f19719e.d4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19720e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f19721f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19722g;

        /* loaded from: classes4.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h1 f19723e;

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
                this.f19723e = h1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.a.p0.h2.k.e.v0 v0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f19723e.f19722g.K0) == null || v0Var.g() == null) {
                    return;
                }
                if (!this.f19723e.f19722g.K0.g().e()) {
                    this.f19723e.f19722g.K0.b(false);
                }
                this.f19723e.f19722g.K0.g().l(false);
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
            this.f19722g = videoPbFragment;
            this.f19720e = str;
            this.f19721f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = d.a.c.e.p.l.i(this.f19722g.f19684e.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = d.a.c.e.p.l.g(this.f19722g.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i2 = i3 / 2;
                    g2 = d.a.c.e.p.l.g(this.f19722g.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i4 = i3 - (i2 + g2);
                VideoPbFragment videoPbFragment = this.f19722g;
                boolean z = true;
                int i5 = (videoPbFragment.S0[1] + videoPbFragment.T0) - i4;
                if (videoPbFragment.m3() != null) {
                    this.f19722g.m3().smoothScrollBy(0, i5);
                }
                if (this.f19722g.P0 != null) {
                    this.f19722g.N0.a().setVisibility(8);
                    this.f19722g.P0.n(this.f19720e, this.f19721f, this.f19722g.o3(), (this.f19722g.y() == null || this.f19722g.y().D0() == null || this.f19722g.y().D0().N() == null || !this.f19722g.y().D0().N().I1()) ? false : false);
                    d.a.o0.w.w.h b2 = this.f19722g.P0.b();
                    if (b2 != null && this.f19722g.y() != null && this.f19722g.y().D0() != null) {
                        b2.E(this.f19722g.y().D0().d());
                        b2.X(this.f19722g.y().D0().N());
                    }
                    if (this.f19722g.K0.f() == null && this.f19722g.P0.b().s() != null) {
                        this.f19722g.P0.b().s().g(new a(this));
                        VideoPbFragment videoPbFragment2 = this.f19722g;
                        videoPbFragment2.K0.n(videoPbFragment2.P0.b().s().i());
                        this.f19722g.P0.b().K(this.f19722g.n1);
                    }
                }
                this.f19722g.r3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19724e;

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
            this.f19724e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPbFragment videoPbFragment = this.f19724e;
                videoPbFragment.showToast(videoPbFragment.C0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19725e;

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
            this.f19725e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f19725e.q.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f19726a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19727b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19728c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i1 f19729e;

            /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$i1$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0234a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f19730e;

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
                    this.f19730e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    d.a.p0.h2.k.e.v0 v0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f19730e.f19729e.f19728c.K0) == null || v0Var.g() == null) {
                        return;
                    }
                    if (!this.f19730e.f19729e.f19728c.K0.g().e()) {
                        this.f19730e.f19729e.f19728c.K0.b(false);
                    }
                    this.f19730e.f19729e.f19728c.K0.g().l(false);
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
                this.f19729e = i1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int g2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = d.a.c.e.p.l.i(this.f19729e.f19728c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g2 = d.a.c.e.p.l.g(this.f19729e.f19728c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    } else {
                        i2 = i3 / 2;
                        g2 = d.a.c.e.p.l.g(this.f19729e.f19728c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    }
                    int i4 = i3 - (i2 + g2);
                    VideoPbFragment videoPbFragment = this.f19729e.f19728c;
                    boolean z = true;
                    int i5 = (videoPbFragment.S0[1] + videoPbFragment.T0) - i4;
                    if (videoPbFragment.m3() != null) {
                        this.f19729e.f19728c.m3().smoothScrollBy(0, i5);
                    }
                    if (this.f19729e.f19728c.P0 != null) {
                        this.f19729e.f19728c.N0.a().setVisibility(8);
                        z = (this.f19729e.f19728c.y() == null || this.f19729e.f19728c.y().D0() == null || this.f19729e.f19728c.y().D0().N() == null || !this.f19729e.f19728c.y().D0().N().I1()) ? false : false;
                        d.a.p0.h2.k.e.u uVar = this.f19729e.f19728c.P0;
                        i1 i1Var = this.f19729e;
                        uVar.n(i1Var.f19726a, i1Var.f19727b, i1Var.f19728c.o3(), z);
                        d.a.o0.w.w.h b2 = this.f19729e.f19728c.P0.b();
                        if (b2 != null && this.f19729e.f19728c.y() != null && this.f19729e.f19728c.y().D0() != null) {
                            b2.E(this.f19729e.f19728c.y().D0().d());
                            b2.X(this.f19729e.f19728c.y().D0().N());
                        }
                        if (this.f19729e.f19728c.K0.f() == null && this.f19729e.f19728c.P0.b().s() != null) {
                            this.f19729e.f19728c.P0.b().s().g(new C0234a(this));
                            VideoPbFragment videoPbFragment2 = this.f19729e.f19728c;
                            videoPbFragment2.K0.n(videoPbFragment2.P0.b().s().i());
                            this.f19729e.f19728c.P0.b().K(this.f19729e.f19728c.n1);
                        }
                    }
                    this.f19729e.f19728c.r3();
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
            this.f19728c = videoPbFragment;
            this.f19726a = str;
            this.f19727b = str2;
        }

        @Override // d.a.p0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // d.a.p0.u0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                d.a.c.e.m.e.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // d.a.p0.u0.f2.a.c.d
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
        public final /* synthetic */ VideoPbFragment f19731a;

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
            this.f19731a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f19731a.N0 != null) {
                VideoPbFragment videoPbFragment = this.f19731a;
                videoPbFragment.s4(videoPbFragment.N0.C());
            }
            this.f19731a.F4(false);
        }
    }

    /* loaded from: classes4.dex */
    public class j0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbViewModel f19732e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19733f;

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
            this.f19733f = videoPbFragment;
            this.f19732e = videoPbViewModel;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (!d.a.o0.c1.b.e.d() && this.f19733f.J3() && (this.f19732e.m() || this.f19733f.y().S0() == VideoPbFragment.R1)) {
                    this.f19733f.f19688i.setCurrentItem(VideoPbFragment.R1);
                } else if (this.f19732e.m() || this.f19733f.y().S0() == VideoPbFragment.S1) {
                    this.f19733f.f19688i.setCurrentItem(VideoPbFragment.S1);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (!d.a.o0.c1.b.e.d() && this.f19733f.J3() && (this.f19732e.m() || this.f19733f.y().S0() == VideoPbFragment.R1)) {
                    this.f19733f.f19688i.setCurrentItem(VideoPbFragment.R1);
                } else if (this.f19732e.m() || this.f19733f.y().S0() == VideoPbFragment.S1) {
                    this.f19733f.f19688i.setCurrentItem(VideoPbFragment.S1);
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
        public final /* synthetic */ VideoPbFragment f19734e;

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
            this.f19734e = videoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19734e.A == null || this.f19734e.A.o()) {
                    if (this.f19734e.A != null && this.f19734e.y() != null && this.f19734e.y().D0() != null && this.f19734e.y().D0().m() != null) {
                        TiebaStatic.log(new StatisticItem("c13712").param("fid", this.f19734e.y().D0().m().getId()).param("fname", this.f19734e.y().D0().m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f19734e.y().D0().P()).param("obj_param1", this.f19734e.A.o));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13608").param("obj_id", this.f19734e.A.getTitle()).param("obj_name", this.f19734e.A.j()).param("obj_type", 2).param("fid", this.f19734e.y().D0().n()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f19734e.y().D0().P()));
                }
                this.f19734e.N4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19735e;

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
            this.f19735e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19735e.A == null || this.f19735e.A.o()) {
                    if (this.f19735e.A != null) {
                        if (!this.f19735e.A.l) {
                            if (this.f19735e.A.q != null) {
                                YYLiveUtil.jumpToYYLiveRoom(this.f19735e.getPageContext(), this.f19735e.A.q.mSid, this.f19735e.A.q.mSsid, this.f19735e.A.q.mTemplateId, "", YYLiveUtil.SOURCE_PB_LIVE_BANNER);
                            }
                        } else {
                            VideoPbFragment videoPbFragment = this.f19735e;
                            videoPbFragment.N3(videoPbFragment.A.n, this.f19735e.A.m);
                        }
                        if (this.f19735e.y() == null || this.f19735e.y().D0() == null || this.f19735e.y().D0().m() == null) {
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c13713").param("fid", this.f19735e.y().D0().m().getId()).param("fname", this.f19735e.y().D0().m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f19735e.y().D0().P()).param("obj_param1", this.f19735e.A.o));
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13590").param("obj_id", this.f19735e.A.getTitle()).param("obj_name", this.f19735e.A.j()).param("obj_type", 2).param("fid", this.f19735e.y().D0().n()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f19735e.y().D0().P()));
                String e2 = this.f19735e.A.e();
                if (TextUtils.isEmpty(e2)) {
                    return;
                }
                if (!URLUtil.isHttpUrl(e2) && !URLUtil.isHttpsUrl(e2)) {
                    Uri parse = Uri.parse(e2);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(this.f19735e.getActivity(), parse.toString());
                        return;
                    }
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f19735e.getPageContext(), new String[]{e2});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19736a;

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
            this.f19736a = videoPbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.f19736a.N0.L(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.f19736a.P0 != null && this.f19736a.P0.b() != null) {
                    this.f19736a.P0.b().D();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    VideoPbFragment videoPbFragment = this.f19736a;
                    videoPbFragment.o4(videoPbFragment.X);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19737e;

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
            this.f19737e = videoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f19737e.z.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19738e;

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
            this.f19738e = videoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return this.f19738e.x1 != null && this.f19738e.x1.onTouchEvent(motionEvent);
                }
                if (this.f19738e.r1 == 1) {
                    if (!this.f19738e.v1) {
                        this.f19738e.P4();
                        UtilHelper.showStatusBar(this.f19738e.z(), this.f19738e.z().getRootView());
                        this.f19738e.v1 = true;
                        d.a.c.e.m.e.a().removeCallbacks(this.f19738e.z1);
                        d.a.c.e.m.e.a().postDelayed(this.f19738e.z1, 3000L);
                    }
                } else if (this.f19738e.r1 == 2 && (this.f19738e.v1 || this.f19738e.K3())) {
                    this.f19738e.O4();
                    UtilHelper.hideStatusBar(this.f19738e.z(), this.f19738e.z().getRootView());
                    this.f19738e.v1 = false;
                    if (this.f19738e.o != null) {
                        this.f19738e.o.X0(false);
                    }
                }
                this.f19738e.r1 = 0;
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
        public final /* synthetic */ VideoPbFragment f19739a;

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
            this.f19739a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.h(this.f19739a.f19684e, this.f19739a.f19684e.getUniqueId(), (View) customResponsedMessage.getData(), this.f19739a.f19686g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19740e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19741f;

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
            this.f19741f = videoPbFragment;
            this.f19740e = layoutParams;
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
                this.f19741f.Z4(this.f19740e);
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
        public final /* synthetic */ VideoPbFragment f19742e;

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
            this.f19742e = videoPbFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f19742e.r1 = 0;
                this.f19742e.s1 = 0.0f;
                this.f19742e.t1 = 0.0f;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f19742e.s1 += f2;
                this.f19742e.t1 += f3;
                if (this.f19742e.r1 == 0 && !this.f19742e.u1 && this.f19742e.o != null && !this.f19742e.o.C()) {
                    int height = this.f19742e.q.getHeight();
                    if (motionEvent.getY() < 0.0f || Math.abs(this.f19742e.t1) <= Math.abs(this.f19742e.s1) || this.f19742e.t1 > (-height) / 5) {
                        if (Math.abs(this.f19742e.t1) > Math.abs(this.f19742e.s1) && this.f19742e.t1 > 0.0f && f3 > 0.0f) {
                            this.f19742e.r1 = 2;
                        }
                    } else {
                        this.f19742e.r1 = 1;
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
        public final /* synthetic */ VideoPbFragment f19743a;

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
            this.f19743a = videoPbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.q(this.f19743a.f19684e, ItemCardHelper.OrderTipStatus.FAIL, this.f19743a.f19686g);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.q(this.f19743a.f19684e, ItemCardHelper.OrderTipStatus.SUCCESS, this.f19743a.f19686g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19745f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19746g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19747h;

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
            this.f19747h = videoPbFragment;
            this.f19744e = layoutParams;
            this.f19745f = layoutParams2;
            this.f19746g = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.X1);
                this.f19744e.height = floatValue;
                this.f19745f.height = (this.f19746g - VideoPbFragment.X1) + floatValue;
                this.f19747h.z.setLayoutParams(this.f19744e);
                this.f19747h.m.setLayoutParams(this.f19745f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19748e;

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
            this.f19748e = videoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19748e.v1 && !this.f19748e.K3()) {
                this.f19748e.O4();
                UtilHelper.hideStatusBar(this.f19748e.z(), this.f19748e.z().getRootView());
                this.f19748e.v1 = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n0 implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19749e;

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
            this.f19749e = videoPbFragment;
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
                    if (this.f19749e.Y2() != null) {
                        this.f19749e.Y2().n1(false);
                    } else if (this.f19749e.J3() && this.f19749e.n3() != null) {
                        this.f19749e.n3().j1(false);
                    }
                    if (this.f19749e.Z2() != null) {
                        this.f19749e.Z2().X0(true);
                        VideoPbFragment videoPbFragment = this.f19749e;
                        videoPbFragment.A4(videoPbFragment.Z2().P0() == 0 ? 8 : 0);
                        this.f19749e.n0.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.f19749e.getActivity()).get(VideoPbViewModel.class);
                    this.f19749e.o.W0((videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || !videoPbViewModel.e().getValue().booleanValue()) ? false : false);
                    this.f19749e.k4();
                    if (this.f19749e.y() != null && this.f19749e.y().D0() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.f19749e.y().T0()).param("fid", this.f19749e.y().D0().n()));
                    }
                } else {
                    if (this.f19749e.Z2() != null) {
                        this.f19749e.Z2().X0(false);
                    }
                    if (this.f19749e.Y2() != null) {
                        this.f19749e.Y2().n1(true);
                        int f1 = this.f19749e.Y2().f1();
                        int d1 = this.f19749e.Y2().d1();
                        if (f1 != 0) {
                            this.f19749e.A4(8);
                            this.f19749e.Y2().x1(0);
                        } else if (d1 != 0) {
                            this.f19749e.Y2().x1(8);
                            this.f19749e.A4(0);
                        } else {
                            this.f19749e.Y2().x1(8);
                            this.f19749e.A4(8);
                        }
                    } else if (this.f19749e.n3() != null) {
                        this.f19749e.n3().j1(true);
                        int d12 = this.f19749e.n3().d1();
                        int b1 = this.f19749e.n3().b1();
                        if (d12 != 0) {
                            this.f19749e.A4(8);
                            this.f19749e.n3().r1(0);
                        } else if (b1 != 0) {
                            this.f19749e.n3().r1(8);
                            this.f19749e.A4(0);
                        } else {
                            this.f19749e.n3().r1(8);
                            this.f19749e.A4(8);
                        }
                        this.f19749e.n0.setVisibility(0);
                    }
                    this.f19749e.o.W0(false);
                    this.f19749e.m.setExpanded(false, true);
                    if (this.f19749e.y() != null && this.f19749e.y().D0() != null) {
                        TiebaStatic.log(new StatisticItem("c13593").param("tid", this.f19749e.y().T0()).param("fid", this.f19749e.y().D0().n()));
                    }
                }
                this.f19749e.j.d(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n1 implements a.InterfaceC1192a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19750a;

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
            this.f19750a = videoPbFragment;
        }

        @Override // d.a.o0.h.a.InterfaceC1192a
        public void a(boolean z, boolean z2, String str) {
            d.a.o0.r.q.b2 N;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.f19750a.x4();
                if (z && this.f19750a.y() != null) {
                    if (this.f19750a.V != null) {
                        this.f19750a.V.h(z2);
                    }
                    this.f19750a.y().X1(z2);
                    if (this.f19750a.y().D0() != null && (N = this.f19750a.y().D0().N()) != null) {
                        if (z2) {
                            N.J2++;
                        } else {
                            int i2 = N.J2;
                            if (i2 > 0) {
                                N.J2 = i2 - 1;
                            }
                        }
                    }
                    if (this.f19750a.y().p0()) {
                        this.f19750a.R3();
                    } else if (this.f19750a.J3()) {
                        if (this.f19750a.Z2() != null) {
                            this.f19750a.Z2().S0();
                        }
                        if (this.f19750a.n3() != null) {
                            this.f19750a.n3().g1();
                        }
                    } else if (this.f19750a.Y2() != null) {
                        this.f19750a.Y2().j1();
                    }
                    if (z2) {
                        if (this.f19750a.V != null) {
                            if (this.f19750a.V.f() == null || this.f19750a.y() == null || this.f19750a.y().D0() == null || this.f19750a.y().D0().N() == null || this.f19750a.y().D0().N().H() == null) {
                                return;
                            }
                            MarkData f2 = this.f19750a.V.f();
                            MetaData H = this.f19750a.y().D0().N().H();
                            if (f2 != null && H != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), H.getUserId()) && !H.hadConcerned()) {
                                    this.f19750a.T.u0(H);
                                } else {
                                    this.f19750a.showToast(R.string.add_mark_on_pb);
                                }
                            } else {
                                VideoPbFragment videoPbFragment = this.f19750a;
                                videoPbFragment.showToast(videoPbFragment.getPageContext().getString(R.string.add_mark));
                            }
                        }
                        this.f19750a.A2();
                        return;
                    }
                    VideoPbFragment videoPbFragment2 = this.f19750a;
                    videoPbFragment2.showToast(videoPbFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                VideoPbFragment videoPbFragment3 = this.f19750a;
                videoPbFragment3.showToast(videoPbFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19751a;

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
            this.f19751a = videoPbFragment;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.f19751a.y() != null) {
                    switch (this.f19751a.Z.getLoadDataMode()) {
                        case 0:
                            this.f19751a.y().Z0();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.f19751a.R2(bVar, (bVar.f21183e != 1002 || bVar.f21184f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.f19751a.S2(1, dVar.f21186a, dVar.f21187b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            VideoPbFragment videoPbFragment = this.f19751a;
                            videoPbFragment.T2(videoPbFragment.Z.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            VideoPbFragment videoPbFragment2 = this.f19751a;
                            videoPbFragment2.S2(videoPbFragment2.Z.getLoadDataMode(), gVar.f21200a, gVar.f21201b, false);
                            this.f19751a.T.e0(gVar.f21202c);
                            return;
                        default:
                            return;
                    }
                }
                VideoPbFragment videoPbFragment3 = this.f19751a;
                videoPbFragment3.S2(videoPbFragment3.Z.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o0 extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.t.a f19752a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f19753b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19754c;

        public o0(VideoPbFragment videoPbFragment, d.a.o0.t.a aVar, int i2) {
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
            this.f19754c = videoPbFragment;
            this.f19752a = aVar;
            this.f19753b = i2;
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
                this.f19754c.M4(this.f19752a, bitmap, this.f19753b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19755e;

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
            this.f19755e = videoPbFragment;
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
                this.f19755e.z.setVisibility(8);
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
        public final /* synthetic */ VideoPbFragment f19756e;

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
            this.f19756e = videoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f19756e.R0.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class p0 implements c.InterfaceC1445c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Random f19757a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19758b;

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
            this.f19758b = videoPbFragment;
            this.f19757a = random;
        }

        @Override // d.a.p0.h2.p.c.InterfaceC1445c
        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f19757a.nextInt(2) * 0.1f) + 0.8f : invokeV.floatValue;
        }
    }

    /* loaded from: classes4.dex */
    public class p1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19759e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19760f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19761g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19762h;

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
            this.f19762h = videoPbFragment;
            this.f19759e = layoutParams;
            this.f19760f = layoutParams2;
            this.f19761g = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.X1);
                this.f19759e.height = floatValue;
                this.f19760f.height = this.f19761g + floatValue;
                this.f19762h.z.setLayoutParams(this.f19759e);
                this.f19762h.m.setLayoutParams(this.f19760f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class q implements b.InterfaceC1456b {
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

        @Override // d.a.p0.i0.b.InterfaceC1456b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    d.a.p0.h2.i.b.d();
                } else {
                    d.a.p0.h2.i.b.c();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.t.a f19763e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19764f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19765g;

        public q0(VideoPbFragment videoPbFragment, d.a.o0.t.a aVar, int i2) {
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
            this.f19765g = videoPbFragment;
            this.f19763e = aVar;
            this.f19764f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<BaseFragmentActivity> pageContext = this.f19765g.getPageContext();
                urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + d.a.c.e.p.k.getUrlEncode(this.f19763e.d())});
                TiebaStatic.log(new StatisticItem("c14126").param("obj_type", this.f19764f).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19766e;

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
            this.f19766e = videoPbFragment;
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
                this.f19766e.X4();
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
        public final /* synthetic */ VideoPbFragment f19767e;

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
            this.f19767e = videoPbFragment;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
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
        public final /* synthetic */ VideoPbFragment f19768e;

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
            this.f19768e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19768e.a1.k();
                this.f19768e.w3();
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
        public final /* synthetic */ VideoPbFragment f19769e;

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
            this.f19769e = videoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f19769e.z.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19770a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f19771e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ s f19772f;

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
                this.f19772f = sVar;
                this.f19771e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19771e == null) {
                    return;
                }
                this.f19772f.f19770a.R4();
                this.f19772f.f19770a.Z3(this.f19771e.getmAdverSegmentData(), 2);
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

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
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
            public final /* synthetic */ s f19773e;

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
                this.f19773e = sVar;
            }

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f19773e.f19770a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f19773e.f19770a.getActivity(), 0, 26, 2)));
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
            this.f19770a = videoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.o0.s.c.i0 i0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) {
                if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f19770a.y() != null && this.f19770a.y().D0() != null) {
                        statisticItem.param("fid", this.f19770a.y().D0().n());
                    }
                    if (this.f19770a.y() != null) {
                        statisticItem.param("tid", this.f19770a.y().T0());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    d.a.p0.h2.k.e.v0 v0Var = this.f19770a.K0;
                    if (v0Var != null) {
                        v0Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        d.a.o0.s.h.b.a(this.f19770a.getPageContext(), postWriteCallBackData);
                    }
                    if (postWriteCallBackData.getmAdverSegmentData() != null) {
                        d.a.c.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                        return;
                    }
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f19770a.H0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.f19770a.getActivity(), this.f19770a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.f19770a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f19770a.getActivity());
                    if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f19770a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new b(this));
                    aVar.setPositiveButton(R.string.open_now, new c(this));
                    aVar.create(this.f19770a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                VideoPbFragment videoPbFragment = this.f19770a;
                if (videoPbFragment.K0 == null) {
                    return;
                }
                if (videoPbFragment.P0 != null && this.f19770a.P0.b() != null && this.f19770a.P0.b().v()) {
                    this.f19770a.P0.b().t(postWriteCallBackData);
                }
                this.f19770a.K0.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19774e;

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
            this.f19774e = videoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19774e.Q == null) {
                return;
            }
            d.a.p0.h2.p.d.b(this.f19774e.Q);
        }
    }

    /* loaded from: classes4.dex */
    public class s1 implements d.a.c.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19775a;

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
            this.f19775a = videoPbFragment;
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
                    if (d.a.o0.r.k.c().g()) {
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
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f19775a.getPageContext().getPageActivity());
                boolean g2 = d.a.o0.r.k.c().g();
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
        public final /* synthetic */ MarkData f19776e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f19777f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f19778g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19779h;

        public t(VideoPbFragment videoPbFragment, MarkData markData, MarkData markData2, d.a.o0.r.s.a aVar) {
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
            this.f19779h = videoPbFragment;
            this.f19776e = markData;
            this.f19777f = markData2;
            this.f19778g = aVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f19779h.V != null) {
                    if (this.f19779h.V.e()) {
                        this.f19779h.V.d();
                        this.f19779h.V.h(false);
                    }
                    this.f19779h.V.i(this.f19776e);
                    this.f19779h.V.h(true);
                    this.f19779h.V.a();
                }
                this.f19777f.setPostId(this.f19776e.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f19777f);
                this.f19779h.f19684e.setResult(-1, intent);
                this.f19778g.dismiss();
                this.f19779h.T4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19780e;

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
            this.f19780e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19780e.A == null || this.f19780e.A.o()) {
                    if (this.f19780e.A != null) {
                        TiebaStatic.log(new StatisticItem("c13608").param("tid", this.f19780e.y().D0().P()));
                        this.f19780e.A.p = true;
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13591"));
                }
                this.f19780e.L4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t1 implements d.a.c.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19781a;

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
            this.f19781a = videoPbFragment;
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
                if (d.a.o0.r.k.c().g()) {
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
                GifView gifView = new GifView(this.f19781a.getPageContext().getPageActivity());
                boolean g2 = d.a.o0.r.k.c().g();
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

    /* loaded from: classes4.dex */
    public class u implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19782e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f19783f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19784g;

        public u(VideoPbFragment videoPbFragment, MarkData markData, d.a.o0.r.s.a aVar) {
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
            this.f19784g = videoPbFragment;
            this.f19782e = markData;
            this.f19783f = aVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.f19782e);
                this.f19784g.f19684e.setResult(-1, intent);
                this.f19783f.dismiss();
                this.f19784g.T4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19785e;

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
            this.f19785e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new d.a.o0.r.q.s0(this.f19785e.getActivity(), "pb_huitie"))) {
                this.f19785e.Q2(false);
                this.f19785e.c4();
                if (this.f19785e.y() == null || this.f19785e.y().D0() == null || this.f19785e.y().D0().N() == null || this.f19785e.y().D0().N().H() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f19785e.y().U0()).param("fid", this.f19785e.y().D0().n()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19785e.y().T0()).param("fid", this.f19785e.y().D0().n()).param("obj_locate", 1).param("uid", this.f19785e.y().D0().N().H().getUserId()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u1 implements d.a.c.e.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19786a;

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
            this.f19786a = videoPbFragment;
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
                ((PlayVoiceBntNew) view).l();
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
                ((PlayVoiceBntNew) view).k();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.f19786a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.f19786a.getVoiceManager());
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
        public final /* synthetic */ VideoPbFragment f19787a;

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
            this.f19787a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921552) {
                this.f19787a.w3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19788a;

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
            this.f19788a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f19788a.n0.getLayoutParams();
            layoutParams.height = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
            this.f19788a.n0.setLayoutParams(layoutParams);
            if (this.f19788a.J3() && this.f19788a.f19687h != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f19788a.f19687h.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = VideoPbFragment.Y1;
                } else {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, VideoPbFragment.Y1);
                }
                this.f19788a.f19687h.setLayoutParams(layoutParams2);
                this.f19788a.f19688i.setScrollable(true);
            }
            this.f19788a.k4();
            if (this.f19788a.Z2() != null) {
                this.f19788a.Z2().S0();
            }
            if (this.f19788a.Y2() != null) {
                this.f19788a.Y2().j1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v1 implements d.a.c.e.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19789a;

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
            this.f19789a = videoPbFragment;
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
                LinearLayout linearLayout = new LinearLayout(this.f19789a.getPageContext().getPageActivity());
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
        public final /* synthetic */ VideoPbFragment f19790e;

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
            this.f19790e = videoPbFragment;
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
        public final /* synthetic */ VideoPbFragment f19791e;

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
            this.f19791e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19791e.u3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w1 implements d.a.c.e.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19792a;

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
            this.f19792a = videoPbFragment;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.f19792a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class x implements d.a.o0.w.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19793a;

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
            this.f19793a = videoPbFragment;
        }

        @Override // d.a.o0.w.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19793a.showProgressBar();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19794e;

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
            this.f19794e = videoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19794e.k4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x1 implements Comparator<d.a.o0.t.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19795e;

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
            this.f19795e = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.a.o0.t.a aVar, d.a.o0.t.a aVar2) {
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
        public final /* synthetic */ VideoPbFragment f19796e;

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
            this.f19796e = videoPbFragment;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.f19796e.isAdded()) {
                int i6 = 1;
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.f19796e.y().T0());
                    statisticItem2.param("fid", this.f19796e.y().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    if (this.f19796e.m0) {
                        this.f19796e.m0 = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (this.f19796e.y() == null || this.f19796e.y().D0() == null || this.f19796e.Q0 == null || postData.t() == null || postData.A() == 1 || !this.f19796e.checkUpIsLogin()) {
                                return;
                            }
                            if (this.f19796e.P0 != null) {
                                this.f19796e.P0.c();
                            }
                            d.a.p0.h2.h.r rVar = new d.a.p0.h2.h.r();
                            rVar.A(this.f19796e.y().D0().m());
                            rVar.E(this.f19796e.y().D0().N());
                            rVar.C(postData);
                            this.f19796e.Q0.I(rVar);
                            this.f19796e.Q0.setPostId(postData.E());
                            this.f19796e.Q3(view, postData.t().getUserId(), "", postData);
                            TiebaStatic.log("c11743");
                            d.a.p0.h2.m.a.b(this.f19796e.y().D0(), postData, postData.i0, 8, 1);
                            if (this.f19796e.N0 != null) {
                                VideoPbFragment videoPbFragment = this.f19796e;
                                videoPbFragment.s4(videoPbFragment.N0.C());
                            }
                        }
                    }
                } else if ((this.f19796e.J3() && this.f19796e.n3() != null && this.f19796e.n3().c1() != null && view == this.f19796e.n3().c1()) || ((this.f19796e.Y2() != null && this.f19796e.Y2().e1() != null && view == this.f19796e.Y2().e1()) || view.getId() == R.id.pb_more)) {
                    if (!this.f19796e.R && this.f19796e.y().l1(true)) {
                        this.f19796e.R = true;
                        if (this.f19796e.J3()) {
                            if (this.f19796e.n3() != null) {
                                this.f19796e.n3().q1();
                            }
                        } else if (this.f19796e.Y2() != null) {
                            this.f19796e.Y2().w1();
                        }
                    }
                } else {
                    d.a.p0.h2.o.g.a aVar = this.f19796e.T;
                    if (aVar != null && aVar.Q() != null && view == this.f19796e.T.Q().e()) {
                        this.f19796e.T.I();
                        return;
                    }
                    d.a.p0.h2.o.g.a aVar2 = this.f19796e.T;
                    if ((aVar2 == null || ((aVar2.Q() == null || view != this.f19796e.T.Q().h()) && view.getId() != R.id.owner_reply && view.getId() != R.id.all_reply)) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                        VideoPbFragment videoPbFragment2 = this.f19796e;
                        if (view == videoPbFragment2.t) {
                            if (videoPbFragment2.y() == null || this.f19796e.y().D0() == null) {
                                return;
                            }
                            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                StatisticItem statisticItem3 = new StatisticItem("c13266");
                                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem3.param("fid", this.f19796e.y().D0().n());
                                statisticItem3.param("tid", this.f19796e.y().T0());
                                statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(statisticItem3);
                                TbadkCoreApplication.getInst().setTaskId("");
                            }
                            d.a.c.e.p.l.x(this.f19796e.f19684e, this.f19796e.t);
                            this.f19796e.f19684e.finish();
                        } else if (view == videoPbFragment2.v && videoPbFragment2.T != null) {
                            if (d.a.o0.z0.l.a()) {
                                return;
                            }
                            if (this.f19796e.y() != null && this.f19796e.y().D0() != null) {
                                ArrayList<PostData> E = this.f19796e.y().D0().E();
                                if ((E == null || E.size() <= 0) && this.f19796e.y().R0()) {
                                    d.a.c.e.p.l.M(this.f19796e.getPageContext().getPageActivity(), this.f19796e.getPageContext().getString(R.string.pb_no_data_tips));
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.f19796e.y().T0()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f19796e.y().getForumId()));
                                this.f19796e.T.k0();
                                return;
                            }
                            d.a.c.e.p.l.M(this.f19796e.getPageContext().getPageActivity(), this.f19796e.getPageContext().getString(R.string.pb_no_data_tips));
                        } else if (this.f19796e.T.Q() != null && view == this.f19796e.T.Q().k()) {
                            if (this.f19796e.y() == null) {
                                return;
                            }
                            this.f19796e.T.F();
                            if (d.a.c.e.p.j.z()) {
                                this.f19796e.S4();
                                this.f19796e.y4();
                                this.f19796e.y().V1(1);
                                return;
                            }
                            this.f19796e.showToast(R.string.network_not_available);
                        } else {
                            d.a.p0.h2.o.g.a aVar3 = this.f19796e.T;
                            if (aVar3 != null && aVar3.Q() != null && view == this.f19796e.T.Q().h()) {
                                this.f19796e.T.I();
                                return;
                            }
                            d.a.p0.h2.o.g.a aVar4 = this.f19796e.T;
                            if (aVar4 != null && ((aVar4.Q() != null && view == this.f19796e.T.Q().q()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                                this.f19796e.T.F();
                                if (d.a.c.e.p.j.z()) {
                                    if (!this.f19796e.R) {
                                        this.f19796e.S4();
                                        this.f19796e.y4();
                                        this.f19796e.T.D0(view);
                                        return;
                                    }
                                    view.setTag(Integer.valueOf(this.f19796e.y().P0()));
                                    return;
                                }
                                this.f19796e.showToast(R.string.network_not_available);
                                return;
                            }
                            d.a.p0.h2.o.g.a aVar5 = this.f19796e.T;
                            if (aVar5 != null && aVar5.Q() != null && view == this.f19796e.T.Q().p()) {
                                if (this.f19796e.y() == null || this.f19796e.y().D0() == null || this.f19796e.y().D0().N() == null) {
                                    return;
                                }
                                this.f19796e.T.I();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                VideoPbFragment videoPbFragment3 = this.f19796e;
                                videoPbFragment3.T.U(videoPbFragment3.y().D0().N().T());
                            } else if (view.getId() == R.id.pb_floor_feedback) {
                                try {
                                    sparseArray = (SparseArray) view.getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray = null;
                                }
                                d.a.p0.h2.o.g.a aVar6 = this.f19796e.T;
                                if (aVar6 != null) {
                                    aVar6.r0(sparseArray);
                                }
                            } else {
                                d.a.p0.h2.o.g.a aVar7 = this.f19796e.T;
                                if (aVar7 != null && aVar7.Q() != null && view == this.f19796e.T.Q().n()) {
                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                    if (skinType == 1) {
                                        this.f19796e.onChangeSkinType(skinType);
                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                    } else if (skinType == 0 || skinType == 4) {
                                        UtilHelper.showSkinChangeAnimation(this.f19796e.getActivity());
                                        this.f19796e.onChangeSkinType(skinType);
                                        UtilHelper.setNavigationBarBackground(this.f19796e.getActivity(), this.f19796e.getResources().getColor(R.color.CAM_X0201_1));
                                        TbadkCoreApplication.getInst().setSkinType(1);
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                    }
                                    this.f19796e.T.J();
                                    return;
                                }
                                d.a.p0.h2.o.g.a aVar8 = this.f19796e.T;
                                if (aVar8 != null && aVar8.Q() != null && view == this.f19796e.T.Q().o()) {
                                    this.f19796e.T.J();
                                    VideoPbFragment videoPbFragment4 = this.f19796e;
                                    videoPbFragment4.T.A0(videoPbFragment4.I1);
                                    return;
                                }
                                d.a.p0.h2.o.g.a aVar9 = this.f19796e.T;
                                if (aVar9 != null && (view == aVar9.M() || (this.f19796e.T.Q() != null && (view == this.f19796e.T.Q().l() || view == this.f19796e.T.Q().m())))) {
                                    if (!d.a.c.e.p.j.z()) {
                                        this.f19796e.showToast(R.string.network_not_available);
                                        return;
                                    } else if ((this.f19796e.y() == null && this.f19796e.y().D0() == null) || this.f19796e.Z.O()) {
                                        return;
                                    } else {
                                        this.f19796e.T.F();
                                        if (this.f19796e.T.Q() != null && view == this.f19796e.T.Q().m()) {
                                            i4 = this.f19796e.y().D0().N().m0() == 1 ? 5 : 4;
                                        } else if (this.f19796e.T.Q() != null && view == this.f19796e.T.Q().l()) {
                                            i4 = this.f19796e.y().D0().N().l0() == 1 ? 3 : 6;
                                        } else {
                                            i4 = view == this.f19796e.T.M() ? 2 : 0;
                                        }
                                        ForumData m = this.f19796e.y().D0().m();
                                        String name = m.getName();
                                        String id = m.getId();
                                        String c0 = this.f19796e.y().D0().N().c0();
                                        this.f19796e.showProgressBar();
                                        this.f19796e.Z.S(id, name, c0, i4, this.f19796e.T.N());
                                        return;
                                    }
                                }
                                d.a.p0.h2.o.g.a aVar10 = this.f19796e.T;
                                if (aVar10 != null && aVar10.Q() != null && view == this.f19796e.T.Q().g()) {
                                    if (this.f19796e.y() == null) {
                                        return;
                                    }
                                    if (!d.a.c.e.p.j.z()) {
                                        this.f19796e.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    this.f19796e.T.F();
                                    VideoPbFragment videoPbFragment5 = this.f19796e;
                                    SparseArray<Object> f3 = videoPbFragment5.f3(videoPbFragment5.y().D0(), this.f19796e.y().R0(), 1);
                                    if (f3 == null) {
                                        return;
                                    }
                                    this.f19796e.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f19796e.getPageContext().getPageActivity(), this.f19796e.y().D0().m().getId(), this.f19796e.y().D0().m().getName(), this.f19796e.y().D0().N().c0(), String.valueOf(this.f19796e.y().D0().T().getUserId()), (String) f3.get(R.id.tag_forbid_user_name), (String) f3.get(R.id.tag_forbid_user_name_show), (String) f3.get(R.id.tag_forbid_user_post_id), (String) f3.get(R.id.tag_forbid_user_portrait))));
                                    return;
                                }
                                d.a.p0.h2.o.g.a aVar11 = this.f19796e.T;
                                if (aVar11 != null && aVar11.Q() != null && view == this.f19796e.T.Q().f()) {
                                    if (this.f19796e.y() == null) {
                                        return;
                                    }
                                    if (!d.a.c.e.p.j.z()) {
                                        this.f19796e.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    VideoPbFragment videoPbFragment6 = this.f19796e;
                                    SparseArray<Object> f32 = videoPbFragment6.f3(videoPbFragment6.y().D0(), this.f19796e.y().R0(), 1);
                                    if (f32 != null) {
                                        if (StringUtils.isNull((String) f32.get(R.id.tag_del_multi_forum))) {
                                            this.f19796e.T.f0(((Integer) f32.get(R.id.tag_del_post_type)).intValue(), (String) f32.get(R.id.tag_del_post_id), ((Integer) f32.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) f32.get(R.id.tag_del_post_is_self)).booleanValue());
                                        } else {
                                            this.f19796e.T.g0(((Integer) f32.get(R.id.tag_del_post_type)).intValue(), (String) f32.get(R.id.tag_del_post_id), ((Integer) f32.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) f32.get(R.id.tag_del_post_is_self)).booleanValue(), (String) f32.get(R.id.tag_del_multi_forum));
                                        }
                                    }
                                    this.f19796e.T.I();
                                } else if (view.getId() != R.id.sub_pb_more && view.getId() != R.id.sub_pb_item && view.getId() != R.id.pb_floor_reply_more && view.getId() != R.id.new_sub_pb_list_richText && view.getId() != R.id.pb_post_reply_count) {
                                    if (view.getId() != R.id.pb_post_reply && view.getId() != R.id.post_info_commont_img && view.getId() != R.id.pb_floor_comment_container) {
                                        if (view.getId() != R.id.pb_editor_tool_collection && view.getId() != R.id.collect_num_container) {
                                            if (view.getId() == R.id.pb_editor_tool_share) {
                                                this.f19796e.q3(true);
                                            } else if (view.getId() != R.id.pb_editor_tool_comment_icon && view.getId() != R.id.thread_info_commont_container) {
                                                if (view.getId() == R.id.tv_pb_reply_more) {
                                                    if (this.f19796e.W0 >= 0) {
                                                        if (this.f19796e.y() != null) {
                                                            this.f19796e.y().H1();
                                                        }
                                                        if (this.f19796e.J3() && this.f19796e.y() != null && this.f19796e.n3() != null && this.f19796e.n3().H0() != null) {
                                                            this.f19796e.n3().H0().f(this.f19796e.y().D0());
                                                        } else if (this.f19796e.Y2() != null && this.f19796e.Y2().H0() != null) {
                                                            this.f19796e.Y2().H0().v(this.f19796e.y().D0());
                                                        }
                                                        this.f19796e.W0 = 0;
                                                        this.f19796e.X0 = Integer.MIN_VALUE;
                                                        if (this.f19796e.J3() && this.f19796e.y() != null && this.f19796e.n3() != null) {
                                                            this.f19796e.n3().m1(this.f19796e.y().w0(), this.f19796e.y().v0());
                                                            this.f19796e.y().L1(0, 0);
                                                        } else if (this.f19796e.y() == null || this.f19796e.Y2() == null) {
                                                        } else {
                                                            this.f19796e.Y2().r1(this.f19796e.y().w0(), this.f19796e.y().v0());
                                                            this.f19796e.y().L1(0, 0);
                                                        }
                                                    }
                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                    if (this.f19796e.y() == null) {
                                                        return;
                                                    }
                                                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                                                    statisticItem4.param("tid", this.f19796e.y().T0());
                                                    statisticItem4.param("fid", this.f19796e.y().getForumId());
                                                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem4.param("obj_locate", 2);
                                                    TiebaStatic.log(statisticItem4);
                                                } else if (view.getId() == R.id.pb_item_tail_content) {
                                                    if (ViewHelper.checkUpIsLogin(this.f19796e.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                        String p = d.a.o0.r.d0.b.j().p("tail_link", "");
                                                        if (!StringUtils.isNull(p)) {
                                                            TiebaStatic.log("c10056");
                                                            d.a.o0.l.a.o(view.getContext(), string, p, true, true, true);
                                                        }
                                                        this.f19796e.k4();
                                                    }
                                                } else if (view.getId() == R.id.keyboard_background_shadow) {
                                                    this.f19796e.k4();
                                                } else if (this.f19796e.T.Q() != null && view == this.f19796e.T.Q().d()) {
                                                    this.f19796e.T.F();
                                                    if (this.f19796e.y() != null) {
                                                        this.f19796e.x.f(this.f19796e.y().T0());
                                                    }
                                                    if (this.f19796e.y() == null || !this.f19796e.y().isPrivacy()) {
                                                        this.f19796e.x.b();
                                                        if (!TbSingleton.getInstance().mCanCallFans && this.f19796e.y() != null && this.f19796e.y().D0() != null && this.f19796e.y().D0().P() != null && this.f19796e.y().D0().P().equals(TbSingleton.getInstance().mCallFansTid)) {
                                                            i6 = 2;
                                                        }
                                                        if (this.f19796e.y() == null || this.f19796e.y().D0() == null) {
                                                            return;
                                                        }
                                                        this.f19796e.x.d(3, i6, this.f19796e.y().D0().P());
                                                        return;
                                                    }
                                                    this.f19796e.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                    if (this.f19796e.y().D0() != null) {
                                                        this.f19796e.x.d(3, 3, this.f19796e.y().D0().P());
                                                    }
                                                } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                                                    StatisticItem statisticItem5 = new StatisticItem("c13398");
                                                    statisticItem5.param("tid", this.f19796e.y().T0());
                                                    statisticItem5.param("fid", this.f19796e.y().getForumId());
                                                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem5.param("obj_locate", 7);
                                                    TiebaStatic.log(statisticItem5);
                                                    this.f19796e.T.m0(false);
                                                    this.f19796e.T.P().onLongClick(view);
                                                }
                                            } else if (this.f19796e.y() != null) {
                                                VideoPbFragment videoPbFragment7 = this.f19796e;
                                                if (videoPbFragment7.T == null || videoPbFragment7.f19688i == null || this.f19796e.y().D0() == null || this.f19796e.y().D0().N() == null || !this.f19796e.checkUpIsLogin()) {
                                                    return;
                                                }
                                                d.a.p0.h2.h.e D0 = this.f19796e.y().D0();
                                                int P0 = D0.N().P0();
                                                int currentItem = this.f19796e.f19688i.getCurrentItem();
                                                if (P0 == 0) {
                                                    if (this.f19796e.J3() && currentItem == VideoPbFragment.Q1) {
                                                        this.f19796e.f19688i.setCurrentItem(VideoPbFragment.R1);
                                                    }
                                                    this.f19796e.Q2(false);
                                                    this.f19796e.c4();
                                                    return;
                                                }
                                                if (this.f19796e.J3() && currentItem == VideoPbFragment.Q1) {
                                                    this.f19796e.f19688i.setCurrentItem(VideoPbFragment.R1);
                                                } else if ((this.f19796e.J3() && this.f19796e.n3() == null) || this.f19796e.Y2() == null || this.f19796e.m3() == null) {
                                                    return;
                                                } else {
                                                    StatisticItem param = new StatisticItem("c13403").param("tid", this.f19796e.y().T0()).param("fid", this.f19796e.y().D0().n()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    int i7 = (int) (d.a.c.e.p.l.i(this.f19796e.getContext()) * 0.6d);
                                                    BdTypeRecyclerView m3 = this.f19796e.m3();
                                                    if (m3 == null) {
                                                        return;
                                                    }
                                                    boolean canScrollVertically = m3.canScrollVertically(1);
                                                    boolean canScrollVertically2 = m3.canScrollVertically(-1);
                                                    if (this.f19796e.m != null) {
                                                        this.f19796e.m.setExpanded(false, true);
                                                    }
                                                    if (m3.getLayoutManager() == null || !(m3.getLayoutManager() instanceof LinearLayoutManager)) {
                                                        return;
                                                    }
                                                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) m3.getLayoutManager();
                                                    if (!canScrollVertically2 && canScrollVertically) {
                                                        if (this.f19796e.U0 == -1 && this.f19796e.V0 == Integer.MIN_VALUE) {
                                                            return;
                                                        }
                                                        if (this.f19796e.U0 > 3 || (this.f19796e.U0 == 3 && this.f19796e.V0 < (-i7))) {
                                                            linearLayoutManager.scrollToPositionWithOffset(this.f19796e.U0, this.f19796e.V0 + i7);
                                                            m3.smoothScrollBy(0, i7);
                                                        } else if (this.f19796e.U0 >= 2) {
                                                            int i8 = i7 / 2;
                                                            linearLayoutManager.scrollToPositionWithOffset(this.f19796e.U0, this.f19796e.V0 + i8);
                                                            m3.smoothScrollBy(0, i8);
                                                        } else if (this.f19796e.U0 == 1) {
                                                            int i9 = i7 / 4;
                                                            linearLayoutManager.scrollToPositionWithOffset(this.f19796e.U0, this.f19796e.V0 + i9);
                                                            m3.smoothScrollBy(0, i9);
                                                        } else {
                                                            m3.smoothScrollBy(0, -this.f19796e.V0);
                                                        }
                                                        param.param("obj_locate", 2);
                                                        i3 = 1;
                                                    } else {
                                                        int firstVisiblePosition = m3.getFirstVisiblePosition();
                                                        View childAt = m3.getChildAt(0);
                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                        this.f19796e.U0 = firstVisiblePosition;
                                                        this.f19796e.V0 = top;
                                                        if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-i7) || m3.getCount() < 6)) {
                                                            m3.smoothScrollToPosition(0);
                                                        } else {
                                                            linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                            m3.smoothScrollToPosition(0);
                                                        }
                                                        i3 = 1;
                                                        param.param("obj_locate", 1);
                                                    }
                                                    TiebaStatic.log(param);
                                                    d.a.o0.i0.c f2 = TbPageExtraHelper.f(view);
                                                    StatisticItem statisticItem6 = new StatisticItem("c12942");
                                                    statisticItem6.param("obj_type", i3);
                                                    statisticItem6.param("obj_locate", 4);
                                                    statisticItem6.param("tid", this.f19796e.y().T0());
                                                    statisticItem6.param("nid", D0.N().A0());
                                                    if (f2 != null) {
                                                        statisticItem6.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                                                    }
                                                    if (TbPageExtraHelper.m() != null) {
                                                        statisticItem6.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                                                    }
                                                    TiebaStatic.log(statisticItem6);
                                                }
                                                if (this.f19796e.y() == null || this.f19796e.y().D0() == null || this.f19796e.y().D0().N() == null || this.f19796e.y().D0().N().H() == null) {
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19796e.y().T0()).param("fid", this.f19796e.y().D0().n()).param("obj_locate", 2).param("uid", this.f19796e.y().D0().N().H().getUserId()));
                                            }
                                        } else if (!d.a.c.e.p.j.z()) {
                                            this.f19796e.showToast(R.string.network_not_available);
                                        } else {
                                            VideoPbFragment videoPbFragment8 = this.f19796e;
                                            if (videoPbFragment8.T == null || videoPbFragment8.y() == null) {
                                                return;
                                            }
                                            if (this.f19796e.J3() && this.f19796e.n3() == null) {
                                                return;
                                            }
                                            if (this.f19796e.J3() || this.f19796e.Y2() != null) {
                                                this.f19796e.T.F();
                                                if (view.getId() != R.id.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new d.a.o0.r.q.s0(this.f19796e.getActivity(), "pb_shoucang"))) {
                                                    if (!this.f19796e.H2(11009) || this.f19796e.y() == null) {
                                                        return;
                                                    }
                                                    this.f19796e.S3();
                                                    if (this.f19796e.y().D0() != null && this.f19796e.y().D0().N() != null && this.f19796e.y().D0().N().H() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19796e.y().T0()).param("fid", this.f19796e.y().D0().n()).param("obj_locate", 3).param("uid", this.f19796e.y().D0().N().H().getUserId()));
                                                    }
                                                    if (this.f19796e.y().D0().N() == null || this.f19796e.y().D0().N().H() == null || this.f19796e.y().D0().N().H().getUserId() == null || this.f19796e.V == null) {
                                                        return;
                                                    }
                                                    VideoPbFragment videoPbFragment9 = this.f19796e;
                                                    int S = videoPbFragment9.T.S(videoPbFragment9.y().D0());
                                                    d.a.o0.r.q.b2 N = this.f19796e.y().D0().N();
                                                    if (N.E1()) {
                                                        i2 = 2;
                                                    } else if (N.H1()) {
                                                        i2 = 3;
                                                    } else if (N.F1()) {
                                                        i2 = 4;
                                                    } else {
                                                        i2 = N.G1() ? 5 : 1;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f19796e.y().T0()).param("obj_locate", 1).param("obj_id", this.f19796e.y().D0().N().H().getUserId()).param("obj_type", !this.f19796e.V.e()).param("obj_source", S).param("obj_param1", i2));
                                                    return;
                                                }
                                                this.f19796e.D = view;
                                            }
                                        }
                                    } else if (this.f19796e.y() == null) {
                                    } else {
                                        if (view.getId() == R.id.pb_post_reply) {
                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                            statisticItem7.param("tid", this.f19796e.y().T0());
                                            statisticItem7.param("fid", this.f19796e.y().getForumId());
                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem7.param("obj_locate", 6);
                                            TiebaStatic.log(statisticItem7);
                                        }
                                        if (view.getId() == R.id.post_info_commont_img) {
                                            if (!DialogLoginHelper.checkUpIsLogin(new d.a.o0.r.q.s0(this.f19796e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                this.f19796e.C = view;
                                                return;
                                            }
                                        } else if (view.getId() == R.id.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new d.a.o0.r.q.s0(this.f19796e.getActivity(), "pb_huifu_louzhonglou"))) {
                                            this.f19796e.C = view;
                                            return;
                                        }
                                        if (this.f19796e.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                if (view.getId() == R.id.pb_post_reply && (statisticItem = postData2.j0) != null) {
                                                    StatisticItem copy = statisticItem.copy();
                                                    copy.delete("obj_locate");
                                                    copy.param("obj_locate", 8);
                                                    TiebaStatic.log(copy);
                                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f19796e.y().U0()).param("fid", this.f19796e.y().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.E()).param("obj_source", 1).param("obj_type", 3));
                                                }
                                                if (this.f19796e.y() == null || this.f19796e.y().D0() == null || this.f19796e.Q0 == null || postData2.t() == null || postData2.A() == 1) {
                                                    return;
                                                }
                                                if (this.f19796e.P0 != null) {
                                                    this.f19796e.P0.c();
                                                }
                                                if (this.f19796e.Z0 && postData2.M() != null && postData2.M().size() != 0) {
                                                    this.f19796e.Q4(postData2, null, true, false);
                                                    return;
                                                }
                                                d.a.p0.h2.h.r rVar2 = new d.a.p0.h2.h.r();
                                                rVar2.A(this.f19796e.y().D0().m());
                                                rVar2.E(this.f19796e.y().D0().N());
                                                rVar2.C(postData2);
                                                this.f19796e.Q0.I(rVar2);
                                                this.f19796e.Q0.setPostId(postData2.E());
                                                this.f19796e.Q3(view, postData2.t().getUserId(), "", postData2);
                                                if (this.f19796e.N0 != null) {
                                                    VideoPbFragment videoPbFragment10 = this.f19796e;
                                                    videoPbFragment10.s4(videoPbFragment10.N0.C());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                        StatisticItem statisticItem8 = new StatisticItem("c13398");
                                        statisticItem8.param("tid", this.f19796e.y().T0());
                                        statisticItem8.param("fid", this.f19796e.y().getForumId());
                                        statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem8.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem8);
                                    }
                                    if ((view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.pb_post_reply_count) && !DialogLoginHelper.checkUpIsLogin(new d.a.o0.r.q.s0(this.f19796e.getActivity(), "pb_chakanhuifu"))) {
                                        this.f19796e.B = view;
                                    } else if (!this.f19796e.checkUpIsLogin()) {
                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.f19796e.y().D0().n()));
                                    } else if (this.f19796e.y() == null || this.f19796e.y().D0() == null) {
                                    } else {
                                        d.a.p0.h2.o.g.a aVar12 = this.f19796e.T;
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
                                        this.f19796e.S4();
                                        TiebaStatic.log("c11742");
                                        if (postData4 != null) {
                                            this.f19796e.Q4(postData3, postData4, false, true);
                                        } else {
                                            this.f19796e.Q4(postData3, null, false, false);
                                        }
                                    }
                                }
                            }
                        }
                    } else if (!d.a.c.e.p.j.z()) {
                        this.f19796e.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                    } else {
                        this.f19796e.T.F();
                        if (!this.f19796e.R) {
                            this.f19796e.S4();
                            this.f19796e.y4();
                            if (view.getId() == R.id.owner_reply) {
                                a2 = this.f19796e.y().a2(true, this.f19796e.b3());
                            } else {
                                a2 = view.getId() == R.id.all_reply ? this.f19796e.y().a2(false, this.f19796e.b3()) : this.f19796e.y().Z1(this.f19796e.b3());
                            }
                            view.setTag(Boolean.valueOf(a2));
                            if (a2) {
                                this.f19796e.I4();
                                i5 = 1;
                                this.f19796e.R = true;
                            } else {
                                i5 = 1;
                            }
                            TiebaStatic.eventStat(this.f19796e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i5, new Object[0]);
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
        public final /* synthetic */ VideoPbFragment f19797a;

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
            this.f19797a = videoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f19797a.Q0.E(postData);
                if (this.f19797a.Y2() != null) {
                    this.f19797a.Y2().j1();
                } else if (this.f19797a.J3() && this.f19797a.n3() != null) {
                    this.f19797a.n3().g1();
                }
                this.f19797a.P0.c();
                this.f19797a.O0.q();
                this.f19797a.F4(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y1 implements d.a.o0.w.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19798a;

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
            this.f19798a = videoPbFragment;
        }

        @Override // d.a.o0.w.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.p0.h2.k.e.v0 v0Var = this.f19798a.K0;
                if (v0Var == null || v0Var.e() == null || !this.f19798a.K0.e().d()) {
                    return !this.f19798a.J2(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                VideoPbFragment videoPbFragment = this.f19798a;
                videoPbFragment.showToast(videoPbFragment.K0.e().c());
                if (this.f19798a.N0 != null && (this.f19798a.N0.B() || this.f19798a.N0.D())) {
                    this.f19798a.N0.z(false, this.f19798a.K0.h());
                }
                this.f19798a.K0.a(true);
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
        public final /* synthetic */ VideoPbFragment f19799e;

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
            this.f19799e = videoPbFragment;
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
            d.a.p0.h2.o.g.a aVar = this.f19799e.T;
            if (aVar != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 1);
                        this.f19799e.T.B(sparseArray);
                        return;
                    }
                    aVar.j0(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    sparseArray.put(R.id.tag_check_mute_from, 1);
                    this.f19799e.T.B(sparseArray);
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
        public final /* synthetic */ VideoPbFragment f19800e;

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
            this.f19800e = videoPbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f19800e.T.m0(true);
                return this.f19800e.T.P().onLongClick(view);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class z1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19801a;

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
            this.f19801a = videoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19801a.y() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.f19801a.N0 != null) {
                VideoPbFragment videoPbFragment = this.f19801a;
                videoPbFragment.s4(videoPbFragment.N0.C());
            }
            this.f19801a.k4();
            this.f19801a.T.F();
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
        this.f19685f = 0L;
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
        this.Z0 = d.a.o0.b.d.g0();
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

    public static VideoPbFragment U3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? new VideoPbFragment() : (VideoPbFragment) invokeV.objValue;
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || y() == null || y().D0() == null || y().D0().N() == null) {
            return;
        }
        d.a.o0.r.q.b2 N = y().D0().N();
        N.V0 = y().I0();
        N.U0 = y().L0();
        N.T0 = y().K0();
        N.W0 = y().J0();
        N.D2 = y().r0();
        if (N.Q() == 0) {
            N.l3(d.a.c.e.m.b.f(y().getForumId(), 0L));
        }
        StatisticItem i2 = d.a.o0.j0.c.i(getContext(), N, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public final void A3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            d.a.o0.w.w.g gVar = new d.a.o0.w.w.g();
            this.M0 = gVar;
            v4(gVar);
            d.a.o0.w.w.e eVar = (d.a.o0.w.w.e) this.M0.a(getActivity());
            this.N0 = eVar;
            eVar.e0(this.f19684e.getPageContext());
            this.N0.n0(this.o1);
            this.N0.o0(this.F1);
            this.N0.g0(1);
            this.N0.F(this.f19684e.getPageContext(), bundle);
            this.N0.a().b(new d.a.o0.w.k(getActivity()));
            this.N0.a().C(true);
            C4(true);
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
                this.N0.k0(o3());
            }
            this.K0 = new d.a.p0.h2.k.e.v0();
            if (this.N0.v() != null) {
                this.K0.m(this.N0.v().i());
            }
            this.N0.d0(this.e1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.H0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new k0(this));
        }
    }

    public void A4(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (view = this.k) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public final void B2(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) || y() == null || y().D0() == null || y().D0().N() == null) {
            return;
        }
        d.a.o0.r.q.b2 N = y().D0().N();
        N.V0 = y().I0();
        N.U0 = y().L0();
        N.T0 = y().K0();
        N.W0 = y().J0();
        if (N.Q() == 0) {
            N.l3(d.a.c.e.m.b.f(y().getForumId(), 0L));
        }
        StatisticItem i2 = d.a.o0.j0.c.i(getContext(), N, "c13563");
        TbPageTag l2 = d.a.o0.j0.c.l(getContext());
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
            d.a.o0.i0.c k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(i2);
        }
        StatisticItem i3 = d.a.o0.j0.c.i(getContext(), N, "c14180");
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

    public final void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.P = (FallingView) this.f19686g.findViewById(R.id.falling_view);
            TbImageView tbImageView = (TbImageView) this.f19686g.findViewById(R.id.falling_ad_view);
            this.Q = tbImageView;
            tbImageView.setPlaceHolder(2);
        }
    }

    public void B4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z2) == null) {
            this.y = z2;
        }
    }

    @Override // d.a.p0.h2.o.b
    public PbFragment C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
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
    public final void C2(d.a.o0.r.q.b2 b2Var) {
        double d2;
        int ceil;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        Rect X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, b2Var) == null) {
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
                    if (J3() && !d.a.o0.c1.b.e.d()) {
                        layoutParams3 = (RelativeLayout.LayoutParams) this.f19687h.getLayoutParams();
                        if (layoutParams3 != null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, Y1);
                        } else {
                            layoutParams3.height = Y1;
                        }
                        this.f19687h.setLayoutParams(layoutParams3);
                    }
                    layoutParams2 = (CoordinatorLayout.LayoutParams) this.m.getLayoutParams();
                    if (J3() && !d.a.o0.c1.b.e.d()) {
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
            if (J3()) {
                layoutParams3 = (RelativeLayout.LayoutParams) this.f19687h.getLayoutParams();
                if (layoutParams3 != null) {
                }
                this.f19687h.setLayoutParams(layoutParams3);
            }
            layoutParams2 = (CoordinatorLayout.LayoutParams) this.m.getLayoutParams();
            if (J3()) {
                ceil += Y1;
            }
            if (layoutParams2 != null) {
            }
            this.m.setLayoutParams(layoutParams2);
            if (i2 == 0) {
            }
        }
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.H = (TextView) this.f19686g.findViewById(R.id.pb_video_mount_title);
            this.L = (TbImageView) this.f19686g.findViewById(R.id.pb_video_mount_pic);
            this.I = (TextView) this.f19686g.findViewById(R.id.pb_video_mount_desc);
            this.J = (ImageView) this.f19686g.findViewById(R.id.pb_video_mount_close);
            this.K = (TBSpecificationBtn) this.f19686g.findViewById(R.id.pb_video_mount_link);
            this.M = this.f19686g.findViewById(R.id.ala_live_point);
            this.L.setRadius(d.a.c.e.p.l.g(getContext(), R.dimen.tbds10));
            this.L.setConrers(15);
            this.K.setConfig(new d.a.o0.r.f0.n.c());
            this.J.setOnClickListener(new t0(this));
            this.K.setOnClickListener(this.G);
            this.z.setOnClickListener(this.G);
            if (y() == null || y().D0() == null) {
                return;
            }
            H4(y().D0());
        }
    }

    public final void C4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z2) == null) {
            this.N0.f0(z2);
            this.N0.i0(z2);
            this.N0.p0(z2);
        }
    }

    public final void D2(d.a.p0.h2.o.i.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) && aVar != null && this.A == null) {
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

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f19686g.findViewById(R.id.video_pb_navigation_bar);
            this.q = navigationBar;
            navigationBar.setOnClickListener(new w0(this));
            this.q.hideBottomLine();
            this.q.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
            this.q.getTopCoverBgView().setVisibility(0);
            this.r = this.f19686g.findViewById(R.id.statebar);
            View findViewById = this.f19686g.findViewById(R.id.status_bar_background);
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

    public final void D4(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048588, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new d1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                d.a.p0.h2.o.g.a aVar = this.T;
                if (aVar != null) {
                    aVar.E0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || y() == null || this.f19684e == null) {
            return;
        }
        d.a.o0.w.w.e eVar = this.N0;
        if (eVar == null || !eVar.z) {
            d.a.o0.w.w.d dVar = new d.a.o0.w.w.d();
            v4(dVar);
            d.a.o0.w.w.e eVar2 = (d.a.o0.w.w.e) dVar.a(getContext());
            this.N0 = eVar2;
            eVar2.e0(this.f19684e.getPageContext());
            this.N0.n0(this.o1);
            this.N0.o0(this.F1);
            this.N0.F(this.f19684e.getPageContext(), this.f19684e.getIntent() == null ? null : this.f19684e.getIntent().getExtras());
            this.N0.a().C(true);
            r4(this.N0.a());
            if (!y().r0()) {
                this.N0.s(y().T0());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.N0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (y().b1()) {
                this.N0.k0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.N0.k0(o3());
            }
        }
    }

    public void E3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (editorTools = this.O0) == null) {
            return;
        }
        editorTools.j();
        d.a.o0.w.w.e eVar = this.N0;
        if (eVar != null) {
            eVar.P();
        }
        r3();
    }

    public final void E4(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            String errorString = postWriteCallBackData.getErrorString();
            String preMsg = postWriteCallBackData.getPreMsg();
            String colorMsg = postWriteCallBackData.getColorMsg();
            if (postWriteCallBackData.getIconStampData() != null) {
                d.a.o0.s.h.b.a(getPageContext(), postWriteCallBackData);
                return;
            } else {
                d.a.p0.h3.q0.g.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
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

    public void F2(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, bdTypeRecyclerView, z2) == null) {
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
                if (((d.a.o0.t.a) ListUtils.getItem(arrayList, 0)).c() != 1) {
                    R4();
                    Z3((d.a.o0.t.a) ListUtils.getItem(arrayList, 0), 1);
                } else if (z2) {
                } else {
                    R4();
                    Z3((d.a.o0.t.a) ListUtils.getItem(arrayList, 0), 0);
                }
            }
        }
    }

    public void F3(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) || this.a1 == null || eVar == null || eVar.g() == 3) {
            return;
        }
        d.a.p0.h2.o.j.a aVar = new d.a.p0.h2.o.j.a();
        this.F = aVar;
        aVar.e(eVar.k() == null ? null : eVar.k().pbpage);
        this.F.d(TbSingleton.getInstance().getAdFloatViewData());
        w3();
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

    public void F4(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) || this.p0 == null || d.a.o0.c1.b.e.d()) {
            return;
        }
        s4(this.N0.C());
        if (this.B0) {
            G4(z2);
        } else {
            s3(z2);
        }
        a4();
        d4();
    }

    public final boolean G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PbModel y2 = y();
            if (y2 == null || y2.D0() == null) {
                return false;
            }
            d.a.o0.r.q.b2 N = y2.D0().N();
            y2.D0().d();
            return AntiHelper.b(getPageContext(), N);
        }
        return invokeV.booleanValue;
    }

    public final void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f19687h.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            this.f19687h.setContainerLayoutParams(layoutParams);
            this.f19687h.setRectPaintColor(R.color.CAM_X0302);
            this.f19687h.C(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
            this.f19687h.setIndicatorOffset(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds64));
            this.f19687h.setIndicatorOvershot(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            this.f19687h.setIndicatorMarginBottom(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
            layoutParams2.gravity = 16;
            this.f19687h.setExpandedTabLayoutParams(layoutParams2);
        }
    }

    public void G4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z2) == null) || this.p0 == null || (textView = this.s0) == null) {
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
        this.z0.f19696a = true;
    }

    public final boolean H2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void H3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            d.a.p0.i0.b bVar = new d.a.p0.i0.b(getActivity());
            this.R0 = bVar;
            bVar.i(Z1);
            this.u1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
            D3();
            this.m = (AppBarLayout) this.f19686g.findViewById(R.id.appbar_layout);
            this.k = this.f19686g.findViewById(R.id.pb_video_pager_shadow);
            this.a1 = (RightFloatLayerView) this.f19686g.findViewById(R.id.right_layer_view);
            registerListener(this.b1);
            this.n = (VideoContainerLayout) this.f19686g.findViewById(R.id.pb_video_container);
            d.a.p0.h2.o.k.a aVar = new d.a.p0.h2.o.k.a(getContext(), this.n);
            this.o = aVar;
            aVar.setStageType("2002");
            this.o.setUniqueId(getUniqueId());
            this.o.c1(this);
            this.o.a1(z().getRootView());
            this.o.b1(this.s);
            ((RelativeLayout) this.f19686g.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((d.a.c.e.p.l.k(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
            this.f19687h = (NewPagerSlidingTabBaseStrip) this.f19686g.findViewById(R.id.pb_video_tab_strip);
            this.z = this.f19686g.findViewById(R.id.pb_video_mount_layout);
            this.f19688i = (CustomViewPager) this.f19686g.findViewById(R.id.pb_video_view_pager);
            this.l = this.f19686g.findViewById(R.id.keyboard_background_shadow);
            this.E = (MaskView) this.f19686g.findViewById(R.id.mask_view);
            this.l.setOnClickListener(this.G1);
            G3();
            C3();
            x3();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.j = videoPbFragmentAdapter;
            this.f19688i.setAdapter(videoPbFragmentAdapter);
            this.f19687h.setViewPager(this.f19688i);
            this.f19687h.setOnPageChangeListener(new n0(this));
            this.S = this.f19686g.findViewById(R.id.viewstub_progress);
            z3();
            B3();
            y3();
            if (!this.u1 && this.v1) {
                O4();
                UtilHelper.hideStatusBar(z(), z().getRootView());
                this.v1 = false;
            }
            if (!J3() || d.a.o0.c1.b.e.d()) {
                this.f19687h.getLayoutParams().height = 0;
            }
            if (d.a.o0.c1.b.e.d()) {
                this.f19688i.setScrollable(false);
            }
        }
    }

    public final void H4(d.a.p0.h2.h.e eVar) {
        d.a.p0.h2.o.i.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, eVar) == null) || (F = eVar.F()) == null || F.p) {
            return;
        }
        D2(F);
    }

    public boolean I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if ((y() != null && y().D0().e0()) || this.H0 == null || y() == null || y().D0() == null || ThreadCardUtils.isSelf(y().D0().N()) || y().D0().d() == null) {
                return true;
            }
            return this.H0.checkPrivacyBeforeInvokeEditor(y().D0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void I3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.p == null) {
            this.p = new d.a.p0.h2.o.e(getBaseFragmentActivity(), this.n);
            int r2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? d.a.c.e.p.l.r(z()) : 0;
            Rect rect = new Rect(0, r2, d.a.c.e.p.l.k(getContext()), this.n.getOriginHeight() + r2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.p.r(videoPbViewModel.h(), rect);
            if (this.p.l()) {
                this.p.q(new j0(this, videoPbViewModel));
            } else if (!d.a.o0.c1.b.e.d() && J3() && (videoPbViewModel.m() || y().S0() == R1)) {
                this.f19688i.setCurrentItem(R1);
            } else if (videoPbViewModel.m() || y().S0() == S1) {
                this.f19688i.setCurrentItem(S1);
            }
        }
    }

    public void I4() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (view = this.S) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public boolean J2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            if (this.H0 == null || y() == null || y().D0() == null || ThreadCardUtils.isSelf(y().D0().N()) || y().D0().d() == null) {
                return true;
            }
            return this.H0.checkPrivacyBeforeSend(y().D0().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public boolean J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? y() != null && y().g1() : invokeV.booleanValue;
    }

    public final void J4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            d.a.p0.h2.o.j.b.c(z(), X2(), i2);
        }
    }

    public void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (!checkUpIsLogin()) {
                if (y() != null) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", y().getForumId()));
                }
            } else if (I2()) {
                d.a.o0.w.w.e eVar = this.N0;
                if (eVar != null && (eVar.B() || this.N0.D())) {
                    this.N0.z(false, null);
                    return;
                }
                if (this.O0 != null) {
                    E3();
                    this.z0.f19696a = false;
                    if (this.O0.n(2) != null) {
                        d.a.p0.h3.g0.a.c(getPageContext(), (View) this.O0.n(2).k, false, null);
                    }
                }
                r3();
            }
        }
    }

    public final boolean K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            d.a.p0.h2.o.k.a aVar = this.o;
            return aVar != null && aVar.R0();
        }
        return invokeV.booleanValue;
    }

    public final void K4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || y() == null || d.a.c.e.p.k.isEmpty(y().T0())) {
            return;
        }
        d.a.o0.a.d.y().P(d.a.o0.a.c.W, d.a.c.e.m.b.f(y().T0(), 0L));
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (y().j0() || y().m0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", y().T0());
                this.f19684e.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, y().T0()));
            if (U4()) {
                this.f19684e.finish();
            }
        }
    }

    public boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.v1 : invokeV.booleanValue;
    }

    public final void L4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || this.z.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            W4();
        }
    }

    public void M2(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bVar) == null) {
            List<PostData> list = y().D0().S().f56951a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).M().size()) {
                        break;
                    } else if (bVar.f21185g.equals(list.get(i2).M().get(i3).E())) {
                        list.get(i2).M().remove(i3);
                        list.get(i2).l();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).n(bVar.f21185g);
            }
            if (z2) {
                if (Y2() != null) {
                    Y2().j1();
                } else if (J3() && n3() != null) {
                    n3().g1();
                }
            }
        }
    }

    public boolean M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            d.a.p0.h2.o.k.a aVar = this.o;
            if (aVar == null) {
                return false;
            }
            return aVar.S0();
        }
        return invokeV.booleanValue;
    }

    public void M4(d.a.o0.t.a aVar, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048615, this, aVar, bitmap, i2) == null) && d.a.p0.h2.k.e.r0.a(aVar, i2)) {
            Random random = new Random();
            c.b bVar = new c.b(bitmap);
            bVar.p(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.o(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.m(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.n(new p0(this, random));
            bVar.q(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40), true, true);
            d.a.p0.h2.p.c l2 = bVar.l();
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

    public void N2(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, sparseArray, jSONArray) == null) {
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

    public final void N3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void N4() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (layoutParams = this.z.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.z.setAlpha(0.0f);
            this.z.setVisibility(0);
            Y4(layoutParams);
        }
    }

    public void O2(d.a.o0.r.s.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, aVar, jSONArray) == null) {
            aVar.dismiss();
            if (y() == null || y().D0() == null || y().D0().N() == null || y().D0().m() == null) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (aVar.getYesButtonTag() instanceof SparseArray) {
                    N2((SparseArray) aVar.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final void O3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void O4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.B1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, "alpha", 1.0f, 0.0f);
                this.B1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.B1.start();
        }
    }

    public void P2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(T1, Integer.valueOf(U1));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                N2(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (this.r0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.r0.setImageResource(0);
                this.r0.M(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.r0.setImageResource(R.drawable.transparent_bg);
        }
    }

    public final void P4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (this.A1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, "alpha", 0.0f, 1.0f);
                this.A1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.A1.start();
        }
    }

    public void Q2(boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) || (appBarLayout = this.m) == null) {
            return;
        }
        appBarLayout.setExpanded(z2);
    }

    public final void Q3(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048626, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || G2() || !I2()) {
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
            d.a.p0.u0.f2.a.c cVar = new d.a.p0.u0.f2.a.c(getPageContext());
            this.J0 = cVar;
            cVar.k(1);
            this.J0.j(new i1(this, str, str2));
        }
        if (y() == null || y().D0() == null || y().D0().m() == null) {
            return;
        }
        this.J0.h(y().D0().m().getId(), d.a.c.e.m.b.f(y().T0(), 0L));
    }

    public final void Q4(PostData postData, PostData postData2, boolean z2, boolean z3) {
        PbActivity.e n2;
        PostData a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String T0 = y().T0();
            String E = postData.E();
            String E2 = postData2 != null ? postData2.E() : "";
            int U = y().D0() != null ? y().D0().U() : 0;
            if (n3() != null && n3().e1() != null) {
                n2 = n3().e1().n(E);
            } else if (Y2() == null || Y2().g1() == null) {
                return;
            } else {
                n2 = Y2().g1().n(E);
            }
            PbActivity.e eVar = n2;
            if (postData == null || y() == null || y().D0() == null || eVar == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(T0, E, "pb", true, null, false, E2, U, postData.O(), y().D0().d(), false, postData.t().getIconInfo()).addBigImageData(eVar.f19176a, eVar.f19177b, eVar.f19182g, eVar.j);
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
            if (y() != null && (a3 = a3(y().D0())) != null) {
                if (!a3.S && !postData.S) {
                    z4 = false;
                }
                addBigImageData.setMainPostMaskVisibly(z4);
            }
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.r
    public void R(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048628, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (d.a.o0.b1.m.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), d.a.o0.b1.m.f.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (d.a.p0.h2.k.e.y0.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new d.a.o0.b1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final void R2(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048629, this, bVar, z2) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f21180b) ? bVar.f21180b : getString(R.string.delete_fail);
            int i2 = 0;
            if (bVar.f21181c == 1211066) {
                hideProgressBar();
                d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(R.string.dialog_known, new r(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else {
                S2(0, bVar.f21179a, bVar.f21180b, z2);
            }
            if (bVar.f21179a) {
                int i3 = bVar.f21182d;
                if (i3 == 1) {
                    ArrayList<PostData> E = y().D0().E();
                    int size = E.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.f21185g.equals(E.get(i2).E())) {
                            E.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    y().D0().N().R3(y().D0().N().P0() - 1);
                    if (Y2() != null) {
                        Y2().j1();
                    } else if (J3() && n3() != null) {
                        n3().g1();
                    }
                } else if (i3 == 0) {
                    L2();
                } else if (i3 == 2) {
                    ArrayList<PostData> E2 = y().D0().E();
                    int size2 = E2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= E2.get(i4).M().size()) {
                                break;
                            } else if (bVar.f21185g.equals(E2.get(i4).M().get(i5).E())) {
                                E2.get(i4).M().remove(i5);
                                E2.get(i4).l();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        E2.get(i4).n(bVar.f21185g);
                    }
                    if (z3) {
                        if (Y2() != null) {
                            Y2().j1();
                        } else if (J3() && n3() != null) {
                            n3().g1();
                        }
                    }
                    M2(bVar);
                }
            }
        }
    }

    public final void R3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || y() == null) {
            return;
        }
        d.a.p0.h2.h.e D0 = y().D0();
        y().X1(true);
        d.a.o0.h.a aVar = this.V;
        if (aVar != null) {
            D0.w0(aVar.g());
        }
        if (J3()) {
            if (Z2() != null) {
                Z2().S0();
            }
            if (n3() != null) {
                n3().g1();
            }
        } else if (Y2() != null) {
            Y2().j1();
        }
    }

    public void R4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
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

    public void S2(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
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

    public final void S3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || y() == null || y().D0() == null) {
            return;
        }
        if (J3() && n3() == null) {
            return;
        }
        if ((J3() || Y2() != null) && this.V != null) {
            MarkData markData = null;
            if (y().D0() != null && y().D0().e0()) {
                markData = y().W(0);
            } else {
                CustomViewPager customViewPager = this.f19688i;
                if (customViewPager != null && customViewPager.getCurrentItem() == Q1) {
                    markData = y().x0(a3(y().D0()));
                } else if (J3()) {
                    if (n3() != null) {
                        markData = y().W(n3().Z0());
                    }
                } else if (Y2() != null) {
                    markData = y().W(Y2().b1());
                }
            }
            if (markData == null) {
                return;
            }
            if (markData.isApp() && n3() != null && (markData = y().W(n3().Z0() + 1)) == null) {
                return;
            }
            y4();
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

    public final void S4() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (voiceManager = this.a0) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public final void T2(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048635, this, i2, gVar) == null) || gVar == null || y() == null || y().D0() == null || y().D0().N() == null) {
            return;
        }
        S2(this.Z.getLoadDataMode(), gVar.f21200a, gVar.f21201b, false);
        if (gVar.f21200a) {
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
            if (gVar != null && !TextUtils.isEmpty(gVar.f21201b)) {
                string = gVar.f21201b;
            } else {
                string = getString(R.string.operation_failed);
            }
            d.a.c.e.p.l.M(getPageContext().getPageActivity(), string);
        }
        if (J3()) {
            if (y().D0().N() == null || Z2() == null) {
                return;
            }
            Z2().Z0();
        } else if (y().D0().N() == null || Y2() == null) {
        } else {
            Y2().p1();
        }
    }

    public final boolean T3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String p2 = d.a.o0.r.d0.b.j().p("bubble_link", "");
                if (StringUtils.isNull(p2)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    d.a.o0.l.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p2 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void T4() {
        PbActivity pbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048637, this) == null) || (pbActivity = this.f19684e) == null) {
            return;
        }
        pbActivity.superCloseActivity();
    }

    public final String U2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048638, this, i2)) == null) {
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

    public final boolean U4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (y() == null) {
                return true;
            }
            if (y().D0() == null || !y().D0().e0()) {
                if (y().p0()) {
                    MarkData c02 = y().c0();
                    if (c02 != null && y().n0() && m3() != null) {
                        MarkData W = y().W(m3().getFirstVisiblePosition());
                        if (W == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", c02);
                            this.f19684e.setResult(-1, intent);
                            return true;
                        } else if (W.getPostId() != null && !W.getPostId().equals(c02.getPostId())) {
                            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(getBaseFragmentActivity());
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
                            this.f19684e.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (y().D0() != null && y().D0().E() != null && y().D0().E().size() > 0 && y().n0()) {
                    this.f19684e.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public d.a.o0.s.e.a V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.Y : (d.a.o0.s.e.a) invokeV.objValue;
    }

    public void V3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z2) == null) {
            this.l.setVisibility(z2 ? 0 : 8);
        }
    }

    public void V4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            d.a.o0.w.w.e eVar = this.N0;
            if (eVar != null) {
                s4(eVar.C());
            }
            k4();
            this.T.F();
        }
    }

    public LinearLayout W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.q0 : (LinearLayout) invokeV.objValue;
    }

    public final void W3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            if (!d.a.c.e.p.j.z()) {
                showToast(R.string.network_not_available);
            } else if (this.T == null || y() == null) {
            } else {
                this.T.F();
                if (this.R) {
                    return;
                }
                S4();
                y4();
                if (y().LoadData()) {
                    I4();
                }
            }
        }
    }

    public final void W4() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || (layoutParams = this.z.getLayoutParams()) == null) {
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

    public final int X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            if (y() == null || y().D0() == null || y().D0().N() == null) {
                return -1;
            }
            return y().D0().N().q();
        }
        return invokeV.intValue;
    }

    public void X3(int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
            if (i2 == 0) {
                d.a.p0.g3.c.g().h(getUniqueId(), false);
                if (m3() != null) {
                    F2(m3(), true);
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

    public final void X4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.N = ofFloat;
            ofFloat.setDuration(300L);
            this.N.addUpdateListener(new r1(this));
            this.N.start();
        }
    }

    @Override // d.a.p0.h2.o.b
    public PbModel.g Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.c1 : (PbModel.g) invokeV.objValue;
    }

    public DetailInfoAndReplyFragment Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(S1) instanceof DetailInfoAndReplyFragment)) {
                return null;
            }
            return (DetailInfoAndReplyFragment) this.j.b(S1);
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public void Y3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048651, this, z2) == null) || z() == null) {
            return;
        }
        if (this.v1 && !TbSingleton.getInstance().isNotchScreen(z()) && !TbSingleton.getInstance().isCutoutScreen(z())) {
            O4();
            UtilHelper.hideStatusBar(z(), z().getRootView());
            this.v1 = false;
        }
        this.z0.f19697b = z2;
        a4();
        d4();
    }

    public final void Y4(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, layoutParams) == null) {
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

    public DetailInfoFragment Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(Q1) instanceof DetailInfoFragment)) {
                return null;
            }
            return (DetailInfoFragment) this.j.b(Q1);
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    public void Z3(d.a.o0.t.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048654, this, aVar, i2) == null) && d.a.p0.h2.k.e.r0.a(aVar, i2)) {
            this.Q.M(aVar.f(), 10, false);
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.e())).setProgressiveRenderingEnabled(true).build(), getPageContext()).subscribe(new o0(this, aVar, i2), CallerThreadExecutor.getInstance());
        }
    }

    public final void Z4(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, layoutParams) == null) {
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

    public PostData a3(d.a.p0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, eVar)) == null) {
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
                postData = l3(eVar);
            }
            if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
                postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final void a4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048657, this) == null) || this.o == null) {
            return;
        }
        if (this.z0.a()) {
            this.o.X(false);
            return;
        }
        d.a.p0.h2.o.k.a aVar = this.o;
        aVar.X(!aVar.S0());
    }

    public final void a5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048658, this) == null) || y() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.B(y().getForumId()) || y().D0() == null || y().D0().m() == null) {
            return;
        }
        if (y().D0().m().isLike() == 1) {
            y().T().A(y().getForumId(), y().T0());
        }
    }

    public final String b3() {
        InterceptResult invokeV;
        ArrayList<PostData> E;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
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
            if (m3() != null) {
                if (J3()) {
                    if (n3() != null) {
                        i2 = n3().X0();
                    }
                } else if (Y2() != null) {
                    i2 = Y2().Z0();
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

    public final void b4(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048660, this, eVar) == null) || eVar == null) {
            return;
        }
        d.a.o0.r.q.b2 N = eVar.N();
        if (N != null && N.p2()) {
            E2();
        } else {
            v4(this.M0);
        }
        d.a.o0.w.w.e eVar2 = this.N0;
        if (eVar2 != null) {
            s4(eVar2.C());
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

    public void b5(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, eVar) == null) {
            if (eVar != null && AntiHelper.o(eVar.N())) {
                d.a.p0.h2.p.h hVar = this.w0;
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
            d.a.p0.h2.p.h hVar2 = this.w0;
            if (hVar2 == null || !hVar2.e()) {
                ViewGroup.LayoutParams layoutParams2 = this.v0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.v0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.v0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public boolean c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public void c4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048663, this) == null) || !checkUpIsLogin() || y() == null || y().D0() == null || y().D0().m() == null || G2()) {
            return;
        }
        if (y().D0().e0()) {
            K2();
            return;
        }
        if (this.I0 == null) {
            d.a.p0.u0.f2.a.c cVar = new d.a.p0.u0.f2.a.c(getPageContext());
            this.I0 = cVar;
            cVar.k(0);
            this.I0.j(new b1(this));
        }
        this.I0.h(y().D0().m().getId(), d.a.c.e.m.b.f(y().T0(), 0L));
    }

    public void c5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z2) == null) {
            DetailInfoAndReplyFragment Y2 = Y2();
            if (Y2 != null && Y2.H0() != null && Y2.H0().l() != null && Y2.H0().m() != null) {
                Y2.H0().l().X0(z2);
                Y2.H0().m().s0(z2);
            }
            MaskView maskView = this.E;
            if (maskView != null) {
                maskView.setVisibility(z2 ? 0 : 8);
            }
        }
    }

    public View.OnClickListener d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.G1 : (View.OnClickListener) invokeV.objValue;
    }

    public final void d4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048666, this) == null) || this.o == null || this.f19688i == null) {
            return;
        }
        boolean z2 = false;
        if (!J3()) {
            this.o.W0(false);
        } else if (this.f19688i.getCurrentItem() != 0) {
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

    public View.OnClickListener e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.H1 : (View.OnClickListener) invokeV.objValue;
    }

    public void e4(boolean z2, int i2, int i3, int i4, d.a.p0.h2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048668, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.j.c()) {
                if (baseFragment instanceof d.a.p0.h2.o.a) {
                    ((d.a.p0.h2.o.a) baseFragment).z0(z2, i2, i3, i4, eVar, str, i5);
                }
            }
            z0(z2, i2, i3, i4, eVar, str, i5);
        }
    }

    public SparseArray<Object> f3(d.a.p0.h2.h.e eVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData a3;
        d.a.o0.r.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048669, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (eVar == null || (a3 = a3(eVar)) == null) {
                return null;
            }
            String userId = a3.t().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, a3.E());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.U()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (a3.t() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, a3.t().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, a3.t().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, a3.t().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, a3.E());
                }
                sparseArray.put(R.id.tag_del_post_id, a3.E());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.U()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<d.a.o0.r.q.x1> q2 = eVar.q();
                if (ListUtils.getCount(q2) > 0) {
                    sb = new StringBuilder();
                    for (d.a.o0.r.q.x1 x1Var : q2) {
                        if (x1Var != null && !StringUtils.isNull(x1Var.g()) && (e0Var = x1Var.f52820g) != null && e0Var.f52641a && !e0Var.f52643c && ((i3 = e0Var.f52642b) == 1 || i3 == 2)) {
                            sb.append(d.a.c.e.p.k.cutString(x1Var.g(), 12));
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

    public void f4(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048670, this, eVar) == null) || eVar == null || eVar.N() == null) {
            return;
        }
        b5(eVar);
        this.u0.setVisibility(eVar.e0() ? 8 : 0);
        if (eVar.s()) {
            WebPManager.setPureDrawable(this.u0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.u0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String U2 = U2(eVar.N().P0());
        TextView textView = this.x0;
        if (textView != null) {
            textView.setText(U2);
        }
        TextView textView2 = this.y0;
        if (textView2 != null) {
            textView2.setText(U2);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.N()));
    }

    @Override // d.a.p0.h2.o.b
    public void finish() {
        CardHListViewData r2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            PbModel pbModel = this.f19684e.getPbModel();
            if (pbModel != null && pbModel.D0() != null && !pbModel.D0().e0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = pbModel.D0().N().c0();
                if (pbModel.isShareThread() && pbModel.D0().N().u1 != null) {
                    historyMessage.threadName = pbModel.D0().N().u1.f12248b;
                } else {
                    historyMessage.threadName = pbModel.D0().N().getTitle();
                }
                if (pbModel.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = pbModel.D0().m().getName();
                }
                ArrayList<PostData> E = pbModel.D0().E();
                int X0 = n3() != null ? n3().X0() : 0;
                if (E != null && X0 >= 0 && X0 < E.size()) {
                    historyMessage.postID = E.get(X0).E();
                }
                historyMessage.isHostOnly = pbModel.i0();
                historyMessage.isSquence = pbModel.R0();
                historyMessage.isShareThread = pbModel.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            d.a.o0.w.w.e eVar = this.N0;
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
                if (pbModel.D0() != null && System.currentTimeMillis() - this.f19685f >= 40000 && (r2 = pbModel.D0().r()) != null && !ListUtils.isEmpty(r2.getDataList())) {
                    intent.putExtra("guess_like_data", r2);
                }
                this.f19684e.setResult(-1, intent);
            }
            if (U4()) {
                if (pbModel != null) {
                    d.a.p0.h2.h.e D0 = pbModel.D0();
                    if (D0 != null) {
                        if (D0.T() != null) {
                            D0.T().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!this.G0) {
                            if (this.n != null) {
                                Rect rect = new Rect();
                                this.n.getGlobalVisibleRect(rect);
                                d.a.p0.h2.k.e.m0.b().t(rect);
                            }
                            d.a.p0.h2.k.e.m0.b().s(this.f19688i.getCurrentItem());
                            BdTypeRecyclerView m3 = m3();
                            d.a.p0.h2.k.e.m0.b().n(pbModel.E0(), m3 != null ? m3.onSaveInstanceState() : null, pbModel.R0(), pbModel.i0(), false);
                        }
                    }
                } else {
                    d.a.p0.h2.k.e.m0.b().m();
                }
                T4();
            }
        }
    }

    public d.a.o0.h.a g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.V : (d.a.o0.h.a) invokeV.objValue;
    }

    public void g4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048673, this, z2, markData) == null) || y() == null) {
            return;
        }
        x4();
        y().X1(z2);
        d.a.o0.h.a aVar = this.V;
        if (aVar != null) {
            aVar.h(z2);
            if (markData != null) {
                this.V.i(markData);
            }
        }
        if (y().p0()) {
            R3();
        } else if (J3()) {
            if (Z2() != null) {
                Z2().S0();
            }
            if (n3() != null) {
                n3().g1();
            }
        } else if (Y2() != null) {
            Y2().j1();
        }
    }

    @Override // d.a.o0.b1.m.h
    public d.a.c.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            if (this.b0 == null) {
                this.b0 = new d.a.c.e.k.b<>(new t1(this), 20, 0);
            }
            return this.b0;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.o0.b1.m.h
    public d.a.c.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            if (this.i0 == null) {
                this.i0 = new d.a.c.e.k.b<>(new s1(this), 8, 0);
            }
            return this.i0;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.o0.b1.m.h
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // d.a.o0.b1.m.h
    public d.a.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            d.a.c.e.k.b<RelativeLayout> bVar = new d.a.c.e.k.b<>(new w1(this), 10, 0);
            this.l0 = bVar;
            return bVar;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.o0.b1.m.h
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.o0.b1.m.h
    public d.a.c.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            if (this.c0 == null) {
                this.c0 = TbRichTextView.y(getPageContext().getPageActivity(), 8);
            }
            return this.c0;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.o0.b1.m.h
    public d.a.c.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            if (this.a0 == null) {
                this.a0 = VoiceManager.instance();
            }
            return this.a0;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // d.a.o0.b1.m.h
    public d.a.c.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            if (this.j0 == null) {
                this.j0 = new d.a.c.e.k.b<>(new u1(this), 8, 0);
            }
            return this.j0;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    public View.OnLongClickListener h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.O1 : (View.OnLongClickListener) invokeV.objValue;
    }

    public void h4(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048685, this, eVar) == null) || eVar == null || eVar.N() == null) {
            return;
        }
        String valueOf = String.valueOf(eVar.N().P0());
        if (eVar.N().P0() == 0) {
            valueOf = "";
        }
        this.f19687h.F(valueOf);
    }

    public View.OnTouchListener i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? this.D1 : (View.OnTouchListener) invokeV.objValue;
    }

    public void i4(d.a.p0.h2.h.r rVar) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048687, this, rVar) == null) || y() == null || y().D0() == null || rVar.i() == null) {
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
        if (J3() && n3() != null) {
            n3().g1();
        } else if (Y2() != null) {
            Y2().j1();
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            d.a.o0.h.a c2 = d.a.o0.h.a.c(this.f19684e);
            this.V = c2;
            if (c2 != null) {
                c2.j(this.d1);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f19684e);
            this.Z = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.C1);
            this.Y = new d.a.o0.s.e.a(getPageContext());
            this.T = new d.a.p0.h2.o.g.a(this);
        }
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            PbModel pbModel = this.f19684e.getPbModel();
            if (pbModel == null) {
                return false;
            }
            return pbModel.i1();
        }
        return invokeV.booleanValue;
    }

    public d.a.o0.w.w.e j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.N0 : (d.a.o0.w.w.e) invokeV.objValue;
    }

    public final void j4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048691, this) == null) || this.N0 == null || this.O0 == null) {
            return;
        }
        d.a.o0.w.w.a.a().c(0);
        this.N0.T();
        this.N0.R();
        if (this.N0.y() != null) {
            this.N0.y().setMaxImagesAllowed(this.N0.z ? 1 : 9);
        }
        this.N0.l0(SendView.k);
        this.N0.j(SendView.k);
        d.a.o0.w.h m2 = this.O0.m(23);
        d.a.o0.w.h m3 = this.O0.m(2);
        d.a.o0.w.h m4 = this.O0.m(5);
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

    public final int k3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048692, this, i2)) == null) {
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

    public void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            j4();
            t3();
            this.P0.c();
            F4(false);
        }
    }

    public final PostData l3(d.a.p0.h2.h.e eVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048694, this, eVar)) == null) {
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

    public final void l4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
            layoutParams.height = 0;
            this.z.setLayoutParams(layoutParams);
            this.z.setVisibility(8);
        }
    }

    public BdTypeRecyclerView m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            Iterator<BaseFragment> it = this.j.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).c1();
                }
                if (next instanceof ReplyFragment) {
                    return ((ReplyFragment) next).a1();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public void m4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048697, this) == null) {
            this.U0 = -1;
            this.V0 = Integer.MIN_VALUE;
        }
    }

    public ReplyFragment n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(R1) instanceof ReplyFragment)) {
                return null;
            }
            return (ReplyFragment) this.j.b(R1);
        }
        return (ReplyFragment) invokeV.objValue;
    }

    public boolean n4(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048699, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (!TextUtils.isEmpty(postData.u()) && d.a.o0.r.k.c().g()) {
                        return T3(postData.E());
                    }
                    if (checkUpIsLogin() && y() != null && y().D0() != null) {
                        d.a.p0.h2.k.e.u uVar = this.P0;
                        if (uVar != null) {
                            uVar.c();
                        }
                        d.a.p0.h2.h.r rVar = new d.a.p0.h2.h.r();
                        rVar.A(y().D0().m());
                        rVar.E(y().D0().N());
                        rVar.C(postData);
                        this.Q0.I(rVar);
                        this.Q0.setPostId(postData.E());
                        Q3(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        d.a.o0.w.w.e eVar = this.N0;
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

    public String o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            if (!d.a.c.e.p.k.isEmpty(this.A0)) {
                return this.A0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(d.a.p0.h2.k.e.r0.b());
            this.A0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void o4(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048701, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.W == null) {
            d.a.p0.h2.k.e.b1.f.a aVar = new d.a.p0.h2.k.e.b1.f.a(this.f19684e);
            this.W = aVar;
            aVar.n(this.F1);
            this.W.m(this.o1);
        }
        this.W.k(emotionImageData, y(), y().D0());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            b4(videoPbViewModel.c());
            F3(videoPbViewModel.c());
            h4(videoPbViewModel.c());
            if (y() != null && y().D0() != null) {
                boolean n02 = y().n0();
                d.a.p0.h2.h.e D0 = y().D0();
                if (n02) {
                    PostData a3 = a3(D0);
                    if (D0.u() != null && !D0.u().equals(a3.E()) && this.f19688i != null) {
                        if (J3()) {
                            this.f19688i.setCurrentItem(R1);
                        } else {
                            this.f19688i.setCurrentItem(S1);
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
        if (interceptable == null || interceptable.invokeIIL(1048703, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.N0.H(i2, i3, intent);
            d.a.p0.h2.k.e.b1.f.a aVar = this.W;
            if (aVar != null) {
                aVar.i(i2, i3, intent);
            }
            d.a.p0.h2.k.e.u uVar = this.P0;
            if (uVar != null) {
                uVar.g(i2, i3, intent);
            }
            if (i2 == 25035) {
                p3(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 11009) {
                    S3();
                } else if (i2 == 13011) {
                    d.a.p0.v2.a.g().m(getPageContext());
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
                            if (W2() != null) {
                                W2().performClick();
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
                    if (J2(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        o4(emotionImageData);
                    }
                }
            }
        }
    }

    @Override // d.a.o0.b1.m.h
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048704, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.m0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, context) == null) {
            super.onAttach(context);
            this.f19684e = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048706, this, i2) == null) {
            super.onChangeSkinType(i2);
            UtilHelper.changeStatusBarIconAndTextColor(true, this.f19684e);
            getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            getBaseFragmentActivity().getLayoutMode().j(this.f19686g);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0611);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.f19687h, R.color.CAM_X0207);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f19687h;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.G();
            }
            d.a.p0.h2.k.e.v0 v0Var = this.K0;
            if (v0Var != null) {
                v0Var.i();
            }
            d.a.p0.h2.o.e eVar = this.p;
            if (eVar == null || !eVar.k()) {
                SkinManager.setBackgroundColor(this.f19686g, R.color.CAM_X0201);
            }
            EditorTools editorTools = this.O0;
            if (editorTools != null) {
                editorTools.w(i2);
            }
            d.a.p0.h2.k.e.u uVar = this.P0;
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
                b5(y().D0());
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
            if (Y2() != null) {
                Y2().onChangeSkinType(i2);
            } else if (J3() && n3() != null) {
                n3().onChangeSkinType(i2);
            }
            if (Z2() != null) {
                Z2().onChangeSkinType(i2);
            }
            View view = this.M;
            if (view != null) {
                view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(view.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            }
            S4();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            d.a.p0.h2.o.k.a aVar = this.o;
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
        if (interceptable == null || interceptable.invokeL(1048708, this, bundle) == null) {
            this.f19685f = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            A3(bundle);
            getVoiceManager().onCreate(getPageContext());
            d.a.o0.r.f0.c cVar = new d.a.o0.r.f0.c();
            this.U = cVar;
            cVar.f52333a = 1000L;
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
            this.x = new d.a.p0.z.a(getPageContext());
            d.a.p0.g3.c.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048709, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f19686g = (RelativeLayout) layoutInflater.inflate(R.layout.video_pb_fragment, viewGroup, false);
            H3();
            return this.f19686g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            super.onDestroy();
            d.a.p0.g3.c.g().k(getUniqueId());
            getVoiceManager().onDestory(getPageContext());
            d.a.p0.h2.p.h hVar = this.w0;
            if (hVar != null) {
                hVar.g();
            }
            ForumManageModel forumManageModel = this.Z;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            d.a.p0.h2.o.k.a aVar = this.o;
            if (aVar != null) {
                aVar.T0();
            }
            d.a.p0.h2.k.e.b1.f.a aVar2 = this.W;
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
            d.a.o0.w.w.e eVar = this.N0;
            if (eVar != null) {
                eVar.I();
            }
            this.U = null;
            R4();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048711, this, i2, keyEvent)) == null) {
            if (!this.u1 && (this.v1 || K3())) {
                O4();
                UtilHelper.hideStatusBar(z(), z().getRootView());
                this.v1 = false;
                d.a.p0.h2.o.k.a aVar = this.o;
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

    @Override // d.a.o0.b1.m.h
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048712, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.m0 = true;
    }

    @Override // d.a.o0.b1.m.h
    public void onLinkClicked(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048713, this, context, str, z2) == null) {
            if (d.a.p0.h2.k.e.y0.c(str) && y() != null && y().T0() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", y().T0()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    d.a.o0.t.m mVar = new d.a.o0.t.m();
                    mVar.f53441a = str;
                    mVar.f53442b = 3;
                    mVar.f53443c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, mVar));
                }
            } else {
                d.a.p0.h2.k.e.y0.a().e(getPageContext(), str);
            }
            this.m0 = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            super.onPause();
            this.Y0 = true;
            getVoiceManager().onPause(getPageContext());
            this.o.r0(true);
            if (y() != null && !y().r0()) {
                this.N0.U(y().T0());
            }
            d.a.o0.a.d.y().E();
            MessageManager.getInstance().unRegisterListener(this.l1);
            MessageManager.getInstance().unRegisterListener(this.m1);
            MessageManager.getInstance().unRegisterListener(this.k1);
            MessageManager.getInstance().unRegisterListener(this.J1);
        }
    }

    @Override // d.a.o0.b1.m.h
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048715, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.T.n0(str);
        d.a.o0.r.s.b R = this.T.R();
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
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            super.onResume();
            this.Y0 = false;
            getVoiceManager().onResume(getPageContext());
            this.o.r0(false);
            K4();
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
        if (interceptable == null || interceptable.invokeL(1048717, this, bundle) == null) {
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

    @Override // d.a.o0.b1.m.h
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048718, this, context, str) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            super.onStart();
            getVoiceManager().onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            super.onStop();
            getVoiceManager().onStop(getPageContext());
            d.a.p0.g3.c.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.K1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048721, this, z2) == null) {
            super.onUserChanged(z2);
            P3();
        }
    }

    @Override // d.a.o0.b1.m.h
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048722, this, context, str) == null) {
            d.a.p0.h2.k.e.y0.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.m0 = true;
        }
    }

    @Override // d.a.o0.b1.m.h
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048723, this, context, str) == null) {
        }
    }

    public final void p3(int i2, Intent intent) {
        d.a.o0.w.n nVar;
        d.a.p0.h2.k.e.u uVar;
        d.a.o0.w.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048724, this, i2, intent) == null) {
            if (i2 == 0) {
                t3();
                d.a.p0.h2.k.e.u uVar2 = this.P0;
                if (uVar2 != null) {
                    uVar2.c();
                }
                F4(false);
            }
            k4();
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
                    d.a.o0.w.m n2 = this.N0.a().n(6);
                    if (n2 != null && (nVar = n2.k) != null) {
                        nVar.onAction(new d.a.o0.w.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.N0.L(null, null);
                    }
                } else if (editorType != 1 || (uVar = this.P0) == null || uVar.b() == null) {
                } else {
                    d.a.o0.w.w.h b3 = this.P0.b();
                    b3.X(y().D0().N());
                    b3.z(writeData);
                    b3.Y(pbEditorData.getVoiceModel());
                    d.a.o0.w.m n3 = b3.a().n(6);
                    if (n3 != null && (nVar2 = n3.k) != null) {
                        nVar2.onAction(new d.a.o0.w.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b3.D();
                    }
                }
            }
        }
    }

    public final void p4(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048725, this, i2) == null) || y() == null) {
            return;
        }
        showLoadingView(getView());
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
        privacySettingMessage.setTid(y().T0());
        sendMessage(privacySettingMessage);
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
    public void q3(boolean z2) {
        d.a.p0.h2.h.e D0;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048726, this, z2) == null) || y() == null || this.T == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (D0 = y().D0()) == null) {
            return;
        }
        d.a.o0.r.q.b2 N = D0.N();
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
                d.a.o0.j0.c.e(z(), statisticItem);
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
                S4();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), N)) {
                    return;
                }
                d.a.p0.h2.p.h hVar = this.w0;
                if (hVar != null) {
                    hVar.h(false);
                    b5(D0);
                }
                if (ShareSwitch.isOn()) {
                    J4(z2 ? 2 : 1);
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

    public void q4(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048727, this, i2) == null) || (linearLayout = this.n0) == null) {
            return;
        }
        linearLayout.setVisibility(i2);
    }

    public void r3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048728, this) == null) || this.p0 == null) {
            return;
        }
        this.o0.setVisibility(8);
        this.p0.setVisibility(8);
        this.z0.f19696a = false;
        a4();
        d4();
    }

    public void r4(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, editorTools) == null) {
            this.O0 = editorTools;
            editorTools.setId(R.id.pb_editor);
            this.O0.setOnCancelClickListener(new e1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.O0.getParent() == null) {
                this.f19686g.addView(this.O0, layoutParams);
            }
            this.O0.w(TbadkCoreApplication.getInst().getSkinType());
            this.O0.setActionListener(24, new f1(this));
            t3();
            this.N0.i(new g1(this));
        }
    }

    public void s3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048730, this, z2) == null) || this.p0 == null || this.s0 == null) {
            return;
        }
        if (y() != null && y().D0() != null) {
            this.s0.setText(TbSingleton.getInstance().getAdVertiComment(y().D0().g0(), y().D0().h0(), o3()));
        } else {
            this.s0.setText(o3());
        }
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.p0.startAnimation(alphaAnimation);
        }
        this.o0.setVisibility(0);
        this.p0.setVisibility(0);
        this.z0.f19696a = true;
    }

    public void s4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048731, this, z2) == null) {
            this.B0 = z2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048732, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || (customViewPager = this.f19688i) == null) {
                return;
            }
            videoPbFragmentAdapter.d(z2 ? customViewPager.getCurrentItem() : -1);
        }
    }

    public void t3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048733, this) == null) || (editorTools = this.O0) == null) {
            return;
        }
        editorTools.o();
    }

    public void t4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048734, this, z2) == null) {
            this.R = z2;
        }
    }

    public void u3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048735, this) == null) || this.f19684e.getCurrentFocus() == null) {
            return;
        }
        d.a.c.e.p.l.x(getPageContext().getPageActivity(), this.f19684e.getCurrentFocus());
    }

    public void u4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z2) == null) {
            this.v1 = z2;
        }
    }

    @Override // d.a.p0.h2.o.b
    public VideoPbFragment v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? this : (VideoPbFragment) invokeV.objValue;
    }

    public void v3() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048738, this) == null) || (view = this.S) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void v4(d.a.o0.w.w.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048739, this, gVar) == null) || gVar == null || y() == null) {
            return;
        }
        gVar.o(y().f0());
        if (y().D0() != null && y().D0().m() != null) {
            gVar.n(y().D0().m());
        }
        gVar.p("pb");
        gVar.q(y());
    }

    public void w3() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048740, this) == null) || (rightFloatLayerView = this.a1) == null) {
            return;
        }
        rightFloatLayerView.f();
    }

    public void w4(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048741, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            d.a.p0.h2.o.g.a aVar = this.T;
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

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            this.n0 = (LinearLayout) this.f19686g.findViewById(R.id.video_pb_comment_container);
            this.o0 = this.f19686g.findViewById(R.id.view_comment_top_line);
            this.p0 = this.f19686g.findViewById(R.id.pb_editor_tool_comment);
            d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
            HeadImageView headImageView = (HeadImageView) this.f19686g.findViewById(R.id.pb_editor_tool_comment_user_image);
            this.r0 = headImageView;
            headImageView.setVisibility(0);
            this.r0.setIsRound(true);
            this.r0.setBorderWidth(d.a.c.e.p.l.g(getContext(), R.dimen.L_X01));
            this.r0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.r0.setPlaceHolder(0);
            P3();
            this.s0 = (TextView) this.f19686g.findViewById(R.id.pb_editor_tool_comment_reply_text);
            LinearLayout linearLayout = (LinearLayout) this.f19686g.findViewById(R.id.pb_editer_tool_comment_layout);
            this.q0 = linearLayout;
            linearLayout.setOnClickListener(new u0(this));
            ImageView imageView = (ImageView) this.f19686g.findViewById(R.id.pb_editor_tool_comment_icon);
            this.t0 = imageView;
            imageView.setOnClickListener(this.G1);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView2 = (ImageView) this.f19686g.findViewById(R.id.pb_editor_tool_collection);
            this.u0 = imageView2;
            imageView2.setOnClickListener(this.G1);
            if (booleanExtra) {
                this.u0.setVisibility(8);
            } else {
                this.u0.setVisibility(0);
            }
            ImageView imageView3 = (ImageView) this.f19686g.findViewById(R.id.pb_editor_tool_share);
            this.v0 = imageView3;
            imageView3.setOnClickListener(this.G1);
            d.a.p0.h2.p.h hVar = new d.a.p0.h2.p.h(this.v0);
            this.w0 = hVar;
            hVar.d();
            TextView textView = (TextView) this.f19686g.findViewById(R.id.pb_editor_tool_comment_red_dot);
            this.x0 = textView;
            textView.setVisibility(0);
            F4(false);
            if (d.a.o0.c1.b.e.d()) {
                ViewGroup.LayoutParams layoutParams = this.n0.getLayoutParams();
                layoutParams.height = 0;
                this.n0.setLayoutParams(layoutParams);
            }
        }
    }

    public void x4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048743, this) == null) {
            hideProgressBar();
            if (J3() && n3() != null) {
                n3().U0();
                n3().V0();
            } else if (Y2() != null) {
                Y2().W0();
                Y2().X0();
            }
        }
    }

    @Override // d.a.p0.h2.o.b
    public PbModel y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) ? this.f19684e.getPbModel() : (PbModel) invokeV.objValue;
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            this.Q0 = new PbFakeFloorModel(getPageContext());
            d.a.p0.h2.k.e.u uVar = new d.a.p0.h2.k.e.u(getPageContext(), this.Q0, this.f19686g);
            this.P0 = uVar;
            uVar.k(new x0(this));
            this.P0.m(this.E1);
            this.Q0.H(new y0(this));
        }
    }

    public void y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            d.a.c.e.p.l.x(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    @Override // d.a.p0.h2.o.b
    public PbActivity z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) ? this.f19684e : (PbActivity) invokeV.objValue;
    }

    @Override // d.a.p0.h2.o.a
    public void z0(boolean z2, int i2, int i3, int i4, d.a.p0.h2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048748, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
        }
    }

    public void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            r4(this.N0.a());
        }
    }

    public final void z4(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048750, this, i2) == null) || y() == null) {
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
            W3();
        }
    }

    /* loaded from: classes4.dex */
    public class b2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f19696a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f19697b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoPbFragment f19698c;

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
            this.f19698c = videoPbFragment;
            this.f19697b = true;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f19696a && this.f19697b) ? false : true : invokeV.booleanValue;
        }

        public /* synthetic */ b2(VideoPbFragment videoPbFragment, k kVar) {
            this(videoPbFragment);
        }
    }
}
