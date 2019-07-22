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
    private final TextView dzt;
    private final HeadImageView eef;
    private final UserIconBox fUH;
    private final PersonalTalkSettingActivity gSE;
    private TbSettingTextTipView gSI;
    private TbSettingTextTipView gSJ;
    private TbSettingTextTipView gSK;
    private RelativeLayout gSL;
    private LinearLayout gSM;
    public PersonaltalkSettingViewBlackManView gSN;
    public PersonalTalkSettingViewSettingView gSO;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.gSE = personalTalkSettingActivity;
        this.gSE.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.gSE.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gSE.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gSN = (PersonaltalkSettingViewBlackManView) this.gSE.findViewById(R.id.black_status_view);
        this.gSO = (PersonalTalkSettingViewSettingView) this.gSE.findViewById(R.id.setting_detail_view);
        this.gSM = (LinearLayout) this.gSE.findViewById(R.id.user_info_lin);
        this.gSI = (TbSettingTextTipView) this.gSE.findViewById(R.id.st_delete_talk_history);
        this.gSJ = (TbSettingTextTipView) this.gSE.findViewById(R.id.st_report);
        this.gSK = (TbSettingTextTipView) this.gSE.findViewById(R.id.add_to_black);
        this.gSL = (RelativeLayout) this.gSE.findViewById(R.id.remove_from_black_man);
        this.gSI.setOnClickListener(this.gSE);
        this.gSJ.setOnClickListener(this.gSE);
        this.gSK.setOnClickListener(this.gSE);
        this.gSL.setOnClickListener(this.gSE);
        this.gSM.setOnClickListener(this.gSE);
        this.eef = (HeadImageView) this.gSE.findViewById(R.id.photo);
        this.eef.setIsRound(true);
        this.mName = (TextView) this.gSE.findViewById(R.id.name);
        this.fUH = (UserIconBox) this.gSE.findViewById(R.id.user_icon_box);
        this.dzt = (TextView) this.gSE.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.gSE.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gSE.getPageContext(), i);
    }

    public void p(boolean z, int i) {
        if (z) {
            this.gSN.setSex(i);
            this.gSN.setVisibility(0);
            this.gSO.setVisibility(8);
            return;
        }
        this.gSO.setVisibility(0);
        this.gSN.setVisibility(8);
    }

    public void mJ(boolean z) {
        this.gSO.mJ(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            p(fVar.bHa(), fVar.bGZ().sex.intValue());
            mJ(fVar.bGY());
            a(fVar.bGZ());
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
            this.dzt.setText(dataRes.intro);
            if (this.fUH != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.fUH.a(linkedList, i, this.gSE.getResources().getDimensionPixelSize(R.dimen.ds28), this.gSE.getResources().getDimensionPixelSize(R.dimen.ds28), this.gSE.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bGZ() != null && (str = fVar.bGZ().portrait) != null && str.length() > 0) {
            this.eef.setImageResource(0);
            this.eef.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.gSO != null) {
            this.gSO.setSwitchStateChangeListener(aVar);
        }
    }
}
