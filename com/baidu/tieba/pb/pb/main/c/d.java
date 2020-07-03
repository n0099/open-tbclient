package com.baidu.tieba.pb.pb.main.c;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class d extends a {
    public TextView ecN;
    private LinearLayout mRootView;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        this.mRootView = (LinearLayout) this.dPv.getPageActivity().getLayoutInflater().inflate(R.layout.delete_original_thread_view, (ViewGroup) null);
        this.ecN = (TextView) this.mRootView.findViewById(R.id.text);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.ecN.setText(new SpannableString(originalThreadInfo.title));
        an.setViewTextColor(this.ecN, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(aa aaVar) {
        super.a(aaVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            an.setViewTextColor(this.ecN, (int) R.color.cp_cont_b);
        }
    }
}
