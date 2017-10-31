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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class o extends RelativeLayout {
    public TextView cle;
    public BarImageView fqT;
    public TextView fqU;
    public TextView fqV;
    public TextView fqW;
    private com.baidu.tieba.personPolymeric.c.f fqX;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public o(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(d.h.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.fqT = (BarImageView) findViewById(d.g.forum_avatar);
        this.cle = (TextView) findViewById(d.g.forum_name);
        this.fqU = (TextView) findViewById(d.g.forum_post_thread);
        this.fqV = (TextView) findViewById(d.g.forum_thread_num);
        this.fqW = (TextView) findViewById(d.g.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && o.this.fqX != null) {
                    TiebaStatic.log(new ak("c12503").ac("obj_locate", "6"));
                    TiebaStatic.log(new ak("c11594"));
                    String str = o.this.fqX.forumName;
                    if (am.aL(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(o.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.fqX = fVar;
        this.fqT.startLoad(fVar.avatar, 10, false);
        this.cle.setText(am.f(fVar.forumName, 7, "...") + this.mContext.getString(d.j.forum));
        this.fqV.setText(am.u(fVar.fpi));
        this.fqU.setText(String.format(this.mContext.getString(d.j.person_has_posted), am.cX(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            aj.i(this.cle, d.C0080d.cp_cont_b);
            aj.i(this.fqU, d.C0080d.cp_cont_d);
            aj.i(this.fqW, d.C0080d.cp_cont_d);
            aj.i(this.fqV, d.C0080d.cp_link_tip_a);
            aj.j(this, d.f.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
