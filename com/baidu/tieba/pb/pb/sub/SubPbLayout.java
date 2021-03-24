package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.b.e.p.l;
import d.b.h0.b.d;
import d.b.h0.r.u.c;
import d.b.i0.c2.k.g.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes5.dex */
public class SubPbLayout extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f19936e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnLongClickListener f19937f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnTouchListener f19938g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.c2.k.g.b f19939h;
    public int i;
    public PostData j;
    public View k;
    public final Queue<b> l;
    public RelativeLayout m;
    public TextView n;
    public boolean o;
    public ViewGroup.MarginLayoutParams p;
    public SparseArray<Object> q;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f19940a;

        /* renamed from: b  reason: collision with root package name */
        public View f19941b;

        public b(int i, View view) {
            this.f19940a = i;
            this.f19941b = view;
        }
    }

    public SubPbLayout(Context context) {
        this(context, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public final int b(int i, int i2) {
        String format;
        if (i > 0 && (this.j.B() == 1 || this.j.B() == 3 || this.j.M() > this.i)) {
            if (this.o) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.j.M()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.j.M()));
            }
            this.n.setText(format);
            this.m.setOnClickListener(this.f19936e);
            SparseArray sparseArray = (SparseArray) this.m.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.m.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.j);
            sparseArray.put(R.id.tag_load_sub_view, this.k);
            this.m.setVisibility(0);
            this.m.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.m.setVisibility(8);
        }
        if (this.m.getVisibility() == 0) {
            return this.m.getMeasuredHeight();
        }
        return 0;
    }

    public final int c(List<PostData> list, int i) {
        if (this.j.B() != 1 && this.j.B() != 3) {
            if (ListUtils.getCount(list) == 0) {
                return 0;
            }
            int count = ListUtils.getCount(list);
            this.i = count;
            if (!this.j.Z()) {
                if (count <= 4) {
                    this.i = count;
                } else {
                    this.i = 4;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.i) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.m)) {
                    childAt = this.f19939h.b();
                    childAt.setPadding(0, 0, 0, 0);
                    this.l.offer(new b(i2, childAt));
                }
                childAt.setOnClickListener(this.f19936e);
                if (!this.o) {
                    childAt.setOnLongClickListener(this.f19937f);
                }
                childAt.setOnTouchListener(this.f19938g);
                childAt.setClickable(true);
                childAt.setVisibility(0);
                SparseArray sparseArray = (SparseArray) childAt.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    childAt.setTag(sparseArray);
                }
                Object obj = sparseArray.get(R.id.tag_load_sub_data);
                PostData postData = this.j;
                if (obj != postData) {
                    sparseArray.put(R.id.tag_load_sub_data, postData);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.k);
                sparseArray.put(R.id.tag_is_subpb, Boolean.TRUE);
                if (list.get(i2) != null && list.get(i2).s() != null) {
                    if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i2)) {
                        sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i2));
                    }
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).s().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).s().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                SparseArray<Object> sparseArray2 = this.q;
                if (sparseArray2 != null) {
                    sparseArray.put(-1, sparseArray2.get(-1));
                    sparseArray.put(-2, this.q.get(-2));
                    sparseArray.put(-3, this.q.get(-3));
                    sparseArray.put(-4, this.q.get(-4));
                }
                b.C1166b c1166b = (b.C1166b) sparseArray.get(R.id.tag_holder);
                this.f19939h.c(c1166b, list.get(i2), this.j.M() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c1166b.f53064e.setPadding(0, 0, 0, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                if (d.x()) {
                    f();
                } else {
                    e();
                }
                childAt.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i3 += childAt.getMeasuredHeight();
                i2++;
            }
            return i3;
        }
        this.i = 0;
        return 0;
    }

    public void d() {
        if (d.x()) {
            f();
        } else {
            e();
        }
        TextView textView = this.n;
        if (textView != null) {
            if (this.o) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        PostData postData = this.j;
        if (postData == null || postData.L() == null) {
            return;
        }
        int i = this.i;
        for (int i2 = 0; i2 < i; i2++) {
            if (i < getChildCount()) {
                drawChild(canvas, getChildAt(i2), drawingTime);
            }
        }
        if (this.m.getVisibility() == 0) {
            drawChild(canvas, this.m, drawingTime);
        }
    }

    public final void e() {
        TextView textView = this.n;
        if (textView != null) {
            textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
            if (this.o) {
                c.a(this.n).n(R.color.CAM_X0304);
            } else {
                c.a(this.n).n(R.color.CAM_X0108);
            }
        }
    }

    public final void f() {
        TextView textView = this.n;
        if (textView != null) {
            textView.setTextSize(0, TbConfig.getTestContentSizeOfLzl());
            if (this.o) {
                c.a(this.n).n(R.color.CAM_X0318);
            } else {
                c.a(this.n).n(R.color.CAM_X0108);
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        PostData postData = this.j;
        if (postData == null || postData.L() == null) {
            return;
        }
        int size = this.l.size();
        for (int i5 = 0; i5 < size; i5++) {
            b poll = this.l.poll();
            if (poll.f19941b.getParent() == null) {
                addViewInLayout(poll.f19941b, poll.f19940a, this.p, true);
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i6 = this.i;
        for (int i7 = 0; i7 < i6; i7++) {
            View childAt = getChildAt(i7);
            if (childAt != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (marginLayoutParams == null) {
                    marginLayoutParams = generateDefaultLayoutParams();
                }
                int i8 = marginLayoutParams.leftMargin;
                int i9 = paddingLeft + i8;
                int i10 = paddingTop + marginLayoutParams.topMargin;
                int measuredWidth = i8 + paddingLeft + childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + i10;
                childAt.layout(i9, i10, measuredWidth, measuredHeight);
                paddingTop = measuredHeight + marginLayoutParams.bottomMargin;
            }
        }
        if (this.m.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.m.getLayoutParams();
            RelativeLayout relativeLayout = this.m;
            int i11 = marginLayoutParams2.leftMargin;
            int i12 = paddingTop + marginLayoutParams2.topMargin;
            relativeLayout.layout(paddingLeft + i11, i12, paddingLeft + i11 + relativeLayout.getMeasuredWidth(), this.m.getMeasuredHeight() + i12);
        }
        int childCount = getChildCount();
        for (int i13 = this.i; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2 != null && childAt2 != this.m) {
                childAt2.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        PostData postData;
        ArrayList<PostData> L;
        if (this.f19939h != null && (postData = this.j) != null && postData.L() != null) {
            int size = View.MeasureSpec.getSize(i);
            if (this.j.Z()) {
                L = this.j.w();
            } else {
                L = this.j.L();
            }
            setMeasuredDimension(size, c(L, size) + 0 + b(ListUtils.getCount(L), size) + getPaddingBottom() + getPaddingTop());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.f19936e = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f19937f = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f19938g = onTouchListener;
    }

    public void setData(PostData postData, View view) {
        this.j = postData;
        requestLayout();
        this.k = view;
    }

    public void setDefaultTag(SparseArray<Object> sparseArray) {
        this.q = sparseArray;
    }

    public void setShowChildComment(boolean z) {
        this.o = z;
    }

    public void setSubPbAdapter(d.b.i0.c2.k.g.b bVar) {
        this.f19939h = bVar;
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 0;
        this.k = null;
        this.l = new LinkedList();
        this.o = false;
        this.p = new ViewGroup.MarginLayoutParams(-1, -2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.m = relativeLayout;
        relativeLayout.setId(R.id.pb_floor_reply_more);
        TextView textView = new TextView(context);
        this.n = textView;
        textView.setPadding(0, l.g(context, R.dimen.tbds_3), 0, l.g(context, R.dimen.tbds12));
        if (d.x()) {
            f();
        } else {
            e();
        }
        if (this.o) {
            this.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.n.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.m.addView(this.n);
        addView(this.m, -1, -2);
    }
}
