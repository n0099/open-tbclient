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
    private View drg;
    private FrameLayout gqV;
    private TbImageView gqW;
    private TbImageView gqX;
    private TextView gqY;
    private LinearLayout gqZ;
    private TextView gra;
    private TextView grb;
    private LinearLayout grc;
    private LinearLayout grd;
    private LinearLayout gre;
    private ImageView grf;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        bu(aiw());
    }

    private void bu(View view) {
        this.gqV = (FrameLayout) view.findViewById(d.g.ala_entrance_root);
        this.gqW = (TbImageView) view.findViewById(d.g.entrance_background);
        this.gqW.setAutoChangeStyle(false);
        this.gqW.setDrawerType(1);
        this.gqW.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds10));
        this.gqX = (TbImageView) view.findViewById(d.g.live_level_img);
        this.gqX.setAutoChangeStyle(false);
        this.gqX.setDrawerType(1);
        this.gqX.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds10));
        this.gqY = (TextView) view.findViewById(d.g.live_level_text);
        this.gqZ = (LinearLayout) view.findViewById(d.g.replay_root);
        this.grb = (TextView) this.gqZ.findViewById(d.g.tv_replay_more);
        this.grf = (ImageView) this.gqZ.findViewById(d.g.replay_more_arrow);
        this.gra = (TextView) this.gqZ.findViewById(d.g.tv_replay_tile);
        this.grc = (LinearLayout) this.gqZ.findViewById(d.g.replay_item_one);
        this.grd = (LinearLayout) this.gqZ.findViewById(d.g.replay_item_two);
        this.gre = (LinearLayout) this.gqZ.findViewById(d.g.replay_item_three);
        e(this.grc);
        e(this.grd);
        e(this.gre);
        this.gqV.setOnClickListener(this);
        this.grc.setOnClickListener(this);
        this.grd.setOnClickListener(this);
        this.gre.setOnClickListener(this);
        this.grb.setOnClickListener(this);
        this.drg = view.findViewById(d.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        aj.t(this.mRootView, d.C0141d.cp_bg_line_d);
        aj.r(this.gra, d.C0141d.cp_cont_b);
        aj.r(this.grb, d.C0141d.cp_cont_d);
        aj.t(this.drg, d.C0141d.cp_bg_line_e);
        aj.c(this.grf, d.f.icon_mine_list_arrow);
        f(this.grc);
        f(this.grd);
        f(this.gre);
    }

    public View aiw() {
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
            this.gqV.setVisibility(8);
            return;
        }
        this.gqV.setVisibility(0);
        this.gqV.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.gqW.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.gqX.setBackgroundResource(d.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.gqX.setBackgroundResource(d.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.gqX.setBackgroundResource(d.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.gqX.setBackgroundResource(d.f.shape_ala_grade_4_orange);
        } else {
            this.gqX.setBackgroundResource(d.f.shape_ala_grade_5_purple);
        }
        this.gqY.setText(re(String.valueOf(i)));
    }

    private void dg(List<AlaLiveInfoCoreData> list) {
        if (v.E(list)) {
            this.gqZ.setVisibility(8);
            return;
        }
        this.gqZ.setVisibility(0);
        this.grd.setVisibility(0);
        this.gre.setVisibility(0);
        this.grc.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.grb.setVisibility(0);
            this.grf.setVisibility(0);
        } else {
            this.grb.setVisibility(4);
            this.grf.setVisibility(4);
        }
        a(list.get(0), this.grc);
        if (size >= 3) {
            a(list.get(1), this.grd);
            a(list.get(2), this.gre);
        } else if (size >= 2) {
            a(list.get(1), this.grd);
            this.gre.setVisibility(4);
        } else {
            this.grd.setVisibility(4);
            this.gre.setVisibility(4);
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
        aj.r((TextView) linearLayout.findViewById(d.g.replay_item_title), d.C0141d.cp_cont_b);
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
        int color = this.mPageContext.getResources().getColor(d.C0141d.cp_cont_g);
        int parseColor = Color.parseColor("#FFD026");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, string.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), string.length(), string.length() + str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), string.length() + str.length(), str2.length(), 18);
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gqV) {
            if (this.gqV.getTag() != null && (this.gqV.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.gqV.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new ak("c12544"));
            }
        } else if (view == this.grc) {
            cI(this.grc);
        } else if (view == this.grd) {
            cI(this.grd);
        } else if (view == this.gre) {
            cI(this.gre);
        } else if (view == this.grb) {
            bkD();
        }
    }

    private void cI(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void bkD() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
