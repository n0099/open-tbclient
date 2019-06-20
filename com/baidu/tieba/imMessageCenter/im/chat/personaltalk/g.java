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
/* loaded from: classes4.dex */
public class g {
    private final TextView dwv;
    private final UserIconBox fPK;
    private final HeadImageView frV;
    private TbSettingTextTipView gMA;
    private RelativeLayout gMB;
    private LinearLayout gMC;
    public PersonaltalkSettingViewBlackManView gMD;
    public PersonalTalkSettingViewSettingView gME;
    private final PersonalTalkSettingActivity gMu;
    private TbSettingTextTipView gMy;
    private TbSettingTextTipView gMz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.gMu = personalTalkSettingActivity;
        this.gMu.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.gMu.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gMu.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gMD = (PersonaltalkSettingViewBlackManView) this.gMu.findViewById(R.id.black_status_view);
        this.gME = (PersonalTalkSettingViewSettingView) this.gMu.findViewById(R.id.setting_detail_view);
        this.gMC = (LinearLayout) this.gMu.findViewById(R.id.user_info_lin);
        this.gMy = (TbSettingTextTipView) this.gMu.findViewById(R.id.st_delete_talk_history);
        this.gMz = (TbSettingTextTipView) this.gMu.findViewById(R.id.st_report);
        this.gMA = (TbSettingTextTipView) this.gMu.findViewById(R.id.add_to_black);
        this.gMB = (RelativeLayout) this.gMu.findViewById(R.id.remove_from_black_man);
        this.gMy.setOnClickListener(this.gMu);
        this.gMz.setOnClickListener(this.gMu);
        this.gMA.setOnClickListener(this.gMu);
        this.gMB.setOnClickListener(this.gMu);
        this.gMC.setOnClickListener(this.gMu);
        this.frV = (HeadImageView) this.gMu.findViewById(R.id.photo);
        this.frV.setIsRound(true);
        this.mName = (TextView) this.gMu.findViewById(R.id.name);
        this.fPK = (UserIconBox) this.gMu.findViewById(R.id.user_icon_box);
        this.dwv = (TextView) this.gMu.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.gMu.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gMu.getPageContext(), i);
    }

    public void p(boolean z, int i) {
        if (z) {
            this.gMD.setSex(i);
            this.gMD.setVisibility(0);
            this.gME.setVisibility(8);
            return;
        }
        this.gME.setVisibility(0);
        this.gMD.setVisibility(8);
    }

    public void mv(boolean z) {
        this.gME.mv(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            p(fVar.bEt(), fVar.bEs().sex.intValue());
            mv(fVar.bEr());
            a(fVar.bEs());
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
            this.dwv.setText(dataRes.intro);
            if (this.fPK != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.fPK.a(linkedList, i, this.gMu.getResources().getDimensionPixelSize(R.dimen.ds28), this.gMu.getResources().getDimensionPixelSize(R.dimen.ds28), this.gMu.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bEs() != null && (str = fVar.bEs().portrait) != null && str.length() > 0) {
            this.frV.setImageResource(0);
            this.frV.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.gME != null) {
            this.gME.setSwitchStateChangeListener(aVar);
        }
    }
}
