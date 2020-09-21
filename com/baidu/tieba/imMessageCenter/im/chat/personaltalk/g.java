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
/* loaded from: classes21.dex */
public class g {
    private final TextView fUX;
    private final UserIconBox iFH;
    private final HeadImageView idE;
    private final PersonalTalkSettingActivity jKm;
    private TbSettingTextTipView jKq;
    private TbSettingTextTipView jKr;
    private TbSettingTextTipView jKs;
    private RelativeLayout jKt;
    private LinearLayout jKu;
    public PersonaltalkSettingViewBlackManView jKv;
    public PersonalTalkSettingViewSettingView jKw;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.jKm = personalTalkSettingActivity;
        this.jKm.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.jKm.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jKm.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jKv = (PersonaltalkSettingViewBlackManView) this.jKm.findViewById(R.id.black_status_view);
        this.jKw = (PersonalTalkSettingViewSettingView) this.jKm.findViewById(R.id.setting_detail_view);
        this.jKu = (LinearLayout) this.jKm.findViewById(R.id.user_info_lin);
        this.jKq = (TbSettingTextTipView) this.jKm.findViewById(R.id.st_delete_talk_history);
        this.jKr = (TbSettingTextTipView) this.jKm.findViewById(R.id.st_report);
        this.jKs = (TbSettingTextTipView) this.jKm.findViewById(R.id.add_to_black);
        this.jKt = (RelativeLayout) this.jKm.findViewById(R.id.remove_from_black_man);
        this.jKq.setOnClickListener(this.jKm);
        this.jKr.setOnClickListener(this.jKm);
        this.jKs.setOnClickListener(this.jKm);
        this.jKt.setOnClickListener(this.jKm);
        this.jKu.setOnClickListener(this.jKm);
        this.idE = (HeadImageView) this.jKm.findViewById(R.id.photo);
        this.idE.setIsRound(true);
        this.mName = (TextView) this.jKm.findViewById(R.id.name);
        this.iFH = (UserIconBox) this.jKm.findViewById(R.id.user_icon_box);
        this.fUX = (TextView) this.jKm.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.jKm.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jKm.getPageContext(), i);
    }

    public void B(boolean z, int i) {
        if (z) {
            this.jKv.setSex(i);
            this.jKv.setVisibility(0);
            this.jKw.setVisibility(8);
            return;
        }
        this.jKw.setVisibility(0);
        this.jKv.setVisibility(8);
    }

    public void rp(boolean z) {
        this.jKw.rp(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            B(fVar.cMz(), fVar.cMy().sex.intValue());
            rp(fVar.cMx());
            a(fVar.cMy());
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
            this.fUX.setText(dataRes.intro);
            if (this.iFH != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.iFH.a(linkedList, i, this.jKm.getResources().getDimensionPixelSize(R.dimen.ds28), this.jKm.getResources().getDimensionPixelSize(R.dimen.ds28), this.jKm.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.cMy() != null && (str = fVar.cMy().portrait) != null && str.length() > 0) {
            this.idE.setImageResource(0);
            this.idE.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.jKw != null) {
            this.jKw.setSwitchStateChangeListener(aVar);
        }
    }
}
