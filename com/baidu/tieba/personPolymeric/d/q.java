package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class q extends RelativeLayout {
    public TextView bFX;
    public TextView eLA;
    private com.baidu.tieba.personPolymeric.c.e eLB;
    public BarImageView eLx;
    public TextView eLy;
    public TextView eLz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public q(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(r.h.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        UT();
    }

    private void init() {
        this.eLx = (BarImageView) findViewById(r.g.forum_avatar);
        this.bFX = (TextView) findViewById(r.g.forum_name);
        this.eLy = (TextView) findViewById(r.g.forum_post_thread);
        this.eLz = (TextView) findViewById(r.g.forum_thread_num);
        this.eLA = (TextView) findViewById(r.g.forum_thread_str);
    }

    private void UT() {
        this.mOnClickListener = new r(this);
    }

    public void setData(com.baidu.tieba.personPolymeric.c.e eVar) {
        this.eLB = eVar;
        this.eLx.c(eVar.avatar, 10, false);
        this.bFX.setText(String.valueOf(az.e(eVar.forumName, 7, "...")) + this.mContext.getString(r.j.forum));
        this.eLz.setText(az.w(eVar.eKi));
        this.eLy.setText(String.format(this.mContext.getString(r.j.person_has_posted), az.cT(eVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        tx();
    }

    public void tx() {
        if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
            av.j((View) this.bFX, r.d.cp_cont_b);
            av.j((View) this.eLy, r.d.cp_cont_c);
            av.j((View) this.eLA, r.d.cp_cont_c);
            av.j((View) this.eLz, r.d.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }
}
