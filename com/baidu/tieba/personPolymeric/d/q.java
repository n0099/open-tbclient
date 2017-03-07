package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class q extends RelativeLayout {
    public TextView bDN;
    public BarImageView eIQ;
    public TextView eIR;
    public TextView eIS;
    public TextView eIT;
    private com.baidu.tieba.personPolymeric.c.e eIU;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public q(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(w.j.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        MV();
    }

    private void init() {
        this.eIQ = (BarImageView) findViewById(w.h.forum_avatar);
        this.bDN = (TextView) findViewById(w.h.forum_name);
        this.eIR = (TextView) findViewById(w.h.forum_post_thread);
        this.eIS = (TextView) findViewById(w.h.forum_thread_num);
        this.eIT = (TextView) findViewById(w.h.forum_thread_str);
    }

    private void MV() {
        this.mOnClickListener = new r(this);
    }

    public void setData(com.baidu.tieba.personPolymeric.c.e eVar) {
        this.eIU = eVar;
        this.eIQ.c(eVar.avatar, 10, false);
        this.bDN.setText(String.valueOf(au.e(eVar.forumName, 7, "...")) + this.mContext.getString(w.l.forum));
        this.eIS.setText(au.t(eVar.eHB));
        this.eIR.setText(String.format(this.mContext.getString(w.l.person_has_posted), au.cS(eVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        tD();
    }

    public void tD() {
        if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
            aq.i((View) this.bDN, w.e.cp_cont_b);
            aq.i((View) this.eIR, w.e.cp_cont_c);
            aq.i((View) this.eIT, w.e.cp_cont_c);
            aq.i((View) this.eIS, w.e.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }
}
