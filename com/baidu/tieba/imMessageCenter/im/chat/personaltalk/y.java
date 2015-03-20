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
    private final View LM;
    private final TextView aHg;
    private final HeadImageView aIi;
    private final UserIconBox aOi;
    private final TextView aXK;
    private final PersonalTalkSettingActivity bpQ;
    public PersonaltalkSettingViewBlackManView bpU;
    public PersonalTalkSettingViewSettingView bpV;
    private final NavigationBar mNavigationBar;

    public y(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bpQ = personalTalkSettingActivity;
        this.bpQ.setContentView(com.baidu.tieba.w.p2ptalk_setting_activity);
        this.LM = this.bpQ.findViewById(com.baidu.tieba.v.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.LM.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bpQ.getPageContext().getString(com.baidu.tieba.y.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bpU = (PersonaltalkSettingViewBlackManView) this.bpQ.findViewById(com.baidu.tieba.v.black_status_view);
        this.bpV = (PersonalTalkSettingViewSettingView) this.bpQ.findViewById(com.baidu.tieba.v.setting_detail_view);
        this.aIi = (HeadImageView) this.bpQ.findViewById(com.baidu.tieba.v.photo);
        this.aIi.setIsRound(true);
        this.aXK = (TextView) this.bpQ.findViewById(com.baidu.tieba.v.name);
        this.aOi = (UserIconBox) this.bpQ.findViewById(com.baidu.tieba.v.user_icon_box);
        this.aHg = (TextView) this.bpQ.findViewById(com.baidu.tieba.v.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.bpQ.getLayoutMode().h(this.LM);
        this.mNavigationBar.onChangeSkinType(this.bpQ.getPageContext(), i);
    }

    public void c(boolean z, int i) {
        if (z) {
            this.bpU.setSex(i);
            this.bpU.setVisibility(0);
            this.bpV.setVisibility(8);
            return;
        }
        this.bpV.setVisibility(0);
        this.bpU.setVisibility(8);
    }

    public void di(boolean z) {
        this.bpV.di(z);
    }

    public void e(s sVar) {
        if (sVar != null) {
            c(sVar.Ua(), sVar.TZ().sex.intValue());
            di(sVar.TY());
            a(sVar.TZ());
            f(sVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 3;
        if (dataRes != null) {
            this.aXK.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.aXK.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.u.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 4;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.aXK.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.aXK.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.u.icon_pop_girl, 0);
            }
            this.aHg.setText(dataRes.intro);
            if (this.aOi != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.aOi.a(linkedList, i, this.bpQ.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_width), this.bpQ.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_height), this.bpQ.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_margin));
            }
        }
    }

    public void f(s sVar) {
        String str;
        if (sVar != null && sVar.TZ() != null && (str = sVar.TZ().portrait) != null && str.length() > 0) {
            this.aIi.setImageResource(0);
            this.aIi.c(str, 12, false);
        }
    }

    public void a(com.baidu.adp.widget.BdSwitchView.b bVar) {
        if (this.bpV != null) {
            this.bpV.setSwitchStateChangeListener(bVar);
        }
    }
}
