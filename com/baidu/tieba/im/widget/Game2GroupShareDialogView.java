package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
/* loaded from: classes5.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f17647e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f17648f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17649g;

    /* renamed from: h  reason: collision with root package name */
    public BarImageView f17650h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17651i;
    public TextView j;
    public TextView k;
    public ShareFromGameCenterMsgData l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b(context);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17647e.setFocusable(true);
            this.f17647e.setFocusableInTouchMode(true);
            this.f17647e.requestFocus();
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.game_to_group_share_dialog, this);
            setOrientation(1);
            this.f17647e = (LinearLayout) findViewById(R.id.game_to_group_share_dialog_content);
            this.j = (TextView) findViewById(R.id.share_title_view);
            this.f17648f = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
            this.f17649g = (TbImageView) findViewById(R.id.game_to_group_share_img);
            this.f17650h = (BarImageView) findViewById(R.id.game_to_group_share_icon);
            this.f17651i = (TextView) findViewById(R.id.game_to_group_share_desc);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f17648f, R.color.CAM_X0105, 2);
            this.f17648f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setViewTextColor(this.f17651i, R.color.CAM_X0106, 1);
            this.f17648f.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
            TextView textView = (TextView) findViewById(R.id.game_to_group_share);
            this.k = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0108, 1);
            a();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j.setText(this.l.getTitle());
            this.f17649g.setTag(this.l.getImageUrl());
            this.f17649g.M(this.l.getImageUrl(), 17, false);
            this.f17650h.setVisibility(0);
            this.f17650h.setTag(this.l.getShareSourceIcon());
            this.f17650h.M(this.l.getShareSourceIcon(), 17, false);
            this.f17651i.setText(this.l.getContent());
            TextView textView = this.k;
            textView.setText("来自" + this.l.getShareSource());
        }
    }

    public EditText getChatMsgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f17648f : (EditText) invokeV.objValue;
    }

    public String getLeaveMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            EditText editText = this.f17648f;
            if (editText != null) {
                return k.charSequence2String(editText.getText(), null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, shareFromGameCenterMsgData) == null) {
            this.l = shareFromGameCenterMsgData;
            c();
        }
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareFromPBMsgData) == null) {
            this.j.setText(shareFromPBMsgData.getTitle());
            if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
                shareFromPBMsgData.setImageUrl("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
            }
            this.f17649g.setTag(shareFromPBMsgData.getImageUrl());
            this.f17649g.M(shareFromPBMsgData.getImageUrl(), 17, false);
            this.f17650h.setVisibility(8);
            this.f17651i.setText(shareFromPBMsgData.getContent());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new LinearLayout.LayoutParams(-1, -2) : (LinearLayout.LayoutParams) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Game2GroupShareDialogView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(context);
    }
}
