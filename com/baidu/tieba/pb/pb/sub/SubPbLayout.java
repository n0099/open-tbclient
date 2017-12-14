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
    private d eQS;
    private View.OnTouchListener fiA;
    private int fiB;
    private int fiC;
    private int fiD;
    private PostData fiE;
    private final Queue<a> fiF;
    private RelativeLayout fiG;
    private TextView fiH;
    private ViewGroup.MarginLayoutParams fiI;
    private View.OnClickListener fiy;
    private View.OnLongClickListener fiz;
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
        this.fiB = 0;
        this.fiC = 0;
        this.fiD = 0;
        this.mRootView = null;
        this.fiF = new LinkedList();
        this.fiI = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fiB = l.f(context, d.e.tbds4);
        this.fiC = l.f(context, d.e.tbds17);
        this.fiG = new RelativeLayout(context);
        this.fiG.setId(d.g.pb_floor_reply_more);
        this.fiH = new TextView(context);
        this.fiH.setPadding(0, this.fiB, 0, this.fiC);
        this.fiH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
        this.fiH.setTextSize(0, l.f(context, d.e.tbfontsize30));
        aj.i(this.fiH, d.C0096d.cp_cont_d);
        this.fiG.addView(this.fiH);
        addView(this.fiG, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fiy = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fiz = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fiA = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.eQS = dVar;
    }

    public void a(PostData postData, View view) {
        this.fiE = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bwS;
        if (this.eQS == null || this.fiE == null || this.fiE.bwS() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.fiE.bwQ()) {
            bwS = this.fiE.bwO();
        } else {
            bwS = this.fiE.bwS();
        }
        setMeasuredDimension(size, bw(v.v(bwS), size) + n(bwS, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.fiE.bxl()) {
            this.fiD = 0;
            return 0;
        } else if (v.v(list) != 0) {
            int v = v.v(list);
            this.fiD = v;
            if (!this.fiE.bwQ()) {
                if (v <= 2) {
                    this.fiD = v;
                } else {
                    this.fiD = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.fiD) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.fiG)) {
                    childAt = this.eQS.kX();
                    childAt.setPadding(0, 0, 0, 0);
                    this.fiF.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.fiy);
                view.setOnLongClickListener(this.fiz);
                view.setOnTouchListener(this.fiA);
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
                if (sparseArray.get(d.g.tag_load_sub_data) != this.fiE) {
                    sparseArray.put(d.g.tag_load_sub_data, this.fiE);
                }
                sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(d.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).rv() != null) {
                    sparseArray.put(d.g.tag_photo_username, list.get(i2).rv().getUserName());
                    sparseArray.put(d.g.tag_photo_userid, list.get(i2).rv().getUserId());
                    sparseArray.put(d.g.tag_clip_board, list.get(i2));
                }
                this.eQS.a((d.b) sparseArray.get(d.g.tag_holder), list.get(i2), this.fiE.bxa() > list.size() || list.size() - i2 > 1, i2 == 0, false);
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
        if (i > 0 && (this.fiE.bxl() || this.fiE.bxa() > this.fiD)) {
            this.fiH.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.fiE.bxa())));
            this.fiG.setOnClickListener(this.fiy);
            SparseArray sparseArray = (SparseArray) this.fiG.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.fiG.setTag(sparseArray);
            }
            sparseArray.put(d.g.tag_load_sub_data, this.fiE);
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            this.fiG.setVisibility(0);
            this.fiG.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.fiG.setVisibility(8);
        }
        if (this.fiG.getVisibility() == 0) {
            return this.fiG.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fiE != null && this.fiE.bwS() != null) {
            int size = this.fiF.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.fiF.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.fiI, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fiD;
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
            if (this.fiG.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fiG.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.fiG.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.fiG.getMeasuredWidth(), this.fiG.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.fiD; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.fiG) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fiE != null && this.fiE.bwS() != null) {
            int i = this.fiD;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.fiG.getVisibility() == 0) {
                drawChild(canvas, this.fiG, drawingTime);
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
        if (this.fiH != null) {
            this.fiH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_lou_more), (Drawable) null);
            aj.i(this.fiH, d.C0096d.cp_cont_d);
        }
    }
}
