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
    private final View LR;
    private final TextView aQi;
    private final HeadImageView aSY;
    private final PersonalTalkSettingActivity bKq;
    private TbSettingTextTipView bKu;
    private TbSettingTextTipView bKv;
    private RelativeLayout bKw;
    private LinearLayout bKx;
    public PersonaltalkSettingViewBlackManView bKy;
    public PersonalTalkSettingViewSettingView bKz;
    private final UserIconBox bcC;
    private final TextView bsb;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bKq = personalTalkSettingActivity;
        this.bKq.setContentView(i.g.p2ptalk_setting_activity);
        this.LR = this.bKq.findViewById(i.f.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.LR.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bKq.getPageContext().getString(i.h.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bKy = (PersonaltalkSettingViewBlackManView) this.bKq.findViewById(i.f.black_status_view);
        this.bKz = (PersonalTalkSettingViewSettingView) this.bKq.findViewById(i.f.setting_detail_view);
        this.bKx = (LinearLayout) this.bKq.findViewById(i.f.user_info_lin);
        this.bKu = (TbSettingTextTipView) this.bKq.findViewById(i.f.st_delete_talk_history);
        this.bKv = (TbSettingTextTipView) this.bKq.findViewById(i.f.add_to_black);
        this.bKw = (RelativeLayout) this.bKq.findViewById(i.f.remove_from_black_man);
        this.bKu.setOnClickListener(this.bKq);
        this.bKv.setOnClickListener(this.bKq);
        this.bKw.setOnClickListener(this.bKq);
        this.bKx.setOnClickListener(this.bKq);
        this.aSY = (HeadImageView) this.bKq.findViewById(i.f.photo);
        this.aSY.setIsRound(true);
        this.bsb = (TextView) this.bKq.findViewById(i.f.name);
        this.bcC = (UserIconBox) this.bKq.findViewById(i.f.user_icon_box);
        this.aQi = (TextView) this.bKq.findViewById(i.f.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.bKq.getLayoutMode().k(this.LR);
        this.mNavigationBar.onChangeSkinType(this.bKq.getPageContext(), i);
    }

    public void b(boolean z, int i) {
        if (z) {
            this.bKy.setSex(i);
            this.bKy.setVisibility(0);
            this.bKz.setVisibility(8);
            return;
        }
        this.bKz.setVisibility(0);
        this.bKy.setVisibility(8);
    }

    public void dA(boolean z) {
        this.bKz.dA(z);
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
            this.bsb.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.bsb.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.bsb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.bsb.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_pop_girl, 0);
            }
            this.aQi.setText(dataRes.intro);
            if (this.bcC != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bcC.a(linkedList, i, this.bKq.getResources().getDimensionPixelSize(i.d.person_icon_width), this.bKq.getResources().getDimensionPixelSize(i.d.person_icon_height), this.bKq.getResources().getDimensionPixelSize(i.d.person_icon_margin));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.XV() != null && (str = rVar.XV().portrait) != null && str.length() > 0) {
            this.aSY.setImageResource(0);
            this.aSY.d(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.bKz != null) {
            this.bKz.setSwitchStateChangeListener(aVar);
        }
    }
}
