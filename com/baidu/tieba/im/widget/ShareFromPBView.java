package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public final class ShareFromPBView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f45159e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f45160f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45161g;

    /* renamed from: h  reason: collision with root package name */
    public ShareFromPBMsgData f45162h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFromPBView(Context context, AttributeSet attributeSet) {
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.share_from_pb_view, this);
            setOrientation(1);
            this.f45159e = (TextView) findViewById(R.id.chat_title);
            this.f45160f = (HeadImageView) findViewById(R.id.chat_group_img);
            this.f45161g = (TextView) findViewById(R.id.chat_group_desc);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f45159e.setText(this.f45162h.getTitle());
            this.f45160f.setPlaceHolder(1);
            this.f45160f.setAutoChangeStyle(false);
            this.f45160f.startLoad(this.f45162h.getImageUrl(), 10, false);
            this.f45161g.setText(this.f45162h.getContent());
        }
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareFromPBMsgData) == null) {
            this.f45162h = shareFromPBMsgData;
            b();
        }
    }

    public void setIsLeft(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f45159e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
                this.f45161g.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
                return;
            }
            this.f45159e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
            this.f45161g.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFromPBView(Context context) {
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
        a();
    }
}
