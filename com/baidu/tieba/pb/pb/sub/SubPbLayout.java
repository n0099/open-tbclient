package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class SubPbLayout extends ViewGroup {
    private int DS12;
    private int DS8;
    private float aRe;
    private int bhx;
    private d eHS;
    private View.OnClickListener fal;
    private View.OnLongClickListener fam;
    private View.OnTouchListener fan;
    private int fao;
    private PostData fap;
    private final Queue<a> faq;
    private TextView far;
    private ViewGroup.MarginLayoutParams fas;
    private CustomMessageListener fat;
    private View mEmptyView;
    private View mRootView;

    /* loaded from: classes.dex */
    private static class a {
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
        this.DS8 = 0;
        this.bhx = 0;
        this.DS12 = 0;
        this.fao = 0;
        this.mRootView = null;
        this.aRe = TbConfig.getContentSizeOfLzl();
        this.faq = new LinkedList();
        this.fas = new ViewGroup.MarginLayoutParams(-1, -2);
        this.fat = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.sub.SubPbLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                float contentSizeOfLzl = TbConfig.getContentSizeOfLzl();
                if (contentSizeOfLzl != SubPbLayout.this.aRe) {
                    SubPbLayout.this.aRe = contentSizeOfLzl;
                    SubPbLayout.this.far.setTextSize(0, contentSizeOfLzl);
                }
            }
        };
        this.DS8 = l.f(context, d.e.ds8);
        this.bhx = l.f(context, d.e.ds16);
        this.DS12 = l.f(context, d.e.ds12);
        this.mEmptyView = new View(context);
        addView(this.mEmptyView, -1, this.DS12);
        this.far = new TextView(context);
        this.far.setPadding(0, 0, 0, this.bhx);
        this.far.setId(d.g.pb_floor_reply_more);
        this.far.setTextSize(0, this.aRe);
        aj.i(this.far, d.C0080d.cp_link_tip_c);
        addView(this.far, -1, -2);
        com.baidu.adp.base.e<?> Y = i.Y(getContext());
        if (Y != null) {
            Y.registerListener(this.fat);
        }
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.fal = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.fam = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fan = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.eHS = dVar;
    }

    public void a(PostData postData, View view) {
        this.fap = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bur;
        int i3;
        SparseArray sparseArray;
        if (this.eHS == null || this.fap == null || this.fap.bur() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int i4 = 0;
        if (this.fap.bup()) {
            bur = this.fap.bun();
        } else {
            bur = this.fap.bur();
        }
        int u = v.u(bur);
        this.fao = u;
        if (!this.fap.bup()) {
            if (u <= 2) {
                this.fao = u;
            } else {
                this.fao = 2;
            }
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i3 = i4;
            if (i6 >= this.fao) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt == null || childAt.equals(this.far) || childAt.equals(this.mEmptyView)) {
                childAt = this.eHS.kX();
                childAt.setPadding(0, 0, 0, this.DS8);
                this.faq.offer(new a(i6, childAt));
            }
            View view = childAt;
            view.setOnClickListener(this.fal);
            view.setOnLongClickListener(this.fam);
            view.setOnTouchListener(this.fan);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(d.g.tag_load_sub_data) != this.fap) {
                sparseArray.put(d.g.tag_load_sub_data, this.fap);
            }
            sparseArray.put(d.g.tag_load_sub_view, this.mRootView);
            sparseArray.put(d.g.tag_is_subpb, true);
            if (bur.get(i6) != null && bur.get(i6).rt() != null) {
                sparseArray.put(d.g.tag_photo_username, bur.get(i6).rt().getUserName());
                sparseArray.put(d.g.tag_photo_userid, bur.get(i6).rt().getUserId());
                sparseArray.put(d.g.tag_clip_board, bur.get(i6));
            }
            this.eHS.a((d.b) sparseArray.get(d.g.tag_holder), bur.get(i6), this.fap.buy() > bur.size() || bur.size() - i6 > 1, i6 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i4 = i3 + view.getMeasuredHeight();
            i5 = i6 + 1;
        }
        if (bur != null && bur.size() > 0 && this.fap.buy() > this.fao) {
            this.far.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.j.sub_pb_load_more), Integer.valueOf(this.fap.buy() - this.fao)));
            this.far.setOnClickListener(this.fal);
            SparseArray sparseArray4 = (SparseArray) this.far.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.far.setTag(sparseArray4);
            }
            sparseArray4.put(d.g.tag_load_sub_data, this.fap);
            sparseArray4.put(d.g.tag_load_sub_view, this.mRootView);
            this.far.setVisibility(0);
            this.far.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.mEmptyView.setVisibility(8);
        } else {
            this.far.setVisibility(8);
            this.mEmptyView.setVisibility(0);
            this.mEmptyView.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, this.DS12 + 1073741824);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop() + i3;
        if (this.far.getVisibility() == 0) {
            paddingBottom += this.far.getMeasuredHeight();
        }
        if (this.mEmptyView.getVisibility() == 0) {
            paddingBottom += this.mEmptyView.getMeasuredHeight();
        }
        setMeasuredDimension(size, paddingBottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.fap != null && this.fap.bur() != null) {
            int size = this.faq.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.faq.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.fas, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.fao;
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
            if (this.mEmptyView.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mEmptyView.getLayoutParams();
                int i11 = i9 + marginLayoutParams2.topMargin;
                this.mEmptyView.layout(marginLayoutParams2.leftMargin + paddingLeft, i11, marginLayoutParams2.leftMargin + paddingLeft + this.mEmptyView.getMeasuredWidth(), this.mEmptyView.getMeasuredHeight() + i11);
                i9 = i11 + marginLayoutParams2.bottomMargin;
            }
            if (this.far.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.far.getLayoutParams();
                int i12 = i9 + marginLayoutParams3.topMargin;
                this.far.layout(marginLayoutParams3.leftMargin + paddingLeft, i12, marginLayoutParams3.leftMargin + paddingLeft + this.far.getMeasuredWidth(), this.far.getMeasuredHeight() + i12);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.fap != null && this.fap.bur() != null) {
            int i = this.fao;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.mEmptyView.getVisibility() == 0) {
                drawChild(canvas, this.mEmptyView, drawingTime);
            }
            if (this.far.getVisibility() == 0) {
                drawChild(canvas, this.far, drawingTime);
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
    /* renamed from: aWA */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
