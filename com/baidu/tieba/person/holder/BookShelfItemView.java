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
    private View.OnClickListener aMS;
    private com.baidu.tieba.personInfo.b eoI;
    private TbImageView eoJ;
    private TextView eoK;
    private TextView eoL;
    private Context mContext;
    private View mRootView;

    public BookShelfItemView(Context context) {
        super(context);
        this.aMS = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMS = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aMS = new b(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.GO = (TbPageContext) l.C(this.mContext);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.personinfo_book_shelf_item, this);
        this.eoJ = (TbImageView) this.mRootView.findViewById(r.g.book_icon);
        this.eoK = (TextView) this.mRootView.findViewById(r.g.book_title);
        this.eoL = (TextView) this.mRootView.findViewById(r.g.book_desc);
        this.eoJ.setOnClickListener(this.aMS);
        this.eoK.setOnClickListener(this.aMS);
        this.eoL.setOnClickListener(this.aMS);
    }

    public void a(com.baidu.tieba.personInfo.b bVar) {
        if (bVar != null) {
            this.eoI = bVar;
            this.eoJ.c(this.eoI.dOC, 10, false);
            this.eoK.setText(this.eoI.dxm);
            if (this.eoI.Qn == 1) {
                this.eoL.setText("共" + this.eoI.Qe + "章");
            } else {
                this.eoL.setText("更新" + this.eoI.Qe + "章");
            }
            tm();
        }
    }

    public void tm() {
        com.baidu.tbadk.i.a.a(this.GO, this.mRootView);
    }
}
