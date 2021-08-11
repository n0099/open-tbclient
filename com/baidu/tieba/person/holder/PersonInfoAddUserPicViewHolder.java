package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.k.e.n;
import c.a.p0.k2.h.c;
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
/* loaded from: classes7.dex */
public class PersonInfoAddUserPicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f55465a;
    public ImageView addView;

    /* renamed from: b  reason: collision with root package name */
    public n f55466b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f55467c;
    public TextView numberTipView;
    public View rootView;

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
        this.f55465a = 3;
        this.rootView = view.findViewById(R.id.add_pic_root);
        this.addView = (ImageView) view.findViewById(R.id.add_image_view);
        this.numberTipView = (TextView) view.findViewById(R.id.tip_left_count_view);
    }

    public void bindDataToView(n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) && (nVar instanceof c)) {
            this.f55466b = nVar;
            c cVar = (c) nVar;
            SkinManager.setImageResource(this.addView, R.drawable.icon_mine_pic_add);
            if (cVar.b() > 0) {
                this.numberTipView.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.have_left_some_picture_upload), Integer.valueOf(cVar.b())));
            }
            getView().setOnClickListener(this.f55467c);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55466b : (n) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f55465a == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.numberTipView, R.color.CAM_X0110, 1);
        SkinManager.setBackgroundColor(getView(), R.color.CAM_X0205);
        this.f55465a = i2;
    }

    public void setOnclickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f55467c = onClickListener;
        }
    }
}
