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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.view.i;
/* loaded from: classes9.dex */
public class c {
    private com.baidu.tieba.pb.a.c eor;
    private PbFragment kbv;
    private ImageView kpi;
    private RelativeLayout kpg = null;
    private TextView kph = null;
    private CustomMessageListener kpj = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.kph != null) {
                c.this.kph.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.kbv = pbFragment;
        this.eor = cVar;
        this.kbv.registerListener(this.kpj);
        initView();
    }

    private void initView() {
        if (this.kpg == null) {
            this.kpg = (RelativeLayout) LayoutInflater.from(this.kbv.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.kpi = (ImageView) this.kpg.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.kpi.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -au.cLF());
            this.kpi.setImageMatrix(matrix);
            this.kph = (TextView) this.kpg.findViewById(R.id.tv_pb_title);
            this.kph.setLinkTextColor(an.getColor(R.color.cp_link_tip_c));
            this.kph.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.kph.getPaint().setFakeBoldText(true);
            an.setViewTextColor(this.kph, (int) R.color.cp_cont_b);
            this.kph.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.kph.setVisibility(8);
            if (this.kph.getParent() == null) {
                this.kpg.addView(this.kph);
            }
            this.kpg.setOnTouchListener(this.eor);
            this.kpg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kph != null) {
            an.setViewTextColor(this.kph, (int) R.color.cp_cont_b);
            this.kph.setLinkTextColor(an.getColor(R.color.cp_link_tip_c));
        }
    }

    public void A(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && !eVar.cGN().aQV() && this.kph.getText() != null && this.kph.getText().length() > 0) {
            this.kph.setVisibility(0);
        } else {
            this.kph.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.kpg.setVisibility(8);
            bdTypeListView.removeHeaderView(this.kpg);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.kpg.setVisibility(0);
            bdTypeListView.addHeaderView(this.kpg);
        }
    }

    public void B(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cGN() != null) {
            SpannableStringBuilder aSZ = eVar.cGN().aSZ();
            SpannableString aK = au.aK(eVar.cGN());
            if (!StringUtils.isNull(eVar.cGN().getTitle())) {
                if (aK != null) {
                    aSZ.append((CharSequence) aK);
                    this.kph.setText(aSZ, TextView.BufferType.SPANNABLE);
                } else {
                    this.kph.setText(aSZ);
                }
                C(eVar);
                this.kph.setVisibility(0);
                this.kph.setMaxLines(3);
                this.kph.setEllipsize(TextUtils.TruncateAt.END);
                this.kph.invalidate();
                return;
            }
            this.kph.setVisibility(8);
        }
    }

    public void C(com.baidu.tieba.pb.data.e eVar) {
        if (this.kph != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (eVar.cHp()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.kph.setLayoutParams(layoutParams);
        }
    }

    public void D(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cGN() != null) {
            SpannableStringBuilder aSZ = eVar.cGN().aSZ();
            this.kph.setOnTouchListener(new i(aSZ));
            this.kph.setText(aSZ);
            this.kph.setVisibility(0);
        }
    }

    public void c(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.cGN() != null && eVar.cGN().aSD() == 0 && !eVar.cGN().aQV()) {
            if (eVar.jYP) {
                this.kpi.setImageResource(R.drawable.pic_frs_headlines_n);
                this.kpi.setVisibility(0);
            } else if (z && z2) {
                this.kpi.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.kpi.setVisibility(0);
            } else if (z) {
                this.kpi.setImageResource(R.drawable.pic_pb_refined_n);
                this.kpi.setVisibility(0);
            } else if (z2) {
                this.kpi.setImageResource(R.drawable.pic_pb_stick_n);
                this.kpi.setVisibility(0);
            } else {
                this.kpi.setVisibility(8);
            }
            if (this.kpi.getVisibility() == 0 && this.kpi.getLayoutParams() != null) {
                this.kpi.getLayoutParams().height = au.cLG() - au.cLF();
            }
        }
    }
}
