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
    private final View aVm;
    private final HeadImageView bWb;
    private final TextView bbY;
    private final UserIconBox ciK;
    private final PersonalTalkSettingActivity djX;
    private TbSettingTextTipView dkb;
    private TbSettingTextTipView dkc;
    private RelativeLayout dkd;
    private LinearLayout dke;
    public PersonaltalkSettingViewBlackManView dkf;
    public PersonalTalkSettingViewSettingView dkg;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.djX = personalTalkSettingActivity;
        this.djX.setContentView(w.j.p2ptalk_setting_activity);
        this.aVm = this.djX.findViewById(w.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.aVm.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.djX.getPageContext().getString(w.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dkf = (PersonaltalkSettingViewBlackManView) this.djX.findViewById(w.h.black_status_view);
        this.dkg = (PersonalTalkSettingViewSettingView) this.djX.findViewById(w.h.setting_detail_view);
        this.dke = (LinearLayout) this.djX.findViewById(w.h.user_info_lin);
        this.dkb = (TbSettingTextTipView) this.djX.findViewById(w.h.st_delete_talk_history);
        this.dkc = (TbSettingTextTipView) this.djX.findViewById(w.h.add_to_black);
        this.dkd = (RelativeLayout) this.djX.findViewById(w.h.remove_from_black_man);
        this.dkb.setOnClickListener(this.djX);
        this.dkc.setOnClickListener(this.djX);
        this.dkd.setOnClickListener(this.djX);
        this.dke.setOnClickListener(this.djX);
        this.bWb = (HeadImageView) this.djX.findViewById(w.h.photo);
        this.bWb.setIsRound(true);
        this.mName = (TextView) this.djX.findViewById(w.h.name);
        this.ciK = (UserIconBox) this.djX.findViewById(w.h.user_icon_box);
        this.bbY = (TextView) this.djX.findViewById(w.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.djX.getLayoutMode().t(this.aVm);
        this.mNavigationBar.onChangeSkinType(this.djX.getPageContext(), i);
    }

    public void i(boolean z, int i) {
        if (z) {
            this.dkf.setSex(i);
            this.dkf.setVisibility(0);
            this.dkg.setVisibility(8);
            return;
        }
        this.dkg.setVisibility(0);
        this.dkf.setVisibility(8);
    }

    public void go(boolean z) {
        this.dkg.go(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            i(rVar.atk(), rVar.atj().sex.intValue());
            go(rVar.ati());
            a(rVar.atj());
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
            this.bbY.setText(dataRes.intro);
            if (this.ciK != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.ciK.a(linkedList, i, this.djX.getResources().getDimensionPixelSize(w.f.ds28), this.djX.getResources().getDimensionPixelSize(w.f.ds28), this.djX.getResources().getDimensionPixelSize(w.f.ds4));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.atj() != null && (str = rVar.atj().portrait) != null && str.length() > 0) {
            this.bWb.setImageResource(0);
            this.bWb.c(str, 12, false);
        }
    }

    public void b(BdSwitchView.a aVar) {
        if (this.dkg != null) {
            this.dkg.setSwitchStateChangeListener(aVar);
        }
    }
}
