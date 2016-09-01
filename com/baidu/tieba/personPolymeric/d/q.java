package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class q extends RelativeLayout {
    public TextView bFM;
    public BarImageView eJu;
    public TextView eJv;
    public TextView eJw;
    public TextView eJx;
    private com.baidu.tieba.personPolymeric.c.e eJy;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public q(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(t.h.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        UA();
    }

    private void init() {
        this.eJu = (BarImageView) findViewById(t.g.forum_avatar);
        this.bFM = (TextView) findViewById(t.g.forum_name);
        this.eJv = (TextView) findViewById(t.g.forum_post_thread);
        this.eJw = (TextView) findViewById(t.g.forum_thread_num);
        this.eJx = (TextView) findViewById(t.g.forum_thread_str);
    }

    private void UA() {
        this.mOnClickListener = new r(this);
    }

    public void setData(com.baidu.tieba.personPolymeric.c.e eVar) {
        this.eJy = eVar;
        this.eJu.c(eVar.avatar, 10, false);
        this.bFM.setText(String.valueOf(ba.d(eVar.forumName, 5, "...")) + this.mContext.getString(t.j.forum));
        this.eJw.setText(ba.w(eVar.eIe));
        this.eJv.setText(String.format(this.mContext.getString(t.j.person_has_posted), ba.cT(eVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        ti();
    }

    public void ti() {
        if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
            av.j((View) this.bFM, t.d.cp_cont_b);
            av.j((View) this.eJv, t.d.cp_cont_c);
            av.j((View) this.eJx, t.d.cp_cont_c);
            av.j((View) this.eJw, t.d.cp_link_tip_a);
        }
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
    }
}
