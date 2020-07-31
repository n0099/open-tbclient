package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public TextView iLO;
    public BarImageView kZQ;
    public TextView kZR;
    public TextView kZS;
    public TextView kZT;
    private com.baidu.tieba.personPolymeric.c.f kZU;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public PersonCommonForumItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(R.layout.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.kZQ = (BarImageView) findViewById(R.id.forum_avatar);
        this.iLO = (TextView) findViewById(R.id.forum_name);
        this.kZR = (TextView) findViewById(R.id.forum_post_thread);
        this.kZS = (TextView) findViewById(R.id.forum_thread_num);
        this.kZT = (TextView) findViewById(R.id.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.kZU != null) {
                    TiebaStatic.log(new ap("c12503").dn("obj_locate", "6"));
                    TiebaStatic.log(new ap("c11594"));
                    String str = PersonCommonForumItemView.this.kZU.forumName;
                    if (as.isForumName(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.kZU = fVar;
        this.kZQ.startLoad(fVar.avatar, 10, false);
        this.iLO.setText(as.cutForumNameWithSuffix(fVar.forumName, 7, StringHelper.STRING_MORE) + this.mContext.getString(R.string.forum));
        this.kZS.setText(as.numberUniformFormat(fVar.kWK));
        this.kZR.setText(String.format(this.mContext.getString(R.string.person_has_posted), as.getUserDescByGender(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            ao.setViewTextColor(this.iLO, R.color.cp_cont_b);
            ao.setViewTextColor(this.kZR, R.color.cp_cont_d);
            ao.setViewTextColor(this.kZT, R.color.cp_cont_d);
            ao.setViewTextColor(this.kZS, R.color.cp_link_tip_a);
            ao.setBackgroundResource(this, R.drawable.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
