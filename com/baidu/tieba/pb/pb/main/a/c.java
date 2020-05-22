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
    private PbFragment jGF;
    private ImageView jUm;
    private RelativeLayout jUk = null;
    private TextView jUl = null;
    private CustomMessageListener jUn = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.jUl != null) {
                c.this.jUl.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.jGF = pbFragment;
        this.efF = cVar;
        this.jGF.registerListener(this.jUn);
        initView();
    }

    private void initView() {
        if (this.jUk == null) {
            this.jUk = (RelativeLayout) LayoutInflater.from(this.jGF.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.jUm = (ImageView) this.jUk.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.jUm.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -au.cGY());
            this.jUm.setImageMatrix(matrix);
            this.jUl = (TextView) this.jUk.findViewById(R.id.tv_pb_title);
            this.jUl.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            this.jUl.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.jUl.getPaint().setFakeBoldText(true);
            am.setViewTextColor(this.jUl, (int) R.color.cp_cont_b);
            this.jUl.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.jUl.setVisibility(8);
            if (this.jUl.getParent() == null) {
                this.jUk.addView(this.jUl);
            }
            this.jUk.setOnTouchListener(this.efF);
            this.jUk.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jUl != null) {
            am.setViewTextColor(this.jUl, (int) R.color.cp_cont_b);
            this.jUl.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        }
    }

    public void z(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && !eVar.cCi().aPk() && this.jUl.getText() != null && this.jUl.getText().length() > 0) {
            this.jUl.setVisibility(0);
        } else {
            this.jUl.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.jUk.setVisibility(8);
            bdTypeListView.removeHeaderView(this.jUk);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.jUk.setVisibility(0);
            bdTypeListView.addHeaderView(this.jUk);
        }
    }

    public void A(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCi() != null) {
            SpannableStringBuilder aRi = eVar.cCi().aRi();
            SpannableString aJ = au.aJ(eVar.cCi());
            if (!StringUtils.isNull(eVar.cCi().getTitle())) {
                if (aJ != null) {
                    aRi.append((CharSequence) aJ);
                    this.jUl.setText(aRi, TextView.BufferType.SPANNABLE);
                } else {
                    this.jUl.setText(aRi);
                }
                B(eVar);
                this.jUl.setVisibility(0);
                this.jUl.setMaxLines(3);
                this.jUl.setEllipsize(TextUtils.TruncateAt.END);
                this.jUl.invalidate();
                return;
            }
            this.jUl.setVisibility(8);
        }
    }

    public void B(com.baidu.tieba.pb.data.e eVar) {
        if (this.jUl != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (eVar.cCJ()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.jUl.setLayoutParams(layoutParams);
        }
    }

    public void C(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCi() != null) {
            SpannableStringBuilder aRi = eVar.cCi().aRi();
            this.jUl.setOnTouchListener(new i(aRi));
            this.jUl.setText(aRi);
            this.jUl.setVisibility(0);
        }
    }

    public void c(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.cCi() != null && eVar.cCi().aQM() == 0 && !eVar.cCi().aPk()) {
            if (eVar.jDZ) {
                this.jUm.setImageResource(R.drawable.pic_frs_headlines_n);
                this.jUm.setVisibility(0);
            } else if (z && z2) {
                this.jUm.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.jUm.setVisibility(0);
            } else if (z) {
                this.jUm.setImageResource(R.drawable.pic_pb_refined_n);
                this.jUm.setVisibility(0);
            } else if (z2) {
                this.jUm.setImageResource(R.drawable.pic_pb_stick_n);
                this.jUm.setVisibility(0);
            } else {
                this.jUm.setVisibility(8);
            }
            if (this.jUm.getVisibility() == 0 && this.jUm.getLayoutParams() != null) {
                this.jUm.getLayoutParams().height = au.cGZ() - au.cGY();
            }
        }
    }
}
