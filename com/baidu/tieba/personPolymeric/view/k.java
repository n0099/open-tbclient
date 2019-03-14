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
    private View bjK;
    private TextView hTA;
    private TextView hTB;
    private LinearLayout hTC;
    private LinearLayout hTD;
    private LinearLayout hTE;
    private ImageView hTF;
    private FrameLayout hTv;
    private TbImageView hTw;
    private TbImageView hTx;
    private TextView hTy;
    private LinearLayout hTz;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        O(aOM());
    }

    private void O(View view) {
        this.hTv = (FrameLayout) view.findViewById(d.g.ala_entrance_root);
        this.hTw = (TbImageView) view.findViewById(d.g.entrance_background);
        this.hTw.setAutoChangeStyle(false);
        this.hTw.setDrawerType(1);
        this.hTw.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds10));
        this.hTx = (TbImageView) view.findViewById(d.g.live_level_img);
        this.hTx.setAutoChangeStyle(false);
        this.hTx.setDrawerType(1);
        this.hTx.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.ds10));
        this.hTy = (TextView) view.findViewById(d.g.live_level_text);
        this.hTz = (LinearLayout) view.findViewById(d.g.replay_root);
        this.hTB = (TextView) this.hTz.findViewById(d.g.tv_replay_more);
        this.hTF = (ImageView) this.hTz.findViewById(d.g.replay_more_arrow);
        this.hTA = (TextView) this.hTz.findViewById(d.g.tv_replay_tile);
        this.hTC = (LinearLayout) this.hTz.findViewById(d.g.replay_item_one);
        this.hTD = (LinearLayout) this.hTz.findViewById(d.g.replay_item_two);
        this.hTE = (LinearLayout) this.hTz.findViewById(d.g.replay_item_three);
        g(this.hTC);
        g(this.hTD);
        g(this.hTE);
        this.hTv.setOnClickListener(this);
        this.hTC.setOnClickListener(this);
        this.hTD.setOnClickListener(this);
        this.hTE.setOnClickListener(this);
        this.hTB.setOnClickListener(this);
        this.bjK = view.findViewById(d.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
        al.j(this.hTA, d.C0277d.cp_cont_b);
        al.j(this.hTB, d.C0277d.cp_cont_d);
        al.l(this.bjK, d.C0277d.cp_bg_line_e);
        al.c(this.hTF, d.f.icon_mine_list_arrow);
        h(this.hTC);
        h(this.hTD);
        h(this.hTE);
    }

    public View aOM() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        dN(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.hTv.setVisibility(8);
            return;
        }
        this.hTv.setVisibility(0);
        this.hTv.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.hTw.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.hTx.setBackgroundResource(d.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.hTx.setBackgroundResource(d.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.hTx.setBackgroundResource(d.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.hTx.setBackgroundResource(d.f.shape_ala_grade_4_orange);
        } else {
            this.hTx.setBackgroundResource(d.f.shape_ala_grade_5_purple);
        }
        this.hTy.setText(AM(String.valueOf(i)));
    }

    private void dN(List<AlaLiveInfoCoreData> list) {
        if (v.T(list)) {
            this.hTz.setVisibility(8);
            return;
        }
        this.hTz.setVisibility(0);
        this.hTD.setVisibility(0);
        this.hTE.setVisibility(0);
        this.hTC.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.hTB.setVisibility(0);
            this.hTF.setVisibility(0);
        } else {
            this.hTB.setVisibility(4);
            this.hTF.setVisibility(4);
        }
        a(list.get(0), this.hTC);
        if (size >= 3) {
            a(list.get(1), this.hTD);
            a(list.get(2), this.hTE);
        } else if (size >= 2) {
            a(list.get(1), this.hTD);
            this.hTE.setVisibility(4);
        } else {
            this.hTD.setVisibility(4);
            this.hTE.setVisibility(4);
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

    private SpannableStringBuilder AM(String str) {
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
        if (view == this.hTv) {
            if (this.hTv.getTag() != null && (this.hTv.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.hTv.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new am("c12544"));
            }
        } else if (view == this.hTC) {
            cA(this.hTC);
        } else if (view == this.hTD) {
            cA(this.hTD);
        } else if (view == this.hTE) {
            cA(this.hTE);
        } else if (view == this.hTB) {
            bSv();
        }
    }

    private void cA(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void bSv() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
