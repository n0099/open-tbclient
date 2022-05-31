package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
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
import com.repackage.am;
import com.repackage.uq4;
import com.repackage.wq4;
/* loaded from: classes4.dex */
public class NewUserRewardDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlphaVideo a;
    public RoundRelativeLayout b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public final CustomMessageListener h;

    /* loaded from: classes4.dex */
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05f9, this);
            this.a = (AlphaVideo) findViewById(R.id.obfuscated_res_0x7f091537);
            this.b = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f09153c);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09153d);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091539);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091538);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f09153a);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f09153b);
            this.a.setKeepLastFrame(true);
            MessageManager.getInstance().registerListener(this.h);
            this.b.setRoundLayoutRadius(uq4.y(R.string.J_X06));
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0211);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0107);
            SkinManager.setImageResource(this.e, R.drawable.icon_use_close_n);
            wq4 d = wq4.d(this.f);
            d.l(R.dimen.L_X01);
            d.k(R.color.CAM_X0902);
            d.n(R.string.J_X01);
            d.v(R.color.CAM_X0105);
            wq4 d2 = wq4.d(this.g);
            d2.l(R.dimen.L_X01);
            d2.k(R.color.CAM_X0304);
            d2.n(R.string.J_X01);
            d2.v(R.color.CAM_X0304);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.destroy();
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public View getNewUserDialogShareView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.g : (View) invokeV.objValue;
    }

    public View getNewsUserDialogLookView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.e.setOnClickListener(onClickListener);
        }
    }

    public void setData(IconStampData iconStampData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, iconStampData) == null) || iconStampData == null) {
            return;
        }
        this.c.setText(iconStampData.stampTitle);
        this.d.setText(iconStampData.stampText);
        int i = iconStampData.stampType;
        if (i == 1) {
            this.a.setSourcePath(am.b("post_1_times.mp4"));
        } else if (i == 2) {
            this.a.setSourcePath(am.b("reply_1_times.mp4"));
        } else if (i == 3) {
            this.a.setSourcePath(am.b("post_7_times.mp4"));
        } else {
            this.a.setSourcePath(am.b("reply_7_times.mp4"));
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
        this.h = new a(this, 2001011);
        b(context);
        c();
    }
}
