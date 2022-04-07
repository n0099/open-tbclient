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
import com.repackage.wr4;
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091ade);
        this.c = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090eaf);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092199);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09219b);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f0911d2);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fce);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092194);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09219a);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092195);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092198);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f0911d1);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fcd);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092197);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092196);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092193);
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.setConrers(15);
            this.c.setIsRound(true);
            this.c.setPlaceHolder(3);
            wr4 d = wr4.d(this.d);
            d.A(R.string.F_X01);
            d.z(R.dimen.T_X06);
            wr4 d2 = wr4.d(this.g);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X10);
            wr4 d3 = wr4.d(this.h);
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X10);
            wr4 d4 = wr4.d(this.i);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X10);
            wr4 d5 = wr4.d(this.o);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X10);
            wr4 d6 = wr4.d(this.p);
            d6.z(R.string.F_X01);
            d6.z(R.dimen.T_X10);
            wr4 d7 = wr4.d(this.m);
            d7.A(R.string.F_X01);
            d7.z(R.dimen.T_X08);
            wr4 d8 = wr4.d(this.j);
            d8.A(R.string.F_X01);
            d8.z(R.dimen.T_X10);
            wr4 d9 = wr4.d(this.n);
            d9.A(R.string.F_X01);
            d9.z(R.dimen.T_X08);
        }
    }
}
