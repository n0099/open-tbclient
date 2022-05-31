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
import com.repackage.hz4;
import com.repackage.jn;
/* loaded from: classes3.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;
    public View c;
    public jn d;
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
        TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091834);
        this.a = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.c = view2.findViewById(R.id.obfuscated_res_0x7f091585);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ffe);
    }

    public void c(jn jnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jnVar) == null) && (jnVar instanceof hz4)) {
            this.d = jnVar;
            hz4 hz4Var = (hz4) jnVar;
            if (hz4Var.e()) {
                String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(hz4Var.b());
                this.b.setVisibility(0);
                if (StringUtils.isNull(headPortraitFilter)) {
                    this.a.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.a.K(headPortraitFilter, 25, false);
                }
            } else {
                this.a.setDefaultResource(R.drawable.obfuscated_res_0x7f080ba6);
                this.b.setVisibility(8);
                this.a.K(hz4Var.b(), 10, false);
            }
            b().setOnClickListener(this.f);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public jn d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (jn) invokeV.objValue;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.e == i) {
            return;
        }
        SkinManager.setViewTextColor(this.b, R.color.CAM_X0111, 1);
        SkinManager.setBackgroundColor(this.b, R.color.black_alpha50);
        this.e = i;
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }
}
