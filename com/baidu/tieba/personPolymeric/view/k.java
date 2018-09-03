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
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class k implements View.OnClickListener {
    private View cUL;
    private LinearLayout gcA;
    private LinearLayout gcB;
    private ImageView gcC;
    private FrameLayout gcs;
    private TbImageView gct;
    private TbImageView gcu;
    private TextView gcv;
    private LinearLayout gcw;
    private TextView gcx;
    private TextView gcy;
    private LinearLayout gcz;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        Y(ahd());
    }

    private void Y(View view) {
        this.gcs = (FrameLayout) view.findViewById(f.g.ala_entrance_root);
        this.gct = (TbImageView) view.findViewById(f.g.entrance_background);
        this.gct.setAutoChangeStyle(false);
        this.gct.setDrawerType(1);
        this.gct.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), f.e.ds10));
        this.gcu = (TbImageView) view.findViewById(f.g.live_level_img);
        this.gcu.setAutoChangeStyle(false);
        this.gcu.setDrawerType(1);
        this.gcu.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), f.e.ds10));
        this.gcv = (TextView) view.findViewById(f.g.live_level_text);
        this.gcw = (LinearLayout) view.findViewById(f.g.replay_root);
        this.gcy = (TextView) this.gcw.findViewById(f.g.tv_replay_more);
        this.gcC = (ImageView) this.gcw.findViewById(f.g.replay_more_arrow);
        this.gcx = (TextView) this.gcw.findViewById(f.g.tv_replay_tile);
        this.gcz = (LinearLayout) this.gcw.findViewById(f.g.replay_item_one);
        this.gcA = (LinearLayout) this.gcw.findViewById(f.g.replay_item_two);
        this.gcB = (LinearLayout) this.gcw.findViewById(f.g.replay_item_three);
        f(this.gcz);
        f(this.gcA);
        f(this.gcB);
        this.gcs.setOnClickListener(this);
        this.gcz.setOnClickListener(this);
        this.gcA.setOnClickListener(this);
        this.gcB.setOnClickListener(this);
        this.gcy.setOnClickListener(this);
        this.cUL = view.findViewById(f.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        am.j(this.mRootView, f.d.cp_bg_line_d);
        am.h(this.gcx, f.d.cp_cont_b);
        am.h(this.gcy, f.d.cp_cont_d);
        am.j(this.cUL, f.d.cp_bg_line_e);
        am.c(this.gcC, f.C0146f.icon_mine_list_arrow);
        g(this.gcz);
        g(this.gcA);
        g(this.gcB);
    }

    public View ahd() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(f.h.item_person_center_ala_live, (ViewGroup) null);
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
            this.gcs.setVisibility(8);
            return;
        }
        this.gcs.setVisibility(0);
        this.gcs.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.gct.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.gcu.setBackgroundResource(f.C0146f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.gcu.setBackgroundResource(f.C0146f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.gcu.setBackgroundResource(f.C0146f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.gcu.setBackgroundResource(f.C0146f.shape_ala_grade_4_orange);
        } else {
            this.gcu.setBackgroundResource(f.C0146f.shape_ala_grade_5_purple);
        }
        this.gcv.setText(sb(String.valueOf(i)));
    }

    private void dg(List<AlaLiveInfoCoreData> list) {
        if (w.z(list)) {
            this.gcw.setVisibility(8);
            return;
        }
        this.gcw.setVisibility(0);
        this.gcA.setVisibility(0);
        this.gcB.setVisibility(0);
        this.gcz.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.gcy.setVisibility(0);
            this.gcC.setVisibility(0);
        } else {
            this.gcy.setVisibility(4);
            this.gcC.setVisibility(4);
        }
        a(list.get(0), this.gcz);
        if (size >= 3) {
            a(list.get(1), this.gcA);
            a(list.get(2), this.gcB);
        } else if (size >= 2) {
            a(list.get(1), this.gcA);
            this.gcB.setVisibility(4);
        } else {
            this.gcA.setVisibility(4);
            this.gcB.setVisibility(4);
        }
    }

    private void f(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(f.e.ds34);
        layoutParams.width = ((com.baidu.adp.lib.util.l.ah(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(f.e.ds16) * 2)) - (dimensionPixelSize * 2)) / 3;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    private void g(LinearLayout linearLayout) {
        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(f.g.replay_item_cover);
        tbImageView.setAutoChangeStyle(true);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        am.h((TextView) linearLayout.findViewById(f.g.replay_item_title), f.d.cp_cont_b);
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, LinearLayout linearLayout) {
        if (alaLiveInfoCoreData != null && linearLayout != null) {
            linearLayout.setTag(alaLiveInfoCoreData);
            TextView textView = (TextView) linearLayout.findViewById(f.g.replay_item_title);
            if (textView != null) {
                if (!StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                    textView.setText(alaLiveInfoCoreData.liveTitle);
                } else if (this.mIsHost) {
                    textView.setText(this.mPageContext.getString(f.j.wo_replay));
                } else {
                    textView.setText(this.mPageContext.getString(f.j.ta_replay));
                }
            }
            TbImageView tbImageView = (TbImageView) linearLayout.findViewById(f.g.replay_item_cover);
            if (tbImageView != null && !StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
                tbImageView.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
            }
        }
    }

    private SpannableStringBuilder sb(String str) {
        String string = this.mPageContext.getResources().getString(f.j.ala_live_entrance_level_text_pre);
        String str2 = string + String.format(this.mPageContext.getResources().getString(f.j.ala_live_entrance_level_text_content), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int color = this.mPageContext.getResources().getColor(f.d.cp_cont_g);
        int parseColor = Color.parseColor("#FFD026");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, string.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), string.length(), string.length() + str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), string.length() + str.length(), str2.length(), 18);
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gcs) {
            if (this.gcs.getTag() != null && (this.gcs.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.gcs.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new an("c12544"));
            }
        } else if (view == this.gcz) {
            bv(this.gcz);
        } else if (view == this.gcA) {
            bv(this.gcA);
        } else if (view == this.gcB) {
            bv(this.gcB);
        } else if (view == this.gcy) {
            bjD();
        }
    }

    private void bv(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void bjD() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
