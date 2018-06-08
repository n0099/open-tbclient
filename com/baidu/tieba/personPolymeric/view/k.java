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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class k implements View.OnClickListener {
    private View cUb;
    private FrameLayout fYb;
    private TbImageView fYc;
    private TbImageView fYd;
    private TextView fYe;
    private LinearLayout fYf;
    private TextView fYg;
    private TextView fYh;
    private LinearLayout fYi;
    private LinearLayout fYj;
    private LinearLayout fYk;
    private ImageView fYl;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        Y(aga());
    }

    private void Y(View view) {
        this.fYb = (FrameLayout) view.findViewById(d.g.ala_entrance_root);
        this.fYc = (TbImageView) view.findViewById(d.g.entrance_background);
        this.fYc.setAutoChangeStyle(false);
        this.fYc.setDrawerType(1);
        this.fYc.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds10));
        this.fYd = (TbImageView) view.findViewById(d.g.live_level_img);
        this.fYd.setAutoChangeStyle(false);
        this.fYd.setDrawerType(1);
        this.fYd.setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds10));
        this.fYe = (TextView) view.findViewById(d.g.live_level_text);
        this.fYf = (LinearLayout) view.findViewById(d.g.replay_root);
        this.fYh = (TextView) this.fYf.findViewById(d.g.tv_replay_more);
        this.fYl = (ImageView) this.fYf.findViewById(d.g.replay_more_arrow);
        this.fYg = (TextView) this.fYf.findViewById(d.g.tv_replay_tile);
        this.fYi = (LinearLayout) this.fYf.findViewById(d.g.replay_item_one);
        this.fYj = (LinearLayout) this.fYf.findViewById(d.g.replay_item_two);
        this.fYk = (LinearLayout) this.fYf.findViewById(d.g.replay_item_three);
        f(this.fYi);
        f(this.fYj);
        f(this.fYk);
        this.fYb.setOnClickListener(this);
        this.fYi.setOnClickListener(this);
        this.fYj.setOnClickListener(this);
        this.fYk.setOnClickListener(this);
        this.fYh.setOnClickListener(this);
        this.cUb = view.findViewById(d.g.divider_view);
    }

    public void onChangeSkinType(int i) {
        al.j(this.mRootView, d.C0141d.cp_bg_line_d);
        al.h(this.fYg, d.C0141d.cp_cont_b);
        al.h(this.fYh, d.C0141d.cp_cont_d);
        al.j(this.cUb, d.C0141d.cp_bg_line_e);
        al.c(this.fYl, d.f.icon_mine_list_arrow);
        g(this.fYi);
        g(this.fYj);
        g(this.fYk);
    }

    public View aga() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.item_person_center_ala_live, (ViewGroup) null);
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
            this.fYb.setVisibility(8);
            return;
        }
        this.fYb.setVisibility(0);
        this.fYb.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.fYc.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.fYd.setBackgroundResource(d.f.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.fYd.setBackgroundResource(d.f.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.fYd.setBackgroundResource(d.f.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.fYd.setBackgroundResource(d.f.shape_ala_grade_4_orange);
        } else {
            this.fYd.setBackgroundResource(d.f.shape_ala_grade_5_purple);
        }
        this.fYe.setText(sf(String.valueOf(i)));
    }

    private void dg(List<AlaLiveInfoCoreData> list) {
        if (w.z(list)) {
            this.fYf.setVisibility(8);
            return;
        }
        this.fYf.setVisibility(0);
        this.fYj.setVisibility(0);
        this.fYk.setVisibility(0);
        this.fYi.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.fYh.setVisibility(0);
            this.fYl.setVisibility(0);
        } else {
            this.fYh.setVisibility(4);
            this.fYl.setVisibility(4);
        }
        a(list.get(0), this.fYi);
        if (size >= 3) {
            a(list.get(1), this.fYj);
            a(list.get(2), this.fYk);
        } else if (size >= 2) {
            a(list.get(1), this.fYj);
            this.fYk.setVisibility(4);
        } else {
            this.fYj.setVisibility(4);
            this.fYk.setVisibility(4);
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
        al.h((TextView) linearLayout.findViewById(d.g.replay_item_title), d.C0141d.cp_cont_b);
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

    private SpannableStringBuilder sf(String str) {
        String string = this.mPageContext.getResources().getString(d.k.ala_live_entrance_level_text_pre);
        String str2 = string + String.format(this.mPageContext.getResources().getString(d.k.ala_live_entrance_level_text_content), str);
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
        if (view == this.fYb) {
            if (this.fYb.getTag() != null && (this.fYb.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.fYb.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new am("c12544"));
            }
        } else if (view == this.fYi) {
            br(this.fYi);
        } else if (view == this.fYj) {
            br(this.fYj);
        } else if (view == this.fYk) {
            br(this.fYk);
        } else if (view == this.fYh) {
            bkH();
        }
    }

    private void br(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void bkH() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
