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
    private com.baidu.tieba.pb.a.c fhK;
    private ImageView lEh;
    private PbFragment lpI;
    private RelativeLayout lEf = null;
    private TextView lEg = null;
    private CustomMessageListener lEi = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.lEg != null) {
                c.this.lEg.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.lpI = pbFragment;
        this.fhK = cVar;
        this.lpI.registerListener(this.lEi);
        initView();
    }

    private void initView() {
        if (this.lEf == null) {
            this.lEf = (RelativeLayout) LayoutInflater.from(this.lpI.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.lEh = (ImageView) this.lEf.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.lEh.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ay.dne());
            this.lEh.setImageMatrix(matrix);
            this.lEg = (TextView) this.lEf.findViewById(R.id.tv_pb_title);
            this.lEg.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            this.lEg.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.lEg.getPaint().setFakeBoldText(true);
            ap.setViewTextColor(this.lEg, R.color.cp_cont_b);
            this.lEg.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.lEg.setVisibility(8);
            if (this.lEg.getParent() == null) {
                this.lEf.addView(this.lEg);
            }
            this.lEf.setOnTouchListener(this.fhK);
            this.lEf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lEg != null) {
            ap.setViewTextColor(this.lEg, R.color.cp_cont_b);
            this.lEg.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        }
    }

    public void A(f fVar) {
        if (fVar != null && !fVar.dik().blg() && this.lEg.getText() != null && this.lEg.getText().length() > 0) {
            this.lEg.setVisibility(0);
        } else {
            this.lEg.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lEf.setVisibility(8);
            bdTypeListView.removeHeaderView(this.lEf);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lEf.setVisibility(0);
            bdTypeListView.addHeaderView(this.lEf);
        }
    }

    public void B(f fVar) {
        if (fVar != null && fVar.dik() != null) {
            SpannableStringBuilder bnk = fVar.dik().bnk();
            SpannableString aJ = ay.aJ(fVar.dik());
            if (!StringUtils.isNull(fVar.dik().getTitle())) {
                if (aJ != null) {
                    bnk.append((CharSequence) aJ);
                    this.lEg.setText(bnk, TextView.BufferType.SPANNABLE);
                } else {
                    this.lEg.setText(bnk);
                }
                C(fVar);
                this.lEg.setVisibility(0);
                this.lEg.setMaxLines(3);
                this.lEg.setEllipsize(TextUtils.TruncateAt.END);
                this.lEg.invalidate();
                return;
            }
            this.lEg.setVisibility(8);
        }
    }

    public void C(f fVar) {
        if (this.lEg != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (fVar.diN()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.lEg.setLayoutParams(layoutParams);
        }
    }

    public void D(f fVar) {
        if (fVar != null && fVar.dik() != null) {
            SpannableStringBuilder bnk = fVar.dik().bnk();
            this.lEg.setOnTouchListener(new i(bnk));
            this.lEg.setText(bnk);
            this.lEg.setVisibility(0);
        }
    }

    public void c(f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.dik() != null && fVar.dik().bmO() == 0 && !fVar.dik().blg()) {
            if (fVar.lmX) {
                this.lEh.setImageResource(R.drawable.pic_frs_headlines_n);
                this.lEh.setVisibility(0);
            } else if (z && z2) {
                this.lEh.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.lEh.setVisibility(0);
            } else if (z) {
                this.lEh.setImageResource(R.drawable.pic_pb_refined_n);
                this.lEh.setVisibility(0);
            } else if (z2) {
                this.lEh.setImageResource(R.drawable.pic_pb_stick_n);
                this.lEh.setVisibility(0);
            } else {
                this.lEh.setVisibility(8);
            }
            if (this.lEh.getVisibility() == 0 && this.lEh.getLayoutParams() != null) {
                this.lEh.getLayoutParams().height = ay.dnf() - ay.dne();
            }
        }
    }
}
