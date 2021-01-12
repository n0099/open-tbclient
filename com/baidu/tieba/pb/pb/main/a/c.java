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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.view.i;
/* loaded from: classes2.dex */
public class c {
    private com.baidu.tieba.pb.a.c ftt;
    private PbFragment lEi;
    private RelativeLayout lSX = null;
    private TextView lSY = null;
    private ImageView lSZ;

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lEi = pbFragment;
        this.ftt = cVar;
        initView();
    }

    private void initView() {
        if (this.lSX == null) {
            this.lSX = (RelativeLayout) LayoutInflater.from(this.lEi.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.lSZ = (ImageView) this.lSX.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.lSZ.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ao.dnQ());
            this.lSZ.setImageMatrix(matrix);
            this.lSY = (TextView) this.lSX.findViewById(R.id.tv_pb_title);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.lSY).nW(R.dimen.T_X03).nY(R.dimen.M_T_X003).nV(R.color.CAM_X0105).nX(R.string.F_X02).nZ(R.color.CAM_X0304);
            this.lSY.setVisibility(8);
            if (this.lSY.getParent() == null) {
                this.lSX.addView(this.lSY);
            }
            this.lSX.setOnTouchListener(this.ftt);
            this.lSX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lSY != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSY, R.color.CAM_X0105);
            this.lSY.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304));
        }
    }

    public void C(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && !fVar.diN().bmc() && this.lSY.getText() != null && this.lSY.getText().length() > 0) {
            this.lSY.setVisibility(0);
        } else {
            this.lSY.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lSX.setVisibility(8);
            bdTypeListView.removeHeaderView(this.lSX);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lSX.setVisibility(0);
            bdTypeListView.addHeaderView(this.lSX);
        }
    }

    public void D(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.diN() != null) {
            SpannableStringBuilder bog = fVar.diN().bog();
            SpannableString aM = ao.aM(fVar.diN());
            if (!StringUtils.isNull(fVar.diN().getTitle())) {
                if (aM != null) {
                    bog.append((CharSequence) aM);
                    this.lSY.setText(bog, TextView.BufferType.SPANNABLE);
                } else {
                    this.lSY.setText(bog);
                }
                E(fVar);
                this.lSY.setVisibility(0);
                this.lSY.setMaxLines(3);
                this.lSY.setEllipsize(TextUtils.TruncateAt.END);
                this.lSY.invalidate();
                return;
            }
            this.lSY.setVisibility(8);
        }
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (this.lSY != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lSY.getLayoutParams();
            if (fVar.djq()) {
                dimens = 0;
            }
            layoutParams.bottomMargin = dimens;
            this.lSY.setLayoutParams(layoutParams);
        }
    }

    public void F(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.diN() != null) {
            SpannableStringBuilder bog = fVar.diN().bog();
            this.lSY.setOnTouchListener(new i(bog));
            this.lSY.setText(bog);
            this.lSY.setVisibility(0);
        }
    }
}
