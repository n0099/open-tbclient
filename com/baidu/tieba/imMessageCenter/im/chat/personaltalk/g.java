package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.d;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes2.dex */
public class g {
    private final View bep;
    private final TextView bqC;
    private final HeadImageView cJh;
    private final PersonalTalkSettingActivity dWR;
    private TbSettingTextTipView dWV;
    private TbSettingTextTipView dWW;
    private RelativeLayout dWX;
    private LinearLayout dWY;
    public PersonaltalkSettingViewBlackManView dWZ;
    public PersonalTalkSettingViewSettingView dXa;
    private final UserIconBox dbM;
    private final TextView mName;
    private final NavigationBar mNavigationBar;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dWR = personalTalkSettingActivity;
        this.dWR.setContentView(d.h.p2ptalk_setting_activity);
        this.bep = this.dWR.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.bep.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dWR.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dWZ = (PersonaltalkSettingViewBlackManView) this.dWR.findViewById(d.g.black_status_view);
        this.dXa = (PersonalTalkSettingViewSettingView) this.dWR.findViewById(d.g.setting_detail_view);
        this.dWY = (LinearLayout) this.dWR.findViewById(d.g.user_info_lin);
        this.dWV = (TbSettingTextTipView) this.dWR.findViewById(d.g.st_delete_talk_history);
        this.dWW = (TbSettingTextTipView) this.dWR.findViewById(d.g.add_to_black);
        this.dWX = (RelativeLayout) this.dWR.findViewById(d.g.remove_from_black_man);
        this.dWV.setOnClickListener(this.dWR);
        this.dWW.setOnClickListener(this.dWR);
        this.dWX.setOnClickListener(this.dWR);
        this.dWY.setOnClickListener(this.dWR);
        this.cJh = (HeadImageView) this.dWR.findViewById(d.g.photo);
        this.cJh.setIsRound(true);
        this.mName = (TextView) this.dWR.findViewById(d.g.name);
        this.dbM = (UserIconBox) this.dWR.findViewById(d.g.user_icon_box);
        this.bqC = (TextView) this.dWR.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.dWR.getLayoutMode().t(this.bep);
        this.mNavigationBar.onChangeSkinType(this.dWR.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.dWZ.setSex(i);
            this.dWZ.setVisibility(0);
            this.dXa.setVisibility(8);
            return;
        }
        this.dXa.setVisibility(0);
        this.dWZ.setVisibility(8);
    }

    public void ho(boolean z) {
        this.dXa.ho(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.aDN(), fVar.aDM().sex.intValue());
            ho(fVar.aDL());
            a(fVar.aDM());
            f(fVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_pop_girl, 0);
            }
            this.bqC.setText(dataRes.intro);
            if (this.dbM != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.dbM.a(linkedList, i, this.dWR.getResources().getDimensionPixelSize(d.e.ds28), this.dWR.getResources().getDimensionPixelSize(d.e.ds28), this.dWR.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aDM() != null && (str = fVar.aDM().portrait) != null && str.length() > 0) {
            this.cJh.setImageResource(0);
            this.cJh.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.dXa != null) {
            this.dXa.setSwitchStateChangeListener(aVar);
        }
    }
}
