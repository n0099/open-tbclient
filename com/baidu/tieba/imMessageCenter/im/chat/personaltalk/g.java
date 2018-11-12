package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.e;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes4.dex */
public class g {
    private final TextView bSg;
    private final HeadImageView dEl;
    private final UserIconBox dZU;
    private final PersonalTalkSettingActivity eUQ;
    private TbSettingTextTipView eUU;
    private TbSettingTextTipView eUV;
    private TbSettingTextTipView eUW;
    private RelativeLayout eUX;
    private LinearLayout eUY;
    public PersonaltalkSettingViewBlackManView eUZ;
    public PersonalTalkSettingViewSettingView eVa;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.eUQ = personalTalkSettingActivity;
        this.eUQ.setContentView(e.h.p2ptalk_setting_activity);
        this.mParent = this.eUQ.findViewById(e.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eUQ.getPageContext().getString(e.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eUZ = (PersonaltalkSettingViewBlackManView) this.eUQ.findViewById(e.g.black_status_view);
        this.eVa = (PersonalTalkSettingViewSettingView) this.eUQ.findViewById(e.g.setting_detail_view);
        this.eUY = (LinearLayout) this.eUQ.findViewById(e.g.user_info_lin);
        this.eUU = (TbSettingTextTipView) this.eUQ.findViewById(e.g.st_delete_talk_history);
        this.eUV = (TbSettingTextTipView) this.eUQ.findViewById(e.g.st_report);
        this.eUW = (TbSettingTextTipView) this.eUQ.findViewById(e.g.add_to_black);
        this.eUX = (RelativeLayout) this.eUQ.findViewById(e.g.remove_from_black_man);
        this.eUU.setOnClickListener(this.eUQ);
        this.eUV.setOnClickListener(this.eUQ);
        this.eUW.setOnClickListener(this.eUQ);
        this.eUX.setOnClickListener(this.eUQ);
        this.eUY.setOnClickListener(this.eUQ);
        this.dEl = (HeadImageView) this.eUQ.findViewById(e.g.photo);
        this.dEl.setIsRound(true);
        this.mName = (TextView) this.eUQ.findViewById(e.g.name);
        this.dZU = (UserIconBox) this.eUQ.findViewById(e.g.user_icon_box);
        this.bSg = (TextView) this.eUQ.findViewById(e.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.eUQ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eUQ.getPageContext(), i);
    }

    public void i(boolean z, int i) {
        if (z) {
            this.eUZ.setSex(i);
            this.eUZ.setVisibility(0);
            this.eVa.setVisibility(8);
            return;
        }
        this.eVa.setVisibility(0);
        this.eUZ.setVisibility(8);
    }

    public void iZ(boolean z) {
        this.eVa.iZ(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            i(fVar.aTa(), fVar.aSZ().sex.intValue());
            iZ(fVar.aSY());
            a(fVar.aSZ());
            f(fVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_pop_girl, 0);
            }
            this.bSg.setText(dataRes.intro);
            if (this.dZU != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dZU.a(linkedList, i, this.eUQ.getResources().getDimensionPixelSize(e.C0200e.ds28), this.eUQ.getResources().getDimensionPixelSize(e.C0200e.ds28), this.eUQ.getResources().getDimensionPixelSize(e.C0200e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aSZ() != null && (str = fVar.aSZ().portrait) != null && str.length() > 0) {
            this.dEl.setImageResource(0);
            this.dEl.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.eVa != null) {
            this.eVa.setSwitchStateChangeListener(aVar);
        }
    }
}
