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
    private PostData cdl;
    private TextView dMM;
    private c hQl;
    private View.OnClickListener idV;
    private View.OnLongClickListener idW;
    private View.OnTouchListener idX;
    private int idY;
    private final Queue<a> idZ;
    private RelativeLayout iea;
    private ViewGroup.MarginLayoutParams ieb;
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
        this.idY = 0;
        this.mRootView = null;
        this.idZ = new LinkedList();
        this.ieb = new ViewGroup.MarginLayoutParams(-1, -2);
        this.iea = new RelativeLayout(context);
        this.iea.setId(R.id.pb_floor_reply_more);
        this.dMM = new TextView(context);
        this.dMM.setPadding(0, l.g(context, R.dimen.tbds2), 0, l.g(context, R.dimen.tbds12));
        this.dMM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.dMM.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.dMM.setTextSize(0, l.g(context, R.dimen.tbds40));
        am.j(this.dMM, R.color.cp_cont_c);
        this.iea.addView(this.dMM);
        addView(this.iea, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.idV = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.idW = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.idX = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.hQl = cVar;
    }

    public void setData(PostData postData, View view) {
        this.cdl = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> cqw;
        if (this.hQl == null || this.cdl == null || this.cdl.cqw() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.cdl.cqv()) {
            cqw = this.cdl.cqs();
        } else {
            cqw = this.cdl.cqw();
        }
        setMeasuredDimension(size, cj(v.Z(cqw), size) + n(cqw, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.cdl.cqL() == 1 || this.cdl.cqL() == 3) {
            this.idY = 0;
            return 0;
        } else if (v.Z(list) != 0) {
            int Z = v.Z(list);
            this.idY = Z;
            if (!this.cdl.cqv()) {
                if (Z <= 2) {
                    this.idY = Z;
                } else {
                    this.idY = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.idY) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.iea)) {
                    childAt = this.hQl.nZ();
                    childAt.setPadding(0, 0, 0, 0);
                    this.idZ.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.idV);
                view.setOnLongClickListener(this.idW);
                view.setOnTouchListener(this.idX);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.cdl) {
                    sparseArray.put(R.id.tag_load_sub_data, this.cdl);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).aeC() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).aeC().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).aeC().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.hQl.a((c.b) sparseArray.get(R.id.tag_holder), list.get(i2), this.cdl.cqD() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cj(int i, int i2) {
        if (i > 0 && (this.cdl.cqL() == 1 || this.cdl.cqL() == 3 || this.cdl.cqD() > this.idY)) {
            this.dMM.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.cdl.cqD())));
            this.iea.setOnClickListener(this.idV);
            SparseArray sparseArray = (SparseArray) this.iea.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.iea.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.cdl);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.iea.setVisibility(0);
            this.iea.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.iea.setVisibility(8);
        }
        if (this.iea.getVisibility() == 0) {
            return this.iea.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.cdl != null && this.cdl.cqw() != null) {
            int size = this.idZ.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.idZ.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.ieb, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.idY;
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
            if (this.iea.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iea.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.iea.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.iea.getMeasuredWidth(), this.iea.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.idY; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.iea) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.cdl != null && this.cdl.cqw() != null) {
            int i = this.idY;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.iea.getVisibility() == 0) {
                drawChild(canvas, this.iea, drawingTime);
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
    /* renamed from: caq */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.dMM != null) {
            this.dMM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            am.j(this.dMM, R.color.cp_cont_c);
        }
    }
}
