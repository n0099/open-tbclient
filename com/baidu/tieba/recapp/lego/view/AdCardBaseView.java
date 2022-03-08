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
import c.a.d.f.p.n;
import c.a.q0.r.t.a;
import c.a.r0.j3.a0;
import c.a.r0.j3.q;
import c.a.r0.v.g.g.b;
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
/* loaded from: classes6.dex */
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
    public final int f46108f;

    /* renamed from: g  reason: collision with root package name */
    public final int f46109g;

    /* renamed from: h  reason: collision with root package name */
    public final int f46110h;

    /* renamed from: i  reason: collision with root package name */
    public final int f46111i;

    /* renamed from: j  reason: collision with root package name */
    public final int f46112j;
    public final int k;
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
    public AdLottieButtonView x;

    /* loaded from: classes6.dex */
    public class a implements AdThreadUserInfoLayout.AfterAdjustChildWidthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f46113b;

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
            this.f46113b = adCardBaseView;
            this.a = adCard;
        }

        @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
        public void afterChildWidth() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((TextView) this.f46113b.mThreadUserInfoLayout.getUserName()).setText(this.a.userName);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f46114e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f46115f;

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
            this.f46115f = adCardBaseView;
            this.f46114e = advertAppInfo;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            AdvertAppInfo advertAppInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.q0.s.c.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.e() || (advertAppInfo = this.f46114e) == null) {
                    return false;
                }
                c.a.d.f.p.c.a(advertAppInfo.U4());
                ((Vibrator) this.f46115f.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f46117f;

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
            this.f46117f = adCardBaseView;
            this.f46116e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f46117f.o != null) {
                    str = this.f46117f.o.getDownloadId();
                    str2 = this.f46117f.o.getExtInfo();
                    str3 = this.f46117f.o.cmdScheme;
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                int e2 = a0.e(this.f46117f.mContext, this.f46116e, str, str2, str3);
                if (this.f46117f.afterClickSchemeListener != null) {
                    this.f46117f.afterClickSchemeListener.a(e2, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f46118e;

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
            this.f46118e = adCardBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f46118e.m.performClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f46119b;

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
            this.f46119b = adCardBaseView;
            this.a = str;
        }

        @Override // c.a.r0.v.g.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.r0.v.a.a(this.a);
                this.f46119b.afterClick();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f46120e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46121f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f46122g;

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
            this.f46122g = adCardBaseView;
            this.f46120e = advertAppInfo;
            this.f46121f = i2;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                AdCardBaseView adCardBaseView = this.f46122g;
                adCardBaseView.downloadApp(this.f46120e, this.f46121f, adCardBaseView.mAdvertAppDownloadView);
                AdCardBaseView adCardBaseView2 = this.f46122g;
                ApkDownloadView apkDownloadView = adCardBaseView2.mAdvertAppDownloadView;
                if (apkDownloadView != null) {
                    apkDownloadView.updata(adCardBaseView2.K(this.f46120e, this.f46121f));
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f46123e;

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
            this.f46123e = adCardBaseView;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f46124b;

        public h(AdCardBaseView adCardBaseView, AdCard adCard) {
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
            this.f46124b = adCardBaseView;
            this.a = adCard;
        }

        @Override // c.a.r0.j3.q
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean C = a0.C(this.a.getAdvertAppInfo(), this.a.downloadInfo.a);
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("da_area", "try_button");
                this.f46124b.afterClickSchemeListener.a(1, hashMap);
                return C;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AdCardBaseView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(int i2, AdCardBaseView adCardBaseView) {
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
            int p = c.a.r0.j3.g0.e.p(downloadData);
            if (p == 7) {
                adCardBaseView.mTransformBtn.setText(R.string.pause_load);
            } else if (p == 1 || p == 2) {
                adCardBaseView.mTransformBtn.setText(R.string.pb_download_pause);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public AdCard f46125e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdCardBaseView f46126f;

        public j(AdCardBaseView adCardBaseView, AdCard adCard) {
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
            this.f46126f = adCardBaseView;
            this.f46125e = adCard;
        }

        public final void a(AdvertAppInfo advertAppInfo, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, advertAppInfo, z) == null) {
                if (!this.f46125e.isDirectDownload() && !z) {
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
                int status = ApkDownloadView.getStatus(this.f46126f.K(advertAppInfo, i2));
                if ((6 == status || 7 == status) && l.z() && !l.H()) {
                    this.f46126f.showDownloadAppDialog(advertAppInfo, i2, true, "");
                    return;
                }
                AdCardBaseView adCardBaseView = this.f46126f;
                adCardBaseView.handleAdvertAppClick(advertAppInfo, i2, adCardBaseView.mAdvertAppDownloadView, z);
                this.f46126f.afterClick();
            }
        }

        public final void c(AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo) == null) {
                String extInfo = this.f46126f.o.getExtInfo();
                int e2 = a0.e(this.f46126f.mContext, this.f46126f.o.scheme, this.f46126f.o.getDownloadId(), extInfo, this.f46126f.o.cmdScheme);
                if (this.f46126f.afterClickSchemeListener != null) {
                    this.f46126f.afterClickSchemeListener.a(e2, null);
                }
            }
        }

        public final void d(AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, advertAppInfo) == null) {
                String str = this.f46126f.o.scheme;
                int e2 = !a0.C(advertAppInfo, str) ? a0.e(this.f46126f.mContext, str, this.f46126f.o.getDownloadId(), this.f46126f.o.getExtInfo(), this.f46126f.o.cmdScheme) : 3;
                if (this.f46126f.afterClickSchemeListener != null) {
                    this.f46126f.afterClickSchemeListener.a(e2, null);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
                if (!l.A()) {
                    this.f46126f.mContext.showToast(R.string.neterror);
                } else if (this.f46125e == null || view == null || view.getId() == R.id.thread_info_commont_container) {
                } else {
                    AdvertAppInfo advertAppInfo = this.f46125e.getAdvertAppInfo();
                    boolean z = view == this.f46126f.mAdvertAppDownloadView;
                    if (advertAppInfo != null && advertAppInfo.W4()) {
                        a(advertAppInfo, z);
                    } else {
                        c(advertAppInfo);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AdCardBaseView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(int i2, AdCardBaseView adCardBaseView) {
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
        this.mUpdateDownloadBtnListener = new i(2016484, this);
        this.mDeleteBtnListener = new k(2016483, this);
        Resources resources = tbPageContext.getResources();
        this.HEAD_IMAGE_WIDTH = (int) resources.getDimension(R.dimen.tbds92);
        this.HEAD_IMAGE_HEIGHT = (int) resources.getDimension(R.dimen.tbds92);
        this.HEAD_IMAGE_RIGHT_MARGIN = (int) resources.getDimension(R.dimen.M_W_X004);
        this.HEAD_IMAGE_WIDTH_PB = (int) resources.getDimension(R.dimen.tbds90);
        this.HEAD_IMAGE_HEIGHT_PB = (int) resources.getDimension(R.dimen.tbds90);
        this.HEAD_IMAGE_RIGHT_MARGIN_PB = (int) resources.getDimension(R.dimen.tbds22);
        this.ROOT_PADDING = (int) resources.getDimension(R.dimen.M_W_X005);
        this.ROOT_MARGIN = (int) resources.getDimension(R.dimen.M_W_X004);
        this.f46110h = 0;
        this.f46108f = (int) resources.getDimension(R.dimen.M_W_X007);
        this.f46109g = (int) resources.getDimension(R.dimen.M_H_X005);
        this.f46111i = (int) resources.getDimension(R.dimen.tbds208);
        this.f46112j = (int) resources.getDimension(R.dimen.tbds33);
        this.k = (int) resources.getDimension(R.dimen.tbds72);
        this.l = (int) resources.getDimension(R.dimen.tbds48);
    }

    public final void A(@NonNull AdCard adCard, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adCard, jVar) == null) {
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

    public final void B(AdCard adCard, AdvertAppInfo advertAppInfo, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adCard, advertAppInfo, jVar) == null) {
            if (adCard != null && advertAppInfo != null) {
                if (UbsABTestHelper.isNativeFlowAdsStyleABTestA() && (isHomePage() || isFrsPage())) {
                    this.mBottomTransformArea.setVisibility(8);
                } else {
                    this.mBottomTransformArea.setVisibility(0);
                }
                if (advertAppInfo.W4()) {
                    x(advertAppInfo, adCard, jVar);
                    y(adCard, advertAppInfo);
                    return;
                } else if (advertAppInfo.Y4()) {
                    A(adCard, jVar);
                    return;
                } else {
                    return;
                }
            }
            this.mBottomTransformArea.setVisibility(8);
        }
    }

    public final void C(AdCard adCard, AdvertAppInfo advertAppInfo, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adCard, advertAppInfo, jVar) == null) {
            AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
            if (advertAppInfo2 != null) {
                if (UbsABTestHelper.isNativeFlowAdsStyleABTestA()) {
                    if (isHomePage()) {
                        advertAppInfo2.D4(this.mContext.getString(R.string.advert_label));
                    } else if (isPbPage()) {
                        advertAppInfo2.D4(StringHelper.getFormatTimeForJustNow(adCard.getTime()));
                    } else if (isFrsPage()) {
                        advertAppInfo2.D4(StringHelper.getFormatTimeForJustNow(adCard.getTime()) + GlideException.IndentedAppendable.INDENT + this.mContext.getString(R.string.advert_label));
                    }
                } else {
                    advertAppInfo2.D4(StringHelper.getFormatTimeForJustNow(adCard.getTime()));
                }
            }
            this.mThreadUserInfoLayout.setShowFlag(1413);
            this.mThreadUserInfoLayout.setData(advertAppInfo2);
            ((TextView) this.mThreadUserInfoLayout.getUserName()).setText(adCard.userName);
            HomeGroupUbsUIHelper.handleHeadSegmentTitleView((TextView) this.mThreadUserInfoLayout.getUserName());
            this.mThreadUserInfoLayout.getUserName().setOnClickListener(jVar);
            this.mThreadUserInfoLayout.setAfterAdjustChildWidthListener(new a(this, adCard));
            this.mThreadUserInfoLayout.getHeaderImg().setOnLongClickListener(new b(this, advertAppInfo));
            setPicClick(this.mThreadUserInfoLayout.getHeaderImg(), jVar);
            if (isPbBannerAd(adCard)) {
                this.mThreadUserInfoLayout.setVisibility(8);
            }
        }
    }

    public final void D(AdCard adCard, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, adCard, jVar) == null) {
            this.p.setType(TbadkCoreApplication.getInst().getCardShowType());
            if (!isPbPage() && !UbsABTestHelper.isNativeFlowAdsNoInteractionABTestA()) {
                this.mPbBottomView.setVisibility(8);
                t(adCard, jVar);
                return;
            }
            this.p.setVisibility(8);
            this.p.setBarNameClickEnabled(false);
            this.p.setShareVisible(false);
            this.p.setShowPraiseNum(false);
            this.p.setCommentNumEnable(false);
            this.p.setReplyTimeVisible(false);
            this.mPbBottomView.setVisibility(0);
            this.mFrsBottomView.setVisibility(8);
        }
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBusinessType == 1 : invokeV.booleanValue;
    }

    public final boolean F(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, viewGroup)) == null) ? (view == null || view.getParent() == null || view.getParent() != viewGroup) ? false : true : invokeLL.booleanValue;
    }

    public final void G(View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view, viewGroup) == null) && view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
            viewGroup.addView(view);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.r == null || this.s == null) {
            return;
        }
        c.a.r0.v.g.e.d().j(this.r, this.s);
    }

    public final void I(AdCard adCard, DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adCard, downloadData) == null) {
            if (adCard.isDirectDownload()) {
                downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
            } else {
                downloadData.setStatus(this.mAdvertAppDownloadView.getDownloadStatus());
            }
        }
    }

    public final void J(AdCard adCard, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, adCard, jVar) == null) {
            if (adCard.isDirectDownload()) {
                this.mAdvertAppDownloadView.setOnClickListener(jVar);
                return;
            }
            this.mAdvertAppDownloadView.setOnClickInterceptListener(new e(this, adCard.getButtonCmdScheme()));
        }
    }

    public DownloadData K(AdvertAppInfo advertAppInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, advertAppInfo, i2)) == null) {
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.x4);
            downloadData.setName(advertAppInfo.t4);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(c.a.d.f.m.b.e(advertAppInfo.g4, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.r == null || this.s == null) {
            return;
        }
        c.a.r0.v.g.e.d().r(this.r, this.s);
    }

    public final void M(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adCard) == null) {
            c.a.q0.r.r.c appInfoModel = adCard.getAppInfoModel();
            RelativeLayout downloadButtonContainer = this.w.getDownloadButtonContainer();
            if (c.a.q0.r.r.c.a(appInfoModel)) {
                this.w.setVisibility(0);
                this.w.setAppInfo(appInfoModel);
                this.w.setAd(adCard.getAdvertAppInfo());
                if (F(this.mAdvertAppDownloadView, downloadButtonContainer)) {
                    return;
                }
                G(this.mAdvertAppDownloadView, downloadButtonContainer);
                return;
            }
            this.w.setVisibility(8);
            if (F(this.mAdvertAppDownloadView, this.mBottomTransformArea)) {
                return;
            }
            G(this.mAdvertAppDownloadView, this.mBottomTransformArea);
        }
    }

    public final void N(@NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, adCard) == null) {
            if (adCard.gameModel == null && this.x == null) {
                return;
            }
            AdLottieButtonView adLottieButtonView = this.x;
            if ((adLottieButtonView == null || adLottieButtonView.getParent() == null) && !z()) {
                return;
            }
            this.x.setData(adCard.gameModel);
            this.x.setClickListener(new h(this, adCard));
        }
    }

    public void afterClick() {
        c.a.r0.z1.o.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (aVar = this.afterClickSchemeListener) == null) {
            return;
        }
        aVar.a(3, null);
    }

    public void bindDownloadData(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.r = downloadCacheKey;
        L();
        this.s = null;
        AdDownloadData b2 = c.a.r0.v.g.e.d().b(downloadCacheKey);
        if (a0.r(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.o;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.o.getAdvertAppInfo().q4;
            b2.setExtInfo(this.o.getExtInfo());
            b2.setDownloadKey(this.o.getDownloadKey());
            JSONObject appJson = JsonTransHelper.toAppJson(this.o.getAdvertAppInfo().s4);
            if (appJson != null) {
                b2.setAppJson(appJson.toString());
            }
            b2.setPage(str);
            b2.setDeeplinkUrl(this.o.scheme);
            b2.setCmdScheme(this.o.cmdScheme);
            b2.setAppIcon(this.o.appInfoModel.f13195b);
            b2.setAppName(this.o.appInfoModel.f13196c);
        }
        c.a.r0.v.g.e d2 = c.a.r0.v.g.e.d();
        ApkDownloadView apkDownloadView = this.mAdvertAppDownloadView;
        c.a.r0.v.g.g.c c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.s = new c.a.r0.v.g.h.b(c2);
        if (b2.extra().getPercent() > 0) {
            c2.d(b2);
        }
        H();
        this.mAdvertAppDownloadView.onStatusChanged(b2.getCurrentState());
    }

    public void downloadApp(AdvertAppInfo advertAppInfo, int i2, ApkDownloadView apkDownloadView) {
        c.a.r0.z1.o.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048592, this, advertAppInfo, i2, apkDownloadView) == null) || advertAppInfo == null) {
            return;
        }
        if (advertAppInfo.Z4() != 0) {
            n.M(this.mContext.getPageActivity(), R.string.download_error);
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
            apkDownloadView.updata(K(advertAppInfo, i2));
        }
    }

    public abstract void fillCustomView(AdCard adCard);

    public abstract int getCustomLayout();

    public abstract int getLayout();

    public float getRatioByResString(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
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
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{advertAppInfo, Integer.valueOf(i2), apkDownloadView, Boolean.valueOf(z)}) == null) || advertAppInfo == null) {
            return;
        }
        DownloadData K = K(advertAppInfo, i2);
        int status = ApkDownloadView.getStatus(K);
        if (status != 1) {
            if (status == 3) {
                c.a.r0.j3.g0.j.d(this.mContext.getPageActivity(), advertAppInfo.y4);
                return;
            } else if (status != 5) {
                if (status == 6 || status == 7) {
                    downloadApp(advertAppInfo, i2, this.mAdvertAppDownloadView);
                    apkDownloadView.startDownload(K);
                    return;
                } else if (status != 8) {
                    return;
                } else {
                    c.a.r0.v.g.e.d().p(this.mContext.getPageActivity(), advertAppInfo.y4);
                    return;
                }
            }
        }
        if (z) {
            c.a.r0.j3.g0.j.a(advertAppInfo);
            apkDownloadView.pause(K);
        }
    }

    public abstract void initCustomView(View view);

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
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
            adCloseView.mCloseImage.getLayoutParams().height = n.f(getContext(), R.dimen.tbds76);
            this.m.mCloseImage.getLayoutParams().width = n.f(getContext(), R.dimen.tbds76);
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
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(adAppInfoView);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? getBusinessType() == 1 : invokeV.booleanValue;
    }

    public boolean isHomePage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? getBusinessType() == 2 : invokeV.booleanValue;
    }

    public boolean isPbBannerAd(AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, adCard)) == null) ? isPbPage() && adCard.isPBBanner : invokeL.booleanValue;
    }

    public boolean isPbPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? getBusinessType() == 4 : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onAttachedToWindow();
            H();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onDetachedFromWindow();
            L();
        }
    }

    public final void q(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, view) == null) && view != null && view.getVisibility() == 0) {
            this.t.setVisibility(0);
            if (F(view, this.t)) {
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

    public final void r(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, view) == null) && view != null && view.getVisibility() == 0) {
            this.t.setVisibility(8);
            if (F(view, this.mThreadUserInfoLayout)) {
                return;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.mThreadUserInfoLayout.addAdTagView(this.n);
        }
    }

    public final void s(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, adCard) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mCardAdMiddleContainer.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            this.mCardAdMiddleContainer.setPadding(0, 0, 0, 0);
            this.t.setVisibility(8);
            this.u.setVisibility(8);
            if (isPbPage()) {
                View view = this.mRootView;
                int i2 = this.f46108f;
                view.setPadding(i2, this.f46109g, i2, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mCardAdMiddleContainer.getLayoutParams();
                int k2 = (n.k(getContext()) - (this.f46110h * 2)) - (this.f46108f * 2);
                int i3 = this.HEAD_IMAGE_WIDTH;
                int i4 = this.HEAD_IMAGE_RIGHT_MARGIN;
                this.mMaxWidth = (k2 - i3) - i4;
                layoutParams2.leftMargin = i3 + i4;
                this.v.setVisibility(0);
                r(this.n);
                if (isPbBannerAd(adCard)) {
                    this.v.setVisibility(8);
                    this.mRootView.setPadding(0, 0, 0, 0);
                    View view2 = this.mCardAdMiddleContainer;
                    int i5 = this.f46108f;
                    view2.setPadding(i5, 0, i5, 0);
                    layoutParams2.leftMargin = 0;
                    this.mMaxWidth = (n.k(getContext()) - (this.f46108f * 2)) - (this.f46110h * 2);
                    layoutParams.topMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                    this.u.setVisibility(0);
                    SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
                    q(this.n);
                    return;
                }
                return;
            }
            View view3 = this.mRootView;
            int i6 = this.ROOT_PADDING;
            view3.setPadding(i6, this.f46109g, i6, 0);
            this.mMaxWidth = (n.k(getContext()) - (this.ROOT_PADDING * 2)) - (this.ROOT_MARGIN * 2);
            if ((c.a.r0.d1.b.f().i() || c.a.r0.d1.a.h().j()) && E()) {
                this.mFrsMultiDelAdMaskView.setVisibility(0);
                SkinManager.setBackgroundColor(this.mFrsMultiDelAdMaskView, R.color.CAM_X0201);
            } else {
                this.mFrsMultiDelAdMaskView.setVisibility(8);
            }
            this.v.setVisibility(8);
        }
    }

    public void setPicClick(View view, j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048614, this, view, jVar) == null) || view == null) {
            return;
        }
        view.setClickable(true);
        view.setOnClickListener(jVar);
    }

    public void showDownloadAppDialog(AdvertAppInfo advertAppInfo, int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) || advertAppInfo == null) {
            return;
        }
        if (!l.A()) {
            n.M(this.mContext.getPageActivity(), R.string.neterror);
        } else if (advertAppInfo.W4()) {
            if (TextUtils.isEmpty(str)) {
                str = this.mContext.getString(R.string.frs_network_tips);
            }
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(this.mContext.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.alert_yes_button, new f(this, advertAppInfo, i2));
            aVar.setNegativeButton(R.string.cancel, new g(this));
            aVar.create(this.mContext).show();
        }
    }

    public final void t(AdCard adCard, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, adCard, jVar) == null) {
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
                this.p.getCommentContainer().setOnClickListener(jVar);
            }
            this.p.setNeedAddReplyIcon(true);
            this.p.setCommentNumEnable(false);
            this.p.setCommentClickable(true);
            this.p.setReplayContainerBgGray(true);
            this.p.setOnClickListener(jVar);
            this.p.setShareData(adCard);
            this.p.setDisPraiseViewVisibility(false);
        }
    }

    public final void u(AdvertAppInfo advertAppInfo, AdCard adCard) {
        AdCloseInfo adCloseInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, advertAppInfo, adCard) == null) {
            if (adCard != null && (adCloseInfo = adCard.closeInfo) != null && adCloseInfo.support_close.intValue() > 0) {
                this.m.setVisibility(0);
                this.m.setPage(getBusinessType());
                this.m.setData(advertAppInfo, adCard.closeInfo);
                n.b(this.mContext.getPageActivity(), this.n, 40, 40, 40, 120);
                this.n.setOnClickListener(new d(this));
                return;
            }
            this.m.setVisibility(8);
            this.mAdTag.setOnClickListener(null);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, c.a.r0.z1.o.l.e
    public void updateFontSize() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && isPbPage()) {
            this.mAdTitle.setTextSize(0, TbConfig.getContentSize());
        }
    }

    public final void v(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, adCard) == null) {
            int i2 = (this.mMaxWidth - this.f46111i) - this.l;
            if (isPbPage()) {
                i2 -= this.f46112j + this.k;
            }
            String str = adCard.recommendReason;
            if (TextUtils.isEmpty(str)) {
                str = adCard.userName;
            }
            this.mAdvertName.setText(c.a.r0.j3.j0.c.a.d(str, this.mContext.getString(R.string.advert_label), i2, this.mAdvertName.getPaint()));
        }
    }

    public final void w(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, adCard) == null) {
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

    public final void x(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048621, this, advertAppInfo, adCard, jVar) == null) {
            M(adCard);
            this.mTransformBtn.setVisibility(8);
            this.mAdvertAppDownloadView.setVisibility(0);
            this.mAdvertAppDownloadView.setClickable(true);
            this.mAdvertAppDownloadView.setInitText(adCard.getButtonText());
            this.apkPackage = advertAppInfo.y4;
            DownloadData K = K(advertAppInfo, advertAppInfo.position);
            if (a0.r(this.apkPackage)) {
                K.setStatus(8);
            } else {
                I(adCard, K);
            }
            this.mAdvertAppDownloadView.setData(K);
            J(adCard, jVar);
        }
    }

    public final void y(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048622, this, adCard, advertAppInfo) == null) || adCard.isDirectDownload()) {
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
            i2 = DownloadCacheKey.create(downloadId, advertAppInfo.x4, advertAppInfo.y4);
            c.a.r0.v.g.e.d().j(i2, null);
        }
        bindDownloadData(i2);
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.mCustomRoot instanceof RelativeLayout) {
                AdLottieButtonView adLottieButtonView = new AdLottieButtonView(this.mContext.getPageActivity());
                this.x = adLottieButtonView;
                adLottieButtonView.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = n.f(this.mContext.getPageActivity(), R.dimen.M_H_X003);
                layoutParams.leftMargin = n.f(this.mContext.getPageActivity(), R.dimen.M_W_X004);
                View view = this.mCustomRoot;
                if (view instanceof RelativeLayout) {
                    ((RelativeLayout) view).addView(this.x, layoutParams);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(AdCard adCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048606, this, adCard, i2) == null) {
            this.m.onChangeSkinType();
            this.mThreadUserInfoLayout.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            this.p.onChangeSkinType();
            if (getBusinessType() == 1 || getBusinessType() == 2) {
                View view = this.mRootView;
                view.setBackgroundDrawable(c.a.r0.j3.j0.c.a.e(R.string.J_X06, R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50, view.getMeasuredHeight()));
            }
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor((TextView) this.mThreadUserInfoLayout.getUserName());
            SkinManager.setViewTextColor(this.mAdTitle, R.color.CAM_X0105, 1);
            ThreadCardUtils.setAbstractStyleAb(this.mAdTitle);
            SkinManager.setViewTextColor(this.mAdvertName, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.mAdTag, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.mTransformBtn, R.color.CAM_X0304, 1);
            SkinManager.setBackgroundResource(this.mTransformBtn, R.drawable.ad_download_progress_button_bg);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0203);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
            this.mAdvertAppDownloadView.onChangeSkinType(i2);
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.w);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            this.w.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, adCard) == null) {
            this.o = adCard;
            if (adCard == null) {
                return;
            }
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            j jVar = new j(this, adCard);
            s(adCard);
            C(adCard, advertAppInfo, jVar);
            w(adCard);
            B(adCard, advertAppInfo, jVar);
            v(adCard);
            u(advertAppInfo, adCard);
            D(adCard, jVar);
            N(adCard);
            this.mRootView.setOnClickListener(jVar);
            fillCustomView(adCard);
            onChangeSkinType(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
