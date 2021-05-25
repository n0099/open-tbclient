package com.baidu.tieba.newlist.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.m.f;
import d.a.n0.b2.d.b;
/* loaded from: classes4.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f18734e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f18735f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18736g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18737h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18738i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public b o;
    public f<b> p;

    public HotTopicListInfoItem(Context context) {
        super(context);
        this.f18734e = 3;
        c();
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.o = bVar;
            this.f18735f.V(bVar.j, 10, false);
            this.f18737h.setText(bVar.f52072g);
            this.k.setText(bVar.f52073h);
            String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f18738i.getContext(), bVar.k);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f18737h.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            if (TextUtils.isEmpty(hotTopicTagStr)) {
                this.f18738i.setVisibility(8);
                layoutParams.rightMargin = l.g(this.f18738i.getContext(), R.dimen.tbds42);
                this.f18737h.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.m.setLayoutParams(layoutParams2);
            } else {
                layoutParams.rightMargin = l.g(this.f18738i.getContext(), R.dimen.tbds100);
                this.f18737h.setLayoutParams(layoutParams);
                layoutParams2.leftMargin = -layoutParams.rightMargin;
                this.m.setLayoutParams(layoutParams2);
                this.f18738i.setVisibility(0);
                this.f18738i.setText(hotTopicTagStr);
            }
            b();
            if (bVar.f52074i > 0) {
                this.j.setVisibility(0);
                String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(bVar.f52074i);
                TextView textView = this.j;
                textView.setText(textView.getContext().getResources().getString(R.string.hot_topic_rank_item_tag, numberUniformFormatExtraWithRoundInt));
            } else {
                this.j.setVisibility(4);
            }
            TextView textView2 = this.f18736g;
            textView2.setText("" + bVar.f52071f);
        }
    }

    public final void b() {
        b bVar = this.o;
        if (bVar != null) {
            int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(bVar.k);
            Drawable background = this.f18738i.getBackground();
            DrawableCompat.setTint(background, SkinManager.getColor(hotTopicTagColorRes));
            this.f18738i.setBackgroundDrawable(background);
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(this.o.f52071f);
            Drawable background2 = this.f18736g.getBackground();
            DrawableCompat.setTint(background2, SkinManager.getColor(indexTextColorRes));
            this.f18736g.setBackgroundDrawable(background2);
        }
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_list_info_item, (ViewGroup) this, true);
        this.n = findViewById(R.id.rootLayout);
        this.f18735f = (TbImageView) findViewById(R.id.coverView);
        this.f18736g = (TextView) findViewById(R.id.indexView);
        this.f18737h = (TextView) findViewById(R.id.titleView);
        this.f18738i = (TextView) findViewById(R.id.tagView);
        this.j = (TextView) findViewById(R.id.numView);
        this.k = (TextView) findViewById(R.id.descView);
        this.l = (TextView) findViewById(R.id.titlePre);
        this.m = (TextView) findViewById(R.id.titleNext);
        this.f18735f.setPlaceHolder(1);
        this.f18735f.setRadius(l.g(getContext(), R.dimen.tbds10));
        this.f18735f.setConrers(15);
        findViewById(R.id.rootLayout).setOnClickListener(this);
    }

    public void d(int i2) {
        if (this.f18734e != i2) {
            TBSelector.setViewBackgroundColorWithPressedState(this.n, R.color.CAM_X0205, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f18738i, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f18736g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f18737h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
            b();
            this.f18734e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = this.o;
        if (bVar != null) {
            long j = bVar.f52070e;
            if (j <= 0) {
                return;
            }
            f<b> fVar = this.p;
            if (fVar != null) {
                fVar.a(view, bVar, bVar.f52071f, j);
            }
            HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(getContext());
            hotTopicActivityConfig.createNormalConfig("" + this.o.f52070e, null, "5").start();
        }
    }

    public void setOnItemCoverListener(f<b> fVar) {
        this.p = fVar;
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18734e = 3;
        c();
    }

    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18734e = 3;
        c();
    }
}
