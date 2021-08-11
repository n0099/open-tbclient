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
import c.a.o0.d1.m.e;
import c.a.o0.i.a;
import c.a.o0.s.s.a;
import c.a.p0.i0.b;
import c.a.p0.i2.p.c;
import c.a.p0.v0.f2.a.c;
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
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
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
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
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
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.material.appbar.AppBarLayout;
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
/* loaded from: classes7.dex */
public abstract class AbsVideoPbFragment extends BaseFragment implements c.a.o0.d1.m.g, VoiceManager.j, c.a.p0.i2.o.b, TbRichTextView.t, c.a.p0.i2.o.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BDALERT_DIALOG_CLICK_FROM = 0;
    public static final int DETAIL_INFO_AND_REPLY_PAGE = 0;
    public static final int DETAIL_INFO_PAGE = 0;
    public static final int DIALOG_FROM_MANAGE = 3;
    public static final int DIALOG_FROM_UPGRADE_THREAD = 4;
    public static final int DIALOG_FROM_UPGRADE_THREAD_FAILED = 5;
    public static final int DIALOG_FROM_UPGRADE_THREAD_HAS_SAME = 6;
    public static final int F1;
    public static final int G1;
    public static final int REPLY_PAGE = 1;
    public static final int THREAD_CAN_UPGRADE = 3;
    public static final int UPDATE_TYPE_DELETE = 1;
    public static final int UPDATE_TYPE_MARK = 2;
    public static final int UPDATE_TYPE_WRITE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public c.a.p0.v0.f2.a.c A0;
    public CustomMessageListener A1;
    public TextView B;
    public PermissionJudgePolicy B0;
    public final ItemCardHelper.b B1;
    public ImageView C;
    public c.a.o0.x.w.g C0;
    public Runnable C1;
    public TBSpecificationBtn D;
    public c.a.o0.x.w.e D0;
    public CustomMessageListener D1;
    public TbImageView E;
    public EditorTools E0;
    public final View.OnLongClickListener E1;
    public View F;
    public c.a.p0.i2.k.e.u F0;
    public ValueAnimator G;
    public PbFakeFloorModel G0;
    public ValueAnimator H;
    public int[] H0;
    public FallingView I;
    public int I0;
    public TbImageView J;
    public int J0;
    public boolean K;
    public int K0;
    public View L;
    public int L0;
    public c.a.o0.s.f0.c M;
    public int M0;
    public c.a.o0.i.a N;
    public boolean N0;
    public c.a.p0.i2.k.e.b1.f.a O;
    public boolean O0;
    public EmotionImageData P;
    @NonNull
    public TiePlusEventController.d P0;
    public c.a.o0.t.e.a Q;
    public RightFloatLayerView Q0;
    public ForumManageModel R;
    public final CustomMessageListener R0;
    public VoiceManager S;
    public final PbModel.g S0;
    public c.a.e.e.k.b<GifView> T;
    public final a.InterfaceC0661a T0;
    public c.a.e.e.k.b<TextView> U;
    public c.a.o0.x.w.b U0;
    public c.a.e.e.k.b<ImageView> V;
    public final CustomMessageListener V0;
    public c.a.e.e.k.b<View> W;
    public CustomMessageListener W0;
    public c.a.e.e.k.b<LinearLayout> X;
    public final CustomMessageListener X0;
    public c.a.e.e.k.b<RelativeLayout> Y;
    public CustomMessageListener Y0;
    public boolean Z;
    public HttpMessageListener Z0;
    public LinearLayout a0;
    public CustomMessageListener a1;
    public View b0;
    public CustomMessageListener b1;
    public View c0;
    public CustomMessageListener c1;
    public c.a.o0.x.w.b d1;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f55129e;
    public final NewWriteModel.g e1;

    /* renamed from: f  reason: collision with root package name */
    public long f55130f;
    public View.OnClickListener f1;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f55131g;
    public CustomMessageListener g1;

    /* renamed from: h  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f55132h;
    public int h1;

    /* renamed from: i  reason: collision with root package name */
    public CustomViewPager f55133i;
    public LinearLayout i0;
    public float i1;

    /* renamed from: j  reason: collision with root package name */
    public VideoPbFragmentAdapter f55134j;
    public HeadImageView j0;
    public float j1;
    public View k;
    public TextView k0;
    public boolean k1;
    public View l;
    public ImageView l0;
    public boolean l1;
    public final View.OnClickListener listener;
    public VideoContainerLayout m;
    public ImageView m0;
    public View.OnTouchListener m1;
    public AppBarLayout mAppBarLayout;
    public View mBackButton;
    public c.a.p0.i2.k.e.u0 mContentProcessController;
    public c.a.p0.i2.o.g.a mDialogController;
    public c.a.p0.i0.b mDragActionManager;
    public View mMore;
    public NavigationBar mNavigationBar;
    public NewWriteModel.g mOnFloorPostWriteNewCallback;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public View mStatusBar;
    public View mStatusBarBackground;
    public c.a.p0.i2.o.e n;
    public ImageView n0;
    public GestureDetector n1;
    public ImageView o;
    public c.a.p0.i2.p.h o0;
    public GestureDetector.SimpleOnGestureListener o1;
    public SortSwitchButton.f onSwitchChangeListener;
    public c.a.p0.i2.o.k.a operableVideoContainer;
    public ImageView p;
    public TextView p0;
    public Runnable p1;
    public c.a.p0.z.a q;
    public TextView q0;
    public ObjectAnimator q1;
    public boolean r;
    public f2 r0;
    public ObjectAnimator r1;
    public View s;
    public String s0;
    public final c.a.e.a.e s1;
    public c.a.p0.i2.o.i.a t;
    public boolean t0;
    public View.OnTouchListener t1;
    public View u;
    public String u0;
    public final b.InterfaceC0895b u1;
    public View v;
    public boolean v0;
    public c.a.o0.x.w.c v1;
    public View w;
    public boolean w0;
    public View.OnClickListener w1;
    public MaskView x;
    public boolean x0;
    public final AdapterView.OnItemClickListener x1;
    public c.a.p0.i2.o.j.a y;
    public boolean y0;
    public CustomMessageListener y1;
    public View.OnClickListener z;
    public c.a.p0.v0.f2.a.c z0;
    public CustomMessageListener z1;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55135a;

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
            this.f55135a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            c.a.p0.i2.e eVar = (c.a.p0.i2.e) customResponsedMessage.getData();
            int b2 = eVar.b();
            if (b2 == 0) {
                this.f55135a.refreshWrite((c.a.p0.i2.h.r) eVar.a());
            } else if (b2 == 1) {
                this.f55135a.h1((ForumManageModel.b) eVar.a(), false);
            } else if (b2 != 2) {
            } else {
                if (eVar.a() == null) {
                    this.f55135a.refreshMark(false, null);
                } else {
                    this.f55135a.refreshMark(true, (MarkData) eVar.a());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 extends c.a.o0.b1.h0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55136a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55137b;

        public a0(AbsVideoPbFragment absVideoPbFragment, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55137b = absVideoPbFragment;
            this.f55136a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.b1.h0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel pbModel = this.f55137b.getPbModel();
                if (pbModel != null) {
                    pbModel.a2(this.f55136a);
                }
                ShareItem d2 = c.a.p0.i2.k.e.f1.b.d(this.f55137b.getContext(), this.f55137b.k1(), 2, pbModel);
                if (this.f55137b.o0 != null) {
                    d2.F = this.f55137b.o0.f();
                }
                return d2;
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55138e;

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
            this.f55138e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55138e.hideKeyBroad();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a2 implements c.a.e.e.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55139a;

        public a2(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55139a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.f55139a.getPageContext().getPageActivity());
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

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55140a;

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
            this.f55140a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f55140a.N0) {
                return;
            }
            this.f55140a.U1();
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements c.a.o0.b1.n<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55141a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55142b;

        public b0(AbsVideoPbFragment absVideoPbFragment, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55142b = absVideoPbFragment;
            this.f55141a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                shareItem.k(bundle);
                if (this.f55142b.o0 != null) {
                    shareItem.F = this.f55142b.o0.f();
                }
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f55142b.getContext(), this.f55141a, shareItem, false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55143e;

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
            this.f55143e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55143e.resetCommentView();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b2 implements c.a.e.e.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55144a;

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
            this.f55144a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.f55144a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55145a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbsVideoPbFragment absVideoPbFragment, int i2) {
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
            this.f55145a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f55145a.g2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55146e;

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
            this.f55146e = absVideoPbFragment;
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
            c.a.p0.i2.o.g.a aVar = this.f55146e.mDialogController;
            if (aVar != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 1);
                        this.f55146e.mDialogController.B(sparseArray);
                        return;
                    }
                    aVar.l0(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    sparseArray.put(R.id.tag_check_mute_from, 1);
                    this.f55146e.mDialogController.B(sparseArray);
                } else if (booleanValue3) {
                    aVar.g0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55147e;

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
            this.f55147e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55147e.Q0.inPbLastCloseTime();
                this.f55147e.hideRightFloatLayerView();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", 2).param("obj_locate", 2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c2 implements Comparator<c.a.o0.u.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55148e;

        public c2(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55148e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c.a.o0.u.a aVar, c.a.o0.u.a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) ? aVar.compareTo(aVar2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55149a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbsVideoPbFragment absVideoPbFragment, int i2, boolean z) {
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
            this.f55149a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.f55149a.getView() != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.f55149a;
                    absVideoPbFragment.hideLoadingView(absVideoPbFragment.getView());
                    this.f55149a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            new BdTopToast(this.f55149a.getContext()).setIcon(true).setContent(this.f55149a.getString(R.string.block_user_success)).show((ViewGroup) this.f55149a.getView());
                            this.f55149a.O1(type);
                            return;
                        }
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = this.f55149a.getResources().getString(R.string.neterror);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        new BdTopToast(this.f55149a.getContext()).setIcon(false).setContent(errorString).show((ViewGroup) this.f55149a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55150e;

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
            this.f55150e = absVideoPbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f55150e.getPbModel() == null || this.f55150e.getPbModel().X0() == i2 + 1) {
                return;
            }
            AbsVideoPbFragment absVideoPbFragment = this.f55150e;
            absVideoPbFragment.M1(absVideoPbFragment.m1(i2));
        }
    }

    /* loaded from: classes7.dex */
    public class d1 implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55151a;

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
            this.f55151a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f55151a.G0.M(postData);
                if (this.f55151a.getDetailInfoAndReplyFragment() != null) {
                    this.f55151a.getDetailInfoAndReplyFragment().invalidataData();
                } else if (this.f55151a.isShowDoubleTab() && this.f55151a.getReplyFragment() != null) {
                    this.f55151a.getReplyFragment().invalidataData();
                }
                this.f55151a.F0.c();
                this.f55151a.E0.hideTools();
                this.f55151a.showCommonView(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d2 implements c.a.o0.x.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55152a;

        public d2(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55152a = absVideoPbFragment;
        }

        @Override // c.a.o0.x.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.i2.k.e.u0 u0Var = this.f55152a.mContentProcessController;
                if (u0Var == null || u0Var.e() == null || !this.f55152a.mContentProcessController.e().d()) {
                    return !this.f55152a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                AbsVideoPbFragment absVideoPbFragment = this.f55152a;
                absVideoPbFragment.showToast(absVideoPbFragment.mContentProcessController.e().c());
                if (this.f55152a.D0 != null && (this.f55152a.D0.C() || this.f55152a.D0.E())) {
                    this.f55152a.D0.A(false, this.f55152a.mContentProcessController.h());
                }
                this.f55152a.mContentProcessController.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55153a;

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
            this.f55153a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f55153a.mDialogController != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.p0.t3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f55153a.mDialogController.D) {
                c.a.p0.t3.a aVar = (c.a.p0.t3.a) customResponsedMessage.getData();
                this.f55153a.mDialogController.V();
                SparseArray<Object> sparseArray = (SparseArray) this.f55153a.mDialogController.O();
                DataRes dataRes = aVar.f24431a;
                if (aVar.f24433c == 0 && dataRes != null) {
                    int d2 = c.a.e.e.m.b.d(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r2 = d2 == 1;
                    if (c.a.e.e.p.k.isEmpty(str)) {
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
                    this.f55153a.mDialogController.E0(r2, sparseArray);
                } else if (intValue == 1) {
                    this.f55153a.mDialogController.k0(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55154a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(AbsVideoPbFragment absVideoPbFragment, int i2) {
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
            this.f55154a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e.a)) {
                e.a aVar = (e.a) customResponsedMessage.getData();
                c.a.o0.d1.m.e.c(this.f55154a.getPageContext(), this.f55154a, aVar.f12949a, aVar.f12950b, aVar.f12951c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e1 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55155e;

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
            this.f55155e = absVideoPbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f55155e.mDialogController.o0(true);
                return this.f55155e.mDialogController.P().onLongClick(view);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e2 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55156a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e2(AbsVideoPbFragment absVideoPbFragment, int i2) {
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
            this.f55156a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f55156a.getPbModel() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.f55156a.D0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.f55156a;
                absVideoPbFragment.setHasDraft(absVideoPbFragment.D0.D());
            }
            this.f55156a.resetCommentView();
            this.f55156a.mDialogController.F();
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55157a;

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
            this.f55157a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f55157a.mDialogController == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            c.a.p0.i2.o.g.a aVar = this.f55157a.mDialogController;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                c.a.p0.i2.h.e O0 = this.f55157a.getPbModel().O0();
                if (O0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    O0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.f55157a.M.c(this.f55157a.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f55157a.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.f55157a.mDialogController.K0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.f55157a.mDialogController.D0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (c.a.e.e.p.k.isEmpty(errorString2)) {
                        errorString2 = this.f55157a.getResources().getString(R.string.mute_fail);
                    }
                    this.f55157a.M.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55158a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(AbsVideoPbFragment absVideoPbFragment, int i2) {
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
            this.f55158a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.p0.i3.h0.e eVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.p0.i3.h0.e) || (eVar = (c.a.p0.i3.h0.e) customResponsedMessage.getData()) == null || (agreeData = eVar.f19938b) == null || agreeData.agreeType != 2 || this.f55158a.o0 == null || this.f55158a.getPbModel() == null || !c.a.o0.b.d.Y() || c.a.p0.i2.k.e.f1.b.k(this.f55158a.getPbModel().e1())) {
                return;
            }
            this.f55158a.o0.m(2);
            c.a.p0.i2.k.e.f1.b.b(this.f55158a.getPbModel().e1());
        }
    }

    /* loaded from: classes7.dex */
    public class f1 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55159a;

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
            this.f55159a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                c.a.p0.i2.o.g.a aVar = this.f55159a.mDialogController;
                if (aVar != null) {
                    aVar.F();
                }
                boolean z = false;
                if (!c.a.e.e.p.j.z()) {
                    this.f55159a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.f55159a.getPbModel() != null && !this.f55159a.getPbModel().isLoading) {
                    this.f55159a.stopVoice();
                    this.f55159a.setPreLoad();
                    z = true;
                    if (this.f55159a.getPbModel().O0() != null && this.f55159a.getPbModel().O0().f18734f != null && this.f55159a.getPbModel().O0().f18734f.size() > i2) {
                        int intValue = this.f55159a.getPbModel().O0().f18734f.get(i2).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.f55159a.getPbModel().f1()).param("fid", this.f55159a.getPbModel().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.f55159a.getPbModel().q2(intValue)) {
                            this.f55159a.K = true;
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

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55163a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(AbsVideoPbFragment absVideoPbFragment, int i2) {
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
            this.f55163a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f55163a.mDialogController == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            c.a.p0.i2.o.g.a aVar = this.f55163a.mDialogController;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.f55163a.M.c(this.f55163a.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (c.a.e.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = this.f55163a.getResources().getString(R.string.un_mute_fail);
                }
                this.f55163a.M.b(muteMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55164a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(AbsVideoPbFragment absVideoPbFragment, int i2) {
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
            this.f55164a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921552) {
                this.f55164a.hideRightFloatLayerView();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55165a;

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
            this.f55165a = absVideoPbFragment;
        }

        @Override // c.a.p0.v0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.p0.v0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f55165a.D0 != null && this.f55165a.D0.a() != null) {
                    this.f55165a.D0.a().sendAction(new c.a.o0.x.a(45, 27, null));
                }
                this.f55165a.clickCommentReply();
            }
        }

        @Override // c.a.p0.v0.f2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements c.a.o0.x.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55166a;

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
            this.f55166a = absVideoPbFragment;
        }

        @Override // c.a.o0.x.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.i2.k.e.u0 u0Var = this.f55166a.mContentProcessController;
                if (u0Var == null || u0Var.g() == null || !this.f55166a.mContentProcessController.g().d()) {
                    return !this.f55166a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                AbsVideoPbFragment absVideoPbFragment = this.f55166a;
                absVideoPbFragment.showToast(absVideoPbFragment.mContentProcessController.g().c());
                if (this.f55166a.F0 != null && this.f55166a.F0.b() != null && this.f55166a.F0.b().x()) {
                    this.f55166a.F0.b().v(this.f55166a.mContentProcessController.h());
                }
                this.f55166a.mContentProcessController.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h0 implements Observer<c.a.o0.s.q.c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55167e;

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
            this.f55167e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable c.a.o0.s.q.c2 c2Var) {
            c.a.p0.i2.o.k.a aVar;
            BdTypeRecyclerView recyclerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, c2Var) == null) || c2Var == null || c2Var.o1() == null || (aVar = this.f55167e.operableVideoContainer) == null) {
                return;
            }
            if (aVar.f0() != null && this.f55167e.operableVideoContainer.f0().equals(c2Var.o1().video_url)) {
                this.f55167e.operableVideoContainer.setData(c2Var);
                return;
            }
            if (!c.a.e.e.p.k.isEmpty(this.f55167e.operableVideoContainer.f0())) {
                this.f55167e.y0 = true;
                if (this.f55167e.isShowDoubleTab()) {
                    this.f55167e.f55133i.setCurrentItem(0);
                } else {
                    this.f55167e.f55133i.setCurrentItem(0);
                }
                if (!this.f55167e.isShowDoubleTab() && (recyclerView = this.f55167e.getRecyclerView()) != null) {
                    recyclerView.scrollToPosition(0);
                }
            }
            if (this.f55167e.n == null || !this.f55167e.n.k()) {
                this.f55167e.K1();
                this.f55167e.b1(c2Var);
            }
            this.f55167e.x1();
            if (this.f55167e.n != null && this.f55167e.n.l()) {
                this.f55167e.n.s();
            }
            boolean z = !StringHelper.equals(this.f55167e.operableVideoContainer.f0(), c2Var.o1().video_url);
            this.f55167e.operableVideoContainer.setData(c2Var);
            if (this.f55167e.isShowDoubleTab()) {
                AbsVideoPbFragment absVideoPbFragment = this.f55167e;
                absVideoPbFragment.operableVideoContainer.U0(absVideoPbFragment.f55133i.getCurrentItem() == 0);
            } else {
                this.f55167e.operableVideoContainer.U0(false);
            }
            if (z) {
                this.f55167e.operableVideoContainer.startPlay();
                this.f55167e.operableVideoContainer.x0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55168a;

        public h1(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55168a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55169a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f55170e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f55171f;

            public a(i iVar, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55171f = iVar;
                this.f55170e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55170e == null) {
                    return;
                }
                this.f55171f.f55169a.stopFallingRedpacket();
                this.f55171f.f55169a.performFallingRedpacket(this.f55170e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.o0.s.s.a.e
            public void onClick(c.a.o0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f55172e;

            public c(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55172e = iVar;
            }

            @Override // c.a.o0.s.s.a.e
            public void onClick(c.a.o0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f55172e.f55169a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f55172e.f55169a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

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
            this.f55169a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.o0.t.c.k0 k0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f55169a.getPbModel() != null && this.f55169a.getPbModel().O0() != null) {
                        statisticItem.param("fid", this.f55169a.getPbModel().O0().n());
                    }
                    statisticItem.param("tid", this.f55169a.getPbModel().e1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.f55169a.stopVoice();
                this.f55169a.setPostPostWrite(z, postWriteCallBackData);
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
                        this.f55169a.showToast(str);
                        if (this.f55169a.D0.C() || this.f55169a.D0.E()) {
                            this.f55169a.D0.A(false, postWriteCallBackData);
                        }
                        this.f55169a.mContentProcessController.k(postWriteCallBackData);
                        return;
                    } else if (i2 == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.f55169a.mReplyPrivacyController;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.makeText(this.f55169a.getActivity(), this.f55169a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.makeText(this.f55169a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                            return;
                        }
                    } else if (postWriteCallBackData == null || !postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        if (k0Var != null || i2 == 227001) {
                            return;
                        }
                        this.f55169a.Q1(i2, antiData, str);
                        return;
                    } else {
                        c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(this.f55169a.getActivity());
                        if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                            aVar.setMessage(this.f55169a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            aVar.setMessage(postWriteCallBackData.getErrorString());
                        }
                        aVar.setNegativeButton(R.string.cancel, new b(this));
                        aVar.setPositiveButton(R.string.open_now, new c(this));
                        aVar.create(this.f55169a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    }
                }
                if (PbReplySwitch.getInOn() && this.f55169a.getPbModel() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    this.f55169a.getPbModel().X(postWriteCallBackData.getPostId());
                    if (this.f55169a.isShowDoubleTab() && this.f55169a.getReplyFragment() != null) {
                        AbsVideoPbFragment absVideoPbFragment = this.f55169a;
                        absVideoPbFragment.L0 = absVideoPbFragment.getReplyFragment().getFirstItem();
                        AbsVideoPbFragment absVideoPbFragment2 = this.f55169a;
                        absVideoPbFragment2.M0 = absVideoPbFragment2.getReplyFragment().getFirstItemOffset();
                        this.f55169a.getPbModel().X1(this.f55169a.L0, this.f55169a.M0);
                    } else if (this.f55169a.getDetailInfoAndReplyFragment() != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.f55169a;
                        absVideoPbFragment3.L0 = absVideoPbFragment3.getDetailInfoAndReplyFragment().getFirstItem();
                        AbsVideoPbFragment absVideoPbFragment4 = this.f55169a;
                        absVideoPbFragment4.M0 = absVideoPbFragment4.getDetailInfoAndReplyFragment().getFirstItemOffset();
                        this.f55169a.getPbModel().X1(this.f55169a.L0, this.f55169a.M0);
                    }
                }
                if (this.f55169a.f55133i != null) {
                    if (this.f55169a.isShowDoubleTab()) {
                        this.f55169a.f55133i.setCurrentItem(1);
                    } else {
                        this.f55169a.f55133i.setCurrentItem(0);
                    }
                }
                this.f55169a.mDialogController.F();
                this.f55169a.mContentProcessController.c();
                if (this.f55169a.D0 != null) {
                    AbsVideoPbFragment absVideoPbFragment5 = this.f55169a;
                    absVideoPbFragment5.setHasDraft(absVideoPbFragment5.D0.D());
                }
                this.f55169a.hideEditTool();
                this.f55169a.showCommonView(true);
                this.f55169a.getPbModel().l1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.f55169a.R1(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.f55169a.getPbModel().s0()) {
                        c.a.p0.i2.h.e O0 = this.f55169a.getPbModel().O0();
                        if (O0 != null && O0.O() != null && O0.O().J() != null && (userId = O0.O().J().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.f55169a.getPbModel().n2()) {
                            this.f55169a.setPreLoad();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.f55169a.getPbModel().n2()) {
                        this.f55169a.setPreLoad();
                    }
                } else if (floor != null) {
                    if (this.f55169a.isShowDoubleTab() && this.f55169a.getReplyFragment() != null) {
                        this.f55169a.getReplyFragment().invalidataData();
                    } else if (this.f55169a.getDetailInfoAndReplyFragment() != null) {
                        this.f55169a.getDetailInfoAndReplyFragment().invalidataData();
                    }
                }
                if (postWriteCallBackData.getmAdverSegmentData() != null) {
                    c.a.e.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                AbsVideoPbFragment absVideoPbFragment6 = this.f55169a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                absVideoPbFragment6.a1(z2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements Observer<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55173e;

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
            this.f55173e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                this.f55173e.f55133i.setCurrentItem(num.intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55174e;

        public i1(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55174e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55174e.resetCommentView();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55175e;

        public j(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55175e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.f55175e;
                absVideoPbFragment.showToast(absVideoPbFragment.u0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 implements Observer<c.a.o0.s.q.c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55176e;

        public j0(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55176e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable c.a.o0.s.q.c2 c2Var) {
            c.a.p0.i2.o.k.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, c2Var) == null) || (aVar = this.f55176e.operableVideoContainer) == null) {
                return;
            }
            aVar.X0(c2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class j1 implements c.a.o0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55177e;

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
            this.f55177e = absVideoPbFragment;
        }

        @Override // c.a.o0.x.b
        public void onAction(c.a.o0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f14777c;
                if (obj instanceof c.a.o0.t.c.v) {
                    if (((c.a.o0.t.c.v) obj).f() == EmotionGroupType.BIG_EMOTION || ((c.a.o0.t.c.v) aVar.f14777c).f() == EmotionGroupType.USER_COLLECT) {
                        if (this.f55177e.B0 == null) {
                            this.f55177e.B0 = new PermissionJudgePolicy();
                        }
                        this.f55177e.B0.clearRequestPermissionList();
                        this.f55177e.B0.appendRequestPermission(this.f55177e.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f55177e.B0.startRequestPermission(this.f55177e.getBaseFragmentActivity())) {
                            return;
                        }
                        this.f55177e.D0.h((c.a.o0.t.c.v) aVar.f14777c);
                        this.f55177e.D0.A(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55178e;

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
            this.f55178e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f55178e.t == null || this.f55178e.t.q()) {
                    if (this.f55178e.t != null) {
                        if (!this.f55178e.t.l) {
                            if (this.f55178e.t.q != null) {
                                YYLiveUtil.jumpToYYLiveRoom(this.f55178e.getPageContext(), this.f55178e.t.q.mSid, this.f55178e.t.q.mSsid, this.f55178e.t.q.mTemplateId, "", YYLiveUtil.SOURCE_PB_LIVE_BANNER);
                            }
                        } else {
                            AbsVideoPbFragment absVideoPbFragment = this.f55178e;
                            absVideoPbFragment.z1(absVideoPbFragment.t.n, this.f55178e.t.m);
                        }
                        if (this.f55178e.getPbModel() == null || this.f55178e.getPbModel().O0() == null || this.f55178e.getPbModel().O0().m() == null) {
                            return;
                        }
                        StatisticItem param = new StatisticItem("c13713").param("fid", this.f55178e.getPbModel().O0().m().getId()).param("fname", this.f55178e.getPbModel().O0().m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f55178e.getPbModel().O0().Q()).param("obj_param1", this.f55178e.t.o);
                        if (this.f55178e.getPbModel().O0().O() != null) {
                            c.a.o0.s.q.c2 O = this.f55178e.getPbModel().O0().O();
                            int calculateLiveType = YYLiveUtil.calculateLiveType(O.j1());
                            AlaInfoData j1 = O.j1();
                            String str = TiebaStatic.YYValues.YY_LIVE;
                            if (j1 == null || !O.j1().isLegalYYLiveData()) {
                                if (this.f55178e.t.q != null) {
                                    TiebaStaticHelper.addYYParam(param, this.f55178e.t.q);
                                    calculateLiveType = YYLiveUtil.calculateLiveType(this.f55178e.t.q);
                                } else {
                                    str = "";
                                }
                            } else {
                                TiebaStaticHelper.addYYParam(param, O.j1().mYyExtData);
                            }
                            param.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                            param.param(TiebaStatic.Params.OBJ_PARAM3, str);
                        }
                        TiebaStatic.log(param);
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13590").param("obj_id", this.f55178e.t.getTitle()).param("obj_name", this.f55178e.t.p()).param("obj_type", 2).param("fid", this.f55178e.getPbModel().O0().n()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f55178e.getPbModel().O0().Q()));
                String k = this.f55178e.t.k();
                if (TextUtils.isEmpty(k)) {
                    return;
                }
                if (!URLUtil.isHttpUrl(k) && !URLUtil.isHttpsUrl(k)) {
                    Uri parse = Uri.parse(k);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(this.f55178e.getActivity(), parse.toString());
                        return;
                    }
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f55178e.getPageContext(), new String[]{k});
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k0 implements Observer<c.a.o0.s.q.c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55179e;

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
            this.f55179e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable c.a.o0.s.q.c2 c2Var) {
            c.a.p0.i2.o.k.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, c2Var) == null) || (aVar = this.f55179e.operableVideoContainer) == null) {
                return;
            }
            aVar.W0(c2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class k1 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55180e;

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
            this.f55180e = absVideoPbFragment;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            c.a.p0.i2.k.e.u0 u0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f55180e.mContentProcessController) == null || u0Var.e() == null) {
                return;
            }
            if (!this.f55180e.mContentProcessController.e().e()) {
                this.f55180e.mContentProcessController.a(false);
            }
            this.f55180e.mContentProcessController.e().l(false);
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
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) != null) || this.f55180e.E0 == null || this.f55180e.E0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2) || TextUtils.isEmpty(charSequence.toString().substring(i2, i5))) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55181a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(AbsVideoPbFragment absVideoPbFragment, int i2) {
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
            this.f55181a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f55181a.D0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.f55181a;
                absVideoPbFragment.setHasDraft(absVideoPbFragment.D0.D());
            }
            this.f55181a.showCommonView(false);
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55182e;

        public l0(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55182e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f55182e.J1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55183e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f55184f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55185g;

        /* loaded from: classes7.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l1 f55186e;

            public a(l1 l1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55186e = l1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.a.p0.i2.k.e.u0 u0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f55186e.f55185g.mContentProcessController) == null || u0Var.g() == null) {
                    return;
                }
                if (!this.f55186e.f55185g.mContentProcessController.g().e()) {
                    this.f55186e.f55185g.mContentProcessController.b(false);
                }
                this.f55186e.f55185g.mContentProcessController.g().l(false);
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

        public l1(AbsVideoPbFragment absVideoPbFragment, String str, String str2) {
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
            this.f55185g = absVideoPbFragment;
            this.f55183e = str;
            this.f55184f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = c.a.e.e.p.l.i(this.f55185g.f55129e.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = c.a.e.e.p.l.g(this.f55185g.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i2 = i3 / 2;
                    g2 = c.a.e.e.p.l.g(this.f55185g.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i4 = i3 - (i2 + g2);
                AbsVideoPbFragment absVideoPbFragment = this.f55185g;
                boolean z = true;
                int i5 = (absVideoPbFragment.H0[1] + absVideoPbFragment.I0) - i4;
                if (absVideoPbFragment.getRecyclerView() != null) {
                    this.f55185g.getRecyclerView().smoothScrollBy(0, i5);
                }
                if (this.f55185g.F0 != null) {
                    this.f55185g.D0.a().setVisibility(8);
                    this.f55185g.F0.n(this.f55183e, this.f55184f, this.f55185g.getReplyHint(), (this.f55185g.getPbModel() == null || this.f55185g.getPbModel().O0() == null || this.f55185g.getPbModel().O0().O() == null || !this.f55185g.getPbModel().O0().O().N1()) ? false : false);
                    c.a.o0.x.w.h b2 = this.f55185g.F0.b();
                    if (b2 != null && this.f55185g.getPbModel() != null && this.f55185g.getPbModel().O0() != null) {
                        b2.G(this.f55185g.getPbModel().O0().d());
                        b2.a0(this.f55185g.getPbModel().O0().O());
                    }
                    if (this.f55185g.mContentProcessController.f() == null && this.f55185g.F0.b().u() != null) {
                        this.f55185g.F0.b().u().g(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.f55185g;
                        absVideoPbFragment2.mContentProcessController.n(absVideoPbFragment2.F0.b().u().i());
                        this.f55185g.F0.b().M(this.f55185g.d1);
                    }
                }
                this.f55185g.hideCommonView();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55187e;

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
            this.f55187e = absVideoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return this.f55187e.n1 != null && this.f55187e.n1.onTouchEvent(motionEvent);
                }
                if (this.f55187e.h1 == 1) {
                    if (!this.f55187e.l1) {
                        this.f55187e.Y1();
                        UtilHelper.showStatusBar(this.f55187e.getPbActivity(), this.f55187e.getPbActivity().getRootView());
                        this.f55187e.l1 = true;
                        c.a.e.e.m.e.a().removeCallbacks(this.f55187e.p1);
                        c.a.e.e.m.e.a().postDelayed(this.f55187e.p1, 3000L);
                    }
                } else if (this.f55187e.h1 == 2 && (this.f55187e.l1 || this.f55187e.y1())) {
                    this.f55187e.X1();
                    UtilHelper.hideStatusBar(this.f55187e.getPbActivity(), this.f55187e.getPbActivity().getRootView());
                    this.f55187e.l1 = false;
                    c.a.p0.i2.o.k.a aVar = this.f55187e.operableVideoContainer;
                    if (aVar != null) {
                        aVar.V0(false);
                    }
                }
                this.f55187e.h1 = 0;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55188e;

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
            this.f55188e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f55188e.setNavigationBarVisibility(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55189a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f55190b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55191c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m1 f55192e;

            /* renamed from: com.baidu.tieba.pb.videopb.AbsVideoPbFragment$m1$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1787a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f55193e;

                public C1787a(a aVar) {
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
                    this.f55193e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    c.a.p0.i2.k.e.u0 u0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f55193e.f55192e.f55191c.mContentProcessController) == null || u0Var.g() == null) {
                        return;
                    }
                    if (!this.f55193e.f55192e.f55191c.mContentProcessController.g().e()) {
                        this.f55193e.f55192e.f55191c.mContentProcessController.b(false);
                    }
                    this.f55193e.f55192e.f55191c.mContentProcessController.g().l(false);
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

            public a(m1 m1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55192e = m1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int g2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = c.a.e.e.p.l.i(this.f55192e.f55191c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g2 = c.a.e.e.p.l.g(this.f55192e.f55191c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    } else {
                        i2 = i3 / 2;
                        g2 = c.a.e.e.p.l.g(this.f55192e.f55191c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    }
                    int i4 = i3 - (i2 + g2);
                    AbsVideoPbFragment absVideoPbFragment = this.f55192e.f55191c;
                    boolean z = true;
                    int i5 = (absVideoPbFragment.H0[1] + absVideoPbFragment.I0) - i4;
                    if (absVideoPbFragment.getRecyclerView() != null) {
                        this.f55192e.f55191c.getRecyclerView().smoothScrollBy(0, i5);
                    }
                    if (this.f55192e.f55191c.F0 != null) {
                        this.f55192e.f55191c.D0.a().setVisibility(8);
                        z = (this.f55192e.f55191c.getPbModel() == null || this.f55192e.f55191c.getPbModel().O0() == null || this.f55192e.f55191c.getPbModel().O0().O() == null || !this.f55192e.f55191c.getPbModel().O0().O().N1()) ? false : false;
                        c.a.p0.i2.k.e.u uVar = this.f55192e.f55191c.F0;
                        m1 m1Var = this.f55192e;
                        uVar.n(m1Var.f55189a, m1Var.f55190b, m1Var.f55191c.getReplyHint(), z);
                        c.a.o0.x.w.h b2 = this.f55192e.f55191c.F0.b();
                        if (b2 != null && this.f55192e.f55191c.getPbModel() != null && this.f55192e.f55191c.getPbModel().O0() != null) {
                            b2.G(this.f55192e.f55191c.getPbModel().O0().d());
                            b2.a0(this.f55192e.f55191c.getPbModel().O0().O());
                        }
                        if (this.f55192e.f55191c.mContentProcessController.f() == null && this.f55192e.f55191c.F0.b().u() != null) {
                            this.f55192e.f55191c.F0.b().u().g(new C1787a(this));
                            AbsVideoPbFragment absVideoPbFragment2 = this.f55192e.f55191c;
                            absVideoPbFragment2.mContentProcessController.n(absVideoPbFragment2.F0.b().u().i());
                            this.f55192e.f55191c.F0.b().M(this.f55192e.f55191c.d1);
                        }
                    }
                    this.f55192e.f55191c.hideCommonView();
                }
            }
        }

        public m1(AbsVideoPbFragment absVideoPbFragment, String str, String str2) {
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
            this.f55191c = absVideoPbFragment;
            this.f55189a = str;
            this.f55190b = str2;
        }

        @Override // c.a.p0.v0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.p0.v0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                c.a.e.e.m.e.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // c.a.p0.v0.f2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55194e;

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
            this.f55194e = absVideoPbFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f55194e.h1 = 0;
                this.f55194e.i1 = 0.0f;
                this.f55194e.j1 = 0.0f;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            c.a.p0.i2.o.k.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f55194e.i1 += f2;
                this.f55194e.j1 += f3;
                if (this.f55194e.h1 == 0 && !this.f55194e.k1 && (aVar = this.f55194e.operableVideoContainer) != null && !aVar.isFullScreen()) {
                    int height = this.f55194e.mNavigationBar.getHeight();
                    if (motionEvent.getY() < 0.0f || Math.abs(this.f55194e.j1) <= Math.abs(this.f55194e.i1) || this.f55194e.j1 > (-height) / 5) {
                        if (Math.abs(this.f55194e.j1) > Math.abs(this.f55194e.i1) && this.f55194e.j1 > 0.0f && f3 > 0.0f) {
                            this.f55194e.h1 = 2;
                        }
                    } else {
                        this.f55194e.h1 = 1;
                    }
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbViewModel f55195e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55196f;

        public n0(AbsVideoPbFragment absVideoPbFragment, VideoPbViewModel videoPbViewModel) {
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
            this.f55196f = absVideoPbFragment;
            this.f55195e = videoPbViewModel;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (!c.a.o0.e1.b.e.d() && this.f55196f.isShowDoubleTab() && (this.f55195e.isJumpCommentTab() || this.f55196f.getPbModel().d1() == 1)) {
                    this.f55196f.f55133i.setCurrentItem(1);
                } else if (this.f55195e.isJumpCommentTab() || this.f55196f.getPbModel().d1() == 0) {
                    this.f55196f.f55133i.setCurrentItem(0);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (!c.a.o0.e1.b.e.d() && this.f55196f.isShowDoubleTab() && (this.f55195e.isJumpCommentTab() || this.f55196f.getPbModel().d1() == 1)) {
                    this.f55196f.f55133i.setCurrentItem(1);
                } else if (this.f55195e.isJumpCommentTab() || this.f55196f.getPbModel().d1() == 0) {
                    this.f55196f.f55133i.setCurrentItem(0);
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

    /* loaded from: classes7.dex */
    public class n1 implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55197a;

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
            this.f55197a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j2)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(c.a.p0.i2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, c.a.p0.i2.h.e eVar, String str, int i5) {
            String replyHint;
            c.a.o0.x.h findLauncherById;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
                this.f55197a.setPostPro();
                this.f55197a.hideProgressView();
                if (this.f55197a.K) {
                    this.f55197a.K = false;
                }
                this.f55197a.showCommonView(false);
                if (z && eVar != null) {
                    c.a.o0.s.q.c2 O = eVar.O();
                    ((VideoPbViewModel) ViewModelProviders.of(this.f55197a.getActivity()).get(VideoPbViewModel.class)).setData(eVar, i3);
                    this.f55197a.I1(eVar);
                    this.f55197a.S1(eVar);
                    this.f55197a.refreshTabText(eVar);
                    this.f55197a.refreshAll(z, i2, i3, i4, eVar, str, i5);
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.U().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.U().getBimg_end_time());
                    if (eVar.F() != null && eVar.F().size() >= 1 && eVar.F().get(0) != null) {
                        this.f55197a.getPbModel().Y1(eVar.F().get(0).E());
                    } else if (eVar.W() != null) {
                        this.f55197a.getPbModel().Y1(eVar.W().E());
                    }
                    if (this.f55197a.N != null) {
                        this.f55197a.N.h(eVar.s());
                    }
                    AntiData d2 = eVar.d();
                    if (d2 != null) {
                        this.f55197a.u0 = d2.getVoice_message();
                        if (!StringUtils.isNull(this.f55197a.u0) && this.f55197a.D0 != null && this.f55197a.D0.a() != null && (findLauncherById = this.f55197a.D0.a().findLauncherById(6)) != null && !TextUtils.isEmpty(this.f55197a.u0)) {
                            ((View) findLauncherById).setOnClickListener(this.f55197a.f1);
                        }
                    }
                    if (this.f55197a.mReplyPrivacyController != null && O != null && O.J() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.J());
                        this.f55197a.mReplyPrivacyController.setLikeUserData(attentionHostData);
                    }
                    this.f55197a.initRightFloatLayerView(eVar);
                    if (this.f55197a.getPbModel() != null && this.f55197a.getPbModel().n1()) {
                        replyHint = this.f55197a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else {
                        replyHint = this.f55197a.getReplyHint();
                    }
                    if (!StringUtils.isNull(replyHint)) {
                        this.f55197a.D0.l0(TbSingleton.getInstance().getAdVertiComment(eVar.j0(), eVar.k0(), replyHint));
                    }
                } else {
                    if (i2 == 4 || i2 == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.f55197a.getPbModel().e1());
                            jSONObject.put("fid", this.f55197a.getPbModel().getForumId());
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
                    if ((this.f55197a.isShowDoubleTab() && this.f55197a.getReplyFragment() == null) || this.f55197a.getDetailInfoAndReplyFragment() == null) {
                        return;
                    }
                    ArrayList<PostData> arrayList = null;
                    if (this.f55197a.isShowDoubleTab()) {
                        if (i2 != -1) {
                            if (this.f55197a.getPbModel() != null && this.f55197a.getPbModel().O0() != null) {
                                arrayList = this.f55197a.getPbModel().O0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f55197a.getReplyFragment().setEndText(this.f55197a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.f55197a.getReplyFragment().isHostOnlyMode()) {
                                this.f55197a.getReplyFragment().setEndTextWithNoData(this.f55197a.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                this.f55197a.getReplyFragment().setEndTextWithNoData(this.f55197a.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            this.f55197a.getReplyFragment().setEndText("");
                        }
                        this.f55197a.getReplyFragment().endLoadData();
                    } else {
                        if (i2 != -1) {
                            if (this.f55197a.getPbModel() != null && this.f55197a.getPbModel().O0() != null) {
                                arrayList = this.f55197a.getPbModel().O0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f55197a.getDetailInfoAndReplyFragment().setEndText(this.f55197a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.f55197a.getDetailInfoAndReplyFragment().isHostOnlyMode()) {
                                this.f55197a.getDetailInfoAndReplyFragment().setEndTextWithNoData(this.f55197a.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                this.f55197a.getDetailInfoAndReplyFragment().setEndTextWithNoData(this.f55197a.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            this.f55197a.getDetailInfoAndReplyFragment().setEndText("");
                        }
                        this.f55197a.getDetailInfoAndReplyFragment().endLoadData();
                    }
                }
                c.a.p0.h3.c.g().h(this.f55197a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55198e;

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
            this.f55198e = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f55198e.l1 && !this.f55198e.y1()) {
                this.f55198e.X1();
                UtilHelper.hideStatusBar(this.f55198e.getPbActivity(), this.f55198e.getPbActivity().getRootView());
                this.f55198e.l1 = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55199a;

        public o0(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55199a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.f55199a.D0.M(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.f55199a.F0 != null && this.f55199a.F0.b() != null) {
                    this.f55199a.F0.b().F();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    AbsVideoPbFragment absVideoPbFragment = this.f55199a;
                    absVideoPbFragment.L1(absVideoPbFragment.P);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55200e;

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
            this.f55200e = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f55200e.t == null || this.f55200e.t.q()) {
                    if (this.f55200e.t != null && this.f55200e.getPbModel() != null && this.f55200e.getPbModel().O0() != null && this.f55200e.getPbModel().O0().m() != null) {
                        TiebaStatic.log(new StatisticItem("c13712").param("fid", this.f55200e.getPbModel().O0().m().getId()).param("fname", this.f55200e.getPbModel().O0().m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f55200e.getPbModel().O0().Q()).param("obj_param1", this.f55200e.t.o));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13608").param("obj_id", this.f55200e.t.getTitle()).param("obj_name", this.f55200e.t.p()).param("obj_type", 2).param("fid", this.f55200e.getPbModel().O0().n()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f55200e.getPbModel().O0().Q()));
                }
                this.f55200e.W1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55201a;

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
            this.f55201a = absVideoPbFragment;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.f55201a.getPbModel() != null) {
                    switch (this.f55201a.R.getLoadDataMode()) {
                        case 0:
                            this.f55201a.getPbModel().l1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.f55201a.h1(bVar, (bVar.f56804e != 1002 || bVar.f56805f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.f55201a.finishForumManageProcess(1, dVar.f56808a, dVar.f56809b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.f55201a;
                            absVideoPbFragment.i1(absVideoPbFragment.R.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.f55201a;
                            absVideoPbFragment2.finishForumManageProcess(absVideoPbFragment2.R.getLoadDataMode(), gVar.f56822a, gVar.f56823b, false);
                            this.f55201a.mDialogController.f0(gVar.f56824c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.f55201a;
                absVideoPbFragment3.finishForumManageProcess(absVideoPbFragment3.R.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55202a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(AbsVideoPbFragment absVideoPbFragment, int i2) {
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
            this.f55202a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.j(this.f55202a.f55129e, this.f55202a.f55129e.getUniqueId(), (View) customResponsedMessage.getData(), this.f55202a.f55131g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55203e;

        public p1(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55203e = absVideoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f55203e.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55204e;

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
            this.f55204e = absVideoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f55204e.mDragActionManager.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class q0 implements ItemCardHelper.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55205a;

        public q0(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55205a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.u(this.f55205a.f55129e, ItemCardHelper.OrderTipStatus.FAIL, this.f55205a.f55131g);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.u(this.f55205a.f55129e, ItemCardHelper.OrderTipStatus.SUCCESS, this.f55205a.f55131g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f55206e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55207f;

        public q1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams) {
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
            this.f55207f = absVideoPbFragment;
            this.f55206e = layoutParams;
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
                this.f55207f.f2(this.f55206e);
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

    /* loaded from: classes7.dex */
    public class r implements b.InterfaceC0895b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55208a;

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
            this.f55208a = absVideoPbFragment;
        }

        @Override // c.a.p0.i0.b.InterfaceC0895b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.p0.i2.i.b.d();
                } else {
                    c.a.p0.i2.i.b.c();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55209e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55210f;

        public r0(AbsVideoPbFragment absVideoPbFragment, String str) {
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
            this.f55210f = absVideoPbFragment;
            this.f55209e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55210f.Q0.inPbLastCloseTime();
                if (!StringUtils.isNull(this.f55209e)) {
                    this.f55210f.A1(this.f55209e);
                }
                this.f55210f.hideRightFloatLayerView();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2).param("obj_param1", 0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f55211e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f55212f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f55213g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55214h;

        public r1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i2) {
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
            this.f55214h = absVideoPbFragment;
            this.f55211e = layoutParams;
            this.f55212f = layoutParams2;
            this.f55213g = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.F1);
                this.f55211e.height = floatValue;
                this.f55212f.height = (this.f55213g - AbsVideoPbFragment.F1) + floatValue;
                this.f55214h.s.setLayoutParams(this.f55211e);
                this.f55214h.mAppBarLayout.setLayoutParams(this.f55212f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55215e;

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
            this.f55215e = absVideoPbFragment;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55216e;

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
            this.f55216e = absVideoPbFragment;
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
                    if (this.f55216e.getDetailInfoAndReplyFragment() != null) {
                        this.f55216e.getDetailInfoAndReplyFragment().receiveFling(false);
                    } else if (this.f55216e.isShowDoubleTab() && this.f55216e.getReplyFragment() != null) {
                        this.f55216e.getReplyFragment().receiveFling(false);
                    }
                    if (this.f55216e.getDetailInfoFragment() != null) {
                        this.f55216e.getDetailInfoFragment().receiveFling(true);
                        AbsVideoPbFragment absVideoPbFragment = this.f55216e;
                        absVideoPbFragment.setShadowVisible(absVideoPbFragment.getDetailInfoFragment().getRecyclerViewState() == 0 ? 8 : 0);
                        this.f55216e.a0.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.f55216e.getActivity()).get(VideoPbViewModel.class);
                    z = (videoPbViewModel.getIsDetailTabTop() == null || videoPbViewModel.getIsDetailTabTop().getValue() == null || !videoPbViewModel.getIsDetailTabTop().getValue().booleanValue()) ? false : false;
                    c.a.p0.i2.o.k.a aVar = this.f55216e.operableVideoContainer;
                    if (aVar != null) {
                        aVar.U0(z);
                    }
                    this.f55216e.resetCommentView();
                    if (this.f55216e.getPbModel() != null && this.f55216e.getPbModel().O0() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.f55216e.getPbModel().e1()).param("fid", this.f55216e.getPbModel().O0().n()));
                    }
                } else {
                    if (this.f55216e.getDetailInfoFragment() != null) {
                        this.f55216e.getDetailInfoFragment().receiveFling(false);
                    }
                    if (this.f55216e.getDetailInfoAndReplyFragment() != null) {
                        this.f55216e.getDetailInfoAndReplyFragment().receiveFling(true);
                        int recyclerViewState = this.f55216e.getDetailInfoAndReplyFragment().getRecyclerViewState();
                        int multiNestedLayoutState = this.f55216e.getDetailInfoAndReplyFragment().getMultiNestedLayoutState();
                        if (recyclerViewState != 0) {
                            this.f55216e.setShadowVisible(8);
                            this.f55216e.getDetailInfoAndReplyFragment().setShadowVisible(0);
                        } else if (multiNestedLayoutState != 0) {
                            this.f55216e.getDetailInfoAndReplyFragment().setShadowVisible(8);
                            this.f55216e.setShadowVisible(0);
                        } else {
                            this.f55216e.getDetailInfoAndReplyFragment().setShadowVisible(8);
                            this.f55216e.setShadowVisible(8);
                        }
                    } else if (this.f55216e.getReplyFragment() != null) {
                        this.f55216e.getReplyFragment().receiveFling(true);
                        int recyclerViewState2 = this.f55216e.getReplyFragment().getRecyclerViewState();
                        int multiNestedLayoutState2 = this.f55216e.getReplyFragment().getMultiNestedLayoutState();
                        if (recyclerViewState2 != 0) {
                            this.f55216e.setShadowVisible(8);
                            this.f55216e.getReplyFragment().setShadowVisible(0);
                        } else if (multiNestedLayoutState2 != 0) {
                            this.f55216e.getReplyFragment().setShadowVisible(8);
                            this.f55216e.setShadowVisible(0);
                        } else {
                            this.f55216e.getReplyFragment().setShadowVisible(8);
                            this.f55216e.setShadowVisible(8);
                        }
                        this.f55216e.a0.setVisibility(0);
                    }
                    c.a.p0.i2.o.k.a aVar2 = this.f55216e.operableVideoContainer;
                    if (aVar2 != null) {
                        aVar2.U0(false);
                    }
                    this.f55216e.mAppBarLayout.setExpanded(false, true);
                    if (this.f55216e.getPbModel() != null && this.f55216e.getPbModel().O0() != null) {
                        TiebaStatic.log(new StatisticItem("c13593").param("tid", this.f55216e.getPbModel().e1()).param("fid", this.f55216e.getPbModel().O0().n()));
                    }
                }
                this.f55216e.f55134j.setItemPrimary(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55217e;

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
            this.f55217e = absVideoPbFragment;
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
                this.f55217e.s.setVisibility(8);
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

    /* loaded from: classes7.dex */
    public class t implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55218a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f55219e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ t f55220f;

            public a(t tVar, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55220f = tVar;
                this.f55219e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55219e == null) {
                    return;
                }
                this.f55220f.f55218a.stopFallingRedpacket();
                this.f55220f.f55218a.performFallingRedpacket(this.f55219e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes7.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.o0.s.s.a.e
            public void onClick(c.a.o0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t f55221e;

            public c(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55221e = tVar;
            }

            @Override // c.a.o0.s.s.a.e
            public void onClick(c.a.o0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f55221e.f55218a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f55221e.f55218a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public t(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55218a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.o0.t.c.k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f55218a.getPbModel() != null && this.f55218a.getPbModel().O0() != null) {
                        statisticItem.param("fid", this.f55218a.getPbModel().O0().n());
                    }
                    if (this.f55218a.getPbModel() != null) {
                        statisticItem.param("tid", this.f55218a.getPbModel().e1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    c.a.p0.i2.k.e.u0 u0Var = this.f55218a.mContentProcessController;
                    if (u0Var != null) {
                        u0Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        c.a.o0.t.h.b.a(this.f55218a.getPageContext(), postWriteCallBackData);
                    }
                    if (postWriteCallBackData.getmAdverSegmentData() != null) {
                        c.a.e.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                        return;
                    }
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f55218a.mReplyPrivacyController;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.f55218a.getActivity(), this.f55218a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.f55218a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(this.f55218a.getActivity());
                    if (c.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f55218a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new b(this));
                    aVar.setPositiveButton(R.string.open_now, new c(this));
                    aVar.create(this.f55218a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment = this.f55218a;
                if (absVideoPbFragment.mContentProcessController == null) {
                    return;
                }
                if (absVideoPbFragment.F0 != null && this.f55218a.F0.b() != null && this.f55218a.F0.b().x()) {
                    this.f55218a.F0.b().v(postWriteCallBackData);
                }
                this.f55218a.mContentProcessController.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t0 extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.u.a f55222a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f55223b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55224c;

        public t0(AbsVideoPbFragment absVideoPbFragment, c.a.o0.u.a aVar, int i2) {
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
            this.f55224c = absVideoPbFragment;
            this.f55222a = aVar;
            this.f55223b = i2;
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
                this.f55224c.startFallingRedpacketAnimation(this.f55222a, bitmap, this.f55223b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f55225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f55226f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f55227g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55228h;

        public t1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i2) {
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
            this.f55228h = absVideoPbFragment;
            this.f55225e = layoutParams;
            this.f55226f = layoutParams2;
            this.f55227g = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.F1);
                this.f55225e.height = floatValue;
                this.f55226f.height = this.f55227g + floatValue;
                this.f55228h.s.setLayoutParams(this.f55225e);
                this.f55228h.mAppBarLayout.setLayoutParams(this.f55226f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f55229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f55230f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.s.s.a f55231g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55232h;

        public u(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, c.a.o0.s.s.a aVar) {
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
            this.f55232h = absVideoPbFragment;
            this.f55229e = markData;
            this.f55230f = markData2;
            this.f55231g = aVar;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f55232h.N != null) {
                    if (this.f55232h.N.e()) {
                        this.f55232h.N.d();
                        this.f55232h.N.h(false);
                    }
                    this.f55232h.N.i(this.f55229e);
                    this.f55232h.N.h(true);
                    this.f55232h.N.a();
                }
                this.f55230f.setPostId(this.f55229e.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f55230f);
                this.f55232h.f55129e.setResult(-1, intent);
                this.f55231g.dismiss();
                this.f55232h.a2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements c.InterfaceC0939c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Random f55233a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55234b;

        public u0(AbsVideoPbFragment absVideoPbFragment, Random random) {
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
            this.f55234b = absVideoPbFragment;
            this.f55233a = random;
        }

        @Override // c.a.p0.i2.p.c.InterfaceC0939c
        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f55233a.nextInt(2) * 0.1f) + 0.8f : invokeV.floatValue;
        }
    }

    /* loaded from: classes7.dex */
    public class u1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55235e;

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
            this.f55235e = absVideoPbFragment;
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
                this.f55235e.d2();
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

    /* loaded from: classes7.dex */
    public class v implements TiePlusEventController.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55236a;

        public v(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55236a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.d
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55236a.Z = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.u.a f55237e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55238f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55239g;

        public v0(AbsVideoPbFragment absVideoPbFragment, c.a.o0.u.a aVar, int i2) {
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
            this.f55239g = absVideoPbFragment;
            this.f55237e = aVar;
            this.f55238f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<BaseFragmentActivity> pageContext = this.f55239g.getPageContext();
                urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + c.a.e.e.p.k.getUrlEncode(this.f55237e.d())});
                TiebaStatic.log(new StatisticItem("c14126").param("obj_type", this.f55238f).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55240e;

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
            this.f55240e = absVideoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f55240e.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f55241e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.s.s.a f55242f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55243g;

        public w(AbsVideoPbFragment absVideoPbFragment, MarkData markData, c.a.o0.s.s.a aVar) {
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
            this.f55243g = absVideoPbFragment;
            this.f55241e = markData;
            this.f55242f = aVar;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.f55241e);
                this.f55243g.f55129e.setResult(-1, intent);
                this.f55242f.dismiss();
                this.f55243g.a2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55244e;

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
            this.f55244e = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55244e.J == null) {
                return;
            }
            c.a.p0.i2.p.d.b(this.f55244e.J);
        }
    }

    /* loaded from: classes7.dex */
    public class w1 implements c.a.e.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55245a;

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
            this.f55245a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
                    if (c.a.o0.s.k.c().g()) {
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
        @Override // c.a.e.e.k.c
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
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f55245a.getPageContext().getPageActivity());
                boolean g2 = c.a.o0.s.k.c().g();
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
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.reset();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class x implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55246e;

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
            this.f55246e = absVideoPbFragment;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55247e;

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
            this.f55247e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f55247e.t == null || this.f55247e.t.q()) {
                    if (this.f55247e.t != null) {
                        TiebaStatic.log(new StatisticItem("c13608").param("tid", this.f55247e.getPbModel().O0().Q()));
                        this.f55247e.t.p = true;
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13591"));
                }
                this.f55247e.V1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x1 implements c.a.e.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55248a;

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
            this.f55248a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
                if (c.a.o0.s.k.c().g()) {
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
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.onDestroy();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.f55248a.getPageContext().getPageActivity());
                boolean g2 = c.a.o0.s.k.c().g();
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
                gifView.release();
                gifView.onDestroy();
                gifView.setImageDrawable(null);
                gifView.resetDefaultNoImageDay();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class y implements c.a.o0.x.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55249a;

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
            this.f55249a = absVideoPbFragment;
        }

        @Override // c.a.o0.x.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55249a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55250e;

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
            this.f55250e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new c.a.o0.s.q.t0(this.f55250e.getActivity(), "pb_huitie"))) {
                this.f55250e.expandVideo(false);
                this.f55250e.processProfessionPermission();
                if (this.f55250e.getPbModel() == null || this.f55250e.getPbModel().O0() == null || this.f55250e.getPbModel().O0().O() == null || this.f55250e.getPbModel().O0().O().J() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f55250e.getPbModel().f1()).param("fid", this.f55250e.getPbModel().O0().n()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f55250e.getPbModel().e1()).param("fid", this.f55250e.getPbModel().O0().n()).param("obj_locate", 1).param("uid", this.f55250e.getPbModel().O0().O().J().getUserId()));
                if (this.f55250e.isCommentFloatPage()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", this.f55250e.getPbModel().getForumId());
                    statisticItem.param("tid", this.f55250e.getPbModel().e1());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", this.f55250e.l1());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 11);
                    statisticItem.param("obj_locate", this.f55250e.getFromVideoPageType());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y1 implements a.InterfaceC0661a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55251a;

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
            this.f55251a = absVideoPbFragment;
        }

        @Override // c.a.o0.i.a.InterfaceC0661a
        public void a(boolean z, boolean z2, String str) {
            c.a.o0.s.q.c2 O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.f55251a.setPostPro();
                if (z && this.f55251a.getPbModel() != null) {
                    if (this.f55251a.N != null) {
                        this.f55251a.N.h(z2);
                    }
                    this.f55251a.getPbModel().m2(z2);
                    if (this.f55251a.getPbModel().O0() != null && (O = this.f55251a.getPbModel().O0().O()) != null) {
                        if (z2) {
                            O.K2++;
                        } else {
                            int i2 = O.K2;
                            if (i2 > 0) {
                                O.K2 = i2 - 1;
                            }
                        }
                    }
                    if (this.f55251a.getPbModel().A0()) {
                        this.f55251a.D1();
                    } else if (this.f55251a.isShowDoubleTab()) {
                        if (this.f55251a.getDetailInfoFragment() != null) {
                            this.f55251a.getDetailInfoFragment().invalidataData();
                        }
                        if (this.f55251a.getReplyFragment() != null) {
                            this.f55251a.getReplyFragment().invalidataData();
                        }
                    } else if (this.f55251a.getDetailInfoAndReplyFragment() != null) {
                        this.f55251a.getDetailInfoAndReplyFragment().invalidataData();
                    }
                    if (z2) {
                        if (this.f55251a.N != null) {
                            if (this.f55251a.N.f() == null || this.f55251a.getPbModel() == null || this.f55251a.getPbModel().O0() == null || this.f55251a.getPbModel().O0().O() == null || this.f55251a.getPbModel().O0().O().J() == null) {
                                return;
                            }
                            MarkData f2 = this.f55251a.N.f();
                            MetaData J = this.f55251a.getPbModel().O0().O().J();
                            if (f2 != null && J != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), J.getUserId()) && !J.hadConcerned()) {
                                    this.f55251a.mDialogController.A0(J);
                                } else {
                                    this.f55251a.showToast(R.string.add_mark_on_pb);
                                }
                            } else {
                                AbsVideoPbFragment absVideoPbFragment = this.f55251a;
                                absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(R.string.add_mark));
                            }
                        }
                        this.f55251a.Z0();
                        return;
                    }
                    AbsVideoPbFragment absVideoPbFragment2 = this.f55251a;
                    absVideoPbFragment2.showToast(absVideoPbFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.f55251a;
                absVideoPbFragment3.showToast(absVideoPbFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55252e;

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
            this.f55252e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            StatisticItem statisticItem;
            StatisticItem statisticItem2;
            int top;
            String str;
            int i2;
            int i3;
            String b2;
            boolean p2;
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.f55252e.isAdded()) {
                int i5 = 1;
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem3 = new StatisticItem("c13398");
                    statisticItem3.param("tid", this.f55252e.getPbModel().e1());
                    statisticItem3.param("fid", this.f55252e.getPbModel().getForumId());
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem3.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem3);
                    if (this.f55252e.isCommentFloatPage()) {
                        StatisticItem statisticItem4 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem4.param("fid", this.f55252e.getPbModel().getForumId());
                        statisticItem4.param("tid", this.f55252e.getPbModel().e1());
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("post_id", this.f55252e.l1());
                        statisticItem4.param("obj_source", 1);
                        statisticItem4.param("obj_type", 3);
                        statisticItem4.param("obj_locate", this.f55252e.getFromVideoPageType());
                        TiebaStatic.log(statisticItem4);
                    }
                    if (this.f55252e.Z) {
                        this.f55252e.Z = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (this.f55252e.getPbModel() == null || this.f55252e.getPbModel().O0() == null || this.f55252e.G0 == null || postData.t() == null || postData.A() == 1 || !this.f55252e.checkUpIsLogin()) {
                                return;
                            }
                            if (this.f55252e.F0 != null) {
                                this.f55252e.F0.c();
                            }
                            c.a.p0.i2.h.r rVar = new c.a.p0.i2.h.r();
                            rVar.A(this.f55252e.getPbModel().O0().m());
                            rVar.E(this.f55252e.getPbModel().O0().O());
                            rVar.C(postData);
                            this.f55252e.G0.R(rVar);
                            this.f55252e.G0.setPostId(postData.E());
                            this.f55252e.C1(view, postData.t().getUserId(), "", postData);
                            TiebaStatic.log("c11743");
                            c.a.p0.i2.m.a.b(this.f55252e.getPbModel().O0(), postData, postData.i0, 8, 1);
                            if (this.f55252e.D0 != null) {
                                AbsVideoPbFragment absVideoPbFragment = this.f55252e;
                                absVideoPbFragment.setHasDraft(absVideoPbFragment.D0.D());
                            }
                        }
                    }
                } else if ((this.f55252e.isShowDoubleTab() && this.f55252e.getReplyFragment() != null && this.f55252e.getReplyFragment().getNextView() != null && view == this.f55252e.getReplyFragment().getNextView()) || ((this.f55252e.getDetailInfoAndReplyFragment() != null && this.f55252e.getDetailInfoAndReplyFragment().getNextView() != null && view == this.f55252e.getDetailInfoAndReplyFragment().getNextView()) || view.getId() == R.id.pb_more)) {
                    if (!this.f55252e.K && this.f55252e.getPbModel().x1(true)) {
                        this.f55252e.K = true;
                        if (this.f55252e.isShowDoubleTab()) {
                            if (this.f55252e.getReplyFragment() != null) {
                                this.f55252e.getReplyFragment().setPreLoadNext();
                            }
                        } else if (this.f55252e.getDetailInfoAndReplyFragment() != null) {
                            this.f55252e.getDetailInfoAndReplyFragment().setPreLoadNext();
                        }
                    }
                } else {
                    c.a.p0.i2.o.g.a aVar = this.f55252e.mDialogController;
                    if (aVar != null && aVar.Q() != null && view == this.f55252e.mDialogController.Q().e()) {
                        this.f55252e.mDialogController.I();
                        return;
                    }
                    c.a.p0.i2.o.g.a aVar2 = this.f55252e.mDialogController;
                    if ((aVar2 == null || ((aVar2.Q() == null || view != this.f55252e.mDialogController.Q().i()) && view.getId() != R.id.owner_reply && view.getId() != R.id.all_reply)) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                        AbsVideoPbFragment absVideoPbFragment2 = this.f55252e;
                        if (view == absVideoPbFragment2.mBackButton) {
                            if (absVideoPbFragment2.getPbModel() == null || this.f55252e.getPbModel().O0() == null) {
                                return;
                            }
                            if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                StatisticItem statisticItem5 = new StatisticItem("c13266");
                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem5.param("fid", this.f55252e.getPbModel().O0().n());
                                statisticItem5.param("tid", this.f55252e.getPbModel().e1());
                                statisticItem5.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(statisticItem5);
                                TbadkCoreApplication.getInst().setTaskId("");
                            }
                            c.a.e.e.p.l.x(this.f55252e.f55129e, this.f55252e.mBackButton);
                            this.f55252e.f55129e.finish();
                        } else if (view == absVideoPbFragment2.mMore && absVideoPbFragment2.mDialogController != null) {
                            if (c.a.o0.b1.l.a()) {
                                return;
                            }
                            if (this.f55252e.getPbModel() != null && this.f55252e.getPbModel().O0() != null) {
                                ArrayList<PostData> F = this.f55252e.getPbModel().O0().F();
                                if ((F == null || F.size() <= 0) && this.f55252e.getPbModel().c1()) {
                                    c.a.e.e.p.l.M(this.f55252e.getPageContext().getPageActivity(), this.f55252e.getPageContext().getString(R.string.pb_no_data_tips));
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.f55252e.getPbModel().e1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f55252e.getPbModel().getForumId()));
                                this.f55252e.mDialogController.m0();
                                return;
                            }
                            c.a.e.e.p.l.M(this.f55252e.getPageContext().getPageActivity(), this.f55252e.getPageContext().getString(R.string.pb_no_data_tips));
                        } else if (this.f55252e.mDialogController.Q() != null && view == this.f55252e.mDialogController.Q().k()) {
                            if (this.f55252e.getPbModel() == null) {
                                return;
                            }
                            this.f55252e.mDialogController.F();
                            if (c.a.e.e.p.j.z()) {
                                this.f55252e.stopVoice();
                                this.f55252e.setPreLoad();
                                this.f55252e.getPbModel().k2(1);
                                return;
                            }
                            this.f55252e.showToast(R.string.network_not_available);
                        } else {
                            c.a.p0.i2.o.g.a aVar3 = this.f55252e.mDialogController;
                            if (aVar3 != null && aVar3.Q() != null && view == this.f55252e.mDialogController.Q().i()) {
                                this.f55252e.mDialogController.I();
                                return;
                            }
                            c.a.p0.i2.o.g.a aVar4 = this.f55252e.mDialogController;
                            if (aVar4 != null && ((aVar4.Q() != null && view == this.f55252e.mDialogController.Q().q()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                                this.f55252e.mDialogController.F();
                                if (c.a.e.e.p.j.z()) {
                                    if (!this.f55252e.K) {
                                        this.f55252e.stopVoice();
                                        this.f55252e.setPreLoad();
                                        this.f55252e.mDialogController.J0(view);
                                        return;
                                    }
                                    view.setTag(Integer.valueOf(this.f55252e.getPbModel().a1()));
                                    return;
                                }
                                this.f55252e.showToast(R.string.network_not_available);
                                return;
                            }
                            c.a.p0.i2.o.g.a aVar5 = this.f55252e.mDialogController;
                            if (aVar5 != null && aVar5.Q() != null && view == this.f55252e.mDialogController.Q().p()) {
                                if (this.f55252e.getPbModel() == null || this.f55252e.getPbModel().O0() == null || this.f55252e.getPbModel().O0().O() == null) {
                                    return;
                                }
                                this.f55252e.mDialogController.I();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment3 = this.f55252e;
                                absVideoPbFragment3.mDialogController.U(absVideoPbFragment3.getPbModel().O0().O().W());
                            } else if (view.getId() == R.id.pb_floor_feedback) {
                                try {
                                    sparseArray = (SparseArray) view.getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray = null;
                                }
                                c.a.p0.i2.o.g.a aVar6 = this.f55252e.mDialogController;
                                if (aVar6 != null) {
                                    aVar6.w0(sparseArray);
                                }
                            } else {
                                c.a.p0.i2.o.g.a aVar7 = this.f55252e.mDialogController;
                                if (aVar7 != null && aVar7.Q() != null && view == this.f55252e.mDialogController.Q().n()) {
                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                    if (skinType == 1) {
                                        this.f55252e.onChangeSkinType(skinType);
                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                    } else if (skinType == 0 || skinType == 4) {
                                        UtilHelper.showSkinChangeAnimation(this.f55252e.getActivity());
                                        this.f55252e.onChangeSkinType(skinType);
                                        UtilHelper.setNavigationBarBackground(this.f55252e.getActivity(), this.f55252e.getResources().getColor(R.color.CAM_X0201_1));
                                        TbadkCoreApplication.getInst().setSkinType(1);
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                    }
                                    this.f55252e.mDialogController.J();
                                    return;
                                }
                                c.a.p0.i2.o.g.a aVar8 = this.f55252e.mDialogController;
                                if (aVar8 != null && aVar8.Q() != null && view == this.f55252e.mDialogController.Q().o()) {
                                    this.f55252e.mDialogController.J();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.f55252e;
                                    absVideoPbFragment4.mDialogController.G0(absVideoPbFragment4.x1);
                                    return;
                                }
                                c.a.p0.i2.o.g.a aVar9 = this.f55252e.mDialogController;
                                if (aVar9 != null && aVar9.Q() != null && view == this.f55252e.mDialogController.Q().h()) {
                                    c.a.o0.t.c.i0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (b2 = tiebaPlusConfigData.b(this.f55252e.getPbModel().e1())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.f55252e.getPageContext(), new String[]{b2});
                                    this.f55252e.mDialogController.I();
                                    return;
                                }
                                c.a.p0.i2.o.g.a aVar10 = this.f55252e.mDialogController;
                                if (aVar10 != null && (view == aVar10.M() || (this.f55252e.mDialogController.Q() != null && (view == this.f55252e.mDialogController.Q().l() || view == this.f55252e.mDialogController.Q().m())))) {
                                    if (!c.a.e.e.p.j.z()) {
                                        this.f55252e.showToast(R.string.network_not_available);
                                        return;
                                    } else if ((this.f55252e.getPbModel() == null && this.f55252e.getPbModel().O0() == null) || this.f55252e.R.O()) {
                                        return;
                                    } else {
                                        this.f55252e.mDialogController.F();
                                        if (this.f55252e.mDialogController.Q() != null && view == this.f55252e.mDialogController.Q().m()) {
                                            i3 = this.f55252e.getPbModel().O0().O().p0() == 1 ? 5 : 4;
                                        } else if (this.f55252e.mDialogController.Q() != null && view == this.f55252e.mDialogController.Q().l()) {
                                            i3 = this.f55252e.getPbModel().O0().O().o0() == 1 ? 3 : 6;
                                        } else {
                                            i3 = view == this.f55252e.mDialogController.M() ? 2 : 0;
                                        }
                                        ForumData m = this.f55252e.getPbModel().O0().m();
                                        String name = m.getName();
                                        String id = m.getId();
                                        String f0 = this.f55252e.getPbModel().O0().O().f0();
                                        this.f55252e.showProgressBar();
                                        this.f55252e.R.S(id, name, f0, i3, this.f55252e.mDialogController.N());
                                        return;
                                    }
                                }
                                c.a.p0.i2.o.g.a aVar11 = this.f55252e.mDialogController;
                                if (aVar11 != null && aVar11.Q() != null && view == this.f55252e.mDialogController.Q().g()) {
                                    if (this.f55252e.getPbModel() == null) {
                                        return;
                                    }
                                    if (!c.a.e.e.p.j.z()) {
                                        this.f55252e.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    this.f55252e.mDialogController.F();
                                    AbsVideoPbFragment absVideoPbFragment5 = this.f55252e;
                                    SparseArray<Object> managerOrDeleteTag = absVideoPbFragment5.getManagerOrDeleteTag(absVideoPbFragment5.getPbModel().O0(), this.f55252e.getPbModel().c1(), 1);
                                    if (managerOrDeleteTag == null) {
                                        return;
                                    }
                                    this.f55252e.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f55252e.getPageContext().getPageActivity(), this.f55252e.getPbModel().O0().m().getId(), this.f55252e.getPbModel().O0().m().getName(), this.f55252e.getPbModel().O0().O().f0(), String.valueOf(this.f55252e.getPbModel().O0().U().getUserId()), (String) managerOrDeleteTag.get(R.id.tag_forbid_user_name), (String) managerOrDeleteTag.get(R.id.tag_forbid_user_name_show), (String) managerOrDeleteTag.get(R.id.tag_forbid_user_post_id), (String) managerOrDeleteTag.get(R.id.tag_forbid_user_portrait))));
                                    return;
                                }
                                c.a.p0.i2.o.g.a aVar12 = this.f55252e.mDialogController;
                                if (aVar12 != null && aVar12.Q() != null && view == this.f55252e.mDialogController.Q().c()) {
                                    if (!c.a.e.e.p.j.z()) {
                                        this.f55252e.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.f55252e;
                                    SparseArray<Object> managerOrDeleteTag2 = absVideoPbFragment6.getManagerOrDeleteTag(absVideoPbFragment6.getPbModel().O0(), this.f55252e.getPbModel().c1(), 1);
                                    if (managerOrDeleteTag2 != null) {
                                        this.f55252e.mDialogController.j0(((Integer) managerOrDeleteTag2.get(R.id.tag_del_post_type)).intValue(), (String) managerOrDeleteTag2.get(R.id.tag_del_post_id), ((Integer) managerOrDeleteTag2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) managerOrDeleteTag2.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                    this.f55252e.mDialogController.I();
                                    if (this.f55252e.getPbModel() == null || this.f55252e.getPbModel().O0() == null || this.f55252e.getPbModel().O0().O() == null) {
                                        return;
                                    }
                                    c.a.o0.s.q.c2 O = this.f55252e.getPbModel().O0().O();
                                    StatisticItem statisticItem6 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem6.param("tid", O.f0());
                                    statisticItem6.param("fid", O.T());
                                    statisticItem6.param("fname", O.Z());
                                    TiebaStatic.log(statisticItem6);
                                    StatisticItem statisticItem7 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                    statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem7.param("tid", O.f0());
                                    statisticItem7.param("fid", O.T());
                                    statisticItem7.param("fname", O.Z());
                                    statisticItem7.param("obj_source", 3);
                                    TiebaStatic.log(statisticItem7);
                                    return;
                                }
                                c.a.p0.i2.o.g.a aVar13 = this.f55252e.mDialogController;
                                if (aVar13 != null && aVar13.Q() != null && view == this.f55252e.mDialogController.Q().f()) {
                                    if (this.f55252e.getPbModel() == null) {
                                        return;
                                    }
                                    if (!c.a.e.e.p.j.z()) {
                                        this.f55252e.showToast(R.string.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment7 = this.f55252e;
                                    SparseArray<Object> managerOrDeleteTag3 = absVideoPbFragment7.getManagerOrDeleteTag(absVideoPbFragment7.getPbModel().O0(), this.f55252e.getPbModel().c1(), 1);
                                    if (managerOrDeleteTag3 != null) {
                                        if (StringUtils.isNull((String) managerOrDeleteTag3.get(R.id.tag_del_multi_forum))) {
                                            this.f55252e.mDialogController.g0(((Integer) managerOrDeleteTag3.get(R.id.tag_del_post_type)).intValue(), (String) managerOrDeleteTag3.get(R.id.tag_del_post_id), ((Integer) managerOrDeleteTag3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) managerOrDeleteTag3.get(R.id.tag_del_post_is_self)).booleanValue());
                                        } else {
                                            this.f55252e.mDialogController.h0(((Integer) managerOrDeleteTag3.get(R.id.tag_del_post_type)).intValue(), (String) managerOrDeleteTag3.get(R.id.tag_del_post_id), ((Integer) managerOrDeleteTag3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) managerOrDeleteTag3.get(R.id.tag_del_post_is_self)).booleanValue(), (String) managerOrDeleteTag3.get(R.id.tag_del_multi_forum));
                                        }
                                    }
                                    this.f55252e.mDialogController.I();
                                } else if (view.getId() != R.id.sub_pb_more && view.getId() != R.id.sub_pb_item && view.getId() != R.id.pb_floor_reply_more && view.getId() != R.id.new_sub_pb_list_richText && view.getId() != R.id.pb_post_reply_count) {
                                    if (view.getId() != R.id.pb_post_reply && view.getId() != R.id.post_info_commont_img && view.getId() != R.id.pb_floor_comment_container) {
                                        if (view.getId() != R.id.pb_editor_tool_collection && view.getId() != R.id.collect_num_container) {
                                            if (view.getId() == R.id.pb_editor_tool_share) {
                                                this.f55252e.handleShare(true);
                                                return;
                                            } else if (view.getId() != R.id.pb_editor_tool_comment_icon && view.getId() != R.id.thread_info_commont_container) {
                                                if (view.getId() == R.id.tv_pb_reply_more) {
                                                    if (this.f55252e.L0 >= 0) {
                                                        if (this.f55252e.getPbModel() != null) {
                                                            this.f55252e.getPbModel().T1();
                                                        }
                                                        if (this.f55252e.isShowDoubleTab() && this.f55252e.getPbModel() != null && this.f55252e.getReplyFragment() != null && this.f55252e.getReplyFragment().getAdapterManager() != null) {
                                                            this.f55252e.getReplyFragment().getAdapterManager().f(this.f55252e.getPbModel().O0());
                                                        } else if (this.f55252e.getDetailInfoAndReplyFragment() != null && this.f55252e.getDetailInfoAndReplyFragment().getAdapterManager() != null) {
                                                            this.f55252e.getDetailInfoAndReplyFragment().getAdapterManager().q(this.f55252e.getPbModel().O0());
                                                        }
                                                        this.f55252e.L0 = 0;
                                                        this.f55252e.M0 = Integer.MIN_VALUE;
                                                        if (this.f55252e.isShowDoubleTab() && this.f55252e.getPbModel() != null && this.f55252e.getReplyFragment() != null) {
                                                            this.f55252e.getReplyFragment().scrollListView(this.f55252e.getPbModel().H0(), this.f55252e.getPbModel().G0());
                                                            this.f55252e.getPbModel().X1(0, 0);
                                                            return;
                                                        } else if (this.f55252e.getPbModel() == null || this.f55252e.getDetailInfoAndReplyFragment() == null) {
                                                            return;
                                                        } else {
                                                            this.f55252e.getDetailInfoAndReplyFragment().scrollListView(this.f55252e.getPbModel().H0(), this.f55252e.getPbModel().G0());
                                                            this.f55252e.getPbModel().X1(0, 0);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                    if (this.f55252e.getPbModel() == null) {
                                                        return;
                                                    }
                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                    statisticItem8.param("tid", this.f55252e.getPbModel().e1());
                                                    statisticItem8.param("fid", this.f55252e.getPbModel().getForumId());
                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem8.param("obj_locate", 2);
                                                    TiebaStatic.log(statisticItem8);
                                                    return;
                                                } else if (view.getId() == R.id.pb_item_tail_content) {
                                                    if (ViewHelper.checkUpIsLogin(this.f55252e.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                        String p = c.a.o0.s.d0.b.j().p("tail_link", "");
                                                        if (!StringUtils.isNull(p)) {
                                                            TiebaStatic.log("c10056");
                                                            c.a.o0.m.a.o(view.getContext(), string, p, true, true, true);
                                                        }
                                                        this.f55252e.resetCommentView();
                                                        return;
                                                    }
                                                    return;
                                                } else if (view.getId() == R.id.keyboard_background_shadow) {
                                                    this.f55252e.resetCommentView();
                                                    return;
                                                } else if (this.f55252e.mDialogController.Q() != null && view == this.f55252e.mDialogController.Q().d()) {
                                                    this.f55252e.mDialogController.F();
                                                    if (this.f55252e.getPbModel() != null) {
                                                        this.f55252e.q.f(this.f55252e.getPbModel().e1());
                                                    }
                                                    if (this.f55252e.getPbModel() == null || !this.f55252e.getPbModel().isPrivacy()) {
                                                        this.f55252e.q.b();
                                                        if (!TbSingleton.getInstance().mCanCallFans && this.f55252e.getPbModel() != null && this.f55252e.getPbModel().O0() != null && this.f55252e.getPbModel().O0().Q() != null && this.f55252e.getPbModel().O0().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
                                                            i5 = 2;
                                                        }
                                                        if (this.f55252e.getPbModel() == null || this.f55252e.getPbModel().O0() == null) {
                                                            return;
                                                        }
                                                        this.f55252e.q.d(3, i5, this.f55252e.getPbModel().O0().Q());
                                                        return;
                                                    }
                                                    this.f55252e.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                    if (this.f55252e.getPbModel().O0() != null) {
                                                        this.f55252e.q.d(3, 3, this.f55252e.getPbModel().O0().Q());
                                                        return;
                                                    }
                                                    return;
                                                } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                                                    StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                    statisticItem9.param("tid", this.f55252e.getPbModel().e1());
                                                    statisticItem9.param("fid", this.f55252e.getPbModel().getForumId());
                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem9.param("obj_locate", 7);
                                                    TiebaStatic.log(statisticItem9);
                                                    if (this.f55252e.isCommentFloatPage()) {
                                                        StatisticItem statisticItem10 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem10.param("fid", this.f55252e.getPbModel().getForumId());
                                                        statisticItem10.param("tid", this.f55252e.getPbModel().e1());
                                                        statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem10.param("post_id", this.f55252e.l1());
                                                        statisticItem10.param("obj_source", 1);
                                                        statisticItem10.param("obj_type", 2);
                                                        statisticItem10.param("obj_locate", this.f55252e.getFromVideoPageType());
                                                        TiebaStatic.log(statisticItem10);
                                                    }
                                                    this.f55252e.mDialogController.o0(false);
                                                    this.f55252e.mDialogController.P().onLongClick(view);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else if (this.f55252e.getPbModel() != null) {
                                                AbsVideoPbFragment absVideoPbFragment8 = this.f55252e;
                                                if (absVideoPbFragment8.mDialogController == null || absVideoPbFragment8.f55133i == null || this.f55252e.getPbModel().O0() == null || this.f55252e.getPbModel().O0().O() == null || !this.f55252e.checkUpIsLogin()) {
                                                    return;
                                                }
                                                c.a.p0.i2.h.e O0 = this.f55252e.getPbModel().O0();
                                                int S0 = O0.O().S0();
                                                int currentItem = this.f55252e.f55133i.getCurrentItem();
                                                if (S0 == 0) {
                                                    if (this.f55252e.isShowDoubleTab() && currentItem == 0) {
                                                        this.f55252e.f55133i.setCurrentItem(1);
                                                    }
                                                    this.f55252e.expandVideo(false);
                                                    this.f55252e.processProfessionPermission();
                                                    return;
                                                }
                                                if (this.f55252e.isShowDoubleTab() && currentItem == 0) {
                                                    this.f55252e.f55133i.setCurrentItem(1);
                                                    str = "obj_source";
                                                } else if ((this.f55252e.isShowDoubleTab() && this.f55252e.getReplyFragment() == null) || this.f55252e.getDetailInfoAndReplyFragment() == null || this.f55252e.getRecyclerView() == null) {
                                                    return;
                                                } else {
                                                    StatisticItem param = new StatisticItem("c13403").param("tid", this.f55252e.getPbModel().e1()).param("fid", this.f55252e.getPbModel().O0().n()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    int i6 = (int) (c.a.e.e.p.l.i(this.f55252e.getContext()) * 0.6d);
                                                    BdTypeRecyclerView recyclerView = this.f55252e.getRecyclerView();
                                                    if (recyclerView == null) {
                                                        return;
                                                    }
                                                    boolean canScrollVertically = recyclerView.canScrollVertically(1);
                                                    boolean canScrollVertically2 = recyclerView.canScrollVertically(-1);
                                                    AppBarLayout appBarLayout = this.f55252e.mAppBarLayout;
                                                    if (appBarLayout != null) {
                                                        appBarLayout.setExpanded(false, true);
                                                    }
                                                    if (recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                                                        return;
                                                    }
                                                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                                                    if (!canScrollVertically2 && canScrollVertically) {
                                                        if (this.f55252e.J0 == -1 && this.f55252e.K0 == Integer.MIN_VALUE) {
                                                            return;
                                                        }
                                                        if (this.f55252e.J0 <= 3 && (this.f55252e.J0 != 3 || this.f55252e.K0 >= (-i6))) {
                                                            if (this.f55252e.J0 < 2) {
                                                                if (this.f55252e.J0 != 1) {
                                                                    recyclerView.smoothScrollBy(0, -this.f55252e.K0);
                                                                } else {
                                                                    int i7 = i6 / 4;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.f55252e.J0, this.f55252e.K0 + i7);
                                                                    recyclerView.smoothScrollBy(0, i7);
                                                                }
                                                            } else {
                                                                int i8 = i6 / 2;
                                                                linearLayoutManager.scrollToPositionWithOffset(this.f55252e.J0, this.f55252e.K0 + i8);
                                                                recyclerView.smoothScrollBy(0, i8);
                                                            }
                                                        } else {
                                                            linearLayoutManager.scrollToPositionWithOffset(this.f55252e.J0, this.f55252e.K0 + i6);
                                                            recyclerView.smoothScrollBy(0, i6);
                                                        }
                                                        statisticItem2 = param;
                                                        statisticItem2.param("obj_locate", 2);
                                                        str = "obj_source";
                                                        i2 = 1;
                                                    } else {
                                                        statisticItem2 = param;
                                                        int firstVisiblePosition = recyclerView.getFirstVisiblePosition();
                                                        View childAt = recyclerView.getChildAt(0);
                                                        if (childAt == null) {
                                                            str = "obj_source";
                                                            top = 0;
                                                        } else {
                                                            top = childAt.getTop();
                                                            str = "obj_source";
                                                        }
                                                        this.f55252e.J0 = firstVisiblePosition;
                                                        this.f55252e.K0 = top;
                                                        if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-i6) || recyclerView.getCount() < 6)) {
                                                            recyclerView.smoothScrollToPosition(0);
                                                        } else {
                                                            linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                            recyclerView.smoothScrollToPosition(0);
                                                        }
                                                        i2 = 1;
                                                        statisticItem2.param("obj_locate", 1);
                                                    }
                                                    TiebaStatic.log(statisticItem2);
                                                    c.a.o0.k0.c f2 = TbPageExtraHelper.f(view);
                                                    StatisticItem statisticItem11 = new StatisticItem("c12942");
                                                    statisticItem11.param("obj_type", i2);
                                                    statisticItem11.param("obj_locate", 4);
                                                    statisticItem11.param("tid", this.f55252e.getPbModel().e1());
                                                    statisticItem11.param("nid", O0.O().D0());
                                                    if (f2 != null) {
                                                        statisticItem11.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                                                    }
                                                    if (TbPageExtraHelper.m() != null) {
                                                        statisticItem11.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                                                    }
                                                    TiebaStatic.log(statisticItem11);
                                                }
                                                if (this.f55252e.getPbModel() == null || this.f55252e.getPbModel().O0() == null || this.f55252e.getPbModel().O0().O() == null || this.f55252e.getPbModel().O0().O().J() == null) {
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f55252e.getPbModel().e1()).param("fid", this.f55252e.getPbModel().O0().n()).param("obj_locate", 2).param("uid", this.f55252e.getPbModel().O0().O().J().getUserId()));
                                                if (this.f55252e.isCommentFloatPage()) {
                                                    StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                    statisticItem12.param("fid", this.f55252e.getPbModel().getForumId());
                                                    statisticItem12.param("tid", this.f55252e.getPbModel().e1());
                                                    statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem12.param("post_id", this.f55252e.l1());
                                                    statisticItem12.param(str, 1);
                                                    statisticItem12.param("obj_type", 12);
                                                    statisticItem12.param("obj_locate", this.f55252e.getFromVideoPageType());
                                                    TiebaStatic.log(statisticItem12);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        }
                                        int i9 = 2;
                                        if (!c.a.e.e.p.j.z()) {
                                            this.f55252e.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment9 = this.f55252e;
                                        if (absVideoPbFragment9.mDialogController == null || absVideoPbFragment9.getPbModel() == null) {
                                            return;
                                        }
                                        if (this.f55252e.isShowDoubleTab() && this.f55252e.getReplyFragment() == null) {
                                            return;
                                        }
                                        if (this.f55252e.isShowDoubleTab() || this.f55252e.getDetailInfoAndReplyFragment() != null) {
                                            this.f55252e.mDialogController.F();
                                            if (view.getId() != R.id.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new c.a.o0.s.q.t0(this.f55252e.getActivity(), "pb_shoucang"))) {
                                                if (!this.f55252e.f1(11009) || this.f55252e.getPbModel() == null) {
                                                    return;
                                                }
                                                this.f55252e.E1();
                                                if (this.f55252e.getPbModel().O0() != null && this.f55252e.getPbModel().O0().O() != null && this.f55252e.getPbModel().O0().O().J() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f55252e.getPbModel().e1()).param("fid", this.f55252e.getPbModel().O0().n()).param("obj_locate", 3).param("uid", this.f55252e.getPbModel().O0().O().J().getUserId()));
                                                    if (this.f55252e.isCommentFloatPage()) {
                                                        StatisticItem statisticItem13 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem13.param("fid", this.f55252e.getPbModel().getForumId());
                                                        statisticItem13.param("tid", this.f55252e.getPbModel().e1());
                                                        statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem13.param("post_id", this.f55252e.l1());
                                                        statisticItem13.param("obj_source", 1);
                                                        statisticItem13.param("obj_type", 13);
                                                        statisticItem13.param("obj_locate", this.f55252e.getFromVideoPageType());
                                                        TiebaStatic.log(statisticItem13);
                                                    }
                                                }
                                                if (this.f55252e.getPbModel().O0().O() == null || this.f55252e.getPbModel().O0().O().J() == null || this.f55252e.getPbModel().O0().O().J().getUserId() == null || this.f55252e.N == null) {
                                                    return;
                                                }
                                                AbsVideoPbFragment absVideoPbFragment10 = this.f55252e;
                                                int S = absVideoPbFragment10.mDialogController.S(absVideoPbFragment10.getPbModel().O0());
                                                c.a.o0.s.q.c2 O2 = this.f55252e.getPbModel().O0().O();
                                                if (!O2.J1()) {
                                                    if (O2.M1()) {
                                                        i9 = 3;
                                                    } else if (O2.K1()) {
                                                        i9 = 4;
                                                    } else {
                                                        i9 = O2.L1() ? 5 : 1;
                                                    }
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f55252e.getPbModel().e1()).param("obj_locate", 1).param("obj_id", this.f55252e.getPbModel().O0().O().J().getUserId()).param("obj_type", !this.f55252e.N.e()).param("obj_source", S).param("obj_param1", i9));
                                                return;
                                            }
                                            this.f55252e.w = view;
                                        }
                                    } else if (this.f55252e.getPbModel() == null) {
                                    } else {
                                        if (view.getId() == R.id.pb_post_reply) {
                                            StatisticItem statisticItem14 = new StatisticItem("c13398");
                                            statisticItem14.param("tid", this.f55252e.getPbModel().e1());
                                            statisticItem14.param("fid", this.f55252e.getPbModel().getForumId());
                                            statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem14.param("obj_locate", 6);
                                            TiebaStatic.log(statisticItem14);
                                        }
                                        if (view.getId() == R.id.post_info_commont_img) {
                                            if (!DialogLoginHelper.checkUpIsLogin(new c.a.o0.s.q.t0(this.f55252e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                this.f55252e.v = view;
                                                return;
                                            }
                                        } else if (view.getId() == R.id.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new c.a.o0.s.q.t0(this.f55252e.getActivity(), "pb_huifu_louzhonglou"))) {
                                            this.f55252e.v = view;
                                            return;
                                        }
                                        if (this.f55252e.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                if (view.getId() == R.id.pb_post_reply && (statisticItem = postData2.j0) != null) {
                                                    StatisticItem copy = statisticItem.copy();
                                                    copy.delete("obj_locate");
                                                    copy.param("obj_locate", 8);
                                                    TiebaStatic.log(copy);
                                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f55252e.getPbModel().f1()).param("fid", this.f55252e.getPbModel().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.E()).param("obj_source", 1).param("obj_type", 3));
                                                }
                                                if (this.f55252e.getPbModel() == null || this.f55252e.getPbModel().O0() == null || this.f55252e.G0 == null || postData2.t() == null || postData2.A() == 1) {
                                                    return;
                                                }
                                                if (this.f55252e.F0 != null) {
                                                    this.f55252e.F0.c();
                                                }
                                                if (this.f55252e.O0 && postData2.M() != null && postData2.M().size() != 0) {
                                                    this.f55252e.Z1(postData2, null, true, false);
                                                    return;
                                                }
                                                c.a.p0.i2.h.r rVar2 = new c.a.p0.i2.h.r();
                                                rVar2.A(this.f55252e.getPbModel().O0().m());
                                                rVar2.E(this.f55252e.getPbModel().O0().O());
                                                rVar2.C(postData2);
                                                this.f55252e.G0.R(rVar2);
                                                this.f55252e.G0.setPostId(postData2.E());
                                                this.f55252e.C1(view, postData2.t().getUserId(), "", postData2);
                                                if (this.f55252e.D0 != null) {
                                                    AbsVideoPbFragment absVideoPbFragment11 = this.f55252e;
                                                    absVideoPbFragment11.setHasDraft(absVideoPbFragment11.D0.D());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                        StatisticItem statisticItem15 = new StatisticItem("c13398");
                                        statisticItem15.param("tid", this.f55252e.getPbModel().e1());
                                        statisticItem15.param("fid", this.f55252e.getPbModel().getForumId());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem15);
                                        if (this.f55252e.isCommentFloatPage()) {
                                            StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem16.param("fid", this.f55252e.getPbModel().getForumId());
                                            statisticItem16.param("tid", this.f55252e.getPbModel().e1());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param("post_id", this.f55252e.l1());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 8);
                                            statisticItem16.param("obj_locate", this.f55252e.getFromVideoPageType());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                    }
                                    if ((view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.pb_post_reply_count) && !DialogLoginHelper.checkUpIsLogin(new c.a.o0.s.q.t0(this.f55252e.getActivity(), "pb_chakanhuifu"))) {
                                        this.f55252e.u = view;
                                        return;
                                    }
                                    if (view.getId() == R.id.pb_floor_reply_more && this.f55252e.isCommentFloatPage()) {
                                        StatisticItem statisticItem17 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem17.param("fid", this.f55252e.getPbModel().getForumId());
                                        statisticItem17.param("tid", this.f55252e.getPbModel().e1());
                                        statisticItem17.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem17.param("post_id", this.f55252e.l1());
                                        statisticItem17.param("obj_source", 1);
                                        statisticItem17.param("obj_type", 9);
                                        statisticItem17.param("obj_locate", this.f55252e.getFromVideoPageType());
                                        TiebaStatic.log(statisticItem17);
                                    }
                                    if (!this.f55252e.checkUpIsLogin()) {
                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.f55252e.getPbModel().O0().n()));
                                    } else if (this.f55252e.getPbModel() == null || this.f55252e.getPbModel().O0() == null) {
                                    } else {
                                        c.a.p0.i2.o.g.a aVar14 = this.f55252e.mDialogController;
                                        if (aVar14 != null) {
                                            aVar14.F();
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
                                        StatisticItem statisticItem18 = postData3.j0;
                                        if (statisticItem18 != null) {
                                            StatisticItem copy2 = statisticItem18.copy();
                                            copy2.delete("obj_locate");
                                            if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                copy2.param("obj_locate", 6);
                                            } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                copy2.param("obj_locate", 8);
                                            }
                                            TiebaStatic.log(copy2);
                                        }
                                        this.f55252e.stopVoice();
                                        TiebaStatic.log("c11742");
                                        if (postData4 != null) {
                                            this.f55252e.Z1(postData3, postData4, false, true);
                                        } else {
                                            this.f55252e.Z1(postData3, null, false, false);
                                        }
                                    }
                                }
                            }
                        }
                    } else if (!c.a.e.e.p.j.z()) {
                        this.f55252e.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                    } else {
                        this.f55252e.mDialogController.F();
                        if (!this.f55252e.K) {
                            this.f55252e.stopVoice();
                            this.f55252e.setPreLoad();
                            if (view.getId() == R.id.owner_reply) {
                                p2 = this.f55252e.getPbModel().p2(true, this.f55252e.l1());
                            } else {
                                p2 = view.getId() == R.id.all_reply ? this.f55252e.getPbModel().p2(false, this.f55252e.l1()) : this.f55252e.getPbModel().o2(this.f55252e.l1());
                            }
                            view.setTag(Boolean.valueOf(p2));
                            if (p2) {
                                this.f55252e.showProgressView();
                                i4 = 1;
                                this.f55252e.K = true;
                            } else {
                                i4 = 1;
                            }
                            TiebaStatic.eventStat(this.f55252e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i4, new Object[0]);
                            return;
                        }
                        view.setTag(Boolean.FALSE);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55253a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z0(AbsVideoPbFragment absVideoPbFragment, int i2) {
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
            this.f55253a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f55253a.a0.getLayoutParams();
            layoutParams.height = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
            this.f55253a.a0.setLayoutParams(layoutParams);
            if (this.f55253a.isShowDoubleTab() && this.f55253a.f55132h != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f55253a.f55132h.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = AbsVideoPbFragment.G1;
                } else {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, AbsVideoPbFragment.G1);
                }
                this.f55253a.f55132h.setLayoutParams(layoutParams2);
                this.f55253a.f55133i.setScrollable(true);
            }
            this.f55253a.resetCommentView();
            if (this.f55253a.getDetailInfoFragment() != null) {
                this.f55253a.getDetailInfoFragment().invalidataData();
            }
            if (this.f55253a.getDetailInfoAndReplyFragment() != null) {
                this.f55253a.getDetailInfoAndReplyFragment().invalidataData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z1 implements c.a.e.e.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55254a;

        public z1(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55254a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
                ((PlayVoiceBntNew) view).reset();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.f55254a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.f55254a.getVoiceManager());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
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
        F1 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds146);
        G1 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds114);
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
        this.f55130f = 0L;
        this.r = false;
        this.z = new k(this);
        this.K = false;
        this.N = null;
        this.Q = null;
        this.R = null;
        this.Z = false;
        this.c0 = null;
        this.k0 = null;
        this.t0 = false;
        this.u0 = null;
        this.v0 = false;
        this.w0 = false;
        this.x0 = false;
        this.y0 = false;
        this.H0 = new int[2];
        this.J0 = -1;
        this.K0 = Integer.MIN_VALUE;
        this.L0 = 0;
        this.M0 = Integer.MIN_VALUE;
        this.N0 = false;
        this.O0 = c.a.o0.b.d.s0();
        this.P0 = new v(this);
        this.R0 = new g0(this, 2921552);
        this.S0 = new n1(this);
        this.T0 = new y1(this);
        this.U0 = new d2(this);
        this.V0 = new e2(this, 2004016);
        this.W0 = new a(this, 2004007);
        this.X0 = new b(this, 2921391);
        this.Y0 = new c(this, 2016450);
        this.Z0 = new d(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.a1 = new e(this, 2001426);
        this.b1 = new f(this, 2001427);
        this.c1 = new g(this, 2001428);
        this.d1 = new h(this);
        this.e1 = new i(this);
        this.f1 = new j(this);
        this.g1 = new l(this, 2004008);
        this.h1 = 0;
        this.l1 = true;
        this.m1 = new m(this);
        this.o1 = new n(this);
        this.p1 = new o(this);
        this.s1 = new p(this);
        this.t1 = new q(this);
        this.u1 = new r(this);
        this.mOnFloorPostWriteNewCallback = new t(this);
        this.v1 = new y(this);
        this.listener = new z(this);
        this.w1 = new c0(this);
        this.x1 = new d0(this);
        this.y1 = new e0(this, 2001332);
        this.z1 = new f0(this, 2016528);
        this.A1 = new p0(this, 2001440);
        this.B1 = new q0(this);
        this.C1 = new w0(this);
        this.D1 = new z0(this, 2921509);
        this.E1 = new e1(this);
        this.onSwitchChangeListener = new f1(this);
        this.r0 = new f2(this, null);
    }

    public final void A1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.j0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.j0.setImageResource(0);
                this.j0.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.j0.setImageResource(R.drawable.transparent_bg);
        }
    }

    public final void C1(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || e1() || !checkPrivacyBeforeInput()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.H0);
            this.I0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (this.F0 != null && postData != null) {
            this.F0.j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.t().getName_show(), postData.K() != null ? postData.K().toString() : ""));
        }
        if (getPbModel() != null && getPbModel().O0() != null && getPbModel().O0().f0()) {
            c.a.e.e.m.e.a().postDelayed(new l1(this, str, str2), 0L);
            return;
        }
        if (this.A0 == null) {
            c.a.p0.v0.f2.a.c cVar = new c.a.p0.v0.f2.a.c(getPageContext());
            this.A0 = cVar;
            cVar.j(1);
            this.A0.i(new m1(this, str, str2));
        }
        if (getPbModel() == null || getPbModel().O0() == null || getPbModel().O0().m() == null) {
            return;
        }
        this.A0.g(getPbModel().O0().m().getId(), c.a.e.e.m.b.f(getPbModel().e1(), 0L));
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || getPbModel() == null) {
            return;
        }
        c.a.p0.i2.h.e O0 = getPbModel().O0();
        getPbModel().m2(true);
        c.a.o0.i.a aVar = this.N;
        if (aVar != null) {
            O0.B0(aVar.g());
        }
        if (isShowDoubleTab()) {
            if (getDetailInfoFragment() != null) {
                getDetailInfoFragment().invalidataData();
            }
            if (getReplyFragment() != null) {
                getReplyFragment().invalidataData();
            }
        } else if (getDetailInfoAndReplyFragment() != null) {
            getDetailInfoAndReplyFragment().invalidataData();
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || getPbModel() == null || getPbModel().O0() == null) {
            return;
        }
        if (isShowDoubleTab() && getReplyFragment() == null) {
            return;
        }
        if ((isShowDoubleTab() || getDetailInfoAndReplyFragment() != null) && this.N != null) {
            MarkData markData = null;
            if (getPbModel().O0() != null && getPbModel().O0().f0()) {
                markData = getPbModel().g0(0);
            } else {
                CustomViewPager customViewPager = this.f55133i;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = getPbModel().I0(getFirstPostData(getPbModel().O0()));
                } else if (isShowDoubleTab()) {
                    if (getReplyFragment() != null) {
                        markData = getPbModel().g0(getReplyFragment().getLastItem());
                    }
                } else if (getDetailInfoAndReplyFragment() != null) {
                    markData = getPbModel().g0(getDetailInfoAndReplyFragment().getLastItem());
                }
            }
            if (markData == null) {
                return;
            }
            if (markData.isApp() && getReplyFragment() != null && (markData = getPbModel().g0(getReplyFragment().getLastItem() + 1)) == null) {
                return;
            }
            setPreLoad();
            this.N.i(markData);
            if (!this.N.e()) {
                if (getPbModel() != null && !c.a.p0.i2.k.e.f1.b.k(getPbModel().e1())) {
                    this.o0.m(2);
                    c.a.p0.i2.k.e.f1.b.b(getPbModel().e1());
                }
                this.N.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.N.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final boolean F1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String p2 = c.a.o0.s.d0.b.j().p("bubble_link", "");
                if (StringUtils.isNull(p2)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    c.a.o0.m.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p2 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!c.a.e.e.p.j.z()) {
                showToast(R.string.network_not_available);
            } else if (this.mDialogController == null || getPbModel() == null) {
            } else {
                this.mDialogController.F();
                if (this.K) {
                    return;
                }
                stopVoice();
                setPreLoad();
                if (getPbModel().LoadData()) {
                    showProgressView();
                }
            }
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.operableVideoContainer == null) {
            return;
        }
        boolean z2 = false;
        if (this.r0.a()) {
            this.operableVideoContainer.a0(false);
            return;
        }
        c.a.p0.i2.o.k.a aVar = this.operableVideoContainer;
        if (!isCommentFloatPage() && !this.operableVideoContainer.Q0()) {
            z2 = true;
        }
        aVar.a0(z2);
    }

    public final void I1(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) || eVar == null) {
            return;
        }
        c.a.o0.s.q.c2 O = eVar.O();
        if (O != null && O.z2()) {
            d1();
        } else {
            N1(this.C0);
        }
        c.a.o0.x.w.e eVar2 = this.D0;
        if (eVar2 != null) {
            setHasDraft(eVar2.D());
            this.D0.N(eVar.d());
            this.D0.O(eVar.m(), eVar.U());
            this.D0.s0(O);
            if (getPbModel() != null) {
                this.D0.P(getPbModel().r0(), getPbModel().e1(), getPbModel().o0());
            }
            if (O != null) {
                this.D0.i0(O.h2());
            }
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.operableVideoContainer == null || this.f55133i == null) {
            return;
        }
        boolean z2 = false;
        if (!isShowDoubleTab()) {
            this.operableVideoContainer.U0(false);
        } else if (this.f55133i.getCurrentItem() != 0) {
            this.operableVideoContainer.U0(false);
        } else if (this.r0.a()) {
            this.operableVideoContainer.U0(false);
        } else {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            if (videoPbViewModel != null) {
                this.operableVideoContainer.U0((videoPbViewModel.getIsDetailTabTop() == null || videoPbViewModel.getIsDetailTabTop().getValue() == null || videoPbViewModel.getIsDetailTabTop().getValue().booleanValue()) ? true : true);
            }
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
            layoutParams.height = 0;
            this.s.setLayoutParams(layoutParams);
            this.s.setVisibility(8);
        }
    }

    public final void L1(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.O == null) {
            c.a.p0.i2.k.e.b1.f.a aVar = new c.a.p0.i2.k.e.b1.f.a(this.f55129e);
            this.O = aVar;
            aVar.n(this.v1);
            this.O.m(this.e1);
        }
        this.O.k(emotionImageData, getPbModel(), getPbModel().O0());
    }

    public final void M1(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || getPbModel() == null) {
            return;
        }
        showLoadingView(getView());
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
        privacySettingMessage.setTid(getPbModel().e1());
        sendMessage(privacySettingMessage);
    }

    public final void N1(c.a.o0.x.w.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) || gVar == null || getPbModel() == null) {
            return;
        }
        gVar.o(getPbModel().p0());
        if (getPbModel().O0() != null && getPbModel().O0().m() != null) {
            gVar.n(getPbModel().O0().m());
        }
        gVar.p("pb");
        gVar.q(getPbModel());
    }

    public final void O1(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || getPbModel() == null) {
            return;
        }
        int X0 = getPbModel().X0();
        if (i2 == 5) {
            getPbModel().i2(2);
        } else if (i2 == 6) {
            getPbModel().i2(3);
        } else if (i2 != 7) {
            getPbModel().i2(1);
        } else {
            getPbModel().i2(4);
        }
        int X02 = getPbModel().X0();
        if (X0 == 4 || X02 == 4) {
            G1();
        }
    }

    public final void P1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) {
            this.D0.g0(z2);
            this.D0.j0(z2);
            this.D0.q0(z2);
        }
    }

    public final void Q1(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048592, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new h1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                c.a.p0.i2.o.g.a aVar = this.mDialogController;
                if (aVar != null) {
                    aVar.K0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    public final void R1(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            String errorString = postWriteCallBackData.getErrorString();
            String preMsg = postWriteCallBackData.getPreMsg();
            String colorMsg = postWriteCallBackData.getColorMsg();
            if (postWriteCallBackData.getIconStampData() != null) {
                c.a.o0.t.h.b.a(getPageContext(), postWriteCallBackData);
                return;
            } else {
                c.a.p0.i3.q0.m.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                return;
            }
        }
        if (getPbModel() != null && !getPbModel().C0()) {
            antiData.setBlock_forum_name(getPbModel().O0().m().getName());
            antiData.setBlock_forum_id(getPbModel().O0().m().getId());
            antiData.setUser_name(getPbModel().O0().U().getUserName());
            antiData.setUser_id(getPbModel().O0().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public final void S1(c.a.p0.i2.h.e eVar) {
        c.a.p0.i2.o.i.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) || (G = eVar.G()) == null || G.p) {
            return;
        }
        c1(G);
    }

    public final void T1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            c.a.p0.i2.o.j.b.c(getPbActivity(), k1(), i2);
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || getPbModel() == null || c.a.e.e.p.k.isEmpty(getPbModel().e1())) {
            return;
        }
        c.a.o0.a.d.y().P(c.a.o0.a.c.W, c.a.e.e.m.b.f(getPbModel().e1(), 0L));
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.s.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.G;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            c2();
        }
    }

    public final void W1() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (layoutParams = this.s.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.G;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.s.setAlpha(0.0f);
            this.s.setVisibility(0);
            e2(layoutParams);
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.r1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mStatusBarBackground, "alpha", 1.0f, 0.0f);
                this.r1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.r1.start();
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.q1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mStatusBarBackground, "alpha", 0.0f, 1.0f);
                this.q1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.q1.start();
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || getPbModel() == null || getPbModel().O0() == null || getPbModel().O0().O() == null) {
            return;
        }
        c.a.o0.s.q.c2 O = getPbModel().O0().O();
        O.W0 = getPbModel().T0();
        O.V0 = getPbModel().W0();
        O.U0 = getPbModel().V0();
        O.X0 = getPbModel().U0();
        O.E2 = getPbModel().C0();
        if (O.T() == 0) {
            O.x3(c.a.e.e.m.b.f(getPbModel().getForumId(), 0L));
        }
        StatisticItem i2 = c.a.o0.l0.c.i(getContext(), O, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public final void Z1(PostData postData, PostData postData2, boolean z2, boolean z3) {
        AbsPbActivity.e n2;
        PostData firstPostData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String e12 = getPbModel().e1();
            String E = postData.E();
            String E2 = postData2 != null ? postData2.E() : "";
            int V = getPbModel().O0() != null ? getPbModel().O0().V() : 0;
            if (getReplyFragment() != null && getReplyFragment().getRichViewHepler() != null) {
                n2 = getReplyFragment().getRichViewHepler().n(E);
            } else if (getDetailInfoAndReplyFragment() == null || getDetailInfoAndReplyFragment().getRichViewHepler() == null) {
                return;
            } else {
                n2 = getDetailInfoAndReplyFragment().getRichViewHepler().n(E);
            }
            AbsPbActivity.e eVar = n2;
            if (postData == null || getPbModel() == null || getPbModel().O0() == null || eVar == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(e12, E, "pb", true, isCommentFloatPage(), null, false, E2, V, postData.O(), getPbModel().O0().d(), false, postData.t().getIconInfo(), getFromVideoPageType()).addBigImageData(eVar.f54625a, eVar.f54626b, eVar.f54631g, eVar.f54634j);
            boolean z4 = true;
            if (z3) {
                addBigImageData.setHighLightPostId(E2);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(getPbModel().getForumId());
            addBigImageData.setTiebaPlusData(getPbModel().E(), getPbModel().A(), getPbModel().B(), getPbModel().z(), getPbModel().F());
            addBigImageData.setBjhData(getPbModel().i0());
            addBigImageData.setKeyPageStartFrom(getPbModel().N0());
            addBigImageData.setFromFrsForumId(getPbModel().getFromForumId());
            addBigImageData.setWorksInfoData(getPbModel().i1());
            addBigImageData.setIsOpenEditor(z2);
            if (getPbModel().O0().p() != null) {
                addBigImageData.setHasForumRule(getPbModel().O0().p().has_forum_rule.intValue());
            }
            if (getPbModel().O0().U() != null) {
                addBigImageData.setIsManager(getPbModel().O0().U().getIs_manager());
            }
            if (getPbModel().O0().m().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(getPbModel().O0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(getPbModel().O0().m().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (getPbModel().O0().m() != null) {
                addBigImageData.setForumHeadUrl(getPbModel().O0().m().getImage_url());
                addBigImageData.setUserLevel(getPbModel().O0().m().getUser_level());
            }
            if (getPbModel() != null && (firstPostData = getFirstPostData(getPbModel().O0())) != null) {
                if (!firstPostData.S && !postData.S) {
                    z4 = false;
                }
                addBigImageData.setMainPostMaskVisibly(z4);
            }
            if (isCommentFloatPage() && this.f55129e.getIntent() != null) {
                addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.f55129e.getIntent().getSerializableExtra("key_from_video_page_id"));
            }
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public final void a1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048603, this, z2) == null) || getPbModel() == null || getPbModel().O0() == null || getPbModel().O0().O() == null) {
            return;
        }
        c.a.o0.s.q.c2 O = getPbModel().O0().O();
        O.W0 = getPbModel().T0();
        O.V0 = getPbModel().W0();
        O.U0 = getPbModel().V0();
        O.X0 = getPbModel().U0();
        if (O.T() == 0) {
            O.x3(c.a.e.e.m.b.f(getPbModel().getForumId(), 0L));
        }
        StatisticItem i2 = c.a.o0.l0.c.i(getContext(), O, "c13563");
        TbPageTag l2 = c.a.o0.l0.c.l(getContext());
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
            c.a.o0.k0.c k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(i2);
        }
        if (i2 != null) {
            if (getFromVideoPageType() == 1) {
                i2.param("obj_locate", 4);
            } else if (getFromVideoPageType() == 2) {
                i2.param("obj_locate", 5);
            } else if (getFromVideoPageType() == 3) {
                i2.param("obj_locate", 2);
            } else if (getFromVideoPageType() == 4) {
                i2.param("obj_locate", 3);
            } else {
                i2.param("obj_locate", 6);
            }
            i2.param("obj_type", 1);
            i2.param("tid", getPbModel().e1());
            i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i2.param("fid", getPbModel().O0().n());
            TiebaStatic.log(i2);
        }
        StatisticItem i3 = c.a.o0.l0.c.i(getContext(), O, "c14180");
        if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i3.param("obj_type", 2);
        } else {
            i3.param("obj_type", 1);
        }
        i3.param("tid", getPbModel().e1());
        i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
        i3.param("fid", getPbModel().O0().n());
        if (l2 != null) {
            i3.param("obj_source", l2.tabType);
        }
        TiebaStatic.log(i3);
        StatisticItem i4 = c.a.o0.l0.c.i(getContext(), O, "c14303");
        if (i4 != null) {
            if (getFromVideoPageType() == 1) {
                i4.param("obj_locate", 1);
            } else if (getFromVideoPageType() == 2) {
                i4.param("obj_locate", 2);
            } else if (getFromVideoPageType() == 3) {
                i4.param("obj_locate", 3);
            } else if (getFromVideoPageType() == 4) {
                i4.param("obj_locate", 4);
            }
            i3.param("tid", getPbModel().e1());
            i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i3.param("fid", getPbModel().O0().n());
            i3.param("obj_type", 1);
        }
        TiebaStatic.log(i4);
    }

    public final void a2() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (absPbActivity = this.f55129e) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
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
    public final void b1(c.a.o0.s.q.c2 c2Var) {
        double d3;
        int ceil;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        Rect h02;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, c2Var) == null) {
            double k2 = c.a.e.e.p.l.k(getContext());
            double i3 = (2.0d * k2) / c.a.e.e.p.l.i(getContext());
            if (c2Var != null && c2Var.o1() != null) {
                int intValue = c2Var.o1().video_width.intValue();
                int intValue2 = c2Var.o1().video_height.intValue();
                if (intValue2 > 0) {
                    d3 = (intValue * 1.0f) / intValue2;
                    if (d3 > 1.7777777777777777d) {
                        d3 = 1.7777777777777777d;
                    }
                    if (d3 >= i3) {
                        i3 = d3;
                    }
                    ceil = (int) Math.ceil(k2 / i3);
                    int height = (getPbModel() != null || (h02 = getPbModel().h0()) == null) ? ceil : h02.height();
                    i2 = 0;
                    layoutParams = this.m.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, height);
                    } else {
                        i2 = layoutParams.height - height;
                        layoutParams.height = height;
                    }
                    this.m.setLayoutParams(layoutParams);
                    this.m.setMaxHeight(ceil);
                    this.m.setMinHeight((int) Math.ceil(k2 / 1.7777777777777777d));
                    this.m.setOriginHeight(height);
                    if (isShowDoubleTab() && !c.a.o0.e1.b.e.d()) {
                        layoutParams3 = (RelativeLayout.LayoutParams) this.f55132h.getLayoutParams();
                        if (layoutParams3 != null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, G1);
                        } else {
                            layoutParams3.height = G1;
                        }
                        this.f55132h.setLayoutParams(layoutParams3);
                    }
                    layoutParams2 = (CoordinatorLayout.LayoutParams) this.mAppBarLayout.getLayoutParams();
                    if (isShowDoubleTab() && !c.a.o0.e1.b.e.d()) {
                        ceil += G1;
                    }
                    if (layoutParams2 != null) {
                        layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).height = ceil;
                    }
                    this.mAppBarLayout.setLayoutParams(layoutParams2);
                    if (i2 == 0 && (this.mAppBarLayout.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.mAppBarLayout.getLayoutParams()).getBehavior();
                        if (behavior instanceof VideoZoomBehavior) {
                            ((VideoZoomBehavior) behavior).setTopAndBottomOffset(-i2);
                            return;
                        }
                        return;
                    }
                }
            }
            d3 = 1.7777777777777777d;
            if (d3 > 1.7777777777777777d) {
            }
            if (d3 >= i3) {
            }
            ceil = (int) Math.ceil(k2 / i3);
            if (getPbModel() != null) {
            }
            i2 = 0;
            layoutParams = this.m.getLayoutParams();
            if (layoutParams != null) {
            }
            this.m.setLayoutParams(layoutParams);
            this.m.setMaxHeight(ceil);
            this.m.setMinHeight((int) Math.ceil(k2 / 1.7777777777777777d));
            this.m.setOriginHeight(height);
            if (isShowDoubleTab()) {
                layoutParams3 = (RelativeLayout.LayoutParams) this.f55132h.getLayoutParams();
                if (layoutParams3 != null) {
                }
                this.f55132h.setLayoutParams(layoutParams3);
            }
            layoutParams2 = (CoordinatorLayout.LayoutParams) this.mAppBarLayout.getLayoutParams();
            if (isShowDoubleTab()) {
                ceil += G1;
            }
            if (layoutParams2 != null) {
            }
            this.mAppBarLayout.setLayoutParams(layoutParams2);
            if (i2 == 0) {
            }
        }
    }

    public final boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (getPbModel() == null) {
                return true;
            }
            if (getPbModel().O0() == null || !getPbModel().O0().f0()) {
                if (getPbModel().A0()) {
                    MarkData m02 = getPbModel().m0();
                    if (m02 != null && getPbModel().y0() && getRecyclerView() != null) {
                        MarkData g02 = getPbModel().g0(getRecyclerView().getFirstVisiblePosition());
                        if (g02 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", m02);
                            this.f55129e.setResult(-1, intent);
                            return true;
                        } else if (g02.getPostId() != null && !g02.getPostId().equals(m02.getPostId())) {
                            c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(getBaseFragmentActivity());
                            aVar.setMessage(getPageContext().getString(R.string.alert_update_mark));
                            aVar.setPositiveButton(R.string.confirm, new u(this, g02, m02, aVar));
                            aVar.setNegativeButton(R.string.cancel, new w(this, m02, aVar));
                            aVar.setOnCalcelListener(new x(this));
                            aVar.create(getBaseFragmentActivity().getPageContext());
                            aVar.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", m02);
                            this.f55129e.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (getPbModel().O0() != null && getPbModel().O0().F() != null && getPbModel().O0().F().size() > 0 && getPbModel().y0()) {
                    this.f55129e.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void c1(c.a.p0.i2.o.i.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, aVar) == null) && aVar != null && this.t == null) {
            this.t = aVar;
            this.A.setText(aVar.getTitle());
            this.B.setText(aVar.p());
            String o2 = aVar.o();
            TBSpecificationBtn tBSpecificationBtn = this.D;
            if (TextUtils.isEmpty(o2)) {
                o2 = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(o2);
            this.E.startLoad(aVar.i(), 10, false);
            this.F.setVisibility(aVar.q() ? 0 : 8);
            c.a.e.e.m.e.a().postDelayed(new o1(this), aVar.g().longValue() * 1000);
        }
    }

    public final void c2() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (layoutParams = this.s.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.H;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.H = ofFloat;
            ofFloat.addUpdateListener(new p1(this));
            this.H.setDuration(200L);
            this.H.start();
            this.H.addListener(new q1(this, layoutParams));
        }
    }

    public void checkEasterEgg(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048609, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) instanceof PostData) && (postData = (PostData) bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition)) != null && postData.p() != null) {
                        postData.p().j(postData.A());
                        arrayList.add(postData.p());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new c2(this));
                if (((c.a.o0.u.a) ListUtils.getItem(arrayList, 0)).c() != 1) {
                    stopFallingRedpacket();
                    performFallingRedpacket((c.a.o0.u.a) ListUtils.getItem(arrayList, 0), 1);
                } else if (z2) {
                } else {
                    stopFallingRedpacket();
                    performFallingRedpacket((c.a.o0.u.a) ListUtils.getItem(arrayList, 0), 0);
                }
            }
        }
    }

    public boolean checkPrivacyBeforeInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if ((getPbModel() != null && getPbModel().O0().f0()) || this.mReplyPrivacyController == null || getPbModel() == null || getPbModel().O0() == null || ThreadCardUtils.isSelf(getPbModel().O0().O()) || getPbModel().O0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(getPbModel().O0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public boolean checkPrivacyBeforePost(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            if (this.mReplyPrivacyController == null || getPbModel() == null || getPbModel().O0() == null || ThreadCardUtils.isSelf(getPbModel().O0().O()) || getPbModel().O0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeSend(getPbModel().O0().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public void clickCommentReply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (!checkUpIsLogin()) {
                if (getPbModel() != null) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", getPbModel().getForumId()));
                }
            } else if (checkPrivacyBeforeInput()) {
                c.a.o0.x.w.e eVar = this.D0;
                if (eVar != null && (eVar.C() || this.D0.E())) {
                    this.D0.A(false, null);
                    return;
                }
                if (this.E0 != null) {
                    initPbEditor();
                    this.r0.f55160a = false;
                    if (this.E0.findToolById(2) != null) {
                        c.a.p0.i3.g0.a.c(getPageContext(), (View) this.E0.findToolById(2).k, false, null);
                    }
                }
                hideCommonView();
            }
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || getPbModel() == null || this.f55129e == null) {
            return;
        }
        c.a.o0.x.w.e eVar = this.D0;
        if (eVar == null || !eVar.z) {
            c.a.o0.x.w.d dVar = new c.a.o0.x.w.d();
            N1(dVar);
            c.a.o0.x.w.e eVar2 = (c.a.o0.x.w.e) dVar.a(getContext());
            this.D0 = eVar2;
            eVar2.f0(this.f55129e.getPageContext());
            this.D0.o0(this.e1);
            this.D0.p0(this.v1);
            this.D0.G(this.f55129e.getPageContext(), this.f55129e.getIntent() == null ? null : this.f55129e.getIntent().getExtras());
            this.D0.a().showLinePositionBottom(true);
            setEditorTools(this.D0.a());
            if (!getPbModel().C0()) {
                this.D0.t(getPbModel().e1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.D0.l0(TbSingleton.getInstance().getAdVertiComment());
            } else if (getPbModel().n1()) {
                this.D0.l0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.D0.l0(getReplyHint());
            }
        }
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.G = ofFloat;
            ofFloat.setDuration(300L);
            this.G.addUpdateListener(new v1(this));
            this.G.start();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048615, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (c.a.o0.d1.m.e[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), c.a.o0.d1.m.e.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (c.a.p0.i2.k.e.x0.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new c.a.o0.d1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public void delGodReplyFloor(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bVar) == null) {
            List<PostData> list = getPbModel().O0().T().f18797a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).M().size()) {
                        break;
                    } else if (bVar.f56806g.equals(list.get(i2).M().get(i3).E())) {
                        list.get(i2).M().remove(i3);
                        list.get(i2).l();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).n(bVar.f56806g);
            }
            if (z2) {
                if (getDetailInfoAndReplyFragment() != null) {
                    getDetailInfoAndReplyFragment().invalidataData();
                } else if (isShowDoubleTab() && getReplyFragment() != null) {
                    getReplyFragment().invalidataData();
                }
            }
        }
    }

    public void deleteThread(c.a.o0.s.s.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, aVar, jSONArray) == null) {
            aVar.dismiss();
            if (getPbModel() == null || getPbModel().O0() == null || getPbModel().O0().O() == null || getPbModel().O0().m() == null) {
                return;
            }
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

    public void deleteThreadDirect(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                deleteThread(sparseArray, (JSONArray) null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            PbModel pbModel = getPbModel();
            if (pbModel == null || pbModel.O0() == null) {
                return false;
            }
            c.a.o0.s.q.c2 O = pbModel.O0().O();
            pbModel.O0().d();
            return AntiHelper.b(getPageContext(), O);
        }
        return invokeV.booleanValue;
    }

    public final void e2(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, layoutParams) == null) {
            ViewGroup.LayoutParams layoutParams2 = this.mAppBarLayout.getLayoutParams();
            int i2 = layoutParams2.height;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.G = ofFloat;
            ofFloat.addUpdateListener(new t1(this, layoutParams, layoutParams2, i2));
            this.G.setDuration(300L);
            this.G.start();
            this.G.addListener(new u1(this));
        }
    }

    public void expandVideo(boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048622, this, z2) == null) || (appBarLayout = this.mAppBarLayout) == null) {
            return;
        }
        appBarLayout.setExpanded(z2);
    }

    public final boolean f1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void f2(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, layoutParams) == null) {
            ViewGroup.LayoutParams layoutParams2 = this.mAppBarLayout.getLayoutParams();
            int i2 = layoutParams2.height;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.G = ofFloat;
            ofFloat.addUpdateListener(new r1(this, layoutParams, layoutParams2, i2));
            this.G.setDuration(300L);
            this.G.start();
            this.G.addListener(new s1(this));
        }
    }

    @Override // c.a.p0.i2.o.b
    public void finish() {
        CardHListViewData r2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            PbModel pbModel = this.f55129e.getPbModel();
            if (pbModel != null && pbModel.O0() != null && !pbModel.O0().f0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = pbModel.O0().O().f0();
                if (pbModel.isShareThread() && pbModel.O0().O().v1 != null) {
                    historyMessage.threadName = pbModel.O0().O().v1.f47196b;
                } else {
                    historyMessage.threadName = pbModel.O0().O().getTitle();
                }
                if (pbModel.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = pbModel.O0().m().getName();
                }
                ArrayList<PostData> F = pbModel.O0().F();
                int firstItem = getReplyFragment() != null ? getReplyFragment().getFirstItem() : 0;
                if (F != null && firstItem >= 0 && firstItem < F.size()) {
                    historyMessage.postID = F.get(firstItem).E();
                }
                historyMessage.isHostOnly = pbModel.s0();
                historyMessage.isSquence = pbModel.c1();
                historyMessage.isShareThread = pbModel.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            c.a.o0.x.w.e eVar = this.D0;
            if (eVar != null) {
                eVar.J();
            }
            if (pbModel != null && (pbModel.u0() || pbModel.x0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", pbModel.e1());
                if (this.v0) {
                    if (this.x0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", pbModel.D0());
                    }
                    if (this.w0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", pbModel.z0());
                    }
                }
                if (pbModel.O0() != null && System.currentTimeMillis() - this.f55130f >= 40000 && (r2 = pbModel.O0().r()) != null && !ListUtils.isEmpty(r2.getDataList())) {
                    intent.putExtra("guess_like_data", r2);
                }
                this.f55129e.setResult(-1, intent);
            }
            if (b2()) {
                if (pbModel != null) {
                    c.a.p0.i2.h.e O0 = pbModel.O0();
                    if (O0 != null) {
                        if (O0.U() != null) {
                            O0.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!this.y0) {
                            if (this.m != null) {
                                Rect rect = new Rect();
                                this.m.getGlobalVisibleRect(rect);
                                c.a.p0.i2.k.e.l0.b().t(rect);
                            }
                            c.a.p0.i2.k.e.l0.b().s(this.f55133i.getCurrentItem());
                            BdTypeRecyclerView recyclerView = getRecyclerView();
                            c.a.p0.i2.k.e.l0.b().n(pbModel.P0(), recyclerView != null ? recyclerView.onSaveInstanceState() : null, pbModel.c1(), pbModel.s0(), false);
                        }
                    }
                } else {
                    c.a.p0.i2.k.e.l0.b().m();
                }
                a2();
            }
        }
    }

    public void finishForumManageProcess(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.success));
            } else if (z3) {
                if (c.a.e.e.p.k.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                }
                showToast(str);
            }
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            if (getPbModel().u0() || getPbModel().x0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", getPbModel().e1());
                this.f55129e.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, getPbModel().e1()));
            if (b2()) {
                this.f55129e.finish();
            }
        }
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || getPbModel() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.B(getPbModel().getForumId()) || getPbModel().O0() == null || getPbModel().O0().m() == null) {
            return;
        }
        if (getPbModel().O0().m().isLike() == 1) {
            getPbModel().d0().A(getPbModel().getForumId(), getPbModel().e1());
        }
    }

    public c.a.o0.t.e.a getAttentionModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.Q : (c.a.o0.t.e.a) invokeV.objValue;
    }

    public LinearLayout getCommentReplyLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.i0 : (LinearLayout) invokeV.objValue;
    }

    public DetailInfoAndReplyFragment getDetailInfoAndReplyFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f55134j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.getFragmentByIndex(0) instanceof DetailInfoAndReplyFragment)) {
                return null;
            }
            return (DetailInfoAndReplyFragment) this.f55134j.getFragmentByIndex(0);
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public DetailInfoFragment getDetailInfoFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f55134j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.getFragmentByIndex(0) instanceof DetailInfoFragment)) {
                return null;
            }
            return (DetailInfoFragment) this.f55134j.getFragmentByIndex(0);
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    public PostData getFirstPostData(c.a.p0.i2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, eVar)) == null) {
            PostData postData = null;
            if (eVar == null) {
                return null;
            }
            if (eVar.W() != null) {
                return eVar.W();
            }
            if (!ListUtils.isEmpty(eVar.F())) {
                Iterator<PostData> it = eVar.F().iterator();
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
                postData = n1(eVar);
            }
            if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
                postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public abstract int getFromVideoPageType();

    @Override // c.a.o0.d1.m.g
    public c.a.e.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (this.T == null) {
                this.T = new c.a.e.e.k.b<>(new x1(this), 20, 0);
            }
            return this.T;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.d1.m.g
    public c.a.e.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (this.V == null) {
                this.V = new c.a.e.e.k.b<>(new w1(this), 8, 0);
            }
            return this.V;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public abstract int getInflateLayoutId();

    public boolean getIsLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.K : invokeV.booleanValue;
    }

    public boolean getLinkGoodsMoreShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.r : invokeV.booleanValue;
    }

    @Override // c.a.o0.d1.m.g
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public View.OnClickListener getListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.listener : (View.OnClickListener) invokeV.objValue;
    }

    public View.OnClickListener getManageOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.w1 : (View.OnClickListener) invokeV.objValue;
    }

    public SparseArray<Object> getManagerOrDeleteTag(c.a.p0.i2.h.e eVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData firstPostData;
        c.a.o0.s.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048643, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (eVar == null || (firstPostData = getFirstPostData(eVar)) == null) {
                return null;
            }
            String userId = firstPostData.t().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, firstPostData.E());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (firstPostData.t() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, firstPostData.t().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, firstPostData.t().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, firstPostData.t().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, firstPostData.E());
                }
                sparseArray.put(R.id.tag_del_post_id, firstPostData.E());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<c.a.o0.s.q.y1> q2 = eVar.q();
                if (ListUtils.getCount(q2) > 0) {
                    sb = new StringBuilder();
                    for (c.a.o0.s.q.y1 y1Var : q2) {
                        if (y1Var != null && !StringUtils.isNull(y1Var.getForumName()) && (e0Var = y1Var.f14098g) != null && e0Var.f13895a && !e0Var.f13897c && ((i3 = e0Var.f13896b) == 1 || i3 == 2)) {
                            sb.append(c.a.e.e.p.k.cutString(y1Var.getForumName(), 12));
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

    public c.a.o0.i.a getMarkModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.N : (c.a.o0.i.a) invokeV.objValue;
    }

    public View.OnLongClickListener getOnLongClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.E1 : (View.OnLongClickListener) invokeV.objValue;
    }

    public View.OnTouchListener getOnTouchListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.t1 : (View.OnTouchListener) invokeV.objValue;
    }

    @Override // c.a.p0.i2.o.b
    public AbsPbActivity getPbActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.f55129e : (AbsPbActivity) invokeV.objValue;
    }

    public c.a.o0.x.w.e getPbEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.D0 : (c.a.o0.x.w.e) invokeV.objValue;
    }

    @Override // c.a.p0.i2.o.b
    public PbFragment getPbFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    @Override // c.a.p0.i2.o.b
    public PbModel.g getPbFragmentDataCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.S0 : (PbModel.g) invokeV.objValue;
    }

    @Override // c.a.p0.i2.o.b
    public PbModel getPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.f55129e.getPbModel() : (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public BdTypeRecyclerView getRecyclerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            Iterator<BaseFragment> it = this.f55134j.getFragments().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).getListView();
                }
                if (next instanceof ReplyFragment) {
                    return ((ReplyFragment) next).getListView();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // c.a.o0.d1.m.g
    public c.a.e.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            c.a.e.e.k.b<RelativeLayout> bVar = new c.a.e.e.k.b<>(new b2(this), 10, 0);
            this.Y = bVar;
            return bVar;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public ReplyFragment getReplyFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f55134j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.getFragmentByIndex(1) instanceof ReplyFragment)) {
                return null;
            }
            return (ReplyFragment) this.f55134j.getFragmentByIndex(1);
        }
        return (ReplyFragment) invokeV.objValue;
    }

    public String getReplyHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            if (!c.a.e.e.p.k.isEmpty(this.s0)) {
                return this.s0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(c.a.p0.i2.k.e.q0.c());
            this.s0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.d1.m.g
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.o0.d1.m.g
    public c.a.e.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            if (this.U == null) {
                this.U = TbRichTextView.createTextViewPool(getPageContext().getPageActivity(), 8);
            }
            return this.U;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.d1.m.g
    public c.a.e.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            if (this.X == null) {
                this.X = new c.a.e.e.k.b<>(new a2(this), 15, 0);
            }
            return this.X;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.d1.m.g
    public c.a.e.e.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return null;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    @Override // c.a.p0.i2.o.b
    public AbsVideoPbFragment getVideoPbFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            if (this.S == null) {
                this.S = VoiceManager.instance();
            }
            return this.S;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // c.a.o0.d1.m.g
    public c.a.e.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (this.W == null) {
                this.W = new c.a.e.e.k.b<>(new z1(this), 8, 0);
            }
            return this.W;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public final void h1(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048664, this, bVar, z2) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f56801b) ? bVar.f56801b : getString(R.string.delete_fail);
            int i2 = 0;
            if (bVar.f56802c == 1211066) {
                hideProgressBar();
                c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(R.string.dialog_known, new s(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else {
                finishForumManageProcess(0, bVar.f56800a, bVar.f56801b, z2);
            }
            if (bVar.f56800a) {
                int i3 = bVar.f56803d;
                if (i3 == 1) {
                    ArrayList<PostData> F = getPbModel().O0().F();
                    int size = F.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.f56806g.equals(F.get(i2).E())) {
                            F.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    getPbModel().O0().O().d4(getPbModel().O0().O().S0() - 1);
                    if (getDetailInfoAndReplyFragment() != null) {
                        getDetailInfoAndReplyFragment().invalidataData();
                    } else if (isShowDoubleTab() && getReplyFragment() != null) {
                        getReplyFragment().invalidataData();
                    }
                } else if (i3 == 0) {
                    g1();
                } else if (i3 == 2) {
                    ArrayList<PostData> F2 = getPbModel().O0().F();
                    int size2 = F2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= F2.get(i4).M().size()) {
                                break;
                            } else if (bVar.f56806g.equals(F2.get(i4).M().get(i5).E())) {
                                F2.get(i4).M().remove(i5);
                                F2.get(i4).l();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        F2.get(i4).n(bVar.f56806g);
                    }
                    if (z3) {
                        if (getDetailInfoAndReplyFragment() != null) {
                            getDetailInfoAndReplyFragment().invalidataData();
                        } else if (isShowDoubleTab() && getReplyFragment() != null) {
                            getReplyFragment().invalidataData();
                        }
                    }
                    delGodReplyFloor(bVar);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0204  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleShare(boolean z2) {
        c.a.p0.i2.h.e O0;
        int i2;
        c.a.p0.i2.p.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048665, this, z2) == null) || getPbModel() == null || this.mDialogController == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (O0 = getPbModel().O0()) == null) {
            return;
        }
        c.a.o0.s.q.c2 O = O0.O();
        if (O != null && O.J() != null) {
            TiebaStatic.log(new StatisticItem("c13402").param("tid", getPbModel().e1()).param("fid", O0.n()).param("obj_locate", 4).param("uid", O.J().getUserId()));
            if (isCommentFloatPage()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", getPbModel().getForumId());
                statisticItem.param("tid", getPbModel().e1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", l1());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", getFromVideoPageType());
                TiebaStatic.log(statisticItem);
            }
        }
        if (O != null) {
            if (O.J1()) {
                i2 = 2;
            } else if (O.M1()) {
                i2 = 3;
            } else if (O.K1()) {
                i2 = 4;
            } else if (O.L1()) {
                i2 = 5;
            }
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem2.param("tid", getPbModel().e1());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("fid", getPbModel().getForumId());
            if (!z2) {
                statisticItem2.param("obj_locate", 6);
            } else {
                statisticItem2.param("obj_locate", 5);
            }
            statisticItem2.param("obj_name", i2);
            statisticItem2.param("obj_type", 2);
            if (O != null) {
                if (O.J1()) {
                    statisticItem2.param("obj_type", 10);
                } else if (O.M1()) {
                    statisticItem2.param("obj_type", 9);
                } else if (O.L1()) {
                    statisticItem2.param("obj_type", 8);
                } else if (O.K1()) {
                    statisticItem2.param("obj_type", 7);
                } else if (O.w1) {
                    statisticItem2.param("obj_type", 6);
                } else {
                    int i3 = O.a0;
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
                statisticItem2.param("nid", O.D0());
                statisticItem2.param("card_type", O.O0());
                statisticItem2.param("recom_source", O.U0);
                statisticItem2.param("ab_tag", O.W0);
                statisticItem2.param("weight", O.V0);
                statisticItem2.param("extra", O.X0);
                statisticItem2.param("nid", O.D0());
                if (O.L() != null && !c.a.e.e.p.k.isEmpty(O.L().oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, O.L().oriUgcVid);
                }
            }
            if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (getPbActivity() != null) {
                c.a.o0.l0.c.e(getPbActivity(), statisticItem2);
            }
            hVar = this.o0;
            if (hVar != null) {
                statisticItem2.param("obj_param1", hVar.f());
            }
            TiebaStatic.log(statisticItem2);
            if (c.a.e.e.p.l.D()) {
                showToast(R.string.neterror);
                return;
            } else if (getPbModel().O0() == null) {
                c.a.e.e.p.l.M(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                return;
            } else {
                ArrayList<PostData> F = O0.F();
                if ((F == null || F.size() <= 0) && getPbModel().c1()) {
                    c.a.e.e.p.l.M(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                    return;
                }
                this.mDialogController.F();
                stopVoice();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), O)) {
                    return;
                }
                c.a.p0.i2.p.h hVar2 = this.o0;
                if (hVar2 != null) {
                    hVar2.k(false);
                    updateBottomShareStateUI(O0);
                }
                if (ShareSwitch.isOn()) {
                    int i4 = z2 ? 2 : 1;
                    if (this.o0.h()) {
                        this.o0.l(false);
                        p1(c.a.o0.t.g.f.a(), this.o0.f());
                        return;
                    }
                    T1(i4);
                    return;
                }
                this.mDialogController.B0();
                getPbModel().k0().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                return;
            }
        }
        i2 = 1;
        StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem22.param("tid", getPbModel().e1());
        statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem22.param("fid", getPbModel().getForumId());
        if (!z2) {
        }
        statisticItem22.param("obj_name", i2);
        statisticItem22.param("obj_type", 2);
        if (O != null) {
        }
        if (!c.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
        }
        if (getPbActivity() != null) {
        }
        hVar = this.o0;
        if (hVar != null) {
        }
        TiebaStatic.log(statisticItem22);
        if (c.a.e.e.p.l.D()) {
        }
    }

    public void hideCommonView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048666, this) == null) || this.c0 == null) {
            return;
        }
        this.b0.setVisibility(8);
        this.c0.setVisibility(8);
        this.r0.f55160a = false;
        H1();
        J1();
    }

    public void hideDraftTip(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048667, this, z2) == null) || this.c0 == null || this.k0 == null) {
            return;
        }
        if (getPbModel() != null && getPbModel().O0() != null) {
            this.k0.setText(TbSingleton.getInstance().getAdVertiComment(getPbModel().O0().j0(), getPbModel().O0().k0(), getReplyHint()));
        } else {
            this.k0.setText(getReplyHint());
        }
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.c0.startAnimation(alphaAnimation);
        }
        this.b0.setVisibility(0);
        this.c0.setVisibility(0);
        this.r0.f55160a = true;
    }

    public void hideEditTool() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048668, this) == null) || (editorTools = this.E0) == null) {
            return;
        }
        editorTools.hide();
    }

    public void hideKeyBroad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048669, this) == null) || this.f55129e.getCurrentFocus() == null) {
            return;
        }
        c.a.e.e.p.l.x(getPageContext().getPageActivity(), this.f55129e.getCurrentFocus());
    }

    public void hideProgressView() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048670, this) == null) || (view = this.L) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void hideRightFloatLayerView() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048671, this) == null) || (rightFloatLayerView = this.Q0) == null) {
            return;
        }
        rightFloatLayerView.completeHide();
    }

    public void hideToolInEditor() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048672, this) == null) || (editorTools = this.E0) == null) {
            return;
        }
        editorTools.hideTools();
    }

    public final void i1(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048673, this, i2, gVar) == null) || gVar == null || getPbModel() == null || getPbModel().O0() == null || getPbModel().O0().O() == null) {
            return;
        }
        finishForumManageProcess(this.R.getLoadDataMode(), gVar.f56822a, gVar.f56823b, false);
        if (gVar.f56822a) {
            this.v0 = true;
            if (i2 == 2 || i2 == 3) {
                this.w0 = true;
                this.x0 = false;
            } else if (i2 == 4 || i2 == 5) {
                this.w0 = false;
                this.x0 = true;
            }
            if (i2 == 2) {
                getPbModel().O0().O().O3(1);
                getPbModel().b2(1);
            } else if (i2 == 3) {
                getPbModel().O0().O().O3(0);
                getPbModel().b2(0);
            } else if (i2 == 4) {
                getPbModel().O0().O().P3(1);
                getPbModel().c2(1);
            } else if (i2 == 5) {
                getPbModel().O0().O().P3(0);
                getPbModel().c2(0);
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.f56823b)) {
                string = gVar.f56823b;
            } else {
                string = getString(R.string.operation_failed);
            }
            c.a.e.e.p.l.M(getPageContext().getPageActivity(), string);
        }
        if (isShowDoubleTab()) {
            if (getPbModel().O0().O() == null || getDetailInfoFragment() == null) {
                return;
            }
            getDetailInfoFragment().refreshFirstFloor();
        } else if (getPbModel().O0().O() == null || getDetailInfoAndReplyFragment() == null) {
        } else {
            getDetailInfoAndReplyFragment().refreshFirstFloor();
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            c.a.o0.i.a c3 = c.a.o0.i.a.c(this.f55129e);
            this.N = c3;
            if (c3 != null) {
                c3.j(this.T0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f55129e);
            this.R = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.s1);
            this.Q = new c.a.o0.t.e.a(getPageContext());
            this.mDialogController = new c.a.p0.i2.o.g.a(this);
        }
    }

    public void initET() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            setEditorTools(this.D0.a());
        }
    }

    public void initPbEditor() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048676, this) == null) || (editorTools = this.E0) == null) {
            return;
        }
        editorTools.display();
        c.a.o0.x.w.e eVar = this.D0;
        if (eVar != null) {
            eVar.Q();
        }
        hideCommonView();
    }

    public void initRightFloatLayerView(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048677, this, eVar) == null) || this.Q0 == null || eVar == null || eVar.g() == 3 || isCommentFloatPage()) {
            return;
        }
        c.a.p0.i2.o.j.a aVar = new c.a.p0.i2.o.j.a();
        this.y = aVar;
        aVar.e(eVar.k() == null ? null : eVar.k().pbpage);
        this.y.d(TbSingleton.getInstance().getAdFloatViewData());
        hideRightFloatLayerView();
        if (this.Q0.isPbNeedShow()) {
            String a3 = this.y.a(eVar.j0());
            if (StringUtils.isNull(a3)) {
                return;
            }
            this.Q0.setData(a3);
            TiebaStatic.log(new StatisticItem("c14128").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2));
            this.Q0.setLogoListener(new r0(this, this.y.b(eVar.j0())));
            this.Q0.setFeedBackListener(new c1(this));
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            c.a.p0.i0.b bVar = new c.a.p0.i0.b(getActivity());
            this.mDragActionManager = bVar;
            bVar.i(this.u1);
            this.k1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
            v1();
            this.mAppBarLayout = (AppBarLayout) this.f55131g.findViewById(R.id.appbar_layout);
            this.k = this.f55131g.findViewById(R.id.pb_video_pager_shadow);
            this.Q0 = (RightFloatLayerView) this.f55131g.findViewById(R.id.right_layer_view);
            registerListener(this.R0);
            this.m = (VideoContainerLayout) this.f55131g.findViewById(R.id.pb_video_container);
            c.a.p0.i2.o.k.a aVar = new c.a.p0.i2.o.k.a(getContext(), this.m);
            this.operableVideoContainer = aVar;
            aVar.setStageType("2002");
            this.operableVideoContainer.setUniqueId(getUniqueId());
            this.operableVideoContainer.a1(this);
            this.operableVideoContainer.Y0(getPbActivity().getRootView());
            this.operableVideoContainer.Z0(this.mStatusBarBackground);
            ((RelativeLayout) this.f55131g.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((c.a.e.e.p.l.k(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
            this.f55132h = (NewPagerSlidingTabBaseStrip) this.f55131g.findViewById(R.id.pb_video_tab_strip);
            this.s = this.f55131g.findViewById(R.id.pb_video_mount_layout);
            this.f55133i = (CustomViewPager) this.f55131g.findViewById(R.id.pb_video_view_pager);
            this.l = this.f55131g.findViewById(R.id.keyboard_background_shadow);
            this.x = (MaskView) this.f55131g.findViewById(R.id.mask_view);
            this.l.setOnClickListener(this.listener);
            w1();
            u1();
            q1();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.f55134j = videoPbFragmentAdapter;
            this.f55133i.setAdapter(videoPbFragmentAdapter);
            this.f55132h.setViewPager(this.f55133i);
            this.f55132h.setOnPageChangeListener(new s0(this));
            this.L = this.f55131g.findViewById(R.id.viewstub_progress);
            initET();
            t1();
            r1();
            if (!this.k1 && this.l1) {
                X1();
                UtilHelper.hideStatusBar(getPbActivity(), getPbActivity().getRootView());
                this.l1 = false;
            }
            if (!isShowDoubleTab() || c.a.o0.e1.b.e.d()) {
                this.f55132h.getLayoutParams().height = 0;
            }
            if (c.a.o0.e1.b.e.d()) {
                this.f55133i.setScrollable(false);
            }
        }
    }

    public abstract boolean isCommentFloatPage();

    public boolean isEditToolVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            EditorTools editorTools = this.E0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowDoubleTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? (isCommentFloatPage() || getPbModel() == null || !getPbModel().s1()) ? false : true : invokeV.booleanValue;
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            PbModel pbModel = this.f55129e.getPbModel();
            if (pbModel == null) {
                return false;
            }
            return pbModel.u1();
        }
        return invokeV.booleanValue;
    }

    public boolean isStatusBarShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.l1 : invokeV.booleanValue;
    }

    public boolean isToolInEditorVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            EditorTools editorTools = this.E0;
            return editorTools != null && editorTools.isToolVisible();
        }
        return invokeV.booleanValue;
    }

    public boolean isVerticalVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            c.a.p0.i2.o.k.a aVar = this.operableVideoContainer;
            if (aVar == null) {
                return false;
            }
            return aVar.Q0();
        }
        return invokeV.booleanValue;
    }

    public final String j1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048686, this, i2)) == null) {
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

    public final int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            if (getPbModel() == null || getPbModel().O0() == null || getPbModel().O0().O() == null) {
                return -1;
            }
            return getPbModel().O0().O().w();
        }
        return invokeV.intValue;
    }

    public final String l1() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            if (getPbModel() == null || getPbModel().O0() == null || getPbModel().O0().F() == null || (count = ListUtils.getCount((F = getPbModel().O0().F()))) == 0) {
                return "";
            }
            if (getPbModel().Z0()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.E();
                    }
                }
            }
            int i2 = 0;
            if (getRecyclerView() != null) {
                if (isShowDoubleTab()) {
                    if (getReplyFragment() != null) {
                        i2 = getReplyFragment().getFirstItem();
                    }
                } else if (getDetailInfoAndReplyFragment() != null) {
                    i2 = getDetailInfoAndReplyFragment().getFirstItem();
                }
            }
            PostData postData = (PostData) ListUtils.getItem(F, i2);
            if (postData != null && postData.t() != null) {
                if (getPbModel().v1(postData.t().getUserId())) {
                    return postData.E();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                        break;
                    } else if (getPbModel().v1(postData2.t().getUserId())) {
                        return postData2.E();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                        break;
                    } else if (getPbModel().v1(postData3.t().getUserId())) {
                        return postData3.E();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final int m1(int i2) {
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

    public final PostData n1(c.a.p0.i2.h.e eVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048690, this, eVar)) == null) {
            if (eVar == null || eVar.O() == null || eVar.O().J() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData J = eVar.O().J();
            String userId = J.getUserId();
            HashMap<String, MetaData> y12 = eVar.O().y1();
            if (y12 != null && (metaData = y12.get(userId)) != null && metaData.getUserId() != null) {
                J = metaData;
            }
            postData.i0(1);
            postData.l0(eVar.O().W());
            postData.x0(eVar.O().getTitle());
            postData.w0(eVar.O().P());
            postData.g0(J);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final void o1(int i2, Intent intent) {
        c.a.o0.x.n nVar;
        c.a.p0.i2.k.e.u uVar;
        c.a.o0.x.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048691, this, i2, intent) == null) {
            if (i2 == 0) {
                hideEditTool();
                c.a.p0.i2.k.e.u uVar2 = this.F0;
                if (uVar2 != null) {
                    uVar2.c();
                }
                showCommonView(false);
            }
            resetCommentView();
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
                    this.D0.T();
                    this.D0.u0(pbEditorData.getVoiceModel());
                    this.D0.H(writeData);
                    c.a.o0.x.m findToolById = this.D0.a().findToolById(6);
                    if (findToolById != null && (nVar = findToolById.k) != null) {
                        nVar.onAction(new c.a.o0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.D0.M(null, null);
                    }
                } else if (editorType != 1 || (uVar = this.F0) == null || uVar.b() == null) {
                } else {
                    c.a.o0.x.w.h b3 = this.F0.b();
                    b3.a0(getPbModel().O0().O());
                    b3.B(writeData);
                    b3.b0(pbEditorData.getVoiceModel());
                    c.a.o0.x.m findToolById2 = b3.a().findToolById(6);
                    if (findToolById2 != null && (nVar2 = findToolById2.k) != null) {
                        nVar2.onAction(new c.a.o0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b3.F();
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            I1(videoPbViewModel.getData());
            initRightFloatLayerView(videoPbViewModel.getData());
            refreshTabText(videoPbViewModel.getData());
            if (getPbModel() != null && getPbModel().O0() != null) {
                boolean y02 = getPbModel().y0();
                c.a.p0.i2.h.e O0 = getPbModel().O0();
                if (y02) {
                    PostData firstPostData = getFirstPostData(O0);
                    if (O0.u() != null && !O0.u().equals(firstPostData.E()) && this.f55133i != null) {
                        if (isShowDoubleTab()) {
                            this.f55133i.setCurrentItem(1);
                        } else {
                            this.f55133i.setCurrentItem(0);
                        }
                    }
                }
            }
            videoPbViewModel.getVideoData().observe(this, new h0(this));
            videoPbViewModel.getCurrentTab().observe(this, new i0(this));
            videoPbViewModel.getPreVideoData().observe(this, new j0(this));
            videoPbViewModel.getNextVideoData().observe(this, new k0(this));
            videoPbViewModel.getIsDetailTabTop().observe(this, new l0(this));
            videoPbViewModel.getIsShowNavigationBar().observe(this, new m0(this));
            this.f55129e.getTiePlusEventController().addEventAckedCallbackWeaked(this.P0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048693, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.D0.I(i2, i3, intent);
            c.a.p0.i2.k.e.b1.f.a aVar = this.O;
            if (aVar != null) {
                aVar.i(i2, i3, intent);
            }
            c.a.p0.i2.k.e.u uVar = this.F0;
            if (uVar != null) {
                uVar.g(i2, i3, intent);
            }
            if (i2 == 25035) {
                o1(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 11009) {
                    E1();
                } else if (i2 == 13011) {
                    c.a.p0.w2.a.g().m(getPageContext());
                } else if (i2 != 25016 && i2 != 25023 && i2 != 24007 && i2 != 24008) {
                    switch (i2) {
                        case 25055:
                            View view = this.u;
                            if (view != null) {
                                view.performClick();
                                return;
                            }
                            return;
                        case 25056:
                            View view2 = this.v;
                            if (view2 != null) {
                                view2.performClick();
                                return;
                            }
                            return;
                        case 25057:
                            if (getCommentReplyLayout() != null) {
                                getCommentReplyLayout().performClick();
                                return;
                            }
                            return;
                        case 25058:
                            View view3 = this.w;
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
                    this.P = emotionImageData;
                    if (checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        L1(emotionImageData);
                    }
                }
            }
        }
    }

    @Override // c.a.o0.d1.m.g
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048694, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.Z = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, context) == null) {
            super.onAttach(context);
            this.f55129e = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i2) == null) {
            super.onChangeSkinType(i2);
            UtilHelper.changeStatusBarIconAndTextColor(true, this.f55129e);
            getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            getBaseFragmentActivity().getLayoutMode().j(this.f55131g);
            SkinManager.setBackgroundColor(this.mStatusBar, R.color.CAM_X0611);
            SkinManager.setBackgroundColor(this.mStatusBarBackground, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.f55132h, R.color.CAM_X0207);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f55132h;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.onChangeSkinType();
            }
            c.a.p0.i2.k.e.u0 u0Var = this.mContentProcessController;
            if (u0Var != null) {
                u0Var.i();
            }
            c.a.p0.i2.o.e eVar = this.n;
            if (eVar == null || !eVar.k()) {
                SkinManager.setBackgroundColor(this.f55131g, R.color.CAM_X0201);
            }
            EditorTools editorTools = this.E0;
            if (editorTools != null) {
                editorTools.onChangeSkinType(i2);
            }
            c.a.p0.i2.k.e.u uVar = this.F0;
            if (uVar != null) {
                uVar.h(i2);
            }
            RightFloatLayerView rightFloatLayerView = this.Q0;
            if (rightFloatLayerView != null) {
                rightFloatLayerView.onChangeSkinType();
            }
            HeadImageView headImageView = this.j0;
            if (headImageView != null) {
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            }
            LinearLayout linearLayout = this.i0;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.e.e.p.l.g(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (getPbModel() != null && getPbModel().A0()) {
                WebPManager.setPureDrawable(this.m0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.m0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.l0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.C, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (getPbModel() != null) {
                updateBottomShareStateUI(getPbModel().O0());
            }
            SkinManager.setBackgroundResource(this.k, R.drawable.personalize_tab_shadow);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.c0, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.b0, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.B, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k0, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.q0, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.p0, R.color.CAM_X0107);
            TextView textView = this.p0;
            int g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
            int i3 = R.color.CAM_X0207;
            SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3);
            if (getDetailInfoAndReplyFragment() != null) {
                getDetailInfoAndReplyFragment().onChangeSkinType(i2);
            } else if (isShowDoubleTab() && getReplyFragment() != null) {
                getReplyFragment().onChangeSkinType(i2);
            }
            if (getDetailInfoFragment() != null) {
                getDetailInfoFragment().onChangeSkinType(i2);
            }
            View view = this.F;
            if (view != null) {
                view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.e.e.p.l.g(view.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            }
            stopVoice();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            c.a.p0.i2.o.k.a aVar = this.operableVideoContainer;
            if (aVar == null || aVar.Q0()) {
                return;
            }
            if (!(this.operableVideoContainer.isFullScreen() && configuration.orientation == 1) && (this.operableVideoContainer.isFullScreen() || configuration.orientation != 2)) {
                return;
            }
            this.operableVideoContainer.Y(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, bundle) == null) {
            this.f55130f = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            s1(bundle);
            getVoiceManager().onCreate(getPageContext());
            c.a.o0.s.f0.c cVar = new c.a.o0.s.f0.c();
            this.M = cVar;
            cVar.f13570a = 1000L;
            if (this.mDialogController != null) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
                userMuteAddAndDelCustomMessage.from = 1;
                BdUniqueId bdUniqueId = this.mDialogController.D;
                userMuteAddAndDelCustomMessage.mId = bdUniqueId;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
                BdUniqueId bdUniqueId2 = this.mDialogController.D;
                userMuteCheckCustomMessage.mId = bdUniqueId2;
                userMuteCheckCustomMessage.setTag(bdUniqueId2);
                MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            }
            registerListener(this.z1);
            this.q = new c.a.p0.z.a(getPageContext());
            c.a.p0.h3.c.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048699, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f55131g = (RelativeLayout) layoutInflater.inflate(getInflateLayoutId(), viewGroup, false);
            initUI();
            return this.f55131g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            super.onDestroy();
            c.a.p0.h3.c.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.z1);
            getVoiceManager().onDestory(getPageContext());
            c.a.p0.i2.p.h hVar = this.o0;
            if (hVar != null) {
                hVar.j();
            }
            ForumManageModel forumManageModel = this.R;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            c.a.p0.i2.o.k.a aVar = this.operableVideoContainer;
            if (aVar != null) {
                aVar.R0();
            }
            c.a.p0.i2.k.e.b1.f.a aVar2 = this.O;
            if (aVar2 != null) {
                aVar2.f();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.mReplyPrivacyController;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            if (getPbModel() != null) {
                getPbModel().cancelLoadData();
                getPbModel().destory();
                if (getPbModel().K0() != null) {
                    getPbModel().K0().d();
                }
            }
            c.a.o0.x.w.e eVar = this.D0;
            if (eVar != null) {
                eVar.J();
            }
            this.M = null;
            stopFallingRedpacket();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        c.a.p0.i2.o.k.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048701, this, i2, keyEvent)) == null) {
            if (!this.k1 && (this.l1 || y1())) {
                X1();
                UtilHelper.hideStatusBar(getPbActivity(), getPbActivity().getRootView());
                this.l1 = false;
                c.a.p0.i2.o.k.a aVar2 = this.operableVideoContainer;
                if (aVar2 != null) {
                    aVar2.V0(false);
                }
            }
            if (i2 == 4) {
                c.a.p0.i2.o.k.a aVar3 = this.operableVideoContainer;
                if (aVar3 != null) {
                    return aVar3.C();
                }
                return false;
            } else if (i2 == 24) {
                c.a.p0.i2.o.k.a aVar4 = this.operableVideoContainer;
                if (aVar4 != null) {
                    return aVar4.F();
                }
                return false;
            } else if (i2 != 25 || (aVar = this.operableVideoContainer) == null) {
                return false;
            } else {
                return aVar.S0();
            }
        }
        return invokeIL.booleanValue;
    }

    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048702, this, z2) == null) {
            this.l.setVisibility(z2 ? 0 : 8);
        }
    }

    @Override // c.a.o0.d1.m.g
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048703, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.Z = true;
    }

    @Override // c.a.o0.d1.m.g
    public void onLinkClicked(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048704, this, context, str, z2) == null) {
            if (c.a.p0.i2.k.e.x0.c(str) && getPbModel() != null && getPbModel().e1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", getPbModel().e1()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    c.a.o0.u.l lVar = new c.a.o0.u.l();
                    lVar.f14726a = str;
                    lVar.f14727b = 3;
                    lVar.f14728c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, lVar));
                }
            } else {
                c.a.p0.i2.k.e.x0.a().e(getPageContext(), str);
            }
            this.Z = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            super.onPause();
            this.N0 = true;
            getVoiceManager().onPause(getPageContext());
            c.a.p0.i2.o.k.a aVar = this.operableVideoContainer;
            if (aVar != null) {
                aVar.I(true);
            }
            if (getPbModel() != null && !getPbModel().C0()) {
                this.D0.V(getPbModel().e1());
            }
            c.a.o0.a.d.y().E();
            MessageManager.getInstance().unRegisterListener(this.b1);
            MessageManager.getInstance().unRegisterListener(this.c1);
            MessageManager.getInstance().unRegisterListener(this.a1);
            MessageManager.getInstance().unRegisterListener(this.y1);
        }
    }

    @Override // c.a.o0.d1.m.g
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048706, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mDialogController.p0(str);
        c.a.o0.s.s.b R = this.mDialogController.R();
        if (R == null) {
            this.mDialogController.W();
        }
        TiebaStatic.log("pb_show_phonedialog");
        if (str2.equals("2")) {
            R.f(1).setVisibility(8);
        } else {
            R.f(1).setVisibility(0);
        }
        R.m();
        this.Z = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            super.onResume();
            this.N0 = false;
            getVoiceManager().onResume(getPageContext());
            c.a.p0.i2.o.k.a aVar = this.operableVideoContainer;
            if (aVar != null) {
                aVar.I(false);
            }
            U1();
            registerListener(this.b1);
            registerListener(this.c1);
            registerListener(this.a1);
            registerListener(this.y1);
            ItemCardHelper.s(this.B1);
            MessageManager.getInstance().registerListener(this.A1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (getPbModel() != null) {
                getPbModel().U1(bundle);
            }
            if (getPageContext() == null || getPageContext().getPageActivity() == null) {
                return;
            }
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    public void onScrollStateChanged(int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048709, this, i2) == null) {
            if (i2 == 0) {
                c.a.p0.h3.c.g().h(getUniqueId(), false);
                if (getRecyclerView() != null) {
                    checkEasterEgg(getRecyclerView(), true);
                }
            }
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.Q0;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.onScrollIdle();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.Q0;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.onScrollDragging();
                }
            } else if (i2 != 2 || (rightFloatLayerView = this.Q0) == null) {
            } else {
                rightFloatLayerView.onScrollSettling();
            }
        }
    }

    @Override // c.a.o0.d1.m.g
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048710, this, context, str) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048711, this) == null) {
            super.onStart();
            getVoiceManager().onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            super.onStop();
            getVoiceManager().onStop(getPageContext());
            c.a.p0.h3.c.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.A1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048713, this, z2) == null) {
            super.onUserChanged(z2);
            B1();
        }
    }

    @Override // c.a.o0.d1.m.g
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048714, this, context, str) == null) {
            c.a.p0.i2.k.e.x0.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.Z = true;
        }
    }

    @Override // c.a.o0.d1.m.g
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048715, this, context, str) == null) {
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048716, this, z2) == null) || getPbActivity() == null) {
            return;
        }
        if (this.l1 && !TbSingleton.getInstance().isNotchScreen(getPbActivity()) && !TbSingleton.getInstance().isCutoutScreen(getPbActivity())) {
            X1();
            UtilHelper.hideStatusBar(getPbActivity(), getPbActivity().getRootView());
            this.l1 = false;
        }
        this.r0.f55161b = z2;
        H1();
        J1();
    }

    public final void p1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048717, this, i2, i3) == null) {
            c.a.o0.b1.k0.b(new a0(this, i3), new b0(this, i2));
        }
    }

    public void performFallingRedpacket(c.a.o0.u.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048718, this, aVar, i2) == null) && c.a.p0.i2.k.e.q0.a(aVar, i2)) {
            this.J.startLoad(aVar.f(), 10, false);
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.e())).setProgressiveRenderingEnabled(true).build(), getPageContext()).subscribe(new t0(this, aVar, i2), CallerThreadExecutor.getInstance());
        }
    }

    public void processProfessionPermission() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048719, this) == null) || !checkUpIsLogin() || getPbModel() == null || getPbModel().O0() == null || getPbModel().O0().m() == null || e1()) {
            return;
        }
        if (getPbModel().O0().f0()) {
            clickCommentReply();
            return;
        }
        if (this.z0 == null) {
            c.a.p0.v0.f2.a.c cVar = new c.a.p0.v0.f2.a.c(getPageContext());
            this.z0 = cVar;
            cVar.j(0);
            this.z0.i(new g1(this));
        }
        this.z0.g(getPbModel().O0().m().getId(), c.a.e.e.m.b.f(getPbModel().e1(), 0L));
    }

    public final void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            this.a0 = (LinearLayout) this.f55131g.findViewById(R.id.video_pb_comment_container);
            this.b0 = this.f55131g.findViewById(R.id.view_comment_top_line);
            this.c0 = this.f55131g.findViewById(R.id.pb_editor_tool_comment);
            c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
            HeadImageView headImageView = (HeadImageView) this.f55131g.findViewById(R.id.pb_editor_tool_comment_user_image);
            this.j0 = headImageView;
            headImageView.setVisibility(0);
            this.j0.setIsRound(true);
            this.j0.setBorderWidth(c.a.e.e.p.l.g(getContext(), R.dimen.L_X01));
            this.j0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.j0.setPlaceHolder(0);
            B1();
            this.k0 = (TextView) this.f55131g.findViewById(R.id.pb_editor_tool_comment_reply_text);
            LinearLayout linearLayout = (LinearLayout) this.f55131g.findViewById(R.id.pb_editer_tool_comment_layout);
            this.i0 = linearLayout;
            linearLayout.setOnClickListener(new y0(this));
            ImageView imageView = (ImageView) this.f55131g.findViewById(R.id.pb_editor_tool_comment_icon);
            this.l0 = imageView;
            imageView.setOnClickListener(this.listener);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView2 = (ImageView) this.f55131g.findViewById(R.id.pb_editor_tool_collection);
            this.m0 = imageView2;
            imageView2.setOnClickListener(this.listener);
            if (booleanExtra) {
                this.m0.setVisibility(8);
            } else {
                this.m0.setVisibility(0);
            }
            ImageView imageView3 = (ImageView) this.f55131g.findViewById(R.id.pb_editor_tool_share);
            this.n0 = imageView3;
            imageView3.setOnClickListener(this.listener);
            this.o0 = new c.a.p0.i2.p.h(this.n0);
            if (getPbModel() != null && c.a.o0.b.d.X() && !c.a.p0.i2.k.e.f1.b.k(getPbModel().e1())) {
                this.o0.e();
                c.a.p0.i2.k.e.f1.b.b(getPbModel().e1());
            }
            TextView textView = (TextView) this.f55131g.findViewById(R.id.pb_editor_tool_comment_red_dot);
            this.p0 = textView;
            textView.setVisibility(0);
            showCommonView(false);
            if (c.a.o0.e1.b.e.d()) {
                ViewGroup.LayoutParams layoutParams = this.a0.getLayoutParams();
                layoutParams.height = 0;
                this.a0.setLayoutParams(layoutParams);
            }
        }
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            this.G0 = new PbFakeFloorModel(getPageContext());
            PbModel pbModel = getPbModel();
            this.G0.O(pbModel.E(), pbModel.A(), pbModel.B(), pbModel.z(), pbModel.F());
            this.G0.setFromForumId(pbModel.getFromForumId());
            c.a.p0.i2.k.e.u uVar = new c.a.p0.i2.k.e.u(getPageContext(), this.G0, this.f55131g);
            this.F0 = uVar;
            uVar.k(new b1(this));
            this.F0.m(this.mOnFloorPostWriteNewCallback);
            this.G0.Q(new d1(this));
        }
    }

    @Override // c.a.p0.i2.o.a
    public void refresh(boolean z2, int i2, int i3, int i4, c.a.p0.i2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048722, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
        }
    }

    public void refreshAll(boolean z2, int i2, int i3, int i4, c.a.p0.i2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048723, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.f55134j.getFragments()) {
                if (baseFragment instanceof c.a.p0.i2.o.a) {
                    ((c.a.p0.i2.o.a) baseFragment).refresh(z2, i2, i3, i4, eVar, str, i5);
                }
            }
            refresh(z2, i2, i3, i4, eVar, str, i5);
        }
    }

    public void refreshBottomTool(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048724, this, eVar) == null) || eVar == null || eVar.O() == null) {
            return;
        }
        updateBottomShareStateUI(eVar);
        this.m0.setVisibility(eVar.f0() ? 8 : 0);
        if (eVar.s()) {
            WebPManager.setPureDrawable(this.m0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.m0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String j12 = j1(eVar.O().S0());
        TextView textView = this.p0;
        if (textView != null) {
            textView.setText(j12);
        }
        TextView textView2 = this.q0;
        if (textView2 != null) {
            textView2.setText(j12);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.O()));
    }

    public void refreshMark(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048725, this, z2, markData) == null) || getPbModel() == null) {
            return;
        }
        setPostPro();
        getPbModel().m2(z2);
        c.a.o0.i.a aVar = this.N;
        if (aVar != null) {
            aVar.h(z2);
            if (markData != null) {
                this.N.i(markData);
            }
        }
        if (getPbModel().A0()) {
            D1();
        } else if (isShowDoubleTab()) {
            if (getDetailInfoFragment() != null) {
                getDetailInfoFragment().invalidataData();
            }
            if (getReplyFragment() != null) {
                getReplyFragment().invalidataData();
            }
        } else if (getDetailInfoAndReplyFragment() != null) {
            getDetailInfoAndReplyFragment().invalidataData();
        }
    }

    public void refreshTabText(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048726, this, eVar) == null) || eVar == null || eVar.O() == null) {
            return;
        }
        String valueOf = String.valueOf(eVar.O().S0());
        if (eVar.O().S0() == 0) {
            valueOf = "";
        }
        this.f55132h.notifyTailData(valueOf);
    }

    public void refreshWrite(c.a.p0.i2.h.r rVar) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048727, this, rVar) == null) || getPbModel() == null || getPbModel().O0() == null || rVar.i() == null) {
            return;
        }
        String E = rVar.i().E();
        ArrayList<PostData> F = getPbModel().O0().F();
        int i2 = 0;
        while (true) {
            z2 = true;
            if (i2 >= F.size()) {
                break;
            }
            PostData postData = F.get(i2);
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
                            next.z0(getPageContext(), getPbModel().v1(metaData.getUserId()));
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
        if (getPbModel().y0() || !z2) {
            return;
        }
        if (isShowDoubleTab() && getReplyFragment() != null) {
            getReplyFragment().invalidataData();
        } else if (getDetailInfoAndReplyFragment() != null) {
            getDetailInfoAndReplyFragment().invalidataData();
        }
    }

    public final void reset() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048728, this) == null) || this.D0 == null || this.E0 == null) {
            return;
        }
        c.a.o0.x.w.a.a().c(0);
        this.D0.U();
        this.D0.S();
        if (this.D0.z() != null) {
            this.D0.z().setMaxImagesAllowed(this.D0.z ? 1 : 9);
        }
        this.D0.m0(SendView.ALL);
        this.D0.j(SendView.ALL);
        c.a.o0.x.h findLauncherById = this.E0.findLauncherById(23);
        c.a.o0.x.h findLauncherById2 = this.E0.findLauncherById(2);
        c.a.o0.x.h findLauncherById3 = this.E0.findLauncherById(5);
        if (findLauncherById2 != null) {
            findLauncherById2.display();
        }
        if (findLauncherById3 != null) {
            findLauncherById3.display();
        }
        if (findLauncherById != null) {
            findLauncherById.hide();
        }
        this.E0.invalidate();
    }

    public void resetCommentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            reset();
            hideEditTool();
            this.F0.c();
            showCommonView(false);
        }
    }

    public void resetRecordLocation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            this.J0 = -1;
            this.K0 = Integer.MIN_VALUE;
        }
    }

    public boolean richTextHandleSingleTap(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048731, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (!TextUtils.isEmpty(postData.u()) && c.a.o0.s.k.c().g()) {
                        return F1(postData.E());
                    }
                    if (checkUpIsLogin() && getPbModel() != null && getPbModel().O0() != null) {
                        c.a.p0.i2.k.e.u uVar = this.F0;
                        if (uVar != null) {
                            uVar.c();
                        }
                        c.a.p0.i2.h.r rVar = new c.a.p0.i2.h.r();
                        rVar.A(getPbModel().O0().m());
                        rVar.E(getPbModel().O0().O());
                        rVar.C(postData);
                        this.G0.R(rVar);
                        this.G0.setPostId(postData.E());
                        C1(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        c.a.o0.x.w.e eVar = this.D0;
                        if (eVar != null) {
                            setHasDraft(eVar.D());
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

    public final void s1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, bundle) == null) {
            c.a.o0.x.w.g gVar = new c.a.o0.x.w.g();
            this.C0 = gVar;
            N1(gVar);
            c.a.o0.x.w.e eVar = (c.a.o0.x.w.e) this.C0.a(getActivity());
            this.D0 = eVar;
            eVar.f0(this.f55129e.getPageContext());
            this.D0.o0(this.e1);
            this.D0.p0(this.v1);
            this.D0.h0(1);
            this.D0.G(this.f55129e.getPageContext(), bundle);
            this.D0.a().addHideLauncher(new c.a.o0.x.k(getActivity()));
            this.D0.a().showLinePositionBottom(true);
            P1(true);
            this.D0.P(getPbModel().r0(), getPbModel().e1(), getPbModel().o0());
            registerListener(this.W0);
            registerListener(this.Y0);
            registerListener(this.g1);
            registerListener(this.V0);
            registerListener(this.X0);
            registerListener(this.Z0);
            registerListener(this.D1);
            if (!getPbModel().C0()) {
                this.D0.t(getPbModel().e1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.D0.l0(TbSingleton.getInstance().getAdVertiComment());
            } else if (getPbModel().n1()) {
                this.D0.l0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.D0.l0(getReplyHint());
            }
            this.mContentProcessController = new c.a.p0.i2.k.e.u0();
            if (this.D0.w() != null) {
                this.mContentProcessController.m(this.D0.w().i());
            }
            this.D0.e0(this.U0);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.mReplyPrivacyController = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new o0(this));
        }
    }

    public void setCommentContainerVisible(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048733, this, i2) == null) || (linearLayout = this.a0) == null) {
            return;
        }
        linearLayout.setVisibility(i2);
    }

    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, editorTools) == null) {
            this.E0 = editorTools;
            editorTools.setId(R.id.pb_editor);
            this.E0.setOnCancelClickListener(new i1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.E0.getParent() == null) {
                this.f55131g.addView(this.E0, layoutParams);
            }
            this.E0.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.E0.setActionListener(24, new j1(this));
            hideEditTool();
            this.D0.i(new k1(this));
        }
    }

    public void setHasDraft(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z2) == null) {
            this.t0 = z2;
        }
    }

    public void setIsLoading(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z2) == null) {
            this.K = z2;
        }
    }

    public void setIsStatusBarShowing(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z2) == null) {
            this.l1 = z2;
        }
    }

    public abstract void setNavigationBarVisibility(boolean z2);

    public void setPostPostWrite(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048739, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            c.a.p0.i2.o.g.a aVar = this.mDialogController;
            if (aVar == null) {
                return;
            }
            if (z2) {
                aVar.F();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.mDialogController.G();
            } else {
                this.mDialogController.F();
            }
        }
    }

    public void setPostPro() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            hideProgressBar();
            if (isShowDoubleTab() && getReplyFragment() != null) {
                getReplyFragment().endLoadData();
                getReplyFragment().endPullRefresh();
            } else if (getDetailInfoAndReplyFragment() != null) {
                getDetailInfoAndReplyFragment().endLoadData();
                getDetailInfoAndReplyFragment().endPullRefresh();
            }
        }
    }

    public void setPreLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            c.a.e.e.p.l.x(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048742, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f55134j;
            if (videoPbFragmentAdapter == null || (customViewPager = this.f55133i) == null) {
                return;
            }
            videoPbFragmentAdapter.setItemPrimary(z2 ? customViewPager.getCurrentItem() : -1);
        }
    }

    public void setShadowVisible(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048743, this, i2) == null) || (view = this.k) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void setShowLinkGoodsMore(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048744, this, z2) == null) {
            this.r = z2;
        }
    }

    public void showCommonView(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048745, this, z2) == null) || this.c0 == null || c.a.o0.e1.b.e.d()) {
            return;
        }
        setHasDraft(this.D0.D());
        if (this.t0) {
            showDraftTip(z2);
        } else {
            hideDraftTip(z2);
        }
        H1();
        J1();
    }

    public void showDraftTip(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048746, this, z2) == null) || this.c0 == null || (textView = this.k0) == null) {
            return;
        }
        textView.setText(R.string.draft_to_send);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.c0.startAnimation(alphaAnimation);
        }
        this.b0.setVisibility(0);
        this.c0.setVisibility(0);
        this.r0.f55160a = true;
    }

    public void showProgressView() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048747, this) == null) || (view = this.L) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void showRightFloatLayerView() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048748, this) == null) || (rightFloatLayerView = this.Q0) == null) {
            return;
        }
        rightFloatLayerView.completeShow();
    }

    public void startFallingRedpacketAnimation(c.a.o0.u.a aVar, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048749, this, aVar, bitmap, i2) == null) && c.a.p0.i2.k.e.q0.a(aVar, i2)) {
            Random random = new Random();
            c.b bVar = new c.b(bitmap);
            bVar.p(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.o(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.m(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100), c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.n(new u0(this, random));
            bVar.q(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40), true, true);
            c.a.p0.i2.p.c l2 = bVar.l();
            this.I.start();
            this.I.addFallObject(l2, 22);
            c.a.e.e.m.e.a().postDelayed(this.C1, 2000L);
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TbImageView tbImageView = this.J;
            if (tbImageView != null) {
                tbImageView.setOnClickListener(new v0(this, aVar, i2));
            }
        }
    }

    public void stopFallingRedpacket() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048750, this) == null) {
            FallingView fallingView = this.I;
            if (fallingView != null) {
                fallingView.stop();
            }
            if (this.J != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.C1);
                this.J.setVisibility(8);
            }
        }
    }

    public final void stopVoice() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048751, this) == null) || (voiceManager = this.S) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            this.I = (FallingView) this.f55131g.findViewById(R.id.falling_view);
            TbImageView tbImageView = (TbImageView) this.f55131g.findViewById(R.id.falling_ad_view);
            this.J = tbImageView;
            tbImageView.setPlaceHolder(2);
        }
    }

    public void tapResetEditor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            c.a.o0.x.w.e eVar = this.D0;
            if (eVar != null) {
                setHasDraft(eVar.D());
            }
            resetCommentView();
            this.mDialogController.F();
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
            this.A = (TextView) this.f55131g.findViewById(R.id.pb_video_mount_title);
            this.E = (TbImageView) this.f55131g.findViewById(R.id.pb_video_mount_pic);
            this.B = (TextView) this.f55131g.findViewById(R.id.pb_video_mount_desc);
            this.C = (ImageView) this.f55131g.findViewById(R.id.pb_video_mount_close);
            this.D = (TBSpecificationBtn) this.f55131g.findViewById(R.id.pb_video_mount_link);
            this.F = this.f55131g.findViewById(R.id.ala_live_point);
            this.E.setRadius(c.a.e.e.p.l.g(getContext(), R.dimen.tbds10));
            this.E.setConrers(15);
            this.D.setConfig(new c.a.o0.s.f0.n.c());
            this.C.setOnClickListener(new x0(this));
            this.D.setOnClickListener(this.z);
            this.s.setOnClickListener(this.z);
            if (getPbModel() == null || getPbModel().O0() == null) {
                return;
            }
            S1(getPbModel().O0());
        }
    }

    public void updateBottomShareStateUI(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, eVar) == null) {
            if (eVar != null && AntiHelper.o(eVar.O())) {
                c.a.p0.i2.p.h hVar = this.o0;
                if (hVar != null) {
                    hVar.k(false);
                    this.o0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.n0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.n0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.n0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            c.a.p0.i2.p.h hVar2 = this.o0;
            if (hVar2 == null || !hVar2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.n0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.n0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.n0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void updateUegMask(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048756, this, z2) == null) {
            DetailInfoAndReplyFragment detailInfoAndReplyFragment = getDetailInfoAndReplyFragment();
            if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.getAdapterManager() != null && detailInfoAndReplyFragment.getAdapterManager().f() != null && detailInfoAndReplyFragment.getAdapterManager().g() != null) {
                detailInfoAndReplyFragment.getAdapterManager().f().V0(z2);
                detailInfoAndReplyFragment.getAdapterManager().g().s0(z2);
            }
            MaskView maskView = this.x;
            if (maskView != null) {
                maskView.setVisibility(z2 ? 0 : 8);
            }
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f55131g.findViewById(R.id.video_pb_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setOnClickListener(new a1(this));
            this.mNavigationBar.hideBottomLine();
            this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mStatusBar = this.f55131g.findViewById(R.id.statebar);
            View findViewById = this.f55131g.findViewById(R.id.status_bar_background);
            this.mStatusBarBackground = findViewById;
            if (this.k1) {
                ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
                layoutParams.height = c.a.e.e.p.l.r(getPbActivity());
                this.mStatusBar.setLayoutParams(layoutParams);
                this.mStatusBar.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = c.a.e.e.p.l.r(getPbActivity());
                this.mStatusBarBackground.setLayoutParams(layoutParams2);
                this.mStatusBarBackground.setVisibility(0);
            }
            View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.listener);
            this.mBackButton = addSystemImageButton;
            this.o = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.listener);
            this.mMore = addCustomView;
            this.p = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
            int g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds132);
            int g3 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.rightMargin = g3;
            this.mMore.setLayoutParams(layoutParams3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.p, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mMore.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            this.n1 = new GestureDetector(getContext(), this.o1);
            this.mNavigationBar.setOnTouchListener(this.m1);
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            this.f55132h.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            this.f55132h.setContainerLayoutParams(layoutParams);
            this.f55132h.setRectPaintColor(R.color.CAM_X0302);
            this.f55132h.init(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
            this.f55132h.setIndicatorOffset(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds64));
            this.f55132h.setIndicatorOvershot(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            this.f55132h.setIndicatorMarginBottom(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
            layoutParams2.gravity = 16;
            this.f55132h.setExpandedTabLayoutParams(layoutParams2);
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048759, this) == null) && this.n == null) {
            this.n = new c.a.p0.i2.o.e(getBaseFragmentActivity(), this.m);
            int r2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? c.a.e.e.p.l.r(getPbActivity()) : 0;
            Rect rect = new Rect(0, r2, c.a.e.e.p.l.k(getContext()), this.m.getOriginHeight() + r2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.n.r(videoPbViewModel.getOriginArea(), rect);
            if (this.n.l()) {
                this.n.q(new n0(this, videoPbViewModel));
            } else if (!c.a.o0.e1.b.e.d() && isShowDoubleTab() && (videoPbViewModel.isJumpCommentTab() || getPbModel().d1() == 1)) {
                this.f55133i.setCurrentItem(1);
            } else if (videoPbViewModel.isJumpCommentTab() || getPbModel().d1() == 0) {
                this.f55133i.setCurrentItem(0);
            }
        }
    }

    public final boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            c.a.p0.i2.o.k.a aVar = this.operableVideoContainer;
            return aVar != null && aVar.P0();
        }
        return invokeV.booleanValue;
    }

    public final void z1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048761, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    /* loaded from: classes7.dex */
    public class f2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f55160a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f55161b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f55162c;

        public f2(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f55162c = absVideoPbFragment;
            this.f55161b = true;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f55160a && this.f55161b) ? false : true : invokeV.booleanValue;
        }

        public /* synthetic */ f2(AbsVideoPbFragment absVideoPbFragment, k kVar) {
            this(absVideoPbFragment);
        }
    }

    public void deleteThread(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue != 3) {
                if (intValue == 4 || intValue == 6) {
                    if (getPbModel().l0() != null) {
                        getPbModel().l0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == 4) {
                        TiebaStatic.log("c10499");
                    }
                }
            } else if (this.R.O()) {
            } else {
                showProgressBar();
                String str = (String) sparseArray.get(R.id.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.tag_is_block_thread) != null ? ((Boolean) sparseArray.get(R.id.tag_is_block_thread)).booleanValue() : false;
                if (jSONArray != null) {
                    this.R.Q(StringHelper.JsonArrayToString(jSONArray));
                }
                this.R.R(getPbModel().O0().m().getId(), getPbModel().O0().m().getName(), getPbModel().O0().O().f0(), str, intValue3, intValue2, booleanValue, getPbModel().O0().O().L(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            }
        }
    }
}
