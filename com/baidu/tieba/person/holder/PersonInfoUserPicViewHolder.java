package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import c.a.d.m.e.n;
import c.a.r0.w2.a;
import c.a.r0.w2.c;
import c.a.r0.w2.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class PersonInfoUserPicViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n a;

    /* renamed from: b  reason: collision with root package name */
    public int f48172b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f48173c;
    public View coverView;
    public TbImageView imageView;
    public TextView tipTextView;

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
        this.f48172b = 3;
        TbImageView tbImageView = (TbImageView) view.findViewById(d.photo_image_view);
        this.imageView = tbImageView;
        tbImageView.setDefaultBgResource(a.CAM_X0205);
        this.coverView = view.findViewById(d.normal_pic_click_bg);
        this.tipTextView = (TextView) view.findViewById(d.tip_default_view);
    }

    public void bindDataToView(n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) && (nVar instanceof c.a.q0.u.n)) {
            this.a = nVar;
            c.a.q0.u.n nVar2 = (c.a.q0.u.n) nVar;
            if (nVar2.e()) {
                String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(nVar2.d());
                this.tipTextView.setVisibility(0);
                if (StringUtils.isNull(headPortraitFilter)) {
                    this.imageView.setDefaultResource(c.pic_mycenter_avatar_def_i);
                } else {
                    this.imageView.startLoad(headPortraitFilter, 25, false);
                }
            } else {
                this.imageView.setDefaultResource(c.img_default_100);
                this.tipTextView.setVisibility(8);
                this.imageView.startLoad(nVar2.d(), 10, false);
            }
            getView().setOnClickListener(this.f48173c);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public n getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (n) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f48172b == i2) {
            return;
        }
        SkinManager.setViewTextColor(this.tipTextView, a.CAM_X0111, 1);
        SkinManager.setBackgroundColor(this.tipTextView, a.black_alpha50);
        this.f48172b = i2;
    }

    public void setOnclickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f48173c = onClickListener;
        }
    }
}
