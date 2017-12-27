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
    private final TextView ceb;
    private final UserIconBox dPi;
    private final HeadImageView dyP;
    private final PersonalTalkSettingActivity eKd;
    private TbSettingTextTipView eKh;
    private TbSettingTextTipView eKi;
    private RelativeLayout eKj;
    private LinearLayout eKk;
    public PersonaltalkSettingViewBlackManView eKl;
    public PersonalTalkSettingViewSettingView eKm;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.eKd = personalTalkSettingActivity;
        this.eKd.setContentView(d.h.p2ptalk_setting_activity);
        this.mParent = this.eKd.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eKd.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eKl = (PersonaltalkSettingViewBlackManView) this.eKd.findViewById(d.g.black_status_view);
        this.eKm = (PersonalTalkSettingViewSettingView) this.eKd.findViewById(d.g.setting_detail_view);
        this.eKk = (LinearLayout) this.eKd.findViewById(d.g.user_info_lin);
        this.eKh = (TbSettingTextTipView) this.eKd.findViewById(d.g.st_delete_talk_history);
        this.eKi = (TbSettingTextTipView) this.eKd.findViewById(d.g.add_to_black);
        this.eKj = (RelativeLayout) this.eKd.findViewById(d.g.remove_from_black_man);
        this.eKh.setOnClickListener(this.eKd);
        this.eKi.setOnClickListener(this.eKd);
        this.eKj.setOnClickListener(this.eKd);
        this.eKk.setOnClickListener(this.eKd);
        this.dyP = (HeadImageView) this.eKd.findViewById(d.g.photo);
        this.dyP.setIsRound(true);
        this.mName = (TextView) this.eKd.findViewById(d.g.name);
        this.dPi = (UserIconBox) this.eKd.findViewById(d.g.user_icon_box);
        this.ceb = (TextView) this.eKd.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.eKd.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eKd.getPageContext(), i);
    }

    public void k(boolean z, int i) {
        if (z) {
            this.eKl.setSex(i);
            this.eKl.setVisibility(0);
            this.eKm.setVisibility(8);
            return;
        }
        this.eKm.setVisibility(0);
        this.eKl.setVisibility(8);
    }

    public void hO(boolean z) {
        this.eKm.hO(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            k(fVar.aKX(), fVar.aKW().sex.intValue());
            hO(fVar.aKV());
            a(fVar.aKW());
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
            this.ceb.setText(dataRes.intro);
            if (this.dPi != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dPi.a(linkedList, i, this.eKd.getResources().getDimensionPixelSize(d.e.ds28), this.eKd.getResources().getDimensionPixelSize(d.e.ds28), this.eKd.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aKW() != null && (str = fVar.aKW().portrait) != null && str.length() > 0) {
            this.dyP.setImageResource(0);
            this.dyP.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.eKm != null) {
            this.eKm.setSwitchStateChangeListener(aVar);
        }
    }
}
