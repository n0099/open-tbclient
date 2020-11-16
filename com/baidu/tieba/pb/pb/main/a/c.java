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
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.view.i;
/* loaded from: classes21.dex */
public class c {
    private com.baidu.tieba.pb.a.c fgS;
    private RelativeLayout lEx = null;
    private TextView lEy = null;
    private ImageView lEz;
    private PbFragment lpX;

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lpX = pbFragment;
        this.fgS = cVar;
        initView();
    }

    private void initView() {
        if (this.lEx == null) {
            this.lEx = (RelativeLayout) LayoutInflater.from(this.lpX.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.lEz = (ImageView) this.lEx.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.lEz.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ay.dmD());
            this.lEz.setImageMatrix(matrix);
            this.lEy = (TextView) this.lEx.findViewById(R.id.tv_pb_title);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.lEy).oU(R.dimen.T_X03).oW(R.dimen.M_T_X003).oT(R.color.CAM_X0105).oV(R.string.F_X02).oX(R.color.CAM_X0304);
            this.lEy.setVisibility(8);
            if (this.lEy.getParent() == null) {
                this.lEx.addView(this.lEy);
            }
            this.lEx.setOnTouchListener(this.fgS);
            this.lEx.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lEy != null) {
            ap.setViewTextColor(this.lEy, R.color.CAM_X0105);
            this.lEy.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        }
    }

    public void C(f fVar) {
        if (fVar != null && !fVar.dhH().bki() && this.lEy.getText() != null && this.lEy.getText().length() > 0) {
            this.lEy.setVisibility(0);
        } else {
            this.lEy.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lEx.setVisibility(8);
            bdTypeListView.removeHeaderView(this.lEx);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lEx.setVisibility(0);
            bdTypeListView.addHeaderView(this.lEx);
        }
    }

    public void D(f fVar) {
        if (fVar != null && fVar.dhH() != null) {
            SpannableStringBuilder bmm = fVar.dhH().bmm();
            SpannableString aL = ay.aL(fVar.dhH());
            if (!StringUtils.isNull(fVar.dhH().getTitle())) {
                if (aL != null) {
                    bmm.append((CharSequence) aL);
                    this.lEy.setText(bmm, TextView.BufferType.SPANNABLE);
                } else {
                    this.lEy.setText(bmm);
                }
                E(fVar);
                this.lEy.setVisibility(0);
                this.lEy.setMaxLines(3);
                this.lEy.setEllipsize(TextUtils.TruncateAt.END);
                this.lEy.invalidate();
                return;
            }
            this.lEy.setVisibility(8);
        }
    }

    public void E(f fVar) {
        if (this.lEy != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lEy.getLayoutParams();
            if (fVar.dik()) {
                dimens = 0;
            }
            layoutParams.bottomMargin = dimens;
            this.lEy.setLayoutParams(layoutParams);
        }
    }

    public void F(f fVar) {
        if (fVar != null && fVar.dhH() != null) {
            SpannableStringBuilder bmm = fVar.dhH().bmm();
            this.lEy.setOnTouchListener(new i(bmm));
            this.lEy.setText(bmm);
            this.lEy.setVisibility(0);
        }
    }
}
