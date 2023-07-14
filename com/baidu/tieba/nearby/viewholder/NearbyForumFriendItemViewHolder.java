package com.baidu.tieba.nearby.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091f6b);
        this.c = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910c3);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926e8);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926ea);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f091485);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911f8);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926e3);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926e9);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926e4);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926e7);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091484);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911f7);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926e6);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926e5);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926e2);
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.setConrers(15);
            this.c.setIsRound(true);
            this.c.setPlaceHolder(3);
            d85 d = d85.d(this.d);
            d.D(R.string.F_X01);
            d.C(R.dimen.T_X06);
            d85 d2 = d85.d(this.g);
            d2.D(R.string.F_X01);
            d2.C(R.dimen.T_X10);
            d85 d3 = d85.d(this.h);
            d3.D(R.string.F_X01);
            d3.C(R.dimen.T_X10);
            d85 d4 = d85.d(this.i);
            d4.D(R.string.F_X01);
            d4.C(R.dimen.T_X10);
            d85 d5 = d85.d(this.o);
            d5.D(R.string.F_X01);
            d5.C(R.dimen.T_X10);
            d85 d6 = d85.d(this.p);
            d6.C(R.string.F_X01);
            d6.C(R.dimen.T_X10);
            d85 d7 = d85.d(this.m);
            d7.D(R.string.F_X01);
            d7.C(R.dimen.T_X08);
            d85 d8 = d85.d(this.j);
            d8.D(R.string.F_X01);
            d8.C(R.dimen.T_X10);
            d85 d9 = d85.d(this.n);
            d9.D(R.string.F_X01);
            d9.C(R.dimen.T_X08);
        }
    }
}
