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
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.view.i;
/* loaded from: classes9.dex */
public class c {
    private com.baidu.tieba.pb.a.c efF;
    private PbFragment jHL;
    private ImageView jVs;
    private RelativeLayout jVq = null;
    private TextView jVr = null;
    private CustomMessageListener jVt = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.jVr != null) {
                c.this.jVr.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.jHL = pbFragment;
        this.efF = cVar;
        this.jHL.registerListener(this.jVt);
        initView();
    }

    private void initView() {
        if (this.jVq == null) {
            this.jVq = (RelativeLayout) LayoutInflater.from(this.jHL.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.jVs = (ImageView) this.jVq.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.jVs.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -au.cHo());
            this.jVs.setImageMatrix(matrix);
            this.jVr = (TextView) this.jVq.findViewById(R.id.tv_pb_title);
            this.jVr.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.jVr.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.jVr.getPaint().setFakeBoldText(true);
            am.setViewTextColor(this.jVr, (int) R.color.cp_cont_b);
            this.jVr.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.jVr.setVisibility(8);
            if (this.jVr.getParent() == null) {
                this.jVq.addView(this.jVr);
            }
            this.jVq.setOnTouchListener(this.efF);
            this.jVq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jVr != null) {
            am.setViewTextColor(this.jVr, (int) R.color.cp_cont_b);
            this.jVr.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        }
    }

    public void z(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && !eVar.cCy().aPk() && this.jVr.getText() != null && this.jVr.getText().length() > 0) {
            this.jVr.setVisibility(0);
        } else {
            this.jVr.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.jVq.setVisibility(8);
            bdTypeListView.removeHeaderView(this.jVq);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.jVq.setVisibility(0);
            bdTypeListView.addHeaderView(this.jVq);
        }
    }

    public void A(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCy() != null) {
            SpannableStringBuilder aRi = eVar.cCy().aRi();
            SpannableString aJ = au.aJ(eVar.cCy());
            if (!StringUtils.isNull(eVar.cCy().getTitle())) {
                if (aJ != null) {
                    aRi.append((CharSequence) aJ);
                    this.jVr.setText(aRi, TextView.BufferType.SPANNABLE);
                } else {
                    this.jVr.setText(aRi);
                }
                B(eVar);
                this.jVr.setVisibility(0);
                this.jVr.setMaxLines(3);
                this.jVr.setEllipsize(TextUtils.TruncateAt.END);
                this.jVr.invalidate();
                return;
            }
            this.jVr.setVisibility(8);
        }
    }

    public void B(com.baidu.tieba.pb.data.e eVar) {
        if (this.jVr != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (eVar.cCZ()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.jVr.setLayoutParams(layoutParams);
        }
    }

    public void C(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCy() != null) {
            SpannableStringBuilder aRi = eVar.cCy().aRi();
            this.jVr.setOnTouchListener(new i(aRi));
            this.jVr.setText(aRi);
            this.jVr.setVisibility(0);
        }
    }

    public void c(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.cCy() != null && eVar.cCy().aQM() == 0 && !eVar.cCy().aPk()) {
            if (eVar.jFf) {
                this.jVs.setImageResource(R.drawable.pic_frs_headlines_n);
                this.jVs.setVisibility(0);
            } else if (z && z2) {
                this.jVs.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.jVs.setVisibility(0);
            } else if (z) {
                this.jVs.setImageResource(R.drawable.pic_pb_refined_n);
                this.jVs.setVisibility(0);
            } else if (z2) {
                this.jVs.setImageResource(R.drawable.pic_pb_stick_n);
                this.jVs.setVisibility(0);
            } else {
                this.jVs.setVisibility(8);
            }
            if (this.jVs.getVisibility() == 0 && this.jVs.getLayoutParams() != null) {
                this.jVs.getLayoutParams().height = au.cHp() - au.cHo();
            }
        }
    }
}
