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
    private final View Fo;
    private final TextView aUd;
    private final TextView aUe;
    private final HeadImageView bIe;
    private final UserIconBox bXk;
    public PersonaltalkSettingViewBlackManView dhA;
    public PersonalTalkSettingViewSettingView dhB;
    private final PersonalTalkSettingActivity dhs;
    private TbSettingTextTipView dhw;
    private TbSettingTextTipView dhx;
    private RelativeLayout dhy;
    private LinearLayout dhz;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dhs = personalTalkSettingActivity;
        this.dhs.setContentView(r.j.p2ptalk_setting_activity);
        this.Fo = this.dhs.findViewById(r.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.Fo.findViewById(r.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dhs.getPageContext().getString(r.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dhA = (PersonaltalkSettingViewBlackManView) this.dhs.findViewById(r.h.black_status_view);
        this.dhB = (PersonalTalkSettingViewSettingView) this.dhs.findViewById(r.h.setting_detail_view);
        this.dhz = (LinearLayout) this.dhs.findViewById(r.h.user_info_lin);
        this.dhw = (TbSettingTextTipView) this.dhs.findViewById(r.h.st_delete_talk_history);
        this.dhx = (TbSettingTextTipView) this.dhs.findViewById(r.h.add_to_black);
        this.dhy = (RelativeLayout) this.dhs.findViewById(r.h.remove_from_black_man);
        this.dhw.setOnClickListener(this.dhs);
        this.dhx.setOnClickListener(this.dhs);
        this.dhy.setOnClickListener(this.dhs);
        this.dhz.setOnClickListener(this.dhs);
        this.bIe = (HeadImageView) this.dhs.findViewById(r.h.photo);
        this.bIe.setIsRound(true);
        this.aUd = (TextView) this.dhs.findViewById(r.h.name);
        this.bXk = (UserIconBox) this.dhs.findViewById(r.h.user_icon_box);
        this.aUe = (TextView) this.dhs.findViewById(r.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dhs.getLayoutMode().v(this.Fo);
        this.mNavigationBar.onChangeSkinType(this.dhs.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.dhA.setSex(i);
            this.dhA.setVisibility(0);
            this.dhB.setVisibility(8);
            return;
        }
        this.dhB.setVisibility(0);
        this.dhA.setVisibility(8);
    }

    public void gz(boolean z) {
        this.dhB.gz(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            h(rVar.avd(), rVar.avc().sex.intValue());
            gz(rVar.avb());
            a(rVar.avc());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.aUd.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.aUd.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.g.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.aUd.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.aUd.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.g.icon_pop_girl, 0);
            }
            this.aUe.setText(dataRes.intro);
            if (this.bXk != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bXk.a(linkedList, i, this.dhs.getResources().getDimensionPixelSize(r.f.ds28), this.dhs.getResources().getDimensionPixelSize(r.f.ds28), this.dhs.getResources().getDimensionPixelSize(r.f.ds4));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.avc() != null && (str = rVar.avc().portrait) != null && str.length() > 0) {
            this.bIe.setImageResource(0);
            this.bIe.c(str, 12, false);
        }
    }

    public void c(BdSwitchView.a aVar) {
        if (this.dhB != null) {
            this.dhB.setSwitchStateChangeListener(aVar);
        }
    }
}
