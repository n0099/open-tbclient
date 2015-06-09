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
    private final TextView aJx;
    private final HeadImageView aKz;
    private final UserIconBox aQL;
    private final TextView baI;
    private final PersonalTalkSettingActivity bsM;
    private TbSettingTextTipView bsQ;
    private TbSettingTextTipView bsR;
    private RelativeLayout bsS;
    private LinearLayout bsT;
    public PersonaltalkSettingViewBlackManView bsU;
    public PersonalTalkSettingViewSettingView bsV;
    private final NavigationBar mNavigationBar;

    public y(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bsM = personalTalkSettingActivity;
        this.bsM.setContentView(com.baidu.tieba.r.p2ptalk_setting_activity);
        this.LG = this.bsM.findViewById(com.baidu.tieba.q.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.LG.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bsM.getPageContext().getString(com.baidu.tieba.t.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bsU = (PersonaltalkSettingViewBlackManView) this.bsM.findViewById(com.baidu.tieba.q.black_status_view);
        this.bsV = (PersonalTalkSettingViewSettingView) this.bsM.findViewById(com.baidu.tieba.q.setting_detail_view);
        this.bsT = (LinearLayout) this.bsM.findViewById(com.baidu.tieba.q.user_info_lin);
        this.bsQ = (TbSettingTextTipView) this.bsM.findViewById(com.baidu.tieba.q.st_delete_talk_history);
        this.bsR = (TbSettingTextTipView) this.bsM.findViewById(com.baidu.tieba.q.add_to_black);
        this.bsS = (RelativeLayout) this.bsM.findViewById(com.baidu.tieba.q.remove_from_black_man);
        this.bsQ.setOnClickListener(this.bsM);
        this.bsR.setOnClickListener(this.bsM);
        this.bsS.setOnClickListener(this.bsM);
        this.bsT.setOnClickListener(this.bsM);
        this.aKz = (HeadImageView) this.bsM.findViewById(com.baidu.tieba.q.photo);
        this.aKz.setIsRound(true);
        this.baI = (TextView) this.bsM.findViewById(com.baidu.tieba.q.name);
        this.aQL = (UserIconBox) this.bsM.findViewById(com.baidu.tieba.q.user_icon_box);
        this.aJx = (TextView) this.bsM.findViewById(com.baidu.tieba.q.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.bsM.getLayoutMode().j(this.LG);
        this.mNavigationBar.onChangeSkinType(this.bsM.getPageContext(), i);
    }

    public void b(boolean z, int i) {
        if (z) {
            this.bsU.setSex(i);
            this.bsU.setVisibility(0);
            this.bsV.setVisibility(8);
            return;
        }
        this.bsV.setVisibility(0);
        this.bsU.setVisibility(8);
    }

    public void ds(boolean z) {
        this.bsV.ds(z);
    }

    public void e(s sVar) {
        if (sVar != null) {
            b(sVar.VF(), sVar.VE().sex.intValue());
            ds(sVar.VD());
            a(sVar.VE());
            f(sVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 3;
        if (dataRes != null) {
            this.baI.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.baI.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.p.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 4;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.baI.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.baI.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.p.icon_pop_girl, 0);
            }
            this.aJx.setText(dataRes.intro);
            if (this.aQL != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.aQL.a(linkedList, i, this.bsM.getResources().getDimensionPixelSize(com.baidu.tieba.o.person_icon_width), this.bsM.getResources().getDimensionPixelSize(com.baidu.tieba.o.person_icon_height), this.bsM.getResources().getDimensionPixelSize(com.baidu.tieba.o.person_icon_margin));
            }
        }
    }

    public void f(s sVar) {
        String str;
        if (sVar != null && sVar.VE() != null && (str = sVar.VE().portrait) != null && str.length() > 0) {
            this.aKz.setImageResource(0);
            this.aKz.c(str, 12, false);
        }
    }

    public void a(com.baidu.adp.widget.BdSwitchView.b bVar) {
        if (this.bsV != null) {
            this.bsV.setSwitchStateChangeListener(bVar);
        }
    }
}
