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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public TextView jKX;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    public BarImageView maY;
    public TextView maZ;
    public TextView mba;
    public TextView mbb;
    private com.baidu.tieba.personPolymeric.c.f mbc;

    public PersonCommonForumItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(R.layout.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.maY = (BarImageView) findViewById(R.id.forum_avatar);
        this.jKX = (TextView) findViewById(R.id.forum_name);
        this.maZ = (TextView) findViewById(R.id.forum_post_thread);
        this.mba = (TextView) findViewById(R.id.forum_thread_num);
        this.mbb = (TextView) findViewById(R.id.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.mbc != null) {
                    TiebaStatic.log(new aq("c12503").dR("obj_locate", "6"));
                    TiebaStatic.log(new aq("c11594"));
                    String str = PersonCommonForumItemView.this.mbc.forumName;
                    if (at.isForumName(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.mbc = fVar;
        this.maY.startLoad(fVar.avatar, 10, false);
        this.jKX.setText(at.cutForumNameWithSuffix(fVar.forumName, 7, StringHelper.STRING_MORE) + this.mContext.getString(R.string.forum));
        this.mba.setText(at.numberUniformFormat(fVar.lXt));
        this.maZ.setText(String.format(this.mContext.getString(R.string.person_has_posted), at.getUserDescByGender(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setViewTextColor(this.jKX, R.color.cp_cont_b);
            ap.setViewTextColor(this.maZ, R.color.cp_cont_d);
            ap.setViewTextColor(this.mbb, R.color.cp_cont_d);
            ap.setViewTextColor(this.mba, R.color.cp_link_tip_a);
            ap.setBackgroundResource(this, R.drawable.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
