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
    private final TextView exl;
    private final UserIconBox gPD;
    private final HeadImageView grh;
    private final PersonalTalkSettingActivity hMc;
    private TbSettingTextTipView hMg;
    private TbSettingTextTipView hMh;
    private TbSettingTextTipView hMi;
    private RelativeLayout hMj;
    private LinearLayout hMk;
    public PersonaltalkSettingViewBlackManView hMl;
    public PersonalTalkSettingViewSettingView hMm;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.hMc = personalTalkSettingActivity;
        this.hMc.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.hMc.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hMc.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hMl = (PersonaltalkSettingViewBlackManView) this.hMc.findViewById(R.id.black_status_view);
        this.hMm = (PersonalTalkSettingViewSettingView) this.hMc.findViewById(R.id.setting_detail_view);
        this.hMk = (LinearLayout) this.hMc.findViewById(R.id.user_info_lin);
        this.hMg = (TbSettingTextTipView) this.hMc.findViewById(R.id.st_delete_talk_history);
        this.hMh = (TbSettingTextTipView) this.hMc.findViewById(R.id.st_report);
        this.hMi = (TbSettingTextTipView) this.hMc.findViewById(R.id.add_to_black);
        this.hMj = (RelativeLayout) this.hMc.findViewById(R.id.remove_from_black_man);
        this.hMg.setOnClickListener(this.hMc);
        this.hMh.setOnClickListener(this.hMc);
        this.hMi.setOnClickListener(this.hMc);
        this.hMj.setOnClickListener(this.hMc);
        this.hMk.setOnClickListener(this.hMc);
        this.grh = (HeadImageView) this.hMc.findViewById(R.id.photo);
        this.grh.setIsRound(true);
        this.mName = (TextView) this.hMc.findViewById(R.id.name);
        this.gPD = (UserIconBox) this.hMc.findViewById(R.id.user_icon_box);
        this.exl = (TextView) this.hMc.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.hMc.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hMc.getPageContext(), i);
    }

    public void v(boolean z, int i) {
        if (z) {
            this.hMl.setSex(i);
            this.hMl.setVisibility(0);
            this.hMm.setVisibility(8);
            return;
        }
        this.hMm.setVisibility(0);
        this.hMl.setVisibility(8);
    }

    public void ob(boolean z) {
        this.hMm.ob(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            v(fVar.bYH(), fVar.bYG().sex.intValue());
            ob(fVar.bYF());
            a(fVar.bYG());
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
            this.exl.setText(dataRes.intro);
            if (this.gPD != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.gPD.a(linkedList, i, this.hMc.getResources().getDimensionPixelSize(R.dimen.ds28), this.hMc.getResources().getDimensionPixelSize(R.dimen.ds28), this.hMc.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bYG() != null && (str = fVar.bYG().portrait) != null && str.length() > 0) {
            this.grh.setImageResource(0);
            this.grh.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.hMm != null) {
            this.hMm.setSwitchStateChangeListener(aVar);
        }
    }
}
