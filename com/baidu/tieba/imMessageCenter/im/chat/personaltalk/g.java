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
/* loaded from: classes22.dex */
public class g {
    private final TextView gFB;
    private final UserIconBox jBh;
    private final PersonalTalkSettingActivity kFM;
    private TbSettingTextTipView kFQ;
    private TbSettingTextTipView kFR;
    private TbSettingTextTipView kFS;
    private RelativeLayout kFT;
    private LinearLayout kFU;
    public PersonaltalkSettingViewBlackManView kFV;
    public PersonalTalkSettingViewSettingView kFW;
    private final HeadImageView kjT;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.kFM = personalTalkSettingActivity;
        this.kFM.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.kFM.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kFM.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kFV = (PersonaltalkSettingViewBlackManView) this.kFM.findViewById(R.id.black_status_view);
        this.kFW = (PersonalTalkSettingViewSettingView) this.kFM.findViewById(R.id.setting_detail_view);
        this.kFU = (LinearLayout) this.kFM.findViewById(R.id.user_info_lin);
        this.kFQ = (TbSettingTextTipView) this.kFM.findViewById(R.id.st_delete_talk_history);
        this.kFR = (TbSettingTextTipView) this.kFM.findViewById(R.id.st_report);
        this.kFS = (TbSettingTextTipView) this.kFM.findViewById(R.id.add_to_black);
        this.kFT = (RelativeLayout) this.kFM.findViewById(R.id.remove_from_black_man);
        this.kFQ.setOnClickListener(this.kFM);
        this.kFR.setOnClickListener(this.kFM);
        this.kFS.setOnClickListener(this.kFM);
        this.kFT.setOnClickListener(this.kFM);
        this.kFU.setOnClickListener(this.kFM);
        this.kjT = (HeadImageView) this.kFM.findViewById(R.id.photo);
        this.kjT.setIsRound(true);
        this.mName = (TextView) this.kFM.findViewById(R.id.name);
        this.jBh = (UserIconBox) this.kFM.findViewById(R.id.user_icon_box);
        this.gFB = (TextView) this.kFM.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.kFM.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kFM.getPageContext(), i);
    }

    public void E(boolean z, int i) {
        if (z) {
            this.kFV.setSex(i);
            this.kFV.setVisibility(0);
            this.kFW.setVisibility(8);
            return;
        }
        this.kFW.setVisibility(0);
        this.kFV.setVisibility(8);
    }

    public void tb(boolean z) {
        this.kFW.tb(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            E(fVar.daI(), fVar.daH().sex.intValue());
            tb(fVar.daG());
            a(fVar.daH());
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
            this.gFB.setText(dataRes.intro);
            if (this.jBh != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.jBh.a(linkedList, i, this.kFM.getResources().getDimensionPixelSize(R.dimen.ds28), this.kFM.getResources().getDimensionPixelSize(R.dimen.ds28), this.kFM.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.daH() != null && (str = fVar.daH().portrait) != null && str.length() > 0) {
            this.kjT.setImageResource(0);
            this.kjT.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.kFW != null) {
            this.kFW.setSwitchStateChangeListener(aVar);
        }
    }
}
