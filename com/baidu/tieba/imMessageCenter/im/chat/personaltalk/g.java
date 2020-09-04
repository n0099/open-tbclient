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
/* loaded from: classes16.dex */
public class g {
    private final TextView fRM;
    private final HeadImageView hWA;
    private final UserIconBox iyl;
    private final PersonalTalkSettingActivity jBK;
    private TbSettingTextTipView jBO;
    private TbSettingTextTipView jBP;
    private TbSettingTextTipView jBQ;
    private RelativeLayout jBR;
    private LinearLayout jBS;
    public PersonaltalkSettingViewBlackManView jBT;
    public PersonalTalkSettingViewSettingView jBU;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.jBK = personalTalkSettingActivity;
        this.jBK.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.jBK.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jBK.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jBT = (PersonaltalkSettingViewBlackManView) this.jBK.findViewById(R.id.black_status_view);
        this.jBU = (PersonalTalkSettingViewSettingView) this.jBK.findViewById(R.id.setting_detail_view);
        this.jBS = (LinearLayout) this.jBK.findViewById(R.id.user_info_lin);
        this.jBO = (TbSettingTextTipView) this.jBK.findViewById(R.id.st_delete_talk_history);
        this.jBP = (TbSettingTextTipView) this.jBK.findViewById(R.id.st_report);
        this.jBQ = (TbSettingTextTipView) this.jBK.findViewById(R.id.add_to_black);
        this.jBR = (RelativeLayout) this.jBK.findViewById(R.id.remove_from_black_man);
        this.jBO.setOnClickListener(this.jBK);
        this.jBP.setOnClickListener(this.jBK);
        this.jBQ.setOnClickListener(this.jBK);
        this.jBR.setOnClickListener(this.jBK);
        this.jBS.setOnClickListener(this.jBK);
        this.hWA = (HeadImageView) this.jBK.findViewById(R.id.photo);
        this.hWA.setIsRound(true);
        this.mName = (TextView) this.jBK.findViewById(R.id.name);
        this.iyl = (UserIconBox) this.jBK.findViewById(R.id.user_icon_box);
        this.fRM = (TextView) this.jBK.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.jBK.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jBK.getPageContext(), i);
    }

    public void B(boolean z, int i) {
        if (z) {
            this.jBT.setSex(i);
            this.jBT.setVisibility(0);
            this.jBU.setVisibility(8);
            return;
        }
        this.jBU.setVisibility(0);
        this.jBT.setVisibility(8);
    }

    public void rh(boolean z) {
        this.jBU.rh(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            B(fVar.cIT(), fVar.cIS().sex.intValue());
            rh(fVar.cIR());
            a(fVar.cIS());
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
            this.fRM.setText(dataRes.intro);
            if (this.iyl != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.iyl.a(linkedList, i, this.jBK.getResources().getDimensionPixelSize(R.dimen.ds28), this.jBK.getResources().getDimensionPixelSize(R.dimen.ds28), this.jBK.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cIS() != null && (str = fVar.cIS().portrait) != null && str.length() > 0) {
            this.hWA.setImageResource(0);
            this.hWA.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.jBU != null) {
            this.jBU.setSwitchStateChangeListener(aVar);
        }
    }
}
