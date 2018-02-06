package com.baidu.tieba.write.view.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends a {
    public LinearLayout hIy;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.write.view.a.a
    protected void initView() {
        this.mRootView = LayoutInflater.from(this.mBdPageContext.getPageActivity()).inflate(d.h.pic_filter_view, (ViewGroup) null);
        this.hIy = (LinearLayout) this.mRootView.findViewById(d.g.filters_layout);
    }

    public View getRootView() {
        return this.mRootView;
    }
}
