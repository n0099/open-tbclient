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
/* loaded from: classes9.dex */
public class g {
    private final TextView fpL;
    private final UserIconBox hPT;
    private final HeadImageView hqm;
    private RelativeLayout iMA;
    private LinearLayout iMB;
    public PersonaltalkSettingViewBlackManView iMC;
    public PersonalTalkSettingViewSettingView iMD;
    private final PersonalTalkSettingActivity iMt;
    private TbSettingTextTipView iMx;
    private TbSettingTextTipView iMy;
    private TbSettingTextTipView iMz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.iMt = personalTalkSettingActivity;
        this.iMt.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.iMt.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iMt.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iMC = (PersonaltalkSettingViewBlackManView) this.iMt.findViewById(R.id.black_status_view);
        this.iMD = (PersonalTalkSettingViewSettingView) this.iMt.findViewById(R.id.setting_detail_view);
        this.iMB = (LinearLayout) this.iMt.findViewById(R.id.user_info_lin);
        this.iMx = (TbSettingTextTipView) this.iMt.findViewById(R.id.st_delete_talk_history);
        this.iMy = (TbSettingTextTipView) this.iMt.findViewById(R.id.st_report);
        this.iMz = (TbSettingTextTipView) this.iMt.findViewById(R.id.add_to_black);
        this.iMA = (RelativeLayout) this.iMt.findViewById(R.id.remove_from_black_man);
        this.iMx.setOnClickListener(this.iMt);
        this.iMy.setOnClickListener(this.iMt);
        this.iMz.setOnClickListener(this.iMt);
        this.iMA.setOnClickListener(this.iMt);
        this.iMB.setOnClickListener(this.iMt);
        this.hqm = (HeadImageView) this.iMt.findViewById(R.id.photo);
        this.hqm.setIsRound(true);
        this.mName = (TextView) this.iMt.findViewById(R.id.name);
        this.hPT = (UserIconBox) this.iMt.findViewById(R.id.user_icon_box);
        this.fpL = (TextView) this.iMt.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.iMt.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iMt.getPageContext(), i);
    }

    public void z(boolean z, int i) {
        if (z) {
            this.iMC.setSex(i);
            this.iMC.setVisibility(0);
            this.iMD.setVisibility(8);
            return;
        }
        this.iMD.setVisibility(0);
        this.iMC.setVisibility(8);
    }

    public void pH(boolean z) {
        this.iMD.pH(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            z(fVar.cqa(), fVar.cpZ().sex.intValue());
            pH(fVar.cpY());
            a(fVar.cpZ());
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
            this.fpL.setText(dataRes.intro);
            if (this.hPT != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.hPT.a(linkedList, i, this.iMt.getResources().getDimensionPixelSize(R.dimen.ds28), this.iMt.getResources().getDimensionPixelSize(R.dimen.ds28), this.iMt.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cpZ() != null && (str = fVar.cpZ().portrait) != null && str.length() > 0) {
            this.hqm.setImageResource(0);
            this.hqm.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.iMD != null) {
            this.iMD.setSwitchStateChangeListener(aVar);
        }
    }
}
