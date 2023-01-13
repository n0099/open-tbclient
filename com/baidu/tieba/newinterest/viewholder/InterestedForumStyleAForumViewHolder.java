package com.baidu.tieba.newinterest.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class InterestedForumStyleAForumViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public BarImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public View g;
    public ImageView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestedForumStyleAForumViewHolder(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
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
        this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ffd);
        this.b = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ff9);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090fff);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ffa);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ff7);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ffc);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f090ff8);
        this.h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ffe);
    }
}
