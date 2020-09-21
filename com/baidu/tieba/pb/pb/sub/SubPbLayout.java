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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes21.dex */
public class SubPbLayout extends ViewGroup {
    private PostData ewM;
    private TextView gvX;
    private b kJB;
    private boolean kJD;
    private View.OnClickListener lbI;
    private View.OnLongClickListener lbJ;
    private View.OnTouchListener lbK;
    private int lbL;
    private final Queue<a> lbM;
    private RelativeLayout lbN;
    private ViewGroup.MarginLayoutParams lbO;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
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
        this.lbL = 0;
        this.mRootView = null;
        this.lbM = new LinkedList();
        this.kJD = false;
        this.lbO = new ViewGroup.MarginLayoutParams(-1, -2);
        this.lbN = new RelativeLayout(context);
        this.lbN.setId(R.id.pb_floor_reply_more);
        this.gvX = new TextView(context);
        this.gvX.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.gvX.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.kJD) {
            ap.setViewTextColor(this.gvX, R.color.cp_link_tip_c);
            this.gvX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ap.setViewTextColor(this.gvX, R.color.cp_cont_c);
            this.gvX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.gvX.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.lbN.addView(this.gvX);
        addView(this.lbN, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.lbI = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lbJ = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.lbK = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.kJB = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.kJD = z;
    }

    public void setData(PostData postData, View view) {
        this.ewM = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dAA;
        if (this.kJB == null || this.ewM == null || this.ewM.dAA() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.ewM.dAz()) {
            dAA = this.ewM.dAw();
        } else {
            dAA = this.ewM.dAA();
        }
        setMeasuredDimension(size, cZ(y.getCount(dAA), size) + q(dAA, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.ewM.dAP() == 1 || this.ewM.dAP() == 3) {
            this.lbL = 0;
            return 0;
        } else if (y.getCount(list) != 0) {
            int count = y.getCount(list);
            this.lbL = count;
            if (!this.ewM.dAz()) {
                if (count <= 2) {
                    this.lbL = count;
                } else {
                    this.lbL = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.lbL) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.lbN)) {
                    childAt = this.kJB.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.lbM.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.lbI);
                if (!this.kJD) {
                    view.setOnLongClickListener(this.lbJ);
                }
                view.setOnTouchListener(this.lbK);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.ewM) {
                    sparseArray.put(R.id.tag_load_sub_data, this.ewM);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).bfy() != null) {
                    if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i2)) {
                        sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i2));
                    }
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).bfy().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).bfy().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                b.C0771b c0771b = (b.C0771b) sparseArray.get(R.id.tag_holder);
                this.kJB.a(c0771b, list.get(i2), this.ewM.dAH() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0771b.kKX.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                this.gvX.setTextSize(0, TbConfig.getContentSizeOfLzl());
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cZ(int i, int i2) {
        String format;
        if (i > 0 && (this.ewM.dAP() == 1 || this.ewM.dAP() == 3 || this.ewM.dAH() > this.lbL)) {
            if (this.kJD) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.ewM.dAH()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.ewM.dAH()));
            }
            this.gvX.setText(format);
            this.lbN.setOnClickListener(this.lbI);
            SparseArray sparseArray = (SparseArray) this.lbN.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.lbN.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.ewM);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.lbN.setVisibility(0);
            this.lbN.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.lbN.setVisibility(8);
        }
        if (this.lbN.getVisibility() == 0) {
            return this.lbN.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.ewM != null && this.ewM.dAA() != null) {
            int size = this.lbM.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.lbM.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.lbO, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.lbL;
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
            if (this.lbN.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lbN.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.lbN.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.lbN.getMeasuredWidth(), this.lbN.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.lbL; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.lbN) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.ewM != null && this.ewM.dAA() != null) {
            int i = this.lbL;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.lbN.getVisibility() == 0) {
                drawChild(canvas, this.lbN, drawingTime);
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
    /* renamed from: dgB */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.gvX != null) {
            if (this.kJD) {
                ap.setViewTextColor(this.gvX, R.color.cp_link_tip_c);
                this.gvX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.gvX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ap.setViewTextColor(this.gvX, R.color.cp_cont_c);
        }
    }
}
