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
    private final TextView fcd;
    private final UserIconBox hBa;
    private final HeadImageView hbs;
    private final PersonalTalkSettingActivity ixH;
    private TbSettingTextTipView ixL;
    private TbSettingTextTipView ixM;
    private TbSettingTextTipView ixN;
    private RelativeLayout ixO;
    private LinearLayout ixP;
    public PersonaltalkSettingViewBlackManView ixQ;
    public PersonalTalkSettingViewSettingView ixR;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ixH = personalTalkSettingActivity;
        this.ixH.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.ixH.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ixH.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ixQ = (PersonaltalkSettingViewBlackManView) this.ixH.findViewById(R.id.black_status_view);
        this.ixR = (PersonalTalkSettingViewSettingView) this.ixH.findViewById(R.id.setting_detail_view);
        this.ixP = (LinearLayout) this.ixH.findViewById(R.id.user_info_lin);
        this.ixL = (TbSettingTextTipView) this.ixH.findViewById(R.id.st_delete_talk_history);
        this.ixM = (TbSettingTextTipView) this.ixH.findViewById(R.id.st_report);
        this.ixN = (TbSettingTextTipView) this.ixH.findViewById(R.id.add_to_black);
        this.ixO = (RelativeLayout) this.ixH.findViewById(R.id.remove_from_black_man);
        this.ixL.setOnClickListener(this.ixH);
        this.ixM.setOnClickListener(this.ixH);
        this.ixN.setOnClickListener(this.ixH);
        this.ixO.setOnClickListener(this.ixH);
        this.ixP.setOnClickListener(this.ixH);
        this.hbs = (HeadImageView) this.ixH.findViewById(R.id.photo);
        this.hbs.setIsRound(true);
        this.mName = (TextView) this.ixH.findViewById(R.id.name);
        this.hBa = (UserIconBox) this.ixH.findViewById(R.id.user_icon_box);
        this.fcd = (TextView) this.ixH.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.ixH.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ixH.getPageContext(), i);
    }

    public void w(boolean z, int i) {
        if (z) {
            this.ixQ.setSex(i);
            this.ixQ.setVisibility(0);
            this.ixR.setVisibility(8);
            return;
        }
        this.ixR.setVisibility(0);
        this.ixQ.setVisibility(8);
    }

    public void pl(boolean z) {
        this.ixR.pl(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            w(fVar.cjD(), fVar.cjC().sex.intValue());
            pl(fVar.cjB());
            a(fVar.cjC());
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
            this.fcd.setText(dataRes.intro);
            if (this.hBa != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.hBa.a(linkedList, i, this.ixH.getResources().getDimensionPixelSize(R.dimen.ds28), this.ixH.getResources().getDimensionPixelSize(R.dimen.ds28), this.ixH.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cjC() != null && (str = fVar.cjC().portrait) != null && str.length() > 0) {
            this.hbs.setImageResource(0);
            this.hbs.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.ixR != null) {
            this.ixR.setSwitchStateChangeListener(aVar);
        }
    }
}
