package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public TextView cIW;
    public BarImageView fMd;
    public TextView fMe;
    public TextView fMf;
    public TextView fMg;
    private com.baidu.tieba.personPolymeric.c.f fMh;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public PersonCommonForumItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(d.i.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.fMd = (BarImageView) findViewById(d.g.forum_avatar);
        this.cIW = (TextView) findViewById(d.g.forum_name);
        this.fMe = (TextView) findViewById(d.g.forum_post_thread);
        this.fMf = (TextView) findViewById(d.g.forum_thread_num);
        this.fMg = (TextView) findViewById(d.g.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 != null && PersonCommonForumItemView.this.fMh != null) {
                    TiebaStatic.log(new al("c12503").ac("obj_locate", "6"));
                    TiebaStatic.log(new al("c11594"));
                    String str = PersonCommonForumItemView.this.fMh.forumName;
                    if (an.aQ(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.fMh = fVar;
        this.fMd.startLoad(fVar.avatar, 10, false);
        this.cIW.setText(an.f(fVar.forumName, 7, "...") + this.mContext.getString(d.k.forum));
        this.fMf.setText(an.v(fVar.fKt));
        this.fMe.setText(String.format(this.mContext.getString(d.k.person_has_posted), an.cU(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            ak.h(this.cIW, d.C0126d.cp_cont_b);
            ak.h(this.fMe, d.C0126d.cp_cont_d);
            ak.h(this.fMg, d.C0126d.cp_cont_d);
            ak.h(this.fMf, d.C0126d.cp_link_tip_a);
            ak.i(this, d.f.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
