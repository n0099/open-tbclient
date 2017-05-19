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
public class s extends RelativeLayout {
    public TextView clJ;
    public BarImageView eEJ;
    public TextView eEK;
    public TextView eEL;
    public TextView eEM;
    private com.baidu.tieba.personPolymeric.c.e eEN;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public s(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(w.j.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.eEJ = (BarImageView) findViewById(w.h.forum_avatar);
        this.clJ = (TextView) findViewById(w.h.forum_name);
        this.eEK = (TextView) findViewById(w.h.forum_post_thread);
        this.eEL = (TextView) findViewById(w.h.forum_thread_num);
        this.eEM = (TextView) findViewById(w.h.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new t(this);
    }

    public void setData(com.baidu.tieba.personPolymeric.c.e eVar) {
        this.eEN = eVar;
        this.eEJ.c(eVar.avatar, 10, false);
        this.clJ.setText(String.valueOf(au.e(eVar.forumName, 7, "...")) + this.mContext.getString(w.l.forum));
        this.eEL.setText(au.t(eVar.eDh));
        this.eEK.setText(String.format(this.mContext.getString(w.l.person_has_posted), au.cR(eVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
            aq.i(this.clJ, w.e.cp_cont_b);
            aq.i(this.eEK, w.e.cp_cont_c);
            aq.i(this.eEM, w.e.cp_cont_c);
            aq.i(this.eEL, w.e.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }
}
