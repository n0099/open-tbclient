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
import com.baidu.tieba.view.h;
/* loaded from: classes9.dex */
public class c {
    private com.baidu.tieba.pb.a.c dqK;
    private PbFragment iDY;
    private ImageView iQN;
    private RelativeLayout iQL = null;
    private TextView iQM = null;
    private CustomMessageListener iQO = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.iQM != null) {
                c.this.iQM.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.iDY = pbFragment;
        this.dqK = cVar;
        this.iDY.registerListener(this.iQO);
        initView();
    }

    private void initView() {
        if (this.iQL == null) {
            this.iQL = (RelativeLayout) LayoutInflater.from(this.iDY.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.iQN = (ImageView) this.iQL.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.iQN.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -am.cpc());
            this.iQN.setImageMatrix(matrix);
            this.iQM = (TextView) this.iQL.findViewById(R.id.tv_pb_title);
            this.iQM.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.iQM.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.iQM.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iQM, (int) R.color.cp_cont_b);
            this.iQM.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.iQM.setVisibility(8);
            if (this.iQM.getParent() == null) {
                this.iQL.addView(this.iQM);
            }
            this.iQL.setOnTouchListener(this.dqK);
            this.iQL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iQM != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iQM, (int) R.color.cp_cont_b);
            this.iQM.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        }
    }

    public void w(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && !eVar.cku().aBb() && this.iQM.getText() != null && this.iQM.getText().length() > 0) {
            this.iQM.setVisibility(0);
        } else {
            this.iQM.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.iQL.setVisibility(8);
            bdTypeListView.removeHeaderView(this.iQL);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.iQL.setVisibility(0);
            bdTypeListView.addHeaderView(this.iQL);
        }
    }

    public void x(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cku() != null) {
            SpannableStringBuilder aCV = eVar.cku().aCV();
            SpannableString aH = am.aH(eVar.cku());
            if (!StringUtils.isNull(eVar.cku().getTitle())) {
                if (aH != null) {
                    aCV.append((CharSequence) aH);
                    this.iQM.setText(aCV, TextView.BufferType.SPANNABLE);
                } else {
                    this.iQM.setText(aCV);
                }
                y(eVar);
                this.iQM.setVisibility(0);
                this.iQM.setMaxLines(3);
                this.iQM.setEllipsize(TextUtils.TruncateAt.END);
                this.iQM.invalidate();
                return;
            }
            this.iQM.setVisibility(8);
        }
    }

    public void y(com.baidu.tieba.pb.data.e eVar) {
        if (this.iQM != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (eVar.ckS()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.iQM.setLayoutParams(layoutParams);
        }
    }

    public void z(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cku() != null) {
            SpannableStringBuilder aCV = eVar.cku().aCV();
            this.iQM.setOnTouchListener(new h(aCV));
            this.iQM.setText(aCV);
            this.iQM.setVisibility(0);
        }
    }

    public void c(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.cku() != null && eVar.cku().aCD() == 0 && !eVar.cku().aBb()) {
            if (eVar.iBH) {
                this.iQN.setImageResource(R.drawable.pic_frs_headlines_n);
                this.iQN.setVisibility(0);
            } else if (z && z2) {
                this.iQN.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.iQN.setVisibility(0);
            } else if (z) {
                this.iQN.setImageResource(R.drawable.pic_pb_refined_n);
                this.iQN.setVisibility(0);
            } else if (z2) {
                this.iQN.setImageResource(R.drawable.pic_pb_stick_n);
                this.iQN.setVisibility(0);
            } else {
                this.iQN.setVisibility(8);
            }
            if (this.iQN.getVisibility() == 0 && this.iQN.getLayoutParams() != null) {
                this.iQN.getLayoutParams().height = am.cpd() - am.cpc();
            }
        }
    }
}
