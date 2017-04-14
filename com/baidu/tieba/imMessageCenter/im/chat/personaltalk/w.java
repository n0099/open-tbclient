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
import com.baidu.tieba.w;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class w {
    private final View aXl;
    private final HeadImageView bPc;
    private final TextView baj;
    private final UserIconBox cdi;
    private final PersonalTalkSettingActivity dij;
    private TbSettingTextTipView din;
    private TbSettingTextTipView dio;
    private RelativeLayout dip;
    private LinearLayout diq;
    public PersonaltalkSettingViewBlackManView dir;
    public PersonalTalkSettingViewSettingView dis;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dij = personalTalkSettingActivity;
        this.dij.setContentView(w.j.p2ptalk_setting_activity);
        this.aXl = this.dij.findViewById(w.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.aXl.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dij.getPageContext().getString(w.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dir = (PersonaltalkSettingViewBlackManView) this.dij.findViewById(w.h.black_status_view);
        this.dis = (PersonalTalkSettingViewSettingView) this.dij.findViewById(w.h.setting_detail_view);
        this.diq = (LinearLayout) this.dij.findViewById(w.h.user_info_lin);
        this.din = (TbSettingTextTipView) this.dij.findViewById(w.h.st_delete_talk_history);
        this.dio = (TbSettingTextTipView) this.dij.findViewById(w.h.add_to_black);
        this.dip = (RelativeLayout) this.dij.findViewById(w.h.remove_from_black_man);
        this.din.setOnClickListener(this.dij);
        this.dio.setOnClickListener(this.dij);
        this.dip.setOnClickListener(this.dij);
        this.diq.setOnClickListener(this.dij);
        this.bPc = (HeadImageView) this.dij.findViewById(w.h.photo);
        this.bPc.setIsRound(true);
        this.mName = (TextView) this.dij.findViewById(w.h.name);
        this.cdi = (UserIconBox) this.dij.findViewById(w.h.user_icon_box);
        this.baj = (TextView) this.dij.findViewById(w.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dij.getLayoutMode().t(this.aXl);
        this.mNavigationBar.onChangeSkinType(this.dij.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.dir.setSex(i);
            this.dir.setVisibility(0);
            this.dis.setVisibility(8);
            return;
        }
        this.dis.setVisibility(0);
        this.dir.setVisibility(8);
    }

    public void gq(boolean z) {
        this.dis.gq(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            h(rVar.aur(), rVar.auq().sex.intValue());
            gq(rVar.aup());
            a(rVar.auq());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_pop_girl, 0);
            }
            this.baj.setText(dataRes.intro);
            if (this.cdi != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.cdi.a(linkedList, i, this.dij.getResources().getDimensionPixelSize(w.f.ds28), this.dij.getResources().getDimensionPixelSize(w.f.ds28), this.dij.getResources().getDimensionPixelSize(w.f.ds4));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.auq() != null && (str = rVar.auq().portrait) != null && str.length() > 0) {
            this.bPc.setImageResource(0);
            this.bPc.c(str, 12, false);
        }
    }

    public void c(BdSwitchView.a aVar) {
        if (this.dis != null) {
            this.dis.setSwitchStateChangeListener(aVar);
        }
    }
}
