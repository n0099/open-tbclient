package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nn;
import com.repackage.y05;
/* loaded from: classes3.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;
    public View c;
    public nn d;
    public int e;
    public View.OnClickListener f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoUserPicViewHolder(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
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
        this.e = 3;
        TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0918ae);
        this.a = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.c = view2.findViewById(R.id.obfuscated_res_0x7f0915fb);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920a6);
    }

    public void b(nn nnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nnVar) == null) && (nnVar instanceof y05)) {
            this.d = nnVar;
            y05 y05Var = (y05) nnVar;
            if (y05Var.c()) {
                String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(y05Var.b());
                this.b.setVisibility(0);
                if (StringUtils.isNull(headPortraitFilter)) {
                    this.a.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.a.J(headPortraitFilter, 25, false);
                }
            } else {
                this.a.setDefaultResource(R.drawable.obfuscated_res_0x7f080b9b);
                this.b.setVisibility(8);
                this.a.J(y05Var.b(), 10, false);
            }
            a().setOnClickListener(this.f);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public nn c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (nn) invokeV.objValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.e == i) {
            return;
        }
        SkinManager.setViewTextColor(this.b, R.color.CAM_X0111, 1);
        SkinManager.setBackgroundColor(this.b, R.color.black_alpha50);
        this.e = i;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }
}
