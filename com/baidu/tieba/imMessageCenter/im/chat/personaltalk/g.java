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
    private final TextView bRu;
    private final HeadImageView dCV;
    private final UserIconBox dYB;
    private TbSettingTextTipView eTC;
    private TbSettingTextTipView eTD;
    private TbSettingTextTipView eTE;
    private RelativeLayout eTF;
    private LinearLayout eTG;
    public PersonaltalkSettingViewBlackManView eTH;
    public PersonalTalkSettingViewSettingView eTI;
    private final PersonalTalkSettingActivity eTy;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.eTy = personalTalkSettingActivity;
        this.eTy.setContentView(e.h.p2ptalk_setting_activity);
        this.mParent = this.eTy.findViewById(e.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eTy.getPageContext().getString(e.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eTH = (PersonaltalkSettingViewBlackManView) this.eTy.findViewById(e.g.black_status_view);
        this.eTI = (PersonalTalkSettingViewSettingView) this.eTy.findViewById(e.g.setting_detail_view);
        this.eTG = (LinearLayout) this.eTy.findViewById(e.g.user_info_lin);
        this.eTC = (TbSettingTextTipView) this.eTy.findViewById(e.g.st_delete_talk_history);
        this.eTD = (TbSettingTextTipView) this.eTy.findViewById(e.g.st_report);
        this.eTE = (TbSettingTextTipView) this.eTy.findViewById(e.g.add_to_black);
        this.eTF = (RelativeLayout) this.eTy.findViewById(e.g.remove_from_black_man);
        this.eTC.setOnClickListener(this.eTy);
        this.eTD.setOnClickListener(this.eTy);
        this.eTE.setOnClickListener(this.eTy);
        this.eTF.setOnClickListener(this.eTy);
        this.eTG.setOnClickListener(this.eTy);
        this.dCV = (HeadImageView) this.eTy.findViewById(e.g.photo);
        this.dCV.setIsRound(true);
        this.mName = (TextView) this.eTy.findViewById(e.g.name);
        this.dYB = (UserIconBox) this.eTy.findViewById(e.g.user_icon_box);
        this.bRu = (TextView) this.eTy.findViewById(e.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.eTy.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eTy.getPageContext(), i);
    }

    public void i(boolean z, int i) {
        if (z) {
            this.eTH.setSex(i);
            this.eTH.setVisibility(0);
            this.eTI.setVisibility(8);
            return;
        }
        this.eTI.setVisibility(0);
        this.eTH.setVisibility(8);
    }

    public void iQ(boolean z) {
        this.eTI.iQ(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            i(fVar.aTD(), fVar.aTC().sex.intValue());
            iQ(fVar.aTB());
            a(fVar.aTC());
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
            this.bRu.setText(dataRes.intro);
            if (this.dYB != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dYB.a(linkedList, i, this.eTy.getResources().getDimensionPixelSize(e.C0175e.ds28), this.eTy.getResources().getDimensionPixelSize(e.C0175e.ds28), this.eTy.getResources().getDimensionPixelSize(e.C0175e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aTC() != null && (str = fVar.aTC().portrait) != null && str.length() > 0) {
            this.dCV.setImageResource(0);
            this.dCV.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.eTI != null) {
            this.eTI.setSwitchStateChangeListener(aVar);
        }
    }
}
