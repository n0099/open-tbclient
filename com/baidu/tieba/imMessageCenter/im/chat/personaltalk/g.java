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
/* loaded from: classes16.dex */
public class g {
    private final TextView fGr;
    private final HeadImageView hJe;
    private final UserIconBox ijZ;
    private final PersonalTalkSettingActivity jmE;
    private TbSettingTextTipView jmI;
    private TbSettingTextTipView jmJ;
    private TbSettingTextTipView jmK;
    private RelativeLayout jmL;
    private LinearLayout jmM;
    public PersonaltalkSettingViewBlackManView jmN;
    public PersonalTalkSettingViewSettingView jmO;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.jmE = personalTalkSettingActivity;
        this.jmE.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.jmE.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jmE.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jmN = (PersonaltalkSettingViewBlackManView) this.jmE.findViewById(R.id.black_status_view);
        this.jmO = (PersonalTalkSettingViewSettingView) this.jmE.findViewById(R.id.setting_detail_view);
        this.jmM = (LinearLayout) this.jmE.findViewById(R.id.user_info_lin);
        this.jmI = (TbSettingTextTipView) this.jmE.findViewById(R.id.st_delete_talk_history);
        this.jmJ = (TbSettingTextTipView) this.jmE.findViewById(R.id.st_report);
        this.jmK = (TbSettingTextTipView) this.jmE.findViewById(R.id.add_to_black);
        this.jmL = (RelativeLayout) this.jmE.findViewById(R.id.remove_from_black_man);
        this.jmI.setOnClickListener(this.jmE);
        this.jmJ.setOnClickListener(this.jmE);
        this.jmK.setOnClickListener(this.jmE);
        this.jmL.setOnClickListener(this.jmE);
        this.jmM.setOnClickListener(this.jmE);
        this.hJe = (HeadImageView) this.jmE.findViewById(R.id.photo);
        this.hJe.setIsRound(true);
        this.mName = (TextView) this.jmE.findViewById(R.id.name);
        this.ijZ = (UserIconBox) this.jmE.findViewById(R.id.user_icon_box);
        this.fGr = (TextView) this.jmE.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.jmE.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jmE.getPageContext(), i);
    }

    public void B(boolean z, int i) {
        if (z) {
            this.jmN.setSex(i);
            this.jmN.setVisibility(0);
            this.jmO.setVisibility(8);
            return;
        }
        this.jmO.setVisibility(0);
        this.jmN.setVisibility(8);
    }

    public void qz(boolean z) {
        this.jmO.qz(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            B(fVar.cyb(), fVar.cya().sex.intValue());
            qz(fVar.cxZ());
            a(fVar.cya());
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
            this.fGr.setText(dataRes.intro);
            if (this.ijZ != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.ijZ.a(linkedList, i, this.jmE.getResources().getDimensionPixelSize(R.dimen.ds28), this.jmE.getResources().getDimensionPixelSize(R.dimen.ds28), this.jmE.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cya() != null && (str = fVar.cya().portrait) != null && str.length() > 0) {
            this.hJe.setImageResource(0);
            this.hJe.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.jmO != null) {
            this.jmO.setSwitchStateChangeListener(aVar);
        }
    }
}
