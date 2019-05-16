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
    private final TextView dwu;
    private final UserIconBox fPH;
    private final HeadImageView frU;
    public PersonaltalkSettingViewBlackManView gMA;
    public PersonalTalkSettingViewSettingView gMB;
    private final PersonalTalkSettingActivity gMr;
    private TbSettingTextTipView gMv;
    private TbSettingTextTipView gMw;
    private TbSettingTextTipView gMx;
    private RelativeLayout gMy;
    private LinearLayout gMz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.gMr = personalTalkSettingActivity;
        this.gMr.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.gMr.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gMr.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gMA = (PersonaltalkSettingViewBlackManView) this.gMr.findViewById(R.id.black_status_view);
        this.gMB = (PersonalTalkSettingViewSettingView) this.gMr.findViewById(R.id.setting_detail_view);
        this.gMz = (LinearLayout) this.gMr.findViewById(R.id.user_info_lin);
        this.gMv = (TbSettingTextTipView) this.gMr.findViewById(R.id.st_delete_talk_history);
        this.gMw = (TbSettingTextTipView) this.gMr.findViewById(R.id.st_report);
        this.gMx = (TbSettingTextTipView) this.gMr.findViewById(R.id.add_to_black);
        this.gMy = (RelativeLayout) this.gMr.findViewById(R.id.remove_from_black_man);
        this.gMv.setOnClickListener(this.gMr);
        this.gMw.setOnClickListener(this.gMr);
        this.gMx.setOnClickListener(this.gMr);
        this.gMy.setOnClickListener(this.gMr);
        this.gMz.setOnClickListener(this.gMr);
        this.frU = (HeadImageView) this.gMr.findViewById(R.id.photo);
        this.frU.setIsRound(true);
        this.mName = (TextView) this.gMr.findViewById(R.id.name);
        this.fPH = (UserIconBox) this.gMr.findViewById(R.id.user_icon_box);
        this.dwu = (TextView) this.gMr.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.gMr.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gMr.getPageContext(), i);
    }

    public void p(boolean z, int i) {
        if (z) {
            this.gMA.setSex(i);
            this.gMA.setVisibility(0);
            this.gMB.setVisibility(8);
            return;
        }
        this.gMB.setVisibility(0);
        this.gMA.setVisibility(8);
    }

    public void mu(boolean z) {
        this.gMB.mu(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            p(fVar.bEp(), fVar.bEo().sex.intValue());
            mu(fVar.bEn());
            a(fVar.bEo());
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
            this.dwu.setText(dataRes.intro);
            if (this.fPH != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.fPH.a(linkedList, i, this.gMr.getResources().getDimensionPixelSize(R.dimen.ds28), this.gMr.getResources().getDimensionPixelSize(R.dimen.ds28), this.gMr.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bEo() != null && (str = fVar.bEo().portrait) != null && str.length() > 0) {
            this.frU.setImageResource(0);
            this.frU.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.gMB != null) {
            this.gMB.setSwitchStateChangeListener(aVar);
        }
    }
}
