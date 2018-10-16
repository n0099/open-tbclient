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
    private final UserIconBox dYA;
    private TbSettingTextTipView eTB;
    private TbSettingTextTipView eTC;
    private TbSettingTextTipView eTD;
    private RelativeLayout eTE;
    private LinearLayout eTF;
    public PersonaltalkSettingViewBlackManView eTG;
    public PersonalTalkSettingViewSettingView eTH;
    private final PersonalTalkSettingActivity eTx;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.eTx = personalTalkSettingActivity;
        this.eTx.setContentView(e.h.p2ptalk_setting_activity);
        this.mParent = this.eTx.findViewById(e.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eTx.getPageContext().getString(e.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eTG = (PersonaltalkSettingViewBlackManView) this.eTx.findViewById(e.g.black_status_view);
        this.eTH = (PersonalTalkSettingViewSettingView) this.eTx.findViewById(e.g.setting_detail_view);
        this.eTF = (LinearLayout) this.eTx.findViewById(e.g.user_info_lin);
        this.eTB = (TbSettingTextTipView) this.eTx.findViewById(e.g.st_delete_talk_history);
        this.eTC = (TbSettingTextTipView) this.eTx.findViewById(e.g.st_report);
        this.eTD = (TbSettingTextTipView) this.eTx.findViewById(e.g.add_to_black);
        this.eTE = (RelativeLayout) this.eTx.findViewById(e.g.remove_from_black_man);
        this.eTB.setOnClickListener(this.eTx);
        this.eTC.setOnClickListener(this.eTx);
        this.eTD.setOnClickListener(this.eTx);
        this.eTE.setOnClickListener(this.eTx);
        this.eTF.setOnClickListener(this.eTx);
        this.dCV = (HeadImageView) this.eTx.findViewById(e.g.photo);
        this.dCV.setIsRound(true);
        this.mName = (TextView) this.eTx.findViewById(e.g.name);
        this.dYA = (UserIconBox) this.eTx.findViewById(e.g.user_icon_box);
        this.bRu = (TextView) this.eTx.findViewById(e.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.eTx.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eTx.getPageContext(), i);
    }

    public void i(boolean z, int i) {
        if (z) {
            this.eTG.setSex(i);
            this.eTG.setVisibility(0);
            this.eTH.setVisibility(8);
            return;
        }
        this.eTH.setVisibility(0);
        this.eTG.setVisibility(8);
    }

    public void iQ(boolean z) {
        this.eTH.iQ(z);
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
            if (this.dYA != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dYA.a(linkedList, i, this.eTx.getResources().getDimensionPixelSize(e.C0175e.ds28), this.eTx.getResources().getDimensionPixelSize(e.C0175e.ds28), this.eTx.getResources().getDimensionPixelSize(e.C0175e.ds4));
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
        if (this.eTH != null) {
            this.eTH.setSwitchStateChangeListener(aVar);
        }
    }
}
