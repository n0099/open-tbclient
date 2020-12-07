package com.baidu.tieba.newdetail.adapter;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.a.c;
/* loaded from: classes21.dex */
public class b extends com.baidu.adp.widget.ListView.a<c, a> {
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.newdetail.a.a.lqf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cc */
    public a c(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setPadding(l.getDimens(viewGroup.getContext(), R.dimen.tbds44), 0, l.getDimens(viewGroup.getContext(), R.dimen.tbds44), l.getDimens(viewGroup.getContext(), R.dimen.tbds12));
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        View view = new View(viewGroup.getContext());
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, l.getDimens(viewGroup.getContext(), R.dimen.tbds1)));
        TextView textView = new TextView(viewGroup.getContext());
        textView.setTextColor(viewGroup.getContext().getResources().getColor(R.color.CAM_X0105));
        textView.setTextSize(0, l.getDimens(viewGroup.getContext(), R.dimen.tbds47));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setIncludeFontPadding(false);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(0, l.getDimens(viewGroup.getContext(), R.dimen.tbds48), 0, 0);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        a aVar = new a(linearLayout, textView, view);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, c cVar, a aVar) {
        if (cVar == null || aVar == null) {
            return null;
        }
        aVar.a(cVar);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static class a extends af.a {
        private TextView eAz;
        private View eOv;
        private int jQu;

        a(View view, TextView textView, View view2) {
            super(view);
            this.jQu = 3;
            this.eAz = textView;
            this.eOv = view2;
        }

        void a(c cVar) {
            if (cVar != null) {
                this.eAz.setText(cVar.title);
                this.eOv.setVisibility(cVar.ldg ? 0 : 8);
            }
        }

        void onChangeSkinType(int i) {
            if (this.jQu != i) {
                ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
                ap.setBackgroundColor(this.eOv, R.color.CAM_X0204);
                this.jQu = i;
            }
        }
    }
}
