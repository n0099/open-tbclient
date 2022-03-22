package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class GodReplyMoreViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public View f35136b;

    /* renamed from: c  reason: collision with root package name */
    public int f35137c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GodReplyMoreViewHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        this.f35137c = 3;
        this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09133d);
        this.f35136b = view.findViewById(R.id.obfuscated_res_0x7f0907f7);
        SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0106);
        SkinManager.setBackgroundResource(this.a, R.drawable.more_all);
        SkinManager.setBackgroundResource(this.f35136b, R.color.CAM_X0204);
    }
}
