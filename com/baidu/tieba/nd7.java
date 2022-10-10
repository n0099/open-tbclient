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
public class nd7 {
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

    public nd7(PersonalTalkSettingActivity personalTalkSettingActivity) {
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
        personalTalkSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d0697);
        View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091989);
        this.c = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.obfuscated_res_0x7f0925c5);
        this.b = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f138e));
        this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        PersonalTalkSettingViewSettingView personalTalkSettingViewSettingView = (PersonalTalkSettingViewSettingView) this.a.findViewById(R.id.obfuscated_res_0x7f091e6d);
        this.n = personalTalkSettingViewSettingView;
        personalTalkSettingViewSettingView.b.setSwitchStateChangeListener(this.a);
        this.l = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0924af);
        this.i = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091f67);
        this.j = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091f68);
        this.k = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090125);
        this.i.setOnClickListener(this.a);
        this.j.setOnClickListener(this.a);
        this.k.setOnClickListener(this.a);
        this.l.setOnClickListener(this.a);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0919be);
        this.d = headImageView;
        headImageView.setIsRound(true);
        this.d.setGodIconWidth(R.dimen.tbds47);
        this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090e6f);
        this.h = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090e6d);
        this.f = (UserIconBox) this.a.findViewById(R.id.obfuscated_res_0x7f0924a8);
        this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092491);
        this.m = this.a.findViewById(R.id.obfuscated_res_0x7f090821);
    }

    public void a(PermissionList permissionList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, permissionList) == null) || permissionList == null || this.n == null) {
            return;
        }
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

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.n.a(z);
        }
    }

    public void c(PersonalTalkSettingModel personalTalkSettingModel) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, personalTalkSettingModel) == null) || personalTalkSettingModel == null || personalTalkSettingModel.K() == null || (str = personalTalkSettingModel.K().portrait) == null || str.length() <= 0) {
            return;
        }
        this.d.setImageResource(0);
        UtilHelper.showHeadImageViewBigV(this.d, personalTalkSettingModel.M());
        this.d.setTag(null);
        this.d.setPageId(this.a.getUniqueId());
        this.d.K(str, 12, false);
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a.getLayoutMode().k(this.c);
            this.b.onChangeSkinType(this.a.getPageContext(), i);
            hv4 d = hv4.d(this.e);
            d.A(R.string.F_X02);
            d.z(R.dimen.T_X04);
            d.v(R.color.CAM_X0105);
            hv4 d2 = hv4.d(this.g);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X08);
            d2.v(R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
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
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || (personalTalkSettingViewSettingView = this.n) == null) {
            return;
        }
        personalTalkSettingViewSettingView.setSwitchStateChangeListener(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(PersonalTalkSettingModel personalTalkSettingModel) {
        int i;
        String a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, personalTalkSettingModel) == null) || personalTalkSettingModel == null || personalTalkSettingModel.K() == null) {
            return;
        }
        DataRes K = personalTalkSettingModel.K();
        this.e.setText(StringUtils.isNull(personalTalkSettingModel.getNameShow()) ? K.name + "" : personalTalkSettingModel.getNameShow());
        if (K.sex.intValue() == 1) {
            this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
        } else if (K.sex.intValue() == 2) {
            if (K.iconInfo.size() > 0 && K.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
            }
        } else {
            i = 9;
            a = personalTalkSettingModel.M() != null ? md7.a(personalTalkSettingModel.M()) : "";
            if (StringUtils.isNull(a)) {
                a = K.intro;
            }
            this.g.setText(a);
            if (this.f == null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : K.iconInfo) {
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
        if (personalTalkSettingModel.M() != null) {
        }
        if (StringUtils.isNull(a)) {
        }
        this.g.setText(a);
        if (this.f == null) {
        }
    }

    public void h(PersonalTalkSettingModel personalTalkSettingModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, personalTalkSettingModel) == null) || personalTalkSettingModel == null) {
            return;
        }
        a(personalTalkSettingModel.L());
        b(personalTalkSettingModel.N());
        e(uc7.a(String.valueOf(personalTalkSettingModel.getUid())) > 0);
        g(personalTalkSettingModel);
        c(personalTalkSettingModel);
    }
}
