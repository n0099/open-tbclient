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
    public TextView cai;
    public TextView fnA;
    public TextView fnB;
    public TextView fnC;
    private com.baidu.tieba.personPolymeric.c.f fnD;
    public BarImageView fnz;
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
        this.fnz = (BarImageView) findViewById(d.h.forum_avatar);
        this.cai = (TextView) findViewById(d.h.forum_name);
        this.fnA = (TextView) findViewById(d.h.forum_post_thread);
        this.fnB = (TextView) findViewById(d.h.forum_thread_num);
        this.fnC = (TextView) findViewById(d.h.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && n.this.fnD != null) {
                    TiebaStatic.log(new aj("c11594"));
                    String str = n.this.fnD.forumName;
                    if (al.aP(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.fnD = fVar;
        this.fnz.c(fVar.avatar, 10, false);
        this.cai.setText(al.f(fVar.forumName, 7, "...") + this.mContext.getString(d.l.forum));
        this.fnB.setText(al.u(fVar.fml));
        this.fnA.setText(String.format(this.mContext.getString(d.l.person_has_posted), al.cY(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            ai.i(this.cai, d.e.cp_cont_b);
            ai.i(this.fnA, d.e.cp_cont_c);
            ai.i(this.fnC, d.e.cp_cont_c);
            ai.i(this.fnB, d.e.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
