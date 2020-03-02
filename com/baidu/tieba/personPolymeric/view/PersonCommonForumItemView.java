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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public TextView hnE;
    public BarImageView jrV;
    public TextView jrW;
    public TextView jrX;
    public TextView jrY;
    private com.baidu.tieba.personPolymeric.c.f jrZ;
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
        this.jrV = (BarImageView) findViewById(R.id.forum_avatar);
        this.hnE = (TextView) findViewById(R.id.forum_name);
        this.jrW = (TextView) findViewById(R.id.forum_post_thread);
        this.jrX = (TextView) findViewById(R.id.forum_thread_num);
        this.jrY = (TextView) findViewById(R.id.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.jrZ != null) {
                    TiebaStatic.log(new an("c12503").cy("obj_locate", "6"));
                    TiebaStatic.log(new an("c11594"));
                    String str = PersonCommonForumItemView.this.jrZ.forumName;
                    if (aq.isForumName(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.jrZ = fVar;
        this.jrV.startLoad(fVar.avatar, 10, false);
        this.hnE.setText(aq.cutForumNameWithSuffix(fVar.forumName, 7, StringHelper.STRING_MORE) + this.mContext.getString(R.string.forum));
        this.jrX.setText(aq.numberUniformFormat(fVar.joO));
        this.jrW.setText(String.format(this.mContext.getString(R.string.person_has_posted), aq.getUserDescByGender(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            am.setViewTextColor(this.hnE, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jrW, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jrY, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jrX, (int) R.color.cp_link_tip_a);
            am.setBackgroundResource(this, R.drawable.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
