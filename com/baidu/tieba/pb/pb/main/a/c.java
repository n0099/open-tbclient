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
/* loaded from: classes16.dex */
public class c {
    private com.baidu.tieba.pb.a.c eFf;
    private ImageView kNN;
    private PbFragment kzt;
    private RelativeLayout kNL = null;
    private TextView kNM = null;
    private CustomMessageListener kNO = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.kNM != null) {
                c.this.kNM.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.kzt = pbFragment;
        this.eFf = cVar;
        this.kzt.registerListener(this.kNO);
        initView();
    }

    private void initView() {
        if (this.kNL == null) {
            this.kNL = (RelativeLayout) LayoutInflater.from(this.kzt.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.kNN = (ImageView) this.kNL.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.kNN.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ay.dai());
            this.kNN.setImageMatrix(matrix);
            this.kNM = (TextView) this.kNL.findViewById(R.id.tv_pb_title);
            this.kNM.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            this.kNM.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.kNM.getPaint().setFakeBoldText(true);
            ap.setViewTextColor(this.kNM, R.color.cp_cont_b);
            this.kNM.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.kNM.setVisibility(8);
            if (this.kNM.getParent() == null) {
                this.kNL.addView(this.kNM);
            }
            this.kNL.setOnTouchListener(this.eFf);
            this.kNL.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kNM != null) {
            ap.setViewTextColor(this.kNM, R.color.cp_cont_b);
            this.kNM.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        }
    }

    public void A(f fVar) {
        if (fVar != null && !fVar.cVl().bdk() && this.kNM.getText() != null && this.kNM.getText().length() > 0) {
            this.kNM.setVisibility(0);
        } else {
            this.kNM.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.kNL.setVisibility(8);
            bdTypeListView.removeHeaderView(this.kNL);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.kNL.setVisibility(0);
            bdTypeListView.addHeaderView(this.kNL);
        }
    }

    public void B(f fVar) {
        if (fVar != null && fVar.cVl() != null) {
            SpannableStringBuilder bfo = fVar.cVl().bfo();
            SpannableString aI = ay.aI(fVar.cVl());
            if (!StringUtils.isNull(fVar.cVl().getTitle())) {
                if (aI != null) {
                    bfo.append((CharSequence) aI);
                    this.kNM.setText(bfo, TextView.BufferType.SPANNABLE);
                } else {
                    this.kNM.setText(bfo);
                }
                C(fVar);
                this.kNM.setVisibility(0);
                this.kNM.setMaxLines(3);
                this.kNM.setEllipsize(TextUtils.TruncateAt.END);
                this.kNM.invalidate();
                return;
            }
            this.kNM.setVisibility(8);
        }
    }

    public void C(f fVar) {
        if (this.kNM != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (fVar.cVO()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.kNM.setLayoutParams(layoutParams);
        }
    }

    public void D(f fVar) {
        if (fVar != null && fVar.cVl() != null) {
            SpannableStringBuilder bfo = fVar.cVl().bfo();
            this.kNM.setOnTouchListener(new i(bfo));
            this.kNM.setText(bfo);
            this.kNM.setVisibility(0);
        }
    }

    public void c(f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.cVl() != null && fVar.cVl().beS() == 0 && !fVar.cVl().bdk()) {
            if (fVar.kwL) {
                this.kNN.setImageResource(R.drawable.pic_frs_headlines_n);
                this.kNN.setVisibility(0);
            } else if (z && z2) {
                this.kNN.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.kNN.setVisibility(0);
            } else if (z) {
                this.kNN.setImageResource(R.drawable.pic_pb_refined_n);
                this.kNN.setVisibility(0);
            } else if (z2) {
                this.kNN.setImageResource(R.drawable.pic_pb_stick_n);
                this.kNN.setVisibility(0);
            } else {
                this.kNN.setVisibility(8);
            }
            if (this.kNN.getVisibility() == 0 && this.kNN.getLayoutParams() != null) {
                this.kNN.getLayoutParams().height = ay.daj() - ay.dai();
            }
        }
    }
}
