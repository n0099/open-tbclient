package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pea extends tea {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView h;
    public TextView i;
    public TextView j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eea a;
        public final /* synthetic */ pea b;

        public a(pea peaVar, eea eeaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {peaVar, eeaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = peaVar;
            this.a = eeaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Context context = this.b.b.getContext();
                eea eeaVar = this.a;
                String str2 = eeaVar.d;
                String str3 = eeaVar.f;
                AdvertAppInfo advertAppInfo = this.b.c;
                if (advertAppInfo != null) {
                    str = advertAppInfo.g;
                } else {
                    str = "";
                }
                zca.a(context, str2, str3, str, this.a.j);
                ClogBuilder clogBuilder = new ClogBuilder();
                clogBuilder.v(this.b.c.j).q(String.valueOf(this.b.c.position + 1)).p(this.b.c.g).z(String.valueOf(302));
                az0.e(clogBuilder);
                pea peaVar = this.b;
                if (peaVar.d != null) {
                    dc9.c(peaVar.c);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pea(View view2, String str) {
        super(view2, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        k();
    }

    @Override // com.baidu.tieba.tea
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.b();
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0620, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.obfuscated_res_0x7f081506, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.tea
    public void c(eea eeaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eeaVar) == null) {
            super.c(eeaVar);
            this.h.startLoad(eeaVar.c, 10, false);
            this.i.setText(eeaVar.b);
            this.j.setText(eeaVar.e);
            this.b.setOnClickListener(new a(this, eeaVar));
            b();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HeadImageView headImageView = (HeadImageView) a(R.id.obfuscated_res_0x7f0928c3);
            this.h = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.h.setDefaultBgResource(R.color.CAM_X0205);
            this.h.setIsRound(true);
            this.i = (TextView) a(R.id.user_name);
            this.j = (TextView) a(R.id.obfuscated_res_0x7f09007d);
        }
    }
}
