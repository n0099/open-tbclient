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
    private final TextView cei;
    private final HeadImageView dDq;
    private final UserIconBox dTW;
    private final PersonalTalkSettingActivity eLD;
    private TbSettingTextTipView eLH;
    private TbSettingTextTipView eLI;
    private RelativeLayout eLJ;
    private LinearLayout eLK;
    public PersonaltalkSettingViewBlackManView eLL;
    public PersonalTalkSettingViewSettingView eLM;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.eLD = personalTalkSettingActivity;
        this.eLD.setContentView(d.h.p2ptalk_setting_activity);
        this.mParent = this.eLD.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eLD.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eLL = (PersonaltalkSettingViewBlackManView) this.eLD.findViewById(d.g.black_status_view);
        this.eLM = (PersonalTalkSettingViewSettingView) this.eLD.findViewById(d.g.setting_detail_view);
        this.eLK = (LinearLayout) this.eLD.findViewById(d.g.user_info_lin);
        this.eLH = (TbSettingTextTipView) this.eLD.findViewById(d.g.st_delete_talk_history);
        this.eLI = (TbSettingTextTipView) this.eLD.findViewById(d.g.add_to_black);
        this.eLJ = (RelativeLayout) this.eLD.findViewById(d.g.remove_from_black_man);
        this.eLH.setOnClickListener(this.eLD);
        this.eLI.setOnClickListener(this.eLD);
        this.eLJ.setOnClickListener(this.eLD);
        this.eLK.setOnClickListener(this.eLD);
        this.dDq = (HeadImageView) this.eLD.findViewById(d.g.photo);
        this.dDq.setIsRound(true);
        this.mName = (TextView) this.eLD.findViewById(d.g.name);
        this.dTW = (UserIconBox) this.eLD.findViewById(d.g.user_icon_box);
        this.cei = (TextView) this.eLD.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.eLD.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eLD.getPageContext(), i);
    }

    public void k(boolean z, int i) {
        if (z) {
            this.eLL.setSex(i);
            this.eLL.setVisibility(0);
            this.eLM.setVisibility(8);
            return;
        }
        this.eLM.setVisibility(0);
        this.eLL.setVisibility(8);
    }

    public void hR(boolean z) {
        this.eLM.hR(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            k(fVar.aLc(), fVar.aLb().sex.intValue());
            hR(fVar.aLa());
            a(fVar.aLb());
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
            this.cei.setText(dataRes.intro);
            if (this.dTW != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dTW.a(linkedList, i, this.eLD.getResources().getDimensionPixelSize(d.e.ds28), this.eLD.getResources().getDimensionPixelSize(d.e.ds28), this.eLD.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aLb() != null && (str = fVar.aLb().portrait) != null && str.length() > 0) {
            this.dDq.setImageResource(0);
            this.dDq.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.eLM != null) {
            this.eLM.setSwitchStateChangeListener(aVar);
        }
    }
}
