package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class ShareFromFrsView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46633e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f46634f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46635g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46636h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46637i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46638j;

    /* renamed from: k  reason: collision with root package name */
    public Context f46639k;
    public ShareFromFrsMsgData l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFromFrsView(Context context, AttributeSet attributeSet) {
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
        this.f46639k = context;
        b();
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return l.cutString(str, 8) + this.f46639k.getString(R.string.forum);
        }
        return (String) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.share_from_frs_view, this);
            this.f46633e = (TextView) findViewById(R.id.frs_name);
            this.f46634f = (HeadImageView) findViewById(R.id.frs_img);
            this.f46636h = (TextView) findViewById(R.id.frs_member_num);
            this.f46638j = (TextView) findViewById(R.id.frs_post_num);
            this.f46635g = (TextView) findViewById(R.id.frs_member_num_label);
            this.f46637i = (TextView) findViewById(R.id.frs_post_num_label);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f46633e.setText(a(this.l.getName()));
            this.f46634f.setPlaceHolder(1);
            this.f46634f.setAutoChangeStyle(false);
            this.f46634f.startLoad(this.l.getImageUrl(), 10, false);
            this.f46636h.setText(StringHelper.numFormatOver10000(this.l.getMemberNum()));
            this.f46638j.setText(StringHelper.numFormatOver10000(this.l.getPostNum()));
        }
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, shareFromFrsMsgData) == null) {
            this.l = shareFromFrsMsgData;
            c();
        }
    }

    public void setIsLeft(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.f46633e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
                this.f46636h.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
                this.f46638j.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
                this.f46635g.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
                this.f46637i.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
                return;
            }
            this.f46633e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
            this.f46636h.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
            this.f46638j.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
            this.f46635g.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
            this.f46637i.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFromFrsView(Context context) {
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
        this.f46639k = context;
        b();
    }
}
