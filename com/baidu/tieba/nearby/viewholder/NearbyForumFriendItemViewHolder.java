package com.baidu.tieba.nearby.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.n15;
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091e46);
        this.c = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091042);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092595);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092597);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f0913f7);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091171);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092590);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092596);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092591);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092594);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f0913f6);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091170);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092593);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092592);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09258f);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.setConrers(15);
            this.c.setIsRound(true);
            this.c.setPlaceHolder(3);
            n15 d = n15.d(this.d);
            d.B(R.string.F_X01);
            d.A(R.dimen.T_X06);
            n15 d2 = n15.d(this.g);
            d2.B(R.string.F_X01);
            d2.A(R.dimen.T_X10);
            n15 d3 = n15.d(this.h);
            d3.B(R.string.F_X01);
            d3.A(R.dimen.T_X10);
            n15 d4 = n15.d(this.i);
            d4.B(R.string.F_X01);
            d4.A(R.dimen.T_X10);
            n15 d5 = n15.d(this.o);
            d5.B(R.string.F_X01);
            d5.A(R.dimen.T_X10);
            n15 d6 = n15.d(this.p);
            d6.A(R.string.F_X01);
            d6.A(R.dimen.T_X10);
            n15 d7 = n15.d(this.m);
            d7.B(R.string.F_X01);
            d7.A(R.dimen.T_X08);
            n15 d8 = n15.d(this.j);
            d8.B(R.string.F_X01);
            d8.A(R.dimen.T_X10);
            n15 d9 = n15.d(this.n);
            d9.B(R.string.F_X01);
            d9.A(R.dimen.T_X08);
        }
    }
}
