package com.baidu.tieba.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
public class b extends RelativeLayout {
    private Context a;
    private ViewGroup b;
    private TbImageView c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private View j;
    private ViewGroup k;
    private ViewGroup l;
    private TbImageView m;
    private TextView n;
    private TextView o;
    private boolean p;

    public void setShowName(boolean z) {
        this.p = z;
    }

    public b(Context context) {
        super(context);
        this.a = context;
        c();
    }

    private void c() {
        View a = com.baidu.adp.lib.e.b.a().a(this.a, getXmlLayoutResId(), this);
        this.b = (ViewGroup) a.findViewById(com.baidu.tieba.u.bubble_layout);
        this.c = (TbImageView) a.findViewById(com.baidu.tieba.u.bubble_image);
        this.d = (ImageView) a.findViewById(com.baidu.tieba.u.bubble_iamge_bg);
        this.e = (ImageView) a.findViewById(com.baidu.tieba.u.free_tip);
        this.f = (ImageView) a.findViewById(com.baidu.tieba.u.defualt_tip);
        this.g = (ImageView) a.findViewById(com.baidu.tieba.u.bubble_notuse_iamge);
        this.h = (ImageView) a.findViewById(com.baidu.tieba.u.bubble_round_up);
        this.i = (ImageView) a.findViewById(com.baidu.tieba.u.bubble_round_full);
        this.j = a.findViewById(com.baidu.tieba.u.bubble_center_line);
        this.k = (ViewGroup) a.findViewById(com.baidu.tieba.u.bubble_bottom_layout);
        this.l = (ViewGroup) a.findViewById(com.baidu.tieba.u.has_icon_name);
        this.m = (TbImageView) a.findViewById(com.baidu.tieba.u.icon_iamge);
        this.n = (TextView) a.findViewById(com.baidu.tieba.u.bubble_name);
        this.o = (TextView) a.findViewById(com.baidu.tieba.u.no_icon_name);
    }

    public int getXmlLayoutResId() {
        return com.baidu.tieba.v.bubbleview;
    }

    public void a(BubbleListData.BubbleData bubbleData, boolean z) {
        if (bubbleData != null) {
            if (bubbleData.getBcode() == 0) {
                a();
                this.f.setVisibility(z ? 0 : 8);
                this.d.setVisibility(z ? 0 : 8);
                return;
            }
            this.b.setVisibility(0);
            this.g.setVisibility(8);
            if (bubbleData.isDef()) {
                this.d.setVisibility(0);
                this.f.setVisibility(0);
            } else {
                this.d.setVisibility(8);
                this.f.setVisibility(8);
            }
            if (bubbleData.isFree()) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bubbleData.getB_url())) {
                this.c.setTag(bubbleData.getB_url());
                this.c.a(bubbleData.getB_url(), 10, false);
            }
            if (!this.p) {
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.h.setVisibility(8);
                this.i.setVisibility(0);
                return;
            }
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            this.h.setVisibility(0);
            this.i.setVisibility(8);
            if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
                this.l.setVisibility(0);
                this.o.setVisibility(8);
                this.n.setText(bubbleData.getBname());
                this.m.setTag(bubbleData.getIcon_url());
                this.m.a(bubbleData.getIcon_url(), 10, false);
                return;
            }
            this.l.setVisibility(8);
            this.o.setVisibility(0);
            this.o.setText(bubbleData.getBname());
        }
    }

    public void a() {
        this.b.setVisibility(8);
        this.g.setVisibility(0);
        this.e.setVisibility(8);
        if (!this.p) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.h.setVisibility(8);
            this.i.setVisibility(0);
            return;
        }
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        this.l.setVisibility(8);
        this.o.setVisibility(0);
        this.o.setText(this.a.getString(com.baidu.tieba.x.bubble_notuse_text));
    }

    public void b() {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (this.a instanceof BaseActivity) {
            ((BaseActivity) this.a).getLayoutMode().a(skinType == 1);
            ((BaseActivity) this.a).getLayoutMode().a((View) this);
        }
        if (this.a instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.a).c().a(skinType == 1);
            ((BaseFragmentActivity) this.a).c().a((View) this);
        }
    }
}
