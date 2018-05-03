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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class k implements View.OnClickListener {
    private View cJM;
    private FrameLayout fLJ;
    private TbImageView fLK;
    private TbImageView fLL;
    private TextView fLM;
    private LinearLayout fLN;
    private TextView fLO;
    private TextView fLP;
    private LinearLayout fLQ;
    private LinearLayout fLR;
    private LinearLayout fLS;
    private ImageView fLT;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        Y(acD());
    }

    private void Y(View view2) {
        this.fLJ = (FrameLayout) view2.findViewById(d.g.ala_entrance_root);
        this.fLK = (TbImageView) view2.findViewById(d.g.entrance_background);
        this.fLK.setAutoChangeStyle(false);
        this.fLK.setDrawerType(1);
        this.fLK.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds10));
        this.fLL = (TbImageView) view2.findViewById(d.g.live_level_img);
        this.fLL.setAutoChangeStyle(false);
        this.fLL.setDrawerType(1);
        this.fLL.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds10));
        this.fLM = (TextView) view2.findViewById(d.g.live_level_text);
        this.fLN = (LinearLayout) view2.findViewById(d.g.replay_root);
        this.fLP = (TextView) this.fLN.findViewById(d.g.tv_replay_more);
        this.fLT = (ImageView) this.fLN.findViewById(d.g.replay_more_arrow);
        this.fLO = (TextView) this.fLN.findViewById(d.g.tv_replay_tile);
        this.fLQ = (LinearLayout) this.fLN.findViewById(d.g.replay_item_one);
        this.fLR = (LinearLayout) this.fLN.findViewById(d.g.replay_item_two);
        this.fLS = (LinearLayout) this.fLN.findViewById(d.g.replay_item_three);
        e(this.fLQ);
        e(this.fLR);
        e(this.fLS);
        this.fLJ.setOnClickListener(this);
        this.fLQ.setOnClickListener(this);
        this.fLR.setOnClickListener(this);
        this.fLS.setOnClickListener(this);
        this.fLP.setOnClickListener(this);
        this.cJM = view2.findViewById(d.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
        ak.h(this.fLO, d.C0126d.cp_cont_b);
        ak.h(this.fLP, d.C0126d.cp_cont_d);
        ak.j(this.cJM, d.C0126d.cp_bg_line_e);
        ak.c(this.fLT, d.f.icon_mine_list_arrow);
        f(this.fLQ);
        f(this.fLR);
        f(this.fLS);
    }

    public View acD() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        cY(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.fLJ.setVisibility(8);
            return;
        }
        this.fLJ.setVisibility(0);
        this.fLJ.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.fLK.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.fLL.setBackgroundResource(d.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.fLL.setBackgroundResource(d.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.fLL.setBackgroundResource(d.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.fLL.setBackgroundResource(d.f.shape_ala_grade_4_orange);
        } else {
            this.fLL.setBackgroundResource(d.f.shape_ala_grade_5_purple);
        }
        this.fLM.setText(rl(String.valueOf(i)));
    }

    private void cY(List<AlaLiveInfoCoreData> list) {
        if (v.w(list)) {
            this.fLN.setVisibility(8);
            return;
        }
        this.fLN.setVisibility(0);
        this.fLR.setVisibility(0);
        this.fLS.setVisibility(0);
        this.fLQ.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.fLP.setVisibility(0);
            this.fLT.setVisibility(0);
        } else {
            this.fLP.setVisibility(4);
            this.fLT.setVisibility(4);
        }
        a(list.get(0), this.fLQ);
        if (size >= 3) {
            a(list.get(1), this.fLR);
            a(list.get(2), this.fLS);
        } else if (size >= 2) {
            a(list.get(1), this.fLR);
            this.fLS.setVisibility(4);
        } else {
            this.fLR.setVisibility(4);
            this.fLS.setVisibility(4);
        }
    }

    private void e(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds34);
        layoutParams.width = ((com.baidu.adp.lib.util.l.af(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(d.e.ds16) * 2)) - (dimensionPixelSize * 2)) / 3;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    private void f(LinearLayout linearLayout) {
        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(d.g.replay_item_cover);
        tbImageView.setAutoChangeStyle(true);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(d.f.pic_bg_video_frs);
        ak.h((TextView) linearLayout.findViewById(d.g.replay_item_title), d.C0126d.cp_cont_b);
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, LinearLayout linearLayout) {
        if (alaLiveInfoCoreData != null && linearLayout != null) {
            linearLayout.setTag(alaLiveInfoCoreData);
            TextView textView = (TextView) linearLayout.findViewById(d.g.replay_item_title);
            if (textView != null) {
                if (!StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                    textView.setText(alaLiveInfoCoreData.liveTitle);
                } else if (this.mIsHost) {
                    textView.setText(this.mPageContext.getString(d.k.wo_replay));
                } else {
                    textView.setText(this.mPageContext.getString(d.k.ta_replay));
                }
            }
            TbImageView tbImageView = (TbImageView) linearLayout.findViewById(d.g.replay_item_cover);
            if (tbImageView != null && !StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
                tbImageView.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
            }
        }
    }

    private SpannableStringBuilder rl(String str) {
        String string = this.mPageContext.getResources().getString(d.k.ala_live_entrance_level_text_pre);
        String str2 = string + String.format(this.mPageContext.getResources().getString(d.k.ala_live_entrance_level_text_content), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int color = this.mPageContext.getResources().getColor(d.C0126d.cp_cont_g);
        int parseColor = Color.parseColor("#FFD026");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, string.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), string.length(), string.length() + str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), string.length() + str.length(), str2.length(), 18);
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.fLJ) {
            if (this.fLJ.getTag() != null && (this.fLJ.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.fLJ.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new al("c12544"));
            }
        } else if (view2 == this.fLQ) {
            bo(this.fLQ);
        } else if (view2 == this.fLR) {
            bo(this.fLR);
        } else if (view2 == this.fLS) {
            bo(this.fLS);
        } else if (view2 == this.fLP) {
            bfI();
        }
    }

    private void bo(View view2) {
        if (view2.getTag() != null && (view2.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view2.getTag()).threadId), null, "person_page")));
        }
    }

    private void bfI() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
