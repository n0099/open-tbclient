package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.a4.q0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ShareFromGameCenter extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f33914b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f33915c;

    /* renamed from: d  reason: collision with root package name */
    public Button f33916d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f33917e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f33918f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f33919g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f33920h;
    public TextView i;
    public ShareFromGameCenterMsgData j;
    public Context k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFromGameCenter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = context;
        a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0772, this);
            setOrientation(1);
            this.f33918f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091cc0);
            this.f33920h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090c4d);
            this.f33919g = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091d33);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090c6e);
            this.f33914b = (TextView) findViewById(R.id.obfuscated_res_0x7f090c3d);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f090c3e);
            this.f33915c = headImageView;
            headImageView.setDefaultResource(R.drawable.pic_avatar_ba_140);
            this.f33915c.setAutoChangeStyle(false);
            this.f33916d = (Button) findViewById(R.id.obfuscated_res_0x7f09002a);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091edd);
            this.f33917e = tbImageView;
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081833);
            this.f33917e.setAutoChangeStyle(false);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091edc);
        }
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.f33918f.setBackgroundDrawable(this.k.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
                this.a.setTextColor(this.k.getResources().getColor(R.color.CAM_X0111));
                this.f33914b.setTextColor(this.k.getResources().getColor(R.color.CAM_X0111));
            } else {
                this.a.setTextColor(this.k.getResources().getColor(R.color.CAM_X0105));
                this.f33914b.setTextColor(this.k.getResources().getColor(R.color.CAM_X0106));
                this.f33918f.setBackgroundDrawable(this.k.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(n.f(getContext(), R.dimen.obfuscated_res_0x7f0701b2), 0, 0, 0);
                layoutParams.height = n.f(getContext(), R.dimen.obfuscated_res_0x7f0702c4);
                this.f33919g.setLayoutParams(layoutParams);
            }
            this.a.setText(this.j.getTitle());
            this.f33915c.setDefaultResource(R.drawable.pic_avatar_ba_140);
            this.f33915c.setAutoChangeStyle(false);
            this.f33915c.J(this.j.getImageUrl(), 10, false);
            this.f33914b.setText(this.j.getContent());
            this.f33916d.setTextColor(this.k.getResources().getColor(R.color.CAM_X0105));
            this.f33916d.setBackgroundResource(R.drawable.btn_appdownload);
            if (!TextUtils.isEmpty(this.j.getButton())) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, n.f(getContext(), R.dimen.obfuscated_res_0x7f070253));
                int f2 = n.f(getContext(), R.dimen.obfuscated_res_0x7f070201);
                layoutParams2.setMargins(f2, n.f(getContext(), R.dimen.obfuscated_res_0x7f070257), f2, f2);
                this.f33916d.setLayoutParams(layoutParams2);
                this.f33916d.setVisibility(0);
                this.f33916d.setText(this.j.getButton());
            } else {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                int f3 = n.f(getContext(), R.dimen.obfuscated_res_0x7f070201);
                layoutParams3.setMargins(f3, n.f(getContext(), R.dimen.obfuscated_res_0x7f0701d5), f3, f3);
                this.f33916d.setVisibility(8);
                this.f33920h.setLayoutParams(layoutParams3);
            }
            if (TextUtils.isEmpty(this.j.getShareSource())) {
                this.f33919g.setVisibility(8);
            }
            this.i.setText(this.j.getShareSource());
            this.f33917e.setDefaultResource(R.drawable.obfuscated_res_0x7f081833);
            this.f33917e.setAutoChangeStyle(false);
            this.f33917e.J(this.j.getShareSourceIcon(), 10, false);
            TiebaStatic.eventStat(this.k, "game_show", "show", 1, "dev_id", b.a(this.j.getShareSourceUrl()), "ref_id", GameCenterCoreUtils.REF_TYPE_IM);
        }
    }

    public LinearLayout getContentBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33918f : (LinearLayout) invokeV.objValue;
    }

    public LinearLayout getTail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33919g : (LinearLayout) invokeV.objValue;
    }

    public ImageView getTiebaIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33917e : (ImageView) invokeV.objValue;
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, shareFromGameCenterMsgData, z) == null) || shareFromGameCenterMsgData == null) {
            return;
        }
        this.j = shareFromGameCenterMsgData;
        b(z);
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbImageView) == null) {
            this.f33917e = tbImageView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFromGameCenter(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = context;
        a();
    }
}
