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
    private View clV;
    private FrameLayout fqC;
    private TbImageView fqD;
    private TbImageView fqE;
    private TextView fqF;
    private LinearLayout fqG;
    private TextView fqH;
    private TextView fqI;
    private LinearLayout fqJ;
    private LinearLayout fqK;
    private LinearLayout fqL;
    private ImageView fqM;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public l(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        Z(Yb());
    }

    private void Z(View view) {
        this.fqC = (FrameLayout) view.findViewById(d.g.ala_entrance_root);
        this.fqD = (TbImageView) view.findViewById(d.g.entrance_background);
        this.fqD.setAutoChangeStyle(false);
        this.fqD.setDrawerType(1);
        this.fqD.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds10));
        this.fqE = (TbImageView) view.findViewById(d.g.live_level_img);
        this.fqE.setAutoChangeStyle(false);
        this.fqE.setDrawerType(1);
        this.fqE.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds10));
        this.fqF = (TextView) view.findViewById(d.g.live_level_text);
        this.fqG = (LinearLayout) view.findViewById(d.g.replay_root);
        this.fqI = (TextView) this.fqG.findViewById(d.g.tv_replay_more);
        this.fqM = (ImageView) this.fqG.findViewById(d.g.replay_more_arrow);
        this.fqH = (TextView) this.fqG.findViewById(d.g.tv_replay_tile);
        this.fqJ = (LinearLayout) this.fqG.findViewById(d.g.replay_item_one);
        this.fqK = (LinearLayout) this.fqG.findViewById(d.g.replay_item_two);
        this.fqL = (LinearLayout) this.fqG.findViewById(d.g.replay_item_three);
        e(this.fqJ);
        e(this.fqK);
        e(this.fqL);
        this.fqC.setOnClickListener(this);
        this.fqJ.setOnClickListener(this);
        this.fqK.setOnClickListener(this);
        this.fqL.setOnClickListener(this);
        this.fqI.setOnClickListener(this);
        this.clV = view.findViewById(d.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        aj.k(this.mRootView, d.C0080d.cp_bg_line_d);
        aj.i(this.fqH, d.C0080d.cp_cont_b);
        aj.i(this.fqI, d.C0080d.cp_cont_d);
        aj.k(this.clV, d.C0080d.cp_bg_line_e);
        aj.c(this.fqM, d.f.icon_mine_list_arrow);
        f(this.fqJ);
        f(this.fqK);
        f(this.fqL);
    }

    public View Yb() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        cJ(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.fqC.setVisibility(8);
            return;
        }
        this.fqC.setVisibility(0);
        this.fqC.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.fqD.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.fqE.setBackgroundResource(d.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.fqE.setBackgroundResource(d.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.fqE.setBackgroundResource(d.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.fqE.setBackgroundResource(d.f.shape_ala_grade_4_orange);
        } else {
            this.fqE.setBackgroundResource(d.f.shape_ala_grade_5_purple);
        }
        this.fqF.setText(qh(String.valueOf(i)));
    }

    private void cJ(List<AlaLiveInfoCoreData> list) {
        if (v.v(list)) {
            this.fqG.setVisibility(8);
            return;
        }
        this.fqG.setVisibility(0);
        this.fqK.setVisibility(0);
        this.fqL.setVisibility(0);
        this.fqJ.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.fqI.setVisibility(0);
            this.fqM.setVisibility(0);
        } else {
            this.fqI.setVisibility(4);
            this.fqM.setVisibility(4);
        }
        a(list.get(0), this.fqJ);
        if (size >= 3) {
            a(list.get(1), this.fqK);
            a(list.get(2), this.fqL);
        } else if (size >= 2) {
            a(list.get(1), this.fqK);
            this.fqL.setVisibility(4);
        } else {
            this.fqK.setVisibility(4);
            this.fqL.setVisibility(4);
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

    private SpannableStringBuilder qh(String str) {
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
        if (view == this.fqC) {
            if (this.fqC.getTag() != null && (this.fqC.getTag() instanceof AlaLiveInfoCoreData)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), (AlaLiveInfoCoreData) this.fqC.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new ak("c12544"));
            }
        } else if (view == this.fqJ) {
            bw(this.fqJ);
        } else if (view == this.fqK) {
            bw(this.fqK);
        } else if (view == this.fqL) {
            bw(this.fqL);
        } else if (view == this.fqI) {
            bai();
        }
    }

    private void bw(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void bai() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
