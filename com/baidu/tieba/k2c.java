package com.baidu.tieba;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.BDMarketingTextView;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.PersonalRecommendObserver;
import com.fun.ad.sdk.channel.model.baidu.CustomProgressButton;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class k2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements PersonalRecommendObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.fun.ad.sdk.PersonalRecommendObserver
        public void notifyStatusChanged(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                MobadsPermissionSettings.setLimitPersonalAds(!z);
            }
        }
    }

    public static View b(ExpressResponse expressResponse, m2c m2cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, expressResponse, m2cVar)) == null) {
            if (expressResponse == null) {
                return null;
            }
            try {
                expressResponse.setInteractionListener(new x3c(m2cVar));
                expressResponse.setAdDislikeListener(new l2c(m2cVar));
                expressResponse.render();
                return expressResponse.getExpressAdView();
            } catch (Exception e) {
                LogPrinter.e(e.getMessage(), new Object[0]);
                return null;
            }
        }
        return (View) invokeLL.objValue;
    }

    public static void d(View view2, int i, final NativeResponse nativeResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65539, null, view2, i, nativeResponse) == null) {
            view2.findViewById(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h2c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        NativeResponse.this.unionLogoClick();
                    }
                }
            });
        }
    }

    public static boolean f(NativeResponse nativeResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, nativeResponse)) == null) ? (nativeResponse.getAdActionType() != 2 || TextUtils.isEmpty(nativeResponse.getAppVersion()) || TextUtils.isEmpty(nativeResponse.getPublisher()) || TextUtils.isEmpty(nativeResponse.getAppPrivacyLink()) || TextUtils.isEmpty(nativeResponse.getAppPermissionLink())) ? false : true : invokeL.booleanValue;
    }

    public static View a(Context context, NativeResponse nativeResponse, q2c q2cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, nativeResponse, q2cVar)) == null) {
            CustomProgressButton customProgressButton = null;
            View inflate = LayoutInflater.from(context).inflate(R.layout.fun_baidu_ad_feed, (ViewGroup) null);
            if (nativeResponse == null) {
                return inflate;
            }
            GlideHelper.get().load(context, nativeResponse.getIconUrl(), (ImageView) inflate.findViewById(R.id.native_icon_image));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.native_main_image);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ad_feed_container);
            if (!TextUtils.isEmpty(nativeResponse.getImageUrl())) {
                GlideHelper.get().load(context, nativeResponse.getImageUrl(), imageView);
            } else if (nativeResponse.getMultiPicUrls() != null && nativeResponse.getMultiPicUrls().size() > 0) {
                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.ad_img1);
                ImageView imageView3 = (ImageView) inflate.findViewById(R.id.ad_img2);
                ImageView imageView4 = (ImageView) inflate.findViewById(R.id.ad_img3);
                imageView.setVisibility(8);
                linearLayout.setVisibility(0);
                List<String> multiPicUrls = nativeResponse.getMultiPicUrls();
                if (multiPicUrls.size() < 2) {
                    inflate.findViewById(R.id.ad_img1).setVisibility(0);
                    GlideHelper.get().load(context, multiPicUrls.get(0), imageView2);
                } else {
                    int size = multiPicUrls.size();
                    imageView2.setVisibility(0);
                    imageView3.setVisibility(0);
                    if (size < 3) {
                        GlideHelper.get().load(context, multiPicUrls.get(0), imageView2);
                        GlideHelper.get().load(context, multiPicUrls.get(1), imageView3);
                    } else {
                        imageView4.setVisibility(0);
                        GlideHelper.get().load(context, multiPicUrls.get(0), imageView2);
                        GlideHelper.get().load(context, multiPicUrls.get(1), imageView3);
                        GlideHelper.get().load(context, multiPicUrls.get(2), imageView4);
                    }
                }
            }
            ((TextView) inflate.findViewById(R.id.native_text)).setText(nativeResponse.getDesc());
            GlideHelper.get().load(context, nativeResponse.getMarketingPendant(), (ImageView) inflate.findViewById(R.id.native_marketing_pendant));
            BDMarketingTextView bDMarketingTextView = (BDMarketingTextView) inflate.findViewById(R.id.native_title);
            bDMarketingTextView.setLabelFontSizeSp(13);
            bDMarketingTextView.setEllipsize(TextUtils.TruncateAt.END);
            bDMarketingTextView.setAdData(nativeResponse, nativeResponse.getTitle());
            if (f(nativeResponse)) {
                ((TextView) inflate.findViewById(R.id.app_name)).setText(nativeResponse.getBrandName());
                customProgressButton = c(inflate, nativeResponse);
                inflate.findViewById(R.id.native_brand_name).setVisibility(8);
            } else {
                TextView textView = (TextView) inflate.findViewById(R.id.native_brand_name);
                textView.setText(nativeResponse.getBrandName());
                inflate.findViewById(R.id.app_download_container).setVisibility(8);
                textView.setVisibility(0);
            }
            GlideHelper.get().load(context, nativeResponse.getAdLogoUrl(), (ImageView) inflate.findViewById(R.id.native_adlogo));
            d(inflate, R.id.native_adlogo, nativeResponse);
            GlideHelper.get().load(context, nativeResponse.getBaiduLogoUrl(), (ImageView) inflate.findViewById(R.id.native_baidulogo));
            d(inflate, R.id.native_baidulogo, nativeResponse);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(inflate);
            if (customProgressButton != null) {
                arrayList2.add(customProgressButton);
            }
            nativeResponse.registerViewForInteraction(inflate, arrayList, arrayList2, new o2c(q2cVar, customProgressButton, nativeResponse));
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    public static CustomProgressButton c(View view2, final NativeResponse nativeResponse) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, view2, nativeResponse)) == null) {
            ((RelativeLayout) view2.findViewById(R.id.app_download_container)).setVisibility(0);
            ((TextView) view2.findViewById(R.id.native_version)).setText("版本 " + nativeResponse.getAppVersion());
            ((TextView) view2.findViewById(R.id.native_publisher)).setText(nativeResponse.getPublisher());
            view2.findViewById(R.id.native_privacy).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.j2c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        NativeResponse.this.privacyClick();
                    }
                }
            });
            view2.findViewById(R.id.native_permission).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.i2c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        NativeResponse.this.permissionClick();
                    }
                }
            });
            CustomProgressButton customProgressButton = (CustomProgressButton) view2.findViewById(R.id.native_download_button);
            Context context = view2.getContext();
            customProgressButton.o = nativeResponse;
            customProgressButton.a(nativeResponse);
            customProgressButton.setTextColor(Color.parseColor("#FFFFFF"));
            customProgressButton.setTextSize((int) ((context.getResources().getDisplayMetrics().scaledDensity * 12.0f) + 0.5f));
            customProgressButton.setTypeFace(Typeface.create(Typeface.MONOSPACE, 3));
            customProgressButton.setForegroundColor(Color.parseColor("#3388FF"));
            customProgressButton.setBackgroundColor(Color.parseColor("#D7E6FF"));
            return customProgressButton;
        }
        return (CustomProgressButton) invokeLL.objValue;
    }
}
