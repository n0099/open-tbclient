package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
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
/* loaded from: classes12.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f45141e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f45142f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f45143g;

    /* renamed from: h  reason: collision with root package name */
    public BarImageView f45144h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f45145i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f45146j;
    public ShareFromGameCenterMsgData k;
    public TextView shareTv;

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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.game_to_group_share_dialog, this);
            setOrientation(1);
            this.f45141e = (LinearLayout) findViewById(R.id.game_to_group_share_dialog_content);
            this.f45146j = (TextView) findViewById(R.id.share_title_view);
            this.f45142f = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
            this.f45143g = (TbImageView) findViewById(R.id.game_to_group_share_img);
            this.f45144h = (BarImageView) findViewById(R.id.game_to_group_share_icon);
            this.f45145i = (TextView) findViewById(R.id.game_to_group_share_desc);
            SkinManager.setViewTextColor(this.f45146j, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f45142f, R.color.CAM_X0105, 2);
            this.f45142f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setViewTextColor(this.f45145i, R.color.CAM_X0106, 1);
            this.f45142f.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
            TextView textView = (TextView) findViewById(R.id.game_to_group_share);
            this.shareTv = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0108, 1);
            hideEditTextCursor();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f45146j.setText(this.k.getTitle());
            this.f45143g.setTag(this.k.getImageUrl());
            this.f45143g.startLoad(this.k.getImageUrl(), 17, false);
            this.f45144h.setVisibility(0);
            this.f45144h.setTag(this.k.getShareSourceIcon());
            this.f45144h.startLoad(this.k.getShareSourceIcon(), 17, false);
            this.f45145i.setText(this.k.getContent());
            TextView textView = this.shareTv;
            textView.setText("来自" + this.k.getShareSource());
        }
    }

    public EditText getChatMsgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45142f : (EditText) invokeV.objValue;
    }

    public String getLeaveMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            EditText editText = this.f45142f;
            if (editText != null) {
                return m.charSequence2String(editText.getText(), null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void hideEditTextCursor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f45141e.setFocusable(true);
            this.f45141e.setFocusableInTouchMode(true);
            this.f45141e.requestFocus();
        }
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, shareFromGameCenterMsgData) == null) {
            this.k = shareFromGameCenterMsgData;
            b();
        }
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareFromPBMsgData) == null) {
            this.f45146j.setText(shareFromPBMsgData.getTitle());
            if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
                shareFromPBMsgData.setImageUrl("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
            }
            this.f45143g.setTag(shareFromPBMsgData.getImageUrl());
            this.f45143g.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
            this.f45144h.setVisibility(8);
            this.f45145i.setText(shareFromPBMsgData.getContent());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new LinearLayout.LayoutParams(-1, -2) : (LinearLayout.LayoutParams) invokeV.objValue;
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
        a(context);
    }
}
