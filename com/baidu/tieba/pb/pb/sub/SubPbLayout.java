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
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes6.dex */
public class SubPbLayout extends ViewGroup {
    private PostData aFA;
    private TextView chF;
    private c fZx;
    private View.OnClickListener gmO;
    private View.OnLongClickListener gmP;
    private View.OnTouchListener gmQ;
    private int gmR;
    private final Queue<a> gmS;
    private RelativeLayout gmT;
    private ViewGroup.MarginLayoutParams gmU;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
        this.gmR = 0;
        this.mRootView = null;
        this.gmS = new LinkedList();
        this.gmU = new ViewGroup.MarginLayoutParams(-1, -2);
        this.gmT = new RelativeLayout(context);
        this.gmT.setId(e.g.pb_floor_reply_more);
        this.chF = new TextView(context);
        this.chF.setPadding(0, l.h(context, e.C0210e.tbds14), 0, l.h(context, e.C0210e.tbds22));
        this.chF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_lou_more), (Drawable) null);
        this.chF.setTextSize(0, l.h(context, e.C0210e.tbfontsize42));
        al.h(this.chF, e.d.cp_cont_d);
        this.gmT.addView(this.chF);
        addView(this.gmT, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.gmO = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.gmP = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.gmQ = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.fZx = cVar;
    }

    public void setData(PostData postData, View view) {
        this.aFA = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bEP;
        if (this.fZx == null || this.aFA == null || this.aFA.bEP() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.aFA.bEO()) {
            bEP = this.aFA.bEL();
        } else {
            bEP = this.aFA.bEP();
        }
        setMeasuredDimension(size, bA(v.H(bEP), size) + o(bEP, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int o(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.aFA.bFe() == 1 || this.aFA.bFe() == 3) {
            this.gmR = 0;
            return 0;
        } else if (v.H(list) != 0) {
            int H = v.H(list);
            this.gmR = H;
            if (!this.aFA.bEO()) {
                if (H <= 2) {
                    this.gmR = H;
                } else {
                    this.gmR = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.gmR) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.gmT)) {
                    childAt = this.fZx.oH();
                    childAt.setPadding(0, 0, 0, 0);
                    this.gmS.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.gmO);
                view.setOnLongClickListener(this.gmP);
                view.setOnTouchListener(this.gmQ);
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
                if (sparseArray.get(e.g.tag_load_sub_data) != this.aFA) {
                    sparseArray.put(e.g.tag_load_sub_data, this.aFA);
                }
                sparseArray.put(e.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(e.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).zT() != null) {
                    sparseArray.put(e.g.tag_photo_username, list.get(i2).zT().getUserName());
                    sparseArray.put(e.g.tag_photo_userid, list.get(i2).zT().getUserId());
                    sparseArray.put(e.g.tag_clip_board, list.get(i2));
                }
                this.fZx.a((c.b) sparseArray.get(e.g.tag_holder), list.get(i2), this.aFA.bEW() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + AiAppsFileUtils.GB, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int bA(int i, int i2) {
        if (i > 0 && (this.aFA.bFe() == 1 || this.aFA.bFe() == 3 || this.aFA.bEW() > this.gmR)) {
            this.chF.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(e.j.sub_pb_load_more), Integer.valueOf(this.aFA.bEW())));
            this.gmT.setOnClickListener(this.gmO);
            SparseArray sparseArray = (SparseArray) this.gmT.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.gmT.setTag(sparseArray);
            }
            sparseArray.put(e.g.tag_load_sub_data, this.aFA);
            sparseArray.put(e.g.tag_load_sub_view, this.mRootView);
            this.gmT.setVisibility(0);
            this.gmT.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + AiAppsFileUtils.GB, 0);
        } else {
            this.gmT.setVisibility(8);
        }
        if (this.gmT.getVisibility() == 0) {
            return this.gmT.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.aFA != null && this.aFA.bEP() != null) {
            int size = this.gmS.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.gmS.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.gmU, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.gmR;
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
            if (this.gmT.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gmT.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.gmT.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.gmT.getMeasuredWidth(), this.gmT.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.gmR; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.gmT) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.aFA != null && this.aFA.bEP() != null) {
            int i = this.gmR;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.gmT.getVisibility() == 0) {
                drawChild(canvas, this.gmT, drawingTime);
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
    /* renamed from: bog */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.chF != null) {
            this.chF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_lou_more), (Drawable) null);
            al.h(this.chF, e.d.cp_cont_d);
        }
    }
}
