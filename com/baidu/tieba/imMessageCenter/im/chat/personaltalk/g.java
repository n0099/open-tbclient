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
    private final TextView exW;
    private final UserIconBox gQY;
    private final HeadImageView gsg;
    private final PersonalTalkSettingActivity hNQ;
    private TbSettingTextTipView hNU;
    private TbSettingTextTipView hNV;
    private TbSettingTextTipView hNW;
    private RelativeLayout hNX;
    private LinearLayout hNY;
    public PersonaltalkSettingViewBlackManView hNZ;
    public PersonalTalkSettingViewSettingView hOa;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.hNQ = personalTalkSettingActivity;
        this.hNQ.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.hNQ.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hNQ.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hNZ = (PersonaltalkSettingViewBlackManView) this.hNQ.findViewById(R.id.black_status_view);
        this.hOa = (PersonalTalkSettingViewSettingView) this.hNQ.findViewById(R.id.setting_detail_view);
        this.hNY = (LinearLayout) this.hNQ.findViewById(R.id.user_info_lin);
        this.hNU = (TbSettingTextTipView) this.hNQ.findViewById(R.id.st_delete_talk_history);
        this.hNV = (TbSettingTextTipView) this.hNQ.findViewById(R.id.st_report);
        this.hNW = (TbSettingTextTipView) this.hNQ.findViewById(R.id.add_to_black);
        this.hNX = (RelativeLayout) this.hNQ.findViewById(R.id.remove_from_black_man);
        this.hNU.setOnClickListener(this.hNQ);
        this.hNV.setOnClickListener(this.hNQ);
        this.hNW.setOnClickListener(this.hNQ);
        this.hNX.setOnClickListener(this.hNQ);
        this.hNY.setOnClickListener(this.hNQ);
        this.gsg = (HeadImageView) this.hNQ.findViewById(R.id.photo);
        this.gsg.setIsRound(true);
        this.mName = (TextView) this.hNQ.findViewById(R.id.name);
        this.gQY = (UserIconBox) this.hNQ.findViewById(R.id.user_icon_box);
        this.exW = (TextView) this.hNQ.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.hNQ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hNQ.getPageContext(), i);
    }

    public void v(boolean z, int i) {
        if (z) {
            this.hNZ.setSex(i);
            this.hNZ.setVisibility(0);
            this.hOa.setVisibility(8);
            return;
        }
        this.hOa.setVisibility(0);
        this.hNZ.setVisibility(8);
    }

    public void oh(boolean z) {
        this.hOa.oh(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            v(fVar.bZc(), fVar.bZb().sex.intValue());
            oh(fVar.bZa());
            a(fVar.bZb());
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
            this.exW.setText(dataRes.intro);
            if (this.gQY != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.gQY.a(linkedList, i, this.hNQ.getResources().getDimensionPixelSize(R.dimen.ds28), this.hNQ.getResources().getDimensionPixelSize(R.dimen.ds28), this.hNQ.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bZb() != null && (str = fVar.bZb().portrait) != null && str.length() > 0) {
            this.gsg.setImageResource(0);
            this.gsg.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.hOa != null) {
            this.hOa.setSwitchStateChangeListener(aVar);
        }
    }
}
