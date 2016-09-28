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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BookShelfItemView extends LinearLayout {
    private TbPageContext<?> GM;
    private View.OnClickListener ahN;
    private com.baidu.tieba.personInfo.b eEE;
    private TbImageView eEF;
    private TextView eEG;
    private TextView eEH;
    private Context mContext;
    private View mRootView;

    public BookShelfItemView(Context context) {
        super(context);
        this.ahN = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahN = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahN = new b(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.GM = (TbPageContext) l.C(this.mContext);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.personinfo_book_shelf_item, this);
        this.eEF = (TbImageView) this.mRootView.findViewById(r.g.book_icon);
        this.eEG = (TextView) this.mRootView.findViewById(r.g.book_title);
        this.eEH = (TextView) this.mRootView.findViewById(r.g.book_desc);
        this.eEF.setOnClickListener(this.ahN);
        this.eEG.setOnClickListener(this.ahN);
        this.eEH.setOnClickListener(this.ahN);
    }

    public void a(com.baidu.tieba.personInfo.b bVar) {
        if (bVar != null) {
            this.eEE = bVar;
            this.eEF.c(this.eEE.edX, 10, false);
            this.eEG.setText(this.eEE.dNf);
            if (this.eEE.PY == 1) {
                this.eEH.setText("共" + this.eEE.PO + "章");
            } else {
                this.eEH.setText("更新" + this.eEE.PO + "章");
            }
            tx();
        }
    }

    public void tx() {
        com.baidu.tbadk.i.a.a(this.GM, this.mRootView);
    }
}
