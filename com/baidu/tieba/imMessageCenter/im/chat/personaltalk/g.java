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
    private final TextView gPA;
    private final UserIconBox jQm;
    private final HeadImageView kAp;
    private final PersonalTalkSettingActivity kOI;
    private TbSettingTextTipView kOM;
    private TbSettingTextTipView kON;
    private TbSettingTextTipView kOO;
    private RelativeLayout kOP;
    private LinearLayout kOQ;
    public PersonaltalkSettingViewBlackManView kOR;
    public PersonalTalkSettingViewSettingView kOS;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.kOI = personalTalkSettingActivity;
        this.kOI.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.kOI.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kOI.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kOR = (PersonaltalkSettingViewBlackManView) this.kOI.findViewById(R.id.black_status_view);
        this.kOS = (PersonalTalkSettingViewSettingView) this.kOI.findViewById(R.id.setting_detail_view);
        this.kOQ = (LinearLayout) this.kOI.findViewById(R.id.user_info_lin);
        this.kOM = (TbSettingTextTipView) this.kOI.findViewById(R.id.st_delete_talk_history);
        this.kON = (TbSettingTextTipView) this.kOI.findViewById(R.id.st_report);
        this.kOO = (TbSettingTextTipView) this.kOI.findViewById(R.id.add_to_black);
        this.kOP = (RelativeLayout) this.kOI.findViewById(R.id.remove_from_black_man);
        this.kOM.setOnClickListener(this.kOI);
        this.kON.setOnClickListener(this.kOI);
        this.kOO.setOnClickListener(this.kOI);
        this.kOP.setOnClickListener(this.kOI);
        this.kOQ.setOnClickListener(this.kOI);
        this.kAp = (HeadImageView) this.kOI.findViewById(R.id.photo);
        this.kAp.setIsRound(true);
        this.mName = (TextView) this.kOI.findViewById(R.id.name);
        this.jQm = (UserIconBox) this.kOI.findViewById(R.id.user_icon_box);
        this.gPA = (TextView) this.kOI.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.kOI.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kOI.getPageContext(), i);
    }

    public void D(boolean z, int i) {
        if (z) {
            this.kOR.setSex(i);
            this.kOR.setVisibility(0);
            this.kOS.setVisibility(8);
            return;
        }
        this.kOS.setVisibility(0);
        this.kOR.setVisibility(8);
    }

    public void tl(boolean z) {
        this.kOS.tl(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            D(fVar.cYz(), fVar.cYy().sex.intValue());
            tl(fVar.cYx());
            a(fVar.cYy());
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
            this.gPA.setText(dataRes.intro);
            if (this.jQm != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.jQm.a(linkedList, i, this.kOI.getResources().getDimensionPixelSize(R.dimen.ds28), this.kOI.getResources().getDimensionPixelSize(R.dimen.ds28), this.kOI.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cYy() != null && (str = fVar.cYy().portrait) != null && str.length() > 0) {
            this.kAp.setImageResource(0);
            this.kAp.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.kOS != null) {
            this.kOS.setSwitchStateChangeListener(aVar);
        }
    }
}
