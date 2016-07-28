package com.baidu.tieba.person.holder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class BookShelfItemView extends LinearLayout {
    private TbPageContext<?> EA;
    private View.OnClickListener afk;
    private com.baidu.tieba.personInfo.c eub;
    private TbImageView euc;
    private TextView eud;
    private TextView eue;
    private Context mContext;
    private View mRootView;

    public BookShelfItemView(Context context) {
        super(context);
        this.afk = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afk = new b(this);
        this.mContext = context;
        initView();
    }

    public BookShelfItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afk = new b(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.EA = (TbPageContext) com.baidu.adp.base.l.s(this.mContext);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(u.h.personinfo_book_shelf_item, this);
        this.euc = (TbImageView) this.mRootView.findViewById(u.g.book_icon);
        this.eud = (TextView) this.mRootView.findViewById(u.g.book_title);
        this.eue = (TextView) this.mRootView.findViewById(u.g.book_desc);
        this.euc.setOnClickListener(this.afk);
        this.eud.setOnClickListener(this.afk);
        this.eue.setOnClickListener(this.afk);
    }

    public void a(com.baidu.tieba.personInfo.c cVar) {
        if (cVar != null) {
            this.eub = cVar;
            this.euc.c(this.eub.dPX, 10, false);
            this.eud.setText(this.eub.dzu);
            if (this.eub.NC == 1) {
                this.eue.setText("共" + this.eub.Nt + "章");
            } else {
                this.eue.setText("更新" + this.eub.Nt + "章");
            }
            sd();
        }
    }

    public void sd() {
        com.baidu.tbadk.j.a.a(this.EA, this.mRootView);
    }
}
