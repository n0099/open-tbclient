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
import com.baidu.tieba.r;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class w {
    private final View Ge;
    private final TextView bOY;
    private final HeadImageView bUx;
    private final UserIconBox clv;
    private final TextView daX;
    private final PersonalTalkSettingActivity dvd;
    private TbSettingTextTipView dvh;
    private TbSettingTextTipView dvi;
    private RelativeLayout dvj;
    private LinearLayout dvk;
    public PersonaltalkSettingViewBlackManView dvl;
    public PersonalTalkSettingViewSettingView dvm;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dvd = personalTalkSettingActivity;
        this.dvd.setContentView(r.h.p2ptalk_setting_activity);
        this.Ge = this.dvd.findViewById(r.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.Ge.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dvd.getPageContext().getString(r.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dvl = (PersonaltalkSettingViewBlackManView) this.dvd.findViewById(r.g.black_status_view);
        this.dvm = (PersonalTalkSettingViewSettingView) this.dvd.findViewById(r.g.setting_detail_view);
        this.dvk = (LinearLayout) this.dvd.findViewById(r.g.user_info_lin);
        this.dvh = (TbSettingTextTipView) this.dvd.findViewById(r.g.st_delete_talk_history);
        this.dvi = (TbSettingTextTipView) this.dvd.findViewById(r.g.add_to_black);
        this.dvj = (RelativeLayout) this.dvd.findViewById(r.g.remove_from_black_man);
        this.dvh.setOnClickListener(this.dvd);
        this.dvi.setOnClickListener(this.dvd);
        this.dvj.setOnClickListener(this.dvd);
        this.dvk.setOnClickListener(this.dvd);
        this.bUx = (HeadImageView) this.dvd.findViewById(r.g.photo);
        this.bUx.setIsRound(true);
        this.daX = (TextView) this.dvd.findViewById(r.g.name);
        this.clv = (UserIconBox) this.dvd.findViewById(r.g.user_icon_box);
        this.bOY = (TextView) this.dvd.findViewById(r.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dvd.getLayoutMode().x(this.Ge);
        this.mNavigationBar.onChangeSkinType(this.dvd.getPageContext(), i);
    }

    public void k(boolean z, int i) {
        if (z) {
            this.dvl.setSex(i);
            this.dvl.setVisibility(0);
            this.dvm.setVisibility(8);
            return;
        }
        this.dvm.setVisibility(0);
        this.dvl.setVisibility(8);
    }

    public void gM(boolean z) {
        this.dvm.gM(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            k(rVar.azx(), rVar.azw().sex.intValue());
            gM(rVar.azv());
            a(rVar.azw());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.daX.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.daX.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.daX.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.daX.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_pop_girl, 0);
            }
            this.bOY.setText(dataRes.intro);
            if (this.clv != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.clv.a(linkedList, i, this.dvd.getResources().getDimensionPixelSize(r.e.ds28), this.dvd.getResources().getDimensionPixelSize(r.e.ds28), this.dvd.getResources().getDimensionPixelSize(r.e.ds4));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.azw() != null && (str = rVar.azw().portrait) != null && str.length() > 0) {
            this.bUx.setImageResource(0);
            this.bUx.c(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.dvm != null) {
            this.dvm.setSwitchStateChangeListener(aVar);
        }
    }
}
