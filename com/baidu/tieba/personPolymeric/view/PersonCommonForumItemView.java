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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public TextView kfj;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    public BarImageView mvu;
    public TextView mvv;
    public TextView mvw;
    public TextView mvx;
    private com.baidu.tieba.personPolymeric.c.f mvy;

    public PersonCommonForumItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(R.layout.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.mvu = (BarImageView) findViewById(R.id.forum_avatar);
        this.kfj = (TextView) findViewById(R.id.forum_name);
        this.mvv = (TextView) findViewById(R.id.forum_post_thread);
        this.mvw = (TextView) findViewById(R.id.forum_thread_num);
        this.mvx = (TextView) findViewById(R.id.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.mvy != null) {
                    TiebaStatic.log(new ar("c12503").dY("obj_locate", "6"));
                    TiebaStatic.log(new ar("c11594"));
                    String str = PersonCommonForumItemView.this.mvy.forumName;
                    if (au.isForumName(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.mvy = fVar;
        this.mvu.startLoad(fVar.avatar, 10, false);
        this.kfj.setText(au.cutForumNameWithSuffix(fVar.forumName, 7, StringHelper.STRING_MORE) + this.mContext.getString(R.string.forum));
        this.mvw.setText(au.numberUniformFormat(fVar.mrQ));
        this.mvv.setText(String.format(this.mContext.getString(R.string.person_has_posted), au.getUserDescByGender(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setViewTextColor(this.kfj, R.color.CAM_X0105);
            ap.setViewTextColor(this.mvv, R.color.CAM_X0109);
            ap.setViewTextColor(this.mvx, R.color.CAM_X0109);
            ap.setViewTextColor(this.mvw, R.color.CAM_X0302);
            ap.setBackgroundResource(this, R.drawable.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
