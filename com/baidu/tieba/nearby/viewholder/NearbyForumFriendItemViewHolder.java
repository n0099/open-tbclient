package com.baidu.tieba.nearby.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.p15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091db8);
        this.c = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fd0);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924ee);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924f0);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f091384);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910fe);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924e9);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924ef);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924ea);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924ed);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091383);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910fd);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924ec);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924eb);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924e8);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.setConrers(15);
            this.c.setIsRound(true);
            this.c.setPlaceHolder(3);
            p15 d = p15.d(this.d);
            d.A(R.string.F_X01);
            d.z(R.dimen.T_X06);
            p15 d2 = p15.d(this.g);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X10);
            p15 d3 = p15.d(this.h);
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X10);
            p15 d4 = p15.d(this.i);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X10);
            p15 d5 = p15.d(this.o);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X10);
            p15 d6 = p15.d(this.p);
            d6.z(R.string.F_X01);
            d6.z(R.dimen.T_X10);
            p15 d7 = p15.d(this.m);
            d7.A(R.string.F_X01);
            d7.z(R.dimen.T_X08);
            p15 d8 = p15.d(this.j);
            d8.A(R.string.F_X01);
            d8.z(R.dimen.T_X10);
            p15 d9 = p15.d(this.n);
            d9.A(R.string.F_X01);
            d9.z(R.dimen.T_X08);
        }
    }
}
