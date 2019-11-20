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
/* loaded from: classes4.dex */
public class g {
    private final TextView dFN;
    private final UserIconBox fVS;
    private final HeadImageView fxA;
    private TbSettingTextTipView gSC;
    private TbSettingTextTipView gSD;
    private TbSettingTextTipView gSE;
    private RelativeLayout gSF;
    private LinearLayout gSG;
    public PersonaltalkSettingViewBlackManView gSH;
    public PersonalTalkSettingViewSettingView gSI;
    private final PersonalTalkSettingActivity gSy;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.gSy = personalTalkSettingActivity;
        this.gSy.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.gSy.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gSy.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gSH = (PersonaltalkSettingViewBlackManView) this.gSy.findViewById(R.id.black_status_view);
        this.gSI = (PersonalTalkSettingViewSettingView) this.gSy.findViewById(R.id.setting_detail_view);
        this.gSG = (LinearLayout) this.gSy.findViewById(R.id.user_info_lin);
        this.gSC = (TbSettingTextTipView) this.gSy.findViewById(R.id.st_delete_talk_history);
        this.gSD = (TbSettingTextTipView) this.gSy.findViewById(R.id.st_report);
        this.gSE = (TbSettingTextTipView) this.gSy.findViewById(R.id.add_to_black);
        this.gSF = (RelativeLayout) this.gSy.findViewById(R.id.remove_from_black_man);
        this.gSC.setOnClickListener(this.gSy);
        this.gSD.setOnClickListener(this.gSy);
        this.gSE.setOnClickListener(this.gSy);
        this.gSF.setOnClickListener(this.gSy);
        this.gSG.setOnClickListener(this.gSy);
        this.fxA = (HeadImageView) this.gSy.findViewById(R.id.photo);
        this.fxA.setIsRound(true);
        this.mName = (TextView) this.gSy.findViewById(R.id.name);
        this.fVS = (UserIconBox) this.gSy.findViewById(R.id.user_icon_box);
        this.dFN = (TextView) this.gSy.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.gSy.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gSy.getPageContext(), i);
    }

    public void q(boolean z, int i) {
        if (z) {
            this.gSH.setSex(i);
            this.gSH.setVisibility(0);
            this.gSI.setVisibility(8);
            return;
        }
        this.gSI.setVisibility(0);
        this.gSH.setVisibility(8);
    }

    public void mA(boolean z) {
        this.gSI.mA(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            q(fVar.bEL(), fVar.bEK().sex.intValue());
            mA(fVar.bEJ());
            a(fVar.bEK());
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
            this.dFN.setText(dataRes.intro);
            if (this.fVS != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.fVS.a(linkedList, i, this.gSy.getResources().getDimensionPixelSize(R.dimen.ds28), this.gSy.getResources().getDimensionPixelSize(R.dimen.ds28), this.gSy.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bEK() != null && (str = fVar.bEK().portrait) != null && str.length() > 0) {
            this.fxA.setImageResource(0);
            this.fxA.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.gSI != null) {
            this.gSI.setSwitchStateChangeListener(aVar);
        }
    }
}
