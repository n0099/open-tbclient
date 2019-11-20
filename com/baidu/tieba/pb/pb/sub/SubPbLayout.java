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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes4.dex */
public class SubPbLayout extends ViewGroup {
    private PostData cqH;
    private TextView eaG;
    private c hNZ;
    private View.OnClickListener ibJ;
    private View.OnLongClickListener ibK;
    private View.OnTouchListener ibL;
    private int ibM;
    private final Queue<a> ibN;
    private RelativeLayout ibO;
    private ViewGroup.MarginLayoutParams ibP;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
        this.ibM = 0;
        this.mRootView = null;
        this.ibN = new LinkedList();
        this.ibP = new ViewGroup.MarginLayoutParams(-1, -2);
        this.ibO = new RelativeLayout(context);
        this.ibO.setId(R.id.pb_floor_reply_more);
        this.eaG = new TextView(context);
        this.eaG.setPadding(0, l.getDimens(context, R.dimen.tbds2), 0, l.getDimens(context, R.dimen.tbds12));
        this.eaG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.eaG.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.eaG.setTextSize(0, l.getDimens(context, R.dimen.tbds40));
        am.setViewTextColor(this.eaG, (int) R.color.cp_cont_c);
        this.ibO.addView(this.eaG);
        addView(this.ibO, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.ibJ = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ibK = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.ibL = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.hNZ = cVar;
    }

    public void setData(PostData postData, View view) {
        this.cqH = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> cok;
        if (this.hNZ == null || this.cqH == null || this.cqH.cok() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.cqH.coj()) {
            cok = this.cqH.cog();
        } else {
            cok = this.cqH.cok();
        }
        setMeasuredDimension(size, ca(v.getCount(cok), size) + l(cok, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int l(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.cqH.coz() == 1 || this.cqH.coz() == 3) {
            this.ibM = 0;
            return 0;
        } else if (v.getCount(list) != 0) {
            int count = v.getCount(list);
            this.ibM = count;
            if (!this.cqH.coj()) {
                if (count <= 2) {
                    this.ibM = count;
                } else {
                    this.ibM = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.ibM) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.ibO)) {
                    childAt = this.hNZ.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.ibN.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.ibJ);
                view.setOnLongClickListener(this.ibK);
                view.setOnTouchListener(this.ibL);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.cqH) {
                    sparseArray.put(R.id.tag_load_sub_data, this.cqH);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).aiE() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).aiE().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).aiE().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.hNZ.a((c.b) sparseArray.get(R.id.tag_holder), list.get(i2), this.cqH.cor() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int ca(int i, int i2) {
        if (i > 0 && (this.cqH.coz() == 1 || this.cqH.coz() == 3 || this.cqH.cor() > this.ibM)) {
            this.eaG.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.cqH.cor())));
            this.ibO.setOnClickListener(this.ibJ);
            SparseArray sparseArray = (SparseArray) this.ibO.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.ibO.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.cqH);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.ibO.setVisibility(0);
            this.ibO.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.ibO.setVisibility(8);
        }
        if (this.ibO.getVisibility() == 0) {
            return this.ibO.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.cqH != null && this.cqH.cok() != null) {
            int size = this.ibN.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.ibN.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.ibP, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.ibM;
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
            if (this.ibO.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ibO.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.ibO.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.ibO.getMeasuredWidth(), this.ibO.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.ibM; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.ibO) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.cqH != null && this.cqH.cok() != null) {
            int i = this.ibM;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.ibO.getVisibility() == 0) {
                drawChild(canvas, this.ibO, drawingTime);
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
    /* renamed from: bXr */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.eaG != null) {
            this.eaG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            am.setViewTextColor(this.eaG, (int) R.color.cp_cont_c);
        }
    }
}
