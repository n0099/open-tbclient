package com.baidu.tieba.personPolymeric.view;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    private View cmp;
    private FrameLayout fqZ;
    private TbImageView fra;
    private TbImageView frb;
    private TextView frc;
    private LinearLayout frd;
    private TextView fre;
    private TextView frf;
    private LinearLayout frg;
    private LinearLayout frh;
    private LinearLayout fri;
    private ImageView frj;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public l(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        Z(Yn());
    }

    private void Z(View view) {
        this.fqZ = (FrameLayout) view.findViewById(d.g.ala_entrance_root);
        this.fra = (TbImageView) view.findViewById(d.g.entrance_background);
        this.fra.setAutoChangeStyle(false);
        this.fra.setDrawerType(1);
        this.fra.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds10));
        this.frb = (TbImageView) view.findViewById(d.g.live_level_img);
        this.frb.setAutoChangeStyle(false);
        this.frb.setDrawerType(1);
        this.frb.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds10));
        this.frc = (TextView) view.findViewById(d.g.live_level_text);
        this.frd = (LinearLayout) view.findViewById(d.g.replay_root);
        this.frf = (TextView) this.frd.findViewById(d.g.tv_replay_more);
        this.frj = (ImageView) this.frd.findViewById(d.g.replay_more_arrow);
        this.fre = (TextView) this.frd.findViewById(d.g.tv_replay_tile);
        this.frg = (LinearLayout) this.frd.findViewById(d.g.replay_item_one);
        this.frh = (LinearLayout) this.frd.findViewById(d.g.replay_item_two);
        this.fri = (LinearLayout) this.frd.findViewById(d.g.replay_item_three);
        e(this.frg);
        e(this.frh);
        e(this.fri);
        this.fqZ.setOnClickListener(this);
        this.frg.setOnClickListener(this);
        this.frh.setOnClickListener(this);
        this.fri.setOnClickListener(this);
        this.frf.setOnClickListener(this);
        this.cmp = view.findViewById(d.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        aj.k(this.mRootView, d.C0080d.cp_bg_line_d);
        aj.i(this.fre, d.C0080d.cp_cont_b);
        aj.i(this.frf, d.C0080d.cp_cont_d);
        aj.k(this.cmp, d.C0080d.cp_bg_line_e);
        aj.c(this.frj, d.f.icon_mine_list_arrow);
        f(this.frg);
        f(this.frh);
        f(this.fri);
    }

    public View Yn() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        cK(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.fqZ.setVisibility(8);
            return;
        }
        this.fqZ.setVisibility(0);
        this.fqZ.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.fra.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.frb.setBackgroundResource(d.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.frb.setBackgroundResource(d.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.frb.setBackgroundResource(d.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.frb.setBackgroundResource(d.f.shape_ala_grade_4_orange);
        } else {
            this.frb.setBackgroundResource(d.f.shape_ala_grade_5_purple);
        }
        this.frc.setText(ql(String.valueOf(i)));
    }

    private void cK(List<AlaLiveInfoCoreData> list) {
        if (v.v(list)) {
            this.frd.setVisibility(8);
            return;
        }
        this.frd.setVisibility(0);
        this.frh.setVisibility(0);
        this.fri.setVisibility(0);
        this.frg.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.frf.setVisibility(0);
            this.frj.setVisibility(0);
        } else {
            this.frf.setVisibility(4);
            this.frj.setVisibility(4);
        }
        a(list.get(0), this.frg);
        if (size >= 3) {
            a(list.get(1), this.frh);
            a(list.get(2), this.fri);
        } else if (size >= 2) {
            a(list.get(1), this.frh);
            this.fri.setVisibility(4);
        } else {
            this.frh.setVisibility(4);
            this.fri.setVisibility(4);
        }
    }

    private void e(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds34);
        layoutParams.width = ((com.baidu.adp.lib.util.l.ac(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(d.e.ds16) * 2)) - (dimensionPixelSize * 2)) / 3;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    private void f(LinearLayout linearLayout) {
        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(d.g.replay_item_cover);
        tbImageView.setAutoChangeStyle(true);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(d.f.pic_bg_video_frs);
        aj.i((TextView) linearLayout.findViewById(d.g.replay_item_title), d.C0080d.cp_cont_b);
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, LinearLayout linearLayout) {
        if (alaLiveInfoCoreData != null && linearLayout != null) {
            linearLayout.setTag(alaLiveInfoCoreData);
            TextView textView = (TextView) linearLayout.findViewById(d.g.replay_item_title);
            if (textView != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                textView.setText(alaLiveInfoCoreData.liveTitle);
            }
            TbImageView tbImageView = (TbImageView) linearLayout.findViewById(d.g.replay_item_cover);
            if (tbImageView != null && !StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
                tbImageView.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
            }
        }
    }

    private SpannableStringBuilder ql(String str) {
        String string = this.mPageContext.getResources().getString(d.j.ala_live_entrance_level_text_pre);
        String str2 = string + String.format(this.mPageContext.getResources().getString(d.j.ala_live_entrance_level_text_content), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int color = this.mPageContext.getResources().getColor(d.C0080d.cp_cont_g);
        int parseColor = Color.parseColor("#FFD026");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, string.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), string.length(), string.length() + str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), string.length() + str.length(), str2.length(), 18);
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fqZ) {
            if (this.fqZ.getTag() != null && (this.fqZ.getTag() instanceof AlaLiveInfoCoreData)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), (AlaLiveInfoCoreData) this.fqZ.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new ak("c12544"));
            }
        } else if (view == this.frg) {
            bx(this.frg);
        } else if (view == this.frh) {
            bx(this.frh);
        } else if (view == this.fri) {
            bx(this.fri);
        } else if (view == this.frf) {
            baq();
        }
    }

    private void bx(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void baq() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
