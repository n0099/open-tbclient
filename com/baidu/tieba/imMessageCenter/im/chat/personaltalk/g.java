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
    private final View baE;
    private final TextView biL;
    private final UserIconBox cJm;
    private final HeadImageView csz;
    private TbSettingTextTipView dHB;
    private TbSettingTextTipView dHC;
    private RelativeLayout dHD;
    private LinearLayout dHE;
    public PersonaltalkSettingViewBlackManView dHF;
    public PersonalTalkSettingViewSettingView dHG;
    private final PersonalTalkSettingActivity dHx;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dHx = personalTalkSettingActivity;
        this.dHx.setContentView(d.j.p2ptalk_setting_activity);
        this.baE = this.dHx.findViewById(d.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.baE.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dHx.getPageContext().getString(d.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dHF = (PersonaltalkSettingViewBlackManView) this.dHx.findViewById(d.h.black_status_view);
        this.dHG = (PersonalTalkSettingViewSettingView) this.dHx.findViewById(d.h.setting_detail_view);
        this.dHE = (LinearLayout) this.dHx.findViewById(d.h.user_info_lin);
        this.dHB = (TbSettingTextTipView) this.dHx.findViewById(d.h.st_delete_talk_history);
        this.dHC = (TbSettingTextTipView) this.dHx.findViewById(d.h.add_to_black);
        this.dHD = (RelativeLayout) this.dHx.findViewById(d.h.remove_from_black_man);
        this.dHB.setOnClickListener(this.dHx);
        this.dHC.setOnClickListener(this.dHx);
        this.dHD.setOnClickListener(this.dHx);
        this.dHE.setOnClickListener(this.dHx);
        this.csz = (HeadImageView) this.dHx.findViewById(d.h.photo);
        this.csz.setIsRound(true);
        this.mName = (TextView) this.dHx.findViewById(d.h.name);
        this.cJm = (UserIconBox) this.dHx.findViewById(d.h.user_icon_box);
        this.biL = (TextView) this.dHx.findViewById(d.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dHx.getLayoutMode().t(this.baE);
        this.mNavigationBar.onChangeSkinType(this.dHx.getPageContext(), i);
    }

    public void i(boolean z, int i) {
        if (z) {
            this.dHF.setSex(i);
            this.dHF.setVisibility(0);
            this.dHG.setVisibility(8);
            return;
        }
        this.dHG.setVisibility(0);
        this.dHF.setVisibility(8);
    }

    public void gT(boolean z) {
        this.dHG.gT(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            i(fVar.azT(), fVar.azS().sex.intValue());
            gT(fVar.azR());
            a(fVar.azS());
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
            this.biL.setText(dataRes.intro);
            if (this.cJm != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.cJm.a(linkedList, i, this.dHx.getResources().getDimensionPixelSize(d.f.ds28), this.dHx.getResources().getDimensionPixelSize(d.f.ds28), this.dHx.getResources().getDimensionPixelSize(d.f.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.azS() != null && (str = fVar.azS().portrait) != null && str.length() > 0) {
            this.csz.setImageResource(0);
            this.csz.c(str, 12, false);
        }
    }

    public void b(BdSwitchView.a aVar) {
        if (this.dHG != null) {
            this.dHG.setSwitchStateChangeListener(aVar);
        }
    }
}
