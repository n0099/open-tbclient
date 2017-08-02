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
    private final View aXV;
    private final TextView bfM;
    private final HeadImageView cjV;
    private final UserIconBox cxU;
    private TbSettingTextTipView dAA;
    private RelativeLayout dAB;
    private LinearLayout dAC;
    public PersonaltalkSettingViewBlackManView dAD;
    public PersonalTalkSettingViewSettingView dAE;
    private final PersonalTalkSettingActivity dAv;
    private TbSettingTextTipView dAz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dAv = personalTalkSettingActivity;
        this.dAv.setContentView(d.j.p2ptalk_setting_activity);
        this.aXV = this.dAv.findViewById(d.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.aXV.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dAv.getPageContext().getString(d.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dAD = (PersonaltalkSettingViewBlackManView) this.dAv.findViewById(d.h.black_status_view);
        this.dAE = (PersonalTalkSettingViewSettingView) this.dAv.findViewById(d.h.setting_detail_view);
        this.dAC = (LinearLayout) this.dAv.findViewById(d.h.user_info_lin);
        this.dAz = (TbSettingTextTipView) this.dAv.findViewById(d.h.st_delete_talk_history);
        this.dAA = (TbSettingTextTipView) this.dAv.findViewById(d.h.add_to_black);
        this.dAB = (RelativeLayout) this.dAv.findViewById(d.h.remove_from_black_man);
        this.dAz.setOnClickListener(this.dAv);
        this.dAA.setOnClickListener(this.dAv);
        this.dAB.setOnClickListener(this.dAv);
        this.dAC.setOnClickListener(this.dAv);
        this.cjV = (HeadImageView) this.dAv.findViewById(d.h.photo);
        this.cjV.setIsRound(true);
        this.mName = (TextView) this.dAv.findViewById(d.h.name);
        this.cxU = (UserIconBox) this.dAv.findViewById(d.h.user_icon_box);
        this.bfM = (TextView) this.dAv.findViewById(d.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dAv.getLayoutMode().t(this.aXV);
        this.mNavigationBar.onChangeSkinType(this.dAv.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.dAD.setSex(i);
            this.dAD.setVisibility(0);
            this.dAE.setVisibility(8);
            return;
        }
        this.dAE.setVisibility(0);
        this.dAD.setVisibility(8);
    }

    public void gU(boolean z) {
        this.dAE.gU(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.ayv(), fVar.ayu().sex.intValue());
            gU(fVar.ayt());
            a(fVar.ayu());
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
            this.bfM.setText(dataRes.intro);
            if (this.cxU != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.cxU.a(linkedList, i, this.dAv.getResources().getDimensionPixelSize(d.f.ds28), this.dAv.getResources().getDimensionPixelSize(d.f.ds28), this.dAv.getResources().getDimensionPixelSize(d.f.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.ayu() != null && (str = fVar.ayu().portrait) != null && str.length() > 0) {
            this.cjV.setImageResource(0);
            this.cjV.c(str, 12, false);
        }
    }

    public void b(BdSwitchView.a aVar) {
        if (this.dAE != null) {
            this.dAE.setSwitchStateChangeListener(aVar);
        }
    }
}
