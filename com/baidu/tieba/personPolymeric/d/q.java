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
    public TextView bFX;
    public BarImageView eJb;
    public TextView eJc;
    public TextView eJd;
    public TextView eJe;
    private com.baidu.tieba.personPolymeric.c.e eJf;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public q(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(w.j.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.eJb = (BarImageView) findViewById(w.h.forum_avatar);
        this.bFX = (TextView) findViewById(w.h.forum_name);
        this.eJc = (TextView) findViewById(w.h.forum_post_thread);
        this.eJd = (TextView) findViewById(w.h.forum_thread_num);
        this.eJe = (TextView) findViewById(w.h.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new r(this);
    }

    public void setData(com.baidu.tieba.personPolymeric.c.e eVar) {
        this.eJf = eVar;
        this.eJb.c(eVar.avatar, 10, false);
        this.bFX.setText(String.valueOf(au.e(eVar.forumName, 7, "...")) + this.mContext.getString(w.l.forum));
        this.eJd.setText(au.t(eVar.eHN));
        this.eJc.setText(String.format(this.mContext.getString(w.l.person_has_posted), au.cV(eVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
            aq.i(this.bFX, w.e.cp_cont_b);
            aq.i(this.eJc, w.e.cp_cont_c);
            aq.i(this.eJe, w.e.cp_cont_c);
            aq.i(this.eJd, w.e.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }
}
