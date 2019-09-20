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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class k implements View.OnClickListener {
    private View brc;
    private LinearLayout ivA;
    private LinearLayout ivB;
    private ImageView ivC;
    private FrameLayout ivs;
    private TbImageView ivt;
    private TbImageView ivu;
    private TextView ivv;
    private LinearLayout ivw;
    private TextView ivx;
    private TextView ivy;
    private LinearLayout ivz;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        Q(aXx());
    }

    private void Q(View view) {
        this.ivs = (FrameLayout) view.findViewById(R.id.ala_entrance_root);
        this.ivt = (TbImageView) view.findViewById(R.id.entrance_background);
        this.ivt.setAutoChangeStyle(false);
        this.ivt.setDrawerType(1);
        this.ivt.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds10));
        this.ivu = (TbImageView) view.findViewById(R.id.live_level_img);
        this.ivu.setAutoChangeStyle(false);
        this.ivu.setDrawerType(1);
        this.ivu.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds10));
        this.ivv = (TextView) view.findViewById(R.id.live_level_text);
        this.ivw = (LinearLayout) view.findViewById(R.id.replay_root);
        this.ivy = (TextView) this.ivw.findViewById(R.id.tv_replay_more);
        this.ivC = (ImageView) this.ivw.findViewById(R.id.replay_more_arrow);
        this.ivx = (TextView) this.ivw.findViewById(R.id.tv_replay_tile);
        this.ivz = (LinearLayout) this.ivw.findViewById(R.id.replay_item_one);
        this.ivA = (LinearLayout) this.ivw.findViewById(R.id.replay_item_two);
        this.ivB = (LinearLayout) this.ivw.findViewById(R.id.replay_item_three);
        g(this.ivz);
        g(this.ivA);
        g(this.ivB);
        this.ivs.setOnClickListener(this);
        this.ivz.setOnClickListener(this);
        this.ivA.setOnClickListener(this);
        this.ivB.setOnClickListener(this);
        this.ivy.setOnClickListener(this);
        this.brc = view.findViewById(R.id.divider_view);
    }

    public void onChangeSkinType(int i) {
        am.l(this.mRootView, R.color.cp_bg_line_d);
        am.j(this.ivx, R.color.cp_cont_b);
        am.j(this.ivy, R.color.cp_cont_d);
        am.l(this.brc, R.color.cp_bg_line_e);
        am.c(this.ivC, (int) R.drawable.icon_mine_list_arrow);
        h(this.ivz);
        h(this.ivA);
        h(this.ivB);
    }

    public View aXx() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        dV(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.ivs.setVisibility(8);
            return;
        }
        this.ivs.setVisibility(0);
        this.ivs.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.ivt.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.ivu.setBackgroundResource(R.drawable.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.ivu.setBackgroundResource(R.drawable.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.ivu.setBackgroundResource(R.drawable.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.ivu.setBackgroundResource(R.drawable.shape_ala_grade_4_orange);
        } else {
            this.ivu.setBackgroundResource(R.drawable.shape_ala_grade_5_purple);
        }
        this.ivv.setText(Ds(String.valueOf(i)));
    }

    private void dV(List<AlaLiveInfoCoreData> list) {
        if (v.aa(list)) {
            this.ivw.setVisibility(8);
            return;
        }
        this.ivw.setVisibility(0);
        this.ivA.setVisibility(0);
        this.ivB.setVisibility(0);
        this.ivz.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.ivy.setVisibility(0);
            this.ivC.setVisibility(0);
        } else {
            this.ivy.setVisibility(4);
            this.ivC.setVisibility(4);
        }
        a(list.get(0), this.ivz);
        if (size >= 3) {
            a(list.get(1), this.ivA);
            a(list.get(2), this.ivB);
        } else if (size >= 2) {
            a(list.get(1), this.ivA);
            this.ivB.setVisibility(4);
        } else {
            this.ivA.setVisibility(4);
            this.ivB.setVisibility(4);
        }
    }

    private void g(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds34);
        layoutParams.width = ((com.baidu.adp.lib.util.l.af(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) - (dimensionPixelSize * 2)) / 3;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    private void h(LinearLayout linearLayout) {
        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(R.id.replay_item_cover);
        tbImageView.setAutoChangeStyle(true);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        am.j((TextView) linearLayout.findViewById(R.id.replay_item_title), R.color.cp_cont_b);
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, LinearLayout linearLayout) {
        if (alaLiveInfoCoreData != null && linearLayout != null) {
            linearLayout.setTag(alaLiveInfoCoreData);
            TextView textView = (TextView) linearLayout.findViewById(R.id.replay_item_title);
            if (textView != null) {
                if (!StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                    textView.setText(alaLiveInfoCoreData.liveTitle);
                } else if (this.mIsHost) {
                    textView.setText(this.mPageContext.getString(R.string.wo_replay));
                } else {
                    textView.setText(this.mPageContext.getString(R.string.ta_replay));
                }
            }
            TbImageView tbImageView = (TbImageView) linearLayout.findViewById(R.id.replay_item_cover);
            if (tbImageView != null && !StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
                tbImageView.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
            }
        }
    }

    private SpannableStringBuilder Ds(String str) {
        String string = this.mPageContext.getResources().getString(R.string.ala_live_entrance_level_text_pre);
        String str2 = string + String.format(this.mPageContext.getResources().getString(R.string.ala_live_entrance_level_text_content), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int color = this.mPageContext.getResources().getColor(R.color.cp_cont_g);
        int parseColor = Color.parseColor("#FFD026");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, string.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), string.length(), string.length() + str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), string.length() + str.length(), str2.length(), 18);
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ivs) {
            if (this.ivs.getTag() != null && (this.ivs.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.ivs.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new an("c12544"));
            }
        } else if (view == this.ivz) {
            cN(this.ivz);
        } else if (view == this.ivA) {
            cN(this.ivA);
        } else if (view == this.ivB) {
            cN(this.ivB);
        } else if (view == this.ivy) {
            cer();
        }
    }

    private void cN(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void cer() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
