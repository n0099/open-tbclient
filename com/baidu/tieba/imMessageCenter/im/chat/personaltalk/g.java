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
/* loaded from: classes7.dex */
public class g {
    private final TextView etb;
    private final UserIconBox gND;
    private final HeadImageView gpg;
    private final PersonalTalkSettingActivity hKe;
    private TbSettingTextTipView hKi;
    private TbSettingTextTipView hKj;
    private TbSettingTextTipView hKk;
    private RelativeLayout hKl;
    private LinearLayout hKm;
    public PersonaltalkSettingViewBlackManView hKn;
    public PersonalTalkSettingViewSettingView hKo;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.hKe = personalTalkSettingActivity;
        this.hKe.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.hKe.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hKe.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hKn = (PersonaltalkSettingViewBlackManView) this.hKe.findViewById(R.id.black_status_view);
        this.hKo = (PersonalTalkSettingViewSettingView) this.hKe.findViewById(R.id.setting_detail_view);
        this.hKm = (LinearLayout) this.hKe.findViewById(R.id.user_info_lin);
        this.hKi = (TbSettingTextTipView) this.hKe.findViewById(R.id.st_delete_talk_history);
        this.hKj = (TbSettingTextTipView) this.hKe.findViewById(R.id.st_report);
        this.hKk = (TbSettingTextTipView) this.hKe.findViewById(R.id.add_to_black);
        this.hKl = (RelativeLayout) this.hKe.findViewById(R.id.remove_from_black_man);
        this.hKi.setOnClickListener(this.hKe);
        this.hKj.setOnClickListener(this.hKe);
        this.hKk.setOnClickListener(this.hKe);
        this.hKl.setOnClickListener(this.hKe);
        this.hKm.setOnClickListener(this.hKe);
        this.gpg = (HeadImageView) this.hKe.findViewById(R.id.photo);
        this.gpg.setIsRound(true);
        this.mName = (TextView) this.hKe.findViewById(R.id.name);
        this.gND = (UserIconBox) this.hKe.findViewById(R.id.user_icon_box);
        this.etb = (TextView) this.hKe.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.hKe.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hKe.getPageContext(), i);
    }

    public void u(boolean z, int i) {
        if (z) {
            this.hKn.setSex(i);
            this.hKn.setVisibility(0);
            this.hKo.setVisibility(8);
            return;
        }
        this.hKo.setVisibility(0);
        this.hKn.setVisibility(8);
    }

    public void nZ(boolean z) {
        this.hKo.nZ(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            u(fVar.bXg(), fVar.bXf().sex.intValue());
            nZ(fVar.bXe());
            a(fVar.bXf());
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
            this.etb.setText(dataRes.intro);
            if (this.gND != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.gND.a(linkedList, i, this.hKe.getResources().getDimensionPixelSize(R.dimen.ds28), this.hKe.getResources().getDimensionPixelSize(R.dimen.ds28), this.hKe.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bXf() != null && (str = fVar.bXf().portrait) != null && str.length() > 0) {
            this.gpg.setImageResource(0);
            this.gpg.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.hKo != null) {
            this.hKo.setSwitchStateChangeListener(aVar);
        }
    }
}
