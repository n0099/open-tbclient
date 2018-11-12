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
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class k implements View.OnClickListener {
    private FrameLayout gsK;
    private TbImageView gsL;
    private TbImageView gsM;
    private TextView gsN;
    private LinearLayout gsO;
    private TextView gsP;
    private TextView gsQ;
    private LinearLayout gsR;
    private LinearLayout gsS;
    private LinearLayout gsT;
    private ImageView gsU;
    private View mDividerView;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        initView(alT());
    }

    private void initView(View view) {
        this.gsK = (FrameLayout) view.findViewById(e.g.ala_entrance_root);
        this.gsL = (TbImageView) view.findViewById(e.g.entrance_background);
        this.gsL.setAutoChangeStyle(false);
        this.gsL.setDrawerType(1);
        this.gsL.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0200e.ds10));
        this.gsM = (TbImageView) view.findViewById(e.g.live_level_img);
        this.gsM.setAutoChangeStyle(false);
        this.gsM.setDrawerType(1);
        this.gsM.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0200e.ds10));
        this.gsN = (TextView) view.findViewById(e.g.live_level_text);
        this.gsO = (LinearLayout) view.findViewById(e.g.replay_root);
        this.gsQ = (TextView) this.gsO.findViewById(e.g.tv_replay_more);
        this.gsU = (ImageView) this.gsO.findViewById(e.g.replay_more_arrow);
        this.gsP = (TextView) this.gsO.findViewById(e.g.tv_replay_tile);
        this.gsR = (LinearLayout) this.gsO.findViewById(e.g.replay_item_one);
        this.gsS = (LinearLayout) this.gsO.findViewById(e.g.replay_item_two);
        this.gsT = (LinearLayout) this.gsO.findViewById(e.g.replay_item_three);
        g(this.gsR);
        g(this.gsS);
        g(this.gsT);
        this.gsK.setOnClickListener(this);
        this.gsR.setOnClickListener(this);
        this.gsS.setOnClickListener(this);
        this.gsT.setOnClickListener(this);
        this.gsQ.setOnClickListener(this);
        this.mDividerView = view.findViewById(e.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
        al.h(this.gsP, e.d.cp_cont_b);
        al.h(this.gsQ, e.d.cp_cont_d);
        al.j(this.mDividerView, e.d.cp_bg_line_e);
        al.c(this.gsU, e.f.icon_mine_list_arrow);
        h(this.gsR);
        h(this.gsS);
        h(this.gsT);
    }

    public View alT() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        dt(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.gsK.setVisibility(8);
            return;
        }
        this.gsK.setVisibility(0);
        this.gsK.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.gsL.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.gsM.setBackgroundResource(e.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.gsM.setBackgroundResource(e.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.gsM.setBackgroundResource(e.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.gsM.setBackgroundResource(e.f.shape_ala_grade_4_orange);
        } else {
            this.gsM.setBackgroundResource(e.f.shape_ala_grade_5_purple);
        }
        this.gsN.setText(tn(String.valueOf(i)));
    }

    private void dt(List<AlaLiveInfoCoreData> list) {
        if (v.I(list)) {
            this.gsO.setVisibility(8);
            return;
        }
        this.gsO.setVisibility(0);
        this.gsS.setVisibility(0);
        this.gsT.setVisibility(0);
        this.gsR.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.gsQ.setVisibility(0);
            this.gsU.setVisibility(0);
        } else {
            this.gsQ.setVisibility(4);
            this.gsU.setVisibility(4);
        }
        a(list.get(0), this.gsR);
        if (size >= 3) {
            a(list.get(1), this.gsS);
            a(list.get(2), this.gsT);
        } else if (size >= 2) {
            a(list.get(1), this.gsS);
            this.gsT.setVisibility(4);
        } else {
            this.gsS.setVisibility(4);
            this.gsT.setVisibility(4);
        }
    }

    private void g(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds34);
        layoutParams.width = ((com.baidu.adp.lib.util.l.aO(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds16) * 2)) - (dimensionPixelSize * 2)) / 3;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    private void h(LinearLayout linearLayout) {
        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(e.g.replay_item_cover);
        tbImageView.setAutoChangeStyle(true);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(e.f.pic_bg_video_frs);
        al.h((TextView) linearLayout.findViewById(e.g.replay_item_title), e.d.cp_cont_b);
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, LinearLayout linearLayout) {
        if (alaLiveInfoCoreData != null && linearLayout != null) {
            linearLayout.setTag(alaLiveInfoCoreData);
            TextView textView = (TextView) linearLayout.findViewById(e.g.replay_item_title);
            if (textView != null) {
                if (!StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                    textView.setText(alaLiveInfoCoreData.liveTitle);
                } else if (this.mIsHost) {
                    textView.setText(this.mPageContext.getString(e.j.wo_replay));
                } else {
                    textView.setText(this.mPageContext.getString(e.j.ta_replay));
                }
            }
            TbImageView tbImageView = (TbImageView) linearLayout.findViewById(e.g.replay_item_cover);
            if (tbImageView != null && !StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
                tbImageView.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
            }
        }
    }

    private SpannableStringBuilder tn(String str) {
        String string = this.mPageContext.getResources().getString(e.j.ala_live_entrance_level_text_pre);
        String str2 = string + String.format(this.mPageContext.getResources().getString(e.j.ala_live_entrance_level_text_content), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int color = this.mPageContext.getResources().getColor(e.d.cp_cont_g);
        int parseColor = Color.parseColor("#FFD026");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, string.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), string.length(), string.length() + str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), string.length() + str.length(), str2.length(), 18);
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gsK) {
            if (this.gsK.getTag() != null && (this.gsK.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.gsK.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new am("c12544"));
            }
        } else if (view == this.gsR) {
            bK(this.gsR);
        } else if (view == this.gsS) {
            bK(this.gsS);
        } else if (view == this.gsT) {
            bK(this.gsT);
        } else if (view == this.gsQ) {
            boK();
        }
    }

    private void bK(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void boK() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
