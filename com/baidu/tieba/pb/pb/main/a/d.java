package com.baidu.tieba.pb.pb.main.a;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
/* loaded from: classes2.dex */
public class d {
    private EMTextView eVM;
    private FrameLayout fIu;
    public int fvb;
    private LinearLayout mcc;
    private EMTextView mcd;
    private String postId;

    public d(PbFragment pbFragment) {
        E(pbFragment.getPageContext());
    }

    public d(VideoPbFragment videoPbFragment, FrameLayout frameLayout) {
        this(videoPbFragment.getPageContext(), frameLayout);
    }

    public d(TbPageContext<?> tbPageContext, FrameLayout frameLayout) {
        this.fIu = frameLayout;
        F(tbPageContext);
    }

    private void E(TbPageContext<?> tbPageContext) {
        if (this.fIu == null) {
            this.fIu = (FrameLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.pb_head_ueg_layout, (ViewGroup) null);
            F(tbPageContext);
        }
    }

    private void F(final TbPageContext<?> tbPageContext) {
        this.mcc = (LinearLayout) this.fIu.findViewById(R.id.container);
        this.eVM = (EMTextView) this.fIu.findViewById(R.id.tv_title);
        this.mcd = (EMTextView) this.fIu.findViewById(R.id.tv_content);
        com.baidu.tbadk.core.elementsMaven.c.br(this.eVM).nY(R.color.CAM_X0109).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.mcd).ob(R.dimen.M_H_X003).nY(R.color.CAM_X0109).oa(R.string.F_X01);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_head_block_title));
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan.on(l.getDimens(tbPageContext.getContext(), R.dimen.tbds31));
        eMRichTextAnyIconSpan.setRightPadding(l.getDimens(tbPageContext.getContext(), R.dimen.M_W_X002));
        eMRichTextAnyIconSpan.setLeftPadding(0);
        spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
        this.eVM.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_head_block_content));
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_pure_arrow12_right_n, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan2.setLeftPadding(l.getDimens(tbPageContext.getContext(), R.dimen.tbds3));
        spannableStringBuilder2.setSpan(eMRichTextAnyIconSpan2, spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 33);
        this.mcd.setText(spannableStringBuilder2);
        this.mcc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bf.bsV().b(tbPageContext, new String[]{"http://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1&postId=" + d.this.postId});
                TiebaStatic.log(new ar("c14048").ap("obj_locate", d.this.fvb));
            }
        });
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.fIu);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.fIu, i);
        }
    }

    public void setVisibility(int i) {
        this.fIu.setVisibility(i);
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.elementsMaven.c.br(this.mcc).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        ap.setViewTextColor(this.eVM, R.color.CAM_X0109);
        ap.setViewTextColor(this.mcd, R.color.CAM_X0109);
    }
}
