package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.repackage.bm8;
import com.repackage.qi;
/* loaded from: classes3.dex */
public class ShareFromGameCenter extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public HeadImageView c;
    public Button d;
    public TbImageView e;
    public LinearLayout f;
    public LinearLayout g;
    public LinearLayout h;
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07a3, this);
            setOrientation(1);
            this.f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091e36);
            this.h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090c5b);
            this.g = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091eb3);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090c60);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090c4e);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f090c4f);
            this.c = headImageView;
            headImageView.setDefaultResource(R.drawable.pic_avatar_ba_140);
            this.c.setAutoChangeStyle(false);
            this.d = (Button) findViewById(R.id.obfuscated_res_0x7f09002f);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092063);
            this.e = tbImageView;
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081833);
            this.e.setAutoChangeStyle(false);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f092062);
        }
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.f.setBackgroundDrawable(this.k.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
                this.a.setTextColor(this.k.getResources().getColor(R.color.CAM_X0111));
                this.b.setTextColor(this.k.getResources().getColor(R.color.CAM_X0111));
            } else {
                this.a.setTextColor(this.k.getResources().getColor(R.color.CAM_X0105));
                this.b.setTextColor(this.k.getResources().getColor(R.color.CAM_X0106));
                this.f.setBackgroundDrawable(this.k.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(qi.f(getContext(), R.dimen.obfuscated_res_0x7f0701b2), 0, 0, 0);
                layoutParams.height = qi.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb);
                this.g.setLayoutParams(layoutParams);
            }
            this.a.setText(this.j.getTitle());
            this.c.setDefaultResource(R.drawable.pic_avatar_ba_140);
            this.c.setAutoChangeStyle(false);
            this.c.K(this.j.getImageUrl(), 10, false);
            this.b.setText(this.j.getContent());
            this.d.setTextColor(this.k.getResources().getColor(R.color.CAM_X0105));
            this.d.setBackgroundResource(R.drawable.btn_appdownload);
            if (!TextUtils.isEmpty(this.j.getButton())) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, qi.f(getContext(), R.dimen.obfuscated_res_0x7f070253));
                int f = qi.f(getContext(), R.dimen.obfuscated_res_0x7f070201);
                layoutParams2.setMargins(f, qi.f(getContext(), R.dimen.obfuscated_res_0x7f07025f), f, f);
                this.d.setLayoutParams(layoutParams2);
                this.d.setVisibility(0);
                this.d.setText(this.j.getButton());
            } else {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                int f2 = qi.f(getContext(), R.dimen.obfuscated_res_0x7f070201);
                layoutParams3.setMargins(f2, qi.f(getContext(), R.dimen.obfuscated_res_0x7f0701d5), f2, f2);
                this.d.setVisibility(8);
                this.h.setLayoutParams(layoutParams3);
            }
            if (TextUtils.isEmpty(this.j.getShareSource())) {
                this.g.setVisibility(8);
            }
            this.i.setText(this.j.getShareSource());
            this.e.setDefaultResource(R.drawable.obfuscated_res_0x7f081833);
            this.e.setAutoChangeStyle(false);
            this.e.K(this.j.getShareSourceIcon(), 10, false);
            TiebaStatic.eventStat(this.k, "game_show", "show", 1, "dev_id", bm8.a(this.j.getShareSourceUrl()), "ref_id", GameCenterCoreUtils.REF_TYPE_IM);
        }
    }

    public LinearLayout getContentBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (LinearLayout) invokeV.objValue;
    }

    public LinearLayout getTail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.g : (LinearLayout) invokeV.objValue;
    }

    public ImageView getTiebaIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (ImageView) invokeV.objValue;
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
            this.e = tbImageView;
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
