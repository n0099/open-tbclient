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
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.view.i;
/* loaded from: classes22.dex */
public class c {
    private com.baidu.tieba.pb.a.c fos;
    private PbFragment lDI;
    private RelativeLayout lSq = null;
    private TextView lSr = null;
    private ImageView lSs;

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lDI = pbFragment;
        this.fos = cVar;
        initView();
    }

    private void initView() {
        if (this.lSq == null) {
            this.lSq = (RelativeLayout) LayoutInflater.from(this.lDI.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.lSs = (ImageView) this.lSq.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.lSs.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ay.drV());
            this.lSs.setImageMatrix(matrix);
            this.lSr = (TextView) this.lSq.findViewById(R.id.tv_pb_title);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.lSr).pt(R.dimen.T_X03).pv(R.dimen.M_T_X003).ps(R.color.CAM_X0105).pu(R.string.F_X02).pw(R.color.CAM_X0304);
            this.lSr.setVisibility(8);
            if (this.lSr.getParent() == null) {
                this.lSq.addView(this.lSr);
            }
            this.lSq.setOnTouchListener(this.fos);
            this.lSq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lSr != null) {
            ap.setViewTextColor(this.lSr, R.color.CAM_X0105);
            this.lSr.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        }
    }

    public void C(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && !fVar.dmU().bnv() && this.lSr.getText() != null && this.lSr.getText().length() > 0) {
            this.lSr.setVisibility(0);
        } else {
            this.lSr.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lSq.setVisibility(8);
            bdTypeListView.removeHeaderView(this.lSq);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lSq.setVisibility(0);
            bdTypeListView.addHeaderView(this.lSq);
        }
    }

    public void D(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmU() != null) {
            SpannableStringBuilder bpz = fVar.dmU().bpz();
            SpannableString aL = ay.aL(fVar.dmU());
            if (!StringUtils.isNull(fVar.dmU().getTitle())) {
                if (aL != null) {
                    bpz.append((CharSequence) aL);
                    this.lSr.setText(bpz, TextView.BufferType.SPANNABLE);
                } else {
                    this.lSr.setText(bpz);
                }
                E(fVar);
                this.lSr.setVisibility(0);
                this.lSr.setMaxLines(3);
                this.lSr.setEllipsize(TextUtils.TruncateAt.END);
                this.lSr.invalidate();
                return;
            }
            this.lSr.setVisibility(8);
        }
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (this.lSr != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lSr.getLayoutParams();
            if (fVar.dny()) {
                dimens = 0;
            }
            layoutParams.bottomMargin = dimens;
            this.lSr.setLayoutParams(layoutParams);
        }
    }

    public void F(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmU() != null) {
            SpannableStringBuilder bpz = fVar.dmU().bpz();
            this.lSr.setOnTouchListener(new i(bpz));
            this.lSr.setText(bpz);
            this.lSr.setVisibility(0);
        }
    }
}
