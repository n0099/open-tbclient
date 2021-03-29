package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import d.b.b.a.f;
import d.b.b.e.m.g;
import d.b.h0.r.s.h;
import d.b.h0.r.s.j;
import d.b.h0.r.s.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MyFansUserLikeButton extends CommonUserLikeButton {
    public f k;
    public j l;
    public String m;
    public int n;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f19061e;

        /* renamed from: com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0204a implements l.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f19063a;

            public C0204a(View view) {
                this.f19063a = view;
            }

            @Override // d.b.h0.r.s.l.d
            public void onClick() {
                View.OnClickListener onClickListener = a.this.f19061e;
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(this.f19063a);
                if (MyFansUserLikeButton.this.n != 1) {
                    if (MyFansUserLikeButton.this.n == 2) {
                        TiebaStatic.log(new StatisticItem("C12603").param("obj_param1", MyFansUserLikeButton.this.m));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12773").param("obj_param1", MyFansUserLikeButton.this.m));
                }
                g.b(MyFansUserLikeButton.this.l, MyFansUserLikeButton.this.k);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements l.c {
            public b() {
            }

            @Override // d.b.h0.r.s.l.c
            public void onClick() {
                if (MyFansUserLikeButton.this.l == null) {
                    return;
                }
                g.b(MyFansUserLikeButton.this.l, MyFansUserLikeButton.this.k);
            }
        }

        public a(View.OnClickListener onClickListener) {
            this.f19061e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MyFansUserLikeButton.this.n != 1) {
                if (MyFansUserLikeButton.this.n == 2) {
                    TiebaStatic.log(new StatisticItem("c12605").param("obj_locate", MyFansUserLikeButton.this.f13639g ? 3 : 2).param("obj_param1", MyFansUserLikeButton.this.m));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12772").param("obj_locate", MyFansUserLikeButton.this.f13639g ? "3" : "2").param("obj_param1", MyFansUserLikeButton.this.m));
            }
            if (MyFansUserLikeButton.this.f13639g) {
                if (MyFansUserLikeButton.this.k != null) {
                    if (MyFansUserLikeButton.this.l == null) {
                        l lVar = new l(MyFansUserLikeButton.this.k.getContext());
                        lVar.q(MyFansUserLikeButton.this.k.getString(R.string.confirm_unlike));
                        ArrayList arrayList = new ArrayList();
                        h hVar = new h(MyFansUserLikeButton.this.k.getString(R.string.confirm), lVar);
                        hVar.m(new C0204a(view));
                        arrayList.add(hVar);
                        lVar.m(new b());
                        lVar.k(arrayList);
                        MyFansUserLikeButton.this.l = new j(MyFansUserLikeButton.this.k, lVar);
                        MyFansUserLikeButton.this.l.k(0.7f);
                    }
                    g.j(MyFansUserLikeButton.this.l, MyFansUserLikeButton.this.k);
                    return;
                }
                return;
            }
            this.f19061e.onClick(view);
        }
    }

    public MyFansUserLikeButton(Context context) {
        super(context);
        this.n = 1;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, d.b.h0.r.f0.q.b
    public void a(boolean z, int i) {
        this.f13639g = z;
        if (!z) {
            setTextSize(0, d.b.b.e.p.l.g(getContext(), R.dimen.ds26));
            setText(this.f13638f);
        } else if (i == 1) {
            setTextSize(0, d.b.b.e.p.l.g(getContext(), R.dimen.ds26));
            setText(this.f13637e);
        } else if (i != 2) {
            setTextSize(0, d.b.b.e.p.l.g(getContext(), R.dimen.ds26));
            setText(this.f13637e);
        } else {
            setTextSize(0, d.b.b.e.p.l.g(getContext(), R.dimen.ds24));
            setText(R.string.each_concerned);
        }
        g(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, d.b.h0.r.f0.q.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(new a(onClickListener));
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void g(int i) {
        if (this.f13639g) {
            SkinManager.setViewTextColor(this, R.color.btn_forum_focus_gray_color);
            SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_gray_border);
            return;
        }
        SkinManager.setViewTextColor(this, R.color.btn_forum_focus_color);
        SkinManager.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void h(boolean z) {
    }

    public void setContext(f fVar) {
        this.k = fVar;
    }

    public void setStatsParams(int i, String str) {
        this.n = i;
        this.m = str;
    }

    public MyFansUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 1;
    }

    public MyFansUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = 1;
    }
}
