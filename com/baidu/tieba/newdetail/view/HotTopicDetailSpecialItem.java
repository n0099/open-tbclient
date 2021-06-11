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
import d.a.c.e.p.l;
import d.a.m0.m.f;
import d.a.m0.r.q.a;
import d.a.n0.y1.e.b;
/* loaded from: classes4.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f18584e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f18585f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18586g;

    /* renamed from: h  reason: collision with root package name */
    public View f18587h;

    /* renamed from: i  reason: collision with root package name */
    public View f18588i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public b n;
    public f<b> o;

    public HotTopicDetailSpecialItem(Context context) {
        super(context);
        this.f18584e = 3;
        b();
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.n = bVar;
            if (TextUtils.isEmpty(bVar.f67119h)) {
                this.f18586g.setVisibility(8);
                this.f18587h.setVisibility(8);
                this.f18588i.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.descView);
                this.m.setLayoutParams(layoutParams);
            } else {
                this.f18586g.U(bVar.f67119h, 10, false);
                this.f18586g.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.m.setLayoutParams(layoutParams2);
                if (bVar.f67120i > 0) {
                    this.f18588i.setVisibility(0);
                    this.f18587h.setVisibility(0);
                    this.k.setText(StringUtils.translateSecondsToString(bVar.f67120i));
                } else {
                    this.f18588i.setVisibility(8);
                    this.f18587h.setVisibility(8);
                }
            }
            this.l.setText(bVar.f67116e);
            String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(bVar.f67117f);
            String str = "" + this.m.getContext().getResources().getString(R.string.hot_topic_special_item_reply, numberUniformFormatExtra);
            String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(bVar.f67118g);
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
        this.f18585f = viewGroup;
        viewGroup.setOnClickListener(this);
        this.f18586g = (TbImageView) findViewById(R.id.coverView);
        this.f18587h = findViewById(R.id.coverGradientMask);
        this.f18588i = findViewById(R.id.videoTimeContainer);
        this.j = (ImageView) findViewById(R.id.videoPlayIcon);
        this.k = (TextView) findViewById(R.id.videoPlayTime);
        this.l = (TextView) findViewById(R.id.descView);
        this.m = (TextView) findViewById(R.id.tagView);
        this.f18586g.setPlaceHolder(2);
        this.f18586g.setRadius(l.g(getContext(), R.dimen.tbds10));
        this.f18586g.setConrers(15);
    }

    public void c(int i2) {
        if (this.f18584e != i2) {
            TBSelector.setViewBackgroundColorWithPressedState(this.f18585f, R.color.CAM_X0205, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
            this.j.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            this.f18584e = i2;
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
        this.f18584e = 3;
        b();
    }

    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18584e = 3;
        b();
    }
}
