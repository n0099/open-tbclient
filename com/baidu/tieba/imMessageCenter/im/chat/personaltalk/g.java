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
/* loaded from: classes2.dex */
public class g {
    private final TextView bIR;
    private final UserIconBox dQF;
    private final HeadImageView duU;
    private final PersonalTalkSettingActivity eLP;
    private TbSettingTextTipView eLT;
    private TbSettingTextTipView eLU;
    private TbSettingTextTipView eLV;
    private RelativeLayout eLW;
    private LinearLayout eLX;
    public PersonaltalkSettingViewBlackManView eLY;
    public PersonalTalkSettingViewSettingView eLZ;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.eLP = personalTalkSettingActivity;
        this.eLP.setContentView(e.h.p2ptalk_setting_activity);
        this.mParent = this.eLP.findViewById(e.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eLP.getPageContext().getString(e.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eLY = (PersonaltalkSettingViewBlackManView) this.eLP.findViewById(e.g.black_status_view);
        this.eLZ = (PersonalTalkSettingViewSettingView) this.eLP.findViewById(e.g.setting_detail_view);
        this.eLX = (LinearLayout) this.eLP.findViewById(e.g.user_info_lin);
        this.eLT = (TbSettingTextTipView) this.eLP.findViewById(e.g.st_delete_talk_history);
        this.eLU = (TbSettingTextTipView) this.eLP.findViewById(e.g.st_report);
        this.eLV = (TbSettingTextTipView) this.eLP.findViewById(e.g.add_to_black);
        this.eLW = (RelativeLayout) this.eLP.findViewById(e.g.remove_from_black_man);
        this.eLT.setOnClickListener(this.eLP);
        this.eLU.setOnClickListener(this.eLP);
        this.eLV.setOnClickListener(this.eLP);
        this.eLW.setOnClickListener(this.eLP);
        this.eLX.setOnClickListener(this.eLP);
        this.duU = (HeadImageView) this.eLP.findViewById(e.g.photo);
        this.duU.setIsRound(true);
        this.mName = (TextView) this.eLP.findViewById(e.g.name);
        this.dQF = (UserIconBox) this.eLP.findViewById(e.g.user_icon_box);
        this.bIR = (TextView) this.eLP.findViewById(e.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.eLP.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eLP.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.eLY.setSex(i);
            this.eLY.setVisibility(0);
            this.eLZ.setVisibility(8);
            return;
        }
        this.eLZ.setVisibility(0);
        this.eLY.setVisibility(8);
    }

    public void iy(boolean z) {
        this.eLZ.iy(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.aQp(), fVar.aQo().sex.intValue());
            iy(fVar.aQn());
            a(fVar.aQo());
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
            this.bIR.setText(dataRes.intro);
            if (this.dQF != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dQF.a(linkedList, i, this.eLP.getResources().getDimensionPixelSize(e.C0141e.ds28), this.eLP.getResources().getDimensionPixelSize(e.C0141e.ds28), this.eLP.getResources().getDimensionPixelSize(e.C0141e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aQo() != null && (str = fVar.aQo().portrait) != null && str.length() > 0) {
            this.duU.setImageResource(0);
            this.duU.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.eLZ != null) {
            this.eLZ.setSwitchStateChangeListener(aVar);
        }
    }
}
