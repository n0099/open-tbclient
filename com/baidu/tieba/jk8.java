package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.immessagecenter.im.chat.personaltalk.InvatateAnswerSettingActivity;
import com.baidu.tieba.immessagecenter.im.chat.personaltalk.PersonalTalkSettingViewSettingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final InvatateAnswerSettingActivity a;
    public final NavigationBar b;
    public final View c;
    public final HeadImageView d;
    public final TextView e;
    public final UserIconBox f;
    public final TextView g;
    public ImageView h;
    public TbSettingTextTipView i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public RelativeLayout l;
    public View m;
    public PersonalTalkSettingViewSettingView n;

    public jk8(InvatateAnswerSettingActivity invatateAnswerSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invatateAnswerSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = invatateAnswerSettingActivity;
        invatateAnswerSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d073c);
        View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091bf7);
        this.c = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.b = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f15be));
        this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        PersonalTalkSettingViewSettingView personalTalkSettingViewSettingView = (PersonalTalkSettingViewSettingView) this.a.findViewById(R.id.obfuscated_res_0x7f09212a);
        this.n = personalTalkSettingViewSettingView;
        personalTalkSettingViewSettingView.a.setVisibility(0);
        c(r95.p().l("key_question_msg_no_remind", false));
        this.n.b.setVisibility(8);
        this.l = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0927d2);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09224a);
        this.j = tbSettingTextTipView;
        tbSettingTextTipView.setVisibility(8);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09013d);
        this.k = tbSettingTextTipView2;
        tbSettingTextTipView2.setVisibility(8);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f092249);
        this.i = tbSettingTextTipView3;
        tbSettingTextTipView3.setVisibility(8);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091c34);
        this.d = headImageView;
        headImageView.setIsRound(true);
        this.d.setGodIconWidth(R.dimen.tbds47);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091025);
        this.e = textView;
        textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0ae0));
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091023);
        this.h = imageView;
        imageView.setVisibility(8);
        this.f = (UserIconBox) this.a.findViewById(R.id.user_icon_box);
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0927b3);
        this.g = textView2;
        textView2.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0eb5));
        this.m = this.a.findViewById(R.id.obfuscated_res_0x7f09090d);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.a.getLayoutMode().k(this.c);
            this.b.onChangeSkinType(this.a.getPageContext(), i);
            this.d.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0809cb));
            s75 d = s75.d(this.e);
            d.D(R.string.F_X02);
            d.C(R.dimen.T_X04);
            d.x(R.color.CAM_X0105);
            s75 d2 = s75.d(this.g);
            d2.D(R.string.F_X01);
            d2.C(R.dimen.T_X08);
            d2.x(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        }
    }

    public void b(BdSwitchView.b bVar) {
        PersonalTalkSettingViewSettingView personalTalkSettingViewSettingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && (personalTalkSettingViewSettingView = this.n) != null) {
            personalTalkSettingViewSettingView.setSwitchStateChangeListener(bVar);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.n.a.g();
            } else {
                this.n.a.e();
            }
        }
    }
}
