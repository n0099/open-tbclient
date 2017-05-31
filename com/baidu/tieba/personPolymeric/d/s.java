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
    public TextView csi;
    public TextView eNA;
    public TextView eNB;
    private com.baidu.tieba.personPolymeric.c.f eNC;
    public BarImageView eNy;
    public TextView eNz;
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
        this.eNy = (BarImageView) findViewById(w.h.forum_avatar);
        this.csi = (TextView) findViewById(w.h.forum_name);
        this.eNz = (TextView) findViewById(w.h.forum_post_thread);
        this.eNA = (TextView) findViewById(w.h.forum_thread_num);
        this.eNB = (TextView) findViewById(w.h.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new t(this);
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.eNC = fVar;
        this.eNy.c(fVar.avatar, 10, false);
        this.csi.setText(String.valueOf(au.e(fVar.forumName, 7, "...")) + this.mContext.getString(w.l.forum));
        this.eNA.setText(au.t(fVar.eMu));
        this.eNz.setText(String.format(this.mContext.getString(w.l.person_has_posted), au.cS(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
            aq.i(this.csi, w.e.cp_cont_b);
            aq.i(this.eNz, w.e.cp_cont_c);
            aq.i(this.eNB, w.e.cp_cont_c);
            aq.i(this.eNA, w.e.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }
}
