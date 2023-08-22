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
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.ad.VipAdFreeGuideLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.d56;
import com.baidu.tieba.i1a;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.m61;
import com.baidu.tieba.n56;
import com.baidu.tieba.o56;
import com.baidu.tieba.og7;
import com.baidu.tieba.oj0;
import com.baidu.tieba.p1a;
import com.baidu.tieba.p51;
import com.baidu.tieba.pg7;
import com.baidu.tieba.pj0;
import com.baidu.tieba.q51;
import com.baidu.tieba.recapp.lego.controller.NadTagController;
import com.baidu.tieba.recapp.lego.controller.NadTitleController;
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
import com.baidu.tieba.s1a;
import com.baidu.tieba.t19;
import com.baidu.tieba.y05;
import com.baidu.tieba.y2a;
import com.baidu.tieba.zb5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import tbclient.AdCloseInfo;
/* loaded from: classes7.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdCloseView A;
    public LinearLayout B;
    public ApkDownloadView C;
    public RelativeLayout D;
    public View E;
    public AdCard F;
    public AdThreadCommentAndPraiseInfoLayout G;
    public AdThreadUserInfoLayout H;
    public View I;
    public View J;
    public FrameLayout K;
    public View L;
    public View M;
    public AdAppInfoView N;
    public AdLottieButtonView O;
    public VipAdFreeGuideLayout P;
    public boolean Q;
    public n56 R;
    public NadOperateBar S;

    /* renamed from: T  reason: collision with root package name */
    public NadLongProgressButton f1164T;
    public NadProgressButton U;
    public NadCustomAppInfoView V;
    public ViewTreeObserver W;
    public ViewTreeObserver.OnGlobalLayoutListener a0;
    public RecyclerView b0;
    public TextView c0;
    public NadTitleController d0;
    public NadTagController e0;
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
    public int x;
    public TextView y;
    public TextView z;

    /* loaded from: classes7.dex */
    public interface p {
        void a(Boolean bool);

        void onAnimStart();
    }

    public abstract void V(AdCard adCard);

    public abstract void d0(View view2);

    public abstract int getCustomLayout();

    public abstract int getLayout();

    public void setCustomViewRadius(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, fArr) == null) {
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.Y("tag");
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.Y("title");
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.A.performClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements i1a {
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

        @Override // com.baidu.tieba.i1a
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean b = oj0.b(this.b.i.getPageActivity(), this.a.downloadInfo.a);
                HashMap<String, Object> S = this.b.S("try_button");
                if (this.b.k != null) {
                    this.b.k.a(1, S);
                }
                return b;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.Y("operate");
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.F.adRunTime.a = bool;
            }
        }

        @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView.p
        public void onAnimStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.t0();
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    if (this.a.b0 == null) {
                        for (ViewParent parent = this.a.getParent(); parent != null; parent = parent.getParent()) {
                            if (parent instanceof RecyclerView) {
                                this.a.b0 = (RecyclerView) parent;
                                return;
                            }
                        }
                    } else if (this.a.b0.getScrollState() == 0) {
                        this.a.v0();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.Y("hotarea");
            }
        }
    }

    /* loaded from: classes7.dex */
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
                p51.a().b(this.a.getContext());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.Y("username");
            }
        }
    }

    /* loaded from: classes7.dex */
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
                ((TextView) this.b.H.getUserName()).setText(this.a.userName);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                zb5 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.d() || (advertAppInfo = this.a) == null) {
                    return false;
                }
                AndroidUtils.copyToClipboard(advertAppInfo.c());
                ((Vibrator) this.b.i.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.Y("icon");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements o56.a {
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

        @Override // com.baidu.tieba.o56.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                d56.a(this.a);
                HashMap<String, Object> S = this.b.S(NativeConstants.ID_BUTTON);
                if (this.b.k != null) {
                    this.b.k.a(3, S);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.Y(NativeConstants.ID_BUTTON);
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
    }

    private void setDownloadElementVisibility(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, adCard) == null) {
            if (adCard.isNewLayout()) {
                this.N.setVisibility(8);
                this.V.setVisibility(0);
                this.S.setVisibility(0);
                this.S.setOnClickListener(new e(this));
                this.C.setVisibility(8);
                if (adCard.isContainOperateRecommendReason()) {
                    this.U.setVisibility(0);
                    this.f1164T.setVisibility(8);
                    return;
                }
                this.U.setVisibility(8);
                this.f1164T.setVisibility(0);
                return;
            }
            this.N.setVisibility(0);
            this.V.setVisibility(8);
            this.S.setVisibility(8);
            this.f1164T.setVisibility(8);
            if (p1a.a.a()) {
                this.U.setVisibility(0);
                this.C.setVisibility(8);
                return;
            }
            this.U.setVisibility(8);
            this.C.setVisibility(0);
        }
    }

    public void Y(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.i.showToast(R.string.obfuscated_res_0x7f0f0e29);
                return;
            }
            AdCard adCard = this.F;
            if (adCard == null) {
                return;
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            String extInfo = this.F.getExtInfo();
            String downloadId = this.F.getDownloadId();
            String str3 = this.F.scheme;
            if (NativeConstants.ID_BUTTON.equals(str)) {
                str2 = this.F.getButtonCmdScheme();
            } else {
                str2 = this.F.cmdScheme;
            }
            int i2 = 3;
            boolean z = false;
            if (advertAppInfo != null && advertAppInfo.e() && !pj0.n(this.F.cmdScheme)) {
                z = oj0.b(this.i.getPageActivity(), advertAppInfo.q);
            }
            if (!z) {
                i2 = s1a.b(this.i, str3, downloadId, extInfo, str2);
            }
            HashMap<String, Object> S = S(str);
            t19 t19Var = this.k;
            if (t19Var != null) {
                t19Var.a(i2, S);
            }
        }
    }

    public final void h0(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, adCard) == null) {
            this.C.setVisibility(8);
            this.f1164T.setVisibility(8);
            this.U.setVisibility(8);
            setCustomViewRadius(X(R.string.J_X05));
            this.N.setVisibility(8);
            this.V.setVisibility(8);
            this.S.setVisibility(8);
            this.y.setVisibility(0);
            this.y.setClickable(true);
            SkinManager.setViewTextColor(this.y, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.y, R.drawable.obfuscated_res_0x7f0800d9);
            this.y.setText(adCard.getButtonText());
            this.y.setOnClickListener(new o(this));
        }
    }

    @NonNull
    public HashMap S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("da_area", str);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public final void b0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adCard) == null) {
            this.d0.update(adCard, this.x, new b(this));
        }
    }

    public boolean o0(AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, adCard)) == null) {
            if (p0() && adCard.isPBBanner) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAppInfoMaskRadius(float[] fArr) {
        NadCustomAppInfoView nadCustomAppInfoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, fArr) == null) && (nadCustomAppInfoView = this.V) != null && (nadCustomAppInfoView.getBackground() instanceof GradientDrawable)) {
            GradientDrawable gradientDrawable = (GradientDrawable) this.V.getBackground();
            gradientDrawable.setCornerRadii(fArr);
            this.V.setBackground(gradientDrawable);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.o29
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.Q = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z) == null) && (adThreadCommentAndPraiseInfoLayout = this.G) != null) {
            adThreadCommentAndPraiseInfoLayout.setNeedMatchStrategy(z);
        }
    }

    public final boolean q0(View view2, ViewGroup viewGroup) {
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

    public final void r0(View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048612, this, view2, viewGroup) != null) || view2 == null || !(view2.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view2.getParent()).removeView(view2);
        viewGroup.addView(view2);
    }

    public final void w0(ViewGroup.LayoutParams layoutParams, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048624, this, layoutParams, i2) == null) && layoutParams != null) {
            layoutParams.width = -2;
            layoutParams.height = i2;
        }
    }

    public final void P(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2.getVisibility() == 0) {
            this.K.setVisibility(0);
            if (q0(view2, this.K)) {
                return;
            }
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            this.K.removeAllViews();
            view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.K.addView(view2);
        }
    }

    @NonNull
    public float[] X(@StringRes int i2) {
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

    public final void a0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, adCard) == null) {
            this.e0.update(adCard, this.x, o0(adCard), new a(this));
            if (adCard.hitAdTagMove()) {
                this.c0.setVisibility(0);
                String string = this.i.getString(R.string.advert_label);
                if (!TextUtils.isEmpty(adCard.nadTagModel.a)) {
                    string = adCard.nadTagModel.a;
                }
                this.c0.setText(string);
                this.c0.setTextColor(y2a.h(adCard.nadTagModel.b, SkinManager.getColor(R.color.CAM_X0619)));
                return;
            }
            this.c0.setVisibility(8);
        }
    }

    public final void k0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, adCard) == null) {
            this.G.setType(TbadkCoreApplication.getInst().getCardShowType());
            if (p0()) {
                this.G.setVisibility(8);
                this.G.setBarNameClickEnabled(false);
                this.G.setShareVisible(false);
                this.G.setShowPraiseNum(false);
                this.G.setCommentNumEnable(false);
                this.G.setReplyTimeVisible(false);
                this.I.setVisibility(0);
                this.J.setVisibility(8);
                return;
            }
            U(adCard);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: u0 */
    public void v(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, adCard) == null) {
            this.F = adCard;
            if (adCard == null) {
                return;
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            R(adCard);
            j0(adCard, advertAppInfo);
            b0(adCard);
            i0(adCard, advertAppInfo);
            a0(adCard);
            Z(advertAppInfo, adCard);
            k0(adCard);
            y0(adCard);
            this.m.setOnClickListener(new h(this));
            if (q51.a) {
                this.m.setOnLongClickListener(new i(this));
            }
            V(adCard);
            u(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void Q(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && view2 != null && view2.getVisibility() == 0) {
            this.K.setVisibility(8);
            if (q0(view2, this.H)) {
                return;
            }
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            this.H.addAdTagView(this.B);
        }
    }

    public final View W(AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, adCard)) == null) {
            if (adCard.isNewLayout()) {
                if (!adCard.isContainOperateRecommendReason()) {
                    return this.f1164T;
                }
                return this.U;
            } else if (p1a.a.a()) {
                return this.U;
            } else {
                return this.C;
            }
        }
        return (View) invokeL.objValue;
    }

    public final void e0(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, adCard) == null) {
            setDownloadElementVisibility(adCard);
            View W = W(adCard);
            x0(adCard, W);
            c0(W);
            this.y.setVisibility(8);
            W.setClickable(true);
            if (W instanceof o56) {
                o56 o56Var = (o56) W;
                o56Var.setOnClickInterceptListener(new n(this, adCard.getButtonCmdScheme()));
                this.R = new n56(o56Var, y2a.d(adCard));
            }
        }
    }

    public final void y0(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, adCard) == null) {
            if (adCard.gameModel == null && this.O == null) {
                return;
            }
            AdLottieButtonView adLottieButtonView = this.O;
            if ((adLottieButtonView == null || adLottieButtonView.getParent() == null) && !f0()) {
                return;
            }
            this.O.setData(adCard.gameModel);
            this.O.setClickListener(new d(this, adCard));
        }
    }

    public final void R(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            layoutParams.topMargin = this.i.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            this.E.setPadding(0, 0, 0, 0);
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            if (p0()) {
                View view2 = this.m;
                int i2 = this.t;
                view2.setPadding(i2, this.u, i2, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
                int equipmentWidth = (BdUtilHelper.getEquipmentWidth(getContext()) - (this.w * 2)) - (this.t * 2);
                int i3 = this.q;
                int i4 = this.r;
                this.x = (equipmentWidth - i3) - i4;
                layoutParams2.leftMargin = i3 + i4;
                this.M.setVisibility(0);
                Q(this.B);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.P.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
                    layoutParams3.leftMargin = 0;
                    layoutParams3.rightMargin = 0;
                }
                if (o0(adCard)) {
                    this.M.setVisibility(8);
                    this.m.setPadding(0, 0, 0, 0);
                    View view3 = this.E;
                    int i5 = this.t;
                    view3.setPadding(i5, 0, i5, 0);
                    this.P.setLayoutPadding(-1, -1, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007));
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.P.getLayoutParams();
                    if (layoutParams4 != null) {
                        int i6 = this.t;
                        layoutParams4.leftMargin = -i6;
                        layoutParams4.rightMargin = -i6;
                    }
                    layoutParams2.leftMargin = 0;
                    this.x = (BdUtilHelper.getEquipmentWidth(getContext()) - (this.t * 2)) - (this.w * 2);
                    layoutParams.topMargin = this.i.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                    this.L.setVisibility(0);
                    SkinManager.setBackgroundColor(this.L, R.color.CAM_X0204);
                    P(this.B);
                    return;
                }
                ViewGroup.LayoutParams layoutParams5 = getLayoutParams();
                if (this.Q) {
                    w0(layoutParams5, -1);
                    this.p.setVisibility(0);
                    this.p.bringToFront();
                    SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
                    return;
                }
                w0(layoutParams5, -2);
                this.p.setVisibility(8);
                return;
            }
            View view4 = this.m;
            int i7 = this.s;
            view4.setPadding(i7, this.u, i7, 0);
            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.P.getLayoutParams();
            if (layoutParams6 != null) {
                int i8 = this.s;
                layoutParams6.leftMargin = -i8;
                layoutParams6.rightMargin = -i8;
            }
            this.x = (BdUtilHelper.getEquipmentWidth(getContext()) - (this.s * 2)) - (this.v * 2);
            if ((pg7.f().i() || og7.h().j()) && n0()) {
                this.p.setVisibility(0);
                SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
            } else {
                this.p.setVisibility(8);
            }
            this.M.setVisibility(8);
        }
    }

    public final Boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdCard adCard = this.F;
            if (adCard == null) {
                return Boolean.FALSE;
            }
            if (!adCard.isNewLayout()) {
                return Boolean.FALSE;
            }
            if (!this.F.isNeedExecuteOperateExpandAnim()) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        return (Boolean) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.o29
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && p0()) {
            this.d0.m().setTextSize(0, TbConfig.getContentSize());
        }
    }

    public View getPbAdBottomDivider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.M;
        }
        return (View) invokeV.objValue;
    }

    public View getPbBottomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.I;
        }
        return (View) invokeV.objValue;
    }

    public VipAdFreeGuideLayout getVipAdFreeGuideLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.P;
        }
        return (VipAdFreeGuideLayout) invokeV.objValue;
    }

    public boolean l0() {
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

    public boolean m0() {
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

    public final boolean n0() {
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onDetachedFromWindow();
            ViewTreeObserver viewTreeObserver = this.W;
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                this.W.removeOnGlobalLayoutListener(this.a0);
            }
            this.a0 = null;
            this.W = null;
        }
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (getBusinessType() == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setUseDynamicLikeRes() {
        AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (adThreadCommentAndPraiseInfoLayout = this.G) != null) {
            adThreadCommentAndPraiseInfoLayout.setUseDynamicLikeRes();
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            setAppInfoMaskRadius(X(R.string.J_X02));
            setCustomViewRadius(X(R.string.J_X13));
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048623, this) != null) || !T().booleanValue()) {
            return;
        }
        this.S.startExpandAnim(this.F.operate.e, new f(this));
    }

    public final void U(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adCard) == null) {
            if (adCard.getAgreeNum() == -1 && adCard.getShareNum() == -1 && adCard.getReplyNum() == -1) {
                this.J.setVisibility(0);
                this.G.setVisibility(8);
                return;
            }
            this.J.setVisibility(8);
            this.G.setVisibility(0);
            this.G.setBarNameClickEnabled(false);
            this.G.setReplyTimeVisible(false);
            this.G.setData(adCard.getThreadData());
            if (adCard.getAgreeNum() != -1) {
                this.G.setAgreeClickable(true);
                this.G.setPraiseContainerBgGray(false);
            } else {
                this.G.setAgreeClickable(false);
                this.G.setPraiseContainerBgGray(true);
            }
            if (adCard.getShareNum() != -1) {
                this.G.setShareClickable(true);
                this.G.setShareContainerBgGray(false);
            } else {
                this.G.setShareClickable(false);
                this.G.setShareContainerBgGray(true);
            }
            this.G.setNeedAddReplyIcon(true);
            this.G.setCommentNumEnable(false);
            this.G.setCommentClickable(true);
            this.G.setReplayContainerBgGray(true);
            this.G.setShareData(adCard);
            this.G.setDisPraiseViewVisibility(false);
        }
    }

    public final void c0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            if (this.F.isNewLayout()) {
                if (this.F.isNeedExecuteOperateExpandAnim()) {
                    this.S.setAlpha(0.0f);
                    this.S.getLayoutParams().height = 0;
                    this.S.setVisibility(8);
                    this.S.getRecommendReason().setAlpha(0.0f);
                    this.S.getRecommendReason().setVisibility(8);
                    view2.setAlpha(0.0f);
                    view2.setVisibility(8);
                    setAppInfoMaskRadius(X(R.string.J_X16));
                    setCustomViewRadius(X(R.string.J_X05));
                    return;
                }
                this.S.setAlpha(1.0f);
                this.S.getLayoutParams().height = m61.c.a(getContext(), 34.6f);
                this.S.setVisibility(0);
                this.S.getRecommendReason().setAlpha(1.0f);
                this.S.getRecommendReason().setVisibility(0);
                view2.setAlpha(1.0f);
                view2.setVisibility(0);
                setAppInfoMaskRadius(X(R.string.J_X02));
                setCustomViewRadius(X(R.string.J_X13));
                return;
            }
            this.S.setVisibility(8);
            view2.setAlpha(1.0f);
            view2.setVisibility(0);
            setAppInfoMaskRadius(X(R.string.J_X16));
            setCustomViewRadius(X(R.string.J_X05));
        }
    }

    public final void Z(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, advertAppInfo, adCard) == null) {
            if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
                this.A.setVisibility(0);
                this.A.setPage(getBusinessType());
                this.A.setData(advertAppInfo, adCard.closeInfo);
                BdUtilHelper.addToParentArea(this.i.getPageActivity(), this.B, 40, 40, 40, 120);
                this.B.setOnClickListener(new c(this));
                return;
            }
            this.A.setVisibility(8);
            this.z.setOnClickListener(null);
        }
    }

    public final boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!(this.o instanceof RelativeLayout)) {
                return false;
            }
            AdLottieButtonView adLottieButtonView = new AdLottieButtonView(this.i.getPageActivity());
            this.O = adLottieButtonView;
            adLottieButtonView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = BdUtilHelper.getDimens(this.i.getPageActivity(), R.dimen.M_H_X003);
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.i.getPageActivity(), R.dimen.M_W_X004);
            View view2 = this.o;
            if (view2 instanceof RelativeLayout) {
                ((RelativeLayout) view2).addView(this.O, layoutParams);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.m = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
            this.B = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0073, (ViewGroup) null);
            ViewStub viewStub = (ViewStub) this.m.findViewById(R.id.obfuscated_res_0x7f0900af);
            this.n = viewStub;
            viewStub.setLayoutResource(getCustomLayout());
            this.o = this.n.inflate();
        }
    }

    public final void i0(AdCard adCard, AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, adCard, advertAppInfo) == null) {
            if (adCard != null && advertAppInfo != null) {
                this.D.setVisibility(0);
                n56 n56Var = this.R;
                if (n56Var != null) {
                    n56Var.j();
                    this.R = null;
                }
                if (advertAppInfo.e()) {
                    e0(adCard);
                    return;
                } else if (advertAppInfo.g()) {
                    h0(adCard);
                    return;
                } else {
                    return;
                }
            }
            this.D.setVisibility(8);
        }
    }

    public final void j0(AdCard adCard, AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, adCard, advertAppInfo) == null) {
            AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
            if (advertAppInfo2 != null) {
                advertAppInfo2.setThreadExtendInfo(StringHelper.getFormatTimeForJustNow(adCard.getTime()));
            }
            this.H.setShowFlag(1413);
            this.H.setData(advertAppInfo2);
            ((TextView) this.H.getUserName()).setText(adCard.userName);
            HomeGroupUbsUIHelper.handleHeadSegmentTitleView((TextView) this.H.getUserName());
            this.H.getUserName().setOnClickListener(new j(this));
            this.H.setAfterAdjustChildWidthListener(new k(this, adCard));
            this.H.getHeaderImg().setOnLongClickListener(new l(this, advertAppInfo));
            if (this.H.getHeaderImg() != null) {
                this.H.getHeaderImg().setClickable(true);
                this.H.getHeaderImg().setOnClickListener(new m(this));
            }
            if (o0(adCard)) {
                this.H.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.m == null) {
                this.m = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) this, false);
            }
            this.L = this.m.findViewById(R.id.obfuscated_res_0x7f090340);
            View findViewById = this.m.findViewById(R.id.obfuscated_res_0x7f092526);
            this.p = findViewById;
            findViewById.setClickable(true);
            this.d0 = new NadTitleController(this.m);
            this.y = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0926b5);
            this.C = (ApkDownloadView) this.m.findViewById(R.id.obfuscated_res_0x7f090155);
            this.e0 = new NadTagController(this.m);
            this.D = (RelativeLayout) this.m.findViewById(R.id.obfuscated_res_0x7f090486);
            this.E = this.m.findViewById(R.id.obfuscated_res_0x7f090577);
            AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout = (AdThreadCommentAndPraiseInfoLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0905f1);
            this.G = adThreadCommentAndPraiseInfoLayout;
            adThreadCommentAndPraiseInfoLayout.setStyle(1);
            if (l0() || m0()) {
                setUseDynamicLikeRes();
                setNeedMatchStrategy(true);
            }
            this.H = (AdThreadUserInfoLayout) this.m.findViewById(R.id.obfuscated_res_0x7f090578);
            this.K = (FrameLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0904e2);
            if (this.B == null) {
                this.B = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0073, (ViewGroup) null);
            }
            AdCloseView adCloseView = (AdCloseView) this.B.findViewById(R.id.obfuscated_res_0x7f0900a8);
            this.A = adCloseView;
            adCloseView.k.getLayoutParams().height = BdUtilHelper.getDimens(getContext(), R.dimen.tbds76);
            this.A.k.getLayoutParams().width = BdUtilHelper.getDimens(getContext(), R.dimen.tbds76);
            TextView textView = (TextView) this.B.findViewById(R.id.obfuscated_res_0x7f090b0e);
            this.z = textView;
            textView.setVisibility(8);
            this.H.addAdTagView(this.B);
            if (this.o == null) {
                ViewStub viewStub = (ViewStub) this.m.findViewById(R.id.obfuscated_res_0x7f0900af);
                this.n = viewStub;
                viewStub.setLayoutResource(getCustomLayout());
                this.o = this.n.inflate();
            }
            this.I = this.m.findViewById(R.id.obfuscated_res_0x7f091a9d);
            this.J = this.m.findViewById(R.id.obfuscated_res_0x7f090c77);
            this.M = this.m.findViewById(R.id.obfuscated_res_0x7f091a97);
            this.N = (AdAppInfoView) this.m.findViewById(R.id.app_info_view);
            this.c0 = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0918ad);
            EMManager.from(this.N).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
            NadCustomAppInfoView nadCustomAppInfoView = (NadCustomAppInfoView) this.m.findViewById(R.id.obfuscated_res_0x7f091861);
            this.V = nadCustomAppInfoView;
            EMManager.from(nadCustomAppInfoView).setCorner(R.string.J_X16);
            NadOperateBar nadOperateBar = (NadOperateBar) this.m.findViewById(R.id.obfuscated_res_0x7f091896);
            this.S = nadOperateBar;
            EMManager.from(nadOperateBar).setCorner(R.string.J_X16).setBackGroundColor(R.color.CAM_X0905);
            d0(this.o);
            this.P = (VipAdFreeGuideLayout) this.m.findViewById(R.id.obfuscated_res_0x7f090643);
            this.f1164T = (NadLongProgressButton) this.m.findViewById(R.id.obfuscated_res_0x7f09188a);
            this.U = (NadProgressButton) this.m.findViewById(R.id.obfuscated_res_0x7f091898);
            this.W = this.m.getViewTreeObserver();
            g gVar = new g(this);
            this.a0 = gVar;
            ViewTreeObserver viewTreeObserver = this.W;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(gVar);
            }
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: s0 */
    public void u(AdCard adCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048613, this, adCard, i2) == null) {
            this.A.onChangeSkinType();
            this.H.onChangeSkinType(this.i, TbadkCoreApplication.getInst().getSkinType());
            this.G.onChangeSkinType();
            if (getBusinessType() == 1 || getBusinessType() == 2) {
                View view2 = this.m;
                view2.setBackgroundDrawable(y2a.f(R.string.J_X06, R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50, view2.getMeasuredHeight()));
            }
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor((TextView) this.H.getUserName());
            SkinManager.setViewTextColor(this.d0.m(), R.color.CAM_X0105, 1);
            ThreadCardUtils.setAbstractStyleAb(this.d0.m());
            this.e0.h();
            SkinManager.setViewTextColor(this.z, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.y, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.y, R.drawable.obfuscated_res_0x7f0800d9);
            SkinManager.setBackgroundColor(this.M, R.color.CAM_X0203);
            SkinManager.setBackgroundColor(this.L, R.color.CAM_X0204);
            if (W(adCard) instanceof o56) {
                ((o56) W(adCard)).onChangeSkinType(i2);
            }
            EMManager.from(this.N).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
            EMManager.from(this.S).setCorner(R.string.J_X16).setBackGroundColor(R.color.CAM_X0905);
            this.N.onChangeSkinType();
            this.V.onChangeSkinType();
            this.P.f();
        }
    }

    public final void x0(AdCard adCard, View view2) {
        RelativeLayout downloadButtonContainer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, adCard, view2) == null) {
            y05 appInfoModel = adCard.getAppInfoModel();
            if (this.N.getVisibility() == 0) {
                downloadButtonContainer = this.N.getDownloadButtonContainer();
            } else {
                downloadButtonContainer = this.S.getDownloadButtonContainer(Boolean.valueOf(adCard.isContainOperateRecommendReason()).booleanValue());
            }
            if (y05.a(appInfoModel)) {
                if (this.N.getVisibility() == 0) {
                    this.N.setAppInfo(appInfoModel);
                    this.N.setAd(adCard.getAdvertAppInfo());
                } else {
                    this.V.setAppInfo(adCard);
                    this.S.setRecommendReason(this.F.operate.d);
                    this.S.setAdInfo(adCard.getAdvertAppInfo(), this.F.adRunTime.a.booleanValue());
                }
                if (q0(view2, downloadButtonContainer)) {
                    return;
                }
                r0(view2, downloadButtonContainer);
                return;
            }
            this.N.setVisibility(8);
            if (q0(view2, this.D)) {
                return;
            }
            r0(view2, this.D);
        }
    }
}
