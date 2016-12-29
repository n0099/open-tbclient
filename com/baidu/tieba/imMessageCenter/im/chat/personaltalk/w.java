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
    private final HeadImageView bAJ;
    private final UserIconBox bQG;
    private final TextView bvd;
    private final TextView cGh;
    private final PersonalTalkSettingActivity dad;
    private TbSettingTextTipView dah;
    private TbSettingTextTipView dai;
    private RelativeLayout daj;
    private LinearLayout dak;
    public PersonaltalkSettingViewBlackManView dal;
    public PersonalTalkSettingViewSettingView dam;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dad = personalTalkSettingActivity;
        this.dad.setContentView(r.h.p2ptalk_setting_activity);
        this.Ge = this.dad.findViewById(r.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.Ge.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dad.getPageContext().getString(r.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dal = (PersonaltalkSettingViewBlackManView) this.dad.findViewById(r.g.black_status_view);
        this.dam = (PersonalTalkSettingViewSettingView) this.dad.findViewById(r.g.setting_detail_view);
        this.dak = (LinearLayout) this.dad.findViewById(r.g.user_info_lin);
        this.dah = (TbSettingTextTipView) this.dad.findViewById(r.g.st_delete_talk_history);
        this.dai = (TbSettingTextTipView) this.dad.findViewById(r.g.add_to_black);
        this.daj = (RelativeLayout) this.dad.findViewById(r.g.remove_from_black_man);
        this.dah.setOnClickListener(this.dad);
        this.dai.setOnClickListener(this.dad);
        this.daj.setOnClickListener(this.dad);
        this.dak.setOnClickListener(this.dad);
        this.bAJ = (HeadImageView) this.dad.findViewById(r.g.photo);
        this.bAJ.setIsRound(true);
        this.cGh = (TextView) this.dad.findViewById(r.g.name);
        this.bQG = (UserIconBox) this.dad.findViewById(r.g.user_icon_box);
        this.bvd = (TextView) this.dad.findViewById(r.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dad.getLayoutMode().x(this.Ge);
        this.mNavigationBar.onChangeSkinType(this.dad.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.dal.setSex(i);
            this.dal.setVisibility(0);
            this.dam.setVisibility(8);
            return;
        }
        this.dam.setVisibility(0);
        this.dal.setVisibility(8);
    }

    public void gw(boolean z) {
        this.dam.gw(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            h(rVar.atX(), rVar.atW().sex.intValue());
            gw(rVar.atV());
            a(rVar.atW());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.cGh.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.cGh.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.cGh.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.cGh.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_pop_girl, 0);
            }
            this.bvd.setText(dataRes.intro);
            if (this.bQG != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bQG.a(linkedList, i, this.dad.getResources().getDimensionPixelSize(r.e.ds28), this.dad.getResources().getDimensionPixelSize(r.e.ds28), this.dad.getResources().getDimensionPixelSize(r.e.ds4));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.atW() != null && (str = rVar.atW().portrait) != null && str.length() > 0) {
            this.bAJ.setImageResource(0);
            this.bAJ.c(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.dam != null) {
            this.dam.setSwitchStateChangeListener(aVar);
        }
    }
}
