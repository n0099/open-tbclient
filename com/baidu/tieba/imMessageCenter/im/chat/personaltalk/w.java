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
import com.baidu.tieba.t;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class w {
    private final View MQ;
    private final TextView bPr;
    private final TextView bbT;
    private final HeadImageView beU;
    private final UserIconBox bqH;
    private final PersonalTalkSettingActivity ciA;
    private TbSettingTextTipView ciE;
    private TbSettingTextTipView ciF;
    private RelativeLayout ciG;
    private LinearLayout ciH;
    public PersonaltalkSettingViewBlackManView ciI;
    public PersonalTalkSettingViewSettingView ciJ;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ciA = personalTalkSettingActivity;
        this.ciA.setContentView(t.h.p2ptalk_setting_activity);
        this.MQ = this.ciA.findViewById(t.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.MQ.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ciA.getPageContext().getString(t.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ciI = (PersonaltalkSettingViewBlackManView) this.ciA.findViewById(t.g.black_status_view);
        this.ciJ = (PersonalTalkSettingViewSettingView) this.ciA.findViewById(t.g.setting_detail_view);
        this.ciH = (LinearLayout) this.ciA.findViewById(t.g.user_info_lin);
        this.ciE = (TbSettingTextTipView) this.ciA.findViewById(t.g.st_delete_talk_history);
        this.ciF = (TbSettingTextTipView) this.ciA.findViewById(t.g.add_to_black);
        this.ciG = (RelativeLayout) this.ciA.findViewById(t.g.remove_from_black_man);
        this.ciE.setOnClickListener(this.ciA);
        this.ciF.setOnClickListener(this.ciA);
        this.ciG.setOnClickListener(this.ciA);
        this.ciH.setOnClickListener(this.ciA);
        this.beU = (HeadImageView) this.ciA.findViewById(t.g.photo);
        this.beU.setIsRound(true);
        this.bPr = (TextView) this.ciA.findViewById(t.g.name);
        this.bqH = (UserIconBox) this.ciA.findViewById(t.g.user_icon_box);
        this.bbT = (TextView) this.ciA.findViewById(t.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.ciA.getLayoutMode().x(this.MQ);
        this.mNavigationBar.onChangeSkinType(this.ciA.getPageContext(), i);
    }

    public void d(boolean z, int i) {
        if (z) {
            this.ciI.setSex(i);
            this.ciI.setVisibility(0);
            this.ciJ.setVisibility(8);
            return;
        }
        this.ciJ.setVisibility(0);
        this.ciI.setVisibility(8);
    }

    public void ee(boolean z) {
        this.ciJ.ee(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            d(rVar.afL(), rVar.afK().sex.intValue());
            ee(rVar.afJ());
            a(rVar.afK());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.bPr.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.bPr.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.bPr.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.bPr.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_pop_girl, 0);
            }
            this.bbT.setText(dataRes.intro);
            if (this.bqH != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bqH.a(linkedList, i, this.ciA.getResources().getDimensionPixelSize(t.e.person_icon_width), this.ciA.getResources().getDimensionPixelSize(t.e.person_icon_height), this.ciA.getResources().getDimensionPixelSize(t.e.person_icon_margin));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.afK() != null && (str = rVar.afK().portrait) != null && str.length() > 0) {
            this.beU.setImageResource(0);
            this.beU.d(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.ciJ != null) {
            this.ciJ.setSwitchStateChangeListener(aVar);
        }
    }
}
