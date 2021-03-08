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
    private final TextView gRj;
    private final UserIconBox jRV;
    private final HeadImageView kCr;
    private final PersonalTalkSettingActivity kQK;
    private TbSettingTextTipView kQO;
    private TbSettingTextTipView kQP;
    private TbSettingTextTipView kQQ;
    private RelativeLayout kQR;
    private LinearLayout kQS;
    public PersonaltalkSettingViewBlackManView kQT;
    public PersonalTalkSettingViewSettingView kQU;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.kQK = personalTalkSettingActivity;
        this.kQK.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.kQK.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kQK.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kQT = (PersonaltalkSettingViewBlackManView) this.kQK.findViewById(R.id.black_status_view);
        this.kQU = (PersonalTalkSettingViewSettingView) this.kQK.findViewById(R.id.setting_detail_view);
        this.kQS = (LinearLayout) this.kQK.findViewById(R.id.user_info_lin);
        this.kQO = (TbSettingTextTipView) this.kQK.findViewById(R.id.st_delete_talk_history);
        this.kQP = (TbSettingTextTipView) this.kQK.findViewById(R.id.st_report);
        this.kQQ = (TbSettingTextTipView) this.kQK.findViewById(R.id.add_to_black);
        this.kQR = (RelativeLayout) this.kQK.findViewById(R.id.remove_from_black_man);
        this.kQO.setOnClickListener(this.kQK);
        this.kQP.setOnClickListener(this.kQK);
        this.kQQ.setOnClickListener(this.kQK);
        this.kQR.setOnClickListener(this.kQK);
        this.kQS.setOnClickListener(this.kQK);
        this.kCr = (HeadImageView) this.kQK.findViewById(R.id.photo);
        this.kCr.setIsRound(true);
        this.mName = (TextView) this.kQK.findViewById(R.id.name);
        this.jRV = (UserIconBox) this.kQK.findViewById(R.id.user_icon_box);
        this.gRj = (TextView) this.kQK.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.kQK.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kQK.getPageContext(), i);
    }

    public void D(boolean z, int i) {
        if (z) {
            this.kQT.setSex(i);
            this.kQT.setVisibility(0);
            this.kQU.setVisibility(8);
            return;
        }
        this.kQU.setVisibility(0);
        this.kQT.setVisibility(8);
    }

    public void tl(boolean z) {
        this.kQU.tl(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            D(fVar.cYG(), fVar.cYF().sex.intValue());
            tl(fVar.cYE());
            a(fVar.cYF());
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
            this.gRj.setText(dataRes.intro);
            if (this.jRV != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.jRV.a(linkedList, i, this.kQK.getResources().getDimensionPixelSize(R.dimen.ds28), this.kQK.getResources().getDimensionPixelSize(R.dimen.ds28), this.kQK.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cYF() != null && (str = fVar.cYF().portrait) != null && str.length() > 0) {
            this.kCr.setImageResource(0);
            this.kCr.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.kQU != null) {
            this.kQU.setSwitchStateChangeListener(aVar);
        }
    }
}
