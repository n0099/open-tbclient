package com.baidu.tieba.pb.pb.main.a;

import android.graphics.Matrix;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.view.i;
/* loaded from: classes2.dex */
public class c {
    private com.baidu.tieba.pb.a.c fvK;
    private PbFragment lNm;
    private RelativeLayout mcn = null;
    private TextView mco = null;
    private ImageView mcp;

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lNm = pbFragment;
        this.fvK = cVar;
        initView();
    }

    private void initView() {
        if (this.mcn == null) {
            this.mcn = (RelativeLayout) LayoutInflater.from(this.lNm.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.mcp = (ImageView) this.mcn.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.mcp.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ao.dql());
            this.mcp.setImageMatrix(matrix);
            this.mco = (TextView) this.mcn.findViewById(R.id.tv_pb_title);
            com.baidu.tbadk.core.elementsMaven.c.br(this.mco).nZ(R.dimen.T_X03).ob(R.dimen.M_T_X003).nY(R.color.CAM_X0105).oa(R.string.F_X02).oc(R.color.CAM_X0304);
            this.mco.setVisibility(8);
            if (this.mco.getParent() == null) {
                this.mcn.addView(this.mco);
            }
            this.mcn.setOnTouchListener(this.fvK);
            this.mcn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mco != null) {
            ap.setViewTextColor(this.mco, R.color.CAM_X0105);
            this.mco.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        }
    }

    public void C(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && !fVar.dlg().bmv() && this.mco.getText() != null && this.mco.getText().length() > 0) {
            this.mco.setVisibility(0);
        } else {
            this.mco.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.mcn.setVisibility(8);
            bdTypeListView.removeHeaderView(this.mcn);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.mcn.setVisibility(0);
            bdTypeListView.addHeaderView(this.mcn);
        }
    }

    public void D(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlg() != null) {
            SpannableStringBuilder boz = fVar.dlg().boz();
            SpannableString aN = ao.aN(fVar.dlg());
            if (!StringUtils.isNull(fVar.dlg().getTitle())) {
                if (aN != null) {
                    boz.append((CharSequence) aN);
                    this.mco.setText(boz, TextView.BufferType.SPANNABLE);
                } else {
                    this.mco.setText(boz);
                }
                E(fVar);
                this.mco.setVisibility(0);
                this.mco.setMaxLines(3);
                this.mco.setEllipsize(TextUtils.TruncateAt.END);
                this.mco.invalidate();
                return;
            }
            this.mco.setVisibility(8);
        }
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (this.mco != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mco.getLayoutParams();
            if (fVar.dlJ()) {
                dimens = 0;
            }
            layoutParams.bottomMargin = dimens;
            this.mco.setLayoutParams(layoutParams);
        }
    }

    public void F(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlg() != null) {
            SpannableStringBuilder boz = fVar.dlg().boz();
            this.mco.setOnTouchListener(new i(boz));
            this.mco.setText(boz);
            this.mco.setVisibility(0);
        }
    }
}
