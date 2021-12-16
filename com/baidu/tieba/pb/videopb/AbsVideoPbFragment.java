package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
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
import c.a.r0.f1.n.f;
import c.a.r0.i.a;
import c.a.r0.s.r.d2;
import c.a.r0.s.t.a;
import c.a.s0.d1.r2.a.c;
import c.a.s0.q0.b;
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
import com.baidu.tbadk.core.view.ItemCardView;
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
/* loaded from: classes12.dex */
public abstract class AbsVideoPbFragment extends BaseFragment implements c.a.r0.f1.n.i, VoiceManager.j, c.a.s0.s2.y.b, TbRichTextView.s, c.a.s0.s2.y.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BDALERT_DIALOG_CLICK_FROM = 0;
    public static final int D1;
    public static final int DETAIL_INFO_AND_REPLY_PAGE = 0;
    public static final int DETAIL_INFO_PAGE = 0;
    public static final int DIALOG_FROM_MANAGE = 3;
    public static final int DIALOG_FROM_UPGRADE_THREAD = 4;
    public static final int DIALOG_FROM_UPGRADE_THREAD_FAILED = 5;
    public static final int DIALOG_FROM_UPGRADE_THREAD_HAS_SAME = 6;
    public static final int E1;
    public static final int REPLY_PAGE = 1;
    public static final int THREAD_CAN_UPGRADE = 3;
    public static final int UPDATE_TYPE_DELETE = 1;
    public static final int UPDATE_TYPE_MARK = 2;
    public static final int UPDATE_TYPE_WRITE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public PermissionJudgePolicy A0;
    public final ItemCardHelper.c A1;
    public ImageView B;
    public c.a.r0.x.x.g B0;
    public CustomMessageListener B1;
    public TBSpecificationBtn C;
    public c.a.r0.x.x.e C0;
    public final View.OnLongClickListener C1;
    public TbImageView D;
    public EditorTools D0;
    public View E;
    public c.a.s0.s2.u.f.t E0;
    public ValueAnimator F;
    public PbFakeFloorModel F0;
    public ValueAnimator G;
    public int[] G0;
    public FallingView H;
    public int H0;
    public boolean I;
    public int I0;
    public View J;
    public int J0;
    public c.a.r0.s.i0.c K;
    public int K0;
    public c.a.r0.i.a L;
    public int L0;
    public c.a.s0.s2.u.f.c1.f.a M;
    public boolean M0;
    public EmotionImageData N;
    public boolean N0;
    public c.a.r0.t.e.a O;
    @NonNull
    public TiePlusEventController.f O0;
    public ForumManageModel P;
    public FrameLayout P0;
    public VoiceManager Q;
    public RightFloatLayerView Q0;
    public c.a.d.f.k.b<GifView> R;
    public final PbModel.g R0;
    public c.a.d.f.k.b<TextView> S;
    public final a.InterfaceC0818a S0;
    public c.a.d.f.k.b<ImageView> T;
    public c.a.r0.x.x.b T0;
    public c.a.d.f.k.b<View> U;
    public final CustomMessageListener U0;
    public c.a.d.f.k.b<LinearLayout> V;
    public CustomMessageListener V0;
    public c.a.d.f.k.b<RelativeLayout> W;
    public final CustomMessageListener W0;
    public boolean X;
    public CustomMessageListener X0;
    public LinearLayout Y;
    public HttpMessageListener Y0;
    public View Z;
    public CustomMessageListener Z0;
    public View a0;
    public CustomMessageListener a1;
    public LinearLayout b0;
    public CustomMessageListener b1;
    public HeadImageView c0;
    public c.a.r0.x.x.b c1;
    public TextView d0;
    public final NewWriteModel.g d1;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f48389e;
    public ImageView e0;
    public View.OnClickListener e1;

    /* renamed from: f  reason: collision with root package name */
    public long f48390f;
    public ImageView f0;
    public CustomMessageListener f1;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f48391g;
    public ImageView g0;
    public int g1;

    /* renamed from: h  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f48392h;
    public c.a.s0.s2.z.i h0;
    public float h1;

    /* renamed from: i  reason: collision with root package name */
    public CustomViewPager f48393i;
    public TextView i0;
    public float i1;

    /* renamed from: j  reason: collision with root package name */
    public VideoPbFragmentAdapter f48394j;
    public boolean j1;

    /* renamed from: k  reason: collision with root package name */
    public View f48395k;
    public TextView k0;
    public boolean k1;
    public View l;
    public View.OnTouchListener l1;
    public final View.OnClickListener listener;
    public VideoContainerLayout m;
    public GestureDetector m1;
    public AppBarLayout mAppBarLayout;
    public View mBackButton;
    public c.a.s0.s2.u.f.v0 mContentProcessController;
    public c.a.s0.s2.y.g.a mDialogController;
    public c.a.s0.q0.b mDragActionManager;
    public View mMore;
    public NavigationBar mNavigationBar;
    public NewWriteModel.g mOnFloorPostWriteNewCallback;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public View mStatusBar;
    public View mStatusBarBackground;
    public c.a.s0.s2.y.e n;
    public GestureDetector.SimpleOnGestureListener n1;
    public ImageView o;
    public Runnable o1;
    public SortSwitchButton.f onSwitchChangeListener;
    public c.a.s0.s2.y.k.a operableVideoContainer;
    public ImageView p;
    public ObjectAnimator p1;
    public c.a.s0.f0.a q;
    public b2 q0;
    public ObjectAnimator q1;
    public boolean r;
    public String r0;
    public final c.a.d.a.e r1;
    public View s;
    public boolean s0;
    public View.OnTouchListener s1;
    public c.a.s0.s2.y.i.a t;
    public String t0;
    public final b.InterfaceC1295b t1;
    public View u;
    public boolean u0;
    public c.a.r0.x.x.c u1;
    public View v;
    public boolean v0;
    public View.OnClickListener v1;
    public View w;
    public boolean w0;
    public final AdapterView.OnItemClickListener w1;
    public MaskView x;
    public boolean x0;
    public CustomMessageListener x1;
    public View.OnClickListener y;
    public c.a.s0.d1.r2.a.c y0;
    public CustomMessageListener y1;
    public TextView z;
    public c.a.s0.d1.r2.a.c z0;
    public CustomMessageListener z1;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.M0) {
                return;
            }
            this.a.V1();
        }
    }

    /* loaded from: classes12.dex */
    public class a0 implements c.a.r0.d1.s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f48396b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48397c;

        public a0(AbsVideoPbFragment absVideoPbFragment, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48397c = absVideoPbFragment;
            this.a = i2;
            this.f48396b = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.d1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.a);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f48397c.getContext(), this.f48396b, shareItem, false));
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                c.a.s0.s2.y.g.a aVar = this.a.mDialogController;
                if (aVar != null) {
                    aVar.F();
                }
                boolean z = false;
                if (!c.a.d.f.p.k.z()) {
                    this.a.showToast(c.a.s0.s2.l.network_not_available);
                    return false;
                }
                if (this.a.getPbModel() != null && !this.a.getPbModel().isLoading) {
                    this.a.stopVoice();
                    this.a.setPreLoad();
                    z = true;
                    if (this.a.getPbModel().R0() != null && this.a.getPbModel().R0().f22526f != null && this.a.getPbModel().R0().f22526f.size() > i2) {
                        int intValue = this.a.getPbModel().R0().f22526f.get(i2).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.getPbModel().i1()).param("fid", this.a.getPbModel().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.getPbModel().B2(intValue)) {
                            this.a.I = true;
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

    /* loaded from: classes12.dex */
    public class a2 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            c.a.s0.s2.o oVar = (c.a.s0.s2.o) customResponsedMessage.getData();
            int type = oVar.getType();
            if (type == 0) {
                this.a.refreshWrite((c.a.s0.s2.r.t) oVar.a());
            } else if (type == 1) {
                this.a.k1((ForumManageModel.b) oVar.a(), false);
            } else if (type != 2) {
            } else {
                if (oVar.a() == null) {
                    this.a.refreshMark(false, null);
                } else {
                    this.a.refreshMark(true, (MarkData) oVar.a());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.h2();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48398e;

        public b0(AbsVideoPbFragment absVideoPbFragment) {
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
            this.f48398e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(c.a.s0.s2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.s0.s2.i.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(c.a.s0.s2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.s0.s2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(c.a.s0.s2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.s0.s2.i.tag_should_delete_visible)).booleanValue() : false;
            c.a.s0.s2.y.g.a aVar = this.f48398e.mDialogController;
            if (aVar != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(c.a.s0.s2.i.tag_from, 1);
                        this.f48398e.mDialogController.B(sparseArray);
                        return;
                    }
                    aVar.l0(view);
                } else if (booleanValue2) {
                    sparseArray.put(c.a.s0.s2.i.tag_from, 0);
                    sparseArray.put(c.a.s0.s2.i.tag_check_mute_from, 1);
                    this.f48398e.mDialogController.B(sparseArray);
                } else if (booleanValue3) {
                    aVar.g0(((Integer) sparseArray.get(c.a.s0.s2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(c.a.s0.s2.i.tag_del_post_id), ((Integer) sparseArray.get(c.a.s0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(c.a.s0.s2.i.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // c.a.s0.d1.r2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.s0.d1.r2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.C0 != null && this.a.C0.a() != null) {
                    this.a.C0.a().sendAction(new c.a.r0.x.a(45, 27, null));
                }
                this.a.clickCommentReply();
            }
        }

        @Override // c.a.s0.d1.r2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
                            new BdTopToast(this.a.getContext()).setIcon(true).setContent(this.a.getString(c.a.s0.s2.l.block_user_success)).show((ViewGroup) this.a.getView());
                            this.a.P1(type);
                            return;
                        }
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = this.a.getResources().getString(c.a.s0.s2.l.neterror);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        new BdTopToast(this.a.getContext()).setIcon(false).setContent(errorString).show((ViewGroup) this.a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c0 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48401e;

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
            this.f48401e = absVideoPbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f48401e.getPbModel() == null || this.f48401e.getPbModel().a1() == i2 + 1) {
                return;
            }
            AbsVideoPbFragment absVideoPbFragment = this.f48401e;
            absVideoPbFragment.N1(absVideoPbFragment.p1(i2));
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j2)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(c.a.s0.s2.r.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, c.a.s0.s2.r.f fVar, String str, int i5) {
            String replyHint;
            c.a.r0.x.h findLauncherById;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) {
                this.a.setPostPro();
                this.a.hideProgressView();
                if (this.a.I) {
                    this.a.I = false;
                }
                this.a.showCommonView(false);
                if (z && fVar != null) {
                    d2 O = fVar.O();
                    ((VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class)).setData(fVar, i3);
                    this.a.J1(fVar);
                    this.a.T1(fVar);
                    this.a.refreshTabText(fVar);
                    this.a.refreshAll(z, i2, i3, i4, fVar, str, i5);
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.U().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.U().getBimg_end_time());
                    if (fVar.F() != null && fVar.F().size() >= 1 && fVar.F().get(0) != null) {
                        this.a.getPbModel().i2(fVar.F().get(0).G());
                    } else if (fVar.W() != null) {
                        this.a.getPbModel().i2(fVar.W().G());
                    }
                    if (this.a.L != null) {
                        this.a.L.h(fVar.r());
                    }
                    AntiData d2 = fVar.d();
                    if (d2 != null) {
                        this.a.t0 = d2.getVoice_message();
                        if (!StringUtils.isNull(this.a.t0) && this.a.C0 != null && this.a.C0.a() != null && (findLauncherById = this.a.C0.a().findLauncherById(6)) != null && !TextUtils.isEmpty(this.a.t0)) {
                            ((View) findLauncherById).setOnClickListener(this.a.e1);
                        }
                    }
                    if (this.a.mReplyPrivacyController != null && O != null && O.J() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.J());
                        this.a.mReplyPrivacyController.setLikeUserData(attentionHostData);
                    }
                    this.a.initRightFloatLayerView(fVar);
                    if (this.a.getPbModel() != null && this.a.getPbModel().t1()) {
                        replyHint = this.a.getPageContext().getString(c.a.s0.s2.l.pb_reply_hint_from_smart_frs);
                    } else {
                        replyHint = this.a.getReplyHint();
                    }
                    if (!StringUtils.isNull(replyHint)) {
                        this.a.C0.k0(TbSingleton.getInstance().getAdVertiComment(fVar.k0(), fVar.l0(), replyHint));
                    }
                } else {
                    if (i2 == 4 || i2 == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.getPbModel().h1());
                            jSONObject.put("fid", this.a.getPbModel().getForumId());
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
                    if ((this.a.isShowDoubleTab() && this.a.getReplyFragment() == null) || this.a.getDetailInfoAndReplyFragment() == null) {
                        return;
                    }
                    ArrayList<PostData> arrayList = null;
                    if (this.a.isShowDoubleTab()) {
                        if (i2 != -1) {
                            if (this.a.getPbModel() != null && this.a.getPbModel().R0() != null) {
                                arrayList = this.a.getPbModel().R0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.a.getReplyFragment().setEndText(this.a.getResources().getString(c.a.s0.s2.l.list_no_more_new));
                            } else if (this.a.getReplyFragment().isHostOnlyMode()) {
                                this.a.getReplyFragment().setEndTextWithNoData(this.a.getResources().getString(c.a.s0.s2.l.pb_no_host_reply));
                            } else {
                                this.a.getReplyFragment().setEndTextWithNoData(this.a.getResources().getString(c.a.s0.s2.l.pb_no_replay));
                            }
                        } else {
                            this.a.getReplyFragment().setEndText("");
                        }
                        this.a.getReplyFragment().endLoadData();
                    } else {
                        if (i2 != -1) {
                            if (this.a.getPbModel() != null && this.a.getPbModel().R0() != null) {
                                arrayList = this.a.getPbModel().R0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.a.getDetailInfoAndReplyFragment().setEndText(this.a.getResources().getString(c.a.s0.s2.l.list_no_more_new));
                            } else if (this.a.getDetailInfoAndReplyFragment().isHostOnlyMode()) {
                                this.a.getDetailInfoAndReplyFragment().setEndTextWithNoData(this.a.getResources().getString(c.a.s0.s2.l.pb_no_host_reply));
                            } else {
                                this.a.getDetailInfoAndReplyFragment().setEndTextWithNoData(this.a.getResources().getString(c.a.s0.s2.l.pb_no_replay));
                            }
                        } else {
                            this.a.getDetailInfoAndReplyFragment().setEndText("");
                        }
                        this.a.getDetailInfoAndReplyFragment().endLoadData();
                    }
                }
                c.a.s0.u3.c.g().h(this.a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.mDialogController != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.s0.g4.a) && customResponsedMessage.getOrginalMessage().getTag() == this.a.mDialogController.D) {
                c.a.s0.g4.a aVar = (c.a.s0.g4.a) customResponsedMessage.getData();
                this.a.mDialogController.V();
                SparseArray<Object> sparseArray = (SparseArray) this.a.mDialogController.O();
                DataRes dataRes = aVar.a;
                if (aVar.f17891c == 0 && dataRes != null) {
                    int e2 = c.a.d.f.m.b.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r2 = e2 == 1;
                    if (c.a.d.f.p.l.isEmpty(str)) {
                        sparseArray.put(c.a.s0.s2.i.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(c.a.s0.s2.i.tag_user_mute_msg, str);
                    }
                    sparseArray.put(c.a.s0.s2.i.tag_user_mute_visible, Boolean.TRUE);
                } else {
                    sparseArray.put(c.a.s0.s2.i.tag_user_mute_visible, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(c.a.s0.s2.i.tag_from)).intValue();
                if (intValue == 0) {
                    this.a.mDialogController.E0(r2, sparseArray);
                } else if (intValue == 1) {
                    this.a.mDialogController.k0(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(AbsVideoPbFragment absVideoPbFragment, int i2) {
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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                c.a.r0.f1.n.f.c(this.a.getPageContext(), this.a, aVar.a, aVar.f12497b, aVar.f12498c);
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.mDialogController == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            c.a.s0.s2.y.g.a aVar = this.a.mDialogController;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                c.a.s0.s2.r.f R0 = this.a.getPbModel().R0();
                if (R0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    R0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.K.c(this.a.getResources().getString(c.a.s0.s2.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.getResources().getString(c.a.s0.s2.l.mute_error_beyond_limit);
                    }
                    this.a.mDialogController.K0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.mDialogController.D0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (c.a.d.f.p.l.isEmpty(errorString2)) {
                        errorString2 = this.a.getResources().getString(c.a.s0.s2.l.mute_fail);
                    }
                    this.a.K.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.s0.v3.j0.e eVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.s0.v3.j0.e) || (eVar = (c.a.s0.v3.j0.e) customResponsedMessage.getData()) == null || (agreeData = eVar.f24896b) == null || agreeData.agreeType != 2 || this.a.h0 == null || this.a.getPbModel() == null || !c.a.r0.b.d.b0() || c.a.s0.s2.u.f.g1.b.k(this.a.getPbModel().h1())) {
                return;
            }
            this.a.h0.m(2);
            c.a.s0.s2.u.f.g1.b.b(this.a.getPbModel().h1());
        }
    }

    /* loaded from: classes12.dex */
    public class e1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48402e;

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
            this.f48402e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48402e.resetCommentView();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.mDialogController == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            c.a.s0.s2.y.g.a aVar = this.a.mDialogController;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.K.c(this.a.getResources().getString(c.a.s0.s2.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (c.a.d.f.p.l.isEmpty(muteMessage)) {
                    muteMessage = this.a.getResources().getString(c.a.s0.s2.l.un_mute_fail);
                }
                this.a.K.b(muteMessage);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f0 implements Observer<d2> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public void onChanged(@Nullable d2 d2Var) {
            c.a.s0.s2.y.k.a aVar;
            BdTypeRecyclerView recyclerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || d2Var == null || d2Var.t1() == null || (aVar = this.a.operableVideoContainer) == null) {
                return;
            }
            if (aVar.f0() != null && this.a.operableVideoContainer.f0().equals(d2Var.t1().video_url)) {
                this.a.operableVideoContainer.setData(d2Var);
                return;
            }
            if (!c.a.d.f.p.l.isEmpty(this.a.operableVideoContainer.f0())) {
                this.a.x0 = true;
                if (this.a.isShowDoubleTab()) {
                    this.a.f48393i.setCurrentItem(0);
                } else {
                    this.a.f48393i.setCurrentItem(0);
                }
                if (!this.a.isShowDoubleTab() && (recyclerView = this.a.getRecyclerView()) != null) {
                    recyclerView.scrollToPosition(0);
                }
            }
            if (this.a.n == null || !this.a.n.k()) {
                this.a.L1();
                this.a.e1(d2Var);
            }
            this.a.z1();
            if (this.a.n != null && this.a.n.l()) {
                this.a.n.s();
            }
            boolean z = !StringHelper.equals(this.a.operableVideoContainer.f0(), d2Var.t1().video_url);
            this.a.operableVideoContainer.setData(d2Var);
            if (this.a.isShowDoubleTab()) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.operableVideoContainer.V0(absVideoPbFragment.f48393i.getCurrentItem() == 0);
            } else {
                this.a.operableVideoContainer.V0(false);
            }
            if (z) {
                this.a.operableVideoContainer.startPlay();
                this.a.operableVideoContainer.y0();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f1 implements c.a.r0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48403e;

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
            this.f48403e = absVideoPbFragment;
        }

        @Override // c.a.r0.x.b
        public void onAction(c.a.r0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f14019c;
                if (obj instanceof c.a.r0.t.c.w) {
                    if (((c.a.r0.t.c.w) obj).getType() == EmotionGroupType.BIG_EMOTION || ((c.a.r0.t.c.w) aVar.f14019c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.f48403e.A0 == null) {
                            this.f48403e.A0 = new PermissionJudgePolicy();
                        }
                        this.f48403e.A0.clearRequestPermissionList();
                        this.f48403e.A0.appendRequestPermission(this.f48403e.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f48403e.A0.startRequestPermission(this.f48403e.getBaseFragmentActivity())) {
                            return;
                        }
                        this.f48403e.C0.h((c.a.r0.t.c.w) aVar.f14019c);
                        this.f48403e.C0.z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements c.a.r0.x.x.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // c.a.r0.x.x.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.s0.s2.u.f.v0 v0Var = this.a.mContentProcessController;
                if (v0Var == null || v0Var.g() == null || !this.a.mContentProcessController.g().d()) {
                    return !this.a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.showToast(absVideoPbFragment.mContentProcessController.g().c());
                if (this.a.E0 != null && this.a.E0.b() != null && this.a.E0.b().x()) {
                    this.a.E0.b().v(this.a.mContentProcessController.h());
                }
                this.a.mContentProcessController.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s2.r.f f48404e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.t.c.g f48405f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48406g;

        public g0(AbsVideoPbFragment absVideoPbFragment, c.a.s0.s2.r.f fVar, c.a.r0.t.c.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, fVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48406g = absVideoPbFragment;
            this.f48404e = fVar;
            this.f48405f = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f48404e == null || this.f48405f == null || this.f48406g.Q0 == null) {
                return;
            }
            this.f48406g.Q0.doLink(this.f48405f);
            this.f48406g.Q0.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes12.dex */
    public class g1 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48407e;

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
            this.f48407e = absVideoPbFragment;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            c.a.s0.s2.u.f.v0 v0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f48407e.mContentProcessController) == null || v0Var.e() == null) {
                return;
            }
            if (!this.f48407e.mContentProcessController.e().e()) {
                this.f48407e.mContentProcessController.a(false);
            }
            this.f48407e.mContentProcessController.e().l(false);
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
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) != null) || this.f48407e.D0 == null || this.f48407e.D0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2) || TextUtils.isEmpty(charSequence.toString().substring(i2, i5))) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f48408e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f48409f;

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
                this.f48409f = hVar;
                this.f48408e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postWriteCallBackData = this.f48408e) == null) {
                    return;
                }
                this.f48409f.a.performFallingRedpacket(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes12.dex */
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

            @Override // c.a.r0.s.t.a.e
            public void onClick(c.a.r0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes12.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f48410e;

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
                this.f48410e = hVar;
            }

            @Override // c.a.r0.s.t.a.e
            public void onClick(c.a.r0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f48410e.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f48410e.a.getActivity(), 0, 26, 2)));
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
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.r0.t.c.m0 m0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (!c.a.d.f.p.l.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.getPbModel() != null && this.a.getPbModel().R0() != null) {
                        statisticItem.param("fid", this.a.getPbModel().R0().m());
                    }
                    statisticItem.param("tid", this.a.getPbModel().h1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.stopVoice();
                this.a.setPostPostWrite(z, postWriteCallBackData);
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
                        this.a.showToast(str);
                        if (this.a.C0.B() || this.a.C0.D()) {
                            this.a.C0.z(false, postWriteCallBackData);
                        }
                        this.a.mContentProcessController.k(postWriteCallBackData);
                        return;
                    } else if (i2 == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.mReplyPrivacyController;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (c.a.d.f.p.l.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.makeText(this.a.getActivity(), this.a.getActivity().getString(c.a.s0.s2.l.current_links_too_much_please_modify_and_publish), null).show();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.makeText(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                            return;
                        }
                    } else if (postWriteCallBackData == null || !postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        if (m0Var != null || i2 == 227001) {
                            return;
                        }
                        this.a.R1(i2, antiData, str);
                        return;
                    } else {
                        c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(this.a.getActivity());
                        if (c.a.d.f.p.l.isEmpty(postWriteCallBackData.getErrorString())) {
                            aVar.setMessage(this.a.getActivity().getString(c.a.s0.s2.l.open_member_and_add_more_links));
                        } else {
                            aVar.setMessage(postWriteCallBackData.getErrorString());
                        }
                        aVar.setNegativeButton(c.a.s0.s2.l.cancel, new b(this));
                        aVar.setPositiveButton(c.a.s0.s2.l.open_now, new c(this));
                        aVar.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    }
                }
                if (PbReplySwitch.getInOn() && this.a.getPbModel() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    this.a.getPbModel().Z(postWriteCallBackData.getPostId());
                    if (this.a.isShowDoubleTab() && this.a.getReplyFragment() != null) {
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.K0 = absVideoPbFragment.getReplyFragment().getFirstItem();
                        AbsVideoPbFragment absVideoPbFragment2 = this.a;
                        absVideoPbFragment2.L0 = absVideoPbFragment2.getReplyFragment().getFirstItemOffset();
                        this.a.getPbModel().h2(this.a.K0, this.a.L0);
                    } else if (this.a.getDetailInfoAndReplyFragment() != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.a;
                        absVideoPbFragment3.K0 = absVideoPbFragment3.getDetailInfoAndReplyFragment().getFirstItem();
                        AbsVideoPbFragment absVideoPbFragment4 = this.a;
                        absVideoPbFragment4.L0 = absVideoPbFragment4.getDetailInfoAndReplyFragment().getFirstItemOffset();
                        this.a.getPbModel().h2(this.a.K0, this.a.L0);
                    }
                }
                if (this.a.f48393i != null) {
                    if (this.a.isShowDoubleTab()) {
                        this.a.f48393i.setCurrentItem(1);
                    } else {
                        this.a.f48393i.setCurrentItem(0);
                    }
                }
                this.a.mDialogController.F();
                this.a.mContentProcessController.c();
                if (this.a.C0 != null) {
                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                    absVideoPbFragment5.setHasDraft(absVideoPbFragment5.C0.C());
                }
                this.a.hideEditTool();
                this.a.showCommonView(true);
                this.a.getPbModel().q1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.S1(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.a.getPbModel().v0()) {
                        c.a.s0.s2.r.f R0 = this.a.getPbModel().R0();
                        if (R0 != null && R0.O() != null && R0.O().J() != null && (userId = R0.O().J().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.getPbModel().y2()) {
                            this.a.setPreLoad();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.getPbModel().y2()) {
                        this.a.setPreLoad();
                    }
                } else if (floor != null) {
                    if (this.a.isShowDoubleTab() && this.a.getReplyFragment() != null) {
                        this.a.getReplyFragment().invalidataData();
                    } else if (this.a.getDetailInfoAndReplyFragment() != null) {
                        this.a.getDetailInfoAndReplyFragment().invalidataData();
                    }
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    c.a.d.f.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                AbsVideoPbFragment absVideoPbFragment6 = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                absVideoPbFragment6.d1(z2);
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.f48393i.setCurrentItem(num.intValue());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48411e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48412f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48413g;

        /* loaded from: classes12.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h1 f48414e;

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
                this.f48414e = h1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.a.s0.s2.u.f.v0 v0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f48414e.f48413g.mContentProcessController) == null || v0Var.g() == null) {
                    return;
                }
                if (!this.f48414e.f48413g.mContentProcessController.g().e()) {
                    this.f48414e.f48413g.mContentProcessController.b(false);
                }
                this.f48414e.f48413g.mContentProcessController.g().l(false);
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
            this.f48413g = absVideoPbFragment;
            this.f48411e = str;
            this.f48412f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = c.a.d.f.p.m.i(this.f48413g.f48389e.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f2 = c.a.d.f.p.m.f(this.f48413g.getPageContext().getPageActivity(), c.a.s0.s2.g.tbds256);
                } else {
                    i2 = i3 / 2;
                    f2 = c.a.d.f.p.m.f(this.f48413g.getPageContext().getPageActivity(), c.a.s0.s2.g.tbds256);
                }
                int i4 = i3 - (i2 + f2);
                AbsVideoPbFragment absVideoPbFragment = this.f48413g;
                boolean z = true;
                int i5 = (absVideoPbFragment.G0[1] + absVideoPbFragment.H0) - i4;
                if (absVideoPbFragment.getRecyclerView() != null) {
                    this.f48413g.getRecyclerView().smoothScrollBy(0, i5);
                }
                if (this.f48413g.E0 != null) {
                    this.f48413g.C0.a().setVisibility(8);
                    this.f48413g.E0.o(this.f48411e, this.f48412f, this.f48413g.getReplyHint(), (this.f48413g.getPbModel() == null || this.f48413g.getPbModel().R0() == null || this.f48413g.getPbModel().R0().O() == null || !this.f48413g.getPbModel().R0().O().T1()) ? false : false);
                    this.f48413g.E0.l(this.f48413g.getFromVideoPageType());
                    c.a.r0.x.x.h b2 = this.f48413g.E0.b();
                    if (b2 != null && this.f48413g.getPbModel() != null && this.f48413g.getPbModel().R0() != null) {
                        b2.G(this.f48413g.getPbModel().R0().d());
                        b2.b0(this.f48413g.getPbModel().R0().O());
                    }
                    if (this.f48413g.mContentProcessController.f() == null && this.f48413g.E0.b().t() != null) {
                        this.f48413g.E0.b().t().f(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.f48413g;
                        absVideoPbFragment2.mContentProcessController.n(absVideoPbFragment2.E0.b().t().h());
                        this.f48413g.E0.b().M(this.f48413g.c1);
                    }
                }
                this.f48413g.hideCommonView();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48415e;

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
            this.f48415e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.f48415e;
                absVideoPbFragment.showToast(absVideoPbFragment.t0);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i0 implements Observer<d2> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public void onChanged(@Nullable d2 d2Var) {
            c.a.s0.s2.y.k.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || (aVar = this.a.operableVideoContainer) == null) {
                return;
            }
            aVar.Y0(d2Var);
        }
    }

    /* loaded from: classes12.dex */
    public class i1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48416b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48417c;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i1 f48418e;

            /* renamed from: com.baidu.tieba.pb.videopb.AbsVideoPbFragment$i1$a$a  reason: collision with other inner class name */
            /* loaded from: classes12.dex */
            public class C1926a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f48419e;

                public C1926a(a aVar) {
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
                    this.f48419e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    c.a.s0.s2.u.f.v0 v0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f48419e.f48418e.f48417c.mContentProcessController) == null || v0Var.g() == null) {
                        return;
                    }
                    if (!this.f48419e.f48418e.f48417c.mContentProcessController.g().e()) {
                        this.f48419e.f48418e.f48417c.mContentProcessController.b(false);
                    }
                    this.f48419e.f48418e.f48417c.mContentProcessController.g().l(false);
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
                this.f48418e = i1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int f2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = c.a.d.f.p.m.i(this.f48418e.f48417c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f2 = c.a.d.f.p.m.f(this.f48418e.f48417c.getPageContext().getPageActivity(), c.a.s0.s2.g.tbds256);
                    } else {
                        i2 = i3 / 2;
                        f2 = c.a.d.f.p.m.f(this.f48418e.f48417c.getPageContext().getPageActivity(), c.a.s0.s2.g.tbds256);
                    }
                    int i4 = i3 - (i2 + f2);
                    AbsVideoPbFragment absVideoPbFragment = this.f48418e.f48417c;
                    boolean z = true;
                    int i5 = (absVideoPbFragment.G0[1] + absVideoPbFragment.H0) - i4;
                    if (absVideoPbFragment.getRecyclerView() != null) {
                        this.f48418e.f48417c.getRecyclerView().smoothScrollBy(0, i5);
                    }
                    if (this.f48418e.f48417c.E0 != null) {
                        this.f48418e.f48417c.C0.a().setVisibility(8);
                        z = (this.f48418e.f48417c.getPbModel() == null || this.f48418e.f48417c.getPbModel().R0() == null || this.f48418e.f48417c.getPbModel().R0().O() == null || !this.f48418e.f48417c.getPbModel().R0().O().T1()) ? false : false;
                        c.a.s0.s2.u.f.t tVar = this.f48418e.f48417c.E0;
                        i1 i1Var = this.f48418e;
                        tVar.o(i1Var.a, i1Var.f48416b, i1Var.f48417c.getReplyHint(), z);
                        this.f48418e.f48417c.E0.l(this.f48418e.f48417c.getFromVideoPageType());
                        c.a.r0.x.x.h b2 = this.f48418e.f48417c.E0.b();
                        if (b2 != null && this.f48418e.f48417c.getPbModel() != null && this.f48418e.f48417c.getPbModel().R0() != null) {
                            b2.G(this.f48418e.f48417c.getPbModel().R0().d());
                            b2.b0(this.f48418e.f48417c.getPbModel().R0().O());
                        }
                        if (this.f48418e.f48417c.mContentProcessController.f() == null && this.f48418e.f48417c.E0.b().t() != null) {
                            this.f48418e.f48417c.E0.b().t().f(new C1926a(this));
                            AbsVideoPbFragment absVideoPbFragment2 = this.f48418e.f48417c;
                            absVideoPbFragment2.mContentProcessController.n(absVideoPbFragment2.E0.b().t().h());
                            this.f48418e.f48417c.E0.b().M(this.f48418e.f48417c.c1);
                        }
                    }
                    this.f48418e.f48417c.hideCommonView();
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
            this.f48417c = absVideoPbFragment;
            this.a = str;
            this.f48416b = str2;
        }

        @Override // c.a.s0.d1.r2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.s0.d1.r2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                c.a.d.f.m.e.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // c.a.s0.d1.r2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.C0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.setHasDraft(absVideoPbFragment.C0.C());
            }
            this.a.showCommonView(false);
        }
    }

    /* loaded from: classes12.dex */
    public class j0 implements Observer<d2> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public void onChanged(@Nullable d2 d2Var) {
            c.a.s0.s2.y.k.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || (aVar = this.a.operableVideoContainer) == null) {
                return;
            }
            aVar.X0(d2Var);
        }
    }

    /* loaded from: classes12.dex */
    public class j1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48420e;

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
            this.f48420e = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f48420e.t == null || this.f48420e.t.q()) {
                    if (this.f48420e.t != null && this.f48420e.getPbModel() != null && this.f48420e.getPbModel().R0() != null && this.f48420e.getPbModel().R0().l() != null) {
                        TiebaStatic.log(new StatisticItem("c13712").param("fid", this.f48420e.getPbModel().R0().l().getId()).param("fname", this.f48420e.getPbModel().R0().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f48420e.getPbModel().R0().Q()).param("obj_param1", this.f48420e.t.o));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13608").param("obj_id", this.f48420e.t.getTitle()).param("obj_name", this.f48420e.t.p()).param("obj_type", 2).param("fid", this.f48420e.getPbModel().R0().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f48420e.getPbModel().R0().Q()));
                }
                this.f48420e.X1();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48421e;

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
            this.f48421e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f48421e.t == null || this.f48421e.t.q()) {
                    if (this.f48421e.t != null) {
                        if (!this.f48421e.t.l) {
                            if (this.f48421e.t.q != null) {
                                YYLiveUtil.jumpToYYLiveRoom(this.f48421e.getPageContext(), this.f48421e.t.q.mSid, this.f48421e.t.q.mSsid, this.f48421e.t.q.mTemplateId, "", YYLiveUtil.SOURCE_PB_LIVE_BANNER);
                            }
                        } else {
                            AbsVideoPbFragment absVideoPbFragment = this.f48421e;
                            absVideoPbFragment.B1(absVideoPbFragment.t.n, this.f48421e.t.m);
                        }
                        if (this.f48421e.getPbModel() == null || this.f48421e.getPbModel().R0() == null || this.f48421e.getPbModel().R0().l() == null) {
                            return;
                        }
                        StatisticItem param = new StatisticItem("c13713").param("fid", this.f48421e.getPbModel().R0().l().getId()).param("fname", this.f48421e.getPbModel().R0().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f48421e.getPbModel().R0().Q()).param("obj_param1", this.f48421e.t.o);
                        if (this.f48421e.getPbModel().R0().O() != null) {
                            d2 O = this.f48421e.getPbModel().R0().O();
                            int calculateLiveType = YYLiveUtil.calculateLiveType(O.o1());
                            AlaInfoData o1 = O.o1();
                            String str = TiebaStatic.YYValues.YY_LIVE;
                            if (o1 == null || !O.o1().isLegalYYLiveData()) {
                                if (this.f48421e.t.q != null) {
                                    TiebaStaticHelper.addYYParam(param, this.f48421e.t.q);
                                    calculateLiveType = YYLiveUtil.calculateLiveType(this.f48421e.t.q);
                                } else {
                                    str = "";
                                }
                            } else {
                                TiebaStaticHelper.addYYParam(param, O.o1().mYyExtData);
                            }
                            param.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                            param.param(TiebaStatic.Params.OBJ_PARAM3, str);
                        }
                        TiebaStatic.log(param);
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13590").param("obj_id", this.f48421e.t.getTitle()).param("obj_name", this.f48421e.t.p()).param("obj_type", 2).param("fid", this.f48421e.getPbModel().R0().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f48421e.getPbModel().R0().Q()));
                String k2 = this.f48421e.t.k();
                if (TextUtils.isEmpty(k2)) {
                    return;
                }
                if (!URLUtil.isHttpUrl(k2) && !URLUtil.isHttpsUrl(k2)) {
                    Uri parse = Uri.parse(k2);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(this.f48421e.getActivity(), parse.toString());
                        return;
                    }
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f48421e.getPageContext(), new String[]{k2});
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.K1();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class k1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48422e;

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
            this.f48422e = absVideoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f48422e.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48423e;

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
            this.f48423e = absVideoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return this.f48423e.m1 != null && this.f48423e.m1.onTouchEvent(motionEvent);
                }
                if (this.f48423e.g1 == 1) {
                    if (!this.f48423e.k1) {
                        this.f48423e.Z1();
                        UtilHelper.showStatusBar(this.f48423e.getPbActivity(), this.f48423e.getPbActivity().getRootView());
                        this.f48423e.k1 = true;
                        c.a.d.f.m.e.a().removeCallbacks(this.f48423e.o1);
                        c.a.d.f.m.e.a().postDelayed(this.f48423e.o1, 3000L);
                    }
                } else if (this.f48423e.g1 == 2 && (this.f48423e.k1 || this.f48423e.A1())) {
                    this.f48423e.Y1();
                    UtilHelper.hideStatusBar(this.f48423e.getPbActivity(), this.f48423e.getPbActivity().getRootView());
                    this.f48423e.k1 = false;
                    c.a.s0.s2.y.k.a aVar = this.f48423e.operableVideoContainer;
                    if (aVar != null) {
                        aVar.W0(false);
                    }
                }
                this.f48423e.g1 = 0;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.setNavigationBarVisibility(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class l1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f48424e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48425f;

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
            this.f48425f = absVideoPbFragment;
            this.f48424e = layoutParams;
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
                this.f48425f.g2(this.f48424e);
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

    /* loaded from: classes12.dex */
    public class m extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48426e;

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
            this.f48426e = absVideoPbFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f48426e.g1 = 0;
                this.f48426e.h1 = 0.0f;
                this.f48426e.i1 = 0.0f;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            c.a.s0.s2.y.k.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f48426e.h1 += f2;
                this.f48426e.i1 += f3;
                if (this.f48426e.g1 == 0 && !this.f48426e.j1 && (aVar = this.f48426e.operableVideoContainer) != null && !aVar.isFullScreen()) {
                    int height = this.f48426e.mNavigationBar.getHeight();
                    if (motionEvent.getY() < 0.0f || Math.abs(this.f48426e.i1) <= Math.abs(this.f48426e.h1) || this.f48426e.i1 > (-height) / 5) {
                        if (Math.abs(this.f48426e.i1) > Math.abs(this.f48426e.h1) && this.f48426e.i1 > 0.0f && f3 > 0.0f) {
                            this.f48426e.g1 = 2;
                        }
                    } else {
                        this.f48426e.g1 = 1;
                    }
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class m0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbViewModel f48427e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48428f;

        public m0(AbsVideoPbFragment absVideoPbFragment, VideoPbViewModel videoPbViewModel) {
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
            this.f48428f = absVideoPbFragment;
            this.f48427e = videoPbViewModel;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (!c.a.r0.g1.b.c.d() && this.f48428f.isShowDoubleTab() && (this.f48427e.isJumpCommentTab() || this.f48428f.getPbModel().g1() == 1)) {
                    this.f48428f.f48393i.setCurrentItem(1);
                } else if (this.f48427e.isJumpCommentTab() || this.f48428f.getPbModel().g1() == 0) {
                    this.f48428f.f48393i.setCurrentItem(0);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (!c.a.r0.g1.b.c.d() && this.f48428f.isShowDoubleTab() && (this.f48427e.isJumpCommentTab() || this.f48428f.getPbModel().g1() == 1)) {
                    this.f48428f.f48393i.setCurrentItem(1);
                } else if (this.f48427e.isJumpCommentTab() || this.f48428f.getPbModel().g1() == 0) {
                    this.f48428f.f48393i.setCurrentItem(0);
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

    /* loaded from: classes12.dex */
    public class m1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f48429e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f48430f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48431g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48432h;

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
            this.f48432h = absVideoPbFragment;
            this.f48429e = layoutParams;
            this.f48430f = layoutParams2;
            this.f48431g = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.D1);
                this.f48429e.height = floatValue;
                this.f48430f.height = (this.f48431g - AbsVideoPbFragment.D1) + floatValue;
                this.f48432h.s.setLayoutParams(this.f48429e);
                this.f48432h.mAppBarLayout.setLayoutParams(this.f48430f);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48433e;

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
            this.f48433e = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f48433e.k1 && !this.f48433e.A1()) {
                this.f48433e.Y1();
                UtilHelper.hideStatusBar(this.f48433e.getPbActivity(), this.f48433e.getPbActivity().getRootView());
                this.f48433e.k1 = false;
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.C0.L(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.E0 != null && this.a.E0.b() != null) {
                    this.a.E0.b().F();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.M1(absVideoPbFragment.N);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class n1 implements a.InterfaceC0818a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // c.a.r0.i.a.InterfaceC0818a
        public void a(boolean z, boolean z2, String str) {
            d2 O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.setPostPro();
                if (z && this.a.getPbModel() != null) {
                    if (this.a.L != null) {
                        this.a.L.h(z2);
                    }
                    this.a.getPbModel().x2(z2);
                    if (this.a.getPbModel().R0() != null && (O = this.a.getPbModel().R0().O()) != null) {
                        if (z2) {
                            O.Q2++;
                        } else {
                            int i2 = O.Q2;
                            if (i2 > 0) {
                                O.Q2 = i2 - 1;
                            }
                        }
                    }
                    if (this.a.getPbModel().D0()) {
                        this.a.E1();
                    } else if (this.a.isShowDoubleTab()) {
                        if (this.a.getDetailInfoFragment() != null) {
                            this.a.getDetailInfoFragment().invalidataData();
                        }
                        if (this.a.getReplyFragment() != null) {
                            this.a.getReplyFragment().invalidataData();
                        }
                    } else if (this.a.getDetailInfoAndReplyFragment() != null) {
                        this.a.getDetailInfoAndReplyFragment().invalidataData();
                    }
                    if (z2) {
                        if (this.a.L != null) {
                            if (this.a.L.f() == null || this.a.getPbModel() == null || this.a.getPbModel().R0() == null || this.a.getPbModel().R0().O() == null || this.a.getPbModel().R0().O().J() == null) {
                                return;
                            }
                            MarkData f2 = this.a.L.f();
                            MetaData J = this.a.getPbModel().R0().O().J();
                            if (f2 != null && J != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), J.getUserId()) && !J.hadConcerned()) {
                                    this.a.mDialogController.A0(J);
                                } else {
                                    this.a.showToast(c.a.s0.s2.l.add_mark_on_pb);
                                }
                            } else {
                                AbsVideoPbFragment absVideoPbFragment = this.a;
                                absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(c.a.s0.s2.l.add_mark));
                            }
                        }
                        this.a.c1();
                        return;
                    }
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    absVideoPbFragment2.showToast(absVideoPbFragment2.getPageContext().getString(c.a.s0.s2.l.remove_mark));
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.showToast(absVideoPbFragment3.getPageContext().getString(c.a.s0.s2.l.update_mark_failed));
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (obj != null && this.a.getPbModel() != null) {
                    switch (this.a.P.getLoadDataMode()) {
                        case 0:
                            this.a.getPbModel().q1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.k1(bVar, (bVar.f49829e != 1002 || bVar.f49830f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.finishForumManageProcess(1, dVar.a, dVar.f49833b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.l1(absVideoPbFragment.P.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.finishForumManageProcess(absVideoPbFragment2.P.getLoadDataMode(), gVar.a, gVar.f49844b, false);
                            this.a.mDialogController.f0(gVar.f49845c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.finishForumManageProcess(absVideoPbFragment3.P.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(AbsVideoPbFragment absVideoPbFragment, int i2) {
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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.a.f48389e, this.a.f48389e.getUniqueId(), (View) customResponsedMessage.getData(), this.a.f48391g);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class o1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48434e;

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
            this.f48434e = absVideoPbFragment;
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
                this.f48434e.s.setVisibility(8);
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

    /* loaded from: classes12.dex */
    public class p implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48435e;

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
            this.f48435e = absVideoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f48435e.mDragActionManager.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                ItemCardHelper.x(this.a.f48389e, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.f48391g, j2);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.a.f48389e, ItemCardHelper.OrderTipStatus.FAIL, this.a.f48391g, 0L);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class p1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f48436e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f48437f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48438g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48439h;

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
            this.f48439h = absVideoPbFragment;
            this.f48436e = layoutParams;
            this.f48437f = layoutParams2;
            this.f48438g = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.D1);
                this.f48436e.height = floatValue;
                this.f48437f.height = this.f48438g + floatValue;
                this.f48439h.s.setLayoutParams(this.f48436e);
                this.f48439h.mAppBarLayout.setLayoutParams(this.f48437f);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class q implements b.InterfaceC1295b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // c.a.s0.q0.b.InterfaceC1295b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.s0.s2.s.b.d();
                } else {
                    c.a.s0.s2.s.b.c();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class q0 implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48440e;

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
            this.f48440e = absVideoPbFragment;
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
                    if (this.f48440e.getDetailInfoAndReplyFragment() != null) {
                        this.f48440e.getDetailInfoAndReplyFragment().receiveFling(false);
                    } else if (this.f48440e.isShowDoubleTab() && this.f48440e.getReplyFragment() != null) {
                        this.f48440e.getReplyFragment().receiveFling(false);
                    }
                    if (this.f48440e.getDetailInfoFragment() != null) {
                        this.f48440e.getDetailInfoFragment().receiveFling(true);
                        AbsVideoPbFragment absVideoPbFragment = this.f48440e;
                        absVideoPbFragment.setShadowVisible(absVideoPbFragment.getDetailInfoFragment().getRecyclerViewState() == 0 ? 8 : 0);
                        this.f48440e.Y.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.f48440e.getActivity()).get(VideoPbViewModel.class);
                    z = (videoPbViewModel.getIsDetailTabTop() == null || videoPbViewModel.getIsDetailTabTop().getValue() == null || !videoPbViewModel.getIsDetailTabTop().getValue().booleanValue()) ? false : false;
                    c.a.s0.s2.y.k.a aVar = this.f48440e.operableVideoContainer;
                    if (aVar != null) {
                        aVar.V0(z);
                    }
                    this.f48440e.resetCommentView();
                    if (this.f48440e.getPbModel() != null && this.f48440e.getPbModel().R0() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.f48440e.getPbModel().h1()).param("fid", this.f48440e.getPbModel().R0().m()));
                    }
                } else {
                    if (this.f48440e.getDetailInfoFragment() != null) {
                        this.f48440e.getDetailInfoFragment().receiveFling(false);
                    }
                    if (this.f48440e.getDetailInfoAndReplyFragment() != null) {
                        this.f48440e.getDetailInfoAndReplyFragment().receiveFling(true);
                        int recyclerViewState = this.f48440e.getDetailInfoAndReplyFragment().getRecyclerViewState();
                        int multiNestedLayoutState = this.f48440e.getDetailInfoAndReplyFragment().getMultiNestedLayoutState();
                        if (recyclerViewState != 0) {
                            this.f48440e.setShadowVisible(8);
                            this.f48440e.getDetailInfoAndReplyFragment().setShadowVisible(0);
                        } else if (multiNestedLayoutState != 0) {
                            this.f48440e.getDetailInfoAndReplyFragment().setShadowVisible(8);
                            this.f48440e.setShadowVisible(0);
                        } else {
                            this.f48440e.getDetailInfoAndReplyFragment().setShadowVisible(8);
                            this.f48440e.setShadowVisible(8);
                        }
                    } else if (this.f48440e.getReplyFragment() != null) {
                        this.f48440e.getReplyFragment().receiveFling(true);
                        int recyclerViewState2 = this.f48440e.getReplyFragment().getRecyclerViewState();
                        int multiNestedLayoutState2 = this.f48440e.getReplyFragment().getMultiNestedLayoutState();
                        if (recyclerViewState2 != 0) {
                            this.f48440e.setShadowVisible(8);
                            this.f48440e.getReplyFragment().setShadowVisible(0);
                        } else if (multiNestedLayoutState2 != 0) {
                            this.f48440e.getReplyFragment().setShadowVisible(8);
                            this.f48440e.setShadowVisible(0);
                        } else {
                            this.f48440e.getReplyFragment().setShadowVisible(8);
                            this.f48440e.setShadowVisible(8);
                        }
                        this.f48440e.Y.setVisibility(0);
                    }
                    c.a.s0.s2.y.k.a aVar2 = this.f48440e.operableVideoContainer;
                    if (aVar2 != null) {
                        aVar2.V0(false);
                    }
                    this.f48440e.mAppBarLayout.setExpanded(false, true);
                    if (this.f48440e.getPbModel() != null && this.f48440e.getPbModel().R0() != null) {
                        TiebaStatic.log(new StatisticItem("c13593").param("tid", this.f48440e.getPbModel().h1()).param("fid", this.f48440e.getPbModel().R0().m()));
                    }
                }
                this.f48440e.f48394j.setItemPrimary(i2);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class q1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48441e;

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
            this.f48441e = absVideoPbFragment;
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
                this.f48441e.e2();
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

    /* loaded from: classes12.dex */
    public class r implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48442e;

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
            this.f48442e = absVideoPbFragment;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes12.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.t.c.g f48443e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48444f;

        public r0(AbsVideoPbFragment absVideoPbFragment, c.a.r0.t.c.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48444f = absVideoPbFragment;
            this.f48443e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48444f.Q0.inPbLastCloseTime();
                this.f48444f.hideRightFloatLayerView();
                this.f48444f.Q0.reportClickCloseAd(this.f48443e);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class r1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48445e;

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
            this.f48445e = absVideoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f48445e.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class s implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f48446e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ s f48447f;

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
                this.f48447f = sVar;
                this.f48446e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postWriteCallBackData = this.f48446e) == null) {
                    return;
                }
                this.f48447f.a.performFallingRedpacket(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes12.dex */
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

            @Override // c.a.r0.s.t.a.e
            public void onClick(c.a.r0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes12.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ s f48448e;

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
                this.f48448e = sVar;
            }

            @Override // c.a.r0.s.t.a.e
            public void onClick(c.a.r0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f48448e.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f48448e.a.getActivity(), 0, 26, 2)));
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
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.r0.t.c.m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (!c.a.d.f.p.l.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.getPbModel() != null && this.a.getPbModel().R0() != null) {
                        statisticItem.param("fid", this.a.getPbModel().R0().m());
                    }
                    if (this.a.getPbModel() != null) {
                        statisticItem.param("tid", this.a.getPbModel().h1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    c.a.s0.s2.u.f.v0 v0Var = this.a.mContentProcessController;
                    if (v0Var != null) {
                        v0Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        c.a.r0.t.h.b.a(this.a.getPageContext(), postWriteCallBackData);
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getmAdverSegmentData() == null) {
                        return;
                    }
                    c.a.d.f.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.mReplyPrivacyController;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (c.a.d.f.p.l.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.a.getActivity(), this.a.getActivity().getString(c.a.s0.s2.l.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(this.a.getActivity());
                    if (c.a.d.f.p.l.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.a.getActivity().getString(c.a.s0.s2.l.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(c.a.s0.s2.l.cancel, new b(this));
                    aVar.setPositiveButton(c.a.s0.s2.l.open_now, new c(this));
                    aVar.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment = this.a;
                if (absVideoPbFragment.mContentProcessController == null) {
                    return;
                }
                if (absVideoPbFragment.E0 != null && this.a.E0.b() != null && this.a.E0.b().x()) {
                    this.a.E0.b().v(postWriteCallBackData);
                }
                this.a.mContentProcessController.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class s0 implements FallingView.l {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.l
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.H.setTag(Boolean.TRUE);
                if (this.a.Q0 != null && this.a.Q0.getTag() == this.a.H) {
                    this.a.Q0.setTag(null);
                    this.a.Q0.setAutoCompleteShown(true);
                    this.a.Q0.completeShow();
                }
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.l
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.H.setTag(Boolean.FALSE);
                if (this.a.Q0 == null) {
                    return;
                }
                this.a.Q0.setAutoCompleteShown(false);
                if (this.a.Q0.getVisibility() == 0) {
                    this.a.Q0.setTag(this.a.H);
                    this.a.Q0.completeHide();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    if (c.a.r0.s.l.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(c.a.s0.s2.h.icon_click);
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
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(c.a.s0.s2.f.common_color_10220);
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
                boolean g2 = c.a.r0.s.l.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(c.a.s0.s2.f.common_color_10220));
                if (g2) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(c.a.s0.s2.h.icon_click);
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
                    foreDrawableImageView.setDefaultBgResource(c.a.s0.s2.f.common_color_10220);
                    foreDrawableImageView.reset();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class t implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f48449e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f48450f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s.t.a f48451g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48452h;

        public t(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, c.a.r0.s.t.a aVar) {
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
            this.f48452h = absVideoPbFragment;
            this.f48449e = markData;
            this.f48450f = markData2;
            this.f48451g = aVar;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f48452h.L != null) {
                    if (this.f48452h.L.e()) {
                        this.f48452h.L.d();
                        this.f48452h.L.h(false);
                    }
                    this.f48452h.L.i(this.f48449e);
                    this.f48452h.L.h(true);
                    this.f48452h.L.a();
                }
                this.f48450f.setPostId(this.f48449e.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f48450f);
                this.f48452h.f48389e.setResult(-1, intent);
                this.f48451g.dismiss();
                this.f48452h.b2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class t0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48453e;

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
            this.f48453e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f48453e.t == null || this.f48453e.t.q()) {
                    if (this.f48453e.t != null) {
                        TiebaStatic.log(new StatisticItem("c13608").param("tid", this.f48453e.getPbModel().R0().Q()));
                        this.f48453e.t.p = true;
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13591"));
                }
                this.f48453e.W1();
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (c.a.r0.s.l.c().g()) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(c.a.s0.s2.h.icon_click);
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
                gifView.setDefaultBgResource(c.a.s0.s2.f.common_color_10220);
                gifView.onDestroy();
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
                boolean g2 = c.a.r0.s.l.c().g();
                gifView.setDefaultBg(SkinManager.getDrawable(c.a.s0.s2.f.common_color_10220));
                if (g2) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(c.a.s0.s2.h.icon_click);
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
                gifView.setDefaultBgResource(c.a.s0.s2.f.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class u implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f48454e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s.t.a f48455f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48456g;

        public u(AbsVideoPbFragment absVideoPbFragment, MarkData markData, c.a.r0.s.t.a aVar) {
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
            this.f48456g = absVideoPbFragment;
            this.f48454e = markData;
            this.f48455f = aVar;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.f48454e);
                this.f48456g.f48389e.setResult(-1, intent);
                this.f48455f.dismiss();
                this.f48456g.b2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48457e;

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
            this.f48457e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new c.a.r0.s.r.t0(this.f48457e.getActivity(), "pb_huitie"))) {
                this.f48457e.expandVideo(false);
                this.f48457e.processProfessionPermission();
                if (this.f48457e.getPbModel() == null || this.f48457e.getPbModel().R0() == null || this.f48457e.getPbModel().R0().O() == null || this.f48457e.getPbModel().R0().O().J() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f48457e.getPbModel().i1()).param("fid", this.f48457e.getPbModel().R0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f48457e.getPbModel().h1()).param("fid", this.f48457e.getPbModel().R0().m()).param("obj_locate", 1).param("uid", this.f48457e.getPbModel().R0().O().J().getUserId()));
                if (this.f48457e.isCommentFloatPage()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", this.f48457e.getPbModel().getForumId());
                    statisticItem.param("tid", this.f48457e.getPbModel().h1());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", this.f48457e.o1());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 11);
                    statisticItem.param("obj_locate", this.f48457e.getFromVideoPageType());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                ((PlayVoiceBntNew) view).resetLayoutParams();
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
                ((PlayVoiceBntNew) view).reset();
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
                playVoiceBntNew.setPlayTimeTextView(c.a.s0.s2.g.fontsize28);
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

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.X = true;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class v0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.a.Y.getLayoutParams();
            layoutParams.height = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds144);
            this.a.Y.setLayoutParams(layoutParams);
            if (this.a.isShowDoubleTab() && this.a.f48392h != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.f48392h.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = AbsVideoPbFragment.E1;
                } else {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, AbsVideoPbFragment.E1);
                }
                this.a.f48392h.setLayoutParams(layoutParams2);
                this.a.f48393i.setScrollable(true);
            }
            this.a.resetCommentView();
            if (this.a.getDetailInfoFragment() != null) {
                this.a.getDetailInfoFragment().invalidataData();
            }
            if (this.a.getDetailInfoAndReplyFragment() != null) {
                this.a.getDetailInfoAndReplyFragment().invalidataData();
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                linearLayout.setId(c.a.s0.s2.i.pb_text_voice_layout);
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

    /* loaded from: classes12.dex */
    public class w implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48458e;

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
            this.f48458e = absVideoPbFragment;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class w0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48459e;

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
            this.f48459e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48459e.hideKeyBroad();
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes12.dex */
    public class x implements c.a.r0.x.x.c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // c.a.r0.x.x.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class x0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48460e;

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
            this.f48460e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48460e.resetCommentView();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class x1 implements Comparator<c.a.r0.u.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48461e;

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
            this.f48461e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c.a.r0.u.a aVar, c.a.r0.u.a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) ? aVar.compareTo(aVar2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes12.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48462e;

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
            this.f48462e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            SparseArray<Object> sparseArray;
            StatisticItem statisticItem;
            int i2;
            String str4;
            int i3;
            int i4;
            String d2;
            boolean A2;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.f48462e.isAdded()) {
                Object tag = view.getTag(c.a.s0.s2.i.tag_first);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view.setTag(c.a.s0.s2.i.tag_first, null);
                } else if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.f48462e.getPbModel().h1());
                    statisticItem2.param("fid", this.f48462e.getPbModel().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    if (this.f48462e.isCommentFloatPage()) {
                        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem3.param("fid", this.f48462e.getPbModel().getForumId());
                        statisticItem3.param("tid", this.f48462e.getPbModel().h1());
                        statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem3.param("post_id", this.f48462e.o1());
                        statisticItem3.param("obj_source", 1);
                        statisticItem3.param("obj_type", 3);
                        statisticItem3.param("obj_locate", this.f48462e.getFromVideoPageType());
                        TiebaStatic.log(statisticItem3);
                    }
                    if (this.f48462e.X) {
                        this.f48462e.X = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(c.a.s0.s2.i.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (this.f48462e.getPbModel() == null || this.f48462e.getPbModel().R0() == null || this.f48462e.F0 == null || postData.t() == null || postData.A() == 1 || !this.f48462e.checkUpIsLogin()) {
                                return;
                            }
                            if (this.f48462e.E0 != null) {
                                this.f48462e.E0.c();
                            }
                            c.a.s0.s2.r.t tVar = new c.a.s0.s2.r.t();
                            tVar.A(this.f48462e.getPbModel().R0().l());
                            tVar.E(this.f48462e.getPbModel().R0().O());
                            tVar.C(postData);
                            this.f48462e.F0.S(tVar);
                            this.f48462e.F0.setPostId(postData.G());
                            this.f48462e.D1(view, postData.t().getUserId(), "", postData);
                            TiebaStatic.log("c11743");
                            c.a.s0.s2.w.a.b(this.f48462e.getPbModel().R0(), postData, postData.f0, 8, 1);
                            if (this.f48462e.C0 != null) {
                                AbsVideoPbFragment absVideoPbFragment = this.f48462e;
                                absVideoPbFragment.setHasDraft(absVideoPbFragment.C0.C());
                            }
                        }
                    }
                } else {
                    if (view.getId() != c.a.s0.s2.i.pb_video_more || this.f48462e.getPageContext().getPageActivity() == null || this.f48462e.getPbModel() == null || this.f48462e.f48389e == null || this.f48462e.f48389e.getIntent() == null) {
                        str = TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK;
                        str2 = "post_id";
                        str3 = "obj_locate";
                    } else {
                        str2 = "post_id";
                        if (this.f48462e.f48389e.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.f48462e.f48389e.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            Activity pageActivity = this.f48462e.getPageContext().getPageActivity();
                            String h1 = this.f48462e.getPbModel().h1();
                            str = TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK;
                            str3 = "obj_locate";
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(pageActivity, h1, false, true);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.f48462e.f48389e.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.f48462e.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            str = TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK;
                            str3 = "obj_locate";
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.f48462e.getPageContext().getPageActivity(), this.f48462e.getPbModel().h1(), true, false);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.f48462e.f48389e.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.f48462e.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.f48462e.getPbModel().getForumId());
                        statisticItem4.param("fname", this.f48462e.getPbModel().r0());
                        statisticItem4.param("tid", this.f48462e.getPbModel().h1());
                        TiebaStatic.log(statisticItem4);
                    }
                    if ((this.f48462e.isShowDoubleTab() && this.f48462e.getReplyFragment() != null && this.f48462e.getReplyFragment().getNextView() != null && view == this.f48462e.getReplyFragment().getNextView()) || ((this.f48462e.getDetailInfoAndReplyFragment() != null && this.f48462e.getDetailInfoAndReplyFragment().getNextView() != null && view == this.f48462e.getDetailInfoAndReplyFragment().getNextView()) || view.getId() == c.a.s0.s2.i.pb_more)) {
                        if (!this.f48462e.I && this.f48462e.getPbModel().F1(true)) {
                            this.f48462e.I = true;
                            if (this.f48462e.isShowDoubleTab()) {
                                if (this.f48462e.getReplyFragment() != null) {
                                    this.f48462e.getReplyFragment().setPreLoadNext();
                                    return;
                                }
                                return;
                            } else if (this.f48462e.getDetailInfoAndReplyFragment() != null) {
                                this.f48462e.getDetailInfoAndReplyFragment().setPreLoadNext();
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    c.a.s0.s2.y.g.a aVar = this.f48462e.mDialogController;
                    if (aVar != null && aVar.Q() != null && view == this.f48462e.mDialogController.Q().e()) {
                        this.f48462e.mDialogController.I();
                        return;
                    }
                    c.a.s0.s2.y.g.a aVar2 = this.f48462e.mDialogController;
                    if ((aVar2 == null || ((aVar2.Q() == null || view != this.f48462e.mDialogController.Q().i()) && view.getId() != c.a.s0.s2.i.owner_reply && view.getId() != c.a.s0.s2.i.all_reply)) && view.getId() != c.a.s0.s2.i.floor_owner_reply && view.getId() != c.a.s0.s2.i.reply_title) {
                        AbsVideoPbFragment absVideoPbFragment2 = this.f48462e;
                        if (view == absVideoPbFragment2.mBackButton) {
                            if (absVideoPbFragment2.getPbModel() == null || this.f48462e.getPbModel().R0() == null) {
                                return;
                            }
                            if (!c.a.d.f.p.l.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                StatisticItem statisticItem5 = new StatisticItem("c13266");
                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem5.param("fid", this.f48462e.getPbModel().R0().m());
                                statisticItem5.param("tid", this.f48462e.getPbModel().h1());
                                statisticItem5.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(statisticItem5);
                                TbadkCoreApplication.getInst().setTaskId("");
                            }
                            c.a.d.f.p.m.w(this.f48462e.f48389e, this.f48462e.mBackButton);
                            this.f48462e.f48389e.finish();
                        } else if (view == absVideoPbFragment2.mMore && absVideoPbFragment2.mDialogController != null) {
                            if (c.a.r0.d1.q.a()) {
                                return;
                            }
                            if (this.f48462e.getPbModel() != null && this.f48462e.getPbModel().R0() != null) {
                                ArrayList<PostData> F = this.f48462e.getPbModel().R0().F();
                                if ((F == null || F.size() <= 0) && this.f48462e.getPbModel().f1()) {
                                    c.a.d.f.p.m.M(this.f48462e.getPageContext().getPageActivity(), this.f48462e.getPageContext().getString(c.a.s0.s2.l.pb_no_data_tips));
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.f48462e.getPbModel().h1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f48462e.getPbModel().getForumId()));
                                this.f48462e.mDialogController.m0();
                                return;
                            }
                            c.a.d.f.p.m.M(this.f48462e.getPageContext().getPageActivity(), this.f48462e.getPageContext().getString(c.a.s0.s2.l.pb_no_data_tips));
                        } else if (this.f48462e.mDialogController.Q() != null && view == this.f48462e.mDialogController.Q().k()) {
                            if (this.f48462e.getPbModel() == null) {
                                return;
                            }
                            this.f48462e.mDialogController.F();
                            if (c.a.d.f.p.k.z()) {
                                this.f48462e.stopVoice();
                                this.f48462e.setPreLoad();
                                this.f48462e.getPbModel().v2(1);
                                return;
                            }
                            this.f48462e.showToast(c.a.s0.s2.l.network_not_available);
                        } else {
                            c.a.s0.s2.y.g.a aVar3 = this.f48462e.mDialogController;
                            if (aVar3 != null && aVar3.Q() != null && view == this.f48462e.mDialogController.Q().i()) {
                                this.f48462e.mDialogController.I();
                                return;
                            }
                            c.a.s0.s2.y.g.a aVar4 = this.f48462e.mDialogController;
                            if (aVar4 != null && ((aVar4.Q() != null && view == this.f48462e.mDialogController.Q().q()) || view.getId() == c.a.s0.s2.i.pb_sort_type || view.getId() == c.a.s0.s2.i.pb_sort)) {
                                this.f48462e.mDialogController.F();
                                if (c.a.d.f.p.k.z()) {
                                    if (!this.f48462e.I) {
                                        this.f48462e.stopVoice();
                                        this.f48462e.setPreLoad();
                                        this.f48462e.mDialogController.J0(view);
                                        return;
                                    }
                                    view.setTag(Integer.valueOf(this.f48462e.getPbModel().d1()));
                                    return;
                                }
                                this.f48462e.showToast(c.a.s0.s2.l.network_not_available);
                                return;
                            }
                            c.a.s0.s2.y.g.a aVar5 = this.f48462e.mDialogController;
                            if (aVar5 != null && aVar5.Q() != null && view == this.f48462e.mDialogController.Q().p()) {
                                if (this.f48462e.getPbModel() == null || this.f48462e.getPbModel().R0() == null || this.f48462e.getPbModel().R0().O() == null) {
                                    return;
                                }
                                this.f48462e.mDialogController.I();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment3 = this.f48462e;
                                absVideoPbFragment3.mDialogController.U(absVideoPbFragment3.getPbModel().R0().O().X());
                            } else if (view.getId() == c.a.s0.s2.i.pb_floor_feedback) {
                                try {
                                    sparseArray = (SparseArray) view.getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray = null;
                                }
                                c.a.s0.s2.y.g.a aVar6 = this.f48462e.mDialogController;
                                if (aVar6 != null) {
                                    aVar6.w0(sparseArray);
                                }
                            } else {
                                c.a.s0.s2.y.g.a aVar7 = this.f48462e.mDialogController;
                                if (aVar7 != null && aVar7.Q() != null && view == this.f48462e.mDialogController.Q().n()) {
                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                    if (skinType == 1) {
                                        this.f48462e.onChangeSkinType(skinType);
                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                    } else if (skinType == 0 || skinType == 4) {
                                        UtilHelper.showSkinChangeAnimation(this.f48462e.getActivity());
                                        this.f48462e.onChangeSkinType(skinType);
                                        UtilHelper.setNavigationBarBackground(this.f48462e.getActivity(), this.f48462e.getResources().getColor(c.a.s0.s2.f.CAM_X0201_1));
                                        TbadkCoreApplication.getInst().setSkinType(1);
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                    }
                                    this.f48462e.mDialogController.J();
                                    return;
                                }
                                c.a.s0.s2.y.g.a aVar8 = this.f48462e.mDialogController;
                                if (aVar8 != null && aVar8.Q() != null && view == this.f48462e.mDialogController.Q().o()) {
                                    this.f48462e.mDialogController.J();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.f48462e;
                                    absVideoPbFragment4.mDialogController.G0(absVideoPbFragment4.w1);
                                    return;
                                }
                                c.a.s0.s2.y.g.a aVar9 = this.f48462e.mDialogController;
                                if (aVar9 != null && aVar9.Q() != null && view == this.f48462e.mDialogController.Q().h()) {
                                    c.a.r0.t.c.k0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (d2 = tiebaPlusConfigData.d(this.f48462e.getPbModel().h1())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.f48462e.getPageContext(), new String[]{d2});
                                    this.f48462e.mDialogController.I();
                                    c.a.r0.t.c.k0.a(3);
                                    return;
                                }
                                c.a.s0.s2.y.g.a aVar10 = this.f48462e.mDialogController;
                                if (aVar10 != null && (view == aVar10.M() || (this.f48462e.mDialogController.Q() != null && (view == this.f48462e.mDialogController.Q().l() || view == this.f48462e.mDialogController.Q().m())))) {
                                    if (!c.a.d.f.p.k.z()) {
                                        this.f48462e.showToast(c.a.s0.s2.l.network_not_available);
                                        return;
                                    } else if ((this.f48462e.getPbModel() == null && this.f48462e.getPbModel().R0() == null) || this.f48462e.P.P()) {
                                        return;
                                    } else {
                                        this.f48462e.mDialogController.F();
                                        if (this.f48462e.mDialogController.Q() != null && view == this.f48462e.mDialogController.Q().m()) {
                                            i4 = this.f48462e.getPbModel().R0().O().s0() == 1 ? 5 : 4;
                                        } else if (this.f48462e.mDialogController.Q() != null && view == this.f48462e.mDialogController.Q().l()) {
                                            i4 = this.f48462e.getPbModel().R0().O().r0() == 1 ? 3 : 6;
                                        } else {
                                            i4 = view == this.f48462e.mDialogController.M() ? 2 : 0;
                                        }
                                        ForumData l = this.f48462e.getPbModel().R0().l();
                                        String name = l.getName();
                                        String id = l.getId();
                                        String g0 = this.f48462e.getPbModel().R0().O().g0();
                                        this.f48462e.showProgressBar();
                                        this.f48462e.P.T(id, name, g0, i4, this.f48462e.mDialogController.N());
                                        return;
                                    }
                                }
                                c.a.s0.s2.y.g.a aVar11 = this.f48462e.mDialogController;
                                if (aVar11 != null && aVar11.Q() != null && view == this.f48462e.mDialogController.Q().g()) {
                                    if (this.f48462e.getPbModel() == null) {
                                        return;
                                    }
                                    if (!c.a.d.f.p.k.z()) {
                                        this.f48462e.showToast(c.a.s0.s2.l.network_not_available);
                                        return;
                                    }
                                    this.f48462e.mDialogController.F();
                                    AbsVideoPbFragment absVideoPbFragment5 = this.f48462e;
                                    SparseArray<Object> managerOrDeleteTag = absVideoPbFragment5.getManagerOrDeleteTag(absVideoPbFragment5.getPbModel().R0(), this.f48462e.getPbModel().f1(), 1);
                                    if (managerOrDeleteTag == null) {
                                        return;
                                    }
                                    this.f48462e.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f48462e.getPageContext().getPageActivity(), this.f48462e.getPbModel().R0().l().getId(), this.f48462e.getPbModel().R0().l().getName(), this.f48462e.getPbModel().R0().O().g0(), String.valueOf(this.f48462e.getPbModel().R0().U().getUserId()), (String) managerOrDeleteTag.get(c.a.s0.s2.i.tag_forbid_user_name), (String) managerOrDeleteTag.get(c.a.s0.s2.i.tag_forbid_user_name_show), (String) managerOrDeleteTag.get(c.a.s0.s2.i.tag_forbid_user_post_id), (String) managerOrDeleteTag.get(c.a.s0.s2.i.tag_forbid_user_portrait))));
                                    return;
                                }
                                c.a.s0.s2.y.g.a aVar12 = this.f48462e.mDialogController;
                                if (aVar12 != null && aVar12.Q() != null && view == this.f48462e.mDialogController.Q().c()) {
                                    if (!c.a.d.f.p.k.z()) {
                                        this.f48462e.showToast(c.a.s0.s2.l.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.f48462e;
                                    SparseArray<Object> managerOrDeleteTag2 = absVideoPbFragment6.getManagerOrDeleteTag(absVideoPbFragment6.getPbModel().R0(), this.f48462e.getPbModel().f1(), 1);
                                    if (managerOrDeleteTag2 != null) {
                                        this.f48462e.mDialogController.j0(((Integer) managerOrDeleteTag2.get(c.a.s0.s2.i.tag_del_post_type)).intValue(), (String) managerOrDeleteTag2.get(c.a.s0.s2.i.tag_del_post_id), ((Integer) managerOrDeleteTag2.get(c.a.s0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) managerOrDeleteTag2.get(c.a.s0.s2.i.tag_del_post_is_self)).booleanValue());
                                    }
                                    this.f48462e.mDialogController.I();
                                    if (this.f48462e.getPbModel() == null || this.f48462e.getPbModel().R0() == null || this.f48462e.getPbModel().R0().O() == null) {
                                        return;
                                    }
                                    d2 O = this.f48462e.getPbModel().R0().O();
                                    StatisticItem statisticItem6 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem6.param("tid", O.g0());
                                    statisticItem6.param("fid", O.U());
                                    statisticItem6.param("fname", O.a0());
                                    TiebaStatic.log(statisticItem6);
                                    StatisticItem statisticItem7 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                    statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem7.param("tid", O.g0());
                                    statisticItem7.param("fid", O.U());
                                    statisticItem7.param("fname", O.a0());
                                    statisticItem7.param("obj_source", 3);
                                    TiebaStatic.log(statisticItem7);
                                    return;
                                }
                                c.a.s0.s2.y.g.a aVar13 = this.f48462e.mDialogController;
                                if (aVar13 != null && aVar13.Q() != null && view == this.f48462e.mDialogController.Q().f()) {
                                    if (this.f48462e.getPbModel() == null) {
                                        return;
                                    }
                                    if (!c.a.d.f.p.k.z()) {
                                        this.f48462e.showToast(c.a.s0.s2.l.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment7 = this.f48462e;
                                    SparseArray<Object> managerOrDeleteTag3 = absVideoPbFragment7.getManagerOrDeleteTag(absVideoPbFragment7.getPbModel().R0(), this.f48462e.getPbModel().f1(), 1);
                                    if (managerOrDeleteTag3 != null) {
                                        if (StringUtils.isNull((String) managerOrDeleteTag3.get(c.a.s0.s2.i.tag_del_multi_forum))) {
                                            this.f48462e.mDialogController.g0(((Integer) managerOrDeleteTag3.get(c.a.s0.s2.i.tag_del_post_type)).intValue(), (String) managerOrDeleteTag3.get(c.a.s0.s2.i.tag_del_post_id), ((Integer) managerOrDeleteTag3.get(c.a.s0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) managerOrDeleteTag3.get(c.a.s0.s2.i.tag_del_post_is_self)).booleanValue());
                                        } else {
                                            this.f48462e.mDialogController.h0(((Integer) managerOrDeleteTag3.get(c.a.s0.s2.i.tag_del_post_type)).intValue(), (String) managerOrDeleteTag3.get(c.a.s0.s2.i.tag_del_post_id), ((Integer) managerOrDeleteTag3.get(c.a.s0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) managerOrDeleteTag3.get(c.a.s0.s2.i.tag_del_post_is_self)).booleanValue(), (String) managerOrDeleteTag3.get(c.a.s0.s2.i.tag_del_multi_forum));
                                        }
                                    }
                                    this.f48462e.mDialogController.I();
                                } else if (view.getId() != c.a.s0.s2.i.sub_pb_more && view.getId() != c.a.s0.s2.i.sub_pb_item && view.getId() != c.a.s0.s2.i.pb_floor_reply_more && view.getId() != c.a.s0.s2.i.new_sub_pb_list_richText && view.getId() != c.a.s0.s2.i.pb_post_reply_count) {
                                    if (view.getId() != c.a.s0.s2.i.pb_post_reply && view.getId() != c.a.s0.s2.i.post_info_commont_img && view.getId() != c.a.s0.s2.i.pb_floor_comment_container) {
                                        if (view.getId() != c.a.s0.s2.i.pb_editor_tool_collection && view.getId() != c.a.s0.s2.i.collect_num_container) {
                                            if (view.getId() == c.a.s0.s2.i.pb_editor_tool_share) {
                                                this.f48462e.handleShare(true);
                                                return;
                                            } else if (view.getId() != c.a.s0.s2.i.pb_editor_tool_comment_icon && view.getId() != c.a.s0.s2.i.thread_info_commont_container) {
                                                if (view.getId() == c.a.s0.s2.i.tv_pb_reply_more) {
                                                    if (this.f48462e.K0 >= 0) {
                                                        if (this.f48462e.getPbModel() != null) {
                                                            this.f48462e.getPbModel().d2();
                                                        }
                                                        if (this.f48462e.isShowDoubleTab() && this.f48462e.getPbModel() != null && this.f48462e.getReplyFragment() != null && this.f48462e.getReplyFragment().getAdapterManager() != null) {
                                                            this.f48462e.getReplyFragment().getAdapterManager().f(this.f48462e.getPbModel().R0());
                                                        } else if (this.f48462e.getDetailInfoAndReplyFragment() != null && this.f48462e.getDetailInfoAndReplyFragment().getAdapterManager() != null) {
                                                            this.f48462e.getDetailInfoAndReplyFragment().getAdapterManager().q(this.f48462e.getPbModel().R0());
                                                        }
                                                        this.f48462e.K0 = 0;
                                                        this.f48462e.L0 = Integer.MIN_VALUE;
                                                        if (this.f48462e.isShowDoubleTab() && this.f48462e.getPbModel() != null && this.f48462e.getReplyFragment() != null) {
                                                            this.f48462e.getReplyFragment().scrollListView(this.f48462e.getPbModel().K0(), this.f48462e.getPbModel().J0());
                                                            this.f48462e.getPbModel().h2(0, 0);
                                                            return;
                                                        } else if (this.f48462e.getPbModel() == null || this.f48462e.getDetailInfoAndReplyFragment() == null) {
                                                            return;
                                                        } else {
                                                            this.f48462e.getDetailInfoAndReplyFragment().scrollListView(this.f48462e.getPbModel().K0(), this.f48462e.getPbModel().J0());
                                                            this.f48462e.getPbModel().h2(0, 0);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                    if (this.f48462e.getPbModel() == null) {
                                                        return;
                                                    }
                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                    statisticItem8.param("tid", this.f48462e.getPbModel().h1());
                                                    statisticItem8.param("fid", this.f48462e.getPbModel().getForumId());
                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem8.param(str3, 2);
                                                    TiebaStatic.log(statisticItem8);
                                                    return;
                                                } else {
                                                    String str5 = str3;
                                                    if (view.getId() == c.a.s0.s2.i.pb_item_tail_content) {
                                                        if (ViewHelper.checkUpIsLogin(this.f48462e.getPageContext().getPageActivity())) {
                                                            String string = TbadkCoreApplication.getInst().getString(c.a.s0.s2.l.tail_web_view_title);
                                                            String p = c.a.r0.s.g0.b.j().p("tail_link", "");
                                                            if (!StringUtils.isNull(p)) {
                                                                TiebaStatic.log("c10056");
                                                                c.a.r0.m.a.q(view.getContext(), string, p, true, true, true);
                                                            }
                                                            this.f48462e.resetCommentView();
                                                            return;
                                                        }
                                                        return;
                                                    } else if (view.getId() == c.a.s0.s2.i.keyboard_background_shadow) {
                                                        this.f48462e.resetCommentView();
                                                        return;
                                                    } else if (this.f48462e.mDialogController.Q() != null && view == this.f48462e.mDialogController.Q().d()) {
                                                        this.f48462e.mDialogController.F();
                                                        if (this.f48462e.getPbModel() != null) {
                                                            this.f48462e.q.f(this.f48462e.getPbModel().h1());
                                                        }
                                                        if (this.f48462e.getPbModel() == null || !this.f48462e.getPbModel().isPrivacy()) {
                                                            this.f48462e.q.b();
                                                            int i6 = (TbSingleton.getInstance().mCanCallFans || this.f48462e.getPbModel() == null || this.f48462e.getPbModel().R0() == null || this.f48462e.getPbModel().R0().Q() == null || !this.f48462e.getPbModel().R0().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                            if (this.f48462e.getPbModel() == null || this.f48462e.getPbModel().R0() == null) {
                                                                return;
                                                            }
                                                            this.f48462e.q.d(3, i6, this.f48462e.getPbModel().R0().Q());
                                                            return;
                                                        }
                                                        this.f48462e.showToast(c.a.s0.s2.l.privacy_thread_can_not_use_call_fans);
                                                        if (this.f48462e.getPbModel().R0() != null) {
                                                            this.f48462e.q.d(3, 3, this.f48462e.getPbModel().R0().Q());
                                                            return;
                                                        }
                                                        return;
                                                    } else if (view.getId() == c.a.s0.s2.i.pb_floor_right_top_feedback || view.getId() == c.a.s0.s2.i.pb_post_op_more) {
                                                        StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                        statisticItem9.param("tid", this.f48462e.getPbModel().h1());
                                                        statisticItem9.param("fid", this.f48462e.getPbModel().getForumId());
                                                        statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem9.param(str5, 7);
                                                        TiebaStatic.log(statisticItem9);
                                                        if (this.f48462e.isCommentFloatPage()) {
                                                            StatisticItem statisticItem10 = new StatisticItem(str);
                                                            statisticItem10.param("fid", this.f48462e.getPbModel().getForumId());
                                                            statisticItem10.param("tid", this.f48462e.getPbModel().h1());
                                                            statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem10.param(str2, this.f48462e.o1());
                                                            statisticItem10.param("obj_source", 1);
                                                            statisticItem10.param("obj_type", 2);
                                                            statisticItem10.param(str5, this.f48462e.getFromVideoPageType());
                                                            TiebaStatic.log(statisticItem10);
                                                        }
                                                        this.f48462e.mDialogController.o0(false);
                                                        this.f48462e.mDialogController.P().onLongClick(view);
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                            } else {
                                                String str6 = str2;
                                                String str7 = str;
                                                String str8 = str3;
                                                if (this.f48462e.getPbModel() != null) {
                                                    AbsVideoPbFragment absVideoPbFragment8 = this.f48462e;
                                                    if (absVideoPbFragment8.mDialogController == null || absVideoPbFragment8.f48393i == null || this.f48462e.getPbModel().R0() == null || this.f48462e.getPbModel().R0().O() == null || !this.f48462e.checkUpIsLogin()) {
                                                        return;
                                                    }
                                                    c.a.s0.s2.r.f R0 = this.f48462e.getPbModel().R0();
                                                    int V0 = R0.O().V0();
                                                    int currentItem = this.f48462e.f48393i.getCurrentItem();
                                                    if (V0 == 0) {
                                                        if (this.f48462e.isShowDoubleTab() && currentItem == 0) {
                                                            this.f48462e.f48393i.setCurrentItem(1);
                                                        }
                                                        this.f48462e.expandVideo(false);
                                                        this.f48462e.processProfessionPermission();
                                                        return;
                                                    }
                                                    if (this.f48462e.isShowDoubleTab() && currentItem == 0) {
                                                        this.f48462e.f48393i.setCurrentItem(1);
                                                        str4 = str6;
                                                    } else if ((this.f48462e.isShowDoubleTab() && this.f48462e.getReplyFragment() == null) || this.f48462e.getDetailInfoAndReplyFragment() == null || this.f48462e.getRecyclerView() == null) {
                                                        return;
                                                    } else {
                                                        StatisticItem param = new StatisticItem("c13403").param("tid", this.f48462e.getPbModel().h1()).param("fid", this.f48462e.getPbModel().R0().m()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        str4 = str6;
                                                        int i7 = (int) (c.a.d.f.p.m.i(this.f48462e.getContext()) * 0.6d);
                                                        BdTypeRecyclerView recyclerView = this.f48462e.getRecyclerView();
                                                        if (recyclerView == null) {
                                                            return;
                                                        }
                                                        boolean canScrollVertically = recyclerView.canScrollVertically(1);
                                                        boolean canScrollVertically2 = recyclerView.canScrollVertically(-1);
                                                        AppBarLayout appBarLayout = this.f48462e.mAppBarLayout;
                                                        if (appBarLayout != null) {
                                                            appBarLayout.setExpanded(false, true);
                                                        }
                                                        if (recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                                                            return;
                                                        }
                                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                                                        if (!canScrollVertically2 && canScrollVertically) {
                                                            if (this.f48462e.I0 == -1 && this.f48462e.J0 == Integer.MIN_VALUE) {
                                                                return;
                                                            }
                                                            if (this.f48462e.I0 <= 3 && (this.f48462e.I0 != 3 || this.f48462e.J0 >= (-i7))) {
                                                                if (this.f48462e.I0 < 2) {
                                                                    if (this.f48462e.I0 != 1) {
                                                                        recyclerView.smoothScrollBy(0, -this.f48462e.J0);
                                                                    } else {
                                                                        int i8 = i7 / 4;
                                                                        linearLayoutManager.scrollToPositionWithOffset(this.f48462e.I0, this.f48462e.J0 + i8);
                                                                        recyclerView.smoothScrollBy(0, i8);
                                                                    }
                                                                } else {
                                                                    int i9 = i7 / 2;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.f48462e.I0, this.f48462e.J0 + i9);
                                                                    recyclerView.smoothScrollBy(0, i9);
                                                                }
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(this.f48462e.I0, this.f48462e.J0 + i7);
                                                                recyclerView.smoothScrollBy(0, i7);
                                                            }
                                                            param.param(str8, 2);
                                                            i3 = 1;
                                                        } else {
                                                            int firstVisiblePosition = recyclerView.getFirstVisiblePosition();
                                                            View childAt = recyclerView.getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            this.f48462e.I0 = firstVisiblePosition;
                                                            this.f48462e.J0 = top;
                                                            if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-i7) || recyclerView.getCount() < 6)) {
                                                                recyclerView.smoothScrollToPosition(0);
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                                recyclerView.smoothScrollToPosition(0);
                                                            }
                                                            i3 = 1;
                                                            param.param(str8, 1);
                                                        }
                                                        TiebaStatic.log(param);
                                                        c.a.r0.n0.c f2 = TbPageExtraHelper.f(view);
                                                        StatisticItem statisticItem11 = new StatisticItem("c12942");
                                                        statisticItem11.param("obj_type", i3);
                                                        statisticItem11.param(str8, 4);
                                                        statisticItem11.param("tid", this.f48462e.getPbModel().h1());
                                                        statisticItem11.param("nid", R0.O().G0());
                                                        if (f2 != null) {
                                                            statisticItem11.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                                                        }
                                                        if (TbPageExtraHelper.m() != null) {
                                                            statisticItem11.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                                                        }
                                                        TiebaStatic.log(statisticItem11);
                                                    }
                                                    if (this.f48462e.getPbModel() == null || this.f48462e.getPbModel().R0() == null || this.f48462e.getPbModel().R0().O() == null || this.f48462e.getPbModel().R0().O().J() == null) {
                                                        return;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f48462e.getPbModel().h1()).param("fid", this.f48462e.getPbModel().R0().m()).param(str8, 2).param("uid", this.f48462e.getPbModel().R0().O().J().getUserId()));
                                                    if (this.f48462e.isCommentFloatPage()) {
                                                        StatisticItem statisticItem12 = new StatisticItem(str7);
                                                        statisticItem12.param("fid", this.f48462e.getPbModel().getForumId());
                                                        statisticItem12.param("tid", this.f48462e.getPbModel().h1());
                                                        statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem12.param(str4, this.f48462e.o1());
                                                        statisticItem12.param("obj_source", 1);
                                                        statisticItem12.param("obj_type", 12);
                                                        statisticItem12.param(str8, this.f48462e.getFromVideoPageType());
                                                        TiebaStatic.log(statisticItem12);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        String str9 = str2;
                                        String str10 = str;
                                        String str11 = str3;
                                        if (!c.a.d.f.p.k.z()) {
                                            this.f48462e.showToast(c.a.s0.s2.l.network_not_available);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment9 = this.f48462e;
                                        if (absVideoPbFragment9.mDialogController == null || absVideoPbFragment9.getPbModel() == null) {
                                            return;
                                        }
                                        if (this.f48462e.isShowDoubleTab() && this.f48462e.getReplyFragment() == null) {
                                            return;
                                        }
                                        if (this.f48462e.isShowDoubleTab() || this.f48462e.getDetailInfoAndReplyFragment() != null) {
                                            this.f48462e.mDialogController.F();
                                            if (view.getId() != c.a.s0.s2.i.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new c.a.r0.s.r.t0(this.f48462e.getActivity(), "pb_shoucang"))) {
                                                if (!this.f48462e.i1(11009) || this.f48462e.getPbModel() == null) {
                                                    return;
                                                }
                                                this.f48462e.F1();
                                                if (this.f48462e.getPbModel().R0() != null && this.f48462e.getPbModel().R0().O() != null && this.f48462e.getPbModel().R0().O().J() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f48462e.getPbModel().h1()).param("fid", this.f48462e.getPbModel().R0().m()).param(str11, 3).param("uid", this.f48462e.getPbModel().R0().O().J().getUserId()));
                                                    if (this.f48462e.isCommentFloatPage()) {
                                                        StatisticItem statisticItem13 = new StatisticItem(str10);
                                                        statisticItem13.param("fid", this.f48462e.getPbModel().getForumId());
                                                        statisticItem13.param("tid", this.f48462e.getPbModel().h1());
                                                        statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem13.param(str9, this.f48462e.o1());
                                                        statisticItem13.param("obj_source", 1);
                                                        statisticItem13.param("obj_type", 13);
                                                        statisticItem13.param(str11, this.f48462e.getFromVideoPageType());
                                                        TiebaStatic.log(statisticItem13);
                                                    }
                                                }
                                                if (this.f48462e.getPbModel().R0().O() == null || this.f48462e.getPbModel().R0().O().J() == null || this.f48462e.getPbModel().R0().O().J().getUserId() == null || this.f48462e.L == null) {
                                                    return;
                                                }
                                                AbsVideoPbFragment absVideoPbFragment10 = this.f48462e;
                                                int S = absVideoPbFragment10.mDialogController.S(absVideoPbFragment10.getPbModel().R0());
                                                d2 O2 = this.f48462e.getPbModel().R0().O();
                                                if (O2.P1()) {
                                                    i2 = 2;
                                                } else if (O2.S1()) {
                                                    i2 = 3;
                                                } else if (O2.Q1()) {
                                                    i2 = 4;
                                                } else {
                                                    i2 = O2.R1() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f48462e.getPbModel().h1()).param(str11, 1).param("obj_id", this.f48462e.getPbModel().R0().O().J().getUserId()).param("obj_type", !this.f48462e.L.e()).param("obj_source", S).param("obj_param1", i2));
                                                return;
                                            }
                                            this.f48462e.w = view;
                                            return;
                                        }
                                        return;
                                    }
                                    String str12 = str2;
                                    String str13 = str3;
                                    if (this.f48462e.getPbModel() == null) {
                                        return;
                                    }
                                    if (view.getId() == c.a.s0.s2.i.pb_post_reply) {
                                        StatisticItem statisticItem14 = new StatisticItem("c13398");
                                        statisticItem14.param("tid", this.f48462e.getPbModel().h1());
                                        statisticItem14.param("fid", this.f48462e.getPbModel().getForumId());
                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem14.param(str13, 6);
                                        TiebaStatic.log(statisticItem14);
                                    }
                                    if (view.getId() == c.a.s0.s2.i.post_info_commont_img) {
                                        if (!DialogLoginHelper.checkUpIsLogin(new c.a.r0.s.r.t0(this.f48462e.getActivity(), "pb_huifu_louzhonglou"))) {
                                            this.f48462e.v = view;
                                            return;
                                        }
                                    } else if (view.getId() == c.a.s0.s2.i.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new c.a.r0.s.r.t0(this.f48462e.getActivity(), "pb_huifu_louzhonglou"))) {
                                        this.f48462e.v = view;
                                        return;
                                    }
                                    if (this.f48462e.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2.get(c.a.s0.s2.i.tag_load_sub_data) instanceof PostData) {
                                            PostData postData2 = (PostData) sparseArray2.get(c.a.s0.s2.i.tag_load_sub_data);
                                            if (view.getId() == c.a.s0.s2.i.pb_post_reply && (statisticItem = postData2.g0) != null) {
                                                StatisticItem copy = statisticItem.copy();
                                                copy.delete(str13);
                                                copy.param(str13, 8);
                                                TiebaStatic.log(copy);
                                            } else if (view.getId() == c.a.s0.s2.i.post_info_commont_img || view.getId() == c.a.s0.s2.i.pb_floor_comment_container) {
                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f48462e.getPbModel().i1()).param("fid", this.f48462e.getPbModel().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param(str12, postData2.G()).param("obj_source", 1).param("obj_type", 3));
                                            }
                                            if (this.f48462e.getPbModel() == null || this.f48462e.getPbModel().R0() == null || this.f48462e.F0 == null || postData2.t() == null || postData2.A() == 1) {
                                                return;
                                            }
                                            if (this.f48462e.E0 != null) {
                                                this.f48462e.E0.c();
                                            }
                                            if (this.f48462e.N0 && postData2.O() != null && postData2.O().size() != 0) {
                                                this.f48462e.a2(postData2, null, true, false);
                                                return;
                                            }
                                            c.a.s0.s2.r.t tVar2 = new c.a.s0.s2.r.t();
                                            tVar2.A(this.f48462e.getPbModel().R0().l());
                                            tVar2.E(this.f48462e.getPbModel().R0().O());
                                            tVar2.C(postData2);
                                            this.f48462e.F0.S(tVar2);
                                            this.f48462e.F0.setPostId(postData2.G());
                                            this.f48462e.D1(view, postData2.t().getUserId(), "", postData2);
                                            if (this.f48462e.C0 != null) {
                                                AbsVideoPbFragment absVideoPbFragment11 = this.f48462e;
                                                absVideoPbFragment11.setHasDraft(absVideoPbFragment11.C0.C());
                                            }
                                        }
                                    }
                                } else {
                                    String str14 = str2;
                                    String str15 = str;
                                    String str16 = str3;
                                    if (view.getId() == c.a.s0.s2.i.new_sub_pb_list_richText) {
                                        StatisticItem statisticItem15 = new StatisticItem("c13398");
                                        statisticItem15.param("tid", this.f48462e.getPbModel().h1());
                                        statisticItem15.param("fid", this.f48462e.getPbModel().getForumId());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param(str16, 4);
                                        TiebaStatic.log(statisticItem15);
                                        if (this.f48462e.isCommentFloatPage()) {
                                            StatisticItem statisticItem16 = new StatisticItem(str15);
                                            statisticItem16.param("fid", this.f48462e.getPbModel().getForumId());
                                            statisticItem16.param("tid", this.f48462e.getPbModel().h1());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param(str14, this.f48462e.o1());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 8);
                                            statisticItem16.param(str16, this.f48462e.getFromVideoPageType());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                    }
                                    if ((view.getId() == c.a.s0.s2.i.pb_floor_reply_more || view.getId() == c.a.s0.s2.i.pb_post_reply_count) && !DialogLoginHelper.checkUpIsLogin(new c.a.r0.s.r.t0(this.f48462e.getActivity(), "pb_chakanhuifu"))) {
                                        this.f48462e.u = view;
                                        return;
                                    }
                                    if (view.getId() == c.a.s0.s2.i.pb_floor_reply_more && this.f48462e.isCommentFloatPage()) {
                                        StatisticItem statisticItem17 = new StatisticItem(str15);
                                        statisticItem17.param("fid", this.f48462e.getPbModel().getForumId());
                                        statisticItem17.param("tid", this.f48462e.getPbModel().h1());
                                        statisticItem17.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem17.param(str14, this.f48462e.o1());
                                        statisticItem17.param("obj_source", 1);
                                        statisticItem17.param("obj_type", 9);
                                        statisticItem17.param(str16, this.f48462e.getFromVideoPageType());
                                        TiebaStatic.log(statisticItem17);
                                    }
                                    if (!this.f48462e.checkUpIsLogin()) {
                                        TiebaStatic.log(new StatisticItem("c10517").param(str16, 3).param("fid", this.f48462e.getPbModel().R0().m()));
                                    } else if (this.f48462e.getPbModel() == null || this.f48462e.getPbModel().R0() == null) {
                                    } else {
                                        c.a.s0.s2.y.g.a aVar14 = this.f48462e.mDialogController;
                                        if (aVar14 != null) {
                                            aVar14.F();
                                        }
                                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                                        PostData postData3 = (PostData) sparseArray3.get(c.a.s0.s2.i.tag_load_sub_data);
                                        PostData postData4 = (PostData) sparseArray3.get(c.a.s0.s2.i.tag_load_sub_reply_data);
                                        if (postData3 == null) {
                                            return;
                                        }
                                        if (postData3.E() == 1) {
                                            TiebaStatic.log(new StatisticItem("c12630"));
                                        }
                                        StatisticItem statisticItem18 = postData3.g0;
                                        if (statisticItem18 != null) {
                                            StatisticItem copy2 = statisticItem18.copy();
                                            copy2.delete(str16);
                                            if (view.getId() == c.a.s0.s2.i.new_sub_pb_list_richText) {
                                                copy2.param(str16, 6);
                                            } else if (view.getId() == c.a.s0.s2.i.pb_floor_reply_more) {
                                                copy2.param(str16, 8);
                                            }
                                            TiebaStatic.log(copy2);
                                        }
                                        this.f48462e.stopVoice();
                                        TiebaStatic.log("c11742");
                                        if (postData4 != null) {
                                            this.f48462e.a2(postData3, postData4, false, true);
                                        } else {
                                            this.f48462e.a2(postData3, null, false, false);
                                        }
                                    }
                                }
                            }
                        }
                    } else if (!c.a.d.f.p.k.z()) {
                        this.f48462e.showToast(c.a.s0.s2.l.network_not_available);
                        view.setTag(Boolean.FALSE);
                    } else {
                        this.f48462e.mDialogController.F();
                        if (!this.f48462e.I) {
                            this.f48462e.stopVoice();
                            this.f48462e.setPreLoad();
                            if (view.getId() == c.a.s0.s2.i.owner_reply) {
                                A2 = this.f48462e.getPbModel().A2(true, this.f48462e.o1());
                            } else {
                                A2 = view.getId() == c.a.s0.s2.i.all_reply ? this.f48462e.getPbModel().A2(false, this.f48462e.o1()) : this.f48462e.getPbModel().z2(this.f48462e.o1());
                            }
                            view.setTag(Boolean.valueOf(A2));
                            if (A2) {
                                this.f48462e.showProgressView();
                                i5 = 1;
                                this.f48462e.I = true;
                            } else {
                                i5 = 1;
                            }
                            TiebaStatic.eventStat(this.f48462e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i5, new Object[0]);
                            return;
                        }
                        view.setTag(Boolean.FALSE);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.F0.N(postData);
                if (this.a.getDetailInfoAndReplyFragment() != null) {
                    this.a.getDetailInfoAndReplyFragment().invalidataData();
                } else if (this.a.isShowDoubleTab() && this.a.getReplyFragment() != null) {
                    this.a.getReplyFragment().invalidataData();
                }
                this.a.E0.c();
                this.a.D0.hideTools();
                this.a.showCommonView(false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class y1 implements c.a.r0.x.x.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // c.a.r0.x.x.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.s0.s2.u.f.v0 v0Var = this.a.mContentProcessController;
                if (v0Var == null || v0Var.e() == null || !this.a.mContentProcessController.e().d()) {
                    return !this.a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.showToast(absVideoPbFragment.mContentProcessController.e().c());
                if (this.a.C0 != null && (this.a.C0.B() || this.a.C0.D())) {
                    this.a.C0.z(false, this.a.mContentProcessController.h());
                }
                this.a.mContentProcessController.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class z extends c.a.r0.d1.k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48463b;

        public z(AbsVideoPbFragment absVideoPbFragment, int i2) {
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
            this.f48463b = absVideoPbFragment;
            this.a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.d1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel pbModel = this.f48463b.getPbModel();
                if (pbModel != null) {
                    pbModel.k2(this.a);
                }
                return c.a.s0.s2.u.f.g1.b.d(this.f48463b.n1(), 2, pbModel);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class z0 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48464e;

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
            this.f48464e = absVideoPbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f48464e.mDialogController.o0(true);
                return this.f48464e.mDialogController.P().onLongClick(view);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class z1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.getPbModel() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.a.C0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.setHasDraft(absVideoPbFragment.C0.C());
            }
            this.a.resetCommentView();
            this.a.mDialogController.F();
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
        D1 = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds146);
        E1 = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds114);
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
        this.f48390f = 0L;
        this.r = false;
        this.y = new k(this);
        this.I = false;
        this.L = null;
        this.O = null;
        this.P = null;
        this.X = false;
        this.a0 = null;
        this.d0 = null;
        this.s0 = false;
        this.t0 = null;
        this.u0 = false;
        this.v0 = false;
        this.w0 = false;
        this.x0 = false;
        this.G0 = new int[2];
        this.I0 = -1;
        this.J0 = Integer.MIN_VALUE;
        this.K0 = 0;
        this.L0 = Integer.MIN_VALUE;
        this.M0 = false;
        this.N0 = c.a.r0.b.d.w0();
        this.O0 = new v(this);
        this.R0 = new c1(this);
        this.S0 = new n1(this);
        this.T0 = new y1(this);
        this.U0 = new z1(this, 2004016);
        this.V0 = new a2(this, 2004007);
        this.W0 = new a(this, 2921391);
        this.X0 = new b(this, 2016450);
        this.Y0 = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.Z0 = new d(this, 2001426);
        this.a1 = new e(this, 2001427);
        this.b1 = new f(this, 2001428);
        this.c1 = new g(this);
        this.d1 = new h(this);
        this.e1 = new i(this);
        this.f1 = new j(this, 2004008);
        this.g1 = 0;
        this.k1 = true;
        this.l1 = new l(this);
        this.n1 = new m(this);
        this.o1 = new n(this);
        this.r1 = new o(this);
        this.s1 = new p(this);
        this.t1 = new q(this);
        this.mOnFloorPostWriteNewCallback = new s(this);
        this.u1 = new x(this);
        this.listener = new y(this);
        this.v1 = new b0(this);
        this.w1 = new c0(this);
        this.x1 = new d0(this, 2001332);
        this.y1 = new e0(this, 2016528);
        this.z1 = new o0(this, 2001440);
        this.A1 = new p0(this);
        this.B1 = new v0(this, 2921509);
        this.C1 = new z0(this);
        this.onSwitchChangeListener = new a1(this);
        this.q0 = new b2(this, null);
    }

    public final boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.s0.s2.y.k.a aVar = this.operableVideoContainer;
            return aVar != null && aVar.Q0();
        }
        return invokeV.booleanValue;
    }

    public final void B1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.c0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.c0.setImageResource(0);
                this.c0.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.c0.setImageResource(c.a.s0.s2.h.transparent_bg);
        }
    }

    public final void D1(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || h1() || !checkPrivacyBeforeInput()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.G0);
            this.H0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (this.E0 != null && postData != null) {
            this.E0.j(String.format(TbadkCoreApplication.getInst().getResources().getString(c.a.s0.s2.l.reply_title), postData.t().getName_show(), postData.M() != null ? postData.M().toString() : ""));
        }
        if (getPbModel() != null && getPbModel().R0() != null && getPbModel().R0().g0()) {
            c.a.d.f.m.e.a().postDelayed(new h1(this, str, str2), 0L);
            return;
        }
        if (this.z0 == null) {
            c.a.s0.d1.r2.a.c cVar = new c.a.s0.d1.r2.a.c(getPageContext());
            this.z0 = cVar;
            cVar.j(1);
            this.z0.i(new i1(this, str, str2));
        }
        if (getPbModel() == null || getPbModel().R0() == null || getPbModel().R0().l() == null) {
            return;
        }
        this.z0.g(getPbModel().R0().l().getId(), c.a.d.f.m.b.g(getPbModel().h1(), 0L));
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || getPbModel() == null) {
            return;
        }
        c.a.s0.s2.r.f R0 = getPbModel().R0();
        getPbModel().x2(true);
        c.a.r0.i.a aVar = this.L;
        if (aVar != null) {
            R0.E0(aVar.g());
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

    public final void F1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || getPbModel() == null || getPbModel().R0() == null) {
            return;
        }
        if (isShowDoubleTab() && getReplyFragment() == null) {
            return;
        }
        if ((isShowDoubleTab() || getDetailInfoAndReplyFragment() != null) && this.L != null) {
            MarkData markData = null;
            if (getPbModel().R0() != null && getPbModel().R0().g0()) {
                markData = getPbModel().i0(0);
            } else {
                CustomViewPager customViewPager = this.f48393i;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = getPbModel().L0(getFirstPostData(getPbModel().R0()));
                } else if (isShowDoubleTab()) {
                    if (getReplyFragment() != null) {
                        markData = getPbModel().i0(getReplyFragment().getLastItem());
                    }
                } else if (getDetailInfoAndReplyFragment() != null) {
                    markData = getPbModel().i0(getDetailInfoAndReplyFragment().getLastItem());
                }
            }
            if (markData == null) {
                return;
            }
            if (markData.isApp() && getReplyFragment() != null && (markData = getPbModel().i0(getReplyFragment().getLastItem() + 1)) == null) {
                return;
            }
            setPreLoad();
            this.L.i(markData);
            if (!this.L.e()) {
                if (getPbModel() != null && !c.a.s0.s2.u.f.g1.b.k(getPbModel().h1())) {
                    this.h0.m(2);
                    c.a.s0.s2.u.f.g1.b.b(getPbModel().h1());
                }
                this.L.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.L.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final boolean G1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String p2 = c.a.r0.s.g0.b.j().p("bubble_link", "");
                if (StringUtils.isNull(p2)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    c.a.r0.m.a.q(getPageContext().getPageActivity(), getResources().getString(c.a.s0.s2.l.editor_privilege), p2 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!c.a.d.f.p.k.z()) {
                showToast(c.a.s0.s2.l.network_not_available);
            } else if (this.mDialogController == null || getPbModel() == null) {
            } else {
                this.mDialogController.F();
                if (this.I) {
                    return;
                }
                stopVoice();
                setPreLoad();
                if (getPbModel().loadData()) {
                    showProgressView();
                }
            }
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.operableVideoContainer == null) {
            return;
        }
        boolean z2 = false;
        if (this.q0.a()) {
            this.operableVideoContainer.a0(false);
            return;
        }
        c.a.s0.s2.y.k.a aVar = this.operableVideoContainer;
        if (!isCommentFloatPage() && !this.operableVideoContainer.R0()) {
            z2 = true;
        }
        aVar.a0(z2);
    }

    public final void J1(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || fVar == null) {
            return;
        }
        d2 O = fVar.O();
        if (O != null && O.G2()) {
            g1();
        } else {
            O1(this.B0);
        }
        c.a.r0.x.x.e eVar = this.C0;
        if (eVar != null) {
            setHasDraft(eVar.C());
            this.C0.M(fVar.d());
            this.C0.N(fVar.l(), fVar.U());
            this.C0.r0(O);
            if (getPbModel() != null) {
                this.C0.O(getPbModel().u0(), getPbModel().h1(), getPbModel().q0());
            }
            if (O != null) {
                this.C0.h0(O.o2());
            }
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.operableVideoContainer == null || this.f48393i == null) {
            return;
        }
        boolean z2 = false;
        if (!isShowDoubleTab()) {
            this.operableVideoContainer.V0(false);
        } else if (this.f48393i.getCurrentItem() != 0) {
            this.operableVideoContainer.V0(false);
        } else if (this.q0.a()) {
            this.operableVideoContainer.V0(false);
        } else {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            if (videoPbViewModel != null) {
                this.operableVideoContainer.V0((videoPbViewModel.getIsDetailTabTop() == null || videoPbViewModel.getIsDetailTabTop().getValue() == null || videoPbViewModel.getIsDetailTabTop().getValue().booleanValue()) ? true : true);
            }
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
            layoutParams.height = 0;
            this.s.setLayoutParams(layoutParams);
            this.s.setVisibility(8);
        }
    }

    public final void M1(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.M == null) {
            c.a.s0.s2.u.f.c1.f.a aVar = new c.a.s0.s2.u.f.c1.f.a(this.f48389e);
            this.M = aVar;
            aVar.n(this.u1);
            this.M.m(this.d1);
        }
        this.M.k(emotionImageData, getPbModel(), getPbModel().R0());
    }

    public final void N1(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || getPbModel() == null) {
            return;
        }
        showLoadingView(getView());
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
        privacySettingMessage.setTid(getPbModel().h1());
        sendMessage(privacySettingMessage);
    }

    public final void O1(c.a.r0.x.x.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) || gVar == null || getPbModel() == null) {
            return;
        }
        gVar.p(getPbModel().r0());
        if (getPbModel().R0() != null && getPbModel().R0().l() != null) {
            gVar.o(getPbModel().R0().l());
        }
        gVar.q("pb");
        gVar.r(getPbModel());
    }

    public final void P1(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || getPbModel() == null) {
            return;
        }
        int a12 = getPbModel().a1();
        if (i2 == 5) {
            getPbModel().s2(2);
        } else if (i2 == 6) {
            getPbModel().s2(3);
        } else if (i2 != 7) {
            getPbModel().s2(1);
        } else {
            getPbModel().s2(4);
        }
        int a13 = getPbModel().a1();
        if (a12 == 4 || a13 == 4) {
            H1();
        }
    }

    public final void Q1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z2) == null) {
            this.C0.f0(z2);
            this.C0.i0(z2);
            this.C0.p0(z2);
        }
    }

    public final void R1(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048593, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new d1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                c.a.s0.s2.y.g.a aVar = this.mDialogController;
                if (aVar != null) {
                    aVar.K0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    public final void S1(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            String errorString = postWriteCallBackData.getErrorString();
            String preMsg = postWriteCallBackData.getPreMsg();
            String colorMsg = postWriteCallBackData.getColorMsg();
            if (postWriteCallBackData.getIconStampData() != null) {
                c.a.r0.t.h.b.a(getPageContext(), postWriteCallBackData);
                return;
            }
            if (StringUtils.isNull(errorString)) {
                errorString = getPageContext().getPageActivity().getString(c.a.s0.s2.l.send_success);
            }
            if (StringUtils.isNull(colorMsg)) {
                c.a.d.f.p.m.M(getPageContext().getPageActivity(), errorString);
                return;
            }
            String str = errorString + " " + preMsg + colorMsg;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getPageContext().getPageActivity().getResources().getColor(c.a.s0.s2.f.CAM_X0305));
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(foregroundColorSpan, errorString.length() + preMsg.length() + 1, str.length(), 17);
            c.a.d.f.p.m.H(getPageContext().getPageActivity(), str, spannableString, 3000);
            return;
        }
        if (getPbModel() != null && !getPbModel().F0()) {
            antiData.setBlock_forum_name(getPbModel().R0().l().getName());
            antiData.setBlock_forum_id(getPbModel().R0().l().getId());
            antiData.setUser_name(getPbModel().R0().U().getUserName());
            antiData.setUser_id(getPbModel().R0().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public final void T1(c.a.s0.s2.r.f fVar) {
        c.a.s0.s2.y.i.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) || (G = fVar.G()) == null || G.p) {
            return;
        }
        f1(G);
    }

    public final void U1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            c.a.s0.s2.y.j.a.c(getPbActivity(), n1(), i2);
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || getPbModel() == null || c.a.d.f.p.l.isEmpty(getPbModel().h1())) {
            return;
        }
        c.a.r0.a.d.y().R(c.a.r0.a.c.X, c.a.d.f.m.b.g(getPbModel().h1(), 0L));
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.s.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.F;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            d2();
        }
    }

    public final void X1() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (layoutParams = this.s.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.F;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.s.setAlpha(0.0f);
            this.s.setVisibility(0);
            f2(layoutParams);
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.q1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mStatusBarBackground, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.q1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.q1.start();
        }
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.p1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mStatusBarBackground, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.p1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.p1.start();
        }
    }

    public final void a2(PostData postData, PostData postData2, boolean z2, boolean z3) {
        AbsPbActivity.e n2;
        boolean z4;
        PostData firstPostData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String h12 = getPbModel().h1();
            String G = postData.G();
            String G2 = postData2 != null ? postData2.G() : "";
            int V = getPbModel().R0() != null ? getPbModel().R0().V() : 0;
            if (getReplyFragment() != null && getReplyFragment().getRichViewHepler() != null) {
                n2 = getReplyFragment().getRichViewHepler().n(G);
            } else if (getDetailInfoAndReplyFragment() == null || getDetailInfoAndReplyFragment().getRichViewHepler() == null) {
                return;
            } else {
                n2 = getDetailInfoAndReplyFragment().getRichViewHepler().n(G);
            }
            AbsPbActivity.e eVar = n2;
            if (postData == null || getPbModel() == null || getPbModel().R0() == null || eVar == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(h12, G, "pb", true, isCommentFloatPage(), null, false, G2, V, postData.R(), getPbModel().R0().d(), false, postData.t().getIconInfo(), getFromVideoPageType(), getFromVideoPageType() == 1 || getFromVideoPageType() == 2 || getFromVideoPageType() == 3 || getFromVideoPageType() == 4 || getFromVideoPageType() == 5).addBigImageData(eVar.a, eVar.f48008b, eVar.f48013g, eVar.f48016j);
            if (z3) {
                addBigImageData.setHighLightPostId(G2);
                z4 = true;
                addBigImageData.setKeyIsUseSpid(true);
            } else {
                z4 = true;
            }
            addBigImageData.setKeyFromForumId(getPbModel().getForumId());
            addBigImageData.setTiebaPlusData(getPbModel().F(), getPbModel().B(), getPbModel().C(), getPbModel().A(), getPbModel().G());
            addBigImageData.setBjhData(getPbModel().k0());
            addBigImageData.setKeyPageStartFrom(getPbModel().Q0());
            addBigImageData.setFromFrsForumId(getPbModel().getFromForumId());
            addBigImageData.setWorksInfoData(getPbModel().m1());
            addBigImageData.setIsOpenEditor(z2);
            if (getPbModel().R0().o() != null) {
                addBigImageData.setHasForumRule(getPbModel().R0().o().has_forum_rule.intValue());
            }
            if (getPbModel().R0().U() != null) {
                addBigImageData.setIsManager(getPbModel().R0().U().getIs_manager());
            }
            if (getPbModel().R0().l().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(getPbModel().R0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(getPbModel().R0().l().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (getPbModel().R0().l() != null) {
                addBigImageData.setForumHeadUrl(getPbModel().R0().l().getImage_url());
                addBigImageData.setUserLevel(getPbModel().R0().l().getUser_level());
            }
            if (getPbModel() != null && (firstPostData = getFirstPostData(getPbModel().R0())) != null) {
                if (!firstPostData.U && !postData.U) {
                    z4 = false;
                }
                addBigImageData.setMainPostMaskVisibly(z4);
            }
            if (isCommentFloatPage() && this.f48389e.getIntent() != null) {
                addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.f48389e.getIntent().getSerializableExtra("key_from_video_page_id"));
            }
            addBigImageData.setForceInterceptStimeStat(this.f48389e.isForceInterceptStimeStat());
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public final void b2() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (absPbActivity = this.f48389e) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || getPbModel() == null || getPbModel().R0() == null || getPbModel().R0().O() == null) {
            return;
        }
        d2 O = getPbModel().R0().O();
        O.b1 = getPbModel().W0();
        O.a1 = getPbModel().Z0();
        O.Z0 = getPbModel().Y0();
        O.c1 = getPbModel().X0();
        O.K2 = getPbModel().F0();
        if (O.U() == 0) {
            O.I3(c.a.d.f.m.b.g(getPbModel().getForumId(), 0L));
        }
        StatisticItem i2 = c.a.r0.o0.c.i(getContext(), O, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public final boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (getPbModel() == null) {
                return true;
            }
            if (getPbModel().R0() == null || !getPbModel().R0().g0()) {
                if (getPbModel().D0()) {
                    MarkData o02 = getPbModel().o0();
                    if (o02 != null && getPbModel().B0() && getRecyclerView() != null) {
                        MarkData i02 = getPbModel().i0(getRecyclerView().getFirstVisiblePosition());
                        if (i02 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", o02);
                            this.f48389e.setResult(-1, intent);
                            return true;
                        } else if (i02.getPostId() != null && !i02.getPostId().equals(o02.getPostId())) {
                            c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(getBaseFragmentActivity());
                            aVar.setMessage(getPageContext().getString(c.a.s0.s2.l.alert_update_mark));
                            aVar.setPositiveButton(c.a.s0.s2.l.confirm, new t(this, i02, o02, aVar));
                            aVar.setNegativeButton(c.a.s0.s2.l.cancel, new u(this, o02, aVar));
                            aVar.setOnCalcelListener(new w(this));
                            aVar.create(getBaseFragmentActivity().getPageContext());
                            aVar.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", o02);
                            this.f48389e.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (getPbModel().R0() != null && getPbModel().R0().F() != null && getPbModel().R0().F().size() > 0 && getPbModel().B0()) {
                    this.f48389e.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void checkEasterEgg(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) instanceof PostData) && (postData = (PostData) bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition)) != null && postData.p() != null) {
                        postData.p().p(postData.A());
                        arrayList.add(postData.p());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new x1(this));
                if (((c.a.r0.u.a) ListUtils.getItem(arrayList, 0)).e() != 1) {
                    performFallingRedpacket((c.a.r0.u.a) ListUtils.getItem(arrayList, 0), 1);
                } else if (z2) {
                } else {
                    performFallingRedpacket((c.a.r0.u.a) ListUtils.getItem(arrayList, 0), 0);
                }
            }
        }
    }

    public boolean checkPrivacyBeforeInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if ((getPbModel() != null && getPbModel().R0().g0()) || this.mReplyPrivacyController == null || getPbModel() == null || getPbModel().R0() == null || ThreadCardUtils.isSelf(getPbModel().R0().O()) || getPbModel().R0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(getPbModel().R0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public boolean checkPrivacyBeforePost(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            if (this.mReplyPrivacyController == null || getPbModel() == null || getPbModel().R0() == null || ThreadCardUtils.isSelf(getPbModel().R0().O()) || getPbModel().R0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeSend(getPbModel().R0().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public void clickCommentReply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (!checkUpIsLogin()) {
                if (getPbModel() != null) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", getPbModel().getForumId()));
                }
            } else if (checkPrivacyBeforeInput()) {
                c.a.r0.x.x.e eVar = this.C0;
                if (eVar != null && (eVar.B() || this.C0.D())) {
                    this.C0.z(false, null);
                    return;
                }
                if (this.D0 != null) {
                    initPbEditor();
                    this.q0.a = false;
                    if (this.D0.findToolById(2) != null) {
                        c.a.s0.v3.i0.a.c(getPageContext(), (View) this.D0.findToolById(2).f14038k, false, null);
                    }
                }
                hideCommonView();
            }
        }
    }

    public final void d1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z2) == null) || getPbModel() == null || getPbModel().R0() == null || getPbModel().R0().O() == null) {
            return;
        }
        d2 O = getPbModel().R0().O();
        O.b1 = getPbModel().W0();
        O.a1 = getPbModel().Z0();
        O.Z0 = getPbModel().Y0();
        O.c1 = getPbModel().X0();
        if (O.U() == 0) {
            O.I3(c.a.d.f.m.b.g(getPbModel().getForumId(), 0L));
        }
        StatisticItem i2 = c.a.r0.o0.c.i(getContext(), O, "c13563");
        TbPageTag l2 = c.a.r0.o0.c.l(getContext());
        if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
        }
        if (i2 != null) {
            i2.param(TiebaStatic.Params.REPLY_TYPE, 1);
            if (z2) {
                i2.addParam("obj_type", 2);
            } else {
                i2.addParam("obj_type", 1);
            }
            c.a.r0.n0.c k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            if (getFromVideoPageType() == 1) {
                i2.param("obj_locate", 4);
            } else if (getFromVideoPageType() == 2) {
                i2.param("obj_locate", 5);
            } else if (getFromVideoPageType() == 3) {
                i2.param("obj_locate", 2);
            } else if (getFromVideoPageType() == 4) {
                i2.param("obj_locate", 3);
            } else if (getFromVideoPageType() == 7) {
                i2.param("obj_locate", 7);
            } else {
                i2.param("obj_locate", 6);
            }
            i2.addParam("obj_type", 1);
            i2.addParam("tid", getPbModel().h1());
            i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i2.addParam("fid", getPbModel().R0().m());
            TiebaStatic.log(i2);
        }
        StatisticItem i3 = c.a.r0.o0.c.i(getContext(), O, "c14180");
        if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i3.addParam("obj_type", 2);
        } else {
            i3.addParam("obj_type", 1);
        }
        i3.param("tid", getPbModel().h1());
        i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
        i3.param("fid", getPbModel().R0().m());
        if (l2 != null) {
            i3.param("obj_source", l2.tabType);
        }
        TiebaStatic.log(i3);
        StatisticItem i4 = c.a.r0.o0.c.i(getContext(), O, "c14303");
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
            i4.param("tid", getPbModel().h1());
            i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i4.param("fid", getPbModel().R0().m());
            i4.param("obj_type", 1);
        }
        TiebaStatic.log(i4);
    }

    public final void d2() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (layoutParams = this.s.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.G;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.G = ofFloat;
            ofFloat.addUpdateListener(new k1(this));
            this.G.setDuration(200L);
            this.G.start();
            this.G.addListener(new l1(this, layoutParams));
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048612, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX)) {
            return;
        }
        Object[] objArr = (c.a.r0.f1.n.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), c.a.r0.f1.n.f.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (c.a.s0.s2.u.f.y0.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(c.a.s0.s2.h.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX);
                spannableStringBuilder2.setSpan(new c.a.r0.f1.d(drawable), 0, 33, 33);
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
        if (interceptable == null || interceptable.invokeL(1048613, this, bVar) == null) {
            List<PostData> list = getPbModel().R0().T().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).O().size()) {
                        break;
                    } else if (bVar.f49831g.equals(list.get(i2).O().get(i3).G())) {
                        list.get(i2).O().remove(i3);
                        list.get(i2).l();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).n(bVar.f49831g);
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

    public void deleteThread(c.a.r0.s.t.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, aVar, jSONArray) == null) {
            aVar.dismiss();
            if (getPbModel() == null || getPbModel().R0() == null || getPbModel().R0().O() == null || getPbModel().R0().l() == null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(c.a.s0.s2.i.tag_del_post_id, str);
            sparseArray.put(c.a.s0.s2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(c.a.s0.s2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(c.a.s0.s2.i.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                deleteThread(sparseArray, (JSONArray) null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
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
    public final void e1(d2 d2Var) {
        double d2;
        int ceil;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        Rect j02;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, d2Var) == null) {
            double k2 = c.a.d.f.p.m.k(getContext());
            double i3 = (2.0d * k2) / c.a.d.f.p.m.i(getContext());
            if (d2Var != null && d2Var.t1() != null) {
                int intValue = d2Var.t1().video_width.intValue();
                int intValue2 = d2Var.t1().video_height.intValue();
                if (intValue2 > 0) {
                    d2 = (intValue * 1.0f) / intValue2;
                    if (d2 > 1.7777777777777777d) {
                        d2 = 1.7777777777777777d;
                    }
                    if (d2 >= i3) {
                        i3 = d2;
                    }
                    ceil = (int) Math.ceil(k2 / i3);
                    int height = (getPbModel() != null || (j02 = getPbModel().j0()) == null) ? ceil : j02.height();
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
                    if (isShowDoubleTab() && !c.a.r0.g1.b.c.d()) {
                        layoutParams3 = (RelativeLayout.LayoutParams) this.f48392h.getLayoutParams();
                        if (layoutParams3 != null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, E1);
                        } else {
                            layoutParams3.height = E1;
                        }
                        this.f48392h.setLayoutParams(layoutParams3);
                    }
                    layoutParams2 = (CoordinatorLayout.LayoutParams) this.mAppBarLayout.getLayoutParams();
                    if (isShowDoubleTab() && !c.a.r0.g1.b.c.d()) {
                        ceil += E1;
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
            d2 = 1.7777777777777777d;
            if (d2 > 1.7777777777777777d) {
            }
            if (d2 >= i3) {
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
                layoutParams3 = (RelativeLayout.LayoutParams) this.f48392h.getLayoutParams();
                if (layoutParams3 != null) {
                }
                this.f48392h.setLayoutParams(layoutParams3);
            }
            layoutParams2 = (CoordinatorLayout.LayoutParams) this.mAppBarLayout.getLayoutParams();
            if (isShowDoubleTab()) {
                ceil += E1;
            }
            if (layoutParams2 != null) {
            }
            this.mAppBarLayout.setLayoutParams(layoutParams2);
            if (i2 == 0) {
            }
        }
    }

    public final void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.F = ofFloat;
            ofFloat.setDuration(300L);
            this.F.addUpdateListener(new r1(this));
            this.F.start();
        }
    }

    public void expandVideo(boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) || (appBarLayout = this.mAppBarLayout) == null) {
            return;
        }
        appBarLayout.setExpanded(z2);
    }

    public final void f1(c.a.s0.s2.y.i.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, aVar) == null) && aVar != null && this.t == null) {
            this.t = aVar;
            this.z.setText(aVar.getTitle());
            this.A.setText(aVar.p());
            String o2 = aVar.o();
            TBSpecificationBtn tBSpecificationBtn = this.C;
            if (TextUtils.isEmpty(o2)) {
                o2 = getPageContext().getString(c.a.s0.s2.l.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(o2);
            this.D.startLoad(aVar.i(), 10, false);
            this.E.setVisibility(aVar.q() ? 0 : 8);
            c.a.d.f.m.e.a().postDelayed(new j1(this), aVar.g().longValue() * 1000);
        }
    }

    public final void f2(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, layoutParams) == null) {
            ViewGroup.LayoutParams layoutParams2 = this.mAppBarLayout.getLayoutParams();
            int i2 = layoutParams2.height;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.F = ofFloat;
            ofFloat.addUpdateListener(new p1(this, layoutParams, layoutParams2, i2));
            this.F.setDuration(300L);
            this.F.start();
            this.F.addListener(new q1(this));
        }
    }

    @Override // c.a.s0.s2.y.b
    public void finish() {
        CardHListViewData q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            PbModel pbModel = this.f48389e.getPbModel();
            if (pbModel != null && pbModel.R0() != null && !pbModel.R0().g0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = pbModel.R0().O().g0();
                if (pbModel.isShareThread() && pbModel.R0().O().A1 != null) {
                    historyMessage.threadName = pbModel.R0().O().A1.f41391b;
                } else {
                    historyMessage.threadName = pbModel.R0().O().getTitle();
                }
                if (pbModel.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = pbModel.R0().l().getName();
                }
                ArrayList<PostData> F = pbModel.R0().F();
                int firstItem = getReplyFragment() != null ? getReplyFragment().getFirstItem() : 0;
                if (F != null && firstItem >= 0 && firstItem < F.size()) {
                    historyMessage.postID = F.get(firstItem).G();
                }
                historyMessage.isHostOnly = pbModel.v0();
                historyMessage.isSquence = pbModel.f1();
                historyMessage.isShareThread = pbModel.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            c.a.r0.x.x.e eVar = this.C0;
            if (eVar != null) {
                eVar.I();
            }
            if (pbModel != null && (pbModel.x0() || pbModel.A0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", pbModel.h1());
                if (this.u0) {
                    if (this.w0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", pbModel.G0());
                    }
                    if (this.v0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", pbModel.C0());
                    }
                }
                if (pbModel.R0() != null && System.currentTimeMillis() - this.f48390f >= 40000 && (q2 = pbModel.R0().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                    intent.putExtra("guess_like_data", q2);
                }
                this.f48389e.setResult(-1, intent);
            }
            if (c2()) {
                if (pbModel != null) {
                    c.a.s0.s2.r.f R0 = pbModel.R0();
                    if (R0 != null) {
                        if (R0.U() != null) {
                            R0.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!this.x0) {
                            if (this.m != null) {
                                Rect rect = new Rect();
                                this.m.getGlobalVisibleRect(rect);
                                c.a.s0.s2.u.f.l0.b().t(rect);
                            }
                            c.a.s0.s2.u.f.l0.b().s(this.f48393i.getCurrentItem());
                            BdTypeRecyclerView recyclerView = getRecyclerView();
                            c.a.s0.s2.u.f.l0.b().n(pbModel.S0(), recyclerView != null ? recyclerView.onSaveInstanceState() : null, pbModel.f1(), pbModel.v0(), false);
                        }
                    }
                } else {
                    c.a.s0.s2.u.f.l0.b().m();
                }
                b2();
            }
        }
    }

    public void finishForumManageProcess(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(c.a.s0.s2.l.success));
            } else if (z3) {
                if (c.a.d.f.p.l.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(c.a.s0.s2.l.neterror);
                }
                showToast(str);
            }
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || getPbModel() == null || this.f48389e == null) {
            return;
        }
        c.a.r0.x.x.e eVar = this.C0;
        if (eVar == null || !eVar.z) {
            c.a.r0.x.x.d dVar = new c.a.r0.x.x.d();
            O1(dVar);
            c.a.r0.x.x.e eVar2 = (c.a.r0.x.x.e) dVar.a(getContext());
            this.C0 = eVar2;
            eVar2.e0(this.f48389e.getPageContext());
            this.C0.n0(this.d1);
            this.C0.o0(this.u1);
            this.C0.F(this.f48389e.getPageContext(), this.f48389e.getIntent() == null ? null : this.f48389e.getIntent().getExtras());
            this.C0.a().showLinePositionBottom(true);
            setEditorTools(this.C0.a());
            if (!getPbModel().F0()) {
                this.C0.s(getPbModel().h1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.C0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (getPbModel().t1()) {
                this.C0.k0(getPageContext().getString(c.a.s0.s2.l.pb_reply_hint_from_smart_frs));
            } else {
                this.C0.k0(getReplyHint());
            }
        }
    }

    public final void g2(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, layoutParams) == null) {
            ViewGroup.LayoutParams layoutParams2 = this.mAppBarLayout.getLayoutParams();
            int i2 = layoutParams2.height;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.F = ofFloat;
            ofFloat.addUpdateListener(new m1(this, layoutParams, layoutParams2, i2));
            this.F.setDuration(300L);
            this.F.start();
            this.F.addListener(new o1(this));
        }
    }

    public c.a.r0.t.e.a getAttentionModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.O : (c.a.r0.t.e.a) invokeV.objValue;
    }

    public LinearLayout getCommentReplyLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.b0 : (LinearLayout) invokeV.objValue;
    }

    public DetailInfoAndReplyFragment getDetailInfoAndReplyFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f48394j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.getFragmentByIndex(0) instanceof DetailInfoAndReplyFragment)) {
                return null;
            }
            return (DetailInfoAndReplyFragment) this.f48394j.getFragmentByIndex(0);
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public DetailInfoFragment getDetailInfoFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f48394j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.getFragmentByIndex(0) instanceof DetailInfoFragment)) {
                return null;
            }
            return (DetailInfoFragment) this.f48394j.getFragmentByIndex(0);
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    public PostData getFirstPostData(c.a.s0.s2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, fVar)) == null) {
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
                postData = q1(fVar);
            }
            if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
                postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public abstract int getFromVideoPageType();

    @Override // c.a.r0.f1.n.i
    public c.a.d.f.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (this.R == null) {
                this.R = new c.a.d.f.k.b<>(new t1(this), 20, 0);
            }
            return this.R;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.r0.f1.n.i
    public c.a.d.f.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (this.T == null) {
                this.T = new c.a.d.f.k.b<>(new s1(this), 8, 0);
            }
            return this.T;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public abstract int getInflateLayoutId();

    public boolean getIsLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.I : invokeV.booleanValue;
    }

    @Override // c.a.r0.f1.n.i
    public c.a.d.f.k.b<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public boolean getLinkGoodsMoreShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.r : invokeV.booleanValue;
    }

    @Override // c.a.r0.f1.n.i
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public View.OnClickListener getListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.listener : (View.OnClickListener) invokeV.objValue;
    }

    public View.OnClickListener getManageOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.v1 : (View.OnClickListener) invokeV.objValue;
    }

    public SparseArray<Object> getManagerOrDeleteTag(c.a.s0.s2.r.f fVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData firstPostData;
        c.a.r0.s.r.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048641, this, new Object[]{fVar, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (fVar == null || (firstPostData = getFirstPostData(fVar)) == null) {
                return null;
            }
            String userId = firstPostData.t().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(c.a.s0.s2.i.tag_del_post_id, firstPostData.G());
                sparseArray.put(c.a.s0.s2.i.tag_del_post_type, 0);
                sparseArray.put(c.a.s0.s2.i.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(c.a.s0.s2.i.tag_manage_user_identity, Integer.valueOf(fVar.V()));
                sparseArray.put(c.a.s0.s2.i.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (firstPostData.t() != null) {
                    sparseArray.put(c.a.s0.s2.i.tag_forbid_user_name, firstPostData.t().getUserName());
                    sparseArray.put(c.a.s0.s2.i.tag_forbid_user_name_show, firstPostData.t().getName_show());
                    sparseArray.put(c.a.s0.s2.i.tag_forbid_user_portrait, firstPostData.t().getPortrait());
                    sparseArray.put(c.a.s0.s2.i.tag_forbid_user_post_id, firstPostData.G());
                }
                sparseArray.put(c.a.s0.s2.i.tag_del_post_id, firstPostData.G());
                sparseArray.put(c.a.s0.s2.i.tag_del_post_type, 0);
                sparseArray.put(c.a.s0.s2.i.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(c.a.s0.s2.i.tag_manage_user_identity, Integer.valueOf(fVar.V()));
                sparseArray.put(c.a.s0.s2.i.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<c.a.r0.s.r.z1> p2 = fVar.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (c.a.r0.s.r.z1 z1Var : p2) {
                        if (z1Var != null && !StringUtils.isNull(z1Var.getForumName()) && (e0Var = z1Var.f13493g) != null && e0Var.a && !e0Var.f13298c && ((i3 = e0Var.f13297b) == 1 || i3 == 2)) {
                            sb.append(c.a.d.f.p.l.cutString(z1Var.getForumName(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(c.a.s0.s2.l.forum));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(c.a.s0.s2.i.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(c.a.s0.s2.l.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public c.a.r0.i.a getMarkModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.L : (c.a.r0.i.a) invokeV.objValue;
    }

    public View.OnLongClickListener getOnLongClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.C1 : (View.OnLongClickListener) invokeV.objValue;
    }

    public View.OnTouchListener getOnTouchListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.s1 : (View.OnTouchListener) invokeV.objValue;
    }

    @Override // c.a.s0.s2.y.b
    public AbsPbActivity getPbActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.f48389e : (AbsPbActivity) invokeV.objValue;
    }

    public c.a.r0.x.x.e getPbEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.C0 : (c.a.r0.x.x.e) invokeV.objValue;
    }

    @Override // c.a.s0.s2.y.b
    public PbFragment getPbFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    @Override // c.a.s0.s2.y.b
    public PbModel.g getPbFragmentDataCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.R0 : (PbModel.g) invokeV.objValue;
    }

    @Override // c.a.s0.s2.y.b
    public PbModel getPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.f48389e.getPbModel() : (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public BdTypeRecyclerView getRecyclerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            Iterator<BaseFragment> it = this.f48394j.getFragments().iterator();
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

    @Override // c.a.r0.f1.n.i
    public c.a.d.f.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            c.a.d.f.k.b<RelativeLayout> bVar = new c.a.d.f.k.b<>(new w1(this), 10, 0);
            this.W = bVar;
            return bVar;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public ReplyFragment getReplyFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f48394j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.getFragmentByIndex(1) instanceof ReplyFragment)) {
                return null;
            }
            return (ReplyFragment) this.f48394j.getFragmentByIndex(1);
        }
        return (ReplyFragment) invokeV.objValue;
    }

    public String getReplyHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            if (!c.a.d.f.p.l.isEmpty(this.r0)) {
                return this.r0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(c.a.s0.s2.u.f.r0.b());
            this.r0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.f1.n.i
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.f1.n.i
    public c.a.d.f.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            if (this.S == null) {
                this.S = TbRichTextView.createTextViewPool(getPageContext().getPageActivity(), 8);
            }
            return this.S;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.r0.f1.n.i
    public c.a.d.f.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            if (this.V == null) {
                this.V = new c.a.d.f.k.b<>(new v1(this), 15, 0);
            }
            return this.V;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.r0.f1.n.i
    public c.a.d.f.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.s0.s2.y.b
    public AbsVideoPbFragment getVideoPbFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            if (this.Q == null) {
                this.Q = VoiceManager.instance();
            }
            return this.Q;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // c.a.r0.f1.n.i
    public c.a.d.f.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (this.U == null) {
                this.U = new c.a.d.f.k.b<>(new u1(this), 8, 0);
            }
            return this.U;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public final boolean h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            PbModel pbModel = getPbModel();
            if (pbModel == null || pbModel.R0() == null) {
                return false;
            }
            d2 O = pbModel.R0().O();
            pbModel.R0().d();
            return AntiHelper.b(getPageContext(), O);
        }
        return invokeV.booleanValue;
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048663, this) == null) || getPbModel() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.B(getPbModel().getForumId()) || getPbModel().R0() == null || getPbModel().R0().l() == null) {
            return;
        }
        if (getPbModel().R0().l().isLike() == 1) {
            getPbModel().f0().A(getPbModel().getForumId(), getPbModel().h1());
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
        c.a.s0.s2.r.f R0;
        int i2;
        c.a.s0.s2.z.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048664, this, z2) == null) || getPbModel() == null || this.mDialogController == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (R0 = getPbModel().R0()) == null) {
            return;
        }
        d2 O = R0.O();
        if (O != null && O.J() != null) {
            TiebaStatic.log(new StatisticItem("c13402").param("tid", getPbModel().h1()).param("fid", R0.m()).param("obj_locate", 4).param("uid", O.J().getUserId()));
            if (isCommentFloatPage()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", getPbModel().getForumId());
                statisticItem.param("tid", getPbModel().h1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", o1());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", getFromVideoPageType());
                TiebaStatic.log(statisticItem);
            }
        }
        if (O != null) {
            if (O.P1()) {
                i2 = 2;
            } else if (O.S1()) {
                i2 = 3;
            } else if (O.Q1()) {
                i2 = 4;
            } else if (O.R1()) {
                i2 = 5;
            }
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem2.param("tid", getPbModel().h1());
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
                if (O.P1()) {
                    statisticItem2.param("obj_type", 10);
                } else if (O.S1()) {
                    statisticItem2.param("obj_type", 9);
                } else if (O.R1()) {
                    statisticItem2.param("obj_type", 8);
                } else if (O.Q1()) {
                    statisticItem2.param("obj_type", 7);
                } else if (O.B1) {
                    statisticItem2.param("obj_type", 6);
                } else {
                    int i3 = O.d0;
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
                statisticItem2.param("nid", O.G0());
                statisticItem2.param("card_type", O.R0());
                statisticItem2.param("recom_source", O.Z0);
                statisticItem2.param("ab_tag", O.b1);
                statisticItem2.param("weight", O.a1);
                statisticItem2.param("extra", O.c1);
                statisticItem2.param("nid", O.G0());
                if (O.L() != null && !c.a.d.f.p.l.isEmpty(O.L().oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, O.L().oriUgcVid);
                }
            }
            if (!c.a.d.f.p.l.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (getPbActivity() != null) {
                c.a.r0.o0.c.e(getPbActivity(), statisticItem2);
            }
            iVar = this.h0;
            if (iVar != null) {
                statisticItem2.param("obj_param1", iVar.f());
            }
            TiebaStatic.log(statisticItem2);
            if (c.a.d.f.p.m.C()) {
                showToast(c.a.s0.s2.l.neterror);
                return;
            } else if (getPbModel().R0() == null) {
                c.a.d.f.p.m.M(getPageContext().getPageActivity(), getPageContext().getString(c.a.s0.s2.l.pb_no_data_tips));
                return;
            } else {
                ArrayList<PostData> F = R0.F();
                if ((F == null || F.size() <= 0) && getPbModel().f1()) {
                    c.a.d.f.p.m.M(getPageContext().getPageActivity(), getPageContext().getString(c.a.s0.s2.l.pb_no_data_tips));
                    return;
                }
                this.mDialogController.F();
                stopVoice();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), O)) {
                    return;
                }
                c.a.s0.s2.z.i iVar2 = this.h0;
                if (iVar2 != null) {
                    iVar2.k(false);
                    updateBottomShareStateUI(R0);
                }
                if (ShareSwitch.isOn()) {
                    int i4 = z2 ? 2 : 1;
                    if ((c.a.r0.b.d.a0() || c.a.r0.b.d.b0()) && this.h0.h()) {
                        this.h0.l(false);
                        s1(c.a.r0.t.g.f.a(), this.h0.f());
                        return;
                    }
                    U1(i4);
                    return;
                }
                this.mDialogController.B0();
                getPbModel().m0().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                return;
            }
        }
        i2 = 1;
        StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem22.param("tid", getPbModel().h1());
        statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem22.param("fid", getPbModel().getForumId());
        if (!z2) {
        }
        statisticItem22.param("obj_name", i2);
        statisticItem22.param("obj_type", 2);
        if (O != null) {
        }
        if (!c.a.d.f.p.l.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
        }
        if (getPbActivity() != null) {
        }
        iVar = this.h0;
        if (iVar != null) {
        }
        TiebaStatic.log(statisticItem22);
        if (c.a.d.f.p.m.C()) {
        }
    }

    public void hideCommonView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048665, this) == null) || this.a0 == null) {
            return;
        }
        this.Z.setVisibility(8);
        this.a0.setVisibility(8);
        this.q0.a = false;
        I1();
        K1();
    }

    public void hideDraftTip(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) || this.a0 == null || this.d0 == null) {
            return;
        }
        if (getPbModel() != null && getPbModel().R0() != null) {
            this.d0.setText(TbSingleton.getInstance().getAdVertiComment(getPbModel().R0().k0(), getPbModel().R0().l0(), getReplyHint()));
        } else {
            this.d0.setText(getReplyHint());
        }
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.a0.startAnimation(alphaAnimation);
        }
        this.Z.setVisibility(0);
        this.a0.setVisibility(0);
        this.q0.a = true;
    }

    public void hideEditTool() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || (editorTools = this.D0) == null) {
            return;
        }
        editorTools.hide();
    }

    public void hideKeyBroad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048668, this) == null) || this.f48389e.getCurrentFocus() == null) {
            return;
        }
        c.a.d.f.p.m.w(getPageContext().getPageActivity(), this.f48389e.getCurrentFocus());
    }

    public void hideProgressView() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048669, this) == null) || (view = this.J) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void hideRightFloatLayerView() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048670, this) == null) || (rightFloatLayerView = this.Q0) == null) {
            return;
        }
        rightFloatLayerView.completeHide();
    }

    public void hideToolInEditor() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048671, this) == null) || (editorTools = this.D0) == null) {
            return;
        }
        editorTools.hideTools();
    }

    public final boolean i1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048672, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            c.a.r0.i.a c2 = c.a.r0.i.a.c(this.f48389e);
            this.L = c2;
            if (c2 != null) {
                c2.j(this.S0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f48389e);
            this.P = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.r1);
            this.O = new c.a.r0.t.e.a(getPageContext());
            this.mDialogController = new c.a.s0.s2.y.g.a(this);
        }
    }

    public void initET() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            setEditorTools(this.C0.a());
        }
    }

    public void initPbEditor() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048675, this) == null) || (editorTools = this.D0) == null) {
            return;
        }
        editorTools.display();
        c.a.r0.x.x.e eVar = this.C0;
        if (eVar != null) {
            eVar.P();
        }
        hideCommonView();
    }

    public void initRightFloatLayerView(c.a.s0.s2.r.f fVar) {
        c.a.r0.t.c.g pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048676, this, fVar) == null) || this.P0 == null || fVar == null || fVar.g() == 3 || isCommentFloatPage()) {
            return;
        }
        if (fVar.k0()) {
            pbAdFloatViewItemData = fVar.Z();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a() && getContext() != null) {
            if (!RightFloatLayerView.isPbNeedShow()) {
                hideRightFloatLayerView();
                return;
            }
            if (this.Q0 == null) {
                this.Q0 = RightFloatLayerLottieView.getRightFloatView(pbAdFloatViewItemData, getContext());
                this.P0.removeAllViews();
                this.P0.addView(this.Q0);
            }
            if ((this.H.getTag() instanceof Boolean) && !((Boolean) this.H.getTag()).booleanValue()) {
                this.Q0.setAutoCompleteShown(false);
                this.Q0.setTag(this.H);
                this.Q0.completeHide();
            }
            if (pbAdFloatViewItemData.a()) {
                return;
            }
            this.Q0.setData(pbAdFloatViewItemData);
            this.Q0.setLogoListener(new g0(this, fVar, pbAdFloatViewItemData));
            this.Q0.setFeedBackListener(new r0(this, pbAdFloatViewItemData));
            return;
        }
        hideRightFloatLayerView();
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            c.a.s0.q0.b bVar = new c.a.s0.q0.b(getActivity());
            this.mDragActionManager = bVar;
            bVar.i(this.t1);
            this.j1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
            x1();
            this.mAppBarLayout = (AppBarLayout) this.f48391g.findViewById(c.a.s0.s2.i.appbar_layout);
            this.f48395k = this.f48391g.findViewById(c.a.s0.s2.i.pb_video_pager_shadow);
            this.P0 = (FrameLayout) this.f48391g.findViewById(c.a.s0.s2.i.right_layer_view);
            this.m = (VideoContainerLayout) this.f48391g.findViewById(c.a.s0.s2.i.pb_video_container);
            c.a.s0.s2.y.k.a aVar = new c.a.s0.s2.y.k.a(getContext(), this.m);
            this.operableVideoContainer = aVar;
            aVar.setStageType("2002");
            this.operableVideoContainer.setUniqueId(getUniqueId());
            this.operableVideoContainer.b1(this);
            this.operableVideoContainer.Z0(getPbActivity().getRootView());
            this.operableVideoContainer.a1(this.mStatusBarBackground);
            ((RelativeLayout) this.f48391g.findViewById(c.a.s0.s2.i.scroll_container)).setMinimumHeight(((int) Math.ceil((c.a.d.f.p.m.k(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(c.a.s0.s2.g.tbds118));
            this.f48392h = (NewPagerSlidingTabBaseStrip) this.f48391g.findViewById(c.a.s0.s2.i.pb_video_tab_strip);
            this.s = this.f48391g.findViewById(c.a.s0.s2.i.pb_video_mount_layout);
            this.f48393i = (CustomViewPager) this.f48391g.findViewById(c.a.s0.s2.i.pb_video_view_pager);
            this.l = this.f48391g.findViewById(c.a.s0.s2.i.keyboard_background_shadow);
            this.x = (MaskView) this.f48391g.findViewById(c.a.s0.s2.i.mask_view);
            this.l.setOnClickListener(this.listener);
            y1();
            w1();
            t1();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.f48394j = videoPbFragmentAdapter;
            this.f48393i.setAdapter(videoPbFragmentAdapter);
            this.f48392h.setViewPager(this.f48393i);
            this.f48392h.setOnPageChangeListener(new q0(this));
            this.J = this.f48391g.findViewById(c.a.s0.s2.i.viewstub_progress);
            FallingView fallingView = (FallingView) this.f48391g.findViewById(c.a.s0.s2.i.falling_view);
            this.H = fallingView;
            fallingView.setAnimationListener(new s0(this));
            initET();
            u1();
            if (!this.j1 && this.k1) {
                Y1();
                UtilHelper.hideStatusBar(getPbActivity(), getPbActivity().getRootView());
                this.k1 = false;
            }
            if (!isShowDoubleTab() || c.a.r0.g1.b.c.d()) {
                this.f48392h.getLayoutParams().height = 0;
            }
            if (c.a.r0.g1.b.c.d()) {
                this.f48393i.setScrollable(false);
            }
        }
    }

    public abstract boolean isCommentFloatPage();

    public boolean isEditToolVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            EditorTools editorTools = this.D0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean isShowBottomCommentIcon();

    public boolean isShowDoubleTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? (isCommentFloatPage() || getPbModel() == null || !getPbModel().A1()) ? false : true : invokeV.booleanValue;
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            PbModel pbModel = this.f48389e.getPbModel();
            if (pbModel == null) {
                return false;
            }
            return pbModel.C1();
        }
        return invokeV.booleanValue;
    }

    public boolean isStatusBarShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.k1 : invokeV.booleanValue;
    }

    public boolean isToolInEditorVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            EditorTools editorTools = this.D0;
            return editorTools != null && editorTools.isToolVisible();
        }
        return invokeV.booleanValue;
    }

    public boolean isVerticalVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            c.a.s0.s2.y.k.a aVar = this.operableVideoContainer;
            if (aVar == null) {
                return false;
            }
            return aVar.R0();
        }
        return invokeV.booleanValue;
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            if (getPbModel().x0() || getPbModel().A0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", getPbModel().h1());
                this.f48389e.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, getPbModel().h1()));
            if (c2()) {
                this.f48389e.finish();
            }
        }
    }

    public final void k1(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048687, this, bVar, z2) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f49826b) ? bVar.f49826b : getString(c.a.s0.s2.l.delete_fail);
            int i2 = 0;
            if (bVar.f49827c == 1211066) {
                hideProgressBar();
                c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(c.a.s0.s2.l.dialog_known, new r(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else {
                finishForumManageProcess(0, bVar.a, bVar.f49826b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.f49828d;
                if (i3 == 1) {
                    ArrayList<PostData> F = getPbModel().R0().F();
                    int size = F.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.f49831g.equals(F.get(i2).G())) {
                            F.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    getPbModel().R0().O().r4(getPbModel().R0().O().V0() - 1);
                    if (getDetailInfoAndReplyFragment() != null) {
                        getDetailInfoAndReplyFragment().invalidataData();
                    } else if (isShowDoubleTab() && getReplyFragment() != null) {
                        getReplyFragment().invalidataData();
                    }
                } else if (i3 == 0) {
                    j1();
                } else if (i3 == 2) {
                    ArrayList<PostData> F2 = getPbModel().R0().F();
                    int size2 = F2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= F2.get(i4).O().size()) {
                                break;
                            } else if (bVar.f49831g.equals(F2.get(i4).O().get(i5).G())) {
                                F2.get(i4).O().remove(i5);
                                F2.get(i4).l();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        F2.get(i4).n(bVar.f49831g);
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

    public final void l1(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048688, this, i2, gVar) == null) || gVar == null || getPbModel() == null || getPbModel().R0() == null || getPbModel().R0().O() == null) {
            return;
        }
        finishForumManageProcess(this.P.getLoadDataMode(), gVar.a, gVar.f49844b, false);
        if (gVar.a) {
            this.u0 = true;
            if (i2 == 2 || i2 == 3) {
                this.v0 = true;
                this.w0 = false;
            } else if (i2 == 4 || i2 == 5) {
                this.v0 = false;
                this.w0 = true;
            }
            if (i2 == 2) {
                getPbModel().R0().O().b4(1);
                getPbModel().l2(1);
            } else if (i2 == 3) {
                getPbModel().R0().O().b4(0);
                getPbModel().l2(0);
            } else if (i2 == 4) {
                getPbModel().R0().O().c4(1);
                getPbModel().m2(1);
            } else if (i2 == 5) {
                getPbModel().R0().O().c4(0);
                getPbModel().m2(0);
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.f49844b)) {
                string = gVar.f49844b;
            } else {
                string = getString(c.a.s0.s2.l.operation_failed);
            }
            c.a.d.f.p.m.M(getPageContext().getPageActivity(), string);
        }
        if (isShowDoubleTab()) {
            if (getPbModel().R0().O() == null || getDetailInfoFragment() == null) {
                return;
            }
            getDetailInfoFragment().refreshFirstFloor();
        } else if (getPbModel().R0().O() == null || getDetailInfoAndReplyFragment() == null) {
        } else {
            getDetailInfoAndReplyFragment().refreshFirstFloor();
        }
    }

    public final String m1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048689, this, i2)) == null) {
            if (i2 == 0) {
                return getString(c.a.s0.s2.l.pb_comment_red_dot_no_reply);
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

    public final int n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            if (getPbModel() == null || getPbModel().R0() == null || getPbModel().R0().O() == null) {
                return -1;
            }
            return getPbModel().R0().O().w();
        }
        return invokeV.intValue;
    }

    public final String o1() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            if (getPbModel() == null || getPbModel().R0() == null || getPbModel().R0().F() == null || (count = ListUtils.getCount((F = getPbModel().R0().F()))) == 0) {
                return "";
            }
            if (getPbModel().c1()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.G();
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
                if (getPbModel().D1(postData.t().getUserId())) {
                    return postData.G();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                        break;
                    } else if (getPbModel().D1(postData2.t().getUserId())) {
                        return postData2.G();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                        break;
                    } else if (getPbModel().D1(postData3.t().getUserId())) {
                        return postData3.G();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(c.a.s0.s2.i.container));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            J1(videoPbViewModel.getData());
            initRightFloatLayerView(videoPbViewModel.getData());
            refreshTabText(videoPbViewModel.getData());
            if (getPbModel() != null && getPbModel().R0() != null) {
                boolean B0 = getPbModel().B0();
                c.a.s0.s2.r.f R0 = getPbModel().R0();
                if (B0) {
                    PostData firstPostData = getFirstPostData(R0);
                    if (R0.u() != null && !R0.u().equals(firstPostData.G()) && this.f48393i != null) {
                        if (isShowDoubleTab()) {
                            this.f48393i.setCurrentItem(1);
                        } else {
                            this.f48393i.setCurrentItem(0);
                        }
                    }
                }
            }
            videoPbViewModel.getVideoData().observe(this, new f0(this));
            videoPbViewModel.getCurrentTab().observe(this, new h0(this));
            videoPbViewModel.getPreVideoData().observe(this, new i0(this));
            videoPbViewModel.getNextVideoData().observe(this, new j0(this));
            videoPbViewModel.getIsDetailTabTop().observe(this, new k0(this));
            videoPbViewModel.getIsShowNavigationBar().observe(this, new l0(this));
            this.f48389e.getTiePlusEventController().addEventAckedCallbackWeaked(this.O0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048693, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.C0.H(i2, i3, intent);
            c.a.s0.s2.u.f.c1.f.a aVar = this.M;
            if (aVar != null) {
                aVar.i(i2, i3, intent);
            }
            c.a.s0.s2.u.f.t tVar = this.E0;
            if (tVar != null) {
                tVar.g(i2, i3, intent);
            }
            if (i2 == 25035) {
                r1(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 11009) {
                    F1();
                } else if (i2 == 13011) {
                    c.a.s0.i3.a.g().m(getPageContext());
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
                    this.N = emotionImageData;
                    if (checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        M1(emotionImageData);
                    }
                }
            }
        }
    }

    @Override // c.a.r0.f1.n.i
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048694, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.X = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, context) == null) {
            super.onAttach(context);
            this.f48389e = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i2) == null) {
            super.onChangeSkinType(i2);
            UtilHelper.changeStatusBarIconAndTextColor(true, this.f48389e);
            getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            getBaseFragmentActivity().getLayoutMode().j(this.f48391g);
            SkinManager.setBackgroundColor(this.mStatusBar, c.a.s0.s2.f.CAM_X0611);
            SkinManager.setBackgroundColor(this.mStatusBarBackground, c.a.s0.s2.f.CAM_X0608);
            SkinManager.setBackgroundColor(this.f48392h, c.a.s0.s2.f.CAM_X0207);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f48392h;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.onChangeSkinType();
            }
            c.a.s0.s2.u.f.v0 v0Var = this.mContentProcessController;
            if (v0Var != null) {
                v0Var.i();
            }
            c.a.s0.s2.y.e eVar = this.n;
            if (eVar == null || !eVar.k()) {
                SkinManager.setBackgroundColor(this.f48391g, c.a.s0.s2.f.CAM_X0201);
            }
            EditorTools editorTools = this.D0;
            if (editorTools != null) {
                editorTools.onChangeSkinType(i2);
            }
            c.a.s0.s2.u.f.t tVar = this.E0;
            if (tVar != null) {
                tVar.h(i2);
            }
            RightFloatLayerView rightFloatLayerView = this.Q0;
            if (rightFloatLayerView != null) {
                rightFloatLayerView.onChangeSkinType();
            }
            HeadImageView headImageView = this.c0;
            if (headImageView != null) {
                headImageView.setBorderColor(SkinManager.getColor(c.a.s0.s2.f.CAM_X0401));
            }
            LinearLayout linearLayout = this.b0;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.d.f.p.m.f(getContext(), c.a.s0.s2.g.tbds47), SkinManager.getColor(c.a.s0.s2.f.CAM_X0209)));
            }
            if (getPbModel() != null && getPbModel().D0()) {
                WebPManager.setPureDrawable(this.f0, c.a.s0.s2.h.icon_pure_pb_bottom_collected26_selection, c.a.s0.s2.f.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.f0, c.a.s0.s2.h.icon_pure_pb_bottom_collect26, c.a.s0.s2.f.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.e0, c.a.s0.s2.h.icon_pure_pb_bottom_comment26, c.a.s0.s2.f.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.B, c.a.s0.s2.h.icon_pure_close16_n_svg, c.a.s0.s2.f.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (getPbModel() != null) {
                updateBottomShareStateUI(getPbModel().R0());
            }
            SkinManager.setBackgroundResource(this.f48395k, c.a.s0.s2.h.personalize_tab_shadow);
            SkinManager.setBackgroundColor(this.s, c.a.s0.s2.f.CAM_X0206);
            SkinManager.setBackgroundColor(this.a0, c.a.s0.s2.f.CAM_X0207);
            SkinManager.setBackgroundColor(this.Z, c.a.s0.s2.f.CAM_X0203);
            SkinManager.setViewTextColor(this.A, c.a.s0.s2.f.CAM_X0109);
            SkinManager.setViewTextColor(this.z, c.a.s0.s2.f.CAM_X0105);
            SkinManager.setViewTextColor(this.d0, c.a.s0.s2.f.CAM_X0109);
            SkinManager.setViewTextColor(this.k0, c.a.s0.s2.f.CAM_X0105);
            SkinManager.setViewTextColor(this.i0, c.a.s0.s2.f.CAM_X0107);
            TextView textView = this.i0;
            int f2 = c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.s2.g.tbds18);
            int i3 = c.a.s0.s2.f.CAM_X0207;
            SkinManager.setBackgroundShapeDrawable(textView, f2, i3, i3);
            if (getDetailInfoAndReplyFragment() != null) {
                getDetailInfoAndReplyFragment().onChangeSkinType(i2);
            } else if (isShowDoubleTab() && getReplyFragment() != null) {
                getReplyFragment().onChangeSkinType(i2);
            }
            if (getDetailInfoFragment() != null) {
                getDetailInfoFragment().onChangeSkinType(i2);
            }
            View view = this.E;
            if (view != null) {
                view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.d.f.p.m.f(view.getContext(), c.a.s0.s2.g.tbds32), SkinManager.getColor(c.a.s0.s2.f.CAM_X0309)));
            }
            stopVoice();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            c.a.s0.s2.y.k.a aVar = this.operableVideoContainer;
            if (aVar == null || aVar.R0()) {
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
            this.f48390f = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            v1(bundle);
            getVoiceManager().onCreate(getPageContext());
            c.a.r0.s.i0.c cVar = new c.a.r0.s.i0.c();
            this.K = cVar;
            cVar.a = 1000L;
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
            registerListener(this.y1);
            this.q = new c.a.s0.f0.a(getPageContext());
            c.a.s0.u3.c.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048699, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f48391g = (RelativeLayout) layoutInflater.inflate(getInflateLayoutId(), viewGroup, false);
            initUI();
            return this.f48391g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            super.onDestroy();
            c.a.s0.u3.c.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.y1);
            getVoiceManager().onDestory(getPageContext());
            c.a.s0.s2.z.i iVar = this.h0;
            if (iVar != null) {
                iVar.j();
            }
            ForumManageModel forumManageModel = this.P;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            c.a.s0.s2.y.k.a aVar = this.operableVideoContainer;
            if (aVar != null) {
                aVar.S0();
            }
            c.a.s0.s2.u.f.c1.f.a aVar2 = this.M;
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
                if (getPbModel().N0() != null) {
                    getPbModel().N0().d();
                }
            }
            c.a.r0.x.x.e eVar = this.C0;
            if (eVar != null) {
                eVar.I();
            }
            this.K = null;
            stopFallingRedpacket();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        c.a.s0.s2.y.k.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048701, this, i2, keyEvent)) == null) {
            if (!this.j1 && (this.k1 || A1())) {
                Y1();
                UtilHelper.hideStatusBar(getPbActivity(), getPbActivity().getRootView());
                this.k1 = false;
                c.a.s0.s2.y.k.a aVar2 = this.operableVideoContainer;
                if (aVar2 != null) {
                    aVar2.W0(false);
                }
            }
            if (i2 == 4) {
                c.a.s0.s2.y.k.a aVar3 = this.operableVideoContainer;
                if (aVar3 != null) {
                    return aVar3.H();
                }
                return false;
            } else if (i2 == 24) {
                c.a.s0.s2.y.k.a aVar4 = this.operableVideoContainer;
                if (aVar4 != null) {
                    return aVar4.J();
                }
                return false;
            } else if (i2 != 25 || (aVar = this.operableVideoContainer) == null) {
                return false;
            } else {
                return aVar.T0();
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

    @Override // c.a.r0.f1.n.i
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048703, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.X = true;
    }

    @Override // c.a.r0.f1.n.i
    public void onLinkClicked(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048704, this, context, str, z2) == null) {
            if (c.a.s0.s2.u.f.y0.c(str) && getPbModel() != null && getPbModel().h1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", getPbModel().h1()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    c.a.r0.u.m mVar = new c.a.r0.u.m();
                    mVar.a = str;
                    mVar.f13993b = 3;
                    mVar.f13994c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, mVar));
                }
            } else {
                c.a.s0.s2.u.f.y0.a().e(getPageContext(), str);
            }
            this.X = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            super.onPause();
            this.M0 = true;
            getVoiceManager().onPause(getPageContext());
            c.a.s0.s2.y.k.a aVar = this.operableVideoContainer;
            if (aVar != null) {
                aVar.R(true);
            }
            if (getPbModel() != null && !getPbModel().F0()) {
                this.C0.U(getPbModel().h1());
            }
            RightFloatLayerView rightFloatLayerView = this.Q0;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).onChangeStyleToUnFold(600);
            }
            c.a.r0.a.d.y().G();
            MessageManager.getInstance().unRegisterListener(this.a1);
            MessageManager.getInstance().unRegisterListener(this.b1);
            MessageManager.getInstance().unRegisterListener(this.Z0);
            MessageManager.getInstance().unRegisterListener(this.x1);
        }
    }

    @Override // c.a.r0.f1.n.i
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048706, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mDialogController.p0(str);
        c.a.r0.s.t.b R = this.mDialogController.R();
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
        this.X = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            super.onResume();
            this.M0 = false;
            getVoiceManager().onResume(getPageContext());
            c.a.s0.s2.y.k.a aVar = this.operableVideoContainer;
            if (aVar != null) {
                aVar.R(false);
            }
            V1();
            registerListener(this.a1);
            registerListener(this.b1);
            registerListener(this.Z0);
            registerListener(this.x1);
            ItemCardHelper.v(this.A1);
            MessageManager.getInstance().registerListener(this.z1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (getPbModel() != null) {
                getPbModel().e2(bundle);
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
                c.a.s0.u3.c.g().h(getUniqueId(), false);
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

    @Override // c.a.r0.f1.n.i
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
            c.a.s0.u3.c.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.z1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048713, this, z2) == null) {
            super.onUserChanged(z2);
            C1();
        }
    }

    @Override // c.a.r0.f1.n.i
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048714, this, context, str) == null) {
            c.a.s0.s2.u.f.y0.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.X = true;
        }
    }

    @Override // c.a.r0.f1.n.i
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
        if (this.k1 && !TbSingleton.getInstance().isNotchScreen(getPbActivity()) && !TbSingleton.getInstance().isCutoutScreen(getPbActivity())) {
            Y1();
            UtilHelper.hideStatusBar(getPbActivity(), getPbActivity().getRootView());
            this.k1 = false;
        }
        this.q0.f48399b = z2;
        I1();
        K1();
    }

    public final int p1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048717, this, i2)) == null) {
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

    public void performFallingRedpacket(c.a.r0.u.a aVar, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048718, this, aVar, i2) == null) || (fallingView = this.H) == null) {
            return;
        }
        fallingView.startFalling(aVar, getPageContext(), i2, false);
    }

    public void processProfessionPermission() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048719, this) == null) || !checkUpIsLogin() || getPbModel() == null || getPbModel().R0() == null || getPbModel().R0().l() == null || h1()) {
            return;
        }
        if (getPbModel().R0().g0()) {
            clickCommentReply();
            return;
        }
        if (this.y0 == null) {
            c.a.s0.d1.r2.a.c cVar = new c.a.s0.d1.r2.a.c(getPageContext());
            this.y0 = cVar;
            cVar.j(0);
            this.y0.i(new b1(this));
        }
        this.y0.g(getPbModel().R0().l().getId(), c.a.d.f.m.b.g(getPbModel().h1(), 0L));
    }

    public final PostData q1(c.a.s0.s2.r.f fVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048720, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null || fVar.O().J() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData J = fVar.O().J();
            String userId = J.getUserId();
            HashMap<String, MetaData> C1 = fVar.O().C1();
            if (C1 != null && (metaData = C1.get(userId)) != null && metaData.getUserId() != null) {
                J = metaData;
            }
            postData.m0(1);
            postData.q0(fVar.O().X());
            postData.C0(fVar.O().getTitle());
            postData.B0(fVar.O().P());
            postData.k0(J);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final void r1(int i2, Intent intent) {
        c.a.r0.x.n nVar;
        c.a.s0.s2.u.f.t tVar;
        c.a.r0.x.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048721, this, i2, intent) == null) {
            if (i2 == 0) {
                hideEditTool();
                c.a.s0.s2.u.f.t tVar2 = this.E0;
                if (tVar2 != null) {
                    tVar2.c();
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
                    this.C0.S();
                    this.C0.t0(pbEditorData.getVoiceModel());
                    this.C0.G(writeData);
                    c.a.r0.x.m findToolById = this.C0.a().findToolById(6);
                    if (findToolById != null && (nVar = findToolById.f14038k) != null) {
                        nVar.onAction(new c.a.r0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.C0.L(null, null);
                    }
                } else if (editorType != 1 || (tVar = this.E0) == null || tVar.b() == null) {
                } else {
                    c.a.r0.x.x.h b3 = this.E0.b();
                    b3.b0(getPbModel().R0().O());
                    b3.B(writeData);
                    b3.c0(pbEditorData.getVoiceModel());
                    c.a.r0.x.m findToolById2 = b3.a().findToolById(6);
                    if (findToolById2 != null && (nVar2 = findToolById2.f14038k) != null) {
                        nVar2.onAction(new c.a.r0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b3.F();
                    }
                }
            }
        }
    }

    @Override // c.a.s0.s2.y.a
    public void refresh(boolean z2, int i2, int i3, int i4, c.a.s0.s2.r.f fVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048722, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) {
        }
    }

    public void refreshAll(boolean z2, int i2, int i3, int i4, c.a.s0.s2.r.f fVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048723, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.f48394j.getFragments()) {
                if (baseFragment instanceof c.a.s0.s2.y.a) {
                    ((c.a.s0.s2.y.a) baseFragment).refresh(z2, i2, i3, i4, fVar, str, i5);
                }
            }
            refresh(z2, i2, i3, i4, fVar, str, i5);
        }
    }

    public void refreshBottomTool(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048724, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        updateBottomShareStateUI(fVar);
        this.f0.setVisibility(fVar.g0() ? 8 : 0);
        if (fVar.r()) {
            WebPManager.setPureDrawable(this.f0, c.a.s0.s2.h.icon_pure_pb_bottom_collected26_selection, c.a.s0.s2.f.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.f0, c.a.s0.s2.h.icon_pure_pb_bottom_collect26, c.a.s0.s2.f.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String m12 = m1(fVar.O().V0());
        TextView textView = this.i0;
        if (textView != null) {
            textView.setText(m12);
        }
        TextView textView2 = this.k0;
        if (textView2 != null) {
            textView2.setText(m12);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.O()));
    }

    public void refreshMark(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048725, this, z2, markData) == null) || getPbModel() == null) {
            return;
        }
        setPostPro();
        getPbModel().x2(z2);
        c.a.r0.i.a aVar = this.L;
        if (aVar != null) {
            aVar.h(z2);
            if (markData != null) {
                this.L.i(markData);
            }
        }
        if (getPbModel().D0()) {
            E1();
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

    public void refreshTabText(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048726, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        String valueOf = String.valueOf(fVar.O().V0());
        if (fVar.O().V0() == 0) {
            valueOf = "";
        }
        this.f48392h.notifyTailData(valueOf);
    }

    public void refreshWrite(c.a.s0.s2.r.t tVar) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048727, this, tVar) == null) || getPbModel() == null || getPbModel().R0() == null || tVar.i() == null) {
            return;
        }
        String G = tVar.i().G();
        ArrayList<PostData> F = getPbModel().R0().F();
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
                ArrayList<PostData> k2 = tVar.k();
                postData.z0(tVar.m());
                if (postData.O() != null && k2 != null) {
                    Iterator<PostData> it = k2.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.V() != null && next != null && next.t() != null && (metaData = postData.V().get(next.t().getUserId())) != null) {
                            next.k0(metaData);
                            next.t0(true);
                            next.F0(getPageContext(), getPbModel().D1(metaData.getUserId()));
                        }
                    }
                    boolean z3 = k2.size() != postData.O().size();
                    if (!postData.Z(true)) {
                        postData.O().clear();
                        postData.O().addAll(k2);
                    }
                    z2 = z3;
                }
                if (postData.x() != null) {
                    postData.i0();
                }
            }
        }
        if (getPbModel().B0() || !z2) {
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
        if (!(interceptable == null || interceptable.invokeV(1048728, this) == null) || this.C0 == null || this.D0 == null) {
            return;
        }
        c.a.r0.x.x.a.a().c(0);
        this.C0.T();
        this.C0.R();
        if (this.C0.y() != null) {
            this.C0.y().setMaxImagesAllowed(this.C0.z ? 1 : 9);
        }
        this.C0.l0(SendView.ALL);
        this.C0.j(SendView.ALL);
        c.a.r0.x.h findLauncherById = this.D0.findLauncherById(23);
        c.a.r0.x.h findLauncherById2 = this.D0.findLauncherById(2);
        c.a.r0.x.h findLauncherById3 = this.D0.findLauncherById(5);
        if (findLauncherById2 != null) {
            findLauncherById2.display();
        }
        if (findLauncherById3 != null) {
            findLauncherById3.display();
        }
        if (findLauncherById != null) {
            findLauncherById.hide();
        }
        this.D0.invalidate();
    }

    public void resetCommentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            reset();
            hideEditTool();
            this.E0.c();
            showCommonView(false);
        }
    }

    public void resetRecordLocation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            this.I0 = -1;
            this.J0 = Integer.MIN_VALUE;
        }
    }

    public boolean richTextHandleSingleTap(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048731, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(c.a.s0.s2.i.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (!TextUtils.isEmpty(postData.u()) && c.a.r0.s.l.c().g()) {
                        return G1(postData.G());
                    }
                    if (checkUpIsLogin() && getPbModel() != null && getPbModel().R0() != null) {
                        c.a.s0.s2.u.f.t tVar = this.E0;
                        if (tVar != null) {
                            tVar.c();
                        }
                        c.a.s0.s2.r.t tVar2 = new c.a.s0.s2.r.t();
                        tVar2.A(getPbModel().R0().l());
                        tVar2.E(getPbModel().R0().O());
                        tVar2.C(postData);
                        this.F0.S(tVar2);
                        this.F0.setPostId(postData.G());
                        D1(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        c.a.r0.x.x.e eVar = this.C0;
                        if (eVar != null) {
                            setHasDraft(eVar.C());
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

    public final void s1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048732, this, i2, i3) == null) {
            c.a.r0.d1.n0.b(new z(this, i3), new a0(this, i3, i2));
        }
    }

    public void setCommentContainerVisible(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048733, this, i2) == null) || (linearLayout = this.Y) == null) {
            return;
        }
        linearLayout.setVisibility(i2);
    }

    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, editorTools) == null) {
            this.D0 = editorTools;
            editorTools.setId(c.a.s0.s2.i.pb_editor);
            this.D0.setOnCancelClickListener(new e1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.D0.getParent() == null) {
                this.f48391g.addView(this.D0, layoutParams);
            }
            this.D0.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.D0.setActionListener(24, new f1(this));
            hideEditTool();
            this.C0.i(new g1(this));
        }
    }

    public void setHasDraft(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z2) == null) {
            this.s0 = z2;
        }
    }

    public void setIsLoading(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z2) == null) {
            this.I = z2;
        }
    }

    public void setIsStatusBarShowing(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z2) == null) {
            this.k1 = z2;
        }
    }

    public abstract void setNavigationBarVisibility(boolean z2);

    public void setPostPostWrite(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048739, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            c.a.s0.s2.y.g.a aVar = this.mDialogController;
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
            c.a.d.f.p.m.w(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048742, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f48394j;
            if (videoPbFragmentAdapter == null || (customViewPager = this.f48393i) == null) {
                return;
            }
            videoPbFragmentAdapter.setItemPrimary(z2 ? customViewPager.getCurrentItem() : -1);
        }
    }

    public void setShadowVisible(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048743, this, i2) == null) || (view = this.f48395k) == null) {
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
        if (!(interceptable == null || interceptable.invokeZ(1048745, this, z2) == null) || this.a0 == null || c.a.r0.g1.b.c.d()) {
            return;
        }
        setHasDraft(this.C0.C());
        if (this.s0) {
            showDraftTip(z2);
        } else {
            hideDraftTip(z2);
        }
        I1();
        K1();
    }

    public void showDraftTip(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048746, this, z2) == null) || this.a0 == null || (textView = this.d0) == null) {
            return;
        }
        textView.setText(c.a.s0.s2.l.draft_to_send);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.a0.startAnimation(alphaAnimation);
        }
        this.Z.setVisibility(0);
        this.a0.setVisibility(0);
        this.q0.a = true;
    }

    public void showProgressView() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048747, this) == null) || (view = this.J) == null) {
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

    public void stopFallingRedpacket() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048749, this) == null) || (fallingView = this.H) == null) {
            return;
        }
        fallingView.stopAllViews();
    }

    public final void stopVoice() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048750, this) == null) || (voiceManager = this.Q) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048751, this) == null) {
            this.Y = (LinearLayout) this.f48391g.findViewById(c.a.s0.s2.i.video_pb_comment_container);
            this.Z = this.f48391g.findViewById(c.a.s0.s2.i.view_comment_top_line);
            this.a0 = this.f48391g.findViewById(c.a.s0.s2.i.pb_editor_tool_comment);
            c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds120);
            c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.ds242);
            HeadImageView headImageView = (HeadImageView) this.f48391g.findViewById(c.a.s0.s2.i.pb_editor_tool_comment_user_image);
            this.c0 = headImageView;
            headImageView.setVisibility(0);
            this.c0.setIsRound(true);
            this.c0.setBorderWidth(c.a.d.f.p.m.f(getContext(), c.a.s0.s2.g.L_X01));
            this.c0.setBorderColor(SkinManager.getColor(c.a.s0.s2.f.CAM_X0401));
            this.c0.setPlaceHolder(0);
            C1();
            this.d0 = (TextView) this.f48391g.findViewById(c.a.s0.s2.i.pb_editor_tool_comment_reply_text);
            LinearLayout linearLayout = (LinearLayout) this.f48391g.findViewById(c.a.s0.s2.i.pb_editer_tool_comment_layout);
            this.b0 = linearLayout;
            linearLayout.setOnClickListener(new u0(this));
            ImageView imageView = (ImageView) this.f48391g.findViewById(c.a.s0.s2.i.pb_editor_tool_comment_icon);
            this.e0 = imageView;
            imageView.setOnClickListener(this.listener);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView2 = (ImageView) this.f48391g.findViewById(c.a.s0.s2.i.pb_editor_tool_collection);
            this.f0 = imageView2;
            imageView2.setOnClickListener(this.listener);
            if (booleanExtra) {
                this.f0.setVisibility(8);
            } else {
                this.f0.setVisibility(0);
            }
            if (isShowBottomCommentIcon()) {
                this.e0.setVisibility(0);
            } else {
                this.e0.setVisibility(8);
                this.f0.setPadding(c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView3 = (ImageView) this.f48391g.findViewById(c.a.s0.s2.i.pb_editor_tool_share);
            this.g0 = imageView3;
            imageView3.setOnClickListener(this.listener);
            this.h0 = new c.a.s0.s2.z.i(this.g0);
            if (!c.a.r0.b.d.a0() && !c.a.r0.b.d.b0()) {
                this.h0.e();
            }
            if (getPbModel() != null && c.a.r0.b.d.a0() && !c.a.s0.s2.u.f.g1.b.k(getPbModel().h1())) {
                this.h0.e();
                c.a.s0.s2.u.f.g1.b.b(getPbModel().h1());
            }
            TextView textView = (TextView) this.f48391g.findViewById(c.a.s0.s2.i.pb_editor_tool_comment_red_dot);
            this.i0 = textView;
            textView.setVisibility(0);
            showCommonView(false);
            if (c.a.r0.g1.b.c.d()) {
                ViewGroup.LayoutParams layoutParams = this.Y.getLayoutParams();
                layoutParams.height = 0;
                this.Y.setLayoutParams(layoutParams);
            }
        }
    }

    public void tapResetEditor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            c.a.r0.x.x.e eVar = this.C0;
            if (eVar != null) {
                setHasDraft(eVar.C());
            }
            resetCommentView();
            this.mDialogController.F();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048754, this) == null) || getPbModel() == null || c.a.d.f.p.l.isEmpty(getPbModel().h1())) {
            return;
        }
        super.taskStart();
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048755, this) == null) {
            this.F0 = new PbFakeFloorModel(getPageContext());
            PbModel pbModel = getPbModel();
            this.F0.P(pbModel.F(), pbModel.B(), pbModel.C(), pbModel.A(), pbModel.G());
            this.F0.setFromForumId(pbModel.getFromForumId());
            c.a.s0.s2.u.f.t tVar = new c.a.s0.s2.u.f.t(getPageContext(), this.F0, this.f48391g);
            this.E0 = tVar;
            tVar.k(new x0(this));
            this.E0.n(this.mOnFloorPostWriteNewCallback);
            this.F0.R(new y0(this));
        }
    }

    public void updateBottomShareStateUI(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, fVar) == null) {
            if (fVar != null && AntiHelper.o(fVar.O())) {
                c.a.s0.s2.z.i iVar = this.h0;
                if (iVar != null) {
                    iVar.k(false);
                    this.h0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.g0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.g0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.g0, c.a.s0.s2.h.icon_pure_pb_bottom_share26, c.a.s0.s2.f.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            c.a.s0.s2.z.i iVar2 = this.h0;
            if (iVar2 == null || !iVar2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.g0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.g0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.g0, c.a.s0.s2.h.icon_pure_pb_bottom_share26, c.a.s0.s2.f.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void updateUegMask(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048757, this, z2) == null) {
            DetailInfoAndReplyFragment detailInfoAndReplyFragment = getDetailInfoAndReplyFragment();
            if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.getAdapterManager() != null && detailInfoAndReplyFragment.getAdapterManager().f() != null && detailInfoAndReplyFragment.getAdapterManager().g() != null) {
                detailInfoAndReplyFragment.getAdapterManager().f().V0(z2);
                detailInfoAndReplyFragment.getAdapterManager().g().t0(z2);
            }
            MaskView maskView = this.x;
            if (maskView != null) {
                maskView.setVisibility(z2 ? 0 : 8);
            }
        }
    }

    public final void v1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, bundle) == null) {
            c.a.r0.x.x.g gVar = new c.a.r0.x.x.g();
            this.B0 = gVar;
            O1(gVar);
            c.a.r0.x.x.e eVar = (c.a.r0.x.x.e) this.B0.a(getActivity());
            this.C0 = eVar;
            eVar.e0(this.f48389e.getPageContext());
            this.C0.n0(this.d1);
            this.C0.o0(this.u1);
            this.C0.g0(1);
            this.C0.F(this.f48389e.getPageContext(), bundle);
            this.C0.a().addHideLauncher(new c.a.r0.x.k(getActivity()));
            this.C0.a().showLinePositionBottom(true);
            Q1(true);
            this.C0.O(getPbModel().u0(), getPbModel().h1(), getPbModel().q0());
            registerListener(this.V0);
            registerListener(this.X0);
            registerListener(this.f1);
            registerListener(this.U0);
            registerListener(this.W0);
            registerListener(this.Y0);
            registerListener(this.B1);
            if (!getPbModel().F0()) {
                this.C0.s(getPbModel().h1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.C0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (getPbModel().t1()) {
                this.C0.k0(getPageContext().getString(c.a.s0.s2.l.pb_reply_hint_from_smart_frs));
            } else {
                this.C0.k0(getReplyHint());
            }
            this.mContentProcessController = new c.a.s0.s2.u.f.v0();
            if (this.C0.v() != null) {
                this.mContentProcessController.m(this.C0.v().h());
            }
            this.C0.d0(this.T0);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.mReplyPrivacyController = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new n0(this));
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            this.z = (TextView) this.f48391g.findViewById(c.a.s0.s2.i.pb_video_mount_title);
            this.D = (TbImageView) this.f48391g.findViewById(c.a.s0.s2.i.pb_video_mount_pic);
            this.A = (TextView) this.f48391g.findViewById(c.a.s0.s2.i.pb_video_mount_desc);
            this.B = (ImageView) this.f48391g.findViewById(c.a.s0.s2.i.pb_video_mount_close);
            this.C = (TBSpecificationBtn) this.f48391g.findViewById(c.a.s0.s2.i.pb_video_mount_link);
            this.E = this.f48391g.findViewById(c.a.s0.s2.i.ala_live_point);
            this.D.setRadius(c.a.d.f.p.m.f(getContext(), c.a.s0.s2.g.tbds10));
            this.D.setConrers(15);
            this.C.setConfig(new c.a.r0.s.i0.n.c());
            this.B.setOnClickListener(new t0(this));
            this.C.setOnClickListener(this.y);
            this.s.setOnClickListener(this.y);
            if (getPbModel() == null || getPbModel().R0() == null) {
                return;
            }
            T1(getPbModel().R0());
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f48391g.findViewById(c.a.s0.s2.i.video_pb_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setOnClickListener(new w0(this));
            this.mNavigationBar.hideBottomLine();
            this.mNavigationBar.getTopCoverBgView().setBackgroundResource(c.a.s0.s2.h.bg_pb_header_gradient_top);
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mStatusBar = this.f48391g.findViewById(c.a.s0.s2.i.statebar);
            View findViewById = this.f48391g.findViewById(c.a.s0.s2.i.status_bar_background);
            this.mStatusBarBackground = findViewById;
            if (this.j1) {
                ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
                layoutParams.height = c.a.d.f.p.m.r(getPbActivity());
                this.mStatusBar.setLayoutParams(layoutParams);
                this.mStatusBar.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = c.a.d.f.p.m.r(getPbActivity());
                this.mStatusBarBackground.setLayoutParams(layoutParams2);
                this.mStatusBarBackground.setVisibility(0);
            }
            View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.listener);
            this.mBackButton = addSystemImageButton;
            this.o = (ImageView) addSystemImageButton.findViewById(c.a.s0.s2.i.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, c.a.s0.s2.h.ic_icon_pure_topbar_return40_svg, c.a.s0.s2.f.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, c.a.s0.s2.j.nb_item_floor_more, this.listener);
            this.mMore = addCustomView;
            this.p = (ImageView) addCustomView.findViewById(c.a.s0.s2.i.navigationBarBtnMore);
            int f2 = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds132);
            int f3 = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds21);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(f2, f2);
            layoutParams3.rightMargin = f3;
            this.mMore.setLayoutParams(layoutParams3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.p, c.a.s0.s2.h.icon_pure_topbar_more44_svg, c.a.s0.s2.f.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mMore.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            this.m1 = new GestureDetector(getContext(), this.n1);
            this.mNavigationBar.setOnTouchListener(this.l1);
        }
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048761, this) == null) {
            this.f48392h.setDefaultSelectorColorResourceId(c.a.s0.s2.f.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds4);
            this.f48392h.setContainerLayoutParams(layoutParams);
            this.f48392h.setRectPaintColor(c.a.s0.s2.f.CAM_X0302);
            this.f48392h.init(c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds46), c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds46), c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds10), c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds46), true, true);
            this.f48392h.setIndicatorOffset(c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds64));
            this.f48392h.setIndicatorOvershot(c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds8));
            this.f48392h.setIndicatorMarginBottom(c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds170), -1);
            layoutParams2.gravity = 16;
            this.f48392h.setExpandedTabLayoutParams(layoutParams2);
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048762, this) == null) && this.n == null) {
            this.n = new c.a.s0.s2.y.e(getBaseFragmentActivity(), this.m);
            int r2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? c.a.d.f.p.m.r(getPbActivity()) : 0;
            Rect rect = new Rect(0, r2, c.a.d.f.p.m.k(getContext()), this.m.getOriginHeight() + r2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.n.r(videoPbViewModel.getOriginArea(), rect);
            if (this.n.l()) {
                this.n.q(new m0(this, videoPbViewModel));
            } else if (!c.a.r0.g1.b.c.d() && isShowDoubleTab() && (videoPbViewModel.isJumpCommentTab() || getPbModel().g1() == 1)) {
                this.f48393i.setCurrentItem(1);
            } else if (videoPbViewModel.isJumpCommentTab() || getPbModel().g1() == 0) {
                this.f48393i.setCurrentItem(0);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f48399b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f48400c;

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
            this.f48400c = absVideoPbFragment;
            this.f48399b = true;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.a && this.f48399b) ? false : true : invokeV.booleanValue;
        }

        public /* synthetic */ b2(AbsVideoPbFragment absVideoPbFragment, k kVar) {
            this(absVideoPbFragment);
        }
    }

    public void deleteThread(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue != 3) {
                if (intValue == 4 || intValue == 6) {
                    if (getPbModel().n0() != null) {
                        getPbModel().n0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == 4) {
                        TiebaStatic.log("c10499");
                    }
                }
            } else if (this.P.P()) {
            } else {
                showProgressBar();
                String str = (String) sparseArray.get(c.a.s0.s2.i.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(c.a.s0.s2.i.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(c.a.s0.s2.i.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(c.a.s0.s2.i.tag_del_post_type)).intValue();
                boolean booleanValue2 = sparseArray.get(c.a.s0.s2.i.tag_is_block_thread) != null ? ((Boolean) sparseArray.get(c.a.s0.s2.i.tag_is_block_thread)).booleanValue() : false;
                if (jSONArray != null) {
                    this.P.R(StringHelper.JsonArrayToString(jSONArray));
                }
                this.P.S(getPbModel().R0().l().getId(), getPbModel().R0().l().getName(), getPbModel().R0().O().g0(), str, intValue3, intValue2, booleanValue, getPbModel().R0().O().L(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            }
        }
    }
}
