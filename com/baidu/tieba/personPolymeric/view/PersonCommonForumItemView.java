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
    public TextView kfl;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private com.baidu.tieba.personPolymeric.c.f mvA;
    public BarImageView mvw;
    public TextView mvx;
    public TextView mvy;
    public TextView mvz;

    public PersonCommonForumItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(R.layout.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.mvw = (BarImageView) findViewById(R.id.forum_avatar);
        this.kfl = (TextView) findViewById(R.id.forum_name);
        this.mvx = (TextView) findViewById(R.id.forum_post_thread);
        this.mvy = (TextView) findViewById(R.id.forum_thread_num);
        this.mvz = (TextView) findViewById(R.id.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.mvA != null) {
                    TiebaStatic.log(new ar("c12503").dY("obj_locate", "6"));
                    TiebaStatic.log(new ar("c11594"));
                    String str = PersonCommonForumItemView.this.mvA.forumName;
                    if (au.isForumName(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.mvA = fVar;
        this.mvw.startLoad(fVar.avatar, 10, false);
        this.kfl.setText(au.cutForumNameWithSuffix(fVar.forumName, 7, StringHelper.STRING_MORE) + this.mContext.getString(R.string.forum));
        this.mvy.setText(au.numberUniformFormat(fVar.mrS));
        this.mvx.setText(String.format(this.mContext.getString(R.string.person_has_posted), au.getUserDescByGender(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setViewTextColor(this.kfl, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.mvx, (int) R.color.CAM_X0109);
            ap.setViewTextColor(this.mvz, (int) R.color.CAM_X0109);
            ap.setViewTextColor(this.mvy, (int) R.color.CAM_X0302);
            ap.setBackgroundResource(this, R.drawable.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
