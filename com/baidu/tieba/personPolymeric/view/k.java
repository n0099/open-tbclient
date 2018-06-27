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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class k implements View.OnClickListener {
    private View cSc;
    private FrameLayout gcb;
    private TbImageView gcc;
    private TbImageView gcd;
    private TextView gce;
    private LinearLayout gcf;
    private TextView gcg;
    private TextView gch;
    private LinearLayout gci;
    private LinearLayout gcj;
    private LinearLayout gck;
    private ImageView gcl;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        W(agG());
    }

    private void W(View view) {
        this.gcb = (FrameLayout) view.findViewById(d.g.ala_entrance_root);
        this.gcc = (TbImageView) view.findViewById(d.g.entrance_background);
        this.gcc.setAutoChangeStyle(false);
        this.gcc.setDrawerType(1);
        this.gcc.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds10));
        this.gcd = (TbImageView) view.findViewById(d.g.live_level_img);
        this.gcd.setAutoChangeStyle(false);
        this.gcd.setDrawerType(1);
        this.gcd.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds10));
        this.gce = (TextView) view.findViewById(d.g.live_level_text);
        this.gcf = (LinearLayout) view.findViewById(d.g.replay_root);
        this.gch = (TextView) this.gcf.findViewById(d.g.tv_replay_more);
        this.gcl = (ImageView) this.gcf.findViewById(d.g.replay_more_arrow);
        this.gcg = (TextView) this.gcf.findViewById(d.g.tv_replay_tile);
        this.gci = (LinearLayout) this.gcf.findViewById(d.g.replay_item_one);
        this.gcj = (LinearLayout) this.gcf.findViewById(d.g.replay_item_two);
        this.gck = (LinearLayout) this.gcf.findViewById(d.g.replay_item_three);
        f(this.gci);
        f(this.gcj);
        f(this.gck);
        this.gcb.setOnClickListener(this);
        this.gci.setOnClickListener(this);
        this.gcj.setOnClickListener(this);
        this.gck.setOnClickListener(this);
        this.gch.setOnClickListener(this);
        this.cSc = view.findViewById(d.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        am.j(this.mRootView, d.C0142d.cp_bg_line_d);
        am.h(this.gcg, d.C0142d.cp_cont_b);
        am.h(this.gch, d.C0142d.cp_cont_d);
        am.j(this.cSc, d.C0142d.cp_bg_line_e);
        am.c(this.gcl, d.f.icon_mine_list_arrow);
        g(this.gci);
        g(this.gcj);
        g(this.gck);
    }

    public View agG() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        dk(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.gcb.setVisibility(8);
            return;
        }
        this.gcb.setVisibility(0);
        this.gcb.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.gcc.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.gcd.setBackgroundResource(d.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.gcd.setBackgroundResource(d.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.gcd.setBackgroundResource(d.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.gcd.setBackgroundResource(d.f.shape_ala_grade_4_orange);
        } else {
            this.gcd.setBackgroundResource(d.f.shape_ala_grade_5_purple);
        }
        this.gce.setText(se(String.valueOf(i)));
    }

    private void dk(List<AlaLiveInfoCoreData> list) {
        if (w.A(list)) {
            this.gcf.setVisibility(8);
            return;
        }
        this.gcf.setVisibility(0);
        this.gcj.setVisibility(0);
        this.gck.setVisibility(0);
        this.gci.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.gch.setVisibility(0);
            this.gcl.setVisibility(0);
        } else {
            this.gch.setVisibility(4);
            this.gcl.setVisibility(4);
        }
        a(list.get(0), this.gci);
        if (size >= 3) {
            a(list.get(1), this.gcj);
            a(list.get(2), this.gck);
        } else if (size >= 2) {
            a(list.get(1), this.gcj);
            this.gck.setVisibility(4);
        } else {
            this.gcj.setVisibility(4);
            this.gck.setVisibility(4);
        }
    }

    private void f(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds34);
        layoutParams.width = ((com.baidu.adp.lib.util.l.ah(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(d.e.ds16) * 2)) - (dimensionPixelSize * 2)) / 3;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    private void g(LinearLayout linearLayout) {
        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(d.g.replay_item_cover);
        tbImageView.setAutoChangeStyle(true);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(d.f.pic_bg_video_frs);
        am.h((TextView) linearLayout.findViewById(d.g.replay_item_title), d.C0142d.cp_cont_b);
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

    private SpannableStringBuilder se(String str) {
        String string = this.mPageContext.getResources().getString(d.k.ala_live_entrance_level_text_pre);
        String str2 = string + String.format(this.mPageContext.getResources().getString(d.k.ala_live_entrance_level_text_content), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int color = this.mPageContext.getResources().getColor(d.C0142d.cp_cont_g);
        int parseColor = Color.parseColor("#FFD026");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, string.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), string.length(), string.length() + str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), string.length() + str.length(), str2.length(), 18);
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gcb) {
            if (this.gcb.getTag() != null && (this.gcb.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.gcb.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new an("c12544"));
            }
        } else if (view == this.gci) {
            bs(this.gci);
        } else if (view == this.gcj) {
            bs(this.gcj);
        } else if (view == this.gck) {
            bs(this.gck);
        } else if (view == this.gch) {
            blm();
        }
    }

    private void bs(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void blm() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
