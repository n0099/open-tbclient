package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.index.a.d;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
/* loaded from: classes9.dex */
public class CategoryView extends LinearLayout {
    private View.OnClickListener jgS;
    private TextView lih;
    private TextView lii;
    private ImageView lij;
    private d lik;
    private Context mContext;
    private View mRootView;

    public CategoryView(Context context) {
        super(context);
        this.jgS = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.index.CategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && CategoryView.this.lik != null && !StringUtils.isNull(CategoryView.this.lik.dgW()) && !StringUtils.isNull(CategoryView.this.lik.dgV())) {
                    switch (CategoryView.this.lik.dgX()) {
                        case 1:
                            TiebaStatic.log("c10441");
                            break;
                        case 2:
                            TiebaStatic.log("c10443");
                            break;
                        case 3:
                            TiebaStatic.log("c10449");
                            break;
                    }
                    MemberCenterStatic.c((TbPageContext) j.K(CategoryView.this.mContext), new String[]{CategoryView.this.lik.dgW()});
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public CategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jgS = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.index.CategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && CategoryView.this.lik != null && !StringUtils.isNull(CategoryView.this.lik.dgW()) && !StringUtils.isNull(CategoryView.this.lik.dgV())) {
                    switch (CategoryView.this.lik.dgX()) {
                        case 1:
                            TiebaStatic.log("c10441");
                            break;
                        case 2:
                            TiebaStatic.log("c10443");
                            break;
                        case 3:
                            TiebaStatic.log("c10449");
                            break;
                    }
                    MemberCenterStatic.c((TbPageContext) j.K(CategoryView.this.mContext), new String[]{CategoryView.this.lik.dgW()});
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public CategoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.jgS = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.index.CategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && CategoryView.this.lik != null && !StringUtils.isNull(CategoryView.this.lik.dgW()) && !StringUtils.isNull(CategoryView.this.lik.dgV())) {
                    switch (CategoryView.this.lik.dgX()) {
                        case 1:
                            TiebaStatic.log("c10441");
                            break;
                        case 2:
                            TiebaStatic.log("c10443");
                            break;
                        case 3:
                            TiebaStatic.log("c10449");
                            break;
                    }
                    MemberCenterStatic.c((TbPageContext) j.K(CategoryView.this.mContext), new String[]{CategoryView.this.lik.dgW()});
                }
            }
        };
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.index_category, this);
        this.lih = (TextView) this.mRootView.findViewById(R.id.class_name);
        this.lii = (TextView) this.mRootView.findViewById(R.id.sprend_name);
        this.lij = (ImageView) this.mRootView.findViewById(R.id.spread_icon);
        this.mRootView.setOnClickListener(this.jgS);
        this.lij.setOnClickListener(this.jgS);
    }
}
