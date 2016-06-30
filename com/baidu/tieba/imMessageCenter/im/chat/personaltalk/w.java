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
import com.baidu.tieba.u;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class w {
    private final View Do;
    private final HeadImageView bBS;
    private final UserIconBox bTj;
    private final TextView byo;
    private final TextView cFy;
    public PersonaltalkSettingViewBlackManView cZA;
    public PersonalTalkSettingViewSettingView cZB;
    private final PersonalTalkSettingActivity cZs;
    private TbSettingTextTipView cZw;
    private TbSettingTextTipView cZx;
    private RelativeLayout cZy;
    private LinearLayout cZz;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.cZs = personalTalkSettingActivity;
        this.cZs.setContentView(u.h.p2ptalk_setting_activity);
        this.Do = this.cZs.findViewById(u.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.Do.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cZs.getPageContext().getString(u.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cZA = (PersonaltalkSettingViewBlackManView) this.cZs.findViewById(u.g.black_status_view);
        this.cZB = (PersonalTalkSettingViewSettingView) this.cZs.findViewById(u.g.setting_detail_view);
        this.cZz = (LinearLayout) this.cZs.findViewById(u.g.user_info_lin);
        this.cZw = (TbSettingTextTipView) this.cZs.findViewById(u.g.st_delete_talk_history);
        this.cZx = (TbSettingTextTipView) this.cZs.findViewById(u.g.add_to_black);
        this.cZy = (RelativeLayout) this.cZs.findViewById(u.g.remove_from_black_man);
        this.cZw.setOnClickListener(this.cZs);
        this.cZx.setOnClickListener(this.cZs);
        this.cZy.setOnClickListener(this.cZs);
        this.cZz.setOnClickListener(this.cZs);
        this.bBS = (HeadImageView) this.cZs.findViewById(u.g.photo);
        this.bBS.setIsRound(true);
        this.cFy = (TextView) this.cZs.findViewById(u.g.name);
        this.bTj = (UserIconBox) this.cZs.findViewById(u.g.user_icon_box);
        this.byo = (TextView) this.cZs.findViewById(u.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.cZs.getLayoutMode().w(this.Do);
        this.mNavigationBar.onChangeSkinType(this.cZs.getPageContext(), i);
    }

    public void j(boolean z, int i) {
        if (z) {
            this.cZA.setSex(i);
            this.cZA.setVisibility(0);
            this.cZB.setVisibility(8);
            return;
        }
        this.cZB.setVisibility(0);
        this.cZA.setVisibility(8);
    }

    public void fQ(boolean z) {
        this.cZB.fQ(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            j(rVar.arB(), rVar.arA().sex.intValue());
            fQ(rVar.arz());
            a(rVar.arA());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.cFy.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.cFy.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.cFy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.cFy.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.f.icon_pop_girl, 0);
            }
            this.byo.setText(dataRes.intro);
            if (this.bTj != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bTj.a(linkedList, i, this.cZs.getResources().getDimensionPixelSize(u.e.ds28), this.cZs.getResources().getDimensionPixelSize(u.e.ds28), this.cZs.getResources().getDimensionPixelSize(u.e.ds4));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.arA() != null && (str = rVar.arA().portrait) != null && str.length() > 0) {
            this.bBS.setImageResource(0);
            this.bBS.c(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.cZB != null) {
            this.cZB.setSwitchStateChangeListener(aVar);
        }
    }
}
