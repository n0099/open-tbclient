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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.view.h;
/* loaded from: classes6.dex */
public class c {
    private com.baidu.tieba.pb.a.c dmm;
    private ImageView iLM;
    private PbFragment iyA;
    private RelativeLayout iLK = null;
    private TextView iLL = null;
    private CustomMessageListener iLN = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.iLL != null) {
                c.this.iLL.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.iyA = pbFragment;
        this.dmm = cVar;
        this.iyA.registerListener(this.iLN);
        initView();
    }

    private void initView() {
        if (this.iLK == null) {
            this.iLK = (RelativeLayout) LayoutInflater.from(this.iyA.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.iLM = (ImageView) this.iLK.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.iLM.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ap.cmC());
            this.iLM.setImageMatrix(matrix);
            this.iLL = (TextView) this.iLK.findViewById(R.id.tv_pb_title);
            this.iLL.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.iLL.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.iLL.getPaint().setFakeBoldText(true);
            am.setViewTextColor(this.iLL, (int) R.color.cp_cont_b);
            this.iLL.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.iLL.setVisibility(8);
            if (this.iLL.getParent() == null) {
                this.iLK.addView(this.iLL);
            }
            this.iLK.setOnTouchListener(this.dmm);
            this.iLK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLL != null) {
            am.setViewTextColor(this.iLL, (int) R.color.cp_cont_b);
            this.iLL.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        }
    }

    public void v(f fVar) {
        if (fVar != null && !fVar.chK().aAE() && this.iLL.getText() != null && this.iLL.getText().length() > 0) {
            this.iLL.setVisibility(0);
        } else {
            this.iLL.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.iLK.setVisibility(8);
            bdTypeListView.removeHeaderView(this.iLK);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.iLK.setVisibility(0);
            bdTypeListView.addHeaderView(this.iLK);
        }
    }

    public void w(f fVar) {
        if (fVar != null && fVar.chK() != null) {
            SpannableStringBuilder aAl = fVar.chK().aAl();
            SpannableString aD = ap.aD(fVar.chK());
            if (!StringUtils.isNull(fVar.chK().getTitle())) {
                if (aD != null) {
                    aAl.append((CharSequence) aD);
                    this.iLL.setText(aAl, TextView.BufferType.SPANNABLE);
                } else {
                    this.iLL.setText(aAl);
                }
                x(fVar);
                this.iLL.setVisibility(0);
                this.iLL.setMaxLines(3);
                this.iLL.setEllipsize(TextUtils.TruncateAt.END);
                this.iLL.invalidate();
                return;
            }
            this.iLL.setVisibility(8);
        }
    }

    public void x(f fVar) {
        if (this.iLL != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (fVar.cik()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.iLL.setLayoutParams(layoutParams);
        }
    }

    public void y(f fVar) {
        if (fVar != null && fVar.chK() != null) {
            SpannableStringBuilder aAl = fVar.chK().aAl();
            this.iLL.setOnTouchListener(new h(aAl));
            this.iLL.setText(aAl);
            this.iLL.setVisibility(0);
        }
    }

    public void c(f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.chK() != null && fVar.chK().azT() == 0 && !fVar.chK().aAE()) {
            if (fVar.iwj) {
                this.iLM.setImageResource(R.drawable.pic_frs_headlines_n);
                this.iLM.setVisibility(0);
            } else if (z && z2) {
                this.iLM.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.iLM.setVisibility(0);
            } else if (z) {
                this.iLM.setImageResource(R.drawable.pic_pb_refined_n);
                this.iLM.setVisibility(0);
            } else if (z2) {
                this.iLM.setImageResource(R.drawable.pic_pb_stick_n);
                this.iLM.setVisibility(0);
            } else {
                this.iLM.setVisibility(8);
            }
            if (this.iLM.getVisibility() == 0 && this.iLM.getLayoutParams() != null) {
                this.iLM.getLayoutParams().height = ap.cmD() - ap.cmC();
            }
        }
    }
}
