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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private d eQX;
    private View.OnClickListener fiD;
    private View.OnLongClickListener fiE;
    private View.OnTouchListener fiF;
    private int fiG;
    private int fiH;
    private int fiI;
    private PostData fiJ;
    private final Queue<a> fiK;
    private RelativeLayout fiL;
    private TextView fiM;
    private ViewGroup.MarginLayoutParams fiN;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int position;
        View view;

        private a(int i, View view) {
            this.position = i;
            this.view = view;
        }
    }

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fiG = 0;
        this.fiH = 0;
        this.fiI = 0;
        this.mRootView = null;
        this.fiK = new LinkedList();
        this.fiN = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fiG = l.f(context, d.e.tbds4);
        this.fiH = l.f(context, d.e.tbds17);
        this.fiL = new RelativeLayout(context);
        this.fiL.setId(d.g.pb_floor_reply_more);
        this.fiM = new TextView(context);
        this.fiM.setPadding(0, this.fiG, 0, this.fiH);
        this.fiM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.fiM.setTextSize(0, l.f(context, d.e.tbfontsize30));
        aj.i(this.fiM, d.C0095d.cp_cont_d);
        this.fiL.addView(this.fiM);
        addView(this.fiL, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fiD = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fiE = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fiF = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.eQX = dVar;
    }

    public void a(PostData postData, View view) {
        this.fiJ = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bwS;
        if (this.eQX == null || this.fiJ == null || this.fiJ.bwS() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fiJ.bwQ()) {
            bwS = this.fiJ.bwO();
        } else {
            bwS = this.fiJ.bwS();
        }
        setMeasuredDimension(size, bw(v.v(bwS), size) + n(bwS, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.fiJ.bxl()) {
            this.fiI = 0;
            return 0;
        } else if (v.v(list) != 0) {
            int v = v.v(list);
            this.fiI = v;
            if (!this.fiJ.bwQ()) {
                if (v <= 2) {
                    this.fiI = v;
                } else {
                    this.fiI = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.fiI) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.fiL)) {
                    childAt = this.eQX.kX();
                    childAt.setPadding(0, 0, 0, 0);
                    this.fiK.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.fiD);
                view.setOnLongClickListener(this.fiE);
                view.setOnTouchListener(this.fiF);
                view.setClickable(true);
                view.setVisibility(0);
                SparseArray sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 == null) {
                    SparseArray sparseArray3 = new SparseArray();
                    view.setTag(sparseArray3);
                    sparseArray = sparseArray3;
                } else {
                    sparseArray = sparseArray2;
                }
                if (sparseArray.get(d.g.tag_load_sub_data) != this.fiJ) {
                    sparseArray.put(d.g.tag_load_sub_data, this.fiJ);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).rv() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).rv().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).rv().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.eQX.a((d.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.fiJ.bxa() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int bw(int i, int i2) {
        if (i > 0 && (this.fiJ.bxl() || this.fiJ.bxa() > this.fiI)) {
            this.fiM.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.fiJ.bxa())));
            this.fiL.setOnClickListener(this.fiD);
            SparseArray sparseArray = (SparseArray) this.fiL.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.fiL.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.fiJ);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.fiL.setVisibility(0);
            this.fiL.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.fiL.setVisibility(8);
        }
        if (this.fiL.getVisibility() == 0) {
            return this.fiL.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fiJ != null && this.fiJ.bwS() != null) {
            int size = this.fiK.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.fiK.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.fiN, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fiI;
            int i8 = 0;
            int i9 = paddingTop;
            while (i8 < i7) {
                View childAt = getChildAt(i8);
                if (childAt == null) {
                    i5 = i9;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    if (marginLayoutParams == null) {
                        marginLayoutParams = generateDefaultLayoutParams();
                    }
                    int i10 = i9 + marginLayoutParams.topMargin;
                    int measuredWidth = marginLayoutParams.leftMargin + paddingLeft + childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight() + i10;
                    childAt.layout(marginLayoutParams.leftMargin + paddingLeft, i10, measuredWidth, measuredHeight);
                    i5 = marginLayoutParams.bottomMargin + measuredHeight;
                }
                i8++;
                i9 = i5;
            }
            if (this.fiL.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fiL.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.fiL.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.fiL.getMeasuredWidth(), this.fiL.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.fiI; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.fiL) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fiJ != null && this.fiJ.bwS() != null) {
            int i = this.fiI;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.fiL.getVisibility() == 0) {
                drawChild(canvas, this.fiL, drawingTime);
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: aXP */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.fiM != null) {
            this.fiM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
            aj.i(this.fiM, d.C0095d.cp_cont_d);
        }
    }
}
