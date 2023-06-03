package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.ui;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ShareFromFrsView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public HeadImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public Context g;
    public ShareFromFrsMsgData h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFromFrsView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = context;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFromFrsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = context;
        b();
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return ui.cutString(str, 8) + this.g.getString(R.string.obfuscated_res_0x7f0f0766);
        }
        return (String) invokeL.objValue;
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, shareFromFrsMsgData) == null) {
            this.h = shareFromFrsMsgData;
            c();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.share_from_frs_view, this);
            this.a = (TextView) findViewById(R.id.frs_name);
            this.b = (HeadImageView) findViewById(R.id.frs_img);
            this.d = (TextView) findViewById(R.id.frs_member_num);
            this.f = (TextView) findViewById(R.id.frs_post_num);
            this.c = (TextView) findViewById(R.id.frs_member_num_label);
            this.e = (TextView) findViewById(R.id.frs_post_num_label);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setText(a(this.h.getName()));
            this.b.setPlaceHolder(1);
            this.b.setAutoChangeStyle(false);
            this.b.N(this.h.getImageUrl(), 10, false);
            this.d.setText(StringHelper.numFormatOver10000(this.h.getMemberNum()));
            this.f.setText(StringHelper.numFormatOver10000(this.h.getPostNum()));
        }
    }

    public void setIsLeft(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.a.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
                this.d.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
                this.f.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
                this.c.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
                this.e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
                return;
            }
            this.a.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
            this.d.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
            this.f.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
            this.c.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
            this.e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        }
    }
}
