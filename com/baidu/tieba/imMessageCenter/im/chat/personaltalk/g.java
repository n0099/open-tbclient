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
import com.baidu.tieba.d;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes2.dex */
public class g {
    private final View beq;
    private final TextView bqD;
    private final HeadImageView cJr;
    private final PersonalTalkSettingActivity dXW;
    private TbSettingTextTipView dYa;
    private TbSettingTextTipView dYb;
    private RelativeLayout dYc;
    private LinearLayout dYd;
    public PersonaltalkSettingViewBlackManView dYe;
    public PersonalTalkSettingViewSettingView dYf;
    private final UserIconBox dcT;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dXW = personalTalkSettingActivity;
        this.dXW.setContentView(d.h.p2ptalk_setting_activity);
        this.beq = this.dXW.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.beq.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dXW.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dYe = (PersonaltalkSettingViewBlackManView) this.dXW.findViewById(d.g.black_status_view);
        this.dYf = (PersonalTalkSettingViewSettingView) this.dXW.findViewById(d.g.setting_detail_view);
        this.dYd = (LinearLayout) this.dXW.findViewById(d.g.user_info_lin);
        this.dYa = (TbSettingTextTipView) this.dXW.findViewById(d.g.st_delete_talk_history);
        this.dYb = (TbSettingTextTipView) this.dXW.findViewById(d.g.add_to_black);
        this.dYc = (RelativeLayout) this.dXW.findViewById(d.g.remove_from_black_man);
        this.dYa.setOnClickListener(this.dXW);
        this.dYb.setOnClickListener(this.dXW);
        this.dYc.setOnClickListener(this.dXW);
        this.dYd.setOnClickListener(this.dXW);
        this.cJr = (HeadImageView) this.dXW.findViewById(d.g.photo);
        this.cJr.setIsRound(true);
        this.mName = (TextView) this.dXW.findViewById(d.g.name);
        this.dcT = (UserIconBox) this.dXW.findViewById(d.g.user_icon_box);
        this.bqD = (TextView) this.dXW.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dXW.getLayoutMode().t(this.beq);
        this.mNavigationBar.onChangeSkinType(this.dXW.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.dYe.setSex(i);
            this.dYe.setVisibility(0);
            this.dYf.setVisibility(8);
            return;
        }
        this.dYf.setVisibility(0);
        this.dYe.setVisibility(8);
    }

    public void hp(boolean z) {
        this.dYf.hp(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.aDW(), fVar.aDV().sex.intValue());
            hp(fVar.aDU());
            a(fVar.aDV());
            f(fVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_pop_girl, 0);
            }
            this.bqD.setText(dataRes.intro);
            if (this.dcT != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dcT.a(linkedList, i, this.dXW.getResources().getDimensionPixelSize(d.e.ds28), this.dXW.getResources().getDimensionPixelSize(d.e.ds28), this.dXW.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aDV() != null && (str = fVar.aDV().portrait) != null && str.length() > 0) {
            this.cJr.setImageResource(0);
            this.cJr.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.dYf != null) {
            this.dYf.setSwitchStateChangeListener(aVar);
        }
    }
}
