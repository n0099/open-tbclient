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
    private final TextView chZ;
    private final HeadImageView dGH;
    private final UserIconBox dYa;
    private final PersonalTalkSettingActivity eQk;
    private TbSettingTextTipView eQo;
    private TbSettingTextTipView eQp;
    private RelativeLayout eQq;
    private LinearLayout eQr;
    public PersonaltalkSettingViewBlackManView eQs;
    public PersonalTalkSettingViewSettingView eQt;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.eQk = personalTalkSettingActivity;
        this.eQk.setContentView(d.h.p2ptalk_setting_activity);
        this.mParent = this.eQk.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eQk.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eQs = (PersonaltalkSettingViewBlackManView) this.eQk.findViewById(d.g.black_status_view);
        this.eQt = (PersonalTalkSettingViewSettingView) this.eQk.findViewById(d.g.setting_detail_view);
        this.eQr = (LinearLayout) this.eQk.findViewById(d.g.user_info_lin);
        this.eQo = (TbSettingTextTipView) this.eQk.findViewById(d.g.st_delete_talk_history);
        this.eQp = (TbSettingTextTipView) this.eQk.findViewById(d.g.add_to_black);
        this.eQq = (RelativeLayout) this.eQk.findViewById(d.g.remove_from_black_man);
        this.eQo.setOnClickListener(this.eQk);
        this.eQp.setOnClickListener(this.eQk);
        this.eQq.setOnClickListener(this.eQk);
        this.eQr.setOnClickListener(this.eQk);
        this.dGH = (HeadImageView) this.eQk.findViewById(d.g.photo);
        this.dGH.setIsRound(true);
        this.mName = (TextView) this.eQk.findViewById(d.g.name);
        this.dYa = (UserIconBox) this.eQk.findViewById(d.g.user_icon_box);
        this.chZ = (TextView) this.eQk.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.eQk.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eQk.getPageContext(), i);
    }

    public void l(boolean z, int i) {
        if (z) {
            this.eQs.setSex(i);
            this.eQs.setVisibility(0);
            this.eQt.setVisibility(8);
            return;
        }
        this.eQt.setVisibility(0);
        this.eQs.setVisibility(8);
    }

    public void ij(boolean z) {
        this.eQt.ij(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            l(fVar.aMJ(), fVar.aMI().sex.intValue());
            ij(fVar.aMH());
            a(fVar.aMI());
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
            this.chZ.setText(dataRes.intro);
            if (this.dYa != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dYa.a(linkedList, i, this.eQk.getResources().getDimensionPixelSize(d.e.ds28), this.eQk.getResources().getDimensionPixelSize(d.e.ds28), this.eQk.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aMI() != null && (str = fVar.aMI().portrait) != null && str.length() > 0) {
            this.dGH.setImageResource(0);
            this.dGH.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.eQt != null) {
            this.eQt.setSwitchStateChangeListener(aVar);
        }
    }
}
