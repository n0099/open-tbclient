package com.baidu.tieba.nearby.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.s75;
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091f39);
        this.c = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910b2);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926b3);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926b5);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f091471);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911e6);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926ae);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926b4);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926af);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926b2);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091470);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911e5);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926b1);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926b0);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926ad);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.setConrers(15);
            this.c.setIsRound(true);
            this.c.setPlaceHolder(3);
            s75 d = s75.d(this.d);
            d.D(R.string.F_X01);
            d.C(R.dimen.T_X06);
            s75 d2 = s75.d(this.g);
            d2.D(R.string.F_X01);
            d2.C(R.dimen.T_X10);
            s75 d3 = s75.d(this.h);
            d3.D(R.string.F_X01);
            d3.C(R.dimen.T_X10);
            s75 d4 = s75.d(this.i);
            d4.D(R.string.F_X01);
            d4.C(R.dimen.T_X10);
            s75 d5 = s75.d(this.o);
            d5.D(R.string.F_X01);
            d5.C(R.dimen.T_X10);
            s75 d6 = s75.d(this.p);
            d6.C(R.string.F_X01);
            d6.C(R.dimen.T_X10);
            s75 d7 = s75.d(this.m);
            d7.D(R.string.F_X01);
            d7.C(R.dimen.T_X08);
            s75 d8 = s75.d(this.j);
            d8.D(R.string.F_X01);
            d8.C(R.dimen.T_X10);
            s75 d9 = s75.d(this.n);
            d9.D(R.string.F_X01);
            d9.C(R.dimen.T_X08);
        }
    }
}
