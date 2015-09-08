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
import com.baidu.tieba.i;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class w {
    private final View LR;
    private final TextView aRm;
    private final HeadImageView aUc;
    private final PersonalTalkSettingActivity bHl;
    private TbSettingTextTipView bHp;
    private TbSettingTextTipView bHq;
    private RelativeLayout bHr;
    private LinearLayout bHs;
    public PersonaltalkSettingViewBlackManView bHt;
    public PersonalTalkSettingViewSettingView bHu;
    private final UserIconBox bcI;
    private final TextView bpb;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bHl = personalTalkSettingActivity;
        this.bHl.setContentView(i.g.p2ptalk_setting_activity);
        this.LR = this.bHl.findViewById(i.f.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.LR.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bHl.getPageContext().getString(i.h.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bHt = (PersonaltalkSettingViewBlackManView) this.bHl.findViewById(i.f.black_status_view);
        this.bHu = (PersonalTalkSettingViewSettingView) this.bHl.findViewById(i.f.setting_detail_view);
        this.bHs = (LinearLayout) this.bHl.findViewById(i.f.user_info_lin);
        this.bHp = (TbSettingTextTipView) this.bHl.findViewById(i.f.st_delete_talk_history);
        this.bHq = (TbSettingTextTipView) this.bHl.findViewById(i.f.add_to_black);
        this.bHr = (RelativeLayout) this.bHl.findViewById(i.f.remove_from_black_man);
        this.bHp.setOnClickListener(this.bHl);
        this.bHq.setOnClickListener(this.bHl);
        this.bHr.setOnClickListener(this.bHl);
        this.bHs.setOnClickListener(this.bHl);
        this.aUc = (HeadImageView) this.bHl.findViewById(i.f.photo);
        this.aUc.setIsRound(true);
        this.bpb = (TextView) this.bHl.findViewById(i.f.name);
        this.bcI = (UserIconBox) this.bHl.findViewById(i.f.user_icon_box);
        this.aRm = (TextView) this.bHl.findViewById(i.f.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.bHl.getLayoutMode().k(this.LR);
        this.mNavigationBar.onChangeSkinType(this.bHl.getPageContext(), i);
    }

    public void b(boolean z, int i) {
        if (z) {
            this.bHt.setSex(i);
            this.bHt.setVisibility(0);
            this.bHu.setVisibility(8);
            return;
        }
        this.bHu.setVisibility(0);
        this.bHt.setVisibility(8);
    }

    public void dA(boolean z) {
        this.bHu.dA(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            b(rVar.Xo(), rVar.Xn().sex.intValue());
            dA(rVar.Xm());
            a(rVar.Xn());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.bpb.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.bpb.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.bpb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.bpb.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_pop_girl, 0);
            }
            this.aRm.setText(dataRes.intro);
            if (this.bcI != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.bcI.a(linkedList, i, this.bHl.getResources().getDimensionPixelSize(i.d.person_icon_width), this.bHl.getResources().getDimensionPixelSize(i.d.person_icon_height), this.bHl.getResources().getDimensionPixelSize(i.d.person_icon_margin));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.Xn() != null && (str = rVar.Xn().portrait) != null && str.length() > 0) {
            this.aUc.setImageResource(0);
            this.aUc.d(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.bHu != null) {
            this.bHu.setSwitchStateChangeListener(aVar);
        }
    }
}
