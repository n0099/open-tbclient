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
    private final View aYR;
    private final TextView bgX;
    private final UserIconBox cIw;
    private final HeadImageView csc;
    private final PersonalTalkSettingActivity dLi;
    private TbSettingTextTipView dLm;
    private TbSettingTextTipView dLn;
    private RelativeLayout dLo;
    private LinearLayout dLp;
    public PersonaltalkSettingViewBlackManView dLq;
    public PersonalTalkSettingViewSettingView dLr;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dLi = personalTalkSettingActivity;
        this.dLi.setContentView(d.j.p2ptalk_setting_activity);
        this.aYR = this.dLi.findViewById(d.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.aYR.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dLi.getPageContext().getString(d.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dLq = (PersonaltalkSettingViewBlackManView) this.dLi.findViewById(d.h.black_status_view);
        this.dLr = (PersonalTalkSettingViewSettingView) this.dLi.findViewById(d.h.setting_detail_view);
        this.dLp = (LinearLayout) this.dLi.findViewById(d.h.user_info_lin);
        this.dLm = (TbSettingTextTipView) this.dLi.findViewById(d.h.st_delete_talk_history);
        this.dLn = (TbSettingTextTipView) this.dLi.findViewById(d.h.add_to_black);
        this.dLo = (RelativeLayout) this.dLi.findViewById(d.h.remove_from_black_man);
        this.dLm.setOnClickListener(this.dLi);
        this.dLn.setOnClickListener(this.dLi);
        this.dLo.setOnClickListener(this.dLi);
        this.dLp.setOnClickListener(this.dLi);
        this.csc = (HeadImageView) this.dLi.findViewById(d.h.photo);
        this.csc.setIsRound(true);
        this.mName = (TextView) this.dLi.findViewById(d.h.name);
        this.cIw = (UserIconBox) this.dLi.findViewById(d.h.user_icon_box);
        this.bgX = (TextView) this.dLi.findViewById(d.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dLi.getLayoutMode().t(this.aYR);
        this.mNavigationBar.onChangeSkinType(this.dLi.getPageContext(), i);
    }

    public void i(boolean z, int i) {
        if (z) {
            this.dLq.setSex(i);
            this.dLq.setVisibility(0);
            this.dLr.setVisibility(8);
            return;
        }
        this.dLr.setVisibility(0);
        this.dLq.setVisibility(8);
    }

    public void hg(boolean z) {
        this.dLr.hg(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            i(fVar.aBi(), fVar.aBh().sex.intValue());
            hg(fVar.aBg());
            a(fVar.aBh());
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
            if (this.cIw != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.cIw.a(linkedList, i, this.dLi.getResources().getDimensionPixelSize(d.f.ds28), this.dLi.getResources().getDimensionPixelSize(d.f.ds28), this.dLi.getResources().getDimensionPixelSize(d.f.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aBh() != null && (str = fVar.aBh().portrait) != null && str.length() > 0) {
            this.csc.setImageResource(0);
            this.csc.c(str, 12, false);
        }
    }

    public void b(BdSwitchView.a aVar) {
        if (this.dLr != null) {
            this.dLr.setSwitchStateChangeListener(aVar);
        }
    }
}
