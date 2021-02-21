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
    private TbImageView jYS;
    private int lpk;
    private Context mContext;
    private View mRootView;
    private TextView mTitleView;
    private TextView nFL;
    private e nFM;

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
        this.jYS = (TbImageView) this.mRootView.findViewById(R.id.vip_icon);
        this.jYS.setDefaultResource(R.drawable.icon_vip_orange);
        this.jYS.setDefaultBgResource(R.drawable.transparent_bg);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.title_view);
        this.nFL = (TextView) this.mRootView.findViewById(R.id.jump_button);
        this.nFL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.themeCenter.MemberRecommendView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                TbPageContext tbPageContext;
                int i = 9;
                switch (MemberRecommendView.this.lpk) {
                    case 1:
                        TiebaStatic.log("c10261");
                        i = 8;
                        str = MemberPayStatistic.REFER_PAGE_DRESS_UP_CENTER;
                        break;
                    case 2:
                    case 3:
                    case 9:
                        TiebaStatic.log("c10266");
                        if (MemberRecommendView.this.lpk != 9) {
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
                        str = MemberRecommendView.this.lpk == 4 ? MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND : MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND;
                        break;
                    case 6:
                    case 7:
                        TiebaStatic.log("c10762");
                        i = 19;
                        str = MemberRecommendView.this.lpk == 7 ? MemberPayStatistic.REFER_PAGE_ALL_BUBBLE : MemberPayStatistic.REFER_PAGE_POST_BUBBLE;
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
                if (MemberRecommendView.this.nFM != null && (tbPageContext = (TbPageContext) j.K(MemberRecommendView.this.mContext)) != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(tbPageContext.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i);
                    memberPayActivityConfig.setReferPageClickZone(str, MemberPayStatistic.CLICK_ZONE_OPENDE_RENEWALFEE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            }
        });
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.nFM = eVar;
            this.jYS.startLoad(this.nFM.getIconUrl(), 10, false);
            this.mTitleView.setText(this.nFM.dRw());
            if (StringUtils.isNull(this.nFM.dRx())) {
                this.nFL.setVisibility(8);
                return;
            }
            this.nFL.setVisibility(0);
            this.nFL.setText(this.nFM.dRx());
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
        return this.lpk;
    }

    public void setFromType(int i) {
        this.lpk = i;
    }

    public View getButton() {
        return this.nFL;
    }
}
