package com.baidu.tieba.person.holder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BookShelfItemView extends LinearLayout {
    private TbPageContext<?> FY;
    private View.OnClickListener aLT;
    private com.baidu.tieba.personInfo.b eyD;
    private TbImageView eyE;
    private TextView eyF;
    private TextView eyG;
    private Context mContext;
    private View mRootView;

    public BookShelfItemView(Context context) {
        super(context);
        this.aLT = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLT = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLT = new b(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.FY = (TbPageContext) k.C(this.mContext);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(r.j.personinfo_book_shelf_item, this);
        this.eyE = (TbImageView) this.mRootView.findViewById(r.h.book_icon);
        this.eyF = (TextView) this.mRootView.findViewById(r.h.book_title);
        this.eyG = (TextView) this.mRootView.findViewById(r.h.book_desc);
        this.eyE.setOnClickListener(this.aLT);
        this.eyF.setOnClickListener(this.aLT);
        this.eyG.setOnClickListener(this.aLT);
    }

    public void a(com.baidu.tieba.personInfo.b bVar) {
        if (bVar != null) {
            this.eyD = bVar;
            this.eyE.c(this.eyD.dXy, 10, false);
            this.eyF.setText(this.eyD.dGt);
            if (this.eyD.Pw == 1) {
                this.eyG.setText("共" + this.eyD.Pn + "章");
            } else {
                this.eyG.setText("更新" + this.eyD.Pn + "章");
            }
            tg();
        }
    }

    public void tg() {
        com.baidu.tbadk.i.a.a(this.FY, this.mRootView);
    }
}
