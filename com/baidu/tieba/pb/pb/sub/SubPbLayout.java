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
    private float aSm;
    private int bgZ;
    private int cWi;
    private d eAd;
    private int eEv;
    private View.OnClickListener eRQ;
    private View.OnLongClickListener eRR;
    private View.OnTouchListener eRS;
    private int eRT;
    private int eRU;
    private PostData eRV;
    private final Queue<a> eRW;
    private TextView eRX;
    private ViewGroup.MarginLayoutParams eRY;
    private CustomMessageListener eRZ;
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
        this.eEv = 0;
        this.cWi = 0;
        this.bgZ = 0;
        this.eRT = 0;
        this.eRU = 0;
        this.mRootView = null;
        this.aSm = TbConfig.getContentSizeOfLzl();
        this.eRW = new LinkedList();
        this.eRY = new ViewGroup.MarginLayoutParams(-1, -2);
        this.eRZ = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.sub.SubPbLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                float contentSizeOfLzl = TbConfig.getContentSizeOfLzl();
                if (contentSizeOfLzl != SubPbLayout.this.aSm) {
                    SubPbLayout.this.aSm = contentSizeOfLzl;
                    SubPbLayout.this.eRX.setTextSize(0, contentSizeOfLzl);
                }
            }
        };
        this.eEv = l.f(context, d.f.ds8);
        this.cWi = l.f(context, d.f.ds20);
        this.bgZ = l.f(context, d.f.ds16);
        this.eRT = l.f(context, d.f.ds12);
        this.mEmptyView = new View(context);
        addView(this.mEmptyView, -1, this.eRT);
        this.eRX = new TextView(context);
        this.eRX.setPadding(0, 0, 0, this.bgZ);
        this.eRX.setId(d.h.pb_floor_reply_more);
        this.eRX.setTextSize(0, this.aSm);
        aj.i(this.eRX, d.e.cp_link_tip_c);
        addView(this.eRX, -1, -2);
        com.baidu.adp.base.e<?> Y = i.Y(getContext());
        if (Y != null) {
            Y.registerListener(this.eRZ);
        }
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.eRQ = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.eRR = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eRS = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.eAd = dVar;
    }

    public void a(PostData postData, View view) {
        this.eRV = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bru;
        int i3;
        SparseArray sparseArray;
        if (this.eAd == null || this.eRV == null || this.eRV.bru() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int i4 = 0;
        if (this.eRV.brs()) {
            bru = this.eRV.brq();
        } else {
            bru = this.eRV.bru();
        }
        int t = v.t(bru);
        this.eRU = t;
        if (!this.eRV.brs()) {
            if (t <= 2) {
                this.eRU = t;
            } else {
                this.eRU = 2;
            }
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i3 = i4;
            if (i6 >= this.eRU) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt == null || childAt.equals(this.eRX) || childAt.equals(this.mEmptyView)) {
                childAt = this.eAd.ld();
                childAt.setPadding(0, 0, 0, this.eEv);
                this.eRW.offer(new a(i6, childAt));
            }
            View view = childAt;
            view.setOnClickListener(this.eRQ);
            view.setOnLongClickListener(this.eRR);
            view.setOnTouchListener(this.eRS);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(d.h.tag_load_sub_data) != this.eRV) {
                sparseArray.put(d.h.tag_load_sub_data, this.eRV);
            }
            sparseArray.put(d.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(d.h.tag_is_subpb, true);
            if (bru.get(i6) != null && bru.get(i6).getAuthor() != null) {
                sparseArray.put(d.h.tag_photo_username, bru.get(i6).getAuthor().getUserName());
                sparseArray.put(d.h.tag_photo_userid, bru.get(i6).getAuthor().getUserId());
                sparseArray.put(d.h.tag_clip_board, bru.get(i6));
            }
            this.eAd.a((d.b) sparseArray.get(d.h.tag_holder), bru.get(i6), this.eRV.brB() > bru.size() || bru.size() - i6 > 1, i6 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i4 = i3 + view.getMeasuredHeight();
            i5 = i6 + 1;
        }
        if (bru != null && bru.size() > 0 && this.eRV.brB() > this.eRU) {
            this.eRX.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.l.sub_pb_load_more), Integer.valueOf(this.eRV.brB() - this.eRU)));
            this.eRX.setOnClickListener(this.eRQ);
            SparseArray sparseArray4 = (SparseArray) this.eRX.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.eRX.setTag(sparseArray4);
            }
            sparseArray4.put(d.h.tag_load_sub_data, this.eRV);
            sparseArray4.put(d.h.tag_load_sub_view, this.mRootView);
            this.eRX.setVisibility(0);
            this.eRX.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.mEmptyView.setVisibility(8);
        } else {
            this.eRX.setVisibility(8);
            this.mEmptyView.setVisibility(0);
            this.mEmptyView.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, this.eRT + 1073741824);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop() + i3;
        if (this.eRX.getVisibility() == 0) {
            paddingBottom += this.eRX.getMeasuredHeight();
        }
        if (this.mEmptyView.getVisibility() == 0) {
            paddingBottom += this.mEmptyView.getMeasuredHeight();
        }
        setMeasuredDimension(size, paddingBottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eRV != null && this.eRV.bru() != null) {
            int size = this.eRW.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.eRW.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.eRY, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.eRU;
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
            if (this.eRX.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.eRX.getLayoutParams();
                int i12 = i9 + marginLayoutParams3.topMargin;
                this.eRX.layout(marginLayoutParams3.leftMargin + paddingLeft, i12, marginLayoutParams3.leftMargin + paddingLeft + this.eRX.getMeasuredWidth(), this.eRX.getMeasuredHeight() + i12);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eRV != null && this.eRV.bru() != null) {
            int i = this.eRU;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.mEmptyView.getVisibility() == 0) {
                drawChild(canvas, this.mEmptyView, drawingTime);
            }
            if (this.eRX.getVisibility() == 0) {
                drawChild(canvas, this.eRX, drawingTime);
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
    /* renamed from: aTD */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
