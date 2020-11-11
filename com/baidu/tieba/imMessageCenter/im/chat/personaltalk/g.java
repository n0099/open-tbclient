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
import com.baidu.tieba.R;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes22.dex */
public class g {
    private final TextView gxh;
    private final HeadImageView iKU;
    private final UserIconBox jmS;
    private final PersonalTalkSettingActivity krF;
    private TbSettingTextTipView krJ;
    private TbSettingTextTipView krK;
    private TbSettingTextTipView krL;
    private RelativeLayout krM;
    private LinearLayout krN;
    public PersonaltalkSettingViewBlackManView krO;
    public PersonalTalkSettingViewSettingView krP;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.krF = personalTalkSettingActivity;
        this.krF.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.krF.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.krF.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.krO = (PersonaltalkSettingViewBlackManView) this.krF.findViewById(R.id.black_status_view);
        this.krP = (PersonalTalkSettingViewSettingView) this.krF.findViewById(R.id.setting_detail_view);
        this.krN = (LinearLayout) this.krF.findViewById(R.id.user_info_lin);
        this.krJ = (TbSettingTextTipView) this.krF.findViewById(R.id.st_delete_talk_history);
        this.krK = (TbSettingTextTipView) this.krF.findViewById(R.id.st_report);
        this.krL = (TbSettingTextTipView) this.krF.findViewById(R.id.add_to_black);
        this.krM = (RelativeLayout) this.krF.findViewById(R.id.remove_from_black_man);
        this.krJ.setOnClickListener(this.krF);
        this.krK.setOnClickListener(this.krF);
        this.krL.setOnClickListener(this.krF);
        this.krM.setOnClickListener(this.krF);
        this.krN.setOnClickListener(this.krF);
        this.iKU = (HeadImageView) this.krF.findViewById(R.id.photo);
        this.iKU.setIsRound(true);
        this.mName = (TextView) this.krF.findViewById(R.id.name);
        this.jmS = (UserIconBox) this.krF.findViewById(R.id.user_icon_box);
        this.gxh = (TextView) this.krF.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.krF.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.krF.getPageContext(), i);
    }

    public void E(boolean z, int i) {
        if (z) {
            this.krO.setSex(i);
            this.krO.setVisibility(0);
            this.krP.setVisibility(8);
            return;
        }
        this.krP.setVisibility(0);
        this.krO.setVisibility(8);
    }

    public void sw(boolean z) {
        this.krP.sw(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            E(fVar.cVP(), fVar.cVO().sex.intValue());
            sw(fVar.cVN());
            a(fVar.cVO());
            f(fVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
            }
            this.gxh.setText(dataRes.intro);
            if (this.jmS != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.jmS.a(linkedList, i, this.krF.getResources().getDimensionPixelSize(R.dimen.ds28), this.krF.getResources().getDimensionPixelSize(R.dimen.ds28), this.krF.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cVO() != null && (str = fVar.cVO().portrait) != null && str.length() > 0) {
            this.iKU.setImageResource(0);
            this.iKU.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.krP != null) {
            this.krP.setSwitchStateChangeListener(aVar);
        }
    }
}
