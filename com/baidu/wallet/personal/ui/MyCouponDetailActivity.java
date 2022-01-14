package com.baidu.wallet.personal.ui;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.WalletBaseEmptyView;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.personal.b.a;
import com.baidu.wallet.personal.beans.b;
import com.baidu.wallet.personal.datamodel.CouponDetailResponse;
import com.baidu.wallet.personal.ui.view.DiscolorScrollView;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class MyCouponDetailActivity extends CouponBaseActivity implements View.OnClickListener, DiscolorScrollView.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BEAN_TAG = "MyCouponDetailActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public BdActionBar actionBar;
    public int cardType;
    public TextView copyBtn;
    public String couponNum;
    public ImageView invalidCouponImg;
    public ClipData mClipData;
    public ClipboardManager mClipboardManager;
    public RelativeLayout mCouponBgDown;
    public RelativeLayout mCouponBgUp;
    public NetImageView mCouponDetailBgpic;
    public TextView mCouponName;
    public TextView mCouponTitleDesc;
    public TextView mCouponTitleHead;
    public ImageView mDateDot;
    public TextView mDateMsg;
    public TextView mDateTips;
    public CouponDetailResponse mDetail;
    public LinearLayout mExchangeAScenceLayout;
    public TextView mMarketLabel;
    public WalletBaseEmptyView mReloadView;
    public TextView mScenceServiceView;
    public RelativeLayout mSceneServiceLayout;
    public DiscolorScrollView mScrollView;
    public TextView mSubTitile;
    public TextView mSubTitle1;
    public ImageView mTermDot;
    public ImageView mTermDot1;
    public TextView mTermTips;
    public LinearLayout mUseInfos;
    public boolean needRefresh;
    public String templateNum;

    public MyCouponDetailActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.needRefresh = false;
    }

    private void configMarketLabel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mMarketLabel.getLayoutParams();
            layoutParams.height = DisplayUtils.dip2px(this.mAct, 20.0f);
            this.mMarketLabel.setLayoutParams(layoutParams);
            int dip2px = DisplayUtils.dip2px(this.mAct, 4.0f);
            if (!TextUtils.isEmpty(this.mDetail.marketing_label)) {
                this.mMarketLabel.setText(this.mDetail.marketing_label.length() > 6 ? this.mDetail.marketing_label.substring(0, 6) : this.mDetail.marketing_label);
                this.mMarketLabel.setPadding(dip2px, 0, dip2px, 0);
                this.mMarketLabel.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.mDetail.marketing_label_bgpic)) {
                return;
            }
            ImageLoader.getInstance(this.mAct).getBitmap(this.mDetail.marketing_label_bgpic, new ImageLoader.OnGetBitmapListener(this, layoutParams) { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RelativeLayout.LayoutParams a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ MyCouponDetailActivity f52576b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, layoutParams};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52576b = this;
                    this.a = layoutParams;
                }

                @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                public boolean needCancel(String str, Object obj) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, obj)) == null) {
                        return false;
                    }
                    return invokeLL.booleanValue;
                }

                @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                public void onError(String str, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
                    }
                }

                @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                public void onGetBitmap(String str, Object obj, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, bitmap) == null) || bitmap == null) {
                        return;
                    }
                    if (TextUtils.isEmpty(this.f52576b.mDetail.marketing_label)) {
                        this.f52576b.mMarketLabel.post(new Runnable(this, bitmap) { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.5.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Bitmap a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass5 f52577b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, bitmap};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f52577b = this;
                                this.a = bitmap;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    AnonymousClass5 anonymousClass5 = this.f52577b;
                                    anonymousClass5.a.width = DisplayUtils.dip2px(anonymousClass5.f52576b.mAct, 65.0f);
                                    AnonymousClass5 anonymousClass52 = this.f52577b;
                                    anonymousClass52.a.height = DisplayUtils.dip2px(anonymousClass52.f52576b.mAct, 16.55f);
                                    this.f52577b.f52576b.mMarketLabel.setLayoutParams(this.f52577b.a);
                                    this.f52577b.f52576b.mMarketLabel.setBackgroundDrawable(new BitmapDrawable(this.a));
                                    this.f52577b.f52576b.mMarketLabel.setVisibility(0);
                                }
                            }
                        });
                        return;
                    }
                    a aVar = new a(this.f52576b.getResources(), bitmap);
                    aVar.a(bitmap.getWidth() / 2, 1).b(bitmap.getHeight() / 2, 1);
                    NinePatchDrawable c2 = aVar.c();
                    if (c2 != null) {
                        this.f52576b.mMarketLabel.post(new Runnable(this, c2) { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.5.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NinePatchDrawable a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass5 f52578b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, c2};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f52578b = this;
                                this.a = c2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f52578b.f52576b.mMarketLabel.setBackgroundDrawable(this.a);
                                    this.f52578b.f52576b.mMarketLabel.setLayoutParams(this.f52578b.a);
                                    if (this.f52578b.f52576b.mMarketLabel.getVisibility() == 8) {
                                        this.f52578b.f52576b.mMarketLabel.setVisibility(0);
                                    }
                                }
                            }
                        });
                    }
                }
            }, null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
        }
    }

    private GradientDrawable getDefaultGradientBg(int i2, int i3, GradientDrawable.Orientation orientation) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65548, this, i2, i3, orientation)) == null) {
            int[] iArr = {i2, i3};
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(0);
            if (Build.VERSION.SDK_INT >= 16) {
                gradientDrawable.setOrientation(orientation);
                gradientDrawable.setColors(iArr);
                gradientDrawable.setSize(DisplayUtils.getDisplayWidth(this.mAct), DisplayUtils.dip2px(this.mAct, 195.0f));
            }
            return gradientDrawable;
        }
        return (GradientDrawable) invokeIIL.objValue;
    }

    private int getStatus(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, this, i2)) == null) {
            switch (i2) {
                case 3:
                case 8:
                case 9:
                case 10:
                    return 1;
                case 4:
                    return 0;
                case 5:
                case 6:
                case 7:
                    return 2;
                default:
                    return -1;
            }
        }
        return invokeI.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryDetail(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, this, z) == null) {
            DXMSdkSAUtils.onEventStart("CouponDetailRequest");
            if (getActivity() == null) {
                return;
            }
            if (z) {
                WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
            }
            b bVar = (b) com.baidu.wallet.personal.beans.a.a().getBean(this.mAct, 516, BEAN_TAG);
            bVar.a(this.cardType);
            bVar.a(this.couponNum);
            bVar.b(this.templateNum);
            bVar.setResponseCallback(this);
            bVar.execBean();
        }
    }

    private void setDatas() {
        TextView textView;
        String string;
        TextView textView2;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.mScrollView.setVisibility(0);
            int a = com.baidu.wallet.personal.b.b.a(this.mAct, this.mDetail.coupon_detail_btn_bg, "coupon_base_black_394259");
            if (TextUtils.isEmpty(this.mDetail.coupon_detail_btn_bg)) {
                updateTitleBarColor(false);
            } else {
                updateTitleBarColor(true);
            }
            setDetailBgDefault();
            if (!TextUtils.isEmpty(this.mDetail.coupon_detail_bgpic)) {
                ImageLoader.getInstance(this.mAct).getBitmap(this.mDetail.coupon_detail_bgpic, new ImageLoader.OnGetBitmapListener(this) { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MyCouponDetailActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                    public boolean needCancel(String str, Object obj) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, obj)) == null) {
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }

                    @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                    public void onError(String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
                        }
                    }

                    @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                    public void onGetBitmap(String str, Object obj, Bitmap bitmap) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, bitmap) == null) || bitmap == null) {
                            return;
                        }
                        this.a.mCouponDetailBgpic.post(new Runnable(this, bitmap) { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Bitmap a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f52573b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, bitmap};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f52573b = this;
                                this.a = bitmap;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f52573b.a.mCouponDetailBgpic.setImageDrawable(new BitmapDrawable(this.a));
                                }
                            }
                        });
                    }
                }, null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCouponName.getLayoutParams();
            layoutParams.topMargin = DisplayUtils.dip2px(this.mAct, 37.0f);
            this.mCouponName.setLayoutParams(layoutParams);
            if (TextUtils.isEmpty(this.mDetail.coupon_name)) {
                textView = this.mCouponName;
                string = ResUtils.getString(this.mAct, "wallet_personal_coupon_logo_title");
            } else {
                textView = this.mCouponName;
                string = this.mDetail.coupon_name;
            }
            textView.setText(string);
            if (Build.VERSION.SDK_INT >= 16) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mCouponBgUp.getLayoutParams();
                layoutParams2.topMargin = DisplayUtils.dip2px(this.mAct, 77.0f);
                layoutParams2.height = DisplayUtils.dip2px(this.mAct, 100.5f);
                this.mCouponBgUp.setLayoutParams(layoutParams2);
            }
            if (!TextUtils.isEmpty(this.mDetail.coupon_detail_bgpic_up)) {
                ImageLoader.getInstance(this.mAct).getBitmap(this.mDetail.coupon_detail_bgpic_up, new ImageLoader.OnGetBitmapListener(this) { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MyCouponDetailActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                    public boolean needCancel(String str, Object obj) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, obj)) == null) {
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }

                    @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                    public void onError(String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
                        }
                    }

                    @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                    public void onGetBitmap(String str, Object obj, Bitmap bitmap) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, bitmap) == null) || bitmap == null) {
                            return;
                        }
                        this.a.mCouponBgUp.post(new Runnable(this, bitmap) { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Bitmap a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f52574b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, bitmap};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f52574b = this;
                                this.a = bitmap;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f52574b.a.mCouponBgUp.setBackgroundDrawable(new BitmapDrawable(this.f52574b.a.getResources(), this.a));
                                }
                            }
                        });
                    }
                }, null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
            }
            if (!TextUtils.isEmpty(this.mDetail.coupon_detail_bgpic_down)) {
                ImageLoader.getInstance(this.mAct).getBitmap(this.mDetail.coupon_detail_bgpic_down, new ImageLoader.OnGetBitmapListener(this) { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MyCouponDetailActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                    public boolean needCancel(String str, Object obj) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, obj)) == null) {
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }

                    @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                    public void onError(String str, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
                        }
                    }

                    @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                    public void onGetBitmap(String str, Object obj, Bitmap bitmap) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, bitmap) == null) || bitmap == null) {
                            return;
                        }
                        a aVar = new a(this.a.getResources(), bitmap);
                        aVar.b(13, 1);
                        this.a.mCouponBgDown.post(new Runnable(this, aVar.c()) { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NinePatchDrawable a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f52575b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r7};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f52575b = this;
                                this.a = r7;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (Build.VERSION.SDK_INT >= 16) {
                                        this.f52575b.a.mCouponBgDown.setBackground(this.a);
                                    } else {
                                        this.f52575b.a.mCouponBgDown.setBackgroundDrawable(this.a);
                                    }
                                }
                            }
                        });
                    }
                }, null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
            }
            configMarketLabel();
            if (TextUtils.isEmpty(this.mDetail.coupon_title_head)) {
                this.mCouponTitleHead.setVisibility(8);
            } else {
                this.mCouponTitleHead.setText(this.mDetail.coupon_title_head);
                this.mCouponTitleHead.setVisibility(0);
                this.mCouponTitleHead.setTextColor(com.baidu.wallet.personal.b.b.a(this.mAct, this.mDetail.coupon_list_show_formwork));
            }
            if (TextUtils.isEmpty(this.mDetail.coupon_title_desc)) {
                this.mCouponTitleDesc.setVisibility(8);
            } else {
                this.mCouponTitleDesc.setText(this.mDetail.coupon_title_desc);
                this.mCouponTitleDesc.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.mDetail.date_message)) {
                this.mDateTips.setVisibility(8);
                this.mDateDot.setVisibility(8);
                this.mDateMsg.setVisibility(8);
            } else {
                Drawable[] compoundDrawables = this.mDateTips.getCompoundDrawables();
                if (!TextUtils.isEmpty(this.mDetail.coupon_detail_btn_bg)) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.mDateDot.getDrawable().setTint(a);
                        if (compoundDrawables != null && compoundDrawables[0] != null) {
                            compoundDrawables[0].setTint(a);
                        }
                    }
                    this.mDateTips.setTextColor(a);
                }
                this.mDateTips.setVisibility(0);
                this.mDateDot.setVisibility(0);
                this.mDateMsg.setText(this.mDetail.date_message);
            }
            if (TextUtils.isEmpty(this.mDetail.sub_title)) {
                this.mTermTips.setVisibility(8);
                this.mTermDot.setVisibility(8);
                this.mSubTitile.setVisibility(8);
            } else {
                Drawable[] compoundDrawables2 = this.mTermTips.getCompoundDrawables();
                if (!TextUtils.isEmpty(this.mDetail.coupon_detail_btn_bg)) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.mTermDot.getDrawable().setTint(a);
                        if (compoundDrawables2 != null && compoundDrawables2[0] != null) {
                            compoundDrawables2[0].setTint(a);
                        }
                    }
                    this.mTermTips.setTextColor(a);
                }
                this.mTermTips.setVisibility(0);
                this.mTermDot.setVisibility(0);
                this.mSubTitile.setVisibility(0);
                this.mSubTitile.setText(this.mDetail.sub_title);
            }
            if (TextUtils.isEmpty(this.mDetail.sub_title2)) {
                this.mTermDot1.setVisibility(8);
                this.mSubTitle1.setVisibility(8);
            } else {
                if (!TextUtils.isEmpty(this.mDetail.coupon_detail_btn_bg) && Build.VERSION.SDK_INT >= 21) {
                    this.mTermDot1.getDrawable().setTint(a);
                }
                this.mTermDot1.setVisibility(0);
                this.mSubTitle1.setText(this.mDetail.sub_title2);
                this.mSubTitle1.setVisibility(0);
            }
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "coupon_detail_exchange"));
            if (TextUtils.isEmpty(this.mDetail.display_coupon_num)) {
                relativeLayout.setVisibility(8);
            } else {
                relativeLayout.setVisibility(0);
                ((TextView) findViewById(ResUtils.id(this.mAct, "other_coupon_detail_scene_service_label"))).setText(this.mDetail.display_coupon_num);
                TextView textView3 = (TextView) findViewById(ResUtils.id(this.mAct, "other_coupon_detail_btn_copy"));
                this.copyBtn = textView3;
                if (this.mDetail.status != 2) {
                    textView3.setTextColor(ResUtils.getColor(this.mAct, "wallet_invalid_coupon_detail_D7D7D7"));
                    this.copyBtn.setClickable(false);
                } else {
                    textView3.setOnClickListener(this);
                }
            }
            this.mSceneServiceLayout = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "coupon_detail_btn"));
            this.mScenceServiceView = (TextView) findViewById(ResUtils.id(this.mAct, "coupon_detail_scene_service_label1"));
            if (TextUtils.isEmpty(this.mDetail.scene_service) && this.mDetail.app_scene_service == null) {
                this.mSceneServiceLayout.setVisibility(8);
            } else {
                this.mSceneServiceLayout.setVisibility(0);
                if (Build.VERSION.SDK_INT >= 21) {
                    RelativeLayout relativeLayout2 = this.mSceneServiceLayout;
                    BeanActivity beanActivity = this.mAct;
                    relativeLayout2.setBackground(com.baidu.wallet.personal.b.b.a(beanActivity, a, 0, DisplayUtils.dip2px(beanActivity, 100.0f)));
                }
                if (TextUtils.isEmpty(this.mDetail.scene_service_label)) {
                    textView2 = this.mScenceServiceView;
                    string2 = ResUtils.getString(this.mAct, "wallet_personal_coupon_detail_btn_txt");
                } else {
                    textView2 = this.mScenceServiceView;
                    string2 = this.mDetail.scene_service_label;
                }
                textView2.setText(string2);
                this.mScenceServiceView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MyCouponDetailActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BaiduWalletDelegate baiduWalletDelegate;
                        BeanActivity beanActivity2;
                        String str;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || CheckUtils.isFastDoubleClick()) {
                            return;
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("coupon_name", this.a.mDetail.coupon_name);
                            jSONObject.put("template_num", this.a.mDetail.template_num);
                            jSONObject.put("coupon_num", this.a.mDetail.coupon_num);
                            jSONObject.put("card_type", this.a.cardType);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        DXMSdkSAUtils.onEventWithValues("CouponDetailToUseBtnClick", Arrays.asList(jSONObject.toString()));
                        if (this.a.mDetail.app_scene_service != null) {
                            if (this.a.mDetail.app_scene_service.f52563android > 0) {
                                this.a.needRefresh = true;
                                BaiduWalletServiceController baiduWalletServiceController = BaiduWalletServiceController.getInstance();
                                MyCouponDetailActivity myCouponDetailActivity = this.a;
                                baiduWalletServiceController.gotoWalletService(myCouponDetailActivity.mAct, myCouponDetailActivity.mDetail.app_scene_service.f52563android, "");
                                return;
                            } else if (TextUtils.isEmpty(this.a.mDetail.app_scene_service.url)) {
                                return;
                            } else {
                                this.a.needRefresh = true;
                                baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                                MyCouponDetailActivity myCouponDetailActivity2 = this.a;
                                beanActivity2 = myCouponDetailActivity2.mAct;
                                str = myCouponDetailActivity2.mDetail.app_scene_service.url;
                            }
                        } else if (TextUtils.isEmpty(this.a.mDetail.scene_service)) {
                            return;
                        } else {
                            this.a.needRefresh = true;
                            baiduWalletDelegate = BaiduWalletDelegate.getInstance();
                            MyCouponDetailActivity myCouponDetailActivity3 = this.a;
                            beanActivity2 = myCouponDetailActivity3.mAct;
                            str = myCouponDetailActivity3.mDetail.scene_service;
                        }
                        baiduWalletDelegate.openH5Module(beanActivity2, str, true);
                    }
                });
            }
            if (relativeLayout.getVisibility() == 0 || this.mSceneServiceLayout.getVisibility() == 0) {
                this.mExchangeAScenceLayout.setVisibility(0);
            }
            this.invalidCouponImg = (ImageView) findViewById(ResUtils.id(this.mAct, "coupocoupon_use_imgn_use_img"));
            setStatusImage(getStatus(this.mDetail.status));
            showDetails();
            showDxmLogo();
        }
    }

    private void setDetailBgDefault() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (!TextUtils.isEmpty(this.mDetail.coupon_detail_btn_bg) && Build.VERSION.SDK_INT >= 16) {
                this.mCouponDetailBgpic.setImageDrawable(getDefaultGradientBg(com.baidu.wallet.personal.b.b.a(this.mAct, this.mDetail.coupon_detail_btn_bg, "coupon_base_black_394259"), ResUtils.getColor(this.mAct, "coupon_base_white_f7f8fa"), GradientDrawable.Orientation.TOP_BOTTOM));
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCouponDetailBgpic.getLayoutParams();
            layoutParams.height = DisplayUtils.dip2px(this.mAct, 195.0f);
            this.mCouponDetailBgpic.setLayoutParams(layoutParams);
        }
    }

    private void setStatusImage(int i2) {
        ImageView imageView;
        BeanActivity beanActivity;
        String str;
        ImageView imageView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65553, this, i2) == null) {
            int i3 = 0;
            if (i2 != 0) {
                if (i2 == 1) {
                    imageView = this.invalidCouponImg;
                    beanActivity = this.mAct;
                    str = "wallet_personal_coupon_used";
                    imageView.setImageDrawable(ResUtils.getDrawable(beanActivity, str));
                    imageView2 = this.invalidCouponImg;
                    imageView2.setVisibility(i3);
                } else if (i2 != 2) {
                    imageView2 = this.invalidCouponImg;
                    i3 = 8;
                    imageView2.setVisibility(i3);
                }
            }
            imageView = this.invalidCouponImg;
            beanActivity = this.mAct;
            str = "wallet_personal_coupon_expired";
            imageView.setImageDrawable(ResUtils.getDrawable(beanActivity, str));
            imageView2 = this.invalidCouponImg;
            imageView2.setVisibility(i3);
        }
    }

    private void showDetails() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65554, this) != null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(this.mAct, "coupon_detail_use_limit_detail"));
        this.mUseInfos = linearLayout;
        linearLayout.removeAllViews();
        CouponDetailResponse couponDetailResponse = this.mDetail;
        if (couponDetailResponse == null || couponDetailResponse.detail.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            CouponDetailResponse.Detail[] detailArr = this.mDetail.detail;
            if (i2 >= detailArr.length) {
                return;
            }
            CouponDetailResponse.Detail detail = detailArr[i2];
            if (detail != null && !TextUtils.isEmpty(detail.name) && !TextUtils.isEmpty(detail.value)) {
                BeanActivity beanActivity = this.mAct;
                View inflate = View.inflate(beanActivity, ResUtils.layout(beanActivity, "wallet_personal_coupon_detail_use_info_layout"), null);
                if (i2 == 0) {
                    inflate.findViewById(ResUtils.id(this.mAct, "use_info_margin")).setVisibility(8);
                }
                TextView textView = (TextView) inflate.findViewById(ResUtils.id(this.mAct, "detail_name"));
                if (textView != null) {
                    textView.setText(detail.name);
                }
                TextView textView2 = (TextView) inflate.findViewById(ResUtils.id(this.mAct, "detail_infos"));
                if (textView2 != null) {
                    textView2.setText(Html.fromHtml(detail.value));
                }
                this.mUseInfos.addView(inflate);
            }
            i2++;
        }
    }

    private void showDxmLogo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            ImageView imageView = (ImageView) findViewById(ResUtils.id(this.mAct, "detail_dxm_logo"));
            imageView.post(new Runnable(this, imageView) { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageView a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ MyCouponDetailActivity f52579b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, imageView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52579b = this;
                    this.a = imageView;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int dip2px = DisplayUtils.dip2px(this.f52579b.mAct, 30.0f);
                        DisplayUtils.getDisplayHeight(this.f52579b.mAct);
                        int height = this.a.getHeight();
                        int dip2px2 = DisplayUtils.dip2px(this.f52579b.mAct, 60.0f);
                        int height2 = this.f52579b.mScrollView.getHeight();
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
                        layoutParams.topMargin = ((height2 - this.f52579b.mUseInfos.getBottom()) - dip2px) - height > dip2px2 ? (height2 - height) - dip2px : this.f52579b.mUseInfos.getBottom() + dip2px2;
                        layoutParams.bottomMargin = dip2px;
                        this.a.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void showEmptyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.mReloadView.setVisibility(0);
            this.mReloadView.showTip1_Tip2_NextBtn(ResUtils.drawable(this.mAct, "wallet_base_no_net"), ResUtils.getString(this.mAct, "wallet_base_no_network"), ResUtils.getString(this.mAct, "wallet_base_no_network_reason"), ResUtils.getString(getActivity(), "bd_wallet_reload"), new WalletBaseEmptyView.EmptyBtnClickListener(this) { // from class: com.baidu.wallet.personal.ui.MyCouponDetailActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MyCouponDetailActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
                public void onBtnClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.queryDetail(true);
                    }
                }
            });
        }
    }

    private void updateTitleBarColor(boolean z) {
        BdActionBar bdActionBar;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, this, z) == null) {
            try {
                if (z) {
                    this.actionBar.setTitlebgColor(Color.parseColor(this.mDetail.coupon_detail_btn_bg));
                    this.actionBar.setTitleColor(-1);
                    bdActionBar = this.actionBar;
                    drawable = ResUtils.getDrawable(this.mAct, "wallet_base_actionbar_white_back_arrow");
                } else {
                    this.actionBar.setTitlebgColor(-1);
                    this.actionBar.setTitleColor(ResUtils.getColor(this.mAct, "bd_wallet_black3"));
                    bdActionBar = this.actionBar;
                    drawable = ResUtils.getDrawable(this.mAct, "wallet_base_actionbar_back_arrow");
                }
                bdActionBar.setLeftZoneImageSrc(drawable);
            } catch (Exception unused) {
                this.actionBar.setTitlebgColor(-1);
                this.actionBar.setTitleColor(ResUtils.getColor(this.mAct, "bd_wallet_black3"));
                this.actionBar.setLeftZoneImageSrc(ResUtils.getDrawable(this.mAct, "wallet_base_actionbar_back_arrow"));
            }
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            DXMSdkSAUtils.onEventEnd("CouponDetailRequest", 1);
            BeanActivity beanActivity = this.mAct;
            if (beanActivity == null) {
                return;
            }
            WalletGlobalUtils.safeDismissDialog(beanActivity, -1);
            if (i3 != 5003) {
                showEmptyView();
                return;
            }
            LogUtil.d(BEAN_TAG, "没有登陆");
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_base_please_login"));
            WalletLoginHelper.getInstance().logout(false);
            finish();
        }
    }

    @Override // com.baidu.wallet.personal.ui.CouponBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
            DXMSdkSAUtils.onEventEnd("CouponDetailRequest", 0);
            BeanActivity beanActivity = this.mAct;
            if (beanActivity == null) {
                return;
            }
            WalletGlobalUtils.safeDismissDialog(beanActivity, -1);
            if (i2 == 516) {
                this.mReloadView.setVisibility(8);
                CouponDetailResponse couponDetailResponse = (CouponDetailResponse) obj;
                this.mDetail = couponDetailResponse;
                if (couponDetailResponse != null) {
                    initView();
                    setDatas();
                    return;
                }
                GlobalUtils.toast(this.mAct, ResUtils.getString(this.mAct, "bd_wallet_coupon_detail_fail"));
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            DiscolorScrollView discolorScrollView = (DiscolorScrollView) findViewById(ResUtils.id(this.mAct, "coupon_detail_scroolview"));
            this.mScrollView = discolorScrollView;
            discolorScrollView.setScrollViewListener(this);
            this.mCouponName = (TextView) findViewById(ResUtils.id(this.mAct, "coupon_name"));
            this.mCouponDetailBgpic = (NetImageView) findViewById(ResUtils.id(this.mAct, "coupon_detail_bgpic"));
            this.mCouponBgUp = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "coupon_detail_bgpic_up"));
            this.mMarketLabel = (TextView) findViewById(ResUtils.id(this.mAct, "detail_marketing_label"));
            this.mCouponTitleHead = (TextView) findViewById(ResUtils.id(this.mAct, "detail_coupon_title_head"));
            this.mCouponTitleDesc = (TextView) findViewById(ResUtils.id(this.mAct, "detail_coupon_title_desc"));
            this.mCouponBgDown = (RelativeLayout) findViewById(ResUtils.id(this.mAct, "coupon_detail_bgpic_down"));
            this.mDateMsg = (TextView) findViewById(ResUtils.id(this.mAct, "detail_date_message"));
            this.mDateTips = (TextView) findViewById(ResUtils.id(this.mAct, "date_tip_title"));
            this.mDateDot = (ImageView) findViewById(ResUtils.id(this.mAct, "date_tip_dot"));
            this.mTermTips = (TextView) findViewById(ResUtils.id(this.mAct, "sub_title_tip_title"));
            this.mTermDot = (ImageView) findViewById(ResUtils.id(this.mAct, "sub_title_tip_dot"));
            this.mSubTitile = (TextView) findViewById(ResUtils.id(this.mAct, "sub_title"));
            this.mTermDot1 = (ImageView) findViewById(ResUtils.id(this.mAct, "sub_title_tip_dot2"));
            this.mSubTitle1 = (TextView) findViewById(ResUtils.id(this.mAct, "sub_title2"));
            this.mExchangeAScenceLayout = (LinearLayout) findViewById(ResUtils.id(this.mAct, "exchange_and_scence_layout"));
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            finish();
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view == this.copyBtn && Build.VERSION.SDK_INT >= 11) {
            this.mClipboardManager = (ClipboardManager) getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            ClipData newPlainText = ClipData.newPlainText(ResUtils.getString(this.mAct, "wallet_personal_coupon_detail_copy_lable"), this.mDetail.display_coupon_num);
            this.mClipData = newPlainText;
            this.mClipboardManager.setPrimaryClip(newPlainText);
            BeanActivity beanActivity = this.mAct;
            GlobalUtils.toast(beanActivity, ResUtils.getString(beanActivity, "wallet_personal_coupon_detail_copy_success"));
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(ResUtils.layout(this.mAct, "wallet_personal_coupon_detail1"));
            Intent intent = getIntent();
            if (intent != null) {
                this.cardType = intent.getIntExtra("cardType", 0);
                this.couponNum = intent.getStringExtra("couponNum");
                this.templateNum = intent.getStringExtra("templateNum");
            }
            initActionBar("bd_wallet_coupon_detail");
            BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(this.mAct, "bdactionbar"));
            this.actionBar = bdActionBar;
            bdActionBar.setBottomSeperatorvisible(false);
            this.mReloadView = (WalletBaseEmptyView) findViewById(ResUtils.id(this.mAct, "wallet_personal_reload_view"));
            queryDetail(true);
            setResult(0);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            BeanManager.getInstance().removeAllBeans(BEAN_TAG);
            super.onDestroy();
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            if (this.needRefresh) {
                queryDetail(true);
                this.needRefresh = false;
            }
        }
    }

    @Override // com.baidu.wallet.personal.ui.view.DiscolorScrollView.a
    public void onScrollChanged(DiscolorScrollView discolorScrollView, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{discolorScrollView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            BdActionBar bdActionBar = this.actionBar;
            if (i3 - (bdActionBar != null ? bdActionBar.getBottom() : 0) > DisplayUtils.dip2px(this.mAct, 30.0f)) {
                updateTitleBarColor(false);
            } else {
                updateTitleBarColor(true);
            }
        }
    }
}
