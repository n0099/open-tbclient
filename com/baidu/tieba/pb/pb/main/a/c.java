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
    private PbFragment lMX;
    private RelativeLayout mbY = null;
    private TextView mbZ = null;
    private ImageView mca;

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lMX = pbFragment;
        this.fvK = cVar;
        initView();
    }

    private void initView() {
        if (this.mbY == null) {
            this.mbY = (RelativeLayout) LayoutInflater.from(this.lMX.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.mca = (ImageView) this.mbY.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.mca.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ao.dqe());
            this.mca.setImageMatrix(matrix);
            this.mbZ = (TextView) this.mbY.findViewById(R.id.tv_pb_title);
            com.baidu.tbadk.core.elementsMaven.c.br(this.mbZ).nZ(R.dimen.T_X03).ob(R.dimen.M_T_X003).nY(R.color.CAM_X0105).oa(R.string.F_X02).oc(R.color.CAM_X0304);
            this.mbZ.setVisibility(8);
            if (this.mbZ.getParent() == null) {
                this.mbY.addView(this.mbZ);
            }
            this.mbY.setOnTouchListener(this.fvK);
            this.mbY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mbZ != null) {
            ap.setViewTextColor(this.mbZ, R.color.CAM_X0105);
            this.mbZ.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        }
    }

    public void C(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && !fVar.dkZ().bmv() && this.mbZ.getText() != null && this.mbZ.getText().length() > 0) {
            this.mbZ.setVisibility(0);
        } else {
            this.mbZ.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.mbY.setVisibility(8);
            bdTypeListView.removeHeaderView(this.mbY);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.mbY.setVisibility(0);
            bdTypeListView.addHeaderView(this.mbY);
        }
    }

    public void D(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dkZ() != null) {
            SpannableStringBuilder boz = fVar.dkZ().boz();
            SpannableString aN = ao.aN(fVar.dkZ());
            if (!StringUtils.isNull(fVar.dkZ().getTitle())) {
                if (aN != null) {
                    boz.append((CharSequence) aN);
                    this.mbZ.setText(boz, TextView.BufferType.SPANNABLE);
                } else {
                    this.mbZ.setText(boz);
                }
                E(fVar);
                this.mbZ.setVisibility(0);
                this.mbZ.setMaxLines(3);
                this.mbZ.setEllipsize(TextUtils.TruncateAt.END);
                this.mbZ.invalidate();
                return;
            }
            this.mbZ.setVisibility(8);
        }
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (this.mbZ != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mbZ.getLayoutParams();
            if (fVar.dlC()) {
                dimens = 0;
            }
            layoutParams.bottomMargin = dimens;
            this.mbZ.setLayoutParams(layoutParams);
        }
    }

    public void F(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dkZ() != null) {
            SpannableStringBuilder boz = fVar.dkZ().boz();
            this.mbZ.setOnTouchListener(new i(boz));
            this.mbZ.setText(boz);
            this.mbZ.setVisibility(0);
        }
    }
}
