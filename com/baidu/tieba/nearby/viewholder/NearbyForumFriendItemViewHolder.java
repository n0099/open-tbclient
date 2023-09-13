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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091fed);
        this.c = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910eb);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092769);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09276b);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f0914b5);
        this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091227);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092764);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09276a);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092765);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092768);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f0914b4);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091226);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092767);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092766);
        this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092763);
        a();
    }

    public final void a() {
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
