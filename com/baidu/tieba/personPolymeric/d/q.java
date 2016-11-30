package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class q extends RelativeLayout {
    public TextView bIR;
    public BarImageView eRV;
    public TextView eRW;
    public TextView eRX;
    public TextView eRY;
    private com.baidu.tieba.personPolymeric.c.e eRZ;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public q(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(r.h.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        VV();
    }

    private void init() {
        this.eRV = (BarImageView) findViewById(r.g.forum_avatar);
        this.bIR = (TextView) findViewById(r.g.forum_name);
        this.eRW = (TextView) findViewById(r.g.forum_post_thread);
        this.eRX = (TextView) findViewById(r.g.forum_thread_num);
        this.eRY = (TextView) findViewById(r.g.forum_thread_str);
    }

    private void VV() {
        this.mOnClickListener = new r(this);
    }

    public void setData(com.baidu.tieba.personPolymeric.c.e eVar) {
        this.eRZ = eVar;
        this.eRV.c(eVar.avatar, 10, false);
        this.bIR.setText(String.valueOf(ax.e(eVar.forumName, 7, "...")) + this.mContext.getString(r.j.forum));
        this.eRX.setText(ax.v(eVar.eQG));
        this.eRW.setText(String.format(this.mContext.getString(r.j.person_has_posted), ax.cU(eVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        tB();
    }

    public void tB() {
        if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
            at.j((View) this.bIR, r.d.cp_cont_b);
            at.j((View) this.eRW, r.d.cp_cont_c);
            at.j((View) this.eRY, r.d.cp_cont_c);
            at.j((View) this.eRX, r.d.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }
}
