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
import c.a.d.f.p.l;
import c.a.q0.s.s.a;
import c.a.r0.h3.z;
import c.a.r0.v.g.g.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.JsonTransHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
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
import com.bumptech.glide.load.engine.GlideException;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
/* loaded from: classes11.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int HEAD_IMAGE_HEIGHT;
    public final int HEAD_IMAGE_HEIGHT_PB;
    public final int HEAD_IMAGE_RIGHT_MARGIN;
    public final int HEAD_IMAGE_RIGHT_MARGIN_PB;
    public final int HEAD_IMAGE_WIDTH;
    public final int HEAD_IMAGE_WIDTH_PB;
    public final int ROOT_MARGIN;
    public final int ROOT_PADDING;
    public String apkPackage;

    /* renamed from: f  reason: collision with root package name */
    public final int f48641f;

    /* renamed from: g  reason: collision with root package name */
    public final int f48642g;

    /* renamed from: h  reason: collision with root package name */
    public final int f48643h;

    /* renamed from: i  reason: collision with root package name */
    public final int f48644i;

    /* renamed from: j  reason: collision with root package name */
    public final int f48645j;

    /* renamed from: k  reason: collision with root package name */
    public final int f48646k;
    public final int l;
    public AdCloseView m;
    public TextView mAdTag;
    public TextView mAdTitle;
    public ApkDownloadView mAdvertAppDownloadView;
    public TextView mAdvertName;
    public RelativeLayout mBottomTransformArea;
    public View mCardAdMiddleContainer;
    public View mCustomRoot;
    public ViewStub mCustomViewStub;
    public CustomMessageListener mDeleteBtnListener;
    public View mFrsBottomView;
    public View mFrsMultiDelAdMaskView;
    public int mMaxWidth;
    public View mPbBottomView;
    public View mRootView;
    public AdThreadUserInfoLayout mThreadUserInfoLayout;
    public TextView mTransformBtn;
    public CustomMessageListener mUpdateDownloadBtnListener;
    public LinearLayout n;
    public AdCard o;
    public AdThreadCommentAndPraiseInfoLayout p;
    public PermissionJudgePolicy q;
    public DownloadCacheKey r;
    public c.a.r0.v.g.h.d s;
    public FrameLayout t;
    public View u;
    public View v;
    public AdAppInfoView w;

    /* loaded from: classes11.dex */
    public class a implements AdThreadUserInfoLayout.AfterAdjustChildWidthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f48647b;

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
            this.f48647b = adCardBaseView;
            this.a = adCard;
        }

        @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
        public void afterChildWidth() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((TextView) this.f48647b.mThreadUserInfoLayout.getUserName()).setText(this.a.userName);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f48648e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f48649f;

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
            this.f48649f = adCardBaseView;
            this.f48648e = advertAppInfo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            AdvertAppInfo advertAppInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.q0.t.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.e() || (advertAppInfo = this.f48648e) == null) {
                    return false;
                }
                c.a.d.f.p.a.a(advertAppInfo.T4());
                ((Vibrator) this.f48649f.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48650e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f48651f;

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
            this.f48651f = adCardBaseView;
            this.f48650e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f48651f.o != null) {
                    str = this.f48651f.o.getDownloadId();
                    str2 = this.f48651f.o.getExtInfo();
                    str3 = this.f48651f.o.cmdScheme;
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                int e2 = z.e(this.f48651f.mContext, this.f48650e, str, str2, str3);
                if (this.f48651f.afterClickSchemeListener != null) {
                    this.f48651f.afterClickSchemeListener.a(e2, null);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f48652e;

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
            this.f48652e = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48652e.m.performClick();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f48653b;

        public e(AdCardBaseView adCardBaseView, String str) {
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
            this.f48653b = adCardBaseView;
            this.a = str;
        }

        @Override // c.a.r0.v.g.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.r0.v.a.a(this.a);
                this.f48653b.afterClick();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f48654e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48655f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f48656g;

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
            this.f48656g = adCardBaseView;
            this.f48654e = advertAppInfo;
            this.f48655f = i2;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                AdCardBaseView adCardBaseView = this.f48656g;
                adCardBaseView.downloadApp(this.f48654e, this.f48655f, adCardBaseView.mAdvertAppDownloadView);
                AdCardBaseView adCardBaseView2 = this.f48656g;
                ApkDownloadView apkDownloadView = adCardBaseView2.mAdvertAppDownloadView;
                if (apkDownloadView != null) {
                    apkDownloadView.updata(adCardBaseView2.L(this.f48654e, this.f48655f));
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f48657e;

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
            this.f48657e = adCardBaseView;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AdCardBaseView> a;

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
            this.a = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView;
            DownloadData downloadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (adCardBaseView = this.a.get()) == null || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(adCardBaseView.apkPackage) || !adCardBaseView.apkPackage.equals(downloadData.getId())) {
                return;
            }
            int p = c.a.r0.h3.f0.e.p(downloadData);
            if (p == 7) {
                adCardBaseView.mTransformBtn.setText(R.string.pause_load);
            } else if (p == 1 || p == 2) {
                adCardBaseView.mTransformBtn.setText(R.string.pb_download_pause);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public AdCard f48658e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f48659f;

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
            this.f48659f = adCardBaseView;
            this.f48658e = adCard;
        }

        public final void a(AdvertAppInfo advertAppInfo, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, advertAppInfo, z) == null) {
                if (!this.f48658e.isDirectDownload() && !z) {
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
                int status = ApkDownloadView.getStatus(this.f48659f.L(advertAppInfo, i2));
                if ((6 == status || 7 == status) && c.a.d.f.p.j.z() && !c.a.d.f.p.j.H()) {
                    this.f48659f.showDownloadAppDialog(advertAppInfo, i2, true, "");
                    return;
                }
                AdCardBaseView adCardBaseView = this.f48659f;
                adCardBaseView.handleAdvertAppClick(advertAppInfo, i2, adCardBaseView.mAdvertAppDownloadView, z);
                this.f48659f.afterClick();
            }
        }

        public final void c(AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo) == null) {
                String extInfo = this.f48659f.o.getExtInfo();
                int e2 = z.e(this.f48659f.mContext, this.f48659f.o.scheme, this.f48659f.o.getDownloadId(), extInfo, this.f48659f.o.cmdScheme);
                if (this.f48659f.afterClickSchemeListener != null) {
                    this.f48659f.afterClickSchemeListener.a(e2, null);
                }
            }
        }

        public final void d(AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, advertAppInfo) == null) {
                String str = this.f48659f.o.scheme;
                int e2 = !z.C(advertAppInfo, str) ? z.e(this.f48659f.mContext, str, this.f48659f.o.getDownloadId(), this.f48659f.o.getExtInfo(), this.f48659f.o.cmdScheme) : 3;
                if (this.f48659f.afterClickSchemeListener != null) {
                    this.f48659f.afterClickSchemeListener.a(e2, null);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
                if (!c.a.d.f.p.j.A()) {
                    this.f48659f.mContext.showToast(R.string.neterror);
                } else if (this.f48658e == null || view == null || view.getId() == R.id.thread_info_commont_container) {
                } else {
                    AdvertAppInfo advertAppInfo = this.f48658e.getAdvertAppInfo();
                    boolean z = view == this.f48659f.mAdvertAppDownloadView;
                    if (advertAppInfo != null && advertAppInfo.V4()) {
                        a(advertAppInfo, z);
                    } else {
                        c(advertAppInfo);
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AdCardBaseView> a;

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
            this.a = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView;
            DownloadData downloadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (adCardBaseView = this.a.get()) == null || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(adCardBaseView.apkPackage) || !adCardBaseView.apkPackage.equals(downloadData.getId())) {
                return;
            }
            adCardBaseView.mAdvertAppDownloadView.reset(downloadData);
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
        this.s = null;
        this.mUpdateDownloadBtnListener = new h(2016484, this);
        this.mDeleteBtnListener = new j(2016483, this);
        Resources resources = tbPageContext.getResources();
        this.HEAD_IMAGE_WIDTH = (int) resources.getDimension(R.dimen.tbds92);
        this.HEAD_IMAGE_HEIGHT = (int) resources.getDimension(R.dimen.tbds92);
        this.HEAD_IMAGE_RIGHT_MARGIN = (int) resources.getDimension(R.dimen.M_W_X004);
        this.HEAD_IMAGE_WIDTH_PB = (int) resources.getDimension(R.dimen.tbds90);
        this.HEAD_IMAGE_HEIGHT_PB = (int) resources.getDimension(R.dimen.tbds90);
        this.HEAD_IMAGE_RIGHT_MARGIN_PB = (int) resources.getDimension(R.dimen.tbds22);
        this.ROOT_PADDING = (int) resources.getDimension(R.dimen.M_W_X005);
        this.ROOT_MARGIN = (int) resources.getDimension(R.dimen.M_W_X004);
        this.f48643h = 0;
        this.f48641f = (int) resources.getDimension(R.dimen.M_W_X007);
        this.f48642g = (int) resources.getDimension(R.dimen.M_H_X005);
        this.f48644i = (int) resources.getDimension(R.dimen.tbds208);
        this.f48645j = (int) resources.getDimension(R.dimen.tbds33);
        this.f48646k = (int) resources.getDimension(R.dimen.tbds72);
        this.l = (int) resources.getDimension(R.dimen.tbds48);
    }

    public final void A(AdCard adCard, AdvertAppInfo advertAppInfo, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, adCard, advertAppInfo, iVar) == null) {
            AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
            if (advertAppInfo2 != null) {
                if (c.a.q0.b.d.I()) {
                    if (isHomePage()) {
                        advertAppInfo2.C4(this.mContext.getString(R.string.advert_label));
                    } else if (isPbPage()) {
                        advertAppInfo2.C4(StringHelper.getFormatTimeForJustNow(adCard.getTime()));
                    } else if (isFrsPage()) {
                        advertAppInfo2.C4(StringHelper.getFormatTimeForJustNow(adCard.getTime()) + GlideException.IndentedAppendable.INDENT + this.mContext.getString(R.string.advert_label));
                    }
                } else {
                    advertAppInfo2.C4(StringHelper.getFormatTimeForJustNow(adCard.getTime()));
                }
            }
            this.mThreadUserInfoLayout.setShowFlag(1413);
            this.mThreadUserInfoLayout.setData(advertAppInfo2);
            ((TextView) this.mThreadUserInfoLayout.getUserName()).setText(adCard.userName);
            c.a.q0.b.g.b.f((TextView) this.mThreadUserInfoLayout.getUserName());
            this.mThreadUserInfoLayout.getUserName().setOnClickListener(iVar);
            this.mThreadUserInfoLayout.setAfterAdjustChildWidthListener(new a(this, adCard));
            this.mThreadUserInfoLayout.getHeaderImg().setOnLongClickListener(new b(this, advertAppInfo));
            setPicClick(this.mThreadUserInfoLayout.getHeaderImg(), iVar);
            if (isPbBannerAd(adCard)) {
                this.mThreadUserInfoLayout.setVisibility(8);
            }
        }
    }

    public final void B(AdCard adCard, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adCard, iVar) == null) {
            this.p.setType(TbadkCoreApplication.getInst().getCardShowType());
            if (isPbPage()) {
                this.p.setVisibility(8);
                this.p.setBarNameClickEnabled(false);
                this.p.setShareVisible(false);
                this.p.setShowPraiseNum(false);
                this.p.setCommentNumEnable(false);
                this.p.setReplyTimeVisible(false);
                this.mPbBottomView.setVisibility(0);
                this.mFrsBottomView.setVisibility(8);
                return;
            }
            s(adCard, iVar);
        }
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBusinessType == 1 : invokeV.booleanValue;
    }

    public final boolean D(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, viewGroup)) == null) ? (view == null || view.getParent() == null || view.getParent() != viewGroup) ? false : true : invokeLL.booleanValue;
    }

    public final void E(View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, view, viewGroup) == null) && view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
            viewGroup.addView(view);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.r == null || this.s == null) {
            return;
        }
        c.a.r0.v.g.e.d().j(this.r, this.s);
    }

    public final void G(AdCard adCard, DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, adCard, downloadData) == null) {
            if (adCard.isDirectDownload()) {
                downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
            } else {
                downloadData.setStatus(this.mAdvertAppDownloadView.getDownloadStatus());
            }
        }
    }

    public final void K(AdCard adCard, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, adCard, iVar) == null) {
            if (adCard.isDirectDownload()) {
                this.mAdvertAppDownloadView.setOnClickListener(iVar);
                return;
            }
            this.mAdvertAppDownloadView.setOnClickInterceptListener(new e(this, adCard.getButtonCmdScheme()));
        }
    }

    public DownloadData L(AdvertAppInfo advertAppInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo, i2)) == null) {
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.t4);
            downloadData.setName(advertAppInfo.p4);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(c.a.d.f.m.b.e(advertAppInfo.c4, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.r == null || this.s == null) {
            return;
        }
        c.a.r0.v.g.e.d().r(this.r, this.s);
    }

    public final void O(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adCard) == null) {
            c.a.q0.s.q.c appInfoModel = adCard.getAppInfoModel();
            RelativeLayout downloadButtonContainer = this.w.getDownloadButtonContainer();
            if (c.a.q0.s.q.c.a(appInfoModel)) {
                this.w.setVisibility(0);
                this.w.setAppInfo(appInfoModel);
                this.w.setAd(adCard.getAdvertAppInfo());
                if (D(this.mAdvertAppDownloadView, downloadButtonContainer)) {
                    return;
                }
                E(this.mAdvertAppDownloadView, downloadButtonContainer);
                return;
            }
            this.w.setVisibility(8);
            if (D(this.mAdvertAppDownloadView, this.mBottomTransformArea)) {
                return;
            }
            E(this.mAdvertAppDownloadView, this.mBottomTransformArea);
        }
    }

    public void afterClick() {
        c.a.r0.w1.o.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (aVar = this.afterClickSchemeListener) == null) {
            return;
        }
        aVar.a(3, null);
    }

    public void bindDownloadData(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.r = downloadCacheKey;
        M();
        this.s = null;
        AdDownloadData b2 = c.a.r0.v.g.e.d().b(downloadCacheKey);
        if (z.r(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.o;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.o.getAdvertAppInfo().m4;
            b2.setExtInfo(this.o.getExtInfo());
            b2.setDownloadKey(this.o.getDownloadKey());
            JSONObject appJson = JsonTransHelper.toAppJson(this.o.getAdvertAppInfo().o4);
            if (appJson != null) {
                b2.setAppJson(appJson.toString());
            }
            b2.setPage(str);
            b2.setDeeplinkUrl(this.o.scheme);
            b2.setCmdScheme(this.o.cmdScheme);
            b2.setAppIcon(this.o.appInfoModel.f12869b);
            b2.setAppName(this.o.appInfoModel.f12870c);
        }
        c.a.r0.v.g.e d2 = c.a.r0.v.g.e.d();
        ApkDownloadView apkDownloadView = this.mAdvertAppDownloadView;
        c.a.r0.v.g.g.c c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.s = new c.a.r0.v.g.h.b(c2);
        if (b2.extra().getPercent() > 0) {
            c2.d(b2);
        }
        F();
        this.mAdvertAppDownloadView.onStatusChanged(b2.getCurrentState());
    }

    public void downloadApp(AdvertAppInfo advertAppInfo, int i2, ApkDownloadView apkDownloadView) {
        c.a.r0.w1.o.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048589, this, advertAppInfo, i2, apkDownloadView) == null) || advertAppInfo == null) {
            return;
        }
        if (advertAppInfo.Y4() != 0) {
            l.L(this.mContext.getPageActivity(), R.string.download_error);
            return;
        }
        if (this.q == null) {
            this.q = new PermissionJudgePolicy();
        }
        this.q.clearRequestPermissionList();
        this.q.appendRequestPermission(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.q.startRequestPermission(this.mContext.getPageActivity()) || (cVar = this.downloadAppCallback) == null) {
            return;
        }
        cVar.a(advertAppInfo, i2);
        if (apkDownloadView != null) {
            apkDownloadView.updata(L(advertAppInfo, i2));
        }
    }

    public abstract void fillCustomView(AdCard adCard);

    public abstract int getCustomLayout();

    public abstract int getLayout();

    public float getRatioByResString(@StringRes int i2) {
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

    public void handleAdvertAppClick(AdvertAppInfo advertAppInfo, int i2, ApkDownloadView apkDownloadView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{advertAppInfo, Integer.valueOf(i2), apkDownloadView, Boolean.valueOf(z)}) == null) || advertAppInfo == null) {
            return;
        }
        DownloadData L = L(advertAppInfo, i2);
        int status = ApkDownloadView.getStatus(L);
        if (status != 1) {
            if (status == 3) {
                c.a.r0.h3.f0.j.d(this.mContext.getPageActivity(), advertAppInfo.u4);
                return;
            } else if (status != 5) {
                if (status == 6 || status == 7) {
                    downloadApp(advertAppInfo, i2, this.mAdvertAppDownloadView);
                    apkDownloadView.startDownload(L);
                    return;
                } else if (status != 8) {
                    return;
                } else {
                    c.a.r0.v.g.e.d().p(this.mContext.getPageActivity(), advertAppInfo.u4);
                    return;
                }
            }
        }
        if (z) {
            c.a.r0.h3.f0.j.a(advertAppInfo);
            apkDownloadView.pause(L);
        }
    }

    public abstract void initCustomView(View view);

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            MessageManager.getInstance().registerListener(this.mUpdateDownloadBtnListener);
            MessageManager.getInstance().registerListener(this.mDeleteBtnListener);
            View inflate = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
            this.mRootView = inflate;
            this.u = inflate.findViewById(R.id.banner_top_divider);
            View findViewById = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
            this.mFrsMultiDelAdMaskView = findViewById;
            findViewById.setClickable(true);
            this.mAdTitle = (TextView) this.mRootView.findViewById(R.id.ad_title);
            this.mTransformBtn = (TextView) this.mRootView.findViewById(R.id.transform_btn);
            this.mAdvertAppDownloadView = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
            this.mAdvertName = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
            this.mBottomTransformArea = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
            this.mAdvertAppDownloadView.enableDownloadListener(this.mContext.getUniqueId());
            this.mUpdateDownloadBtnListener.setTag(this.mContext.getUniqueId());
            this.mCardAdMiddleContainer = this.mRootView.findViewById(R.id.card_ad_middle_container);
            this.mDeleteBtnListener.setTag(this.mContext.getUniqueId());
            AdThreadCommentAndPraiseInfoLayout adThreadCommentAndPraiseInfoLayout = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
            this.p = adThreadCommentAndPraiseInfoLayout;
            adThreadCommentAndPraiseInfoLayout.setStyle(1);
            this.mThreadUserInfoLayout = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
            this.t = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
            this.n = linearLayout;
            AdCloseView adCloseView = (AdCloseView) linearLayout.findViewById(R.id.ad_close_view);
            this.m = adCloseView;
            ViewGroup.LayoutParams layoutParams = adCloseView.mCloseImage.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.m.mCloseImage.getLayoutParams();
            int f2 = l.f(getContext(), R.dimen.tbds62);
            layoutParams2.width = f2;
            layoutParams.height = f2;
            TextView textView = (TextView) this.n.findViewById(R.id.feed_tag);
            this.mAdTag = textView;
            textView.setVisibility(8);
            this.mThreadUserInfoLayout.addAdTagView(this.n);
            ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
            this.mCustomViewStub = viewStub;
            viewStub.setLayoutResource(getCustomLayout());
            this.mCustomRoot = this.mCustomViewStub.inflate();
            this.mPbBottomView = this.mRootView.findViewById(R.id.pb_bottom_view);
            this.mFrsBottomView = this.mRootView.findViewById(R.id.frs_bottom_view);
            this.v = this.mRootView.findViewById(R.id.pb_ad_bottom_divider);
            AdAppInfoView adAppInfoView = (AdAppInfoView) this.mRootView.findViewById(R.id.app_info_view);
            this.w = adAppInfoView;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(adAppInfoView);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            initCustomView(this.mCustomRoot);
            return this.mRootView;
        }
        return (View) invokeV.objValue;
    }

    public boolean isFrsPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? getBusinessType() == 1 : invokeV.booleanValue;
    }

    public boolean isHomePage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? getBusinessType() == 2 : invokeV.booleanValue;
    }

    public boolean isPbBannerAd(AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, adCard)) == null) ? isPbPage() && adCard.isPBBanner : invokeL.booleanValue;
    }

    public boolean isPbPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? getBusinessType() == 4 : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onAttachedToWindow();
            F();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onDetachedFromWindow();
            M();
        }
    }

    public final void p(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, view) == null) && view != null && view.getVisibility() == 0) {
            this.t.setVisibility(0);
            if (D(view, this.t)) {
                return;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.t.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.t.addView(view);
        }
    }

    public final void q(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, view) == null) && view != null && view.getVisibility() == 0) {
            this.t.setVisibility(8);
            if (D(view, this.mThreadUserInfoLayout)) {
                return;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.mThreadUserInfoLayout.addAdTagView(this.n);
        }
    }

    public final void r(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, adCard) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mCardAdMiddleContainer.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            this.mCardAdMiddleContainer.setPadding(0, 0, 0, 0);
            this.t.setVisibility(8);
            this.u.setVisibility(8);
            if (isPbPage()) {
                View view = this.mRootView;
                int i2 = this.f48641f;
                view.setPadding(i2, this.f48642g, i2, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mCardAdMiddleContainer.getLayoutParams();
                int k2 = (l.k(getContext()) - (this.f48643h * 2)) - (this.f48641f * 2);
                int i3 = this.HEAD_IMAGE_WIDTH;
                int i4 = this.HEAD_IMAGE_RIGHT_MARGIN;
                this.mMaxWidth = (k2 - i3) - i4;
                layoutParams2.leftMargin = i3 + i4;
                this.v.setVisibility(0);
                q(this.n);
                if (isPbBannerAd(adCard)) {
                    this.v.setVisibility(8);
                    this.mRootView.setPadding(0, 0, 0, 0);
                    View view2 = this.mCardAdMiddleContainer;
                    int i5 = this.f48641f;
                    view2.setPadding(i5, 0, i5, 0);
                    layoutParams2.leftMargin = 0;
                    this.mMaxWidth = (l.k(getContext()) - (this.f48641f * 2)) - (this.f48643h * 2);
                    layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                    this.u.setVisibility(0);
                    SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
                    p(this.n);
                    return;
                }
                return;
            }
            View view3 = this.mRootView;
            int i6 = this.ROOT_PADDING;
            view3.setPadding(i6, this.f48642g, i6, 0);
            this.mMaxWidth = (l.k(getContext()) - (this.ROOT_PADDING * 2)) - (this.ROOT_MARGIN * 2);
            if ((c.a.r0.d1.b.f().i() || c.a.r0.d1.a.h().j()) && C()) {
                this.mFrsMultiDelAdMaskView.setVisibility(0);
                SkinManager.setBackgroundColor(this.mFrsMultiDelAdMaskView, R.color.CAM_X0201);
            } else {
                this.mFrsMultiDelAdMaskView.setVisibility(8);
            }
            this.v.setVisibility(8);
        }
    }

    public final void s(AdCard adCard, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, adCard, iVar) == null) {
            if (adCard.getAgreeNum() == -1 && adCard.getShareNum() == -1 && adCard.getReplyNum() == -1) {
                this.mFrsBottomView.setVisibility(0);
                this.p.setVisibility(8);
                return;
            }
            this.mFrsBottomView.setVisibility(8);
            this.p.setVisibility(0);
            this.p.setBarNameClickEnabled(false);
            this.p.setReplyTimeVisible(false);
            this.p.setData(adCard.getThreadData());
            if (adCard.getAgreeNum() != -1) {
                this.p.setAgreeClickable(true);
                this.p.setPraiseContainerBgGray(false);
            } else {
                this.p.setAgreeClickable(false);
                this.p.setPraiseContainerBgGray(true);
            }
            if (adCard.getShareNum() != -1) {
                this.p.setShareClickable(true);
                this.p.setShareContainerBgGray(false);
            } else {
                this.p.setShareClickable(false);
                this.p.setShareContainerBgGray(true);
            }
            if (this.p.getCommentContainer() != null) {
                this.p.getCommentContainer().setOnClickListener(iVar);
            }
            this.p.setNeedAddReplyIcon(true);
            this.p.setCommentNumEnable(false);
            this.p.setCommentClickable(true);
            this.p.setReplayContainerBgGray(true);
            this.p.setOnClickListener(iVar);
            this.p.setShareData(adCard);
            this.p.setDisPraiseViewVisibility(false);
        }
    }

    public void setPicClick(View view, i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048612, this, view, iVar) == null) || view == null) {
            return;
        }
        view.setClickable(true);
        view.setOnClickListener(iVar);
    }

    public void showDownloadAppDialog(AdvertAppInfo advertAppInfo, int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) || advertAppInfo == null) {
            return;
        }
        if (!c.a.d.f.p.j.A()) {
            l.L(this.mContext.getPageActivity(), R.string.neterror);
        } else if (advertAppInfo.V4()) {
            if (TextUtils.isEmpty(str)) {
                str = this.mContext.getString(R.string.frs_network_tips);
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.mContext.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.alert_yes_button, new f(this, advertAppInfo, i2));
            aVar.setNegativeButton(R.string.cancel, new g(this));
            aVar.create(this.mContext).show();
        }
    }

    public final void t(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, advertAppInfo, adCard) == null) {
            if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
                this.m.setVisibility(0);
                this.m.setPage(getBusinessType());
                this.m.setData(advertAppInfo, adCard.closeInfo);
                l.b(this.mContext.getPageActivity(), this.n, 40, 40, 40, 120);
                this.n.setOnClickListener(new d(this));
                return;
            }
            this.m.setVisibility(8);
            this.mAdTag.setOnClickListener(null);
        }
    }

    public final void u(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, adCard) == null) {
            int i2 = (this.mMaxWidth - this.f48644i) - this.l;
            if (isPbPage()) {
                i2 -= this.f48645j + this.f48646k;
            }
            String str = adCard.recommendReason;
            if (TextUtils.isEmpty(str)) {
                str = adCard.userName;
            }
            if (!isPbPage() && c.a.q0.b.d.I()) {
                this.mAdvertName.setText("");
            } else {
                this.mAdvertName.setText(c.a.r0.h3.i0.c.a.d(str, this.mContext.getString(R.string.advert_label), i2, this.mAdvertName.getPaint()));
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, c.a.r0.w1.o.l.e
    public void updateFontSize() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && isPbPage()) {
            this.mAdTitle.setTextSize(0, TbConfig.getContentSize());
        }
    }

    public final void v(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, adCard) == null) {
            String str = adCard.threadTitle;
            if (TextUtils.isEmpty(str)) {
                this.mAdTitle.setVisibility(8);
                return;
            }
            int i2 = adCard.maxTitleLine;
            if (i2 <= 0) {
                i2 = 4;
            }
            this.mAdTitle.setMaxLines(i2);
            this.mAdTitle.setText(str);
            this.mAdTitle.setVisibility(0);
        }
    }

    public final void w(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048618, this, advertAppInfo, adCard, iVar) == null) {
            O(adCard);
            this.mTransformBtn.setVisibility(8);
            this.mAdvertAppDownloadView.setVisibility(0);
            this.mAdvertAppDownloadView.setClickable(true);
            this.mAdvertAppDownloadView.setInitText(adCard.getButtonText());
            this.apkPackage = advertAppInfo.u4;
            DownloadData L = L(advertAppInfo, advertAppInfo.position);
            if (z.r(this.apkPackage)) {
                L.setStatus(8);
            } else {
                G(adCard, L);
            }
            this.mAdvertAppDownloadView.setData(L);
            K(adCard, iVar);
        }
    }

    public final void x(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048619, this, adCard, advertAppInfo) == null) || adCard.isDirectDownload()) {
            return;
        }
        String scheme = adCard.getScheme();
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            i2 = c.a.r0.v.g.e.d().h(downloadId);
        } else {
            i2 = c.a.r0.v.g.e.d().i(scheme);
        }
        if (i2 == null) {
            i2 = DownloadCacheKey.create(downloadId, advertAppInfo.t4, advertAppInfo.u4);
            c.a.r0.v.g.e.d().j(i2, null);
        }
        bindDownloadData(i2);
    }

    public final void y(@NonNull AdCard adCard, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, adCard, iVar) == null) {
            this.mAdvertAppDownloadView.setVisibility(8);
            this.w.setVisibility(8);
            this.mTransformBtn.setVisibility(0);
            this.mTransformBtn.setClickable(true);
            SkinManager.setViewTextColor(this.mTransformBtn, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.mTransformBtn, R.drawable.ad_download_progress_button_bg);
            this.mTransformBtn.setText(adCard.getButtonText());
            this.mTransformBtn.setOnClickListener(new c(this, adCard.getButtonScheme()));
        }
    }

    public final void z(AdCard adCard, AdvertAppInfo advertAppInfo, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048621, this, adCard, advertAppInfo, iVar) == null) {
            if (adCard != null && advertAppInfo != null) {
                if (advertAppInfo.V4()) {
                    this.mBottomTransformArea.setVisibility(0);
                    w(advertAppInfo, adCard, iVar);
                    x(adCard, advertAppInfo);
                    return;
                } else if (advertAppInfo.X4()) {
                    if (!isPbPage() && c.a.q0.b.d.I()) {
                        this.mBottomTransformArea.setVisibility(8);
                        return;
                    }
                    this.mBottomTransformArea.setVisibility(0);
                    y(adCard, iVar);
                    return;
                } else {
                    return;
                }
            }
            this.mBottomTransformArea.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(AdCard adCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, adCard, i2) == null) {
            this.m.onChangeSkinType();
            this.mThreadUserInfoLayout.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.p.onChangeSkinType();
            if (getBusinessType() == 1 || getBusinessType() == 2) {
                View view = this.mRootView;
                view.setBackgroundDrawable(c.a.r0.h3.i0.c.a.e(R.string.J_X06, R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50, view.getMeasuredHeight()));
            }
            c.a.q0.b.g.b.g((TextView) this.mThreadUserInfoLayout.getUserName());
            SkinManager.setViewTextColor(this.mAdTitle, R.color.CAM_X0105, 1);
            ThreadCardUtils.setAbstractStyleAb(this.mAdTitle);
            SkinManager.setViewTextColor(this.mAdvertName, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.mAdTag, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.mTransformBtn, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.mTransformBtn, R.drawable.ad_download_progress_button_bg);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0203);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
            this.mAdvertAppDownloadView.onChangeSkinType(i2);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.w);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            this.w.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, adCard) == null) {
            this.o = adCard;
            if (adCard == null) {
                return;
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            i iVar = new i(this, adCard);
            r(adCard);
            A(adCard, advertAppInfo, iVar);
            v(adCard);
            z(adCard, advertAppInfo, iVar);
            u(adCard);
            t(advertAppInfo, adCard);
            B(adCard, iVar);
            this.mRootView.setOnClickListener(iVar);
            fillCustomView(adCard);
            onChangeSkinType(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
