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
/* loaded from: classes2.dex */
public class g {
    private final TextView bDb;
    private final UserIconBox dJz;
    private final HeadImageView doZ;
    private final PersonalTalkSettingActivity eED;
    private TbSettingTextTipView eEH;
    private TbSettingTextTipView eEI;
    private TbSettingTextTipView eEJ;
    private RelativeLayout eEK;
    private LinearLayout eEL;
    public PersonaltalkSettingViewBlackManView eEM;
    public PersonalTalkSettingViewSettingView eEN;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.eED = personalTalkSettingActivity;
        this.eED.setContentView(d.h.p2ptalk_setting_activity);
        this.mParent = this.eED.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eED.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eEM = (PersonaltalkSettingViewBlackManView) this.eED.findViewById(d.g.black_status_view);
        this.eEN = (PersonalTalkSettingViewSettingView) this.eED.findViewById(d.g.setting_detail_view);
        this.eEL = (LinearLayout) this.eED.findViewById(d.g.user_info_lin);
        this.eEH = (TbSettingTextTipView) this.eED.findViewById(d.g.st_delete_talk_history);
        this.eEI = (TbSettingTextTipView) this.eED.findViewById(d.g.st_report);
        this.eEJ = (TbSettingTextTipView) this.eED.findViewById(d.g.add_to_black);
        this.eEK = (RelativeLayout) this.eED.findViewById(d.g.remove_from_black_man);
        this.eEH.setOnClickListener(this.eED);
        this.eEI.setOnClickListener(this.eED);
        this.eEJ.setOnClickListener(this.eED);
        this.eEK.setOnClickListener(this.eED);
        this.eEL.setOnClickListener(this.eED);
        this.doZ = (HeadImageView) this.eED.findViewById(d.g.photo);
        this.doZ.setIsRound(true);
        this.mName = (TextView) this.eED.findViewById(d.g.name);
        this.dJz = (UserIconBox) this.eED.findViewById(d.g.user_icon_box);
        this.bDb = (TextView) this.eED.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.eED.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eED.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.eEM.setSex(i);
            this.eEM.setVisibility(0);
            this.eEN.setVisibility(8);
            return;
        }
        this.eEN.setVisibility(0);
        this.eEM.setVisibility(8);
    }

    public void ia(boolean z) {
        this.eEN.ia(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.aOd(), fVar.aOc().sex.intValue());
            ia(fVar.aOb());
            a(fVar.aOc());
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
            this.bDb.setText(dataRes.intro);
            if (this.dJz != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dJz.a(linkedList, i, this.eED.getResources().getDimensionPixelSize(d.e.ds28), this.eED.getResources().getDimensionPixelSize(d.e.ds28), this.eED.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aOc() != null && (str = fVar.aOc().portrait) != null && str.length() > 0) {
            this.doZ.setImageResource(0);
            this.doZ.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.eEN != null) {
            this.eEN.setSwitchStateChangeListener(aVar);
        }
    }
}
