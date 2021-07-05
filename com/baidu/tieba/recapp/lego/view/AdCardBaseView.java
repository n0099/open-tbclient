package com.baidu.tieba.recapp.lego.view;

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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.AdThreadUserInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.l;
import d.a.r0.r.s.a;
import d.a.s0.q.d.g.b;
import d.a.s0.w2.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.AdCloseInfo;
import tbclient.App;
/* loaded from: classes5.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public int G;
    public TextView H;
    public TextView I;
    public TextView J;
    public AdCloseView K;
    public LinearLayout L;
    public ApkDownloadView M;
    public TextView N;
    public RelativeLayout O;
    public View P;
    public String Q;
    public AdCard R;
    public AdThreadCommentAndPraiseInfoLayout S;
    public AdThreadUserInfoLayout T;
    public View U;
    public View V;
    public PermissionJudgePolicy W;
    public DownloadCacheKey a0;
    public d.a.s0.q.d.h.d b0;
    public FrameLayout c0;
    public View i0;
    public View j0;
    public AdAppInfoView k0;
    public CustomMessageListener l0;
    public CustomMessageListener m0;
    public View r;
    public ViewStub s;
    public View t;
    public View u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    /* loaded from: classes5.dex */
    public class a implements AdThreadUserInfoLayout.AfterAdjustChildWidthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdCard f20466a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f20467b;

        public a(AdCardBaseView adCardBaseView, AdCard adCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView, adCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20467b = adCardBaseView;
            this.f20466a = adCard;
        }

        @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
        public void afterChildWidth() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((TextView) this.f20467b.T.getUserName()).setText(this.f20466a.userName);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f20468e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f20469f;

        public b(AdCardBaseView adCardBaseView, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView, advertAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20469f = adCardBaseView;
            this.f20468e = advertAppInfo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            AdvertAppInfo advertAppInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                d.a.r0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.f() || (advertAppInfo = this.f20468e) == null) {
                    return false;
                }
                d.a.c.e.p.a.a(advertAppInfo.r4());
                ((Vibrator) this.f20469f.m.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20470e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f20471f;

        public c(AdCardBaseView adCardBaseView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20471f = adCardBaseView;
            this.f20470e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f20471f.R != null) {
                    str = this.f20471f.R.getDownloadId();
                    str2 = this.f20471f.R.getExtInfo();
                } else {
                    str = null;
                    str2 = null;
                }
                int e2 = x.e(this.f20471f.m, this.f20470e, str, str2);
                if (this.f20471f.o != null) {
                    this.f20471f.o.a(e2, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f20472e;

        public d(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20472e = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20472e.K.performClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f20473a;

        public e(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20473a = adCardBaseView;
        }

        @Override // d.a.s0.q.d.g.b.a
        public boolean b(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f20473a.Y();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f20474e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f20475f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f20476g;

        public f(AdCardBaseView adCardBaseView, AdvertAppInfo advertAppInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView, advertAppInfo, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20476g = adCardBaseView;
            this.f20474e = advertAppInfo;
            this.f20475f = i2;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                AdCardBaseView adCardBaseView = this.f20476g;
                adCardBaseView.b0(this.f20474e, this.f20475f, adCardBaseView.M);
                AdCardBaseView adCardBaseView2 = this.f20476g;
                ApkDownloadView apkDownloadView = adCardBaseView2.M;
                if (apkDownloadView != null) {
                    apkDownloadView.v(adCardBaseView2.G0(this.f20474e, this.f20475f));
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f20477e;

        public g(AdCardBaseView adCardBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20477e = adCardBaseView;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<AdCardBaseView> f20478a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(int i2, AdCardBaseView adCardBaseView) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), adCardBaseView};
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
            this.f20478a = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView;
            DownloadData downloadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (adCardBaseView = this.f20478a.get()) == null || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(adCardBaseView.Q) || !adCardBaseView.Q.equals(downloadData.getId())) {
                return;
            }
            int p = d.a.s0.w2.c0.e.p(downloadData);
            if (p == 7) {
                adCardBaseView.I.setText(R.string.pause_load);
            } else if (p == 1 || p == 2) {
                adCardBaseView.I.setText(R.string.pb_download_pause);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public AdCard f20479e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f20480f;

        public i(AdCardBaseView adCardBaseView, AdCard adCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardBaseView, adCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20480f = adCardBaseView;
            this.f20479e = adCard;
        }

        public final void a(AdvertAppInfo advertAppInfo, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, advertAppInfo, z) == null) {
                if (!this.f20479e.isDirectDownload() && !z) {
                    d(advertAppInfo);
                } else {
                    b(advertAppInfo, z);
                }
            }
        }

        public final void b(AdvertAppInfo advertAppInfo, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z) == null) {
                int i2 = advertAppInfo.position;
                int m = ApkDownloadView.m(this.f20480f.G0(advertAppInfo, i2));
                if ((6 == m || 7 == m) && d.a.c.e.p.j.z() && !d.a.c.e.p.j.H()) {
                    this.f20480f.F0(advertAppInfo, i2, true, "");
                    return;
                }
                AdCardBaseView adCardBaseView = this.f20480f;
                adCardBaseView.f0(advertAppInfo, i2, adCardBaseView.M, z);
                this.f20480f.Y();
            }
        }

        public final void c(AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo) == null) {
                String extInfo = this.f20480f.R.getExtInfo();
                int e2 = x.e(this.f20480f.m, this.f20480f.R.scheme, this.f20480f.R.getDownloadId(), extInfo);
                if (this.f20480f.o != null) {
                    this.f20480f.o.a(e2, null);
                }
            }
        }

        public final void d(AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, advertAppInfo) == null) {
                String str = this.f20480f.R.scheme;
                int e2 = !x.B(advertAppInfo, str) ? x.e(this.f20480f.m, str, this.f20480f.R.getDownloadId(), this.f20480f.R.getExtInfo()) : 3;
                if (this.f20480f.o != null) {
                    this.f20480f.o.a(e2, null);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
                if (!d.a.c.e.p.j.A()) {
                    this.f20480f.m.showToast(R.string.neterror);
                } else if (this.f20479e == null || view == null || view.getId() == R.id.thread_info_commont_container) {
                } else {
                    AdvertAppInfo advertAppInfo = this.f20479e.getAdvertAppInfo();
                    boolean z = view == this.f20480f.M;
                    if (advertAppInfo != null && advertAppInfo.t4()) {
                        a(advertAppInfo, z);
                    } else {
                        c(advertAppInfo);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<AdCardBaseView> f20481a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(int i2, AdCardBaseView adCardBaseView) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), adCardBaseView};
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
            this.f20481a = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView;
            DownloadData downloadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (adCardBaseView = this.f20481a.get()) == null || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(adCardBaseView.Q) || !adCardBaseView.Q.equals(downloadData.getId())) {
                return;
            }
            adCardBaseView.M.r(downloadData);
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
        this.b0 = null;
        this.l0 = new h(2016484, this);
        this.m0 = new j(2016483, this);
        Resources resources = tbPageContext.getResources();
        this.v = (int) resources.getDimension(R.dimen.tbds92);
        resources.getDimension(R.dimen.tbds92);
        this.w = (int) resources.getDimension(R.dimen.M_W_X004);
        resources.getDimension(R.dimen.tbds90);
        resources.getDimension(R.dimen.tbds90);
        resources.getDimension(R.dimen.tbds22);
        this.x = (int) resources.getDimension(R.dimen.M_W_X005);
        this.A = (int) resources.getDimension(R.dimen.M_W_X004);
        this.B = 0;
        this.y = (int) resources.getDimension(R.dimen.M_W_X007);
        this.z = (int) resources.getDimension(R.dimen.M_H_X005);
        this.C = (int) resources.getDimension(R.dimen.tbds208);
        this.D = (int) resources.getDimension(R.dimen.tbds33);
        this.E = (int) resources.getDimension(R.dimen.tbds72);
        this.F = (int) resources.getDimension(R.dimen.tbds48);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: A0 */
    public void w(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            this.R = adCard;
            if (adCard == null) {
                return;
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            i iVar = new i(this, adCard);
            X(adCard);
            q0(adCard, advertAppInfo, iVar);
            i0(adCard);
            p0(adCard, advertAppInfo, iVar);
            h0(adCard);
            g0(advertAppInfo, adCard);
            s0(adCard, iVar);
            this.r.setOnClickListener(iVar);
            c0(adCard);
            v(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a0 == null || this.b0 == null) {
            return;
        }
        d.a.s0.q.d.e.c().i(this.a0, this.b0);
    }

    public final void C0(AdCard adCard, DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adCard, downloadData) == null) {
            if (adCard.isDirectDownload()) {
                downloadData.setStatus(ApkDownloadView.m(downloadData));
            } else {
                downloadData.setStatus(this.M.getDownloadStatus());
            }
        }
    }

    public final void D0(AdCard adCard, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, adCard, iVar) == null) {
            if (adCard.isDirectDownload()) {
                this.M.setOnClickListener(iVar);
            } else {
                this.M.setOnClickInterceptListener(new e(this));
            }
        }
    }

    public void E0(View view, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, view, iVar) == null) || view == null) {
            return;
        }
        view.setClickable(true);
        view.setOnClickListener(iVar);
    }

    public void F0(AdvertAppInfo advertAppInfo, int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) || advertAppInfo == null) {
            return;
        }
        if (!d.a.c.e.p.j.A()) {
            l.L(this.m.getPageActivity(), R.string.neterror);
        } else if (advertAppInfo.t4()) {
            if (TextUtils.isEmpty(str)) {
                str = this.m.getString(R.string.frs_network_tips);
            }
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.m.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.alert_yes_button, new f(this, advertAppInfo, i2));
            aVar.setNegativeButton(R.string.cancel, new g(this));
            aVar.create(this.m).show();
        }
    }

    public DownloadData G0(AdvertAppInfo advertAppInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, advertAppInfo, i2)) == null) {
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.c4);
            downloadData.setName(advertAppInfo.Y3);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(d.a.c.e.m.b.d(advertAppInfo.L3, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.a0 == null || this.b0 == null) {
            return;
        }
        d.a.s0.q.d.e.c().q(this.a0, this.b0);
    }

    public final void I0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adCard) == null) {
            d.a.r0.r.q.c appInfoModel = adCard.getAppInfoModel();
            RelativeLayout downloadButtonContainer = this.k0.getDownloadButtonContainer();
            if (d.a.r0.r.q.c.a(appInfoModel)) {
                this.k0.setVisibility(0);
                this.k0.setAppInfo(appInfoModel);
                this.k0.setAd(adCard.getAdvertAppInfo());
                if (x0(this.M, downloadButtonContainer)) {
                    return;
                }
                y0(this.M, downloadButtonContainer);
                return;
            }
            this.k0.setVisibility(8);
            if (x0(this.M, this.O)) {
                return;
            }
            y0(this.M, this.O);
        }
    }

    public final void U(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view) == null) && view != null && view.getVisibility() == 0) {
            this.c0.setVisibility(0);
            if (x0(view, this.c0)) {
                return;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.c0.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.c0.addView(view);
        }
    }

    public final void W(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view) == null) && view != null && view.getVisibility() == 0) {
            this.c0.setVisibility(8);
            if (x0(view, this.T)) {
                return;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.T.addAdTagView(this.L);
        }
    }

    public final void X(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, adCard) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.P.getLayoutParams();
            layoutParams.topMargin = this.m.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            this.P.setPadding(0, 0, 0, 0);
            this.c0.setVisibility(8);
            this.i0.setVisibility(8);
            if (w0()) {
                View view = this.r;
                int i2 = this.y;
                view.setPadding(i2, this.z, i2, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.P.getLayoutParams();
                int k = (l.k(getContext()) - (this.B * 2)) - (this.y * 2);
                int i3 = this.v;
                int i4 = this.w;
                this.G = (k - i3) - i4;
                layoutParams2.leftMargin = i3 + i4;
                this.j0.setVisibility(0);
                W(this.L);
                if (v0(adCard)) {
                    this.j0.setVisibility(8);
                    this.r.setPadding(0, 0, 0, 0);
                    View view2 = this.P;
                    int i5 = this.y;
                    view2.setPadding(i5, 0, i5, 0);
                    layoutParams2.leftMargin = 0;
                    this.G = (l.k(getContext()) - (this.y * 2)) - (this.B * 2);
                    layoutParams.topMargin = this.m.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                    this.i0.setVisibility(0);
                    SkinManager.setBackgroundColor(this.i0, R.color.CAM_X0204);
                    U(this.L);
                    return;
                }
                return;
            }
            View view3 = this.r;
            int i6 = this.x;
            view3.setPadding(i6, this.z, i6, 0);
            this.G = (l.k(getContext()) - (this.x * 2)) - (this.A * 2);
            if ((d.a.s0.u0.b.e().g() || d.a.s0.u0.a.h().j()) && t0()) {
                this.u.setVisibility(0);
                SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
            } else {
                this.u.setVisibility(8);
            }
            this.j0.setVisibility(8);
        }
    }

    public void Y() {
        d.a.s0.n1.o.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.a(3, null);
    }

    public void Z(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.a0 = downloadCacheKey;
        H0();
        this.b0 = null;
        AdDownloadData b2 = d.a.s0.q.d.e.c().b(downloadCacheKey);
        if (x.q(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.R;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.R.getAdvertAppInfo().V3;
            b2.setExtInfo(this.R.getExtInfo());
            b2.setDownloadKey(this.R.getDownloadKey());
            b2.setAppJson(App.toJson(this.R.getAdvertAppInfo().X3).toString());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.R.scheme);
        }
        d.a.s0.q.c.b.d.a aVar = new d.a.s0.q.c.b.d.a(this.M, b2);
        this.b0 = new d.a.s0.q.d.h.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        B0();
        this.M.c(b2.getCurrentState());
    }

    public final void a0(AdCard adCard, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, adCard, iVar) == null) {
            if (adCard.getAgreeNum() == -1 && adCard.getShareNum() == -1 && adCard.getReplyNum() == -1) {
                this.V.setVisibility(0);
                this.S.setVisibility(8);
                return;
            }
            this.V.setVisibility(8);
            this.S.setVisibility(0);
            this.S.setBarNameClickEnabled(false);
            this.S.setReplyTimeVisible(false);
            this.S.setData(adCard.getThreadData());
            if (adCard.getAgreeNum() != -1) {
                this.S.setAgreeClickable(true);
                this.S.setPraiseContainerBgGray(false);
            } else {
                this.S.setAgreeClickable(false);
                this.S.setPraiseContainerBgGray(true);
            }
            if (adCard.getShareNum() != -1) {
                this.S.setShareClickable(true);
                this.S.setShareContainerBgGray(false);
            } else {
                this.S.setShareClickable(false);
                this.S.setShareContainerBgGray(true);
            }
            if (this.S.getCommentContainer() != null) {
                this.S.getCommentContainer().setOnClickListener(iVar);
            }
            this.S.setNeedAddReplyIcon(true);
            this.S.setCommentNumEnable(false);
            this.S.setCommentClickable(true);
            this.S.setReplayContainerBgGray(true);
            this.S.setOnClickListener(iVar);
            this.S.setShareData(adCard);
            this.S.setDisPraiseViewVisibility(false);
        }
    }

    public void b0(AdvertAppInfo advertAppInfo, int i2, ApkDownloadView apkDownloadView) {
        d.a.s0.n1.o.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048591, this, advertAppInfo, i2, apkDownloadView) == null) || advertAppInfo == null) {
            return;
        }
        if (advertAppInfo.w4() != 0) {
            l.L(this.m.getPageActivity(), R.string.download_error);
            return;
        }
        if (this.W == null) {
            this.W = new PermissionJudgePolicy();
        }
        this.W.clearRequestPermissionList();
        this.W.appendRequestPermission(this.m.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.W.startRequestPermission(this.m.getPageActivity()) || (cVar = this.q) == null) {
            return;
        }
        cVar.a(advertAppInfo, i2);
        if (apkDownloadView != null) {
            apkDownloadView.v(G0(advertAppInfo, i2));
        }
    }

    public abstract void c0(AdCard adCard);

    public float d0(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            try {
                return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i2).split(",")[0]);
            } catch (Exception unused) {
                return 0.0f;
            }
        }
        return invokeI.floatValue;
    }

    public void f0(AdvertAppInfo advertAppInfo, int i2, ApkDownloadView apkDownloadView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{advertAppInfo, Integer.valueOf(i2), apkDownloadView, Boolean.valueOf(z)}) == null) || advertAppInfo == null) {
            return;
        }
        DownloadData G0 = G0(advertAppInfo, i2);
        int m = ApkDownloadView.m(G0);
        if (m != 1) {
            if (m == 3) {
                d.a.s0.w2.c0.h.d(this.m.getPageActivity(), advertAppInfo.d4);
                return;
            } else if (m != 5) {
                if (m == 6 || m == 7) {
                    b0(advertAppInfo, i2, this.M);
                    apkDownloadView.s(G0);
                    return;
                } else if (m != 8) {
                    return;
                } else {
                    d.a.s0.q.d.e.c().o(this.m.getPageActivity(), advertAppInfo.d4);
                    return;
                }
            }
        }
        if (z) {
            d.a.s0.w2.c0.h.a(advertAppInfo);
            apkDownloadView.p(G0);
        }
    }

    public final void g0(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, advertAppInfo, adCard) == null) {
            if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
                this.K.setVisibility(0);
                this.K.setPage(getBusinessType());
                this.K.setData(advertAppInfo, adCard.closeInfo);
                l.c(this.m.getPageActivity(), this.L, 40, 40, 40, 120);
                this.L.setOnClickListener(new d(this));
                return;
            }
            this.K.setVisibility(8);
            this.J.setOnClickListener(null);
        }
    }

    public abstract int getCustomLayout();

    public abstract int getLayout();

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, d.a.s0.n1.o.l.e
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && w0()) {
            this.H.setTextSize(0, TbConfig.getContentSize());
        }
    }

    public final void h0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, adCard) == null) {
            int i2 = (this.G - this.C) - this.F;
            if (w0()) {
                i2 -= this.D + this.E;
            }
            String str = adCard.recommendReason;
            if (TextUtils.isEmpty(str)) {
                str = adCard.userName;
            }
            TextView textView = this.N;
            textView.setText(d.a.s0.w2.f0.c.a.d(str, "广告", i2, textView.getPaint()));
        }
    }

    public final void i0(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, adCard) == null) {
            String str = adCard.threadTitle;
            if (TextUtils.isEmpty(str)) {
                this.H.setVisibility(8);
                return;
            }
            int i2 = adCard.maxTitleLine;
            if (i2 <= 0) {
                i2 = 4;
            }
            this.H.setMaxLines(i2);
            this.H.setText(str);
            this.H.setVisibility(0);
        }
    }

    public abstract void j0(View view);

    public final void k0(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048602, this, advertAppInfo, adCard, iVar) == null) {
            I0(adCard);
            this.I.setVisibility(8);
            this.M.setVisibility(0);
            this.M.setClickable(true);
            this.M.setInitText(adCard.getButtonText());
            this.Q = advertAppInfo.d4;
            DownloadData G0 = G0(advertAppInfo, advertAppInfo.position);
            if (x.q(this.Q)) {
                G0.setStatus(8);
            } else {
                C0(adCard, G0);
            }
            this.M.setData(G0);
            D0(adCard, iVar);
        }
    }

    public final void l0(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048603, this, adCard, advertAppInfo) == null) || adCard.isDirectDownload()) {
            return;
        }
        String scheme = adCard.getScheme();
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            h2 = d.a.s0.q.d.e.c().g(downloadId);
        } else {
            h2 = d.a.s0.q.d.e.c().h(scheme);
        }
        if (h2 == null) {
            h2 = DownloadCacheKey.create(downloadId, advertAppInfo.c4, advertAppInfo.d4);
            d.a.s0.q.d.e.c().i(h2, null);
        }
        Z(h2);
    }

    public final void m0(@NonNull AdCard adCard, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, adCard, iVar) == null) {
            this.M.setVisibility(8);
            this.k0.setVisibility(8);
            this.I.setVisibility(0);
            this.I.setClickable(true);
            SkinManager.setViewTextColor(this.I, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.I, R.drawable.ad_download_progress_button_bg);
            this.I.setText(adCard.getButtonText());
            this.I.setOnClickListener(new c(this, adCard.getButtonScheme()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onAttachedToWindow();
            B0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onDetachedFromWindow();
            H0();
        }
    }

    public final void p0(AdCard adCard, AdvertAppInfo advertAppInfo, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048607, this, adCard, advertAppInfo, iVar) == null) {
            if (adCard != null && advertAppInfo != null) {
                this.O.setVisibility(0);
                if (advertAppInfo.t4()) {
                    k0(advertAppInfo, adCard, iVar);
                    l0(adCard, advertAppInfo);
                    return;
                } else if (advertAppInfo.v4()) {
                    m0(adCard, iVar);
                    return;
                } else {
                    return;
                }
            }
            this.O.setVisibility(8);
        }
    }

    public final void q0(AdCard adCard, AdvertAppInfo advertAppInfo, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048608, this, adCard, advertAppInfo, iVar) == null) {
            AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
            if (advertAppInfo2 != null) {
                advertAppInfo2.c4(StringHelper.getFormatTimeForJustNow(adCard.getTime()));
            }
            this.T.setShowFlag(1413);
            this.T.setData(advertAppInfo2);
            ((TextView) this.T.getUserName()).setText(adCard.userName);
            d.a.r0.b.g.b.d((TextView) this.T.getUserName());
            this.T.getUserName().setOnClickListener(iVar);
            this.T.setAfterAdjustChildWidthListener(new a(this, adCard));
            this.T.getHeaderImg().setOnLongClickListener(new b(this, advertAppInfo));
            E0(this.T.getHeaderImg(), iVar);
            if (v0(adCard)) {
                this.T.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            MessageManager.getInstance().registerListener(this.l0);
            MessageManager.getInstance().registerListener(this.m0);
            View inflate = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
            this.r = inflate;
            this.i0 = inflate.findViewById(R.id.banner_top_divider);
            View findViewById = this.r.findViewById(R.id.thread_multi_del_ad_mask_view);
            this.u = findViewById;
            findViewById.setClickable(true);
            this.H = (TextView) this.r.findViewById(R.id.ad_title);
            this.I = (TextView) this.r.findViewById(R.id.transform_btn);
            this.M = (ApkDownloadView) this.r.findViewById(R.id.advert_app_download_view);
            this.N = (TextView) this.r.findViewById(R.id.advert_app_name);
            this.O = (RelativeLayout) this.r.findViewById(R.id.bottom_transformation_area);
            this.M.j(this.m.getUniqueId());
            this.l0.setTag(this.m.getUniqueId());
            this.P = this.r.findViewById(R.id.card_ad_middle_container);
            this.m0.setTag(this.m.getUniqueId());
            AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout = (AdThreadCommentAndPraiseInfoLayout) this.r.findViewById(R.id.card_home_page_normal_thread_info_layout);
            this.S = adThreadCommentAndPraiseInfoLayout;
            adThreadCommentAndPraiseInfoLayout.setStyle(1);
            this.T = (AdThreadUserInfoLayout) this.r.findViewById(R.id.card_ad_user_info_layout);
            this.c0 = (FrameLayout) this.r.findViewById(R.id.btn_pb_card_bottom_op_more_container);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
            this.L = linearLayout;
            AdCloseView adCloseView = (AdCloseView) linearLayout.findViewById(R.id.ad_close_view);
            this.K = adCloseView;
            ViewGroup.LayoutParams layoutParams = adCloseView.o.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.K.o.getLayoutParams();
            int g2 = l.g(getContext(), R.dimen.tbds62);
            layoutParams2.width = g2;
            layoutParams.height = g2;
            TextView textView = (TextView) this.L.findViewById(R.id.feed_tag);
            this.J = textView;
            textView.setVisibility(8);
            this.T.addAdTagView(this.L);
            ViewStub viewStub = (ViewStub) this.r.findViewById(R.id.ad_custom_view_stub);
            this.s = viewStub;
            viewStub.setLayoutResource(getCustomLayout());
            this.t = this.s.inflate();
            this.U = this.r.findViewById(R.id.pb_bottom_view);
            this.V = this.r.findViewById(R.id.frs_bottom_view);
            this.j0 = this.r.findViewById(R.id.pb_ad_bottom_divider);
            AdAppInfoView adAppInfoView = (AdAppInfoView) this.r.findViewById(R.id.app_info_view);
            this.k0 = adAppInfoView;
            d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(adAppInfoView);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            j0(this.t);
            return this.r;
        }
        return (View) invokeV.objValue;
    }

    public final void s0(AdCard adCard, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, adCard, iVar) == null) {
            this.S.setType(TbadkCoreApplication.getInst().getCardShowType());
            if (w0()) {
                this.S.setVisibility(8);
                this.S.setBarNameClickEnabled(false);
                this.S.setShareVisible(false);
                this.S.setShowPraiseNum(false);
                this.S.setCommentNumEnable(false);
                this.S.setReplyTimeVisible(false);
                this.U.setVisibility(0);
                this.V.setVisibility(8);
                return;
            }
            a0(adCard, iVar);
        }
    }

    public final boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f18191f == 1 : invokeV.booleanValue;
    }

    public boolean v0(AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, adCard)) == null) ? w0() && adCard.isPBBanner : invokeL.booleanValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? getBusinessType() == 4 : invokeV.booleanValue;
    }

    public final boolean x0(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, view, viewGroup)) == null) ? (view == null || view.getParent() == null || view.getParent() != viewGroup) ? false : true : invokeLL.booleanValue;
    }

    public final void y0(View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048617, this, view, viewGroup) == null) && view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
            viewGroup.addView(view);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: z0 */
    public void v(AdCard adCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048618, this, adCard, i2) == null) {
            this.K.onChangeSkinType();
            this.T.onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
            this.S.onChangeSkinType();
            if (getBusinessType() == 1 || getBusinessType() == 2) {
                d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.r);
                d2.n(R.string.J_X06);
                d2.i(R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50);
            }
            d.a.r0.b.g.b.e((TextView) this.T.getUserName());
            SkinManager.setViewTextColor(this.H, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.N, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.J, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.I, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.I, R.drawable.ad_download_progress_button_bg);
            SkinManager.setBackgroundColor(this.j0, R.color.CAM_X0203);
            SkinManager.setBackgroundColor(this.i0, R.color.CAM_X0204);
            this.M.o(i2);
            d.a.r0.r.u.c d3 = d.a.r0.r.u.c.d(this.k0);
            d3.n(R.string.J_X05);
            d3.f(R.color.CAM_X0206);
            this.k0.onChangeSkinType();
        }
    }
}
