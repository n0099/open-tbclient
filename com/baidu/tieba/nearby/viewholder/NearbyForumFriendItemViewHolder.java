package com.baidu.tieba.nearby.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.o0.r.v.c;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class NearbyForumFriendItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f34587b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f34588c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34589d;

    /* renamed from: e  reason: collision with root package name */
    public View f34590e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f34591f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f34592g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f34593h;
    public TextView i;
    public TextView j;
    public View k;
    public ImageView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyForumFriendItemViewHolder(View view, Context context) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, context};
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
        this.a = context;
        this.f34587b = view.findViewById(R.id.obfuscated_res_0x7f091aef);
        this.f34588c = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090eb4);
        this.f34589d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921b6);
        this.n = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921b8);
        this.f34590e = view.findViewById(R.id.obfuscated_res_0x7f0911dd);
        this.f34591f = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090fd4);
        this.f34592g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921b1);
        this.f34593h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921b7);
        this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921b2);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921b5);
        this.k = view.findViewById(R.id.obfuscated_res_0x7f0911dc);
        this.l = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090fd3);
        this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921b4);
        this.o = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921b3);
        this.p = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921b0);
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f34588c.setConrers(15);
            this.f34588c.setIsRound(true);
            this.f34588c.setPlaceHolder(3);
            c d2 = c.d(this.f34589d);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X06);
            c d3 = c.d(this.f34592g);
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X10);
            c d4 = c.d(this.f34593h);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X10);
            c d5 = c.d(this.i);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X10);
            c d6 = c.d(this.o);
            d6.A(R.string.F_X01);
            d6.z(R.dimen.T_X10);
            c d7 = c.d(this.p);
            d7.z(R.string.F_X01);
            d7.z(R.dimen.T_X10);
            c d8 = c.d(this.m);
            d8.A(R.string.F_X01);
            d8.z(R.dimen.T_X08);
            c d9 = c.d(this.j);
            d9.A(R.string.F_X01);
            d9.z(R.dimen.T_X10);
            c d10 = c.d(this.n);
            d10.A(R.string.F_X01);
            d10.z(R.dimen.T_X08);
        }
    }
}
