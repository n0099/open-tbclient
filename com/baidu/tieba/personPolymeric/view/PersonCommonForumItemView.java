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
import com.baidu.tieba.f;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public TextView cTP;
    public BarImageView gcJ;
    public TextView gcK;
    public TextView gcL;
    public TextView gcM;
    private com.baidu.tieba.personPolymeric.c.f gcN;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public PersonCommonForumItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(f.h.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.gcJ = (BarImageView) findViewById(f.g.forum_avatar);
        this.cTP = (TextView) findViewById(f.g.forum_name);
        this.gcK = (TextView) findViewById(f.g.forum_post_thread);
        this.gcL = (TextView) findViewById(f.g.forum_thread_num);
        this.gcM = (TextView) findViewById(f.g.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.gcN != null) {
                    TiebaStatic.log(new an("c12503").ae("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                    TiebaStatic.log(new an("c11594"));
                    String str = PersonCommonForumItemView.this.gcN.forumName;
                    if (ap.bf(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.gcN = fVar;
        this.gcJ.startLoad(fVar.avatar, 10, false);
        this.cTP.setText(ap.e(fVar.forumName, 7, "...") + this.mContext.getString(f.j.forum));
        this.gcL.setText(ap.A(fVar.gaZ));
        this.gcK.setText(String.format(this.mContext.getString(f.j.person_has_posted), ap.cZ(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            am.h(this.cTP, f.d.cp_cont_b);
            am.h(this.gcK, f.d.cp_cont_d);
            am.h(this.gcM, f.d.cp_cont_d);
            am.h(this.gcL, f.d.cp_link_tip_a);
            am.i(this, f.C0146f.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
