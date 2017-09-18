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
import com.baidu.adp.lib.util.k;
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
    private float aRk;
    private int bfm;
    private d eGG;
    private int eKV;
    private int eKW;
    private View.OnClickListener eXH;
    private View.OnLongClickListener eXI;
    private View.OnTouchListener eXJ;
    private int eXK;
    private int eXL;
    private PostData eXM;
    private final Queue<a> eXN;
    private TextView eXO;
    private ViewGroup.MarginLayoutParams eXP;
    private CustomMessageListener eXQ;
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
        this.eKV = 0;
        this.eKW = 0;
        this.bfm = 0;
        this.eXK = 0;
        this.eXL = 0;
        this.mRootView = null;
        this.aRk = TbConfig.getContentSizeOfLzl();
        this.eXN = new LinkedList();
        this.eXP = new ViewGroup.MarginLayoutParams(-1, -2);
        this.eXQ = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.sub.SubPbLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                float contentSizeOfLzl = TbConfig.getContentSizeOfLzl();
                if (contentSizeOfLzl != SubPbLayout.this.aRk) {
                    SubPbLayout.this.aRk = contentSizeOfLzl;
                    SubPbLayout.this.eXO.setTextSize(0, contentSizeOfLzl);
                }
            }
        };
        this.eKV = k.f(context, d.f.ds8);
        this.eKW = k.f(context, d.f.ds20);
        this.bfm = k.f(context, d.f.ds16);
        this.eXK = k.f(context, d.f.ds12);
        this.mEmptyView = new View(context);
        addView(this.mEmptyView, -1, this.eXK);
        this.eXO = new TextView(context);
        this.eXO.setPadding(0, 0, 0, this.bfm);
        this.eXO.setId(d.h.pb_floor_reply_more);
        this.eXO.setTextSize(0, this.aRk);
        aj.i(this.eXO, d.e.cp_link_tip_c);
        addView(this.eXO, -1, -2);
        com.baidu.adp.base.e<?> Y = i.Y(getContext());
        if (Y != null) {
            Y.registerListener(this.eXQ);
        }
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        this.eXH = onClickListener;
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.eXI = onLongClickListener;
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eXJ = onTouchListener;
    }

    public void setSubPbAdapter(d dVar) {
        this.eGG = dVar;
    }

    public void a(PostData postData, View view) {
        this.eXM = postData;
        requestLayout();
        this.mRootView = view;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ArrayList<PostData> bsw;
        int i3;
        SparseArray sparseArray;
        if (this.eGG == null || this.eXM == null || this.eXM.bsw() == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int i4 = 0;
        if (this.eXM.bsu()) {
            bsw = this.eXM.bst();
        } else {
            bsw = this.eXM.bsw();
        }
        int u = v.u(bsw);
        this.eXL = u;
        if (!this.eXM.bsu()) {
            if (u <= 2) {
                this.eXL = u;
            } else {
                this.eXL = 2;
            }
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i3 = i4;
            if (i6 >= this.eXL) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt == null || childAt.equals(this.eXO) || childAt.equals(this.mEmptyView)) {
                childAt = this.eGG.lb();
                childAt.setPadding(0, 0, 0, this.eKV);
                this.eXN.offer(new a(i6, childAt));
            }
            View view = childAt;
            view.setOnClickListener(this.eXH);
            view.setOnLongClickListener(this.eXI);
            view.setOnTouchListener(this.eXJ);
            view.setClickable(true);
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (sparseArray2 == null) {
                SparseArray sparseArray3 = new SparseArray();
                view.setTag(sparseArray3);
                sparseArray = sparseArray3;
            } else {
                sparseArray = sparseArray2;
            }
            if (sparseArray.get(d.h.tag_load_sub_data) != this.eXM) {
                sparseArray.put(d.h.tag_load_sub_data, this.eXM);
            }
            sparseArray.put(d.h.tag_load_sub_view, this.mRootView);
            sparseArray.put(d.h.tag_is_subpb, true);
            if (bsw.get(i6) != null && bsw.get(i6).getAuthor() != null) {
                sparseArray.put(d.h.tag_photo_username, bsw.get(i6).getAuthor().getUserName());
                sparseArray.put(d.h.tag_photo_userid, bsw.get(i6).getAuthor().getUserId());
                sparseArray.put(d.h.tag_clip_board, bsw.get(i6));
            }
            this.eGG.a((d.b) sparseArray.get(d.h.tag_holder), bsw.get(i6), this.eXM.bsD() > bsw.size() || bsw.size() - i6 > 1, i6 == 0, false);
            view.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            i4 = i3 + view.getMeasuredHeight();
            i5 = i6 + 1;
        }
        if (bsw != null && bsw.size() > 0 && this.eXM.bsD() > this.eXL) {
            this.eXO.setText(String.format(TbadkCoreApplication.getInst().getApp().getString(d.l.sub_pb_load_more), Integer.valueOf(this.eXM.bsD() - this.eXL)));
            this.eXO.setOnClickListener(this.eXH);
            SparseArray sparseArray4 = (SparseArray) this.eXO.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                this.eXO.setTag(sparseArray4);
            }
            sparseArray4.put(d.h.tag_load_sub_data, this.eXM);
            sparseArray4.put(d.h.tag_load_sub_view, this.mRootView);
            this.eXO.setVisibility(0);
            this.eXO.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            this.mEmptyView.setVisibility(8);
        } else {
            this.eXO.setVisibility(8);
            this.mEmptyView.setVisibility(0);
            this.mEmptyView.measure(((size - getPaddingLeft()) - getPaddingRight()) + 1073741824, this.eXK + 1073741824);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop() + i3;
        if (this.eXO.getVisibility() == 0) {
            paddingBottom += this.eXO.getMeasuredHeight();
        }
        if (this.mEmptyView.getVisibility() == 0) {
            paddingBottom += this.mEmptyView.getMeasuredHeight();
        }
        setMeasuredDimension(size, paddingBottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.eXM != null && this.eXM.bsw() != null) {
            int size = this.eXN.size();
            for (int i6 = 0; i6 < size; i6++) {
                a poll = this.eXN.poll();
                if (poll.view.getParent() == null) {
                    addViewInLayout(poll.view, poll.position, this.eXP, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = this.eXL;
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
            if (this.eXO.getVisibility() == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.eXO.getLayoutParams();
                int i12 = i9 + marginLayoutParams3.topMargin;
                this.eXO.layout(marginLayoutParams3.leftMargin + paddingLeft, i12, marginLayoutParams3.leftMargin + paddingLeft + this.eXO.getMeasuredWidth(), this.eXO.getMeasuredHeight() + i12);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        if (this.eXM != null && this.eXM.bsw() != null) {
            int i = this.eXL;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.mEmptyView.getVisibility() == 0) {
                drawChild(canvas, this.mEmptyView, drawingTime);
            }
            if (this.eXO.getVisibility() == 0) {
                drawChild(canvas, this.eXO, drawingTime);
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
    /* renamed from: aVu */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }
}
