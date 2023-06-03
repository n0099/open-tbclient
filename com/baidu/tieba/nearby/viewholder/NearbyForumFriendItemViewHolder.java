package com.baidu.tieba.nearby.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.m75;
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091ed1);
        this.c = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910a1);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092645);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092647);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f09145c);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911d5);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092640);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092646);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092641);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092644);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f09145b);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911d4);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092643);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092642);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09263f);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.setConrers(15);
            this.c.setIsRound(true);
            this.c.setPlaceHolder(3);
            m75 d = m75.d(this.d);
            d.C(R.string.F_X01);
            d.B(R.dimen.T_X06);
            m75 d2 = m75.d(this.g);
            d2.C(R.string.F_X01);
            d2.B(R.dimen.T_X10);
            m75 d3 = m75.d(this.h);
            d3.C(R.string.F_X01);
            d3.B(R.dimen.T_X10);
            m75 d4 = m75.d(this.i);
            d4.C(R.string.F_X01);
            d4.B(R.dimen.T_X10);
            m75 d5 = m75.d(this.o);
            d5.C(R.string.F_X01);
            d5.B(R.dimen.T_X10);
            m75 d6 = m75.d(this.p);
            d6.B(R.string.F_X01);
            d6.B(R.dimen.T_X10);
            m75 d7 = m75.d(this.m);
            d7.C(R.string.F_X01);
            d7.B(R.dimen.T_X08);
            m75 d8 = m75.d(this.j);
            d8.C(R.string.F_X01);
            d8.B(R.dimen.T_X10);
            m75 d9 = m75.d(this.n);
            d9.C(R.string.F_X01);
            d9.B(R.dimen.T_X08);
        }
    }
}
