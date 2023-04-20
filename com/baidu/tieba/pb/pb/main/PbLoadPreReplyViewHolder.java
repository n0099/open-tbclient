package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.r25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbLoadPreReplyViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public ImageView c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbLoadPreReplyViewHolder(Context context, View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
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
        if (view2 == null) {
            return;
        }
        this.a = view2;
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925a8);
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091050);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r25.d(this.b).w(R.color.CAM_X0304);
            WebPManager.setPureDrawable(this.c, R.drawable.obfuscated_res_0x7f080ab3, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        this.b.setText(R.string.obfuscated_res_0x7f0f0b05);
                        this.c.setVisibility(8);
                        return;
                    }
                    return;
                }
                this.b.setText(R.string.obfuscated_res_0x7f0f0b07);
                this.c.setVisibility(8);
                return;
            }
            this.b.setText(R.string.obfuscated_res_0x7f0f105e);
            this.c.setVisibility(0);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                b(0);
            } else {
                this.a.setVisibility(8);
            }
        }
    }
}
