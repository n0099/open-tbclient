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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.view.i;
/* loaded from: classes9.dex */
public class c {
    private com.baidu.tieba.pb.a.c dRm;
    private ImageView jCN;
    private PbFragment jpW;
    private RelativeLayout jCL = null;
    private TextView jCM = null;
    private CustomMessageListener jCO = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.jCM != null) {
                c.this.jCM.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.jpW = pbFragment;
        this.dRm = cVar;
        this.jpW.registerListener(this.jCO);
        initView();
    }

    private void initView() {
        if (this.jCL == null) {
            this.jCL = (RelativeLayout) LayoutInflater.from(this.jpW.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.jCN = (ImageView) this.jCL.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.jCN.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -am.cAc());
            this.jCN.setImageMatrix(matrix);
            this.jCM = (TextView) this.jCL.findViewById(R.id.tv_pb_title);
            this.jCM.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.jCM.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.jCM.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jCM, (int) R.color.cp_cont_b);
            this.jCM.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.jCM.setVisibility(8);
            if (this.jCM.getParent() == null) {
                this.jCL.addView(this.jCM);
            }
            this.jCL.setOnTouchListener(this.dRm);
            this.jCL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jCM != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jCM, (int) R.color.cp_cont_b);
            this.jCM.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        }
    }

    public void w(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && !eVar.cvs().aJp() && this.jCM.getText() != null && this.jCM.getText().length() > 0) {
            this.jCM.setVisibility(0);
        } else {
            this.jCM.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.jCL.setVisibility(8);
            bdTypeListView.removeHeaderView(this.jCL);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.jCL.setVisibility(0);
            bdTypeListView.addHeaderView(this.jCL);
        }
    }

    public void x(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvs() != null) {
            SpannableStringBuilder aLj = eVar.cvs().aLj();
            SpannableString aJ = am.aJ(eVar.cvs());
            if (!StringUtils.isNull(eVar.cvs().getTitle())) {
                if (aJ != null) {
                    aLj.append((CharSequence) aJ);
                    this.jCM.setText(aLj, TextView.BufferType.SPANNABLE);
                } else {
                    this.jCM.setText(aLj);
                }
                y(eVar);
                this.jCM.setVisibility(0);
                this.jCM.setMaxLines(3);
                this.jCM.setEllipsize(TextUtils.TruncateAt.END);
                this.jCM.invalidate();
                return;
            }
            this.jCM.setVisibility(8);
        }
    }

    public void y(com.baidu.tieba.pb.data.e eVar) {
        if (this.jCM != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (eVar.cvQ()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.jCM.setLayoutParams(layoutParams);
        }
    }

    public void z(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvs() != null) {
            SpannableStringBuilder aLj = eVar.cvs().aLj();
            this.jCM.setOnTouchListener(new i(aLj));
            this.jCM.setText(aLj);
            this.jCM.setVisibility(0);
        }
    }

    public void c(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.cvs() != null && eVar.cvs().aKR() == 0 && !eVar.cvs().aJp()) {
            if (eVar.jnD) {
                this.jCN.setImageResource(R.drawable.pic_frs_headlines_n);
                this.jCN.setVisibility(0);
            } else if (z && z2) {
                this.jCN.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.jCN.setVisibility(0);
            } else if (z) {
                this.jCN.setImageResource(R.drawable.pic_pb_refined_n);
                this.jCN.setVisibility(0);
            } else if (z2) {
                this.jCN.setImageResource(R.drawable.pic_pb_stick_n);
                this.jCN.setVisibility(0);
            } else {
                this.jCN.setVisibility(8);
            }
            if (this.jCN.getVisibility() == 0 && this.jCN.getLayoutParams() != null) {
                this.jCN.getLayoutParams().height = am.cAd() - am.cAc();
            }
        }
    }
}
