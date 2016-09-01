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
    private final View Gc;
    private final TextView bMe;
    private final HeadImageView bSr;
    private final TextView cTS;
    private final UserIconBox cgs;
    private final PersonalTalkSettingActivity dnX;
    private TbSettingTextTipView dob;
    private TbSettingTextTipView dod;
    private RelativeLayout doe;
    private LinearLayout dof;
    public PersonaltalkSettingViewBlackManView dog;
    public PersonalTalkSettingViewSettingView doh;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dnX = personalTalkSettingActivity;
        this.dnX.setContentView(t.h.p2ptalk_setting_activity);
        this.Gc = this.dnX.findViewById(t.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.Gc.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dnX.getPageContext().getString(t.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dog = (PersonaltalkSettingViewBlackManView) this.dnX.findViewById(t.g.black_status_view);
        this.doh = (PersonalTalkSettingViewSettingView) this.dnX.findViewById(t.g.setting_detail_view);
        this.dof = (LinearLayout) this.dnX.findViewById(t.g.user_info_lin);
        this.dob = (TbSettingTextTipView) this.dnX.findViewById(t.g.st_delete_talk_history);
        this.dod = (TbSettingTextTipView) this.dnX.findViewById(t.g.add_to_black);
        this.doe = (RelativeLayout) this.dnX.findViewById(t.g.remove_from_black_man);
        this.dob.setOnClickListener(this.dnX);
        this.dod.setOnClickListener(this.dnX);
        this.doe.setOnClickListener(this.dnX);
        this.dof.setOnClickListener(this.dnX);
        this.bSr = (HeadImageView) this.dnX.findViewById(t.g.photo);
        this.bSr.setIsRound(true);
        this.cTS = (TextView) this.dnX.findViewById(t.g.name);
        this.cgs = (UserIconBox) this.dnX.findViewById(t.g.user_icon_box);
        this.bMe = (TextView) this.dnX.findViewById(t.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dnX.getLayoutMode().x(this.Gc);
        this.mNavigationBar.onChangeSkinType(this.dnX.getPageContext(), i);
    }

    public void j(boolean z, int i) {
        if (z) {
            this.dog.setSex(i);
            this.dog.setVisibility(0);
            this.doh.setVisibility(8);
            return;
        }
        this.doh.setVisibility(0);
        this.dog.setVisibility(8);
    }

    public void gp(boolean z) {
        this.doh.gp(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            j(rVar.axb(), rVar.axa().sex.intValue());
            gp(rVar.awZ());
            a(rVar.axa());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.cTS.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.cTS.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.cTS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.cTS.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_pop_girl, 0);
            }
            this.bMe.setText(dataRes.intro);
            if (this.cgs != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.cgs.a(linkedList, i, this.dnX.getResources().getDimensionPixelSize(t.e.ds28), this.dnX.getResources().getDimensionPixelSize(t.e.ds28), this.dnX.getResources().getDimensionPixelSize(t.e.ds4));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.axa() != null && (str = rVar.axa().portrait) != null && str.length() > 0) {
            this.bSr.setImageResource(0);
            this.bSr.c(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.doh != null) {
            this.doh.setSwitchStateChangeListener(aVar);
        }
    }
}
