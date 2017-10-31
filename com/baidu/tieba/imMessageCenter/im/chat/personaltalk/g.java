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
    private final View baW;
    private final TextView bjJ;
    private final UserIconBox cSm;
    private final HeadImageView czK;
    private final PersonalTalkSettingActivity dOX;
    private TbSettingTextTipView dPb;
    private TbSettingTextTipView dPc;
    private RelativeLayout dPd;
    private LinearLayout dPe;
    public PersonaltalkSettingViewBlackManView dPf;
    public PersonalTalkSettingViewSettingView dPg;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dOX = personalTalkSettingActivity;
        this.dOX.setContentView(d.h.p2ptalk_setting_activity);
        this.baW = this.dOX.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.baW.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dOX.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dPf = (PersonaltalkSettingViewBlackManView) this.dOX.findViewById(d.g.black_status_view);
        this.dPg = (PersonalTalkSettingViewSettingView) this.dOX.findViewById(d.g.setting_detail_view);
        this.dPe = (LinearLayout) this.dOX.findViewById(d.g.user_info_lin);
        this.dPb = (TbSettingTextTipView) this.dOX.findViewById(d.g.st_delete_talk_history);
        this.dPc = (TbSettingTextTipView) this.dOX.findViewById(d.g.add_to_black);
        this.dPd = (RelativeLayout) this.dOX.findViewById(d.g.remove_from_black_man);
        this.dPb.setOnClickListener(this.dOX);
        this.dPc.setOnClickListener(this.dOX);
        this.dPd.setOnClickListener(this.dOX);
        this.dPe.setOnClickListener(this.dOX);
        this.czK = (HeadImageView) this.dOX.findViewById(d.g.photo);
        this.czK.setIsRound(true);
        this.mName = (TextView) this.dOX.findViewById(d.g.name);
        this.cSm = (UserIconBox) this.dOX.findViewById(d.g.user_icon_box);
        this.bjJ = (TextView) this.dOX.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dOX.getLayoutMode().t(this.baW);
        this.mNavigationBar.onChangeSkinType(this.dOX.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.dPf.setSex(i);
            this.dPf.setVisibility(0);
            this.dPg.setVisibility(8);
            return;
        }
        this.dPg.setVisibility(0);
        this.dPf.setVisibility(8);
    }

    public void gO(boolean z) {
        this.dPg.gO(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.aCj(), fVar.aCi().sex.intValue());
            gO(fVar.aCh());
            a(fVar.aCi());
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
            this.bjJ.setText(dataRes.intro);
            if (this.cSm != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.cSm.a(linkedList, i, this.dOX.getResources().getDimensionPixelSize(d.e.ds28), this.dOX.getResources().getDimensionPixelSize(d.e.ds28), this.dOX.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aCi() != null && (str = fVar.aCi().portrait) != null && str.length() > 0) {
            this.czK.setImageResource(0);
            this.czK.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.dPg != null) {
            this.dPg.setSwitchStateChangeListener(aVar);
        }
    }
}
