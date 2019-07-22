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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes6.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public TextView eYS;
    public BarImageView isH;
    public TextView isI;
    public TextView isJ;
    public TextView isK;
    private com.baidu.tieba.personPolymeric.c.f isL;
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
        this.isH = (BarImageView) findViewById(R.id.forum_avatar);
        this.eYS = (TextView) findViewById(R.id.forum_name);
        this.isI = (TextView) findViewById(R.id.forum_post_thread);
        this.isJ = (TextView) findViewById(R.id.forum_thread_num);
        this.isK = (TextView) findViewById(R.id.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.isL != null) {
                    TiebaStatic.log(new an("c12503").bT("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                    TiebaStatic.log(new an("c11594"));
                    String str = PersonCommonForumItemView.this.isL.forumName;
                    if (aq.bg(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.isL = fVar;
        this.isH.startLoad(fVar.avatar, 10, false);
        this.eYS.setText(aq.k(fVar.forumName, 7, "...") + this.mContext.getString(R.string.forum));
        this.isJ.setText(aq.aH(fVar.iqX));
        this.isI.setText(String.format(this.mContext.getString(R.string.person_has_posted), aq.ir(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            am.j(this.eYS, R.color.cp_cont_b);
            am.j(this.isI, R.color.cp_cont_d);
            am.j(this.isK, R.color.cp_cont_d);
            am.j(this.isJ, R.color.cp_link_tip_a);
            am.k(this, R.drawable.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
