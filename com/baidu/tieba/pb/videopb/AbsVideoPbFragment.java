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
import com.repackage.a35;
import com.repackage.a9;
import com.repackage.ai8;
import com.repackage.ar8;
import com.repackage.b35;
import com.repackage.bg;
import com.repackage.bg5;
import com.repackage.bs7;
import com.repackage.bv7;
import com.repackage.cg;
import com.repackage.ct7;
import com.repackage.d15;
import com.repackage.d35;
import com.repackage.dw7;
import com.repackage.e35;
import com.repackage.ep4;
import com.repackage.ex7;
import com.repackage.ey4;
import com.repackage.ez4;
import com.repackage.fm4;
import com.repackage.fz7;
import com.repackage.g15;
import com.repackage.g85;
import com.repackage.gz7;
import com.repackage.hr7;
import com.repackage.hw7;
import com.repackage.i15;
import com.repackage.iu4;
import com.repackage.iz4;
import com.repackage.j15;
import com.repackage.jz7;
import com.repackage.k05;
import com.repackage.k08;
import com.repackage.kg;
import com.repackage.ki;
import com.repackage.kj8;
import com.repackage.kw7;
import com.repackage.l85;
import com.repackage.li;
import com.repackage.ln4;
import com.repackage.m98;
import com.repackage.mi;
import com.repackage.mu4;
import com.repackage.mx4;
import com.repackage.n36;
import com.repackage.ne5;
import com.repackage.ng;
import com.repackage.nr4;
import com.repackage.pj8;
import com.repackage.pr4;
import com.repackage.py4;
import com.repackage.rm6;
import com.repackage.rs7;
import com.repackage.sd5;
import com.repackage.sw5;
import com.repackage.uv4;
import com.repackage.uz7;
import com.repackage.vd5;
import com.repackage.vy7;
import com.repackage.vz4;
import com.repackage.w05;
import com.repackage.wc5;
import com.repackage.wx7;
import com.repackage.x05;
import com.repackage.x25;
import com.repackage.xd5;
import com.repackage.xl4;
import com.repackage.xv7;
import com.repackage.xw4;
import com.repackage.xz7;
import com.repackage.y25;
import com.repackage.yf5;
import com.repackage.yi4;
import com.repackage.yq4;
import com.repackage.yz7;
import com.repackage.z25;
import com.repackage.zc5;
import com.repackage.zi4;
import com.repackage.zu4;
import com.repackage.zz7;
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
/* loaded from: classes3.dex */
public abstract class AbsVideoPbFragment extends BaseFragment implements bg5, VoiceManager.j, gz7, TbRichTextView.s, fz7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int N1;
    public static final int O1;
    public transient /* synthetic */ FieldHolder $fh;
    public MaskView A;
    public boolean A0;
    public final n36.b A1;
    public View.OnClickListener B;
    public boolean B0;
    public NewWriteModel.g B1;
    public TextView C;
    public ReplyPrivacyCheckController C0;
    public z25 C1;
    public TextView D;
    public rm6 D0;
    public final View.OnClickListener D1;
    public ImageView E;
    public rm6 E0;
    public View.OnClickListener E1;
    public TBSpecificationBtn F;
    public hw7 F0;
    public final AdapterView.OnItemClickListener F1;
    public TbImageView G;
    public PermissionJudgePolicy G0;
    public CustomMessageListener G1;
    public View H;
    public d35 H0;
    public CustomMessageListener H1;
    public ValueAnimator I;
    public b35 I0;
    public CustomMessageListener I1;
    public ValueAnimator J;
    public EditorTools J0;
    public final ItemCardHelper.c J1;
    public FallingView K;
    public bv7 K0;
    public CustomMessageListener K1;
    public boolean L;
    public PbFakeFloorModel L0;
    public final View.OnLongClickListener L1;
    public View M;
    public n36 M0;
    public SortSwitchButton.f M1;
    public uz7 N;
    public int[] N0;
    public mu4 O;
    public int O0;
    public xl4 P;
    public int P0;
    public ex7 Q;
    public int Q0;
    public EmotionImageData R;
    public int R0;
    public py4 S;
    public int S0;
    public ForumManageModel T;
    public boolean T0;
    public VoiceManager U;
    public boolean U0;
    public bg<GifView> V;
    @NonNull
    public TiePlusEventController.f V0;
    public bg<TextView> W;
    public FrameLayout W0;
    public bg<ImageView> X;
    public RightFloatLayerView X0;
    public bg<View> Y;
    public final PbModel.h Y0;
    public bg<LinearLayout> Z;
    public final xl4.a Z0;
    public AbsPbActivity a;
    public y25 a1;
    public long b;
    public final CustomMessageListener b1;
    public RelativeLayout c;
    public CustomMessageListener c1;
    public NewPagerSlidingTabBaseStrip d;
    public final CustomMessageListener d1;
    public CustomViewPager e;
    public CustomMessageListener e1;
    public VideoPbFragmentAdapter f;
    public HttpMessageListener f1;
    public View g;
    public bg<RelativeLayout> g0;
    public CustomMessageListener g1;
    public View h;
    public boolean h0;
    public CustomMessageListener h1;
    public AppBarLayout i;
    public LinearLayout i0;
    public CustomMessageListener i1;
    public VideoContainerLayout j;
    public View j0;
    public y25 j1;
    public zz7 k;
    public View k0;
    public final NewWriteModel.g k1;
    public jz7 l;
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
    public k08 r0;
    public boolean r1;
    public ImageView s;
    public TextView s0;
    public View.OnTouchListener s1;
    public sw5 t;
    public TextView t0;
    public GestureDetector t1;
    public boolean u;
    public b2 u0;
    public GestureDetector.SimpleOnGestureListener u1;
    public View v;
    public String v0;
    public Runnable v1;
    public xz7 w;
    public boolean w0;
    public ObjectAnimator w1;
    public View x;
    public String x0;
    public ObjectAnimator x1;
    public View y;
    public boolean y0;
    public final a9 y1;
    public View z;
    public boolean z0;
    public View.OnTouchListener z1;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class a0 implements zc5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AbsVideoPbFragment c;

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
            this.c = absVideoPbFragment;
            this.a = i;
            this.b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zc5
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
                uz7 uz7Var = this.a.N;
                if (uz7Var != null) {
                    uz7Var.F();
                }
                boolean z = false;
                if (!ki.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                    return false;
                }
                if (this.a.v() != null && !this.a.v().isLoading) {
                    this.a.T4();
                    this.a.z4();
                    z = true;
                    if (this.a.v().P1() != null && this.a.v().P1().f != null && this.a.v().P1().f.size() > i) {
                        int intValue = this.a.v().P1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.v().i2()).param("fid", this.a.v().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.v().G3(intValue)) {
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

    /* loaded from: classes3.dex */
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
            hr7 hr7Var = (hr7) customResponsedMessage.getData();
            int type = hr7Var.getType();
            if (type == 0) {
                this.a.h4((rs7) hr7Var.a());
            } else if (type == 1) {
                this.a.L2((ForumManageModel.b) hr7Var.a(), false);
            } else if (type != 2) {
            } else {
                if (hr7Var.a() == null) {
                    this.a.f4(false, null);
                } else {
                    this.a.f4(true, (MarkData) hr7Var.a());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091ef0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091f03) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f03)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091eee) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eee)).booleanValue() : false;
            uz7 uz7Var = this.a.N;
            if (uz7Var != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ec1, 1);
                        this.a.N.B(sparseArray);
                        return;
                    }
                    uz7Var.l0(view2);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ec1, 0);
                    sparseArray.put(R.id.obfuscated_res_0x7f091eaa, 1);
                    this.a.N.B(sparseArray);
                } else if (booleanValue3) {
                    uz7Var.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb0), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ecd)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b1 implements rm6.d {
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

        @Override // com.repackage.rm6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.rm6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.I0 != null && this.a.I0.a() != null) {
                    this.a.I0.a().A(new w05(45, 27, null));
                }
                this.a.E2();
            }
        }

        @Override // com.repackage.rm6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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
                            bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f0319));
                            bdTopToast.j((ViewGroup) this.a.getView());
                            this.a.A4(type);
                            return;
                        }
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
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

    /* loaded from: classes3.dex */
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
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.v() == null || this.a.v().Y1() == i + 1) {
                return;
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            absVideoPbFragment.o4(absVideoPbFragment.g3(i));
        }
    }

    /* loaded from: classes3.dex */
    public class c1 implements PbModel.h {
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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(bs7 bs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bs7Var) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, bs7 bs7Var, String str, int i4) {
            String k3;
            d15 m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bs7Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906cd));
                }
                this.a.y4();
                this.a.r3();
                if (this.a.L) {
                    this.a.L = false;
                }
                this.a.G4(false);
                if (z && bs7Var != null) {
                    ThreadData O = bs7Var.O();
                    ((VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class)).t(bs7Var, i2);
                    this.a.a4(bs7Var);
                    this.a.I4(bs7Var);
                    this.a.g4(bs7Var);
                    this.a.d4(z, i, i2, i3, bs7Var, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(bs7Var.U().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(bs7Var.U().getBimg_end_time());
                    if (bs7Var.F() != null && bs7Var.F().size() >= 1 && bs7Var.F().get(0) != null) {
                        this.a.v().m3(bs7Var.F().get(0).I());
                    } else if (bs7Var.W() != null) {
                        this.a.v().m3(bs7Var.W().I());
                    }
                    if (this.a.P != null) {
                        this.a.P.h(bs7Var.r());
                    }
                    AntiData d = bs7Var.d();
                    if (d != null) {
                        this.a.x0 = d.getVoice_message();
                        if (!StringUtils.isNull(this.a.x0) && this.a.I0 != null && this.a.I0.a() != null && (m = this.a.I0.a().m(6)) != null && !TextUtils.isEmpty(this.a.x0)) {
                            ((View) m).setOnClickListener(this.a.l1);
                        }
                    }
                    if (this.a.C0 != null && O != null && O.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.getAuthor());
                        this.a.C0.setLikeUserData(attentionHostData);
                    }
                    this.a.B3(bs7Var);
                    if (this.a.v() != null && this.a.v().v2()) {
                        k3 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dda);
                    } else {
                        k3 = this.a.k3();
                    }
                    if (!StringUtils.isNull(k3)) {
                        this.a.I0.k0(TbSingleton.getInstance().getAdVertiComment(bs7Var.k0(), bs7Var.l0(), k3));
                    }
                } else {
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.v().h2());
                            jSONObject.put("fid", this.a.v().getForumId());
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
                    if ((this.a.I3() && this.a.j3() == null) || this.a.S2() == null) {
                        return;
                    }
                    ArrayList<PostData> arrayList = null;
                    if (this.a.I3()) {
                        if (i != -1) {
                            if (this.a.v() != null && this.a.v().P1() != null) {
                                arrayList = this.a.v().P1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.a.j3().i1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ef));
                            } else if (this.a.j3().c1()) {
                                this.a.j3().j1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dcb));
                            } else {
                                this.a.j3().j1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dcc));
                            }
                        } else {
                            this.a.j3().i1("");
                        }
                        this.a.j3().P0();
                    } else {
                        if (i != -1) {
                            if (this.a.v() != null && this.a.v().P1() != null) {
                                arrayList = this.a.v().P1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.a.S2().p1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ef));
                            } else if (this.a.S2().g1()) {
                                this.a.S2().q1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dcb));
                            } else {
                                this.a.S2().q1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dcc));
                            }
                        } else {
                            this.a.S2().p1("");
                        }
                        this.a.S2().R0();
                    }
                }
                ai8.g().h(this.a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.N != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ar8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.N.D) {
                ar8 ar8Var = (ar8) customResponsedMessage.getData();
                this.a.N.V();
                SparseArray<Object> sparseArray = (SparseArray) this.a.N.O();
                DataRes dataRes = ar8Var.a;
                if (ar8Var.c == 0 && dataRes != null) {
                    int e = kg.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r3 = e == 1;
                    if (li.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091efd, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f091efd, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091f03, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f03, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ec1)).intValue();
                if (intValue == 0) {
                    this.a.N.E0(r3, sparseArray);
                } else if (intValue == 1) {
                    this.a.N.k0(sparseArray, r3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yf5.a)) {
                yf5.a aVar = (yf5.a) customResponsedMessage.getData();
                yf5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onNavigationButtonClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes3.dex */
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
            uz7 uz7Var = this.a.N;
            if (tag == uz7Var.D) {
                uz7Var.V();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                bs7 P1 = this.a.v().P1();
                if (P1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    P1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.O.c(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b2a));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b26);
                    }
                    this.a.N.K0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.N.D0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (li.isEmpty(errorString2)) {
                        errorString2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b27);
                    }
                    this.a.O.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            pj8 pj8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof pj8) || (pj8Var = (pj8) customResponsedMessage.getData()) == null || (agreeData = pj8Var.b) == null || agreeData.agreeType != 2 || this.a.r0 == null || this.a.v() == null || !UbsABTestHelper.isResizeInduceSharingABTestA() || wx7.k(this.a.v().h2())) {
                return;
            }
            this.a.r0.m(2);
            wx7.b(this.a.v().h2());
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j4();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            uz7 uz7Var = this.a.N;
            if (tag == uz7Var.D) {
                uz7Var.V();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.O.c(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1491));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (li.isEmpty(muteMessage)) {
                    muteMessage = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1490);
                }
                this.a.O.b(muteMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            zz7 zz7Var;
            BdTypeRecyclerView i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || threadData.getThreadVideoInfo() == null || (zz7Var = this.a.k) == null) {
                return;
            }
            if (zz7Var.c0() != null && this.a.k.c0().equals(threadData.getThreadVideoInfo().video_url)) {
                this.a.k.setData(threadData);
                return;
            }
            if (!li.isEmpty(this.a.k.c0())) {
                this.a.B0 = true;
                if (this.a.I3()) {
                    this.a.e.setCurrentItem(0);
                } else {
                    this.a.e.setCurrentItem(0);
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
            boolean z = !StringHelper.equals(this.a.k.c0(), threadData.getThreadVideoInfo().video_url);
            this.a.k.setData(threadData);
            if (this.a.I3()) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.k.R0(absVideoPbFragment.e.getCurrentItem() == 0);
            } else {
                this.a.k.R0(false);
            }
            if (z) {
                this.a.k.startPlay();
                this.a.k.u0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f1 implements x05 {
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

        @Override // com.repackage.x05
        public void onAction(w05 w05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, w05Var) == null) {
                Object obj = w05Var.c;
                if (obj instanceof mx4) {
                    if (((mx4) obj).getType() == EmotionGroupType.BIG_EMOTION || ((mx4) w05Var.c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.a.G0 == null) {
                            this.a.G0 = new PermissionJudgePolicy();
                        }
                        this.a.G0.clearRequestPermissionList();
                        this.a.G0.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.G0.startRequestPermission(this.a.getBaseFragmentActivity())) {
                            return;
                        }
                        this.a.I0.h((mx4) w05Var.c);
                        this.a.I0.z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements y25 {
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

        @Override // com.repackage.y25
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                hw7 hw7Var = this.a.F0;
                if (hw7Var == null || hw7Var.g() == null || !this.a.F0.g().d()) {
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

    /* loaded from: classes3.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bs7 a;
        public final /* synthetic */ xw4 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public g0(AbsVideoPbFragment absVideoPbFragment, bs7 bs7Var, xw4 xw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, bs7Var, xw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absVideoPbFragment;
            this.a = bs7Var;
            this.b = xw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a == null || this.b == null || this.c.X0 == null) {
                return;
            }
            this.c.X0.g(this.b);
            this.c.X0.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes3.dex */
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
            hw7 hw7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (hw7Var = this.a.F0) == null || hw7Var.e() == null) {
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

    /* loaded from: classes3.dex */
    public class h implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ h b;

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
                this.b = hVar;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postWriteCallBackData = this.a) == null) {
                    return;
                }
                this.b.a.Y3(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements nr4.e {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements nr4.e {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ey4 ey4Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ey4Var, writeData, antiData}) == null) {
                if (!li.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.v() != null && this.a.v().P1() != null) {
                        statisticItem.param("fid", this.a.v().P1().m());
                    }
                    statisticItem.param("tid", this.a.v().h2());
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
                if (writeData != null) {
                    uv4.b(writeData.getContent(), "3");
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
                        if (li.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f046e), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData == null || !postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        if (ey4Var != null || i == 227001) {
                            return;
                        }
                        this.a.E4(i, antiData, str);
                        return;
                    } else {
                        nr4 nr4Var = new nr4(this.a.getActivity());
                        if (li.isEmpty(postWriteCallBackData.getErrorString())) {
                            nr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ce4));
                        } else {
                            nr4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new b(this));
                        nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ce6, new c(this));
                        nr4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    }
                }
                if (PbReplySwitch.getInOn() && this.a.v() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    this.a.v().X0(postWriteCallBackData.getPostId());
                    if (this.a.I3() && this.a.j3() != null) {
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.R0 = absVideoPbFragment.j3().S0();
                        AbsVideoPbFragment absVideoPbFragment2 = this.a;
                        absVideoPbFragment2.S0 = absVideoPbFragment2.j3().T0();
                        this.a.v().l3(this.a.R0, this.a.S0);
                    } else if (this.a.S2() != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.a;
                        absVideoPbFragment3.R0 = absVideoPbFragment3.S2().U0();
                        AbsVideoPbFragment absVideoPbFragment4 = this.a;
                        absVideoPbFragment4.S0 = absVideoPbFragment4.S2().V0();
                        this.a.v().l3(this.a.R0, this.a.S0);
                    }
                }
                if (this.a.e != null) {
                    if (this.a.I3()) {
                        this.a.e.setCurrentItem(1);
                    } else {
                        this.a.e.setCurrentItem(0);
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
                this.a.v().q2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.F4(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.a.v().s1()) {
                        bs7 P1 = this.a.v().P1();
                        if (P1 != null && P1.O() != null && P1.O().getAuthor() != null && (userId = P1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.v().D3()) {
                            this.a.z4();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.v().D3()) {
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
                    ng.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                AbsVideoPbFragment absVideoPbFragment6 = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                absVideoPbFragment6.v2(z2, writeData != null ? writeData.getContent() : "");
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.e.setCurrentItem(num.intValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

        /* loaded from: classes3.dex */
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
                hw7 hw7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (hw7Var = this.a.c.F0) == null || hw7Var.g() == null) {
                    return;
                }
                if (!this.a.c.F0.g().e()) {
                    this.a.c.F0.b(false);
                }
                this.a.c.F0.g().l(false);
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
            this.c = absVideoPbFragment;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int f;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = mi.i(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = mi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = mi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                AbsVideoPbFragment absVideoPbFragment = this.c;
                boolean z = true;
                int i4 = (absVideoPbFragment.N0[1] + absVideoPbFragment.O0) - i3;
                if (absVideoPbFragment.i3() != null) {
                    this.c.i3().smoothScrollBy(0, i4);
                }
                if (this.c.K0 != null) {
                    this.c.I0.a().setVisibility(8);
                    this.c.K0.o(this.a, this.b, this.c.k3(), (this.c.v() == null || this.c.v().P1() == null || this.c.v().P1().O() == null || !this.c.v().P1().O().isBjh()) ? false : false);
                    this.c.K0.l(this.c.V2());
                    e35 b = this.c.K0.b();
                    if (b != null && this.c.v() != null && this.c.v().P1() != null) {
                        b.G(this.c.v().P1().d());
                        b.c0(this.c.v().P1().O());
                    }
                    if (this.c.F0.f() == null && this.c.K0.b().t() != null) {
                        this.c.K0.b().t().f(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.c;
                        absVideoPbFragment2.F0.n(absVideoPbFragment2.K0.b().t().h());
                        this.c.K0.b().M(this.c.j1);
                    }
                }
                this.c.n3();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.showToast(absVideoPbFragment.x0);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            zz7 zz7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || (zz7Var = this.a.k) == null) {
                return;
            }
            zz7Var.U0(threadData);
        }
    }

    /* loaded from: classes3.dex */
    public class i1 implements rm6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i1 a;

            /* renamed from: com.baidu.tieba.pb.videopb.AbsVideoPbFragment$i1$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0226a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0226a(a aVar) {
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
                    hw7 hw7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (hw7Var = this.a.a.c.F0) == null || hw7Var.g() == null) {
                        return;
                    }
                    if (!this.a.a.c.F0.g().e()) {
                        this.a.a.c.F0.b(false);
                    }
                    this.a.a.c.F0.g().l(false);
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
                    int i2 = mi.i(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = mi.f(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    } else {
                        i = i2 / 2;
                        f = mi.f(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    }
                    int i3 = i2 - (i + f);
                    AbsVideoPbFragment absVideoPbFragment = this.a.c;
                    boolean z = true;
                    int i4 = (absVideoPbFragment.N0[1] + absVideoPbFragment.O0) - i3;
                    if (absVideoPbFragment.i3() != null) {
                        this.a.c.i3().smoothScrollBy(0, i4);
                    }
                    if (this.a.c.K0 != null) {
                        this.a.c.I0.a().setVisibility(8);
                        z = (this.a.c.v() == null || this.a.c.v().P1() == null || this.a.c.v().P1().O() == null || !this.a.c.v().P1().O().isBjh()) ? false : false;
                        bv7 bv7Var = this.a.c.K0;
                        i1 i1Var = this.a;
                        bv7Var.o(i1Var.a, i1Var.b, i1Var.c.k3(), z);
                        this.a.c.K0.l(this.a.c.V2());
                        e35 b = this.a.c.K0.b();
                        if (b != null && this.a.c.v() != null && this.a.c.v().P1() != null) {
                            b.G(this.a.c.v().P1().d());
                            b.c0(this.a.c.v().P1().O());
                        }
                        if (this.a.c.F0.f() == null && this.a.c.K0.b().t() != null) {
                            this.a.c.K0.b().t().f(new C0226a(this));
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.c;
                            absVideoPbFragment2.F0.n(absVideoPbFragment2.K0.b().t().h());
                            this.a.c.K0.b().M(this.a.c.j1);
                        }
                    }
                    this.a.c.n3();
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
            this.c = absVideoPbFragment;
            this.a = str;
            this.b = str2;
        }

        @Override // com.repackage.rm6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.rm6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                ng.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // com.repackage.rm6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            zz7 zz7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || (zz7Var = this.a.k) == null) {
                return;
            }
            zz7Var.T0(threadData);
        }
    }

    /* loaded from: classes3.dex */
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
                    if (this.a.w != null && this.a.v() != null && this.a.v().P1() != null && this.a.v().P1().l() != null) {
                        TiebaStatic.log(new StatisticItem("c13712").param("fid", this.a.v().P1().l().getId()).param("fname", this.a.v().P1().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.v().P1().Q()).param("obj_param1", this.a.w.k));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13608").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.m()).param("obj_type", 2).param("fid", this.a.v().P1().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.v().P1().Q()));
                }
                this.a.O4();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.w == null || this.a.w.q()) {
                    if (this.a.w != null) {
                        if (!this.a.w.h) {
                            if (this.a.w.m != null) {
                                YYLiveUtil.jumpToYYLiveRoom(this.a.getPageContext(), this.a.w.m.mSid, this.a.w.m.mSsid, this.a.w.m.mTemplateId, "", YYLiveUtil.SOURCE_PB_LIVE_BANNER);
                            }
                        } else {
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.M3(absVideoPbFragment.w.j, this.a.w.i);
                        }
                        if (this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().l() == null) {
                            return;
                        }
                        StatisticItem param = new StatisticItem("c13713").param("fid", this.a.v().P1().l().getId()).param("fname", this.a.v().P1().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.v().P1().Q()).param("obj_param1", this.a.w.k);
                        if (this.a.v().P1().O() != null) {
                            ThreadData O = this.a.v().P1().O();
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
                TiebaStatic.log(new StatisticItem("c13590").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.m()).param("obj_type", 2).param("fid", this.a.v().P1().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.v().P1().Q()));
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return this.a.t1 != null && this.a.t1.onTouchEvent(motionEvent);
                }
                if (this.a.n1 == 1) {
                    if (!this.a.r1) {
                        this.a.Q4();
                        UtilHelper.showStatusBar(this.a.w(), this.a.w().getRootView());
                        this.a.r1 = true;
                        ng.a().removeCallbacks(this.a.v1);
                        ng.a().postDelayed(this.a.v1, 3000L);
                    }
                } else if (this.a.n1 == 2 && (this.a.r1 || this.a.J3())) {
                    this.a.P4();
                    UtilHelper.hideStatusBar(this.a.w(), this.a.w().getRootView());
                    this.a.r1 = false;
                    zz7 zz7Var = this.a.k;
                    if (zz7Var != null) {
                        zz7Var.S0(false);
                    }
                }
                this.a.n1 = 0;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class l1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ AbsVideoPbFragment b;

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
            this.b = absVideoPbFragment;
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
                this.b.a5(this.a);
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

    /* loaded from: classes3.dex */
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
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            zz7 zz7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.o1 += f;
                this.a.p1 += f2;
                if (this.a.n1 == 0 && !this.a.q1 && (zz7Var = this.a.k) != null && !zz7Var.isFullScreen()) {
                    int height = this.a.m.getHeight();
                    if (motionEvent.getY() < 0.0f || Math.abs(this.a.p1) <= Math.abs(this.a.o1) || this.a.p1 > (-height) / 5) {
                        if (Math.abs(this.a.p1) > Math.abs(this.a.o1) && this.a.p1 > 0.0f && f2 > 0.0f) {
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

    /* loaded from: classes3.dex */
    public class m0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbViewModel a;
        public final /* synthetic */ AbsVideoPbFragment b;

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
            this.b = absVideoPbFragment;
            this.a = videoPbViewModel;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.b.I3() && (this.a.n() || this.b.v().g2() == 1)) {
                    this.b.e.setCurrentItem(1);
                } else if (this.a.n() || this.b.v().g2() == 0) {
                    this.b.e.setCurrentItem(0);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.b.I3() && (this.a.n() || this.b.v().g2() == 1)) {
                    this.b.e.setCurrentItem(1);
                } else if (this.a.n() || this.b.v().g2() == 0) {
                    this.b.e.setCurrentItem(0);
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

    /* loaded from: classes3.dex */
    public class m1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ ViewGroup.LayoutParams b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AbsVideoPbFragment d;

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
            this.d = absVideoPbFragment;
            this.a = layoutParams;
            this.b = layoutParams2;
            this.c = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.N1);
                this.a.height = floatValue;
                this.b.height = (this.c - AbsVideoPbFragment.N1) + floatValue;
                this.d.v.setLayoutParams(this.a);
                this.d.i.setLayoutParams(this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                UtilHelper.hideStatusBar(this.a.w(), this.a.w().getRootView());
                this.a.r1 = false;
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class n1 implements xl4.a {
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

        @Override // com.repackage.xl4.a
        public void a(boolean z, boolean z2, String str) {
            ThreadData O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.y4();
                if (z && this.a.v() != null) {
                    if (this.a.P != null) {
                        this.a.P.h(z2);
                    }
                    this.a.v().C3(z2);
                    if (this.a.v().P1() != null && (O = this.a.v().P1().O()) != null) {
                        if (z2) {
                            O.collectNum++;
                        } else {
                            int i = O.collectNum;
                            if (i > 0) {
                                O.collectNum = i - 1;
                            }
                        }
                    }
                    if (this.a.v().A1()) {
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
                            if (this.a.P.f() == null || this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().O() == null || this.a.v().P1().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.P.f();
                            MetaData author = this.a.v().P1().O().getAuthor();
                            if (f != null && author != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                    this.a.N.A0(author);
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00d0);
                                }
                            } else {
                                AbsVideoPbFragment absVideoPbFragment = this.a;
                                absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00cf));
                            }
                        }
                        this.a.u2();
                        return;
                    }
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    absVideoPbFragment2.showToast(absVideoPbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f9c));
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.showToast(absVideoPbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14b8));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o extends a9 {
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

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.a.v() != null) {
                    switch (this.a.T.getLoadDataMode()) {
                        case 0:
                            this.a.v().q2();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.L2(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.M2(1, dVar.a, dVar.b, true);
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
                            absVideoPbFragment2.M2(absVideoPbFragment2.T.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.N.f0(gVar.c);
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

    /* loaded from: classes3.dex */
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
                ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), this.a.c);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.M0.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, this.a.c, 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.c, j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ ViewGroup.LayoutParams b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AbsVideoPbFragment d;

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
            this.d = absVideoPbFragment;
            this.a = layoutParams;
            this.b = layoutParams2;
            this.c = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.N1);
                this.a.height = floatValue;
                this.b.height = this.c + floatValue;
                this.d.v.setLayoutParams(this.a);
                this.d.i.setLayoutParams(this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements n36.b {
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

        @Override // com.repackage.n36.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    ct7.d();
                } else {
                    ct7.c();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                boolean z = true;
                if (i == 0) {
                    if (this.a.S2() != null) {
                        this.a.S2().j1(false);
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
                    zz7 zz7Var = this.a.k;
                    if (zz7Var != null) {
                        zz7Var.R0(z);
                    }
                    this.a.j4();
                    if (this.a.v() != null && this.a.v().P1() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.a.v().h2()).param("fid", this.a.v().P1().m()));
                    }
                } else {
                    if (this.a.T2() != null) {
                        this.a.T2().S0(false);
                    }
                    if (this.a.S2() != null) {
                        this.a.S2().j1(true);
                        int a1 = this.a.S2().a1();
                        int Y0 = this.a.S2().Y0();
                        if (a1 != 0) {
                            this.a.B4(8);
                            this.a.S2().t1(0);
                        } else if (Y0 != 0) {
                            this.a.S2().t1(8);
                            this.a.B4(0);
                        } else {
                            this.a.S2().t1(8);
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
                    zz7 zz7Var2 = this.a.k;
                    if (zz7Var2 != null) {
                        zz7Var2.R0(false);
                    }
                    this.a.i.setExpanded(false, true);
                    if (this.a.v() != null && this.a.v().P1() != null) {
                        TiebaStatic.log(new StatisticItem("c13593").param("tid", this.a.v().h2()).param("fid", this.a.v().P1().m()));
                    }
                }
                this.a.f.d(i);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class r implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) || nr4Var == null) {
                return;
            }
            nr4Var.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw4 a;
        public final /* synthetic */ AbsVideoPbFragment b;

        public r0(AbsVideoPbFragment absVideoPbFragment, xw4 xw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, xw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = absVideoPbFragment;
            this.a = xw4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.X0.setHomePbFloatLastCloseTime();
                this.b.s3();
                this.b.X0.u(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class s implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ s b;

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
                this.b = sVar;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postWriteCallBackData = this.a) == null) {
                    return;
                }
                this.b.a.Y3(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements nr4.e {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements nr4.e {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ey4 ey4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ey4Var, writeData, antiData}) == null) {
                if (!li.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.v() != null && this.a.v().P1() != null) {
                        statisticItem.param("fid", this.a.v().P1().m());
                    }
                    if (this.a.v() != null) {
                        statisticItem.param("tid", this.a.v().h2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (writeData != null) {
                    uv4.b(writeData.getContent(), "4");
                }
                if (z) {
                    hw7 hw7Var = this.a.F0;
                    if (hw7Var != null) {
                        hw7Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        iz4.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getmAdverSegmentData() == null) {
                        return;
                    }
                    ng.a().postDelayed(new a(this, postWriteCallBackData), 500L);
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
                    if (li.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f046e), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    nr4 nr4Var = new nr4(this.a.getActivity());
                    if (li.isEmpty(postWriteCallBackData.getErrorString())) {
                        nr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ce4));
                    } else {
                        nr4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new b(this));
                    nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ce6, new c(this));
                    nr4Var.create(this.a.getPageContext()).show();
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

    /* loaded from: classes3.dex */
    public class s0 implements FallingView.n {
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

        @Override // com.baidu.tieba.pb.view.FallingView.n
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K4();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.n
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

    /* loaded from: classes3.dex */
    public class s1 implements cg<ImageView> {
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
        @Override // com.repackage.cg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
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
                    if (ln4.c().g()) {
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
        @Override // com.repackage.cg
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
        @Override // com.repackage.cg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = ln4.c().g();
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
    public class t implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ nr4 c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public t(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = absVideoPbFragment;
            this.a = markData;
            this.b = markData2;
            this.c = nr4Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
                if (this.d.P != null) {
                    if (this.d.P.e()) {
                        this.d.P.d();
                        this.d.P.h(false);
                    }
                    this.d.P.i(this.a);
                    this.d.P.h(true);
                    this.d.P.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.a.setResult(-1, intent);
                this.c.dismiss();
                this.d.U4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.w == null || this.a.w.q()) {
                    if (this.a.w != null) {
                        TiebaStatic.log(new StatisticItem("c13608").param("tid", this.a.v().P1().Q()));
                        this.a.w.l = true;
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13591"));
                }
                this.a.N4();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t1 implements cg<GifView> {
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
        @Override // com.repackage.cg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
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
                if (ln4.c().g()) {
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
        @Override // com.repackage.cg
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
        @Override // com.repackage.cg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = ln4.c().g();
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
    public class u implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ nr4 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public u(AbsVideoPbFragment absVideoPbFragment, MarkData markData, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absVideoPbFragment;
            this.a = markData;
            this.b = nr4Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.U4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                this.a.K2(false);
                this.a.b4();
                if (this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().O() == null || this.a.v().P1().O().getAuthor() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.v().i2()).param("fid", this.a.v().P1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v().h2()).param("fid", this.a.v().P1().m()).param("obj_locate", 1).param("uid", this.a.v().P1().O().getAuthor().getUserId()));
                if (this.a.F3()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", this.a.v().getForumId());
                    statisticItem.param("tid", this.a.v().h2());
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

    /* loaded from: classes3.dex */
    public class u1 implements cg<View> {
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
        @Override // com.repackage.cg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
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
        @Override // com.repackage.cg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cg
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

    /* loaded from: classes3.dex */
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
            layoutParams.height = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds144);
            this.a.i0.setLayoutParams(layoutParams);
            if (this.a.I3() && this.a.d != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.d.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = AbsVideoPbFragment.O1;
                } else {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, AbsVideoPbFragment.O1);
                }
                this.a.d.setLayoutParams(layoutParams2);
                this.a.e.setScrollable(true);
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

    /* loaded from: classes3.dex */
    public class v1 implements cg<LinearLayout> {
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
        @Override // com.repackage.cg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
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
        @Override // com.repackage.cg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f09174d);
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

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.q3();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w1 implements cg<RelativeLayout> {
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
        @Override // com.repackage.cg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
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
        @Override // com.repackage.cg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cg
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
    public class x implements z25 {
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

        @Override // com.repackage.z25
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j4();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x1 implements Comparator<vz4> {
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
        public int compare(vz4 vz4Var, vz4 vz4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vz4Var, vz4Var2)) == null) ? vz4Var.compareTo(vz4Var2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            String str;
            SparseArray<Object> sparseArray;
            StatisticItem statisticItem;
            int i;
            String str2;
            int i2;
            String jumpUrlWithTid;
            boolean F3;
            int i3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09170c) {
                    if (this.a.v() != null) {
                        this.a.v().M2(false);
                        return;
                    }
                    return;
                }
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f091eb8);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view2.setTag(R.id.obfuscated_res_0x7f091eb8, null);
                } else if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.v().h2());
                    statisticItem2.param("fid", this.a.v().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    if (this.a.F3()) {
                        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem3.param("fid", this.a.v().getForumId());
                        statisticItem3.param("tid", this.a.v().h2());
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
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091eae);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (this.a.v() == null || this.a.v().P1() == null || this.a.L0 == null || postData.s() == null || postData.A() == 1 || !this.a.checkUpIsLogin()) {
                                return;
                            }
                            if (this.a.K0 != null) {
                                this.a.K0.c();
                            }
                            rs7 rs7Var = new rs7();
                            rs7Var.A(this.a.v().P1().l());
                            rs7Var.E(this.a.v().P1().O());
                            rs7Var.C(postData);
                            this.a.L0.U(rs7Var);
                            this.a.L0.setPostId(postData.I());
                            this.a.P3(view2, postData.s().getUserId(), "", postData);
                            TiebaStatic.log("c11743");
                            vy7.b(this.a.v().P1(), postData, postData.h0, 8, 1);
                            if (this.a.I0 != null) {
                                AbsVideoPbFragment absVideoPbFragment = this.a;
                                absVideoPbFragment.s4(absVideoPbFragment.I0.C());
                            }
                        }
                    }
                } else {
                    if (view2.getId() != R.id.obfuscated_res_0x7f091764 || this.a.getPageContext().getPageActivity() == null || this.a.v() == null || this.a.a == null || this.a.a.getIntent() == null) {
                        str = "post_id";
                    } else {
                        if (this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            str = "post_id";
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v().h2(), false, true);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            str = "post_id";
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v().h2(), true, false);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.a.v().getForumId());
                        statisticItem4.param("fname", this.a.v().o1());
                        statisticItem4.param("tid", this.a.v().h2());
                        TiebaStatic.log(statisticItem4);
                    }
                    if ((this.a.I3() && this.a.j3() != null && this.a.j3().X0() != null && view2 == this.a.j3().X0()) || ((this.a.S2() != null && this.a.S2().Z0() != null && view2 == this.a.S2().Z0()) || view2.getId() == R.id.obfuscated_res_0x7f09170e)) {
                        if (!this.a.L && this.a.v().I2(true)) {
                            this.a.L = true;
                            if (this.a.I3()) {
                                if (this.a.j3() != null) {
                                    this.a.j3().l1();
                                    return;
                                }
                                return;
                            } else if (this.a.S2() != null) {
                                this.a.S2().s1();
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    uz7 uz7Var = this.a.N;
                    if (uz7Var != null && uz7Var.Q() != null && view2 == this.a.N.Q().h()) {
                        this.a.N.I();
                        return;
                    }
                    uz7 uz7Var2 = this.a.N;
                    if ((uz7Var2 == null || ((uz7Var2.Q() == null || view2 != this.a.N.Q().l()) && view2.getId() != R.id.obfuscated_res_0x7f091657 && view2.getId() != R.id.obfuscated_res_0x7f09025e)) && view2.getId() != R.id.obfuscated_res_0x7f0909e1 && view2.getId() != R.id.obfuscated_res_0x7f091aab) {
                        AbsVideoPbFragment absVideoPbFragment2 = this.a;
                        if (view2 == absVideoPbFragment2.p) {
                            if (absVideoPbFragment2.v() == null || this.a.v().P1() == null) {
                                return;
                            }
                            if (!li.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                StatisticItem statisticItem5 = new StatisticItem("c13266");
                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem5.param("fid", this.a.v().P1().m());
                                statisticItem5.param("tid", this.a.v().h2());
                                statisticItem5.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(statisticItem5);
                                TbadkCoreApplication.getInst().setTaskId("");
                            }
                            mi.w(this.a.a, this.a.p);
                            this.a.a.finish();
                        } else if (view2 == absVideoPbFragment2.r && absVideoPbFragment2.N != null) {
                            if (wc5.a()) {
                                return;
                            }
                            if (this.a.v() != null && this.a.v().P1() != null) {
                                ArrayList<PostData> F = this.a.v().P1().F();
                                if ((F == null || F.size() <= 0) && this.a.v().f2()) {
                                    mi.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dca));
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.v().h2()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.v().getForumId()));
                                this.a.N.m0();
                                return;
                            }
                            mi.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dca));
                        } else if (this.a.N.Q() != null && view2 == this.a.N.Q().n()) {
                            if (this.a.v() == null) {
                                return;
                            }
                            this.a.N.F();
                            if (ki.z()) {
                                this.a.T4();
                                this.a.z4();
                                this.a.v().A3(1);
                                return;
                            }
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                        } else {
                            uz7 uz7Var3 = this.a.N;
                            if (uz7Var3 != null && uz7Var3.Q() != null && view2 == this.a.N.Q().l()) {
                                this.a.N.I();
                                return;
                            }
                            uz7 uz7Var4 = this.a.N;
                            if (uz7Var4 != null && ((uz7Var4.Q() != null && view2 == this.a.N.Q().u()) || view2.getId() == R.id.obfuscated_res_0x7f09174b || view2.getId() == R.id.obfuscated_res_0x7f091749)) {
                                this.a.N.F();
                                if (ki.z()) {
                                    if (!this.a.L) {
                                        this.a.T4();
                                        this.a.z4();
                                        this.a.N.J0(view2);
                                        return;
                                    }
                                    view2.setTag(Integer.valueOf(this.a.v().d2()));
                                    return;
                                }
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                                return;
                            }
                            uz7 uz7Var5 = this.a.N;
                            if (uz7Var5 != null && uz7Var5.Q() != null && view2 == this.a.N.Q().t()) {
                                if (this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().O() == null) {
                                    return;
                                }
                                this.a.N.I();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                absVideoPbFragment3.N.U(absVideoPbFragment3.v().P1().O().getFirstPostId());
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f0916d9) {
                                try {
                                    sparseArray = (SparseArray) view2.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                    sparseArray = null;
                                }
                                uz7 uz7Var6 = this.a.N;
                                if (uz7Var6 != null) {
                                    uz7Var6.w0(sparseArray);
                                }
                            } else {
                                uz7 uz7Var7 = this.a.N;
                                int i4 = 4;
                                if (uz7Var7 != null && uz7Var7.Q() != null && view2 == this.a.N.Q().r()) {
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
                                uz7 uz7Var8 = this.a.N;
                                if (uz7Var8 != null && uz7Var8.Q() != null && view2 == this.a.N.Q().s()) {
                                    this.a.N.J();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                    absVideoPbFragment4.N.G0(absVideoPbFragment4.F1);
                                    return;
                                }
                                uz7 uz7Var9 = this.a.N;
                                if (uz7Var9 != null && uz7Var9.Q() != null && view2 == this.a.N.Q().k()) {
                                    TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.v().h2())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                    this.a.N.I();
                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                    return;
                                }
                                uz7 uz7Var10 = this.a.N;
                                if (uz7Var10 != null && (view2 == uz7Var10.M() || (this.a.N.Q() != null && (view2 == this.a.N.Q().o() || view2 == this.a.N.Q().q())))) {
                                    if (!ki.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                                        return;
                                    } else if ((this.a.v() == null && this.a.v().P1() == null) || this.a.T.R()) {
                                        return;
                                    } else {
                                        this.a.N.F();
                                        if (this.a.N.Q() != null && view2 == this.a.N.Q().q()) {
                                            if (this.a.v().P1().O().getIs_top() == 1) {
                                                i4 = 5;
                                            }
                                        } else if (this.a.N.Q() != null && view2 == this.a.N.Q().o()) {
                                            i4 = this.a.v().P1().O().getIs_good() == 1 ? 3 : 6;
                                        } else {
                                            i4 = view2 == this.a.N.M() ? 2 : 0;
                                        }
                                        ForumData l = this.a.v().P1().l();
                                        String name = l.getName();
                                        String id = l.getId();
                                        String id2 = this.a.v().P1().O().getId();
                                        this.a.showProgressBar();
                                        this.a.T.V(id, name, id2, i4, this.a.N.N());
                                        return;
                                    }
                                }
                                uz7 uz7Var11 = this.a.N;
                                if (uz7Var11 != null && uz7Var11.Q() != null && view2 == this.a.N.Q().j()) {
                                    if (this.a.v() == null) {
                                        return;
                                    }
                                    if (!ki.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                                        return;
                                    }
                                    this.a.N.F();
                                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                    SparseArray<Object> b3 = absVideoPbFragment5.b3(absVideoPbFragment5.v().P1(), this.a.v().f2(), 1);
                                    if (b3 == null) {
                                        return;
                                    }
                                    this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v().P1().l().getId(), this.a.v().P1().l().getName(), this.a.v().P1().O().getId(), String.valueOf(this.a.v().P1().U().getUserId()), (String) b3.get(R.id.obfuscated_res_0x7f091ebb), (String) b3.get(R.id.obfuscated_res_0x7f091ebc), (String) b3.get(R.id.obfuscated_res_0x7f091ebe), (String) b3.get(R.id.obfuscated_res_0x7f091ebd))));
                                    return;
                                }
                                uz7 uz7Var12 = this.a.N;
                                if (uz7Var12 != null && uz7Var12.Q() != null && view2 == this.a.N.Q().e()) {
                                    if (!ki.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                    SparseArray<Object> b32 = absVideoPbFragment6.b3(absVideoPbFragment6.v().P1(), this.a.v().f2(), 1);
                                    if (b32 != null) {
                                        this.a.N.j0(((Integer) b32.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) b32.get(R.id.obfuscated_res_0x7f091eb0), ((Integer) b32.get(R.id.obfuscated_res_0x7f091ecd)).intValue(), ((Boolean) b32.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue());
                                    }
                                    this.a.N.I();
                                    if (this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().O() == null) {
                                        return;
                                    }
                                    ThreadData O = this.a.v().P1().O();
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
                                uz7 uz7Var13 = this.a.N;
                                if (uz7Var13 != null && uz7Var13.Q() != null && view2 == this.a.N.Q().i()) {
                                    if (this.a.v() == null) {
                                        return;
                                    }
                                    if (!ki.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                    SparseArray<Object> b33 = absVideoPbFragment7.b3(absVideoPbFragment7.v().P1(), this.a.v().f2(), 1);
                                    if (b33 != null) {
                                        if (StringUtils.isNull((String) b33.get(R.id.obfuscated_res_0x7f091eaf))) {
                                            this.a.N.g0(((Integer) b33.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) b33.get(R.id.obfuscated_res_0x7f091eb0), ((Integer) b33.get(R.id.obfuscated_res_0x7f091ecd)).intValue(), ((Boolean) b33.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue());
                                        } else {
                                            this.a.N.h0(((Integer) b33.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) b33.get(R.id.obfuscated_res_0x7f091eb0), ((Integer) b33.get(R.id.obfuscated_res_0x7f091ecd)).intValue(), ((Boolean) b33.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue(), (String) b33.get(R.id.obfuscated_res_0x7f091eaf));
                                        }
                                    }
                                    this.a.N.I();
                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091e0b && view2.getId() != R.id.obfuscated_res_0x7f091e09 && view2.getId() != R.id.obfuscated_res_0x7f0916db && view2.getId() != R.id.obfuscated_res_0x7f091576 && view2.getId() != R.id.obfuscated_res_0x7f09173b) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091739 && view2.getId() != R.id.obfuscated_res_0x7f0918fe && view2.getId() != R.id.obfuscated_res_0x7f0916d5) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f0916c7 && view2.getId() != R.id.obfuscated_res_0x7f09067d) {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f0916cd) {
                                                this.a.m3(true);
                                                return;
                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f0916c9 && view2.getId() != R.id.obfuscated_res_0x7f091ff4) {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f092225) {
                                                    if (this.a.R0 >= 0) {
                                                        if (this.a.v() != null) {
                                                            this.a.v().h3();
                                                        }
                                                        if (this.a.I3() && this.a.v() != null && this.a.j3() != null && this.a.j3().C0() != null) {
                                                            this.a.j3().C0().f(this.a.v().P1());
                                                        } else if (this.a.S2() != null && this.a.S2().C0() != null) {
                                                            this.a.S2().C0().r(this.a.v().P1());
                                                        }
                                                        this.a.R0 = 0;
                                                        this.a.S0 = Integer.MIN_VALUE;
                                                        if (this.a.I3() && this.a.v() != null && this.a.j3() != null) {
                                                            this.a.j3().h1(this.a.v().I1(), this.a.v().H1());
                                                            this.a.v().l3(0, 0);
                                                            return;
                                                        } else if (this.a.v() == null || this.a.S2() == null) {
                                                            return;
                                                        } else {
                                                            this.a.S2().n1(this.a.v().I1(), this.a.v().H1());
                                                            this.a.v().l3(0, 0);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                } else if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                    if (this.a.v() == null) {
                                                        return;
                                                    }
                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                    statisticItem8.param("tid", this.a.v().h2());
                                                    statisticItem8.param("fid", this.a.v().getForumId());
                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem8.param("obj_locate", 2);
                                                    TiebaStatic.log(statisticItem8);
                                                    return;
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091703) {
                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1363);
                                                        String q = iu4.k().q("tail_link", "");
                                                        if (!StringUtils.isNull(q)) {
                                                            TiebaStatic.log("c10056");
                                                            fm4.q(view2.getContext(), string, q, true, true, true);
                                                        }
                                                        this.a.j4();
                                                        return;
                                                    }
                                                    return;
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091010) {
                                                    this.a.j4();
                                                    return;
                                                } else if (this.a.N.Q() != null && view2 == this.a.N.Q().g()) {
                                                    this.a.N.F();
                                                    if (this.a.v() != null) {
                                                        this.a.t.f(this.a.v().h2());
                                                    }
                                                    if (this.a.v() == null || !this.a.v().isPrivacy()) {
                                                        this.a.t.b();
                                                        int i5 = (TbSingleton.getInstance().mCanCallFans || this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().Q() == null || !this.a.v().P1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                        if (this.a.v() == null || this.a.v().P1() == null) {
                                                            return;
                                                        }
                                                        this.a.t.d(3, i5, this.a.v().P1().Q());
                                                        return;
                                                    }
                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0eea);
                                                    if (this.a.v().P1() != null) {
                                                        this.a.t.d(3, 3, this.a.v().P1().Q());
                                                        return;
                                                    }
                                                    return;
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f0916dd || view2.getId() == R.id.obfuscated_res_0x7f091733) {
                                                    StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                    statisticItem9.param("tid", this.a.v().h2());
                                                    statisticItem9.param("fid", this.a.v().getForumId());
                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem9.param("obj_locate", 7);
                                                    TiebaStatic.log(statisticItem9);
                                                    if (this.a.F3()) {
                                                        StatisticItem statisticItem10 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem10.param("fid", this.a.v().getForumId());
                                                        statisticItem10.param("tid", this.a.v().h2());
                                                        statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem10.param(str, this.a.W2());
                                                        statisticItem10.param("obj_source", 1);
                                                        statisticItem10.param("obj_type", 2);
                                                        statisticItem10.param("obj_locate", this.a.V2());
                                                        TiebaStatic.log(statisticItem10);
                                                    }
                                                    this.a.N.o0(false);
                                                    this.a.N.P().onLongClick(view2);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                String str3 = str;
                                                if (this.a.v() != null) {
                                                    AbsVideoPbFragment absVideoPbFragment8 = this.a;
                                                    if (absVideoPbFragment8.N == null || absVideoPbFragment8.e == null || this.a.v().P1() == null || this.a.v().P1().O() == null || !this.a.checkUpIsLogin()) {
                                                        return;
                                                    }
                                                    bs7 P1 = this.a.v().P1();
                                                    int reply_num = P1.O().getReply_num();
                                                    int currentItem = this.a.e.getCurrentItem();
                                                    if (reply_num == 0) {
                                                        if (this.a.I3() && currentItem == 0) {
                                                            this.a.e.setCurrentItem(1);
                                                        }
                                                        this.a.K2(false);
                                                        this.a.b4();
                                                        return;
                                                    }
                                                    if (this.a.I3() && currentItem == 0) {
                                                        this.a.e.setCurrentItem(1);
                                                        str2 = "obj_source";
                                                    } else if ((this.a.I3() && this.a.j3() == null) || this.a.S2() == null || this.a.i3() == null) {
                                                        return;
                                                    } else {
                                                        StatisticItem param = new StatisticItem("c13403").param("tid", this.a.v().h2()).param("fid", this.a.v().P1().m()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        int i6 = (int) (mi.i(this.a.getContext()) * 0.6d);
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
                                                        g85 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                                        StatisticItem statisticItem11 = new StatisticItem("c12942");
                                                        statisticItem11.param("obj_type", i2);
                                                        statisticItem11.param("obj_locate", 4);
                                                        statisticItem11.param("tid", this.a.v().h2());
                                                        statisticItem11.param("nid", P1.O().getNid());
                                                        if (findPageExtraByView != null) {
                                                            statisticItem11.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                                                        }
                                                        if (TbPageExtraHelper.getPrePageKey() != null) {
                                                            statisticItem11.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                                                        }
                                                        TiebaStatic.log(statisticItem11);
                                                    }
                                                    if (this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().O() == null || this.a.v().P1().O().getAuthor() == null) {
                                                        return;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v().h2()).param("fid", this.a.v().P1().m()).param("obj_locate", 2).param("uid", this.a.v().P1().O().getAuthor().getUserId()));
                                                    if (this.a.F3()) {
                                                        StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem12.param("fid", this.a.v().getForumId());
                                                        statisticItem12.param("tid", this.a.v().h2());
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
                                        if (!ki.z()) {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment9 = this.a;
                                        if (absVideoPbFragment9.N == null || absVideoPbFragment9.v() == null) {
                                            return;
                                        }
                                        if (this.a.I3() && this.a.j3() == null) {
                                            return;
                                        }
                                        if (this.a.I3() || this.a.S2() != null) {
                                            this.a.N.F();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0916c7 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.B2(11009) || this.a.v() == null) {
                                                    return;
                                                }
                                                this.a.R3();
                                                if (this.a.v().P1() != null && this.a.v().P1().O() != null && this.a.v().P1().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v().h2()).param("fid", this.a.v().P1().m()).param("obj_locate", 3).param("uid", this.a.v().P1().O().getAuthor().getUserId()));
                                                    if (this.a.F3()) {
                                                        StatisticItem statisticItem13 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem13.param("fid", this.a.v().getForumId());
                                                        statisticItem13.param("tid", this.a.v().h2());
                                                        statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem13.param(str4, this.a.W2());
                                                        statisticItem13.param("obj_source", 1);
                                                        statisticItem13.param("obj_type", 13);
                                                        statisticItem13.param("obj_locate", this.a.V2());
                                                        TiebaStatic.log(statisticItem13);
                                                    }
                                                }
                                                if (this.a.v().P1().O() == null || this.a.v().P1().O().getAuthor() == null || this.a.v().P1().O().getAuthor().getUserId() == null || this.a.P == null) {
                                                    return;
                                                }
                                                AbsVideoPbFragment absVideoPbFragment10 = this.a;
                                                int S = absVideoPbFragment10.N.S(absVideoPbFragment10.v().P1());
                                                ThreadData O2 = this.a.v().P1().O();
                                                if (O2.isBJHArticleThreadType()) {
                                                    i = 2;
                                                } else if (O2.isBJHVideoThreadType()) {
                                                    i = 3;
                                                } else if (O2.isBJHNormalThreadType()) {
                                                    i = 4;
                                                } else {
                                                    i = O2.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.v().h2()).param("obj_locate", 1).param("obj_id", this.a.v().P1().O().getAuthor().getUserId()).param("obj_type", !this.a.P.e()).param("obj_source", S).param("obj_param1", i));
                                                return;
                                            }
                                            this.a.z = view2;
                                            return;
                                        }
                                        return;
                                    }
                                    String str5 = str;
                                    if (this.a.v() == null) {
                                        return;
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091739) {
                                        StatisticItem statisticItem14 = new StatisticItem("c13398");
                                        statisticItem14.param("tid", this.a.v().h2());
                                        statisticItem14.param("fid", this.a.v().getForumId());
                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem14.param("obj_locate", 6);
                                        TiebaStatic.log(statisticItem14);
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f0918fe) {
                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.y = view2;
                                            return;
                                        }
                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091739 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                        this.a.y = view2;
                                        return;
                                    }
                                    if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                        SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                        if (sparseArray2.get(R.id.obfuscated_res_0x7f091eca) instanceof PostData) {
                                            PostData postData2 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091eca);
                                            if (view2.getId() == R.id.obfuscated_res_0x7f091739 && (statisticItem = postData2.i0) != null) {
                                                StatisticItem copy = statisticItem.copy();
                                                copy.delete("obj_locate");
                                                copy.param("obj_locate", 8);
                                                TiebaStatic.log(copy);
                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f0918fe || view2.getId() == R.id.obfuscated_res_0x7f0916d5) {
                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.v().i2()).param("fid", this.a.v().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param(str5, postData2.I()).param("obj_source", 1).param("obj_type", 3));
                                            }
                                            if (this.a.v() == null || this.a.v().P1() == null || this.a.L0 == null || postData2.s() == null || postData2.A() == 1) {
                                                return;
                                            }
                                            if (this.a.K0 != null) {
                                                this.a.K0.c();
                                            }
                                            if (this.a.U0 && postData2.R() != null && postData2.R().size() != 0) {
                                                this.a.R4(postData2, null, true, false);
                                                return;
                                            }
                                            rs7 rs7Var2 = new rs7();
                                            rs7Var2.A(this.a.v().P1().l());
                                            rs7Var2.E(this.a.v().P1().O());
                                            rs7Var2.C(postData2);
                                            this.a.L0.U(rs7Var2);
                                            this.a.L0.setPostId(postData2.I());
                                            this.a.P3(view2, postData2.s().getUserId(), "", postData2);
                                            if (this.a.I0 != null) {
                                                AbsVideoPbFragment absVideoPbFragment11 = this.a;
                                                absVideoPbFragment11.s4(absVideoPbFragment11.I0.C());
                                            }
                                        }
                                    }
                                } else {
                                    String str6 = str;
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091576) {
                                        StatisticItem statisticItem15 = new StatisticItem("c13398");
                                        statisticItem15.param("tid", this.a.v().h2());
                                        statisticItem15.param("fid", this.a.v().getForumId());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem15);
                                        if (this.a.F3()) {
                                            StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem16.param("fid", this.a.v().getForumId());
                                            statisticItem16.param("tid", this.a.v().h2());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param(str6, this.a.W2());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 8);
                                            statisticItem16.param("obj_locate", this.a.V2());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                    }
                                    if ((view2.getId() == R.id.obfuscated_res_0x7f0916db || view2.getId() == R.id.obfuscated_res_0x7f09173b) && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                        this.a.x = view2;
                                        return;
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f0916db && this.a.F3()) {
                                        StatisticItem statisticItem17 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem17.param("fid", this.a.v().getForumId());
                                        statisticItem17.param("tid", this.a.v().h2());
                                        statisticItem17.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem17.param(str6, this.a.W2());
                                        statisticItem17.param("obj_source", 1);
                                        statisticItem17.param("obj_type", 9);
                                        statisticItem17.param("obj_locate", this.a.V2());
                                        TiebaStatic.log(statisticItem17);
                                    }
                                    if (!this.a.checkUpIsLogin()) {
                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.v().P1().m()));
                                    } else if (this.a.v() == null || this.a.v().P1() == null) {
                                    } else {
                                        uz7 uz7Var14 = this.a.N;
                                        if (uz7Var14 != null) {
                                            uz7Var14.F();
                                        }
                                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                        PostData postData3 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091eca);
                                        PostData postData4 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091ecb);
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
                                            if (view2.getId() == R.id.obfuscated_res_0x7f091576) {
                                                copy2.param("obj_locate", 6);
                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f0916db) {
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
                    } else if (!ki.z()) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                        view2.setTag(Boolean.FALSE);
                    } else {
                        this.a.N.F();
                        if (!this.a.L) {
                            this.a.T4();
                            this.a.z4();
                            if (view2.getId() == R.id.obfuscated_res_0x7f091657) {
                                F3 = this.a.v().F3(true, this.a.W2());
                            } else {
                                F3 = view2.getId() == R.id.obfuscated_res_0x7f09025e ? this.a.v().F3(false, this.a.W2()) : this.a.v().E3(this.a.W2());
                            }
                            view2.setTag(Boolean.valueOf(F3));
                            if (F3) {
                                this.a.J4();
                                i3 = 1;
                                this.a.L = true;
                            } else {
                                i3 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i3, new Object[0]);
                            return;
                        }
                        view2.setTag(Boolean.FALSE);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class y1 implements y25 {
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

        @Override // com.repackage.y25
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                hw7 hw7Var = this.a.F0;
                if (hw7Var == null || hw7Var.e() == null || !this.a.F0.e().d()) {
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

    /* loaded from: classes3.dex */
    public class z extends sd5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ AbsVideoPbFragment b;

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
            this.b = absVideoPbFragment;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sd5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel v = this.b.v();
                if (v != null) {
                    v.o3(this.a);
                }
                return wx7.d(this.b.R2(), 2, v);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.N.o0(true);
                return this.a.N.P().onLongClick(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.v() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
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
        N1 = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds146);
        O1 = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds114);
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
        this.b = 0L;
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
            PbModel v2 = v();
            if (v2 == null || v2.P1() == null) {
                return false;
            }
            ThreadData O = v2.P1().O();
            v2.P1().d();
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
        b35 b35Var = this.I0;
        if (b35Var != null) {
            b35Var.P();
        }
        n3();
    }

    public final void A4(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || v() == null) {
            return;
        }
        int Y1 = v().Y1();
        if (i2 == 5) {
            v().w3(2);
        } else if (i2 == 6) {
            v().w3(3);
        } else if (i2 != 7) {
            v().w3(1);
        } else {
            v().w3(4);
        }
        int Y12 = v().Y1();
        if (Y1 == 4 || Y12 == 4) {
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

    public void B3(bs7 bs7Var) {
        xw4 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bs7Var) == null) || this.W0 == null || bs7Var == null || bs7Var.g() == 3 || F3()) {
            return;
        }
        if (bs7Var.k0()) {
            pbAdFloatViewItemData = bs7Var.Z();
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
            this.X0.setLogoListener(new g0(this, bs7Var, pbAdFloatViewItemData));
            this.X0.setFeedBackListener(new r0(this, pbAdFloatViewItemData));
            return;
        }
        s3();
    }

    public void B4(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (view2 = this.g) == null) {
            return;
        }
        view2.setVisibility(i2);
    }

    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if ((v() != null && v().P1().g0()) || this.C0 == null || v() == null || v().P1() == null || ThreadCardUtils.isSelf(v().P1().O()) || v().P1().d() == null) {
                return true;
            }
            return this.C0.checkPrivacyBeforeInvokeEditor(v().P1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            this.d.setContainerLayoutParams(layoutParams);
            this.d.setRectPaintColor(R.color.CAM_X0302);
            this.d.C(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
            this.d.setIndicatorOffset(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds64));
            this.d.setIndicatorOvershot(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            this.d.setIndicatorMarginBottom(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
            layoutParams2.gravity = 16;
            this.d.setExpandedTabLayoutParams(layoutParams2);
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
            if (this.C0 == null || v() == null || v().P1() == null || ThreadCardUtils.isSelf(v().P1().O()) || v().P1().d() == null) {
                return true;
            }
            return this.C0.checkPrivacyBeforeSend(v().P1().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            n36 n36Var = new n36(getActivity());
            this.M0 = n36Var;
            n36Var.i(this.A1);
            this.q1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
            z3();
            this.i = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090295);
            this.g = this.c.findViewById(R.id.obfuscated_res_0x7f09176c);
            this.W0 = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091af1);
            this.j = (VideoContainerLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09175a);
            zz7 zz7Var = new zz7(getContext(), this.j);
            this.k = zz7Var;
            zz7Var.setStageType("2002");
            this.k.setUniqueId(getUniqueId());
            this.k.X0(this);
            this.k.V0(w().getRootView());
            this.k.W0(this.o);
            ((RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091c47)).setMinimumHeight(((int) Math.ceil((mi.k(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
            this.d = (NewPagerSlidingTabBaseStrip) this.c.findViewById(R.id.obfuscated_res_0x7f091770);
            this.v = this.c.findViewById(R.id.obfuscated_res_0x7f091767);
            this.e = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f091772);
            this.h = this.c.findViewById(R.id.obfuscated_res_0x7f091010);
            this.A = (MaskView) this.c.findViewById(R.id.obfuscated_res_0x7f0913bf);
            this.h.setOnClickListener(this.D1);
            C3();
            y3();
            u3();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.f = videoPbFragmentAdapter;
            this.e.setAdapter(videoPbFragmentAdapter);
            this.d.setViewPager(this.e);
            this.d.setOnPageChangeListener(new q0(this));
            this.M = this.c.findViewById(R.id.obfuscated_res_0x7f09241b);
            this.K = (FallingView) this.c.findViewById(R.id.obfuscated_res_0x7f09096e);
            r4();
            this.K.setAnimationListener(new s0(this));
            w3();
            v3();
            if (!this.q1 && this.r1) {
                P4();
                UtilHelper.hideStatusBar(w(), w().getRootView());
                this.r1 = false;
            }
            if (I3()) {
                return;
            }
            this.d.getLayoutParams().height = 0;
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
                if (v() != null) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", v().getForumId()));
                }
            } else if (C2()) {
                b35 b35Var = this.I0;
                if (b35Var != null && (b35Var.B() || this.I0.D())) {
                    this.I0.z(false, null);
                    return;
                }
                if (this.J0 != null) {
                    A3();
                    this.u0.a = false;
                    if (this.J0.n(2) != null) {
                        kj8.c(getPageContext(), (View) this.J0.n(2).m, false, null);
                    }
                }
                n3();
            }
        }
    }

    public final void E3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.l == null) {
            this.l = new jz7(getBaseFragmentActivity(), this.j);
            int r2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? mi.r(w()) : 0;
            Rect rect = new Rect(0, r2, mi.k(getContext()), this.j.getOriginHeight() + r2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.l.r(videoPbViewModel.i(), rect);
            if (this.l.l()) {
                this.l.q(new m0(this, videoPbViewModel));
            } else if (I3() && (videoPbViewModel.n() || v().g2() == 1)) {
                this.e.setCurrentItem(1);
            } else if (videoPbViewModel.n() || v().g2() == 0) {
                this.e.setCurrentItem(0);
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
                uz7 uz7Var = this.N;
                if (uz7Var != null) {
                    uz7Var.K0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (v().u1() || v().x1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", v().h2());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, v().h2()));
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
                iz4.c(getPageContext(), postWriteCallBackData, 2);
                return;
            }
            if (StringUtils.isNull(errorString)) {
                errorString = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1106);
            }
            if (StringUtils.isNull(colorMsg)) {
                mi.N(getPageContext().getPageActivity(), errorString);
                return;
            }
            String str = errorString + " " + preMsg + colorMsg;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0305));
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(foregroundColorSpan, errorString.length() + preMsg.length() + 1, str.length(), 17);
            mi.I(getPageContext().getPageActivity(), str, spannableString, 3000);
            return;
        }
        if (v() != null && !v().C1()) {
            antiData.setBlock_forum_name(v().P1().l().getName());
            antiData.setBlock_forum_id(v().P1().l().getId());
            antiData.setUser_name(v().P1().U().getUserName());
            antiData.setUser_id(v().P1().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public void G2(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            List<PostData> list = v().P1().T().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).R().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i2).R().get(i3).I())) {
                        list.get(i2).R().remove(i3);
                        list.get(i2).k();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).m(bVar.g);
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
                    if (v().k1() != null) {
                        v().k1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == 4) {
                        TiebaStatic.log("c10499");
                    }
                }
            } else if (this.T.R()) {
            } else {
                showProgressBar();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb0);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ecd)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091eb2)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ec4) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ec4)).booleanValue() : false;
                if (jSONArray != null) {
                    this.T.T(StringHelper.JsonArrayToString(jSONArray));
                }
                this.T.U(v().P1().l().getId(), v().P1().l().getName(), v().P1().O().getId(), str, intValue3, intValue2, booleanValue, v().P1().O().getBaijiahaoData(), booleanValue2);
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
        textView.setText(R.string.obfuscated_res_0x7f0f050d);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.k0.startAnimation(alphaAnimation);
        }
        this.j0.setVisibility(0);
        this.k0.setVisibility(0);
        this.u0.a = true;
    }

    public void I2(nr4 nr4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, nr4Var, jSONArray) == null) {
            nr4Var.dismiss();
            if (v() == null || v().P1() == null || v().P1().O() == null || v().P1().l() == null) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (nr4Var.getYesButtonTag() instanceof SparseArray) {
                    H2((SparseArray) nr4Var.getYesButtonTag(), jSONArray);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (F3() || v() == null || !v().D2()) ? false : true : invokeV.booleanValue;
    }

    public final void I4(bs7 bs7Var) {
        xz7 G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, bs7Var) == null) || (G = bs7Var.G()) == null || G.l) {
            return;
        }
        x2(G);
    }

    public void J2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091eb0, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091eb2, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(z2));
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
            zz7 zz7Var = this.k;
            return zz7Var != null && zz7Var.M0();
        }
        return invokeV.booleanValue;
    }

    public void J4() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (view2 = this.M) == null) {
            return;
        }
        view2.setVisibility(0);
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
            String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f04a2);
            int i2 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                nr4 nr4Var = new nr4(getPageContext().getPageActivity());
                nr4Var.setMessage(string);
                nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04e1, new r(this));
                nr4Var.setCancelable(true);
                nr4Var.create(getPageContext());
                nr4Var.show();
            } else {
                M2(0, bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                if (i3 == 1) {
                    ArrayList<PostData> F = v().P1().F();
                    int size = F.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i2).I())) {
                            F.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    v().P1().O().setReply_num(v().P1().O().getReply_num() - 1);
                    if (S2() != null) {
                        S2().e1();
                    } else if (I3() && j3() != null) {
                        j3().b1();
                    }
                } else if (i3 == 0) {
                    F2();
                } else if (i3 == 2) {
                    ArrayList<PostData> F2 = v().P1().F();
                    int size2 = F2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= F2.get(i4).R().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i4).R().get(i5).I())) {
                                F2.get(i4).R().remove(i5);
                                F2.get(i4).k();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        F2.get(i4).m(bVar.g);
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
            zz7 zz7Var = this.k;
            if (zz7Var == null) {
                return false;
            }
            return zz7Var.N0();
        }
        return invokeV.booleanValue;
    }

    public final void L4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            yz7.c(w(), R2(), i2);
        }
    }

    public void M2(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f1217));
            } else if (z3) {
                if (li.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
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
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || v() == null || li.isEmpty(v().h2())) {
            return;
        }
        zi4.y().R(yi4.X, kg.g(v().h2(), 0L));
    }

    public final void N2(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048615, this, i2, gVar) == null) || gVar == null || v() == null || v().P1() == null || v().P1().O() == null) {
            return;
        }
        M2(this.T.getLoadDataMode(), gVar.a, gVar.b, false);
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
                v().P1().O().setIs_good(1);
                v().p3(1);
            } else if (i2 == 3) {
                v().P1().O().setIs_good(0);
                v().p3(0);
            } else if (i2 == 4) {
                v().P1().O().setIs_top(1);
                v().q3(1);
            } else if (i2 == 5) {
                v().P1().O().setIs_top(0);
                v().q3(0);
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                string = gVar.b;
            } else {
                string = getString(R.string.obfuscated_res_0x7f0f0cf5);
            }
            mi.N(getPageContext().getPageActivity(), string);
        }
        if (I3()) {
            if (v().P1().O() == null || T2() == null) {
                return;
            }
            T2().U0();
        } else if (v().P1().O() == null || S2() == null) {
        } else {
            S2().l1();
        }
    }

    public /* synthetic */ void N3() {
        String k3;
        if (v() != null && v().v2()) {
            k3 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0dda);
        } else {
            k3 = k3();
        }
        if (!StringUtils.isNull(k3) && v() != null && v().P1() != null) {
            k3 = TbSingleton.getInstance().getAdVertiComment(v().P1().k0(), v().P1().l0(), k3);
        }
        b35 b35Var = this.I0;
        if (b35Var != null) {
            b35Var.k0(k3);
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
                return getString(R.string.obfuscated_res_0x7f0f0db1);
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
                this.m0.K(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.m0.setImageResource(R.drawable.obfuscated_res_0x7f081221);
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

    public py4 P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.S : (py4) invokeV.objValue;
    }

    public final void P3(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048622, this, view2, str, str2, postData) == null) || view2 == null || str == null || str2 == null || A2() || !C2()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.N0);
            this.O0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.K0 != null && postData != null) {
            this.K0.j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fb6), postData.s().getName_show(), postData.P() != null ? postData.P().toString() : ""));
        }
        if (v() != null && v().P1() != null && v().P1().g0()) {
            ng.a().postDelayed(new h1(this, str, str2), 0L);
            return;
        }
        if (this.E0 == null) {
            rm6 rm6Var = new rm6(getPageContext());
            this.E0 = rm6Var;
            rm6Var.j(1);
            this.E0.i(new i1(this, str, str2));
        }
        if (v() == null || v().P1() == null || v().P1().l() == null) {
            return;
        }
        this.E0.g(v().P1().l().getId(), kg.g(v().h2(), 0L));
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
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || v() == null) {
            return;
        }
        bs7 P1 = v().P1();
        v().C3(true);
        xl4 xl4Var = this.P;
        if (xl4Var != null) {
            P1.E0(xl4Var.g());
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
            if (v() == null || v().P1() == null || v().P1().O() == null) {
                return -1;
            }
            return v().P1().O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void R3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || v() == null || v().P1() == null) {
            return;
        }
        if (I3() && j3() == null) {
            return;
        }
        if ((I3() || S2() != null) && this.P != null) {
            MarkData markData = null;
            if (v().P1() != null && v().P1().g0()) {
                markData = v().f1(0);
            } else {
                CustomViewPager customViewPager = this.e;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = v().J1(U2(v().P1()));
                } else if (I3()) {
                    if (j3() != null) {
                        markData = v().f1(j3().U0());
                    }
                } else if (S2() != null) {
                    markData = v().f1(S2().W0());
                }
            }
            if (markData == null) {
                return;
            }
            if (markData.isApp() && j3() != null && (markData = v().f1(j3().U0() + 1)) == null) {
                return;
            }
            z4();
            this.P.i(markData);
            if (!this.P.e()) {
                if (v() != null && !wx7.k(v().h2())) {
                    this.r0.m(2);
                    wx7.b(v().h2());
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
            String h2 = v().h2();
            String I = postData.I();
            String I2 = postData2 != null ? postData2.I() : "";
            int V = v().P1() != null ? v().P1().V() : 0;
            if (j3() != null && j3().Z0() != null) {
                n2 = j3().Z0().n(I);
            } else if (S2() == null || S2().b1() == null) {
                return;
            } else {
                n2 = S2().b1().n(I);
            }
            AbsPbActivity.e eVar = n2;
            if (postData == null || v() == null || v().P1() == null || eVar == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(h2, I, "pb", true, F3(), null, false, I2, V, postData.U(), v().P1().d(), false, postData.s().getIconInfo(), V2(), V2() == 1 || V2() == 2 || V2() == 3 || V2() == 4 || V2() == 5).addBigImageData(eVar.a, eVar.b, eVar.g, eVar.j);
            if (z3) {
                addBigImageData.setHighLightPostId(I2);
                z4 = true;
                addBigImageData.setKeyIsUseSpid(true);
            } else {
                z4 = true;
            }
            addBigImageData.setKeyFromForumId(v().getForumId());
            addBigImageData.setTiebaPlusData(v().H(), v().D(), v().E(), v().C(), v().I());
            addBigImageData.setBjhData(v().h1());
            addBigImageData.setKeyPageStartFrom(v().O1());
            addBigImageData.setFromFrsForumId(v().getFromForumId());
            addBigImageData.setWorksInfoData(v().m2());
            addBigImageData.setIsOpenEditor(z2);
            if (v().P1().o() != null) {
                addBigImageData.setHasForumRule(v().P1().o().has_forum_rule.intValue());
            }
            if (v().P1().U() != null) {
                addBigImageData.setIsManager(v().P1().U().getIs_manager());
            }
            if (v().P1().l().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(v().P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(v().P1().l().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (v().P1().l() != null) {
                addBigImageData.setForumHeadUrl(v().P1().l().getImage_url());
                addBigImageData.setUserLevel(v().P1().l().getUser_level());
            }
            if (v() != null && (U2 = U2(v().P1())) != null) {
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
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return null;
            }
            return (DetailInfoAndReplyFragment) this.f.b(0);
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public final boolean S3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String q2 = iu4.k().q("bubble_link", "");
                if (StringUtils.isNull(q2)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    fm4.q(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f052e), q2 + "?props_id=" + str, true, true, true);
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
        fallingView.F();
    }

    public DetailInfoFragment T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(0) instanceof DetailInfoFragment)) {
                return null;
            }
            return (DetailInfoFragment) this.f.b(0);
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    public boolean T3(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        zz7 zz7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048634, this, i2, keyEvent)) == null) {
            if (!this.q1 && (this.r1 || J3())) {
                P4();
                UtilHelper.hideStatusBar(w(), w().getRootView());
                this.r1 = false;
                zz7 zz7Var2 = this.k;
                if (zz7Var2 != null) {
                    zz7Var2.S0(false);
                }
            }
            if (i2 == 4) {
                zz7 zz7Var3 = this.k;
                if (zz7Var3 != null) {
                    return zz7Var3.onBackPress();
                }
                return false;
            } else if (i2 == 24) {
                zz7 zz7Var4 = this.k;
                if (zz7Var4 != null) {
                    return zz7Var4.onVolumeUp();
                }
                return false;
            } else if (i2 != 25 || (zz7Var = this.k) == null) {
                return false;
            } else {
                return zz7Var.P0();
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

    @Override // com.repackage.gz7
    public PbModel.h U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.Y0 : (PbModel.h) invokeV.objValue;
    }

    public PostData U2(bs7 bs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, bs7Var)) == null) {
            PostData postData = null;
            if (bs7Var == null) {
                return null;
            }
            if (bs7Var.W() != null) {
                return bs7Var.W();
            }
            if (!ListUtils.isEmpty(bs7Var.F())) {
                Iterator<PostData> it = bs7Var.F().iterator();
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
                postData = bs7Var.j();
            }
            if (postData == null) {
                postData = h3(bs7Var);
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
            this.h.setVisibility(z2 ? 0 : 8);
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
            if (!ki.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c2e);
            } else if (this.N == null || v() == null) {
            } else {
                this.N.F();
                if (this.L) {
                    return;
                }
                T4();
                z4();
                if (v().loadData()) {
                    J4();
                }
            }
        }
    }

    public final boolean V4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (v() == null) {
                return true;
            }
            if (v().P1() == null || !v().P1().g0()) {
                if (v().A1()) {
                    MarkData l12 = v().l1();
                    if (l12 != null && v().y1() && i3() != null) {
                        MarkData f12 = v().f1(i3().getFirstVisiblePosition());
                        if (f12 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", l12);
                            this.a.setResult(-1, intent);
                            return true;
                        } else if (f12.getPostId() != null && !f12.getPostId().equals(l12.getPostId())) {
                            nr4 nr4Var = new nr4(getBaseFragmentActivity());
                            nr4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f025e));
                            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0428, new t(this, f12, l12, nr4Var));
                            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new u(this, l12, nr4Var));
                            nr4Var.setOnCalcelListener(new w(this));
                            nr4Var.create(getBaseFragmentActivity().getPageContext());
                            nr4Var.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", l12);
                            this.a.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (v().P1() != null && v().P1().F() != null && v().P1().F().size() > 0 && v().y1()) {
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
            if (v() == null || v().P1() == null || v().P1().F() == null || (count = ListUtils.getCount((F = v().P1().F()))) == 0) {
                return "";
            }
            if (v().a2()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.I();
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
                if (v().F2(postData.s().getUserId())) {
                    return postData.I();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (v().F2(postData2.s().getUserId())) {
                        return postData2.I();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (v().F2(postData3.s().getUserId())) {
                        return postData3.I();
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
                ai8.g().h(getUniqueId(), false);
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
            b35 b35Var = this.I0;
            if (b35Var != null) {
                s4(b35Var.C());
            }
            j4();
            this.N.F();
        }
    }

    public abstract int X2();

    public void X3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048647, this, z2) == null) || w() == null) {
            return;
        }
        if (this.r1 && !TbSingleton.getInstance().isNotchScreen(w()) && !TbSingleton.getInstance().isCutoutScreen(w())) {
            P4();
            UtilHelper.hideStatusBar(w(), w().getRootView());
            this.r1 = false;
        }
        this.u0.b = z2;
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

    public void Y3(vz4 vz4Var, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048650, this, vz4Var, i2) == null) || (fallingView = this.K) == null) {
            return;
        }
        fallingView.D(vz4Var, getPageContext(), i2, false);
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
            this.k.X(false);
            return;
        }
        zz7 zz7Var = this.k;
        if (!F3() && !this.k.N0()) {
            z2 = true;
        }
        zz7Var.X(z2);
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

    public final void a4(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048656, this, bs7Var) == null) || bs7Var == null) {
            return;
        }
        ThreadData O = bs7Var.O();
        if (O != null && O.isUgcThreadType()) {
            y2();
        } else {
            w4(this.H0);
        }
        b35 b35Var = this.I0;
        if (b35Var != null) {
            s4(b35Var.C());
            this.I0.M(bs7Var.d());
            this.I0.N(bs7Var.l(), bs7Var.U());
            this.I0.r0(O);
            if (v() != null) {
                this.I0.O(v().r1(), v().h2(), v().n1());
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

    public SparseArray<Object> b3(bs7 bs7Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData U2;
        ep4 ep4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048658, this, new Object[]{bs7Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (bs7Var == null || (U2 = U2(bs7Var)) == null) {
                return null;
            }
            String userId = U2.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f091eb0, U2.I());
                sparseArray.put(R.id.obfuscated_res_0x7f091eb2, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(bs7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.FALSE);
            } else if (i2 == 1) {
                if (U2.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebb, U2.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebc, U2.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebd, U2.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebe, U2.I());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091eb0, U2.I());
                sparseArray.put(R.id.obfuscated_res_0x7f091eb2, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(bs7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091ef0, Boolean.TRUE);
            }
            if (!z3) {
                List<yq4> p2 = bs7Var.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (yq4 yq4Var : p2) {
                        if (yq4Var != null && !StringUtils.isNull(yq4Var.a()) && (ep4Var = yq4Var.g) != null && ep4Var.a && !ep4Var.c && ((i3 = ep4Var.b) == 1 || i3 == 2)) {
                            sb.append(li.cutString(yq4Var.a(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f064b));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eaf, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void b4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048659, this) == null) || !checkUpIsLogin() || v() == null || v().P1() == null || v().P1().l() == null || A2()) {
            return;
        }
        if (v().P1().g0()) {
            E2();
            return;
        }
        if (this.D0 == null) {
            rm6 rm6Var = new rm6(getPageContext());
            this.D0 = rm6Var;
            rm6Var.j(0);
            this.D0.i(new b1(this));
        }
        this.D0.g(v().P1().l().getId(), kg.g(v().h2(), 0L));
    }

    public final void b5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048660, this) == null) || v() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.D(v().getForumId()) || v().P1() == null || v().P1().l() == null) {
            return;
        }
        if (v().P1().l().isLike() == 1) {
            v().c1().C(v().getForumId(), v().h2());
        }
    }

    public xl4 c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.P : (xl4) invokeV.objValue;
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048662, this) == null) || this.k == null || this.e == null) {
            return;
        }
        boolean z2 = false;
        if (!I3()) {
            this.k.R0(false);
        } else if (this.e.getCurrentItem() != 0) {
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

    public void c5(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, bs7Var) == null) {
            if (bs7Var != null && AntiHelper.o(bs7Var.O())) {
                k08 k08Var = this.r0;
                if (k08Var != null) {
                    k08Var.k(false);
                    this.r0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.q0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.q0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.q0, R.drawable.obfuscated_res_0x7f080944, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            k08 k08Var2 = this.r0;
            if (k08Var2 == null || !k08Var2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.q0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.q0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.q0, R.drawable.obfuscated_res_0x7f080944, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public View.OnLongClickListener d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.L1 : (View.OnLongClickListener) invokeV.objValue;
    }

    public void d4(boolean z2, int i2, int i3, int i4, bs7 bs7Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048665, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bs7Var, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.f.c()) {
                if (baseFragment instanceof fz7) {
                    ((fz7) baseFragment).t0(z2, i2, i3, i4, bs7Var, str, i5);
                }
            }
            t0(z2, i2, i3, i4, bs7Var, str, i5);
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
        Object[] objArr = (yf5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), yf5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (kw7.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX);
                spannableStringBuilder2.setSpan(new ne5(drawable), 0, 33, 33);
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

    public void e4(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048669, this, bs7Var) == null) || bs7Var == null || bs7Var.O() == null) {
            return;
        }
        c5(bs7Var);
        this.p0.setVisibility(bs7Var.g0() ? 8 : 0);
        if (bs7Var.r()) {
            WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f080940, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f08093f, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String O2 = O2(bs7Var.O().getReply_num());
        TextView textView = this.s0;
        if (textView != null) {
            textView.setText(O2);
        }
        TextView textView2 = this.t0;
        if (textView2 != null) {
            textView2.setText(O2);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, bs7Var.O()));
    }

    public b35 f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.I0 : (b35) invokeV.objValue;
    }

    public void f4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048671, this, z2, markData) == null) || v() == null) {
            return;
        }
        y4();
        v().C3(z2);
        xl4 xl4Var = this.P;
        if (xl4Var != null) {
            xl4Var.h(z2);
            if (markData != null) {
                this.P.i(markData);
            }
        }
        if (v().A1()) {
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

    @Override // com.repackage.gz7
    public void finish() {
        CardHListViewData q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            PbModel pbModel = this.a.getPbModel();
            if (pbModel != null && pbModel.P1() != null && !pbModel.P1().g0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = pbModel.P1().O().getId();
                if (pbModel.isShareThread() && pbModel.P1().O().originalThreadData != null) {
                    historyMessage.threadName = pbModel.P1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = pbModel.P1().O().getTitle();
                }
                if (pbModel.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = pbModel.P1().l().getName();
                }
                ArrayList<PostData> F = pbModel.P1().F();
                int S0 = j3() != null ? j3().S0() : 0;
                if (F != null && S0 >= 0 && S0 < F.size()) {
                    historyMessage.postID = F.get(S0).I();
                }
                historyMessage.isHostOnly = pbModel.s1();
                historyMessage.isSquence = pbModel.f2();
                historyMessage.isShareThread = pbModel.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            b35 b35Var = this.I0;
            if (b35Var != null) {
                b35Var.I();
            }
            if (pbModel != null && (pbModel.u1() || pbModel.x1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", pbModel.h2());
                if (this.y0) {
                    if (this.A0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", pbModel.D1());
                    }
                    if (this.z0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", pbModel.z1());
                    }
                }
                if (pbModel.P1() != null && System.currentTimeMillis() - this.b >= 40000 && (q2 = pbModel.P1().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                    intent.putExtra("guess_like_data", q2);
                }
                this.a.setResult(-1, intent);
            }
            if (V4()) {
                if (pbModel != null) {
                    bs7 P1 = pbModel.P1();
                    if (P1 != null) {
                        if (P1.U() != null) {
                            P1.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!this.B0) {
                            if (this.j != null) {
                                Rect rect = new Rect();
                                this.j.getGlobalVisibleRect(rect);
                                xv7.b().t(rect);
                            }
                            xv7.b().s(this.e.getCurrentItem());
                            BdTypeRecyclerView i3 = i3();
                            xv7.b().n(pbModel.Q1(), i3 != null ? i3.onSaveInstanceState() : null, pbModel.f2(), pbModel.s1(), false);
                        }
                    }
                } else {
                    xv7.b().m();
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

    public void g4(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048674, this, bs7Var) == null) || bs7Var == null || bs7Var.O() == null) {
            return;
        }
        String valueOf = String.valueOf(bs7Var.O().getReply_num());
        if (bs7Var.O().getReply_num() == 0) {
            valueOf = "";
        }
        this.d.F(valueOf);
    }

    @Override // com.repackage.bg5
    public bg<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            if (this.V == null) {
                this.V = new bg<>(new t1(this), 20, 0);
            }
            return this.V;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            if (this.X == null) {
                this.X = new bg<>(new s1(this), 8, 0);
            }
            return this.X;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
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

    @Override // com.repackage.bg5
    public bg<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            bg<RelativeLayout> bgVar = new bg<>(new w1(this), 10, 0);
            this.g0 = bgVar;
            return bgVar;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.bg5
    public bg<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            if (this.W == null) {
                this.W = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.W;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            if (this.Z == null) {
                this.Z = new bg<>(new v1(this), 15, 0);
            }
            return this.Z;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.repackage.bg5
    public bg<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
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

    @Override // com.repackage.bg5
    public bg<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            if (this.Y == null) {
                this.Y = new bg<>(new u1(this), 8, 0);
            }
            return this.Y;
        }
        return (bg) invokeV.objValue;
    }

    public final PostData h3(bs7 bs7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048687, this, bs7Var)) == null) {
            if (bs7Var == null || bs7Var.O() == null || bs7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = bs7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = bs7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.p0(1);
            postData.u0(bs7Var.O().getFirstPostId());
            postData.G0(bs7Var.O().getTitle());
            postData.F0(bs7Var.O().getCreateTime());
            postData.n0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void h4(rs7 rs7Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048688, this, rs7Var) == null) || v() == null || v().P1() == null || rs7Var.i() == null) {
            return;
        }
        String I = rs7Var.i().I();
        ArrayList<PostData> F = v().P1().F();
        int i2 = 0;
        while (true) {
            z2 = true;
            if (i2 >= F.size()) {
                break;
            }
            PostData postData = F.get(i2);
            if (postData.I() == null || !postData.I().equals(I)) {
                i2++;
            } else {
                ArrayList<PostData> k2 = rs7Var.k();
                postData.D0(rs7Var.m());
                if (postData.R() != null && k2 != null) {
                    Iterator<PostData> it = k2.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.Y() != null && next != null && next.s() != null && (metaData = postData.Y().get(next.s().getUserId())) != null) {
                            next.n0(metaData);
                            next.x0(true);
                            next.J0(getPageContext(), v().F2(metaData.getUserId()));
                        }
                    }
                    boolean z3 = k2.size() != postData.R().size();
                    if (!postData.c0(true)) {
                        postData.R().clear();
                        postData.R().addAll(k2);
                    }
                    z2 = z3;
                }
                if (postData.x() != null) {
                    postData.l0();
                }
            }
        }
        if (v().y1() || !z2) {
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
            Iterator<BaseFragment> it = this.f.c().iterator();
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
        x25.a().c(0);
        this.I0.T();
        this.I0.R();
        if (this.I0.y() != null) {
            this.I0.y().setMaxImagesAllowed(this.I0.v ? 1 : 9);
        }
        this.I0.l0(SendView.g);
        this.I0.j(SendView.g);
        d15 m2 = this.J0.m(23);
        d15 m3 = this.J0.m(2);
        d15 m4 = this.J0.m(5);
        if (m3 != null) {
            m3.e();
        }
        if (m4 != null) {
            m4.e();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.J0.invalidate();
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048691, this) == null) {
            xl4 c2 = xl4.c(this.a);
            this.P = c2;
            if (c2 != null) {
                c2.j(this.Z0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.T = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.y1);
            this.S = new py4(getPageContext());
            this.N = new uz7(this);
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
            return pbModel.E2();
        }
        return invokeV.booleanValue;
    }

    public ReplyFragment j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(1) instanceof ReplyFragment)) {
                return null;
            }
            return (ReplyFragment) this.f.b(1);
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
            if (!li.isEmpty(this.v0)) {
                return this.v0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(dw7.b());
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
        j15 j15Var;
        bv7 bv7Var;
        j15 j15Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048697, this, i2, intent) == null) {
            if (i2 == 0) {
                p3();
                bv7 bv7Var2 = this.K0;
                if (bv7Var2 != null) {
                    bv7Var2.c();
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
                    i15 n2 = this.I0.a().n(6);
                    if (n2 != null && (j15Var = n2.m) != null) {
                        j15Var.onAction(new w05(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.I0.L(null, null);
                    }
                } else if (editorType != 1 || (bv7Var = this.K0) == null || bv7Var.b() == null) {
                } else {
                    e35 b3 = this.K0.b();
                    b3.c0(v().P1().O());
                    b3.B(writeData);
                    b3.d0(pbEditorData.getVoiceModel());
                    i15 n3 = b3.a().n(6);
                    if (n3 != null && (j15Var2 = n3.m) != null) {
                        j15Var2.onAction(new w05(52, 0, pbEditorData.getVoiceModel()));
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
        bs7 P1;
        int i2;
        k08 k08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048699, this, z2) == null) || v() == null || this.N == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (P1 = v().P1()) == null) {
            return;
        }
        ThreadData O = P1.O();
        if (O != null && O.getAuthor() != null) {
            TiebaStatic.log(new StatisticItem("c13402").param("tid", v().h2()).param("fid", P1.m()).param("obj_locate", 4).param("uid", O.getAuthor().getUserId()));
            if (F3()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", v().getForumId());
                statisticItem.param("tid", v().h2());
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
            statisticItem2.param("tid", v().h2());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("fid", v().getForumId());
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
                if (O.getBaijiahaoData() != null && !li.isEmpty(O.getBaijiahaoData().oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, O.getBaijiahaoData().oriUgcVid);
                }
            }
            if (!li.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (w() != null) {
                l85.e(w(), statisticItem2);
            }
            k08Var = this.r0;
            if (k08Var != null) {
                statisticItem2.param("obj_param1", k08Var.f());
            }
            TiebaStatic.log(statisticItem2);
            if (mi.C()) {
                showToast(R.string.obfuscated_res_0x7f0f0c2d);
                return;
            } else if (v().P1() == null) {
                mi.N(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0dca));
                return;
            } else {
                ArrayList<PostData> F = P1.F();
                if ((F == null || F.size() <= 0) && v().f2()) {
                    mi.N(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0dca));
                    return;
                }
                this.N.F();
                T4();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), O)) {
                    return;
                }
                k08 k08Var2 = this.r0;
                if (k08Var2 != null) {
                    k08Var2.k(false);
                    c5(P1);
                }
                if (ShareSwitch.isOn()) {
                    int i4 = z2 ? 2 : 1;
                    if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.r0.h()) {
                        this.r0.l(false);
                        t3(ez4.a(), this.r0.f());
                        return;
                    }
                    L4(i4);
                    return;
                }
                this.N.B0();
                v().j1().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                return;
            }
        }
        i2 = 1;
        StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem22.param("tid", v().h2());
        statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem22.param("fid", v().getForumId());
        if (!z2) {
        }
        statisticItem22.param("obj_name", i2);
        statisticItem22.param("obj_type", 2);
        if (O != null) {
        }
        if (!li.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
        }
        if (w() != null) {
        }
        k08Var = this.r0;
        if (k08Var != null) {
        }
        TiebaStatic.log(statisticItem22);
        if (mi.C()) {
        }
    }

    public boolean m4(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048700, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091eae);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (!TextUtils.isEmpty(postData.u()) && ln4.c().g()) {
                        return S3(postData.I());
                    }
                    if (checkUpIsLogin() && v() != null && v().P1() != null) {
                        bv7 bv7Var = this.K0;
                        if (bv7Var != null) {
                            bv7Var.c();
                        }
                        rs7 rs7Var = new rs7();
                        rs7Var.A(v().P1().l());
                        rs7Var.E(v().P1().O());
                        rs7Var.C(postData);
                        this.L0.U(rs7Var);
                        this.L0.setPostId(postData.I());
                        P3(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        b35 b35Var = this.I0;
                        if (b35Var != null) {
                            s4(b35Var.C());
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
            ex7 ex7Var = new ex7(this.a);
            this.Q = ex7Var;
            ex7Var.n(this.C1);
            this.Q.m(this.k1);
        }
        this.Q.k(emotionImageData, v(), v().P1());
    }

    public void o3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048703, this, z2) == null) || this.k0 == null || this.n0 == null) {
            return;
        }
        if (v() != null && v().P1() != null) {
            this.n0.setText(TbSingleton.getInstance().getAdVertiComment(v().P1().k0(), v().P1().l0(), k3()));
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
        if (!(interceptable == null || interceptable.invokeI(1048704, this, i2) == null) || v() == null) {
            return;
        }
        showLoadingView(getView());
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
        privacySettingMessage.setTid(v().h2());
        sendMessage(privacySettingMessage);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906cd));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            a4(videoPbViewModel.c());
            B3(videoPbViewModel.c());
            g4(videoPbViewModel.c());
            if (v() != null && v().P1() != null) {
                boolean y12 = v().y1();
                bs7 P1 = v().P1();
                if (y12) {
                    PostData U2 = U2(P1);
                    if (P1.u() != null && !P1.u().equals(U2.I()) && this.e != null) {
                        if (I3()) {
                            this.e.setCurrentItem(1);
                        } else {
                            this.e.setCurrentItem(0);
                        }
                    }
                }
            }
            videoPbViewModel.k().observe(this, new f0(this));
            videoPbViewModel.b().observe(this, new h0(this));
            videoPbViewModel.j().observe(this, new i0(this));
            videoPbViewModel.h().observe(this, new j0(this));
            videoPbViewModel.e().observe(this, new k0(this));
            videoPbViewModel.f().observe(this, new l0(this));
            this.a.getTiePlusEventController().l(this.V0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048706, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.I0.H(i2, i3, intent);
            ex7 ex7Var = this.Q;
            if (ex7Var != null) {
                ex7Var.i(i2, i3, intent);
            }
            bv7 bv7Var = this.K0;
            if (bv7Var != null) {
                bv7Var.g(i2, i3, intent);
            }
            if (i2 == 25035) {
                l3(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 11009) {
                    R3();
                } else if (i2 != 13011) {
                    switch (i2) {
                        case 25055:
                            View view2 = this.x;
                            if (view2 != null) {
                                view2.performClick();
                                return;
                            }
                            return;
                        case 25056:
                            View view3 = this.y;
                            if (view3 != null) {
                                view3.performClick();
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
                            View view4 = this.z;
                            if (view4 != null) {
                                view4.performClick();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    m98.g().m(getPageContext());
                }
            }
        }
    }

    @Override // com.repackage.bg5
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
            getBaseFragmentActivity().getLayoutMode().j(this.c);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0611);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0207);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.d;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.G();
            }
            hw7 hw7Var = this.F0;
            if (hw7Var != null) {
                hw7Var.i();
            }
            jz7 jz7Var = this.l;
            if (jz7Var == null || !jz7Var.k()) {
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            EditorTools editorTools = this.J0;
            if (editorTools != null) {
                editorTools.w(i2);
            }
            bv7 bv7Var = this.K0;
            if (bv7Var != null) {
                bv7Var.h(i2);
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
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(mi.f(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (v() != null && v().A1()) {
                WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f080940, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f08093f, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.o0, R.drawable.obfuscated_res_0x7f080942, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.E, R.drawable.obfuscated_res_0x7f080909, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (v() != null) {
                c5(v().P1());
            }
            SkinManager.setBackgroundResource(this.g, R.drawable.personalize_tab_shadow);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.k0, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.j0, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n0, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.t0, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.s0, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundShapeDrawable(this.s0, mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (S2() != null) {
                S2().onChangeSkinType(i2);
            } else if (I3() && j3() != null) {
                j3().onChangeSkinType(i2);
            }
            if (T2() != null) {
                T2().onChangeSkinType(i2);
            }
            View view2 = this.H;
            if (view2 != null) {
                view2.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(mi.f(view2.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            }
            T4();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            zz7 zz7Var = this.k;
            if (zz7Var == null || zz7Var.N0()) {
                return;
            }
            if (!(this.k.isFullScreen() && configuration.orientation == 1) && (this.k.isFullScreen() || configuration.orientation != 2)) {
                return;
            }
            this.k.V(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, bundle) == null) {
            this.b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            x3(bundle);
            getVoiceManager().onCreate(getPageContext());
            mu4 mu4Var = new mu4();
            this.O = mu4Var;
            mu4Var.a = 1000L;
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
            this.t = new sw5(getPageContext());
            ai8.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048712, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(X2(), viewGroup, false);
            D3();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            super.onDestroy();
            ai8.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.H1);
            getVoiceManager().onDestory(getPageContext());
            k08 k08Var = this.r0;
            if (k08Var != null) {
                k08Var.j();
            }
            ForumManageModel forumManageModel = this.T;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            zz7 zz7Var = this.k;
            if (zz7Var != null) {
                zz7Var.O0();
            }
            ex7 ex7Var = this.Q;
            if (ex7Var != null) {
                ex7Var.f();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.C0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            if (v() != null) {
                v().cancelLoadData();
                v().destory();
                if (v().L1() != null) {
                    v().L1().d();
                }
            }
            b35 b35Var = this.I0;
            if (b35Var != null) {
                b35Var.I();
            }
            this.O = null;
            S4();
        }
    }

    @Override // com.repackage.bg5
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048714, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.h0 = true;
    }

    @Override // com.repackage.bg5
    public void onLinkClicked(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048715, this, context, str, z2) == null) {
            if (kw7.c(str) && v() != null && v().h2() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", v().h2()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    k05 k05Var = new k05();
                    k05Var.a = str;
                    k05Var.b = 3;
                    k05Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, k05Var));
                }
            } else {
                kw7.a().e(getPageContext(), str);
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
            zz7 zz7Var = this.k;
            if (zz7Var != null) {
                zz7Var.onBackground(true);
            }
            if (v() != null && !v().C1()) {
                this.I0.U(v().h2());
            }
            RightFloatLayerView rightFloatLayerView = this.X0;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            zi4.y().G();
            MessageManager.getInstance().unRegisterListener(this.h1);
            MessageManager.getInstance().unRegisterListener(this.i1);
            MessageManager.getInstance().unRegisterListener(this.g1);
            MessageManager.getInstance().unRegisterListener(this.G1);
        }
    }

    @Override // com.repackage.bg5
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048717, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.N.p0(str);
        pr4 R = this.N.R();
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
            zz7 zz7Var = this.k;
            if (zz7Var != null) {
                zz7Var.onBackground(false);
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
            if (v() != null) {
                v().i3(bundle);
            }
            if (getPageContext() == null || getPageContext().getPageActivity() == null) {
                return;
            }
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.repackage.bg5
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
            ai8.g().h(getUniqueId(), false);
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

    @Override // com.repackage.bg5
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048724, this, context, str) == null) {
            kw7.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.h0 = true;
        }
    }

    @Override // com.repackage.bg5
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
        mi.w(getPageContext().getPageActivity(), this.a.getCurrentFocus());
    }

    public void q4(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, editorTools) == null) {
            this.J0 = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f0916c4);
            this.J0.setOnCancelClickListener(new e1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.J0.getParent() == null) {
                this.c.addView(this.J0, layoutParams);
            }
            this.J0.w(TbadkCoreApplication.getInst().getSkinType());
            this.J0.setActionListener(24, new f1(this));
            p3();
            this.I0.i(new g1(this));
        }
    }

    public void r3() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048730, this) == null) || (view2 = this.M) == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public final void r4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            this.K.setFallingFeedbackListener(new FallingView.l() { // from class: com.repackage.ez7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pb.view.FallingView.l
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AbsVideoPbFragment.this.N3();
                    }
                }
            });
        }
    }

    @Override // com.repackage.gz7
    public AbsVideoPbFragment s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    public void s3() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048733, this) == null) || (rightFloatLayerView = this.X0) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public void s4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048734, this, z2) == null) {
            this.w0 = z2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || (customViewPager = this.e) == null) {
                return;
            }
            videoPbFragmentAdapter.d(z2 ? customViewPager.getCurrentItem() : -1);
        }
    }

    @Override // com.repackage.fz7
    public void t0(boolean z2, int i2, int i3, int i4, bs7 bs7Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048736, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bs7Var, str, Integer.valueOf(i5)}) == null) {
        }
    }

    public final void t3(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048737, this, i2, i3) == null) {
            vd5.b(new z(this, i3), new a0(this, i3, i2));
        }
    }

    public void t4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048738, this, z2) == null) {
            this.L = z2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048740, this) == null) || v() == null || li.isEmpty(v().h2())) {
            return;
        }
        super.taskStart();
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048741, this) == null) || v() == null || v().P1() == null || v().P1().O() == null) {
            return;
        }
        ThreadData O = v().P1().O();
        O.mRecomAbTag = v().U1();
        O.mRecomWeight = v().X1();
        O.mRecomSource = v().W1();
        O.mRecomExtra = v().V1();
        O.isSubPb = v().C1();
        if (O.getFid() == 0) {
            O.setFid(kg.g(v().getForumId(), 0L));
        }
        StatisticItem i2 = l85.i(getContext(), O, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            this.i0 = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092387);
            this.j0 = this.c.findViewById(R.id.obfuscated_res_0x7f0923e5);
            this.k0 = this.c.findViewById(R.id.obfuscated_res_0x7f0916c8);
            mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            mi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070287);
            HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0916cc);
            this.m0 = headImageView;
            headImageView.setVisibility(0);
            this.m0.setIsRound(true);
            this.m0.setBorderWidth(mi.f(getContext(), R.dimen.L_X01));
            this.m0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.m0.setPlaceHolder(0);
            O3();
            this.n0 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0916cb);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0916c3);
            this.l0 = linearLayout;
            linearLayout.setOnClickListener(new u0(this));
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0916c9);
            this.o0 = imageView;
            imageView.setOnClickListener(this.D1);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0916c7);
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
                this.p0.setPadding(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0916cd);
            this.q0 = imageView3;
            imageView3.setOnClickListener(this.D1);
            this.r0 = new k08(this.q0);
            if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
                this.r0.e();
            }
            if (v() != null && UbsABTestHelper.isResizeInduceSharingABTest() && !wx7.k(v().h2())) {
                this.r0.e();
                wx7.b(v().h2());
            }
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0916ca);
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

    @Override // com.repackage.gz7
    public PbModel v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) ? this.a.getPbModel() : (PbModel) invokeV.objValue;
    }

    public final void v2(boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048745, this, z2, str) == null) || v() == null || v().P1() == null || v().P1().O() == null) {
            return;
        }
        ThreadData O = v().P1().O();
        O.mRecomAbTag = v().U1();
        O.mRecomWeight = v().X1();
        O.mRecomSource = v().W1();
        O.mRecomExtra = v().V1();
        if (O.getFid() == 0) {
            O.setFid(kg.g(v().getForumId(), 0L));
        }
        StatisticItem i2 = l85.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
        TbPageTag l2 = l85.l(getContext());
        if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
        }
        if (i2 != null) {
            if (O.isVideoThreadType()) {
                i2.param(TiebaStatic.Params.POST_CONTENT, xd5.d(str) > 40 ? xd5.n(str, 40) : str);
            }
            i2.param(TiebaStatic.Params.REPLY_TYPE, 1);
            if (z2) {
                i2.addParam("obj_type", 2);
            } else {
                i2.addParam("obj_type", 1);
            }
            g85 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
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
            i2.addParam("tid", v().h2());
            i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i2.addParam("fid", v().P1().m());
            TiebaStatic.log(i2);
        }
        StatisticItem i3 = l85.i(getContext(), O, "c14180");
        if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i3.addParam("obj_type", 2);
        } else {
            i3.addParam("obj_type", 1);
        }
        i3.param("tid", v().h2());
        i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
        i3.param("fid", v().P1().m());
        if (l2 != null) {
            i3.param("obj_source", l2.tabType);
        }
        TiebaStatic.log(i3);
        StatisticItem i4 = l85.i(getContext(), O, "c14303");
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
            i4.param("tid", v().h2());
            i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i4.param("fid", v().P1().m());
            i4.param("obj_type", 1);
        }
        TiebaStatic.log(i4);
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            this.L0 = new PbFakeFloorModel(getPageContext());
            PbModel v2 = v();
            this.L0.R(v2.H(), v2.D(), v2.E(), v2.C(), v2.I());
            this.L0.setFromForumId(v2.getFromForumId());
            bv7 bv7Var = new bv7(getPageContext(), this.L0, this.c);
            this.K0 = bv7Var;
            bv7Var.k(new x0(this));
            this.K0.n(this.B1);
            this.L0.T(new y0(this));
        }
    }

    public abstract void v4(boolean z2);

    @Override // com.repackage.gz7
    public AbsPbActivity w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) ? this.a : (AbsPbActivity) invokeV.objValue;
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
        Rect g12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, threadData) == null) {
            double k2 = mi.k(getContext());
            double i3 = (2.0d * k2) / mi.i(getContext());
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
                    int height = (v() != null || (g12 = v().g1()) == null) ? ceil : g12.height();
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
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, O1);
                        } else {
                            layoutParams3.height = O1;
                        }
                        this.d.setLayoutParams(layoutParams3);
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
            if (v() != null) {
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
        if (interceptable == null || interceptable.invokeV(1048750, this) == null) {
            q4(this.I0.a());
        }
    }

    public final void w4(d35 d35Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048751, this, d35Var) == null) || d35Var == null || v() == null) {
            return;
        }
        d35Var.p(v().o1());
        if (v().P1() != null && v().P1().l() != null) {
            d35Var.o(v().P1().l());
        }
        d35Var.q("pb");
        d35Var.r(v());
    }

    @Override // com.repackage.gz7
    public PbFragment x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    public final void x2(xz7 xz7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048753, this, xz7Var) == null) && xz7Var != null && this.w == null) {
            this.w = xz7Var;
            this.C.setText(xz7Var.getTitle());
            this.D.setText(xz7Var.m());
            String k2 = xz7Var.k();
            TBSpecificationBtn tBSpecificationBtn = this.F;
            if (TextUtils.isEmpty(k2)) {
                k2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0de9);
            }
            tBSpecificationBtn.setText(k2);
            this.G.K(xz7Var.g(), 10, false);
            this.H.setVisibility(xz7Var.q() ? 0 : 8);
            ng.a().postDelayed(new j1(this), xz7Var.e().longValue() * 1000);
        }
    }

    public final void x3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, bundle) == null) {
            d35 d35Var = new d35();
            this.H0 = d35Var;
            w4(d35Var);
            b35 b35Var = (b35) this.H0.a(getActivity());
            this.I0 = b35Var;
            b35Var.e0(this.a.getPageContext());
            this.I0.n0(this.k1);
            this.I0.o0(this.C1);
            this.I0.g0(1);
            this.I0.F(this.a.getPageContext(), bundle);
            this.I0.a().b(new g15(getActivity()));
            this.I0.a().C(true);
            D4(true);
            if (v() != null) {
                this.I0.O(v().r1(), v().h2(), v().n1());
            }
            registerListener(this.c1);
            registerListener(this.e1);
            registerListener(this.m1);
            registerListener(this.b1);
            registerListener(this.d1);
            registerListener(this.f1);
            registerListener(this.K1);
            if (!v().C1()) {
                this.I0.s(v().h2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.I0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (v().v2()) {
                this.I0.k0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dda));
            } else {
                this.I0.k0(k3());
            }
            this.F0 = new hw7();
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
        if (interceptable == null || interceptable.invokeZL(1048755, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            uz7 uz7Var = this.N;
            if (uz7Var == null) {
                return;
            }
            if (z2) {
                uz7Var.F();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.N.G();
            } else {
                this.N.F();
            }
        }
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048756, this) == null) || v() == null || this.a == null) {
            return;
        }
        b35 b35Var = this.I0;
        if (b35Var == null || !b35Var.v) {
            a35 a35Var = new a35();
            w4(a35Var);
            b35 b35Var2 = (b35) a35Var.a(getContext());
            this.I0 = b35Var2;
            b35Var2.e0(this.a.getPageContext());
            this.I0.n0(this.k1);
            this.I0.o0(this.C1);
            this.I0.F(this.a.getPageContext(), this.a.getIntent() == null ? null : this.a.getIntent().getExtras());
            this.I0.a().C(true);
            q4(this.I0.a());
            if (!v().C1()) {
                this.I0.s(v().h2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.I0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (v().v2()) {
                this.I0.k0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dda));
            } else {
                this.I0.k0(k3());
            }
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            this.C = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09176a);
            this.G = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091769);
            this.D = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091766);
            this.E = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091765);
            this.F = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f091768);
            this.H = this.c.findViewById(R.id.obfuscated_res_0x7f0901eb);
            this.G.setRadius(mi.f(getContext(), R.dimen.tbds10));
            this.G.setConrers(15);
            this.F.setConfig(new zu4());
            this.E.setOnClickListener(new t0(this));
            this.F.setOnClickListener(this.B);
            this.v.setOnClickListener(this.B);
            if (v() == null || v().P1() == null) {
                return;
            }
            I4(v().P1());
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
                if (((vz4) ListUtils.getItem(arrayList, 0)).e() != 1) {
                    Y3((vz4) ListUtils.getItem(arrayList, 0), 1);
                } else if (z2) {
                } else {
                    Y3((vz4) ListUtils.getItem(arrayList, 0), 0);
                }
            }
        }
    }

    public final void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f092388);
            this.m = navigationBar;
            navigationBar.setOnClickListener(new w0(this));
            this.m.hideBottomLine();
            this.m.getTopCoverBgView().setBackgroundResource(R.drawable.obfuscated_res_0x7f0802c9);
            this.m.getTopCoverBgView().setVisibility(0);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f091deb);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f091df0);
            this.o = findViewById;
            if (this.q1) {
                ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
                layoutParams.height = mi.r(w());
                this.n.setLayoutParams(layoutParams);
                this.n.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = mi.r(w());
                this.o.setLayoutParams(layoutParams2);
                this.o.setVisibility(0);
            }
            View addSystemImageButton = this.m.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.D1);
            this.p = addSystemImageButton;
            this.q = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f09249c);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.obfuscated_res_0x7f080611, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05dc, this.D1);
            this.r = addCustomView;
            this.s = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09152a);
            int f2 = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds132);
            int f3 = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds21);
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
            mi.w(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    /* loaded from: classes3.dex */
    public class b2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public final /* synthetic */ AbsVideoPbFragment c;

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
            this.c = absVideoPbFragment;
            this.b = true;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.a && this.b) ? false : true : invokeV.booleanValue;
        }

        public /* synthetic */ b2(AbsVideoPbFragment absVideoPbFragment, k kVar) {
            this(absVideoPbFragment);
        }
    }
}
