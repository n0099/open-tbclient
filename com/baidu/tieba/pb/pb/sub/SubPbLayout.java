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
/* loaded from: classes16.dex */
public class SubPbLayout extends ViewGroup {
    private PostData euI;
    private TextView gsB;
    private b kBe;
    private boolean kBg;
    private View.OnClickListener kTe;
    private View.OnLongClickListener kTf;
    private View.OnTouchListener kTg;
    private int kTh;
    private final Queue<a> kTi;
    private RelativeLayout kTj;
    private ViewGroup.MarginLayoutParams kTk;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
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
        this.kTh = 0;
        this.mRootView = null;
        this.kTi = new LinkedList();
        this.kBg = false;
        this.kTk = new ViewGroup.MarginLayoutParams(-1, -2);
        this.kTj = new RelativeLayout(context);
        this.kTj.setId(R.id.pb_floor_reply_more);
        this.gsB = new TextView(context);
        this.gsB.setPadding(0, l.getDimens(context, R.dimen.tbds_3), 0, l.getDimens(context, R.dimen.tbds12));
        this.gsB.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.kBg) {
            ap.setViewTextColor(this.gsB, R.color.cp_link_tip_c);
            this.gsB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ap.setViewTextColor(this.gsB, R.color.cp_cont_c);
            this.gsB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.gsB.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.kTj.addView(this.gsB);
        addView(this.kTj, -1, -2);
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.kTe = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.kTf = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.kTg = onTouchListener;
    }

    public void setSubPbAdapter(b bVar) {
        this.kBe = bVar;
    }

    public void setShowChildComment(boolean z) {
        this.kBg = z;
    }

    public void setData(PostData postData, View view) {
        this.euI = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> dwH;
        if (this.kBe == null || this.euI == null || this.euI.dwH() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.euI.dwG()) {
            dwH = this.euI.dwD();
        } else {
            dwH = this.euI.dwH();
        }
        setMeasuredDimension(size, cW(y.getCount(dwH), size) + q(dwH, size) + 0 + getPaddingBottom() + getPaddingTop());
    }

    private int q(List<PostData> list, int i) {
        SparseArray sparseArray;
        if (this.euI.dwW() == 1 || this.euI.dwW() == 3) {
            this.kTh = 0;
            return 0;
        } else if (y.getCount(list) != 0) {
            int count = y.getCount(list);
            this.kTh = count;
            if (!this.euI.dwG()) {
                if (count <= 2) {
                    this.kTh = count;
                } else {
                    this.kTh = 2;
                }
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.kTh) {
                View childAt = getChildAt(i2);
                if (childAt == null || childAt.equals(this.kTj)) {
                    childAt = this.kBe.createView();
                    childAt.setPadding(0, 0, 0, 0);
                    this.kTi.offer(new a(i2, childAt));
                }
                View view = childAt;
                view.setOnClickListener(this.kTe);
                if (!this.kBg) {
                    view.setOnLongClickListener(this.kTf);
                }
                view.setOnTouchListener(this.kTg);
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
                if (sparseArray.get(R.id.tag_load_sub_data) != this.euI) {
                    sparseArray.put(R.id.tag_load_sub_data, this.euI);
                }
                sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
                sparseArray.put(R.id.tag_is_subpb, true);
                if (list.get(i2) != null && list.get(i2).beE() != null) {
                    if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i2)) {
                        sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i2));
                    }
                    sparseArray.put(R.id.tag_photo_username, list.get(i2).beE().getUserName());
                    sparseArray.put(R.id.tag_photo_userid, list.get(i2).beE().getUserId());
                    sparseArray.put(R.id.tag_clip_board, list.get(i2));
                }
                b.C0774b c0774b = (b.C0774b) sparseArray.get(R.id.tag_holder);
                this.kBe.a(c0774b, list.get(i2), this.euI.dwO() > list.size() || list.size() - i2 > 1, i2 == 0, false);
                c0774b.kCz.setPadding(0, 0, 0, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                this.gsB.setTextSize(0, TbConfig.getContentSizeOfLzl());
                view.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                i2++;
                i3 += view.getMeasuredHeight();
            }
            return i3;
        } else {
            return 0;
        }
    }

    private int cW(int i, int i2) {
        String format;
        if (i > 0 && (this.euI.dwW() == 1 || this.euI.dwW() == 3 || this.euI.dwO() > this.kTh)) {
            if (this.kBg) {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.euI.dwO()));
            } else {
                format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.euI.dwO()));
            }
            this.gsB.setText(format);
            this.kTj.setOnClickListener(this.kTe);
            SparseArray sparseArray = (SparseArray) this.kTj.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.kTj.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, this.euI);
            sparseArray.put(R.id.tag_load_sub_view, this.mRootView);
            this.kTj.setVisibility(0);
            this.kTj.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
        } else {
            this.kTj.setVisibility(8);
        }
        if (this.kTj.getVisibility() == 0) {
            return this.kTj.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.euI != null && this.euI.dwH() != null) {
            int size = this.kTi.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.kTi.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.kTk, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.kTh;
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
            if (this.kTj.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.kTj.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.kTj.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.kTj.getMeasuredWidth(), this.kTj.getMeasuredHeight() + i11);
            }
            int childCount = getChildCount();
            for (int i12 = this.kTh; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2 != this.kTj) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.euI != null && this.euI.dwH() != null) {
            int i = this.kTh;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.kTj.getVisibility() == 0) {
                drawChild(canvas, this.kTj, drawingTime);
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
    /* renamed from: dcX */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public void onChangeSkinType() {
        if (this.gsB != null) {
            if (this.kBg) {
                ap.setViewTextColor(this.gsB, R.color.cp_link_tip_c);
                this.gsB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.gsB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            ap.setViewTextColor(this.gsB, R.color.cp_cont_c);
        }
    }
}
