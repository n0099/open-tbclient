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
    private LinearLayout gCA;
    private ImageView gCB;
    private FrameLayout gCr;
    private TbImageView gCs;
    private TbImageView gCt;
    private TextView gCu;
    private LinearLayout gCv;
    private TextView gCw;
    private TextView gCx;
    private LinearLayout gCy;
    private LinearLayout gCz;
    private View mDividerView;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        initView(anC());
    }

    private void initView(View view) {
        this.gCr = (FrameLayout) view.findViewById(e.g.ala_entrance_root);
        this.gCs = (TbImageView) view.findViewById(e.g.entrance_background);
        this.gCs.setAutoChangeStyle(false);
        this.gCs.setDrawerType(1);
        this.gCs.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds10));
        this.gCt = (TbImageView) view.findViewById(e.g.live_level_img);
        this.gCt.setAutoChangeStyle(false);
        this.gCt.setDrawerType(1);
        this.gCt.setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds10));
        this.gCu = (TextView) view.findViewById(e.g.live_level_text);
        this.gCv = (LinearLayout) view.findViewById(e.g.replay_root);
        this.gCx = (TextView) this.gCv.findViewById(e.g.tv_replay_more);
        this.gCB = (ImageView) this.gCv.findViewById(e.g.replay_more_arrow);
        this.gCw = (TextView) this.gCv.findViewById(e.g.tv_replay_tile);
        this.gCy = (LinearLayout) this.gCv.findViewById(e.g.replay_item_one);
        this.gCz = (LinearLayout) this.gCv.findViewById(e.g.replay_item_two);
        this.gCA = (LinearLayout) this.gCv.findViewById(e.g.replay_item_three);
        g(this.gCy);
        g(this.gCz);
        g(this.gCA);
        this.gCr.setOnClickListener(this);
        this.gCy.setOnClickListener(this);
        this.gCz.setOnClickListener(this);
        this.gCA.setOnClickListener(this);
        this.gCx.setOnClickListener(this);
        this.mDividerView = view.findViewById(e.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        al.j(this.mRootView, e.d.cp_bg_line_d);
        al.h(this.gCw, e.d.cp_cont_b);
        al.h(this.gCx, e.d.cp_cont_d);
        al.j(this.mDividerView, e.d.cp_bg_line_e);
        al.c(this.gCB, e.f.icon_mine_list_arrow);
        h(this.gCy);
        h(this.gCz);
        h(this.gCA);
    }

    public View anC() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        dy(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.gCr.setVisibility(8);
            return;
        }
        this.gCr.setVisibility(0);
        this.gCr.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.gCs.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.gCt.setBackgroundResource(e.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.gCt.setBackgroundResource(e.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.gCt.setBackgroundResource(e.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.gCt.setBackgroundResource(e.f.shape_ala_grade_4_orange);
        } else {
            this.gCt.setBackgroundResource(e.f.shape_ala_grade_5_purple);
        }
        this.gCu.setText(tS(String.valueOf(i)));
    }

    private void dy(List<AlaLiveInfoCoreData> list) {
        if (v.I(list)) {
            this.gCv.setVisibility(8);
            return;
        }
        this.gCv.setVisibility(0);
        this.gCz.setVisibility(0);
        this.gCA.setVisibility(0);
        this.gCy.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.gCx.setVisibility(0);
            this.gCB.setVisibility(0);
        } else {
            this.gCx.setVisibility(4);
            this.gCB.setVisibility(4);
        }
        a(list.get(0), this.gCy);
        if (size >= 3) {
            a(list.get(1), this.gCz);
            a(list.get(2), this.gCA);
        } else if (size >= 2) {
            a(list.get(1), this.gCz);
            this.gCA.setVisibility(4);
        } else {
            this.gCz.setVisibility(4);
            this.gCA.setVisibility(4);
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

    private SpannableStringBuilder tS(String str) {
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
        if (view == this.gCr) {
            if (this.gCr.getTag() != null && (this.gCr.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.gCr.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new am("c12544"));
            }
        } else if (view == this.gCy) {
            bN(this.gCy);
        } else if (view == this.gCz) {
            bN(this.gCz);
        } else if (view == this.gCA) {
            bN(this.gCA);
        } else if (view == this.gCx) {
            bro();
        }
    }

    private void bN(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void bro() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
