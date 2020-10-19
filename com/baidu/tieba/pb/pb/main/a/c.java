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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.view.i;
/* loaded from: classes22.dex */
public class c {
    private com.baidu.tieba.pb.a.c eTx;
    private PbFragment kXi;
    private ImageView llH;
    private RelativeLayout llF = null;
    private TextView llG = null;
    private CustomMessageListener llI = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.llG != null) {
                c.this.llG.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.kXi = pbFragment;
        this.eTx = cVar;
        this.kXi.registerListener(this.llI);
        initView();
    }

    private void initView() {
        if (this.llF == null) {
            this.llF = (RelativeLayout) LayoutInflater.from(this.kXi.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.llH = (ImageView) this.llF.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.llH.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ay.dhv());
            this.llH.setImageMatrix(matrix);
            this.llG = (TextView) this.llF.findViewById(R.id.tv_pb_title);
            this.llG.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            this.llG.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.llG.getPaint().setFakeBoldText(true);
            ap.setViewTextColor(this.llG, R.color.cp_cont_b);
            this.llG.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.llG.setVisibility(8);
            if (this.llG.getParent() == null) {
                this.llF.addView(this.llG);
            }
            this.llF.setOnTouchListener(this.eTx);
            this.llF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.llG != null) {
            ap.setViewTextColor(this.llG, R.color.cp_cont_b);
            this.llG.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        }
    }

    public void A(f fVar) {
        if (fVar != null && !fVar.dcA().bgN() && this.llG.getText() != null && this.llG.getText().length() > 0) {
            this.llG.setVisibility(0);
        } else {
            this.llG.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.llF.setVisibility(8);
            bdTypeListView.removeHeaderView(this.llF);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.llF.setVisibility(0);
            bdTypeListView.addHeaderView(this.llF);
        }
    }

    public void B(f fVar) {
        if (fVar != null && fVar.dcA() != null) {
            SpannableStringBuilder biR = fVar.dcA().biR();
            SpannableString aJ = ay.aJ(fVar.dcA());
            if (!StringUtils.isNull(fVar.dcA().getTitle())) {
                if (aJ != null) {
                    biR.append((CharSequence) aJ);
                    this.llG.setText(biR, TextView.BufferType.SPANNABLE);
                } else {
                    this.llG.setText(biR);
                }
                C(fVar);
                this.llG.setVisibility(0);
                this.llG.setMaxLines(3);
                this.llG.setEllipsize(TextUtils.TruncateAt.END);
                this.llG.invalidate();
                return;
            }
            this.llG.setVisibility(8);
        }
    }

    public void C(f fVar) {
        if (this.llG != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (fVar.ddd()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.llG.setLayoutParams(layoutParams);
        }
    }

    public void D(f fVar) {
        if (fVar != null && fVar.dcA() != null) {
            SpannableStringBuilder biR = fVar.dcA().biR();
            this.llG.setOnTouchListener(new i(biR));
            this.llG.setText(biR);
            this.llG.setVisibility(0);
        }
    }

    public void c(f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.dcA() != null && fVar.dcA().biv() == 0 && !fVar.dcA().bgN()) {
            if (fVar.kUC) {
                this.llH.setImageResource(R.drawable.pic_frs_headlines_n);
                this.llH.setVisibility(0);
            } else if (z && z2) {
                this.llH.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.llH.setVisibility(0);
            } else if (z) {
                this.llH.setImageResource(R.drawable.pic_pb_refined_n);
                this.llH.setVisibility(0);
            } else if (z2) {
                this.llH.setImageResource(R.drawable.pic_pb_stick_n);
                this.llH.setVisibility(0);
            } else {
                this.llH.setVisibility(8);
            }
            if (this.llH.getVisibility() == 0 && this.llH.getLayoutParams() != null) {
                this.llH.getLayoutParams().height = ay.dhw() - ay.dhv();
            }
        }
    }
}
