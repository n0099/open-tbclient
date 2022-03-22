package com.baidu.tieba.recapp.lego.view;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.l3.a0;
import c.a.p0.l3.q;
import c.a.p0.x.g.g.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.JsonTransHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdLottieButtonView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.AdThreadUserInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
/* loaded from: classes5.dex */
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
    public String L;
    public AdCard M;
    public AdThreadCommentAndPraiseInfoLayout N;
    public AdThreadUserInfoLayout O;
    public View P;
    public View Q;
    public DownloadCacheKey R;
    public c.a.p0.x.g.h.d S;
    public FrameLayout T;
    public View U;
    public View V;
    public AdAppInfoView W;
    public AdLottieButtonView g0;
    public CustomMessageListener h0;
    public CustomMessageListener i0;
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

    /* loaded from: classes5.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f35715b;

        public a(AdCardBaseView adCardBaseView, String str) {
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
            this.f35715b = adCardBaseView;
            this.a = str;
        }

        @Override // c.a.p0.x.g.g.b.a
        public boolean b(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.p0.x.a.a(this.a);
                HashMap<String, Object> M = this.f35715b.M("button");
                if (this.f35715b.k != null) {
                    this.f35715b.k.a(3, M);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f35716b;

        public b(AdCardBaseView adCardBaseView, AdCard adCard) {
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
            this.f35716b = adCardBaseView;
            this.a = adCard;
        }

        @Override // c.a.p0.l3.q
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean C = a0.C(this.a.getAdvertAppInfo(), this.a.downloadInfo.a);
                HashMap<String, Object> M = this.f35716b.M("try_button");
                if (this.f35716b.k != null) {
                    this.f35716b.k.a(1, M);
                }
                return C;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.Q("hotarea");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public d(AdCardBaseView adCardBaseView) {
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.Q("username");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements AdThreadUserInfoLayout.AfterAdjustChildWidthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f35717b;

        public e(AdCardBaseView adCardBaseView, AdCard adCard) {
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
            this.f35717b = adCardBaseView;
            this.a = adCard;
        }

        @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
        public void afterChildWidth() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((TextView) this.f35717b.O.getUserName()).setText(this.a.userName);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f35718b;

        public f(AdCardBaseView adCardBaseView, AdvertAppInfo advertAppInfo) {
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
            this.f35718b = adCardBaseView;
            this.a = advertAppInfo;
        }

        @Override // android.view.View.OnLongClickListener
        @SuppressLint({"MissingPermission"})
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            AdvertAppInfo advertAppInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.o0.s.c.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.e() || (advertAppInfo = this.a) == null) {
                    return false;
                }
                c.a.d.f.p.c.a(advertAppInfo.e());
                ((Vibrator) this.f35718b.i.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.Q("icon");
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.Q("button");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.Q("tag");
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.Q("title");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCardBaseView a;

        public k(AdCardBaseView adCardBaseView) {
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.F.performClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AdCardBaseView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(int i, AdCardBaseView adCardBaseView) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), adCardBaseView};
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
            this.a = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView;
            DownloadData downloadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (adCardBaseView = this.a.get()) == null || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(adCardBaseView.L) || !adCardBaseView.L.equals(downloadData.getId())) {
                return;
            }
            int p = c.a.p0.l3.g0.e.p(downloadData);
            if (p == 7) {
                adCardBaseView.D.setText(R.string.obfuscated_res_0x7f0f0d3e);
            } else if (p == 1 || p == 2) {
                adCardBaseView.D.setText(R.string.obfuscated_res_0x7f0f0d97);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AdCardBaseView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(int i, AdCardBaseView adCardBaseView) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), adCardBaseView};
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
            this.a = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView;
            DownloadData downloadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (adCardBaseView = this.a.get()) == null || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(adCardBaseView.L) || !adCardBaseView.L.equals(downloadData.getId())) {
                return;
            }
            adCardBaseView.H.s(downloadData);
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
        this.S = null;
        this.h0 = new l(2016484, this);
        this.i0 = new m(2016483, this);
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

    private void setDownloadViewClickListener(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, adCard) == null) {
            this.H.setOnClickInterceptListener(new a(this, adCard.getButtonCmdScheme()));
        }
    }

    public final void I(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view.getVisibility() == 0) {
            this.T.setVisibility(0);
            if (h0(view, this.T)) {
                return;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.T.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.T.addView(view);
        }
    }

    public final void J(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && view != null && view.getVisibility() == 0) {
            this.T.setVisibility(8);
            if (h0(view, this.O)) {
                return;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.O.addAdTagView(this.G);
        }
    }

    public final void K(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
            layoutParams.topMargin = this.i.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            this.K.setPadding(0, 0, 0, 0);
            this.T.setVisibility(8);
            this.U.setVisibility(8);
            if (g0()) {
                View view = this.m;
                int i2 = this.t;
                view.setPadding(i2, this.u, i2, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
                int k2 = (n.k(getContext()) - (this.w * 2)) - (this.t * 2);
                int i3 = this.q;
                int i4 = this.r;
                this.B = (k2 - i3) - i4;
                layoutParams2.leftMargin = i3 + i4;
                this.V.setVisibility(0);
                J(this.G);
                if (f0(adCard)) {
                    this.V.setVisibility(8);
                    this.m.setPadding(0, 0, 0, 0);
                    View view2 = this.K;
                    int i5 = this.t;
                    view2.setPadding(i5, 0, i5, 0);
                    layoutParams2.leftMargin = 0;
                    this.B = (n.k(getContext()) - (this.t * 2)) - (this.w * 2);
                    layoutParams.topMargin = this.i.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                    this.U.setVisibility(0);
                    SkinManager.setBackgroundColor(this.U, R.color.CAM_X0204);
                    I(this.G);
                    return;
                }
                return;
            }
            View view3 = this.m;
            int i6 = this.s;
            view3.setPadding(i6, this.u, i6, 0);
            this.B = (n.k(getContext()) - (this.s * 2)) - (this.v * 2);
            if ((c.a.p0.f1.b.f().i() || c.a.p0.f1.a.h().j()) && e0()) {
                this.p.setVisibility(0);
                SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
            } else {
                this.p.setVisibility(8);
            }
            this.V.setVisibility(8);
        }
    }

    public void L(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.R = downloadCacheKey;
        n0();
        this.S = null;
        AdDownloadData b2 = c.a.p0.x.g.e.d().b(downloadCacheKey);
        if (a0.r(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.M;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.M.getAdvertAppInfo().k;
            b2.setExtInfo(this.M.getExtInfo());
            b2.setDownloadKey(this.M.getDownloadKey());
            JSONObject appJson = JsonTransHelper.toAppJson(this.M.getAdvertAppInfo().m);
            if (appJson != null) {
                b2.setAppJson(appJson.toString());
            }
            b2.setPage(str);
            b2.setDeeplinkUrl(this.M.scheme);
            b2.setCmdScheme(this.M.cmdScheme);
            b2.setAppIcon(this.M.appInfoModel.f10811b);
            b2.setAppName(this.M.appInfoModel.f10812c);
        }
        c.a.p0.x.g.e d2 = c.a.p0.x.g.e.d();
        ApkDownloadView apkDownloadView = this.H;
        c.a.p0.x.g.g.c c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.S = new c.a.p0.x.g.h.b(c2);
        if (b2.extra().getPercent() > 0) {
            c2.e(b2);
        }
        l0();
        this.H.d(b2.getCurrentState());
    }

    @NonNull
    public HashMap M(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("da_area", str);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public final void N(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adCard) == null) {
            if (adCard.getAgreeNum() == -1 && adCard.getShareNum() == -1 && adCard.getReplyNum() == -1) {
                this.Q.setVisibility(0);
                this.N.setVisibility(8);
                return;
            }
            this.Q.setVisibility(8);
            this.N.setVisibility(0);
            this.N.setBarNameClickEnabled(false);
            this.N.setReplyTimeVisible(false);
            this.N.setData(adCard.getThreadData());
            if (adCard.getAgreeNum() != -1) {
                this.N.setAgreeClickable(true);
                this.N.setPraiseContainerBgGray(false);
            } else {
                this.N.setAgreeClickable(false);
                this.N.setPraiseContainerBgGray(true);
            }
            if (adCard.getShareNum() != -1) {
                this.N.setShareClickable(true);
                this.N.setShareContainerBgGray(false);
            } else {
                this.N.setShareClickable(false);
                this.N.setShareContainerBgGray(true);
            }
            this.N.setNeedAddReplyIcon(true);
            this.N.setCommentNumEnable(false);
            this.N.setCommentClickable(true);
            this.N.setReplayContainerBgGray(true);
            this.N.setShareData(adCard);
            this.N.setDisPraiseViewVisibility(false);
        }
    }

    public abstract void O(AdCard adCard);

    public float P(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            try {
                return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i2).split(",")[0]);
            } catch (Exception unused) {
                return 0.0f;
            }
        }
        return invokeI.floatValue;
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (!c.a.d.f.p.l.A()) {
                this.i.showToast(R.string.obfuscated_res_0x7f0f0c15);
                return;
            }
            AdCard adCard = this.M;
            if (adCard == null) {
                return;
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            String extInfo = this.M.getExtInfo();
            String downloadId = this.M.getDownloadId();
            String str2 = this.M.scheme;
            boolean z = false;
            if (advertAppInfo != null && advertAppInfo.i()) {
                z = a0.C(advertAppInfo, str2);
            }
            int e2 = z ? 3 : a0.e(this.i, str2, downloadId, extInfo, this.M.cmdScheme);
            HashMap<String, Object> M = M(str);
            c.a.p0.b2.o.a aVar = this.k;
            if (aVar != null) {
                aVar.a(e2, M);
            }
        }
    }

    public final void R(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, advertAppInfo, adCard) == null) {
            if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
                this.F.setVisibility(0);
                this.F.setPage(getBusinessType());
                this.F.setData(advertAppInfo, adCard.closeInfo);
                n.b(this.i.getPageActivity(), this.G, 40, 40, 40, 120);
                this.G.setOnClickListener(new k(this));
                return;
            }
            this.F.setVisibility(8);
            this.E.setOnClickListener(null);
        }
    }

    public final void S(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adCard) == null) {
            int i2 = (this.B - this.x) - this.A;
            if (g0()) {
                i2 -= this.y + this.z;
            }
            String str = adCard.recommendReason;
            if (TextUtils.isEmpty(str)) {
                str = adCard.userName;
            }
            if (UbsABTestHelper.isNativeFlowAdsStyleABTestA() && (d0() || c0())) {
                TextView textView = this.I;
                textView.setText(c.a.p0.l3.j0.c.a.d(str, "", i2, textView.getPaint()));
            } else {
                this.I.setText(c.a.p0.l3.j0.c.a.d(str, this.i.getString(R.string.obfuscated_res_0x7f0f00d9), i2, this.I.getPaint()));
            }
            this.I.setOnClickListener(new i(this));
        }
    }

    public final void T(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, adCard) == null) {
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
            this.C.setOnClickListener(new j(this));
        }
    }

    public abstract void U(View view);

    public final void V(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, advertAppInfo, adCard) == null) {
            o0(adCard);
            this.D.setVisibility(8);
            this.H.setVisibility(0);
            this.H.setClickable(true);
            this.H.setInitText(adCard.getButtonText());
            this.L = advertAppInfo.s;
            DownloadData m0 = m0(advertAppInfo, advertAppInfo.position);
            if (a0.r(this.L)) {
                m0.setStatus(8);
            } else {
                m0.setStatus(this.H.getDownloadStatus());
            }
            this.H.setData(m0);
            setDownloadViewClickListener(adCard);
        }
    }

    public final void W(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, adCard, advertAppInfo) == null) {
            String scheme = adCard.getScheme();
            String downloadId = adCard.getDownloadId();
            if (!TextUtils.isEmpty(downloadId)) {
                i2 = c.a.p0.x.g.e.d().h(downloadId);
            } else {
                i2 = c.a.p0.x.g.e.d().i(scheme);
            }
            if (i2 == null) {
                i2 = DownloadCacheKey.create(downloadId, advertAppInfo.r, advertAppInfo.s);
                c.a.p0.x.g.e.d().j(i2, null);
            }
            L(i2);
        }
    }

    public final boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.o instanceof RelativeLayout) {
                AdLottieButtonView adLottieButtonView = new AdLottieButtonView(this.i.getPageActivity());
                this.g0 = adLottieButtonView;
                adLottieButtonView.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = n.f(this.i.getPageActivity(), R.dimen.M_H_X003);
                layoutParams.leftMargin = n.f(this.i.getPageActivity(), R.dimen.M_W_X004);
                View view = this.o;
                if (view instanceof RelativeLayout) {
                    ((RelativeLayout) view).addView(this.g0, layoutParams);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Y(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, adCard) == null) {
            this.H.setVisibility(8);
            this.W.setVisibility(8);
            this.D.setVisibility(0);
            this.D.setClickable(true);
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.D, R.drawable.obfuscated_res_0x7f0800c2);
            this.D.setText(adCard.getButtonText());
            this.D.setOnClickListener(new h(this));
        }
    }

    public final void Z(AdCard adCard, AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, adCard, advertAppInfo) == null) {
            if (adCard != null && advertAppInfo != null) {
                this.J.setVisibility(0);
                if (advertAppInfo.i()) {
                    V(advertAppInfo, adCard);
                    W(adCard, advertAppInfo);
                    return;
                } else if (advertAppInfo.m()) {
                    Y(adCard);
                    return;
                } else {
                    return;
                }
            }
            this.J.setVisibility(8);
        }
    }

    public final void a0(AdCard adCard, AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, adCard, advertAppInfo) == null) {
            AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
            if (advertAppInfo2 != null) {
                if (UbsABTestHelper.isNativeFlowAdsStyleABTestA()) {
                    if (!d0() && !c0()) {
                        advertAppInfo2.setThreadExtendInfo(StringHelper.getFormatTimeForJustNow(adCard.getTime()));
                    } else {
                        advertAppInfo2.setThreadExtendInfo(StringHelper.getFormatTimeForJustNow(adCard.getTime()) + GlideException.IndentedAppendable.INDENT + this.i.getString(R.string.obfuscated_res_0x7f0f00d9));
                    }
                } else {
                    advertAppInfo2.setThreadExtendInfo(StringHelper.getFormatTimeForJustNow(adCard.getTime()));
                }
            }
            this.O.setShowFlag(1413);
            this.O.setData(advertAppInfo2);
            ((TextView) this.O.getUserName()).setText(adCard.userName);
            HomeGroupUbsUIHelper.handleHeadSegmentTitleView((TextView) this.O.getUserName());
            this.O.getUserName().setOnClickListener(new d(this));
            this.O.setAfterAdjustChildWidthListener(new e(this, adCard));
            this.O.getHeaderImg().setOnLongClickListener(new f(this, advertAppInfo));
            if (this.O.getHeaderImg() != null) {
                this.O.getHeaderImg().setClickable(true);
                this.O.getHeaderImg().setOnClickListener(new g(this));
            }
            if (f0(adCard)) {
                this.O.setVisibility(8);
            }
        }
    }

    public final void b0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, adCard) == null) {
            this.N.setType(TbadkCoreApplication.getInst().getCardShowType());
            if (g0()) {
                this.N.setVisibility(8);
                this.N.setBarNameClickEnabled(false);
                this.N.setShareVisible(false);
                this.N.setShowPraiseNum(false);
                this.N.setCommentNumEnable(false);
                this.N.setReplyTimeVisible(false);
                this.P.setVisibility(0);
                this.Q.setVisibility(8);
                return;
            }
            N(adCard);
        }
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? getBusinessType() == 1 : invokeV.booleanValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? getBusinessType() == 2 : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, c.a.p0.b2.o.l.e
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && g0()) {
            this.C.setTextSize(0, TbConfig.getContentSize());
        }
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f34240b == 1 : invokeV.booleanValue;
    }

    public boolean f0(AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, adCard)) == null) ? g0() && adCard.isPBBanner : invokeL.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? getBusinessType() == 4 : invokeV.booleanValue;
    }

    public abstract int getCustomLayout();

    public abstract int getLayout();

    public final boolean h0(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, view, viewGroup)) == null) ? (view == null || view.getParent() == null || view.getParent() != viewGroup) ? false : true : invokeLL.booleanValue;
    }

    public final void i0(View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, view, viewGroup) == null) && view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
            viewGroup.addView(view);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: j0 */
    public void t(AdCard adCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048606, this, adCard, i2) == null) {
            this.F.onChangeSkinType();
            this.O.onChangeSkinType(this.i, TbadkCoreApplication.getInst().getSkinType());
            this.N.onChangeSkinType();
            if (getBusinessType() == 1 || getBusinessType() == 2) {
                View view = this.m;
                view.setBackgroundDrawable(c.a.p0.l3.j0.c.a.e(R.string.J_X06, R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50, view.getMeasuredHeight()));
            }
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor((TextView) this.O.getUserName());
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0105, 1);
            ThreadCardUtils.setAbstractStyleAb(this.C);
            SkinManager.setViewTextColor(this.I, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.E, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.D, R.drawable.obfuscated_res_0x7f0800c2);
            SkinManager.setBackgroundColor(this.V, R.color.CAM_X0203);
            SkinManager.setBackgroundColor(this.U, R.color.CAM_X0204);
            this.H.p(i2);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.W);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            this.W.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: k0 */
    public void u(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, adCard) == null) {
            this.M = adCard;
            if (adCard == null) {
                return;
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            K(adCard);
            a0(adCard, advertAppInfo);
            T(adCard);
            Z(adCard, advertAppInfo);
            S(adCard);
            R(advertAppInfo, adCard);
            b0(adCard);
            p0(adCard);
            this.m.setOnClickListener(new c(this));
            O(adCard);
            t(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.R == null || this.S == null) {
            return;
        }
        c.a.p0.x.g.e.d().j(this.R, this.S);
    }

    public DownloadData m0(AdvertAppInfo advertAppInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048609, this, advertAppInfo, i2)) == null) {
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.r);
            downloadData.setName(advertAppInfo.n);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(c.a.d.f.m.b.e(advertAppInfo.a, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.R == null || this.S == null) {
            return;
        }
        c.a.p0.x.g.e.d().r(this.R, this.S);
    }

    public final void o0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, adCard) == null) {
            c.a.o0.r.r.c appInfoModel = adCard.getAppInfoModel();
            RelativeLayout downloadButtonContainer = this.W.getDownloadButtonContainer();
            if (c.a.o0.r.r.c.a(appInfoModel)) {
                this.W.setVisibility(0);
                this.W.setAppInfo(appInfoModel);
                this.W.setAd(adCard.getAdvertAppInfo());
                if (h0(this.H, downloadButtonContainer)) {
                    return;
                }
                i0(this.H, downloadButtonContainer);
                return;
            }
            this.W.setVisibility(8);
            if (h0(this.H, this.J)) {
                return;
            }
            i0(this.H, this.J);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onAttachedToWindow();
            l0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onDetachedFromWindow();
            n0();
        }
    }

    public final void p0(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, adCard) == null) {
            if (adCard.gameModel == null && this.g0 == null) {
                return;
            }
            AdLottieButtonView adLottieButtonView = this.g0;
            if ((adLottieButtonView == null || adLottieButtonView.getParent() == null) && !X()) {
                return;
            }
            this.g0.setData(adCard.gameModel);
            this.g0.setClickListener(new b(this, adCard));
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            MessageManager.getInstance().registerListener(this.h0);
            MessageManager.getInstance().registerListener(this.i0);
            View inflate = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
            this.m = inflate;
            this.U = inflate.findViewById(R.id.obfuscated_res_0x7f090305);
            View findViewById = this.m.findViewById(R.id.obfuscated_res_0x7f091fb9);
            this.p = findViewById;
            findViewById.setClickable(true);
            this.C = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0900f3);
            this.D = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f09213f);
            this.H = (ApkDownloadView) this.m.findViewById(R.id.obfuscated_res_0x7f090142);
            this.I = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f090146);
            this.J = (RelativeLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0903e2);
            this.H.k(this.i.getUniqueId());
            this.h0.setTag(this.i.getUniqueId());
            this.K = this.m.findViewById(R.id.obfuscated_res_0x7f0904c3);
            this.i0.setTag(this.i.getUniqueId());
            AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout = (AdThreadCommentAndPraiseInfoLayout) this.m.findViewById(R.id.obfuscated_res_0x7f090538);
            this.N = adThreadCommentAndPraiseInfoLayout;
            adThreadCommentAndPraiseInfoLayout.setStyle(1);
            this.O = (AdThreadUserInfoLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0904c4);
            this.T = (FrameLayout) this.m.findViewById(R.id.obfuscated_res_0x7f09042c);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0071, (ViewGroup) null);
            this.G = linearLayout;
            AdCloseView adCloseView = (AdCloseView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090092);
            this.F = adCloseView;
            adCloseView.k.getLayoutParams().height = n.f(getContext(), R.dimen.tbds76);
            this.F.k.getLayoutParams().width = n.f(getContext(), R.dimen.tbds76);
            TextView textView = (TextView) this.G.findViewById(R.id.obfuscated_res_0x7f09098a);
            this.E = textView;
            textView.setVisibility(8);
            this.O.addAdTagView(this.G);
            ViewStub viewStub = (ViewStub) this.m.findViewById(R.id.obfuscated_res_0x7f09009a);
            this.n = viewStub;
            viewStub.setLayoutResource(getCustomLayout());
            this.o = this.n.inflate();
            this.P = this.m.findViewById(R.id.obfuscated_res_0x7f091690);
            this.Q = this.m.findViewById(R.id.obfuscated_res_0x7f090acc);
            this.V = this.m.findViewById(R.id.obfuscated_res_0x7f09168b);
            AdAppInfoView adAppInfoView = (AdAppInfoView) this.m.findViewById(R.id.obfuscated_res_0x7f09028c);
            this.W = adAppInfoView;
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(adAppInfoView);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            U(this.o);
            return this.m;
        }
        return (View) invokeV.objValue;
    }
}
