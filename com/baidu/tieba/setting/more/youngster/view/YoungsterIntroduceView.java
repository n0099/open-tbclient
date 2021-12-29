package com.baidu.tieba.setting.more.youngster.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.s0.s.i0.n.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class YoungsterIntroduceView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f49720e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f49721f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49722g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49723h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49724i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f49725j;

    /* renamed from: k  reason: collision with root package name */
    public TBSpecificationBtn f49726k;
    public int l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YoungsterIntroduceView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.youngster_introduce, this);
            this.f49720e = (ImageView) findViewById(R.id.img_youngster_introduce);
            this.f49721f = (TextView) findViewById(R.id.txt_youngster_introduce_title);
            this.f49722g = (TextView) findViewById(R.id.txt_youngster_introduce_content1);
            this.f49723h = (TextView) findViewById(R.id.txt_youngster_introduce_content2);
            this.f49724i = (TextView) findViewById(R.id.txt_youngster_introduce_content3);
            this.f49725j = (TextView) findViewById(R.id.txt_youngster_introduce_content4);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.btn_youngster_open);
            this.f49726k = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(new a());
            this.f49726k.setText(getContext().getString(R.string.youngster_settings_open_title));
            this.f49726k.setOnClickListener(this);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f49720e.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.pic_mask_qingshaonian_time, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(this.f49721f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f49722g, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f49723h, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f49724i, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f49725j, R.color.CAM_X0107);
            this.f49726k.changeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) && view == this.f49726k) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(getContext());
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(1);
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.l);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.l = i2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YoungsterIntroduceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YoungsterIntroduceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }
}
