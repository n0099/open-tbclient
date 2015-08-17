package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.i;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class w {
    private final View LR;
    private final TextView aQY;
    private final HeadImageView aTO;
    private final PersonalTalkSettingActivity bGE;
    private TbSettingTextTipView bGI;
    private TbSettingTextTipView bGJ;
    private RelativeLayout bGK;
    private LinearLayout bGL;
    public PersonaltalkSettingViewBlackManView bGM;
    public PersonalTalkSettingViewSettingView bGN;
    private final UserIconBox bco;
    private final TextView boD;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bGE = personalTalkSettingActivity;
        this.bGE.setContentView(i.g.p2ptalk_setting_activity);
        this.LR = this.bGE.findViewById(i.f.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.LR.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bGE.getPageContext().getString(i.C0057i.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bGM = (PersonaltalkSettingViewBlackManView) this.bGE.findViewById(i.f.black_status_view);
        this.bGN = (PersonalTalkSettingViewSettingView) this.bGE.findViewById(i.f.setting_detail_view);
        this.bGL = (LinearLayout) this.bGE.findViewById(i.f.user_info_lin);
        this.bGI = (TbSettingTextTipView) this.bGE.findViewById(i.f.st_delete_talk_history);
        this.bGJ = (TbSettingTextTipView) this.bGE.findViewById(i.f.add_to_black);
        this.bGK = (RelativeLayout) this.bGE.findViewById(i.f.remove_from_black_man);
        this.bGI.setOnClickListener(this.bGE);
        this.bGJ.setOnClickListener(this.bGE);
        this.bGK.setOnClickListener(this.bGE);
        this.bGL.setOnClickListener(this.bGE);
        this.aTO = (HeadImageView) this.bGE.findViewById(i.f.photo);
        this.aTO.setIsRound(true);
        this.boD = (TextView) this.bGE.findViewById(i.f.name);
        this.bco = (UserIconBox) this.bGE.findViewById(i.f.user_icon_box);
        this.aQY = (TextView) this.bGE.findViewById(i.f.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.bGE.getLayoutMode().k(this.LR);
        this.mNavigationBar.onChangeSkinType(this.bGE.getPageContext(), i);
    }

    public void b(boolean z, int i) {
        if (z) {
            this.bGM.setSex(i);
            this.bGM.setVisibility(0);
            this.bGN.setVisibility(8);
            return;
        }
        this.bGN.setVisibility(0);
        this.bGM.setVisibility(8);
    }

    public void dv(boolean z) {
        this.bGN.dv(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            b(rVar.Xm(), rVar.Xl().sex.intValue());
            dv(rVar.Xk());
            a(rVar.Xl());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.boD.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.boD.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.boD.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.boD.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_pop_girl, 0);
            }
            this.aQY.setText(dataRes.intro);
            if (this.bco != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bco.a(linkedList, i, this.bGE.getResources().getDimensionPixelSize(i.d.person_icon_width), this.bGE.getResources().getDimensionPixelSize(i.d.person_icon_height), this.bGE.getResources().getDimensionPixelSize(i.d.person_icon_margin));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.Xl() != null && (str = rVar.Xl().portrait) != null && str.length() > 0) {
            this.aTO.setImageResource(0);
            this.aTO.d(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.bGN != null) {
            this.bGN.setSwitchStateChangeListener(aVar);
        }
    }
}
