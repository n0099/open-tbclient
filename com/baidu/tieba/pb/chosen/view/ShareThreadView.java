package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class ShareThreadView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f52123e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f52124f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f52125g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52126h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f52127i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareThreadView(Context context, AttributeSet attributeSet) {
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
            LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
            setOrientation(1);
            this.f52123e = (LinearLayout) findViewById(R.id.share_content);
            TextView textView = (TextView) findViewById(R.id.share_title_view);
            this.f52127i = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
            this.f52124f = (EditText) findViewById(R.id.chat_msg);
            this.f52125g = (TbImageView) findViewById(R.id.chat_group_img);
            this.f52126h = (TextView) findViewById(R.id.chat_group_desc);
            SkinManager.setViewTextColor(this.f52124f, R.color.CAM_X0105, 2);
            SkinManager.setViewTextColor(this.f52126h, R.color.CAM_X0106, 1);
            this.f52124f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.f52124f.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
            hideEditTextCursor();
        }
    }

    public EditText getChatMsgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f52124f : (EditText) invokeV.objValue;
    }

    public String getLeaveMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            EditText editText = this.f52124f;
            if (editText != null) {
                return k.charSequence2String(editText.getText(), null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void hideEditTextCursor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f52123e.setFocusable(true);
            this.f52123e.setFocusableInTouchMode(true);
            this.f52123e.requestFocus();
        }
    }

    public void loadImageIcon(String str, boolean z) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) || (tbImageView = this.f52125g) == null) {
            return;
        }
        tbImageView.startLoad(str, z ? 17 : 18, false);
    }

    public void setDesc(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (textView = this.f52126h) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setTitle(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (textView = this.f52127i) == null) {
            return;
        }
        textView.setText(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new LinearLayout.LayoutParams(-1, -2) : (LinearLayout.LayoutParams) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareThreadView(Context context) {
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
