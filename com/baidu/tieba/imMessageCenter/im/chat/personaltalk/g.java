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
    private final TextView ceq;
    private final HeadImageView dDL;
    private final UserIconBox dUr;
    private final PersonalTalkSettingActivity eLY;
    private TbSettingTextTipView eMc;
    private TbSettingTextTipView eMd;
    private RelativeLayout eMe;
    private LinearLayout eMf;
    public PersonaltalkSettingViewBlackManView eMg;
    public PersonalTalkSettingViewSettingView eMh;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.eLY = personalTalkSettingActivity;
        this.eLY.setContentView(d.h.p2ptalk_setting_activity);
        this.mParent = this.eLY.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eLY.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eMg = (PersonaltalkSettingViewBlackManView) this.eLY.findViewById(d.g.black_status_view);
        this.eMh = (PersonalTalkSettingViewSettingView) this.eLY.findViewById(d.g.setting_detail_view);
        this.eMf = (LinearLayout) this.eLY.findViewById(d.g.user_info_lin);
        this.eMc = (TbSettingTextTipView) this.eLY.findViewById(d.g.st_delete_talk_history);
        this.eMd = (TbSettingTextTipView) this.eLY.findViewById(d.g.add_to_black);
        this.eMe = (RelativeLayout) this.eLY.findViewById(d.g.remove_from_black_man);
        this.eMc.setOnClickListener(this.eLY);
        this.eMd.setOnClickListener(this.eLY);
        this.eMe.setOnClickListener(this.eLY);
        this.eMf.setOnClickListener(this.eLY);
        this.dDL = (HeadImageView) this.eLY.findViewById(d.g.photo);
        this.dDL.setIsRound(true);
        this.mName = (TextView) this.eLY.findViewById(d.g.name);
        this.dUr = (UserIconBox) this.eLY.findViewById(d.g.user_icon_box);
        this.ceq = (TextView) this.eLY.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.eLY.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eLY.getPageContext(), i);
    }

    public void k(boolean z, int i) {
        if (z) {
            this.eMg.setSex(i);
            this.eMg.setVisibility(0);
            this.eMh.setVisibility(8);
            return;
        }
        this.eMh.setVisibility(0);
        this.eMg.setVisibility(8);
    }

    public void hU(boolean z) {
        this.eMh.hU(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            k(fVar.aLh(), fVar.aLg().sex.intValue());
            hU(fVar.aLf());
            a(fVar.aLg());
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
            this.ceq.setText(dataRes.intro);
            if (this.dUr != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dUr.a(linkedList, i, this.eLY.getResources().getDimensionPixelSize(d.e.ds28), this.eLY.getResources().getDimensionPixelSize(d.e.ds28), this.eLY.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aLg() != null && (str = fVar.aLg().portrait) != null && str.length() > 0) {
            this.dDL.setImageResource(0);
            this.dDL.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.eMh != null) {
            this.eMh.setSwitchStateChangeListener(aVar);
        }
    }
}
