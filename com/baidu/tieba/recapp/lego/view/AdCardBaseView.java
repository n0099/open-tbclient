package com.baidu.tieba.recapp.lego.view;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.ad.VipAdFreeGuideLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.di0;
import com.baidu.tieba.dy5;
import com.baidu.tieba.e31;
import com.baidu.tieba.ei0;
import com.baidu.tieba.ey5;
import com.baidu.tieba.f31;
import com.baidu.tieba.g19;
import com.baidu.tieba.h65;
import com.baidu.tieba.hi;
import com.baidu.tieba.i38;
import com.baidu.tieba.j29;
import com.baidu.tieba.jw4;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.n15;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdLottieButtonView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.AdThreadUserInfoLayout;
import com.baidu.tieba.recapp.view.NadCustomAppInfoView;
import com.baidu.tieba.recapp.view.NadOperateBar;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.recapp.widget.NadLongProgressButton;
import com.baidu.tieba.recapp.widget.NadProgressButton;
import com.baidu.tieba.uv6;
import com.baidu.tieba.uw5;
import com.baidu.tieba.ux5;
import com.baidu.tieba.vv6;
import com.baidu.tieba.x09;
import com.baidu.tieba.xh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import tbclient.AdCloseInfo;
/* loaded from: classes6.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int A;
    public int B;
    public TextView C;
    public TextView D;
    public TextView E;
    public AdCloseView F;
    public LinearLayout G;
    public ApkDownloadView H;
    public TextView I;
    public RelativeLayout J;
    public View K;
    public AdCard L;
    public AdThreadCommentAndPraiseInfoLayout M;
    public AdThreadUserInfoLayout N;
    public View O;
    public View P;
    public FrameLayout Q;
    public View R;
    public View S;
    public AdAppInfoView T;
    public AdLottieButtonView U;
    public VipAdFreeGuideLayout V;
    public boolean W;
    public dy5 a0;
    public NadOperateBar b0;
    public NadLongProgressButton c0;
    public NadProgressButton d0;
    public NadCustomAppInfoView e0;
    public ViewTreeObserver f0;
    public ViewTreeObserver.OnGlobalLayoutListener g0;
    public RecyclerView h0;
    public View m;
    public ViewStub n;
    public View o;
    public View p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    /* loaded from: classes6.dex */
    public interface p {
        void a(Boolean bool);

        void b();
    }

    public abstract void U(AdCard adCard);

    public abstract void c0(View view2);

    public abstract int getCustomLayout();

    public abstract int getLayout();

    public void setCustomViewRadius(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, fArr) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public a(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.X("tag");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public b(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.X("title");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public c(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.F.performClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements x09 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCard a;
        public final /* synthetic */ AdCardBaseView b;

        public d(AdCardBaseView adCardBaseView, AdCard adCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView, adCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adCardBaseView;
            this.a = adCard;
        }

        @Override // com.baidu.tieba.x09
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean b = di0.b(this.b.i.getPageActivity(), this.a.downloadInfo.a);
                HashMap<String, Object> R = this.b.R("try_button");
                if (this.b.k != null) {
                    this.b.k.a(1, R);
                }
                return b;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public e(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.X("operate");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public f(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView.p
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.L.adRunTime.a = bool;
            }
        }

        @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView.p
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.s0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public g(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.a.m.getLocalVisibleRect(rect);
                if (rect.bottom == this.a.m.getHeight()) {
                    if (this.a.h0 == null) {
                        for (ViewParent parent = this.a.getParent(); parent != null; parent = parent.getParent()) {
                            if (parent instanceof RecyclerView) {
                                this.a.h0 = (RecyclerView) parent;
                                return;
                            }
                        }
                    } else if (this.a.h0.getScrollState() == 0) {
                        this.a.u0();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public h(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.X("hotarea");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public i(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                e31.a().b(this.a.getContext());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public j(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.X("username");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements AdThreadUserInfoLayout.AfterAdjustChildWidthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCard a;
        public final /* synthetic */ AdCardBaseView b;

        public k(AdCardBaseView adCardBaseView, AdCard adCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView, adCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adCardBaseView;
            this.a = adCard;
        }

        @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
        public void afterChildWidth() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((TextView) this.b.N.getUserName()).setText(this.a.userName);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ AdCardBaseView b;

        public l(AdCardBaseView adCardBaseView, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView, advertAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adCardBaseView;
            this.a = advertAppInfo;
        }

        @Override // android.view.View.OnLongClickListener
        @SuppressLint({"MissingPermission"})
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            AdvertAppInfo advertAppInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                h65 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.d() || (advertAppInfo = this.a) == null) {
                    return false;
                }
                xh.a(advertAppInfo.c());
                ((Vibrator) this.b.i.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public m(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.X("icon");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements ey5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ AdCardBaseView b;

        public n(AdCardBaseView adCardBaseView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adCardBaseView;
            this.a = str;
        }

        @Override // com.baidu.tieba.ey5.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                ux5.a(this.a);
                HashMap<String, Object> R = this.b.R(NativeConstants.ID_BUTTON);
                if (this.b.k != null) {
                    this.b.k.a(3, R);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public o(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.X(NativeConstants.ID_BUTTON);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Resources resources = tbPageContext.getResources();
        this.q = (int) resources.getDimension(R.dimen.tbds92);
        resources.getDimension(R.dimen.tbds92);
        this.r = (int) resources.getDimension(R.dimen.M_W_X004);
        resources.getDimension(R.dimen.tbds90);
        resources.getDimension(R.dimen.tbds90);
        resources.getDimension(R.dimen.tbds22);
        this.s = (int) resources.getDimension(R.dimen.M_W_X005);
        this.v = (int) resources.getDimension(R.dimen.M_W_X004);
        this.w = 0;
        this.t = (int) resources.getDimension(R.dimen.M_W_X007);
        this.u = (int) resources.getDimension(R.dimen.M_H_X005);
        this.x = (int) resources.getDimension(R.dimen.tbds208);
        this.y = (int) resources.getDimension(R.dimen.tbds33);
        this.z = (int) resources.getDimension(R.dimen.tbds72);
        this.A = (int) resources.getDimension(R.dimen.tbds48);
    }

    public final void T(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adCard) == null) {
            if (adCard.getAgreeNum() == -1 && adCard.getShareNum() == -1 && adCard.getReplyNum() == -1) {
                this.P.setVisibility(0);
                this.M.setVisibility(8);
                return;
            }
            this.P.setVisibility(8);
            this.M.setVisibility(0);
            this.M.setBarNameClickEnabled(false);
            this.M.setReplyTimeVisible(false);
            this.M.setData(adCard.getThreadData());
            if (adCard.getAgreeNum() != -1) {
                this.M.setAgreeClickable(true);
                this.M.setPraiseContainerBgGray(false);
            } else {
                this.M.setAgreeClickable(false);
                this.M.setPraiseContainerBgGray(true);
            }
            if (adCard.getShareNum() != -1) {
                this.M.setShareClickable(true);
                this.M.setShareContainerBgGray(false);
            } else {
                this.M.setShareClickable(false);
                this.M.setShareContainerBgGray(true);
            }
            this.M.setNeedAddReplyIcon(true);
            this.M.setCommentNumEnable(false);
            this.M.setCommentClickable(true);
            this.M.setReplayContainerBgGray(true);
            this.M.setShareData(adCard);
            this.M.setDisPraiseViewVisibility(false);
        }
    }

    @NonNull
    public HashMap R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("da_area", str);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public boolean n0(AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, adCard)) == null) {
            if (o0() && adCard.isPBBanner) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAppInfoMaskRadius(float[] fArr) {
        NadCustomAppInfoView nadCustomAppInfoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, fArr) == null) && (nadCustomAppInfoView = this.e0) != null && (nadCustomAppInfoView.getBackground() instanceof GradientDrawable)) {
            GradientDrawable gradientDrawable = (GradientDrawable) this.e0.getBackground();
            gradientDrawable.setCornerRadii(fArr);
            this.e0.setBackground(gradientDrawable);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.e48
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.W = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && (adThreadCommentAndPraiseInfoLayout = this.M) != null) {
            adThreadCommentAndPraiseInfoLayout.setNeedMatchStrategy(z);
        }
    }

    public final boolean p0(View view2, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, view2, viewGroup)) == null) {
            if (view2 == null || view2.getParent() == null || view2.getParent() != viewGroup) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void q0(View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048612, this, view2, viewGroup) != null) || view2 == null || !(view2.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view2.getParent()).removeView(view2);
        viewGroup.addView(view2);
    }

    public final void v0(ViewGroup.LayoutParams layoutParams, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048624, this, layoutParams, i2) == null) && layoutParams != null) {
            layoutParams.width = -2;
            layoutParams.height = i2;
        }
    }

    private void setDownloadElementVisibility(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, adCard) == null) {
            if (adCard.isNewLayout().booleanValue()) {
                this.T.setVisibility(8);
                this.e0.setVisibility(0);
                this.b0.setVisibility(0);
                this.b0.setOnClickListener(new e(this));
                this.H.setVisibility(8);
                if (adCard.isContainOperateRecommendReason().booleanValue()) {
                    this.d0.setVisibility(0);
                    this.c0.setVisibility(8);
                    return;
                }
                this.d0.setVisibility(8);
                this.c0.setVisibility(0);
                return;
            }
            this.T.setVisibility(0);
            this.e0.setVisibility(8);
            this.b0.setVisibility(8);
            this.c0.setVisibility(8);
            if (uw5.a().b("tieba_download_btn_upgrade", 0) == 1) {
                this.d0.setVisibility(0);
                this.H.setVisibility(8);
                return;
            }
            this.d0.setVisibility(8);
            this.H.setVisibility(0);
        }
    }

    public void X(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.i.showToast(R.string.obfuscated_res_0x7f0f0d1f);
                return;
            }
            AdCard adCard = this.L;
            if (adCard == null) {
                return;
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            String extInfo = this.L.getExtInfo();
            String downloadId = this.L.getDownloadId();
            String str3 = this.L.scheme;
            if (NativeConstants.ID_BUTTON.equals(str)) {
                str2 = this.L.getButtonCmdScheme();
            } else {
                str2 = this.L.cmdScheme;
            }
            int i2 = 3;
            boolean z = false;
            if (advertAppInfo != null && advertAppInfo.g() && !ei0.n(this.L.cmdScheme)) {
                z = di0.b(this.i.getPageActivity(), advertAppInfo.p);
            }
            if (!z) {
                i2 = g19.b(this.i, str3, downloadId, extInfo, str2);
            }
            HashMap<String, Object> R = R(str);
            i38 i38Var = this.k;
            if (i38Var != null) {
                i38Var.a(i2, R);
            }
        }
    }

    public final void b0(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view2) == null) && this.L.isNewLayout().booleanValue() && this.L.isNeedExecuteOperateExpandAnim().booleanValue()) {
            this.b0.setAlpha(0.0f);
            this.b0.getLayoutParams().height = 0;
            this.b0.setVisibility(8);
            this.b0.getRecommendReason().setAlpha(0.0f);
            this.b0.getRecommendReason().setVisibility(8);
            view2.setAlpha(0.0f);
            view2.setVisibility(8);
            setAppInfoMaskRadius(W(R.string.J_X16));
            setCustomViewRadius(W(R.string.J_X05));
        }
    }

    public final void O(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2.getVisibility() == 0) {
            this.Q.setVisibility(0);
            if (p0(view2, this.Q)) {
                return;
            }
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            this.Q.removeAllViews();
            view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.Q.addView(view2);
        }
    }

    @NonNull
    public float[] W(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            try {
                String[] split = TbadkCoreApplication.getInst().getContext().getResources().getString(i2).split(",");
                int min = Math.min(split.length, 4);
                float[] fArr = new float[8];
                for (int i3 = 0; i3 < min; i3++) {
                    float parseFloat = Float.parseFloat(split[i3]);
                    int i4 = i3 * 2;
                    fArr[i4] = parseFloat;
                    fArr[i4 + 1] = parseFloat;
                }
                return fArr;
            } catch (Exception unused) {
                return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            }
        }
        return (float[]) invokeI.objValue;
    }

    public final void Z(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, adCard) == null) {
            int i2 = (this.B - this.x) - this.A;
            if (o0()) {
                i2 -= this.y + this.z;
            }
            String str = adCard.recommendReason;
            if (TextUtils.isEmpty(str)) {
                str = adCard.userName;
            }
            this.I.setText(j29.e(str, this.i.getString(R.string.advert_label), i2, this.I.getPaint()));
            this.I.setOnClickListener(new a(this));
        }
    }

    public final void g0(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, adCard) == null) {
            this.H.setVisibility(8);
            this.c0.setVisibility(8);
            this.d0.setVisibility(8);
            this.T.setVisibility(8);
            this.e0.setVisibility(8);
            this.b0.setVisibility(8);
            this.D.setVisibility(0);
            this.D.setClickable(true);
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.D, R.drawable.obfuscated_res_0x7f0800c1);
            this.D.setText(adCard.getButtonText());
            this.D.setOnClickListener(new o(this));
        }
    }

    public final void j0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, adCard) == null) {
            this.M.setType(TbadkCoreApplication.getInst().getCardShowType());
            if (o0()) {
                this.M.setVisibility(8);
                this.M.setBarNameClickEnabled(false);
                this.M.setShareVisible(false);
                this.M.setShowPraiseNum(false);
                this.M.setCommentNumEnable(false);
                this.M.setReplyTimeVisible(false);
                this.O.setVisibility(0);
                this.P.setVisibility(8);
                return;
            }
            T(adCard);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: t0 */
    public void u(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, adCard) == null) {
            this.L = adCard;
            if (adCard == null) {
                return;
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            Q(adCard);
            i0(adCard, advertAppInfo);
            a0(adCard);
            h0(adCard, advertAppInfo);
            Z(adCard);
            Y(advertAppInfo, adCard);
            j0(adCard);
            x0(adCard);
            this.m.setOnClickListener(new h(this));
            if (f31.a) {
                this.m.setOnLongClickListener(new i(this));
            }
            U(adCard);
            t(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void P(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && view2 != null && view2.getVisibility() == 0) {
            this.Q.setVisibility(8);
            if (p0(view2, this.N)) {
                return;
            }
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            this.N.addAdTagView(this.G);
        }
    }

    public final View V(AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, adCard)) == null) {
            if (this.H.getVisibility() == 0) {
                return this.H;
            }
            if (!adCard.isContainOperateRecommendReason().booleanValue() && uw5.a().b("tieba_download_btn_upgrade", 0) != 1) {
                return this.c0;
            }
            return this.d0;
        }
        return (View) invokeL.objValue;
    }

    public final void a0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adCard) == null) {
            String str = adCard.threadTitle;
            if (TextUtils.isEmpty(str)) {
                this.C.setVisibility(8);
                return;
            }
            int i2 = adCard.maxTitleLine;
            if (i2 <= 0) {
                i2 = 4;
            }
            this.C.setMaxLines(i2);
            this.C.setText(str);
            this.C.setVisibility(0);
            this.C.setOnClickListener(new b(this));
        }
    }

    public final void d0(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, adCard) == null) {
            setDownloadElementVisibility(adCard);
            View V = V(adCard);
            w0(adCard, V);
            b0(V);
            this.D.setVisibility(8);
            V.setClickable(true);
            if (V instanceof ey5) {
                ey5 ey5Var = (ey5) V;
                ey5Var.setOnClickInterceptListener(new n(this, adCard.getButtonCmdScheme()));
                this.a0 = new dy5(ey5Var, j29.d(adCard));
            }
        }
    }

    public final void x0(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, adCard) == null) {
            if (adCard.gameModel == null && this.U == null) {
                return;
            }
            AdLottieButtonView adLottieButtonView = this.U;
            if ((adLottieButtonView == null || adLottieButtonView.getParent() == null) && !e0()) {
                return;
            }
            this.U.setData(adCard.gameModel);
            this.U.setClickListener(new d(this, adCard));
        }
    }

    public final void Q(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
            layoutParams.topMargin = this.i.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            this.K.setPadding(0, 0, 0, 0);
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
            if (o0()) {
                View view2 = this.m;
                int i2 = this.t;
                view2.setPadding(i2, this.u, i2, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
                int l2 = (hi.l(getContext()) - (this.w * 2)) - (this.t * 2);
                int i3 = this.q;
                int i4 = this.r;
                this.B = (l2 - i3) - i4;
                layoutParams2.leftMargin = i3 + i4;
                this.S.setVisibility(0);
                P(this.G);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.V.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
                    layoutParams3.leftMargin = 0;
                    layoutParams3.rightMargin = 0;
                }
                if (n0(adCard)) {
                    this.S.setVisibility(8);
                    this.m.setPadding(0, 0, 0, 0);
                    View view3 = this.K;
                    int i5 = this.t;
                    view3.setPadding(i5, 0, i5, 0);
                    this.V.setLayoutPadding(-1, -1, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007));
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.V.getLayoutParams();
                    if (layoutParams4 != null) {
                        int i6 = this.t;
                        layoutParams4.leftMargin = -i6;
                        layoutParams4.rightMargin = -i6;
                    }
                    layoutParams2.leftMargin = 0;
                    this.B = (hi.l(getContext()) - (this.t * 2)) - (this.w * 2);
                    layoutParams.topMargin = this.i.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                    this.R.setVisibility(0);
                    SkinManager.setBackgroundColor(this.R, R.color.CAM_X0204);
                    O(this.G);
                    return;
                }
                ViewGroup.LayoutParams layoutParams5 = getLayoutParams();
                if (this.W) {
                    v0(layoutParams5, -1);
                    this.p.setVisibility(0);
                    this.p.bringToFront();
                    SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
                    return;
                }
                v0(layoutParams5, -2);
                this.p.setVisibility(8);
                return;
            }
            View view4 = this.m;
            int i7 = this.s;
            view4.setPadding(i7, this.u, i7, 0);
            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.V.getLayoutParams();
            if (layoutParams6 != null) {
                int i8 = this.s;
                layoutParams6.leftMargin = -i8;
                layoutParams6.rightMargin = -i8;
            }
            this.B = (hi.l(getContext()) - (this.s * 2)) - (this.v * 2);
            if ((vv6.f().i() || uv6.h().j()) && m0()) {
                this.p.setVisibility(0);
                SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
            } else {
                this.p.setVisibility(8);
            }
            this.S.setVisibility(8);
        }
    }

    public final Boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.L.isNewLayout().booleanValue()) {
                return Boolean.FALSE;
            }
            if (!this.L.isNeedExecuteOperateExpandAnim().booleanValue()) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        return (Boolean) invokeV.objValue;
    }

    public final void Y(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, advertAppInfo, adCard) == null) {
            if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
                this.F.setVisibility(0);
                this.F.setPage(getBusinessType());
                this.F.setData(advertAppInfo, adCard.closeInfo);
                hi.b(this.i.getPageActivity(), this.G, 40, 40, 40, 120);
                this.G.setOnClickListener(new c(this));
                return;
            }
            this.F.setVisibility(8);
            this.E.setOnClickListener(null);
        }
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!(this.o instanceof RelativeLayout)) {
                return false;
            }
            AdLottieButtonView adLottieButtonView = new AdLottieButtonView(this.i.getPageActivity());
            this.U = adLottieButtonView;
            adLottieButtonView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = hi.g(this.i.getPageActivity(), R.dimen.M_H_X003);
            layoutParams.leftMargin = hi.g(this.i.getPageActivity(), R.dimen.M_W_X004);
            View view2 = this.o;
            if (view2 instanceof RelativeLayout) {
                ((RelativeLayout) view2).addView(this.U, layoutParams);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.m = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
            this.G = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0070, (ViewGroup) null);
            ViewStub viewStub = (ViewStub) this.m.findViewById(R.id.obfuscated_res_0x7f0900a2);
            this.n = viewStub;
            viewStub.setLayoutResource(getCustomLayout());
            this.o = this.n.inflate();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.e48
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && o0()) {
            this.C.setTextSize(0, TbConfig.getContentSize());
        }
    }

    public View getPbAdBottomDivider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.S;
        }
        return (View) invokeV.objValue;
    }

    public View getPbBottomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.O;
        }
        return (View) invokeV.objValue;
    }

    public VipAdFreeGuideLayout getVipAdFreeGuideLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.V;
        }
        return (VipAdFreeGuideLayout) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (getBusinessType() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (getBusinessType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.b == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (getBusinessType() == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onDetachedFromWindow();
            ViewTreeObserver viewTreeObserver = this.f0;
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                this.f0.removeOnGlobalLayoutListener(this.g0);
            }
            this.g0 = null;
            this.f0 = null;
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            setAppInfoMaskRadius(W(R.string.J_X02));
            setCustomViewRadius(W(R.string.J_X13));
        }
    }

    public void setUseDynamicLikeRes() {
        AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (adThreadCommentAndPraiseInfoLayout = this.M) != null) {
            adThreadCommentAndPraiseInfoLayout.setUseDynamicLikeRes();
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048623, this) != null) || !S().booleanValue()) {
            return;
        }
        this.b0.startExpandAnim(this.L.operate.e, new f(this));
    }

    public final void h0(AdCard adCard, AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, adCard, advertAppInfo) == null) {
            if (adCard != null && advertAppInfo != null) {
                this.J.setVisibility(0);
                dy5 dy5Var = this.a0;
                if (dy5Var != null) {
                    dy5Var.k();
                    this.a0 = null;
                }
                if (advertAppInfo.g()) {
                    d0(adCard);
                    return;
                } else if (advertAppInfo.i()) {
                    g0(adCard);
                    return;
                } else {
                    return;
                }
            }
            this.J.setVisibility(8);
        }
    }

    public final void i0(AdCard adCard, AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, adCard, advertAppInfo) == null) {
            AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
            if (advertAppInfo2 != null) {
                advertAppInfo2.setThreadExtendInfo(StringHelper.getFormatTimeForJustNow(adCard.getTime()));
            }
            this.N.setShowFlag(1413);
            this.N.setData(advertAppInfo2);
            ((TextView) this.N.getUserName()).setText(adCard.userName);
            HomeGroupUbsUIHelper.handleHeadSegmentTitleView((TextView) this.N.getUserName());
            this.N.getUserName().setOnClickListener(new j(this));
            this.N.setAfterAdjustChildWidthListener(new k(this, adCard));
            this.N.getHeaderImg().setOnLongClickListener(new l(this, advertAppInfo));
            if (this.N.getHeaderImg() != null) {
                this.N.getHeaderImg().setClickable(true);
                this.N.getHeaderImg().setOnClickListener(new m(this));
            }
            if (n0(adCard)) {
                this.N.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.m == null) {
                this.m = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) this, false);
            }
            this.R = this.m.findViewById(R.id.obfuscated_res_0x7f090339);
            View findViewById = this.m.findViewById(R.id.obfuscated_res_0x7f092396);
            this.p = findViewById;
            findViewById.setClickable(true);
            this.C = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f090106);
            this.D = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f092515);
            this.H = (ApkDownloadView) this.m.findViewById(R.id.obfuscated_res_0x7f090147);
            this.I = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f09014b);
            this.J = (RelativeLayout) this.m.findViewById(R.id.obfuscated_res_0x7f09045c);
            this.K = this.m.findViewById(R.id.obfuscated_res_0x7f090541);
            AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout = (AdThreadCommentAndPraiseInfoLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0905b7);
            this.M = adThreadCommentAndPraiseInfoLayout;
            adThreadCommentAndPraiseInfoLayout.setStyle(1);
            if (k0() || l0()) {
                setUseDynamicLikeRes();
                setNeedMatchStrategy(true);
            }
            this.N = (AdThreadUserInfoLayout) this.m.findViewById(R.id.obfuscated_res_0x7f090542);
            this.Q = (FrameLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0904b4);
            if (this.G == null) {
                this.G = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0070, (ViewGroup) null);
            }
            AdCloseView adCloseView = (AdCloseView) this.G.findViewById(R.id.obfuscated_res_0x7f09009b);
            this.F = adCloseView;
            adCloseView.k.getLayoutParams().height = hi.g(getContext(), R.dimen.tbds76);
            this.F.k.getLayoutParams().width = hi.g(getContext(), R.dimen.tbds76);
            TextView textView = (TextView) this.G.findViewById(R.id.obfuscated_res_0x7f090a9e);
            this.E = textView;
            textView.setVisibility(8);
            this.N.addAdTagView(this.G);
            if (this.o == null) {
                ViewStub viewStub = (ViewStub) this.m.findViewById(R.id.obfuscated_res_0x7f0900a2);
                this.n = viewStub;
                viewStub.setLayoutResource(getCustomLayout());
                this.o = this.n.inflate();
            }
            this.O = this.m.findViewById(R.id.obfuscated_res_0x7f09196e);
            this.P = this.m.findViewById(R.id.obfuscated_res_0x7f090bff);
            this.S = this.m.findViewById(R.id.obfuscated_res_0x7f091968);
            AdAppInfoView adAppInfoView = (AdAppInfoView) this.m.findViewById(R.id.obfuscated_res_0x7f0902ab);
            this.T = adAppInfoView;
            n15 d2 = n15.d(adAppInfoView);
            d2.o(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            NadCustomAppInfoView nadCustomAppInfoView = (NadCustomAppInfoView) this.m.findViewById(R.id.obfuscated_res_0x7f091754);
            this.e0 = nadCustomAppInfoView;
            n15.d(nadCustomAppInfoView).o(R.string.J_X16);
            NadOperateBar nadOperateBar = (NadOperateBar) this.m.findViewById(R.id.obfuscated_res_0x7f091789);
            this.b0 = nadOperateBar;
            n15 d3 = n15.d(nadOperateBar);
            d3.o(R.string.J_X16);
            d3.f(R.color.CAM_X0905);
            c0(this.o);
            this.V = (VipAdFreeGuideLayout) this.m.findViewById(R.id.obfuscated_res_0x7f090605);
            this.c0 = (NadLongProgressButton) this.m.findViewById(R.id.obfuscated_res_0x7f09177d);
            this.d0 = (NadProgressButton) this.m.findViewById(R.id.obfuscated_res_0x7f09178b);
            this.f0 = this.m.getViewTreeObserver();
            g gVar = new g(this);
            this.g0 = gVar;
            ViewTreeObserver viewTreeObserver = this.f0;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(gVar);
            }
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: r0 */
    public void t(AdCard adCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048613, this, adCard, i2) == null) {
            this.F.onChangeSkinType();
            this.N.onChangeSkinType(this.i, TbadkCoreApplication.getInst().getSkinType());
            this.M.onChangeSkinType();
            if (getBusinessType() == 1 || getBusinessType() == 2) {
                View view2 = this.m;
                view2.setBackgroundDrawable(j29.f(R.string.J_X06, R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50, view2.getMeasuredHeight()));
            }
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor((TextView) this.N.getUserName());
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0105, 1);
            ThreadCardUtils.setAbstractStyleAb(this.C);
            SkinManager.setViewTextColor(this.I, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.E, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.D, R.drawable.obfuscated_res_0x7f0800c1);
            SkinManager.setBackgroundColor(this.S, R.color.CAM_X0203);
            SkinManager.setBackgroundColor(this.R, R.color.CAM_X0204);
            if (V(adCard) instanceof ey5) {
                ((ey5) V(adCard)).onChangeSkinType(i2);
            }
            n15 d2 = n15.d(this.T);
            d2.o(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            n15 d3 = n15.d(this.b0);
            d3.o(R.string.J_X16);
            d3.f(R.color.CAM_X0905);
            this.T.onChangeSkinType();
            this.e0.onChangeSkinType();
            this.V.f();
        }
    }

    public final void w0(AdCard adCard, View view2) {
        RelativeLayout downloadButtonContainer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, adCard, view2) == null) {
            jw4 appInfoModel = adCard.getAppInfoModel();
            if (this.T.getVisibility() == 0) {
                downloadButtonContainer = this.T.getDownloadButtonContainer();
            } else {
                downloadButtonContainer = this.b0.getDownloadButtonContainer(adCard.isContainOperateRecommendReason().booleanValue());
            }
            if (jw4.a(appInfoModel)) {
                if (this.T.getVisibility() == 0) {
                    this.T.setAppInfo(appInfoModel);
                    this.T.setAd(adCard.getAdvertAppInfo());
                } else {
                    this.e0.setAppInfo(adCard);
                    this.b0.setRecommendReason(this.L.operate.d);
                    this.b0.setAdInfo(adCard.getAdvertAppInfo(), this.L.adRunTime.a.booleanValue());
                }
                if (p0(view2, downloadButtonContainer)) {
                    return;
                }
                q0(view2, downloadButtonContainer);
                return;
            }
            this.T.setVisibility(8);
            if (p0(view2, this.J)) {
                return;
            }
            q0(view2, this.J);
        }
    }
}
