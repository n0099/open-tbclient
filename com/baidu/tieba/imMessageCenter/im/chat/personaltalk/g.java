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
    private final TextView cij;
    private final HeadImageView dGO;
    private final UserIconBox dYg;
    private final PersonalTalkSettingActivity eQh;
    private TbSettingTextTipView eQl;
    private TbSettingTextTipView eQm;
    private RelativeLayout eQn;
    private LinearLayout eQo;
    public PersonaltalkSettingViewBlackManView eQp;
    public PersonalTalkSettingViewSettingView eQq;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.eQh = personalTalkSettingActivity;
        this.eQh.setContentView(d.h.p2ptalk_setting_activity);
        this.mParent = this.eQh.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eQh.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eQp = (PersonaltalkSettingViewBlackManView) this.eQh.findViewById(d.g.black_status_view);
        this.eQq = (PersonalTalkSettingViewSettingView) this.eQh.findViewById(d.g.setting_detail_view);
        this.eQo = (LinearLayout) this.eQh.findViewById(d.g.user_info_lin);
        this.eQl = (TbSettingTextTipView) this.eQh.findViewById(d.g.st_delete_talk_history);
        this.eQm = (TbSettingTextTipView) this.eQh.findViewById(d.g.add_to_black);
        this.eQn = (RelativeLayout) this.eQh.findViewById(d.g.remove_from_black_man);
        this.eQl.setOnClickListener(this.eQh);
        this.eQm.setOnClickListener(this.eQh);
        this.eQn.setOnClickListener(this.eQh);
        this.eQo.setOnClickListener(this.eQh);
        this.dGO = (HeadImageView) this.eQh.findViewById(d.g.photo);
        this.dGO.setIsRound(true);
        this.mName = (TextView) this.eQh.findViewById(d.g.name);
        this.dYg = (UserIconBox) this.eQh.findViewById(d.g.user_icon_box);
        this.cij = (TextView) this.eQh.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.eQh.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eQh.getPageContext(), i);
    }

    public void l(boolean z, int i) {
        if (z) {
            this.eQp.setSex(i);
            this.eQp.setVisibility(0);
            this.eQq.setVisibility(8);
            return;
        }
        this.eQq.setVisibility(0);
        this.eQp.setVisibility(8);
    }

    public void ie(boolean z) {
        this.eQq.ie(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            l(fVar.aMJ(), fVar.aMI().sex.intValue());
            ie(fVar.aMH());
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
            this.cij.setText(dataRes.intro);
            if (this.dYg != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dYg.a(linkedList, i, this.eQh.getResources().getDimensionPixelSize(d.e.ds28), this.eQh.getResources().getDimensionPixelSize(d.e.ds28), this.eQh.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aMI() != null && (str = fVar.aMI().portrait) != null && str.length() > 0) {
            this.dGO.setImageResource(0);
            this.dGO.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.eQq != null) {
            this.eQq.setSwitchStateChangeListener(aVar);
        }
    }
}
