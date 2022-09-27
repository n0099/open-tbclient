package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.flow.DownloadFlowView;
import com.baidu.tbadk.core.flow.data.ApkDownloadInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.np4;
import com.baidu.tieba.nv4;
import com.baidu.tieba.ov4;
import com.baidu.tieba.rv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class AutoDownloadBannerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public DownloadFlowView<ApkDownloadInfoData> b;
    public List<ApkDownloadInfoData> c;
    public np4 d;

    /* loaded from: classes5.dex */
    public class a extends nv4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AutoDownloadBannerView a;

        public a(AutoDownloadBannerView autoDownloadBannerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {autoDownloadBannerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = autoDownloadBannerView;
        }

        @Override // com.baidu.tieba.nv4, com.baidu.tieba.lv4
        public ov4 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ov4 ov4Var = new ov4();
                ov4Var.c(R.drawable.obfuscated_res_0x7f08069d);
                ov4Var.g(R.drawable.obfuscated_res_0x7f08069c);
                ov4Var.d(81);
                ov4Var.e(R.dimen.M_H_X005);
                ov4Var.h(R.dimen.tbds10);
                return ov4Var;
            }
            return (ov4) invokeV.objValue;
        }

        @Override // com.baidu.tieba.nv4, com.baidu.tieba.lv4
        public rv4 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                rv4 rv4Var = new rv4();
                rv4Var.a(ej.f(this.a.getContext(), R.dimen.tbds187));
                return rv4Var;
            }
            return (rv4) invokeV.objValue;
        }

        @Override // com.baidu.tieba.nv4, com.baidu.tieba.lv4
        public TbImageView d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setPlaceHolder(2);
                tbImageView.setLongIconSupport(false);
                tbImageView.setGifIconSupport(true);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDrawerType(1);
                tbImageView.setRadius(ej.f(this.a.getContext(), R.dimen.obfuscated_res_0x7f070287));
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoDownloadBannerView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i >= 0 && i <= ListUtils.getCount(this.c) : invokeI.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = new DownloadFlowView<>(getContext());
            a aVar = new a(this);
            this.b.setIndicatorNoOffet(false);
            this.b.setDisableParentEvent(false);
            this.b.setCoverFlowFactory(aVar);
            this.b.setIndicatorVisible(0);
            this.b.setIsAutoPlayDragging(false);
            addView(this.b);
        }
    }

    public void c(List<ApkDownloadInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.c = list;
            this.b.setData(list);
            if (list == null) {
                return;
            }
            rv4 rv4Var = new rv4();
            if (list.size() == 1) {
                rv4Var.a(ej.f(getContext(), R.dimen.tbds187));
            } else {
                rv4Var.a(ej.f(getContext(), R.dimen.tbds230));
            }
            this.b.z(rv4Var);
        }
    }

    public void d(int i) {
        DownloadFlowView<ApkDownloadInfoData> downloadFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (downloadFlowView = this.b) == null) {
            return;
        }
        downloadFlowView.r();
    }

    public void e() {
        DownloadFlowView<ApkDownloadInfoData> downloadFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (downloadFlowView = this.b) == null) {
            return;
        }
        downloadFlowView.w();
    }

    public DownloadFlowView getCoverFlowView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (DownloadFlowView) invokeV.objValue;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (this.d != null) {
                this.d.a(this, i == 0, null);
            }
        }
    }

    public void setIWindowChangedListener(np4 np4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, np4Var) == null) {
            this.d = np4Var;
        }
    }

    public void setIndicatorVisible(int i) {
        DownloadFlowView<ApkDownloadInfoData> downloadFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (downloadFlowView = this.b) == null) {
            return;
        }
        downloadFlowView.setIndicatorVisible(i);
    }

    public void setMarqueenTime(long j) {
        DownloadFlowView<ApkDownloadInfoData> downloadFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048585, this, j) == null) || (downloadFlowView = this.b) == null) {
            return;
        }
        downloadFlowView.setMarqueenTime(j);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoDownloadBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoDownloadBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.a = context;
        b();
    }
}
