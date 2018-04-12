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
    private View cJP;
    private FrameLayout fLM;
    private TbImageView fLN;
    private TbImageView fLO;
    private TextView fLP;
    private LinearLayout fLQ;
    private TextView fLR;
    private TextView fLS;
    private LinearLayout fLT;
    private LinearLayout fLU;
    private LinearLayout fLV;
    private ImageView fLW;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        Y(acD());
    }

    private void Y(View view2) {
        this.fLM = (FrameLayout) view2.findViewById(d.g.ala_entrance_root);
        this.fLN = (TbImageView) view2.findViewById(d.g.entrance_background);
        this.fLN.setAutoChangeStyle(false);
        this.fLN.setDrawerType(1);
        this.fLN.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds10));
        this.fLO = (TbImageView) view2.findViewById(d.g.live_level_img);
        this.fLO.setAutoChangeStyle(false);
        this.fLO.setDrawerType(1);
        this.fLO.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds10));
        this.fLP = (TextView) view2.findViewById(d.g.live_level_text);
        this.fLQ = (LinearLayout) view2.findViewById(d.g.replay_root);
        this.fLS = (TextView) this.fLQ.findViewById(d.g.tv_replay_more);
        this.fLW = (ImageView) this.fLQ.findViewById(d.g.replay_more_arrow);
        this.fLR = (TextView) this.fLQ.findViewById(d.g.tv_replay_tile);
        this.fLT = (LinearLayout) this.fLQ.findViewById(d.g.replay_item_one);
        this.fLU = (LinearLayout) this.fLQ.findViewById(d.g.replay_item_two);
        this.fLV = (LinearLayout) this.fLQ.findViewById(d.g.replay_item_three);
        e(this.fLT);
        e(this.fLU);
        e(this.fLV);
        this.fLM.setOnClickListener(this);
        this.fLT.setOnClickListener(this);
        this.fLU.setOnClickListener(this);
        this.fLV.setOnClickListener(this);
        this.fLS.setOnClickListener(this);
        this.cJP = view2.findViewById(d.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
        ak.h(this.fLR, d.C0126d.cp_cont_b);
        ak.h(this.fLS, d.C0126d.cp_cont_d);
        ak.j(this.cJP, d.C0126d.cp_bg_line_e);
        ak.c(this.fLW, d.f.icon_mine_list_arrow);
        f(this.fLT);
        f(this.fLU);
        f(this.fLV);
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
            this.fLM.setVisibility(8);
            return;
        }
        this.fLM.setVisibility(0);
        this.fLM.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.fLN.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.fLO.setBackgroundResource(d.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.fLO.setBackgroundResource(d.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.fLO.setBackgroundResource(d.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.fLO.setBackgroundResource(d.f.shape_ala_grade_4_orange);
        } else {
            this.fLO.setBackgroundResource(d.f.shape_ala_grade_5_purple);
        }
        this.fLP.setText(rl(String.valueOf(i)));
    }

    private void cY(List<AlaLiveInfoCoreData> list) {
        if (v.w(list)) {
            this.fLQ.setVisibility(8);
            return;
        }
        this.fLQ.setVisibility(0);
        this.fLU.setVisibility(0);
        this.fLV.setVisibility(0);
        this.fLT.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.fLS.setVisibility(0);
            this.fLW.setVisibility(0);
        } else {
            this.fLS.setVisibility(4);
            this.fLW.setVisibility(4);
        }
        a(list.get(0), this.fLT);
        if (size >= 3) {
            a(list.get(1), this.fLU);
            a(list.get(2), this.fLV);
        } else if (size >= 2) {
            a(list.get(1), this.fLU);
            this.fLV.setVisibility(4);
        } else {
            this.fLU.setVisibility(4);
            this.fLV.setVisibility(4);
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
        if (view2 == this.fLM) {
            if (this.fLM.getTag() != null && (this.fLM.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.fLM.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new al("c12544"));
            }
        } else if (view2 == this.fLT) {
            bo(this.fLT);
        } else if (view2 == this.fLU) {
            bo(this.fLU);
        } else if (view2 == this.fLV) {
            bo(this.fLV);
        } else if (view2 == this.fLS) {
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
