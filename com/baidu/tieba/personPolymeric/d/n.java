package com.baidu.tieba.personPolymeric.d;

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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class n extends RelativeLayout {
    public TextView cah;
    public TextView fnA;
    private com.baidu.tieba.personPolymeric.c.f fnB;
    public BarImageView fnx;
    public TextView fny;
    public TextView fnz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public n(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(d.j.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.fnx = (BarImageView) findViewById(d.h.forum_avatar);
        this.cah = (TextView) findViewById(d.h.forum_name);
        this.fny = (TextView) findViewById(d.h.forum_post_thread);
        this.fnz = (TextView) findViewById(d.h.forum_thread_num);
        this.fnA = (TextView) findViewById(d.h.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && n.this.fnB != null) {
                    TiebaStatic.log(new aj("c11594"));
                    String str = n.this.fnB.forumName;
                    if (al.aO(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.fnB = fVar;
        this.fnx.c(fVar.avatar, 10, false);
        this.cah.setText(al.e(fVar.forumName, 7, "...") + this.mContext.getString(d.l.forum));
        this.fnz.setText(al.u(fVar.fmj));
        this.fny.setText(String.format(this.mContext.getString(d.l.person_has_posted), al.cY(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            ai.i(this.cah, d.e.cp_cont_b);
            ai.i(this.fny, d.e.cp_cont_c);
            ai.i(this.fnA, d.e.cp_cont_c);
            ai.i(this.fnz, d.e.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
