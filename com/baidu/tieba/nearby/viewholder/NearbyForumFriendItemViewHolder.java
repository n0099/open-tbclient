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
import com.repackage.vr4;
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091b4d);
        this.c = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e7a);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092238);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09223a);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f091216);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f97);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092233);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092239);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092234);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092237);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091215);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f96);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092236);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092235);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092232);
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.setConrers(15);
            this.c.setIsRound(true);
            this.c.setPlaceHolder(3);
            vr4 d = vr4.d(this.d);
            d.A(R.string.F_X01);
            d.z(R.dimen.T_X06);
            vr4 d2 = vr4.d(this.g);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X10);
            vr4 d3 = vr4.d(this.h);
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X10);
            vr4 d4 = vr4.d(this.i);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X10);
            vr4 d5 = vr4.d(this.o);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X10);
            vr4 d6 = vr4.d(this.p);
            d6.z(R.string.F_X01);
            d6.z(R.dimen.T_X10);
            vr4 d7 = vr4.d(this.m);
            d7.A(R.string.F_X01);
            d7.z(R.dimen.T_X08);
            vr4 d8 = vr4.d(this.j);
            d8.A(R.string.F_X01);
            d8.z(R.dimen.T_X10);
            vr4 d9 = vr4.d(this.n);
            d9.A(R.string.F_X01);
            d9.z(R.dimen.T_X08);
        }
    }
}
