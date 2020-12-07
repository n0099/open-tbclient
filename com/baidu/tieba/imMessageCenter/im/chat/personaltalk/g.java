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
    private final TextView gFz;
    private final UserIconBox jBf;
    private final PersonalTalkSettingActivity kFK;
    private TbSettingTextTipView kFO;
    private TbSettingTextTipView kFP;
    private TbSettingTextTipView kFQ;
    private RelativeLayout kFR;
    private LinearLayout kFS;
    public PersonaltalkSettingViewBlackManView kFT;
    public PersonalTalkSettingViewSettingView kFU;
    private final HeadImageView kjR;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.kFK = personalTalkSettingActivity;
        this.kFK.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.kFK.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kFK.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kFT = (PersonaltalkSettingViewBlackManView) this.kFK.findViewById(R.id.black_status_view);
        this.kFU = (PersonalTalkSettingViewSettingView) this.kFK.findViewById(R.id.setting_detail_view);
        this.kFS = (LinearLayout) this.kFK.findViewById(R.id.user_info_lin);
        this.kFO = (TbSettingTextTipView) this.kFK.findViewById(R.id.st_delete_talk_history);
        this.kFP = (TbSettingTextTipView) this.kFK.findViewById(R.id.st_report);
        this.kFQ = (TbSettingTextTipView) this.kFK.findViewById(R.id.add_to_black);
        this.kFR = (RelativeLayout) this.kFK.findViewById(R.id.remove_from_black_man);
        this.kFO.setOnClickListener(this.kFK);
        this.kFP.setOnClickListener(this.kFK);
        this.kFQ.setOnClickListener(this.kFK);
        this.kFR.setOnClickListener(this.kFK);
        this.kFS.setOnClickListener(this.kFK);
        this.kjR = (HeadImageView) this.kFK.findViewById(R.id.photo);
        this.kjR.setIsRound(true);
        this.mName = (TextView) this.kFK.findViewById(R.id.name);
        this.jBf = (UserIconBox) this.kFK.findViewById(R.id.user_icon_box);
        this.gFz = (TextView) this.kFK.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.kFK.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kFK.getPageContext(), i);
    }

    public void E(boolean z, int i) {
        if (z) {
            this.kFT.setSex(i);
            this.kFT.setVisibility(0);
            this.kFU.setVisibility(8);
            return;
        }
        this.kFU.setVisibility(0);
        this.kFT.setVisibility(8);
    }

    public void tb(boolean z) {
        this.kFU.tb(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            E(fVar.daH(), fVar.daG().sex.intValue());
            tb(fVar.daF());
            a(fVar.daG());
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
            this.gFz.setText(dataRes.intro);
            if (this.jBf != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.jBf.a(linkedList, i, this.kFK.getResources().getDimensionPixelSize(R.dimen.ds28), this.kFK.getResources().getDimensionPixelSize(R.dimen.ds28), this.kFK.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.daG() != null && (str = fVar.daG().portrait) != null && str.length() > 0) {
            this.kjR.setImageResource(0);
            this.kjR.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.kFU != null) {
            this.kFU.setSwitchStateChangeListener(aVar);
        }
    }
}
