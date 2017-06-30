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
import com.baidu.tieba.w;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes2.dex */
public class w {
    private final View aWF;
    private final TextView beb;
    private final HeadImageView cej;
    private final UserIconBox cqK;
    private final PersonalTalkSettingActivity drT;
    private TbSettingTextTipView drX;
    private TbSettingTextTipView drY;
    private RelativeLayout drZ;
    private LinearLayout dsa;
    public PersonaltalkSettingViewBlackManView dsb;
    public PersonalTalkSettingViewSettingView dsc;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.drT = personalTalkSettingActivity;
        this.drT.setContentView(w.j.p2ptalk_setting_activity);
        this.aWF = this.drT.findViewById(w.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.aWF.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.drT.getPageContext().getString(w.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dsb = (PersonaltalkSettingViewBlackManView) this.drT.findViewById(w.h.black_status_view);
        this.dsc = (PersonalTalkSettingViewSettingView) this.drT.findViewById(w.h.setting_detail_view);
        this.dsa = (LinearLayout) this.drT.findViewById(w.h.user_info_lin);
        this.drX = (TbSettingTextTipView) this.drT.findViewById(w.h.st_delete_talk_history);
        this.drY = (TbSettingTextTipView) this.drT.findViewById(w.h.add_to_black);
        this.drZ = (RelativeLayout) this.drT.findViewById(w.h.remove_from_black_man);
        this.drX.setOnClickListener(this.drT);
        this.drY.setOnClickListener(this.drT);
        this.drZ.setOnClickListener(this.drT);
        this.dsa.setOnClickListener(this.drT);
        this.cej = (HeadImageView) this.drT.findViewById(w.h.photo);
        this.cej.setIsRound(true);
        this.mName = (TextView) this.drT.findViewById(w.h.name);
        this.cqK = (UserIconBox) this.drT.findViewById(w.h.user_icon_box);
        this.beb = (TextView) this.drT.findViewById(w.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.drT.getLayoutMode().t(this.aWF);
        this.mNavigationBar.onChangeSkinType(this.drT.getPageContext(), i);
    }

    public void i(boolean z, int i) {
        if (z) {
            this.dsb.setSex(i);
            this.dsb.setVisibility(0);
            this.dsc.setVisibility(8);
            return;
        }
        this.dsc.setVisibility(0);
        this.dsb.setVisibility(8);
    }

    public void gG(boolean z) {
        this.dsc.gG(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            i(rVar.awS(), rVar.awR().sex.intValue());
            gG(rVar.awQ());
            a(rVar.awR());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_pop_girl, 0);
            }
            this.beb.setText(dataRes.intro);
            if (this.cqK != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.cqK.a(linkedList, i, this.drT.getResources().getDimensionPixelSize(w.f.ds28), this.drT.getResources().getDimensionPixelSize(w.f.ds28), this.drT.getResources().getDimensionPixelSize(w.f.ds4));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.awR() != null && (str = rVar.awR().portrait) != null && str.length() > 0) {
            this.cej.setImageResource(0);
            this.cej.c(str, 12, false);
        }
    }

    public void b(BdSwitchView.a aVar) {
        if (this.dsc != null) {
            this.dsc.setSwitchStateChangeListener(aVar);
        }
    }
}
