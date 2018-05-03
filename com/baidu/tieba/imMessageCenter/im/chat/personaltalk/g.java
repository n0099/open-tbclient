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
    private final HeadImageView cZB;
    private final UserIconBox dtb;
    private TbSettingTextTipView ekA;
    private TbSettingTextTipView ekB;
    private RelativeLayout ekC;
    private LinearLayout ekD;
    public PersonaltalkSettingViewBlackManView ekE;
    public PersonalTalkSettingViewSettingView ekF;
    private final PersonalTalkSettingActivity ekw;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ekw = personalTalkSettingActivity;
        this.ekw.setContentView(d.i.p2ptalk_setting_activity);
        this.mParent = this.ekw.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ekw.getPageContext().getString(d.k.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ekE = (PersonaltalkSettingViewBlackManView) this.ekw.findViewById(d.g.black_status_view);
        this.ekF = (PersonalTalkSettingViewSettingView) this.ekw.findViewById(d.g.setting_detail_view);
        this.ekD = (LinearLayout) this.ekw.findViewById(d.g.user_info_lin);
        this.ekA = (TbSettingTextTipView) this.ekw.findViewById(d.g.st_delete_talk_history);
        this.ekB = (TbSettingTextTipView) this.ekw.findViewById(d.g.add_to_black);
        this.ekC = (RelativeLayout) this.ekw.findViewById(d.g.remove_from_black_man);
        this.ekA.setOnClickListener(this.ekw);
        this.ekB.setOnClickListener(this.ekw);
        this.ekC.setOnClickListener(this.ekw);
        this.ekD.setOnClickListener(this.ekw);
        this.cZB = (HeadImageView) this.ekw.findViewById(d.g.photo);
        this.cZB.setIsRound(true);
        this.mName = (TextView) this.ekw.findViewById(d.g.name);
        this.dtb = (UserIconBox) this.ekw.findViewById(d.g.user_icon_box);
        this.bsd = (TextView) this.ekw.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.ekw.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ekw.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.ekE.setSex(i);
            this.ekE.setVisibility(0);
            this.ekF.setVisibility(8);
            return;
        }
        this.ekF.setVisibility(0);
        this.ekE.setVisibility(8);
    }

    public void hG(boolean z) {
        this.ekF.hG(z);
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
            if (this.dtb != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dtb.a(linkedList, i, this.ekw.getResources().getDimensionPixelSize(d.e.ds28), this.ekw.getResources().getDimensionPixelSize(d.e.ds28), this.ekw.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aHD() != null && (str = fVar.aHD().portrait) != null && str.length() > 0) {
            this.cZB.setImageResource(0);
            this.cZB.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.ekF != null) {
            this.ekF.setSwitchStateChangeListener(aVar);
        }
    }
}
