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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class n extends RelativeLayout {
    public TextView cdc;
    public BarImageView flU;
    public TextView flV;
    public TextView flW;
    public TextView flX;
    private com.baidu.tieba.personPolymeric.c.f flY;
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
        this.flU = (BarImageView) findViewById(d.h.forum_avatar);
        this.cdc = (TextView) findViewById(d.h.forum_name);
        this.flV = (TextView) findViewById(d.h.forum_post_thread);
        this.flW = (TextView) findViewById(d.h.forum_thread_num);
        this.flX = (TextView) findViewById(d.h.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && n.this.flY != null) {
                    TiebaStatic.log(new ak("c11594"));
                    String str = n.this.flY.forumName;
                    if (am.aL(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.flY = fVar;
        this.flU.c(fVar.avatar, 10, false);
        this.cdc.setText(am.f(fVar.forumName, 7, "...") + this.mContext.getString(d.l.forum));
        this.flW.setText(am.u(fVar.fkG));
        this.flV.setText(String.format(this.mContext.getString(d.l.person_has_posted), am.cZ(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            aj.i(this.cdc, d.e.cp_cont_b);
            aj.i(this.flV, d.e.cp_cont_c);
            aj.i(this.flX, d.e.cp_cont_c);
            aj.i(this.flW, d.e.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
