package com.baidu.tieba.newinterest.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class InterestedForumStyleAMoreViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public LinearLayout b;
    public TextView c;
    public View d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestedForumStyleAMoreViewHolder(View view2) {
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
        this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09113e);
        this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091140);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09113f);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f09113d);
    }
}
