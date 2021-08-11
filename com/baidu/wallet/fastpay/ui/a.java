package com.baidu.wallet.fastpay.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter;
import com.baidu.wallet.base.widget.compromtion.CommonPromotionView;
import com.baidu.wallet.fastpay.datamodel.PromotionInfoResponse;
import com.baidu.wallet.fastpay.ui.widget.FastPayPromotionView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class a extends BasePromotionAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PromotionInfoResponse f60783a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60784b;

    public a(Context context, PromotionInfoResponse promotionInfoResponse) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, promotionInfoResponse};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60783a = promotionInfoResponse;
        this.f60784b = context;
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public CommonPromotionView createAdapterView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            PromotionInfoResponse promotionInfoResponse = this.f60783a;
            if (promotionInfoResponse == null) {
                return null;
            }
            int i2 = promotionInfoResponse.promotion_type;
            if (i2 == 1) {
                CommonPromotionView commonPromotionView = new CommonPromotionView(context);
                commonPromotionView.setCenText(getCenText()).setCenTextColor(ResUtils.getColor(this.f60784b, "wallet_fp_promtion_text"));
                return commonPromotionView;
            } else if (i2 == 2) {
                CommonPromotionView commonPromotionView2 = new CommonPromotionView(context);
                commonPromotionView2.setCenText(getCenText()).setTextClickListener(getClickListener()).setDefLeftDrawable(getDefLeftDraw(), getLeftUrl());
                PromotionInfoResponse promotionInfoResponse2 = this.f60783a;
                if (promotionInfoResponse2.link_type == 0 || TextUtils.isEmpty(promotionInfoResponse2.promotion_detail_url)) {
                    return commonPromotionView2;
                }
                commonPromotionView2.setDefRightDrawable(getDefRightDraw());
                return commonPromotionView2;
            } else if (i2 == 3) {
                CommonPromotionView commonPromotionView3 = new CommonPromotionView(context);
                a();
                commonPromotionView3.setCenText(getCenText()).setTextClickListener(getClickListener()).setDefLeftDrawable(getDefLeftDraw(), getLeftUrl());
                PromotionInfoResponse promotionInfoResponse3 = this.f60783a;
                if (promotionInfoResponse3.link_type == 0 || TextUtils.isEmpty(promotionInfoResponse3.promotion_detail_url)) {
                    return commonPromotionView3;
                }
                commonPromotionView3.setDefRightDrawable(getDefRightDraw());
                return commonPromotionView3;
            } else if (i2 != 4) {
                return null;
            } else {
                FastPayPromotionView fastPayPromotionView = new FastPayPromotionView(context);
                fastPayPromotionView.setCenText(getCenText()).setDefLeftDrawable(getDefLeftDraw(), getLeftUrl()).setClickRightImgToClose();
                PromotionInfoResponse promotionInfoResponse4 = this.f60783a;
                if (promotionInfoResponse4.link_type == 0 || TextUtils.isEmpty(promotionInfoResponse4.promotion_detail_url)) {
                    return fastPayPromotionView;
                }
                fastPayPromotionView.setDefRightDrawable(getDefRightDraw());
                return fastPayPromotionView;
            }
        }
        return (CommonPromotionView) invokeL.objValue;
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public int getBackGround() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.getBackGround() : invokeV.intValue;
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public CharSequence getCenText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60783a.promotion_txt : (CharSequence) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public View.OnClickListener getClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new View.OnClickListener(this) { // from class: com.baidu.wallet.fastpay.ui.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f60785a;

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
                this.f60785a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f60785a.f60783a.promotion_detail_url)) {
                    return;
                }
                ArrayList arrayList = new ArrayList(Arrays.asList(this.f60785a.f60783a.promotion_detail_url));
                arrayList.addAll(com.baidu.wallet.fastpay.a.a.a().b());
                DXMSdkSAUtils.onEventWithValues("mobileRechargeClickPrompt", arrayList);
                int i2 = this.f60785a.f60783a.link_type;
                if (i2 == 1) {
                    BaiduWalletDelegate.getInstance().openH5Module(this.f60785a.f60784b, this.f60785a.f60783a.promotion_detail_url, true);
                } else if (i2 != 3) {
                } else {
                    BaiduWalletDelegate.getInstance().gotoWalletService(this.f60785a.f60784b, this.f60785a.f60783a.promotion_detail_url, "");
                }
            }
        } : (View.OnClickListener) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public Drawable getDefLeftDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f60783a.promotion_type;
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return null;
                    }
                    return ResUtils.getDrawable(this.f60784b, "wallet_fp_promotion_gift");
                }
                return ResUtils.getDrawable(this.f60784b, "wallet_fp_promotion_youhui");
            }
            return ResUtils.getDrawable(this.f60784b, "wallet_fp_promoiton_left");
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public Drawable getDefRightDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f60783a.promotion_type != 4) {
                return ResUtils.getDrawable(this.f60784b, "wallet_fp_promotion_right");
            }
            return ResUtils.getDrawable(this.f60784b, "wallet_fp_promotion_close");
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public String getLeftUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f60783a.promotion_img_url : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.widget.compromtion.BasePromotionAdapter
    public String getRightUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || TextUtils.isEmpty(this.f60783a.promotion_txt)) {
            return;
        }
        Matcher matcher = Pattern.compile("[-+]?([0-9]*\\.[0-9]+|[0-9]+)").matcher(this.f60783a.promotion_txt);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group();
            String str = this.f60783a.promotion_txt;
            stringBuffer.append(str.substring(0, str.indexOf(group)));
            stringBuffer.append(String.format("<font color='#E85352'>%s</font>", group));
            PromotionInfoResponse promotionInfoResponse = this.f60783a;
            String str2 = promotionInfoResponse.promotion_txt;
            promotionInfoResponse.promotion_txt = str2.substring(str2.indexOf(group) + group.length());
        }
        PromotionInfoResponse promotionInfoResponse2 = this.f60783a;
        stringBuffer.append(promotionInfoResponse2.promotion_txt);
        promotionInfoResponse2.promotion_txt = stringBuffer.toString();
    }
}
