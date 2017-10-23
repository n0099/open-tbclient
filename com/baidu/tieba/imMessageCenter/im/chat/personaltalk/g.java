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
    private final View baq;
    private final TextView bix;
    private final UserIconBox cJa;
    private final HeadImageView csn;
    private final PersonalTalkSettingActivity dHj;
    private TbSettingTextTipView dHn;
    private TbSettingTextTipView dHo;
    private RelativeLayout dHp;
    private LinearLayout dHq;
    public PersonaltalkSettingViewBlackManView dHr;
    public PersonalTalkSettingViewSettingView dHs;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dHj = personalTalkSettingActivity;
        this.dHj.setContentView(d.j.p2ptalk_setting_activity);
        this.baq = this.dHj.findViewById(d.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.baq.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dHj.getPageContext().getString(d.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dHr = (PersonaltalkSettingViewBlackManView) this.dHj.findViewById(d.h.black_status_view);
        this.dHs = (PersonalTalkSettingViewSettingView) this.dHj.findViewById(d.h.setting_detail_view);
        this.dHq = (LinearLayout) this.dHj.findViewById(d.h.user_info_lin);
        this.dHn = (TbSettingTextTipView) this.dHj.findViewById(d.h.st_delete_talk_history);
        this.dHo = (TbSettingTextTipView) this.dHj.findViewById(d.h.add_to_black);
        this.dHp = (RelativeLayout) this.dHj.findViewById(d.h.remove_from_black_man);
        this.dHn.setOnClickListener(this.dHj);
        this.dHo.setOnClickListener(this.dHj);
        this.dHp.setOnClickListener(this.dHj);
        this.dHq.setOnClickListener(this.dHj);
        this.csn = (HeadImageView) this.dHj.findViewById(d.h.photo);
        this.csn.setIsRound(true);
        this.mName = (TextView) this.dHj.findViewById(d.h.name);
        this.cJa = (UserIconBox) this.dHj.findViewById(d.h.user_icon_box);
        this.bix = (TextView) this.dHj.findViewById(d.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dHj.getLayoutMode().t(this.baq);
        this.mNavigationBar.onChangeSkinType(this.dHj.getPageContext(), i);
    }

    public void i(boolean z, int i) {
        if (z) {
            this.dHr.setSex(i);
            this.dHr.setVisibility(0);
            this.dHs.setVisibility(8);
            return;
        }
        this.dHs.setVisibility(0);
        this.dHr.setVisibility(8);
    }

    public void gS(boolean z) {
        this.dHs.gS(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            i(fVar.azO(), fVar.azN().sex.intValue());
            gS(fVar.azM());
            a(fVar.azN());
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
            this.bix.setText(dataRes.intro);
            if (this.cJa != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.cJa.a(linkedList, i, this.dHj.getResources().getDimensionPixelSize(d.f.ds28), this.dHj.getResources().getDimensionPixelSize(d.f.ds28), this.dHj.getResources().getDimensionPixelSize(d.f.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.azN() != null && (str = fVar.azN().portrait) != null && str.length() > 0) {
            this.csn.setImageResource(0);
            this.csn.c(str, 12, false);
        }
    }

    public void b(BdSwitchView.a aVar) {
        if (this.dHs != null) {
            this.dHs.setSwitchStateChangeListener(aVar);
        }
    }
}
