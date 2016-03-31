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
import com.baidu.tieba.t;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class w {
    private final View MW;
    private final TextView bZJ;
    private final TextView bgE;
    private final HeadImageView bjG;
    private final UserIconBox bvK;
    private final PersonalTalkSettingActivity ctf;
    private TbSettingTextTipView ctj;
    private TbSettingTextTipView ctk;
    private RelativeLayout ctl;
    private LinearLayout ctm;
    public PersonaltalkSettingViewBlackManView ctn;
    public PersonalTalkSettingViewSettingView cto;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ctf = personalTalkSettingActivity;
        this.ctf.setContentView(t.h.p2ptalk_setting_activity);
        this.MW = this.ctf.findViewById(t.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.MW.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ctf.getPageContext().getString(t.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ctn = (PersonaltalkSettingViewBlackManView) this.ctf.findViewById(t.g.black_status_view);
        this.cto = (PersonalTalkSettingViewSettingView) this.ctf.findViewById(t.g.setting_detail_view);
        this.ctm = (LinearLayout) this.ctf.findViewById(t.g.user_info_lin);
        this.ctj = (TbSettingTextTipView) this.ctf.findViewById(t.g.st_delete_talk_history);
        this.ctk = (TbSettingTextTipView) this.ctf.findViewById(t.g.add_to_black);
        this.ctl = (RelativeLayout) this.ctf.findViewById(t.g.remove_from_black_man);
        this.ctj.setOnClickListener(this.ctf);
        this.ctk.setOnClickListener(this.ctf);
        this.ctl.setOnClickListener(this.ctf);
        this.ctm.setOnClickListener(this.ctf);
        this.bjG = (HeadImageView) this.ctf.findViewById(t.g.photo);
        this.bjG.setIsRound(true);
        this.bZJ = (TextView) this.ctf.findViewById(t.g.name);
        this.bvK = (UserIconBox) this.ctf.findViewById(t.g.user_icon_box);
        this.bgE = (TextView) this.ctf.findViewById(t.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.ctf.getLayoutMode().x(this.MW);
        this.mNavigationBar.onChangeSkinType(this.ctf.getPageContext(), i);
    }

    public void d(boolean z, int i) {
        if (z) {
            this.ctn.setSex(i);
            this.ctn.setVisibility(0);
            this.cto.setVisibility(8);
            return;
        }
        this.cto.setVisibility(0);
        this.ctn.setVisibility(8);
    }

    public void eA(boolean z) {
        this.cto.eA(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            d(rVar.ajf(), rVar.aje().sex.intValue());
            eA(rVar.ajd());
            a(rVar.aje());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.bZJ.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.bZJ.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.bZJ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.bZJ.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_pop_girl, 0);
            }
            this.bgE.setText(dataRes.intro);
            if (this.bvK != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bvK.a(linkedList, i, this.ctf.getResources().getDimensionPixelSize(t.e.person_icon_width), this.ctf.getResources().getDimensionPixelSize(t.e.person_icon_height), this.ctf.getResources().getDimensionPixelSize(t.e.person_icon_margin));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.aje() != null && (str = rVar.aje().portrait) != null && str.length() > 0) {
            this.bjG.setImageResource(0);
            this.bjG.c(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.cto != null) {
            this.cto.setSwitchStateChangeListener(aVar);
        }
    }
}
