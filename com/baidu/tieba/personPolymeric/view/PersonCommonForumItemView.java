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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public TextView cTT;
    public BarImageView gcK;
    public TextView gcL;
    public TextView gcM;
    public TextView gcN;
    private com.baidu.tieba.personPolymeric.c.f gcO;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public PersonCommonForumItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(d.h.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.gcK = (BarImageView) findViewById(d.g.forum_avatar);
        this.cTT = (TextView) findViewById(d.g.forum_name);
        this.gcL = (TextView) findViewById(d.g.forum_post_thread);
        this.gcM = (TextView) findViewById(d.g.forum_thread_num);
        this.gcN = (TextView) findViewById(d.g.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.gcO != null) {
                    TiebaStatic.log(new an("c12503").af("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                    TiebaStatic.log(new an("c11594"));
                    String str = PersonCommonForumItemView.this.gcO.forumName;
                    if (ap.bf(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.gcO = fVar;
        this.gcK.startLoad(fVar.avatar, 10, false);
        this.cTT.setText(ap.f(fVar.forumName, 7, "...") + this.mContext.getString(d.j.forum));
        this.gcM.setText(ap.A(fVar.gaZ));
        this.gcL.setText(String.format(this.mContext.getString(d.j.person_has_posted), ap.cZ(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            am.h(this.cTT, d.C0140d.cp_cont_b);
            am.h(this.gcL, d.C0140d.cp_cont_d);
            am.h(this.gcN, d.C0140d.cp_cont_d);
            am.h(this.gcM, d.C0140d.cp_link_tip_a);
            am.i(this, d.f.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
