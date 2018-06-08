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
    private final TextView bAx;
    private final UserIconBox dDw;
    private final HeadImageView dka;
    private final PersonalTalkSettingActivity ewU;
    private TbSettingTextTipView ewY;
    private TbSettingTextTipView ewZ;
    private RelativeLayout exa;
    private LinearLayout exb;
    public PersonaltalkSettingViewBlackManView exc;
    public PersonalTalkSettingViewSettingView exd;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ewU = personalTalkSettingActivity;
        this.ewU.setContentView(d.i.p2ptalk_setting_activity);
        this.mParent = this.ewU.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ewU.getPageContext().getString(d.k.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.exc = (PersonaltalkSettingViewBlackManView) this.ewU.findViewById(d.g.black_status_view);
        this.exd = (PersonalTalkSettingViewSettingView) this.ewU.findViewById(d.g.setting_detail_view);
        this.exb = (LinearLayout) this.ewU.findViewById(d.g.user_info_lin);
        this.ewY = (TbSettingTextTipView) this.ewU.findViewById(d.g.st_delete_talk_history);
        this.ewZ = (TbSettingTextTipView) this.ewU.findViewById(d.g.add_to_black);
        this.exa = (RelativeLayout) this.ewU.findViewById(d.g.remove_from_black_man);
        this.ewY.setOnClickListener(this.ewU);
        this.ewZ.setOnClickListener(this.ewU);
        this.exa.setOnClickListener(this.ewU);
        this.exb.setOnClickListener(this.ewU);
        this.dka = (HeadImageView) this.ewU.findViewById(d.g.photo);
        this.dka.setIsRound(true);
        this.mName = (TextView) this.ewU.findViewById(d.g.name);
        this.dDw = (UserIconBox) this.ewU.findViewById(d.g.user_icon_box);
        this.bAx = (TextView) this.ewU.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.ewU.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ewU.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.exc.setSex(i);
            this.exc.setVisibility(0);
            this.exd.setVisibility(8);
            return;
        }
        this.exd.setVisibility(0);
        this.exc.setVisibility(8);
    }

    public void hN(boolean z) {
        this.exd.hN(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.aMx(), fVar.aMw().sex.intValue());
            hN(fVar.aMv());
            a(fVar.aMw());
            f(fVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(dataRes.nameShow);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_pop_girl, 0);
            }
            this.bAx.setText(dataRes.intro);
            if (this.dDw != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dDw.a(linkedList, i, this.ewU.getResources().getDimensionPixelSize(d.e.ds28), this.ewU.getResources().getDimensionPixelSize(d.e.ds28), this.ewU.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aMw() != null && (str = fVar.aMw().portrait) != null && str.length() > 0) {
            this.dka.setImageResource(0);
            this.dka.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.exd != null) {
            this.exd.setSwitchStateChangeListener(aVar);
        }
    }
}
