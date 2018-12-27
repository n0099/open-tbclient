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
import com.baidu.tieba.e;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public TextView dst;
    public BarImageView gCI;
    public TextView gCJ;
    public TextView gCK;
    public TextView gCL;
    private com.baidu.tieba.personPolymeric.c.f gCM;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public PersonCommonForumItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(e.h.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.gCI = (BarImageView) findViewById(e.g.forum_avatar);
        this.dst = (TextView) findViewById(e.g.forum_name);
        this.gCJ = (TextView) findViewById(e.g.forum_post_thread);
        this.gCK = (TextView) findViewById(e.g.forum_thread_num);
        this.gCL = (TextView) findViewById(e.g.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.gCM != null) {
                    TiebaStatic.log(new am("c12503").aA("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                    TiebaStatic.log(new am("c11594"));
                    String str = PersonCommonForumItemView.this.gCM.forumName;
                    if (ao.bv(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.gCM = fVar;
        this.gCI.startLoad(fVar.avatar, 10, false);
        this.dst.setText(ao.e(fVar.forumName, 7, "...") + this.mContext.getString(e.j.forum));
        this.gCK.setText(ao.Q(fVar.gAY));
        this.gCJ.setText(String.format(this.mContext.getString(e.j.person_has_posted), ao.dU(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            al.h(this.dst, e.d.cp_cont_b);
            al.h(this.gCJ, e.d.cp_cont_d);
            al.h(this.gCL, e.d.cp_cont_d);
            al.h(this.gCK, e.d.cp_link_tip_a);
            al.i(this, e.f.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
