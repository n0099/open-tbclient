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
import com.baidu.tieba.f;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes2.dex */
public class g {
    private final TextView bDc;
    private final UserIconBox dJv;
    private final HeadImageView doX;
    private TbSettingTextTipView eED;
    private TbSettingTextTipView eEE;
    private TbSettingTextTipView eEF;
    private RelativeLayout eEG;
    private LinearLayout eEH;
    public PersonaltalkSettingViewBlackManView eEI;
    public PersonalTalkSettingViewSettingView eEJ;
    private final PersonalTalkSettingActivity eEz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.eEz = personalTalkSettingActivity;
        this.eEz.setContentView(f.h.p2ptalk_setting_activity);
        this.mParent = this.eEz.findViewById(f.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eEz.getPageContext().getString(f.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eEI = (PersonaltalkSettingViewBlackManView) this.eEz.findViewById(f.g.black_status_view);
        this.eEJ = (PersonalTalkSettingViewSettingView) this.eEz.findViewById(f.g.setting_detail_view);
        this.eEH = (LinearLayout) this.eEz.findViewById(f.g.user_info_lin);
        this.eED = (TbSettingTextTipView) this.eEz.findViewById(f.g.st_delete_talk_history);
        this.eEE = (TbSettingTextTipView) this.eEz.findViewById(f.g.st_report);
        this.eEF = (TbSettingTextTipView) this.eEz.findViewById(f.g.add_to_black);
        this.eEG = (RelativeLayout) this.eEz.findViewById(f.g.remove_from_black_man);
        this.eED.setOnClickListener(this.eEz);
        this.eEE.setOnClickListener(this.eEz);
        this.eEF.setOnClickListener(this.eEz);
        this.eEG.setOnClickListener(this.eEz);
        this.eEH.setOnClickListener(this.eEz);
        this.doX = (HeadImageView) this.eEz.findViewById(f.g.photo);
        this.doX.setIsRound(true);
        this.mName = (TextView) this.eEz.findViewById(f.g.name);
        this.dJv = (UserIconBox) this.eEz.findViewById(f.g.user_icon_box);
        this.bDc = (TextView) this.eEz.findViewById(f.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.eEz.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eEz.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.eEI.setSex(i);
            this.eEI.setVisibility(0);
            this.eEJ.setVisibility(8);
            return;
        }
        this.eEJ.setVisibility(0);
        this.eEI.setVisibility(8);
    }

    public void ia(boolean z) {
        this.eEJ.ia(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.aOa(), fVar.aNZ().sex.intValue());
            ia(fVar.aNY());
            a(fVar.aNZ());
            f(fVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, f.C0146f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, f.C0146f.icon_pop_girl, 0);
            }
            this.bDc.setText(dataRes.intro);
            if (this.dJv != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dJv.a(linkedList, i, this.eEz.getResources().getDimensionPixelSize(f.e.ds28), this.eEz.getResources().getDimensionPixelSize(f.e.ds28), this.eEz.getResources().getDimensionPixelSize(f.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aNZ() != null && (str = fVar.aNZ().portrait) != null && str.length() > 0) {
            this.doX.setImageResource(0);
            this.doX.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.eEJ != null) {
            this.eEJ.setSwitchStateChangeListener(aVar);
        }
    }
}
