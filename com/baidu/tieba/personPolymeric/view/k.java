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
    private ImageView isA;
    private FrameLayout isq;
    private TbImageView isr;
    private TbImageView iss;
    private TextView ist;
    private LinearLayout isu;
    private TextView isv;
    private TextView isw;
    private LinearLayout isx;
    private LinearLayout isy;
    private LinearLayout isz;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        Q(aWR());
    }

    private void Q(View view) {
        this.isq = (FrameLayout) view.findViewById(R.id.ala_entrance_root);
        this.isr = (TbImageView) view.findViewById(R.id.entrance_background);
        this.isr.setAutoChangeStyle(false);
        this.isr.setDrawerType(1);
        this.isr.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds10));
        this.iss = (TbImageView) view.findViewById(R.id.live_level_img);
        this.iss.setAutoChangeStyle(false);
        this.iss.setDrawerType(1);
        this.iss.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds10));
        this.ist = (TextView) view.findViewById(R.id.live_level_text);
        this.isu = (LinearLayout) view.findViewById(R.id.replay_root);
        this.isw = (TextView) this.isu.findViewById(R.id.tv_replay_more);
        this.isA = (ImageView) this.isu.findViewById(R.id.replay_more_arrow);
        this.isv = (TextView) this.isu.findViewById(R.id.tv_replay_tile);
        this.isx = (LinearLayout) this.isu.findViewById(R.id.replay_item_one);
        this.isy = (LinearLayout) this.isu.findViewById(R.id.replay_item_two);
        this.isz = (LinearLayout) this.isu.findViewById(R.id.replay_item_three);
        g(this.isx);
        g(this.isy);
        g(this.isz);
        this.isq.setOnClickListener(this);
        this.isx.setOnClickListener(this);
        this.isy.setOnClickListener(this);
        this.isz.setOnClickListener(this);
        this.isw.setOnClickListener(this);
        this.bqE = view.findViewById(R.id.divider_view);
    }

    public void onChangeSkinType(int i) {
        am.l(this.mRootView, R.color.cp_bg_line_d);
        am.j(this.isv, R.color.cp_cont_b);
        am.j(this.isw, R.color.cp_cont_d);
        am.l(this.bqE, R.color.cp_bg_line_e);
        am.c(this.isA, (int) R.drawable.icon_mine_list_arrow);
        h(this.isx);
        h(this.isy);
        h(this.isz);
    }

    public View aWR() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        dW(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.isq.setVisibility(8);
            return;
        }
        this.isq.setVisibility(0);
        this.isq.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.isr.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.iss.setBackgroundResource(R.drawable.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.iss.setBackgroundResource(R.drawable.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.iss.setBackgroundResource(R.drawable.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.iss.setBackgroundResource(R.drawable.shape_ala_grade_4_orange);
        } else {
            this.iss.setBackgroundResource(R.drawable.shape_ala_grade_5_purple);
        }
        this.ist.setText(CS(String.valueOf(i)));
    }

    private void dW(List<AlaLiveInfoCoreData> list) {
        if (v.aa(list)) {
            this.isu.setVisibility(8);
            return;
        }
        this.isu.setVisibility(0);
        this.isy.setVisibility(0);
        this.isz.setVisibility(0);
        this.isx.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.isw.setVisibility(0);
            this.isA.setVisibility(0);
        } else {
            this.isw.setVisibility(4);
            this.isA.setVisibility(4);
        }
        a(list.get(0), this.isx);
        if (size >= 3) {
            a(list.get(1), this.isy);
            a(list.get(2), this.isz);
        } else if (size >= 2) {
            a(list.get(1), this.isy);
            this.isz.setVisibility(4);
        } else {
            this.isy.setVisibility(4);
            this.isz.setVisibility(4);
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

    private SpannableStringBuilder CS(String str) {
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
        if (view == this.isq) {
            if (this.isq.getTag() != null && (this.isq.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.isq.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new an("c12544"));
            }
        } else if (view == this.isx) {
            cL(this.isx);
        } else if (view == this.isy) {
            cL(this.isy);
        } else if (view == this.isz) {
            cL(this.isz);
        } else if (view == this.isw) {
            cdl();
        }
    }

    private void cL(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void cdl() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
