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
    private b lPc;
    private boolean lPd;
    private View mRootView;
    private View.OnClickListener mhK;
    private View.OnLongClickListener mhL;
    private View.OnTouchListener mhM;
    private int mhN;
    private final Queue<a> mhO;
    private RelativeLayout mhP;
    private ViewGroup.MarginLayoutParams mhQ;
    SparseArray<Object> mhR;

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
        this.mhN = 0;
        this.mRootView = null;
        this.mhO = new LinkedList();
        this.lPd = false;
        this.mhQ = new ViewGroup.MarginLayoutParams(-1, -2);
        this.mhP = new RelativeLayout(context);
        this.mhP.setId(R.id.pb_floor_reply_more);
        this.bRf = new TextView(context);
        this.bRf.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.bRf.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.lPd) {
            ap.setViewTextColor(this.bRf, R.color.CAM_X0304);
            this.bRf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ap.setViewTextColor(this.bRf, R.color.CAM_X0108);
            this.bRf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.bRf.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.mhP.addView(this.bRf);
        addView(this.mhP, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.mhK = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mhL = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mhM = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.lPc = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.lPd = z;
    }

    public void setData(PostData postData, View view) {
        this.flc = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dNC;
        if (this.lPc == null || this.flc == null || this.flc.dNC() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.flc.dNB()) {
            dNC = this.flc.dNy();
        } else {
            dNC = this.flc.dNC();
        }
        setMeasuredDimension(size, dc(y.getCount(dNC), size) + q(dNC, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        int bji = com.baidu.tbadk.a.d.bji();
        if (this.flc.dNR() == 1 || this.flc.dNR() == 3) {
            this.mhN = 0;
            return 0;
        } else if (y.getCount(list) != 0) {
            int count = y.getCount(list);
            this.mhN = count;
            if (!this.flc.dNB()) {
                if (count <= bji) {
                    this.mhN = count;
                } else {
                    this.mhN = bji;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.mhN) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.mhP)) {
                    childAt = this.lPc.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.mhO.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.mhK);
                if (!this.lPd) {
                    view.setOnLongClickListener(this.mhL);
                }
                view.setOnTouchListener(this.mhM);
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
                if (this.mhR != null) {
                    sparseArray.put(-1, this.mhR.get(-1));
                    sparseArray.put(-2, this.mhR.get(-2));
                    sparseArray.put(-3, this.mhR.get(-3));
                    sparseArray.put(-4, this.mhR.get(-4));
                }
                b.C0841b c0841b = (b.C0841b) sparseArray.get(R.id.tag_holder);
                this.lPc.a(c0841b, list.get(i2), this.flc.dNJ() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0841b.lQF.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
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

    private int dc(int i, int i2) {
        String format;
        if (i > 0 && (this.flc.dNR() == 1 || this.flc.dNR() == 3 || this.flc.dNJ() > this.mhN)) {
            if (this.lPd) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.flc.dNJ()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.flc.dNJ()));
            }
            this.bRf.setText(format);
            this.mhP.setOnClickListener(this.mhK);
            SparseArray sparseArray = (SparseArray) this.mhP.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.mhP.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.flc);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.mhP.setVisibility(0);
            this.mhP.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.mhP.setVisibility(8);
        }
        if (this.mhP.getVisibility() == 0) {
            return this.mhP.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 0;
        if (this.flc != null && this.flc.dNC() != null) {
            int size = this.mhO.size();
            for (int i7 = 0; i7 < size; i7++) {
                a poll = this.mhO.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.mhQ, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i8 = this.mhN;
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
            if (this.mhP.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mhP.getLayoutParams();
                int i10 = paddingTop + marginLayoutParams2.topMargin;
                this.mhP.layout(marginLayoutParams2.leftMargin + paddingLeft, i10, marginLayoutParams2.leftMargin + paddingLeft + this.mhP.getMeasuredWidth(), this.mhP.getMeasuredHeight() + i10);
            }
            int childCount = getChildCount();
            for (int i11 = this.mhN; i11 < childCount; i11++) {
                View childAt2 = getChildAt(i11);
                if (childAt2 != null && childAt2 != this.mhP) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.flc != null && this.flc.dNC() != null) {
            int i = this.mhN;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.mhP.getVisibility() == 0) {
                drawChild(canvas, this.mhP, drawingTime);
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
    /* renamed from: dtf */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bRf != null) {
            if (this.lPd) {
                ap.setViewTextColor(this.bRf, R.color.CAM_X0304);
                this.bRf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.bRf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ap.setViewTextColor(this.bRf, R.color.CAM_X0108);
        }
    }

    public void setDefaultTag(SparseArray<Object> sparseArray) {
        this.mhR = sparseArray;
    }
}
