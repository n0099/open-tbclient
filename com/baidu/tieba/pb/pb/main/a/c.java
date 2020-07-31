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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.view.i;
/* loaded from: classes16.dex */
public class c {
    private com.baidu.tieba.pb.a.c euG;
    private PbFragment kjZ;
    private ImageView kyg;
    private RelativeLayout kye = null;
    private TextView kyf = null;
    private CustomMessageListener kyh = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.kyf != null) {
                c.this.kyf.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.kjZ = pbFragment;
        this.euG = cVar;
        this.kjZ.registerListener(this.kyh);
        initView();
    }

    private void initView() {
        if (this.kye == null) {
            this.kye = (RelativeLayout) LayoutInflater.from(this.kjZ.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.kyg = (ImageView) this.kye.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.kyg.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ay.cPs());
            this.kyg.setImageMatrix(matrix);
            this.kyf = (TextView) this.kye.findViewById(R.id.tv_pb_title);
            this.kyf.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
            this.kyf.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.kyf.getPaint().setFakeBoldText(true);
            ao.setViewTextColor(this.kyf, R.color.cp_cont_b);
            this.kyf.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.kyf.setVisibility(8);
            if (this.kyf.getParent() == null) {
                this.kye.addView(this.kyf);
            }
            this.kye.setOnTouchListener(this.euG);
            this.kye.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kyf != null) {
            ao.setViewTextColor(this.kyf, R.color.cp_cont_b);
            this.kyf.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
        }
    }

    public void A(f fVar) {
        if (fVar != null && !fVar.cKx().aUR() && this.kyf.getText() != null && this.kyf.getText().length() > 0) {
            this.kyf.setVisibility(0);
        } else {
            this.kyf.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.kye.setVisibility(8);
            bdTypeListView.removeHeaderView(this.kye);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.kye.setVisibility(0);
            bdTypeListView.addHeaderView(this.kye);
        }
    }

    public void B(f fVar) {
        if (fVar != null && fVar.cKx() != null) {
            SpannableStringBuilder aWV = fVar.cKx().aWV();
            SpannableString aH = ay.aH(fVar.cKx());
            if (!StringUtils.isNull(fVar.cKx().getTitle())) {
                if (aH != null) {
                    aWV.append((CharSequence) aH);
                    this.kyf.setText(aWV, TextView.BufferType.SPANNABLE);
                } else {
                    this.kyf.setText(aWV);
                }
                C(fVar);
                this.kyf.setVisibility(0);
                this.kyf.setMaxLines(3);
                this.kyf.setEllipsize(TextUtils.TruncateAt.END);
                this.kyf.invalidate();
                return;
            }
            this.kyf.setVisibility(8);
        }
    }

    public void C(f fVar) {
        if (this.kyf != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (fVar.cLa()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.kyf.setLayoutParams(layoutParams);
        }
    }

    public void D(f fVar) {
        if (fVar != null && fVar.cKx() != null) {
            SpannableStringBuilder aWV = fVar.cKx().aWV();
            this.kyf.setOnTouchListener(new i(aWV));
            this.kyf.setText(aWV);
            this.kyf.setVisibility(0);
        }
    }

    public void c(f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.cKx() != null && fVar.cKx().aWz() == 0 && !fVar.cKx().aUR()) {
            if (fVar.khq) {
                this.kyg.setImageResource(R.drawable.pic_frs_headlines_n);
                this.kyg.setVisibility(0);
            } else if (z && z2) {
                this.kyg.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.kyg.setVisibility(0);
            } else if (z) {
                this.kyg.setImageResource(R.drawable.pic_pb_refined_n);
                this.kyg.setVisibility(0);
            } else if (z2) {
                this.kyg.setImageResource(R.drawable.pic_pb_stick_n);
                this.kyg.setVisibility(0);
            } else {
                this.kyg.setVisibility(8);
            }
            if (this.kyg.getVisibility() == 0 && this.kyg.getLayoutParams() != null) {
                this.kyg.getLayoutParams().height = ay.cPt() - ay.cPs();
            }
        }
    }
}
