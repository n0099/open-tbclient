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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class n extends RelativeLayout {
    public TextView dqr;
    public BarImageView grm;
    public TextView grn;
    public TextView gro;
    public TextView grp;
    private com.baidu.tieba.personPolymeric.c.f grq;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public n(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(d.h.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.grm = (BarImageView) findViewById(d.g.forum_avatar);
        this.dqr = (TextView) findViewById(d.g.forum_name);
        this.grn = (TextView) findViewById(d.g.forum_post_thread);
        this.gro = (TextView) findViewById(d.g.forum_thread_num);
        this.grp = (TextView) findViewById(d.g.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && n.this.grq != null) {
                    TiebaStatic.log(new ak("c12503").ab("obj_locate", "6"));
                    TiebaStatic.log(new ak("c11594"));
                    String str = n.this.grq.forumName;
                    if (am.aT(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(n.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.grq = fVar;
        this.grm.startLoad(fVar.avatar, 10, false);
        this.dqr.setText(am.f(fVar.forumName, 7, "...") + this.mContext.getString(d.j.forum));
        this.gro.setText(am.C(fVar.gpB));
        this.grn.setText(String.format(this.mContext.getString(d.j.person_has_posted), am.fU(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            aj.r(this.dqr, d.C0141d.cp_cont_b);
            aj.r(this.grn, d.C0141d.cp_cont_d);
            aj.r(this.grp, d.C0141d.cp_cont_d);
            aj.r(this.gro, d.C0141d.cp_link_tip_a);
            aj.s(this, d.f.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
