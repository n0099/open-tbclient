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
    public TextView cRg;
    public BarImageView gcs;
    public TextView gct;
    public TextView gcu;
    public TextView gcv;
    private com.baidu.tieba.personPolymeric.c.f gcw;
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
        this.gcs = (BarImageView) findViewById(d.g.forum_avatar);
        this.cRg = (TextView) findViewById(d.g.forum_name);
        this.gct = (TextView) findViewById(d.g.forum_post_thread);
        this.gcu = (TextView) findViewById(d.g.forum_thread_num);
        this.gcv = (TextView) findViewById(d.g.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.gcw != null) {
                    TiebaStatic.log(new an("c12503").ah("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                    TiebaStatic.log(new an("c11594"));
                    String str = PersonCommonForumItemView.this.gcw.forumName;
                    if (ap.be(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.gcw = fVar;
        this.gcs.startLoad(fVar.avatar, 10, false);
        this.cRg.setText(ap.f(fVar.forumName, 7, "...") + this.mContext.getString(d.k.forum));
        this.gcu.setText(ap.z(fVar.gaI));
        this.gct.setText(String.format(this.mContext.getString(d.k.person_has_posted), ap.cX(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            am.h(this.cRg, d.C0142d.cp_cont_b);
            am.h(this.gct, d.C0142d.cp_cont_d);
            am.h(this.gcv, d.C0142d.cp_cont_d);
            am.h(this.gcu, d.C0142d.cp_link_tip_a);
            am.i(this, d.f.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
