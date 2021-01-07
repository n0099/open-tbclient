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
    private PbFragment lIN;
    private RelativeLayout lXB = null;
    private TextView lXC = null;
    private ImageView lXD;

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lIN = pbFragment;
        this.fyb = cVar;
        initView();
    }

    private void initView() {
        if (this.lXB == null) {
            this.lXB = (RelativeLayout) LayoutInflater.from(this.lIN.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.lXD = (ImageView) this.lXB.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.lXD.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ao.drI());
            this.lXD.setImageMatrix(matrix);
            this.lXC = (TextView) this.lXB.findViewById(R.id.tv_pb_title);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.lXC).pD(R.dimen.T_X03).pF(R.dimen.M_T_X003).pC(R.color.CAM_X0105).pE(R.string.F_X02).pG(R.color.CAM_X0304);
            this.lXC.setVisibility(8);
            if (this.lXC.getParent() == null) {
                this.lXB.addView(this.lXC);
            }
            this.lXB.setOnTouchListener(this.fyb);
            this.lXB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lXC != null) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lXC, R.color.CAM_X0105);
            this.lXC.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0304));
        }
    }

    public void C(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && !fVar.dmF().bpW() && this.lXC.getText() != null && this.lXC.getText().length() > 0) {
            this.lXC.setVisibility(0);
        } else {
            this.lXC.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lXB.setVisibility(8);
            bdTypeListView.removeHeaderView(this.lXB);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lXB.setVisibility(0);
            bdTypeListView.addHeaderView(this.lXB);
        }
    }

    public void D(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmF() != null) {
            SpannableStringBuilder bsa = fVar.dmF().bsa();
            SpannableString aM = ao.aM(fVar.dmF());
            if (!StringUtils.isNull(fVar.dmF().getTitle())) {
                if (aM != null) {
                    bsa.append((CharSequence) aM);
                    this.lXC.setText(bsa, TextView.BufferType.SPANNABLE);
                } else {
                    this.lXC.setText(bsa);
                }
                E(fVar);
                this.lXC.setVisibility(0);
                this.lXC.setMaxLines(3);
                this.lXC.setEllipsize(TextUtils.TruncateAt.END);
                this.lXC.invalidate();
                return;
            }
            this.lXC.setVisibility(8);
        }
    }

    public void E(com.baidu.tieba.pb.data.f fVar) {
        if (this.lXC != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lXC.getLayoutParams();
            if (fVar.dni()) {
                dimens = 0;
            }
            layoutParams.bottomMargin = dimens;
            this.lXC.setLayoutParams(layoutParams);
        }
    }

    public void F(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmF() != null) {
            SpannableStringBuilder bsa = fVar.dmF().bsa();
            this.lXC.setOnTouchListener(new i(bsa));
            this.lXC.setText(bsa);
            this.lXC.setVisibility(0);
        }
    }
}
