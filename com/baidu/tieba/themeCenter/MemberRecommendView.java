package com.baidu.tieba.themeCenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.dressCenter.e;
/* loaded from: classes9.dex */
public class MemberRecommendView extends FrameLayout {
    private TbImageView jYE;
    private int loW;
    private Context mContext;
    private View mRootView;
    private TextView mTitleView;
    private TextView nFl;
    private e nFm;

    public MemberRecommendView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public MemberRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public MemberRecommendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.member_extend_view, this);
        this.jYE = (TbImageView) this.mRootView.findViewById(R.id.vip_icon);
        this.jYE.setDefaultResource(R.drawable.icon_vip_orange);
        this.jYE.setDefaultBgResource(R.drawable.transparent_bg);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.title_view);
        this.nFl = (TextView) this.mRootView.findViewById(R.id.jump_button);
        this.nFl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.MemberRecommendView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                TbPageContext tbPageContext;
                int i = 9;
                switch (MemberRecommendView.this.loW) {
                    case 1:
                        TiebaStatic.log("c10261");
                        i = 8;
                        str = MemberPayStatistic.REFER_PAGE_DRESS_UP_CENTER;
                        break;
                    case 2:
                    case 3:
                    case 9:
                        TiebaStatic.log("c10266");
                        if (MemberRecommendView.this.loW != 9) {
                            str = "";
                            break;
                        } else {
                            str = MemberPayStatistic.REFER_PAGE_PERSONALITY_CARDS;
                            break;
                        }
                    case 4:
                    case 5:
                        TiebaStatic.log("c10278");
                        i = 12;
                        str = MemberRecommendView.this.loW == 4 ? MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND : MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND;
                        break;
                    case 6:
                    case 7:
                        TiebaStatic.log("c10762");
                        i = 19;
                        str = MemberRecommendView.this.loW == 7 ? MemberPayStatistic.REFER_PAGE_ALL_BUBBLE : MemberPayStatistic.REFER_PAGE_POST_BUBBLE;
                        break;
                    case 8:
                        i = 22;
                        TiebaStatic.log("c11613");
                        str = MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT;
                        break;
                    default:
                        str = "";
                        i = 0;
                        break;
                }
                if (MemberRecommendView.this.nFm != null && (tbPageContext = (TbPageContext) j.K(MemberRecommendView.this.mContext)) != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(tbPageContext.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i);
                    memberPayActivityConfig.setReferPageClickZone(str, MemberPayStatistic.CLICK_ZONE_OPENDE_RENEWALFEE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            }
        });
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.nFm = eVar;
            this.jYE.startLoad(this.nFm.getIconUrl(), 10, false);
            this.mTitleView.setText(this.nFm.dRo());
            if (StringUtils.isNull(this.nFm.dRp())) {
                this.nFl.setVisibility(8);
                return;
            }
            this.nFl.setVisibility(0);
            this.nFl.setText(this.nFm.dRp());
        }
    }

    public void bup() {
        TbPageContext tbPageContext = (TbPageContext) j.K(this.mContext);
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            tbPageContext.getLayoutMode().onModeChanged(this.mRootView);
        }
    }

    public int getFromType() {
        return this.loW;
    }

    public void setFromType(int i) {
        this.loW = i;
    }

    public View getButton() {
        return this.nFl;
    }
}
