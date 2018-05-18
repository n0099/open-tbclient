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
    private final TextView bss;
    private final HeadImageView daK;
    private final UserIconBox duj;
    private final PersonalTalkSettingActivity elD;
    private TbSettingTextTipView elH;
    private TbSettingTextTipView elI;
    private RelativeLayout elJ;
    private LinearLayout elK;
    public PersonaltalkSettingViewBlackManView elL;
    public PersonalTalkSettingViewSettingView elM;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.elD = personalTalkSettingActivity;
        this.elD.setContentView(d.i.p2ptalk_setting_activity);
        this.mParent = this.elD.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.elD.getPageContext().getString(d.k.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.elL = (PersonaltalkSettingViewBlackManView) this.elD.findViewById(d.g.black_status_view);
        this.elM = (PersonalTalkSettingViewSettingView) this.elD.findViewById(d.g.setting_detail_view);
        this.elK = (LinearLayout) this.elD.findViewById(d.g.user_info_lin);
        this.elH = (TbSettingTextTipView) this.elD.findViewById(d.g.st_delete_talk_history);
        this.elI = (TbSettingTextTipView) this.elD.findViewById(d.g.add_to_black);
        this.elJ = (RelativeLayout) this.elD.findViewById(d.g.remove_from_black_man);
        this.elH.setOnClickListener(this.elD);
        this.elI.setOnClickListener(this.elD);
        this.elJ.setOnClickListener(this.elD);
        this.elK.setOnClickListener(this.elD);
        this.daK = (HeadImageView) this.elD.findViewById(d.g.photo);
        this.daK.setIsRound(true);
        this.mName = (TextView) this.elD.findViewById(d.g.name);
        this.duj = (UserIconBox) this.elD.findViewById(d.g.user_icon_box);
        this.bss = (TextView) this.elD.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.elD.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.elD.getPageContext(), i);
    }

    public void h(boolean z, int i) {
        if (z) {
            this.elL.setSex(i);
            this.elL.setVisibility(0);
            this.elM.setVisibility(8);
            return;
        }
        this.elM.setVisibility(0);
        this.elL.setVisibility(8);
    }

    public void hH(boolean z) {
        this.elM.hH(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            h(fVar.aHC(), fVar.aHB().sex.intValue());
            hH(fVar.aHA());
            a(fVar.aHB());
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
            this.bss.setText(dataRes.intro);
            if (this.duj != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.duj.a(linkedList, i, this.elD.getResources().getDimensionPixelSize(d.e.ds28), this.elD.getResources().getDimensionPixelSize(d.e.ds28), this.elD.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.aHB() != null && (str = fVar.aHB().portrait) != null && str.length() > 0) {
            this.daK.setImageResource(0);
            this.daK.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.elM != null) {
            this.elM.setSwitchStateChangeListener(aVar);
        }
    }
}
