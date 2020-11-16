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
    private TextView bIg;
    private PostData eWo;
    private View.OnClickListener lJM;
    private View.OnLongClickListener lJN;
    private View.OnTouchListener lJO;
    private int lJP;
    private final Queue<a> lJQ;
    private RelativeLayout lJR;
    private ViewGroup.MarginLayoutParams lJS;
    private b lrC;
    private boolean lrE;
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
        this.lJP = 0;
        this.mRootView = null;
        this.lJQ = new LinkedList();
        this.lrE = false;
        this.lJS = new ViewGroup.MarginLayoutParams(-1, -2);
        this.lJR = new RelativeLayout(context);
        this.lJR.setId(R.id.pb_floor_reply_more);
        this.bIg = new TextView(context);
        this.bIg.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.bIg.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.lrE) {
            ap.setViewTextColor(this.bIg, R.color.CAM_X0304);
            this.bIg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ap.setViewTextColor(this.bIg, R.color.CAM_X0108);
            this.bIg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.bIg.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.lJR.addView(this.bIg);
        addView(this.lJR, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.lJM = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lJN = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.lJO = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.lrC = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.lrE = z;
    }

    public void setData(PostData postData, View view) {
        this.eWo = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dJN;
        if (this.lrC == null || this.eWo == null || this.eWo.dJN() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.eWo.dJM()) {
            dJN = this.eWo.dJJ();
        } else {
            dJN = this.eWo.dJN();
        }
        setMeasuredDimension(size, dd(y.getCount(dJN), size) + q(dJN, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.eWo.dKc() == 1 || this.eWo.dKc() == 3) {
            this.lJP = 0;
            return 0;
        } else if (y.getCount(list) != 0) {
            int count = y.getCount(list);
            this.lJP = count;
            if (!this.eWo.dJM()) {
                if (count <= 2) {
                    this.lJP = count;
                } else {
                    this.lJP = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.lJP) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.lJR)) {
                    childAt = this.lrC.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.lJQ.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.lJM);
                if (!this.lrE) {
                    view.setOnLongClickListener(this.lJN);
                }
                view.setOnTouchListener(this.lJO);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.eWo) {
                    sparseArray.put(R.id.tag_load_sub_data, this.eWo);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).blC() != null) {
                    if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i2)) {
                        sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i2));
                    }
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).blC().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).blC().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                b.C0821b c0821b = (b.C0821b) sparseArray.get(R.id.tag_holder);
                this.lrC.a(c0821b, list.get(i2), this.eWo.dJU() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0821b.lsY.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                this.bIg.setTextSize(0, TbConfig.getContentSizeOfLzl());
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int dd(int i, int i2) {
        String format;
        if (i > 0 && (this.eWo.dKc() == 1 || this.eWo.dKc() == 3 || this.eWo.dJU() > this.lJP)) {
            if (this.lrE) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.eWo.dJU()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.eWo.dJU()));
            }
            this.bIg.setText(format);
            this.lJR.setOnClickListener(this.lJM);
            SparseArray sparseArray = (SparseArray) this.lJR.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.lJR.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.eWo);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.lJR.setVisibility(0);
            this.lJR.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.lJR.setVisibility(8);
        }
        if (this.lJR.getVisibility() == 0) {
            return this.lJR.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eWo != null && this.eWo.dJN() != null) {
            int size = this.lJQ.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.lJQ.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.lJS, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.lJP;
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
            if (this.lJR.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lJR.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.lJR.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.lJR.getMeasuredWidth(), this.lJR.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.lJP; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.lJR) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eWo != null && this.eWo.dJN() != null) {
            int i = this.lJP;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.lJR.getVisibility() == 0) {
                drawChild(canvas, this.lJR, drawingTime);
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
    /* renamed from: dpu */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.bIg != null) {
            if (this.lrE) {
                ap.setViewTextColor(this.bIg, R.color.CAM_X0304);
                this.bIg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.bIg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ap.setViewTextColor(this.bIg, R.color.CAM_X0108);
        }
    }
}
