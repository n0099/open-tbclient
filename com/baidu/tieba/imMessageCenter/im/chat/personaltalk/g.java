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
    private final TextView dzA;
    private final HeadImageView eem;
    private final UserIconBox fVx;
    private TbSettingTextTipView gTA;
    private TbSettingTextTipView gTB;
    private TbSettingTextTipView gTC;
    private RelativeLayout gTD;
    private LinearLayout gTE;
    public PersonaltalkSettingViewBlackManView gTF;
    public PersonalTalkSettingViewSettingView gTG;
    private final PersonalTalkSettingActivity gTw;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.gTw = personalTalkSettingActivity;
        this.gTw.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.gTw.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gTw.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gTF = (PersonaltalkSettingViewBlackManView) this.gTw.findViewById(R.id.black_status_view);
        this.gTG = (PersonalTalkSettingViewSettingView) this.gTw.findViewById(R.id.setting_detail_view);
        this.gTE = (LinearLayout) this.gTw.findViewById(R.id.user_info_lin);
        this.gTA = (TbSettingTextTipView) this.gTw.findViewById(R.id.st_delete_talk_history);
        this.gTB = (TbSettingTextTipView) this.gTw.findViewById(R.id.st_report);
        this.gTC = (TbSettingTextTipView) this.gTw.findViewById(R.id.add_to_black);
        this.gTD = (RelativeLayout) this.gTw.findViewById(R.id.remove_from_black_man);
        this.gTA.setOnClickListener(this.gTw);
        this.gTB.setOnClickListener(this.gTw);
        this.gTC.setOnClickListener(this.gTw);
        this.gTD.setOnClickListener(this.gTw);
        this.gTE.setOnClickListener(this.gTw);
        this.eem = (HeadImageView) this.gTw.findViewById(R.id.photo);
        this.eem.setIsRound(true);
        this.mName = (TextView) this.gTw.findViewById(R.id.name);
        this.fVx = (UserIconBox) this.gTw.findViewById(R.id.user_icon_box);
        this.dzA = (TextView) this.gTw.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.gTw.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gTw.getPageContext(), i);
    }

    public void p(boolean z, int i) {
        if (z) {
            this.gTF.setSex(i);
            this.gTF.setVisibility(0);
            this.gTG.setVisibility(8);
            return;
        }
        this.gTG.setVisibility(0);
        this.gTF.setVisibility(8);
    }

    public void mJ(boolean z) {
        this.gTG.mJ(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            p(fVar.bHo(), fVar.bHn().sex.intValue());
            mJ(fVar.bHm());
            a(fVar.bHn());
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
            this.dzA.setText(dataRes.intro);
            if (this.fVx != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.fVx.a(linkedList, i, this.gTw.getResources().getDimensionPixelSize(R.dimen.ds28), this.gTw.getResources().getDimensionPixelSize(R.dimen.ds28), this.gTw.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bHn() != null && (str = fVar.bHn().portrait) != null && str.length() > 0) {
            this.eem.setImageResource(0);
            this.eem.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.gTG != null) {
            this.gTG.setSwitchStateChangeListener(aVar);
        }
    }
}
