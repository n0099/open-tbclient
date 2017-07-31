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
    private final View aZg;
    private final TextView bgX;
    private final HeadImageView cld;
    private final UserIconBox czs;
    private final PersonalTalkSettingActivity dBM;
    private TbSettingTextTipView dBQ;
    private TbSettingTextTipView dBR;
    private RelativeLayout dBS;
    private LinearLayout dBT;
    public PersonaltalkSettingViewBlackManView dBU;
    public PersonalTalkSettingViewSettingView dBV;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dBM = personalTalkSettingActivity;
        this.dBM.setContentView(d.j.p2ptalk_setting_activity);
        this.aZg = this.dBM.findViewById(d.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.aZg.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dBM.getPageContext().getString(d.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dBU = (PersonaltalkSettingViewBlackManView) this.dBM.findViewById(d.h.black_status_view);
        this.dBV = (PersonalTalkSettingViewSettingView) this.dBM.findViewById(d.h.setting_detail_view);
        this.dBT = (LinearLayout) this.dBM.findViewById(d.h.user_info_lin);
        this.dBQ = (TbSettingTextTipView) this.dBM.findViewById(d.h.st_delete_talk_history);
        this.dBR = (TbSettingTextTipView) this.dBM.findViewById(d.h.add_to_black);
        this.dBS = (RelativeLayout) this.dBM.findViewById(d.h.remove_from_black_man);
        this.dBQ.setOnClickListener(this.dBM);
        this.dBR.setOnClickListener(this.dBM);
        this.dBS.setOnClickListener(this.dBM);
        this.dBT.setOnClickListener(this.dBM);
        this.cld = (HeadImageView) this.dBM.findViewById(d.h.photo);
        this.cld.setIsRound(true);
        this.mName = (TextView) this.dBM.findViewById(d.h.name);
        this.czs = (UserIconBox) this.dBM.findViewById(d.h.user_icon_box);
        this.bgX = (TextView) this.dBM.findViewById(d.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dBM.getLayoutMode().t(this.aZg);
        this.mNavigationBar.onChangeSkinType(this.dBM.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.dBU.setSex(i);
            this.dBU.setVisibility(0);
            this.dBV.setVisibility(8);
            return;
        }
        this.dBV.setVisibility(0);
        this.dBU.setVisibility(8);
    }

    public void gU(boolean z) {
        this.dBV.gU(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.ayG(), fVar.ayF().sex.intValue());
            gU(fVar.ayE());
            a(fVar.ayF());
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
            if (this.czs != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.czs.a(linkedList, i, this.dBM.getResources().getDimensionPixelSize(d.f.ds28), this.dBM.getResources().getDimensionPixelSize(d.f.ds28), this.dBM.getResources().getDimensionPixelSize(d.f.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.ayF() != null && (str = fVar.ayF().portrait) != null && str.length() > 0) {
            this.cld.setImageResource(0);
            this.cld.c(str, 12, false);
        }
    }

    public void b(BdSwitchView.a aVar) {
        if (this.dBV != null) {
            this.dBV.setSwitchStateChangeListener(aVar);
        }
    }
}
