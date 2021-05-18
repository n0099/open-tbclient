package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tieba.R;
import d.a.c.a.f;
import d.a.c.e.m.g;
import d.a.j0.r.s.h;
import d.a.j0.r.s.j;
import d.a.j0.r.s.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class NewMyFansUserLikeButton extends FollowUserButton {
    public int A;
    public boolean B;
    public String v;
    public String w;
    public f x;
    public j y;
    public String z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f18468e;

        /* renamed from: com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0191a implements l.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f18470a;

            public C0191a(View view) {
                this.f18470a = view;
            }

            @Override // d.a.j0.r.s.l.d
            public void onClick() {
                View.OnClickListener onClickListener = a.this.f18468e;
                if (onClickListener == null) {
                    return;
                }
                onClickListener.onClick(this.f18470a);
                if (NewMyFansUserLikeButton.this.A != 1) {
                    if (NewMyFansUserLikeButton.this.A == 2) {
                        TiebaStatic.log(new StatisticItem("C12603").param("obj_param1", NewMyFansUserLikeButton.this.z));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12773").param("obj_param1", NewMyFansUserLikeButton.this.z));
                }
                g.b(NewMyFansUserLikeButton.this.y, NewMyFansUserLikeButton.this.x);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements l.c {
            public b() {
            }

            @Override // d.a.j0.r.s.l.c
            public void onClick() {
                if (NewMyFansUserLikeButton.this.y == null) {
                    return;
                }
                g.b(NewMyFansUserLikeButton.this.y, NewMyFansUserLikeButton.this.x);
            }
        }

        public a(View.OnClickListener onClickListener) {
            this.f18468e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NewMyFansUserLikeButton.this.A != 1) {
                if (NewMyFansUserLikeButton.this.A == 2) {
                    TiebaStatic.log(new StatisticItem("c12605").param("obj_locate", NewMyFansUserLikeButton.this.B ? 3 : 2).param("obj_param1", NewMyFansUserLikeButton.this.z));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12772").param("obj_locate", NewMyFansUserLikeButton.this.B ? "3" : "2").param("obj_param1", NewMyFansUserLikeButton.this.z));
            }
            if (NewMyFansUserLikeButton.this.B) {
                if (NewMyFansUserLikeButton.this.x != null) {
                    if (NewMyFansUserLikeButton.this.y == null) {
                        l lVar = new l(NewMyFansUserLikeButton.this.x.getContext());
                        lVar.q(NewMyFansUserLikeButton.this.x.getString(R.string.confirm_unlike));
                        ArrayList arrayList = new ArrayList();
                        h hVar = new h(NewMyFansUserLikeButton.this.x.getString(R.string.confirm), lVar);
                        hVar.m(new C0191a(view));
                        arrayList.add(hVar);
                        lVar.m(new b());
                        lVar.k(arrayList);
                        NewMyFansUserLikeButton.this.y = new j(NewMyFansUserLikeButton.this.x, lVar);
                        NewMyFansUserLikeButton.this.y.k(0.7f);
                    }
                    g.j(NewMyFansUserLikeButton.this.y, NewMyFansUserLikeButton.this.x);
                    return;
                }
                return;
            }
            this.f18468e.onClick(view);
        }
    }

    public NewMyFansUserLikeButton(Context context) {
        super(context);
        this.v = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.w = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.A = 1;
        this.B = false;
    }

    @Override // com.baidu.tbadk.core.view.FollowUserButton, d.a.j0.r.f0.q.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(new a(onClickListener));
    }

    @Override // com.baidu.tbadk.core.view.FollowUserButton, d.a.j0.r.f0.q.b
    public void e(boolean z, int i2) {
        super.e(z, i2);
        this.B = z;
        if (!z) {
            setText(this.w);
        } else if (i2 == 1) {
            setText(this.v);
        } else if (i2 != 2) {
            setText(this.v);
        } else {
            setText(this.x.getString(R.string.each_concerned));
        }
        r(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setContext(f fVar) {
        this.x = fVar;
    }

    public void setStatsParams(int i2, String str) {
        this.A = i2;
        this.z = str;
    }

    public NewMyFansUserLikeButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.w = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.A = 1;
        this.B = false;
    }

    public NewMyFansUserLikeButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.v = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.w = TbadkCoreApplication.getInst().getString(R.string.attention);
        this.A = 1;
        this.B = false;
    }
}
