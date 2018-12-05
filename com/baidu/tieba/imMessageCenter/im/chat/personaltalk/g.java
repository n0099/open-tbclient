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
    private final TextView bVX;
    private final HeadImageView dKK;
    private final UserIconBox egx;
    private final PersonalTalkSettingActivity fbF;
    private TbSettingTextTipView fbJ;
    private TbSettingTextTipView fbK;
    private TbSettingTextTipView fbL;
    private RelativeLayout fbM;
    private LinearLayout fbN;
    public PersonaltalkSettingViewBlackManView fbO;
    public PersonalTalkSettingViewSettingView fbP;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.fbF = personalTalkSettingActivity;
        this.fbF.setContentView(e.h.p2ptalk_setting_activity);
        this.mParent = this.fbF.findViewById(e.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.fbF.getPageContext().getString(e.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fbO = (PersonaltalkSettingViewBlackManView) this.fbF.findViewById(e.g.black_status_view);
        this.fbP = (PersonalTalkSettingViewSettingView) this.fbF.findViewById(e.g.setting_detail_view);
        this.fbN = (LinearLayout) this.fbF.findViewById(e.g.user_info_lin);
        this.fbJ = (TbSettingTextTipView) this.fbF.findViewById(e.g.st_delete_talk_history);
        this.fbK = (TbSettingTextTipView) this.fbF.findViewById(e.g.st_report);
        this.fbL = (TbSettingTextTipView) this.fbF.findViewById(e.g.add_to_black);
        this.fbM = (RelativeLayout) this.fbF.findViewById(e.g.remove_from_black_man);
        this.fbJ.setOnClickListener(this.fbF);
        this.fbK.setOnClickListener(this.fbF);
        this.fbL.setOnClickListener(this.fbF);
        this.fbM.setOnClickListener(this.fbF);
        this.fbN.setOnClickListener(this.fbF);
        this.dKK = (HeadImageView) this.fbF.findViewById(e.g.photo);
        this.dKK.setIsRound(true);
        this.mName = (TextView) this.fbF.findViewById(e.g.name);
        this.egx = (UserIconBox) this.fbF.findViewById(e.g.user_icon_box);
        this.bVX = (TextView) this.fbF.findViewById(e.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.fbF.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.fbF.getPageContext(), i);
    }

    public void j(boolean z, int i) {
        if (z) {
            this.fbO.setSex(i);
            this.fbO.setVisibility(0);
            this.fbP.setVisibility(8);
            return;
        }
        this.fbP.setVisibility(0);
        this.fbO.setVisibility(8);
    }

    public void jc(boolean z) {
        this.fbP.jc(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            j(fVar.aUS(), fVar.aUR().sex.intValue());
            jc(fVar.aUQ());
            a(fVar.aUR());
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
            this.bVX.setText(dataRes.intro);
            if (this.egx != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.egx.a(linkedList, i, this.fbF.getResources().getDimensionPixelSize(e.C0210e.ds28), this.fbF.getResources().getDimensionPixelSize(e.C0210e.ds28), this.fbF.getResources().getDimensionPixelSize(e.C0210e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aUR() != null && (str = fVar.aUR().portrait) != null && str.length() > 0) {
            this.dKK.setImageResource(0);
            this.dKK.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.fbP != null) {
            this.fbP.setSwitchStateChangeListener(aVar);
        }
    }
}
