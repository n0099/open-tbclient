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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class BookShelfItemView extends LinearLayout {
    private View.OnClickListener aRG;
    private TbPageContext<?> ajF;
    private com.baidu.tieba.personInfo.b eCc;
    private TbImageView eCd;
    private TextView eCe;
    private TextView eCf;
    private Context mContext;
    private View mRootView;

    public BookShelfItemView(Context context) {
        super(context);
        this.aRG = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRG = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aRG = new b(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.ajF = (TbPageContext) k.aa(this.mContext);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.personinfo_book_shelf_item, this);
        this.eCd = (TbImageView) this.mRootView.findViewById(w.h.book_icon);
        this.eCe = (TextView) this.mRootView.findViewById(w.h.book_title);
        this.eCf = (TextView) this.mRootView.findViewById(w.h.book_desc);
        this.eCd.setOnClickListener(this.aRG);
        this.eCe.setOnClickListener(this.aRG);
        this.eCf.setOnClickListener(this.aRG);
    }

    public void a(com.baidu.tieba.personInfo.b bVar) {
        if (bVar != null) {
            this.eCc = bVar;
            this.eCd.c(this.eCc.eas, 10, false);
            this.eCe.setText(this.eCc.dJa);
            if (this.eCc.Uy == 1) {
                this.eCf.setText("共" + this.eCc.Up + "章");
            } else {
                this.eCf.setText("更新" + this.eCc.Up + "章");
            }
            tD();
        }
    }

    public void tD() {
        com.baidu.tbadk.i.a.a(this.ajF, this.mRootView);
    }
}
