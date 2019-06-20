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
import com.baidu.tbadk.core.util.al;
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
    private PostData cbi;
    private TextView dHl;
    private c hHh;
    private View.OnClickListener hUJ;
    private View.OnLongClickListener hUK;
    private View.OnTouchListener hUL;
    private int hUM;
    private final Queue<a> hUN;
    private RelativeLayout hUO;
    private ViewGroup.MarginLayoutParams hUP;
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
        this.hUM = 0;
        this.mRootView = null;
        this.hUN = new LinkedList();
        this.hUP = new ViewGroup.MarginLayoutParams(-1, -2);
        this.hUO = new RelativeLayout(context);
        this.hUO.setId(R.id.pb_floor_reply_more);
        this.dHl = new TextView(context);
        this.dHl.setPadding(0, l.g(context, R.dimen.tbds2), 0, l.g(context, R.dimen.tbds12));
        this.dHl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
        this.dHl.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.dHl.setTextSize(0, l.g(context, R.dimen.tbds40));
        al.j(this.dHl, R.color.cp_cont_c);
        this.hUO.addView(this.dHl);
        addView(this.hUO, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.hUJ = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.hUK = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.hUL = onTouchListener;
    }

    public void setSubPbAdapter(c cVar) {
        this.hHh = cVar;
    }

    public void setData(PostData postData, View view) {
        this.cbi = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> cmu;
        if (this.hHh == null || this.cbi == null || this.cbi.cmu() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.cbi.cmt()) {
            cmu = this.cbi.cmq();
        } else {
            cmu = this.cbi.cmu();
        }
        setMeasuredDimension(size, cd(v.Z(cmu), size) + n(cmu, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int n(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.cbi.cmJ() == 1 || this.cbi.cmJ() == 3) {
            this.hUM = 0;
            return 0;
        } else if (v.Z(list) != 0) {
            int Z = v.Z(list);
            this.hUM = Z;
            if (!this.cbi.cmt()) {
                if (Z <= 2) {
                    this.hUM = Z;
                } else {
                    this.hUM = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.hUM) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.hUO)) {
                    childAt = this.hHh.nG();
                    childAt.setPadding(0, 0, 0, 0);
                    this.hUN.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.hUJ);
                view.setOnLongClickListener(this.hUK);
                view.setOnTouchListener(this.hUL);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.cbi) {
                    sparseArray.put(R.id.tag_load_sub_data, this.cbi);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).adv() != null) {
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).adv().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).adv().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                this.hHh.a((c.b) sparseArray.get(R.id.tag_holder), list.get(i2), this.cbi.cmB() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cd(int i, int i2) {
        if (i > 0 && (this.cbi.cmJ() == 1 || this.cbi.cmJ() == 3 || this.cbi.cmB() > this.hUM)) {
            this.dHl.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.cbi.cmB())));
            this.hUO.setOnClickListener(this.hUJ);
            SparseArray sparseArray = (SparseArray) this.hUO.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.hUO.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.cbi);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.hUO.setVisibility(0);
            this.hUO.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.hUO.setVisibility(8);
        }
        if (this.hUO.getVisibility() == 0) {
            return this.hUO.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.cbi != null && this.cbi.cmu() != null) {
            int size = this.hUN.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.hUN.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.hUP, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.hUM;
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
            if (this.hUO.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hUO.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.hUO.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.hUO.getMeasuredWidth(), this.hUO.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.hUM; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.hUO) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.cbi != null && this.cbi.cmu() != null) {
            int i = this.hUM;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.hUO.getVisibility() == 0) {
                drawChild(canvas, this.hUO, drawingTime);
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
    /* renamed from: bWx */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.dHl != null) {
            this.dHl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            al.j(this.dHl, R.color.cp_cont_c);
        }
    }
}
