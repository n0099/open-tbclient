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
    private View cKV;
    private FrameLayout fMP;
    private TbImageView fMQ;
    private TbImageView fMR;
    private TextView fMS;
    private LinearLayout fMT;
    private TextView fMU;
    private TextView fMV;
    private LinearLayout fMW;
    private LinearLayout fMX;
    private LinearLayout fMY;
    private ImageView fMZ;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        Y(acD());
    }

    private void Y(View view2) {
        this.fMP = (FrameLayout) view2.findViewById(d.g.ala_entrance_root);
        this.fMQ = (TbImageView) view2.findViewById(d.g.entrance_background);
        this.fMQ.setAutoChangeStyle(false);
        this.fMQ.setDrawerType(1);
        this.fMQ.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds10));
        this.fMR = (TbImageView) view2.findViewById(d.g.live_level_img);
        this.fMR.setAutoChangeStyle(false);
        this.fMR.setDrawerType(1);
        this.fMR.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds10));
        this.fMS = (TextView) view2.findViewById(d.g.live_level_text);
        this.fMT = (LinearLayout) view2.findViewById(d.g.replay_root);
        this.fMV = (TextView) this.fMT.findViewById(d.g.tv_replay_more);
        this.fMZ = (ImageView) this.fMT.findViewById(d.g.replay_more_arrow);
        this.fMU = (TextView) this.fMT.findViewById(d.g.tv_replay_tile);
        this.fMW = (LinearLayout) this.fMT.findViewById(d.g.replay_item_one);
        this.fMX = (LinearLayout) this.fMT.findViewById(d.g.replay_item_two);
        this.fMY = (LinearLayout) this.fMT.findViewById(d.g.replay_item_three);
        e(this.fMW);
        e(this.fMX);
        e(this.fMY);
        this.fMP.setOnClickListener(this);
        this.fMW.setOnClickListener(this);
        this.fMX.setOnClickListener(this);
        this.fMY.setOnClickListener(this);
        this.fMV.setOnClickListener(this);
        this.cKV = view2.findViewById(d.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
        ak.h(this.fMU, d.C0126d.cp_cont_b);
        ak.h(this.fMV, d.C0126d.cp_cont_d);
        ak.j(this.cKV, d.C0126d.cp_bg_line_e);
        ak.c(this.fMZ, d.f.icon_mine_list_arrow);
        f(this.fMW);
        f(this.fMX);
        f(this.fMY);
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
        db(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.fMP.setVisibility(8);
            return;
        }
        this.fMP.setVisibility(0);
        this.fMP.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.fMQ.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.fMR.setBackgroundResource(d.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.fMR.setBackgroundResource(d.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.fMR.setBackgroundResource(d.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.fMR.setBackgroundResource(d.f.shape_ala_grade_4_orange);
        } else {
            this.fMR.setBackgroundResource(d.f.shape_ala_grade_5_purple);
        }
        this.fMS.setText(ro(String.valueOf(i)));
    }

    private void db(List<AlaLiveInfoCoreData> list) {
        if (v.w(list)) {
            this.fMT.setVisibility(8);
            return;
        }
        this.fMT.setVisibility(0);
        this.fMX.setVisibility(0);
        this.fMY.setVisibility(0);
        this.fMW.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.fMV.setVisibility(0);
            this.fMZ.setVisibility(0);
        } else {
            this.fMV.setVisibility(4);
            this.fMZ.setVisibility(4);
        }
        a(list.get(0), this.fMW);
        if (size >= 3) {
            a(list.get(1), this.fMX);
            a(list.get(2), this.fMY);
        } else if (size >= 2) {
            a(list.get(1), this.fMX);
            this.fMY.setVisibility(4);
        } else {
            this.fMX.setVisibility(4);
            this.fMY.setVisibility(4);
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

    private SpannableStringBuilder ro(String str) {
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
        if (view2 == this.fMP) {
            if (this.fMP.getTag() != null && (this.fMP.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.fMP.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new al("c12544"));
            }
        } else if (view2 == this.fMW) {
            bo(this.fMW);
        } else if (view2 == this.fMX) {
            bo(this.fMX);
        } else if (view2 == this.fMY) {
            bo(this.fMY);
        } else if (view2 == this.fMV) {
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
