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
    private View bqE;
    private LinearLayout itA;
    private LinearLayout itB;
    private LinearLayout itC;
    private ImageView itD;
    private FrameLayout itt;
    private TbImageView itu;
    private TbImageView itv;
    private TextView itw;
    private LinearLayout itx;
    private TextView ity;
    private TextView itz;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        Q(aWT());
    }

    private void Q(View view) {
        this.itt = (FrameLayout) view.findViewById(R.id.ala_entrance_root);
        this.itu = (TbImageView) view.findViewById(R.id.entrance_background);
        this.itu.setAutoChangeStyle(false);
        this.itu.setDrawerType(1);
        this.itu.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds10));
        this.itv = (TbImageView) view.findViewById(R.id.live_level_img);
        this.itv.setAutoChangeStyle(false);
        this.itv.setDrawerType(1);
        this.itv.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds10));
        this.itw = (TextView) view.findViewById(R.id.live_level_text);
        this.itx = (LinearLayout) view.findViewById(R.id.replay_root);
        this.itz = (TextView) this.itx.findViewById(R.id.tv_replay_more);
        this.itD = (ImageView) this.itx.findViewById(R.id.replay_more_arrow);
        this.ity = (TextView) this.itx.findViewById(R.id.tv_replay_tile);
        this.itA = (LinearLayout) this.itx.findViewById(R.id.replay_item_one);
        this.itB = (LinearLayout) this.itx.findViewById(R.id.replay_item_two);
        this.itC = (LinearLayout) this.itx.findViewById(R.id.replay_item_three);
        g(this.itA);
        g(this.itB);
        g(this.itC);
        this.itt.setOnClickListener(this);
        this.itA.setOnClickListener(this);
        this.itB.setOnClickListener(this);
        this.itC.setOnClickListener(this);
        this.itz.setOnClickListener(this);
        this.bqE = view.findViewById(R.id.divider_view);
    }

    public void onChangeSkinType(int i) {
        am.l(this.mRootView, R.color.cp_bg_line_d);
        am.j(this.ity, R.color.cp_cont_b);
        am.j(this.itz, R.color.cp_cont_d);
        am.l(this.bqE, R.color.cp_bg_line_e);
        am.c(this.itD, (int) R.drawable.icon_mine_list_arrow);
        h(this.itA);
        h(this.itB);
        h(this.itC);
    }

    public View aWT() {
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
            this.itt.setVisibility(8);
            return;
        }
        this.itt.setVisibility(0);
        this.itt.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.itu.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.itv.setBackgroundResource(R.drawable.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.itv.setBackgroundResource(R.drawable.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.itv.setBackgroundResource(R.drawable.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.itv.setBackgroundResource(R.drawable.shape_ala_grade_4_orange);
        } else {
            this.itv.setBackgroundResource(R.drawable.shape_ala_grade_5_purple);
        }
        this.itw.setText(CT(String.valueOf(i)));
    }

    private void dV(List<AlaLiveInfoCoreData> list) {
        if (v.aa(list)) {
            this.itx.setVisibility(8);
            return;
        }
        this.itx.setVisibility(0);
        this.itB.setVisibility(0);
        this.itC.setVisibility(0);
        this.itA.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.itz.setVisibility(0);
            this.itD.setVisibility(0);
        } else {
            this.itz.setVisibility(4);
            this.itD.setVisibility(4);
        }
        a(list.get(0), this.itA);
        if (size >= 3) {
            a(list.get(1), this.itB);
            a(list.get(2), this.itC);
        } else if (size >= 2) {
            a(list.get(1), this.itB);
            this.itC.setVisibility(4);
        } else {
            this.itB.setVisibility(4);
            this.itC.setVisibility(4);
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

    private SpannableStringBuilder CT(String str) {
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
        if (view == this.itt) {
            if (this.itt.getTag() != null && (this.itt.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.itt.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new an("c12544"));
            }
        } else if (view == this.itA) {
            cN(this.itA);
        } else if (view == this.itB) {
            cN(this.itB);
        } else if (view == this.itC) {
            cN(this.itC);
        } else if (view == this.itz) {
            cdD();
        }
    }

    private void cN(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void cdD() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
