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
    private TextView gDA;
    private TextView gDB;
    private LinearLayout gDC;
    private LinearLayout gDD;
    private LinearLayout gDE;
    private ImageView gDF;
    private FrameLayout gDv;
    private TbImageView gDw;
    private TbImageView gDx;
    private TextView gDy;
    private LinearLayout gDz;
    private View mDividerView;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        initView(anZ());
    }

    private void initView(View view) {
        this.gDv = (FrameLayout) view.findViewById(e.g.ala_entrance_root);
        this.gDw = (TbImageView) view.findViewById(e.g.entrance_background);
        this.gDw.setAutoChangeStyle(false);
        this.gDw.setDrawerType(1);
        this.gDw.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds10));
        this.gDx = (TbImageView) view.findViewById(e.g.live_level_img);
        this.gDx.setAutoChangeStyle(false);
        this.gDx.setDrawerType(1);
        this.gDx.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds10));
        this.gDy = (TextView) view.findViewById(e.g.live_level_text);
        this.gDz = (LinearLayout) view.findViewById(e.g.replay_root);
        this.gDB = (TextView) this.gDz.findViewById(e.g.tv_replay_more);
        this.gDF = (ImageView) this.gDz.findViewById(e.g.replay_more_arrow);
        this.gDA = (TextView) this.gDz.findViewById(e.g.tv_replay_tile);
        this.gDC = (LinearLayout) this.gDz.findViewById(e.g.replay_item_one);
        this.gDD = (LinearLayout) this.gDz.findViewById(e.g.replay_item_two);
        this.gDE = (LinearLayout) this.gDz.findViewById(e.g.replay_item_three);
        g(this.gDC);
        g(this.gDD);
        g(this.gDE);
        this.gDv.setOnClickListener(this);
        this.gDC.setOnClickListener(this);
        this.gDD.setOnClickListener(this);
        this.gDE.setOnClickListener(this);
        this.gDB.setOnClickListener(this);
        this.mDividerView = view.findViewById(e.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
        al.h(this.gDA, e.d.cp_cont_b);
        al.h(this.gDB, e.d.cp_cont_d);
        al.j(this.mDividerView, e.d.cp_bg_line_e);
        al.c(this.gDF, e.f.icon_mine_list_arrow);
        h(this.gDC);
        h(this.gDD);
        h(this.gDE);
    }

    public View anZ() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        dz(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.gDv.setVisibility(8);
            return;
        }
        this.gDv.setVisibility(0);
        this.gDv.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.gDw.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.gDx.setBackgroundResource(e.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.gDx.setBackgroundResource(e.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.gDx.setBackgroundResource(e.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.gDx.setBackgroundResource(e.f.shape_ala_grade_4_orange);
        } else {
            this.gDx.setBackgroundResource(e.f.shape_ala_grade_5_purple);
        }
        this.gDy.setText(ui(String.valueOf(i)));
    }

    private void dz(List<AlaLiveInfoCoreData> list) {
        if (v.I(list)) {
            this.gDz.setVisibility(8);
            return;
        }
        this.gDz.setVisibility(0);
        this.gDD.setVisibility(0);
        this.gDE.setVisibility(0);
        this.gDC.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.gDB.setVisibility(0);
            this.gDF.setVisibility(0);
        } else {
            this.gDB.setVisibility(4);
            this.gDF.setVisibility(4);
        }
        a(list.get(0), this.gDC);
        if (size >= 3) {
            a(list.get(1), this.gDD);
            a(list.get(2), this.gDE);
        } else if (size >= 2) {
            a(list.get(1), this.gDD);
            this.gDE.setVisibility(4);
        } else {
            this.gDD.setVisibility(4);
            this.gDE.setVisibility(4);
        }
    }

    private void g(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds34);
        layoutParams.width = ((com.baidu.adp.lib.util.l.aO(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds16) * 2)) - (dimensionPixelSize * 2)) / 3;
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

    private SpannableStringBuilder ui(String str) {
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
        if (view == this.gDv) {
            if (this.gDv.getTag() != null && (this.gDv.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.gDv.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new am("c12544"));
            }
        } else if (view == this.gDC) {
            bN(this.gDC);
        } else if (view == this.gDD) {
            bN(this.gDD);
        } else if (view == this.gDE) {
            bN(this.gDE);
        } else if (view == this.gDB) {
            brX();
        }
    }

    private void bN(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void brX() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
