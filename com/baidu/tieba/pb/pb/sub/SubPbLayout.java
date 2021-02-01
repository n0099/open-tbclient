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
/* loaded from: classes2.dex */
public class SubPbLayout extends ViewGroup {
    private TextView bRf;
    private PostData flc;
    private b lON;
    private boolean lOO;
    private View mRootView;
    private RelativeLayout mhA;
    private ViewGroup.MarginLayoutParams mhB;
    SparseArray<Object> mhC;
    private View.OnClickListener mhv;
    private View.OnLongClickListener mhw;
    private View.OnTouchListener mhx;
    private int mhy;
    private final Queue<a> mhz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
        this.mhy = 0;
        this.mRootView = null;
        this.mhz = new LinkedList();
        this.lOO = false;
        this.mhB = new ViewGroup.MarginLayoutParams(-1, -2);
        this.mhA = new RelativeLayout(context);
        this.mhA.setId(R.id.pb_floor_reply_more);
        this.bRf = new TextView(context);
        this.bRf.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.bRf.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.lOO) {
            ap.setViewTextColor(this.bRf, R.color.CAM_X0304);
            this.bRf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ap.setViewTextColor(this.bRf, R.color.CAM_X0108);
            this.bRf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.bRf.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.mhA.addView(this.bRf);
        addView(this.mhA, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.mhv = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mhw = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mhx = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.lON = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.lOO = z;
    }

    public void setData(PostData postData, View view) {
        this.flc = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dNu;
        if (this.lON == null || this.flc == null || this.flc.dNu() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.flc.dNt()) {
            dNu = this.flc.dNq();
        } else {
            dNu = this.flc.dNu();
        }
        setMeasuredDimension(size, db(y.getCount(dNu), size) + q(dNu, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        int bji = com.baidu.tbadk.a.d.bji();
        if (this.flc.dNJ() == 1 || this.flc.dNJ() == 3) {
            this.mhy = 0;
            return 0;
        } else if (y.getCount(list) != 0) {
            int count = y.getCount(list);
            this.mhy = count;
            if (!this.flc.dNt()) {
                if (count <= bji) {
                    this.mhy = count;
                } else {
                    this.mhy = bji;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.mhy) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.mhA)) {
                    childAt = this.lON.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.mhz.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.mhv);
                if (!this.lOO) {
                    view.setOnLongClickListener(this.mhw);
                }
                view.setOnTouchListener(this.mhx);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.flc) {
                    sparseArray.put(R.id.tag_load_sub_data, this.flc);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).bnQ() != null) {
                    if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i2)) {
                        sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i2));
                    }
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).bnQ().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).bnQ().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                if (this.mhC != null) {
                    sparseArray.put(-1, this.mhC.get(-1));
                    sparseArray.put(-2, this.mhC.get(-2));
                    sparseArray.put(-3, this.mhC.get(-3));
                    sparseArray.put(-4, this.mhC.get(-4));
                }
                b.C0840b c0840b = (b.C0840b) sparseArray.get(R.id.tag_holder);
                this.lON.a(c0840b, list.get(i2), this.flc.dNB() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0840b.lQq.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                this.bRf.setTextSize(0, TbConfig.getContentSizeOfLzl());
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int db(int i, int i2) {
        String format;
        if (i > 0 && (this.flc.dNJ() == 1 || this.flc.dNJ() == 3 || this.flc.dNB() > this.mhy)) {
            if (this.lOO) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.flc.dNB()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.flc.dNB()));
            }
            this.bRf.setText(format);
            this.mhA.setOnClickListener(this.mhv);
            SparseArray sparseArray = (SparseArray) this.mhA.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.mhA.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.flc);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.mhA.setVisibility(0);
            this.mhA.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.mhA.setVisibility(8);
        }
        if (this.mhA.getVisibility() == 0) {
            return this.mhA.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 0;
        if (this.flc != null && this.flc.dNu() != null) {
            int size = this.mhz.size();
            for (int i7 = 0; i7 < size; i7++) {
                a poll = this.mhz.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.mhB, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i8 = this.mhy;
            while (i6 < i8) {
                View childAt = getChildAt(i6);
                if (childAt == null) {
                    i5 = paddingTop;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    if (marginLayoutParams == null) {
                        marginLayoutParams = generateDefaultLayoutParams();
                    }
                    int i9 = paddingTop + marginLayoutParams.topMargin;
                    int measuredWidth = marginLayoutParams.leftMargin + paddingLeft + childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight() + i9;
                    childAt.layout(marginLayoutParams.leftMargin + paddingLeft, i9, measuredWidth, measuredHeight);
                    i5 = marginLayoutParams.bottomMargin + measuredHeight;
                }
                i6++;
                paddingTop = i5;
            }
            if (this.mhA.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mhA.getLayoutParams();
                int i10 = paddingTop + marginLayoutParams2.topMargin;
                this.mhA.layout(marginLayoutParams2.leftMargin + paddingLeft, i10, marginLayoutParams2.leftMargin + paddingLeft + this.mhA.getMeasuredWidth(), this.mhA.getMeasuredHeight() + i10);
            }
            int childCount = getChildCount();
            for (int i11 = this.mhy; i11 < childCount; i11++) {
                View childAt2 = getChildAt(i11);
                if (childAt2 != null && childAt2 != this.mhA) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.flc != null && this.flc.dNu() != null) {
            int i = this.mhy;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.mhA.getVisibility() == 0) {
                drawChild(canvas, this.mhA, drawingTime);
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
    /* renamed from: dsY */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bRf != null) {
            if (this.lOO) {
                ap.setViewTextColor(this.bRf, R.color.CAM_X0304);
                this.bRf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.bRf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ap.setViewTextColor(this.bRf, R.color.CAM_X0108);
        }
    }

    public void setDefaultTag(SparseArray<Object> sparseArray) {
        this.mhC = sparseArray;
    }
}
