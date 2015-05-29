package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.IconData;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class y {
    private final View LG;
    private final TextView aJw;
    private final HeadImageView aKy;
    private final UserIconBox aQK;
    private final TextView baH;
    private final PersonalTalkSettingActivity bsL;
    private TbSettingTextTipView bsP;
    private TbSettingTextTipView bsQ;
    private RelativeLayout bsR;
    private LinearLayout bsS;
    public PersonaltalkSettingViewBlackManView bsT;
    public PersonalTalkSettingViewSettingView bsU;
    private final NavigationBar mNavigationBar;

    public y(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bsL = personalTalkSettingActivity;
        this.bsL.setContentView(com.baidu.tieba.r.p2ptalk_setting_activity);
        this.LG = this.bsL.findViewById(com.baidu.tieba.q.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.LG.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bsL.getPageContext().getString(com.baidu.tieba.t.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bsT = (PersonaltalkSettingViewBlackManView) this.bsL.findViewById(com.baidu.tieba.q.black_status_view);
        this.bsU = (PersonalTalkSettingViewSettingView) this.bsL.findViewById(com.baidu.tieba.q.setting_detail_view);
        this.bsS = (LinearLayout) this.bsL.findViewById(com.baidu.tieba.q.user_info_lin);
        this.bsP = (TbSettingTextTipView) this.bsL.findViewById(com.baidu.tieba.q.st_delete_talk_history);
        this.bsQ = (TbSettingTextTipView) this.bsL.findViewById(com.baidu.tieba.q.add_to_black);
        this.bsR = (RelativeLayout) this.bsL.findViewById(com.baidu.tieba.q.remove_from_black_man);
        this.bsP.setOnClickListener(this.bsL);
        this.bsQ.setOnClickListener(this.bsL);
        this.bsR.setOnClickListener(this.bsL);
        this.bsS.setOnClickListener(this.bsL);
        this.aKy = (HeadImageView) this.bsL.findViewById(com.baidu.tieba.q.photo);
        this.aKy.setIsRound(true);
        this.baH = (TextView) this.bsL.findViewById(com.baidu.tieba.q.name);
        this.aQK = (UserIconBox) this.bsL.findViewById(com.baidu.tieba.q.user_icon_box);
        this.aJw = (TextView) this.bsL.findViewById(com.baidu.tieba.q.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.bsL.getLayoutMode().j(this.LG);
        this.mNavigationBar.onChangeSkinType(this.bsL.getPageContext(), i);
    }

    public void b(boolean z, int i) {
        if (z) {
            this.bsT.setSex(i);
            this.bsT.setVisibility(0);
            this.bsU.setVisibility(8);
            return;
        }
        this.bsU.setVisibility(0);
        this.bsT.setVisibility(8);
    }

    public void ds(boolean z) {
        this.bsU.ds(z);
    }

    public void e(s sVar) {
        if (sVar != null) {
            b(sVar.VE(), sVar.VD().sex.intValue());
            ds(sVar.VC());
            a(sVar.VD());
            f(sVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 3;
        if (dataRes != null) {
            this.baH.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.baH.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.p.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 4;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.baH.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.baH.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.p.icon_pop_girl, 0);
            }
            this.aJw.setText(dataRes.intro);
            if (this.aQK != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.aQK.a(linkedList, i, this.bsL.getResources().getDimensionPixelSize(com.baidu.tieba.o.person_icon_width), this.bsL.getResources().getDimensionPixelSize(com.baidu.tieba.o.person_icon_height), this.bsL.getResources().getDimensionPixelSize(com.baidu.tieba.o.person_icon_margin));
            }
        }
    }

    public void f(s sVar) {
        String str;
        if (sVar != null && sVar.VD() != null && (str = sVar.VD().portrait) != null && str.length() > 0) {
            this.aKy.setImageResource(0);
            this.aKy.c(str, 12, false);
        }
    }

    public void a(com.baidu.adp.widget.BdSwitchView.b bVar) {
        if (this.bsU != null) {
            this.bsU.setSwitchStateChangeListener(bVar);
        }
    }
}
