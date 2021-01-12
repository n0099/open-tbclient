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
/* loaded from: classes8.dex */
public class CategoryView extends LinearLayout {
    private View.OnClickListener jcl;
    private TextView ldB;
    private TextView ldC;
    private ImageView ldD;
    private d ldE;
    private Context mContext;
    private View mRootView;

    public CategoryView(Context context) {
        super(context);
        this.jcl = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.index.CategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && CategoryView.this.ldE != null && !StringUtils.isNull(CategoryView.this.ldE.dde()) && !StringUtils.isNull(CategoryView.this.ldE.ddd())) {
                    switch (CategoryView.this.ldE.ddf()) {
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
                    MemberCenterStatic.c((TbPageContext) j.K(CategoryView.this.mContext), new String[]{CategoryView.this.ldE.dde()});
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public CategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jcl = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.index.CategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && CategoryView.this.ldE != null && !StringUtils.isNull(CategoryView.this.ldE.dde()) && !StringUtils.isNull(CategoryView.this.ldE.ddd())) {
                    switch (CategoryView.this.ldE.ddf()) {
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
                    MemberCenterStatic.c((TbPageContext) j.K(CategoryView.this.mContext), new String[]{CategoryView.this.ldE.dde()});
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public CategoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.jcl = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.index.CategoryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && CategoryView.this.ldE != null && !StringUtils.isNull(CategoryView.this.ldE.dde()) && !StringUtils.isNull(CategoryView.this.ldE.ddd())) {
                    switch (CategoryView.this.ldE.ddf()) {
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
                    MemberCenterStatic.c((TbPageContext) j.K(CategoryView.this.mContext), new String[]{CategoryView.this.ldE.dde()});
                }
            }
        };
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.index_category, this);
        this.ldB = (TextView) this.mRootView.findViewById(R.id.class_name);
        this.ldC = (TextView) this.mRootView.findViewById(R.id.sprend_name);
        this.ldD = (ImageView) this.mRootView.findViewById(R.id.spread_icon);
        this.mRootView.setOnClickListener(this.jcl);
        this.ldD.setOnClickListener(this.jcl);
    }
}
