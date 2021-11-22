package com.baidu.tieba.memberCenter.index.adapter;

import android.view.View;
import android.widget.TextView;
import b.a.r0.y1.c.j.h;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VipHeaderViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f52438a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f52439b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52440c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52441d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f52442e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f52443f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipHeaderViewHolder(View view, BaseFragmentActivity baseFragmentActivity) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, baseFragmentActivity};
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
        if (view == null) {
            return;
        }
        this.f52438a = view;
        this.f52440c = (TextView) view.findViewById(R.id.textview_user_name);
        this.f52441d = (TextView) view.findViewById(R.id.textview_vip_end_time);
        this.f52439b = (HeadImageView) view.findViewById(R.id.user_photo);
        this.f52442e = (TbImageView) view.findViewById(R.id.user_vip_icon_image);
        this.f52443f = (TbImageView) view.findViewById(R.id.user_vip_level_image);
        this.f52439b.setIsRound(true);
        this.f52439b.setDefaultBgResource(0);
        this.f52439b.setDefaultResource(R.drawable.icon_default_avatar100);
    }

    public void fillView(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
        }
    }
}
