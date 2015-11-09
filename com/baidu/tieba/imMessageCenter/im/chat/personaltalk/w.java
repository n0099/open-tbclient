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
    private final View LT;
    private final TextView aQB;
    private final HeadImageView aTr;
    private final PersonalTalkSettingActivity bKW;
    private TbSettingTextTipView bLa;
    private TbSettingTextTipView bLb;
    private RelativeLayout bLc;
    private LinearLayout bLd;
    public PersonaltalkSettingViewBlackManView bLe;
    public PersonalTalkSettingViewSettingView bLf;
    private final UserIconBox bds;
    private final TextView bsQ;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bKW = personalTalkSettingActivity;
        this.bKW.setContentView(i.g.p2ptalk_setting_activity);
        this.LT = this.bKW.findViewById(i.f.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.LT.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bKW.getPageContext().getString(i.h.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bLe = (PersonaltalkSettingViewBlackManView) this.bKW.findViewById(i.f.black_status_view);
        this.bLf = (PersonalTalkSettingViewSettingView) this.bKW.findViewById(i.f.setting_detail_view);
        this.bLd = (LinearLayout) this.bKW.findViewById(i.f.user_info_lin);
        this.bLa = (TbSettingTextTipView) this.bKW.findViewById(i.f.st_delete_talk_history);
        this.bLb = (TbSettingTextTipView) this.bKW.findViewById(i.f.add_to_black);
        this.bLc = (RelativeLayout) this.bKW.findViewById(i.f.remove_from_black_man);
        this.bLa.setOnClickListener(this.bKW);
        this.bLb.setOnClickListener(this.bKW);
        this.bLc.setOnClickListener(this.bKW);
        this.bLd.setOnClickListener(this.bKW);
        this.aTr = (HeadImageView) this.bKW.findViewById(i.f.photo);
        this.aTr.setIsRound(true);
        this.bsQ = (TextView) this.bKW.findViewById(i.f.name);
        this.bds = (UserIconBox) this.bKW.findViewById(i.f.user_icon_box);
        this.aQB = (TextView) this.bKW.findViewById(i.f.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.bKW.getLayoutMode().k(this.LT);
        this.mNavigationBar.onChangeSkinType(this.bKW.getPageContext(), i);
    }

    public void b(boolean z, int i) {
        if (z) {
            this.bLe.setSex(i);
            this.bLe.setVisibility(0);
            this.bLf.setVisibility(8);
            return;
        }
        this.bLf.setVisibility(0);
        this.bLe.setVisibility(8);
    }

    public void dC(boolean z) {
        this.bLf.dC(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            b(rVar.Yn(), rVar.Ym().sex.intValue());
            dC(rVar.Yl());
            a(rVar.Ym());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.bsQ.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.bsQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.bsQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.bsQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_pop_girl, 0);
            }
            this.aQB.setText(dataRes.intro);
            if (this.bds != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bds.a(linkedList, i, this.bKW.getResources().getDimensionPixelSize(i.d.person_icon_width), this.bKW.getResources().getDimensionPixelSize(i.d.person_icon_height), this.bKW.getResources().getDimensionPixelSize(i.d.person_icon_margin));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.Ym() != null && (str = rVar.Ym().portrait) != null && str.length() > 0) {
            this.aTr.setImageResource(0);
            this.aTr.d(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.bLf != null) {
            this.bLf.setSwitchStateChangeListener(aVar);
        }
    }
}
