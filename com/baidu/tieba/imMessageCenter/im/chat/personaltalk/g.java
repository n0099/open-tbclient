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
    private final TextView gMG;
    private final UserIconBox jJb;
    public PersonalTalkSettingViewSettingView kGA;
    private final PersonalTalkSettingActivity kGq;
    private TbSettingTextTipView kGu;
    private TbSettingTextTipView kGv;
    private TbSettingTextTipView kGw;
    private RelativeLayout kGx;
    private LinearLayout kGy;
    public PersonaltalkSettingViewBlackManView kGz;
    private final HeadImageView krU;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.kGq = personalTalkSettingActivity;
        this.kGq.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.kGq.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kGq.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kGz = (PersonaltalkSettingViewBlackManView) this.kGq.findViewById(R.id.black_status_view);
        this.kGA = (PersonalTalkSettingViewSettingView) this.kGq.findViewById(R.id.setting_detail_view);
        this.kGy = (LinearLayout) this.kGq.findViewById(R.id.user_info_lin);
        this.kGu = (TbSettingTextTipView) this.kGq.findViewById(R.id.st_delete_talk_history);
        this.kGv = (TbSettingTextTipView) this.kGq.findViewById(R.id.st_report);
        this.kGw = (TbSettingTextTipView) this.kGq.findViewById(R.id.add_to_black);
        this.kGx = (RelativeLayout) this.kGq.findViewById(R.id.remove_from_black_man);
        this.kGu.setOnClickListener(this.kGq);
        this.kGv.setOnClickListener(this.kGq);
        this.kGw.setOnClickListener(this.kGq);
        this.kGx.setOnClickListener(this.kGq);
        this.kGy.setOnClickListener(this.kGq);
        this.krU = (HeadImageView) this.kGq.findViewById(R.id.photo);
        this.krU.setIsRound(true);
        this.mName = (TextView) this.kGq.findViewById(R.id.name);
        this.jJb = (UserIconBox) this.kGq.findViewById(R.id.user_icon_box);
        this.gMG = (TextView) this.kGq.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.kGq.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kGq.getPageContext(), i);
    }

    public void D(boolean z, int i) {
        if (z) {
            this.kGz.setSex(i);
            this.kGz.setVisibility(0);
            this.kGA.setVisibility(8);
            return;
        }
        this.kGA.setVisibility(0);
        this.kGz.setVisibility(8);
    }

    public void sY(boolean z) {
        this.kGA.sY(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            D(fVar.cWu(), fVar.cWt().sex.intValue());
            sY(fVar.cWs());
            a(fVar.cWt());
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
            this.gMG.setText(dataRes.intro);
            if (this.jJb != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.jJb.a(linkedList, i, this.kGq.getResources().getDimensionPixelSize(R.dimen.ds28), this.kGq.getResources().getDimensionPixelSize(R.dimen.ds28), this.kGq.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cWt() != null && (str = fVar.cWt().portrait) != null && str.length() > 0) {
            this.krU.setImageResource(0);
            this.krU.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.kGA != null) {
            this.kGA.setSwitchStateChangeListener(aVar);
        }
    }
}
