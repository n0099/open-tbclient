package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.d.m.i;
import c.a.o0.r.v.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class NewUserRewardDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlphaVideo a;

    /* renamed from: b  reason: collision with root package name */
    public RoundRelativeLayout f36912b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36913c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36914d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f36915e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f36916f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f36917g;

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f36918h;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewUserRewardDialogView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewUserRewardDialogView newUserRewardDialogView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserRewardDialogView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newUserRewardDialogView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() || this.a.a == null) {
                return;
            }
            this.a.a.requestRender();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewUserRewardDialogView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0611, this);
            this.a = (AlphaVideo) findViewById(R.id.obfuscated_res_0x7f091560);
            this.f36912b = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f091565);
            this.f36913c = (TextView) findViewById(R.id.obfuscated_res_0x7f091566);
            this.f36914d = (TextView) findViewById(R.id.obfuscated_res_0x7f091562);
            this.f36915e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091561);
            this.f36916f = (TextView) findViewById(R.id.obfuscated_res_0x7f091563);
            this.f36917g = (TextView) findViewById(R.id.obfuscated_res_0x7f091564);
            this.a.setKeepLastFrame(true);
            MessageManager.getInstance().registerListener(this.f36918h);
            this.f36912b.setRoundLayoutRadius(c.a.o0.r.v.a.y(R.string.J_X06));
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.f36912b, R.color.CAM_X0211);
            SkinManager.setViewTextColor(this.f36913c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f36914d, (int) R.color.CAM_X0107);
            SkinManager.setImageResource(this.f36915e, R.drawable.icon_use_close_n);
            c d2 = c.d(this.f36916f);
            d2.l(R.dimen.L_X01);
            d2.k(R.color.CAM_X0902);
            d2.n(R.string.J_X01);
            d2.v(R.color.CAM_X0105);
            c d3 = c.d(this.f36917g);
            d3.l(R.dimen.L_X01);
            d3.k(R.color.CAM_X0304);
            d3.n(R.string.J_X01);
            d3.v(R.color.CAM_X0304);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.destroy();
            MessageManager.getInstance().unRegisterListener(this.f36918h);
        }
    }

    public View getNewUserDialogShareView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f36917g : (View) invokeV.objValue;
    }

    public View getNewsUserDialogLookView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36916f : (View) invokeV.objValue;
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.f36915e.setOnClickListener(onClickListener);
        }
    }

    public void setData(IconStampData iconStampData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, iconStampData) == null) || iconStampData == null) {
            return;
        }
        this.f36913c.setText(iconStampData.stampTitle);
        this.f36914d.setText(iconStampData.stampText);
        int i = iconStampData.stampType;
        if (i == 1) {
            this.a.setSourcePath(i.b("post_1_times.mp4"));
        } else if (i == 2) {
            this.a.setSourcePath(i.b("reply_1_times.mp4"));
        } else if (i == 3) {
            this.a.setSourcePath(i.b("post_7_times.mp4"));
        } else {
            this.a.setSourcePath(i.b("reply_7_times.mp4"));
        }
        this.a.play();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f36918h = new a(this, 2001011);
        b(context);
        c();
    }
}
