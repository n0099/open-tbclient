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
import com.baidu.tieba.d;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes2.dex */
public class g {
    private final TextView bCu;
    private final UserIconBox dGK;
    private final HeadImageView dmh;
    private final PersonalTalkSettingActivity eAL;
    private TbSettingTextTipView eAP;
    private TbSettingTextTipView eAQ;
    private RelativeLayout eAR;
    private LinearLayout eAS;
    public PersonaltalkSettingViewBlackManView eAT;
    public PersonalTalkSettingViewSettingView eAU;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.eAL = personalTalkSettingActivity;
        this.eAL.setContentView(d.i.p2ptalk_setting_activity);
        this.mParent = this.eAL.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eAL.getPageContext().getString(d.k.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eAT = (PersonaltalkSettingViewBlackManView) this.eAL.findViewById(d.g.black_status_view);
        this.eAU = (PersonalTalkSettingViewSettingView) this.eAL.findViewById(d.g.setting_detail_view);
        this.eAS = (LinearLayout) this.eAL.findViewById(d.g.user_info_lin);
        this.eAP = (TbSettingTextTipView) this.eAL.findViewById(d.g.st_delete_talk_history);
        this.eAQ = (TbSettingTextTipView) this.eAL.findViewById(d.g.add_to_black);
        this.eAR = (RelativeLayout) this.eAL.findViewById(d.g.remove_from_black_man);
        this.eAP.setOnClickListener(this.eAL);
        this.eAQ.setOnClickListener(this.eAL);
        this.eAR.setOnClickListener(this.eAL);
        this.eAS.setOnClickListener(this.eAL);
        this.dmh = (HeadImageView) this.eAL.findViewById(d.g.photo);
        this.dmh.setIsRound(true);
        this.mName = (TextView) this.eAL.findViewById(d.g.name);
        this.dGK = (UserIconBox) this.eAL.findViewById(d.g.user_icon_box);
        this.bCu = (TextView) this.eAL.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.eAL.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eAL.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.eAT.setSex(i);
            this.eAT.setVisibility(0);
            this.eAU.setVisibility(8);
            return;
        }
        this.eAU.setVisibility(0);
        this.eAT.setVisibility(8);
    }

    public void hX(boolean z) {
        this.eAU.hX(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.aNd(), fVar.aNc().sex.intValue());
            hX(fVar.aNb());
            a(fVar.aNc());
            f(fVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_pop_girl, 0);
            }
            this.bCu.setText(dataRes.intro);
            if (this.dGK != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dGK.a(linkedList, i, this.eAL.getResources().getDimensionPixelSize(d.e.ds28), this.eAL.getResources().getDimensionPixelSize(d.e.ds28), this.eAL.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aNc() != null && (str = fVar.aNc().portrait) != null && str.length() > 0) {
            this.dmh.setImageResource(0);
            this.dmh.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.eAU != null) {
            this.eAU.setSwitchStateChangeListener(aVar);
        }
    }
}
