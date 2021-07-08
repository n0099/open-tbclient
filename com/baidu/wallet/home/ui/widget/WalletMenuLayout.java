package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public class WalletMenuLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void a(HomeCfgResponse.TitleItemData titleItemData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletMenuLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setOrientation(1);
    }

    public void setData(Context context, String str, HomeCfgResponse.TitleItemData[] titleItemDataArr, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, titleItemDataArr, aVar) == null) {
            removeAllViews();
            if (titleItemDataArr == null || titleItemDataArr.length <= 0) {
                return;
            }
            LayoutInflater from = LayoutInflater.from(context);
            for (HomeCfgResponse.TitleItemData titleItemData : titleItemDataArr) {
                if (titleItemData != null) {
                    View inflate = from.inflate(ResUtils.layout(context, "wallet_home_menu_item_view"), (ViewGroup) null);
                    NetImageView netImageView = (NetImageView) inflate.findViewById(ResUtils.id(context, "logo"));
                    ((TextView) inflate.findViewById(ResUtils.id(context, "name"))).setText(titleItemData.setting_name);
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                    }
                    sb.append(titleItemData.setting_icon);
                    netImageView.setImageUrl(sb.toString());
                    inflate.setOnClickListener(new View.OnClickListener(this, aVar, titleItemData) { // from class: com.baidu.wallet.home.ui.widget.WalletMenuLayout.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f25076a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ HomeCfgResponse.TitleItemData f25077b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ WalletMenuLayout f25078c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, aVar, titleItemData};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f25078c = this;
                            this.f25076a = aVar;
                            this.f25077b = titleItemData;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f25076a.a(this.f25077b);
                            }
                        }
                    });
                    addView(inflate);
                }
            }
        }
    }
}
