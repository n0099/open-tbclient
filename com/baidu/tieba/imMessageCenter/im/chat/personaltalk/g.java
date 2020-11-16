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
/* loaded from: classes21.dex */
public class g {
    private final TextView gwO;
    private final HeadImageView iLH;
    private final UserIconBox jnD;
    private final PersonalTalkSettingActivity ksp;
    private TbSettingTextTipView kst;
    private TbSettingTextTipView ksu;
    private TbSettingTextTipView ksv;
    private RelativeLayout ksw;
    private LinearLayout ksx;
    public PersonaltalkSettingViewBlackManView ksy;
    public PersonalTalkSettingViewSettingView ksz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ksp = personalTalkSettingActivity;
        this.ksp.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.ksp.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ksp.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ksy = (PersonaltalkSettingViewBlackManView) this.ksp.findViewById(R.id.black_status_view);
        this.ksz = (PersonalTalkSettingViewSettingView) this.ksp.findViewById(R.id.setting_detail_view);
        this.ksx = (LinearLayout) this.ksp.findViewById(R.id.user_info_lin);
        this.kst = (TbSettingTextTipView) this.ksp.findViewById(R.id.st_delete_talk_history);
        this.ksu = (TbSettingTextTipView) this.ksp.findViewById(R.id.st_report);
        this.ksv = (TbSettingTextTipView) this.ksp.findViewById(R.id.add_to_black);
        this.ksw = (RelativeLayout) this.ksp.findViewById(R.id.remove_from_black_man);
        this.kst.setOnClickListener(this.ksp);
        this.ksu.setOnClickListener(this.ksp);
        this.ksv.setOnClickListener(this.ksp);
        this.ksw.setOnClickListener(this.ksp);
        this.ksx.setOnClickListener(this.ksp);
        this.iLH = (HeadImageView) this.ksp.findViewById(R.id.photo);
        this.iLH.setIsRound(true);
        this.mName = (TextView) this.ksp.findViewById(R.id.name);
        this.jnD = (UserIconBox) this.ksp.findViewById(R.id.user_icon_box);
        this.gwO = (TextView) this.ksp.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.ksp.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ksp.getPageContext(), i);
    }

    public void E(boolean z, int i) {
        if (z) {
            this.ksy.setSex(i);
            this.ksy.setVisibility(0);
            this.ksz.setVisibility(8);
            return;
        }
        this.ksz.setVisibility(0);
        this.ksy.setVisibility(8);
    }

    public void sz(boolean z) {
        this.ksz.sz(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            E(fVar.cVv(), fVar.cVu().sex.intValue());
            sz(fVar.cVt());
            a(fVar.cVu());
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
            this.gwO.setText(dataRes.intro);
            if (this.jnD != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.jnD.a(linkedList, i, this.ksp.getResources().getDimensionPixelSize(R.dimen.ds28), this.ksp.getResources().getDimensionPixelSize(R.dimen.ds28), this.ksp.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cVu() != null && (str = fVar.cVu().portrait) != null && str.length() > 0) {
            this.iLH.setImageResource(0);
            this.iLH.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.ksz != null) {
            this.ksz.setSwitchStateChangeListener(aVar);
        }
    }
}
