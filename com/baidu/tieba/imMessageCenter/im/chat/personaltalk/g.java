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
    private final TextView bsd;
    private final HeadImageView cZE;
    private final UserIconBox dte;
    private TbSettingTextTipView ekD;
    private TbSettingTextTipView ekE;
    private RelativeLayout ekF;
    private LinearLayout ekG;
    public PersonaltalkSettingViewBlackManView ekH;
    public PersonalTalkSettingViewSettingView ekI;
    private final PersonalTalkSettingActivity ekz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ekz = personalTalkSettingActivity;
        this.ekz.setContentView(d.i.p2ptalk_setting_activity);
        this.mParent = this.ekz.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ekz.getPageContext().getString(d.k.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ekH = (PersonaltalkSettingViewBlackManView) this.ekz.findViewById(d.g.black_status_view);
        this.ekI = (PersonalTalkSettingViewSettingView) this.ekz.findViewById(d.g.setting_detail_view);
        this.ekG = (LinearLayout) this.ekz.findViewById(d.g.user_info_lin);
        this.ekD = (TbSettingTextTipView) this.ekz.findViewById(d.g.st_delete_talk_history);
        this.ekE = (TbSettingTextTipView) this.ekz.findViewById(d.g.add_to_black);
        this.ekF = (RelativeLayout) this.ekz.findViewById(d.g.remove_from_black_man);
        this.ekD.setOnClickListener(this.ekz);
        this.ekE.setOnClickListener(this.ekz);
        this.ekF.setOnClickListener(this.ekz);
        this.ekG.setOnClickListener(this.ekz);
        this.cZE = (HeadImageView) this.ekz.findViewById(d.g.photo);
        this.cZE.setIsRound(true);
        this.mName = (TextView) this.ekz.findViewById(d.g.name);
        this.dte = (UserIconBox) this.ekz.findViewById(d.g.user_icon_box);
        this.bsd = (TextView) this.ekz.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.ekz.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ekz.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.ekH.setSex(i);
            this.ekH.setVisibility(0);
            this.ekI.setVisibility(8);
            return;
        }
        this.ekI.setVisibility(0);
        this.ekH.setVisibility(8);
    }

    public void hG(boolean z) {
        this.ekI.hG(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.aHE(), fVar.aHD().sex.intValue());
            hG(fVar.aHC());
            a(fVar.aHD());
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
            this.bsd.setText(dataRes.intro);
            if (this.dte != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dte.a(linkedList, i, this.ekz.getResources().getDimensionPixelSize(d.e.ds28), this.ekz.getResources().getDimensionPixelSize(d.e.ds28), this.ekz.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aHD() != null && (str = fVar.aHD().portrait) != null && str.length() > 0) {
            this.cZE.setImageResource(0);
            this.cZE.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.ekI != null) {
            this.ekI.setSwitchStateChangeListener(aVar);
        }
    }
}
