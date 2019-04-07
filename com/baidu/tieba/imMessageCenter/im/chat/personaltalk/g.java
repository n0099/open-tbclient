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
    private final TextView dlM;
    private final HeadImageView fbF;
    private final UserIconBox fyN;
    private final PersonalTalkSettingActivity gvd;
    private TbSettingTextTipView gvh;
    private TbSettingTextTipView gvi;
    private TbSettingTextTipView gvj;
    private RelativeLayout gvk;
    private LinearLayout gvl;
    public PersonaltalkSettingViewBlackManView gvm;
    public PersonalTalkSettingViewSettingView gvn;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.gvd = personalTalkSettingActivity;
        this.gvd.setContentView(d.h.p2ptalk_setting_activity);
        this.mParent = this.gvd.findViewById(d.g.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gvd.getPageContext().getString(d.j.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gvm = (PersonaltalkSettingViewBlackManView) this.gvd.findViewById(d.g.black_status_view);
        this.gvn = (PersonalTalkSettingViewSettingView) this.gvd.findViewById(d.g.setting_detail_view);
        this.gvl = (LinearLayout) this.gvd.findViewById(d.g.user_info_lin);
        this.gvh = (TbSettingTextTipView) this.gvd.findViewById(d.g.st_delete_talk_history);
        this.gvi = (TbSettingTextTipView) this.gvd.findViewById(d.g.st_report);
        this.gvj = (TbSettingTextTipView) this.gvd.findViewById(d.g.add_to_black);
        this.gvk = (RelativeLayout) this.gvd.findViewById(d.g.remove_from_black_man);
        this.gvh.setOnClickListener(this.gvd);
        this.gvi.setOnClickListener(this.gvd);
        this.gvj.setOnClickListener(this.gvd);
        this.gvk.setOnClickListener(this.gvd);
        this.gvl.setOnClickListener(this.gvd);
        this.fbF = (HeadImageView) this.gvd.findViewById(d.g.photo);
        this.fbF.setIsRound(true);
        this.mName = (TextView) this.gvd.findViewById(d.g.name);
        this.fyN = (UserIconBox) this.gvd.findViewById(d.g.user_icon_box);
        this.dlM = (TextView) this.gvd.findViewById(d.g.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.gvd.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gvd.getPageContext(), i);
    }

    public void p(boolean z, int i) {
        if (z) {
            this.gvm.setSex(i);
            this.gvm.setVisibility(0);
            this.gvn.setVisibility(8);
            return;
        }
        this.gvn.setVisibility(0);
        this.gvm.setVisibility(8);
    }

    public void lF(boolean z) {
        this.gvn.lF(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            p(fVar.bwH(), fVar.bwG().sex.intValue());
            lF(fVar.bwF());
            a(fVar.bwG());
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
            this.dlM.setText(dataRes.intro);
            if (this.fyN != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.fyN.a(linkedList, i, this.gvd.getResources().getDimensionPixelSize(d.e.ds28), this.gvd.getResources().getDimensionPixelSize(d.e.ds28), this.gvd.getResources().getDimensionPixelSize(d.e.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bwG() != null && (str = fVar.bwG().portrait) != null && str.length() > 0) {
            this.fbF.setImageResource(0);
            this.fbF.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.gvn != null) {
            this.gvn.setSwitchStateChangeListener(aVar);
        }
    }
}
