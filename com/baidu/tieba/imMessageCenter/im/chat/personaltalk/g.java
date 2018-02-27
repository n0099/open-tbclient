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
    private final TextView chW;
    private final HeadImageView dGC;
    private final UserIconBox dXU;
    private final PersonalTalkSettingActivity ePV;
    private TbSettingTextTipView ePZ;
    private TbSettingTextTipView eQa;
    private RelativeLayout eQb;
    private LinearLayout eQc;
    public PersonaltalkSettingViewBlackManView eQd;
    public PersonalTalkSettingViewSettingView eQe;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ePV = personalTalkSettingActivity;
        this.ePV.setContentView(d.h.p2ptalk_setting_activity);
        this.mParent = this.ePV.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ePV.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eQd = (PersonaltalkSettingViewBlackManView) this.ePV.findViewById(d.g.black_status_view);
        this.eQe = (PersonalTalkSettingViewSettingView) this.ePV.findViewById(d.g.setting_detail_view);
        this.eQc = (LinearLayout) this.ePV.findViewById(d.g.user_info_lin);
        this.ePZ = (TbSettingTextTipView) this.ePV.findViewById(d.g.st_delete_talk_history);
        this.eQa = (TbSettingTextTipView) this.ePV.findViewById(d.g.add_to_black);
        this.eQb = (RelativeLayout) this.ePV.findViewById(d.g.remove_from_black_man);
        this.ePZ.setOnClickListener(this.ePV);
        this.eQa.setOnClickListener(this.ePV);
        this.eQb.setOnClickListener(this.ePV);
        this.eQc.setOnClickListener(this.ePV);
        this.dGC = (HeadImageView) this.ePV.findViewById(d.g.photo);
        this.dGC.setIsRound(true);
        this.mName = (TextView) this.ePV.findViewById(d.g.name);
        this.dXU = (UserIconBox) this.ePV.findViewById(d.g.user_icon_box);
        this.chW = (TextView) this.ePV.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.ePV.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ePV.getPageContext(), i);
    }

    public void l(boolean z, int i) {
        if (z) {
            this.eQd.setSex(i);
            this.eQd.setVisibility(0);
            this.eQe.setVisibility(8);
            return;
        }
        this.eQe.setVisibility(0);
        this.eQd.setVisibility(8);
    }

    public void ie(boolean z) {
        this.eQe.ie(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            l(fVar.aMI(), fVar.aMH().sex.intValue());
            ie(fVar.aMG());
            a(fVar.aMH());
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
            this.chW.setText(dataRes.intro);
            if (this.dXU != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dXU.a(linkedList, i, this.ePV.getResources().getDimensionPixelSize(d.e.ds28), this.ePV.getResources().getDimensionPixelSize(d.e.ds28), this.ePV.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aMH() != null && (str = fVar.aMH().portrait) != null && str.length() > 0) {
            this.dGC.setImageResource(0);
            this.dGC.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.eQe != null) {
            this.eQe.setSwitchStateChangeListener(aVar);
        }
    }
}
