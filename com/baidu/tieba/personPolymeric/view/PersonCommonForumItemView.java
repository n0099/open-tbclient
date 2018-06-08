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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public TextView cTi;
    public BarImageView fYs;
    public TextView fYt;
    public TextView fYu;
    public TextView fYv;
    private com.baidu.tieba.personPolymeric.c.f fYw;
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
        this.fYs = (BarImageView) findViewById(d.g.forum_avatar);
        this.cTi = (TextView) findViewById(d.g.forum_name);
        this.fYt = (TextView) findViewById(d.g.forum_post_thread);
        this.fYu = (TextView) findViewById(d.g.forum_thread_num);
        this.fYv = (TextView) findViewById(d.g.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.fYw != null) {
                    TiebaStatic.log(new am("c12503").ah("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                    TiebaStatic.log(new am("c11594"));
                    String str = PersonCommonForumItemView.this.fYw.forumName;
                    if (ao.bc(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.fYw = fVar;
        this.fYs.startLoad(fVar.avatar, 10, false);
        this.cTi.setText(ao.f(fVar.forumName, 7, "...") + this.mContext.getString(d.k.forum));
        this.fYu.setText(ao.y(fVar.fWI));
        this.fYt.setText(String.format(this.mContext.getString(d.k.person_has_posted), ao.cW(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            al.h(this.cTi, d.C0141d.cp_cont_b);
            al.h(this.fYt, d.C0141d.cp_cont_d);
            al.h(this.fYv, d.C0141d.cp_cont_d);
            al.h(this.fYu, d.C0141d.cp_link_tip_a);
            al.i(this, d.f.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
