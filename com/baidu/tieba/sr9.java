package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class sr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundPreviewActivity a;
    public View b;
    public BdExpandImageView c;
    public TbImageView d;
    public TbImageView e;
    public TextView f;
    public ImageView g;
    public TextView h;
    public final bg<sm> i;

    /* loaded from: classes6.dex */
    public class a extends bg<sm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr9 a;

        public a(sr9 sr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr9Var;
        }

        @Override // com.baidu.tieba.bg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // com.baidu.tieba.bg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        public void onLoaded(sm smVar, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, smVar, str, i) == null) && smVar != null) {
                smVar.h(this.a.c);
            }
        }
    }

    public sr9(BackgroundPreviewActivity backgroundPreviewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundPreviewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this);
        this.a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0135, (ViewGroup) null);
        this.b = inflate;
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702c7)));
        c();
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.a.getPageContext() == null) {
            return;
        }
        zm5.a(this.a.getPageContext(), this.b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = (BdExpandImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090a44);
            this.d = (TbImageView) this.b.findViewById(R.id.user_head);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0927f0);
            this.e = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f = (TextView) this.b.findViewById(R.id.user_name);
            this.g = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0926ca);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092681);
            this.d.setDefaultResource(R.drawable.icon_default_avatar100);
        }
    }

    public void e(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, dressItemData) != null) || dressItemData == null) {
            return;
        }
        cg.h().k(dressItemData.getExampleImgUrl(), 10, this.i, 0, 0, null, new Object[0]);
        if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
            this.h.setText("0");
        } else {
            this.h.setText(dressItemData.getPropsStateImg());
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0331, 1);
            this.f.setText(R.string.obfuscated_res_0x7f0f04cb);
            this.g.setImageResource(R.drawable.icon_pop_boy);
            this.e.setVisibility(8);
            return;
        }
        String avatar = currentAccountInfo.getAvatar();
        int memberType = currentAccountInfo.getMemberType();
        if (!TextUtils.isEmpty(avatar)) {
            this.d.N(avatar, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (StringUtils.isNull(memberIconUrl)) {
            this.e.setVisibility(8);
        } else {
            this.e.N(memberIconUrl, 10, false);
            this.e.setVisibility(0);
        }
        if (memberType > 0) {
            this.f.setTextColor(this.a.getResources().getColor(R.color.CAM_X0331));
        } else {
            this.f.setTextColor(this.a.getResources().getColor(R.color.CAM_X0622));
        }
        this.f.setText(currentAccountInfo.getAccountNameShow());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            this.g.setImageResource(R.drawable.icon_pop_boy);
        } else if (sex == 2) {
            this.g.setImageResource(R.drawable.icon_pop_girl);
        } else {
            this.g.setVisibility(8);
        }
    }
}
