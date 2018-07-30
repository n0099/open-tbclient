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
    private View cUP;
    private LinearLayout gcA;
    private LinearLayout gcB;
    private LinearLayout gcC;
    private ImageView gcD;
    private FrameLayout gct;
    private TbImageView gcu;
    private TbImageView gcv;
    private TextView gcw;
    private LinearLayout gcx;
    private TextView gcy;
    private TextView gcz;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        Y(ahb());
    }

    private void Y(View view) {
        this.gct = (FrameLayout) view.findViewById(d.g.ala_entrance_root);
        this.gcu = (TbImageView) view.findViewById(d.g.entrance_background);
        this.gcu.setAutoChangeStyle(false);
        this.gcu.setDrawerType(1);
        this.gcu.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds10));
        this.gcv = (TbImageView) view.findViewById(d.g.live_level_img);
        this.gcv.setAutoChangeStyle(false);
        this.gcv.setDrawerType(1);
        this.gcv.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds10));
        this.gcw = (TextView) view.findViewById(d.g.live_level_text);
        this.gcx = (LinearLayout) view.findViewById(d.g.replay_root);
        this.gcz = (TextView) this.gcx.findViewById(d.g.tv_replay_more);
        this.gcD = (ImageView) this.gcx.findViewById(d.g.replay_more_arrow);
        this.gcy = (TextView) this.gcx.findViewById(d.g.tv_replay_tile);
        this.gcA = (LinearLayout) this.gcx.findViewById(d.g.replay_item_one);
        this.gcB = (LinearLayout) this.gcx.findViewById(d.g.replay_item_two);
        this.gcC = (LinearLayout) this.gcx.findViewById(d.g.replay_item_three);
        f(this.gcA);
        f(this.gcB);
        f(this.gcC);
        this.gct.setOnClickListener(this);
        this.gcA.setOnClickListener(this);
        this.gcB.setOnClickListener(this);
        this.gcC.setOnClickListener(this);
        this.gcz.setOnClickListener(this);
        this.cUP = view.findViewById(d.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        am.j(this.mRootView, d.C0140d.cp_bg_line_d);
        am.h(this.gcy, d.C0140d.cp_cont_b);
        am.h(this.gcz, d.C0140d.cp_cont_d);
        am.j(this.cUP, d.C0140d.cp_bg_line_e);
        am.c(this.gcD, d.f.icon_mine_list_arrow);
        g(this.gcA);
        g(this.gcB);
        g(this.gcC);
    }

    public View ahb() {
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
            this.gct.setVisibility(8);
            return;
        }
        this.gct.setVisibility(0);
        this.gct.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.gcu.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.gcv.setBackgroundResource(d.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.gcv.setBackgroundResource(d.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.gcv.setBackgroundResource(d.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.gcv.setBackgroundResource(d.f.shape_ala_grade_4_orange);
        } else {
            this.gcv.setBackgroundResource(d.f.shape_ala_grade_5_purple);
        }
        this.gcw.setText(rY(String.valueOf(i)));
    }

    private void dg(List<AlaLiveInfoCoreData> list) {
        if (w.z(list)) {
            this.gcx.setVisibility(8);
            return;
        }
        this.gcx.setVisibility(0);
        this.gcB.setVisibility(0);
        this.gcC.setVisibility(0);
        this.gcA.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.gcz.setVisibility(0);
            this.gcD.setVisibility(0);
        } else {
            this.gcz.setVisibility(4);
            this.gcD.setVisibility(4);
        }
        a(list.get(0), this.gcA);
        if (size >= 3) {
            a(list.get(1), this.gcB);
            a(list.get(2), this.gcC);
        } else if (size >= 2) {
            a(list.get(1), this.gcB);
            this.gcC.setVisibility(4);
        } else {
            this.gcB.setVisibility(4);
            this.gcC.setVisibility(4);
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
        am.h((TextView) linearLayout.findViewById(d.g.replay_item_title), d.C0140d.cp_cont_b);
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

    private SpannableStringBuilder rY(String str) {
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
        if (view == this.gct) {
            if (this.gct.getTag() != null && (this.gct.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.gct.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new an("c12544"));
            }
        } else if (view == this.gcA) {
            bv(this.gcA);
        } else if (view == this.gcB) {
            bv(this.gcB);
        } else if (view == this.gcC) {
            bv(this.gcC);
        } else if (view == this.gcz) {
            bjG();
        }
    }

    private void bv(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void bjG() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
