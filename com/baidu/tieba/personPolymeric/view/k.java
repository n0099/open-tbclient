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
    private View bIW;
    private FrameLayout itd;
    private TbImageView ite;
    private TbImageView itf;
    private TextView itg;
    private LinearLayout ith;
    private TextView iti;
    private TextView itj;
    private LinearLayout itk;
    private LinearLayout itl;
    private LinearLayout itm;
    private ImageView itn;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private View mRootView;
    private UserData mUserData;

    public k(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        W(aMv());
    }

    private void W(View view) {
        this.itd = (FrameLayout) view.findViewById(R.id.ala_entrance_root);
        this.ite = (TbImageView) view.findViewById(R.id.entrance_background);
        this.ite.setAutoChangeStyle(false);
        this.ite.setDrawerType(1);
        this.ite.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10));
        this.itf = (TbImageView) view.findViewById(R.id.live_level_img);
        this.itf.setAutoChangeStyle(false);
        this.itf.setDrawerType(1);
        this.itf.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds10));
        this.itg = (TextView) view.findViewById(R.id.live_level_text);
        this.ith = (LinearLayout) view.findViewById(R.id.replay_root);
        this.itj = (TextView) this.ith.findViewById(R.id.tv_replay_more);
        this.itn = (ImageView) this.ith.findViewById(R.id.replay_more_arrow);
        this.iti = (TextView) this.ith.findViewById(R.id.tv_replay_tile);
        this.itk = (LinearLayout) this.ith.findViewById(R.id.replay_item_one);
        this.itl = (LinearLayout) this.ith.findViewById(R.id.replay_item_two);
        this.itm = (LinearLayout) this.ith.findViewById(R.id.replay_item_three);
        g(this.itk);
        g(this.itl);
        g(this.itm);
        this.itd.setOnClickListener(this);
        this.itk.setOnClickListener(this);
        this.itl.setOnClickListener(this);
        this.itm.setOnClickListener(this);
        this.itj.setOnClickListener(this);
        this.bIW = view.findViewById(R.id.divider_view);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.iti, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.itj, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.bIW, R.color.cp_bg_line_e);
        am.setImageResource(this.itn, R.drawable.icon_mine_list_arrow);
        h(this.itk);
        h(this.itl);
        h(this.itm);
    }

    public View aMv() {
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
            this.itd.setVisibility(8);
            return;
        }
        this.itd.setVisibility(0);
        this.itd.setTag(alaLiveInfoCoreData);
        if (!StringUtils.isNull(alaLiveInfoCoreData.liveCover)) {
            this.ite.startLoad(alaLiveInfoCoreData.liveCover, 10, false);
        }
        int i = userData.alaUserData.level_id;
        if (i <= 10) {
            this.itf.setBackgroundResource(R.drawable.shape_ala_grade_1_green);
        } else if (i <= 20) {
            this.itf.setBackgroundResource(R.drawable.shape_ala_grade_2_blue);
        } else if (i <= 30) {
            this.itf.setBackgroundResource(R.drawable.shape_ala_grade_3_yellow);
        } else if (i <= 40) {
            this.itf.setBackgroundResource(R.drawable.shape_ala_grade_4_orange);
        } else {
            this.itf.setBackgroundResource(R.drawable.shape_ala_grade_5_purple);
        }
        this.itg.setText(BL(String.valueOf(i)));
    }

    private void ei(List<AlaLiveInfoCoreData> list) {
        if (v.isEmpty(list)) {
            this.ith.setVisibility(8);
            return;
        }
        this.ith.setVisibility(0);
        this.itl.setVisibility(0);
        this.itm.setVisibility(0);
        this.itk.setVisibility(0);
        int size = list.size();
        if (size >= 4) {
            this.itj.setVisibility(0);
            this.itn.setVisibility(0);
        } else {
            this.itj.setVisibility(4);
            this.itn.setVisibility(4);
        }
        a(list.get(0), this.itk);
        if (size >= 3) {
            a(list.get(1), this.itl);
            a(list.get(2), this.itm);
        } else if (size >= 2) {
            a(list.get(1), this.itl);
            this.itm.setVisibility(4);
        } else {
            this.itl.setVisibility(4);
            this.itm.setVisibility(4);
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
        if (view == this.itd) {
            if (this.itd.getTag() != null && (this.itd.getTag() instanceof AlaLiveInfoCoreData)) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) this.itd.getTag();
                if (alaLiveInfoCoreData.liveID > 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_ALA_ENTRANCE_LIVE_ID, Long.valueOf(alaLiveInfoCoreData.liveID)));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_play", TbadkCoreApplication.getCurrentAccount(), this.mIsHost, "")));
                TiebaStatic.log(new an("c12544"));
            }
        } else if (view == this.itk) {
            cJ(this.itk);
        } else if (view == this.itl) {
            cJ(this.itl);
        } else if (view == this.itm) {
            cJ(this.itm);
        } else if (view == this.itj) {
            cbr();
        }
    }

    private void cJ(View view) {
        if (view.getTag() != null && (view.getTag() instanceof AlaLiveInfoCoreData)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(((AlaLiveInfoCoreData) view.getTag()).threadId), null, "person_page")));
        }
    }

    private void cbr() {
        if (this.mUserData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount()))));
        }
    }
}
