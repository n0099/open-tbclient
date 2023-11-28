package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.qxa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
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
            LayoutInflater.from(getContext()).inflate(R.layout.share_from_game_center_pic_and_word, this);
            setOrientation(1);
            this.f = (LinearLayout) findViewById(R.id.share_info_layout);
            this.h = (LinearLayout) findViewById(R.id.game_share_content);
            this.g = (LinearLayout) findViewById(R.id.small_tail);
            this.a = (TextView) findViewById(R.id.game_title);
            this.b = (TextView) findViewById(R.id.game_desc);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.game_img);
            this.c = headImageView;
            headImageView.setDefaultResource(R.drawable.pic_avatar_ba_140);
            this.c.setAutoChangeStyle(false);
            this.d = (Button) findViewById(R.id.accept_invite_button);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.tail_icon);
            this.e = tbImageView;
            tbImageView.setDefaultResource(R.drawable.tb_launcher_icon);
            this.e.setAutoChangeStyle(false);
            this.i = (TextView) findViewById(R.id.tail_game_from);
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
                layoutParams.setMargins(BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701b2), 0, 0, 0);
                layoutParams.height = BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0703e5);
                this.g.setLayoutParams(layoutParams);
            }
            this.a.setText(this.j.getTitle());
            this.c.setDefaultResource(R.drawable.pic_avatar_ba_140);
            this.c.setAutoChangeStyle(false);
            this.c.startLoad(this.j.getImageUrl(), 10, false);
            this.b.setText(this.j.getContent());
            this.d.setTextColor(this.k.getResources().getColor(R.color.CAM_X0105));
            this.d.setBackgroundResource(R.drawable.btn_appdownload);
            if (!TextUtils.isEmpty(this.j.getButton())) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f070253));
                int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f070201);
                layoutParams2.setMargins(dimens, BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f070385), dimens, dimens);
                this.d.setLayoutParams(layoutParams2);
                this.d.setVisibility(0);
                this.d.setText(this.j.getButton());
            } else {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f070201);
                layoutParams3.setMargins(dimens2, BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701d5), dimens2, dimens2);
                this.d.setVisibility(8);
                this.h.setLayoutParams(layoutParams3);
            }
            if (TextUtils.isEmpty(this.j.getShareSource())) {
                this.g.setVisibility(8);
            }
            this.i.setText(this.j.getShareSource());
            this.e.setDefaultResource(R.drawable.tb_launcher_icon);
            this.e.setAutoChangeStyle(false);
            this.e.startLoad(this.j.getShareSourceIcon(), 10, false);
            TiebaStatic.eventStat(this.k, "game_show", "show", 1, "dev_id", qxa.a(this.j.getShareSourceUrl()), "ref_id", GameCenterCoreUtils.REF_TYPE_IM);
        }
    }

    public LinearLayout getContentBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public LinearLayout getTail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public ImageView getTiebaIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (ImageView) invokeV.objValue;
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048581, this, shareFromGameCenterMsgData, z) != null) || shareFromGameCenterMsgData == null) {
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
}
