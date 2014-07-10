package com.baidu.tieba.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
public class b extends RelativeLayout {
    private BaseActivity a;
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
        this.a = (BaseActivity) context;
        c();
    }

    private void c() {
        View inflate = LayoutInflater.from(this.a).inflate(getXmlLayoutResId(), this);
        this.b = (ViewGroup) inflate.findViewById(com.baidu.tieba.v.bubble_layout);
        this.c = (TbImageView) inflate.findViewById(com.baidu.tieba.v.bubble_image);
        this.d = (ImageView) inflate.findViewById(com.baidu.tieba.v.bubble_iamge_bg);
        this.e = (ImageView) inflate.findViewById(com.baidu.tieba.v.free_tip);
        this.f = (ImageView) inflate.findViewById(com.baidu.tieba.v.defualt_tip);
        this.g = (ImageView) inflate.findViewById(com.baidu.tieba.v.bubble_notuse_iamge);
        this.h = (ImageView) inflate.findViewById(com.baidu.tieba.v.bubble_round_up);
        this.i = (ImageView) inflate.findViewById(com.baidu.tieba.v.bubble_round_full);
        this.j = inflate.findViewById(com.baidu.tieba.v.bubble_center_line);
        this.k = (ViewGroup) inflate.findViewById(com.baidu.tieba.v.bubble_bottom_layout);
        this.l = (ViewGroup) inflate.findViewById(com.baidu.tieba.v.has_icon_name);
        this.m = (TbImageView) inflate.findViewById(com.baidu.tieba.v.icon_iamge);
        this.n = (TextView) inflate.findViewById(com.baidu.tieba.v.bubble_name);
        this.o = (TextView) inflate.findViewById(com.baidu.tieba.v.no_icon_name);
    }

    public int getXmlLayoutResId() {
        return com.baidu.tieba.w.bubbleview;
    }

    public void a(BubbleListData.BubbleData bubbleData, com.baidu.tbadk.core.util.b bVar, boolean z) {
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
            if (bVar != null && !TextUtils.isEmpty(bubbleData.getB_url())) {
                this.c.setTag(bubbleData.getB_url());
                bVar.b(bubbleData.getB_url(), new c(this));
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
            if (bVar != null && !TextUtils.isEmpty(bubbleData.getIcon_url())) {
                this.l.setVisibility(0);
                this.o.setVisibility(8);
                this.n.setText(bubbleData.getBname());
                this.m.setTag(bubbleData.getIcon_url());
                bVar.b(bubbleData.getIcon_url(), new d(this));
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
        this.o.setText(this.a.getString(com.baidu.tieba.y.bubble_notuse_text));
    }

    public void b() {
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a((View) this);
    }
}
