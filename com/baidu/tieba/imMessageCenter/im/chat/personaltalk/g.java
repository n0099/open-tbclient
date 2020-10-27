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
/* loaded from: classes22.dex */
public class g {
    private final TextView grt;
    private final HeadImageView iEX;
    private final UserIconBox jgT;
    private final PersonalTalkSettingActivity klJ;
    private TbSettingTextTipView klN;
    private TbSettingTextTipView klO;
    private TbSettingTextTipView klP;
    private RelativeLayout klQ;
    private LinearLayout klR;
    public PersonaltalkSettingViewBlackManView klS;
    public PersonalTalkSettingViewSettingView klT;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.klJ = personalTalkSettingActivity;
        this.klJ.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.klJ.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.klJ.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.klS = (PersonaltalkSettingViewBlackManView) this.klJ.findViewById(R.id.black_status_view);
        this.klT = (PersonalTalkSettingViewSettingView) this.klJ.findViewById(R.id.setting_detail_view);
        this.klR = (LinearLayout) this.klJ.findViewById(R.id.user_info_lin);
        this.klN = (TbSettingTextTipView) this.klJ.findViewById(R.id.st_delete_talk_history);
        this.klO = (TbSettingTextTipView) this.klJ.findViewById(R.id.st_report);
        this.klP = (TbSettingTextTipView) this.klJ.findViewById(R.id.add_to_black);
        this.klQ = (RelativeLayout) this.klJ.findViewById(R.id.remove_from_black_man);
        this.klN.setOnClickListener(this.klJ);
        this.klO.setOnClickListener(this.klJ);
        this.klP.setOnClickListener(this.klJ);
        this.klQ.setOnClickListener(this.klJ);
        this.klR.setOnClickListener(this.klJ);
        this.iEX = (HeadImageView) this.klJ.findViewById(R.id.photo);
        this.iEX.setIsRound(true);
        this.mName = (TextView) this.klJ.findViewById(R.id.name);
        this.jgT = (UserIconBox) this.klJ.findViewById(R.id.user_icon_box);
        this.grt = (TextView) this.klJ.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.klJ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.klJ.getPageContext(), i);
    }

    public void E(boolean z, int i) {
        if (z) {
            this.klS.setSex(i);
            this.klS.setVisibility(0);
            this.klT.setVisibility(8);
            return;
        }
        this.klT.setVisibility(0);
        this.klS.setVisibility(8);
    }

    public void sn(boolean z) {
        this.klT.sn(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            E(fVar.cTo(), fVar.cTn().sex.intValue());
            sn(fVar.cTm());
            a(fVar.cTn());
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
            this.grt.setText(dataRes.intro);
            if (this.jgT != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.jgT.a(linkedList, i, this.klJ.getResources().getDimensionPixelSize(R.dimen.ds28), this.klJ.getResources().getDimensionPixelSize(R.dimen.ds28), this.klJ.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cTn() != null && (str = fVar.cTn().portrait) != null && str.length() > 0) {
            this.iEX.setImageResource(0);
            this.iEX.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.klT != null) {
            this.klT.setSwitchStateChangeListener(aVar);
        }
    }
}
