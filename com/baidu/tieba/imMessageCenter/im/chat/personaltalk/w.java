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
import com.baidu.tieba.t;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class w {
    private final View Dn;
    private final TextView bct;
    private final HeadImageView bfG;
    private final UserIconBox bvy;
    private final TextView cao;
    private final PersonalTalkSettingActivity cud;
    private TbSettingTextTipView cuh;
    private TbSettingTextTipView cui;
    private RelativeLayout cuj;
    private LinearLayout cuk;
    public PersonaltalkSettingViewBlackManView cul;
    public PersonalTalkSettingViewSettingView cum;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.cud = personalTalkSettingActivity;
        this.cud.setContentView(t.h.p2ptalk_setting_activity);
        this.Dn = this.cud.findViewById(t.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.Dn.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cud.getPageContext().getString(t.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cul = (PersonaltalkSettingViewBlackManView) this.cud.findViewById(t.g.black_status_view);
        this.cum = (PersonalTalkSettingViewSettingView) this.cud.findViewById(t.g.setting_detail_view);
        this.cuk = (LinearLayout) this.cud.findViewById(t.g.user_info_lin);
        this.cuh = (TbSettingTextTipView) this.cud.findViewById(t.g.st_delete_talk_history);
        this.cui = (TbSettingTextTipView) this.cud.findViewById(t.g.add_to_black);
        this.cuj = (RelativeLayout) this.cud.findViewById(t.g.remove_from_black_man);
        this.cuh.setOnClickListener(this.cud);
        this.cui.setOnClickListener(this.cud);
        this.cuj.setOnClickListener(this.cud);
        this.cuk.setOnClickListener(this.cud);
        this.bfG = (HeadImageView) this.cud.findViewById(t.g.photo);
        this.bfG.setIsRound(true);
        this.cao = (TextView) this.cud.findViewById(t.g.name);
        this.bvy = (UserIconBox) this.cud.findViewById(t.g.user_icon_box);
        this.bct = (TextView) this.cud.findViewById(t.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.cud.getLayoutMode().x(this.Dn);
        this.mNavigationBar.onChangeSkinType(this.cud.getPageContext(), i);
    }

    public void f(boolean z, int i) {
        if (z) {
            this.cul.setSex(i);
            this.cul.setVisibility(0);
            this.cum.setVisibility(8);
            return;
        }
        this.cum.setVisibility(0);
        this.cul.setVisibility(8);
    }

    public void fc(boolean z) {
        this.cum.fc(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            f(rVar.ajn(), rVar.ajm().sex.intValue());
            fc(rVar.ajl());
            a(rVar.ajm());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.cao.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.cao.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.cao.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.cao.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_pop_girl, 0);
            }
            this.bct.setText(dataRes.intro);
            if (this.bvy != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bvy.a(linkedList, i, this.cud.getResources().getDimensionPixelSize(t.e.person_icon_width), this.cud.getResources().getDimensionPixelSize(t.e.person_icon_height), this.cud.getResources().getDimensionPixelSize(t.e.person_icon_margin));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.ajm() != null && (str = rVar.ajm().portrait) != null && str.length() > 0) {
            this.bfG.setImageResource(0);
            this.bfG.c(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.cum != null) {
            this.cum.setSwitchStateChangeListener(aVar);
        }
    }
}
