package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class q extends RelativeLayout {
    public TextView boU;
    public BarImageView evu;
    public TextView evv;
    public TextView evw;
    public TextView evx;
    private com.baidu.tieba.personPolymeric.c.e evy;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public q(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(r.h.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        Tc();
    }

    private void init() {
        this.evu = (BarImageView) findViewById(r.g.forum_avatar);
        this.boU = (TextView) findViewById(r.g.forum_name);
        this.evv = (TextView) findViewById(r.g.forum_post_thread);
        this.evw = (TextView) findViewById(r.g.forum_thread_num);
        this.evx = (TextView) findViewById(r.g.forum_thread_str);
    }

    private void Tc() {
        this.mOnClickListener = new r(this);
    }

    public void setData(com.baidu.tieba.personPolymeric.c.e eVar) {
        this.evy = eVar;
        this.evu.c(eVar.avatar, 10, false);
        this.boU.setText(String.valueOf(av.e(eVar.forumName, 7, "...")) + this.mContext.getString(r.j.forum));
        this.evw.setText(av.v(eVar.euf));
        this.evv.setText(String.format(this.mContext.getString(r.j.person_has_posted), av.cW(eVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        tm();
    }

    public void tm() {
        if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
            ar.j((View) this.boU, r.d.cp_cont_b);
            ar.j((View) this.evv, r.d.cp_cont_c);
            ar.j((View) this.evx, r.d.cp_cont_c);
            ar.j((View) this.evw, r.d.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }
}
