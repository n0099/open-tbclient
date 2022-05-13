package com.baidu.tieba.nearby.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gs4;
/* loaded from: classes3.dex */
public class NearbyForumFriendItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public HeadImageView c;
    public TextView d;
    public View e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public View k;
    public ImageView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyForumFriendItemViewHolder(View view2, Context context) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, context};
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091b2d);
        this.c = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ebb);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921f2);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921f4);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f0911e2);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fdc);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ed);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921f3);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ee);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921f1);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f0911e1);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fdb);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921f0);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ef);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ec);
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.setConrers(15);
            this.c.setIsRound(true);
            this.c.setPlaceHolder(3);
            gs4 d = gs4.d(this.d);
            d.A(R.string.F_X01);
            d.z(R.dimen.T_X06);
            gs4 d2 = gs4.d(this.g);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X10);
            gs4 d3 = gs4.d(this.h);
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X10);
            gs4 d4 = gs4.d(this.i);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X10);
            gs4 d5 = gs4.d(this.o);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X10);
            gs4 d6 = gs4.d(this.p);
            d6.z(R.string.F_X01);
            d6.z(R.dimen.T_X10);
            gs4 d7 = gs4.d(this.m);
            d7.A(R.string.F_X01);
            d7.z(R.dimen.T_X08);
            gs4 d8 = gs4.d(this.j);
            d8.A(R.string.F_X01);
            d8.z(R.dimen.T_X10);
            gs4 d9 = gs4.d(this.n);
            d9.A(R.string.F_X01);
            d9.z(R.dimen.T_X08);
        }
    }
}
