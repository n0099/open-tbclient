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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes6.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public TextView eTQ;
    public BarImageView imm;
    public TextView imn;
    public TextView imo;
    public TextView imp;
    private com.baidu.tieba.personPolymeric.c.f imq;
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
        this.imm = (BarImageView) findViewById(R.id.forum_avatar);
        this.eTQ = (TextView) findViewById(R.id.forum_name);
        this.imn = (TextView) findViewById(R.id.forum_post_thread);
        this.imo = (TextView) findViewById(R.id.forum_thread_num);
        this.imp = (TextView) findViewById(R.id.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.imq != null) {
                    TiebaStatic.log(new am("c12503").bT("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                    TiebaStatic.log(new am("c11594"));
                    String str = PersonCommonForumItemView.this.imq.forumName;
                    if (ap.bf(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.imq = fVar;
        this.imm.startLoad(fVar.avatar, 10, false);
        this.eTQ.setText(ap.k(fVar.forumName, 7, "...") + this.mContext.getString(R.string.forum));
        this.imo.setText(ap.aG(fVar.ikB));
        this.imn.setText(String.format(this.mContext.getString(R.string.person_has_posted), ap.il(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            al.j(this.eTQ, R.color.cp_cont_b);
            al.j(this.imn, R.color.cp_cont_d);
            al.j(this.imp, R.color.cp_cont_d);
            al.j(this.imo, R.color.cp_link_tip_a);
            al.k(this, R.drawable.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
