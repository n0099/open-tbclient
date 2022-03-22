package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import c.a.d.o.e.n;
import c.a.o0.t.q;
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
/* loaded from: classes5.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35353b;

    /* renamed from: c  reason: collision with root package name */
    public View f35354c;

    /* renamed from: d  reason: collision with root package name */
    public n f35355d;

    /* renamed from: e  reason: collision with root package name */
    public int f35356e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f35357f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoUserPicViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        this.f35356e = 3;
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f09182b);
        this.a = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.f35354c = view.findViewById(R.id.obfuscated_res_0x7f0915b5);
        this.f35353b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09200e);
    }

    public void c(n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) && (nVar instanceof q)) {
            this.f35355d = nVar;
            q qVar = (q) nVar;
            if (qVar.e()) {
                String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(qVar.b());
                this.f35353b.setVisibility(0);
                if (StringUtils.isNull(headPortraitFilter)) {
                    this.a.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.a.J(headPortraitFilter, 25, false);
                }
            } else {
                this.a.setDefaultResource(R.drawable.obfuscated_res_0x7f080b75);
                this.f35353b.setVisibility(8);
                this.a.J(qVar.b(), 10, false);
            }
            b().setOnClickListener(this.f35357f);
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35355d : (n) invokeV.objValue;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.f35356e == i) {
            return;
        }
        SkinManager.setViewTextColor(this.f35353b, R.color.CAM_X0111, 1);
        SkinManager.setBackgroundColor(this.f35353b, R.color.black_alpha50);
        this.f35356e = i;
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f35357f = onClickListener;
        }
    }
}
