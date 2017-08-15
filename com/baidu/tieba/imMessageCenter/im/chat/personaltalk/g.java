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
    private final View aZh;
    private final TextView bgX;
    private final UserIconBox cBm;
    private final HeadImageView clO;
    private final PersonalTalkSettingActivity dDJ;
    private TbSettingTextTipView dDN;
    private TbSettingTextTipView dDO;
    private RelativeLayout dDP;
    private LinearLayout dDQ;
    public PersonaltalkSettingViewBlackManView dDR;
    public PersonalTalkSettingViewSettingView dDS;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dDJ = personalTalkSettingActivity;
        this.dDJ.setContentView(d.j.p2ptalk_setting_activity);
        this.aZh = this.dDJ.findViewById(d.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.aZh.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dDJ.getPageContext().getString(d.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dDR = (PersonaltalkSettingViewBlackManView) this.dDJ.findViewById(d.h.black_status_view);
        this.dDS = (PersonalTalkSettingViewSettingView) this.dDJ.findViewById(d.h.setting_detail_view);
        this.dDQ = (LinearLayout) this.dDJ.findViewById(d.h.user_info_lin);
        this.dDN = (TbSettingTextTipView) this.dDJ.findViewById(d.h.st_delete_talk_history);
        this.dDO = (TbSettingTextTipView) this.dDJ.findViewById(d.h.add_to_black);
        this.dDP = (RelativeLayout) this.dDJ.findViewById(d.h.remove_from_black_man);
        this.dDN.setOnClickListener(this.dDJ);
        this.dDO.setOnClickListener(this.dDJ);
        this.dDP.setOnClickListener(this.dDJ);
        this.dDQ.setOnClickListener(this.dDJ);
        this.clO = (HeadImageView) this.dDJ.findViewById(d.h.photo);
        this.clO.setIsRound(true);
        this.mName = (TextView) this.dDJ.findViewById(d.h.name);
        this.cBm = (UserIconBox) this.dDJ.findViewById(d.h.user_icon_box);
        this.bgX = (TextView) this.dDJ.findViewById(d.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dDJ.getLayoutMode().t(this.aZh);
        this.mNavigationBar.onChangeSkinType(this.dDJ.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.dDR.setSex(i);
            this.dDR.setVisibility(0);
            this.dDS.setVisibility(8);
            return;
        }
        this.dDS.setVisibility(0);
        this.dDR.setVisibility(8);
    }

    public void gX(boolean z) {
        this.dDS.gX(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.azn(), fVar.azm().sex.intValue());
            gX(fVar.azl());
            a(fVar.azm());
            f(fVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_pop_girl, 0);
            }
            this.bgX.setText(dataRes.intro);
            if (this.cBm != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.cBm.a(linkedList, i, this.dDJ.getResources().getDimensionPixelSize(d.f.ds28), this.dDJ.getResources().getDimensionPixelSize(d.f.ds28), this.dDJ.getResources().getDimensionPixelSize(d.f.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.azm() != null && (str = fVar.azm().portrait) != null && str.length() > 0) {
            this.clO.setImageResource(0);
            this.clO.c(str, 12, false);
        }
    }

    public void b(BdSwitchView.a aVar) {
        if (this.dDS != null) {
            this.dDS.setSwitchStateChangeListener(aVar);
        }
    }
}
