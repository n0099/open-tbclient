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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.am;
import com.baidu.tieba.view.h;
/* loaded from: classes9.dex */
public class c {
    private com.baidu.tieba.pb.a.c dqJ;
    private PbFragment iDW;
    private ImageView iQL;
    private RelativeLayout iQJ = null;
    private TextView iQK = null;
    private CustomMessageListener iQM = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.iQK != null) {
                c.this.iQK.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.iDW = pbFragment;
        this.dqJ = cVar;
        this.iDW.registerListener(this.iQM);
        initView();
    }

    private void initView() {
        if (this.iQJ == null) {
            this.iQJ = (RelativeLayout) LayoutInflater.from(this.iDW.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.iQL = (ImageView) this.iQJ.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.iQL.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -am.cpa());
            this.iQL.setImageMatrix(matrix);
            this.iQK = (TextView) this.iQJ.findViewById(R.id.tv_pb_title);
            this.iQK.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.iQK.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.iQK.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iQK, (int) R.color.cp_cont_b);
            this.iQK.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.iQK.setVisibility(8);
            if (this.iQK.getParent() == null) {
                this.iQJ.addView(this.iQK);
            }
            this.iQJ.setOnTouchListener(this.dqJ);
            this.iQJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iQK != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iQK, (int) R.color.cp_cont_b);
            this.iQK.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        }
    }

    public void w(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && !eVar.cks().aAZ() && this.iQK.getText() != null && this.iQK.getText().length() > 0) {
            this.iQK.setVisibility(0);
        } else {
            this.iQK.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.iQJ.setVisibility(8);
            bdTypeListView.removeHeaderView(this.iQJ);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.iQJ.setVisibility(0);
            bdTypeListView.addHeaderView(this.iQJ);
        }
    }

    public void x(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cks() != null) {
            SpannableStringBuilder aCT = eVar.cks().aCT();
            SpannableString aH = am.aH(eVar.cks());
            if (!StringUtils.isNull(eVar.cks().getTitle())) {
                if (aH != null) {
                    aCT.append((CharSequence) aH);
                    this.iQK.setText(aCT, TextView.BufferType.SPANNABLE);
                } else {
                    this.iQK.setText(aCT);
                }
                y(eVar);
                this.iQK.setVisibility(0);
                this.iQK.setMaxLines(3);
                this.iQK.setEllipsize(TextUtils.TruncateAt.END);
                this.iQK.invalidate();
                return;
            }
            this.iQK.setVisibility(8);
        }
    }

    public void y(com.baidu.tieba.pb.data.e eVar) {
        if (this.iQK != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (eVar.ckQ()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.iQK.setLayoutParams(layoutParams);
        }
    }

    public void z(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cks() != null) {
            SpannableStringBuilder aCT = eVar.cks().aCT();
            this.iQK.setOnTouchListener(new h(aCT));
            this.iQK.setText(aCT);
            this.iQK.setVisibility(0);
        }
    }

    public void c(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.cks() != null && eVar.cks().aCB() == 0 && !eVar.cks().aAZ()) {
            if (eVar.iBF) {
                this.iQL.setImageResource(R.drawable.pic_frs_headlines_n);
                this.iQL.setVisibility(0);
            } else if (z && z2) {
                this.iQL.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.iQL.setVisibility(0);
            } else if (z) {
                this.iQL.setImageResource(R.drawable.pic_pb_refined_n);
                this.iQL.setVisibility(0);
            } else if (z2) {
                this.iQL.setImageResource(R.drawable.pic_pb_stick_n);
                this.iQL.setVisibility(0);
            } else {
                this.iQL.setVisibility(8);
            }
            if (this.iQL.getVisibility() == 0 && this.iQL.getLayoutParams() != null) {
                this.iQL.getLayoutParams().height = am.cpb() - am.cpa();
            }
        }
    }
}
