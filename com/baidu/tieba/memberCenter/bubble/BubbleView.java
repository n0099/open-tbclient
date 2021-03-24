package com.baidu.tieba.memberCenter.bubble;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
/* loaded from: classes3.dex */
public class BubbleView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f18892e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f18893f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18894g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f18895h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public View n;
    public ViewGroup o;
    public ViewGroup p;
    public TbImageView q;
    public TextView r;
    public TextView s;
    public boolean t;

    public BubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18892e = context;
        b();
    }

    public void a(TbPageContext<?> tbPageContext) {
        tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this);
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f18892e).inflate(getXmlLayoutResId(), this);
        this.f18893f = (ViewGroup) inflate.findViewById(R.id.bubble_layout);
        this.f18894g = (TbImageView) inflate.findViewById(R.id.bubble_image);
        this.f18895h = (ImageView) inflate.findViewById(R.id.bubble_iamge_bg);
        this.i = (ImageView) inflate.findViewById(R.id.free_tip);
        this.j = (ImageView) inflate.findViewById(R.id.defualt_tip);
        this.k = (ImageView) inflate.findViewById(R.id.bubble_notuse_iamge);
        this.l = (ImageView) inflate.findViewById(R.id.bubble_round_up);
        this.m = (ImageView) inflate.findViewById(R.id.bubble_round_full);
        this.n = inflate.findViewById(R.id.bubble_center_line);
        this.o = (ViewGroup) inflate.findViewById(R.id.bubble_bottom_layout);
        this.p = (ViewGroup) inflate.findViewById(R.id.has_icon_name);
        this.q = (TbImageView) inflate.findViewById(R.id.icon_iamge);
        this.r = (TextView) inflate.findViewById(R.id.bubble_name);
        this.s = (TextView) inflate.findViewById(R.id.no_icon_name);
    }

    public int getXmlLayoutResId() {
        return R.layout.bubbleview;
    }

    public void setCurrentNotUse() {
        this.f18893f.setVisibility(8);
        this.k.setVisibility(0);
        this.i.setVisibility(8);
        if (!this.t) {
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(0);
            return;
        }
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.l.setVisibility(0);
        this.m.setVisibility(8);
        this.p.setVisibility(8);
        this.s.setVisibility(0);
        this.s.setText(this.f18892e.getString(R.string.bubble_notuse_text));
    }

    public void setData(BubbleListData.BubbleData bubbleData, boolean z) {
        if (bubbleData == null) {
            return;
        }
        if (bubbleData.getBcode() == 0) {
            setCurrentNotUse();
            this.j.setVisibility(z ? 0 : 8);
            this.f18895h.setVisibility(z ? 0 : 8);
            return;
        }
        this.f18893f.setVisibility(0);
        this.k.setVisibility(8);
        if (bubbleData.isDef()) {
            this.f18895h.setVisibility(0);
            this.j.setVisibility(0);
        } else {
            this.f18895h.setVisibility(8);
            this.j.setVisibility(8);
        }
        if (bubbleData.isFree()) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        if (!TextUtils.isEmpty(bubbleData.getB_url())) {
            this.f18894g.setTag(bubbleData.getB_url());
            this.f18894g.W(bubbleData.getB_url(), 10, false);
        }
        if (!this.t) {
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(0);
            return;
        }
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.l.setVisibility(0);
        this.m.setVisibility(8);
        if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
            this.p.setVisibility(0);
            this.s.setVisibility(8);
            this.r.setText(bubbleData.getBname());
            this.q.setTag(bubbleData.getIcon_url());
            this.q.W(bubbleData.getIcon_url(), 10, false);
            return;
        }
        this.p.setVisibility(8);
        this.s.setVisibility(0);
        this.s.setText(bubbleData.getBname());
    }

    public void setShowName(boolean z) {
        this.t = z;
    }

    public BubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18892e = context;
        b();
    }

    public BubbleView(Context context) {
        super(context);
        this.f18892e = context;
        b();
    }
}
