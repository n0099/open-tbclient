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
    private com.baidu.tieba.pb.a.c fxj;
    private PbFragment lPo;
    private RelativeLayout meq = null;
    private TextView mer = null;
    private ImageView mes;

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lPo = pbFragment;
        this.fxj = cVar;
        initView();
    }

    private void initView() {
        if (this.meq == null) {
            this.meq = (RelativeLayout) LayoutInflater.from(this.lPo.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.mes = (ImageView) this.meq.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.mes.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ao.dqu());
            this.mes.setImageMatrix(matrix);
            this.mer = (TextView) this.meq.findViewById(R.id.tv_pb_title);
            com.baidu.tbadk.core.elementsMaven.c.br(this.mer).oa(R.dimen.T_X03).oc(R.dimen.M_T_X003).nZ(R.color.CAM_X0105).ob(R.string.F_X02).od(R.color.CAM_X0304);
            this.mer.setVisibility(8);
            if (this.mer.getParent() == null) {
                this.meq.addView(this.mer);
            }
            this.meq.setOnTouchListener(this.fxj);
            this.meq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mer != null) {
            ap.setViewTextColor(this.mer, R.color.CAM_X0105);
            this.mer.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        }
    }

    public void C(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && !fVar.dlp().bmx() && this.mer.getText() != null && this.mer.getText().length() > 0) {
            this.mer.setVisibility(0);
        } else {
            this.mer.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.meq.setVisibility(8);
            bdTypeListView.removeHeaderView(this.meq);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.meq.setVisibility(0);
            bdTypeListView.addHeaderView(this.meq);
        }
    }

    public void D(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlp() != null) {
            SpannableStringBuilder boB = fVar.dlp().boB();
            SpannableString aN = ao.aN(fVar.dlp());
            if (!StringUtils.isNull(fVar.dlp().getTitle())) {
                if (aN != null) {
                    boB.append((CharSequence) aN);
                    this.mer.setText(boB, TextView.BufferType.SPANNABLE);
                } else {
                    this.mer.setText(boB);
                }
                E(fVar);
                this.mer.setVisibility(0);
                this.mer.setMaxLines(3);
                this.mer.setEllipsize(TextUtils.TruncateAt.END);
                this.mer.invalidate();
                return;
            }
            this.mer.setVisibility(8);
        }
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (this.mer != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mer.getLayoutParams();
            if (fVar.dlS()) {
                dimens = 0;
            }
            layoutParams.bottomMargin = dimens;
            this.mer.setLayoutParams(layoutParams);
        }
    }

    public void F(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlp() != null) {
            SpannableStringBuilder boB = fVar.dlp().boB();
            this.mer.setOnTouchListener(new i(boB));
            this.mer.setText(boB);
            this.mer.setVisibility(0);
        }
    }
}
