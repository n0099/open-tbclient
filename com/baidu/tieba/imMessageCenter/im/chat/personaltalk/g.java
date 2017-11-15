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
    private final View bbf;
    private final TextView bjS;
    private final HeadImageView cAd;
    private final UserIconBox cSG;
    private final PersonalTalkSettingActivity dPc;
    private TbSettingTextTipView dPg;
    private TbSettingTextTipView dPh;
    private RelativeLayout dPi;
    private LinearLayout dPj;
    public PersonaltalkSettingViewBlackManView dPk;
    public PersonalTalkSettingViewSettingView dPl;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dPc = personalTalkSettingActivity;
        this.dPc.setContentView(d.h.p2ptalk_setting_activity);
        this.bbf = this.dPc.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.bbf.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dPc.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dPk = (PersonaltalkSettingViewBlackManView) this.dPc.findViewById(d.g.black_status_view);
        this.dPl = (PersonalTalkSettingViewSettingView) this.dPc.findViewById(d.g.setting_detail_view);
        this.dPj = (LinearLayout) this.dPc.findViewById(d.g.user_info_lin);
        this.dPg = (TbSettingTextTipView) this.dPc.findViewById(d.g.st_delete_talk_history);
        this.dPh = (TbSettingTextTipView) this.dPc.findViewById(d.g.add_to_black);
        this.dPi = (RelativeLayout) this.dPc.findViewById(d.g.remove_from_black_man);
        this.dPg.setOnClickListener(this.dPc);
        this.dPh.setOnClickListener(this.dPc);
        this.dPi.setOnClickListener(this.dPc);
        this.dPj.setOnClickListener(this.dPc);
        this.cAd = (HeadImageView) this.dPc.findViewById(d.g.photo);
        this.cAd.setIsRound(true);
        this.mName = (TextView) this.dPc.findViewById(d.g.name);
        this.cSG = (UserIconBox) this.dPc.findViewById(d.g.user_icon_box);
        this.bjS = (TextView) this.dPc.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dPc.getLayoutMode().t(this.bbf);
        this.mNavigationBar.onChangeSkinType(this.dPc.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.dPk.setSex(i);
            this.dPk.setVisibility(0);
            this.dPl.setVisibility(8);
            return;
        }
        this.dPl.setVisibility(0);
        this.dPk.setVisibility(8);
    }

    public void gU(boolean z) {
        this.dPl.gU(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.aCn(), fVar.aCm().sex.intValue());
            gU(fVar.aCl());
            a(fVar.aCm());
            f(fVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_pop_girl, 0);
            }
            this.bjS.setText(dataRes.intro);
            if (this.cSG != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.cSG.a(linkedList, i, this.dPc.getResources().getDimensionPixelSize(d.e.ds28), this.dPc.getResources().getDimensionPixelSize(d.e.ds28), this.dPc.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aCm() != null && (str = fVar.aCm().portrait) != null && str.length() > 0) {
            this.cAd.setImageResource(0);
            this.cAd.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.dPl != null) {
            this.dPl.setSwitchStateChangeListener(aVar);
        }
    }
}
