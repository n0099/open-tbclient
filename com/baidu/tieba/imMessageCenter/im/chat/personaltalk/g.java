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
import com.baidu.tieba.e;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes4.dex */
public class g {
    private final TextView bWM;
    private final HeadImageView dOi;
    private final UserIconBox ejV;
    private final PersonalTalkSettingActivity ffk;
    private TbSettingTextTipView ffo;
    private TbSettingTextTipView ffp;
    private TbSettingTextTipView ffq;
    private RelativeLayout ffr;
    private LinearLayout ffs;
    public PersonaltalkSettingViewBlackManView fft;
    public PersonalTalkSettingViewSettingView ffu;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ffk = personalTalkSettingActivity;
        this.ffk.setContentView(e.h.p2ptalk_setting_activity);
        this.mParent = this.ffk.findViewById(e.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ffk.getPageContext().getString(e.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fft = (PersonaltalkSettingViewBlackManView) this.ffk.findViewById(e.g.black_status_view);
        this.ffu = (PersonalTalkSettingViewSettingView) this.ffk.findViewById(e.g.setting_detail_view);
        this.ffs = (LinearLayout) this.ffk.findViewById(e.g.user_info_lin);
        this.ffo = (TbSettingTextTipView) this.ffk.findViewById(e.g.st_delete_talk_history);
        this.ffp = (TbSettingTextTipView) this.ffk.findViewById(e.g.st_report);
        this.ffq = (TbSettingTextTipView) this.ffk.findViewById(e.g.add_to_black);
        this.ffr = (RelativeLayout) this.ffk.findViewById(e.g.remove_from_black_man);
        this.ffo.setOnClickListener(this.ffk);
        this.ffp.setOnClickListener(this.ffk);
        this.ffq.setOnClickListener(this.ffk);
        this.ffr.setOnClickListener(this.ffk);
        this.ffs.setOnClickListener(this.ffk);
        this.dOi = (HeadImageView) this.ffk.findViewById(e.g.photo);
        this.dOi.setIsRound(true);
        this.mName = (TextView) this.ffk.findViewById(e.g.name);
        this.ejV = (UserIconBox) this.ffk.findViewById(e.g.user_icon_box);
        this.bWM = (TextView) this.ffk.findViewById(e.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.ffk.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ffk.getPageContext(), i);
    }

    public void j(boolean z, int i) {
        if (z) {
            this.fft.setSex(i);
            this.fft.setVisibility(0);
            this.ffu.setVisibility(8);
            return;
        }
        this.ffu.setVisibility(0);
        this.fft.setVisibility(8);
    }

    public void jf(boolean z) {
        this.ffu.jf(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            j(fVar.aWf(), fVar.aWe().sex.intValue());
            jf(fVar.aWd());
            a(fVar.aWe());
            f(fVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_pop_girl, 0);
            }
            this.bWM.setText(dataRes.intro);
            if (this.ejV != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.ejV.a(linkedList, i, this.ffk.getResources().getDimensionPixelSize(e.C0210e.ds28), this.ffk.getResources().getDimensionPixelSize(e.C0210e.ds28), this.ffk.getResources().getDimensionPixelSize(e.C0210e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aWe() != null && (str = fVar.aWe().portrait) != null && str.length() > 0) {
            this.dOi.setImageResource(0);
            this.dOi.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.ffu != null) {
            this.ffu.setSwitchStateChangeListener(aVar);
        }
    }
}
