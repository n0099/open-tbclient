package com.baidu.tieba.pb.pb.main.c;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class d extends a {
    public TextView dYm;
    private LinearLayout mRootView;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public View getView() {
        this.mRootView = (LinearLayout) this.cVi.getPageActivity().getLayoutInflater().inflate(R.layout.delete_original_thread_view, (ViewGroup) null);
        this.dYm = (TextView) this.mRootView.findViewById(R.id.text);
        return this.mRootView;
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void g(OriginalThreadInfo originalThreadInfo) {
        this.dYm.setText(new SpannableString(originalThreadInfo.title));
        am.setViewTextColor(this.dYm, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(z zVar) {
        super.a(zVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void a(b.a aVar) {
        super.a(aVar);
    }

    @Override // com.baidu.tieba.pb.pb.main.c.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dYm, (int) R.color.cp_cont_b);
        }
    }
}
