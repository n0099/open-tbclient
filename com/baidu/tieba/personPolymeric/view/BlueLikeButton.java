package com.baidu.tieba.personPolymeric.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.i0.k0.a;
import d.a.i0.r.f0.q.b;
import java.util.List;
/* loaded from: classes4.dex */
public class BlueLikeButton extends TextView implements b {

    /* renamed from: e  reason: collision with root package name */
    public boolean f20678e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20679f;

    public BlueLikeButton(Context context) {
        super(context);
        this.f20678e = false;
        this.f20679f = false;
    }

    @Override // d.a.i0.r.f0.q.b
    public void a(boolean z, int i2, boolean z2) {
        e(z, i2);
    }

    @Override // d.a.i0.r.f0.q.b
    public void b(View view) {
        if (this.f20679f) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "4"));
        if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            StatisticItem statisticItem = new StatisticItem("c12507");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", 2);
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(statisticItem);
        }
        if (this.f20678e) {
            return;
        }
        Context context = getContext();
        if ((context instanceof Activity) && (context instanceof a)) {
            String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
            List<String> currentPageSourceKeyList = ((a) context).getCurrentPageSourceKeyList();
            if (currentPageSourceKeyList == null || !StringHelper.equals((String) ListUtils.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") || k.isEmpty(stringExtra)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12613").param("obj_type", 1).param("tid", stringExtra));
        }
    }

    @Override // d.a.i0.r.f0.q.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    @Override // d.a.i0.r.f0.q.b
    public void d(int i2) {
    }

    @Override // d.a.i0.r.f0.q.b
    public void e(boolean z, int i2) {
        f(z);
    }

    public void f(boolean z) {
        this.f20678e = z;
        if (z) {
            if (this.f20679f) {
                setText(R.string.followed);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(l.g(getContext(), R.dimen.tbds42)).defaultColor(R.color.CAM_X0204).into(this);
                SkinManager.setViewTextColor(this, R.color.CAM_X0105, 1);
                return;
            }
            setText(R.string.followed);
            setBackgroundDrawable(SkinManager.getDrawable(R.drawable.selector_like_button_gray_bg));
            setPadding(0, 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this, R.color.CAM_X0110, 1);
        } else if (this.f20679f) {
            setText(R.string.attention);
            TBSelector.selectorBackgroundDrawable(DrawableSelector.make().setShape(0).setType(1).radius(l.g(getContext(), R.dimen.tbds42)).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0303, R.color.CAM_X0302).build(), DrawableSelector.make().setShape(0).setType(1).radius(l.g(getContext(), R.dimen.tbds42)).gradientLinear(DrawableSelector.TL_BR, R.color.cp_link_tip_b_alpha50, R.color.cp_link_tip_a_alpha50).build()).into(this);
            SkinManager.setViewTextColor(this, R.color.CAM_X0101, 1);
        } else {
            setText(R.string.attention);
            setBackgroundDrawable(SkinManager.getDrawable(R.drawable.selector_like_button_bg));
            setPadding(getResources().getDimensionPixelSize(R.dimen.tbds20), 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this, R.color.CAM_X0111, 1);
        }
    }

    public void setBJH(boolean z) {
        this.f20679f = z;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20678e = false;
        this.f20679f = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20678e = false;
        this.f20679f = false;
    }
}
