package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingViewSettingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
import tbclient.PermissionList;
/* loaded from: classes5.dex */
public class oi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PersonalTalkSettingActivity a;
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

    public oi7(PersonalTalkSettingActivity personalTalkSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalTalkSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = personalTalkSettingActivity;
        personalTalkSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d06be);
        View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091a38);
        this.c = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.b = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1401));
        this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        PersonalTalkSettingViewSettingView personalTalkSettingViewSettingView = (PersonalTalkSettingViewSettingView) this.a.findViewById(R.id.obfuscated_res_0x7f091f2d);
        this.n = personalTalkSettingViewSettingView;
        personalTalkSettingViewSettingView.b.setSwitchStateChangeListener(this.a);
        this.l = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092570);
        this.i = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09202d);
        this.j = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09202e);
        this.k = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09012d);
        this.i.setOnClickListener(this.a);
        this.j.setOnClickListener(this.a);
        this.k.setOnClickListener(this.a);
        this.l.setOnClickListener(this.a);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091a72);
        this.d = headImageView;
        headImageView.setIsRound(true);
        this.d.setGodIconWidth(R.dimen.tbds47);
        this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090ee7);
        this.h = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090ee5);
        this.f = (UserIconBox) this.a.findViewById(R.id.user_icon_box);
        this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092552);
        this.m = this.a.findViewById(R.id.obfuscated_res_0x7f090855);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(PersonalTalkSettingModel personalTalkSettingModel) {
        String nameShow;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, personalTalkSettingModel) == null) && personalTalkSettingModel != null && personalTalkSettingModel.R() != null) {
            DataRes R = personalTalkSettingModel.R();
            TextView textView = this.e;
            String str = "";
            if (StringUtils.isNull(personalTalkSettingModel.getNameShow())) {
                nameShow = R.name + "";
            } else {
                nameShow = personalTalkSettingModel.getNameShow();
            }
            textView.setText(nameShow);
            if (R.sex.intValue() == 1) {
                this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
            } else if (R.sex.intValue() == 2) {
                if (R.iconInfo.size() > 0 && R.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                    this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
                }
            } else {
                i = 9;
                if (personalTalkSettingModel.T() != null) {
                    str = ni7.a(personalTalkSettingModel.T());
                }
                if (StringUtils.isNull(str)) {
                    str = R.intro;
                }
                this.g.setText(str);
                if (this.f == null) {
                    LinkedList linkedList = new LinkedList();
                    for (IconInfo iconInfo : R.iconInfo) {
                        IconData iconData = new IconData();
                        iconData.setIconName(iconInfo.name);
                        iconData.setIcon(iconInfo.iconUrl);
                        linkedList.add(iconData);
                    }
                    this.f.g(linkedList, i, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                    return;
                }
                return;
            }
            i = 8;
            if (personalTalkSettingModel.T() != null) {
            }
            if (StringUtils.isNull(str)) {
            }
            this.g.setText(str);
            if (this.f == null) {
            }
        }
    }

    public void a(PermissionList permissionList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, permissionList) == null) && permissionList != null && this.n != null) {
            StringBuilder sb = new StringBuilder();
            if (permissionList.follow.intValue() == 1) {
                sb.append("关注、");
            }
            if (permissionList.interact.intValue() == 1) {
                sb.append("互动、");
            }
            if (permissionList.chat.intValue() == 1) {
                sb.append("私信");
                this.m.setVisibility(8);
                this.n.a.setVisibility(8);
                this.n.b.setVisibility(8);
            } else {
                this.n.a.setVisibility(0);
                this.n.b.setVisibility(0);
            }
            if (!StringUtils.isNull(sb.toString()) && sb.length() > 0) {
                sb.insert(0, "禁止");
            } else {
                sb.delete(0, sb.length());
            }
            String sb2 = sb.toString();
            if (!StringUtils.isNull(sb2) && sb2.endsWith("、")) {
                sb2 = sb2.substring(0, sb2.length() - 1);
            }
            this.k.setTip(sb2);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.n.a(z);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.n.c(z);
        }
    }

    public void f(BdSwitchView.b bVar) {
        PersonalTalkSettingViewSettingView personalTalkSettingViewSettingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) && (personalTalkSettingViewSettingView = this.n) != null) {
            personalTalkSettingViewSettingView.setSwitchStateChangeListener(bVar);
        }
    }

    public void c(PersonalTalkSettingModel personalTalkSettingModel) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, personalTalkSettingModel) == null) && personalTalkSettingModel != null && personalTalkSettingModel.R() != null && (str = personalTalkSettingModel.R().portrait) != null && str.length() > 0) {
            this.d.setImageResource(0);
            UtilHelper.showHeadImageViewBigV(this.d, personalTalkSettingModel.T());
            this.d.setTag(null);
            this.d.setPageId(this.a.getUniqueId());
            this.d.K(str, 12, false);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a.getLayoutMode().k(this.c);
            this.b.onChangeSkinType(this.a.getPageContext(), i);
            rw4 d = rw4.d(this.e);
            d.A(R.string.F_X02);
            d.z(R.dimen.T_X04);
            d.v(R.color.CAM_X0105);
            rw4 d2 = rw4.d(this.g);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X08);
            d2.v(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        }
    }

    public void h(PersonalTalkSettingModel personalTalkSettingModel) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, personalTalkSettingModel) == null) && personalTalkSettingModel != null) {
            a(personalTalkSettingModel.S());
            b(personalTalkSettingModel.isNotify());
            if (fg7.a(String.valueOf(personalTalkSettingModel.getUid())) > 0) {
                z = true;
            } else {
                z = false;
            }
            e(z);
            g(personalTalkSettingModel);
            c(personalTalkSettingModel);
        }
    }
}
