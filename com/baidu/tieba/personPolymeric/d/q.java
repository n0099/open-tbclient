package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class q extends RelativeLayout {
    public TextView bwH;
    public BarImageView eFo;
    public TextView eFp;
    public TextView eFq;
    public TextView eFr;
    private com.baidu.tieba.personPolymeric.c.e eFs;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public q(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(r.j.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        Mj();
    }

    private void init() {
        this.eFo = (BarImageView) findViewById(r.h.forum_avatar);
        this.bwH = (TextView) findViewById(r.h.forum_name);
        this.eFp = (TextView) findViewById(r.h.forum_post_thread);
        this.eFq = (TextView) findViewById(r.h.forum_thread_num);
        this.eFr = (TextView) findViewById(r.h.forum_thread_str);
    }

    private void Mj() {
        this.mOnClickListener = new r(this);
    }

    public void setData(com.baidu.tieba.personPolymeric.c.e eVar) {
        this.eFs = eVar;
        this.eFo.c(eVar.avatar, 10, false);
        this.bwH.setText(String.valueOf(at.e(eVar.forumName, 7, "...")) + this.mContext.getString(r.l.forum));
        this.eFq.setText(at.u(eVar.eDZ));
        this.eFp.setText(String.format(this.mContext.getString(r.l.person_has_posted), at.cW(eVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        tg();
    }

    public void tg() {
        if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
            ap.i((View) this.bwH, r.e.cp_cont_b);
            ap.i((View) this.eFp, r.e.cp_cont_c);
            ap.i((View) this.eFr, r.e.cp_cont_c);
            ap.i((View) this.eFq, r.e.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }
}
