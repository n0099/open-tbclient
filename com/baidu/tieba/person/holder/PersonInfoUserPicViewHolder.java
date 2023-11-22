package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ed5;
import com.baidu.tieba.oi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;
    public View c;
    public oi d;
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
        TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091ce4);
        this.a = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.c = view2.findViewById(R.id.obfuscated_res_0x7f091a18);
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925e0);
    }

    public void a(oi oiVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, oiVar) != null) || !(oiVar instanceof ed5)) {
            return;
        }
        this.d = oiVar;
        ed5 ed5Var = (ed5) oiVar;
        if (ed5Var.c()) {
            String b = ed5Var.b();
            this.b.setVisibility(0);
            if (StringUtils.isNull(b)) {
                this.a.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
            } else {
                this.a.startLoad(b, 25, false);
            }
        } else {
            this.a.setDefaultResource(R.drawable.img_default_100);
            this.b.setVisibility(8);
            this.a.startLoad(ed5Var.b(), 10, false);
        }
        getView().setOnClickListener(this.f);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public oi b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (oi) invokeV.objValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.e != i) {
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0111, 1);
            SkinManager.setBackgroundColor(this.b, R.color.black_alpha50);
            this.e = i;
        }
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }
}
