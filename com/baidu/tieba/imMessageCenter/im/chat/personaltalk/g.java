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
/* loaded from: classes4.dex */
public class g {
    private final TextView dlN;
    private final HeadImageView fbT;
    private final UserIconBox fza;
    public PersonaltalkSettingViewBlackManView gvA;
    public PersonalTalkSettingViewSettingView gvB;
    private final PersonalTalkSettingActivity gvr;
    private TbSettingTextTipView gvv;
    private TbSettingTextTipView gvw;
    private TbSettingTextTipView gvx;
    private RelativeLayout gvy;
    private LinearLayout gvz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.gvr = personalTalkSettingActivity;
        this.gvr.setContentView(d.h.p2ptalk_setting_activity);
        this.mParent = this.gvr.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gvr.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gvA = (PersonaltalkSettingViewBlackManView) this.gvr.findViewById(d.g.black_status_view);
        this.gvB = (PersonalTalkSettingViewSettingView) this.gvr.findViewById(d.g.setting_detail_view);
        this.gvz = (LinearLayout) this.gvr.findViewById(d.g.user_info_lin);
        this.gvv = (TbSettingTextTipView) this.gvr.findViewById(d.g.st_delete_talk_history);
        this.gvw = (TbSettingTextTipView) this.gvr.findViewById(d.g.st_report);
        this.gvx = (TbSettingTextTipView) this.gvr.findViewById(d.g.add_to_black);
        this.gvy = (RelativeLayout) this.gvr.findViewById(d.g.remove_from_black_man);
        this.gvv.setOnClickListener(this.gvr);
        this.gvw.setOnClickListener(this.gvr);
        this.gvx.setOnClickListener(this.gvr);
        this.gvy.setOnClickListener(this.gvr);
        this.gvz.setOnClickListener(this.gvr);
        this.fbT = (HeadImageView) this.gvr.findViewById(d.g.photo);
        this.fbT.setIsRound(true);
        this.mName = (TextView) this.gvr.findViewById(d.g.name);
        this.fza = (UserIconBox) this.gvr.findViewById(d.g.user_icon_box);
        this.dlN = (TextView) this.gvr.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.gvr.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gvr.getPageContext(), i);
    }

    public void p(boolean z, int i) {
        if (z) {
            this.gvA.setSex(i);
            this.gvA.setVisibility(0);
            this.gvB.setVisibility(8);
            return;
        }
        this.gvB.setVisibility(0);
        this.gvA.setVisibility(8);
    }

    public void lF(boolean z) {
        this.gvB.lF(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            p(fVar.bwL(), fVar.bwK().sex.intValue());
            lF(fVar.bwJ());
            a(fVar.bwK());
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
            this.dlN.setText(dataRes.intro);
            if (this.fza != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.fza.a(linkedList, i, this.gvr.getResources().getDimensionPixelSize(d.e.ds28), this.gvr.getResources().getDimensionPixelSize(d.e.ds28), this.gvr.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bwK() != null && (str = fVar.bwK().portrait) != null && str.length() > 0) {
            this.fbT.setImageResource(0);
            this.fbT.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.gvB != null) {
            this.gvB.setSwitchStateChangeListener(aVar);
        }
    }
}
