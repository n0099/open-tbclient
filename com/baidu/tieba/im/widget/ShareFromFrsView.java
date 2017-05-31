package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private HeadImageView cjH;
    private ShareFromFrsMsgData cjK;
    private Context context;
    private TextView dib;
    private TextView dic;
    private TextView did;
    private TextView die;
    private TextView name;

    public ShareFromFrsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        initUI();
    }

    public ShareFromFrsView(Context context) {
        super(context);
        this.context = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(w.j.share_from_frs_view, this);
        this.name = (TextView) findViewById(w.h.frs_name);
        this.cjH = (HeadImageView) findViewById(w.h.frs_img);
        this.dic = (TextView) findViewById(w.h.frs_member_num);
        this.die = (TextView) findViewById(w.h.frs_post_num);
        this.dib = (TextView) findViewById(w.h.frs_member_num_label);
        this.did = (TextView) findViewById(w.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(w.e.cp_cont_b));
            this.dic.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.die.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.dib.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.did.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dic.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.die.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dib.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.did.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cjK = shareFromFrsMsgData;
        we();
    }

    private void we() {
        this.name.setText(dA(this.cjK.getName()));
        this.cjH.setDefaultResource(w.g.icon_default_ba_120);
        this.cjH.setAutoChangeStyle(false);
        this.cjH.c(this.cjK.getImageUrl(), 10, false);
        this.dic.setText(au.x(this.cjK.getMemberNum()));
        this.die.setText(au.x(this.cjK.getPostNum()));
    }

    private String dA(String str) {
        return String.valueOf(au.j(str, 8)) + this.context.getString(w.l.forum);
    }
}
