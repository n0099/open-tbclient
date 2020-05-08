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
    private final TextView fci;
    private final UserIconBox hBg;
    private final HeadImageView hby;
    private final PersonalTalkSettingActivity ixN;
    private TbSettingTextTipView ixR;
    private TbSettingTextTipView ixS;
    private TbSettingTextTipView ixT;
    private RelativeLayout ixU;
    private LinearLayout ixV;
    public PersonaltalkSettingViewBlackManView ixW;
    public PersonalTalkSettingViewSettingView ixX;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ixN = personalTalkSettingActivity;
        this.ixN.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.ixN.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ixN.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ixW = (PersonaltalkSettingViewBlackManView) this.ixN.findViewById(R.id.black_status_view);
        this.ixX = (PersonalTalkSettingViewSettingView) this.ixN.findViewById(R.id.setting_detail_view);
        this.ixV = (LinearLayout) this.ixN.findViewById(R.id.user_info_lin);
        this.ixR = (TbSettingTextTipView) this.ixN.findViewById(R.id.st_delete_talk_history);
        this.ixS = (TbSettingTextTipView) this.ixN.findViewById(R.id.st_report);
        this.ixT = (TbSettingTextTipView) this.ixN.findViewById(R.id.add_to_black);
        this.ixU = (RelativeLayout) this.ixN.findViewById(R.id.remove_from_black_man);
        this.ixR.setOnClickListener(this.ixN);
        this.ixS.setOnClickListener(this.ixN);
        this.ixT.setOnClickListener(this.ixN);
        this.ixU.setOnClickListener(this.ixN);
        this.ixV.setOnClickListener(this.ixN);
        this.hby = (HeadImageView) this.ixN.findViewById(R.id.photo);
        this.hby.setIsRound(true);
        this.mName = (TextView) this.ixN.findViewById(R.id.name);
        this.hBg = (UserIconBox) this.ixN.findViewById(R.id.user_icon_box);
        this.fci = (TextView) this.ixN.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.ixN.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ixN.getPageContext(), i);
    }

    public void w(boolean z, int i) {
        if (z) {
            this.ixW.setSex(i);
            this.ixW.setVisibility(0);
            this.ixX.setVisibility(8);
            return;
        }
        this.ixX.setVisibility(0);
        this.ixW.setVisibility(8);
    }

    public void pl(boolean z) {
        this.ixX.pl(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            w(fVar.cjB(), fVar.cjA().sex.intValue());
            pl(fVar.cjz());
            a(fVar.cjA());
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
            this.fci.setText(dataRes.intro);
            if (this.hBg != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.hBg.a(linkedList, i, this.ixN.getResources().getDimensionPixelSize(R.dimen.ds28), this.ixN.getResources().getDimensionPixelSize(R.dimen.ds28), this.ixN.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cjA() != null && (str = fVar.cjA().portrait) != null && str.length() > 0) {
            this.hby.setImageResource(0);
            this.hby.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.ixX != null) {
            this.ixX.setSwitchStateChangeListener(aVar);
        }
    }
}
