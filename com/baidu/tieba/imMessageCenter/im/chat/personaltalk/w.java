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
import com.baidu.tieba.u;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class w {
    private final View DP;
    private final TextView bAC;
    private final HeadImageView bHl;
    private final UserIconBox bVj;
    private final TextView cIn;
    private final PersonalTalkSettingActivity dcp;
    private TbSettingTextTipView dct;
    private TbSettingTextTipView dcv;
    private RelativeLayout dcw;
    private LinearLayout dcx;
    public PersonaltalkSettingViewBlackManView dcy;
    public PersonalTalkSettingViewSettingView dcz;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dcp = personalTalkSettingActivity;
        this.dcp.setContentView(u.h.p2ptalk_setting_activity);
        this.DP = this.dcp.findViewById(u.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.DP.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dcp.getPageContext().getString(u.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dcy = (PersonaltalkSettingViewBlackManView) this.dcp.findViewById(u.g.black_status_view);
        this.dcz = (PersonalTalkSettingViewSettingView) this.dcp.findViewById(u.g.setting_detail_view);
        this.dcx = (LinearLayout) this.dcp.findViewById(u.g.user_info_lin);
        this.dct = (TbSettingTextTipView) this.dcp.findViewById(u.g.st_delete_talk_history);
        this.dcv = (TbSettingTextTipView) this.dcp.findViewById(u.g.add_to_black);
        this.dcw = (RelativeLayout) this.dcp.findViewById(u.g.remove_from_black_man);
        this.dct.setOnClickListener(this.dcp);
        this.dcv.setOnClickListener(this.dcp);
        this.dcw.setOnClickListener(this.dcp);
        this.dcx.setOnClickListener(this.dcp);
        this.bHl = (HeadImageView) this.dcp.findViewById(u.g.photo);
        this.bHl.setIsRound(true);
        this.cIn = (TextView) this.dcp.findViewById(u.g.name);
        this.bVj = (UserIconBox) this.dcp.findViewById(u.g.user_icon_box);
        this.bAC = (TextView) this.dcp.findViewById(u.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dcp.getLayoutMode().w(this.DP);
        this.mNavigationBar.onChangeSkinType(this.dcp.getPageContext(), i);
    }

    public void k(boolean z, int i) {
        if (z) {
            this.dcy.setSex(i);
            this.dcy.setVisibility(0);
            this.dcz.setVisibility(8);
            return;
        }
        this.dcz.setVisibility(0);
        this.dcy.setVisibility(8);
    }

    public void fT(boolean z) {
        this.dcz.fT(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            k(rVar.asn(), rVar.asm().sex.intValue());
            fT(rVar.asl());
            a(rVar.asm());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.cIn.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.cIn.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.cIn.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.cIn.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.f.icon_pop_girl, 0);
            }
            this.bAC.setText(dataRes.intro);
            if (this.bVj != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bVj.a(linkedList, i, this.dcp.getResources().getDimensionPixelSize(u.e.ds28), this.dcp.getResources().getDimensionPixelSize(u.e.ds28), this.dcp.getResources().getDimensionPixelSize(u.e.ds4));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.asm() != null && (str = rVar.asm().portrait) != null && str.length() > 0) {
            this.bHl.setImageResource(0);
            this.bHl.c(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.dcz != null) {
            this.dcz.setSwitchStateChangeListener(aVar);
        }
    }
}
