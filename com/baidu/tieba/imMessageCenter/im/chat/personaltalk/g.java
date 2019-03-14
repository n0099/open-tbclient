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
import com.baidu.tieba.d;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes4.dex */
public class g {
    private final TextView dlJ;
    private final HeadImageView fbS;
    private final UserIconBox fyZ;
    public PersonalTalkSettingViewSettingView gvA;
    private final PersonalTalkSettingActivity gvq;
    private TbSettingTextTipView gvu;
    private TbSettingTextTipView gvv;
    private TbSettingTextTipView gvw;
    private RelativeLayout gvx;
    private LinearLayout gvy;
    public PersonaltalkSettingViewBlackManView gvz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.gvq = personalTalkSettingActivity;
        this.gvq.setContentView(d.h.p2ptalk_setting_activity);
        this.mParent = this.gvq.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gvq.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gvz = (PersonaltalkSettingViewBlackManView) this.gvq.findViewById(d.g.black_status_view);
        this.gvA = (PersonalTalkSettingViewSettingView) this.gvq.findViewById(d.g.setting_detail_view);
        this.gvy = (LinearLayout) this.gvq.findViewById(d.g.user_info_lin);
        this.gvu = (TbSettingTextTipView) this.gvq.findViewById(d.g.st_delete_talk_history);
        this.gvv = (TbSettingTextTipView) this.gvq.findViewById(d.g.st_report);
        this.gvw = (TbSettingTextTipView) this.gvq.findViewById(d.g.add_to_black);
        this.gvx = (RelativeLayout) this.gvq.findViewById(d.g.remove_from_black_man);
        this.gvu.setOnClickListener(this.gvq);
        this.gvv.setOnClickListener(this.gvq);
        this.gvw.setOnClickListener(this.gvq);
        this.gvx.setOnClickListener(this.gvq);
        this.gvy.setOnClickListener(this.gvq);
        this.fbS = (HeadImageView) this.gvq.findViewById(d.g.photo);
        this.fbS.setIsRound(true);
        this.mName = (TextView) this.gvq.findViewById(d.g.name);
        this.fyZ = (UserIconBox) this.gvq.findViewById(d.g.user_icon_box);
        this.dlJ = (TextView) this.gvq.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.gvq.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gvq.getPageContext(), i);
    }

    public void p(boolean z, int i) {
        if (z) {
            this.gvz.setSex(i);
            this.gvz.setVisibility(0);
            this.gvA.setVisibility(8);
            return;
        }
        this.gvA.setVisibility(0);
        this.gvz.setVisibility(8);
    }

    public void lF(boolean z) {
        this.gvA.lF(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            p(fVar.bwK(), fVar.bwJ().sex.intValue());
            lF(fVar.bwI());
            a(fVar.bwJ());
            f(fVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 8;
        if (dataRes != null) {
            this.mName.setText(StringUtils.isNull(dataRes.nameShow) ? dataRes.name + "" : dataRes.nameShow);
            if (dataRes.sex.intValue() == 1) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 9;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_pop_girl, 0);
            }
            this.dlJ.setText(dataRes.intro);
            if (this.fyZ != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.fyZ.a(linkedList, i, this.gvq.getResources().getDimensionPixelSize(d.e.ds28), this.gvq.getResources().getDimensionPixelSize(d.e.ds28), this.gvq.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bwJ() != null && (str = fVar.bwJ().portrait) != null && str.length() > 0) {
            this.fbS.setImageResource(0);
            this.fbS.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.gvA != null) {
            this.gvA.setSwitchStateChangeListener(aVar);
        }
    }
}
