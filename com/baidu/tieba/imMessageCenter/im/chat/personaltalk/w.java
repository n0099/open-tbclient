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
    private final View Mk;
    private final TextView aVE;
    private final HeadImageView aYF;
    private final TextView bHW;
    private final UserIconBox bjY;
    private final PersonalTalkSettingActivity caa;
    private TbSettingTextTipView cae;
    private TbSettingTextTipView caf;
    private RelativeLayout cag;
    private LinearLayout cah;
    public PersonaltalkSettingViewBlackManView cai;
    public PersonalTalkSettingViewSettingView caj;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.caa = personalTalkSettingActivity;
        this.caa.setContentView(n.g.p2ptalk_setting_activity);
        this.Mk = this.caa.findViewById(n.f.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.Mk.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.caa.getPageContext().getString(n.i.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cai = (PersonaltalkSettingViewBlackManView) this.caa.findViewById(n.f.black_status_view);
        this.caj = (PersonalTalkSettingViewSettingView) this.caa.findViewById(n.f.setting_detail_view);
        this.cah = (LinearLayout) this.caa.findViewById(n.f.user_info_lin);
        this.cae = (TbSettingTextTipView) this.caa.findViewById(n.f.st_delete_talk_history);
        this.caf = (TbSettingTextTipView) this.caa.findViewById(n.f.add_to_black);
        this.cag = (RelativeLayout) this.caa.findViewById(n.f.remove_from_black_man);
        this.cae.setOnClickListener(this.caa);
        this.caf.setOnClickListener(this.caa);
        this.cag.setOnClickListener(this.caa);
        this.cah.setOnClickListener(this.caa);
        this.aYF = (HeadImageView) this.caa.findViewById(n.f.photo);
        this.aYF.setIsRound(true);
        this.bHW = (TextView) this.caa.findViewById(n.f.name);
        this.bjY = (UserIconBox) this.caa.findViewById(n.f.user_icon_box);
        this.aVE = (TextView) this.caa.findViewById(n.f.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.caa.getLayoutMode().k(this.Mk);
        this.mNavigationBar.onChangeSkinType(this.caa.getPageContext(), i);
    }

    public void b(boolean z, int i) {
        if (z) {
            this.cai.setSex(i);
            this.cai.setVisibility(0);
            this.caj.setVisibility(8);
            return;
        }
        this.caj.setVisibility(0);
        this.cai.setVisibility(8);
    }

    public void dX(boolean z) {
        this.caj.dX(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            b(rVar.abt(), rVar.abs().sex.intValue());
            dX(rVar.abr());
            a(rVar.abs());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.bHW.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.bHW.setCompoundDrawablesWithIntrinsicBounds(0, 0, n.e.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.bHW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.bHW.setCompoundDrawablesWithIntrinsicBounds(0, 0, n.e.icon_pop_girl, 0);
            }
            this.aVE.setText(dataRes.intro);
            if (this.bjY != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bjY.a(linkedList, i, this.caa.getResources().getDimensionPixelSize(n.d.person_icon_width), this.caa.getResources().getDimensionPixelSize(n.d.person_icon_height), this.caa.getResources().getDimensionPixelSize(n.d.person_icon_margin));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.abs() != null && (str = rVar.abs().portrait) != null && str.length() > 0) {
            this.aYF.setImageResource(0);
            this.aYF.d(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.caj != null) {
            this.caj.setSwitchStateChangeListener(aVar);
        }
    }
}
