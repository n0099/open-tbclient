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
    private com.baidu.tieba.pb.a.c dqX;
    private PbFragment iEk;
    private ImageView iQZ;
    private RelativeLayout iQX = null;
    private TextView iQY = null;
    private CustomMessageListener iRa = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.iQY != null) {
                c.this.iQY.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.iEk = pbFragment;
        this.dqX = cVar;
        this.iEk.registerListener(this.iRa);
        initView();
    }

    private void initView() {
        if (this.iQX == null) {
            this.iQX = (RelativeLayout) LayoutInflater.from(this.iEk.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.iQZ = (ImageView) this.iQX.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.iQZ.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -am.cpd());
            this.iQZ.setImageMatrix(matrix);
            this.iQY = (TextView) this.iQX.findViewById(R.id.tv_pb_title);
            this.iQY.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.iQY.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.iQY.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iQY, (int) R.color.cp_cont_b);
            this.iQY.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.iQY.setVisibility(8);
            if (this.iQY.getParent() == null) {
                this.iQX.addView(this.iQY);
            }
            this.iQX.setOnTouchListener(this.dqX);
            this.iQX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iQY != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iQY, (int) R.color.cp_cont_b);
            this.iQY.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        }
    }

    public void w(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && !eVar.ckv().aBb() && this.iQY.getText() != null && this.iQY.getText().length() > 0) {
            this.iQY.setVisibility(0);
        } else {
            this.iQY.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.iQX.setVisibility(8);
            bdTypeListView.removeHeaderView(this.iQX);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.iQX.setVisibility(0);
            bdTypeListView.addHeaderView(this.iQX);
        }
    }

    public void x(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckv() != null) {
            SpannableStringBuilder aCV = eVar.ckv().aCV();
            SpannableString aH = am.aH(eVar.ckv());
            if (!StringUtils.isNull(eVar.ckv().getTitle())) {
                if (aH != null) {
                    aCV.append((CharSequence) aH);
                    this.iQY.setText(aCV, TextView.BufferType.SPANNABLE);
                } else {
                    this.iQY.setText(aCV);
                }
                y(eVar);
                this.iQY.setVisibility(0);
                this.iQY.setMaxLines(3);
                this.iQY.setEllipsize(TextUtils.TruncateAt.END);
                this.iQY.invalidate();
                return;
            }
            this.iQY.setVisibility(8);
        }
    }

    public void y(com.baidu.tieba.pb.data.e eVar) {
        if (this.iQY != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (eVar.ckT()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.iQY.setLayoutParams(layoutParams);
        }
    }

    public void z(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckv() != null) {
            SpannableStringBuilder aCV = eVar.ckv().aCV();
            this.iQY.setOnTouchListener(new h(aCV));
            this.iQY.setText(aCV);
            this.iQY.setVisibility(0);
        }
    }

    public void c(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.ckv() != null && eVar.ckv().aCD() == 0 && !eVar.ckv().aBb()) {
            if (eVar.iBT) {
                this.iQZ.setImageResource(R.drawable.pic_frs_headlines_n);
                this.iQZ.setVisibility(0);
            } else if (z && z2) {
                this.iQZ.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.iQZ.setVisibility(0);
            } else if (z) {
                this.iQZ.setImageResource(R.drawable.pic_pb_refined_n);
                this.iQZ.setVisibility(0);
            } else if (z2) {
                this.iQZ.setImageResource(R.drawable.pic_pb_stick_n);
                this.iQZ.setVisibility(0);
            } else {
                this.iQZ.setVisibility(8);
            }
            if (this.iQZ.getVisibility() == 0 && this.iQZ.getLayoutParams() != null) {
                this.iQZ.getLayoutParams().height = am.cpe() - am.cpd();
            }
        }
    }
}
