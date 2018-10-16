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
    private PostData aAI;
    private TextView ccI;
    private c fNs;
    private View.OnClickListener gaF;
    private View.OnLongClickListener gaG;
    private View.OnTouchListener gaH;
    private int gaI;
    private final Queue<a> gaJ;
    private RelativeLayout gaK;
    private ViewGroup.MarginLayoutParams gaL;
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
        this.gaI = 0;
        this.mRootView = null;
        this.gaJ = new LinkedList();
        this.gaL = new ViewGroup.MarginLayoutParams(-1, -2);
        this.gaK = new RelativeLayout(context);
        this.gaK.setId(e.g.pb_floor_reply_more);
        this.ccI = new TextView(context);
        this.ccI.setPadding(0, l.h(context, e.C0175e.tbds14), 0, l.h(context, e.C0175e.tbds22));
        this.ccI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_lou_more), (Drawable) null);
        this.ccI.setTextSize(0, l.h(context, e.C0175e.tbfontsize42));
        al.h(this.ccI, e.d.cp_cont_d);
        this.gaK.addView(this.ccI);
        addView(this.gaK, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.gaF = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.gaG = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.gaH = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.fNs = cVar;
    }

    public void setData(PostData postData, View view) {
        this.aAI = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bBY;
        if (this.fNs == null || this.aAI == null || this.aAI.bBY() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.aAI.bBX()) {
            bBY = this.aAI.bBU();
        } else {
            bBY = this.aAI.bBY();
        }
        setMeasuredDimension(size, bz(v.I(bBY), size) + o(bBY, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int o(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.aAI.bCn() == 1) {
            this.gaI = 0;
            return 0;
        } else if (v.I(list) != 0) {
            int I = v.I(list);
            this.gaI = I;
            if (!this.aAI.bBX()) {
                if (I <= 2) {
                    this.gaI = I;
                } else {
                    this.gaI = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.gaI) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.gaK)) {
                    childAt = this.fNs.oG();
                    childAt.setPadding(0, 0, 0, 0);
                    this.gaJ.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.gaF);
                view.setOnLongClickListener(this.gaG);
                view.setOnTouchListener(this.gaH);
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
                if (sparseArray.get(e.g.tag_load_sub_data) != this.aAI) {
                    sparseArray.put(e.g.tag_load_sub_data, this.aAI);
                }
                sparseArray.put(e.g.tag_load_sub_view, this.mRootView);
                sparseArray.put(e.g.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).yv() != null) {
                    sparseArray.put(e.g.tag_photo_username, list.get(i2).yv().getUserName());
                    sparseArray.put(e.g.tag_photo_userid, list.get(i2).yv().getUserId());
                    sparseArray.put(e.g.tag_clip_board, list.get(i2));
                }
                this.fNs.a((c.b) sparseArray.get(e.g.tag_holder), list.get(i2), this.aAI.bCf() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + AiAppsFileUtils.GB, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int bz(int i, int i2) {
        if (i > 0 && (this.aAI.bCn() == 1 || this.aAI.bCf() > this.gaI)) {
            this.ccI.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(e.j.sub_pb_load_more), Integer.valueOf(this.aAI.bCf())));
            this.gaK.setOnClickListener(this.gaF);
            SparseArray sparseArray = (SparseArray) this.gaK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.gaK.setTag(sparseArray);
            }
            sparseArray.put(e.g.tag_load_sub_data, this.aAI);
            sparseArray.put(e.g.tag_load_sub_view, this.mRootView);
            this.gaK.setVisibility(0);
            this.gaK.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + AiAppsFileUtils.GB, 0);
        } else {
            this.gaK.setVisibility(8);
        }
        if (this.gaK.getVisibility() == 0) {
            return this.gaK.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.aAI != null && this.aAI.bBY() != null) {
            int size = this.gaJ.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.gaJ.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.gaL, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.gaI;
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
            if (this.gaK.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gaK.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.gaK.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.gaK.getMeasuredWidth(), this.gaK.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.gaI; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.gaK) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.aAI != null && this.aAI.bBY() != null) {
            int i = this.gaI;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.gaK.getVisibility() == 0) {
                drawChild(canvas, this.gaK, drawingTime);
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
    /* renamed from: bly */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.ccI != null) {
            this.ccI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_lou_more), (Drawable) null);
            al.h(this.ccI, e.d.cp_cont_d);
        }
    }
}
