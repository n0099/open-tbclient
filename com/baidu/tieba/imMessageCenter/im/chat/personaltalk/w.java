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
/* loaded from: classes.dex */
public class w {
    private final View aXo;
    private final HeadImageView bRt;
    private final TextView bam;
    private final UserIconBox cfz;
    private final PersonalTalkSettingActivity dkA;
    private TbSettingTextTipView dkE;
    private TbSettingTextTipView dkF;
    private RelativeLayout dkG;
    private LinearLayout dkH;
    public PersonaltalkSettingViewBlackManView dkI;
    public PersonalTalkSettingViewSettingView dkJ;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dkA = personalTalkSettingActivity;
        this.dkA.setContentView(w.j.p2ptalk_setting_activity);
        this.aXo = this.dkA.findViewById(w.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.aXo.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dkA.getPageContext().getString(w.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dkI = (PersonaltalkSettingViewBlackManView) this.dkA.findViewById(w.h.black_status_view);
        this.dkJ = (PersonalTalkSettingViewSettingView) this.dkA.findViewById(w.h.setting_detail_view);
        this.dkH = (LinearLayout) this.dkA.findViewById(w.h.user_info_lin);
        this.dkE = (TbSettingTextTipView) this.dkA.findViewById(w.h.st_delete_talk_history);
        this.dkF = (TbSettingTextTipView) this.dkA.findViewById(w.h.add_to_black);
        this.dkG = (RelativeLayout) this.dkA.findViewById(w.h.remove_from_black_man);
        this.dkE.setOnClickListener(this.dkA);
        this.dkF.setOnClickListener(this.dkA);
        this.dkG.setOnClickListener(this.dkA);
        this.dkH.setOnClickListener(this.dkA);
        this.bRt = (HeadImageView) this.dkA.findViewById(w.h.photo);
        this.bRt.setIsRound(true);
        this.mName = (TextView) this.dkA.findViewById(w.h.name);
        this.cfz = (UserIconBox) this.dkA.findViewById(w.h.user_icon_box);
        this.bam = (TextView) this.dkA.findViewById(w.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dkA.getLayoutMode().t(this.aXo);
        this.mNavigationBar.onChangeSkinType(this.dkA.getPageContext(), i);
    }

    public void i(boolean z, int i) {
        if (z) {
            this.dkI.setSex(i);
            this.dkI.setVisibility(0);
            this.dkJ.setVisibility(8);
            return;
        }
        this.dkJ.setVisibility(0);
        this.dkI.setVisibility(8);
    }

    public void gA(boolean z) {
        this.dkJ.gA(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            i(rVar.avs(), rVar.avr().sex.intValue());
            gA(rVar.avq());
            a(rVar.avr());
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
            this.bam.setText(dataRes.intro);
            if (this.cfz != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.cfz.a(linkedList, i, this.dkA.getResources().getDimensionPixelSize(w.f.ds28), this.dkA.getResources().getDimensionPixelSize(w.f.ds28), this.dkA.getResources().getDimensionPixelSize(w.f.ds4));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.avr() != null && (str = rVar.avr().portrait) != null && str.length() > 0) {
            this.bRt.setImageResource(0);
            this.bRt.c(str, 12, false);
        }
    }

    public void c(BdSwitchView.a aVar) {
        if (this.dkJ != null) {
            this.dkJ.setSwitchStateChangeListener(aVar);
        }
    }
}
