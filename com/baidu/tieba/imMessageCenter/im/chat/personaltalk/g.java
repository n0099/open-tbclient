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
    private final TextView dBl;
    private final HeadImageView efW;
    private final UserIconBox fXo;
    private final PersonalTalkSettingActivity gVp;
    private TbSettingTextTipView gVt;
    private TbSettingTextTipView gVu;
    private TbSettingTextTipView gVv;
    private RelativeLayout gVw;
    private LinearLayout gVx;
    public PersonaltalkSettingViewBlackManView gVy;
    public PersonalTalkSettingViewSettingView gVz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.gVp = personalTalkSettingActivity;
        this.gVp.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.gVp.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gVp.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gVy = (PersonaltalkSettingViewBlackManView) this.gVp.findViewById(R.id.black_status_view);
        this.gVz = (PersonalTalkSettingViewSettingView) this.gVp.findViewById(R.id.setting_detail_view);
        this.gVx = (LinearLayout) this.gVp.findViewById(R.id.user_info_lin);
        this.gVt = (TbSettingTextTipView) this.gVp.findViewById(R.id.st_delete_talk_history);
        this.gVu = (TbSettingTextTipView) this.gVp.findViewById(R.id.st_report);
        this.gVv = (TbSettingTextTipView) this.gVp.findViewById(R.id.add_to_black);
        this.gVw = (RelativeLayout) this.gVp.findViewById(R.id.remove_from_black_man);
        this.gVt.setOnClickListener(this.gVp);
        this.gVu.setOnClickListener(this.gVp);
        this.gVv.setOnClickListener(this.gVp);
        this.gVw.setOnClickListener(this.gVp);
        this.gVx.setOnClickListener(this.gVp);
        this.efW = (HeadImageView) this.gVp.findViewById(R.id.photo);
        this.efW.setIsRound(true);
        this.mName = (TextView) this.gVp.findViewById(R.id.name);
        this.fXo = (UserIconBox) this.gVp.findViewById(R.id.user_icon_box);
        this.dBl = (TextView) this.gVp.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.gVp.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gVp.getPageContext(), i);
    }

    public void p(boolean z, int i) {
        if (z) {
            this.gVy.setSex(i);
            this.gVy.setVisibility(0);
            this.gVz.setVisibility(8);
            return;
        }
        this.gVz.setVisibility(0);
        this.gVy.setVisibility(8);
    }

    public void mM(boolean z) {
        this.gVz.mM(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            p(fVar.bIc(), fVar.bIb().sex.intValue());
            mM(fVar.bIa());
            a(fVar.bIb());
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
            this.dBl.setText(dataRes.intro);
            if (this.fXo != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.fXo.a(linkedList, i, this.gVp.getResources().getDimensionPixelSize(R.dimen.ds28), this.gVp.getResources().getDimensionPixelSize(R.dimen.ds28), this.gVp.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bIb() != null && (str = fVar.bIb().portrait) != null && str.length() > 0) {
            this.efW.setImageResource(0);
            this.efW.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.gVz != null) {
            this.gVz.setSwitchStateChangeListener(aVar);
        }
    }
}
