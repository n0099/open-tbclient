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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class k implements View.OnClickListener {
    private View bpR;
    private FrameLayout ilY;
    private TbImageView ilZ;
    private TbImageView ima;
    private TextView imb;
    private LinearLayout imc;
    private TextView imd;
    private TextView ime;
    private LinearLayout imf;
    private LinearLayout imh;
    private LinearLayout imi;
    private ImageView imj;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        O(aUW());
    }

    private void O(View view) {
        this.ilY = (FrameLayout) view.findViewById(R.id.ala_entrance_root);
        this.ilZ = (TbImageView) view.findViewById(R.id.entrance_background);
        this.ilZ.setAutoChangeStyle(false);
        this.ilZ.setDrawerType(1);
        this.ilZ.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds10));
        this.ima = (TbImageView) view.findViewById(R.id.live_level_img);
        this.ima.setAutoChangeStyle(false);
        this.ima.setDrawerType(1);
        this.ima.setRadius(com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds10));
        this.imb = (TextView) view.findViewById(R.id.live_level_text);
        this.imc = (LinearLayout) view.findViewById(R.id.replay_root);
        this.ime = (TextView) this.imc.findViewById(R.id.tv_replay_more);
        this.imj = (ImageView) this.imc.findViewById(R.id.replay_more_arrow);
        this.imd = (TextView) this.imc.findViewById(R.id.tv_replay_tile);
        this.imf = (LinearLayout) this.imc.findViewById(R.id.replay_item_one);
        this.imh = (LinearLayout) this.imc.findViewById(R.id.replay_item_two);
        this.imi = (LinearLayout) this.imc.findViewById(R.id.replay_item_three);
        g(this.imf);
        g(this.imh);
        g(this.imi);
        this.ilY.setOnClickListener(this);
        this.imf.setOnClickListener(this);
        this.imh.setOnClickListener(this);
        this.imi.setOnClickListener(this);
        this.ime.setOnClickListener(this);
        this.bpR = view.findViewById(R.id.divider_view);
    }

    public void onChangeSkinType(int i) {
        al.l(this.mRootView, R.color.cp_bg_line_d);
        al.j(this.imd, R.color.cp_cont_b);
        al.j(this.ime, R.color.cp_cont_d);
        al.l(this.bpR, R.color.cp_bg_line_e);
        al.c(this.imj, (int) R.drawable.icon_mine_list_arrow);
        h(this.imf);
        h(this.imh);
        h(this.imi);
    }

    public View aUW() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        dU(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.ilY.setVisibility(8);
            return;
        }
        this.ilY.setVisibility(0);
        this.ilY.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.ilZ.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.ima.setBackgroundResource(R.drawable.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.ima.setBackgroundResource(R.drawable.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.ima.setBackgroundResource(R.drawable.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.ima.setBackgroundResource(R.drawable.shape_ala_grade_4_orange);
        } else {
            this.ima.setBackgroundResource(R.drawable.shape_ala_grade_5_purple);
        }
        this.imb.setText(Cf(String.valueOf(i)));
    }

    private void dU(List<AlaLiveInfoCoreData> list) {
        if (v.aa(list)) {
            this.imc.setVisibility(8);
            return;
        }
        this.imc.setVisibility(0);
        this.imh.setVisibility(0);
        this.imi.setVisibility(0);
        this.imf.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.ime.setVisibility(0);
            this.imj.setVisibility(0);
        } else {
            this.ime.setVisibility(4);
            this.imj.setVisibility(4);
        }
        a(list.get(0), this.imf);
        if (size >= 3) {
            a(list.get(1), this.imh);
            a(list.get(2), this.imi);
        } else if (size >= 2) {
            a(list.get(1), this.imh);
            this.imi.setVisibility(4);
        } else {
            this.imh.setVisibility(4);
            this.imi.setVisibility(4);
        }
    }

    private void g(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds34);
        layoutParams.width = ((com.baidu.adp.lib.util.l.af(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) - (dimensionPixelSize * 2)) / 3;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    private void h(LinearLayout linearLayout) {
        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(R.id.replay_item_cover);
        tbImageView.setAutoChangeStyle(true);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        al.j((TextView) linearLayout.findViewById(R.id.replay_item_title), R.color.cp_cont_b);
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, LinearLayout linearLayout) {
        if (alaLiveInfoCoreData != null && linearLayout != null) {
            linearLayout.setTag(alaLiveInfoCoreData);
            TextView textView = (TextView) linearLayout.findViewById(R.id.replay_item_title);
            if (textView != null) {
                if (!StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                    textView.setText(alaLiveInfoCoreData.liveTitle);
                } else if (this.mIsHost) {
                    textView.setText(this.mPageContext.getString(R.string.wo_replay));
                } else {
                    textView.setText(this.mPageContext.getString(R.string.ta_replay));
                }
            }
            TbImageView tbImageView = (TbImageView) linearLayout.findViewById(R.id.replay_item_cover);
            if (tbImageView != null && !StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
                tbImageView.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
            }
        }
    }

    private SpannableStringBuilder Cf(String str) {
        String string = this.mPageContext.getResources().getString(R.string.ala_live_entrance_level_text_pre);
        String str2 = string + String.format(this.mPageContext.getResources().getString(R.string.ala_live_entrance_level_text_content), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int color = this.mPageContext.getResources().getColor(R.color.cp_cont_g);
        int parseColor = Color.parseColor("#FFD026");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, string.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), string.length(), string.length() + str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), string.length() + str.length(), str2.length(), 18);
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ilY) {
            if (this.ilY.getTag() != null && (this.ilY.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.ilY.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921315, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new am("c12544"));
            }
        } else if (view == this.imf) {
            cI(this.imf);
        } else if (view == this.imh) {
            cI(this.imh);
        } else if (view == this.imi) {
            cI(this.imi);
        } else if (view == this.ime) {
            caw();
        }
    }

    private void cI(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void caw() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
