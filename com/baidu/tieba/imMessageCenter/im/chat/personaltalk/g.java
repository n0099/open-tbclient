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
    private final TextView fBh;
    private final HeadImageView hDg;
    private final UserIconBox ieb;
    private final PersonalTalkSettingActivity jei;
    private TbSettingTextTipView jem;
    private TbSettingTextTipView jen;
    private TbSettingTextTipView jeo;
    private RelativeLayout jep;
    private LinearLayout jeq;
    public PersonaltalkSettingViewBlackManView jer;
    public PersonalTalkSettingViewSettingView jes;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.jei = personalTalkSettingActivity;
        this.jei.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.jei.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jei.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jer = (PersonaltalkSettingViewBlackManView) this.jei.findViewById(R.id.black_status_view);
        this.jes = (PersonalTalkSettingViewSettingView) this.jei.findViewById(R.id.setting_detail_view);
        this.jeq = (LinearLayout) this.jei.findViewById(R.id.user_info_lin);
        this.jem = (TbSettingTextTipView) this.jei.findViewById(R.id.st_delete_talk_history);
        this.jen = (TbSettingTextTipView) this.jei.findViewById(R.id.st_report);
        this.jeo = (TbSettingTextTipView) this.jei.findViewById(R.id.add_to_black);
        this.jep = (RelativeLayout) this.jei.findViewById(R.id.remove_from_black_man);
        this.jem.setOnClickListener(this.jei);
        this.jen.setOnClickListener(this.jei);
        this.jeo.setOnClickListener(this.jei);
        this.jep.setOnClickListener(this.jei);
        this.jeq.setOnClickListener(this.jei);
        this.hDg = (HeadImageView) this.jei.findViewById(R.id.photo);
        this.hDg.setIsRound(true);
        this.mName = (TextView) this.jei.findViewById(R.id.name);
        this.ieb = (UserIconBox) this.jei.findViewById(R.id.user_icon_box);
        this.fBh = (TextView) this.jei.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.jei.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jei.getPageContext(), i);
    }

    public void B(boolean z, int i) {
        if (z) {
            this.jer.setSex(i);
            this.jer.setVisibility(0);
            this.jes.setVisibility(8);
            return;
        }
        this.jes.setVisibility(0);
        this.jer.setVisibility(8);
    }

    public void pR(boolean z) {
        this.jes.pR(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            B(fVar.ctZ(), fVar.ctY().sex.intValue());
            pR(fVar.ctX());
            a(fVar.ctY());
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
            this.fBh.setText(dataRes.intro);
            if (this.ieb != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.ieb.a(linkedList, i, this.jei.getResources().getDimensionPixelSize(R.dimen.ds28), this.jei.getResources().getDimensionPixelSize(R.dimen.ds28), this.jei.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.ctY() != null && (str = fVar.ctY().portrait) != null && str.length() > 0) {
            this.hDg.setImageResource(0);
            this.hDg.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.jes != null) {
            this.jes.setSwitchStateChangeListener(aVar);
        }
    }
}
