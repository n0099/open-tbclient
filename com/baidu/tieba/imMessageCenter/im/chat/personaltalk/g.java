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
    private final TextView exA;
    private final UserIconBox gPR;
    private final HeadImageView grw;
    public PersonalTalkSettingViewSettingView hMA;
    private final PersonalTalkSettingActivity hMq;
    private TbSettingTextTipView hMu;
    private TbSettingTextTipView hMv;
    private TbSettingTextTipView hMw;
    private RelativeLayout hMx;
    private LinearLayout hMy;
    public PersonaltalkSettingViewBlackManView hMz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.hMq = personalTalkSettingActivity;
        this.hMq.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.hMq.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hMq.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hMz = (PersonaltalkSettingViewBlackManView) this.hMq.findViewById(R.id.black_status_view);
        this.hMA = (PersonalTalkSettingViewSettingView) this.hMq.findViewById(R.id.setting_detail_view);
        this.hMy = (LinearLayout) this.hMq.findViewById(R.id.user_info_lin);
        this.hMu = (TbSettingTextTipView) this.hMq.findViewById(R.id.st_delete_talk_history);
        this.hMv = (TbSettingTextTipView) this.hMq.findViewById(R.id.st_report);
        this.hMw = (TbSettingTextTipView) this.hMq.findViewById(R.id.add_to_black);
        this.hMx = (RelativeLayout) this.hMq.findViewById(R.id.remove_from_black_man);
        this.hMu.setOnClickListener(this.hMq);
        this.hMv.setOnClickListener(this.hMq);
        this.hMw.setOnClickListener(this.hMq);
        this.hMx.setOnClickListener(this.hMq);
        this.hMy.setOnClickListener(this.hMq);
        this.grw = (HeadImageView) this.hMq.findViewById(R.id.photo);
        this.grw.setIsRound(true);
        this.mName = (TextView) this.hMq.findViewById(R.id.name);
        this.gPR = (UserIconBox) this.hMq.findViewById(R.id.user_icon_box);
        this.exA = (TextView) this.hMq.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.hMq.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hMq.getPageContext(), i);
    }

    public void v(boolean z, int i) {
        if (z) {
            this.hMz.setSex(i);
            this.hMz.setVisibility(0);
            this.hMA.setVisibility(8);
            return;
        }
        this.hMA.setVisibility(0);
        this.hMz.setVisibility(8);
    }

    public void ob(boolean z) {
        this.hMA.ob(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            v(fVar.bYK(), fVar.bYJ().sex.intValue());
            ob(fVar.bYI());
            a(fVar.bYJ());
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
            this.exA.setText(dataRes.intro);
            if (this.gPR != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.gPR.a(linkedList, i, this.hMq.getResources().getDimensionPixelSize(R.dimen.ds28), this.hMq.getResources().getDimensionPixelSize(R.dimen.ds28), this.hMq.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bYJ() != null && (str = fVar.bYJ().portrait) != null && str.length() > 0) {
            this.grw.setImageResource(0);
            this.grw.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.hMA != null) {
            this.hMA.setSwitchStateChangeListener(aVar);
        }
    }
}
