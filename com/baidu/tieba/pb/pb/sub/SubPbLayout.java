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
    private PostData aEY;
    private TextView cgU;
    private c fYA;
    private View.OnClickListener glL;
    private View.OnLongClickListener glM;
    private View.OnTouchListener glN;
    private int glO;
    private final Queue<a> glP;
    private RelativeLayout glQ;
    private ViewGroup.MarginLayoutParams glR;
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
        this.glO = 0;
        this.mRootView = null;
        this.glP = new LinkedList();
        this.glR = new ViewGroup.MarginLayoutParams(-1, -2);
        this.glQ = new RelativeLayout(context);
        this.glQ.setId(e.g.pb_floor_reply_more);
        this.cgU = new TextView(context);
        this.cgU.setPadding(0, l.h(context, e.C0210e.tbds14), 0, l.h(context, e.C0210e.tbds22));
        this.cgU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_lou_more), (Drawable) null);
        this.cgU.setTextSize(0, l.h(context, e.C0210e.tbfontsize42));
        al.h(this.cgU, e.d.cp_cont_d);
        this.glQ.addView(this.cgU);
        addView(this.glQ, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.glL = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.glM = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.glN = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.fYA = cVar;
    }

    public void setData(PostData postData, View view) {
        this.aEY = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bEg;
        if (this.fYA == null || this.aEY == null || this.aEY.bEg() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.aEY.bEf()) {
            bEg = this.aEY.bEc();
        } else {
            bEg = this.aEY.bEg();
        }
        setMeasuredDimension(size, bA(v.H(bEg), size) + o(bEg, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int o(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.aEY.bEv() == 1 || this.aEY.bEv() == 3) {
            this.glO = 0;
            return 0;
        } else if (v.H(list) != 0) {
            int H = v.H(list);
            this.glO = H;
            if (!this.aEY.bEf()) {
                if (H <= 2) {
                    this.glO = H;
                } else {
                    this.glO = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.glO) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.glQ)) {
                    childAt = this.fYA.oD();
                    childAt.setPadding(0, 0, 0, 0);
                    this.glP.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.glL);
                view.setOnLongClickListener(this.glM);
                view.setOnTouchListener(this.glN);
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
                if (sparseArray.get(e.g.tag_load_sub_data) != this.aEY) {
                    sparseArray.put(e.g.tag_load_sub_data, this.aEY);
                }
                sparseArray.put(e.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(e.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).zG() != null) {
                    sparseArray.put(e.g.tag_photo_username, list.get(i2).zG().getUserName());
                    sparseArray.put(e.g.tag_photo_userid, list.get(i2).zG().getUserId());
                    sparseArray.put(e.g.tag_clip_board, list.get(i2));
                }
                this.fYA.a((c.b) sparseArray.get(e.g.tag_holder), list.get(i2), this.aEY.bEn() > list.size() || list.size() - i2 > 1, i2 == 0, false);
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
        if (i > 0 && (this.aEY.bEv() == 1 || this.aEY.bEv() == 3 || this.aEY.bEn() > this.glO)) {
            this.cgU.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(e.j.sub_pb_load_more), Integer.valueOf(this.aEY.bEn())));
            this.glQ.setOnClickListener(this.glL);
            SparseArray sparseArray = (SparseArray) this.glQ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.glQ.setTag(sparseArray);
            }
            sparseArray.put(e.g.tag_load_sub_data, this.aEY);
            sparseArray.put(e.g.tag_load_sub_view, this.mRootView);
            this.glQ.setVisibility(0);
            this.glQ.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + AiAppsFileUtils.GB, 0);
        } else {
            this.glQ.setVisibility(8);
        }
        if (this.glQ.getVisibility() == 0) {
            return this.glQ.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.aEY != null && this.aEY.bEg() != null) {
            int size = this.glP.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.glP.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.glR, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.glO;
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
            if (this.glQ.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.glQ.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.glQ.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.glQ.getMeasuredWidth(), this.glQ.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.glO; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.glQ) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.aEY != null && this.aEY.bEg() != null) {
            int i = this.glO;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.glQ.getVisibility() == 0) {
                drawChild(canvas, this.glQ, drawingTime);
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
    /* renamed from: bny */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.cgU != null) {
            this.cgU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_lou_more), (Drawable) null);
            al.h(this.cgU, e.d.cp_cont_d);
        }
    }
}
