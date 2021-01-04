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
    private com.baidu.tieba.pb.a.c fyb;
    private PbFragment lIO;
    private RelativeLayout lXC = null;
    private TextView lXD = null;
    private ImageView lXE;

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lIO = pbFragment;
        this.fyb = cVar;
        initView();
    }

    private void initView() {
        if (this.lXC == null) {
            this.lXC = (RelativeLayout) LayoutInflater.from(this.lIO.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.lXE = (ImageView) this.lXC.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.lXE.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ao.drH());
            this.lXE.setImageMatrix(matrix);
            this.lXD = (TextView) this.lXC.findViewById(R.id.tv_pb_title);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.lXD).pD(R.dimen.T_X03).pF(R.dimen.M_T_X003).pC(R.color.CAM_X0105).pE(R.string.F_X02).pG(R.color.CAM_X0304);
            this.lXD.setVisibility(8);
            if (this.lXD.getParent() == null) {
                this.lXC.addView(this.lXD);
            }
            this.lXC.setOnTouchListener(this.fyb);
            this.lXC.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lXD != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXD, R.color.CAM_X0105);
            this.lXD.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304));
        }
    }

    public void C(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && !fVar.dmE().bpV() && this.lXD.getText() != null && this.lXD.getText().length() > 0) {
            this.lXD.setVisibility(0);
        } else {
            this.lXD.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lXC.setVisibility(8);
            bdTypeListView.removeHeaderView(this.lXC);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lXC.setVisibility(0);
            bdTypeListView.addHeaderView(this.lXC);
        }
    }

    public void D(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmE() != null) {
            SpannableStringBuilder brZ = fVar.dmE().brZ();
            SpannableString aM = ao.aM(fVar.dmE());
            if (!StringUtils.isNull(fVar.dmE().getTitle())) {
                if (aM != null) {
                    brZ.append((CharSequence) aM);
                    this.lXD.setText(brZ, TextView.BufferType.SPANNABLE);
                } else {
                    this.lXD.setText(brZ);
                }
                E(fVar);
                this.lXD.setVisibility(0);
                this.lXD.setMaxLines(3);
                this.lXD.setEllipsize(TextUtils.TruncateAt.END);
                this.lXD.invalidate();
                return;
            }
            this.lXD.setVisibility(8);
        }
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (this.lXD != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lXD.getLayoutParams();
            if (fVar.dnh()) {
                dimens = 0;
            }
            layoutParams.bottomMargin = dimens;
            this.lXD.setLayoutParams(layoutParams);
        }
    }

    public void F(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmE() != null) {
            SpannableStringBuilder brZ = fVar.dmE().brZ();
            this.lXD.setOnTouchListener(new i(brZ));
            this.lXD.setText(brZ);
            this.lXD.setVisibility(0);
        }
    }
}
