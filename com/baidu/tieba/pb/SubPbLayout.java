package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private View.OnClickListener a;
    private View.OnLongClickListener b;
    private View.OnTouchListener c;
    private cf d;
    private com.baidu.tieba.data.aq e;
    private View f;
    private Queue<dz> g;
    private View h;
    private ViewGroup.MarginLayoutParams i;

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = null;
        this.g = new LinkedList();
        this.i = new ViewGroup.MarginLayoutParams(-1, -2);
        this.h = LayoutInflater.from(getContext()).inflate(R.layout.new_sub_pb_list_more, (ViewGroup) null);
        addView(this.h, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.a = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.c = onTouchListener;
    }

    public void setSubPbAdapter(cf cfVar) {
        this.d = cfVar;
    }

    public void a(com.baidu.tieba.data.aq aqVar, View view) {
        this.e = aqVar;
        requestLayout();
        this.f = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        View view;
        SparseArray sparseArray;
        if (this.e == null || this.e.a().size() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i4 = i & 1073741823;
        ArrayList<com.baidu.tieba.data.aq> a = this.e.a();
        int size = a.size();
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            boolean z = false;
            View childAt = getChildAt(i5);
            if (childAt == null || childAt.equals(this.h)) {
                com.baidu.adp.lib.util.f.e("SubPbLayout", "onMeasure", "Item View Created for position: " + i5);
                View b = this.d.b();
                this.g.offer(new dz(i5, b, null));
                z = true;
                view = b;
            } else {
                view = childAt;
            }
            view.setOnClickListener(this.a);
            view.setOnLongClickListener(this.b);
            view.setOnTouchListener(this.c);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(R.id.tag_load_sub_data) != this.e) {
                sparseArray.put(R.id.tag_load_sub_data, this.e);
                z = true;
            }
            sparseArray.put(R.id.tag_load_sub_view, this.f);
            sparseArray.put(R.id.tag_is_subpb, true);
            if (a.get(i5) != null && a.get(i5).g() != null) {
                sparseArray.put(R.id.tag_photo_username, a.get(i5).g().getUserName());
                sparseArray.put(R.id.tag_clip_board, a.get(i5));
            }
            cg cgVar = (cg) sparseArray.get(R.id.tag_holder);
            if (z) {
                this.d.a(cgVar, a.get(i5), this.e.j() > a.size() || a.size() - i5 > 1, i5 == 0);
            }
            view.measure(((i4 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i5++;
            i6 += view.getMeasuredHeight();
        }
        if (a != null && this.e.j() > a.size()) {
            a(getContext(), (TextView) this.h.findViewById(R.id.sub_pb_more_text), this.e.j() - a.size());
            View view2 = this.h;
            if (TiebaApplication.g().al() == 1) {
                i3 = R.drawable.bg_floor_new_foot_1;
            } else {
                i3 = R.drawable.bg_floor_new_foot;
            }
            view2.setBackgroundResource(i3);
            ImageView imageView = (ImageView) this.h.findViewById(R.id.image);
            if (TiebaApplication.g().al() == 1) {
                imageView.setBackgroundResource(R.drawable.icon_downward_1);
            } else {
                imageView.setBackgroundResource(R.drawable.icon_downward);
            }
            this.h.setOnClickListener(this.a);
            SparseArray sparseArray4 = (SparseArray) this.h.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.h.setTag(sparseArray4);
            }
            sparseArray4.put(R.id.tag_load_sub_data, this.e);
            sparseArray4.put(R.id.tag_load_sub_view, this.f);
            this.h.setVisibility(0);
            this.h.measure(((i4 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.h.setVisibility(8);
        }
        setMeasuredDimension(i4, (this.h.getVisibility() == 0 ? this.h.getMeasuredHeight() : 0) + i6 + getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.e != null) {
            int size = this.g.size();
            for (int i6 = 0; i6 < size; i6++) {
                dz poll = this.g.poll();
                if (poll.b.getParent() == null) {
                    com.baidu.adp.lib.util.f.e("SubPbLayout", "onLayout", "add to position: " + poll.a);
                    addViewInLayout(poll.b, poll.a, this.i, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int size2 = this.e.a().size();
            int i7 = 0;
            int i8 = paddingTop;
            while (i7 < size2) {
                View childAt = getChildAt(i7);
                if (childAt == null) {
                    i5 = i8;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    if (marginLayoutParams == null) {
                        marginLayoutParams = generateDefaultLayoutParams();
                    }
                    int i9 = i8 + marginLayoutParams.topMargin;
                    int measuredWidth = marginLayoutParams.leftMargin + paddingLeft + childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight() + i9;
                    childAt.layout(marginLayoutParams.leftMargin + paddingLeft, i9, measuredWidth, measuredHeight);
                    i5 = marginLayoutParams.bottomMargin + measuredHeight;
                }
                i7++;
                i8 = i5;
            }
            if (this.h.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
                int i10 = i8 + marginLayoutParams2.topMargin;
                this.h.layout(marginLayoutParams2.leftMargin + paddingLeft, i10, marginLayoutParams2.leftMargin + paddingLeft + this.h.getMeasuredWidth(), this.h.getMeasuredHeight() + i10);
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TiebaApplication.g().b().getString(R.string.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        if (TiebaApplication.g().al() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.sub_pb_more_text_1)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.sub_pb_more_text_1));
        } else {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.sub_pb_more_text)), indexOf, valueOf.length() + indexOf, 33);
            textView.setTextColor(context.getResources().getColor(R.color.sub_pb_more_text));
        }
        textView.setText(spannableString);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        int size = this.e.a().size();
        for (int i = 0; i < size; i++) {
            drawChild(canvas, getChildAt(i), drawingTime);
        }
        if (this.h.getVisibility() == 0) {
            drawChild(canvas, this.h, drawingTime);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
