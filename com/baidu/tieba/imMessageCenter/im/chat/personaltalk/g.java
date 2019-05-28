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
    private final TextView dwv;
    private final UserIconBox fPI;
    private final HeadImageView frV;
    private LinearLayout gMA;
    public PersonaltalkSettingViewBlackManView gMB;
    public PersonalTalkSettingViewSettingView gMC;
    private final PersonalTalkSettingActivity gMs;
    private TbSettingTextTipView gMw;
    private TbSettingTextTipView gMx;
    private TbSettingTextTipView gMy;
    private RelativeLayout gMz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.gMs = personalTalkSettingActivity;
        this.gMs.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.gMs.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gMs.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gMB = (PersonaltalkSettingViewBlackManView) this.gMs.findViewById(R.id.black_status_view);
        this.gMC = (PersonalTalkSettingViewSettingView) this.gMs.findViewById(R.id.setting_detail_view);
        this.gMA = (LinearLayout) this.gMs.findViewById(R.id.user_info_lin);
        this.gMw = (TbSettingTextTipView) this.gMs.findViewById(R.id.st_delete_talk_history);
        this.gMx = (TbSettingTextTipView) this.gMs.findViewById(R.id.st_report);
        this.gMy = (TbSettingTextTipView) this.gMs.findViewById(R.id.add_to_black);
        this.gMz = (RelativeLayout) this.gMs.findViewById(R.id.remove_from_black_man);
        this.gMw.setOnClickListener(this.gMs);
        this.gMx.setOnClickListener(this.gMs);
        this.gMy.setOnClickListener(this.gMs);
        this.gMz.setOnClickListener(this.gMs);
        this.gMA.setOnClickListener(this.gMs);
        this.frV = (HeadImageView) this.gMs.findViewById(R.id.photo);
        this.frV.setIsRound(true);
        this.mName = (TextView) this.gMs.findViewById(R.id.name);
        this.fPI = (UserIconBox) this.gMs.findViewById(R.id.user_icon_box);
        this.dwv = (TextView) this.gMs.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.gMs.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gMs.getPageContext(), i);
    }

    public void p(boolean z, int i) {
        if (z) {
            this.gMB.setSex(i);
            this.gMB.setVisibility(0);
            this.gMC.setVisibility(8);
            return;
        }
        this.gMC.setVisibility(0);
        this.gMB.setVisibility(8);
    }

    public void mu(boolean z) {
        this.gMC.mu(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            p(fVar.bEs(), fVar.bEr().sex.intValue());
            mu(fVar.bEq());
            a(fVar.bEr());
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
            this.dwv.setText(dataRes.intro);
            if (this.fPI != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.fPI.a(linkedList, i, this.gMs.getResources().getDimensionPixelSize(R.dimen.ds28), this.gMs.getResources().getDimensionPixelSize(R.dimen.ds28), this.gMs.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bEr() != null && (str = fVar.bEr().portrait) != null && str.length() > 0) {
            this.frV.setImageResource(0);
            this.frV.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.gMC != null) {
            this.gMC.setSwitchStateChangeListener(aVar);
        }
    }
}
