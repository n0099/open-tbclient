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
    private PostData ccr;
    private TextView dLb;
    private c hOo;
    private View.OnClickListener ibT;
    private View.OnLongClickListener ibU;
    private View.OnTouchListener ibV;
    private int ibW;
    private final Queue<a> ibX;
    private RelativeLayout ibY;
    private ViewGroup.MarginLayoutParams ibZ;
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
        this.ibW = 0;
        this.mRootView = null;
        this.ibX = new LinkedList();
        this.ibZ = new ViewGroup.MarginLayoutParams(-1, -2);
        this.ibY = new RelativeLayout(context);
        this.ibY.setId(R.id.pb_floor_reply_more);
        this.dLb = new TextView(context);
        this.dLb.setPadding(0, l.g(context, R.dimen.tbds2), 0, l.g(context, R.dimen.tbds12));
        this.dLb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.dLb.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.dLb.setTextSize(0, l.g(context, R.dimen.tbds40));
        am.j(this.dLb, R.color.cp_cont_c);
        this.ibY.addView(this.dLb);
        addView(this.ibY, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.ibT = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ibU = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.ibV = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.hOo = cVar;
    }

    public void setData(PostData postData, View view) {
        this.ccr = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> cpI;
        if (this.hOo == null || this.ccr == null || this.ccr.cpI() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.ccr.cpH()) {
            cpI = this.ccr.cpE();
        } else {
            cpI = this.ccr.cpI();
        }
        setMeasuredDimension(size, cj(v.Z(cpI), size) + n(cpI, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.ccr.cpX() == 1 || this.ccr.cpX() == 3) {
            this.ibW = 0;
            return 0;
        } else if (v.Z(list) != 0) {
            int Z = v.Z(list);
            this.ibW = Z;
            if (!this.ccr.cpH()) {
                if (Z <= 2) {
                    this.ibW = Z;
                } else {
                    this.ibW = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.ibW) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.ibY)) {
                    childAt = this.hOo.nZ();
                    childAt.setPadding(0, 0, 0, 0);
                    this.ibX.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.ibT);
                view.setOnLongClickListener(this.ibU);
                view.setOnTouchListener(this.ibV);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.ccr) {
                    sparseArray.put(R.id.tag_load_sub_data, this.ccr);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).aey() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).aey().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).aey().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.hOo.a((c.b) sparseArray.get(R.id.tag_holder), list.get(i2), this.ccr.cpP() > list.size() || list.size() - i2 > 1, i2 == 0, false);
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
        if (i > 0 && (this.ccr.cpX() == 1 || this.ccr.cpX() == 3 || this.ccr.cpP() > this.ibW)) {
            this.dLb.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.ccr.cpP())));
            this.ibY.setOnClickListener(this.ibT);
            SparseArray sparseArray = (SparseArray) this.ibY.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.ibY.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.ccr);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.ibY.setVisibility(0);
            this.ibY.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.ibY.setVisibility(8);
        }
        if (this.ibY.getVisibility() == 0) {
            return this.ibY.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.ccr != null && this.ccr.cpI() != null) {
            int size = this.ibX.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.ibX.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.ibZ, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.ibW;
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
            if (this.ibY.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ibY.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.ibY.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.ibY.getMeasuredWidth(), this.ibY.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.ibW; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.ibY) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.ccr != null && this.ccr.cpI() != null) {
            int i = this.ibW;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.ibY.getVisibility() == 0) {
                drawChild(canvas, this.ibY, drawingTime);
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
    /* renamed from: bZC */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.dLb != null) {
            this.dLb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            am.j(this.dLb, R.color.cp_cont_c);
        }
    }
}
