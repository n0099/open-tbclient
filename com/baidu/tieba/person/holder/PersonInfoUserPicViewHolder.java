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
import d.a.c.k.e.n;
import d.a.r0.t.o;
/* loaded from: classes5.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f19945a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19946b;

    /* renamed from: c  reason: collision with root package name */
    public View f19947c;

    /* renamed from: d  reason: collision with root package name */
    public n f19948d;

    /* renamed from: e  reason: collision with root package name */
    public int f19949e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19950f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoUserPicViewHolder(View view) {
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
        this.f19949e = 3;
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.f19945a = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.f19947c = view.findViewById(R.id.normal_pic_click_bg);
        this.f19946b = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void b(n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) && (nVar instanceof o)) {
            this.f19948d = nVar;
            o oVar = (o) nVar;
            if (oVar.d()) {
                String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(oVar.c());
                this.f19946b.setVisibility(0);
                if (StringUtils.isNull(headPortraitFilter)) {
                    this.f19945a.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.f19945a.M(headPortraitFilter, 25, false);
                }
            } else {
                this.f19945a.setDefaultResource(R.drawable.img_default_100);
                this.f19946b.setVisibility(8);
                this.f19945a.M(oVar.c(), 10, false);
            }
            a().setOnClickListener(this.f19950f);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19948d : (n) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f19949e == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f19946b, R.color.CAM_X0111, 1);
        SkinManager.setBackgroundColor(this.f19946b, R.color.black_alpha50);
        this.f19949e = i2;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f19950f = onClickListener;
        }
    }
}
