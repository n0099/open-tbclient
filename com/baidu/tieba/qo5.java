package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.xo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class qo5 extends ig5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NoDataView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qo5(Context context) {
        super(new NoDataView(context));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = (NoDataView) getView();
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.a.f(g9.a(getView().getContext()), i);
        }
    }

    public void b(xo5.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) || aVar == null) {
            return;
        }
        this.a.setVisibility(0);
        NoDataViewFactory.d.a aVar2 = new NoDataViewFactory.d.a();
        aVar2.i(NoDataViewFactory.ImgType.LOCAL);
        aVar2.h(aVar.c);
        aVar2.j(aVar.g);
        this.a.setImgOption(aVar2.f());
        if (aVar.b && !TextUtils.isEmpty(aVar.a)) {
            str = aVar.a;
        } else {
            str = aVar.d;
        }
        NoDataViewFactory.e.a aVar3 = new NoDataViewFactory.e.a();
        aVar3.g(str);
        this.a.setTextOption(aVar3.f());
        if (aVar.f && !TextUtils.isEmpty(aVar.e)) {
            String str2 = aVar.e;
            View.OnClickListener onClickListener = aVar.h;
            NoDataViewFactory.c.a aVar4 = new NoDataViewFactory.c.a();
            aVar4.f(new NoDataViewFactory.b(str2, onClickListener));
            this.a.setButtonOption(aVar4.e());
        } else {
            this.a.setButtonOption(null);
        }
        a(TbadkCoreApplication.getInst().getSkinType());
    }
}
