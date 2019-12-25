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
/* loaded from: classes6.dex */
public class g {
    private final TextView erQ;
    private final UserIconBox gKq;
    private final HeadImageView glX;
    private final PersonalTalkSettingActivity hGB;
    private TbSettingTextTipView hGF;
    private TbSettingTextTipView hGG;
    private TbSettingTextTipView hGH;
    private RelativeLayout hGI;
    private LinearLayout hGJ;
    public PersonaltalkSettingViewBlackManView hGK;
    public PersonalTalkSettingViewSettingView hGL;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.hGB = personalTalkSettingActivity;
        this.hGB.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.hGB.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hGB.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hGK = (PersonaltalkSettingViewBlackManView) this.hGB.findViewById(R.id.black_status_view);
        this.hGL = (PersonalTalkSettingViewSettingView) this.hGB.findViewById(R.id.setting_detail_view);
        this.hGJ = (LinearLayout) this.hGB.findViewById(R.id.user_info_lin);
        this.hGF = (TbSettingTextTipView) this.hGB.findViewById(R.id.st_delete_talk_history);
        this.hGG = (TbSettingTextTipView) this.hGB.findViewById(R.id.st_report);
        this.hGH = (TbSettingTextTipView) this.hGB.findViewById(R.id.add_to_black);
        this.hGI = (RelativeLayout) this.hGB.findViewById(R.id.remove_from_black_man);
        this.hGF.setOnClickListener(this.hGB);
        this.hGG.setOnClickListener(this.hGB);
        this.hGH.setOnClickListener(this.hGB);
        this.hGI.setOnClickListener(this.hGB);
        this.hGJ.setOnClickListener(this.hGB);
        this.glX = (HeadImageView) this.hGB.findViewById(R.id.photo);
        this.glX.setIsRound(true);
        this.mName = (TextView) this.hGB.findViewById(R.id.name);
        this.gKq = (UserIconBox) this.hGB.findViewById(R.id.user_icon_box);
        this.erQ = (TextView) this.hGB.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.hGB.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hGB.getPageContext(), i);
    }

    public void t(boolean z, int i) {
        if (z) {
            this.hGK.setSex(i);
            this.hGK.setVisibility(0);
            this.hGL.setVisibility(8);
            return;
        }
        this.hGL.setVisibility(0);
        this.hGK.setVisibility(8);
    }

    public void nN(boolean z) {
        this.hGL.nN(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            t(fVar.bVX(), fVar.bVW().sex.intValue());
            nN(fVar.bVV());
            a(fVar.bVW());
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
            this.erQ.setText(dataRes.intro);
            if (this.gKq != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.gKq.a(linkedList, i, this.hGB.getResources().getDimensionPixelSize(R.dimen.ds28), this.hGB.getResources().getDimensionPixelSize(R.dimen.ds28), this.hGB.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bVW() != null && (str = fVar.bVW().portrait) != null && str.length() > 0) {
            this.glX.setImageResource(0);
            this.glX.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.hGL != null) {
            this.hGL.setSwitchStateChangeListener(aVar);
        }
    }
}
