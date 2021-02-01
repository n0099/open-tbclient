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
import com.baidu.tieba.R;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes2.dex */
public class g {
    private final TextView gPm;
    private final UserIconBox jPY;
    private final HeadImageView kAb;
    private TbSettingTextTipView kOA;
    private RelativeLayout kOB;
    private LinearLayout kOC;
    public PersonaltalkSettingViewBlackManView kOD;
    public PersonalTalkSettingViewSettingView kOE;
    private final PersonalTalkSettingActivity kOu;
    private TbSettingTextTipView kOy;
    private TbSettingTextTipView kOz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.kOu = personalTalkSettingActivity;
        this.kOu.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.kOu.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kOu.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kOD = (PersonaltalkSettingViewBlackManView) this.kOu.findViewById(R.id.black_status_view);
        this.kOE = (PersonalTalkSettingViewSettingView) this.kOu.findViewById(R.id.setting_detail_view);
        this.kOC = (LinearLayout) this.kOu.findViewById(R.id.user_info_lin);
        this.kOy = (TbSettingTextTipView) this.kOu.findViewById(R.id.st_delete_talk_history);
        this.kOz = (TbSettingTextTipView) this.kOu.findViewById(R.id.st_report);
        this.kOA = (TbSettingTextTipView) this.kOu.findViewById(R.id.add_to_black);
        this.kOB = (RelativeLayout) this.kOu.findViewById(R.id.remove_from_black_man);
        this.kOy.setOnClickListener(this.kOu);
        this.kOz.setOnClickListener(this.kOu);
        this.kOA.setOnClickListener(this.kOu);
        this.kOB.setOnClickListener(this.kOu);
        this.kOC.setOnClickListener(this.kOu);
        this.kAb = (HeadImageView) this.kOu.findViewById(R.id.photo);
        this.kAb.setIsRound(true);
        this.mName = (TextView) this.kOu.findViewById(R.id.name);
        this.jPY = (UserIconBox) this.kOu.findViewById(R.id.user_icon_box);
        this.gPm = (TextView) this.kOu.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.kOu.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kOu.getPageContext(), i);
    }

    public void D(boolean z, int i) {
        if (z) {
            this.kOD.setSex(i);
            this.kOD.setVisibility(0);
            this.kOE.setVisibility(8);
            return;
        }
        this.kOE.setVisibility(0);
        this.kOD.setVisibility(8);
    }

    public void tl(boolean z) {
        this.kOE.tl(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            D(fVar.cYs(), fVar.cYr().sex.intValue());
            tl(fVar.cYq());
            a(fVar.cYr());
            f(fVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
            }
            this.gPm.setText(dataRes.intro);
            if (this.jPY != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.jPY.a(linkedList, i, this.kOu.getResources().getDimensionPixelSize(R.dimen.ds28), this.kOu.getResources().getDimensionPixelSize(R.dimen.ds28), this.kOu.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cYr() != null && (str = fVar.cYr().portrait) != null && str.length() > 0) {
            this.kAb.setImageResource(0);
            this.kAb.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.kOE != null) {
            this.kOE.setSwitchStateChangeListener(aVar);
        }
    }
}
