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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class k implements View.OnClickListener {
    private View drs;
    private FrameLayout grg;
    private TbImageView grh;
    private TbImageView gri;
    private TextView grj;
    private LinearLayout grk;
    private TextView grl;
    private TextView grm;
    private LinearLayout grn;
    private LinearLayout gro;
    private LinearLayout grp;
    private ImageView grq;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        bu(aix());
    }

    private void bu(View view) {
        this.grg = (FrameLayout) view.findViewById(d.g.ala_entrance_root);
        this.grh = (TbImageView) view.findViewById(d.g.entrance_background);
        this.grh.setAutoChangeStyle(false);
        this.grh.setDrawerType(1);
        this.grh.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds10));
        this.gri = (TbImageView) view.findViewById(d.g.live_level_img);
        this.gri.setAutoChangeStyle(false);
        this.gri.setDrawerType(1);
        this.gri.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds10));
        this.grj = (TextView) view.findViewById(d.g.live_level_text);
        this.grk = (LinearLayout) view.findViewById(d.g.replay_root);
        this.grm = (TextView) this.grk.findViewById(d.g.tv_replay_more);
        this.grq = (ImageView) this.grk.findViewById(d.g.replay_more_arrow);
        this.grl = (TextView) this.grk.findViewById(d.g.tv_replay_tile);
        this.grn = (LinearLayout) this.grk.findViewById(d.g.replay_item_one);
        this.gro = (LinearLayout) this.grk.findViewById(d.g.replay_item_two);
        this.grp = (LinearLayout) this.grk.findViewById(d.g.replay_item_three);
        e(this.grn);
        e(this.gro);
        e(this.grp);
        this.grg.setOnClickListener(this);
        this.grn.setOnClickListener(this);
        this.gro.setOnClickListener(this);
        this.grp.setOnClickListener(this);
        this.grm.setOnClickListener(this);
        this.drs = view.findViewById(d.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        aj.t(this.mRootView, d.C0140d.cp_bg_line_d);
        aj.r(this.grl, d.C0140d.cp_cont_b);
        aj.r(this.grm, d.C0140d.cp_cont_d);
        aj.t(this.drs, d.C0140d.cp_bg_line_e);
        aj.c(this.grq, d.f.icon_mine_list_arrow);
        f(this.grn);
        f(this.gro);
        f(this.grp);
    }

    public View aix() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        dg(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.grg.setVisibility(8);
            return;
        }
        this.grg.setVisibility(0);
        this.grg.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.grh.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.gri.setBackgroundResource(d.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.gri.setBackgroundResource(d.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.gri.setBackgroundResource(d.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.gri.setBackgroundResource(d.f.shape_ala_grade_4_orange);
        } else {
            this.gri.setBackgroundResource(d.f.shape_ala_grade_5_purple);
        }
        this.grj.setText(re(String.valueOf(i)));
    }

    private void dg(List<AlaLiveInfoCoreData> list) {
        if (v.E(list)) {
            this.grk.setVisibility(8);
            return;
        }
        this.grk.setVisibility(0);
        this.gro.setVisibility(0);
        this.grp.setVisibility(0);
        this.grn.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.grm.setVisibility(0);
            this.grq.setVisibility(0);
        } else {
            this.grm.setVisibility(4);
            this.grq.setVisibility(4);
        }
        a(list.get(0), this.grn);
        if (size >= 3) {
            a(list.get(1), this.gro);
            a(list.get(2), this.grp);
        } else if (size >= 2) {
            a(list.get(1), this.gro);
            this.grp.setVisibility(4);
        } else {
            this.gro.setVisibility(4);
            this.grp.setVisibility(4);
        }
    }

    private void e(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(d.e.ds34);
        layoutParams.width = ((com.baidu.adp.lib.util.l.ao(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(d.e.ds16) * 2)) - (dimensionPixelSize * 2)) / 3;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    private void f(LinearLayout linearLayout) {
        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(d.g.replay_item_cover);
        tbImageView.setAutoChangeStyle(true);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(d.f.pic_bg_video_frs);
        aj.r((TextView) linearLayout.findViewById(d.g.replay_item_title), d.C0140d.cp_cont_b);
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

    private SpannableStringBuilder re(String str) {
        String string = this.mPageContext.getResources().getString(d.j.ala_live_entrance_level_text_pre);
        String str2 = string + String.format(this.mPageContext.getResources().getString(d.j.ala_live_entrance_level_text_content), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int color = this.mPageContext.getResources().getColor(d.C0140d.cp_cont_g);
        int parseColor = Color.parseColor("#FFD026");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, string.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), string.length(), string.length() + str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), string.length() + str.length(), str2.length(), 18);
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.grg) {
            if (this.grg.getTag() != null && (this.grg.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.grg.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new ak("c12544"));
            }
        } else if (view == this.grn) {
            cI(this.grn);
        } else if (view == this.gro) {
            cI(this.gro);
        } else if (view == this.grp) {
            cI(this.grp);
        } else if (view == this.grm) {
            bkE();
        }
    }

    private void cI(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void bkE() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
