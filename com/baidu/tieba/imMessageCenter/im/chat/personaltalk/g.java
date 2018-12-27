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
    private final TextView bWa;
    private final HeadImageView dNy;
    private final UserIconBox ejo;
    private TbSettingTextTipView feA;
    private TbSettingTextTipView feB;
    private TbSettingTextTipView feC;
    private RelativeLayout feD;
    private LinearLayout feE;
    public PersonaltalkSettingViewBlackManView feF;
    public PersonalTalkSettingViewSettingView feG;
    private final PersonalTalkSettingActivity few;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.few = personalTalkSettingActivity;
        this.few.setContentView(e.h.p2ptalk_setting_activity);
        this.mParent = this.few.findViewById(e.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.few.getPageContext().getString(e.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.feF = (PersonaltalkSettingViewBlackManView) this.few.findViewById(e.g.black_status_view);
        this.feG = (PersonalTalkSettingViewSettingView) this.few.findViewById(e.g.setting_detail_view);
        this.feE = (LinearLayout) this.few.findViewById(e.g.user_info_lin);
        this.feA = (TbSettingTextTipView) this.few.findViewById(e.g.st_delete_talk_history);
        this.feB = (TbSettingTextTipView) this.few.findViewById(e.g.st_report);
        this.feC = (TbSettingTextTipView) this.few.findViewById(e.g.add_to_black);
        this.feD = (RelativeLayout) this.few.findViewById(e.g.remove_from_black_man);
        this.feA.setOnClickListener(this.few);
        this.feB.setOnClickListener(this.few);
        this.feC.setOnClickListener(this.few);
        this.feD.setOnClickListener(this.few);
        this.feE.setOnClickListener(this.few);
        this.dNy = (HeadImageView) this.few.findViewById(e.g.photo);
        this.dNy.setIsRound(true);
        this.mName = (TextView) this.few.findViewById(e.g.name);
        this.ejo = (UserIconBox) this.few.findViewById(e.g.user_icon_box);
        this.bWa = (TextView) this.few.findViewById(e.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.few.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.few.getPageContext(), i);
    }

    public void j(boolean z, int i) {
        if (z) {
            this.feF.setSex(i);
            this.feF.setVisibility(0);
            this.feG.setVisibility(8);
            return;
        }
        this.feG.setVisibility(0);
        this.feF.setVisibility(8);
    }

    public void jf(boolean z) {
        this.feG.jf(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            j(fVar.aVF(), fVar.aVE().sex.intValue());
            jf(fVar.aVD());
            a(fVar.aVE());
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
            this.bWa.setText(dataRes.intro);
            if (this.ejo != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.ejo.a(linkedList, i, this.few.getResources().getDimensionPixelSize(e.C0210e.ds28), this.few.getResources().getDimensionPixelSize(e.C0210e.ds28), this.few.getResources().getDimensionPixelSize(e.C0210e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aVE() != null && (str = fVar.aVE().portrait) != null && str.length() > 0) {
            this.dNy.setImageResource(0);
            this.dNy.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.feG != null) {
            this.feG.setSwitchStateChangeListener(aVar);
        }
    }
}
