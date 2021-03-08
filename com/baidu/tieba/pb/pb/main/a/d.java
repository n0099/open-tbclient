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
    private EMTextView eXl;
    private FrameLayout fJT;
    public int fwA;
    private LinearLayout meu;
    private EMTextView mev;
    private String postId;

    public d(PbFragment pbFragment) {
        E(pbFragment.getPageContext());
    }

    public d(VideoPbFragment videoPbFragment, FrameLayout frameLayout) {
        this(videoPbFragment.getPageContext(), frameLayout);
    }

    public d(TbPageContext<?> tbPageContext, FrameLayout frameLayout) {
        this.fJT = frameLayout;
        F(tbPageContext);
    }

    private void E(TbPageContext<?> tbPageContext) {
        if (this.fJT == null) {
            this.fJT = (FrameLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.pb_head_ueg_layout, (ViewGroup) null);
            F(tbPageContext);
        }
    }

    private void F(final TbPageContext<?> tbPageContext) {
        this.meu = (LinearLayout) this.fJT.findViewById(R.id.container);
        this.eXl = (EMTextView) this.fJT.findViewById(R.id.tv_title);
        this.mev = (EMTextView) this.fJT.findViewById(R.id.tv_content);
        com.baidu.tbadk.core.elementsMaven.c.br(this.eXl).nZ(R.color.CAM_X0109).ob(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.mev).oc(R.dimen.M_H_X003).nZ(R.color.CAM_X0109).ob(R.string.F_X01);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_head_block_title));
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan.oo(l.getDimens(tbPageContext.getContext(), R.dimen.tbds31));
        eMRichTextAnyIconSpan.setRightPadding(l.getDimens(tbPageContext.getContext(), R.dimen.M_W_X002));
        eMRichTextAnyIconSpan.setLeftPadding(0);
        spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
        this.eXl.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_head_block_content));
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(R.drawable.icon_pure_arrow12_right_n, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan2.setLeftPadding(l.getDimens(tbPageContext.getContext(), R.dimen.tbds3));
        spannableStringBuilder2.setSpan(eMRichTextAnyIconSpan2, spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 33);
        this.mev.setText(spannableStringBuilder2);
        this.meu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bf.bsY().b(tbPageContext, new String[]{"http://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1&postId=" + d.this.postId});
                TiebaStatic.log(new ar("c14048").aq("obj_locate", d.this.fwA));
            }
        });
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.fJT);
        }
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        if (bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.fJT, i);
        }
    }

    public void setVisibility(int i) {
        this.fJT.setVisibility(i);
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.elementsMaven.c.br(this.meu).oh(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        ap.setViewTextColor(this.eXl, R.color.CAM_X0109);
        ap.setViewTextColor(this.mev, R.color.CAM_X0109);
    }
}
