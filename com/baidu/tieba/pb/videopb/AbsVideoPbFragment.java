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
import androidx.constraintlayout.motion.widget.Key;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import b.a.q0.f1.n.f;
import b.a.q0.i.a;
import b.a.q0.s.q.d2;
import b.a.q0.s.s.a;
import b.a.r0.k0.b;
import b.a.r0.x0.q2.a.c;
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
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
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
/* loaded from: classes9.dex */
public abstract class AbsVideoPbFragment extends BaseFragment implements b.a.q0.f1.n.i, VoiceManager.j, b.a.r0.k2.y.b, TbRichTextView.t, b.a.r0.k2.y.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int B1;
    public static final int BDALERT_DIALOG_CLICK_FROM = 0;
    public static final int C1;
    public static final int DETAIL_INFO_AND_REPLY_PAGE = 0;
    public static final int DETAIL_INFO_PAGE = 0;
    public static final int DIALOG_FROM_MANAGE = 3;
    public static final int DIALOG_FROM_UPGRADE_THREAD = 4;
    public static final int DIALOG_FROM_UPGRADE_THREAD_FAILED = 5;
    public static final int DIALOG_FROM_UPGRADE_THREAD_HAS_SAME = 6;
    public static final int REPLY_PAGE = 1;
    public static final int THREAD_CAN_UPGRADE = 3;
    public static final int UPDATE_TYPE_DELETE = 1;
    public static final int UPDATE_TYPE_MARK = 2;
    public static final int UPDATE_TYPE_WRITE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public b.a.q0.x.x.g A0;
    public final View.OnLongClickListener A1;
    public ImageView B;
    public b.a.q0.x.x.e B0;
    public TBSpecificationBtn C;
    public EditorTools C0;
    public TbImageView D;
    public b.a.r0.k2.u.f.t D0;
    public View E;
    public PbFakeFloorModel E0;
    public ValueAnimator F;
    public int[] F0;
    public ValueAnimator G;
    public int G0;
    public FallingView H;
    public int H0;
    public boolean I;
    public int I0;
    public View J;
    public int J0;
    public b.a.q0.s.g0.c K;
    public int K0;
    public b.a.q0.i.a L;
    public boolean L0;
    public b.a.r0.k2.u.f.b1.f.a M;
    public boolean M0;
    public EmotionImageData N;
    @NonNull
    public TiePlusEventController.d N0;
    public b.a.q0.t.e.a O;
    public RightFloatLayerView O0;
    public ForumManageModel P;
    public final PbModel.g P0;
    public VoiceManager Q;
    public final a.InterfaceC0664a Q0;
    public b.a.e.e.k.b<GifView> R;
    public b.a.q0.x.x.b R0;
    public b.a.e.e.k.b<TextView> S;
    public final CustomMessageListener S0;
    public b.a.e.e.k.b<ImageView> T;
    public CustomMessageListener T0;
    public b.a.e.e.k.b<View> U;
    public final CustomMessageListener U0;
    public b.a.e.e.k.b<LinearLayout> V;
    public CustomMessageListener V0;
    public b.a.e.e.k.b<RelativeLayout> W;
    public HttpMessageListener W0;
    public boolean X;
    public CustomMessageListener X0;
    public LinearLayout Y;
    public CustomMessageListener Y0;
    public View Z;
    public CustomMessageListener Z0;
    public View a0;
    public b.a.q0.x.x.b a1;
    public LinearLayout b0;
    public final NewWriteModel.g b1;
    public HeadImageView c0;
    public View.OnClickListener c1;
    public CustomMessageListener d1;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f52667e;
    public int e1;

    /* renamed from: f  reason: collision with root package name */
    public long f52668f;
    public float f1;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f52669g;
    public float g1;

    /* renamed from: h  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f52670h;
    public boolean h1;

    /* renamed from: i  reason: collision with root package name */
    public CustomViewPager f52671i;
    public TextView i0;
    public boolean i1;
    public VideoPbFragmentAdapter j;
    public ImageView j0;
    public View.OnTouchListener j1;
    public View k;
    public ImageView k0;
    public GestureDetector k1;
    public View l;
    public ImageView l0;
    public GestureDetector.SimpleOnGestureListener l1;
    public final View.OnClickListener listener;
    public VideoContainerLayout m;
    public b.a.r0.k2.z.i m0;
    public Runnable m1;
    public AppBarLayout mAppBarLayout;
    public View mBackButton;
    public b.a.r0.k2.u.f.u0 mContentProcessController;
    public b.a.r0.k2.y.g.a mDialogController;
    public b.a.r0.k0.b mDragActionManager;
    public View mMore;
    public NavigationBar mNavigationBar;
    public NewWriteModel.g mOnFloorPostWriteNewCallback;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public View mStatusBar;
    public View mStatusBarBackground;
    public b.a.r0.k2.y.e n;
    public TextView n0;
    public ObjectAnimator n1;
    public ImageView o;
    public TextView o0;
    public ObjectAnimator o1;
    public SortSwitchButton.f onSwitchChangeListener;
    public b.a.r0.k2.y.k.a operableVideoContainer;
    public ImageView p;
    public b2 p0;
    public final b.a.e.a.e p1;
    public b.a.r0.a0.a q;
    public String q0;
    public View.OnTouchListener q1;
    public boolean r;
    public boolean r0;
    public final b.InterfaceC0942b r1;
    public View s;
    public String s0;
    public b.a.q0.x.x.c s1;
    public b.a.r0.k2.y.i.a t;
    public boolean t0;
    public View.OnClickListener t1;
    public View u;
    public boolean u0;
    public final AdapterView.OnItemClickListener u1;
    public View v;
    public boolean v0;
    public CustomMessageListener v1;
    public View w;
    public boolean w0;
    public CustomMessageListener w1;
    public MaskView x;
    public b.a.r0.x0.q2.a.c x0;
    public CustomMessageListener x1;
    public View.OnClickListener y;
    public b.a.r0.x0.q2.a.c y0;
    public final ItemCardHelper.c y1;
    public TextView z;
    public PermissionJudgePolicy z0;
    public CustomMessageListener z1;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52672a;

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
            this.f52672a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f52672a.L0) {
                return;
            }
            this.f52672a.R1();
        }
    }

    /* loaded from: classes9.dex */
    public class a0 implements b.a.q0.d1.q<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f52673a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f52674b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52675c;

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
            this.f52675c = absVideoPbFragment;
            this.f52673a = i2;
            this.f52674b = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.f52673a);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f52675c.getContext(), this.f52674b, shareItem, false));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a1 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52676a;

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
            this.f52676a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                b.a.r0.k2.y.g.a aVar = this.f52676a.mDialogController;
                if (aVar != null) {
                    aVar.F();
                }
                boolean z = false;
                if (!b.a.e.e.p.j.z()) {
                    this.f52676a.showToast(b.a.r0.k2.l.network_not_available);
                    return false;
                }
                if (this.f52676a.getPbModel() != null && !this.f52676a.getPbModel().isLoading) {
                    this.f52676a.stopVoice();
                    this.f52676a.setPreLoad();
                    z = true;
                    if (this.f52676a.getPbModel().P0() != null && this.f52676a.getPbModel().P0().f18762f != null && this.f52676a.getPbModel().P0().f18762f.size() > i2) {
                        int intValue = this.f52676a.getPbModel().P0().f18762f.get(i2).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.f52676a.getPbModel().g1()).param("fid", this.f52676a.getPbModel().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.f52676a.getPbModel().v2(intValue)) {
                            this.f52676a.I = true;
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

    /* loaded from: classes9.dex */
    public class a2 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52677a;

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
            this.f52677a = absVideoPbFragment;
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
                this.f52677a.refreshWrite((b.a.r0.k2.r.s) oVar.a());
            } else if (type == 1) {
                this.f52677a.g1((ForumManageModel.b) oVar.a(), false);
            } else if (type != 2) {
            } else {
                if (oVar.a() == null) {
                    this.f52677a.refreshMark(false, null);
                } else {
                    this.f52677a.refreshMark(true, (MarkData) oVar.a());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52678a;

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
            this.f52678a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f52678a.d2();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52679e;

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
            this.f52679e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue() : false;
            b.a.r0.k2.y.g.a aVar = this.f52679e.mDialogController;
            if (aVar != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(b.a.r0.k2.i.tag_from, 1);
                        this.f52679e.mDialogController.B(sparseArray);
                        return;
                    }
                    aVar.l0(view);
                } else if (booleanValue2) {
                    sparseArray.put(b.a.r0.k2.i.tag_from, 0);
                    sparseArray.put(b.a.r0.k2.i.tag_check_mute_from, 1);
                    this.f52679e.mDialogController.B(sparseArray);
                } else if (booleanValue3) {
                    aVar.g0(((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52680a;

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
            this.f52680a = absVideoPbFragment;
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
                if (this.f52680a.B0 != null && this.f52680a.B0.a() != null) {
                    this.f52680a.B0.a().sendAction(new b.a.q0.x.a(45, 27, null));
                }
                this.f52680a.clickCommentReply();
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
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52683a;

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
            this.f52683a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.f52683a.getView() != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.f52683a;
                    absVideoPbFragment.hideLoadingView(absVideoPbFragment.getView());
                    this.f52683a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            new BdTopToast(this.f52683a.getContext()).setIcon(true).setContent(this.f52683a.getString(b.a.r0.k2.l.block_user_success)).show((ViewGroup) this.f52683a.getView());
                            this.f52683a.L1(type);
                            return;
                        }
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = this.f52683a.getResources().getString(b.a.r0.k2.l.neterror);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        new BdTopToast(this.f52683a.getContext()).setIcon(false).setContent(errorString).show((ViewGroup) this.f52683a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c0 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52684e;

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
            this.f52684e = absVideoPbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f52684e.getPbModel() == null || this.f52684e.getPbModel().Y0() == i2 + 1) {
                return;
            }
            AbsVideoPbFragment absVideoPbFragment = this.f52684e;
            absVideoPbFragment.J1(absVideoPbFragment.l1(i2));
        }
    }

    /* loaded from: classes9.dex */
    public class c1 implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52685a;

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
            this.f52685a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(b.a.r0.k2.r.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, b.a.r0.k2.r.f fVar, String str, int i5) {
            String replyHint;
            b.a.q0.x.h findLauncherById;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) {
                this.f52685a.setPostPro();
                this.f52685a.hideProgressView();
                if (this.f52685a.I) {
                    this.f52685a.I = false;
                }
                this.f52685a.showCommonView(false);
                if (z && fVar != null) {
                    d2 O = fVar.O();
                    ((VideoPbViewModel) ViewModelProviders.of(this.f52685a.getActivity()).get(VideoPbViewModel.class)).setData(fVar, i3);
                    this.f52685a.F1(fVar);
                    this.f52685a.P1(fVar);
                    this.f52685a.refreshTabText(fVar);
                    this.f52685a.refreshAll(z, i2, i3, i4, fVar, str, i5);
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.U().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.U().getBimg_end_time());
                    if (fVar.F() != null && fVar.F().size() >= 1 && fVar.F().get(0) != null) {
                        this.f52685a.getPbModel().c2(fVar.F().get(0).G());
                    } else if (fVar.W() != null) {
                        this.f52685a.getPbModel().c2(fVar.W().G());
                    }
                    if (this.f52685a.L != null) {
                        this.f52685a.L.h(fVar.r());
                    }
                    AntiData d2 = fVar.d();
                    if (d2 != null) {
                        this.f52685a.s0 = d2.getVoice_message();
                        if (!StringUtils.isNull(this.f52685a.s0) && this.f52685a.B0 != null && this.f52685a.B0.a() != null && (findLauncherById = this.f52685a.B0.a().findLauncherById(6)) != null && !TextUtils.isEmpty(this.f52685a.s0)) {
                            ((View) findLauncherById).setOnClickListener(this.f52685a.c1);
                        }
                    }
                    if (this.f52685a.mReplyPrivacyController != null && O != null && O.J() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.J());
                        this.f52685a.mReplyPrivacyController.setLikeUserData(attentionHostData);
                    }
                    this.f52685a.initRightFloatLayerView(fVar);
                    if (this.f52685a.getPbModel() != null && this.f52685a.getPbModel().r1()) {
                        replyHint = this.f52685a.getPageContext().getString(b.a.r0.k2.l.pb_reply_hint_from_smart_frs);
                    } else {
                        replyHint = this.f52685a.getReplyHint();
                    }
                    if (!StringUtils.isNull(replyHint)) {
                        this.f52685a.B0.l0(TbSingleton.getInstance().getAdVertiComment(fVar.k0(), fVar.l0(), replyHint));
                    }
                } else {
                    if (i2 == 4 || i2 == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.f52685a.getPbModel().f1());
                            jSONObject.put("fid", this.f52685a.getPbModel().getForumId());
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
                    if ((this.f52685a.isShowDoubleTab() && this.f52685a.getReplyFragment() == null) || this.f52685a.getDetailInfoAndReplyFragment() == null) {
                        return;
                    }
                    ArrayList<PostData> arrayList = null;
                    if (this.f52685a.isShowDoubleTab()) {
                        if (i2 != -1) {
                            if (this.f52685a.getPbModel() != null && this.f52685a.getPbModel().P0() != null) {
                                arrayList = this.f52685a.getPbModel().P0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f52685a.getReplyFragment().setEndText(this.f52685a.getResources().getString(b.a.r0.k2.l.list_no_more_new));
                            } else if (this.f52685a.getReplyFragment().isHostOnlyMode()) {
                                this.f52685a.getReplyFragment().setEndTextWithNoData(this.f52685a.getResources().getString(b.a.r0.k2.l.pb_no_host_reply));
                            } else {
                                this.f52685a.getReplyFragment().setEndTextWithNoData(this.f52685a.getResources().getString(b.a.r0.k2.l.pb_no_replay));
                            }
                        } else {
                            this.f52685a.getReplyFragment().setEndText("");
                        }
                        this.f52685a.getReplyFragment().endLoadData();
                    } else {
                        if (i2 != -1) {
                            if (this.f52685a.getPbModel() != null && this.f52685a.getPbModel().P0() != null) {
                                arrayList = this.f52685a.getPbModel().P0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f52685a.getDetailInfoAndReplyFragment().setEndText(this.f52685a.getResources().getString(b.a.r0.k2.l.list_no_more_new));
                            } else if (this.f52685a.getDetailInfoAndReplyFragment().isHostOnlyMode()) {
                                this.f52685a.getDetailInfoAndReplyFragment().setEndTextWithNoData(this.f52685a.getResources().getString(b.a.r0.k2.l.pb_no_host_reply));
                            } else {
                                this.f52685a.getDetailInfoAndReplyFragment().setEndTextWithNoData(this.f52685a.getResources().getString(b.a.r0.k2.l.pb_no_replay));
                            }
                        } else {
                            this.f52685a.getDetailInfoAndReplyFragment().setEndText("");
                        }
                        this.f52685a.getDetailInfoAndReplyFragment().endLoadData();
                    }
                }
                b.a.r0.k3.c.g().h(this.f52685a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52686a;

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
            this.f52686a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f52686a.mDialogController != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.r0.w3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f52686a.mDialogController.D) {
                b.a.r0.w3.a aVar = (b.a.r0.w3.a) customResponsedMessage.getData();
                this.f52686a.mDialogController.V();
                SparseArray<Object> sparseArray = (SparseArray) this.f52686a.mDialogController.O();
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
                    this.f52686a.mDialogController.E0(r2, sparseArray);
                } else if (intValue == 1) {
                    this.f52686a.mDialogController.k0(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52687a;

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
            this.f52687a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                b.a.q0.f1.n.f.c(this.f52687a.getPageContext(), this.f52687a, aVar.f12438a, aVar.f12439b, aVar.f12440c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52688a;

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
            this.f52688a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f52688a.mDialogController == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            b.a.r0.k2.y.g.a aVar = this.f52688a.mDialogController;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                b.a.r0.k2.r.f P0 = this.f52688a.getPbModel().P0();
                if (P0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    P0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.f52688a.K.c(this.f52688a.getResources().getString(b.a.r0.k2.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f52688a.getResources().getString(b.a.r0.k2.l.mute_error_beyond_limit);
                    }
                    this.f52688a.mDialogController.K0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.f52688a.mDialogController.D0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (b.a.e.e.p.k.isEmpty(errorString2)) {
                        errorString2 = this.f52688a.getResources().getString(b.a.r0.k2.l.mute_fail);
                    }
                    this.f52688a.K.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52689a;

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
            this.f52689a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.a.r0.l3.j0.e eVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof b.a.r0.l3.j0.e) || (eVar = (b.a.r0.l3.j0.e) customResponsedMessage.getData()) == null || (agreeData = eVar.f20602b) == null || agreeData.agreeType != 2 || this.f52689a.m0 == null || this.f52689a.getPbModel() == null || !b.a.q0.b.d.T() || b.a.r0.k2.u.f.f1.b.k(this.f52689a.getPbModel().f1())) {
                return;
            }
            this.f52689a.m0.m(2);
            b.a.r0.k2.u.f.f1.b.b(this.f52689a.getPbModel().f1());
        }
    }

    /* loaded from: classes9.dex */
    public class e1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52690e;

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
            this.f52690e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52690e.resetCommentView();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52691a;

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
            this.f52691a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f52691a.mDialogController == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            b.a.r0.k2.y.g.a aVar = this.f52691a.mDialogController;
            if (tag == aVar.D) {
                aVar.V();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.f52691a.K.c(this.f52691a.getResources().getString(b.a.r0.k2.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (b.a.e.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = this.f52691a.getResources().getString(b.a.r0.k2.l.un_mute_fail);
                }
                this.f52691a.K.b(muteMessage);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f0 implements Observer<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52692e;

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
            this.f52692e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable d2 d2Var) {
            b.a.r0.k2.y.k.a aVar;
            BdTypeRecyclerView recyclerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || d2Var == null || d2Var.q1() == null || (aVar = this.f52692e.operableVideoContainer) == null) {
                return;
            }
            if (aVar.f0() != null && this.f52692e.operableVideoContainer.f0().equals(d2Var.q1().video_url)) {
                this.f52692e.operableVideoContainer.setData(d2Var);
                return;
            }
            if (!b.a.e.e.p.k.isEmpty(this.f52692e.operableVideoContainer.f0())) {
                this.f52692e.w0 = true;
                if (this.f52692e.isShowDoubleTab()) {
                    this.f52692e.f52671i.setCurrentItem(0);
                } else {
                    this.f52692e.f52671i.setCurrentItem(0);
                }
                if (!this.f52692e.isShowDoubleTab() && (recyclerView = this.f52692e.getRecyclerView()) != null) {
                    recyclerView.scrollToPosition(0);
                }
            }
            if (this.f52692e.n == null || !this.f52692e.n.k()) {
                this.f52692e.H1();
                this.f52692e.a1(d2Var);
            }
            this.f52692e.v1();
            if (this.f52692e.n != null && this.f52692e.n.l()) {
                this.f52692e.n.s();
            }
            boolean z = !StringHelper.equals(this.f52692e.operableVideoContainer.f0(), d2Var.q1().video_url);
            this.f52692e.operableVideoContainer.setData(d2Var);
            if (this.f52692e.isShowDoubleTab()) {
                AbsVideoPbFragment absVideoPbFragment = this.f52692e;
                absVideoPbFragment.operableVideoContainer.U0(absVideoPbFragment.f52671i.getCurrentItem() == 0);
            } else {
                this.f52692e.operableVideoContainer.U0(false);
            }
            if (z) {
                this.f52692e.operableVideoContainer.startPlay();
                this.f52692e.operableVideoContainer.x0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f1 implements b.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52693e;

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
            this.f52693e = absVideoPbFragment;
        }

        @Override // b.a.q0.x.b
        public void onAction(b.a.q0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f14197c;
                if (obj instanceof b.a.q0.t.c.w) {
                    if (((b.a.q0.t.c.w) obj).getType() == EmotionGroupType.BIG_EMOTION || ((b.a.q0.t.c.w) aVar.f14197c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.f52693e.z0 == null) {
                            this.f52693e.z0 = new PermissionJudgePolicy();
                        }
                        this.f52693e.z0.clearRequestPermissionList();
                        this.f52693e.z0.appendRequestPermission(this.f52693e.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f52693e.z0.startRequestPermission(this.f52693e.getBaseFragmentActivity())) {
                            return;
                        }
                        this.f52693e.B0.h((b.a.q0.t.c.w) aVar.f14197c);
                        this.f52693e.B0.A(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements b.a.q0.x.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52694a;

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
            this.f52694a = absVideoPbFragment;
        }

        @Override // b.a.q0.x.x.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.r0.k2.u.f.u0 u0Var = this.f52694a.mContentProcessController;
                if (u0Var == null || u0Var.g() == null || !this.f52694a.mContentProcessController.g().d()) {
                    return !this.f52694a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                AbsVideoPbFragment absVideoPbFragment = this.f52694a;
                absVideoPbFragment.showToast(absVideoPbFragment.mContentProcessController.g().c());
                if (this.f52694a.D0 != null && this.f52694a.D0.b() != null && this.f52694a.D0.b().x()) {
                    this.f52694a.D0.b().v(this.f52694a.mContentProcessController.h());
                }
                this.f52694a.mContentProcessController.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.k2.r.f f52695e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.t.c.g f52696f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52697g;

        public g0(AbsVideoPbFragment absVideoPbFragment, b.a.r0.k2.r.f fVar, b.a.q0.t.c.g gVar) {
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
            this.f52697g = absVideoPbFragment;
            this.f52695e = fVar;
            this.f52696f = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52695e == null || this.f52696f == null || this.f52697g.O0 == null) {
                return;
            }
            this.f52697g.O0.doLink(this.f52696f);
            this.f52697g.O0.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes9.dex */
    public class g1 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52698e;

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
            this.f52698e = absVideoPbFragment;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            b.a.r0.k2.u.f.u0 u0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f52698e.mContentProcessController) == null || u0Var.e() == null) {
                return;
            }
            if (!this.f52698e.mContentProcessController.e().e()) {
                this.f52698e.mContentProcessController.a(false);
            }
            this.f52698e.mContentProcessController.e().l(false);
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
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) != null) || this.f52698e.C0 == null || this.f52698e.C0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2) || TextUtils.isEmpty(charSequence.toString().substring(i2, i5))) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52699a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f52700e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f52701f;

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
                this.f52701f = hVar;
                this.f52700e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postWriteCallBackData = this.f52700e) == null) {
                    return;
                }
                this.f52701f.f52699a.performFallingRedpacket(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes9.dex */
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
            public final /* synthetic */ h f52702e;

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
                this.f52702e = hVar;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f52702e.f52699a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f52702e.f52699a.getActivity(), 0, 26, 2)));
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
            this.f52699a = absVideoPbFragment;
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
                    if (this.f52699a.getPbModel() != null && this.f52699a.getPbModel().P0() != null) {
                        statisticItem.param("fid", this.f52699a.getPbModel().P0().m());
                    }
                    statisticItem.param("tid", this.f52699a.getPbModel().f1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.f52699a.stopVoice();
                this.f52699a.setPostPostWrite(z, postWriteCallBackData);
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
                        this.f52699a.showToast(str);
                        if (this.f52699a.B0.C() || this.f52699a.B0.E()) {
                            this.f52699a.B0.A(false, postWriteCallBackData);
                        }
                        this.f52699a.mContentProcessController.k(postWriteCallBackData);
                        return;
                    } else if (i2 == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.f52699a.mReplyPrivacyController;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (b.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.makeText(this.f52699a.getActivity(), this.f52699a.getActivity().getString(b.a.r0.k2.l.current_links_too_much_please_modify_and_publish), null).show();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.makeText(this.f52699a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                            return;
                        }
                    } else if (postWriteCallBackData == null || !postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        if (m0Var != null || i2 == 227001) {
                            return;
                        }
                        this.f52699a.N1(i2, antiData, str);
                        return;
                    } else {
                        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f52699a.getActivity());
                        if (b.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                            aVar.setMessage(this.f52699a.getActivity().getString(b.a.r0.k2.l.open_member_and_add_more_links));
                        } else {
                            aVar.setMessage(postWriteCallBackData.getErrorString());
                        }
                        aVar.setNegativeButton(b.a.r0.k2.l.cancel, new b(this));
                        aVar.setPositiveButton(b.a.r0.k2.l.open_now, new c(this));
                        aVar.create(this.f52699a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    }
                }
                if (PbReplySwitch.getInOn() && this.f52699a.getPbModel() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    this.f52699a.getPbModel().Y(postWriteCallBackData.getPostId());
                    if (this.f52699a.isShowDoubleTab() && this.f52699a.getReplyFragment() != null) {
                        AbsVideoPbFragment absVideoPbFragment = this.f52699a;
                        absVideoPbFragment.J0 = absVideoPbFragment.getReplyFragment().getFirstItem();
                        AbsVideoPbFragment absVideoPbFragment2 = this.f52699a;
                        absVideoPbFragment2.K0 = absVideoPbFragment2.getReplyFragment().getFirstItemOffset();
                        this.f52699a.getPbModel().b2(this.f52699a.J0, this.f52699a.K0);
                    } else if (this.f52699a.getDetailInfoAndReplyFragment() != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.f52699a;
                        absVideoPbFragment3.J0 = absVideoPbFragment3.getDetailInfoAndReplyFragment().getFirstItem();
                        AbsVideoPbFragment absVideoPbFragment4 = this.f52699a;
                        absVideoPbFragment4.K0 = absVideoPbFragment4.getDetailInfoAndReplyFragment().getFirstItemOffset();
                        this.f52699a.getPbModel().b2(this.f52699a.J0, this.f52699a.K0);
                    }
                }
                if (this.f52699a.f52671i != null) {
                    if (this.f52699a.isShowDoubleTab()) {
                        this.f52699a.f52671i.setCurrentItem(1);
                    } else {
                        this.f52699a.f52671i.setCurrentItem(0);
                    }
                }
                this.f52699a.mDialogController.F();
                this.f52699a.mContentProcessController.c();
                if (this.f52699a.B0 != null) {
                    AbsVideoPbFragment absVideoPbFragment5 = this.f52699a;
                    absVideoPbFragment5.setHasDraft(absVideoPbFragment5.B0.D());
                }
                this.f52699a.hideEditTool();
                this.f52699a.showCommonView(true);
                this.f52699a.getPbModel().o1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.f52699a.O1(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.f52699a.getPbModel().t0()) {
                        b.a.r0.k2.r.f P0 = this.f52699a.getPbModel().P0();
                        if (P0 != null && P0.O() != null && P0.O().J() != null && (userId = P0.O().J().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.f52699a.getPbModel().s2()) {
                            this.f52699a.setPreLoad();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.f52699a.getPbModel().s2()) {
                        this.f52699a.setPreLoad();
                    }
                } else if (floor != null) {
                    if (this.f52699a.isShowDoubleTab() && this.f52699a.getReplyFragment() != null) {
                        this.f52699a.getReplyFragment().invalidataData();
                    } else if (this.f52699a.getDetailInfoAndReplyFragment() != null) {
                        this.f52699a.getDetailInfoAndReplyFragment().invalidataData();
                    }
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    b.a.e.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                AbsVideoPbFragment absVideoPbFragment6 = this.f52699a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                absVideoPbFragment6.Z0(z2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h0 implements Observer<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52703e;

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
            this.f52703e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                this.f52703e.f52671i.setCurrentItem(num.intValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52704e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f52705f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52706g;

        /* loaded from: classes9.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h1 f52707e;

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
                this.f52707e = h1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.a.r0.k2.u.f.u0 u0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f52707e.f52706g.mContentProcessController) == null || u0Var.g() == null) {
                    return;
                }
                if (!this.f52707e.f52706g.mContentProcessController.g().e()) {
                    this.f52707e.f52706g.mContentProcessController.b(false);
                }
                this.f52707e.f52706g.mContentProcessController.g().l(false);
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
            this.f52706g = absVideoPbFragment;
            this.f52704e = str;
            this.f52705f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = b.a.e.e.p.l.i(this.f52706g.f52667e.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = b.a.e.e.p.l.g(this.f52706g.getPageContext().getPageActivity(), b.a.r0.k2.g.tbds256);
                } else {
                    i2 = i3 / 2;
                    g2 = b.a.e.e.p.l.g(this.f52706g.getPageContext().getPageActivity(), b.a.r0.k2.g.tbds256);
                }
                int i4 = i3 - (i2 + g2);
                AbsVideoPbFragment absVideoPbFragment = this.f52706g;
                boolean z = true;
                int i5 = (absVideoPbFragment.F0[1] + absVideoPbFragment.G0) - i4;
                if (absVideoPbFragment.getRecyclerView() != null) {
                    this.f52706g.getRecyclerView().smoothScrollBy(0, i5);
                }
                if (this.f52706g.D0 != null) {
                    this.f52706g.B0.a().setVisibility(8);
                    this.f52706g.D0.n(this.f52704e, this.f52705f, this.f52706g.getReplyHint(), (this.f52706g.getPbModel() == null || this.f52706g.getPbModel().P0() == null || this.f52706g.getPbModel().P0().O() == null || !this.f52706g.getPbModel().P0().O().Q1()) ? false : false);
                    b.a.q0.x.x.h b2 = this.f52706g.D0.b();
                    if (b2 != null && this.f52706g.getPbModel() != null && this.f52706g.getPbModel().P0() != null) {
                        b2.G(this.f52706g.getPbModel().P0().d());
                        b2.b0(this.f52706g.getPbModel().P0().O());
                    }
                    if (this.f52706g.mContentProcessController.f() == null && this.f52706g.D0.b().t() != null) {
                        this.f52706g.D0.b().t().f(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.f52706g;
                        absVideoPbFragment2.mContentProcessController.n(absVideoPbFragment2.D0.b().t().h());
                        this.f52706g.D0.b().M(this.f52706g.a1);
                    }
                }
                this.f52706g.hideCommonView();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52708e;

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
            this.f52708e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.f52708e;
                absVideoPbFragment.showToast(absVideoPbFragment.s0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i0 implements Observer<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52709e;

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
            this.f52709e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable d2 d2Var) {
            b.a.r0.k2.y.k.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || (aVar = this.f52709e.operableVideoContainer) == null) {
                return;
            }
            aVar.X0(d2Var);
        }
    }

    /* loaded from: classes9.dex */
    public class i1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52710a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f52711b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52712c;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i1 f52713e;

            /* renamed from: com.baidu.tieba.pb.videopb.AbsVideoPbFragment$i1$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C1755a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f52714e;

                public C1755a(a aVar) {
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
                    this.f52714e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    b.a.r0.k2.u.f.u0 u0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (u0Var = this.f52714e.f52713e.f52712c.mContentProcessController) == null || u0Var.g() == null) {
                        return;
                    }
                    if (!this.f52714e.f52713e.f52712c.mContentProcessController.g().e()) {
                        this.f52714e.f52713e.f52712c.mContentProcessController.b(false);
                    }
                    this.f52714e.f52713e.f52712c.mContentProcessController.g().l(false);
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
                this.f52713e = i1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int g2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = b.a.e.e.p.l.i(this.f52713e.f52712c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g2 = b.a.e.e.p.l.g(this.f52713e.f52712c.getPageContext().getPageActivity(), b.a.r0.k2.g.tbds256);
                    } else {
                        i2 = i3 / 2;
                        g2 = b.a.e.e.p.l.g(this.f52713e.f52712c.getPageContext().getPageActivity(), b.a.r0.k2.g.tbds256);
                    }
                    int i4 = i3 - (i2 + g2);
                    AbsVideoPbFragment absVideoPbFragment = this.f52713e.f52712c;
                    boolean z = true;
                    int i5 = (absVideoPbFragment.F0[1] + absVideoPbFragment.G0) - i4;
                    if (absVideoPbFragment.getRecyclerView() != null) {
                        this.f52713e.f52712c.getRecyclerView().smoothScrollBy(0, i5);
                    }
                    if (this.f52713e.f52712c.D0 != null) {
                        this.f52713e.f52712c.B0.a().setVisibility(8);
                        z = (this.f52713e.f52712c.getPbModel() == null || this.f52713e.f52712c.getPbModel().P0() == null || this.f52713e.f52712c.getPbModel().P0().O() == null || !this.f52713e.f52712c.getPbModel().P0().O().Q1()) ? false : false;
                        b.a.r0.k2.u.f.t tVar = this.f52713e.f52712c.D0;
                        i1 i1Var = this.f52713e;
                        tVar.n(i1Var.f52710a, i1Var.f52711b, i1Var.f52712c.getReplyHint(), z);
                        b.a.q0.x.x.h b2 = this.f52713e.f52712c.D0.b();
                        if (b2 != null && this.f52713e.f52712c.getPbModel() != null && this.f52713e.f52712c.getPbModel().P0() != null) {
                            b2.G(this.f52713e.f52712c.getPbModel().P0().d());
                            b2.b0(this.f52713e.f52712c.getPbModel().P0().O());
                        }
                        if (this.f52713e.f52712c.mContentProcessController.f() == null && this.f52713e.f52712c.D0.b().t() != null) {
                            this.f52713e.f52712c.D0.b().t().f(new C1755a(this));
                            AbsVideoPbFragment absVideoPbFragment2 = this.f52713e.f52712c;
                            absVideoPbFragment2.mContentProcessController.n(absVideoPbFragment2.D0.b().t().h());
                            this.f52713e.f52712c.D0.b().M(this.f52713e.f52712c.a1);
                        }
                    }
                    this.f52713e.f52712c.hideCommonView();
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
            this.f52712c = absVideoPbFragment;
            this.f52710a = str;
            this.f52711b = str2;
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
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52715a;

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
            this.f52715a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f52715a.B0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.f52715a;
                absVideoPbFragment.setHasDraft(absVideoPbFragment.B0.D());
            }
            this.f52715a.showCommonView(false);
        }
    }

    /* loaded from: classes9.dex */
    public class j0 implements Observer<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52716e;

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
            this.f52716e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable d2 d2Var) {
            b.a.r0.k2.y.k.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || (aVar = this.f52716e.operableVideoContainer) == null) {
                return;
            }
            aVar.W0(d2Var);
        }
    }

    /* loaded from: classes9.dex */
    public class j1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52717e;

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
            this.f52717e = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f52717e.t == null || this.f52717e.t.q()) {
                    if (this.f52717e.t != null && this.f52717e.getPbModel() != null && this.f52717e.getPbModel().P0() != null && this.f52717e.getPbModel().P0().l() != null) {
                        TiebaStatic.log(new StatisticItem("c13712").param("fid", this.f52717e.getPbModel().P0().l().getId()).param("fname", this.f52717e.getPbModel().P0().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f52717e.getPbModel().P0().Q()).param("obj_param1", this.f52717e.t.o));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13608").param("obj_id", this.f52717e.t.getTitle()).param("obj_name", this.f52717e.t.p()).param("obj_type", 2).param("fid", this.f52717e.getPbModel().P0().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f52717e.getPbModel().P0().Q()));
                }
                this.f52717e.T1();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52718e;

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
            this.f52718e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f52718e.t == null || this.f52718e.t.q()) {
                    if (this.f52718e.t != null) {
                        if (!this.f52718e.t.l) {
                            if (this.f52718e.t.q != null) {
                                YYLiveUtil.jumpToYYLiveRoom(this.f52718e.getPageContext(), this.f52718e.t.q.mSid, this.f52718e.t.q.mSsid, this.f52718e.t.q.mTemplateId, "", YYLiveUtil.SOURCE_PB_LIVE_BANNER);
                            }
                        } else {
                            AbsVideoPbFragment absVideoPbFragment = this.f52718e;
                            absVideoPbFragment.x1(absVideoPbFragment.t.n, this.f52718e.t.m);
                        }
                        if (this.f52718e.getPbModel() == null || this.f52718e.getPbModel().P0() == null || this.f52718e.getPbModel().P0().l() == null) {
                            return;
                        }
                        StatisticItem param = new StatisticItem("c13713").param("fid", this.f52718e.getPbModel().P0().l().getId()).param("fname", this.f52718e.getPbModel().P0().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f52718e.getPbModel().P0().Q()).param("obj_param1", this.f52718e.t.o);
                        if (this.f52718e.getPbModel().P0().O() != null) {
                            d2 O = this.f52718e.getPbModel().P0().O();
                            int calculateLiveType = YYLiveUtil.calculateLiveType(O.l1());
                            AlaInfoData l1 = O.l1();
                            String str = TiebaStatic.YYValues.YY_LIVE;
                            if (l1 == null || !O.l1().isLegalYYLiveData()) {
                                if (this.f52718e.t.q != null) {
                                    TiebaStaticHelper.addYYParam(param, this.f52718e.t.q);
                                    calculateLiveType = YYLiveUtil.calculateLiveType(this.f52718e.t.q);
                                } else {
                                    str = "";
                                }
                            } else {
                                TiebaStaticHelper.addYYParam(param, O.l1().mYyExtData);
                            }
                            param.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                            param.param(TiebaStatic.Params.OBJ_PARAM3, str);
                        }
                        TiebaStatic.log(param);
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13590").param("obj_id", this.f52718e.t.getTitle()).param("obj_name", this.f52718e.t.p()).param("obj_type", 2).param("fid", this.f52718e.getPbModel().P0().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f52718e.getPbModel().P0().Q()));
                String k = this.f52718e.t.k();
                if (TextUtils.isEmpty(k)) {
                    return;
                }
                if (!URLUtil.isHttpUrl(k) && !URLUtil.isHttpsUrl(k)) {
                    Uri parse = Uri.parse(k);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(this.f52718e.getActivity(), parse.toString());
                        return;
                    }
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f52718e.getPageContext(), new String[]{k});
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52719e;

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
            this.f52719e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f52719e.G1();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52720e;

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
            this.f52720e = absVideoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f52720e.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52721e;

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
            this.f52721e = absVideoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return this.f52721e.k1 != null && this.f52721e.k1.onTouchEvent(motionEvent);
                }
                if (this.f52721e.e1 == 1) {
                    if (!this.f52721e.i1) {
                        this.f52721e.V1();
                        UtilHelper.showStatusBar(this.f52721e.getPbActivity(), this.f52721e.getPbActivity().getRootView());
                        this.f52721e.i1 = true;
                        b.a.e.e.m.e.a().removeCallbacks(this.f52721e.m1);
                        b.a.e.e.m.e.a().postDelayed(this.f52721e.m1, 3000L);
                    }
                } else if (this.f52721e.e1 == 2 && (this.f52721e.i1 || this.f52721e.w1())) {
                    this.f52721e.U1();
                    UtilHelper.hideStatusBar(this.f52721e.getPbActivity(), this.f52721e.getPbActivity().getRootView());
                    this.f52721e.i1 = false;
                    b.a.r0.k2.y.k.a aVar = this.f52721e.operableVideoContainer;
                    if (aVar != null) {
                        aVar.V0(false);
                    }
                }
                this.f52721e.e1 = 0;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class l0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52722e;

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
            this.f52722e = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f52722e.setNavigationBarVisibility(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f52723e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52724f;

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
            this.f52724f = absVideoPbFragment;
            this.f52723e = layoutParams;
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
                this.f52724f.c2(this.f52723e);
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

    /* loaded from: classes9.dex */
    public class m extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52725e;

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
            this.f52725e = absVideoPbFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f52725e.e1 = 0;
                this.f52725e.f1 = 0.0f;
                this.f52725e.g1 = 0.0f;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            b.a.r0.k2.y.k.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f52725e.f1 += f2;
                this.f52725e.g1 += f3;
                if (this.f52725e.e1 == 0 && !this.f52725e.h1 && (aVar = this.f52725e.operableVideoContainer) != null && !aVar.isFullScreen()) {
                    int height = this.f52725e.mNavigationBar.getHeight();
                    if (motionEvent.getY() < 0.0f || Math.abs(this.f52725e.g1) <= Math.abs(this.f52725e.f1) || this.f52725e.g1 > (-height) / 5) {
                        if (Math.abs(this.f52725e.g1) > Math.abs(this.f52725e.f1) && this.f52725e.g1 > 0.0f && f3 > 0.0f) {
                            this.f52725e.e1 = 2;
                        }
                    } else {
                        this.f52725e.e1 = 1;
                    }
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class m0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbViewModel f52726e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52727f;

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
            this.f52727f = absVideoPbFragment;
            this.f52726e = videoPbViewModel;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (!b.a.q0.g1.b.c.d() && this.f52727f.isShowDoubleTab() && (this.f52726e.isJumpCommentTab() || this.f52727f.getPbModel().e1() == 1)) {
                    this.f52727f.f52671i.setCurrentItem(1);
                } else if (this.f52726e.isJumpCommentTab() || this.f52727f.getPbModel().e1() == 0) {
                    this.f52727f.f52671i.setCurrentItem(0);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (!b.a.q0.g1.b.c.d() && this.f52727f.isShowDoubleTab() && (this.f52726e.isJumpCommentTab() || this.f52727f.getPbModel().e1() == 1)) {
                    this.f52727f.f52671i.setCurrentItem(1);
                } else if (this.f52726e.isJumpCommentTab() || this.f52727f.getPbModel().e1() == 0) {
                    this.f52727f.f52671i.setCurrentItem(0);
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

    /* loaded from: classes9.dex */
    public class m1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f52728e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f52729f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f52730g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52731h;

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
            this.f52731h = absVideoPbFragment;
            this.f52728e = layoutParams;
            this.f52729f = layoutParams2;
            this.f52730g = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.B1);
                this.f52728e.height = floatValue;
                this.f52729f.height = (this.f52730g - AbsVideoPbFragment.B1) + floatValue;
                this.f52731h.s.setLayoutParams(this.f52728e);
                this.f52731h.mAppBarLayout.setLayoutParams(this.f52729f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52732e;

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
            this.f52732e = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f52732e.i1 && !this.f52732e.w1()) {
                this.f52732e.U1();
                UtilHelper.hideStatusBar(this.f52732e.getPbActivity(), this.f52732e.getPbActivity().getRootView());
                this.f52732e.i1 = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52733a;

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
            this.f52733a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.f52733a.B0.M(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.f52733a.D0 != null && this.f52733a.D0.b() != null) {
                    this.f52733a.D0.b().F();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    AbsVideoPbFragment absVideoPbFragment = this.f52733a;
                    absVideoPbFragment.I1(absVideoPbFragment.N);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n1 implements a.InterfaceC0664a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52734a;

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
            this.f52734a = absVideoPbFragment;
        }

        @Override // b.a.q0.i.a.InterfaceC0664a
        public void a(boolean z, boolean z2, String str) {
            d2 O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.f52734a.setPostPro();
                if (z && this.f52734a.getPbModel() != null) {
                    if (this.f52734a.L != null) {
                        this.f52734a.L.h(z2);
                    }
                    this.f52734a.getPbModel().r2(z2);
                    if (this.f52734a.getPbModel().P0() != null && (O = this.f52734a.getPbModel().P0().O()) != null) {
                        if (z2) {
                            O.N2++;
                        } else {
                            int i2 = O.N2;
                            if (i2 > 0) {
                                O.N2 = i2 - 1;
                            }
                        }
                    }
                    if (this.f52734a.getPbModel().B0()) {
                        this.f52734a.A1();
                    } else if (this.f52734a.isShowDoubleTab()) {
                        if (this.f52734a.getDetailInfoFragment() != null) {
                            this.f52734a.getDetailInfoFragment().invalidataData();
                        }
                        if (this.f52734a.getReplyFragment() != null) {
                            this.f52734a.getReplyFragment().invalidataData();
                        }
                    } else if (this.f52734a.getDetailInfoAndReplyFragment() != null) {
                        this.f52734a.getDetailInfoAndReplyFragment().invalidataData();
                    }
                    if (z2) {
                        if (this.f52734a.L != null) {
                            if (this.f52734a.L.f() == null || this.f52734a.getPbModel() == null || this.f52734a.getPbModel().P0() == null || this.f52734a.getPbModel().P0().O() == null || this.f52734a.getPbModel().P0().O().J() == null) {
                                return;
                            }
                            MarkData f2 = this.f52734a.L.f();
                            MetaData J = this.f52734a.getPbModel().P0().O().J();
                            if (f2 != null && J != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), J.getUserId()) && !J.hadConcerned()) {
                                    this.f52734a.mDialogController.A0(J);
                                } else {
                                    this.f52734a.showToast(b.a.r0.k2.l.add_mark_on_pb);
                                }
                            } else {
                                AbsVideoPbFragment absVideoPbFragment = this.f52734a;
                                absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(b.a.r0.k2.l.add_mark));
                            }
                        }
                        this.f52734a.Y0();
                        return;
                    }
                    AbsVideoPbFragment absVideoPbFragment2 = this.f52734a;
                    absVideoPbFragment2.showToast(absVideoPbFragment2.getPageContext().getString(b.a.r0.k2.l.remove_mark));
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.f52734a;
                absVideoPbFragment3.showToast(absVideoPbFragment3.getPageContext().getString(b.a.r0.k2.l.update_mark_failed));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52735a;

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
            this.f52735a = absVideoPbFragment;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.f52735a.getPbModel() != null) {
                    switch (this.f52735a.P.getLoadDataMode()) {
                        case 0:
                            this.f52735a.getPbModel().o1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.f52735a.g1(bVar, (bVar.f54252e != 1002 || bVar.f54253f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.f52735a.finishForumManageProcess(1, dVar.f54256a, dVar.f54257b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.f52735a;
                            absVideoPbFragment.h1(absVideoPbFragment.P.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.f52735a;
                            absVideoPbFragment2.finishForumManageProcess(absVideoPbFragment2.P.getLoadDataMode(), gVar.f54270a, gVar.f54271b, false);
                            this.f52735a.mDialogController.f0(gVar.f54272c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.f52735a;
                absVideoPbFragment3.finishForumManageProcess(absVideoPbFragment3.P.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52736a;

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
            this.f52736a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.f52736a.f52667e, this.f52736a.f52667e.getUniqueId(), (View) customResponsedMessage.getData(), this.f52736a.f52669g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52737e;

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
            this.f52737e = absVideoPbFragment;
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
                this.f52737e.s.setVisibility(8);
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

    /* loaded from: classes9.dex */
    public class p implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52738e;

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
            this.f52738e = absVideoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f52738e.mDragActionManager.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class p0 implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52739a;

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
            this.f52739a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.x(this.f52739a.f52667e, ItemCardHelper.OrderTipStatus.SUCCESS, this.f52739a.f52669g, j);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.f52739a.f52667e, ItemCardHelper.OrderTipStatus.FAIL, this.f52739a.f52669g, 0L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f52740e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f52741f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f52742g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52743h;

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
            this.f52743h = absVideoPbFragment;
            this.f52740e = layoutParams;
            this.f52741f = layoutParams2;
            this.f52742g = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.B1);
                this.f52740e.height = floatValue;
                this.f52741f.height = this.f52742g + floatValue;
                this.f52743h.s.setLayoutParams(this.f52740e);
                this.f52743h.mAppBarLayout.setLayoutParams(this.f52741f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q implements b.InterfaceC0942b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
    public class q0 implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52744e;

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
            this.f52744e = absVideoPbFragment;
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
                    if (this.f52744e.getDetailInfoAndReplyFragment() != null) {
                        this.f52744e.getDetailInfoAndReplyFragment().receiveFling(false);
                    } else if (this.f52744e.isShowDoubleTab() && this.f52744e.getReplyFragment() != null) {
                        this.f52744e.getReplyFragment().receiveFling(false);
                    }
                    if (this.f52744e.getDetailInfoFragment() != null) {
                        this.f52744e.getDetailInfoFragment().receiveFling(true);
                        AbsVideoPbFragment absVideoPbFragment = this.f52744e;
                        absVideoPbFragment.setShadowVisible(absVideoPbFragment.getDetailInfoFragment().getRecyclerViewState() == 0 ? 8 : 0);
                        this.f52744e.Y.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.f52744e.getActivity()).get(VideoPbViewModel.class);
                    z = (videoPbViewModel.getIsDetailTabTop() == null || videoPbViewModel.getIsDetailTabTop().getValue() == null || !videoPbViewModel.getIsDetailTabTop().getValue().booleanValue()) ? false : false;
                    b.a.r0.k2.y.k.a aVar = this.f52744e.operableVideoContainer;
                    if (aVar != null) {
                        aVar.U0(z);
                    }
                    this.f52744e.resetCommentView();
                    if (this.f52744e.getPbModel() != null && this.f52744e.getPbModel().P0() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.f52744e.getPbModel().f1()).param("fid", this.f52744e.getPbModel().P0().m()));
                    }
                } else {
                    if (this.f52744e.getDetailInfoFragment() != null) {
                        this.f52744e.getDetailInfoFragment().receiveFling(false);
                    }
                    if (this.f52744e.getDetailInfoAndReplyFragment() != null) {
                        this.f52744e.getDetailInfoAndReplyFragment().receiveFling(true);
                        int recyclerViewState = this.f52744e.getDetailInfoAndReplyFragment().getRecyclerViewState();
                        int multiNestedLayoutState = this.f52744e.getDetailInfoAndReplyFragment().getMultiNestedLayoutState();
                        if (recyclerViewState != 0) {
                            this.f52744e.setShadowVisible(8);
                            this.f52744e.getDetailInfoAndReplyFragment().setShadowVisible(0);
                        } else if (multiNestedLayoutState != 0) {
                            this.f52744e.getDetailInfoAndReplyFragment().setShadowVisible(8);
                            this.f52744e.setShadowVisible(0);
                        } else {
                            this.f52744e.getDetailInfoAndReplyFragment().setShadowVisible(8);
                            this.f52744e.setShadowVisible(8);
                        }
                    } else if (this.f52744e.getReplyFragment() != null) {
                        this.f52744e.getReplyFragment().receiveFling(true);
                        int recyclerViewState2 = this.f52744e.getReplyFragment().getRecyclerViewState();
                        int multiNestedLayoutState2 = this.f52744e.getReplyFragment().getMultiNestedLayoutState();
                        if (recyclerViewState2 != 0) {
                            this.f52744e.setShadowVisible(8);
                            this.f52744e.getReplyFragment().setShadowVisible(0);
                        } else if (multiNestedLayoutState2 != 0) {
                            this.f52744e.getReplyFragment().setShadowVisible(8);
                            this.f52744e.setShadowVisible(0);
                        } else {
                            this.f52744e.getReplyFragment().setShadowVisible(8);
                            this.f52744e.setShadowVisible(8);
                        }
                        this.f52744e.Y.setVisibility(0);
                    }
                    b.a.r0.k2.y.k.a aVar2 = this.f52744e.operableVideoContainer;
                    if (aVar2 != null) {
                        aVar2.U0(false);
                    }
                    this.f52744e.mAppBarLayout.setExpanded(false, true);
                    if (this.f52744e.getPbModel() != null && this.f52744e.getPbModel().P0() != null) {
                        TiebaStatic.log(new StatisticItem("c13593").param("tid", this.f52744e.getPbModel().f1()).param("fid", this.f52744e.getPbModel().P0().m()));
                    }
                }
                this.f52744e.j.setItemPrimary(i2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52745e;

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
            this.f52745e = absVideoPbFragment;
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
                this.f52745e.a2();
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

    /* loaded from: classes9.dex */
    public class r implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.t.c.g f52746e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52747f;

        public r0(AbsVideoPbFragment absVideoPbFragment, b.a.q0.t.c.g gVar) {
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
            this.f52747f = absVideoPbFragment;
            this.f52746e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52747f.O0.inPbLastCloseTime();
                this.f52747f.hideRightFloatLayerView();
                this.f52747f.O0.reportClickCloseAd(this.f52746e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52748e;

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
            this.f52748e = absVideoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f52748e.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52749a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f52750e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ s f52751f;

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
                this.f52751f = sVar;
                this.f52750e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postWriteCallBackData = this.f52750e) == null) {
                    return;
                }
                this.f52751f.f52749a.performFallingRedpacket(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes9.dex */
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
            public final /* synthetic */ s f52752e;

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
                this.f52752e = sVar;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f52752e.f52749a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f52752e.f52749a.getActivity(), 0, 26, 2)));
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
            this.f52749a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, b.a.q0.t.c.m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (!b.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f52749a.getPbModel() != null && this.f52749a.getPbModel().P0() != null) {
                        statisticItem.param("fid", this.f52749a.getPbModel().P0().m());
                    }
                    if (this.f52749a.getPbModel() != null) {
                        statisticItem.param("tid", this.f52749a.getPbModel().f1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    b.a.r0.k2.u.f.u0 u0Var = this.f52749a.mContentProcessController;
                    if (u0Var != null) {
                        u0Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        b.a.q0.t.h.b.a(this.f52749a.getPageContext(), postWriteCallBackData);
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getmAdverSegmentData() == null) {
                        return;
                    }
                    b.a.e.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f52749a.mReplyPrivacyController;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (b.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.f52749a.getActivity(), this.f52749a.getActivity().getString(b.a.r0.k2.l.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.f52749a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f52749a.getActivity());
                    if (b.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f52749a.getActivity().getString(b.a.r0.k2.l.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(b.a.r0.k2.l.cancel, new b(this));
                    aVar.setPositiveButton(b.a.r0.k2.l.open_now, new c(this));
                    aVar.create(this.f52749a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment = this.f52749a;
                if (absVideoPbFragment.mContentProcessController == null) {
                    return;
                }
                if (absVideoPbFragment.D0 != null && this.f52749a.D0.b() != null && this.f52749a.D0.b().x()) {
                    this.f52749a.D0.b().v(postWriteCallBackData);
                }
                this.f52749a.mContentProcessController.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s0 implements FallingView.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52753a;

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
            this.f52753a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.l
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f52753a.O0.getTag() == this.f52753a.H) {
                this.f52753a.O0.setTag(null);
                this.f52753a.O0.setAutoCompleteShown(true);
                this.f52753a.O0.completeShow();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.l
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f52753a.O0.setAutoCompleteShown(false);
                if (this.f52753a.O0.getVisibility() == 0) {
                    this.f52753a.O0.setTag(this.f52753a.H);
                    this.f52753a.O0.completeHide();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s1 implements b.a.e.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52754a;

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
            this.f52754a = absVideoPbFragment;
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
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f52754a.getPageContext().getPageActivity());
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
    public class t implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f52755e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f52756f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f52757g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52758h;

        public t(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, b.a.q0.s.s.a aVar) {
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
            this.f52758h = absVideoPbFragment;
            this.f52755e = markData;
            this.f52756f = markData2;
            this.f52757g = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f52758h.L != null) {
                    if (this.f52758h.L.e()) {
                        this.f52758h.L.d();
                        this.f52758h.L.h(false);
                    }
                    this.f52758h.L.i(this.f52755e);
                    this.f52758h.L.h(true);
                    this.f52758h.L.a();
                }
                this.f52756f.setPostId(this.f52755e.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f52756f);
                this.f52758h.f52667e.setResult(-1, intent);
                this.f52757g.dismiss();
                this.f52758h.X1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52759e;

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
            this.f52759e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f52759e.t == null || this.f52759e.t.q()) {
                    if (this.f52759e.t != null) {
                        TiebaStatic.log(new StatisticItem("c13608").param("tid", this.f52759e.getPbModel().P0().Q()));
                        this.f52759e.t.p = true;
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13591"));
                }
                this.f52759e.S1();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t1 implements b.a.e.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52760a;

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
            this.f52760a = absVideoPbFragment;
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
                GifView gifView = new GifView(this.f52760a.getPageContext().getPageActivity());
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
    public class u implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f52761e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f52762f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52763g;

        public u(AbsVideoPbFragment absVideoPbFragment, MarkData markData, b.a.q0.s.s.a aVar) {
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
            this.f52763g = absVideoPbFragment;
            this.f52761e = markData;
            this.f52762f = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.f52761e);
                this.f52763g.f52667e.setResult(-1, intent);
                this.f52762f.dismiss();
                this.f52763g.X1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52764e;

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
            this.f52764e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new b.a.q0.s.q.t0(this.f52764e.getActivity(), "pb_huitie"))) {
                this.f52764e.expandVideo(false);
                this.f52764e.processProfessionPermission();
                if (this.f52764e.getPbModel() == null || this.f52764e.getPbModel().P0() == null || this.f52764e.getPbModel().P0().O() == null || this.f52764e.getPbModel().P0().O().J() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f52764e.getPbModel().g1()).param("fid", this.f52764e.getPbModel().P0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f52764e.getPbModel().f1()).param("fid", this.f52764e.getPbModel().P0().m()).param("obj_locate", 1).param("uid", this.f52764e.getPbModel().P0().O().J().getUserId()));
                if (this.f52764e.isCommentFloatPage()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", this.f52764e.getPbModel().getForumId());
                    statisticItem.param("tid", this.f52764e.getPbModel().f1());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", this.f52764e.k1());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 11);
                    statisticItem.param("obj_locate", this.f52764e.getFromVideoPageType());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u1 implements b.a.e.e.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52765a;

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
            this.f52765a = absVideoPbFragment;
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
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.f52765a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.f52765a.getVoiceManager());
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
    public class v implements TiePlusEventController.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52766a;

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
            this.f52766a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.d
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52766a.X = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class v0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52767a;

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
            this.f52767a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f52767a.Y.getLayoutParams();
            layoutParams.height = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds144);
            this.f52767a.Y.setLayoutParams(layoutParams);
            if (this.f52767a.isShowDoubleTab() && this.f52767a.f52670h != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f52767a.f52670h.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = AbsVideoPbFragment.C1;
                } else {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, AbsVideoPbFragment.C1);
                }
                this.f52767a.f52670h.setLayoutParams(layoutParams2);
                this.f52767a.f52671i.setScrollable(true);
            }
            this.f52767a.resetCommentView();
            if (this.f52767a.getDetailInfoFragment() != null) {
                this.f52767a.getDetailInfoFragment().invalidataData();
            }
            if (this.f52767a.getDetailInfoAndReplyFragment() != null) {
                this.f52767a.getDetailInfoAndReplyFragment().invalidataData();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class v1 implements b.a.e.e.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52768a;

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
            this.f52768a = absVideoPbFragment;
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
                LinearLayout linearLayout = new LinearLayout(this.f52768a.getPageContext().getPageActivity());
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
    public class w implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52769e;

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
            this.f52769e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52769e.hideKeyBroad();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w1 implements b.a.e.e.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52770a;

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
            this.f52770a = absVideoPbFragment;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.f52770a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class x implements b.a.q0.x.x.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52771a;

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
            this.f52771a = absVideoPbFragment;
        }

        @Override // b.a.q0.x.x.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52771a.showProgressBar();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class x0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52772e;

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
            this.f52772e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52772e.resetCommentView();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class x1 implements Comparator<b.a.q0.u.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52773e;

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
            this.f52773e = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            StatisticItem statisticItem;
            int i2;
            StatisticItem statisticItem2;
            String str;
            int top;
            int i3;
            int i4;
            String d2;
            boolean u2;
            int i5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.f52773e.isAdded()) {
                Object tag = view.getTag(b.a.r0.k2.i.tag_first);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view.setTag(b.a.r0.k2.i.tag_first, null);
                    return;
                }
                int i6 = 1;
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem3 = new StatisticItem("c13398");
                    statisticItem3.param("tid", this.f52773e.getPbModel().f1());
                    statisticItem3.param("fid", this.f52773e.getPbModel().getForumId());
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem3.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem3);
                    if (this.f52773e.isCommentFloatPage()) {
                        StatisticItem statisticItem4 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem4.param("fid", this.f52773e.getPbModel().getForumId());
                        statisticItem4.param("tid", this.f52773e.getPbModel().f1());
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("post_id", this.f52773e.k1());
                        statisticItem4.param("obj_source", 1);
                        statisticItem4.param("obj_type", 3);
                        statisticItem4.param("obj_locate", this.f52773e.getFromVideoPageType());
                        TiebaStatic.log(statisticItem4);
                    }
                    if (this.f52773e.X) {
                        this.f52773e.X = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(b.a.r0.k2.i.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (this.f52773e.getPbModel() == null || this.f52773e.getPbModel().P0() == null || this.f52773e.E0 == null || postData.t() == null || postData.A() == 1 || !this.f52773e.checkUpIsLogin()) {
                                return;
                            }
                            if (this.f52773e.D0 != null) {
                                this.f52773e.D0.c();
                            }
                            b.a.r0.k2.r.s sVar = new b.a.r0.k2.r.s();
                            sVar.A(this.f52773e.getPbModel().P0().l());
                            sVar.E(this.f52773e.getPbModel().P0().O());
                            sVar.C(postData);
                            this.f52773e.E0.S(sVar);
                            this.f52773e.E0.setPostId(postData.G());
                            this.f52773e.z1(view, postData.t().getUserId(), "", postData);
                            TiebaStatic.log("c11743");
                            b.a.r0.k2.w.a.b(this.f52773e.getPbModel().P0(), postData, postData.k0, 8, 1);
                            if (this.f52773e.B0 != null) {
                                AbsVideoPbFragment absVideoPbFragment = this.f52773e;
                                absVideoPbFragment.setHasDraft(absVideoPbFragment.B0.D());
                            }
                        }
                    }
                } else if ((this.f52773e.isShowDoubleTab() && this.f52773e.getReplyFragment() != null && this.f52773e.getReplyFragment().getNextView() != null && view == this.f52773e.getReplyFragment().getNextView()) || ((this.f52773e.getDetailInfoAndReplyFragment() != null && this.f52773e.getDetailInfoAndReplyFragment().getNextView() != null && view == this.f52773e.getDetailInfoAndReplyFragment().getNextView()) || view.getId() == b.a.r0.k2.i.pb_more)) {
                    if (!this.f52773e.I && this.f52773e.getPbModel().B1(true)) {
                        this.f52773e.I = true;
                        if (this.f52773e.isShowDoubleTab()) {
                            if (this.f52773e.getReplyFragment() != null) {
                                this.f52773e.getReplyFragment().setPreLoadNext();
                            }
                        } else if (this.f52773e.getDetailInfoAndReplyFragment() != null) {
                            this.f52773e.getDetailInfoAndReplyFragment().setPreLoadNext();
                        }
                    }
                } else {
                    b.a.r0.k2.y.g.a aVar = this.f52773e.mDialogController;
                    if (aVar != null && aVar.Q() != null && view == this.f52773e.mDialogController.Q().e()) {
                        this.f52773e.mDialogController.I();
                        return;
                    }
                    b.a.r0.k2.y.g.a aVar2 = this.f52773e.mDialogController;
                    if ((aVar2 == null || ((aVar2.Q() == null || view != this.f52773e.mDialogController.Q().i()) && view.getId() != b.a.r0.k2.i.owner_reply && view.getId() != b.a.r0.k2.i.all_reply)) && view.getId() != b.a.r0.k2.i.floor_owner_reply && view.getId() != b.a.r0.k2.i.reply_title) {
                        AbsVideoPbFragment absVideoPbFragment2 = this.f52773e;
                        if (view == absVideoPbFragment2.mBackButton) {
                            if (absVideoPbFragment2.getPbModel() == null || this.f52773e.getPbModel().P0() == null) {
                                return;
                            }
                            if (!b.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                StatisticItem statisticItem5 = new StatisticItem("c13266");
                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem5.param("fid", this.f52773e.getPbModel().P0().m());
                                statisticItem5.param("tid", this.f52773e.getPbModel().f1());
                                statisticItem5.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(statisticItem5);
                                TbadkCoreApplication.getInst().setTaskId("");
                            }
                            b.a.e.e.p.l.x(this.f52773e.f52667e, this.f52773e.mBackButton);
                            this.f52773e.f52667e.finish();
                        } else if (view == absVideoPbFragment2.mMore && absVideoPbFragment2.mDialogController != null) {
                            if (b.a.q0.d1.o.a()) {
                                return;
                            }
                            if (this.f52773e.getPbModel() != null && this.f52773e.getPbModel().P0() != null) {
                                ArrayList<PostData> F = this.f52773e.getPbModel().P0().F();
                                if ((F == null || F.size() <= 0) && this.f52773e.getPbModel().d1()) {
                                    b.a.e.e.p.l.M(this.f52773e.getPageContext().getPageActivity(), this.f52773e.getPageContext().getString(b.a.r0.k2.l.pb_no_data_tips));
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.f52773e.getPbModel().f1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f52773e.getPbModel().getForumId()));
                                this.f52773e.mDialogController.m0();
                                return;
                            }
                            b.a.e.e.p.l.M(this.f52773e.getPageContext().getPageActivity(), this.f52773e.getPageContext().getString(b.a.r0.k2.l.pb_no_data_tips));
                        } else if (this.f52773e.mDialogController.Q() != null && view == this.f52773e.mDialogController.Q().k()) {
                            if (this.f52773e.getPbModel() == null) {
                                return;
                            }
                            this.f52773e.mDialogController.F();
                            if (b.a.e.e.p.j.z()) {
                                this.f52773e.stopVoice();
                                this.f52773e.setPreLoad();
                                this.f52773e.getPbModel().p2(1);
                                return;
                            }
                            this.f52773e.showToast(b.a.r0.k2.l.network_not_available);
                        } else {
                            b.a.r0.k2.y.g.a aVar3 = this.f52773e.mDialogController;
                            if (aVar3 != null && aVar3.Q() != null && view == this.f52773e.mDialogController.Q().i()) {
                                this.f52773e.mDialogController.I();
                                return;
                            }
                            b.a.r0.k2.y.g.a aVar4 = this.f52773e.mDialogController;
                            if (aVar4 != null && ((aVar4.Q() != null && view == this.f52773e.mDialogController.Q().q()) || view.getId() == b.a.r0.k2.i.pb_sort_type || view.getId() == b.a.r0.k2.i.pb_sort)) {
                                this.f52773e.mDialogController.F();
                                if (b.a.e.e.p.j.z()) {
                                    if (!this.f52773e.I) {
                                        this.f52773e.stopVoice();
                                        this.f52773e.setPreLoad();
                                        this.f52773e.mDialogController.J0(view);
                                        return;
                                    }
                                    view.setTag(Integer.valueOf(this.f52773e.getPbModel().b1()));
                                    return;
                                }
                                this.f52773e.showToast(b.a.r0.k2.l.network_not_available);
                                return;
                            }
                            b.a.r0.k2.y.g.a aVar5 = this.f52773e.mDialogController;
                            if (aVar5 != null && aVar5.Q() != null && view == this.f52773e.mDialogController.Q().p()) {
                                if (this.f52773e.getPbModel() == null || this.f52773e.getPbModel().P0() == null || this.f52773e.getPbModel().P0().O() == null) {
                                    return;
                                }
                                this.f52773e.mDialogController.I();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment3 = this.f52773e;
                                absVideoPbFragment3.mDialogController.U(absVideoPbFragment3.getPbModel().P0().O().W());
                            } else if (view.getId() == b.a.r0.k2.i.pb_floor_feedback) {
                                try {
                                    sparseArray = (SparseArray) view.getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray = null;
                                }
                                b.a.r0.k2.y.g.a aVar6 = this.f52773e.mDialogController;
                                if (aVar6 != null) {
                                    aVar6.w0(sparseArray);
                                }
                            } else {
                                b.a.r0.k2.y.g.a aVar7 = this.f52773e.mDialogController;
                                if (aVar7 != null && aVar7.Q() != null && view == this.f52773e.mDialogController.Q().n()) {
                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                    if (skinType == 1) {
                                        this.f52773e.onChangeSkinType(skinType);
                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                    } else if (skinType == 0 || skinType == 4) {
                                        UtilHelper.showSkinChangeAnimation(this.f52773e.getActivity());
                                        this.f52773e.onChangeSkinType(skinType);
                                        UtilHelper.setNavigationBarBackground(this.f52773e.getActivity(), this.f52773e.getResources().getColor(b.a.r0.k2.f.CAM_X0201_1));
                                        TbadkCoreApplication.getInst().setSkinType(1);
                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                    }
                                    this.f52773e.mDialogController.J();
                                    return;
                                }
                                b.a.r0.k2.y.g.a aVar8 = this.f52773e.mDialogController;
                                if (aVar8 != null && aVar8.Q() != null && view == this.f52773e.mDialogController.Q().o()) {
                                    this.f52773e.mDialogController.J();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.f52773e;
                                    absVideoPbFragment4.mDialogController.G0(absVideoPbFragment4.u1);
                                    return;
                                }
                                b.a.r0.k2.y.g.a aVar9 = this.f52773e.mDialogController;
                                if (aVar9 != null && aVar9.Q() != null && view == this.f52773e.mDialogController.Q().h()) {
                                    b.a.q0.t.c.k0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (d2 = tiebaPlusConfigData.d(this.f52773e.getPbModel().f1())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.f52773e.getPageContext(), new String[]{d2});
                                    this.f52773e.mDialogController.I();
                                    b.a.q0.t.c.k0.a(3);
                                    return;
                                }
                                b.a.r0.k2.y.g.a aVar10 = this.f52773e.mDialogController;
                                if (aVar10 != null && (view == aVar10.M() || (this.f52773e.mDialogController.Q() != null && (view == this.f52773e.mDialogController.Q().l() || view == this.f52773e.mDialogController.Q().m())))) {
                                    if (!b.a.e.e.p.j.z()) {
                                        this.f52773e.showToast(b.a.r0.k2.l.network_not_available);
                                        return;
                                    } else if ((this.f52773e.getPbModel() == null && this.f52773e.getPbModel().P0() == null) || this.f52773e.P.P()) {
                                        return;
                                    } else {
                                        this.f52773e.mDialogController.F();
                                        if (this.f52773e.mDialogController.Q() != null && view == this.f52773e.mDialogController.Q().m()) {
                                            i4 = this.f52773e.getPbModel().P0().O().r0() == 1 ? 5 : 4;
                                        } else if (this.f52773e.mDialogController.Q() != null && view == this.f52773e.mDialogController.Q().l()) {
                                            i4 = this.f52773e.getPbModel().P0().O().q0() == 1 ? 3 : 6;
                                        } else {
                                            i4 = view == this.f52773e.mDialogController.M() ? 2 : 0;
                                        }
                                        ForumData l = this.f52773e.getPbModel().P0().l();
                                        String name = l.getName();
                                        String id = l.getId();
                                        String f0 = this.f52773e.getPbModel().P0().O().f0();
                                        this.f52773e.showProgressBar();
                                        this.f52773e.P.T(id, name, f0, i4, this.f52773e.mDialogController.N());
                                        return;
                                    }
                                }
                                b.a.r0.k2.y.g.a aVar11 = this.f52773e.mDialogController;
                                if (aVar11 != null && aVar11.Q() != null && view == this.f52773e.mDialogController.Q().g()) {
                                    if (this.f52773e.getPbModel() == null) {
                                        return;
                                    }
                                    if (!b.a.e.e.p.j.z()) {
                                        this.f52773e.showToast(b.a.r0.k2.l.network_not_available);
                                        return;
                                    }
                                    this.f52773e.mDialogController.F();
                                    AbsVideoPbFragment absVideoPbFragment5 = this.f52773e;
                                    SparseArray<Object> managerOrDeleteTag = absVideoPbFragment5.getManagerOrDeleteTag(absVideoPbFragment5.getPbModel().P0(), this.f52773e.getPbModel().d1(), 1);
                                    if (managerOrDeleteTag == null) {
                                        return;
                                    }
                                    this.f52773e.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f52773e.getPageContext().getPageActivity(), this.f52773e.getPbModel().P0().l().getId(), this.f52773e.getPbModel().P0().l().getName(), this.f52773e.getPbModel().P0().O().f0(), String.valueOf(this.f52773e.getPbModel().P0().U().getUserId()), (String) managerOrDeleteTag.get(b.a.r0.k2.i.tag_forbid_user_name), (String) managerOrDeleteTag.get(b.a.r0.k2.i.tag_forbid_user_name_show), (String) managerOrDeleteTag.get(b.a.r0.k2.i.tag_forbid_user_post_id), (String) managerOrDeleteTag.get(b.a.r0.k2.i.tag_forbid_user_portrait))));
                                    return;
                                }
                                b.a.r0.k2.y.g.a aVar12 = this.f52773e.mDialogController;
                                if (aVar12 != null && aVar12.Q() != null && view == this.f52773e.mDialogController.Q().c()) {
                                    if (!b.a.e.e.p.j.z()) {
                                        this.f52773e.showToast(b.a.r0.k2.l.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.f52773e;
                                    SparseArray<Object> managerOrDeleteTag2 = absVideoPbFragment6.getManagerOrDeleteTag(absVideoPbFragment6.getPbModel().P0(), this.f52773e.getPbModel().d1(), 1);
                                    if (managerOrDeleteTag2 != null) {
                                        this.f52773e.mDialogController.j0(((Integer) managerOrDeleteTag2.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) managerOrDeleteTag2.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) managerOrDeleteTag2.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) managerOrDeleteTag2.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                                    }
                                    this.f52773e.mDialogController.I();
                                    if (this.f52773e.getPbModel() == null || this.f52773e.getPbModel().P0() == null || this.f52773e.getPbModel().P0().O() == null) {
                                        return;
                                    }
                                    d2 O = this.f52773e.getPbModel().P0().O();
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
                                b.a.r0.k2.y.g.a aVar13 = this.f52773e.mDialogController;
                                if (aVar13 != null && aVar13.Q() != null && view == this.f52773e.mDialogController.Q().f()) {
                                    if (this.f52773e.getPbModel() == null) {
                                        return;
                                    }
                                    if (!b.a.e.e.p.j.z()) {
                                        this.f52773e.showToast(b.a.r0.k2.l.network_not_available);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment7 = this.f52773e;
                                    SparseArray<Object> managerOrDeleteTag3 = absVideoPbFragment7.getManagerOrDeleteTag(absVideoPbFragment7.getPbModel().P0(), this.f52773e.getPbModel().d1(), 1);
                                    if (managerOrDeleteTag3 != null) {
                                        if (StringUtils.isNull((String) managerOrDeleteTag3.get(b.a.r0.k2.i.tag_del_multi_forum))) {
                                            this.f52773e.mDialogController.g0(((Integer) managerOrDeleteTag3.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) managerOrDeleteTag3.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) managerOrDeleteTag3.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) managerOrDeleteTag3.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                                        } else {
                                            this.f52773e.mDialogController.h0(((Integer) managerOrDeleteTag3.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) managerOrDeleteTag3.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) managerOrDeleteTag3.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) managerOrDeleteTag3.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue(), (String) managerOrDeleteTag3.get(b.a.r0.k2.i.tag_del_multi_forum));
                                        }
                                    }
                                    this.f52773e.mDialogController.I();
                                } else if (view.getId() != b.a.r0.k2.i.sub_pb_more && view.getId() != b.a.r0.k2.i.sub_pb_item && view.getId() != b.a.r0.k2.i.pb_floor_reply_more && view.getId() != b.a.r0.k2.i.new_sub_pb_list_richText && view.getId() != b.a.r0.k2.i.pb_post_reply_count) {
                                    if (view.getId() != b.a.r0.k2.i.pb_post_reply && view.getId() != b.a.r0.k2.i.post_info_commont_img && view.getId() != b.a.r0.k2.i.pb_floor_comment_container) {
                                        if (view.getId() != b.a.r0.k2.i.pb_editor_tool_collection && view.getId() != b.a.r0.k2.i.collect_num_container) {
                                            if (view.getId() == b.a.r0.k2.i.pb_editor_tool_share) {
                                                this.f52773e.handleShare(true);
                                            } else if (view.getId() != b.a.r0.k2.i.pb_editor_tool_comment_icon && view.getId() != b.a.r0.k2.i.thread_info_commont_container) {
                                                if (view.getId() == b.a.r0.k2.i.tv_pb_reply_more) {
                                                    if (this.f52773e.J0 >= 0) {
                                                        if (this.f52773e.getPbModel() != null) {
                                                            this.f52773e.getPbModel().X1();
                                                        }
                                                        if (this.f52773e.isShowDoubleTab() && this.f52773e.getPbModel() != null && this.f52773e.getReplyFragment() != null && this.f52773e.getReplyFragment().getAdapterManager() != null) {
                                                            this.f52773e.getReplyFragment().getAdapterManager().f(this.f52773e.getPbModel().P0());
                                                        } else if (this.f52773e.getDetailInfoAndReplyFragment() != null && this.f52773e.getDetailInfoAndReplyFragment().getAdapterManager() != null) {
                                                            this.f52773e.getDetailInfoAndReplyFragment().getAdapterManager().q(this.f52773e.getPbModel().P0());
                                                        }
                                                        this.f52773e.J0 = 0;
                                                        this.f52773e.K0 = Integer.MIN_VALUE;
                                                        if (this.f52773e.isShowDoubleTab() && this.f52773e.getPbModel() != null && this.f52773e.getReplyFragment() != null) {
                                                            this.f52773e.getReplyFragment().scrollListView(this.f52773e.getPbModel().I0(), this.f52773e.getPbModel().H0());
                                                            this.f52773e.getPbModel().b2(0, 0);
                                                        } else if (this.f52773e.getPbModel() == null || this.f52773e.getDetailInfoAndReplyFragment() == null) {
                                                        } else {
                                                            this.f52773e.getDetailInfoAndReplyFragment().scrollListView(this.f52773e.getPbModel().I0(), this.f52773e.getPbModel().H0());
                                                            this.f52773e.getPbModel().b2(0, 0);
                                                        }
                                                    }
                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                    if (this.f52773e.getPbModel() == null) {
                                                        return;
                                                    }
                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                    statisticItem8.param("tid", this.f52773e.getPbModel().f1());
                                                    statisticItem8.param("fid", this.f52773e.getPbModel().getForumId());
                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem8.param("obj_locate", 2);
                                                    TiebaStatic.log(statisticItem8);
                                                } else if (view.getId() == b.a.r0.k2.i.pb_item_tail_content) {
                                                    if (ViewHelper.checkUpIsLogin(this.f52773e.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.tail_web_view_title);
                                                        String p = b.a.q0.s.e0.b.j().p("tail_link", "");
                                                        if (!StringUtils.isNull(p)) {
                                                            TiebaStatic.log("c10056");
                                                            b.a.q0.m.a.p(view.getContext(), string, p, true, true, true);
                                                        }
                                                        this.f52773e.resetCommentView();
                                                    }
                                                } else if (view.getId() == b.a.r0.k2.i.keyboard_background_shadow) {
                                                    this.f52773e.resetCommentView();
                                                } else if (this.f52773e.mDialogController.Q() != null && view == this.f52773e.mDialogController.Q().d()) {
                                                    this.f52773e.mDialogController.F();
                                                    if (this.f52773e.getPbModel() != null) {
                                                        this.f52773e.q.f(this.f52773e.getPbModel().f1());
                                                    }
                                                    if (this.f52773e.getPbModel() == null || !this.f52773e.getPbModel().isPrivacy()) {
                                                        this.f52773e.q.b();
                                                        if (!TbSingleton.getInstance().mCanCallFans && this.f52773e.getPbModel() != null && this.f52773e.getPbModel().P0() != null && this.f52773e.getPbModel().P0().Q() != null && this.f52773e.getPbModel().P0().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
                                                            i6 = 2;
                                                        }
                                                        if (this.f52773e.getPbModel() == null || this.f52773e.getPbModel().P0() == null) {
                                                            return;
                                                        }
                                                        this.f52773e.q.d(3, i6, this.f52773e.getPbModel().P0().Q());
                                                        return;
                                                    }
                                                    this.f52773e.showToast(b.a.r0.k2.l.privacy_thread_can_not_use_call_fans);
                                                    if (this.f52773e.getPbModel().P0() != null) {
                                                        this.f52773e.q.d(3, 3, this.f52773e.getPbModel().P0().Q());
                                                    }
                                                } else if (view.getId() == b.a.r0.k2.i.pb_floor_right_top_feedback || view.getId() == b.a.r0.k2.i.pb_post_op_more) {
                                                    StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                    statisticItem9.param("tid", this.f52773e.getPbModel().f1());
                                                    statisticItem9.param("fid", this.f52773e.getPbModel().getForumId());
                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem9.param("obj_locate", 7);
                                                    TiebaStatic.log(statisticItem9);
                                                    if (this.f52773e.isCommentFloatPage()) {
                                                        StatisticItem statisticItem10 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem10.param("fid", this.f52773e.getPbModel().getForumId());
                                                        statisticItem10.param("tid", this.f52773e.getPbModel().f1());
                                                        statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem10.param("post_id", this.f52773e.k1());
                                                        statisticItem10.param("obj_source", 1);
                                                        statisticItem10.param("obj_type", 2);
                                                        statisticItem10.param("obj_locate", this.f52773e.getFromVideoPageType());
                                                        TiebaStatic.log(statisticItem10);
                                                    }
                                                    this.f52773e.mDialogController.o0(false);
                                                    this.f52773e.mDialogController.P().onLongClick(view);
                                                }
                                            } else if (this.f52773e.getPbModel() != null) {
                                                AbsVideoPbFragment absVideoPbFragment8 = this.f52773e;
                                                if (absVideoPbFragment8.mDialogController == null || absVideoPbFragment8.f52671i == null || this.f52773e.getPbModel().P0() == null || this.f52773e.getPbModel().P0().O() == null || !this.f52773e.checkUpIsLogin()) {
                                                    return;
                                                }
                                                b.a.r0.k2.r.f P0 = this.f52773e.getPbModel().P0();
                                                int U0 = P0.O().U0();
                                                int currentItem = this.f52773e.f52671i.getCurrentItem();
                                                if (U0 == 0) {
                                                    if (this.f52773e.isShowDoubleTab() && currentItem == 0) {
                                                        this.f52773e.f52671i.setCurrentItem(1);
                                                    }
                                                    this.f52773e.expandVideo(false);
                                                    this.f52773e.processProfessionPermission();
                                                    return;
                                                }
                                                if (this.f52773e.isShowDoubleTab() && currentItem == 0) {
                                                    this.f52773e.f52671i.setCurrentItem(1);
                                                    str = "obj_source";
                                                } else if ((this.f52773e.isShowDoubleTab() && this.f52773e.getReplyFragment() == null) || this.f52773e.getDetailInfoAndReplyFragment() == null || this.f52773e.getRecyclerView() == null) {
                                                    return;
                                                } else {
                                                    StatisticItem param = new StatisticItem("c13403").param("tid", this.f52773e.getPbModel().f1()).param("fid", this.f52773e.getPbModel().P0().m()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    int i7 = (int) (b.a.e.e.p.l.i(this.f52773e.getContext()) * 0.6d);
                                                    BdTypeRecyclerView recyclerView = this.f52773e.getRecyclerView();
                                                    if (recyclerView == null) {
                                                        return;
                                                    }
                                                    boolean canScrollVertically = recyclerView.canScrollVertically(1);
                                                    boolean canScrollVertically2 = recyclerView.canScrollVertically(-1);
                                                    AppBarLayout appBarLayout = this.f52773e.mAppBarLayout;
                                                    if (appBarLayout != null) {
                                                        appBarLayout.setExpanded(false, true);
                                                    }
                                                    if (recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                                                        return;
                                                    }
                                                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                                                    if (!canScrollVertically2 && canScrollVertically) {
                                                        if (this.f52773e.H0 == -1 && this.f52773e.I0 == Integer.MIN_VALUE) {
                                                            return;
                                                        }
                                                        if (this.f52773e.H0 <= 3 && (this.f52773e.H0 != 3 || this.f52773e.I0 >= (-i7))) {
                                                            if (this.f52773e.H0 < 2) {
                                                                if (this.f52773e.H0 != 1) {
                                                                    recyclerView.smoothScrollBy(0, -this.f52773e.I0);
                                                                } else {
                                                                    int i8 = i7 / 4;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.f52773e.H0, this.f52773e.I0 + i8);
                                                                    recyclerView.smoothScrollBy(0, i8);
                                                                }
                                                            } else {
                                                                int i9 = i7 / 2;
                                                                linearLayoutManager.scrollToPositionWithOffset(this.f52773e.H0, this.f52773e.I0 + i9);
                                                                recyclerView.smoothScrollBy(0, i9);
                                                            }
                                                        } else {
                                                            linearLayoutManager.scrollToPositionWithOffset(this.f52773e.H0, this.f52773e.I0 + i7);
                                                            recyclerView.smoothScrollBy(0, i7);
                                                        }
                                                        statisticItem2 = param;
                                                        statisticItem2.param("obj_locate", 2);
                                                        str = "obj_source";
                                                        i3 = 1;
                                                    } else {
                                                        statisticItem2 = param;
                                                        int firstVisiblePosition = recyclerView.getFirstVisiblePosition();
                                                        View childAt = recyclerView.getChildAt(0);
                                                        if (childAt == null) {
                                                            str = "obj_source";
                                                            top = 0;
                                                        } else {
                                                            str = "obj_source";
                                                            top = childAt.getTop();
                                                        }
                                                        this.f52773e.H0 = firstVisiblePosition;
                                                        this.f52773e.I0 = top;
                                                        if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-i7) || recyclerView.getCount() < 6)) {
                                                            recyclerView.smoothScrollToPosition(0);
                                                        } else {
                                                            linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                            recyclerView.smoothScrollToPosition(0);
                                                        }
                                                        i3 = 1;
                                                        statisticItem2.param("obj_locate", 1);
                                                    }
                                                    TiebaStatic.log(statisticItem2);
                                                    b.a.q0.m0.c f2 = TbPageExtraHelper.f(view);
                                                    StatisticItem statisticItem11 = new StatisticItem("c12942");
                                                    statisticItem11.param("obj_type", i3);
                                                    statisticItem11.param("obj_locate", 4);
                                                    statisticItem11.param("tid", this.f52773e.getPbModel().f1());
                                                    statisticItem11.param("nid", P0.O().F0());
                                                    if (f2 != null) {
                                                        statisticItem11.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                                                    }
                                                    if (TbPageExtraHelper.m() != null) {
                                                        statisticItem11.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                                                    }
                                                    TiebaStatic.log(statisticItem11);
                                                }
                                                if (this.f52773e.getPbModel() == null || this.f52773e.getPbModel().P0() == null || this.f52773e.getPbModel().P0().O() == null || this.f52773e.getPbModel().P0().O().J() == null) {
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f52773e.getPbModel().f1()).param("fid", this.f52773e.getPbModel().P0().m()).param("obj_locate", 2).param("uid", this.f52773e.getPbModel().P0().O().J().getUserId()));
                                                if (this.f52773e.isCommentFloatPage()) {
                                                    StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                    statisticItem12.param("fid", this.f52773e.getPbModel().getForumId());
                                                    statisticItem12.param("tid", this.f52773e.getPbModel().f1());
                                                    statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem12.param("post_id", this.f52773e.k1());
                                                    statisticItem12.param(str, 1);
                                                    statisticItem12.param("obj_type", 12);
                                                    statisticItem12.param("obj_locate", this.f52773e.getFromVideoPageType());
                                                    TiebaStatic.log(statisticItem12);
                                                }
                                            }
                                        } else if (!b.a.e.e.p.j.z()) {
                                            this.f52773e.showToast(b.a.r0.k2.l.network_not_available);
                                        } else {
                                            AbsVideoPbFragment absVideoPbFragment9 = this.f52773e;
                                            if (absVideoPbFragment9.mDialogController == null || absVideoPbFragment9.getPbModel() == null) {
                                                return;
                                            }
                                            if (this.f52773e.isShowDoubleTab() && this.f52773e.getReplyFragment() == null) {
                                                return;
                                            }
                                            if (this.f52773e.isShowDoubleTab() || this.f52773e.getDetailInfoAndReplyFragment() != null) {
                                                this.f52773e.mDialogController.F();
                                                if (view.getId() != b.a.r0.k2.i.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new b.a.q0.s.q.t0(this.f52773e.getActivity(), "pb_shoucang"))) {
                                                    if (!this.f52773e.e1(11009) || this.f52773e.getPbModel() == null) {
                                                        return;
                                                    }
                                                    this.f52773e.B1();
                                                    if (this.f52773e.getPbModel().P0() != null && this.f52773e.getPbModel().P0().O() != null && this.f52773e.getPbModel().P0().O().J() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f52773e.getPbModel().f1()).param("fid", this.f52773e.getPbModel().P0().m()).param("obj_locate", 3).param("uid", this.f52773e.getPbModel().P0().O().J().getUserId()));
                                                        if (this.f52773e.isCommentFloatPage()) {
                                                            StatisticItem statisticItem13 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                            statisticItem13.param("fid", this.f52773e.getPbModel().getForumId());
                                                            statisticItem13.param("tid", this.f52773e.getPbModel().f1());
                                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem13.param("post_id", this.f52773e.k1());
                                                            statisticItem13.param("obj_source", 1);
                                                            statisticItem13.param("obj_type", 13);
                                                            statisticItem13.param("obj_locate", this.f52773e.getFromVideoPageType());
                                                            TiebaStatic.log(statisticItem13);
                                                        }
                                                    }
                                                    if (this.f52773e.getPbModel().P0().O() == null || this.f52773e.getPbModel().P0().O().J() == null || this.f52773e.getPbModel().P0().O().J().getUserId() == null || this.f52773e.L == null) {
                                                        return;
                                                    }
                                                    AbsVideoPbFragment absVideoPbFragment10 = this.f52773e;
                                                    int S = absVideoPbFragment10.mDialogController.S(absVideoPbFragment10.getPbModel().P0());
                                                    d2 O2 = this.f52773e.getPbModel().P0().O();
                                                    if (O2.M1()) {
                                                        i2 = 2;
                                                    } else if (O2.P1()) {
                                                        i2 = 3;
                                                    } else if (O2.N1()) {
                                                        i2 = 4;
                                                    } else {
                                                        i2 = O2.O1() ? 5 : 1;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f52773e.getPbModel().f1()).param("obj_locate", 1).param("obj_id", this.f52773e.getPbModel().P0().O().J().getUserId()).param("obj_type", !this.f52773e.L.e()).param("obj_source", S).param("obj_param1", i2));
                                                    return;
                                                }
                                                this.f52773e.w = view;
                                            }
                                        }
                                    } else if (this.f52773e.getPbModel() == null) {
                                    } else {
                                        if (view.getId() == b.a.r0.k2.i.pb_post_reply) {
                                            StatisticItem statisticItem14 = new StatisticItem("c13398");
                                            statisticItem14.param("tid", this.f52773e.getPbModel().f1());
                                            statisticItem14.param("fid", this.f52773e.getPbModel().getForumId());
                                            statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem14.param("obj_locate", 6);
                                            TiebaStatic.log(statisticItem14);
                                        }
                                        if (view.getId() == b.a.r0.k2.i.post_info_commont_img) {
                                            if (!DialogLoginHelper.checkUpIsLogin(new b.a.q0.s.q.t0(this.f52773e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                this.f52773e.v = view;
                                                return;
                                            }
                                        } else if (view.getId() == b.a.r0.k2.i.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new b.a.q0.s.q.t0(this.f52773e.getActivity(), "pb_huifu_louzhonglou"))) {
                                            this.f52773e.v = view;
                                            return;
                                        }
                                        if (this.f52773e.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                            if (sparseArray2.get(b.a.r0.k2.i.tag_load_sub_data) instanceof PostData) {
                                                PostData postData2 = (PostData) sparseArray2.get(b.a.r0.k2.i.tag_load_sub_data);
                                                if (view.getId() == b.a.r0.k2.i.pb_post_reply && (statisticItem = postData2.l0) != null) {
                                                    StatisticItem copy = statisticItem.copy();
                                                    copy.delete("obj_locate");
                                                    copy.param("obj_locate", 8);
                                                    TiebaStatic.log(copy);
                                                } else if (view.getId() == b.a.r0.k2.i.post_info_commont_img || view.getId() == b.a.r0.k2.i.pb_floor_comment_container) {
                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f52773e.getPbModel().g1()).param("fid", this.f52773e.getPbModel().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.G()).param("obj_source", 1).param("obj_type", 3));
                                                }
                                                if (this.f52773e.getPbModel() == null || this.f52773e.getPbModel().P0() == null || this.f52773e.E0 == null || postData2.t() == null || postData2.A() == 1) {
                                                    return;
                                                }
                                                if (this.f52773e.D0 != null) {
                                                    this.f52773e.D0.c();
                                                }
                                                if (this.f52773e.M0 && postData2.O() != null && postData2.O().size() != 0) {
                                                    this.f52773e.W1(postData2, null, true, false);
                                                    return;
                                                }
                                                b.a.r0.k2.r.s sVar2 = new b.a.r0.k2.r.s();
                                                sVar2.A(this.f52773e.getPbModel().P0().l());
                                                sVar2.E(this.f52773e.getPbModel().P0().O());
                                                sVar2.C(postData2);
                                                this.f52773e.E0.S(sVar2);
                                                this.f52773e.E0.setPostId(postData2.G());
                                                this.f52773e.z1(view, postData2.t().getUserId(), "", postData2);
                                                if (this.f52773e.B0 != null) {
                                                    AbsVideoPbFragment absVideoPbFragment11 = this.f52773e;
                                                    absVideoPbFragment11.setHasDraft(absVideoPbFragment11.B0.D());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (view.getId() == b.a.r0.k2.i.new_sub_pb_list_richText) {
                                        StatisticItem statisticItem15 = new StatisticItem("c13398");
                                        statisticItem15.param("tid", this.f52773e.getPbModel().f1());
                                        statisticItem15.param("fid", this.f52773e.getPbModel().getForumId());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem15);
                                        if (this.f52773e.isCommentFloatPage()) {
                                            StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem16.param("fid", this.f52773e.getPbModel().getForumId());
                                            statisticItem16.param("tid", this.f52773e.getPbModel().f1());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param("post_id", this.f52773e.k1());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 8);
                                            statisticItem16.param("obj_locate", this.f52773e.getFromVideoPageType());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                    }
                                    if ((view.getId() == b.a.r0.k2.i.pb_floor_reply_more || view.getId() == b.a.r0.k2.i.pb_post_reply_count) && !DialogLoginHelper.checkUpIsLogin(new b.a.q0.s.q.t0(this.f52773e.getActivity(), "pb_chakanhuifu"))) {
                                        this.f52773e.u = view;
                                        return;
                                    }
                                    if (view.getId() == b.a.r0.k2.i.pb_floor_reply_more && this.f52773e.isCommentFloatPage()) {
                                        StatisticItem statisticItem17 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem17.param("fid", this.f52773e.getPbModel().getForumId());
                                        statisticItem17.param("tid", this.f52773e.getPbModel().f1());
                                        statisticItem17.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem17.param("post_id", this.f52773e.k1());
                                        statisticItem17.param("obj_source", 1);
                                        statisticItem17.param("obj_type", 9);
                                        statisticItem17.param("obj_locate", this.f52773e.getFromVideoPageType());
                                        TiebaStatic.log(statisticItem17);
                                    }
                                    if (!this.f52773e.checkUpIsLogin()) {
                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.f52773e.getPbModel().P0().m()));
                                    } else if (this.f52773e.getPbModel() == null || this.f52773e.getPbModel().P0() == null) {
                                    } else {
                                        b.a.r0.k2.y.g.a aVar14 = this.f52773e.mDialogController;
                                        if (aVar14 != null) {
                                            aVar14.F();
                                        }
                                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                                        PostData postData3 = (PostData) sparseArray3.get(b.a.r0.k2.i.tag_load_sub_data);
                                        PostData postData4 = (PostData) sparseArray3.get(b.a.r0.k2.i.tag_load_sub_reply_data);
                                        if (postData3 == null) {
                                            return;
                                        }
                                        if (postData3.E() == 1) {
                                            TiebaStatic.log(new StatisticItem("c12630"));
                                        }
                                        StatisticItem statisticItem18 = postData3.l0;
                                        if (statisticItem18 != null) {
                                            StatisticItem copy2 = statisticItem18.copy();
                                            copy2.delete("obj_locate");
                                            if (view.getId() == b.a.r0.k2.i.new_sub_pb_list_richText) {
                                                copy2.param("obj_locate", 6);
                                            } else if (view.getId() == b.a.r0.k2.i.pb_floor_reply_more) {
                                                copy2.param("obj_locate", 8);
                                            }
                                            TiebaStatic.log(copy2);
                                        }
                                        this.f52773e.stopVoice();
                                        TiebaStatic.log("c11742");
                                        if (postData4 != null) {
                                            this.f52773e.W1(postData3, postData4, false, true);
                                        } else {
                                            this.f52773e.W1(postData3, null, false, false);
                                        }
                                    }
                                }
                            }
                        }
                    } else if (!b.a.e.e.p.j.z()) {
                        this.f52773e.showToast(b.a.r0.k2.l.network_not_available);
                        view.setTag(Boolean.FALSE);
                    } else {
                        this.f52773e.mDialogController.F();
                        if (!this.f52773e.I) {
                            this.f52773e.stopVoice();
                            this.f52773e.setPreLoad();
                            if (view.getId() == b.a.r0.k2.i.owner_reply) {
                                u2 = this.f52773e.getPbModel().u2(true, this.f52773e.k1());
                            } else {
                                u2 = view.getId() == b.a.r0.k2.i.all_reply ? this.f52773e.getPbModel().u2(false, this.f52773e.k1()) : this.f52773e.getPbModel().t2(this.f52773e.k1());
                            }
                            view.setTag(Boolean.valueOf(u2));
                            if (u2) {
                                this.f52773e.showProgressView();
                                i5 = 1;
                                this.f52773e.I = true;
                            } else {
                                i5 = 1;
                            }
                            TiebaStatic.eventStat(this.f52773e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i5, new Object[0]);
                            return;
                        }
                        view.setTag(Boolean.FALSE);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class y0 implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52774a;

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
            this.f52774a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f52774a.E0.N(postData);
                if (this.f52774a.getDetailInfoAndReplyFragment() != null) {
                    this.f52774a.getDetailInfoAndReplyFragment().invalidataData();
                } else if (this.f52774a.isShowDoubleTab() && this.f52774a.getReplyFragment() != null) {
                    this.f52774a.getReplyFragment().invalidataData();
                }
                this.f52774a.D0.c();
                this.f52774a.C0.hideTools();
                this.f52774a.showCommonView(false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class y1 implements b.a.q0.x.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52775a;

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
            this.f52775a = absVideoPbFragment;
        }

        @Override // b.a.q0.x.x.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.r0.k2.u.f.u0 u0Var = this.f52775a.mContentProcessController;
                if (u0Var == null || u0Var.e() == null || !this.f52775a.mContentProcessController.e().d()) {
                    return !this.f52775a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                AbsVideoPbFragment absVideoPbFragment = this.f52775a;
                absVideoPbFragment.showToast(absVideoPbFragment.mContentProcessController.e().c());
                if (this.f52775a.B0 != null && (this.f52775a.B0.C() || this.f52775a.B0.E())) {
                    this.f52775a.B0.A(false, this.f52775a.mContentProcessController.h());
                }
                this.f52775a.mContentProcessController.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class z extends b.a.q0.d1.i0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f52776a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52777b;

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
            this.f52777b = absVideoPbFragment;
            this.f52776a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.i0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel pbModel = this.f52777b.getPbModel();
                if (pbModel != null) {
                    pbModel.e2(this.f52776a);
                }
                return b.a.r0.k2.u.f.f1.b.d(this.f52777b.getContext(), this.f52777b.j1(), 2, pbModel);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class z0 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52778e;

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
            this.f52778e = absVideoPbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f52778e.mDialogController.o0(true);
                return this.f52778e.mDialogController.P().onLongClick(view);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class z1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsVideoPbFragment f52779a;

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
            this.f52779a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f52779a.getPbModel() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.f52779a.B0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.f52779a;
                absVideoPbFragment.setHasDraft(absVideoPbFragment.B0.D());
            }
            this.f52779a.resetCommentView();
            this.f52779a.mDialogController.F();
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
        B1 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds146);
        C1 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds114);
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
        this.f52668f = 0L;
        this.r = false;
        this.y = new k(this);
        this.I = false;
        this.L = null;
        this.O = null;
        this.P = null;
        this.X = false;
        this.a0 = null;
        this.i0 = null;
        this.r0 = false;
        this.s0 = null;
        this.t0 = false;
        this.u0 = false;
        this.v0 = false;
        this.w0 = false;
        this.F0 = new int[2];
        this.H0 = -1;
        this.I0 = Integer.MIN_VALUE;
        this.J0 = 0;
        this.K0 = Integer.MIN_VALUE;
        this.L0 = false;
        this.M0 = b.a.q0.b.d.m0();
        this.N0 = new v(this);
        this.P0 = new c1(this);
        this.Q0 = new n1(this);
        this.R0 = new y1(this);
        this.S0 = new z1(this, 2004016);
        this.T0 = new a2(this, 2004007);
        this.U0 = new a(this, 2921391);
        this.V0 = new b(this, 2016450);
        this.W0 = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.X0 = new d(this, 2001426);
        this.Y0 = new e(this, 2001427);
        this.Z0 = new f(this, 2001428);
        this.a1 = new g(this);
        this.b1 = new h(this);
        this.c1 = new i(this);
        this.d1 = new j(this, 2004008);
        this.e1 = 0;
        this.i1 = true;
        this.j1 = new l(this);
        this.l1 = new m(this);
        this.m1 = new n(this);
        this.p1 = new o(this);
        this.q1 = new p(this);
        this.r1 = new q(this);
        this.mOnFloorPostWriteNewCallback = new s(this);
        this.s1 = new x(this);
        this.listener = new y(this);
        this.t1 = new b0(this);
        this.u1 = new c0(this);
        this.v1 = new d0(this, 2001332);
        this.w1 = new e0(this, 2016528);
        this.x1 = new o0(this, 2001440);
        this.y1 = new p0(this);
        this.z1 = new v0(this, 2921509);
        this.A1 = new z0(this);
        this.onSwitchChangeListener = new a1(this);
        this.p0 = new b2(this, null);
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getPbModel() == null) {
            return;
        }
        b.a.r0.k2.r.f P0 = getPbModel().P0();
        getPbModel().r2(true);
        b.a.q0.i.a aVar = this.L;
        if (aVar != null) {
            P0.E0(aVar.g());
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

    public final void B1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || getPbModel() == null || getPbModel().P0() == null) {
            return;
        }
        if (isShowDoubleTab() && getReplyFragment() == null) {
            return;
        }
        if ((isShowDoubleTab() || getDetailInfoAndReplyFragment() != null) && this.L != null) {
            MarkData markData = null;
            if (getPbModel().P0() != null && getPbModel().P0().g0()) {
                markData = getPbModel().h0(0);
            } else {
                CustomViewPager customViewPager = this.f52671i;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = getPbModel().J0(getFirstPostData(getPbModel().P0()));
                } else if (isShowDoubleTab()) {
                    if (getReplyFragment() != null) {
                        markData = getPbModel().h0(getReplyFragment().getLastItem());
                    }
                } else if (getDetailInfoAndReplyFragment() != null) {
                    markData = getPbModel().h0(getDetailInfoAndReplyFragment().getLastItem());
                }
            }
            if (markData == null) {
                return;
            }
            if (markData.isApp() && getReplyFragment() != null && (markData = getPbModel().h0(getReplyFragment().getLastItem() + 1)) == null) {
                return;
            }
            setPreLoad();
            this.L.i(markData);
            if (!this.L.e()) {
                if (getPbModel() != null && !b.a.r0.k2.u.f.f1.b.k(getPbModel().f1())) {
                    this.m0.m(2);
                    b.a.r0.k2.u.f.f1.b.b(getPbModel().f1());
                }
                this.L.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.L.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final boolean C1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String p2 = b.a.q0.s.e0.b.j().p("bubble_link", "");
                if (StringUtils.isNull(p2)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    b.a.q0.m.a.p(getPageContext().getPageActivity(), getResources().getString(b.a.r0.k2.l.editor_privilege), p2 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!b.a.e.e.p.j.z()) {
                showToast(b.a.r0.k2.l.network_not_available);
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

    public final void E1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.operableVideoContainer == null) {
            return;
        }
        boolean z2 = false;
        if (this.p0.a()) {
            this.operableVideoContainer.a0(false);
            return;
        }
        b.a.r0.k2.y.k.a aVar = this.operableVideoContainer;
        if (!isCommentFloatPage() && !this.operableVideoContainer.Q0()) {
            z2 = true;
        }
        aVar.a0(z2);
    }

    public final void F1(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || fVar == null) {
            return;
        }
        d2 O = fVar.O();
        if (O != null && O.D2()) {
            c1();
        } else {
            K1(this.A0);
        }
        b.a.q0.x.x.e eVar = this.B0;
        if (eVar != null) {
            setHasDraft(eVar.D());
            this.B0.N(fVar.d());
            this.B0.O(fVar.l(), fVar.U());
            this.B0.s0(O);
            if (getPbModel() != null) {
                this.B0.P(getPbModel().s0(), getPbModel().f1(), getPbModel().p0());
            }
            if (O != null) {
                this.B0.i0(O.l2());
            }
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.operableVideoContainer == null || this.f52671i == null) {
            return;
        }
        boolean z2 = false;
        if (!isShowDoubleTab()) {
            this.operableVideoContainer.U0(false);
        } else if (this.f52671i.getCurrentItem() != 0) {
            this.operableVideoContainer.U0(false);
        } else if (this.p0.a()) {
            this.operableVideoContainer.U0(false);
        } else {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            if (videoPbViewModel != null) {
                this.operableVideoContainer.U0((videoPbViewModel.getIsDetailTabTop() == null || videoPbViewModel.getIsDetailTabTop().getValue() == null || videoPbViewModel.getIsDetailTabTop().getValue().booleanValue()) ? true : true);
            }
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
            layoutParams.height = 0;
            this.s.setLayoutParams(layoutParams);
            this.s.setVisibility(8);
        }
    }

    public final void I1(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.M == null) {
            b.a.r0.k2.u.f.b1.f.a aVar = new b.a.r0.k2.u.f.b1.f.a(this.f52667e);
            this.M = aVar;
            aVar.n(this.s1);
            this.M.m(this.b1);
        }
        this.M.k(emotionImageData, getPbModel(), getPbModel().P0());
    }

    public final void J1(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || getPbModel() == null) {
            return;
        }
        showLoadingView(getView());
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
        privacySettingMessage.setTid(getPbModel().f1());
        sendMessage(privacySettingMessage);
    }

    public final void K1(b.a.q0.x.x.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) || gVar == null || getPbModel() == null) {
            return;
        }
        gVar.p(getPbModel().q0());
        if (getPbModel().P0() != null && getPbModel().P0().l() != null) {
            gVar.o(getPbModel().P0().l());
        }
        gVar.q("pb");
        gVar.r(getPbModel());
    }

    public final void L1(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || getPbModel() == null) {
            return;
        }
        int Y0 = getPbModel().Y0();
        if (i2 == 5) {
            getPbModel().m2(2);
        } else if (i2 == 6) {
            getPbModel().m2(3);
        } else if (i2 != 7) {
            getPbModel().m2(1);
        } else {
            getPbModel().m2(4);
        }
        int Y02 = getPbModel().Y0();
        if (Y0 == 4 || Y02 == 4) {
            D1();
        }
    }

    public final void M1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) {
            this.B0.g0(z2);
            this.B0.j0(z2);
            this.B0.q0(z2);
        }
    }

    public final void N1(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048589, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new d1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                b.a.r0.k2.y.g.a aVar = this.mDialogController;
                if (aVar != null) {
                    aVar.K0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    public final void O1(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
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
        if (getPbModel() != null && !getPbModel().D0()) {
            antiData.setBlock_forum_name(getPbModel().P0().l().getName());
            antiData.setBlock_forum_id(getPbModel().P0().l().getId());
            antiData.setUser_name(getPbModel().P0().U().getUserName());
            antiData.setUser_id(getPbModel().P0().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public final void P1(b.a.r0.k2.r.f fVar) {
        b.a.r0.k2.y.i.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) || (G = fVar.G()) == null || G.p) {
            return;
        }
        b1(G);
    }

    public final void Q1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            b.a.r0.k2.y.j.a.c(getPbActivity(), j1(), i2);
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || getPbModel() == null || b.a.e.e.p.k.isEmpty(getPbModel().f1())) {
            return;
        }
        b.a.q0.a.d.y().P(b.a.q0.a.c.W, b.a.e.e.m.b.g(getPbModel().f1(), 0L));
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.s.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.F;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            Z1();
        }
    }

    public final void T1() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (layoutParams = this.s.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.F;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.s.setAlpha(0.0f);
            this.s.setVisibility(0);
            b2(layoutParams);
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.o1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mStatusBarBackground, Key.ALPHA, 1.0f, 0.0f);
                this.o1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.o1.start();
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.n1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mStatusBarBackground, Key.ALPHA, 0.0f, 1.0f);
                this.n1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.n1.start();
        }
    }

    public final void W1(PostData postData, PostData postData2, boolean z2, boolean z3) {
        AbsPbActivity.e n2;
        boolean z4;
        PostData firstPostData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String f12 = getPbModel().f1();
            String G = postData.G();
            String G2 = postData2 != null ? postData2.G() : "";
            int V = getPbModel().P0() != null ? getPbModel().P0().V() : 0;
            if (getReplyFragment() != null && getReplyFragment().getRichViewHepler() != null) {
                n2 = getReplyFragment().getRichViewHepler().n(G);
            } else if (getDetailInfoAndReplyFragment() == null || getDetailInfoAndReplyFragment().getRichViewHepler() == null) {
                return;
            } else {
                n2 = getDetailInfoAndReplyFragment().getRichViewHepler().n(G);
            }
            AbsPbActivity.e eVar = n2;
            if (postData == null || getPbModel() == null || getPbModel().P0() == null || eVar == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(f12, G, "pb", true, isCommentFloatPage(), null, false, G2, V, postData.R(), getPbModel().P0().d(), false, postData.t().getIconInfo(), getFromVideoPageType(), getFromVideoPageType() == 1 || getFromVideoPageType() == 2 || getFromVideoPageType() == 3 || getFromVideoPageType() == 4 || getFromVideoPageType() == 5).addBigImageData(eVar.f52184a, eVar.f52185b, eVar.f52190g, eVar.j);
            if (z3) {
                addBigImageData.setHighLightPostId(G2);
                z4 = true;
                addBigImageData.setKeyIsUseSpid(true);
            } else {
                z4 = true;
            }
            addBigImageData.setKeyFromForumId(getPbModel().getForumId());
            addBigImageData.setTiebaPlusData(getPbModel().F(), getPbModel().B(), getPbModel().C(), getPbModel().A(), getPbModel().G());
            addBigImageData.setBjhData(getPbModel().j0());
            addBigImageData.setKeyPageStartFrom(getPbModel().O0());
            addBigImageData.setFromFrsForumId(getPbModel().getFromForumId());
            addBigImageData.setWorksInfoData(getPbModel().k1());
            addBigImageData.setIsOpenEditor(z2);
            if (getPbModel().P0().o() != null) {
                addBigImageData.setHasForumRule(getPbModel().P0().o().has_forum_rule.intValue());
            }
            if (getPbModel().P0().U() != null) {
                addBigImageData.setIsManager(getPbModel().P0().U().getIs_manager());
            }
            if (getPbModel().P0().l().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(getPbModel().P0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(getPbModel().P0().l().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (getPbModel().P0().l() != null) {
                addBigImageData.setForumHeadUrl(getPbModel().P0().l().getImage_url());
                addBigImageData.setUserLevel(getPbModel().P0().l().getUser_level());
            }
            if (getPbModel() != null && (firstPostData = getFirstPostData(getPbModel().P0())) != null) {
                if (!firstPostData.U && !postData.U) {
                    z4 = false;
                }
                addBigImageData.setMainPostMaskVisibly(z4);
            }
            if (isCommentFloatPage() && this.f52667e.getIntent() != null) {
                addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.f52667e.getIntent().getSerializableExtra("key_from_video_page_id"));
            }
            addBigImageData.setForceInterceptStimeStat(this.f52667e.isForceInterceptStimeStat());
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public final void X1() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (absPbActivity = this.f52667e) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || getPbModel() == null || getPbModel().P0() == null || getPbModel().P0().O() == null) {
            return;
        }
        d2 O = getPbModel().P0().O();
        O.Z0 = getPbModel().U0();
        O.Y0 = getPbModel().X0();
        O.X0 = getPbModel().W0();
        O.a1 = getPbModel().V0();
        O.H2 = getPbModel().D0();
        if (O.T() == 0) {
            O.E3(b.a.e.e.m.b.g(getPbModel().getForumId(), 0L));
        }
        StatisticItem i2 = b.a.q0.n0.c.i(getContext(), O, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public final boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (getPbModel() == null) {
                return true;
            }
            if (getPbModel().P0() == null || !getPbModel().P0().g0()) {
                if (getPbModel().B0()) {
                    MarkData n02 = getPbModel().n0();
                    if (n02 != null && getPbModel().z0() && getRecyclerView() != null) {
                        MarkData h02 = getPbModel().h0(getRecyclerView().getFirstVisiblePosition());
                        if (h02 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", n02);
                            this.f52667e.setResult(-1, intent);
                            return true;
                        } else if (h02.getPostId() != null && !h02.getPostId().equals(n02.getPostId())) {
                            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getBaseFragmentActivity());
                            aVar.setMessage(getPageContext().getString(b.a.r0.k2.l.alert_update_mark));
                            aVar.setPositiveButton(b.a.r0.k2.l.confirm, new t(this, h02, n02, aVar));
                            aVar.setNegativeButton(b.a.r0.k2.l.cancel, new u(this, n02, aVar));
                            aVar.setOnCalcelListener(new w(this));
                            aVar.create(getBaseFragmentActivity().getPageContext());
                            aVar.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", n02);
                            this.f52667e.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (getPbModel().P0() != null && getPbModel().P0().F() != null && getPbModel().P0().F().size() > 0 && getPbModel().z0()) {
                    this.f52667e.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Z0(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) || getPbModel() == null || getPbModel().P0() == null || getPbModel().P0().O() == null) {
            return;
        }
        d2 O = getPbModel().P0().O();
        O.Z0 = getPbModel().U0();
        O.Y0 = getPbModel().X0();
        O.X0 = getPbModel().W0();
        O.a1 = getPbModel().V0();
        if (O.T() == 0) {
            O.E3(b.a.e.e.m.b.g(getPbModel().getForumId(), 0L));
        }
        StatisticItem i2 = b.a.q0.n0.c.i(getContext(), O, "c13563");
        TbPageTag l2 = b.a.q0.n0.c.l(getContext());
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
            b.a.q0.m0.c k2 = TbPageExtraHelper.k(getContext());
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
            i2.param("tid", getPbModel().f1());
            i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i2.param("fid", getPbModel().P0().m());
            TiebaStatic.log(i2);
        }
        StatisticItem i3 = b.a.q0.n0.c.i(getContext(), O, "c14180");
        if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i3.param("obj_type", 2);
        } else {
            i3.param("obj_type", 1);
        }
        i3.param("tid", getPbModel().f1());
        i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
        i3.param("fid", getPbModel().P0().m());
        if (l2 != null) {
            i3.param("obj_source", l2.tabType);
        }
        TiebaStatic.log(i3);
        StatisticItem i4 = b.a.q0.n0.c.i(getContext(), O, "c14303");
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
            i3.param("tid", getPbModel().f1());
            i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i3.param("fid", getPbModel().P0().m());
            i3.param("obj_type", 1);
        }
        TiebaStatic.log(i4);
    }

    public final void Z1() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (layoutParams = this.s.getLayoutParams()) == null) {
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
    public final void a1(d2 d2Var) {
        double d2;
        int ceil;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        Rect i02;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, d2Var) == null) {
            double k2 = b.a.e.e.p.l.k(getContext());
            double i3 = (2.0d * k2) / b.a.e.e.p.l.i(getContext());
            if (d2Var != null && d2Var.q1() != null) {
                int intValue = d2Var.q1().video_width.intValue();
                int intValue2 = d2Var.q1().video_height.intValue();
                if (intValue2 > 0) {
                    d2 = (intValue * 1.0f) / intValue2;
                    if (d2 > 1.7777777777777777d) {
                        d2 = 1.7777777777777777d;
                    }
                    if (d2 >= i3) {
                        i3 = d2;
                    }
                    ceil = (int) Math.ceil(k2 / i3);
                    int height = (getPbModel() != null || (i02 = getPbModel().i0()) == null) ? ceil : i02.height();
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
                    if (isShowDoubleTab() && !b.a.q0.g1.b.c.d()) {
                        layoutParams3 = (RelativeLayout.LayoutParams) this.f52670h.getLayoutParams();
                        if (layoutParams3 != null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, C1);
                        } else {
                            layoutParams3.height = C1;
                        }
                        this.f52670h.setLayoutParams(layoutParams3);
                    }
                    layoutParams2 = (CoordinatorLayout.LayoutParams) this.mAppBarLayout.getLayoutParams();
                    if (isShowDoubleTab() && !b.a.q0.g1.b.c.d()) {
                        ceil += C1;
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
                layoutParams3 = (RelativeLayout.LayoutParams) this.f52670h.getLayoutParams();
                if (layoutParams3 != null) {
                }
                this.f52670h.setLayoutParams(layoutParams3);
            }
            layoutParams2 = (CoordinatorLayout.LayoutParams) this.mAppBarLayout.getLayoutParams();
            if (isShowDoubleTab()) {
                ceil += C1;
            }
            if (layoutParams2 != null) {
            }
            this.mAppBarLayout.setLayoutParams(layoutParams2);
            if (i2 == 0) {
            }
        }
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.F = ofFloat;
            ofFloat.setDuration(300L);
            this.F.addUpdateListener(new r1(this));
            this.F.start();
        }
    }

    public final void b1(b.a.r0.k2.y.i.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, aVar) == null) && aVar != null && this.t == null) {
            this.t = aVar;
            this.z.setText(aVar.getTitle());
            this.A.setText(aVar.p());
            String o2 = aVar.o();
            TBSpecificationBtn tBSpecificationBtn = this.C;
            if (TextUtils.isEmpty(o2)) {
                o2 = getPageContext().getString(b.a.r0.k2.l.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(o2);
            this.D.startLoad(aVar.i(), 10, false);
            this.E.setVisibility(aVar.q() ? 0 : 8);
            b.a.e.e.m.e.a().postDelayed(new j1(this), aVar.g().longValue() * 1000);
        }
    }

    public final void b2(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, layoutParams) == null) {
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

    public final void c1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || getPbModel() == null || this.f52667e == null) {
            return;
        }
        b.a.q0.x.x.e eVar = this.B0;
        if (eVar == null || !eVar.z) {
            b.a.q0.x.x.d dVar = new b.a.q0.x.x.d();
            K1(dVar);
            b.a.q0.x.x.e eVar2 = (b.a.q0.x.x.e) dVar.a(getContext());
            this.B0 = eVar2;
            eVar2.f0(this.f52667e.getPageContext());
            this.B0.o0(this.b1);
            this.B0.p0(this.s1);
            this.B0.G(this.f52667e.getPageContext(), this.f52667e.getIntent() == null ? null : this.f52667e.getIntent().getExtras());
            this.B0.a().showLinePositionBottom(true);
            setEditorTools(this.B0.a());
            if (!getPbModel().D0()) {
                this.B0.s(getPbModel().f1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.B0.l0(TbSingleton.getInstance().getAdVertiComment());
            } else if (getPbModel().r1()) {
                this.B0.l0(getPageContext().getString(b.a.r0.k2.l.pb_reply_hint_from_smart_frs));
            } else {
                this.B0.l0(getReplyHint());
            }
        }
    }

    public final void c2(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, layoutParams) == null) {
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

    public void checkEasterEgg(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048610, this, bdTypeRecyclerView, z2) == null) {
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
                if (((b.a.q0.u.a) ListUtils.getItem(arrayList, 0)).e() != 1) {
                    performFallingRedpacket((b.a.q0.u.a) ListUtils.getItem(arrayList, 0), 1);
                } else if (z2) {
                } else {
                    performFallingRedpacket((b.a.q0.u.a) ListUtils.getItem(arrayList, 0), 0);
                }
            }
        }
    }

    public boolean checkPrivacyBeforeInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if ((getPbModel() != null && getPbModel().P0().g0()) || this.mReplyPrivacyController == null || getPbModel() == null || getPbModel().P0() == null || ThreadCardUtils.isSelf(getPbModel().P0().O()) || getPbModel().P0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(getPbModel().P0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public boolean checkPrivacyBeforePost(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
            if (this.mReplyPrivacyController == null || getPbModel() == null || getPbModel().P0() == null || ThreadCardUtils.isSelf(getPbModel().P0().O()) || getPbModel().P0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeSend(getPbModel().P0().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public void clickCommentReply() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (!checkUpIsLogin()) {
                if (getPbModel() != null) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", getPbModel().getForumId()));
                }
            } else if (checkPrivacyBeforeInput()) {
                b.a.q0.x.x.e eVar = this.B0;
                if (eVar != null && (eVar.C() || this.B0.E())) {
                    this.B0.A(false, null);
                    return;
                }
                if (this.C0 != null) {
                    initPbEditor();
                    this.p0.f52681a = false;
                    if (this.C0.findToolById(2) != null) {
                        b.a.r0.l3.i0.a.c(getPageContext(), (View) this.C0.findToolById(2).k, false, null);
                    }
                }
                hideCommonView();
            }
        }
    }

    public final boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            PbModel pbModel = getPbModel();
            if (pbModel == null || pbModel.P0() == null) {
                return false;
            }
            d2 O = pbModel.P0().O();
            pbModel.P0().d();
            return AntiHelper.b(getPageContext(), O);
        }
        return invokeV.booleanValue;
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || getPbModel() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.B(getPbModel().getForumId()) || getPbModel().P0() == null || getPbModel().P0().l() == null) {
            return;
        }
        if (getPbModel().P0().l().isLike() == 1) {
            getPbModel().e0().A(getPbModel().getForumId(), getPbModel().f1());
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048616, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX)) {
            return;
        }
        Object[] objArr = (b.a.q0.f1.n.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), b.a.q0.f1.n.f.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (b.a.r0.k2.u.f.x0.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(b.a.r0.k2.h.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX);
                spannableStringBuilder2.setSpan(new b.a.q0.f1.d(drawable), 0, 33, 33);
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
        if (interceptable == null || interceptable.invokeL(1048617, this, bVar) == null) {
            List<PostData> list = getPbModel().P0().T().f18820a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).O().size()) {
                        break;
                    } else if (bVar.f54254g.equals(list.get(i2).O().get(i3).G())) {
                        list.get(i2).O().remove(i3);
                        list.get(i2).l();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).n(bVar.f54254g);
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

    public void deleteThread(b.a.q0.s.s.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, aVar, jSONArray) == null) {
            aVar.dismiss();
            if (getPbModel() == null || getPbModel().P0() == null || getPbModel().P0().O() == null || getPbModel().P0().l() == null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(b.a.r0.k2.i.tag_del_post_id, str);
            sparseArray.put(b.a.r0.k2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                deleteThread(sparseArray, (JSONArray) null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final boolean e1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void expandVideo(boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048622, this, z2) == null) || (appBarLayout = this.mAppBarLayout) == null) {
            return;
        }
        appBarLayout.setExpanded(z2);
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (getPbModel().v0() || getPbModel().y0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", getPbModel().f1());
                this.f52667e.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, getPbModel().f1()));
            if (Y1()) {
                this.f52667e.finish();
            }
        }
    }

    @Override // b.a.r0.k2.y.b
    public void finish() {
        CardHListViewData q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            PbModel pbModel = this.f52667e.getPbModel();
            if (pbModel != null && pbModel.P0() != null && !pbModel.P0().g0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = pbModel.P0().O().f0();
                if (pbModel.isShareThread() && pbModel.P0().O().y1 != null) {
                    historyMessage.threadName = pbModel.P0().O().y1.f45036b;
                } else {
                    historyMessage.threadName = pbModel.P0().O().getTitle();
                }
                if (pbModel.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = pbModel.P0().l().getName();
                }
                ArrayList<PostData> F = pbModel.P0().F();
                int firstItem = getReplyFragment() != null ? getReplyFragment().getFirstItem() : 0;
                if (F != null && firstItem >= 0 && firstItem < F.size()) {
                    historyMessage.postID = F.get(firstItem).G();
                }
                historyMessage.isHostOnly = pbModel.t0();
                historyMessage.isSquence = pbModel.d1();
                historyMessage.isShareThread = pbModel.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            b.a.q0.x.x.e eVar = this.B0;
            if (eVar != null) {
                eVar.J();
            }
            if (pbModel != null && (pbModel.v0() || pbModel.y0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", pbModel.f1());
                if (this.t0) {
                    if (this.v0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", pbModel.E0());
                    }
                    if (this.u0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", pbModel.A0());
                    }
                }
                if (pbModel.P0() != null && System.currentTimeMillis() - this.f52668f >= 40000 && (q2 = pbModel.P0().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                    intent.putExtra("guess_like_data", q2);
                }
                this.f52667e.setResult(-1, intent);
            }
            if (Y1()) {
                if (pbModel != null) {
                    b.a.r0.k2.r.f P0 = pbModel.P0();
                    if (P0 != null) {
                        if (P0.U() != null) {
                            P0.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!this.w0) {
                            if (this.m != null) {
                                Rect rect = new Rect();
                                this.m.getGlobalVisibleRect(rect);
                                b.a.r0.k2.u.f.k0.b().t(rect);
                            }
                            b.a.r0.k2.u.f.k0.b().s(this.f52671i.getCurrentItem());
                            BdTypeRecyclerView recyclerView = getRecyclerView();
                            b.a.r0.k2.u.f.k0.b().n(pbModel.Q0(), recyclerView != null ? recyclerView.onSaveInstanceState() : null, pbModel.d1(), pbModel.t0(), false);
                        }
                    }
                } else {
                    b.a.r0.k2.u.f.k0.b().m();
                }
                X1();
            }
        }
    }

    public void finishForumManageProcess(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(b.a.r0.k2.l.success));
            } else if (z3) {
                if (b.a.e.e.p.k.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.neterror);
                }
                showToast(str);
            }
        }
    }

    public final void g1(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048626, this, bVar, z2) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f54249b) ? bVar.f54249b : getString(b.a.r0.k2.l.delete_fail);
            int i2 = 0;
            if (bVar.f54250c == 1211066) {
                hideProgressBar();
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(b.a.r0.k2.l.dialog_known, new r(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else {
                finishForumManageProcess(0, bVar.f54248a, bVar.f54249b, z2);
            }
            if (bVar.f54248a) {
                int i3 = bVar.f54251d;
                if (i3 == 1) {
                    ArrayList<PostData> F = getPbModel().P0().F();
                    int size = F.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.f54254g.equals(F.get(i2).G())) {
                            F.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    getPbModel().P0().O().n4(getPbModel().P0().O().U0() - 1);
                    if (getDetailInfoAndReplyFragment() != null) {
                        getDetailInfoAndReplyFragment().invalidataData();
                    } else if (isShowDoubleTab() && getReplyFragment() != null) {
                        getReplyFragment().invalidataData();
                    }
                } else if (i3 == 0) {
                    f1();
                } else if (i3 == 2) {
                    ArrayList<PostData> F2 = getPbModel().P0().F();
                    int size2 = F2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= F2.get(i4).O().size()) {
                                break;
                            } else if (bVar.f54254g.equals(F2.get(i4).O().get(i5).G())) {
                                F2.get(i4).O().remove(i5);
                                F2.get(i4).l();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        F2.get(i4).n(bVar.f54254g);
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

    public b.a.q0.t.e.a getAttentionModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.O : (b.a.q0.t.e.a) invokeV.objValue;
    }

    public LinearLayout getCommentReplyLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.b0 : (LinearLayout) invokeV.objValue;
    }

    public DetailInfoAndReplyFragment getDetailInfoAndReplyFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.getFragmentByIndex(0) instanceof DetailInfoAndReplyFragment)) {
                return null;
            }
            return (DetailInfoAndReplyFragment) this.j.getFragmentByIndex(0);
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public DetailInfoFragment getDetailInfoFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.getFragmentByIndex(0) instanceof DetailInfoFragment)) {
                return null;
            }
            return (DetailInfoFragment) this.j.getFragmentByIndex(0);
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    public PostData getFirstPostData(b.a.r0.k2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, fVar)) == null) {
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
                postData = m1(fVar);
            }
            if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
                postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public abstract int getFromVideoPageType();

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (this.R == null) {
                this.R = new b.a.e.e.k.b<>(new t1(this), 20, 0);
            }
            return this.R;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            if (this.T == null) {
                this.T = new b.a.e.e.k.b<>(new s1(this), 8, 0);
            }
            return this.T;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public abstract int getInflateLayoutId();

    public boolean getIsLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.I : invokeV.booleanValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return null;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public boolean getLinkGoodsMoreShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.r : invokeV.booleanValue;
    }

    @Override // b.a.q0.f1.n.i
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public View.OnClickListener getListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.listener : (View.OnClickListener) invokeV.objValue;
    }

    public View.OnClickListener getManageOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.t1 : (View.OnClickListener) invokeV.objValue;
    }

    public SparseArray<Object> getManagerOrDeleteTag(b.a.r0.k2.r.f fVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData firstPostData;
        b.a.q0.s.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048642, this, new Object[]{fVar, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (fVar == null || (firstPostData = getFirstPostData(fVar)) == null) {
                return null;
            }
            String userId = firstPostData.t().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(b.a.r0.k2.i.tag_del_post_id, firstPostData.G());
                sparseArray.put(b.a.r0.k2.i.tag_del_post_type, 0);
                sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(fVar.V()));
                sparseArray.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (firstPostData.t() != null) {
                    sparseArray.put(b.a.r0.k2.i.tag_forbid_user_name, firstPostData.t().getUserName());
                    sparseArray.put(b.a.r0.k2.i.tag_forbid_user_name_show, firstPostData.t().getName_show());
                    sparseArray.put(b.a.r0.k2.i.tag_forbid_user_portrait, firstPostData.t().getPortrait());
                    sparseArray.put(b.a.r0.k2.i.tag_forbid_user_post_id, firstPostData.G());
                }
                sparseArray.put(b.a.r0.k2.i.tag_del_post_id, firstPostData.G());
                sparseArray.put(b.a.r0.k2.i.tag_del_post_type, 0);
                sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(fVar.V()));
                sparseArray.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<b.a.q0.s.q.z1> p2 = fVar.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (b.a.q0.s.q.z1 z1Var : p2) {
                        if (z1Var != null && !StringUtils.isNull(z1Var.getForumName()) && (e0Var = z1Var.f13511g) != null && e0Var.f13285a && !e0Var.f13287c && ((i3 = e0Var.f13286b) == 1 || i3 == 2)) {
                            sb.append(b.a.e.e.p.k.cutString(z1Var.getForumName(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.forum));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(b.a.r0.k2.i.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public b.a.q0.i.a getMarkModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.L : (b.a.q0.i.a) invokeV.objValue;
    }

    public View.OnLongClickListener getOnLongClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.A1 : (View.OnLongClickListener) invokeV.objValue;
    }

    public View.OnTouchListener getOnTouchListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.q1 : (View.OnTouchListener) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.b
    public AbsPbActivity getPbActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.f52667e : (AbsPbActivity) invokeV.objValue;
    }

    public b.a.q0.x.x.e getPbEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.B0 : (b.a.q0.x.x.e) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.b
    public PbFragment getPbFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.b
    public PbModel.g getPbFragmentDataCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.P0 : (PbModel.g) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.b
    public PbModel getPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.f52667e.getPbModel() : (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public BdTypeRecyclerView getRecyclerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            Iterator<BaseFragment> it = this.j.getFragments().iterator();
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

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            b.a.e.e.k.b<RelativeLayout> bVar = new b.a.e.e.k.b<>(new w1(this), 10, 0);
            this.W = bVar;
            return bVar;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public ReplyFragment getReplyFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.getFragmentByIndex(1) instanceof ReplyFragment)) {
                return null;
            }
            return (ReplyFragment) this.j.getFragmentByIndex(1);
        }
        return (ReplyFragment) invokeV.objValue;
    }

    public String getReplyHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            if (!b.a.e.e.p.k.isEmpty(this.q0)) {
                return this.q0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.u.f.q0.b());
            this.q0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            if (this.S == null) {
                this.S = TbRichTextView.createTextViewPool(getPageContext().getPageActivity(), 8);
            }
            return this.S;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            if (this.V == null) {
                this.V = new b.a.e.e.k.b<>(new v1(this), 15, 0);
            }
            return this.V;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return null;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.b
    public AbsVideoPbFragment getVideoPbFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (this.Q == null) {
                this.Q = VoiceManager.instance();
            }
            return this.Q;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            if (this.U == null) {
                this.U = new b.a.e.e.k.b<>(new u1(this), 8, 0);
            }
            return this.U;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public final void h1(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048663, this, i2, gVar) == null) || gVar == null || getPbModel() == null || getPbModel().P0() == null || getPbModel().P0().O() == null) {
            return;
        }
        finishForumManageProcess(this.P.getLoadDataMode(), gVar.f54270a, gVar.f54271b, false);
        if (gVar.f54270a) {
            this.t0 = true;
            if (i2 == 2 || i2 == 3) {
                this.u0 = true;
                this.v0 = false;
            } else if (i2 == 4 || i2 == 5) {
                this.u0 = false;
                this.v0 = true;
            }
            if (i2 == 2) {
                getPbModel().P0().O().X3(1);
                getPbModel().f2(1);
            } else if (i2 == 3) {
                getPbModel().P0().O().X3(0);
                getPbModel().f2(0);
            } else if (i2 == 4) {
                getPbModel().P0().O().Y3(1);
                getPbModel().g2(1);
            } else if (i2 == 5) {
                getPbModel().P0().O().Y3(0);
                getPbModel().g2(0);
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.f54271b)) {
                string = gVar.f54271b;
            } else {
                string = getString(b.a.r0.k2.l.operation_failed);
            }
            b.a.e.e.p.l.M(getPageContext().getPageActivity(), string);
        }
        if (isShowDoubleTab()) {
            if (getPbModel().P0().O() == null || getDetailInfoFragment() == null) {
                return;
            }
            getDetailInfoFragment().refreshFirstFloor();
        } else if (getPbModel().P0().O() == null || getDetailInfoAndReplyFragment() == null) {
        } else {
            getDetailInfoAndReplyFragment().refreshFirstFloor();
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
        b.a.r0.k2.r.f P0;
        int i2;
        b.a.r0.k2.z.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048664, this, z2) == null) || getPbModel() == null || this.mDialogController == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (P0 = getPbModel().P0()) == null) {
            return;
        }
        d2 O = P0.O();
        if (O != null && O.J() != null) {
            TiebaStatic.log(new StatisticItem("c13402").param("tid", getPbModel().f1()).param("fid", P0.m()).param("obj_locate", 4).param("uid", O.J().getUserId()));
            if (isCommentFloatPage()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", getPbModel().getForumId());
                statisticItem.param("tid", getPbModel().f1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", k1());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", getFromVideoPageType());
                TiebaStatic.log(statisticItem);
            }
        }
        if (O != null) {
            if (O.M1()) {
                i2 = 2;
            } else if (O.P1()) {
                i2 = 3;
            } else if (O.N1()) {
                i2 = 4;
            } else if (O.O1()) {
                i2 = 5;
            }
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem2.param("tid", getPbModel().f1());
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
                if (O.M1()) {
                    statisticItem2.param("obj_type", 10);
                } else if (O.P1()) {
                    statisticItem2.param("obj_type", 9);
                } else if (O.O1()) {
                    statisticItem2.param("obj_type", 8);
                } else if (O.N1()) {
                    statisticItem2.param("obj_type", 7);
                } else if (O.z1) {
                    statisticItem2.param("obj_type", 6);
                } else {
                    int i3 = O.i0;
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
                statisticItem2.param("nid", O.F0());
                statisticItem2.param("card_type", O.Q0());
                statisticItem2.param("recom_source", O.X0);
                statisticItem2.param("ab_tag", O.Z0);
                statisticItem2.param("weight", O.Y0);
                statisticItem2.param("extra", O.a1);
                statisticItem2.param("nid", O.F0());
                if (O.L() != null && !b.a.e.e.p.k.isEmpty(O.L().oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, O.L().oriUgcVid);
                }
            }
            if (!b.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (getPbActivity() != null) {
                b.a.q0.n0.c.e(getPbActivity(), statisticItem2);
            }
            iVar = this.m0;
            if (iVar != null) {
                statisticItem2.param("obj_param1", iVar.f());
            }
            TiebaStatic.log(statisticItem2);
            if (b.a.e.e.p.l.D()) {
                showToast(b.a.r0.k2.l.neterror);
                return;
            } else if (getPbModel().P0() == null) {
                b.a.e.e.p.l.M(getPageContext().getPageActivity(), getPageContext().getString(b.a.r0.k2.l.pb_no_data_tips));
                return;
            } else {
                ArrayList<PostData> F = P0.F();
                if ((F == null || F.size() <= 0) && getPbModel().d1()) {
                    b.a.e.e.p.l.M(getPageContext().getPageActivity(), getPageContext().getString(b.a.r0.k2.l.pb_no_data_tips));
                    return;
                }
                this.mDialogController.F();
                stopVoice();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), O)) {
                    return;
                }
                b.a.r0.k2.z.i iVar2 = this.m0;
                if (iVar2 != null) {
                    iVar2.k(false);
                    updateBottomShareStateUI(P0);
                }
                if (ShareSwitch.isOn()) {
                    int i4 = z2 ? 2 : 1;
                    if ((b.a.q0.b.d.S() || b.a.q0.b.d.T()) && this.m0.h()) {
                        this.m0.l(false);
                        o1(b.a.q0.t.g.f.a(), this.m0.f());
                        return;
                    }
                    Q1(i4);
                    return;
                }
                this.mDialogController.B0();
                getPbModel().l0().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                return;
            }
        }
        i2 = 1;
        StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem22.param("tid", getPbModel().f1());
        statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem22.param("fid", getPbModel().getForumId());
        if (!z2) {
        }
        statisticItem22.param("obj_name", i2);
        statisticItem22.param("obj_type", 2);
        if (O != null) {
        }
        if (!b.a.e.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
        }
        if (getPbActivity() != null) {
        }
        iVar = this.m0;
        if (iVar != null) {
        }
        TiebaStatic.log(statisticItem22);
        if (b.a.e.e.p.l.D()) {
        }
    }

    public void hideCommonView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048665, this) == null) || this.a0 == null) {
            return;
        }
        this.Z.setVisibility(8);
        this.a0.setVisibility(8);
        this.p0.f52681a = false;
        E1();
        G1();
    }

    public void hideDraftTip(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) || this.a0 == null || this.i0 == null) {
            return;
        }
        if (getPbModel() != null && getPbModel().P0() != null) {
            this.i0.setText(TbSingleton.getInstance().getAdVertiComment(getPbModel().P0().k0(), getPbModel().P0().l0(), getReplyHint()));
        } else {
            this.i0.setText(getReplyHint());
        }
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.a0.startAnimation(alphaAnimation);
        }
        this.Z.setVisibility(0);
        this.a0.setVisibility(0);
        this.p0.f52681a = true;
    }

    public void hideEditTool() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || (editorTools = this.C0) == null) {
            return;
        }
        editorTools.hide();
    }

    public void hideKeyBroad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048668, this) == null) || this.f52667e.getCurrentFocus() == null) {
            return;
        }
        b.a.e.e.p.l.x(getPageContext().getPageActivity(), this.f52667e.getCurrentFocus());
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
        if (!(interceptable == null || interceptable.invokeV(1048670, this) == null) || (rightFloatLayerView = this.O0) == null) {
            return;
        }
        rightFloatLayerView.completeHide();
    }

    public void hideToolInEditor() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048671, this) == null) || (editorTools = this.C0) == null) {
            return;
        }
        editorTools.hideTools();
    }

    public final String i1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048672, this, i2)) == null) {
            if (i2 == 0) {
                return getString(b.a.r0.k2.l.pb_comment_red_dot_no_reply);
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (i2 > 9990000) {
                return "· · ·";
            }
            if (i2 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(i2 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else if (i2 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(i2 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else {
                return "" + i2;
            }
        }
        return (String) invokeI.objValue;
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            b.a.q0.i.a c2 = b.a.q0.i.a.c(this.f52667e);
            this.L = c2;
            if (c2 != null) {
                c2.j(this.Q0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f52667e);
            this.P = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.p1);
            this.O = new b.a.q0.t.e.a(getPageContext());
            this.mDialogController = new b.a.r0.k2.y.g.a(this);
        }
    }

    public void initET() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            setEditorTools(this.B0.a());
        }
    }

    public void initPbEditor() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048675, this) == null) || (editorTools = this.C0) == null) {
            return;
        }
        editorTools.display();
        b.a.q0.x.x.e eVar = this.B0;
        if (eVar != null) {
            eVar.Q();
        }
        hideCommonView();
    }

    public void initRightFloatLayerView(b.a.r0.k2.r.f fVar) {
        b.a.q0.t.c.g pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048676, this, fVar) == null) || this.O0 == null || fVar == null || fVar.g() == 3 || isCommentFloatPage()) {
            return;
        }
        if (fVar.k0()) {
            pbAdFloatViewItemData = fVar.Z();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            if (!this.O0.isPbNeedShow()) {
                hideRightFloatLayerView();
                return;
            } else if (StringUtils.isNull(pbAdFloatViewItemData.f13782f)) {
                return;
            } else {
                this.O0.setData(pbAdFloatViewItemData);
                this.O0.setLogoListener(new g0(this, fVar, pbAdFloatViewItemData));
                this.O0.setFeedBackListener(new r0(this, pbAdFloatViewItemData));
                return;
            }
        }
        hideRightFloatLayerView();
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            b.a.r0.k0.b bVar = new b.a.r0.k0.b(getActivity());
            this.mDragActionManager = bVar;
            bVar.i(this.r1);
            this.h1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
            t1();
            this.mAppBarLayout = (AppBarLayout) this.f52669g.findViewById(b.a.r0.k2.i.appbar_layout);
            this.k = this.f52669g.findViewById(b.a.r0.k2.i.pb_video_pager_shadow);
            this.O0 = (RightFloatLayerView) this.f52669g.findViewById(b.a.r0.k2.i.right_layer_view);
            this.m = (VideoContainerLayout) this.f52669g.findViewById(b.a.r0.k2.i.pb_video_container);
            b.a.r0.k2.y.k.a aVar = new b.a.r0.k2.y.k.a(getContext(), this.m);
            this.operableVideoContainer = aVar;
            aVar.setStageType("2002");
            this.operableVideoContainer.setUniqueId(getUniqueId());
            this.operableVideoContainer.a1(this);
            this.operableVideoContainer.Y0(getPbActivity().getRootView());
            this.operableVideoContainer.Z0(this.mStatusBarBackground);
            ((RelativeLayout) this.f52669g.findViewById(b.a.r0.k2.i.scroll_container)).setMinimumHeight(((int) Math.ceil((b.a.e.e.p.l.k(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(b.a.r0.k2.g.tbds118));
            this.f52670h = (NewPagerSlidingTabBaseStrip) this.f52669g.findViewById(b.a.r0.k2.i.pb_video_tab_strip);
            this.s = this.f52669g.findViewById(b.a.r0.k2.i.pb_video_mount_layout);
            this.f52671i = (CustomViewPager) this.f52669g.findViewById(b.a.r0.k2.i.pb_video_view_pager);
            this.l = this.f52669g.findViewById(b.a.r0.k2.i.keyboard_background_shadow);
            this.x = (MaskView) this.f52669g.findViewById(b.a.r0.k2.i.mask_view);
            this.l.setOnClickListener(this.listener);
            u1();
            s1();
            p1();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.j = videoPbFragmentAdapter;
            this.f52671i.setAdapter(videoPbFragmentAdapter);
            this.f52670h.setViewPager(this.f52671i);
            this.f52670h.setOnPageChangeListener(new q0(this));
            this.J = this.f52669g.findViewById(b.a.r0.k2.i.viewstub_progress);
            FallingView fallingView = (FallingView) this.f52669g.findViewById(b.a.r0.k2.i.falling_view);
            this.H = fallingView;
            fallingView.setAnimationListener(new s0(this));
            initET();
            q1();
            if (!this.h1 && this.i1) {
                U1();
                UtilHelper.hideStatusBar(getPbActivity(), getPbActivity().getRootView());
                this.i1 = false;
            }
            if (!isShowDoubleTab() || b.a.q0.g1.b.c.d()) {
                this.f52670h.getLayoutParams().height = 0;
            }
            if (b.a.q0.g1.b.c.d()) {
                this.f52671i.setScrollable(false);
            }
        }
    }

    public abstract boolean isCommentFloatPage();

    public boolean isEditToolVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            EditorTools editorTools = this.C0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowDoubleTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? (isCommentFloatPage() || getPbModel() == null || !getPbModel().w1()) ? false : true : invokeV.booleanValue;
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            PbModel pbModel = this.f52667e.getPbModel();
            if (pbModel == null) {
                return false;
            }
            return pbModel.y1();
        }
        return invokeV.booleanValue;
    }

    public boolean isStatusBarShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.i1 : invokeV.booleanValue;
    }

    public boolean isToolInEditorVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            EditorTools editorTools = this.C0;
            return editorTools != null && editorTools.isToolVisible();
        }
        return invokeV.booleanValue;
    }

    public boolean isVerticalVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            b.a.r0.k2.y.k.a aVar = this.operableVideoContainer;
            if (aVar == null) {
                return false;
            }
            return aVar.Q0();
        }
        return invokeV.booleanValue;
    }

    public final int j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            if (getPbModel() == null || getPbModel().P0() == null || getPbModel().P0().O() == null) {
                return -1;
            }
            return getPbModel().P0().O().w();
        }
        return invokeV.intValue;
    }

    public final String k1() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            if (getPbModel() == null || getPbModel().P0() == null || getPbModel().P0().F() == null || (count = ListUtils.getCount((F = getPbModel().P0().F()))) == 0) {
                return "";
            }
            if (getPbModel().a1()) {
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
                if (getPbModel().z1(postData.t().getUserId())) {
                    return postData.G();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                        break;
                    } else if (getPbModel().z1(postData2.t().getUserId())) {
                        return postData2.G();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                        break;
                    } else if (getPbModel().z1(postData3.t().getUserId())) {
                        return postData3.G();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final int l1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048687, this, i2)) == null) {
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

    public final PostData m1(b.a.r0.k2.r.f fVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048688, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null || fVar.O().J() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData J = fVar.O().J();
            String userId = J.getUserId();
            HashMap<String, MetaData> A1 = fVar.O().A1();
            if (A1 != null && (metaData = A1.get(userId)) != null && metaData.getUserId() != null) {
                J = metaData;
            }
            postData.m0(1);
            postData.q0(fVar.O().W());
            postData.C0(fVar.O().getTitle());
            postData.B0(fVar.O().P());
            postData.k0(J);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final void n1(int i2, Intent intent) {
        b.a.q0.x.n nVar;
        b.a.r0.k2.u.f.t tVar;
        b.a.q0.x.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048689, this, i2, intent) == null) {
            if (i2 == 0) {
                hideEditTool();
                b.a.r0.k2.u.f.t tVar2 = this.D0;
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
                    this.B0.T();
                    this.B0.u0(pbEditorData.getVoiceModel());
                    this.B0.H(writeData);
                    b.a.q0.x.m findToolById = this.B0.a().findToolById(6);
                    if (findToolById != null && (nVar = findToolById.k) != null) {
                        nVar.onAction(new b.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.B0.M(null, null);
                    }
                } else if (editorType != 1 || (tVar = this.D0) == null || tVar.b() == null) {
                } else {
                    b.a.q0.x.x.h b3 = this.D0.b();
                    b3.b0(getPbModel().P0().O());
                    b3.B(writeData);
                    b3.c0(pbEditorData.getVoiceModel());
                    b.a.q0.x.m findToolById2 = b3.a().findToolById(6);
                    if (findToolById2 != null && (nVar2 = findToolById2.k) != null) {
                        nVar2.onAction(new b.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b3.F();
                    }
                }
            }
        }
    }

    public final void o1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048690, this, i2, i3) == null) {
            b.a.q0.d1.l0.b(new z(this, i3), new a0(this, i3, i2));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(b.a.r0.k2.i.container));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            F1(videoPbViewModel.getData());
            initRightFloatLayerView(videoPbViewModel.getData());
            refreshTabText(videoPbViewModel.getData());
            if (getPbModel() != null && getPbModel().P0() != null) {
                boolean z02 = getPbModel().z0();
                b.a.r0.k2.r.f P0 = getPbModel().P0();
                if (z02) {
                    PostData firstPostData = getFirstPostData(P0);
                    if (P0.u() != null && !P0.u().equals(firstPostData.G()) && this.f52671i != null) {
                        if (isShowDoubleTab()) {
                            this.f52671i.setCurrentItem(1);
                        } else {
                            this.f52671i.setCurrentItem(0);
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
            this.f52667e.getTiePlusEventController().addEventAckedCallbackWeaked(this.N0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048692, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.B0.I(i2, i3, intent);
            b.a.r0.k2.u.f.b1.f.a aVar = this.M;
            if (aVar != null) {
                aVar.i(i2, i3, intent);
            }
            b.a.r0.k2.u.f.t tVar = this.D0;
            if (tVar != null) {
                tVar.g(i2, i3, intent);
            }
            if (i2 == 25035) {
                n1(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 11009) {
                    B1();
                } else if (i2 == 13011) {
                    b.a.r0.y2.a.g().m(getPageContext());
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
                        I1(emotionImageData);
                    }
                }
            }
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048693, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.X = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, context) == null) {
            super.onAttach(context);
            this.f52667e = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048695, this, i2) == null) {
            super.onChangeSkinType(i2);
            UtilHelper.changeStatusBarIconAndTextColor(true, this.f52667e);
            getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            getBaseFragmentActivity().getLayoutMode().j(this.f52669g);
            SkinManager.setBackgroundColor(this.mStatusBar, b.a.r0.k2.f.CAM_X0611);
            SkinManager.setBackgroundColor(this.mStatusBarBackground, b.a.r0.k2.f.CAM_X0608);
            SkinManager.setBackgroundColor(this.f52670h, b.a.r0.k2.f.CAM_X0207);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f52670h;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.onChangeSkinType();
            }
            b.a.r0.k2.u.f.u0 u0Var = this.mContentProcessController;
            if (u0Var != null) {
                u0Var.i();
            }
            b.a.r0.k2.y.e eVar = this.n;
            if (eVar == null || !eVar.k()) {
                SkinManager.setBackgroundColor(this.f52669g, b.a.r0.k2.f.CAM_X0201);
            }
            EditorTools editorTools = this.C0;
            if (editorTools != null) {
                editorTools.onChangeSkinType(i2);
            }
            b.a.r0.k2.u.f.t tVar = this.D0;
            if (tVar != null) {
                tVar.h(i2);
            }
            RightFloatLayerView rightFloatLayerView = this.O0;
            if (rightFloatLayerView != null) {
                rightFloatLayerView.onChangeSkinType();
            }
            HeadImageView headImageView = this.c0;
            if (headImageView != null) {
                headImageView.setBorderColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0401));
            }
            LinearLayout linearLayout = this.b0;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(b.a.e.e.p.l.g(getContext(), b.a.r0.k2.g.tbds47), SkinManager.getColor(b.a.r0.k2.f.CAM_X0209)));
            }
            if (getPbModel() != null && getPbModel().B0()) {
                WebPManager.setPureDrawable(this.k0, b.a.r0.k2.h.icon_pure_pb_bottom_collected26_selection, b.a.r0.k2.f.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.k0, b.a.r0.k2.h.icon_pure_pb_bottom_collect26, b.a.r0.k2.f.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.j0, b.a.r0.k2.h.icon_pure_pb_bottom_comment26, b.a.r0.k2.f.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.B, b.a.r0.k2.h.icon_pure_close16_n_svg, b.a.r0.k2.f.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (getPbModel() != null) {
                updateBottomShareStateUI(getPbModel().P0());
            }
            SkinManager.setBackgroundResource(this.k, b.a.r0.k2.h.personalize_tab_shadow);
            SkinManager.setBackgroundColor(this.s, b.a.r0.k2.f.CAM_X0206);
            SkinManager.setBackgroundColor(this.a0, b.a.r0.k2.f.CAM_X0207);
            SkinManager.setBackgroundColor(this.Z, b.a.r0.k2.f.CAM_X0203);
            SkinManager.setViewTextColor(this.A, b.a.r0.k2.f.CAM_X0109);
            SkinManager.setViewTextColor(this.z, b.a.r0.k2.f.CAM_X0105);
            SkinManager.setViewTextColor(this.i0, b.a.r0.k2.f.CAM_X0109);
            SkinManager.setViewTextColor(this.o0, b.a.r0.k2.f.CAM_X0105);
            SkinManager.setViewTextColor(this.n0, b.a.r0.k2.f.CAM_X0107);
            TextView textView = this.n0;
            int g2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds18);
            int i3 = b.a.r0.k2.f.CAM_X0207;
            SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3);
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
                view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(b.a.e.e.p.l.g(view.getContext(), b.a.r0.k2.g.tbds32), SkinManager.getColor(b.a.r0.k2.f.CAM_X0309)));
            }
            stopVoice();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            b.a.r0.k2.y.k.a aVar = this.operableVideoContainer;
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
        if (interceptable == null || interceptable.invokeL(1048697, this, bundle) == null) {
            this.f52668f = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            r1(bundle);
            getVoiceManager().onCreate(getPageContext());
            b.a.q0.s.g0.c cVar = new b.a.q0.s.g0.c();
            this.K = cVar;
            cVar.f12958a = 1000L;
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
            registerListener(this.w1);
            this.q = new b.a.r0.a0.a(getPageContext());
            b.a.r0.k3.c.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048698, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f52669g = (RelativeLayout) layoutInflater.inflate(getInflateLayoutId(), viewGroup, false);
            initUI();
            return this.f52669g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            super.onDestroy();
            b.a.r0.k3.c.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.w1);
            getVoiceManager().onDestory(getPageContext());
            b.a.r0.k2.z.i iVar = this.m0;
            if (iVar != null) {
                iVar.j();
            }
            ForumManageModel forumManageModel = this.P;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            b.a.r0.k2.y.k.a aVar = this.operableVideoContainer;
            if (aVar != null) {
                aVar.R0();
            }
            b.a.r0.k2.u.f.b1.f.a aVar2 = this.M;
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
                if (getPbModel().L0() != null) {
                    getPbModel().L0().d();
                }
            }
            b.a.q0.x.x.e eVar = this.B0;
            if (eVar != null) {
                eVar.J();
            }
            this.K = null;
            stopFallingRedpacket();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        b.a.r0.k2.y.k.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048700, this, i2, keyEvent)) == null) {
            if (!this.h1 && (this.i1 || w1())) {
                U1();
                UtilHelper.hideStatusBar(getPbActivity(), getPbActivity().getRootView());
                this.i1 = false;
                b.a.r0.k2.y.k.a aVar2 = this.operableVideoContainer;
                if (aVar2 != null) {
                    aVar2.V0(false);
                }
            }
            if (i2 == 4) {
                b.a.r0.k2.y.k.a aVar3 = this.operableVideoContainer;
                if (aVar3 != null) {
                    return aVar3.C();
                }
                return false;
            } else if (i2 == 24) {
                b.a.r0.k2.y.k.a aVar4 = this.operableVideoContainer;
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
        if (interceptable == null || interceptable.invokeZ(1048701, this, z2) == null) {
            this.l.setVisibility(z2 ? 0 : 8);
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048702, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.X = true;
    }

    @Override // b.a.q0.f1.n.i
    public void onLinkClicked(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048703, this, context, str, z2) == null) {
            if (b.a.r0.k2.u.f.x0.c(str) && getPbModel() != null && getPbModel().f1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", getPbModel().f1()));
            }
            if (z2) {
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
            this.X = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            super.onPause();
            this.L0 = true;
            getVoiceManager().onPause(getPageContext());
            b.a.r0.k2.y.k.a aVar = this.operableVideoContainer;
            if (aVar != null) {
                aVar.L(true);
            }
            if (getPbModel() != null && !getPbModel().D0()) {
                this.B0.V(getPbModel().f1());
            }
            b.a.q0.a.d.y().E();
            MessageManager.getInstance().unRegisterListener(this.Y0);
            MessageManager.getInstance().unRegisterListener(this.Z0);
            MessageManager.getInstance().unRegisterListener(this.X0);
            MessageManager.getInstance().unRegisterListener(this.v1);
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048705, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mDialogController.p0(str);
        b.a.q0.s.s.b R = this.mDialogController.R();
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
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            super.onResume();
            this.L0 = false;
            getVoiceManager().onResume(getPageContext());
            b.a.r0.k2.y.k.a aVar = this.operableVideoContainer;
            if (aVar != null) {
                aVar.L(false);
            }
            R1();
            registerListener(this.Y0);
            registerListener(this.Z0);
            registerListener(this.X0);
            registerListener(this.v1);
            ItemCardHelper.v(this.y1);
            MessageManager.getInstance().registerListener(this.x1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (getPbModel() != null) {
                getPbModel().Y1(bundle);
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
        if (interceptable == null || interceptable.invokeI(1048708, this, i2) == null) {
            if (i2 == 0) {
                b.a.r0.k3.c.g().h(getUniqueId(), false);
                if (getRecyclerView() != null) {
                    checkEasterEgg(getRecyclerView(), true);
                }
            }
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.O0;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.onScrollIdle();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.O0;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.onScrollDragging();
                }
            } else if (i2 != 2 || (rightFloatLayerView = this.O0) == null) {
            } else {
                rightFloatLayerView.onScrollSettling();
            }
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048709, this, context, str) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            super.onStart();
            getVoiceManager().onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048711, this) == null) {
            super.onStop();
            getVoiceManager().onStop(getPageContext());
            b.a.r0.k3.c.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.x1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048712, this, z2) == null) {
            super.onUserChanged(z2);
            y1();
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048713, this, context, str) == null) {
            b.a.r0.k2.u.f.x0.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.X = true;
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048714, this, context, str) == null) {
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048715, this, z2) == null) || getPbActivity() == null) {
            return;
        }
        if (this.i1 && !TbSingleton.getInstance().isNotchScreen(getPbActivity()) && !TbSingleton.getInstance().isCutoutScreen(getPbActivity())) {
            U1();
            UtilHelper.hideStatusBar(getPbActivity(), getPbActivity().getRootView());
            this.i1 = false;
        }
        this.p0.f52682b = z2;
        E1();
        G1();
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            this.Y = (LinearLayout) this.f52669g.findViewById(b.a.r0.k2.i.video_pb_comment_container);
            this.Z = this.f52669g.findViewById(b.a.r0.k2.i.view_comment_top_line);
            this.a0 = this.f52669g.findViewById(b.a.r0.k2.i.pb_editor_tool_comment);
            b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds120);
            b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds242);
            HeadImageView headImageView = (HeadImageView) this.f52669g.findViewById(b.a.r0.k2.i.pb_editor_tool_comment_user_image);
            this.c0 = headImageView;
            headImageView.setVisibility(0);
            this.c0.setIsRound(true);
            this.c0.setBorderWidth(b.a.e.e.p.l.g(getContext(), b.a.r0.k2.g.L_X01));
            this.c0.setBorderColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0401));
            this.c0.setPlaceHolder(0);
            y1();
            this.i0 = (TextView) this.f52669g.findViewById(b.a.r0.k2.i.pb_editor_tool_comment_reply_text);
            LinearLayout linearLayout = (LinearLayout) this.f52669g.findViewById(b.a.r0.k2.i.pb_editer_tool_comment_layout);
            this.b0 = linearLayout;
            linearLayout.setOnClickListener(new u0(this));
            ImageView imageView = (ImageView) this.f52669g.findViewById(b.a.r0.k2.i.pb_editor_tool_comment_icon);
            this.j0 = imageView;
            imageView.setOnClickListener(this.listener);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView2 = (ImageView) this.f52669g.findViewById(b.a.r0.k2.i.pb_editor_tool_collection);
            this.k0 = imageView2;
            imageView2.setOnClickListener(this.listener);
            if (booleanExtra) {
                this.k0.setVisibility(8);
            } else {
                this.k0.setVisibility(0);
            }
            ImageView imageView3 = (ImageView) this.f52669g.findViewById(b.a.r0.k2.i.pb_editor_tool_share);
            this.l0 = imageView3;
            imageView3.setOnClickListener(this.listener);
            this.m0 = new b.a.r0.k2.z.i(this.l0);
            if (!b.a.q0.b.d.S() && !b.a.q0.b.d.T()) {
                this.m0.e();
            }
            if (getPbModel() != null && b.a.q0.b.d.S() && !b.a.r0.k2.u.f.f1.b.k(getPbModel().f1())) {
                this.m0.e();
                b.a.r0.k2.u.f.f1.b.b(getPbModel().f1());
            }
            TextView textView = (TextView) this.f52669g.findViewById(b.a.r0.k2.i.pb_editor_tool_comment_red_dot);
            this.n0 = textView;
            textView.setVisibility(0);
            showCommonView(false);
            if (b.a.q0.g1.b.c.d()) {
                ViewGroup.LayoutParams layoutParams = this.Y.getLayoutParams();
                layoutParams.height = 0;
                this.Y.setLayoutParams(layoutParams);
            }
        }
    }

    public void performFallingRedpacket(b.a.q0.u.a aVar, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048717, this, aVar, i2) == null) || (fallingView = this.H) == null) {
            return;
        }
        fallingView.startFalling(aVar, getPageContext(), i2, false);
    }

    public void processProfessionPermission() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048718, this) == null) || !checkUpIsLogin() || getPbModel() == null || getPbModel().P0() == null || getPbModel().P0().l() == null || d1()) {
            return;
        }
        if (getPbModel().P0().g0()) {
            clickCommentReply();
            return;
        }
        if (this.x0 == null) {
            b.a.r0.x0.q2.a.c cVar = new b.a.r0.x0.q2.a.c(getPageContext());
            this.x0 = cVar;
            cVar.j(0);
            this.x0.i(new b1(this));
        }
        this.x0.g(getPbModel().P0().l().getId(), b.a.e.e.m.b.g(getPbModel().f1(), 0L));
    }

    public final void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            this.E0 = new PbFakeFloorModel(getPageContext());
            PbModel pbModel = getPbModel();
            this.E0.P(pbModel.F(), pbModel.B(), pbModel.C(), pbModel.A(), pbModel.G());
            this.E0.setFromForumId(pbModel.getFromForumId());
            b.a.r0.k2.u.f.t tVar = new b.a.r0.k2.u.f.t(getPageContext(), this.E0, this.f52669g);
            this.D0 = tVar;
            tVar.k(new x0(this));
            this.D0.m(this.mOnFloorPostWriteNewCallback);
            this.E0.R(new y0(this));
        }
    }

    public final void r1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, bundle) == null) {
            b.a.q0.x.x.g gVar = new b.a.q0.x.x.g();
            this.A0 = gVar;
            K1(gVar);
            b.a.q0.x.x.e eVar = (b.a.q0.x.x.e) this.A0.a(getActivity());
            this.B0 = eVar;
            eVar.f0(this.f52667e.getPageContext());
            this.B0.o0(this.b1);
            this.B0.p0(this.s1);
            this.B0.h0(1);
            this.B0.G(this.f52667e.getPageContext(), bundle);
            this.B0.a().addHideLauncher(new b.a.q0.x.k(getActivity()));
            this.B0.a().showLinePositionBottom(true);
            M1(true);
            this.B0.P(getPbModel().s0(), getPbModel().f1(), getPbModel().p0());
            registerListener(this.T0);
            registerListener(this.V0);
            registerListener(this.d1);
            registerListener(this.S0);
            registerListener(this.U0);
            registerListener(this.W0);
            registerListener(this.z1);
            if (!getPbModel().D0()) {
                this.B0.s(getPbModel().f1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.B0.l0(TbSingleton.getInstance().getAdVertiComment());
            } else if (getPbModel().r1()) {
                this.B0.l0(getPageContext().getString(b.a.r0.k2.l.pb_reply_hint_from_smart_frs));
            } else {
                this.B0.l0(getReplyHint());
            }
            this.mContentProcessController = new b.a.r0.k2.u.f.u0();
            if (this.B0.v() != null) {
                this.mContentProcessController.m(this.B0.v().h());
            }
            this.B0.e0(this.R0);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.mReplyPrivacyController = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new n0(this));
        }
    }

    @Override // b.a.r0.k2.y.a
    public void refresh(boolean z2, int i2, int i3, int i4, b.a.r0.k2.r.f fVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048721, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) {
        }
    }

    public void refreshAll(boolean z2, int i2, int i3, int i4, b.a.r0.k2.r.f fVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048722, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.j.getFragments()) {
                if (baseFragment instanceof b.a.r0.k2.y.a) {
                    ((b.a.r0.k2.y.a) baseFragment).refresh(z2, i2, i3, i4, fVar, str, i5);
                }
            }
            refresh(z2, i2, i3, i4, fVar, str, i5);
        }
    }

    public void refreshBottomTool(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048723, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        updateBottomShareStateUI(fVar);
        this.k0.setVisibility(fVar.g0() ? 8 : 0);
        if (fVar.r()) {
            WebPManager.setPureDrawable(this.k0, b.a.r0.k2.h.icon_pure_pb_bottom_collected26_selection, b.a.r0.k2.f.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.k0, b.a.r0.k2.h.icon_pure_pb_bottom_collect26, b.a.r0.k2.f.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String i12 = i1(fVar.O().U0());
        TextView textView = this.n0;
        if (textView != null) {
            textView.setText(i12);
        }
        TextView textView2 = this.o0;
        if (textView2 != null) {
            textView2.setText(i12);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.O()));
    }

    public void refreshMark(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048724, this, z2, markData) == null) || getPbModel() == null) {
            return;
        }
        setPostPro();
        getPbModel().r2(z2);
        b.a.q0.i.a aVar = this.L;
        if (aVar != null) {
            aVar.h(z2);
            if (markData != null) {
                this.L.i(markData);
            }
        }
        if (getPbModel().B0()) {
            A1();
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

    public void refreshTabText(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048725, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        String valueOf = String.valueOf(fVar.O().U0());
        if (fVar.O().U0() == 0) {
            valueOf = "";
        }
        this.f52670h.notifyTailData(valueOf);
    }

    public void refreshWrite(b.a.r0.k2.r.s sVar) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048726, this, sVar) == null) || getPbModel() == null || getPbModel().P0() == null || sVar.i() == null) {
            return;
        }
        String G = sVar.i().G();
        ArrayList<PostData> F = getPbModel().P0().F();
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
                ArrayList<PostData> k2 = sVar.k();
                postData.z0(sVar.m());
                if (postData.O() != null && k2 != null) {
                    Iterator<PostData> it = k2.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.V() != null && next != null && next.t() != null && (metaData = postData.V().get(next.t().getUserId())) != null) {
                            next.k0(metaData);
                            next.t0(true);
                            next.F0(getPageContext(), getPbModel().z1(metaData.getUserId()));
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
        if (getPbModel().z0() || !z2) {
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
        if (!(interceptable == null || interceptable.invokeV(1048727, this) == null) || this.B0 == null || this.C0 == null) {
            return;
        }
        b.a.q0.x.x.a.a().c(0);
        this.B0.U();
        this.B0.S();
        if (this.B0.z() != null) {
            this.B0.z().setMaxImagesAllowed(this.B0.z ? 1 : 9);
        }
        this.B0.m0(SendView.ALL);
        this.B0.j(SendView.ALL);
        b.a.q0.x.h findLauncherById = this.C0.findLauncherById(23);
        b.a.q0.x.h findLauncherById2 = this.C0.findLauncherById(2);
        b.a.q0.x.h findLauncherById3 = this.C0.findLauncherById(5);
        if (findLauncherById2 != null) {
            findLauncherById2.display();
        }
        if (findLauncherById3 != null) {
            findLauncherById3.display();
        }
        if (findLauncherById != null) {
            findLauncherById.hide();
        }
        this.C0.invalidate();
    }

    public void resetCommentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            reset();
            hideEditTool();
            this.D0.c();
            showCommonView(false);
        }
    }

    public void resetRecordLocation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            this.H0 = -1;
            this.I0 = Integer.MIN_VALUE;
        }
    }

    public boolean richTextHandleSingleTap(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048730, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(b.a.r0.k2.i.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (!TextUtils.isEmpty(postData.u()) && b.a.q0.s.k.c().g()) {
                        return C1(postData.G());
                    }
                    if (checkUpIsLogin() && getPbModel() != null && getPbModel().P0() != null) {
                        b.a.r0.k2.u.f.t tVar = this.D0;
                        if (tVar != null) {
                            tVar.c();
                        }
                        b.a.r0.k2.r.s sVar = new b.a.r0.k2.r.s();
                        sVar.A(getPbModel().P0().l());
                        sVar.E(getPbModel().P0().O());
                        sVar.C(postData);
                        this.E0.S(sVar);
                        this.E0.setPostId(postData.G());
                        z1(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        b.a.q0.x.x.e eVar = this.B0;
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

    public final void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            this.z = (TextView) this.f52669g.findViewById(b.a.r0.k2.i.pb_video_mount_title);
            this.D = (TbImageView) this.f52669g.findViewById(b.a.r0.k2.i.pb_video_mount_pic);
            this.A = (TextView) this.f52669g.findViewById(b.a.r0.k2.i.pb_video_mount_desc);
            this.B = (ImageView) this.f52669g.findViewById(b.a.r0.k2.i.pb_video_mount_close);
            this.C = (TBSpecificationBtn) this.f52669g.findViewById(b.a.r0.k2.i.pb_video_mount_link);
            this.E = this.f52669g.findViewById(b.a.r0.k2.i.ala_live_point);
            this.D.setRadius(b.a.e.e.p.l.g(getContext(), b.a.r0.k2.g.tbds10));
            this.D.setConrers(15);
            this.C.setConfig(new b.a.q0.s.g0.n.c());
            this.B.setOnClickListener(new t0(this));
            this.C.setOnClickListener(this.y);
            this.s.setOnClickListener(this.y);
            if (getPbModel() == null || getPbModel().P0() == null) {
                return;
            }
            P1(getPbModel().P0());
        }
    }

    public void setCommentContainerVisible(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048732, this, i2) == null) || (linearLayout = this.Y) == null) {
            return;
        }
        linearLayout.setVisibility(i2);
    }

    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, editorTools) == null) {
            this.C0 = editorTools;
            editorTools.setId(b.a.r0.k2.i.pb_editor);
            this.C0.setOnCancelClickListener(new e1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.C0.getParent() == null) {
                this.f52669g.addView(this.C0, layoutParams);
            }
            this.C0.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.C0.setActionListener(24, new f1(this));
            hideEditTool();
            this.B0.i(new g1(this));
        }
    }

    public void setHasDraft(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048734, this, z2) == null) {
            this.r0 = z2;
        }
    }

    public void setIsLoading(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z2) == null) {
            this.I = z2;
        }
    }

    public void setIsStatusBarShowing(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z2) == null) {
            this.i1 = z2;
        }
    }

    public abstract void setNavigationBarVisibility(boolean z2);

    public void setPostPostWrite(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048738, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            b.a.r0.k2.y.g.a aVar = this.mDialogController;
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
        if (interceptable == null || interceptable.invokeV(1048739, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            b.a.e.e.p.l.x(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048741, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
            if (videoPbFragmentAdapter == null || (customViewPager = this.f52671i) == null) {
                return;
            }
            videoPbFragmentAdapter.setItemPrimary(z2 ? customViewPager.getCurrentItem() : -1);
        }
    }

    public void setShadowVisible(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048742, this, i2) == null) || (view = this.k) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void setShowLinkGoodsMore(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048743, this, z2) == null) {
            this.r = z2;
        }
    }

    public void showCommonView(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048744, this, z2) == null) || this.a0 == null || b.a.q0.g1.b.c.d()) {
            return;
        }
        setHasDraft(this.B0.D());
        if (this.r0) {
            showDraftTip(z2);
        } else {
            hideDraftTip(z2);
        }
        E1();
        G1();
    }

    public void showDraftTip(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048745, this, z2) == null) || this.a0 == null || (textView = this.i0) == null) {
            return;
        }
        textView.setText(b.a.r0.k2.l.draft_to_send);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.a0.startAnimation(alphaAnimation);
        }
        this.Z.setVisibility(0);
        this.a0.setVisibility(0);
        this.p0.f52681a = true;
    }

    public void showProgressView() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048746, this) == null) || (view = this.J) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void showRightFloatLayerView() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048747, this) == null) || (rightFloatLayerView = this.O0) == null) {
            return;
        }
        rightFloatLayerView.completeShow();
    }

    public void stopFallingRedpacket() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048748, this) == null) || (fallingView = this.H) == null) {
            return;
        }
        fallingView.stopAllViews();
    }

    public final void stopVoice() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048749, this) == null) || (voiceManager = this.Q) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048750, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f52669g.findViewById(b.a.r0.k2.i.video_pb_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setOnClickListener(new w0(this));
            this.mNavigationBar.hideBottomLine();
            this.mNavigationBar.getTopCoverBgView().setBackgroundResource(b.a.r0.k2.h.bg_pb_header_gradient_top);
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mStatusBar = this.f52669g.findViewById(b.a.r0.k2.i.statebar);
            View findViewById = this.f52669g.findViewById(b.a.r0.k2.i.status_bar_background);
            this.mStatusBarBackground = findViewById;
            if (this.h1) {
                ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
                layoutParams.height = b.a.e.e.p.l.r(getPbActivity());
                this.mStatusBar.setLayoutParams(layoutParams);
                this.mStatusBar.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = b.a.e.e.p.l.r(getPbActivity());
                this.mStatusBarBackground.setLayoutParams(layoutParams2);
                this.mStatusBarBackground.setVisibility(0);
            }
            View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.listener);
            this.mBackButton = addSystemImageButton;
            this.o = (ImageView) addSystemImageButton.findViewById(b.a.r0.k2.i.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, b.a.r0.k2.h.ic_icon_pure_topbar_return40_svg, b.a.r0.k2.f.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, b.a.r0.k2.j.nb_item_floor_more, this.listener);
            this.mMore = addCustomView;
            this.p = (ImageView) addCustomView.findViewById(b.a.r0.k2.i.navigationBarBtnMore);
            int g2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds132);
            int g3 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds21);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.rightMargin = g3;
            this.mMore.setLayoutParams(layoutParams3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.p, b.a.r0.k2.h.icon_pure_topbar_more44_svg, b.a.r0.k2.f.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mMore.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            this.k1 = new GestureDetector(getContext(), this.l1);
            this.mNavigationBar.setOnTouchListener(this.j1);
        }
    }

    public void tapResetEditor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048751, this) == null) {
            b.a.q0.x.x.e eVar = this.B0;
            if (eVar != null) {
                setHasDraft(eVar.D());
            }
            resetCommentView();
            this.mDialogController.F();
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            this.f52670h.setDefaultSelectorColorResourceId(b.a.r0.k2.f.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds4);
            this.f52670h.setContainerLayoutParams(layoutParams);
            this.f52670h.setRectPaintColor(b.a.r0.k2.f.CAM_X0302);
            this.f52670h.init(b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds46), b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds46), b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds10), b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds46), true, true);
            this.f52670h.setIndicatorOffset(b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds64));
            this.f52670h.setIndicatorOvershot(b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds8));
            this.f52670h.setIndicatorMarginBottom(b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds170), -1);
            layoutParams2.gravity = 16;
            this.f52670h.setExpandedTabLayoutParams(layoutParams2);
        }
    }

    public void updateBottomShareStateUI(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, fVar) == null) {
            if (fVar != null && AntiHelper.o(fVar.O())) {
                b.a.r0.k2.z.i iVar = this.m0;
                if (iVar != null) {
                    iVar.k(false);
                    this.m0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.l0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.l0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.l0, b.a.r0.k2.h.icon_pure_pb_bottom_share26, b.a.r0.k2.f.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            b.a.r0.k2.z.i iVar2 = this.m0;
            if (iVar2 == null || !iVar2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.l0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.l0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.l0, b.a.r0.k2.h.icon_pure_pb_bottom_share26, b.a.r0.k2.f.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void updateUegMask(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048754, this, z2) == null) {
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

    public final void v1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048755, this) == null) && this.n == null) {
            this.n = new b.a.r0.k2.y.e(getBaseFragmentActivity(), this.m);
            int r2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? b.a.e.e.p.l.r(getPbActivity()) : 0;
            Rect rect = new Rect(0, r2, b.a.e.e.p.l.k(getContext()), this.m.getOriginHeight() + r2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.n.r(videoPbViewModel.getOriginArea(), rect);
            if (this.n.l()) {
                this.n.q(new m0(this, videoPbViewModel));
            } else if (!b.a.q0.g1.b.c.d() && isShowDoubleTab() && (videoPbViewModel.isJumpCommentTab() || getPbModel().e1() == 1)) {
                this.f52671i.setCurrentItem(1);
            } else if (videoPbViewModel.isJumpCommentTab() || getPbModel().e1() == 0) {
                this.f52671i.setCurrentItem(0);
            }
        }
    }

    public final boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            b.a.r0.k2.y.k.a aVar = this.operableVideoContainer;
            return aVar != null && aVar.P0();
        }
        return invokeV.booleanValue;
    }

    public final void x1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048757, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            if (this.c0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.c0.setImageResource(0);
                this.c0.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.c0.setImageResource(b.a.r0.k2.h.transparent_bg);
        }
    }

    public final void z1(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048759, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || d1() || !checkPrivacyBeforeInput()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.F0);
            this.G0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (this.D0 != null && postData != null) {
            this.D0.j(String.format(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.reply_title), postData.t().getName_show(), postData.M() != null ? postData.M().toString() : ""));
        }
        if (getPbModel() != null && getPbModel().P0() != null && getPbModel().P0().g0()) {
            b.a.e.e.m.e.a().postDelayed(new h1(this, str, str2), 0L);
            return;
        }
        if (this.y0 == null) {
            b.a.r0.x0.q2.a.c cVar = new b.a.r0.x0.q2.a.c(getPageContext());
            this.y0 = cVar;
            cVar.j(1);
            this.y0.i(new i1(this, str, str2));
        }
        if (getPbModel() == null || getPbModel().P0() == null || getPbModel().P0().l() == null) {
            return;
        }
        this.y0.g(getPbModel().P0().l().getId(), b.a.e.e.m.b.g(getPbModel().f1(), 0L));
    }

    /* loaded from: classes9.dex */
    public class b2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f52681a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f52682b;

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
            this.f52682b = true;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f52681a && this.f52682b) ? false : true : invokeV.booleanValue;
        }

        public /* synthetic */ b2(AbsVideoPbFragment absVideoPbFragment, k kVar) {
            this(absVideoPbFragment);
        }
    }

    public void deleteThread(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue != 3) {
                if (intValue == 4 || intValue == 6) {
                    if (getPbModel().m0() != null) {
                        getPbModel().m0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == 4) {
                        TiebaStatic.log("c10499");
                    }
                }
            } else if (this.P.P()) {
            } else {
                showProgressBar();
                String str = (String) sparseArray.get(b.a.r0.k2.i.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue();
                boolean booleanValue2 = sparseArray.get(b.a.r0.k2.i.tag_is_block_thread) != null ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_is_block_thread)).booleanValue() : false;
                if (jSONArray != null) {
                    this.P.R(StringHelper.JsonArrayToString(jSONArray));
                }
                this.P.S(getPbModel().P0().l().getId(), getPbModel().P0().l().getName(), getPbModel().P0().O().f0(), str, intValue3, intValue2, booleanValue, getPbModel().P0().O().L(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            }
        }
    }
}
