package com.baidu.tieba.imMessageCenter.mention.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.e.p.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class MessageCardBottomView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f50843e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f50844f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f50845g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50846h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageCardBottomView(Context context) {
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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.message_card_bottom_layout, (ViewGroup) this, true);
            this.f50843e = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
            this.f50844f = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
            this.f50845g = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
            this.f50846h = (TextView) inflate.findViewById(R.id.message_bottom_reply);
        }
    }

    public View getReplyContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50844f : (View) invokeV.objValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f50843e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f50846h, R.drawable.selector_comment_and_prise_item_text_color);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50845g, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.CAM_X0107, null);
        }
    }

    public void setData(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, str, z) == null) {
            if (!z && k.isEmpty(str)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f50844f.setVisibility(z ? 0 : 8);
            if (k.isEmpty(str)) {
                this.f50843e.setVisibility(8);
                return;
            }
            this.f50843e.setText(UtilHelper.getForumNameWithBar(str, 5, true));
            this.f50843e.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
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
}
