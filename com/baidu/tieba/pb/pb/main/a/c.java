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
/* loaded from: classes21.dex */
public class c {
    private com.baidu.tieba.pb.a.c eHq;
    private PbFragment kHX;
    private ImageView kWu;
    private RelativeLayout kWs = null;
    private TextView kWt = null;
    private CustomMessageListener kWv = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.kWt != null) {
                c.this.kWt.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.kHX = pbFragment;
        this.eHq = cVar;
        this.kHX.registerListener(this.kWv);
        initView();
    }

    private void initView() {
        if (this.kWs == null) {
            this.kWs = (RelativeLayout) LayoutInflater.from(this.kHX.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.kWu = (ImageView) this.kWs.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.kWu.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ay.ddM());
            this.kWu.setImageMatrix(matrix);
            this.kWt = (TextView) this.kWs.findViewById(R.id.tv_pb_title);
            this.kWt.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            this.kWt.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.kWt.getPaint().setFakeBoldText(true);
            ap.setViewTextColor(this.kWt, R.color.cp_cont_b);
            this.kWt.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.kWt.setVisibility(8);
            if (this.kWt.getParent() == null) {
                this.kWs.addView(this.kWt);
            }
            this.kWs.setOnTouchListener(this.eHq);
            this.kWs.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kWt != null) {
            ap.setViewTextColor(this.kWt, R.color.cp_cont_b);
            this.kWt.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        }
    }

    public void A(f fVar) {
        if (fVar != null && !fVar.cYR().bee() && this.kWt.getText() != null && this.kWt.getText().length() > 0) {
            this.kWt.setVisibility(0);
        } else {
            this.kWt.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.kWs.setVisibility(8);
            bdTypeListView.removeHeaderView(this.kWs);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.kWs.setVisibility(0);
            bdTypeListView.addHeaderView(this.kWs);
        }
    }

    public void B(f fVar) {
        if (fVar != null && fVar.cYR() != null) {
            SpannableStringBuilder bgi = fVar.cYR().bgi();
            SpannableString aJ = ay.aJ(fVar.cYR());
            if (!StringUtils.isNull(fVar.cYR().getTitle())) {
                if (aJ != null) {
                    bgi.append((CharSequence) aJ);
                    this.kWt.setText(bgi, TextView.BufferType.SPANNABLE);
                } else {
                    this.kWt.setText(bgi);
                }
                C(fVar);
                this.kWt.setVisibility(0);
                this.kWt.setMaxLines(3);
                this.kWt.setEllipsize(TextUtils.TruncateAt.END);
                this.kWt.invalidate();
                return;
            }
            this.kWt.setVisibility(8);
        }
    }

    public void C(f fVar) {
        if (this.kWt != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (fVar.cZu()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.kWt.setLayoutParams(layoutParams);
        }
    }

    public void D(f fVar) {
        if (fVar != null && fVar.cYR() != null) {
            SpannableStringBuilder bgi = fVar.cYR().bgi();
            this.kWt.setOnTouchListener(new i(bgi));
            this.kWt.setText(bgi);
            this.kWt.setVisibility(0);
        }
    }

    public void c(f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.cYR() != null && fVar.cYR().bfM() == 0 && !fVar.cYR().bee()) {
            if (fVar.kFr) {
                this.kWu.setImageResource(R.drawable.pic_frs_headlines_n);
                this.kWu.setVisibility(0);
            } else if (z && z2) {
                this.kWu.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.kWu.setVisibility(0);
            } else if (z) {
                this.kWu.setImageResource(R.drawable.pic_pb_refined_n);
                this.kWu.setVisibility(0);
            } else if (z2) {
                this.kWu.setImageResource(R.drawable.pic_pb_stick_n);
                this.kWu.setVisibility(0);
            } else {
                this.kWu.setVisibility(8);
            }
            if (this.kWu.getVisibility() == 0 && this.kWu.getLayoutParams() != null) {
                this.kWu.getLayoutParams().height = ay.ddN() - ay.ddM();
            }
        }
    }
}
