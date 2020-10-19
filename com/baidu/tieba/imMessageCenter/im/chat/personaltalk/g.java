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
    private final TextView ghq;
    private final UserIconBox iUx;
    private final HeadImageView isB;
    private final PersonalTalkSettingActivity jZj;
    private TbSettingTextTipView jZn;
    private TbSettingTextTipView jZo;
    private TbSettingTextTipView jZp;
    private RelativeLayout jZq;
    private LinearLayout jZr;
    public PersonaltalkSettingViewBlackManView jZs;
    public PersonalTalkSettingViewSettingView jZt;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.jZj = personalTalkSettingActivity;
        this.jZj.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.jZj.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jZj.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jZs = (PersonaltalkSettingViewBlackManView) this.jZj.findViewById(R.id.black_status_view);
        this.jZt = (PersonalTalkSettingViewSettingView) this.jZj.findViewById(R.id.setting_detail_view);
        this.jZr = (LinearLayout) this.jZj.findViewById(R.id.user_info_lin);
        this.jZn = (TbSettingTextTipView) this.jZj.findViewById(R.id.st_delete_talk_history);
        this.jZo = (TbSettingTextTipView) this.jZj.findViewById(R.id.st_report);
        this.jZp = (TbSettingTextTipView) this.jZj.findViewById(R.id.add_to_black);
        this.jZq = (RelativeLayout) this.jZj.findViewById(R.id.remove_from_black_man);
        this.jZn.setOnClickListener(this.jZj);
        this.jZo.setOnClickListener(this.jZj);
        this.jZp.setOnClickListener(this.jZj);
        this.jZq.setOnClickListener(this.jZj);
        this.jZr.setOnClickListener(this.jZj);
        this.isB = (HeadImageView) this.jZj.findViewById(R.id.photo);
        this.isB.setIsRound(true);
        this.mName = (TextView) this.jZj.findViewById(R.id.name);
        this.iUx = (UserIconBox) this.jZj.findViewById(R.id.user_icon_box);
        this.ghq = (TextView) this.jZj.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.jZj.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jZj.getPageContext(), i);
    }

    public void E(boolean z, int i) {
        if (z) {
            this.jZs.setSex(i);
            this.jZs.setVisibility(0);
            this.jZt.setVisibility(8);
            return;
        }
        this.jZt.setVisibility(0);
        this.jZs.setVisibility(8);
    }

    public void rV(boolean z) {
        this.jZt.rV(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            E(fVar.cQh(), fVar.cQg().sex.intValue());
            rV(fVar.cQf());
            a(fVar.cQg());
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
            this.ghq.setText(dataRes.intro);
            if (this.iUx != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.iUx.a(linkedList, i, this.jZj.getResources().getDimensionPixelSize(R.dimen.ds28), this.jZj.getResources().getDimensionPixelSize(R.dimen.ds28), this.jZj.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cQg() != null && (str = fVar.cQg().portrait) != null && str.length() > 0) {
            this.isB.setImageResource(0);
            this.isB.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.jZt != null) {
            this.jZt.setSwitchStateChangeListener(aVar);
        }
    }
}
