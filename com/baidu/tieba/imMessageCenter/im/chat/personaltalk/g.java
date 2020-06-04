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
    private final TextView fpW;
    private final UserIconBox hQG;
    private final HeadImageView hqx;
    private final PersonalTalkSettingActivity iNg;
    private TbSettingTextTipView iNk;
    private TbSettingTextTipView iNl;
    private TbSettingTextTipView iNm;
    private RelativeLayout iNn;
    private LinearLayout iNo;
    public PersonaltalkSettingViewBlackManView iNp;
    public PersonalTalkSettingViewSettingView iNq;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.iNg = personalTalkSettingActivity;
        this.iNg.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.iNg.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iNg.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iNp = (PersonaltalkSettingViewBlackManView) this.iNg.findViewById(R.id.black_status_view);
        this.iNq = (PersonalTalkSettingViewSettingView) this.iNg.findViewById(R.id.setting_detail_view);
        this.iNo = (LinearLayout) this.iNg.findViewById(R.id.user_info_lin);
        this.iNk = (TbSettingTextTipView) this.iNg.findViewById(R.id.st_delete_talk_history);
        this.iNl = (TbSettingTextTipView) this.iNg.findViewById(R.id.st_report);
        this.iNm = (TbSettingTextTipView) this.iNg.findViewById(R.id.add_to_black);
        this.iNn = (RelativeLayout) this.iNg.findViewById(R.id.remove_from_black_man);
        this.iNk.setOnClickListener(this.iNg);
        this.iNl.setOnClickListener(this.iNg);
        this.iNm.setOnClickListener(this.iNg);
        this.iNn.setOnClickListener(this.iNg);
        this.iNo.setOnClickListener(this.iNg);
        this.hqx = (HeadImageView) this.iNg.findViewById(R.id.photo);
        this.hqx.setIsRound(true);
        this.mName = (TextView) this.iNg.findViewById(R.id.name);
        this.hQG = (UserIconBox) this.iNg.findViewById(R.id.user_icon_box);
        this.fpW = (TextView) this.iNg.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.iNg.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iNg.getPageContext(), i);
    }

    public void z(boolean z, int i) {
        if (z) {
            this.iNp.setSex(i);
            this.iNp.setVisibility(0);
            this.iNq.setVisibility(8);
            return;
        }
        this.iNq.setVisibility(0);
        this.iNp.setVisibility(8);
    }

    public void pH(boolean z) {
        this.iNq.pH(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            z(fVar.cqj(), fVar.cqi().sex.intValue());
            pH(fVar.cqh());
            a(fVar.cqi());
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
            this.fpW.setText(dataRes.intro);
            if (this.hQG != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.hQG.a(linkedList, i, this.iNg.getResources().getDimensionPixelSize(R.dimen.ds28), this.iNg.getResources().getDimensionPixelSize(R.dimen.ds28), this.iNg.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cqi() != null && (str = fVar.cqi().portrait) != null && str.length() > 0) {
            this.hqx.setImageResource(0);
            this.hqx.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.iNq != null) {
            this.iNq.setSwitchStateChangeListener(aVar);
        }
    }
}
