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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes6.dex */
public class k implements View.OnClickListener {
    private View bjN;
    private FrameLayout hTh;
    private TbImageView hTi;
    private TbImageView hTj;
    private TextView hTk;
    private LinearLayout hTl;
    private TextView hTm;
    private TextView hTn;
    private LinearLayout hTo;
    private LinearLayout hTp;
    private LinearLayout hTq;
    private ImageView hTr;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        O(aOH());
    }

    private void O(View view) {
        this.hTh = (FrameLayout) view.findViewById(d.g.ala_entrance_root);
        this.hTi = (TbImageView) view.findViewById(d.g.entrance_background);
        this.hTi.setAutoChangeStyle(false);
        this.hTi.setDrawerType(1);
        this.hTi.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds10));
        this.hTj = (TbImageView) view.findViewById(d.g.live_level_img);
        this.hTj.setAutoChangeStyle(false);
        this.hTj.setDrawerType(1);
        this.hTj.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds10));
        this.hTk = (TextView) view.findViewById(d.g.live_level_text);
        this.hTl = (LinearLayout) view.findViewById(d.g.replay_root);
        this.hTn = (TextView) this.hTl.findViewById(d.g.tv_replay_more);
        this.hTr = (ImageView) this.hTl.findViewById(d.g.replay_more_arrow);
        this.hTm = (TextView) this.hTl.findViewById(d.g.tv_replay_tile);
        this.hTo = (LinearLayout) this.hTl.findViewById(d.g.replay_item_one);
        this.hTp = (LinearLayout) this.hTl.findViewById(d.g.replay_item_two);
        this.hTq = (LinearLayout) this.hTl.findViewById(d.g.replay_item_three);
        g(this.hTo);
        g(this.hTp);
        g(this.hTq);
        this.hTh.setOnClickListener(this);
        this.hTo.setOnClickListener(this);
        this.hTp.setOnClickListener(this);
        this.hTq.setOnClickListener(this);
        this.hTn.setOnClickListener(this);
        this.bjN = view.findViewById(d.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
        al.j(this.hTm, d.C0277d.cp_cont_b);
        al.j(this.hTn, d.C0277d.cp_cont_d);
        al.l(this.bjN, d.C0277d.cp_bg_line_e);
        al.c(this.hTr, d.f.icon_mine_list_arrow);
        h(this.hTo);
        h(this.hTp);
        h(this.hTq);
    }

    public View aOH() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        dK(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.hTh.setVisibility(8);
            return;
        }
        this.hTh.setVisibility(0);
        this.hTh.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.hTi.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.hTj.setBackgroundResource(d.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.hTj.setBackgroundResource(d.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.hTj.setBackgroundResource(d.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.hTj.setBackgroundResource(d.f.shape_ala_grade_4_orange);
        } else {
            this.hTj.setBackgroundResource(d.f.shape_ala_grade_5_purple);
        }
        this.hTk.setText(AL(String.valueOf(i)));
    }

    private void dK(List<AlaLiveInfoCoreData> list) {
        if (v.T(list)) {
            this.hTl.setVisibility(8);
            return;
        }
        this.hTl.setVisibility(0);
        this.hTp.setVisibility(0);
        this.hTq.setVisibility(0);
        this.hTo.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.hTn.setVisibility(0);
            this.hTr.setVisibility(0);
        } else {
            this.hTn.setVisibility(4);
            this.hTr.setVisibility(4);
        }
        a(list.get(0), this.hTo);
        if (size >= 3) {
            a(list.get(1), this.hTp);
            a(list.get(2), this.hTq);
        } else if (size >= 2) {
            a(list.get(1), this.hTp);
            this.hTq.setVisibility(4);
        } else {
            this.hTp.setVisibility(4);
            this.hTq.setVisibility(4);
        }
    }

    private void g(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds34);
        layoutParams.width = ((com.baidu.adp.lib.util.l.aO(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(d.e.ds16) * 2)) - (dimensionPixelSize * 2)) / 3;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    private void h(LinearLayout linearLayout) {
        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(d.g.replay_item_cover);
        tbImageView.setAutoChangeStyle(true);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(d.f.pic_bg_video_frs);
        al.j((TextView) linearLayout.findViewById(d.g.replay_item_title), d.C0277d.cp_cont_b);
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, LinearLayout linearLayout) {
        if (alaLiveInfoCoreData != null && linearLayout != null) {
            linearLayout.setTag(alaLiveInfoCoreData);
            TextView textView = (TextView) linearLayout.findViewById(d.g.replay_item_title);
            if (textView != null) {
                if (!StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                    textView.setText(alaLiveInfoCoreData.liveTitle);
                } else if (this.mIsHost) {
                    textView.setText(this.mPageContext.getString(d.j.wo_replay));
                } else {
                    textView.setText(this.mPageContext.getString(d.j.ta_replay));
                }
            }
            TbImageView tbImageView = (TbImageView) linearLayout.findViewById(d.g.replay_item_cover);
            if (tbImageView != null && !StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
                tbImageView.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
            }
        }
    }

    private SpannableStringBuilder AL(String str) {
        String string = this.mPageContext.getResources().getString(d.j.ala_live_entrance_level_text_pre);
        String str2 = string + String.format(this.mPageContext.getResources().getString(d.j.ala_live_entrance_level_text_content), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int color = this.mPageContext.getResources().getColor(d.C0277d.cp_cont_g);
        int parseColor = Color.parseColor("#FFD026");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, string.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), string.length(), string.length() + str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), string.length() + str.length(), str2.length(), 18);
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hTh) {
            if (this.hTh.getTag() != null && (this.hTh.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.hTh.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new am("c12544"));
            }
        } else if (view == this.hTo) {
            cA(this.hTo);
        } else if (view == this.hTp) {
            cA(this.hTp);
        } else if (view == this.hTq) {
            cA(this.hTq);
        } else if (view == this.hTn) {
            bSr();
        }
    }

    private void cA(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void bSr() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
