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
import com.baidu.tieba.i;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class w {
    private final View LS;
    private final TextView aQt;
    private final HeadImageView aTj;
    private final PersonalTalkSettingActivity bKB;
    private TbSettingTextTipView bKF;
    private TbSettingTextTipView bKG;
    private RelativeLayout bKH;
    private LinearLayout bKI;
    public PersonaltalkSettingViewBlackManView bKJ;
    public PersonalTalkSettingViewSettingView bKK;
    private final UserIconBox bcN;
    private final TextView bsm;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bKB = personalTalkSettingActivity;
        this.bKB.setContentView(i.g.p2ptalk_setting_activity);
        this.LS = this.bKB.findViewById(i.f.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.LS.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bKB.getPageContext().getString(i.h.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bKJ = (PersonaltalkSettingViewBlackManView) this.bKB.findViewById(i.f.black_status_view);
        this.bKK = (PersonalTalkSettingViewSettingView) this.bKB.findViewById(i.f.setting_detail_view);
        this.bKI = (LinearLayout) this.bKB.findViewById(i.f.user_info_lin);
        this.bKF = (TbSettingTextTipView) this.bKB.findViewById(i.f.st_delete_talk_history);
        this.bKG = (TbSettingTextTipView) this.bKB.findViewById(i.f.add_to_black);
        this.bKH = (RelativeLayout) this.bKB.findViewById(i.f.remove_from_black_man);
        this.bKF.setOnClickListener(this.bKB);
        this.bKG.setOnClickListener(this.bKB);
        this.bKH.setOnClickListener(this.bKB);
        this.bKI.setOnClickListener(this.bKB);
        this.aTj = (HeadImageView) this.bKB.findViewById(i.f.photo);
        this.aTj.setIsRound(true);
        this.bsm = (TextView) this.bKB.findViewById(i.f.name);
        this.bcN = (UserIconBox) this.bKB.findViewById(i.f.user_icon_box);
        this.aQt = (TextView) this.bKB.findViewById(i.f.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.bKB.getLayoutMode().k(this.LS);
        this.mNavigationBar.onChangeSkinType(this.bKB.getPageContext(), i);
    }

    public void b(boolean z, int i) {
        if (z) {
            this.bKJ.setSex(i);
            this.bKJ.setVisibility(0);
            this.bKK.setVisibility(8);
            return;
        }
        this.bKK.setVisibility(0);
        this.bKJ.setVisibility(8);
    }

    public void dA(boolean z) {
        this.bKK.dA(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            b(rVar.XW(), rVar.XV().sex.intValue());
            dA(rVar.XU());
            a(rVar.XV());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.bsm.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.bsm.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.bsm.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.bsm.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_pop_girl, 0);
            }
            this.aQt.setText(dataRes.intro);
            if (this.bcN != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bcN.a(linkedList, i, this.bKB.getResources().getDimensionPixelSize(i.d.person_icon_width), this.bKB.getResources().getDimensionPixelSize(i.d.person_icon_height), this.bKB.getResources().getDimensionPixelSize(i.d.person_icon_margin));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.XV() != null && (str = rVar.XV().portrait) != null && str.length() > 0) {
            this.aTj.setImageResource(0);
            this.aTj.d(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.bKK != null) {
            this.bKK.setSwitchStateChangeListener(aVar);
        }
    }
}
