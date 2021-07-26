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
import d.a.d.k.e.n;
import d.a.p0.u.m;
/* loaded from: classes4.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f20103a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f20104b;

    /* renamed from: c  reason: collision with root package name */
    public View f20105c;

    /* renamed from: d  reason: collision with root package name */
    public n f20106d;

    /* renamed from: e  reason: collision with root package name */
    public int f20107e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f20108f;

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
        this.f20107e = 3;
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.photo_image_view);
        this.f20103a = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        this.f20105c = view.findViewById(R.id.normal_pic_click_bg);
        this.f20104b = (TextView) view.findViewById(R.id.tip_default_view);
    }

    public void b(n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) && (nVar instanceof m)) {
            this.f20106d = nVar;
            m mVar = (m) nVar;
            if (mVar.d()) {
                String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(mVar.c());
                this.f20104b.setVisibility(0);
                if (StringUtils.isNull(headPortraitFilter)) {
                    this.f20103a.setDefaultResource(R.drawable.pic_mycenter_avatar_def_i);
                } else {
                    this.f20103a.M(headPortraitFilter, 25, false);
                }
            } else {
                this.f20103a.setDefaultResource(R.drawable.img_default_100);
                this.f20104b.setVisibility(8);
                this.f20103a.M(mVar.c(), 10, false);
            }
            a().setOnClickListener(this.f20108f);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20106d : (n) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f20107e == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.f20104b, R.color.CAM_X0111, 1);
        SkinManager.setBackgroundColor(this.f20104b, R.color.black_alpha50);
        this.f20107e = i2;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f20108f = onClickListener;
        }
    }
}
