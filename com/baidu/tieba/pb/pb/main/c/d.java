package com.baidu.tieba.pb.pb.main.c;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.card.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes2.dex */
public class d extends a {
    public TextView flK;
    private LinearLayout mRootView;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        this.mRootView = (LinearLayout) this.eXu.getPageActivity().getLayoutInflater().inflate(R.layout.delete_original_thread_view, (ViewGroup) null);
        this.flK = (TextView) this.mRootView.findViewById(R.id.text);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.flK.setText(new SpannableString(originalThreadInfo.title));
        ao.setViewTextColor(this.flK, R.color.CAM_X0105);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(a.InterfaceC0089a interfaceC0089a) {
        super.a(interfaceC0089a);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
            ao.setViewTextColor(this.flK, R.color.CAM_X0105);
        }
    }
}
