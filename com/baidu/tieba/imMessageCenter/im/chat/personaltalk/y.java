package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class y {
    private final View LO;
    private final TextView aHo;
    private final HeadImageView aIq;
    private final UserIconBox aOz;
    private final TextView aYa;
    private final PersonalTalkSettingActivity bqg;
    public PersonaltalkSettingViewBlackManView bqk;
    public PersonalTalkSettingViewSettingView bql;
    private final NavigationBar mNavigationBar;

    public y(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bqg = personalTalkSettingActivity;
        this.bqg.setContentView(com.baidu.tieba.w.p2ptalk_setting_activity);
        this.LO = this.bqg.findViewById(com.baidu.tieba.v.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.LO.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bqg.getPageContext().getString(com.baidu.tieba.y.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bqk = (PersonaltalkSettingViewBlackManView) this.bqg.findViewById(com.baidu.tieba.v.black_status_view);
        this.bql = (PersonalTalkSettingViewSettingView) this.bqg.findViewById(com.baidu.tieba.v.setting_detail_view);
        this.aIq = (HeadImageView) this.bqg.findViewById(com.baidu.tieba.v.photo);
        this.aIq.setIsRound(true);
        this.aYa = (TextView) this.bqg.findViewById(com.baidu.tieba.v.name);
        this.aOz = (UserIconBox) this.bqg.findViewById(com.baidu.tieba.v.user_icon_box);
        this.aHo = (TextView) this.bqg.findViewById(com.baidu.tieba.v.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.bqg.getLayoutMode().h(this.LO);
        this.mNavigationBar.onChangeSkinType(this.bqg.getPageContext(), i);
    }

    public void c(boolean z, int i) {
        if (z) {
            this.bqk.setSex(i);
            this.bqk.setVisibility(0);
            this.bql.setVisibility(8);
            return;
        }
        this.bql.setVisibility(0);
        this.bqk.setVisibility(8);
    }

    public void dg(boolean z) {
        this.bql.dg(z);
    }

    public void e(s sVar) {
        if (sVar != null) {
            c(sVar.Un(), sVar.Um().sex.intValue());
            dg(sVar.Ul());
            a(sVar.Um());
            f(sVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 3;
        if (dataRes != null) {
            this.aYa.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.aYa.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.u.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 4;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.aYa.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.aYa.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.u.icon_pop_girl, 0);
            }
            this.aHo.setText(dataRes.intro);
            if (this.aOz != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.aOz.a(linkedList, i, this.bqg.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_width), this.bqg.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_height), this.bqg.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_margin));
            }
        }
    }

    public void f(s sVar) {
        String str;
        if (sVar != null && sVar.Um() != null && (str = sVar.Um().portrait) != null && str.length() > 0) {
            this.aIq.setImageResource(0);
            this.aIq.c(str, 12, false);
        }
    }

    public void a(com.baidu.adp.widget.BdSwitchView.b bVar) {
        if (this.bql != null) {
            this.bql.setSwitchStateChangeListener(bVar);
        }
    }
}
