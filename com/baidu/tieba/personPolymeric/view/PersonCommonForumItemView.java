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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public TextView knS;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    public BarImageView mwe;
    public TextView mwf;
    public TextView mwg;
    public TextView mwh;
    private com.baidu.tieba.personPolymeric.c.f mwi;

    public PersonCommonForumItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(R.layout.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.mwe = (BarImageView) findViewById(R.id.forum_avatar);
        this.knS = (TextView) findViewById(R.id.forum_name);
        this.mwf = (TextView) findViewById(R.id.forum_post_thread);
        this.mwg = (TextView) findViewById(R.id.forum_thread_num);
        this.mwh = (TextView) findViewById(R.id.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.mwi != null) {
                    TiebaStatic.log(new aq("c12503").dW("obj_locate", "6"));
                    TiebaStatic.log(new aq("c11594"));
                    String str = PersonCommonForumItemView.this.mwi.forumName;
                    if (at.isForumName(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.mwi = fVar;
        this.mwe.startLoad(fVar.avatar, 10, false);
        this.knS.setText(at.cutForumNameWithSuffix(fVar.forumName, 7, StringHelper.STRING_MORE) + this.mContext.getString(R.string.forum));
        this.mwg.setText(at.numberUniformFormat(fVar.msB));
        this.mwf.setText(String.format(this.mContext.getString(R.string.person_has_posted), at.getUserDescByGender(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            ao.setViewTextColor(this.knS, R.color.CAM_X0105);
            ao.setViewTextColor(this.mwf, R.color.CAM_X0109);
            ao.setViewTextColor(this.mwh, R.color.CAM_X0109);
            ao.setViewTextColor(this.mwg, R.color.CAM_X0302);
            ao.setBackgroundResource(this, R.drawable.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
