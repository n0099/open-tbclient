package com.baidu.tieba.person.holder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class BookShelfItemView extends LinearLayout {
    private TbPageContext<?> GM;
    private View.OnClickListener aif;
    private com.baidu.tieba.personInfo.b eCB;
    private TbImageView eCC;
    private TextView eCD;
    private TextView eCE;
    private Context mContext;
    private View mRootView;

    public BookShelfItemView(Context context) {
        super(context);
        this.aif = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aif = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aif = new b(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.GM = (TbPageContext) l.C(this.mContext);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.personinfo_book_shelf_item, this);
        this.eCC = (TbImageView) this.mRootView.findViewById(t.g.book_icon);
        this.eCD = (TextView) this.mRootView.findViewById(t.g.book_title);
        this.eCE = (TextView) this.mRootView.findViewById(t.g.book_desc);
        this.eCC.setOnClickListener(this.aif);
        this.eCD.setOnClickListener(this.aif);
        this.eCE.setOnClickListener(this.aif);
    }

    public void a(com.baidu.tieba.personInfo.b bVar) {
        if (bVar != null) {
            this.eCB = bVar;
            this.eCC.c(this.eCB.ecc, 10, false);
            this.eCD.setText(this.eCB.dLj);
            if (this.eCB.Qa == 1) {
                this.eCE.setText("共" + this.eCB.PQ + "章");
            } else {
                this.eCE.setText("更新" + this.eCB.PQ + "章");
            }
            ti();
        }
    }

    public void ti() {
        com.baidu.tbadk.j.a.a(this.GM, this.mRootView);
    }
}
