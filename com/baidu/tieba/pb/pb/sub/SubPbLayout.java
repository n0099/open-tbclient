package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private ba eeC;
    private View.OnClickListener erO;
    private View.OnLongClickListener erP;
    private View.OnTouchListener erQ;
    private int erR;
    private PostData erS;
    private final Queue<a> erT;
    private TextView erU;
    private ViewGroup.MarginLayoutParams erV;
    private View mRootView;

    /* loaded from: classes.dex */
    private static class a {
        int position;
        View view;

        private a(int i, View view) {
            this.position = i;
            this.view = view;
        }

        /* synthetic */ a(int i, View view, a aVar) {
            this(i, view);
        }
    }

    public SubPbLayout(Context context) {
        this(context, null);
    }

    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.erR = 0;
        this.mRootView = null;
        this.erT = new LinkedList();
        this.erV = new ViewGroup.MarginLayoutParams(-1, -2);
        this.erU = new TextView(context);
        this.erU.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(context, w.f.ds16));
        this.erU.setId(w.h.pb_floor_reply_more);
        this.erU.setTextSize(0, com.baidu.adp.lib.util.k.g(context, w.f.fontsize28));
        com.baidu.tbadk.core.util.aq.i(this.erU, w.e.cp_link_tip_c);
        addView(this.erU, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.erO = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.erP = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.erQ = onTouchListener;
    }

    public void setSubPbAdapter(ba baVar) {
        this.eeC = baVar;
    }

    public void a(PostData postData, View view) {
        this.erS = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bgJ;
        SparseArray sparseArray;
        if (this.eeC == null || this.erS == null || this.erS.bgJ() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.erS.bgG()) {
            bgJ = this.erS.bgF();
        } else {
            bgJ = this.erS.bgJ();
        }
        int q = com.baidu.tbadk.core.util.x.q(bgJ);
        this.erR = q;
        if (!this.erS.bgG()) {
            if (q <= 2) {
                this.erR = q;
            } else {
                this.erR = 2;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.erR) {
            View childAt = getChildAt(i3);
            if (childAt == null || childAt.equals(this.erU)) {
                childAt = this.eeC.le();
                childAt.setPadding(0, 0, 0, (int) getResources().getDimension(w.f.ds20));
                this.erT.offer(new a(i3, childAt, null));
            }
            View view = childAt;
            view.setOnClickListener(this.erO);
            view.setOnLongClickListener(this.erP);
            view.setOnTouchListener(this.erQ);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(w.h.tag_load_sub_data) != this.erS) {
                sparseArray.put(w.h.tag_load_sub_data, this.erS);
            }
            sparseArray.put(w.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(w.h.tag_is_subpb, true);
            if (bgJ.get(i3) != null && bgJ.get(i3).getAuthor() != null) {
                sparseArray.put(w.h.tag_photo_username, bgJ.get(i3).getAuthor().getUserName());
                sparseArray.put(w.h.tag_photo_userid, bgJ.get(i3).getAuthor().getUserId());
                sparseArray.put(w.h.tag_clip_board, bgJ.get(i3));
            }
            this.eeC.a((ba.b) sparseArray.get(w.h.tag_holder), bgJ.get(i3), this.erS.bgQ() > bgJ.size() || bgJ.size() - i3 > 1, i3 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i3++;
            i4 += view.getMeasuredHeight();
        }
        if (bgJ != null && bgJ.size() > 0 && this.erS.bgQ() > this.erR) {
            this.erU.setText(String.format(TbadkCoreApplication.m9getInst().getApp().getString(w.l.sub_pb_load_more), Integer.valueOf(this.erS.bgQ() - this.erR)));
            this.erU.setOnClickListener(this.erO);
            SparseArray sparseArray4 = (SparseArray) this.erU.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.erU.setTag(sparseArray4);
            }
            sparseArray4.put(w.h.tag_load_sub_data, this.erS);
            sparseArray4.put(w.h.tag_load_sub_view, this.mRootView);
            this.erU.setVisibility(0);
            this.erU.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.erU.setVisibility(8);
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i4 + (this.erU.getVisibility() == 0 ? this.erU.getMeasuredHeight() : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.erS != null && this.erS.bgJ() != null) {
            int size = this.erT.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.erT.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.erV, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.erR;
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
            if (this.erU.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.erU.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.erU.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.erU.getMeasuredWidth(), this.erU.getMeasuredHeight() + i11);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.erS != null && this.erS.bgJ() != null) {
            int i = this.erR;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.erU.getVisibility() == 0) {
                drawChild(canvas, this.erU, drawingTime);
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
    /* renamed from: aNd */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
