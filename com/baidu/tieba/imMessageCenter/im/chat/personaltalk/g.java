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
    private final TextView exm;
    private final UserIconBox gPF;
    private final HeadImageView grj;
    private final PersonalTalkSettingActivity hMe;
    private TbSettingTextTipView hMi;
    private TbSettingTextTipView hMj;
    private TbSettingTextTipView hMk;
    private RelativeLayout hMl;
    private LinearLayout hMm;
    public PersonaltalkSettingViewBlackManView hMn;
    public PersonalTalkSettingViewSettingView hMo;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.hMe = personalTalkSettingActivity;
        this.hMe.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.hMe.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hMe.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hMn = (PersonaltalkSettingViewBlackManView) this.hMe.findViewById(R.id.black_status_view);
        this.hMo = (PersonalTalkSettingViewSettingView) this.hMe.findViewById(R.id.setting_detail_view);
        this.hMm = (LinearLayout) this.hMe.findViewById(R.id.user_info_lin);
        this.hMi = (TbSettingTextTipView) this.hMe.findViewById(R.id.st_delete_talk_history);
        this.hMj = (TbSettingTextTipView) this.hMe.findViewById(R.id.st_report);
        this.hMk = (TbSettingTextTipView) this.hMe.findViewById(R.id.add_to_black);
        this.hMl = (RelativeLayout) this.hMe.findViewById(R.id.remove_from_black_man);
        this.hMi.setOnClickListener(this.hMe);
        this.hMj.setOnClickListener(this.hMe);
        this.hMk.setOnClickListener(this.hMe);
        this.hMl.setOnClickListener(this.hMe);
        this.hMm.setOnClickListener(this.hMe);
        this.grj = (HeadImageView) this.hMe.findViewById(R.id.photo);
        this.grj.setIsRound(true);
        this.mName = (TextView) this.hMe.findViewById(R.id.name);
        this.gPF = (UserIconBox) this.hMe.findViewById(R.id.user_icon_box);
        this.exm = (TextView) this.hMe.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.hMe.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hMe.getPageContext(), i);
    }

    public void v(boolean z, int i) {
        if (z) {
            this.hMn.setSex(i);
            this.hMn.setVisibility(0);
            this.hMo.setVisibility(8);
            return;
        }
        this.hMo.setVisibility(0);
        this.hMn.setVisibility(8);
    }

    public void ob(boolean z) {
        this.hMo.ob(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            v(fVar.bYJ(), fVar.bYI().sex.intValue());
            ob(fVar.bYH());
            a(fVar.bYI());
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
            this.exm.setText(dataRes.intro);
            if (this.gPF != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.gPF.a(linkedList, i, this.hMe.getResources().getDimensionPixelSize(R.dimen.ds28), this.hMe.getResources().getDimensionPixelSize(R.dimen.ds28), this.hMe.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bYI() != null && (str = fVar.bYI().portrait) != null && str.length() > 0) {
            this.grj.setImageResource(0);
            this.grj.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.hMo != null) {
            this.hMo.setSwitchStateChangeListener(aVar);
        }
    }
}
