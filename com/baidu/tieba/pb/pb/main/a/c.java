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
    private PbFragment lDG;
    private RelativeLayout lSo = null;
    private TextView lSp = null;
    private ImageView lSq;

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lDG = pbFragment;
        this.fos = cVar;
        initView();
    }

    private void initView() {
        if (this.lSo == null) {
            this.lSo = (RelativeLayout) LayoutInflater.from(this.lDG.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.lSq = (ImageView) this.lSo.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.lSq.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ay.drU());
            this.lSq.setImageMatrix(matrix);
            this.lSp = (TextView) this.lSo.findViewById(R.id.tv_pb_title);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.lSp).pt(R.dimen.T_X03).pv(R.dimen.M_T_X003).ps(R.color.CAM_X0105).pu(R.string.F_X02).pw(R.color.CAM_X0304);
            this.lSp.setVisibility(8);
            if (this.lSp.getParent() == null) {
                this.lSo.addView(this.lSp);
            }
            this.lSo.setOnTouchListener(this.fos);
            this.lSo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lSp != null) {
            ap.setViewTextColor(this.lSp, R.color.CAM_X0105);
            this.lSp.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        }
    }

    public void C(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && !fVar.dmT().bnv() && this.lSp.getText() != null && this.lSp.getText().length() > 0) {
            this.lSp.setVisibility(0);
        } else {
            this.lSp.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lSo.setVisibility(8);
            bdTypeListView.removeHeaderView(this.lSo);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lSo.setVisibility(0);
            bdTypeListView.addHeaderView(this.lSo);
        }
    }

    public void D(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmT() != null) {
            SpannableStringBuilder bpz = fVar.dmT().bpz();
            SpannableString aL = ay.aL(fVar.dmT());
            if (!StringUtils.isNull(fVar.dmT().getTitle())) {
                if (aL != null) {
                    bpz.append((CharSequence) aL);
                    this.lSp.setText(bpz, TextView.BufferType.SPANNABLE);
                } else {
                    this.lSp.setText(bpz);
                }
                E(fVar);
                this.lSp.setVisibility(0);
                this.lSp.setMaxLines(3);
                this.lSp.setEllipsize(TextUtils.TruncateAt.END);
                this.lSp.invalidate();
                return;
            }
            this.lSp.setVisibility(8);
        }
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (this.lSp != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lSp.getLayoutParams();
            if (fVar.dnx()) {
                dimens = 0;
            }
            layoutParams.bottomMargin = dimens;
            this.lSp.setLayoutParams(layoutParams);
        }
    }

    public void F(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmT() != null) {
            SpannableStringBuilder bpz = fVar.dmT().bpz();
            this.lSp.setOnTouchListener(new i(bpz));
            this.lSp.setText(bpz);
            this.lSp.setVisibility(0);
        }
    }
}
