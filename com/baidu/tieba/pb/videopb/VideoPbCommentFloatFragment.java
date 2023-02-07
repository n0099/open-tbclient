package com.baidu.tieba.pb.videopb;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.browser.BrowserHelper;
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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
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
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.ItemCardView;
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
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbLoadingViewOptimizeSwitch;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.a85;
import com.baidu.tieba.au4;
import com.baidu.tieba.aw4;
import com.baidu.tieba.b98;
import com.baidu.tieba.br4;
import com.baidu.tieba.bt5;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.ch8;
import com.baidu.tieba.cr4;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.e75;
import com.baidu.tieba.ea5;
import com.baidu.tieba.ej;
import com.baidu.tieba.f95;
import com.baidu.tieba.gh;
import com.baidu.tieba.id8;
import com.baidu.tieba.iz8;
import com.baidu.tieba.j05;
import com.baidu.tieba.ja8;
import com.baidu.tieba.jd5;
import com.baidu.tieba.k55;
import com.baidu.tieba.kc6;
import com.baidu.tieba.kd5;
import com.baidu.tieba.kp5;
import com.baidu.tieba.l05;
import com.baidu.tieba.lb5;
import com.baidu.tieba.ld5;
import com.baidu.tieba.lf8;
import com.baidu.tieba.lg8;
import com.baidu.tieba.mb5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n89;
import com.baidu.tieba.nc8;
import com.baidu.tieba.nd5;
import com.baidu.tieba.nf8;
import com.baidu.tieba.nq5;
import com.baidu.tieba.od5;
import com.baidu.tieba.og8;
import com.baidu.tieba.oo5;
import com.baidu.tieba.op5;
import com.baidu.tieba.p35;
import com.baidu.tieba.p85;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbCommentFloatActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.pg8;
import com.baidu.tieba.pj5;
import com.baidu.tieba.pq8;
import com.baidu.tieba.q95;
import com.baidu.tieba.qd5;
import com.baidu.tieba.qd8;
import com.baidu.tieba.qv4;
import com.baidu.tieba.r09;
import com.baidu.tieba.rp5;
import com.baidu.tieba.sb5;
import com.baidu.tieba.sd5;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sz4;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.u35;
import com.baidu.tieba.u98;
import com.baidu.tieba.ud8;
import com.baidu.tieba.ug;
import com.baidu.tieba.ug8;
import com.baidu.tieba.uj5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.vb5;
import com.baidu.tieba.vg;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.w09;
import com.baidu.tieba.w9;
import com.baidu.tieba.wa5;
import com.baidu.tieba.wb5;
import com.baidu.tieba.xb5;
import com.baidu.tieba.xd8;
import com.baidu.tieba.xg8;
import com.baidu.tieba.xx4;
import com.baidu.tieba.y17;
import com.baidu.tieba.ys5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
public class VideoPbCommentFloatFragment extends BaseFragment implements bt5, VoiceManager.j, pg8, TbRichTextView.u, og8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int V0 = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener A0;
    public LinearLayout B;
    public CustomMessageListener B0;
    public View C;
    public CustomMessageListener C0;
    public View D;
    public kd5 D0;
    public LinearLayout E;
    public final NewWriteModel.d E0;
    public ImageView F;
    public View.OnClickListener F0;
    public TextView G;
    public CustomMessageListener G0;
    public ImageView H;
    public boolean H0;
    public ImageView I;
    public boolean I0;
    public ImageView J;
    public final w9 J0;
    public ch8 K;
    public NewWriteModel.d K0;
    public TextView L;
    public ld5 L0;
    public String M;
    public final View.OnClickListener M0;
    public boolean N;
    public View.OnClickListener N0;
    public String O;
    public final AdapterView.OnItemClickListener O0;
    public boolean P;
    public CustomMessageListener P0;
    public boolean Q;
    public CustomMessageListener Q0;
    public boolean R;
    public CustomMessageListener R0;
    public boolean S;
    public final ItemCardHelper.c S0;
    public ReplyPrivacyCheckController T;
    public CustomMessageListener T0;
    public y17 U;
    public final View.OnLongClickListener U0;
    public y17 V;
    public ud8 W;
    public PermissionJudgePolicy X;
    public qd5 Y;
    public od5 Z;
    public AbsPbActivity a;
    public EditorTools a0;
    public long b;
    public nc8 b0;
    public RelativeLayout c;
    public PbFakeFloorModel c0;
    public CustomViewPager d;
    public int[] d0;
    public VideoPbFragmentAdapter e;
    public int e0;
    public View f;
    public int f0;
    public kc6 g;
    public int g0;
    public View h;
    public int h0;
    public View i;
    public int i0;
    public View j;
    public boolean j0;
    public MaskView k;
    public FallingView l;
    public boolean m;
    public View n;
    public ug8 o;
    public u35 p;
    public au4 q;
    public p85 r;
    @NonNull
    public TiePlusEventController.f r0;
    public ForumManageModel s;
    public final PbModel.h s0;
    public VoiceManager t;
    public final au4.a t0;
    public ug<GifView> u;
    public kd5 u0;
    public ug<TextView> v;
    public final CustomMessageListener v0;
    public ug<ImageView> w;
    public CustomMessageListener w0;
    public ug<View> x;
    public final CustomMessageListener x0;
    public ug<LinearLayout> y;
    public CustomMessageListener y0;
    public ug<RelativeLayout> z;
    public HttpMessageListener z0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1935239406, "Lcom/baidu/tieba/pb/videopb/VideoPbCommentFloatFragment;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1935239406, "Lcom/baidu/tieba/pb/videopb/VideoPbCommentFloatFragment;");
        }
    }

    @Override // com.baidu.tieba.bt5
    public ug<TiebaPlusRecommendCard> B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pg8
    public VideoPbCommentFloatFragment J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this : (VideoPbCommentFloatFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<FestivalTipView> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public void V(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public void e1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048651, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.bt5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<ItemCardView> l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    public final int s3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048698, this, i2)) == null) {
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

    @Override // com.baidu.tieba.og8
    public void t0(boolean z2, int i2, int i3, u98 u98Var, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048701, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), u98Var, Integer.valueOf(i4)}) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pg8
    public PbFragment v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class p0 implements y17.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ VideoPbCommentFloatFragment c;

        @Override // com.baidu.tieba.y17.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.y17.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p0 a;

            /* renamed from: com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment$p0$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0390a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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

                public C0390a(a aVar) {
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
                    ud8 ud8Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ud8Var = this.a.a.c.W) != null && ud8Var.g() != null) {
                        if (!this.a.a.c.W.g().e()) {
                            this.a.a.c.W.b(false);
                        }
                        this.a.a.c.W.g().l(false);
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = p0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int g;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int j = ej.j(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g = ej.g(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    } else {
                        i = j / 2;
                        g = ej.g(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    }
                    int i2 = j - (i + g);
                    VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a.c;
                    boolean z = true;
                    int i3 = (videoPbCommentFloatFragment.d0[1] + videoPbCommentFloatFragment.e0) - i2;
                    if (videoPbCommentFloatFragment.u3() != null) {
                        this.a.c.u3().smoothScrollBy(0, i3);
                    }
                    if (this.a.c.b0 != null) {
                        this.a.c.Z.b().setVisibility(8);
                        z = (this.a.c.M() == null || this.a.c.M().k1() == null || this.a.c.M().k1().N() == null || !this.a.c.M().k1().N().isBjh()) ? false : false;
                        nc8 nc8Var = this.a.c.b0;
                        p0 p0Var = this.a;
                        nc8Var.t(p0Var.a, p0Var.b, p0Var.c.v3(), z);
                        this.a.c.b0.q(this.a.c.k3());
                        sd5 f = this.a.c.b0.f();
                        if (f != null && this.a.c.M() != null && this.a.c.M().k1() != null) {
                            f.H(this.a.c.M().k1().c());
                            f.d0(this.a.c.M().k1().N());
                        }
                        if (this.a.c.W.f() == null && this.a.c.b0.f().u() != null) {
                            this.a.c.b0.f().u().g(new C0390a(this));
                            VideoPbCommentFloatFragment videoPbCommentFloatFragment2 = this.a.c;
                            videoPbCommentFloatFragment2.W.n(videoPbCommentFloatFragment2.b0.f().u().i());
                            this.a.c.b0.f().N(this.a.c.D0);
                        }
                    }
                    this.a.c.y3();
                }
            }
        }

        public p0(VideoPbCommentFloatFragment videoPbCommentFloatFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = videoPbCommentFloatFragment;
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.tieba.y17.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || !z) {
                return;
            }
            gh.a().postDelayed(new a(this), 0L);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ e b;

            public a(e eVar, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (postWriteCallBackData = this.a) != null) {
                    this.b.a.V3(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements j05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.j05.e
            public void onClick(j05 j05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                    j05Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements j05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public c(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.j05.e
            public void onClick(j05 j05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                    j05Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public e(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, a85 a85Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, a85Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.M() != null && this.a.M().k1() != null) {
                        statisticItem.param("fid", this.a.M().k1().l());
                    }
                    statisticItem.param("tid", this.a.M().D1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.B4();
                this.a.n4(z, postWriteCallBackData);
                int i = -1;
                String str2 = "";
                if (postWriteCallBackData == null) {
                    str = "";
                } else {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (writeData != null) {
                    k55.b(writeData.getContent(), "3");
                }
                boolean z2 = false;
                if (z) {
                    if (PbReplySwitch.getInOn() && this.a.M() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                        this.a.M().t0(postWriteCallBackData.getPostId());
                        if (this.a.i3() != null) {
                            VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a;
                            videoPbCommentFloatFragment.h0 = videoPbCommentFloatFragment.i3().Q1();
                            VideoPbCommentFloatFragment videoPbCommentFloatFragment2 = this.a;
                            videoPbCommentFloatFragment2.i0 = videoPbCommentFloatFragment2.i3().R1();
                            this.a.M().H2(this.a.h0, this.a.i0);
                        }
                    }
                    if (this.a.d != null) {
                        this.a.d.setCurrentItem(0);
                    }
                    this.a.o.G();
                    this.a.W.c();
                    if (this.a.Z != null) {
                        VideoPbCommentFloatFragment videoPbCommentFloatFragment3 = this.a;
                        videoPbCommentFloatFragment3.k4(videoPbCommentFloatFragment3.Z.y());
                    }
                    this.a.A3();
                    this.a.u4(true);
                    this.a.M().O1();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.a.t4(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && this.a.i3() != null) {
                            this.a.i3().X1();
                        }
                    } else if (this.a.M().N0()) {
                        u98 k1 = this.a.M().k1();
                        if (k1 != null && k1.N() != null && k1.N().getAuthor() != null && (userId = k1.N().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.M().Z2()) {
                            this.a.p4();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.M().Z2()) {
                        this.a.p4();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        gh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    VideoPbCommentFloatFragment videoPbCommentFloatFragment4 = this.a;
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    }
                    if (writeData != null) {
                        str2 = writeData.getContent();
                    }
                    videoPbCommentFloatFragment4.M2(z2, str2);
                } else if (i == 220015) {
                    this.a.showToast(str);
                    if (this.a.Z.x() || this.a.Z.z()) {
                        this.a.Z.w(false, postWriteCallBackData);
                    }
                    this.a.W.k(postWriteCallBackData);
                } else if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.T;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    j05 j05Var = new j05(this.a.getActivity());
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        j05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        j05Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new b(this));
                    j05Var.setPositiveButton(R.string.open_now, new c(this));
                    j05Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (a85Var != null || i == 227001) {
                } else {
                    this.a.s4(i, str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ j b;

            public a(j jVar, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = jVar;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (postWriteCallBackData = this.a) != null) {
                    this.b.a.V3(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements j05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.j05.e
            public void onClick(j05 j05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                    j05Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements j05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public c(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            @Override // com.baidu.tieba.j05.e
            public void onClick(j05 j05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                    j05Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public j(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, a85 a85Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, a85Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.M() != null && this.a.M().k1() != null) {
                        statisticItem.param("fid", this.a.M().k1().l());
                    }
                    if (this.a.M() != null) {
                        statisticItem.param("tid", this.a.M().D1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (writeData != null) {
                    k55.b(writeData.getContent(), "4");
                }
                if (z) {
                    ud8 ud8Var = this.a.W;
                    if (ud8Var != null) {
                        ud8Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        q95.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        gh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                        return;
                    }
                    return;
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                }
                if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.T;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    j05 j05Var = new j05(this.a.getActivity());
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        j05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        j05Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new b(this));
                    j05Var.setPositiveButton(R.string.open_now, new c(this));
                    j05Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a;
                    if (videoPbCommentFloatFragment.W != null) {
                        if (videoPbCommentFloatFragment.b0 != null && this.a.b0.f() != null && this.a.b0.f().y()) {
                            this.a.b0.f().w(postWriteCallBackData);
                        }
                        this.a.W.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ VideoPbCommentFloatFragment c;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o0 a;

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

            public a(o0 o0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {o0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = o0Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ud8 ud8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ud8Var = this.a.c.W) != null && ud8Var.g() != null) {
                    if (!this.a.c.W.g().e()) {
                        this.a.c.W.b(false);
                    }
                    this.a.c.W.g().l(false);
                }
            }
        }

        public o0(VideoPbCommentFloatFragment videoPbCommentFloatFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = videoPbCommentFloatFragment;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int j = ej.j(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = ej.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = ej.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.c;
                boolean z = true;
                int i3 = (videoPbCommentFloatFragment.d0[1] + videoPbCommentFloatFragment.e0) - i2;
                if (videoPbCommentFloatFragment.u3() != null) {
                    this.c.u3().smoothScrollBy(0, i3);
                }
                if (this.c.b0 != null) {
                    this.c.Z.b().setVisibility(8);
                    this.c.b0.t(this.a, this.b, this.c.v3(), (this.c.M() == null || this.c.M().k1() == null || this.c.M().k1().N() == null || !this.c.M().k1().N().isBjh()) ? false : false);
                    this.c.b0.q(this.c.k3());
                    sd5 f = this.c.b0.f();
                    if (f != null && this.c.M() != null && this.c.M().k1() != null) {
                        f.H(this.c.M().k1().c());
                        f.d0(this.c.M().k1().N());
                    }
                    if (this.c.W.f() == null && this.c.b0.f().u() != null) {
                        this.c.b0.f().u().g(new a(this));
                        VideoPbCommentFloatFragment videoPbCommentFloatFragment2 = this.c;
                        videoPbCommentFloatFragment2.W.n(videoPbCommentFloatFragment2.b0.f().u().i());
                        this.c.b0.f().N(this.c.D0);
                    }
                }
                this.c.y3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i)};
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
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.o != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof n89) && customResponsedMessage.getOrginalMessage().getTag() == this.a.o.D) {
                n89 n89Var = (n89) customResponsedMessage.getData();
                this.a.o.W();
                SparseArray<Object> sparseArray = (SparseArray) this.a.o.P();
                DataRes dataRes = n89Var.a;
                boolean z = false;
                if (n89Var.c == 0 && dataRes != null) {
                    int e = dh.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (e == 1) {
                        z = true;
                    }
                    if (dj.isEmpty(str)) {
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
                    this.a.o.z0(z, sparseArray);
                } else if (intValue == 1) {
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                    this.a.o.j0(sparseArray, z);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public a0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.y(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, this.a.c, 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.y(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.c, j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a1(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i)};
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
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !this.a.j0) {
                this.a.y4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i)};
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
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.o != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
                BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                ug8 ug8Var = this.a.o;
                if (tag == ug8Var.D) {
                    ug8Var.W();
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                    u98 k1 = this.a.M().k1();
                    if (k1 != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.setUserId(str);
                        k1.v().add(muteUser);
                    }
                    if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                        this.a.p.d(this.a.getResources().getString(R.string.mute_success));
                    } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                        String errorString = userMuteAddResponseMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            errorString = this.a.getResources().getString(R.string.mute_error_beyond_limit);
                        }
                        this.a.o.E0(errorString);
                    } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                        this.a.o.y0();
                    } else {
                        String errorString2 = userMuteAddResponseMessage.getErrorString();
                        if (dj.isEmpty(errorString2)) {
                            errorString2 = this.a.getResources().getString(R.string.mute_fail);
                        }
                        this.a.p.c(errorString2);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements FallingView.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        @Override // com.baidu.tieba.pb.view.FallingView.s
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public b0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.s
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.l.setTag(Boolean.FALSE);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b1(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i)};
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
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.F4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i)};
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
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.o != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
                BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                ug8 ug8Var = this.a.o;
                if (tag == ug8Var.D) {
                    ug8Var.W();
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                        this.a.p.d(this.a.getResources().getString(R.string.un_mute_success));
                        return;
                    }
                    String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                    if (dj.isEmpty(muteMessage)) {
                        muteMessage = this.a.getResources().getString(R.string.un_mute_fail);
                    }
                    this.a.p.c(muteMessage);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public c0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a;
                if (videoPbCommentFloatFragment.T != null && videoPbCommentFloatFragment.M() != null && this.a.M().k1() != null && this.a.M().k1().c() != null) {
                    VideoPbCommentFloatFragment videoPbCommentFloatFragment2 = this.a;
                    if (!videoPbCommentFloatFragment2.T.checkPrivacyBeforeInvokeEditor(videoPbCommentFloatFragment2.M().k1().c().replyPrivateFlag)) {
                        return;
                    }
                }
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    return;
                }
                this.a.Z.n0();
                this.a.Z2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c1(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i), Boolean.valueOf(z)};
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
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.a.getView() != null) {
                    VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a;
                    videoPbCommentFloatFragment.hideLoadingView(videoPbCommentFloatFragment.getView());
                    this.a.hideProgressBar();
                }
                if (httpResponsedMessage == null || !(httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    return;
                }
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                if (!TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                    return;
                }
                int type = privacySettingMessage.getType();
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                    bdTopToast.h(true);
                    bdTopToast.g(this.a.getString(R.string.block_user_success));
                    bdTopToast.i((ViewGroup) this.a.getView());
                    this.a.q4(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0cfe);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                bdTopToast2.h(false);
                bdTopToast2.g(errorString);
                bdTopToast2.i((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements kd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public d(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.kd5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ud8 ud8Var = this.a.W;
                if (ud8Var != null && ud8Var.g() != null && this.a.W.g().d()) {
                    VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a;
                    videoPbCommentFloatFragment.showToast(videoPbCommentFloatFragment.W.g().c());
                    if (this.a.b0 != null && this.a.b0.f() != null && this.a.b0.f().y()) {
                        this.a.b0.f().w(this.a.W.h());
                    }
                    this.a.W.b(true);
                    return true;
                } else if (!this.a.S2(ReplyPrivacyCheckController.TYPE_FLOOR)) {
                    return true;
                } else {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public d0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                return;
            }
            this.a.X3();
            if (this.a.M() != null && this.a.M().k1() != null && this.a.M().k1().N() != null && this.a.M().k1().N().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.M().E1()).param("fid", this.a.M().k1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.M().D1()).param("fid", this.a.M().k1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.a.M().getForumId());
                statisticItem.param("tid", this.a.M().D1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.a.l3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 11);
                statisticItem.param("obj_locate", this.a.k3());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i)};
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
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ViewGroup.LayoutParams layoutParams = this.a.B.getLayoutParams();
                layoutParams.height = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
                this.a.B.setLayoutParams(layoutParams);
                this.a.d4();
                if (this.a.i3() != null) {
                    this.a.i3().X1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public f(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a;
                videoPbCommentFloatFragment.showToast(videoPbCommentFloatFragment.O);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public f0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i)};
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
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.Z != null) {
                VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a;
                videoPbCommentFloatFragment.k4(videoPbCommentFloatFragment.Z.y());
            }
            this.a.u4(false);
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements au4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public g0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.au4.a
        public void a(boolean z, boolean z2, String str) {
            ThreadData N;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.o4();
                if (z && this.a.M() != null) {
                    if (this.a.q != null) {
                        this.a.q.h(z2);
                    }
                    this.a.M().Y2(z2);
                    if (this.a.M().k1() != null && (N = this.a.M().k1().N()) != null) {
                        if (z2) {
                            N.collectNum++;
                        } else {
                            int i = N.collectNum;
                            if (i > 0) {
                                N.collectNum = i - 1;
                            }
                        }
                    }
                    if (this.a.M().V0()) {
                        this.a.N3();
                    } else if (this.a.i3() != null) {
                        this.a.i3().X1();
                    }
                    if (z2) {
                        if (this.a.q != null) {
                            if (this.a.q.f() != null && this.a.M() != null && this.a.M().k1() != null && this.a.M().k1().N() != null && this.a.M().k1().N().getAuthor() != null) {
                                MarkData f = this.a.q.f();
                                MetaData author = this.a.M().k1().N().getAuthor();
                                if (f != null && author != null) {
                                    if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                        this.a.o.v0(author);
                                    } else {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00d5);
                                    }
                                } else {
                                    VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a;
                                    videoPbCommentFloatFragment.showToast(videoPbCommentFloatFragment.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.L2();
                        return;
                    }
                    VideoPbCommentFloatFragment videoPbCommentFloatFragment2 = this.a;
                    videoPbCommentFloatFragment2.showToast(videoPbCommentFloatFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                VideoPbCommentFloatFragment videoPbCommentFloatFragment3 = this.a;
                videoPbCommentFloatFragment3.showToast(videoPbCommentFloatFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends w9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public h(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.w9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.a.M() != null) {
                    switch (this.a.s.getLoadDataMode()) {
                        case 0:
                            this.a.M().O1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.b3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.c3(dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a;
                            videoPbCommentFloatFragment.d3(videoPbCommentFloatFragment.s.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            this.a.c3(gVar.a, gVar.b, false);
                            this.a.o.e0(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                this.a.c3(false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public h0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.c0.X(postData);
                if (this.a.i3() != null) {
                    this.a.i3().X1();
                }
                this.a.b0.g();
                this.a.a0.s();
                this.a.u4(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public i(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) && j05Var != null) {
                j05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public i0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.o.n0(true);
                return this.a.o.Q().onLongClick(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements y17.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        @Override // com.baidu.tieba.y17.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.y17.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        public j0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.y17.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.Z != null && this.a.Z.b() != null) {
                    this.a.Z.b().C(new lb5(45, 27, null));
                }
                this.a.T2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements TiePlusEventController.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public k(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.f
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.A = true;
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public k0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ j05 c;
        public final /* synthetic */ VideoPbCommentFloatFragment d;

        public l(VideoPbCommentFloatFragment videoPbCommentFloatFragment, MarkData markData, MarkData markData2, j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, markData, markData2, j05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = videoPbCommentFloatFragment;
            this.a = markData;
            this.b = markData2;
            this.c = j05Var;
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
                if (this.d.q != null) {
                    if (this.d.q.e()) {
                        this.d.q.d();
                        this.d.q.h(false);
                    }
                    this.d.q.i(this.a);
                    this.d.q.h(true);
                    this.d.q.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.a.setResult(-1, intent);
                this.c.dismiss();
                this.d.C4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public l0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ j05 b;
        public final /* synthetic */ VideoPbCommentFloatFragment c;

        public m(VideoPbCommentFloatFragment videoPbCommentFloatFragment, MarkData markData, j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, markData, j05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = videoPbCommentFloatFragment;
            this.a = markData;
            this.b = j05Var;
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.C4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements mb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public m0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.mb5
        public void A(lb5 lb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lb5Var) == null) {
                Object obj = lb5Var.c;
                if ((obj instanceof e75) && EmotionGroupType.isSendAsPic(((e75) obj).getType())) {
                    if (this.a.X == null) {
                        this.a.X = new PermissionJudgePolicy();
                    }
                    this.a.X.clearRequestPermissionList();
                    this.a.X.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.X.startRequestPermission(this.a.getBaseFragmentActivity())) {
                        return;
                    }
                    this.a.Z.f((e75) lb5Var.c);
                    this.a.Z.w(false, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public n(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
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
    public class n0 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public n0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ud8 ud8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ud8Var = this.a.W) != null && ud8Var.e() != null) {
                if (!this.a.W.e().e()) {
                    this.a.W.a(false);
                }
                this.a.W.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) != null) || this.a.a0 == null || this.a.a0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i) || TextUtils.isEmpty(charSequence.toString().substring(i, i4))) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements ld5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public o(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.ld5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            StatisticItem statisticItem;
            int i;
            String str;
            int i2;
            int i3;
            String jumpUrlWithTid;
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09192b) {
                    if (this.a.M() != null) {
                        this.a.M().h2(false);
                        return;
                    }
                    return;
                }
                Object tag = view2.getTag(R.id.tag_first);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view2.setTag(R.id.tag_first, null);
                } else if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.M().D1());
                    statisticItem2.param("fid", this.a.M().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem3.param("fid", this.a.M().getForumId());
                    statisticItem3.param("tid", this.a.M().D1());
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem3.param("post_id", this.a.l3());
                    statisticItem3.param("obj_source", 1);
                    statisticItem3.param("obj_type", 3);
                    statisticItem3.param("obj_locate", this.a.k3());
                    TiebaStatic.log(statisticItem3);
                    if (!this.a.A) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                        if (tbRichTextView.getTag() instanceof SparseArray) {
                            Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                            if (obj instanceof PostData) {
                                PostData postData = (PostData) obj;
                                if (this.a.M() == null || this.a.M().k1() == null || this.a.c0 == null || postData.r() == null || postData.F() == 1 || !this.a.checkUpIsLogin()) {
                                    return;
                                }
                                if (this.a.b0 != null) {
                                    this.a.b0.g();
                                }
                                ja8 ja8Var = new ja8();
                                ja8Var.x(this.a.M().k1().k());
                                ja8Var.B(this.a.M().k1().N());
                                ja8Var.z(postData);
                                this.a.c0.c0(ja8Var);
                                this.a.c0.setPostId(postData.O());
                                this.a.M3(view2, postData.r().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                lg8.b(this.a.M().k1(), postData, postData.d0, 8, 1);
                                if (this.a.Z != null) {
                                    VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a;
                                    videoPbCommentFloatFragment.k4(videoPbCommentFloatFragment.Z.y());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.a.A = false;
                } else {
                    if (view2.getId() == R.id.pb_video_more && this.a.getPageContext().getPageActivity() != null && this.a.M() != null && this.a.a != null && this.a.a.getIntent() != null) {
                        if (this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.M().D1(), false, true);
                            this.a.j4(foldCommentActivityConfig);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.M().D1(), true, false);
                            this.a.j4(foldCommentActivityConfig2);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.a.M().getForumId());
                        statisticItem4.param("fname", this.a.M().J0());
                        statisticItem4.param("tid", this.a.M().D1());
                        TiebaStatic.log(statisticItem4);
                    }
                    ug8 ug8Var = this.a.o;
                    if (ug8Var != null && ug8Var.R() != null && view2 == this.a.o.R().m()) {
                        this.a.o.J();
                        return;
                    }
                    ug8 ug8Var2 = this.a.o;
                    if ((ug8Var2 == null || ug8Var2.R() == null || view2 != this.a.o.R().q()) && view2.getId() != R.id.obfuscated_res_0x7f090a95 && view2.getId() != R.id.obfuscated_res_0x7f091cda) {
                        if (this.a.o.R() != null && view2 == this.a.o.R().s()) {
                            if (this.a.M() == null) {
                                return;
                            }
                            this.a.o.G();
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                return;
                            }
                            this.a.B4();
                            this.a.p4();
                            this.a.M().W2(1);
                            return;
                        }
                        ug8 ug8Var3 = this.a.o;
                        if (ug8Var3 != null && ug8Var3.R() != null && view2 == this.a.o.R().q()) {
                            this.a.o.J();
                            return;
                        }
                        ug8 ug8Var4 = this.a.o;
                        if (ug8Var4 != null && ((ug8Var4.R() != null && view2 == this.a.o.R().y()) || view2.getId() == R.id.obfuscated_res_0x7f091963)) {
                            this.a.o.G();
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                                return;
                            } else if (this.a.m) {
                                view2.setTag(Integer.valueOf(this.a.M().A1()));
                                return;
                            } else {
                                this.a.B4();
                                this.a.p4();
                                this.a.o.D0(view2);
                                return;
                            }
                        }
                        ug8 ug8Var5 = this.a.o;
                        if (ug8Var5 != null && ug8Var5.R() != null && view2 == this.a.o.R().x()) {
                            if (this.a.M() == null || this.a.M().k1() == null || this.a.M().k1().N() == null) {
                                return;
                            }
                            this.a.o.J();
                            TiebaStatic.log(new StatisticItem("c13062"));
                            VideoPbCommentFloatFragment videoPbCommentFloatFragment2 = this.a;
                            videoPbCommentFloatFragment2.o.V(videoPbCommentFloatFragment2.M().k1().N().getFirstPostId());
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0918f6) {
                            try {
                                sparseArray = (SparseArray) view2.getTag();
                            } catch (ClassCastException e) {
                                e.printStackTrace();
                                sparseArray = null;
                            }
                            ug8 ug8Var6 = this.a.o;
                            if (ug8Var6 != null) {
                                ug8Var6.u0(sparseArray);
                            }
                        } else {
                            ug8 ug8Var7 = this.a.o;
                            if (ug8Var7 != null && ug8Var7.R() != null && view2 == this.a.o.R().v()) {
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
                                this.a.o.K();
                                return;
                            }
                            ug8 ug8Var8 = this.a.o;
                            if (ug8Var8 != null && ug8Var8.R() != null && view2 == this.a.o.R().w()) {
                                this.a.o.K();
                                VideoPbCommentFloatFragment videoPbCommentFloatFragment3 = this.a;
                                videoPbCommentFloatFragment3.o.B0(videoPbCommentFloatFragment3.O0);
                                return;
                            }
                            ug8 ug8Var9 = this.a.o;
                            if (ug8Var9 != null && ug8Var9.R() != null && view2 == this.a.o.R().p()) {
                                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.M().D1())) == null) {
                                    return;
                                }
                                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                this.a.o.J();
                                TiebaPlusConfigData.addClickStatsForFireLink(3);
                                return;
                            }
                            ug8 ug8Var10 = this.a.o;
                            if (ug8Var10 != null && (view2 == ug8Var10.N() || (this.a.o.R() != null && (view2 == this.a.o.R().t() || view2 == this.a.o.R().u())))) {
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                } else if (this.a.M() == null || this.a.M().k1() == null || this.a.s.Z()) {
                                    return;
                                } else {
                                    this.a.o.G();
                                    if (this.a.o.R() != null && view2 == this.a.o.R().u()) {
                                        i3 = this.a.M().k1().N().getIs_top() == 1 ? 5 : 4;
                                    } else if (this.a.o.R() != null && view2 == this.a.o.R().t()) {
                                        i3 = this.a.M().k1().N().getIs_good() == 1 ? 3 : 6;
                                    } else {
                                        i3 = view2 == this.a.o.N() ? 2 : 0;
                                    }
                                    ForumData k = this.a.M().k1().k();
                                    String name = k.getName();
                                    String id = k.getId();
                                    String id2 = this.a.M().k1().N().getId();
                                    this.a.showProgressBar();
                                    this.a.s.d0(id, name, id2, i3, this.a.o.O());
                                    return;
                                }
                            }
                            ug8 ug8Var11 = this.a.o;
                            if (ug8Var11 != null && ug8Var11.R() != null && view2 == this.a.o.R().o()) {
                                if (this.a.M() == null) {
                                    return;
                                }
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                }
                                this.a.o.G();
                                VideoPbCommentFloatFragment videoPbCommentFloatFragment4 = this.a;
                                SparseArray<Object> o3 = videoPbCommentFloatFragment4.o3(videoPbCommentFloatFragment4.M().k1(), 1);
                                if (o3 == null) {
                                    return;
                                }
                                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.M().k1().k().getId(), this.a.M().k1().k().getName(), this.a.M().k1().N().getId(), String.valueOf(this.a.M().k1().U().getUserId()), (String) o3.get(R.id.tag_forbid_user_name), (String) o3.get(R.id.tag_forbid_user_name_show), (String) o3.get(R.id.tag_forbid_user_post_id), (String) o3.get(R.id.tag_forbid_user_portrait))));
                                return;
                            }
                            ug8 ug8Var12 = this.a.o;
                            if (ug8Var12 != null && ug8Var12.R() != null && view2 == this.a.o.R().k()) {
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                }
                                VideoPbCommentFloatFragment videoPbCommentFloatFragment5 = this.a;
                                SparseArray<Object> o32 = videoPbCommentFloatFragment5.o3(videoPbCommentFloatFragment5.M().k1(), 1);
                                if (o32 != null) {
                                    this.a.o.i0(((Integer) o32.get(R.id.tag_del_post_type)).intValue(), (String) o32.get(R.id.tag_del_post_id), ((Integer) o32.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) o32.get(R.id.tag_del_post_is_self)).booleanValue());
                                }
                                this.a.o.J();
                                if (this.a.M() == null || this.a.M().k1() == null || this.a.M().k1().N() == null) {
                                    return;
                                }
                                ThreadData N = this.a.M().k1().N();
                                StatisticItem statisticItem5 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                statisticItem5.param("tid", N.getId());
                                statisticItem5.param("fid", N.getFid());
                                statisticItem5.param("fname", N.getForum_name());
                                TiebaStatic.log(statisticItem5);
                                StatisticItem statisticItem6 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                statisticItem6.param("tid", N.getId());
                                statisticItem6.param("fid", N.getFid());
                                statisticItem6.param("fname", N.getForum_name());
                                statisticItem6.param("obj_source", 3);
                                TiebaStatic.log(statisticItem6);
                                return;
                            }
                            ug8 ug8Var13 = this.a.o;
                            if (ug8Var13 != null && ug8Var13.R() != null && view2 == this.a.o.R().n()) {
                                if (this.a.M() == null) {
                                    return;
                                }
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                }
                                VideoPbCommentFloatFragment videoPbCommentFloatFragment6 = this.a;
                                SparseArray<Object> o33 = videoPbCommentFloatFragment6.o3(videoPbCommentFloatFragment6.M().k1(), 1);
                                if (o33 != null) {
                                    if (StringUtils.isNull((String) o33.get(R.id.tag_del_multi_forum))) {
                                        this.a.o.f0(((Integer) o33.get(R.id.tag_del_post_type)).intValue(), (String) o33.get(R.id.tag_del_post_id), ((Integer) o33.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) o33.get(R.id.tag_del_post_is_self)).booleanValue());
                                    } else {
                                        this.a.o.g0(((Integer) o33.get(R.id.tag_del_post_type)).intValue(), (String) o33.get(R.id.tag_del_post_id), ((Integer) o33.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) o33.get(R.id.tag_del_post_is_self)).booleanValue(), (String) o33.get(R.id.tag_del_multi_forum));
                                    }
                                }
                                this.a.o.J();
                            } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f0920a1 && view2.getId() != R.id.obfuscated_res_0x7f0918f8 && view2.getId() != R.id.obfuscated_res_0x7f09178c && view2.getId() != R.id.obfuscated_res_0x7f091955) {
                                if (view2.getId() != R.id.obfuscated_res_0x7f091953 && view2.getId() != R.id.obfuscated_res_0x7f091b20 && view2.getId() != R.id.obfuscated_res_0x7f0918f2) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f0918df && view2.getId() != R.id.collect_num_container) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f0918e4 && view2.getId() != R.id.share_more_container) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0918e1 && view2.getId() != R.id.thread_info_commont_container) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f0924e3) {
                                                    if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                        if (this.a.M() == null) {
                                                            return;
                                                        }
                                                        StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                        statisticItem7.param("tid", this.a.M().D1());
                                                        statisticItem7.param("fid", this.a.M().getForumId());
                                                        statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem7.param("obj_locate", 2);
                                                        TiebaStatic.log(statisticItem7);
                                                        return;
                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f091922 && view2.getId() != R.id.obfuscated_res_0x7f0918ec) {
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f091122) {
                                                            this.a.d4();
                                                            return;
                                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f0907cb && view2.getId() != R.id.obfuscated_res_0x7f090a92) {
                                                            if (this.a.o.R() != null && view2 == this.a.o.R().l()) {
                                                                this.a.o.G();
                                                                if (this.a.M() != null) {
                                                                    this.a.g.f(this.a.M().D1());
                                                                }
                                                                if (this.a.M() != null && this.a.M().isPrivacy()) {
                                                                    this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                                    if (this.a.M().k1() != null) {
                                                                        this.a.g.d(3, 3, this.a.M().k1().P());
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                this.a.g.b();
                                                                int i5 = (TbSingleton.getInstance().mCanCallFans || this.a.M() == null || this.a.M().k1() == null || this.a.M().k1().P() == null || !this.a.M().k1().P().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                                if (this.a.M() == null || this.a.M().k1() == null) {
                                                                    return;
                                                                }
                                                                this.a.g.d(3, i5, this.a.M().k1().P());
                                                                return;
                                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f0918fa || view2.getId() == R.id.obfuscated_res_0x7f09194d) {
                                                                StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                statisticItem8.param("tid", this.a.M().D1());
                                                                statisticItem8.param("fid", this.a.M().getForumId());
                                                                statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem8.param("obj_locate", 7);
                                                                TiebaStatic.log(statisticItem8);
                                                                StatisticItem statisticItem9 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                                statisticItem9.param("fid", this.a.M().getForumId());
                                                                statisticItem9.param("tid", this.a.M().D1());
                                                                statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem9.param("post_id", this.a.l3());
                                                                statisticItem9.param("obj_source", 1);
                                                                statisticItem9.param("obj_type", 2);
                                                                statisticItem9.param("obj_locate", this.a.k3());
                                                                TiebaStatic.log(statisticItem9);
                                                                this.a.o.n0(false);
                                                                this.a.o.Q().onLongClick(view2);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                                            if (sparseArray2 == null || !(sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData)) {
                                                                return;
                                                            }
                                                            PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                            View view3 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                            if (postData2 == null || view3 == null) {
                                                                return;
                                                            }
                                                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0907cc);
                                                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0907cd);
                                                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a92);
                                                            if (postData2.v0()) {
                                                                postData2.V0(false);
                                                                nf8.e(postData2);
                                                            } else {
                                                                if (this.a.M() != null ? nf8.c(this.a.M().k1(), postData2) : false) {
                                                                    postData2.V0(true);
                                                                    findViewById.setVisibility(0);
                                                                }
                                                            }
                                                            SkinManager.setBackgroundColor(findViewById, postData2.v0() ? R.color.CAM_X0201 : R.color.transparent);
                                                            SkinManager.setViewTextColor(eMTextView, postData2.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                            WebPManager.setPureDrawable(imageView, postData2.v0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, postData2.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                            return;
                                                        }
                                                    } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                        String s = p35.m().s("tail_link", "");
                                                        if (!StringUtils.isNull(s)) {
                                                            TiebaStatic.log("c10056");
                                                            BrowserHelper.t(view2.getContext(), string, s, true, true, true);
                                                        }
                                                        this.a.d4();
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (this.a.h0 >= 0) {
                                                    if (this.a.M() != null) {
                                                        this.a.M().D2();
                                                    }
                                                    if (this.a.i3() != null && this.a.i3().C1() != null) {
                                                        this.a.i3().C1().p(this.a.M().k1());
                                                    }
                                                    this.a.h0 = 0;
                                                    this.a.i0 = Integer.MIN_VALUE;
                                                    if (this.a.M() == null || this.a.i3() == null) {
                                                        return;
                                                    }
                                                    this.a.i3().e2(this.a.M().d1(), this.a.M().c1());
                                                    this.a.M().H2(0, 0);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else if (this.a.M() != null) {
                                                VideoPbCommentFloatFragment videoPbCommentFloatFragment7 = this.a;
                                                if (videoPbCommentFloatFragment7.o == null || videoPbCommentFloatFragment7.d == null || this.a.M().k1() == null || this.a.M().k1().N() == null || !this.a.checkUpIsLogin()) {
                                                    return;
                                                }
                                                u98 k1 = this.a.M().k1();
                                                if (k1.N().getReply_num() == 0) {
                                                    this.a.X3();
                                                    return;
                                                } else if (this.a.i3() == null || this.a.u3() == null) {
                                                    return;
                                                } else {
                                                    StatisticItem param = new StatisticItem("c13403").param("tid", this.a.M().D1()).param("fid", this.a.M().k1().l()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    int j = (int) (ej.j(this.a.getContext()) * 0.6d);
                                                    BdTypeRecyclerView u3 = this.a.u3();
                                                    if (u3 == null) {
                                                        return;
                                                    }
                                                    boolean canScrollVertically = u3.canScrollVertically(1);
                                                    boolean canScrollVertically2 = u3.canScrollVertically(-1);
                                                    if (u3.getLayoutManager() == null || !(u3.getLayoutManager() instanceof LinearLayoutManager)) {
                                                        return;
                                                    }
                                                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) u3.getLayoutManager();
                                                    if (canScrollVertically2 || !canScrollVertically) {
                                                        str = "obj_source";
                                                        int firstVisiblePosition = u3.getFirstVisiblePosition();
                                                        View childAt = u3.getChildAt(0);
                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                        this.a.f0 = firstVisiblePosition;
                                                        this.a.g0 = top;
                                                        if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-j) || u3.getCount() < 6)) {
                                                            u3.smoothScrollToPosition(0);
                                                        } else {
                                                            linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                            u3.smoothScrollToPosition(0);
                                                        }
                                                        i2 = 1;
                                                        param.param("obj_locate", 1);
                                                    } else if (this.a.f0 == -1 && this.a.g0 == Integer.MIN_VALUE) {
                                                        return;
                                                    } else {
                                                        if (this.a.f0 > 3 || (this.a.f0 == 3 && this.a.g0 < (-j))) {
                                                            str = "obj_source";
                                                            linearLayoutManager.scrollToPositionWithOffset(this.a.f0, this.a.g0 + j);
                                                            u3.smoothScrollBy(0, j);
                                                        } else if (this.a.f0 >= 2) {
                                                            str = "obj_source";
                                                            int i6 = j / 2;
                                                            linearLayoutManager.scrollToPositionWithOffset(this.a.f0, this.a.g0 + i6);
                                                            u3.smoothScrollBy(0, i6);
                                                        } else {
                                                            str = "obj_source";
                                                            if (this.a.f0 == 1) {
                                                                int i7 = j / 4;
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.f0, this.a.g0 + i7);
                                                                u3.smoothScrollBy(0, i7);
                                                            } else {
                                                                u3.smoothScrollBy(0, -this.a.g0);
                                                            }
                                                        }
                                                        param.param("obj_locate", 2);
                                                        i2 = 1;
                                                    }
                                                    TiebaStatic.log(param);
                                                    pj5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                                    StatisticItem statisticItem10 = new StatisticItem("c12942");
                                                    statisticItem10.param("obj_type", i2);
                                                    statisticItem10.param("obj_locate", 4);
                                                    statisticItem10.param("tid", this.a.M().D1());
                                                    statisticItem10.param("nid", k1.N().getNid());
                                                    if (findPageExtraByView != null) {
                                                        statisticItem10.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                                                    }
                                                    if (TbPageExtraHelper.getPrePageKey() != null) {
                                                        statisticItem10.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                                                    }
                                                    TiebaStatic.log(statisticItem10);
                                                    if (this.a.M() == null || this.a.M().k1() == null || this.a.M().k1().N() == null || this.a.M().k1().N().getAuthor() == null) {
                                                        return;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.M().D1()).param("fid", this.a.M().k1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                    StatisticItem statisticItem11 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                    statisticItem11.param("fid", this.a.M().getForumId());
                                                    statisticItem11.param("tid", this.a.M().D1());
                                                    statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem11.param("post_id", this.a.l3());
                                                    statisticItem11.param(str, 1);
                                                    statisticItem11.param("obj_type", 12);
                                                    statisticItem11.param("obj_locate", this.a.k3());
                                                    TiebaStatic.log(statisticItem11);
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                        this.a.x3(true);
                                    } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                    } else {
                                        VideoPbCommentFloatFragment videoPbCommentFloatFragment8 = this.a;
                                        if (videoPbCommentFloatFragment8.o == null || videoPbCommentFloatFragment8.M() == null || this.a.i3() == null) {
                                            return;
                                        }
                                        this.a.o.G();
                                        if (view2.getId() != R.id.obfuscated_res_0x7f0918df || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                            if (!this.a.Q2(11009) || this.a.M() == null) {
                                                return;
                                            }
                                            this.a.O3();
                                            if (this.a.M().k1() != null && this.a.M().k1().N() != null && this.a.M().k1().N().getAuthor() != null) {
                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.M().D1()).param("fid", this.a.M().k1().l()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                statisticItem12.param("fid", this.a.M().getForumId());
                                                statisticItem12.param("tid", this.a.M().D1());
                                                statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem12.param("post_id", this.a.l3());
                                                statisticItem12.param("obj_source", 1);
                                                statisticItem12.param("obj_type", 13);
                                                statisticItem12.param("obj_locate", this.a.k3());
                                                TiebaStatic.log(statisticItem12);
                                            }
                                            if (this.a.M().k1().N() == null || this.a.M().k1().N().getAuthor() == null || this.a.M().k1().N().getAuthor().getUserId() == null || this.a.q == null) {
                                                return;
                                            }
                                            VideoPbCommentFloatFragment videoPbCommentFloatFragment9 = this.a;
                                            int T = videoPbCommentFloatFragment9.o.T(videoPbCommentFloatFragment9.M().k1());
                                            ThreadData N2 = this.a.M().k1().N();
                                            if (N2.isBJHArticleThreadType()) {
                                                i = 2;
                                            } else if (N2.isBJHVideoThreadType()) {
                                                i = 3;
                                            } else if (N2.isBJHNormalThreadType()) {
                                                i = 4;
                                            } else {
                                                i = N2.isBJHVideoDynamicThreadType() ? 5 : 1;
                                            }
                                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.M().D1()).param("obj_locate", 1).param("obj_id", this.a.M().k1().N().getAuthor().getUserId()).param("obj_type", !this.a.q.e()).param("obj_source", T).param("obj_param1", i));
                                            return;
                                        }
                                        this.a.j = view2;
                                    }
                                } else if (this.a.M() == null) {
                                } else {
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091953) {
                                        StatisticItem statisticItem13 = new StatisticItem("c13398");
                                        statisticItem13.param("tid", this.a.M().D1());
                                        statisticItem13.param("fid", this.a.M().getForumId());
                                        statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem13.param("obj_locate", 6);
                                        TiebaStatic.log(statisticItem13);
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091b20) {
                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.i = view2;
                                            return;
                                        }
                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091953 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                        this.a.i = view2;
                                        return;
                                    }
                                    if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                        if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                            PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                            if (view2.getId() == R.id.obfuscated_res_0x7f091953 && (statisticItem = postData3.e0) != null) {
                                                StatisticItem copy = statisticItem.copy();
                                                copy.delete("obj_locate");
                                                copy.param("obj_locate", 8);
                                                TiebaStatic.log(copy);
                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091b20 || view2.getId() == R.id.obfuscated_res_0x7f0918f2) {
                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.M().E1()).param("fid", this.a.M().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData3.O()).param("obj_source", 1).param("obj_type", 3));
                                            }
                                            if (this.a.M() == null || this.a.M().k1() == null || this.a.c0 == null || postData3.r() == null || postData3.F() == 1) {
                                                return;
                                            }
                                            if (this.a.b0 != null) {
                                                this.a.b0.g();
                                            }
                                            ja8 ja8Var2 = new ja8();
                                            ja8Var2.x(this.a.M().k1().k());
                                            ja8Var2.B(this.a.M().k1().N());
                                            ja8Var2.z(postData3);
                                            this.a.c0.c0(ja8Var2);
                                            this.a.c0.setPostId(postData3.O());
                                            this.a.M3(view2, postData3.r().getUserId(), "", postData3);
                                            if (this.a.Z != null) {
                                                VideoPbCommentFloatFragment videoPbCommentFloatFragment10 = this.a;
                                                videoPbCommentFloatFragment10.k4(videoPbCommentFloatFragment10.Z.y());
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (view2.getId() == R.id.obfuscated_res_0x7f09178c) {
                                    StatisticItem statisticItem14 = new StatisticItem("c13398");
                                    statisticItem14.param("tid", this.a.M().D1());
                                    statisticItem14.param("fid", this.a.M().getForumId());
                                    statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                    statisticItem14.param("obj_locate", 4);
                                    TiebaStatic.log(statisticItem14);
                                    StatisticItem statisticItem15 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                    statisticItem15.param("fid", this.a.M().getForumId());
                                    statisticItem15.param("tid", this.a.M().D1());
                                    statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                    statisticItem15.param("post_id", this.a.l3());
                                    statisticItem15.param("obj_source", 1);
                                    statisticItem15.param("obj_type", 8);
                                    statisticItem15.param("obj_locate", this.a.k3());
                                    TiebaStatic.log(statisticItem15);
                                }
                                if ((view2.getId() != R.id.obfuscated_res_0x7f0918f8 && view2.getId() != R.id.obfuscated_res_0x7f091955) || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                    if (view2.getId() == R.id.obfuscated_res_0x7f0918f8) {
                                        StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem16.param("fid", this.a.M().getForumId());
                                        statisticItem16.param("tid", this.a.M().D1());
                                        statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem16.param("post_id", this.a.l3());
                                        statisticItem16.param("obj_source", 1);
                                        statisticItem16.param("obj_type", 9);
                                        statisticItem16.param("obj_locate", this.a.k3());
                                        TiebaStatic.log(statisticItem16);
                                    }
                                    if (!this.a.checkUpIsLogin()) {
                                        lg8.r("c10517", this.a.M().k1().l(), 3);
                                        return;
                                    } else if (this.a.M() == null || this.a.M().k1() == null) {
                                        return;
                                    } else {
                                        ug8 ug8Var14 = this.a.o;
                                        if (ug8Var14 != null) {
                                            ug8Var14.G();
                                        }
                                        SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                        PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                        PostData postData5 = (PostData) sparseArray4.get(R.id.tag_load_sub_reply_data);
                                        if (postData4 == null) {
                                            return;
                                        }
                                        if (postData4.J() == 1) {
                                            TiebaStatic.log(new StatisticItem("c12630"));
                                        }
                                        StatisticItem statisticItem17 = postData4.e0;
                                        if (statisticItem17 != null) {
                                            StatisticItem copy2 = statisticItem17.copy();
                                            copy2.delete("obj_locate");
                                            if (view2.getId() == R.id.obfuscated_res_0x7f09178c) {
                                                copy2.param("obj_locate", 6);
                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f0918f8) {
                                                copy2.param("obj_locate", 8);
                                            }
                                            TiebaStatic.log(copy2);
                                        }
                                        this.a.B4();
                                        TiebaStatic.log("c11742");
                                        if (postData5 != null) {
                                            this.a.z4(postData4, postData5, false, true);
                                            return;
                                        } else {
                                            this.a.z4(postData4, null, false, false);
                                            return;
                                        }
                                    }
                                }
                                this.a.h = view2;
                            }
                        }
                    } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.showToast(R.string.network_not_available);
                        view2.setTag(Boolean.FALSE);
                    } else {
                        this.a.o.G();
                        if (this.a.m) {
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.B4();
                        this.a.p4();
                        boolean a3 = this.a.M().a3(this.a.l3());
                        view2.setTag(Boolean.valueOf(a3));
                        if (a3) {
                            this.a.w4();
                            i4 = 1;
                            this.a.m = true;
                        } else {
                            i4 = 1;
                        }
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i4, new Object[0]);
                    }
                }
            }
        }

        public p(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }
    }

    /* loaded from: classes5.dex */
    public class q extends kp5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ VideoPbCommentFloatFragment b;

        public q(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoPbCommentFloatFragment;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kp5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel M = this.b.M();
                if (M != null) {
                    M.K2(this.a);
                }
                return lf8.c(this.b.h3(), 2, M);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements vg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public q0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (aw4.c().g()) {
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
                    foreDrawableImageView.F();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = aw4.c().g();
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
    }

    /* loaded from: classes5.dex */
    public class r implements oo5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ VideoPbCommentFloatFragment c;

        public r(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = videoPbCommentFloatFragment;
            this.a = i;
            this.b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.a);
                shareItem.l(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.c.getContext(), this.b, shareItem, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements kd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public r0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.kd5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ud8 ud8Var = this.a.W;
                if (ud8Var != null && ud8Var.e() != null && this.a.W.e().d()) {
                    VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a;
                    videoPbCommentFloatFragment.showToast(videoPbCommentFloatFragment.W.e().c());
                    if (this.a.Z != null && (this.a.Z.x() || this.a.Z.z())) {
                        this.a.Z.w(false, this.a.W.h());
                    }
                    this.a.W.a(true);
                    return true;
                } else if (this.a.S2(ReplyPrivacyCheckController.TYPE_THREAD)) {
                    return false;
                } else {
                    return true;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public s(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                z = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
            } else {
                z = false;
            }
            if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z2 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
            } else {
                z2 = false;
            }
            if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
            } else {
                z3 = false;
            }
            ug8 ug8Var = this.a.o;
            if (ug8Var != null) {
                if (z) {
                    if (z2) {
                        sparseArray.put(R.id.tag_from, 1);
                        this.a.o.C(sparseArray);
                        return;
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                    this.a.o.k0(view2);
                } else if (z2) {
                    sparseArray.put(R.id.tag_from, 0);
                    sparseArray.put(R.id.tag_check_mute_from, 1);
                    this.a.o.C(sparseArray);
                } else if (z3) {
                    ug8Var.f0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements vg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public s0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) {
                gifView.setTag(null);
                if (aw4.c().g()) {
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
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = aw4.c().g();
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
    }

    /* loaded from: classes5.dex */
    public class t implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public t(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.M() != null && this.a.M().t1() != i + 1) {
                VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a;
                videoPbCommentFloatFragment.g4(videoPbCommentFloatFragment.s3(i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements vg<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public t0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
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
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.u0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i)};
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
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ys5.a)) {
                ys5.a aVar = (ys5.a) customResponsedMessage.getData();
                ys5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements vg<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

        public u0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
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
    }

    /* loaded from: classes5.dex */
    public class v implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(u98 u98Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u98Var) == null) {
            }
        }

        public v(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, u98 u98Var, String str, int i4) {
            String v3;
            sb5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), u98Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f09070d));
                }
                this.a.o4();
                this.a.C3();
                if (this.a.m) {
                    this.a.m = false;
                }
                this.a.u4(false);
                if (z && u98Var != null) {
                    ThreadData N = u98Var.N();
                    ((VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class)).j(u98Var, i2);
                    this.a.W3(u98Var);
                    this.a.Y3(z, i2, i3, u98Var, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(u98Var.U().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(u98Var.U().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(u98Var.U().getBimg_end_time());
                    if (u98Var.G() != null && u98Var.G().size() >= 1 && u98Var.G().get(0) != null) {
                        this.a.M().I2(u98Var.G().get(0).O());
                    } else if (u98Var.X() != null) {
                        this.a.M().I2(u98Var.X().O());
                    }
                    if (this.a.q != null) {
                        this.a.q.h(u98Var.q());
                    }
                    AntiData c = u98Var.c();
                    if (c != null) {
                        this.a.O = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.O) && this.a.Z != null && this.a.Z.b() != null && (o = this.a.Z.b().o(6)) != null && !TextUtils.isEmpty(this.a.O)) {
                            ((View) o).setOnClickListener(this.a.F0);
                        }
                    }
                    if (this.a.T != null && N != null && N.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(N.getAuthor());
                        this.a.T.setLikeUserData(attentionHostData);
                    }
                    if (this.a.M() != null && this.a.M().T1()) {
                        v3 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else {
                        v3 = this.a.v3();
                    }
                    if (!StringUtils.isNull(v3)) {
                        this.a.Z.c0(TbSingleton.getInstance().getAdVertiComment(u98Var.o0(), u98Var.p0(), v3));
                    }
                } else {
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.M().D1());
                            jSONObject.put("fid", this.a.M().getForumId());
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
                    if (this.a.i3() == null) {
                        return;
                    }
                    if (i != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (this.a.M() != null && this.a.M().k1() != null) {
                            arrayList = this.a.M().k1().G();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).F() != 1)) {
                            this.a.i3().g2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else if (this.a.i3().Z1()) {
                            this.a.i3().h2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ea1));
                        } else {
                            this.a.i3().h2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ea2));
                        }
                    } else {
                        this.a.i3().g2("");
                    }
                    this.a.i3().N1();
                }
                iz8.g().h(this.a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v0 implements vg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        public v0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new RelativeLayout(this.a.getPageContext().getPageActivity());
            }
            return (RelativeLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i)};
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
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            w09 w09Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w09) && (w09Var = (w09) customResponsedMessage.getData()) != null && (agreeData = w09Var.b) != null && agreeData.agreeType == 2 && this.a.K != null && this.a.M() != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !lf8.h(this.a.M().D1())) {
                this.a.K.o(2);
                lf8.b(this.a.M().D1());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w0 implements Comparator<ea5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public w0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ea5 ea5Var, ea5 ea5Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ea5Var, ea5Var2)) == null) {
                return ea5Var.compareTo(ea5Var2);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class x implements Observer<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public x(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                this.a.d.setCurrentItem(num.intValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x0 implements FallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public x0(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.q
        public void onClick() {
            String v3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.M() != null && this.a.M().T1()) {
                    v3 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    v3 = this.a.v3();
                }
                if (!StringUtils.isNull(v3) && this.a.M() != null && this.a.M().k1() != null) {
                    v3 = TbSingleton.getInstance().getAdVertiComment(this.a.M().k1().o0(), this.a.M().k1().p0(), v3);
                }
                if (this.a.Z != null) {
                    this.a.Z.c0(v3);
                }
                if (this.a.G != null) {
                    this.a.G.setText(v3);
                }
                this.a.u4(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        public y(VideoPbCommentFloatFragment videoPbCommentFloatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbCommentFloatFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.Z.G(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.b0 != null && this.a.b0.f() != null) {
                    this.a.b0.f().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y0(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i)};
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
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.M() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.Z != null) {
                    VideoPbCommentFloatFragment videoPbCommentFloatFragment = this.a;
                    videoPbCommentFloatFragment.k4(videoPbCommentFloatFragment.Z.y());
                }
                this.a.d4();
                this.a.o.G();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i)};
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
            this.a = videoPbCommentFloatFragment;
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

    /* loaded from: classes5.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbCommentFloatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z0(VideoPbCommentFloatFragment videoPbCommentFloatFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbCommentFloatFragment, Integer.valueOf(i)};
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
            this.a = videoPbCommentFloatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                b98 b98Var = (b98) customResponsedMessage.getData();
                int type = b98Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (b98Var.a() == null) {
                                this.a.a4(false, null);
                                return;
                            } else {
                                this.a.a4(true, (MarkData) b98Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.b3((ForumManageModel.b) b98Var.a(), false);
                    return;
                }
                this.a.b4((ja8) b98Var.a());
            }
        }
    }

    public VideoPbCommentFloatFragment() {
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
        this.m = false;
        this.q = null;
        this.r = null;
        this.s = null;
        this.A = false;
        this.D = null;
        this.G = null;
        this.N = false;
        this.O = null;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.d0 = new int[2];
        this.f0 = -1;
        this.g0 = Integer.MIN_VALUE;
        this.h0 = 0;
        this.i0 = Integer.MIN_VALUE;
        this.j0 = false;
        this.r0 = new k(this);
        this.s0 = new v(this);
        this.t0 = new g0(this);
        this.u0 = new r0(this);
        this.v0 = new y0(this, 2004016);
        this.w0 = new z0(this, 2004007);
        this.x0 = new a1(this, 2921391);
        this.y0 = new b1(this, 2016450);
        this.z0 = new c1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.A0 = new a(this, 2001426);
        this.B0 = new b(this, 2001427);
        this.C0 = new c(this, 2001428);
        this.D0 = new d(this);
        this.E0 = new e(this);
        this.F0 = new f(this);
        this.G0 = new g(this, 2004008);
        this.I0 = true;
        this.J0 = new h(this);
        this.K0 = new j(this);
        this.L0 = new o(this);
        this.M0 = new p(this);
        this.N0 = new s(this);
        this.O0 = new t(this);
        this.P0 = new u(this, 2001332);
        this.Q0 = new w(this, 2016528);
        this.R0 = new z(this, 2001440);
        this.S0 = new a0(this);
        this.T0 = new e0(this, 2921509);
        this.U0 = new i0(this);
    }

    public final void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.B = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09264e);
            this.C = this.c.findViewById(R.id.obfuscated_res_0x7f0926a7);
            this.D = this.c.findViewById(R.id.obfuscated_res_0x7f0918e0);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0908d3);
            this.F = imageView;
            imageView.setOnClickListener(new c0(this));
            L3();
            this.G = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0918e3);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0918db);
            this.E = linearLayout;
            linearLayout.setOnClickListener(new d0(this));
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0918e1);
            this.H = imageView2;
            imageView2.setOnClickListener(this.M0);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0918df);
            this.I = imageView3;
            imageView3.setOnClickListener(this.M0);
            if (booleanExtra) {
                this.I.setVisibility(8);
            } else {
                this.I.setVisibility(0);
            }
            this.H.setVisibility(8);
            this.I.setPadding(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            ImageView imageView4 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0918e4);
            this.J = imageView4;
            imageView4.setOnClickListener(this.M0);
            this.K = new ch8(this.J);
            if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
                this.K.f();
            }
            if (M() != null && UbsABTestHelper.isResizeInduceSharingABTest() && !lf8.h(M().D1())) {
                this.K.f();
                lf8.b(M().D1());
            }
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0918e2);
            this.L = textView;
            textView.setVisibility(0);
            u4(false);
        }
    }

    public void R3(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) {
            View view2 = this.f;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public void T3(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048624, this, i2) == null) && i2 == 0) {
            iz8.g().h(getUniqueId(), false);
            if (u3() != null) {
                O2(u3(), true);
            }
        }
    }

    public final void g4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048659, this, i2) == null) && M() != null) {
            showLoadingView(getView());
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
            privacySettingMessage.setTid(M().D1());
            sendMessage(privacySettingMessage);
        }
    }

    public final void j4(FoldCommentActivityConfig foldCommentActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, foldCommentActivityConfig) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity instanceof PbCommentFloatActivity) {
                foldCommentActivityConfig.setBlankViewHeight(((PbCommentFloatActivity) absPbActivity).a2());
            }
        }
    }

    public void k4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z2) == null) {
            this.N = z2;
        }
    }

    public void l4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048672, this, z2) == null) {
            this.m = z2;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048691, this, z2) == null) {
            super.onUserChanged(z2);
            L3();
        }
    }

    public final void r4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048697, this, z2) == null) {
            this.Z.X(z2);
            this.Z.a0(z2);
            this.Z.i0(z2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048700, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter != null && (customViewPager = this.d) != null) {
                if (z2) {
                    i2 = customViewPager.getCurrentItem();
                } else {
                    i2 = -1;
                }
                videoPbFragmentAdapter.d(i2);
            }
        }
    }

    public void u4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048708, this, z2) != null) || this.D == null) {
            return;
        }
        k4(this.Z.y());
        if (this.N) {
            v4(z2);
        } else {
            z3(z2);
        }
    }

    public final void x4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048717, this, i2) == null) {
            xg8.c(N(), h3(), i2);
        }
    }

    public final void D3(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            op5.b(new q(this, i3), new r(this, i3, i2));
        }
    }

    @Override // com.baidu.tieba.bt5
    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.A = true;
        }
    }

    @Override // com.baidu.tieba.bt5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, context, str) == null) {
            xd8.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.A = true;
        }
    }

    public void V3(ea5 ea5Var, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048630, this, ea5Var, i2) == null) && (fallingView = this.l) != null) {
            fallingView.A(ea5Var, getPageContext(), i2, false);
        }
    }

    @Override // com.baidu.tieba.bt5
    public void g0(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048657, this, context, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.A = true;
    }

    public void n4(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048676, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            ug8 ug8Var = this.o;
            if (ug8Var == null) {
                return;
            }
            if (z2) {
                ug8Var.G();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.o.H();
            } else {
                this.o.G();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048684, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0903, viewGroup, false);
            J3();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
    public void A0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (ys5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ys5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (xd8.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new nq5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.bt5
    public void W(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048631, this, context, str, z2) == null) {
            if (xd8.c(str) && M() != null && M().D1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", M().D1()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    wa5 wa5Var = new wa5();
                    wa5Var.a = str;
                    wa5Var.b = 3;
                    wa5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, wa5Var));
                }
            } else {
                xd8.a().e(getPageContext(), str);
            }
            this.A = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048680, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.Z.C(i2, i3, intent);
            nc8 nc8Var = this.b0;
            if (nc8Var != null) {
                nc8Var.k(i2, i3, intent);
            }
            if (i2 == 25035) {
                w3(i3, intent);
            }
            if (i3 == -1) {
                if (i2 != 11009) {
                    if (i2 != 13011) {
                        switch (i2) {
                            case 25055:
                                View view2 = this.h;
                                if (view2 != null) {
                                    view2.performClick();
                                    return;
                                }
                                return;
                            case 25056:
                                View view3 = this.i;
                                if (view3 != null) {
                                    view3.performClick();
                                    return;
                                }
                                return;
                            case 25057:
                                if (g3() != null) {
                                    g3().performClick();
                                    return;
                                }
                                return;
                            case 25058:
                                View view4 = this.j;
                                if (view4 != null) {
                                    view4.performClick();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    pq8.g().m(getPageContext());
                    return;
                }
                O3();
            }
        }
    }

    public void A3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (editorTools = this.a0) != null) {
            editorTools.q();
        }
    }

    public void A4() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (fallingView = this.l) != null) {
            fallingView.C();
        }
    }

    public void B3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.getCurrentFocus() != null) {
            ej.z(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final void B4() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (voiceManager = this.t) != null) {
            voiceManager.stopPlay();
        }
    }

    public void C3() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (view2 = this.n) != null) {
            view2.setVisibility(8);
        }
    }

    public final void C4() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.T1();
        }
    }

    public void E4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            od5 od5Var = this.Z;
            if (od5Var != null) {
                k4(od5Var.y());
            }
            d4();
            this.o.G();
        }
    }

    public void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            h4(this.Z.b());
        }
    }

    @Override // com.baidu.tieba.pg8
    public PbModel.h H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.s0;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public void I3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (editorTools = this.a0) == null) {
            return;
        }
        editorTools.j();
        y3();
    }

    public boolean K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            EditorTools editorTools = this.a0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void L3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.F != null) {
            a3();
            this.F.setImageResource(R.drawable.icon_pure_post_expression24);
        }
    }

    @Override // com.baidu.tieba.pg8
    public PbModel M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.a.H1();
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pg8
    public AbsPbActivity N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<RelativeLayout> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            ug<RelativeLayout> ugVar = new ug<>(new v0(this), 10, 0);
            this.z = ugVar;
            return ugVar;
        }
        return (ug) invokeV.objValue;
    }

    public final boolean P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            PbModel M = M();
            if (M != null && M.k1() != null) {
                return AntiHelper.b(getPageContext(), M.k1().N());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (!this.H0 && this.I0) {
                UtilHelper.hideStatusBar(N(), N().getRootView());
                this.I0 = false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<ImageView> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.w == null) {
                this.w = new ug<>(new q0(this), 8, 0);
            }
            return this.w;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<View> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (this.x == null) {
                this.x = new ug<>(new t0(this), 8, 0);
            }
            return this.x;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<TextView> W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (this.v == null) {
                this.v = TbRichTextView.H(getPageContext().getPageActivity(), 8);
            }
            return this.v;
        }
        return (ug) invokeV.objValue;
    }

    public void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", V0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", V0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void d4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            c4();
            A3();
            this.b0.g();
            u4(false);
        }
    }

    public void e4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            this.f0 = -1;
            this.g0 = Integer.MIN_VALUE;
        }
    }

    public p85 f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.r;
        }
        return (p85) invokeV.objValue;
    }

    public LinearLayout g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.E;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public DetailInfoAndReplyFragment i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.e;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return (DetailInfoAndReplyFragment) this.e.b(0);
            }
            return null;
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public final void i4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            this.l.setFallingFeedbackListener(new x0(this));
        }
    }

    public int k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (getActivity() == null || getActivity().getIntent() == null) {
                return 0;
            }
            return getActivity().getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0);
        }
        return invokeV.intValue;
    }

    public View.OnClickListener m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.M0;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public View.OnClickListener n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.N0;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public void o4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            hideProgressBar();
            if (i3() != null) {
                i3().N1();
                i3().O1();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            super.onStart();
            u0().onStart(getPageContext());
        }
    }

    public au4 p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.q;
        }
        return (au4) invokeV.objValue;
    }

    public void p4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            ej.z(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public View.OnLongClickListener q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.U0;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public od5 r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            return this.Z;
        }
        return (od5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048705, this) == null) && M() != null && !dj.isEmpty(M().D1())) {
            super.taskStart();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            if (this.t == null) {
                this.t = VoiceManager.instance();
            }
            return this.t;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<GifView> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            if (this.u == null) {
                this.u = new ug<>(new s0(this), 20, 0);
            }
            return this.u;
        }
        return (ug) invokeV.objValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            PbModel H1 = this.a.H1();
            if (H1 == null) {
                return false;
            }
            return H1.b2();
        }
        return invokeV.booleanValue;
    }

    public String v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            if (!dj.isEmpty(this.M)) {
                return this.M;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(qd8.g());
            this.M = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public void w4() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048715, this) == null) && (view2 = this.n) != null) {
            view2.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.bt5
    public ug<LinearLayout> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            if (this.y == null) {
                this.y = new ug<>(new u0(this), 15, 0);
            }
            return this.y;
        }
        return (ug) invokeV.objValue;
    }

    public void y3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048719, this) != null) || this.D == null) {
            return;
        }
        this.C.setVisibility(8);
        this.D.setVisibility(8);
    }

    public final boolean D4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (M() == null) {
                return true;
            }
            if (M().k1() != null && M().k1().i0()) {
                return true;
            }
            if (M().V0()) {
                MarkData G0 = M().G0();
                if (G0 != null && M().T0() && u3() != null) {
                    MarkData B0 = M().B0(u3().getFirstVisiblePosition());
                    if (B0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", G0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (B0.getPostId() != null && !B0.getPostId().equals(G0.getPostId())) {
                        j05 j05Var = new j05(getBaseFragmentActivity());
                        j05Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f026e));
                        j05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0459, new l(this, B0, G0, j05Var));
                        j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new m(this, G0, j05Var));
                        j05Var.setOnCalcelListener(new n(this));
                        j05Var.create(getBaseFragmentActivity().getPageContext());
                        j05Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", G0);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (M().k1() != null && M().k1().G() != null && M().k1().G().size() > 0 && M().T0()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void N2() {
        Bundle extras;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && M() != null && this.a != null) {
            od5 od5Var = this.Z;
            if (od5Var != null && od5Var.t) {
                return;
            }
            nd5 nd5Var = new nd5();
            m4(nd5Var);
            od5 od5Var2 = (od5) nd5Var.a(getContext());
            this.Z = od5Var2;
            od5Var2.W(this.a.getPageContext());
            this.Z.f0(this.E0);
            this.Z.g0(this.L0);
            od5 od5Var3 = this.Z;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
            if (this.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.getIntent().getExtras();
            }
            od5Var3.A(pageContext, extras);
            this.Z.b().E(true);
            h4(this.Z.b());
            if (!M().X0()) {
                this.Z.q(M().D1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.Z.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (M().T1()) {
                this.Z.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.Z.c0(v3());
            }
        }
    }

    public final void O3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && M() != null && M().k1() != null && i3() != null && this.q != null) {
            MarkData markData = null;
            if (M().k1() != null && M().k1().i0()) {
                markData = M().B0(0);
            } else {
                CustomViewPager customViewPager = this.d;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = M().e1(j3(M().k1()));
                } else if (i3() != null) {
                    markData = M().B0(i3().S1());
                }
            }
            if (markData == null) {
                return;
            }
            p4();
            this.q.i(markData);
            if (!this.q.e()) {
                if (M() != null && !lf8.h(M().D1())) {
                    this.K.o(2);
                    lf8.b(M().D1());
                }
                this.q.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.q.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final String l3() {
        InterceptResult invokeV;
        ArrayList<PostData> G;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if (M() == null || M().k1() == null || M().k1().G() == null || (count = ListUtils.getCount((G = M().k1().G()))) == 0) {
                return "";
            }
            if (M().v1()) {
                Iterator<PostData> it = G.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.F() == 1) {
                        return next.O();
                    }
                }
            }
            int i2 = 0;
            if (u3() != null && i3() != null) {
                i2 = i3().Q1();
            }
            PostData postData = (PostData) ListUtils.getItem(G, i2);
            if (postData != null && postData.r() != null) {
                if (M().c2(postData.r().getUserId())) {
                    return postData.O();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(G, i3);
                    if (postData2 == null || postData2.r() == null || postData2.r().getUserId() == null) {
                        break;
                    } else if (M().c2(postData2.r().getUserId())) {
                        return postData2.O();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(G, i4);
                    if (postData3 == null || postData3.r() == null || postData3.r().getUserId() == null) {
                        break;
                    } else if (M().c2(postData3.r().getUserId())) {
                        return postData3.O();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void F3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.c0 = new PbFakeFloorModel(getPageContext());
            PbModel M = M();
            this.c0.Z(M.P(), M.L(), M.M(), M.K(), M.Q());
            this.c0.setFromForumId(M.getFromForumId());
            nc8 nc8Var = new nc8(getPageContext(), this.c0, this.c);
            this.b0 = nc8Var;
            nc8Var.p(new f0(this));
            this.b0.s(this.K0);
            this.c0.b0(new h0(this));
        }
    }

    public final void F4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && M() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.L(M().getForumId()) && M().k1() != null && M().k1().k() != null) {
            boolean z2 = true;
            if (M().k1().k().isLike() != 1) {
                z2 = false;
            }
            if (z2) {
                M().y0().K(M().getForumId(), M().D1());
            }
        }
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && M() != null && M().k1() != null && M().k1().N() != null) {
            ThreadData N = M().k1().N();
            N.mRecomAbTag = M().p1();
            N.mRecomWeight = M().s1();
            N.mRecomSource = M().r1();
            N.mRecomExtra = M().q1();
            N.isSubPb = M().X0();
            if (N.getFid() == 0) {
                N.setFid(dh.g(M().getForumId(), 0L));
            }
            StatisticItem i2 = uj5.i(getContext(), N, "c13562");
            if (i2 != null) {
                TiebaStatic.log(i2);
            }
        }
    }

    public boolean R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if ((M() != null && M().k1().i0()) || this.T == null || M() == null || M().k1() == null || ThreadCardUtils.isSelf(M().k1().N()) || M().k1().c() == null) {
                return true;
            }
            return this.T.checkPrivacyBeforeInvokeEditor(M().k1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (!checkUpIsLogin()) {
                if (M() != null) {
                    lg8.r("c10517", M().getForumId(), 2);
                }
            } else if (!R2()) {
            } else {
                od5 od5Var = this.Z;
                if (od5Var != null && (od5Var.x() || this.Z.z())) {
                    this.Z.w(false, null);
                    return;
                }
                if (this.a0 != null) {
                    I3();
                    if (this.a0.p(2) != null) {
                        r09.c(getPageContext(), (View) this.a0.p(2).m, false, null);
                    }
                }
                y3();
            }
        }
    }

    public void X3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048636, this) != null) || !checkUpIsLogin() || M() == null || M().k1() == null || M().k1().k() == null || P2()) {
            return;
        }
        if (M().k1().i0()) {
            T2();
            return;
        }
        if (this.U == null) {
            y17 y17Var = new y17(getPageContext());
            this.U = y17Var;
            y17Var.j(0);
            this.U.i(new j0(this));
        }
        this.U.g(M().k1().k().getId(), dh.g(M().D1(), 0L));
    }

    public final void c4() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048648, this) == null) && this.Z != null && this.a0 != null) {
            jd5.a().c(0);
            this.Z.M();
            this.Z.K();
            if (this.Z.v() != null) {
                WriteImagesInfo v2 = this.Z.v();
                if (this.Z.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v2.setMaxImagesAllowed(i2);
            }
            this.Z.d0(SendView.f);
            this.Z.h(SendView.f);
            sb5 o2 = this.a0.o(23);
            sb5 o3 = this.a0.o(2);
            sb5 o4 = this.a0.o(5);
            if (o3 != null) {
                o3.display();
            }
            if (o4 != null) {
                o4.display();
            }
            if (o2 != null) {
                o2.hide();
            }
            this.a0.invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            super.onDestroy();
            iz8.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.Q0);
            ItemCardHelper.w(null);
            u0().onDestory(getPageContext());
            ch8 ch8Var = this.K;
            if (ch8Var != null) {
                ch8Var.k();
            }
            ForumManageModel forumManageModel = this.s;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.T;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ug8 ug8Var = this.o;
            if (ug8Var != null) {
                ug8Var.m0();
            }
            nc8 nc8Var = this.b0;
            if (nc8Var != null) {
                nc8Var.m();
            }
            if (M() != null) {
                M().cancelLoadData();
                M().destory();
                if (M().g1() != null) {
                    M().g1().d();
                }
            }
            od5 od5Var = this.Z;
            if (od5Var != null) {
                od5Var.D();
            }
            this.p = null;
            r09.d();
            A4();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            super.onPause();
            this.j0 = true;
            u0().onPause();
            if (M() != null && !M().X0()) {
                this.Z.N(M().D1());
            }
            cr4.w().E();
            MessageManager.getInstance().unRegisterListener(this.B0);
            MessageManager.getInstance().unRegisterListener(this.C0);
            MessageManager.getInstance().unRegisterListener(this.A0);
            MessageManager.getInstance().unRegisterListener(this.P0);
        }
    }

    public void G4(u98 u98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, u98Var) == null) {
            if (u98Var != null && AntiHelper.o(u98Var.N())) {
                ch8 ch8Var = this.K;
                if (ch8Var != null) {
                    ch8Var.l(false);
                    this.K.k();
                }
                ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.J.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.J, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            ch8 ch8Var2 = this.K;
            if (ch8Var2 != null && ch8Var2.h()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.J.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.J.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.J, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void V2(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bVar) == null) {
            List<PostData> list = M().k1().S().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).d0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i2).d0().get(i3).O())) {
                        list.get(i2).d0().remove(i3);
                        list.get(i2).k();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).l(bVar.g);
            }
            if (z2 && i3() != null) {
                i3().X1();
            }
        }
    }

    public final void W3(u98 u98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048634, this, u98Var) != null) || u98Var == null) {
            return;
        }
        ThreadData N = u98Var.N();
        if (N != null && N.isUgcThreadType()) {
            N2();
        } else {
            m4(this.Y);
        }
        od5 od5Var = this.Z;
        if (od5Var != null) {
            k4(od5Var.y());
            this.Z.H(u98Var.c());
            this.Z.I(u98Var.k(), u98Var.U());
            this.Z.k0(N);
            if (M() != null) {
                this.Z.J(M().M0(), M().D1(), M().I0());
            }
            if (N != null) {
                this.Z.Z(N.isMutiForumThread());
            }
        }
    }

    public void Z3(u98 u98Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048640, this, u98Var) == null) && u98Var != null && u98Var.N() != null) {
            G4(u98Var);
            ImageView imageView = this.I;
            if (u98Var.i0()) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            if (u98Var.q()) {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String e3 = e3(u98Var.N().getReply_num());
            TextView textView = this.L;
            if (textView != null) {
                textView.setText(e3);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, u98Var.N()));
        }
    }

    public final String e3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048652, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f0e88);
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

    public PostData j3(u98 u98Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048666, this, u98Var)) == null) {
            PostData postData = null;
            if (u98Var == null) {
                return null;
            }
            if (u98Var.X() != null) {
                return u98Var.X();
            }
            if (!ListUtils.isEmpty(u98Var.G())) {
                Iterator<PostData> it = u98Var.G().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next != null && next.F() == 1) {
                        postData = next;
                        break;
                    }
                }
            }
            if (postData == null) {
                postData = u98Var.i();
            }
            if (postData == null) {
                postData = t3(u98Var);
            }
            if (postData != null && postData.r() != null && postData.r().getUserTbVipInfoData() != null && postData.r().getUserTbVipInfoData().getvipIntro() != null) {
                postData.r().getGodUserData().setIntro(postData.r().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, bundle) == null) {
            this.b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            H3(bundle);
            u0().onCreate(getPageContext());
            u35 u35Var = new u35();
            this.p = u35Var;
            u35Var.a = 1000L;
            if (this.o != null) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
                userMuteAddAndDelCustomMessage.from = 1;
                BdUniqueId bdUniqueId = this.o.D;
                userMuteAddAndDelCustomMessage.mId = bdUniqueId;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
                BdUniqueId bdUniqueId2 = this.o.D;
                userMuteCheckCustomMessage.mId = bdUniqueId2;
                userMuteCheckCustomMessage.setTag(bdUniqueId2);
                MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            }
            registerListener(this.Q0);
            this.g = new kc6(getPageContext());
            iz8.g().i(getUniqueId());
        }
    }

    public final PostData t3(u98 u98Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048702, this, u98Var)) == null) {
            if (u98Var != null && u98Var.N() != null && u98Var.N().getAuthor() != null) {
                PostData postData = new PostData();
                MetaData author = u98Var.N().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = u98Var.N().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                postData.J0(1);
                postData.P0(u98Var.N().getFirstPostId());
                postData.f1(u98Var.N().getTitle());
                postData.e1(u98Var.N().getCreateTime());
                postData.G0(author);
                return postData;
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    public void z3(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048721, this, z2) == null) && this.D != null && this.G != null) {
            if (M() != null && M().k1() != null) {
                this.G.setText(TbSingleton.getInstance().getAdVertiComment(M().k1().o0(), M().k1().p0(), v3()));
            } else {
                this.G.setText(v3());
            }
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.D.startAnimation(alphaAnimation);
            }
            this.C.setVisibility(0);
            this.D.setVisibility(0);
        }
    }

    public final void H3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            qd5 qd5Var = new qd5();
            this.Y = qd5Var;
            m4(qd5Var);
            od5 od5Var = (od5) this.Y.a(getActivity());
            this.Z = od5Var;
            od5Var.W(this.a.getPageContext());
            this.Z.f0(this.E0);
            this.Z.g0(this.L0);
            this.Z.Y(1);
            this.Z.d0(SendView.f);
            this.Z.h(SendView.f);
            this.Z.A(this.a.getPageContext(), bundle);
            this.Z.b().b(new vb5(getActivity()));
            this.Z.b().E(true);
            r4(true);
            if (M() != null) {
                this.Z.J(M().M0(), M().D1(), M().I0());
            }
            registerListener(this.w0);
            registerListener(this.y0);
            registerListener(this.G0);
            registerListener(this.v0);
            registerListener(this.x0);
            registerListener(this.z0);
            registerListener(this.T0);
            if (!M().X0()) {
                this.Z.q(M().D1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.Z.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (M().T1()) {
                this.Z.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.Z.c0(v3());
            }
            this.W = new ud8();
            if (this.Z.s() != null) {
                this.W.m(this.Z.s().i());
            }
            this.Z.V(this.u0);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.T = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new y(this));
        }
    }

    public void H4(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z2) == null) {
            DetailInfoAndReplyFragment i3 = i3();
            if (i3 != null && i3.C1() != null && i3.C1().d() != null && i3.C1().e() != null) {
                i3.C1().e().G(z2);
            }
            MaskView maskView = this.k;
            if (maskView != null) {
                if (z2) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                maskView.setVisibility(i2);
            }
        }
    }

    public boolean S2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) {
            if (this.T != null && M() != null && M().k1() != null && !ThreadCardUtils.isSelf(M().k1().N()) && M().k1().c() != null) {
                return this.T.checkPrivacyBeforeSend(M().k1().c().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void h4(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, editorTools) == null) {
            this.a0 = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f0918dc);
            this.a0.setOnCancelClickListener(new l0(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.a0.getParent() == null) {
                this.c.addView(this.a0, layoutParams);
            }
            this.a0.y(TbadkCoreApplication.getInst().getSkinType());
            this.a0.setActionListener(24, new m0(this));
            A3();
            this.Z.g(new n0(this));
        }
    }

    public final void m4(qd5 qd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048674, this, qd5Var) == null) && qd5Var != null && M() != null) {
            qd5Var.p(M().J0());
            if (M().k1() != null && M().k1().k() != null) {
                qd5Var.o(M().k1().k());
            }
            qd5Var.q("pb");
            qd5Var.r(M());
        }
    }

    public final void q4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048695, this, i2) != null) || M() == null) {
            return;
        }
        int t1 = M().t1();
        if (i2 != 5) {
            if (i2 != 6) {
                if (i2 != 7) {
                    M().S2(1);
                } else {
                    M().S2(4);
                }
            } else {
                M().S2(3);
            }
        } else {
            M().S2(2);
        }
        int t12 = M().t1();
        if (t1 == 4 || t12 == 4) {
            S3();
        }
    }

    public void J3() {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.H0 = z2;
            this.d = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f09197f);
            this.f = this.c.findViewById(R.id.obfuscated_res_0x7f091122);
            this.k = (MaskView) this.c.findViewById(R.id.mask_view);
            this.f.setOnClickListener(this.M0);
            E3();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.e = videoPbFragmentAdapter;
            this.d.setAdapter(videoPbFragmentAdapter);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f0926da);
            this.l = (FallingView) this.c.findViewById(R.id.obfuscated_res_0x7f090a10);
            i4();
            this.l.setAnimationListener(new b0(this));
            G3();
            F3();
            if (!this.H0 && this.I0) {
                UtilHelper.hideStatusBar(N(), N().getRootView());
                this.I0 = false;
            }
        }
    }

    public final void M2(boolean z2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048605, this, z2, str) == null) && M() != null && M().k1() != null && M().k1().N() != null) {
            ThreadData N = M().k1().N();
            N.mRecomAbTag = M().p1();
            N.mRecomWeight = M().s1();
            N.mRecomSource = M().r1();
            N.mRecomExtra = M().q1();
            if (N.getFid() == 0) {
                N.setFid(dh.g(M().getForumId(), 0L));
            }
            StatisticItem i2 = uj5.i(getContext(), N, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l2 = uj5.l(getContext());
            if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
            }
            if (i2 != null) {
                if (N.isVideoThreadType()) {
                    if (rp5.e(str) > 40) {
                        str2 = rp5.m(str, 40);
                    } else {
                        str2 = str;
                    }
                    i2.param(TiebaStatic.Params.POST_CONTENT, str2);
                }
                i2.param(TiebaStatic.Params.REPLY_TYPE, 1);
                if (z2) {
                    i2.addParam("obj_type", 2);
                } else {
                    i2.addParam("obj_type", 1);
                }
                pj5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                if (k3() == 1) {
                    i2.param("obj_locate", 4);
                } else if (k3() == 2) {
                    i2.param("obj_locate", 5);
                } else if (k3() == 3) {
                    i2.param("obj_locate", 2);
                } else if (k3() == 4) {
                    i2.param("obj_locate", 3);
                } else if (k3() == 7) {
                    i2.param("obj_locate", 7);
                } else {
                    i2.param("obj_locate", 6);
                }
                i2.addParam("obj_type", 1);
                i2.addParam("tid", M().D1());
                i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i2.addParam("fid", M().k1().l());
                TiebaStatic.log(i2);
            }
            StatisticItem i3 = uj5.i(getContext(), N, "c14180");
            if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i3.addParam("obj_type", 2);
            } else {
                i3.addParam("obj_type", 1);
            }
            i3.param("tid", M().D1());
            i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i3.param("fid", M().k1().l());
            if (l2 != null) {
                i3.param("obj_source", l2.tabType);
            }
            TiebaStatic.log(i3);
            StatisticItem i4 = uj5.i(getContext(), N, "c14303");
            if (i4 != null) {
                if (k3() == 1) {
                    i4.param("obj_locate", 1);
                } else if (k3() == 2) {
                    i4.param("obj_locate", 2);
                } else if (k3() == 3) {
                    i4.param("obj_locate", 3);
                } else if (k3() == 4) {
                    i4.param("obj_locate", 4);
                }
                i4.param("tid", M().D1());
                i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i4.param("fid", M().k1().l());
                i4.param("obj_type", 1);
            }
            TiebaStatic.log(i4);
        }
    }

    public final void M3(View view2, String str, String str2, PostData postData) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048606, this, view2, str, str2, postData) != null) || view2 == null || str == null || str2 == null || P2() || !R2()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.d0);
            this.e0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.b0 != null && postData != null) {
            if (postData.Z() != null) {
                str3 = postData.Z().toString();
            } else {
                str3 = "";
            }
            this.b0.o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.r().getName_show(), str3));
        }
        if (M() != null && M().k1() != null && M().k1().i0()) {
            gh.a().postDelayed(new o0(this, str, str2), 0L);
            return;
        }
        if (this.V == null) {
            y17 y17Var = new y17(getPageContext());
            this.V = y17Var;
            y17Var.j(1);
            this.V.i(new p0(this, str, str2));
        }
        if (M() != null && M().k1() != null && M().k1().k() != null) {
            this.V.g(M().k1().k().getId(), dh.g(M().D1(), 0L));
        }
    }

    public final void N3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || M() == null) {
            return;
        }
        u98 k1 = M().k1();
        M().Y2(true);
        au4 au4Var = this.q;
        if (au4Var != null) {
            k1.I0(au4Var.g());
        }
        if (i3() != null) {
            i3().X1();
        }
    }

    public final void S3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.o != null && M() != null) {
                this.o.G();
                if (this.m) {
                    return;
                }
                B4();
                p4();
                if (M().loadData()) {
                    w4();
                }
            }
        }
    }

    public final int h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (M() != null && M().k1() != null && M().k1().N() != null) {
                return M().k1().N().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            au4 c2 = au4.c(this.a);
            this.q = c2;
            if (c2 != null) {
                c2.j(this.t0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.s = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.J0);
            this.r = new p85(getPageContext());
            this.o = new ug8(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            super.onResume();
            this.j0 = false;
            u0().onResume(getPageContext());
            y4();
            registerListener(this.B0);
            registerListener(this.C0);
            registerListener(this.A0);
            registerListener(this.P0);
            ItemCardHelper.w(this.S0);
            MessageManager.getInstance().registerListener(this.R0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            super.onStop();
            u0().onStop(getPageContext());
            iz8.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.R0);
        }
    }

    public BdTypeRecyclerView u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            Iterator<BaseFragment> it = this.e.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).T1();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void y4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048720, this) == null) && M() != null && !dj.isEmpty(M().D1())) {
            cr4.w().P(br4.Z, dh.g(M().D1(), 0L));
        }
    }

    public void O2(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048610, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().E(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().E(firstVisiblePosition) instanceof PostData) && (postData = (PostData) bdTypeRecyclerView.getListView2().E(firstVisiblePosition)) != null && postData.o() != null) {
                        postData.o().q(postData.F());
                        arrayList.add(postData.o());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new w0(this));
                if (((ea5) ListUtils.getItem(arrayList, 0)).e() == 1) {
                    if (!z2) {
                        V3((ea5) ListUtils.getItem(arrayList, 0), 0);
                        return;
                    }
                    return;
                }
                V3((ea5) ListUtils.getItem(arrayList, 0), 1);
            }
        }
    }

    public final void t4(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048703, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (postWriteCallBackData.getIconStampData() != null) {
                    q95.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                }
                return;
            }
            if (M() != null && !M().X0()) {
                antiData.setBlock_forum_name(M().k1().k().getName());
                antiData.setBlock_forum_id(M().k1().k().getId());
                antiData.setUser_name(M().k1().U().getUserName());
                antiData.setUser_id(M().k1().U().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final boolean P3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            if (StringUtils.isNull(str) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String s2 = p35.m().s("bubble_link", "");
            if (StringUtils.isNull(s2)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
            } else {
                BrowserHelper.t(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), s2 + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean f4(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof PostData)) {
                return false;
            }
            PostData postData = (PostData) obj;
            if (!TextUtils.isEmpty(postData.t()) && aw4.c().g()) {
                return P3(postData.O());
            }
            if (checkUpIsLogin() && M() != null && M().k1() != null) {
                nc8 nc8Var = this.b0;
                if (nc8Var != null) {
                    nc8Var.g();
                }
                ja8 ja8Var = new ja8();
                ja8Var.x(M().k1().k());
                ja8Var.B(M().k1().N());
                ja8Var.z(postData);
                this.c0.c0(ja8Var);
                this.c0.setPostId(postData.O());
                M3(view2, postData.r().getUserId(), "", postData);
                TiebaStatic.log("c11743");
                od5 od5Var = this.Z;
                if (od5Var != null) {
                    k4(od5Var.y());
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f09070d));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            W3(videoPbViewModel.b());
            if (M() != null && M().k1() != null) {
                boolean T0 = M().T0();
                u98 k1 = M().k1();
                if (T0) {
                    PostData j3 = j3(k1);
                    if (k1.u() != null && !k1.u().equals(j3.O()) && (customViewPager = this.d) != null) {
                        customViewPager.setCurrentItem(0);
                    }
                }
            }
            videoPbViewModel.a().observe(getViewLifecycleOwner(), new x(this));
            this.a.J1().d(this.r0);
        }
    }

    public final boolean Q2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (M() != null) {
                M().E2(bundle);
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                u0().onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public void v4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048713, this, z2) == null) && this.D != null && (textView = this.G) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f054d);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.D.startAnimation(alphaAnimation);
            }
            this.C.setVisibility(0);
            this.D.setVisibility(0);
        }
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (M().P0() || M().S0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", M().D1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, M().D1()));
            if (D4()) {
                this.a.finish();
            }
        }
    }

    public void U3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && N() != null && this.I0 && !TbSingleton.getInstance().isNotchScreen(N()) && !TbSingleton.getInstance().isCutoutScreen(N())) {
            UtilHelper.hideStatusBar(N(), N().getRootView());
            this.I0 = false;
        }
    }

    public void W2(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue == 3) {
                if (this.s.Z()) {
                    return;
                }
                showProgressBar();
                String str = (String) sparseArray.get(R.id.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                if (sparseArray.get(R.id.tag_is_block_thread) != null) {
                    z2 = ((Boolean) sparseArray.get(R.id.tag_is_block_thread)).booleanValue();
                } else {
                    z2 = false;
                }
                if (jSONArray != null) {
                    this.s.b0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.s.c0(M().k1().k().getId(), M().k1().k().getName(), M().k1().N().getId(), str, intValue3, intValue2, booleanValue, M().k1().N().getBaijiahaoData(), z2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == 4 || intValue == 6) {
                if (M().F0() != null) {
                    M().F0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == 4) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void d3(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048649, this, i2, gVar) == null) && gVar != null && M() != null && M().k1() != null && M().k1().N() != null) {
            c3(gVar.a, gVar.b, false);
            if (gVar.a) {
                this.P = true;
                if (i2 != 2 && i2 != 3) {
                    if (i2 == 4 || i2 == 5) {
                        this.Q = false;
                        this.R = true;
                    }
                } else {
                    this.Q = true;
                    this.R = false;
                }
                if (i2 == 2) {
                    M().k1().N().setIs_good(1);
                    M().L2(1);
                } else if (i2 == 3) {
                    M().k1().N().setIs_good(0);
                    M().L2(0);
                } else if (i2 == 4) {
                    M().k1().N().setIs_top(1);
                    M().M2(1);
                } else if (i2 == 5) {
                    M().k1().N().setIs_top(0);
                    M().M2(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                    string = gVar.b;
                } else {
                    string = getString(R.string.operation_failed);
                }
                ej.Q(getPageContext().getPageActivity(), string);
            }
            if (M().k1().N() != null && i3() != null) {
                i3().c2();
            }
        }
    }

    public final void w3(int i2, Intent intent) {
        xb5 xb5Var;
        nc8 nc8Var;
        xb5 xb5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048714, this, i2, intent) == null) {
            if (i2 == 0) {
                A3();
                nc8 nc8Var2 = this.b0;
                if (nc8Var2 != null) {
                    nc8Var2.g();
                }
                u4(false);
            }
            d4();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (!(serializableExtra instanceof PbEditorData)) {
                return;
            }
            PbEditorData pbEditorData = (PbEditorData) serializableExtra;
            WriteData writeData = new WriteData();
            writeData.setContent(pbEditorData.getContent());
            writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
            writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
            int editorType = pbEditorData.getEditorType();
            if (editorType != 0) {
                if (editorType == 1 && (nc8Var = this.b0) != null && nc8Var.f() != null) {
                    sd5 f2 = this.b0.f();
                    f2.d0(M().k1().N());
                    f2.C(writeData);
                    f2.e0(pbEditorData.getVoiceModel());
                    wb5 p2 = f2.b().p(6);
                    if (p2 != null && (xb5Var2 = p2.m) != null) {
                        xb5Var2.A(new lb5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        f2.G();
                        return;
                    }
                    return;
                }
                return;
            }
            this.Z.L();
            this.Z.m0(pbEditorData.getVoiceModel());
            this.Z.B(writeData);
            wb5 p3 = this.Z.b().p(6);
            if (p3 != null && (xb5Var = p3.m) != null) {
                xb5Var.A(new lb5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.Z.G(null, null);
            }
        }
    }

    public void X2(j05 j05Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048635, this, j05Var, jSONArray) == null) {
            j05Var.dismiss();
            if (M() != null && M().k1() != null && M().k1().N() != null && M().k1().k() != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!(j05Var.getYesButtonTag() instanceof SparseArray)) {
                        return;
                    }
                    W2((SparseArray) j05Var.getYesButtonTag(), jSONArray);
                    return;
                }
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void Y2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                W2(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void Y3(boolean z2, int i2, int i3, u98 u98Var, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), u98Var, Integer.valueOf(i4)}) == null) {
            for (BaseFragment baseFragment : this.e.c()) {
                if (baseFragment instanceof og8) {
                    ((og8) baseFragment).t0(z2, i2, i3, u98Var, i4);
                }
            }
            t0(z2, i2, i3, u98Var, i4);
        }
    }

    public void a4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048642, this, z2, markData) != null) || M() == null) {
            return;
        }
        o4();
        M().Y2(z2);
        au4 au4Var = this.q;
        if (au4Var != null) {
            au4Var.h(z2);
            if (markData != null) {
                this.q.i(markData);
            }
        }
        if (M().V0()) {
            N3();
        } else if (i3() != null) {
            i3().X1();
        }
    }

    public final void s4(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048699, this, i2, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new k0(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                ug8 ug8Var = this.o;
                if (ug8Var != null) {
                    ug8Var.E0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    public final void b3(ForumManageModel.b bVar, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048643, this, bVar, z2) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            if (bVar.c == 1211066) {
                hideProgressBar();
                j05 j05Var = new j05(getPageContext().getPageActivity());
                j05Var.setMessage(string);
                j05Var.setPositiveButton(R.string.dialog_known, new i(this));
                j05Var.setCancelable(true);
                j05Var.create(getPageContext());
                j05Var.show();
            } else {
                c3(bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i2 = bVar.d;
                int i3 = 0;
                if (i2 == 1) {
                    ArrayList<PostData> G = M().k1().G();
                    int size = G.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.g.equals(G.get(i3).O())) {
                            G.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    M().k1().N().setReply_num(M().k1().N().getReply_num() - 1);
                    if (i3() != null) {
                        i3().X1();
                    }
                } else if (i2 == 0) {
                    U2();
                } else if (i2 == 2) {
                    ArrayList<PostData> G2 = M().k1().G();
                    int size2 = G2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= G2.get(i4).d0().size()) {
                                break;
                            } else if (bVar.g.equals(G2.get(i4).d0().get(i5).O())) {
                                G2.get(i4).d0().remove(i5);
                                G2.get(i4).k();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        G2.get(i4).l(bVar.g);
                    }
                    if (z3 && i3() != null) {
                        i3().X1();
                    }
                    V2(bVar);
                }
            }
        }
    }

    public SparseArray<Object> o3(u98 u98Var, int i2) {
        InterceptResult invokeLI;
        PostData j3;
        boolean z2;
        xx4 xx4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048677, this, u98Var, i2)) == null) {
            StringBuilder sb = null;
            if (u98Var == null || (j3 = j3(u98Var)) == null) {
                return null;
            }
            String userId = j3.r().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            } else {
                z2 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, j3.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(u98Var.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (j3.r() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, j3.r().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, j3.r().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, j3.r().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, j3.O());
                }
                sparseArray.put(R.id.tag_del_post_id, j3.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(u98Var.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z2) {
                List<sz4> o2 = u98Var.o();
                if (ListUtils.getCount(o2) > 0) {
                    sb = new StringBuilder();
                    for (sz4 sz4Var : o2) {
                        if (sz4Var != null && !StringUtils.isNull(sz4Var.d()) && (xx4Var = sz4Var.f) != null && xx4Var.a && !xx4Var.c && ((i3 = xx4Var.b) == 1 || i3 == 2)) {
                            sb.append(dj.cutString(sz4Var.d(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06ad));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cd), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeLI.objValue;
    }

    public void b4(ja8 ja8Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048644, this, ja8Var) == null) && M() != null && M().k1() != null && ja8Var.i() != null) {
            String O = ja8Var.i().O();
            ArrayList<PostData> G = M().k1().G();
            boolean z3 = false;
            int i2 = 0;
            while (true) {
                z2 = true;
                if (i2 >= G.size()) {
                    break;
                }
                PostData postData = G.get(i2);
                if (postData.O() != null && postData.O().equals(O)) {
                    ArrayList<PostData> k2 = ja8Var.k();
                    postData.c1(ja8Var.m());
                    if (postData.d0() != null && k2 != null) {
                        Iterator<PostData> it = k2.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.l0() != null && next != null && next.r() != null && (metaData = postData.l0().get(next.r().getUserId())) != null) {
                                next.G0(metaData);
                                next.S0(true);
                                next.l1(getPageContext(), M().c2(metaData.getUserId()));
                            }
                        }
                        if (k2.size() != postData.d0().size()) {
                            z3 = true;
                        }
                        if (!postData.s0(true)) {
                            postData.d0().clear();
                            postData.d0().addAll(k2);
                        }
                        z2 = z3;
                    }
                    if (postData.z() != null) {
                        postData.E0();
                    }
                } else {
                    i2++;
                }
            }
            if (!M().T0() && z2 && i3() != null) {
                i3().X1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i2) == null) {
            super.onChangeSkinType(i2);
            boolean z2 = true;
            UtilHelper.changeStatusBarIconAndTextColor(true, this.a);
            qv4 layoutMode = getBaseFragmentActivity().getLayoutMode();
            if (i2 != 1) {
                z2 = false;
            }
            layoutMode.l(z2);
            getBaseFragmentActivity().getLayoutMode().k(this.c);
            ud8 ud8Var = this.W;
            if (ud8Var != null) {
                ud8Var.i();
            }
            EditorTools editorTools = this.a0;
            if (editorTools != null) {
                editorTools.y(i2);
            }
            nc8 nc8Var = this.b0;
            if (nc8Var != null) {
                nc8Var.l(i2);
            }
            LinearLayout linearLayout = this.E;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ej.g(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (M() != null && M().V0()) {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.I, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.F, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            if (M() != null) {
                G4(M().k1());
            }
            SkinManager.setBackgroundColor(this.D, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.L, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundShapeDrawable(this.L, ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (i3() != null) {
                i3().onChangeSkinType(i2);
            }
            B4();
        }
    }

    @Override // com.baidu.tieba.bt5
    public void c0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048645, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.o.o0(str);
            l05 S = this.o.S();
            if (S == null) {
                this.o.X();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                S.f(1).setVisibility(8);
            } else {
                S.f(1).setVisibility(0);
            }
            S.m();
            this.A = true;
        }
    }

    public void c3(boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f12e7));
            } else if (z3) {
                if (dj.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0cfe);
                }
                showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.pg8
    public void finish() {
        CardHListViewData p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            PbModel H1 = this.a.H1();
            if (H1 != null && H1.k1() != null && H1.k1().N() != null && !H1.k1().i0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = H1.k1().N().getId();
                if (H1.isShareThread() && H1.k1().N().originalThreadData != null) {
                    historyMessage.threadName = H1.k1().N().originalThreadData.b;
                } else {
                    historyMessage.threadName = H1.k1().N().getTitle();
                }
                if (H1.isShareThread() && !v0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = H1.k1().k().getName();
                }
                ArrayList<PostData> G = H1.k1().G();
                if (G != null && G.size() > 0) {
                    historyMessage.postID = G.get(0).O();
                }
                historyMessage.isHostOnly = H1.N0();
                historyMessage.isSquence = H1.C1();
                historyMessage.isShareThread = H1.isShareThread();
                historyMessage.threadType = H1.k1().N().getThreadType();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            od5 od5Var = this.Z;
            if (od5Var != null) {
                od5Var.D();
            }
            if (H1 != null && (H1.P0() || H1.S0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", H1.D1());
                if (this.P) {
                    if (this.R) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", H1.Y0());
                    }
                    if (this.Q) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", H1.U0());
                    }
                }
                if (H1.k1() != null && System.currentTimeMillis() - this.b >= 40000 && (p2 = H1.k1().p()) != null && !ListUtils.isEmpty(p2.getDataList())) {
                    intent.putExtra("guess_like_data", p2);
                }
                this.a.setResult(-1, intent);
            }
            if (D4()) {
                if (H1 != null) {
                    u98 k1 = H1.k1();
                    if (k1 != null) {
                        if (k1.U() != null) {
                            k1.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            k1.U().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!this.S) {
                            BdTypeRecyclerView u3 = u3();
                            Parcelable parcelable = null;
                            if (u3 != null) {
                                parcelable = u3.onSaveInstanceState();
                            }
                            id8.b().l(H1.l1(), parcelable, H1.C1(), H1.N0(), false);
                        }
                    }
                } else {
                    id8.b().k();
                }
                C4();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x3(boolean z2) {
        u98 k1;
        int i2;
        ch8 ch8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048716, this, z2) == null) && M() != null && this.o != null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (k1 = M().k1()) == null) {
                return;
            }
            ThreadData N = k1.N();
            int i3 = 1;
            if (N != null && N.getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13402").param("tid", M().D1()).param("fid", k1.l()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", M().getForumId());
                statisticItem.param("tid", M().D1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", l3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", k3());
                TiebaStatic.log(statisticItem);
            }
            if (N != null) {
                if (N.isBJHArticleThreadType()) {
                    i2 = 2;
                } else if (N.isBJHVideoThreadType()) {
                    i2 = 3;
                } else if (N.isBJHNormalThreadType()) {
                    i2 = 4;
                } else if (N.isBJHVideoDynamicThreadType()) {
                    i2 = 5;
                }
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", M().D1());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("fid", M().getForumId());
                if (!z2) {
                    statisticItem2.param("obj_locate", 6);
                } else {
                    statisticItem2.param("obj_locate", 5);
                }
                statisticItem2.param("obj_name", i2);
                statisticItem2.param("obj_type", 2);
                if (N != null) {
                    if (N.isBJHArticleThreadType()) {
                        statisticItem2.param("obj_type", 10);
                    } else if (N.isBJHVideoThreadType()) {
                        statisticItem2.param("obj_type", 9);
                    } else if (N.isBJHVideoDynamicThreadType()) {
                        statisticItem2.param("obj_type", 8);
                    } else if (N.isBJHNormalThreadType()) {
                        statisticItem2.param("obj_type", 7);
                    } else if (N.isShareThread) {
                        statisticItem2.param("obj_type", 6);
                    } else {
                        int i4 = N.threadType;
                        if (i4 == 0) {
                            statisticItem2.param("obj_type", 1);
                        } else if (i4 == 40) {
                            statisticItem2.param("obj_type", 2);
                        } else if (i4 == 49) {
                            statisticItem2.param("obj_type", 3);
                        } else if (i4 == 54) {
                            statisticItem2.param("obj_type", 4);
                        } else {
                            statisticItem2.param("obj_type", 5);
                        }
                    }
                    statisticItem2.param("nid", N.getNid());
                    statisticItem2.param("card_type", N.getRecomCardType());
                    statisticItem2.param("recom_source", N.mRecomSource);
                    statisticItem2.param("ab_tag", N.mRecomAbTag);
                    statisticItem2.param("weight", N.mRecomWeight);
                    statisticItem2.param("extra", N.mRecomExtra);
                    statisticItem2.param("nid", N.getNid());
                    if (N.getBaijiahaoData() != null && !dj.isEmpty(N.getBaijiahaoData().oriUgcVid)) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, N.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                }
                if (N() != null) {
                    uj5.e(N(), statisticItem2);
                }
                ch8Var = this.K;
                if (ch8Var != null) {
                    statisticItem2.param("obj_param1", ch8Var.g());
                }
                TiebaStatic.log(statisticItem2);
                if (ej.F()) {
                    showToast(R.string.obfuscated_res_0x7f0f0cfe);
                    return;
                } else if (M().k1() == null) {
                    ej.Q(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0ea0));
                    return;
                } else {
                    ArrayList<PostData> G = k1.G();
                    if ((G == null || G.size() <= 0) && M().C1()) {
                        ej.Q(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0ea0));
                        return;
                    }
                    this.o.G();
                    B4();
                    TiebaStatic.log(new StatisticItem("c11939"));
                    if (AntiHelper.e(getContext(), N)) {
                        return;
                    }
                    ch8 ch8Var2 = this.K;
                    if (ch8Var2 != null) {
                        ch8Var2.l(false);
                        G4(k1);
                    }
                    if (ShareSwitch.isOn()) {
                        if (z2) {
                            i3 = 2;
                        }
                        if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.K.i()) {
                            this.K.m(false);
                            D3(f95.a(), this.K.g());
                            return;
                        }
                        x4(i3);
                        return;
                    }
                    this.o.w0();
                    M().E0().I(CheckRealNameModel.TYPE_PB_SHARE, 6);
                    return;
                }
            }
            i2 = 1;
            StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem22.param("tid", M().D1());
            statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem22.param("fid", M().getForumId());
            if (!z2) {
            }
            statisticItem22.param("obj_name", i2);
            statisticItem22.param("obj_type", 2);
            if (N != null) {
            }
            if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            }
            if (N() != null) {
            }
            ch8Var = this.K;
            if (ch8Var != null) {
            }
            TiebaStatic.log(statisticItem22);
            if (ej.F()) {
            }
        }
    }

    public final void z4(PostData postData, PostData postData2, boolean z2, boolean z3) {
        String str;
        int i2;
        boolean z4;
        boolean z5;
        PostData j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048722, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String D1 = M().D1();
            String O = postData.O();
            if (postData2 != null) {
                str = postData2.O();
            } else {
                str = "";
            }
            if (M().k1() != null) {
                i2 = M().k1().V();
            } else {
                i2 = 0;
            }
            if (i3() != null && i3().U1() != null) {
                AbsPbActivity.e p2 = i3().U1().p(O);
                if (postData != null && M() != null && M().k1() != null && p2 != null) {
                    if (k3() != 1 && k3() != 2 && k3() != 3 && k3() != 4 && k3() != 5) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(D1, O, "pb", true, true, null, false, str, i2, postData.g0(), M().k1().c(), false, postData.r().getIconInfo(), k3(), z4).addBigImageData(p2.a, p2.b, p2.g, p2.j);
                    if (z3) {
                        addBigImageData.setHighLightPostId(str);
                        z5 = true;
                        addBigImageData.setKeyIsUseSpid(true);
                    } else {
                        z5 = true;
                    }
                    addBigImageData.setKeyFromForumId(M().getForumId());
                    addBigImageData.setTiebaPlusData(M().P(), M().L(), M().M(), M().K(), M().Q());
                    addBigImageData.setBjhData(M().C0());
                    addBigImageData.setKeyPageStartFrom(M().j1());
                    addBigImageData.setFromFrsForumId(M().getFromForumId());
                    addBigImageData.setWorksInfoData(M().I1());
                    addBigImageData.setIsOpenEditor(z2);
                    if (M().k1().n() != null) {
                        addBigImageData.setHasForumRule(M().k1().n().has_forum_rule.intValue());
                    }
                    if (M().k1().U() != null) {
                        addBigImageData.setIsManager(M().k1().U().getIs_manager());
                    }
                    if (M().k1().k().getDeletedReasonInfo() != null) {
                        addBigImageData.setDeletedReasonInfoIsGrayCaleForum(M().k1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        addBigImageData.setDeletedReasonInfoIsIsBoomGrow(M().k1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    if (M().k1().k() != null) {
                        addBigImageData.setForumHeadUrl(M().k1().k().getImage_url());
                        addBigImageData.setUserLevel(M().k1().k().getUser_level());
                    }
                    if (M() != null && (j3 = j3(M().k1())) != null) {
                        if (!j3.S && !postData.S) {
                            z5 = false;
                        }
                        addBigImageData.setMainPostMaskVisibly(z5);
                    }
                    if (this.a.getIntent() != null) {
                        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                    }
                    addBigImageData.setForceInterceptStimeStat(this.a.isForceInterceptStimeStat());
                    sendMessage(new CustomMessage(2002001, addBigImageData));
                }
            }
        }
    }
}
