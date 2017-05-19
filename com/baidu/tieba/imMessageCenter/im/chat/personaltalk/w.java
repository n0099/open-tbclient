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
    private final View aXK;
    private final HeadImageView bQk;
    private final TextView baJ;
    private final UserIconBox ccw;
    private final PersonalTalkSettingActivity deD;
    private TbSettingTextTipView deH;
    private TbSettingTextTipView deI;
    private RelativeLayout deJ;
    private LinearLayout deK;
    public PersonaltalkSettingViewBlackManView deL;
    public PersonalTalkSettingViewSettingView deM;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.deD = personalTalkSettingActivity;
        this.deD.setContentView(w.j.p2ptalk_setting_activity);
        this.aXK = this.deD.findViewById(w.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.aXK.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.deD.getPageContext().getString(w.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.deL = (PersonaltalkSettingViewBlackManView) this.deD.findViewById(w.h.black_status_view);
        this.deM = (PersonalTalkSettingViewSettingView) this.deD.findViewById(w.h.setting_detail_view);
        this.deK = (LinearLayout) this.deD.findViewById(w.h.user_info_lin);
        this.deH = (TbSettingTextTipView) this.deD.findViewById(w.h.st_delete_talk_history);
        this.deI = (TbSettingTextTipView) this.deD.findViewById(w.h.add_to_black);
        this.deJ = (RelativeLayout) this.deD.findViewById(w.h.remove_from_black_man);
        this.deH.setOnClickListener(this.deD);
        this.deI.setOnClickListener(this.deD);
        this.deJ.setOnClickListener(this.deD);
        this.deK.setOnClickListener(this.deD);
        this.bQk = (HeadImageView) this.deD.findViewById(w.h.photo);
        this.bQk.setIsRound(true);
        this.mName = (TextView) this.deD.findViewById(w.h.name);
        this.ccw = (UserIconBox) this.deD.findViewById(w.h.user_icon_box);
        this.baJ = (TextView) this.deD.findViewById(w.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.deD.getLayoutMode().t(this.aXK);
        this.mNavigationBar.onChangeSkinType(this.deD.getPageContext(), i);
    }

    public void i(boolean z, int i) {
        if (z) {
            this.deL.setSex(i);
            this.deL.setVisibility(0);
            this.deM.setVisibility(8);
            return;
        }
        this.deM.setVisibility(0);
        this.deL.setVisibility(8);
    }

    public void gb(boolean z) {
        this.deM.gb(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            i(rVar.asn(), rVar.asm().sex.intValue());
            gb(rVar.asl());
            a(rVar.asm());
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
            this.baJ.setText(dataRes.intro);
            if (this.ccw != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.ccw.a(linkedList, i, this.deD.getResources().getDimensionPixelSize(w.f.ds28), this.deD.getResources().getDimensionPixelSize(w.f.ds28), this.deD.getResources().getDimensionPixelSize(w.f.ds4));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.asm() != null && (str = rVar.asm().portrait) != null && str.length() > 0) {
            this.bQk.setImageResource(0);
            this.bQk.c(str, 12, false);
        }
    }

    public void b(BdSwitchView.a aVar) {
        if (this.deM != null) {
            this.deM.setSwitchStateChangeListener(aVar);
        }
    }
}
