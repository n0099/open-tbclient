package com.baidu.tieba.memberCenter.index.adapter;

import android.view.View;
import android.widget.TextView;
import c.a.t0.g2.c.j.h;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class VipHeaderViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f45936b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f45937c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f45938d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f45939e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f45940f;

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
        this.a = view;
        this.f45937c = (TextView) view.findViewById(R.id.textview_user_name);
        this.f45938d = (TextView) view.findViewById(R.id.textview_vip_end_time);
        this.f45936b = (HeadImageView) view.findViewById(R.id.user_photo);
        this.f45939e = (TbImageView) view.findViewById(R.id.user_vip_icon_image);
        this.f45940f = (TbImageView) view.findViewById(R.id.user_vip_level_image);
        this.f45936b.setIsRound(true);
        this.f45936b.setDefaultBgResource(0);
        this.f45936b.setDefaultResource(R.drawable.icon_default_avatar100);
    }

    public void fillView(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
        }
    }
}
