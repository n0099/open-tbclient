package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.bumptech.glide.load.engine.GlideException;
import d.b.c.e.p.l;
import d.b.i0.m.f;
import d.b.i0.r.q.a;
import d.b.j0.x1.e.b;
/* loaded from: classes3.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f18864e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f18865f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18866g;

    /* renamed from: h  reason: collision with root package name */
    public View f18867h;
    public View i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public b n;
    public f<b> o;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.f18864e = 3;
        b();
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.n = bVar;
            if (TextUtils.isEmpty(bVar.f64364h)) {
                this.f18866g.setVisibility(8);
                this.f18867h.setVisibility(8);
                this.i.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.m.setLayoutParams(layoutParams);
            } else {
                this.f18866g.W(bVar.f64364h, 10, false);
                this.f18866g.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.m.setLayoutParams(layoutParams2);
                if (bVar.i > 0) {
                    this.i.setVisibility(0);
                    this.f18867h.setVisibility(0);
                    this.k.setText(StringUtils.translateSecondsToString(bVar.i));
                } else {
                    this.i.setVisibility(8);
                    this.f18867h.setVisibility(8);
                }
            }
            this.l.setText(bVar.f64361e);
            String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(bVar.f64362f);
            String str = "" + this.m.getContext().getResources().getString(R.string.hot_topic_special_item_reply, numberUniformFormatExtra);
            String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(bVar.f64363g);
            if (str.length() > 0) {
                str = str + GlideException.IndentedAppendable.INDENT;
            }
            this.m.setText(str + this.m.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra2));
            setPadding(0, 0, 0, bVar.j ? l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
        }
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.rootLayout);
        this.f18865f = viewGroup;
        viewGroup.setOnClickListener(this);
        this.f18866g = (TbImageView) findViewById(R.id.coverView);
        this.f18867h = findViewById(R.id.coverGradientMask);
        this.i = findViewById(R.id.videoTimeContainer);
        this.j = (ImageView) findViewById(R.id.videoPlayIcon);
        this.k = (TextView) findViewById(R.id.videoPlayTime);
        this.l = (TextView) findViewById(R.id.descView);
        this.m = (TextView) findViewById(R.id.tagView);
        this.f18866g.setPlaceHolder(2);
        this.f18866g.setRadius(l.g(getContext(), R.dimen.tbds10));
        this.f18866g.setConrers(15);
    }

    public void c(int i) {
        if (this.f18864e != i) {
            TBSelector.setViewBackgroundColorWithPressedState(this.f18865f, R.color.CAM_X0205, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
            this.j.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            this.f18864e = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = this.n;
        if (bVar == null || bVar.k == null) {
            return;
        }
        f<b> fVar = this.o;
        if (fVar != null) {
            fVar.a(view, bVar, 0, 0L);
        }
        ThreadCardUtils.jumpToPB((a) this.n.k, view.getContext(), 17, false);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.o = fVar;
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18864e = 3;
        b();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18864e = 3;
        b();
    }
}
