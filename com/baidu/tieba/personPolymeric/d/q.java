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
    public TextView bDG;
    public BarImageView eGL;
    public TextView eGM;
    public TextView eGN;
    public TextView eGO;
    private com.baidu.tieba.personPolymeric.c.e eGP;
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
        this.eGL = (BarImageView) findViewById(w.h.forum_avatar);
        this.bDG = (TextView) findViewById(w.h.forum_name);
        this.eGM = (TextView) findViewById(w.h.forum_post_thread);
        this.eGN = (TextView) findViewById(w.h.forum_thread_num);
        this.eGO = (TextView) findViewById(w.h.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new r(this);
    }

    public void setData(com.baidu.tieba.personPolymeric.c.e eVar) {
        this.eGP = eVar;
        this.eGL.c(eVar.avatar, 10, false);
        this.bDG.setText(String.valueOf(au.e(eVar.forumName, 7, "...")) + this.mContext.getString(w.l.forum));
        this.eGN.setText(au.t(eVar.eFx));
        this.eGM.setText(String.format(this.mContext.getString(w.l.person_has_posted), au.cV(eVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
            aq.i(this.bDG, w.e.cp_cont_b);
            aq.i(this.eGM, w.e.cp_cont_c);
            aq.i(this.eGO, w.e.cp_cont_c);
            aq.i(this.eGN, w.e.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }
}
