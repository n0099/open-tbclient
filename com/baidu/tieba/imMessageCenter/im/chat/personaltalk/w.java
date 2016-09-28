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
    private final View Gc;
    private final TextView bMf;
    private final HeadImageView bSk;
    private final TextView cVm;
    private final UserIconBox cgq;
    private TbSettingTextTipView dpA;
    private TbSettingTextTipView dpB;
    private RelativeLayout dpC;
    private LinearLayout dpD;
    public PersonaltalkSettingViewBlackManView dpE;
    public PersonalTalkSettingViewSettingView dpF;
    private final PersonalTalkSettingActivity dpw;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dpw = personalTalkSettingActivity;
        this.dpw.setContentView(r.h.p2ptalk_setting_activity);
        this.Gc = this.dpw.findViewById(r.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.Gc.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dpw.getPageContext().getString(r.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dpE = (PersonaltalkSettingViewBlackManView) this.dpw.findViewById(r.g.black_status_view);
        this.dpF = (PersonalTalkSettingViewSettingView) this.dpw.findViewById(r.g.setting_detail_view);
        this.dpD = (LinearLayout) this.dpw.findViewById(r.g.user_info_lin);
        this.dpA = (TbSettingTextTipView) this.dpw.findViewById(r.g.st_delete_talk_history);
        this.dpB = (TbSettingTextTipView) this.dpw.findViewById(r.g.add_to_black);
        this.dpC = (RelativeLayout) this.dpw.findViewById(r.g.remove_from_black_man);
        this.dpA.setOnClickListener(this.dpw);
        this.dpB.setOnClickListener(this.dpw);
        this.dpC.setOnClickListener(this.dpw);
        this.dpD.setOnClickListener(this.dpw);
        this.bSk = (HeadImageView) this.dpw.findViewById(r.g.photo);
        this.bSk.setIsRound(true);
        this.cVm = (TextView) this.dpw.findViewById(r.g.name);
        this.cgq = (UserIconBox) this.dpw.findViewById(r.g.user_icon_box);
        this.bMf = (TextView) this.dpw.findViewById(r.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dpw.getLayoutMode().x(this.Gc);
        this.mNavigationBar.onChangeSkinType(this.dpw.getPageContext(), i);
    }

    public void k(boolean z, int i) {
        if (z) {
            this.dpE.setSex(i);
            this.dpE.setVisibility(0);
            this.dpF.setVisibility(8);
            return;
        }
        this.dpF.setVisibility(0);
        this.dpE.setVisibility(8);
    }

    public void gs(boolean z) {
        this.dpF.gs(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            k(rVar.axA(), rVar.axz().sex.intValue());
            gs(rVar.axy());
            a(rVar.axz());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.cVm.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.cVm.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.cVm.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.cVm.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_pop_girl, 0);
            }
            this.bMf.setText(dataRes.intro);
            if (this.cgq != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.cgq.a(linkedList, i, this.dpw.getResources().getDimensionPixelSize(r.e.ds28), this.dpw.getResources().getDimensionPixelSize(r.e.ds28), this.dpw.getResources().getDimensionPixelSize(r.e.ds4));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.axz() != null && (str = rVar.axz().portrait) != null && str.length() > 0) {
            this.bSk.setImageResource(0);
            this.bSk.c(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.dpF != null) {
            this.dpF.setSwitchStateChangeListener(aVar);
        }
    }
}
