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
    private final TextView dGE;
    private final UserIconBox fWJ;
    private final HeadImageView fyr;
    private final PersonalTalkSettingActivity gTp;
    private TbSettingTextTipView gTt;
    private TbSettingTextTipView gTu;
    private TbSettingTextTipView gTv;
    private RelativeLayout gTw;
    private LinearLayout gTx;
    public PersonaltalkSettingViewBlackManView gTy;
    public PersonalTalkSettingViewSettingView gTz;
    private final TextView mName;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.gTp = personalTalkSettingActivity;
        this.gTp.setContentView(R.layout.p2ptalk_setting_activity);
        this.mParent = this.gTp.findViewById(R.id.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gTp.getPageContext().getString(R.string.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gTy = (PersonaltalkSettingViewBlackManView) this.gTp.findViewById(R.id.black_status_view);
        this.gTz = (PersonalTalkSettingViewSettingView) this.gTp.findViewById(R.id.setting_detail_view);
        this.gTx = (LinearLayout) this.gTp.findViewById(R.id.user_info_lin);
        this.gTt = (TbSettingTextTipView) this.gTp.findViewById(R.id.st_delete_talk_history);
        this.gTu = (TbSettingTextTipView) this.gTp.findViewById(R.id.st_report);
        this.gTv = (TbSettingTextTipView) this.gTp.findViewById(R.id.add_to_black);
        this.gTw = (RelativeLayout) this.gTp.findViewById(R.id.remove_from_black_man);
        this.gTt.setOnClickListener(this.gTp);
        this.gTu.setOnClickListener(this.gTp);
        this.gTv.setOnClickListener(this.gTp);
        this.gTw.setOnClickListener(this.gTp);
        this.gTx.setOnClickListener(this.gTp);
        this.fyr = (HeadImageView) this.gTp.findViewById(R.id.photo);
        this.fyr.setIsRound(true);
        this.mName = (TextView) this.gTp.findViewById(R.id.name);
        this.fWJ = (UserIconBox) this.gTp.findViewById(R.id.user_icon_box);
        this.dGE = (TextView) this.gTp.findViewById(R.id.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.gTp.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gTp.getPageContext(), i);
    }

    public void q(boolean z, int i) {
        if (z) {
            this.gTy.setSex(i);
            this.gTy.setVisibility(0);
            this.gTz.setVisibility(8);
            return;
        }
        this.gTz.setVisibility(0);
        this.gTy.setVisibility(8);
    }

    public void mA(boolean z) {
        this.gTz.mA(z);
    }

    public void e(f fVar) {
        if (fVar != null) {
            q(fVar.bEN(), fVar.bEM().sex.intValue());
            mA(fVar.bEL());
            a(fVar.bEM());
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
            this.dGE.setText(dataRes.intro);
            if (this.fWJ != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.fWJ.a(linkedList, i, this.gTp.getResources().getDimensionPixelSize(R.dimen.ds28), this.gTp.getResources().getDimensionPixelSize(R.dimen.ds28), this.gTp.getResources().getDimensionPixelSize(R.dimen.ds4));
            }
        }
    }

    public void f(f fVar) {
        String str;
        if (fVar != null && fVar.bEM() != null && (str = fVar.bEM().portrait) != null && str.length() > 0) {
            this.fyr.setImageResource(0);
            this.fyr.startLoad(str, 12, false);
        }
    }

    public void a(BdSwitchView.a aVar) {
        if (this.gTz != null) {
            this.gTz.setSwitchStateChangeListener(aVar);
        }
    }
}
