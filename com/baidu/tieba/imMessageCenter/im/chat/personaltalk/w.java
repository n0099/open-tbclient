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
    private final View aWX;
    private final HeadImageView bPn;
    private final TextView bap;
    private final TextView baq;
    private final UserIconBox ceI;
    private final PersonalTalkSettingActivity djK;
    private TbSettingTextTipView djO;
    private TbSettingTextTipView djP;
    private RelativeLayout djQ;
    private LinearLayout djR;
    public PersonaltalkSettingViewBlackManView djS;
    public PersonalTalkSettingViewSettingView djT;
    private final NavigationBar mNavigationBar;

    public w(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.djK = personalTalkSettingActivity;
        this.djK.setContentView(w.j.p2ptalk_setting_activity);
        this.aWX = this.djK.findViewById(w.h.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.aWX.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.djK.getPageContext().getString(w.l.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.djS = (PersonaltalkSettingViewBlackManView) this.djK.findViewById(w.h.black_status_view);
        this.djT = (PersonalTalkSettingViewSettingView) this.djK.findViewById(w.h.setting_detail_view);
        this.djR = (LinearLayout) this.djK.findViewById(w.h.user_info_lin);
        this.djO = (TbSettingTextTipView) this.djK.findViewById(w.h.st_delete_talk_history);
        this.djP = (TbSettingTextTipView) this.djK.findViewById(w.h.add_to_black);
        this.djQ = (RelativeLayout) this.djK.findViewById(w.h.remove_from_black_man);
        this.djO.setOnClickListener(this.djK);
        this.djP.setOnClickListener(this.djK);
        this.djQ.setOnClickListener(this.djK);
        this.djR.setOnClickListener(this.djK);
        this.bPn = (HeadImageView) this.djK.findViewById(w.h.photo);
        this.bPn.setIsRound(true);
        this.bap = (TextView) this.djK.findViewById(w.h.name);
        this.ceI = (UserIconBox) this.djK.findViewById(w.h.user_icon_box);
        this.baq = (TextView) this.djK.findViewById(w.h.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.djK.getLayoutMode().t(this.aWX);
        this.mNavigationBar.onChangeSkinType(this.djK.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.djS.setSex(i);
            this.djS.setVisibility(0);
            this.djT.setVisibility(8);
            return;
        }
        this.djT.setVisibility(0);
        this.djS.setVisibility(8);
    }

    public void gq(boolean z) {
        this.djT.gq(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            h(rVar.auy(), rVar.aux().sex.intValue());
            gq(rVar.auw());
            a(rVar.aux());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.bap.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.bap.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.bap.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.bap.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_pop_girl, 0);
            }
            this.baq.setText(dataRes.intro);
            if (this.ceI != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.ceI.a(linkedList, i, this.djK.getResources().getDimensionPixelSize(w.f.ds28), this.djK.getResources().getDimensionPixelSize(w.f.ds28), this.djK.getResources().getDimensionPixelSize(w.f.ds4));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.aux() != null && (str = rVar.aux().portrait) != null && str.length() > 0) {
            this.bPn.setImageResource(0);
            this.bPn.c(str, 12, false);
        }
    }

    public void c(BdSwitchView.a aVar) {
        if (this.djT != null) {
            this.djT.setSwitchStateChangeListener(aVar);
        }
    }
}
