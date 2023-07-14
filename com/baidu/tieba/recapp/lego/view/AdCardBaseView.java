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
import com.baidu.tieba.a0a;
import com.baidu.tieba.d85;
import com.baidu.tieba.e66;
import com.baidu.tieba.e71;
import com.baidu.tieba.e76;
import com.baidu.tieba.ed5;
import com.baidu.tieba.h61;
import com.baidu.tieba.i61;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.ly9;
import com.baidu.tieba.nk0;
import com.baidu.tieba.o76;
import com.baidu.tieba.oh7;
import com.baidu.tieba.oi;
import com.baidu.tieba.ok0;
import com.baidu.tieba.p76;
import com.baidu.tieba.ph7;
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
import com.baidu.tieba.sy9;
import com.baidu.tieba.tz8;
import com.baidu.tieba.v15;
import com.baidu.tieba.vy9;
import com.baidu.tieba.yi;
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
    public final int A;
    public int B;
    public TextView C;
    public TextView D;
    public AdCloseView E;
    public LinearLayout F;
    public ApkDownloadView G;
    public TextView H;
    public RelativeLayout I;
    public View J;
    public AdCard K;
    public AdThreadCommentAndPraiseInfoLayout L;
    public AdThreadUserInfoLayout M;
    public View N;
    public View O;
    public FrameLayout P;
    public View Q;
    public View R;
    public AdAppInfoView S;

    /* renamed from: T  reason: collision with root package name */
    public AdLottieButtonView f1163T;
    public VipAdFreeGuideLayout U;
    public boolean V;
    public o76 W;
    public NadOperateBar a0;
    public NadLongProgressButton b0;
    public NadProgressButton c0;
    public NadCustomAppInfoView d0;
    public ViewTreeObserver e0;
    public ViewTreeObserver.OnGlobalLayoutListener f0;
    public RecyclerView g0;
    public TextView h0;
    public NadTitleController i0;
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
                this.a.E.performClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ly9 {
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

        @Override // com.baidu.tieba.ly9
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean b = nk0.b(this.b.i.getPageActivity(), this.a.downloadInfo.a);
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
                this.a.K.adRunTime.a = bool;
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
                    if (this.a.g0 == null) {
                        for (ViewParent parent = this.a.getParent(); parent != null; parent = parent.getParent()) {
                            if (parent instanceof RecyclerView) {
                                this.a.g0 = (RecyclerView) parent;
                                return;
                            }
                        }
                    } else if (this.a.g0.getScrollState() == 0) {
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
                h61.a().b(this.a.getContext());
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
                ((TextView) this.b.M.getUserName()).setText(this.a.userName);
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
                ed5 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.d() || (advertAppInfo = this.a) == null) {
                    return false;
                }
                oi.a(advertAppInfo.c());
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
    public class n implements p76.a {
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

        @Override // com.baidu.tieba.p76.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                e76.a(this.a);
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
        this.x = (int) resources.getDimension(R.dimen.tbds208);
        this.y = (int) resources.getDimension(R.dimen.tbds33);
        this.z = (int) resources.getDimension(R.dimen.tbds72);
        this.A = (int) resources.getDimension(R.dimen.tbds48);
    }

    public final void U(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adCard) == null) {
            if (adCard.getAgreeNum() == -1 && adCard.getShareNum() == -1 && adCard.getReplyNum() == -1) {
                this.O.setVisibility(0);
                this.L.setVisibility(8);
                return;
            }
            this.O.setVisibility(8);
            this.L.setVisibility(0);
            this.L.setBarNameClickEnabled(false);
            this.L.setReplyTimeVisible(false);
            this.L.setData(adCard.getThreadData());
            if (adCard.getAgreeNum() != -1) {
                this.L.setAgreeClickable(true);
                this.L.setPraiseContainerBgGray(false);
            } else {
                this.L.setAgreeClickable(false);
                this.L.setPraiseContainerBgGray(true);
            }
            if (adCard.getShareNum() != -1) {
                this.L.setShareClickable(true);
                this.L.setShareContainerBgGray(false);
            } else {
                this.L.setShareClickable(false);
                this.L.setShareContainerBgGray(true);
            }
            this.L.setNeedAddReplyIcon(true);
            this.L.setCommentNumEnable(false);
            this.L.setCommentClickable(true);
            this.L.setReplayContainerBgGray(true);
            this.L.setShareData(adCard);
            this.L.setDisPraiseViewVisibility(false);
        }
    }

    public final void a0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, adCard) == null) {
            int i2 = (this.B - this.x) - this.A;
            if (p0()) {
                i2 -= this.y + this.z;
            }
            String str = adCard.recommendReason;
            if (TextUtils.isEmpty(str)) {
                str = adCard.userName;
            }
            if (e66.a().b("tieba_ad_tag_optimize_switch", 0) == 1 && adCard.nadTagModel != null) {
                this.h0.setVisibility(0);
                String string = this.i.getString(R.string.advert_label);
                if (!TextUtils.isEmpty(adCard.nadTagModel.a)) {
                    string = adCard.nadTagModel.a;
                }
                this.h0.setText(string);
                this.h0.setTextColor(a0a.h(adCard.nadTagModel.b, SkinManager.getColor(R.color.CAM_X0619)));
                TextView textView = this.H;
                textView.setText(a0a.e(str, "", i2, textView.getPaint()));
            } else {
                this.h0.setVisibility(8);
                this.H.setText(a0a.e(str, this.i.getString(R.string.advert_label), i2, this.H.getPaint()));
            }
            this.H.setOnClickListener(new a(this));
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
            this.i0.update(adCard, this.B, new b(this));
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
        if ((interceptable == null || interceptable.invokeL(1048614, this, fArr) == null) && (nadCustomAppInfoView = this.d0) != null && (nadCustomAppInfoView.getBackground() instanceof GradientDrawable)) {
            GradientDrawable gradientDrawable = (GradientDrawable) this.d0.getBackground();
            gradientDrawable.setCornerRadii(fArr);
            this.d0.setBackground(gradientDrawable);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.p09
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.V = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z) == null) && (adThreadCommentAndPraiseInfoLayout = this.L) != null) {
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

    private void setDownloadElementVisibility(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, adCard) == null) {
            if (adCard.isNewLayout().booleanValue()) {
                this.S.setVisibility(8);
                this.d0.setVisibility(0);
                this.a0.setVisibility(0);
                this.a0.setOnClickListener(new e(this));
                this.G.setVisibility(8);
                if (adCard.isContainOperateRecommendReason().booleanValue()) {
                    this.c0.setVisibility(0);
                    this.b0.setVisibility(8);
                    return;
                }
                this.c0.setVisibility(8);
                this.b0.setVisibility(0);
                return;
            }
            this.S.setVisibility(0);
            this.d0.setVisibility(8);
            this.a0.setVisibility(8);
            this.b0.setVisibility(8);
            if (sy9.a.a()) {
                this.c0.setVisibility(0);
                this.G.setVisibility(8);
                return;
            }
            this.c0.setVisibility(8);
            this.G.setVisibility(0);
        }
    }

    public void Y(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.i.showToast(R.string.obfuscated_res_0x7f0f0e1f);
                return;
            }
            AdCard adCard = this.K;
            if (adCard == null) {
                return;
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            String extInfo = this.K.getExtInfo();
            String downloadId = this.K.getDownloadId();
            String str3 = this.K.scheme;
            if (NativeConstants.ID_BUTTON.equals(str)) {
                str2 = this.K.getButtonCmdScheme();
            } else {
                str2 = this.K.cmdScheme;
            }
            int i2 = 3;
            boolean z = false;
            if (advertAppInfo != null && advertAppInfo.e() && !ok0.n(this.K.cmdScheme)) {
                z = nk0.b(this.i.getPageActivity(), advertAppInfo.q);
            }
            if (!z) {
                i2 = vy9.b(this.i, str3, downloadId, extInfo, str2);
            }
            HashMap<String, Object> S = S(str);
            tz8 tz8Var = this.k;
            if (tz8Var != null) {
                tz8Var.a(i2, S);
            }
        }
    }

    public final void h0(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, adCard) == null) {
            this.G.setVisibility(8);
            this.b0.setVisibility(8);
            this.c0.setVisibility(8);
            setCustomViewRadius(X(R.string.J_X05));
            this.S.setVisibility(8);
            this.d0.setVisibility(8);
            this.a0.setVisibility(8);
            this.C.setVisibility(0);
            this.C.setClickable(true);
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.C, R.drawable.obfuscated_res_0x7f0800d9);
            this.C.setText(adCard.getButtonText());
            this.C.setOnClickListener(new o(this));
        }
    }

    public final void P(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2.getVisibility() == 0) {
            this.P.setVisibility(0);
            if (q0(view2, this.P)) {
                return;
            }
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            this.P.removeAllViews();
            view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.P.addView(view2);
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

    public final void k0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, adCard) == null) {
            this.L.setType(TbadkCoreApplication.getInst().getCardShowType());
            if (p0()) {
                this.L.setVisibility(8);
                this.L.setBarNameClickEnabled(false);
                this.L.setShareVisible(false);
                this.L.setShowPraiseNum(false);
                this.L.setCommentNumEnable(false);
                this.L.setReplyTimeVisible(false);
                this.N.setVisibility(0);
                this.O.setVisibility(8);
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
            this.K = adCard;
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
            if (i61.a) {
                this.m.setOnLongClickListener(new i(this));
            }
            V(adCard);
            u(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void Q(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && view2 != null && view2.getVisibility() == 0) {
            this.P.setVisibility(8);
            if (q0(view2, this.M)) {
                return;
            }
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            this.M.addAdTagView(this.F);
        }
    }

    public final View W(AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, adCard)) == null) {
            if (adCard.isNewLayout().booleanValue()) {
                if (!adCard.isContainOperateRecommendReason().booleanValue()) {
                    return this.b0;
                }
                return this.c0;
            } else if (sy9.a.a()) {
                return this.c0;
            } else {
                return this.G;
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
            this.C.setVisibility(8);
            W.setClickable(true);
            if (W instanceof p76) {
                p76 p76Var = (p76) W;
                p76Var.setOnClickInterceptListener(new n(this, adCard.getButtonCmdScheme()));
                this.W = new o76(p76Var, a0a.d(adCard));
            }
        }
    }

    public final void y0(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, adCard) == null) {
            if (adCard.gameModel == null && this.f1163T == null) {
                return;
            }
            AdLottieButtonView adLottieButtonView = this.f1163T;
            if ((adLottieButtonView == null || adLottieButtonView.getParent() == null) && !f0()) {
                return;
            }
            this.f1163T.setData(adCard.gameModel);
            this.f1163T.setClickListener(new d(this, adCard));
        }
    }

    public final void R(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
            layoutParams.topMargin = this.i.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            this.J.setPadding(0, 0, 0, 0);
            this.P.setVisibility(8);
            this.Q.setVisibility(8);
            if (p0()) {
                View view2 = this.m;
                int i2 = this.t;
                view2.setPadding(i2, this.u, i2, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
                int l2 = (yi.l(getContext()) - (this.w * 2)) - (this.t * 2);
                int i3 = this.q;
                int i4 = this.r;
                this.B = (l2 - i3) - i4;
                layoutParams2.leftMargin = i3 + i4;
                this.R.setVisibility(0);
                Q(this.F);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.U.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
                    layoutParams3.leftMargin = 0;
                    layoutParams3.rightMargin = 0;
                }
                if (o0(adCard)) {
                    this.R.setVisibility(8);
                    this.m.setPadding(0, 0, 0, 0);
                    View view3 = this.J;
                    int i5 = this.t;
                    view3.setPadding(i5, 0, i5, 0);
                    this.U.setLayoutPadding(-1, -1, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007));
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.U.getLayoutParams();
                    if (layoutParams4 != null) {
                        int i6 = this.t;
                        layoutParams4.leftMargin = -i6;
                        layoutParams4.rightMargin = -i6;
                    }
                    layoutParams2.leftMargin = 0;
                    this.B = (yi.l(getContext()) - (this.t * 2)) - (this.w * 2);
                    layoutParams.topMargin = this.i.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                    this.Q.setVisibility(0);
                    SkinManager.setBackgroundColor(this.Q, R.color.CAM_X0204);
                    P(this.F);
                    return;
                }
                ViewGroup.LayoutParams layoutParams5 = getLayoutParams();
                if (this.V) {
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
            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.U.getLayoutParams();
            if (layoutParams6 != null) {
                int i8 = this.s;
                layoutParams6.leftMargin = -i8;
                layoutParams6.rightMargin = -i8;
            }
            this.B = (yi.l(getContext()) - (this.s * 2)) - (this.v * 2);
            if ((ph7.f().i() || oh7.h().j()) && n0()) {
                this.p.setVisibility(0);
                SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
            } else {
                this.p.setVisibility(8);
            }
            this.R.setVisibility(8);
        }
    }

    public final Boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdCard adCard = this.K;
            if (adCard == null) {
                return Boolean.FALSE;
            }
            if (!adCard.isNewLayout().booleanValue()) {
                return Boolean.FALSE;
            }
            if (!this.K.isNeedExecuteOperateExpandAnim().booleanValue()) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        return (Boolean) invokeV.objValue;
    }

    public final void Z(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, advertAppInfo, adCard) == null) {
            if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
                this.E.setVisibility(0);
                this.E.setPage(getBusinessType());
                this.E.setData(advertAppInfo, adCard.closeInfo);
                yi.b(this.i.getPageActivity(), this.F, 40, 40, 40, 120);
                this.F.setOnClickListener(new c(this));
                return;
            }
            this.E.setVisibility(8);
            this.D.setOnClickListener(null);
        }
    }

    public final void c0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            if (this.K.isNewLayout().booleanValue()) {
                if (this.K.isNeedExecuteOperateExpandAnim().booleanValue()) {
                    this.a0.setAlpha(0.0f);
                    this.a0.getLayoutParams().height = 0;
                    this.a0.setVisibility(8);
                    this.a0.getRecommendReason().setAlpha(0.0f);
                    this.a0.getRecommendReason().setVisibility(8);
                    view2.setAlpha(0.0f);
                    view2.setVisibility(8);
                    setAppInfoMaskRadius(X(R.string.J_X16));
                    setCustomViewRadius(X(R.string.J_X05));
                    return;
                }
                this.a0.setAlpha(1.0f);
                this.a0.getLayoutParams().height = e71.c.a(getContext(), 34.6f);
                this.a0.setVisibility(0);
                this.a0.getRecommendReason().setAlpha(1.0f);
                this.a0.getRecommendReason().setVisibility(0);
                view2.setAlpha(1.0f);
                view2.setVisibility(0);
                setAppInfoMaskRadius(X(R.string.J_X02));
                setCustomViewRadius(X(R.string.J_X13));
                return;
            }
            this.a0.setVisibility(8);
            view2.setAlpha(1.0f);
            view2.setVisibility(0);
            setAppInfoMaskRadius(X(R.string.J_X16));
            setCustomViewRadius(X(R.string.J_X05));
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
            this.f1163T = adLottieButtonView;
            adLottieButtonView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = yi.g(this.i.getPageActivity(), R.dimen.M_H_X003);
            layoutParams.leftMargin = yi.g(this.i.getPageActivity(), R.dimen.M_W_X004);
            View view2 = this.o;
            if (view2 instanceof RelativeLayout) {
                ((RelativeLayout) view2).addView(this.f1163T, layoutParams);
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
            this.F = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0071, (ViewGroup) null);
            ViewStub viewStub = (ViewStub) this.m.findViewById(R.id.obfuscated_res_0x7f0900ae);
            this.n = viewStub;
            viewStub.setLayoutResource(getCustomLayout());
            this.o = this.n.inflate();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.p09
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && p0()) {
            this.i0.m().setTextSize(0, TbConfig.getContentSize());
        }
    }

    public View getPbAdBottomDivider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.R;
        }
        return (View) invokeV.objValue;
    }

    public View getPbBottomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.N;
        }
        return (View) invokeV.objValue;
    }

    public VipAdFreeGuideLayout getVipAdFreeGuideLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.U;
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
            ViewTreeObserver viewTreeObserver = this.e0;
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                this.e0.removeOnGlobalLayoutListener(this.f0);
            }
            this.f0 = null;
            this.e0 = null;
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
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (adThreadCommentAndPraiseInfoLayout = this.L) != null) {
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
        this.a0.startExpandAnim(this.K.operate.e, new f(this));
    }

    public final void i0(AdCard adCard, AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, adCard, advertAppInfo) == null) {
            if (adCard != null && advertAppInfo != null) {
                this.I.setVisibility(0);
                o76 o76Var = this.W;
                if (o76Var != null) {
                    o76Var.j();
                    this.W = null;
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
            this.I.setVisibility(8);
        }
    }

    public final void j0(AdCard adCard, AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, adCard, advertAppInfo) == null) {
            AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
            if (advertAppInfo2 != null) {
                advertAppInfo2.setThreadExtendInfo(StringHelper.getFormatTimeForJustNow(adCard.getTime()));
            }
            this.M.setShowFlag(1413);
            this.M.setData(advertAppInfo2);
            ((TextView) this.M.getUserName()).setText(adCard.userName);
            HomeGroupUbsUIHelper.handleHeadSegmentTitleView((TextView) this.M.getUserName());
            this.M.getUserName().setOnClickListener(new j(this));
            this.M.setAfterAdjustChildWidthListener(new k(this, adCard));
            this.M.getHeaderImg().setOnLongClickListener(new l(this, advertAppInfo));
            if (this.M.getHeaderImg() != null) {
                this.M.getHeaderImg().setClickable(true);
                this.M.getHeaderImg().setOnClickListener(new m(this));
            }
            if (o0(adCard)) {
                this.M.setVisibility(8);
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
            this.Q = this.m.findViewById(R.id.obfuscated_res_0x7f09033d);
            View findViewById = this.m.findViewById(R.id.obfuscated_res_0x7f0924d9);
            this.p = findViewById;
            findViewById.setClickable(true);
            this.i0 = new NadTitleController(this.m);
            this.C = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f092665);
            this.G = (ApkDownloadView) this.m.findViewById(R.id.obfuscated_res_0x7f090152);
            this.H = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f090156);
            this.I = (RelativeLayout) this.m.findViewById(R.id.obfuscated_res_0x7f090476);
            this.J = this.m.findViewById(R.id.obfuscated_res_0x7f090567);
            AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout = (AdThreadCommentAndPraiseInfoLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0905e1);
            this.L = adThreadCommentAndPraiseInfoLayout;
            adThreadCommentAndPraiseInfoLayout.setStyle(1);
            if (l0() || m0()) {
                setUseDynamicLikeRes();
                setNeedMatchStrategy(true);
            }
            this.M = (AdThreadUserInfoLayout) this.m.findViewById(R.id.obfuscated_res_0x7f090568);
            this.P = (FrameLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0904d2);
            if (this.F == null) {
                this.F = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0071, (ViewGroup) null);
            }
            AdCloseView adCloseView = (AdCloseView) this.F.findViewById(R.id.obfuscated_res_0x7f0900a7);
            this.E = adCloseView;
            adCloseView.k.getLayoutParams().height = yi.g(getContext(), R.dimen.tbds76);
            this.E.k.getLayoutParams().width = yi.g(getContext(), R.dimen.tbds76);
            TextView textView = (TextView) this.F.findViewById(R.id.obfuscated_res_0x7f090af1);
            this.D = textView;
            textView.setVisibility(8);
            this.M.addAdTagView(this.F);
            if (this.o == null) {
                ViewStub viewStub = (ViewStub) this.m.findViewById(R.id.obfuscated_res_0x7f0900ae);
                this.n = viewStub;
                viewStub.setLayoutResource(getCustomLayout());
                this.o = this.n.inflate();
            }
            this.N = this.m.findViewById(R.id.obfuscated_res_0x7f091a60);
            this.O = this.m.findViewById(R.id.obfuscated_res_0x7f090c58);
            this.R = this.m.findViewById(R.id.obfuscated_res_0x7f091a5a);
            this.S = (AdAppInfoView) this.m.findViewById(R.id.app_info_view);
            this.h0 = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f091877);
            d85 d2 = d85.d(this.S);
            d2.o(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            NadCustomAppInfoView nadCustomAppInfoView = (NadCustomAppInfoView) this.m.findViewById(R.id.obfuscated_res_0x7f09182b);
            this.d0 = nadCustomAppInfoView;
            d85.d(nadCustomAppInfoView).o(R.string.J_X16);
            NadOperateBar nadOperateBar = (NadOperateBar) this.m.findViewById(R.id.obfuscated_res_0x7f091860);
            this.a0 = nadOperateBar;
            d85 d3 = d85.d(nadOperateBar);
            d3.o(R.string.J_X16);
            d3.f(R.color.CAM_X0905);
            d0(this.o);
            this.U = (VipAdFreeGuideLayout) this.m.findViewById(R.id.obfuscated_res_0x7f090633);
            this.b0 = (NadLongProgressButton) this.m.findViewById(R.id.obfuscated_res_0x7f091854);
            this.c0 = (NadProgressButton) this.m.findViewById(R.id.obfuscated_res_0x7f091862);
            this.e0 = this.m.getViewTreeObserver();
            g gVar = new g(this);
            this.f0 = gVar;
            ViewTreeObserver viewTreeObserver = this.e0;
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
            this.E.onChangeSkinType();
            this.M.onChangeSkinType(this.i, TbadkCoreApplication.getInst().getSkinType());
            this.L.onChangeSkinType();
            if (getBusinessType() == 1 || getBusinessType() == 2) {
                View view2 = this.m;
                view2.setBackgroundDrawable(a0a.f(R.string.J_X06, R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50, view2.getMeasuredHeight()));
            }
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor((TextView) this.M.getUserName());
            SkinManager.setViewTextColor(this.i0.m(), R.color.CAM_X0105, 1);
            ThreadCardUtils.setAbstractStyleAb(this.i0.m());
            SkinManager.setViewTextColor(this.H, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.C, R.drawable.obfuscated_res_0x7f0800d9);
            SkinManager.setBackgroundColor(this.R, R.color.CAM_X0203);
            SkinManager.setBackgroundColor(this.Q, R.color.CAM_X0204);
            if (W(adCard) instanceof p76) {
                ((p76) W(adCard)).onChangeSkinType(i2);
            }
            d85 d2 = d85.d(this.S);
            d2.o(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            d85 d3 = d85.d(this.a0);
            d3.o(R.string.J_X16);
            d3.f(R.color.CAM_X0905);
            this.S.onChangeSkinType();
            this.d0.onChangeSkinType();
            this.U.f();
        }
    }

    public final void x0(AdCard adCard, View view2) {
        RelativeLayout downloadButtonContainer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, adCard, view2) == null) {
            v15 appInfoModel = adCard.getAppInfoModel();
            if (this.S.getVisibility() == 0) {
                downloadButtonContainer = this.S.getDownloadButtonContainer();
            } else {
                downloadButtonContainer = this.a0.getDownloadButtonContainer(adCard.isContainOperateRecommendReason().booleanValue());
            }
            if (v15.a(appInfoModel)) {
                if (this.S.getVisibility() == 0) {
                    this.S.setAppInfo(appInfoModel);
                    this.S.setAd(adCard.getAdvertAppInfo());
                } else {
                    this.d0.setAppInfo(adCard);
                    this.a0.setRecommendReason(this.K.operate.d);
                    this.a0.setAdInfo(adCard.getAdvertAppInfo(), this.K.adRunTime.a.booleanValue());
                }
                if (q0(view2, downloadButtonContainer)) {
                    return;
                }
                r0(view2, downloadButtonContainer);
                return;
            }
            this.S.setVisibility(8);
            if (q0(view2, this.I)) {
                return;
            }
            r0(view2, this.I);
        }
    }
}
