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
    private TbPageContext<?> GO;
    private View.OnClickListener aNB;
    private com.baidu.tieba.personInfo.b eLd;
    private TbImageView eLe;
    private TextView eLf;
    private TextView eLg;
    private Context mContext;
    private View mRootView;

    public BookShelfItemView(Context context) {
        super(context);
        this.aNB = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNB = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNB = new b(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.GO = (TbPageContext) l.C(this.mContext);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.personinfo_book_shelf_item, this);
        this.eLe = (TbImageView) this.mRootView.findViewById(r.g.book_icon);
        this.eLf = (TextView) this.mRootView.findViewById(r.g.book_title);
        this.eLg = (TextView) this.mRootView.findViewById(r.g.book_desc);
        this.eLe.setOnClickListener(this.aNB);
        this.eLf.setOnClickListener(this.aNB);
        this.eLg.setOnClickListener(this.aNB);
    }

    public void a(com.baidu.tieba.personInfo.b bVar) {
        if (bVar != null) {
            this.eLd = bVar;
            this.eLe.c(this.eLd.ejU, 10, false);
            this.eLf.setText(this.eLd.dSK);
            if (this.eLd.Qq == 1) {
                this.eLg.setText("共" + this.eLd.Qh + "章");
            } else {
                this.eLg.setText("更新" + this.eLd.Qh + "章");
            }
            tB();
        }
    }

    public void tB() {
        com.baidu.tbadk.i.a.a(this.GO, this.mRootView);
    }
}
