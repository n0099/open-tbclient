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
    private final View bev;
    private final TextView bqH;
    private final HeadImageView cJv;
    private final PersonalTalkSettingActivity dYa;
    private TbSettingTextTipView dYe;
    private TbSettingTextTipView dYf;
    private RelativeLayout dYg;
    private LinearLayout dYh;
    public PersonaltalkSettingViewBlackManView dYi;
    public PersonalTalkSettingViewSettingView dYj;
    private final UserIconBox dcX;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dYa = personalTalkSettingActivity;
        this.dYa.setContentView(d.h.p2ptalk_setting_activity);
        this.bev = this.dYa.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.bev.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dYa.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dYi = (PersonaltalkSettingViewBlackManView) this.dYa.findViewById(d.g.black_status_view);
        this.dYj = (PersonalTalkSettingViewSettingView) this.dYa.findViewById(d.g.setting_detail_view);
        this.dYh = (LinearLayout) this.dYa.findViewById(d.g.user_info_lin);
        this.dYe = (TbSettingTextTipView) this.dYa.findViewById(d.g.st_delete_talk_history);
        this.dYf = (TbSettingTextTipView) this.dYa.findViewById(d.g.add_to_black);
        this.dYg = (RelativeLayout) this.dYa.findViewById(d.g.remove_from_black_man);
        this.dYe.setOnClickListener(this.dYa);
        this.dYf.setOnClickListener(this.dYa);
        this.dYg.setOnClickListener(this.dYa);
        this.dYh.setOnClickListener(this.dYa);
        this.cJv = (HeadImageView) this.dYa.findViewById(d.g.photo);
        this.cJv.setIsRound(true);
        this.mName = (TextView) this.dYa.findViewById(d.g.name);
        this.dcX = (UserIconBox) this.dYa.findViewById(d.g.user_icon_box);
        this.bqH = (TextView) this.dYa.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dYa.getLayoutMode().t(this.bev);
        this.mNavigationBar.onChangeSkinType(this.dYa.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.dYi.setSex(i);
            this.dYi.setVisibility(0);
            this.dYj.setVisibility(8);
            return;
        }
        this.dYj.setVisibility(0);
        this.dYi.setVisibility(8);
    }

    public void hp(boolean z) {
        this.dYj.hp(z);
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
            this.bqH.setText(dataRes.intro);
            if (this.dcX != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dcX.a(linkedList, i, this.dYa.getResources().getDimensionPixelSize(d.e.ds28), this.dYa.getResources().getDimensionPixelSize(d.e.ds28), this.dYa.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aDV() != null && (str = fVar.aDV().portrait) != null && str.length() > 0) {
            this.cJv.setImageResource(0);
            this.cJv.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.dYj != null) {
            this.dYj.setSwitchStateChangeListener(aVar);
        }
    }
}
