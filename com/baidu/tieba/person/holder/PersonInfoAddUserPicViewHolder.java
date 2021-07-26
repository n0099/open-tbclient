package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.q0.j2.i.c;
/* loaded from: classes4.dex */
public class PersonInfoAddUserPicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f20097a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f20098b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20099c;

    /* renamed from: d  reason: collision with root package name */
    public int f20100d;

    /* renamed from: e  reason: collision with root package name */
    public n f20101e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f20102f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoAddUserPicViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20100d = 3;
        this.f20097a = view.findViewById(R.id.add_pic_root);
        this.f20098b = (ImageView) view.findViewById(R.id.add_image_view);
        this.f20099c = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void b(n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) && (nVar instanceof c)) {
            this.f20101e = nVar;
            c cVar = (c) nVar;
            SkinManager.setImageResource(this.f20098b, R.drawable.icon_mine_pic_add);
            if (cVar.b() > 0) {
                this.f20099c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.b())));
            }
            a().setOnClickListener(this.f20102f);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20101e : (n) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f20100d == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f20099c, R.color.CAM_X0110, 1);
        SkinManager.setBackgroundColor(a(), R.color.CAM_X0205);
        this.f20100d = i2;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f20102f = onClickListener;
        }
    }
}
