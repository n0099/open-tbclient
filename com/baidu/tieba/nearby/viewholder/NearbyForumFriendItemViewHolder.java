package com.baidu.tieba.nearby.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091f88);
        this.c = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910d9);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092707);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092709);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f091498);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09120b);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092702);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092708);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092703);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092706);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091497);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09120a);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092705);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092704);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092701);
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.setConrers(15);
            this.c.setIsRound(true);
            this.c.setPlaceHolder(3);
            EMManager.from(this.d).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X06);
            EMManager.from(this.g).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X10);
            EMManager.from(this.h).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X10);
            EMManager.from(this.i).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X10);
            EMManager.from(this.o).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X10);
            EMManager.from(this.p).setTextSize(R.string.F_X01).setTextSize(R.dimen.T_X10);
            EMManager.from(this.m).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08);
            EMManager.from(this.j).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X10);
            EMManager.from(this.n).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08);
        }
    }
}
