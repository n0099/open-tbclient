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
    private PbFragment kkb;
    private ImageView kyi;
    private RelativeLayout kyg = null;
    private TextView kyh = null;
    private CustomMessageListener kyj = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.kyh != null) {
                c.this.kyh.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.kkb = pbFragment;
        this.euG = cVar;
        this.kkb.registerListener(this.kyj);
        initView();
    }

    private void initView() {
        if (this.kyg == null) {
            this.kyg = (RelativeLayout) LayoutInflater.from(this.kkb.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.kyi = (ImageView) this.kyg.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.kyi.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ay.cPs());
            this.kyi.setImageMatrix(matrix);
            this.kyh = (TextView) this.kyg.findViewById(R.id.tv_pb_title);
            this.kyh.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
            this.kyh.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.kyh.getPaint().setFakeBoldText(true);
            ao.setViewTextColor(this.kyh, R.color.cp_cont_b);
            this.kyh.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.kyh.setVisibility(8);
            if (this.kyh.getParent() == null) {
                this.kyg.addView(this.kyh);
            }
            this.kyg.setOnTouchListener(this.euG);
            this.kyg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kyh != null) {
            ao.setViewTextColor(this.kyh, R.color.cp_cont_b);
            this.kyh.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
        }
    }

    public void A(f fVar) {
        if (fVar != null && !fVar.cKx().aUR() && this.kyh.getText() != null && this.kyh.getText().length() > 0) {
            this.kyh.setVisibility(0);
        } else {
            this.kyh.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.kyg.setVisibility(8);
            bdTypeListView.removeHeaderView(this.kyg);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.kyg.setVisibility(0);
            bdTypeListView.addHeaderView(this.kyg);
        }
    }

    public void B(f fVar) {
        if (fVar != null && fVar.cKx() != null) {
            SpannableStringBuilder aWV = fVar.cKx().aWV();
            SpannableString aH = ay.aH(fVar.cKx());
            if (!StringUtils.isNull(fVar.cKx().getTitle())) {
                if (aH != null) {
                    aWV.append((CharSequence) aH);
                    this.kyh.setText(aWV, TextView.BufferType.SPANNABLE);
                } else {
                    this.kyh.setText(aWV);
                }
                C(fVar);
                this.kyh.setVisibility(0);
                this.kyh.setMaxLines(3);
                this.kyh.setEllipsize(TextUtils.TruncateAt.END);
                this.kyh.invalidate();
                return;
            }
            this.kyh.setVisibility(8);
        }
    }

    public void C(f fVar) {
        if (this.kyh != null) {
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
            this.kyh.setLayoutParams(layoutParams);
        }
    }

    public void D(f fVar) {
        if (fVar != null && fVar.cKx() != null) {
            SpannableStringBuilder aWV = fVar.cKx().aWV();
            this.kyh.setOnTouchListener(new i(aWV));
            this.kyh.setText(aWV);
            this.kyh.setVisibility(0);
        }
    }

    public void c(f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.cKx() != null && fVar.cKx().aWz() == 0 && !fVar.cKx().aUR()) {
            if (fVar.khs) {
                this.kyi.setImageResource(R.drawable.pic_frs_headlines_n);
                this.kyi.setVisibility(0);
            } else if (z && z2) {
                this.kyi.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.kyi.setVisibility(0);
            } else if (z) {
                this.kyi.setImageResource(R.drawable.pic_pb_refined_n);
                this.kyi.setVisibility(0);
            } else if (z2) {
                this.kyi.setImageResource(R.drawable.pic_pb_stick_n);
                this.kyi.setVisibility(0);
            } else {
                this.kyi.setVisibility(8);
            }
            if (this.kyi.getVisibility() == 0 && this.kyi.getLayoutParams() != null) {
                this.kyi.getLayoutParams().height = ay.cPt() - ay.cPs();
            }
        }
    }
}
