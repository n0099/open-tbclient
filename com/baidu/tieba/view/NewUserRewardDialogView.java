package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.e.e.p.l;
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
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class NewUserRewardDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AlphaVideo f57888e;

    /* renamed from: f  reason: collision with root package name */
    public RoundRelativeLayout f57889f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57890g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57891h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f57892i;

    /* renamed from: j  reason: collision with root package name */
    public final CustomMessageListener f57893j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewUserRewardDialogView f57894a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewUserRewardDialogView newUserRewardDialogView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserRewardDialogView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57894a = newUserRewardDialogView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() || this.f57894a.f57888e == null) {
                return;
            }
            this.f57894a.f57888e.requestRender();
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

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.new_user_reward_dialog_layout, this);
            this.f57888e = (AlphaVideo) findViewById(R.id.new_user_anim);
            this.f57889f = (RoundRelativeLayout) findViewById(R.id.new_user_dialog_text_area);
            this.f57890g = (TextView) findViewById(R.id.new_user_dialog_title);
            this.f57891h = (TextView) findViewById(R.id.new_user_dialog_desc);
            this.f57892i = (ImageView) findViewById(R.id.new_user_dialog_close);
            this.f57889f.setAllCornerRound(l.g(context, R.dimen.tbds31));
            this.f57888e.setKeepLastFrame(true);
            MessageManager.getInstance().registerListener(this.f57893j);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.f57889f, R.color.CAM_X0211);
            SkinManager.setViewTextColor(this.f57890g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f57891h, R.color.CAM_X0107);
            SkinManager.setImageResource(this.f57892i, R.drawable.icon_use_close_n);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f57888e.destroy();
            MessageManager.getInstance().unRegisterListener(this.f57893j);
        }
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f57892i.setOnClickListener(onClickListener);
        }
    }

    public void setData(IconStampData iconStampData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iconStampData) == null) || iconStampData == null) {
            return;
        }
        this.f57890g.setText(iconStampData.stampTitle);
        this.f57891h.setText(iconStampData.stampText);
        int i2 = iconStampData.stampType;
        if (i2 == 1) {
            this.f57888e.setSourceAssets("post_1_times.mp4");
        } else if (i2 == 2) {
            this.f57888e.setSourceAssets("reply_1_times.mp4");
        } else if (i2 == 3) {
            this.f57888e.setSourceAssets("post_7_times.mp4");
        } else {
            this.f57888e.setSourceAssets("reply_7_times.mp4");
        }
        this.f57888e.play();
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
    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f57893j = new a(this, 2001011);
        b(context);
        onChangeSkinType();
    }
}
