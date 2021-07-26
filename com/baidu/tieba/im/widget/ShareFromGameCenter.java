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
import d.a.d.e.p.l;
import d.a.q0.h3.n0.b;
/* loaded from: classes4.dex */
public class ShareFromGameCenter extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17752e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17753f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f17754g;

    /* renamed from: h  reason: collision with root package name */
    public Button f17755h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f17756i;
    public LinearLayout j;
    public LinearLayout k;
    public LinearLayout l;
    public TextView m;
    public ShareFromGameCenterMsgData n;
    public Context o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFromGameCenter(Context context, AttributeSet attributeSet) {
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
        this.o = context;
        a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.share_from_game_center_pic_and_word, this);
            setOrientation(1);
            this.j = (LinearLayout) findViewById(R.id.share_info_layout);
            this.l = (LinearLayout) findViewById(R.id.game_share_content);
            this.k = (LinearLayout) findViewById(R.id.small_tail);
            this.f17752e = (TextView) findViewById(R.id.game_title);
            this.f17753f = (TextView) findViewById(R.id.game_desc);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.game_img);
            this.f17754g = headImageView;
            headImageView.setDefaultResource(R.drawable.pic_avatar_ba_140);
            this.f17754g.setAutoChangeStyle(false);
            this.f17755h = (Button) findViewById(R.id.accept_invite_button);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.tail_icon);
            this.f17756i = tbImageView;
            tbImageView.setDefaultResource(R.drawable.tb_launcher_icon);
            this.f17756i.setAutoChangeStyle(false);
            this.m = (TextView) findViewById(R.id.tail_game_from);
        }
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.j.setBackgroundDrawable(this.o.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
                this.f17752e.setTextColor(this.o.getResources().getColor(R.color.CAM_X0111));
                this.f17753f.setTextColor(this.o.getResources().getColor(R.color.CAM_X0111));
            } else {
                this.f17752e.setTextColor(this.o.getResources().getColor(R.color.CAM_X0105));
                this.f17753f.setTextColor(this.o.getResources().getColor(R.color.CAM_X0106));
                this.j.setBackgroundDrawable(this.o.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(l.g(getContext(), R.dimen.ds14), 0, 0, 0);
                layoutParams.height = l.g(getContext(), R.dimen.ds48);
                this.k.setLayoutParams(layoutParams);
            }
            this.f17752e.setText(this.n.getTitle());
            this.f17754g.setDefaultResource(R.drawable.pic_avatar_ba_140);
            this.f17754g.setAutoChangeStyle(false);
            this.f17754g.M(this.n.getImageUrl(), 10, false);
            this.f17753f.setText(this.n.getContent());
            this.f17755h.setTextColor(this.o.getResources().getColor(R.color.CAM_X0105));
            this.f17755h.setBackgroundResource(R.drawable.btn_appdownload);
            if (!TextUtils.isEmpty(this.n.getButton())) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds60));
                int g2 = l.g(getContext(), R.dimen.ds30);
                layoutParams2.setMargins(g2, l.g(getContext(), R.dimen.ds18), g2, g2);
                this.f17755h.setLayoutParams(layoutParams2);
                this.f17755h.setVisibility(0);
                this.f17755h.setText(this.n.getButton());
            } else {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                int g3 = l.g(getContext(), R.dimen.ds30);
                layoutParams3.setMargins(g3, l.g(getContext(), R.dimen.ds20), g3, g3);
                this.f17755h.setVisibility(8);
                this.l.setLayoutParams(layoutParams3);
            }
            if (TextUtils.isEmpty(this.n.getShareSource())) {
                this.k.setVisibility(8);
            }
            this.m.setText(this.n.getShareSource());
            this.f17756i.setDefaultResource(R.drawable.tb_launcher_icon);
            this.f17756i.setAutoChangeStyle(false);
            this.f17756i.M(this.n.getShareSourceIcon(), 10, false);
            TiebaStatic.eventStat(this.o, "game_show", "show", 1, "dev_id", b.a(this.n.getShareSourceUrl()), "ref_id", GameCenterCoreUtils.REF_TYPE_IM);
        }
    }

    public LinearLayout getContentBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (LinearLayout) invokeV.objValue;
    }

    public LinearLayout getTail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (LinearLayout) invokeV.objValue;
    }

    public ImageView getTiebaIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f17756i : (ImageView) invokeV.objValue;
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, shareFromGameCenterMsgData, z) == null) || shareFromGameCenterMsgData == null) {
            return;
        }
        this.n = shareFromGameCenterMsgData;
        b(z);
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbImageView) == null) {
            this.f17756i = tbImageView;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = context;
        a();
    }
}
