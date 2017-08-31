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
    private final View aYU;
    private final TextView bha;
    private final UserIconBox cHC;
    private final HeadImageView crk;
    private final PersonalTalkSettingActivity dKn;
    private TbSettingTextTipView dKr;
    private TbSettingTextTipView dKs;
    private RelativeLayout dKt;
    private LinearLayout dKu;
    public PersonaltalkSettingViewBlackManView dKv;
    public PersonalTalkSettingViewSettingView dKw;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dKn = personalTalkSettingActivity;
        this.dKn.setContentView(d.j.p2ptalk_setting_activity);
        this.aYU = this.dKn.findViewById(d.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.aYU.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dKn.getPageContext().getString(d.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dKv = (PersonaltalkSettingViewBlackManView) this.dKn.findViewById(d.h.black_status_view);
        this.dKw = (PersonalTalkSettingViewSettingView) this.dKn.findViewById(d.h.setting_detail_view);
        this.dKu = (LinearLayout) this.dKn.findViewById(d.h.user_info_lin);
        this.dKr = (TbSettingTextTipView) this.dKn.findViewById(d.h.st_delete_talk_history);
        this.dKs = (TbSettingTextTipView) this.dKn.findViewById(d.h.add_to_black);
        this.dKt = (RelativeLayout) this.dKn.findViewById(d.h.remove_from_black_man);
        this.dKr.setOnClickListener(this.dKn);
        this.dKs.setOnClickListener(this.dKn);
        this.dKt.setOnClickListener(this.dKn);
        this.dKu.setOnClickListener(this.dKn);
        this.crk = (HeadImageView) this.dKn.findViewById(d.h.photo);
        this.crk.setIsRound(true);
        this.mName = (TextView) this.dKn.findViewById(d.h.name);
        this.cHC = (UserIconBox) this.dKn.findViewById(d.h.user_icon_box);
        this.bha = (TextView) this.dKn.findViewById(d.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dKn.getLayoutMode().t(this.aYU);
        this.mNavigationBar.onChangeSkinType(this.dKn.getPageContext(), i);
    }

    public void i(boolean z, int i) {
        if (z) {
            this.dKv.setSex(i);
            this.dKv.setVisibility(0);
            this.dKw.setVisibility(8);
            return;
        }
        this.dKw.setVisibility(0);
        this.dKv.setVisibility(8);
    }

    public void hf(boolean z) {
        this.dKw.hf(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            i(fVar.aAX(), fVar.aAW().sex.intValue());
            hf(fVar.aAV());
            a(fVar.aAW());
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
            this.bha.setText(dataRes.intro);
            if (this.cHC != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.cHC.a(linkedList, i, this.dKn.getResources().getDimensionPixelSize(d.f.ds28), this.dKn.getResources().getDimensionPixelSize(d.f.ds28), this.dKn.getResources().getDimensionPixelSize(d.f.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aAW() != null && (str = fVar.aAW().portrait) != null && str.length() > 0) {
            this.crk.setImageResource(0);
            this.crk.c(str, 12, false);
        }
    }

    public void b(BdSwitchView.a aVar) {
        if (this.dKw != null) {
            this.dKw.setSwitchStateChangeListener(aVar);
        }
    }
}
