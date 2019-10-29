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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class k implements View.OnClickListener {
    private View bJN;
    private FrameLayout itU;
    private TbImageView itV;
    private TbImageView itW;
    private TextView itX;
    private LinearLayout itY;
    private TextView itZ;
    private TextView iua;
    private LinearLayout iub;
    private LinearLayout iuc;
    private LinearLayout iud;
    private ImageView iue;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        W(aMx());
    }

    private void W(View view) {
        this.itU = (FrameLayout) view.findViewById(R.id.ala_entrance_root);
        this.itV = (TbImageView) view.findViewById(R.id.entrance_background);
        this.itV.setAutoChangeStyle(false);
        this.itV.setDrawerType(1);
        this.itV.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10));
        this.itW = (TbImageView) view.findViewById(R.id.live_level_img);
        this.itW.setAutoChangeStyle(false);
        this.itW.setDrawerType(1);
        this.itW.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10));
        this.itX = (TextView) view.findViewById(R.id.live_level_text);
        this.itY = (LinearLayout) view.findViewById(R.id.replay_root);
        this.iua = (TextView) this.itY.findViewById(R.id.tv_replay_more);
        this.iue = (ImageView) this.itY.findViewById(R.id.replay_more_arrow);
        this.itZ = (TextView) this.itY.findViewById(R.id.tv_replay_tile);
        this.iub = (LinearLayout) this.itY.findViewById(R.id.replay_item_one);
        this.iuc = (LinearLayout) this.itY.findViewById(R.id.replay_item_two);
        this.iud = (LinearLayout) this.itY.findViewById(R.id.replay_item_three);
        g(this.iub);
        g(this.iuc);
        g(this.iud);
        this.itU.setOnClickListener(this);
        this.iub.setOnClickListener(this);
        this.iuc.setOnClickListener(this);
        this.iud.setOnClickListener(this);
        this.iua.setOnClickListener(this);
        this.bJN = view.findViewById(R.id.divider_view);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.itZ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iua, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.bJN, R.color.cp_bg_line_e);
        am.setImageResource(this.iue, R.drawable.icon_mine_list_arrow);
        h(this.iub);
        h(this.iuc);
        h(this.iud);
    }

    public View aMx() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.item_person_center_ala_live, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData, List<AlaLiveInfoCoreData> list) {
        this.mIsHost = z;
        this.mUserData = userData;
        a(alaLiveInfoCoreData, z, userData);
        ei(list);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AlaLiveInfoCoreData alaLiveInfoCoreData, boolean z, UserData userData) {
        if (z || alaLiveInfoCoreData == null || alaLiveInfoCoreData.liveStatus != 1 || userData == null || userData.alaUserData == null || StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.itU.setVisibility(8);
            return;
        }
        this.itU.setVisibility(0);
        this.itU.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.itV.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.itW.setBackgroundResource(R.drawable.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.itW.setBackgroundResource(R.drawable.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.itW.setBackgroundResource(R.drawable.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.itW.setBackgroundResource(R.drawable.shape_ala_grade_4_orange);
        } else {
            this.itW.setBackgroundResource(R.drawable.shape_ala_grade_5_purple);
        }
        this.itX.setText(BL(String.valueOf(i)));
    }

    private void ei(List<AlaLiveInfoCoreData> list) {
        if (v.isEmpty(list)) {
            this.itY.setVisibility(8);
            return;
        }
        this.itY.setVisibility(0);
        this.iuc.setVisibility(0);
        this.iud.setVisibility(0);
        this.iub.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.iua.setVisibility(0);
            this.iue.setVisibility(0);
        } else {
            this.iua.setVisibility(4);
            this.iue.setVisibility(4);
        }
        a(list.get(0), this.iub);
        if (size >= 3) {
            a(list.get(1), this.iuc);
            a(list.get(2), this.iud);
        } else if (size >= 2) {
            a(list.get(1), this.iuc);
            this.iud.setVisibility(4);
        } else {
            this.iuc.setVisibility(4);
            this.iud.setVisibility(4);
        }
    }

    private void g(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds34);
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mPageContext.getPageActivity()) - (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) - (dimensionPixelSize * 2)) / 3;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    private void h(LinearLayout linearLayout) {
        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(R.id.replay_item_cover);
        tbImageView.setAutoChangeStyle(true);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        am.setViewTextColor((TextView) linearLayout.findViewById(R.id.replay_item_title), (int) R.color.cp_cont_b);
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

    private SpannableStringBuilder BL(String str) {
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
        if (view == this.itU) {
            if (this.itU.getTag() != null && (this.itU.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.itU.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_ALA_ENTRANCE_LIVE_ID, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new an("c12544"));
            }
        } else if (view == this.iub) {
            cJ(this.iub);
        } else if (view == this.iuc) {
            cJ(this.iuc);
        } else if (view == this.iud) {
            cJ(this.iud);
        } else if (view == this.iua) {
            cbt();
        }
    }

    private void cJ(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void cbt() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
