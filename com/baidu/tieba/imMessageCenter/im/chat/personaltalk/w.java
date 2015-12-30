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
import com.baidu.tieba.n;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class w {
    private final View MA;
    private final TextView aZE;
    private final TextView bLD;
    private final HeadImageView bcC;
    private final UserIconBox bnP;
    private final PersonalTalkSettingActivity ceb;
    private TbSettingTextTipView cef;
    private TbSettingTextTipView ceg;
    private RelativeLayout ceh;
    private LinearLayout cei;
    public PersonaltalkSettingViewBlackManView cej;
    public PersonalTalkSettingViewSettingView cek;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ceb = personalTalkSettingActivity;
        this.ceb.setContentView(n.h.p2ptalk_setting_activity);
        this.MA = this.ceb.findViewById(n.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.MA.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ceb.getPageContext().getString(n.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cej = (PersonaltalkSettingViewBlackManView) this.ceb.findViewById(n.g.black_status_view);
        this.cek = (PersonalTalkSettingViewSettingView) this.ceb.findViewById(n.g.setting_detail_view);
        this.cei = (LinearLayout) this.ceb.findViewById(n.g.user_info_lin);
        this.cef = (TbSettingTextTipView) this.ceb.findViewById(n.g.st_delete_talk_history);
        this.ceg = (TbSettingTextTipView) this.ceb.findViewById(n.g.add_to_black);
        this.ceh = (RelativeLayout) this.ceb.findViewById(n.g.remove_from_black_man);
        this.cef.setOnClickListener(this.ceb);
        this.ceg.setOnClickListener(this.ceb);
        this.ceh.setOnClickListener(this.ceb);
        this.cei.setOnClickListener(this.ceb);
        this.bcC = (HeadImageView) this.ceb.findViewById(n.g.photo);
        this.bcC.setIsRound(true);
        this.bLD = (TextView) this.ceb.findViewById(n.g.name);
        this.bnP = (UserIconBox) this.ceb.findViewById(n.g.user_icon_box);
        this.aZE = (TextView) this.ceb.findViewById(n.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.ceb.getLayoutMode().k(this.MA);
        this.mNavigationBar.onChangeSkinType(this.ceb.getPageContext(), i);
    }

    public void b(boolean z, int i) {
        if (z) {
            this.cej.setSex(i);
            this.cej.setVisibility(0);
            this.cek.setVisibility(8);
            return;
        }
        this.cek.setVisibility(0);
        this.cej.setVisibility(8);
    }

    public void dX(boolean z) {
        this.cek.dX(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            b(rVar.acC(), rVar.acB().sex.intValue());
            dX(rVar.acA());
            a(rVar.acB());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.bLD.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.bLD.setCompoundDrawablesWithIntrinsicBounds(0, 0, n.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.bLD.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.bLD.setCompoundDrawablesWithIntrinsicBounds(0, 0, n.f.icon_pop_girl, 0);
            }
            this.aZE.setText(dataRes.intro);
            if (this.bnP != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bnP.a(linkedList, i, this.ceb.getResources().getDimensionPixelSize(n.e.person_icon_width), this.ceb.getResources().getDimensionPixelSize(n.e.person_icon_height), this.ceb.getResources().getDimensionPixelSize(n.e.person_icon_margin));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.acB() != null && (str = rVar.acB().portrait) != null && str.length() > 0) {
            this.bcC.setImageResource(0);
            this.bcC.d(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.cek != null) {
            this.cek.setSwitchStateChangeListener(aVar);
        }
    }
}
