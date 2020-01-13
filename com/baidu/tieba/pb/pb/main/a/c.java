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
/* loaded from: classes7.dex */
public class c {
    private com.baidu.tieba.pb.a.c dmA;
    private PbFragment iCe;
    private ImageView iPq;
    private RelativeLayout iPo = null;
    private TextView iPp = null;
    private CustomMessageListener iPr = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.iPp != null) {
                c.this.iPp.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.iCe = pbFragment;
        this.dmA = cVar;
        this.iCe.registerListener(this.iPr);
        initView();
    }

    private void initView() {
        if (this.iPo == null) {
            this.iPo = (RelativeLayout) LayoutInflater.from(this.iCe.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.iPq = (ImageView) this.iPo.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.iPq.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ap.cnJ());
            this.iPq.setImageMatrix(matrix);
            this.iPp = (TextView) this.iPo.findViewById(R.id.tv_pb_title);
            this.iPp.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.iPp.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.iPp.getPaint().setFakeBoldText(true);
            am.setViewTextColor(this.iPp, (int) R.color.cp_cont_b);
            this.iPp.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.iPp.setVisibility(8);
            if (this.iPp.getParent() == null) {
                this.iPo.addView(this.iPp);
            }
            this.iPo.setOnTouchListener(this.dmA);
            this.iPo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iPp != null) {
            am.setViewTextColor(this.iPp, (int) R.color.cp_cont_b);
            this.iPp.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        }
    }

    public void v(f fVar) {
        if (fVar != null && !fVar.ciS().aAX() && this.iPp.getText() != null && this.iPp.getText().length() > 0) {
            this.iPp.setVisibility(0);
        } else {
            this.iPp.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.iPo.setVisibility(8);
            bdTypeListView.removeHeaderView(this.iPo);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.iPo.setVisibility(0);
            bdTypeListView.addHeaderView(this.iPo);
        }
    }

    public void w(f fVar) {
        if (fVar != null && fVar.ciS() != null) {
            SpannableStringBuilder aAE = fVar.ciS().aAE();
            SpannableString aE = ap.aE(fVar.ciS());
            if (!StringUtils.isNull(fVar.ciS().getTitle())) {
                if (aE != null) {
                    aAE.append((CharSequence) aE);
                    this.iPp.setText(aAE, TextView.BufferType.SPANNABLE);
                } else {
                    this.iPp.setText(aAE);
                }
                x(fVar);
                this.iPp.setVisibility(0);
                this.iPp.setMaxLines(3);
                this.iPp.setEllipsize(TextUtils.TruncateAt.END);
                this.iPp.invalidate();
                return;
            }
            this.iPp.setVisibility(8);
        }
    }

    public void x(f fVar) {
        if (this.iPp != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (fVar.cjs()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.iPp.setLayoutParams(layoutParams);
        }
    }

    public void y(f fVar) {
        if (fVar != null && fVar.ciS() != null) {
            SpannableStringBuilder aAE = fVar.ciS().aAE();
            this.iPp.setOnTouchListener(new h(aAE));
            this.iPp.setText(aAE);
            this.iPp.setVisibility(0);
        }
    }

    public void c(f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.ciS() != null && fVar.ciS().aAm() == 0 && !fVar.ciS().aAX()) {
            if (fVar.izN) {
                this.iPq.setImageResource(R.drawable.pic_frs_headlines_n);
                this.iPq.setVisibility(0);
            } else if (z && z2) {
                this.iPq.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.iPq.setVisibility(0);
            } else if (z) {
                this.iPq.setImageResource(R.drawable.pic_pb_refined_n);
                this.iPq.setVisibility(0);
            } else if (z2) {
                this.iPq.setImageResource(R.drawable.pic_pb_stick_n);
                this.iPq.setVisibility(0);
            } else {
                this.iPq.setVisibility(8);
            }
            if (this.iPq.getVisibility() == 0 && this.iPq.getLayoutParams() != null) {
                this.iPq.getLayoutParams().height = ap.cnK() - ap.cnJ();
            }
        }
    }
}
