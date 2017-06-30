package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class s extends RelativeLayout {
    public TextView bUb;
    public BarImageView eXH;
    public TextView eXI;
    public TextView eXJ;
    public TextView eXK;
    private com.baidu.tieba.personPolymeric.c.f eXL;
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
        this.eXH = (BarImageView) findViewById(w.h.forum_avatar);
        this.bUb = (TextView) findViewById(w.h.forum_name);
        this.eXI = (TextView) findViewById(w.h.forum_post_thread);
        this.eXJ = (TextView) findViewById(w.h.forum_thread_num);
        this.eXK = (TextView) findViewById(w.h.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new t(this);
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.eXL = fVar;
        this.eXH.c(fVar.avatar, 10, false);
        this.bUb.setText(String.valueOf(aw.e(fVar.forumName, 7, "...")) + this.mContext.getString(w.l.forum));
        this.eXJ.setText(aw.t(fVar.eWD));
        this.eXI.setText(String.format(this.mContext.getString(w.l.person_has_posted), aw.cU(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
            as.i(this.bUb, w.e.cp_cont_b);
            as.i(this.eXI, w.e.cp_cont_c);
            as.i(this.eXK, w.e.cp_cont_c);
            as.i(this.eXJ, w.e.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }
}
