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
/* loaded from: classes2.dex */
public class g {
    private final TextView gRm;
    private final UserIconBox jNH;
    private final PersonalTalkSettingActivity kKV;
    private TbSettingTextTipView kKZ;
    private TbSettingTextTipView kLa;
    private TbSettingTextTipView kLb;
    private RelativeLayout kLc;
    private LinearLayout kLd;
    public PersonaltalkSettingViewBlackManView kLe;
    public PersonalTalkSettingViewSettingView kLf;
    private final HeadImageView kwz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.kKV = personalTalkSettingActivity;
        this.kKV.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.kKV.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kKV.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kLe = (PersonaltalkSettingViewBlackManView) this.kKV.findViewById(R.id.black_status_view);
        this.kLf = (PersonalTalkSettingViewSettingView) this.kKV.findViewById(R.id.setting_detail_view);
        this.kLd = (LinearLayout) this.kKV.findViewById(R.id.user_info_lin);
        this.kKZ = (TbSettingTextTipView) this.kKV.findViewById(R.id.st_delete_talk_history);
        this.kLa = (TbSettingTextTipView) this.kKV.findViewById(R.id.st_report);
        this.kLb = (TbSettingTextTipView) this.kKV.findViewById(R.id.add_to_black);
        this.kLc = (RelativeLayout) this.kKV.findViewById(R.id.remove_from_black_man);
        this.kKZ.setOnClickListener(this.kKV);
        this.kLa.setOnClickListener(this.kKV);
        this.kLb.setOnClickListener(this.kKV);
        this.kLc.setOnClickListener(this.kKV);
        this.kLd.setOnClickListener(this.kKV);
        this.kwz = (HeadImageView) this.kKV.findViewById(R.id.photo);
        this.kwz.setIsRound(true);
        this.mName = (TextView) this.kKV.findViewById(R.id.name);
        this.jNH = (UserIconBox) this.kKV.findViewById(R.id.user_icon_box);
        this.gRm = (TextView) this.kKV.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.kKV.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kKV.getPageContext(), i);
    }

    public void D(boolean z, int i) {
        if (z) {
            this.kLe.setSex(i);
            this.kLe.setVisibility(0);
            this.kLf.setVisibility(8);
            return;
        }
        this.kLf.setVisibility(0);
        this.kLe.setVisibility(8);
    }

    public void tc(boolean z) {
        this.kLf.tc(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            D(fVar.dal(), fVar.dak().sex.intValue());
            tc(fVar.daj());
            a(fVar.dak());
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
            this.gRm.setText(dataRes.intro);
            if (this.jNH != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.jNH.a(linkedList, i, this.kKV.getResources().getDimensionPixelSize(R.dimen.ds28), this.kKV.getResources().getDimensionPixelSize(R.dimen.ds28), this.kKV.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.dak() != null && (str = fVar.dak().portrait) != null && str.length() > 0) {
            this.kwz.setImageResource(0);
            this.kwz.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.kLf != null) {
            this.kLf.setSwitchStateChangeListener(aVar);
        }
    }
}
