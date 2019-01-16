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
    private final TextView bWL;
    private final HeadImageView dOh;
    private final UserIconBox ejU;
    private final PersonalTalkSettingActivity ffj;
    private TbSettingTextTipView ffn;
    private TbSettingTextTipView ffo;
    private TbSettingTextTipView ffp;
    private RelativeLayout ffq;
    private LinearLayout ffr;
    public PersonaltalkSettingViewBlackManView ffs;
    public PersonalTalkSettingViewSettingView fft;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ffj = personalTalkSettingActivity;
        this.ffj.setContentView(e.h.p2ptalk_setting_activity);
        this.mParent = this.ffj.findViewById(e.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ffj.getPageContext().getString(e.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ffs = (PersonaltalkSettingViewBlackManView) this.ffj.findViewById(e.g.black_status_view);
        this.fft = (PersonalTalkSettingViewSettingView) this.ffj.findViewById(e.g.setting_detail_view);
        this.ffr = (LinearLayout) this.ffj.findViewById(e.g.user_info_lin);
        this.ffn = (TbSettingTextTipView) this.ffj.findViewById(e.g.st_delete_talk_history);
        this.ffo = (TbSettingTextTipView) this.ffj.findViewById(e.g.st_report);
        this.ffp = (TbSettingTextTipView) this.ffj.findViewById(e.g.add_to_black);
        this.ffq = (RelativeLayout) this.ffj.findViewById(e.g.remove_from_black_man);
        this.ffn.setOnClickListener(this.ffj);
        this.ffo.setOnClickListener(this.ffj);
        this.ffp.setOnClickListener(this.ffj);
        this.ffq.setOnClickListener(this.ffj);
        this.ffr.setOnClickListener(this.ffj);
        this.dOh = (HeadImageView) this.ffj.findViewById(e.g.photo);
        this.dOh.setIsRound(true);
        this.mName = (TextView) this.ffj.findViewById(e.g.name);
        this.ejU = (UserIconBox) this.ffj.findViewById(e.g.user_icon_box);
        this.bWL = (TextView) this.ffj.findViewById(e.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.ffj.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ffj.getPageContext(), i);
    }

    public void j(boolean z, int i) {
        if (z) {
            this.ffs.setSex(i);
            this.ffs.setVisibility(0);
            this.fft.setVisibility(8);
            return;
        }
        this.fft.setVisibility(0);
        this.ffs.setVisibility(8);
    }

    public void jf(boolean z) {
        this.fft.jf(z);
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
            this.bWL.setText(dataRes.intro);
            if (this.ejU != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.ejU.a(linkedList, i, this.ffj.getResources().getDimensionPixelSize(e.C0210e.ds28), this.ffj.getResources().getDimensionPixelSize(e.C0210e.ds28), this.ffj.getResources().getDimensionPixelSize(e.C0210e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aWe() != null && (str = fVar.aWe().portrait) != null && str.length() > 0) {
            this.dOh.setImageResource(0);
            this.dOh.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.fft != null) {
            this.fft.setSwitchStateChangeListener(aVar);
        }
    }
}
