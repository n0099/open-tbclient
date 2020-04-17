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
import com.baidu.tieba.view.i;
/* loaded from: classes9.dex */
public class c {
    private com.baidu.tieba.pb.a.c dRh;
    private ImageView jCJ;
    private PbFragment jpS;
    private RelativeLayout jCH = null;
    private TextView jCI = null;
    private CustomMessageListener jCK = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.jCI != null) {
                c.this.jCI.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.jpS = pbFragment;
        this.dRh = cVar;
        this.jpS.registerListener(this.jCK);
        initView();
    }

    private void initView() {
        if (this.jCH == null) {
            this.jCH = (RelativeLayout) LayoutInflater.from(this.jpS.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.jCJ = (ImageView) this.jCH.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.jCJ.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -am.cAe());
            this.jCJ.setImageMatrix(matrix);
            this.jCI = (TextView) this.jCH.findViewById(R.id.tv_pb_title);
            this.jCI.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.jCI.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.jCI.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jCI, (int) R.color.cp_cont_b);
            this.jCI.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.jCI.setVisibility(8);
            if (this.jCI.getParent() == null) {
                this.jCH.addView(this.jCI);
            }
            this.jCH.setOnTouchListener(this.dRh);
            this.jCH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jCI != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jCI, (int) R.color.cp_cont_b);
            this.jCI.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        }
    }

    public void w(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && !eVar.cvu().aJr() && this.jCI.getText() != null && this.jCI.getText().length() > 0) {
            this.jCI.setVisibility(0);
        } else {
            this.jCI.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.jCH.setVisibility(8);
            bdTypeListView.removeHeaderView(this.jCH);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.jCH.setVisibility(0);
            bdTypeListView.addHeaderView(this.jCH);
        }
    }

    public void x(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvu() != null) {
            SpannableStringBuilder aLl = eVar.cvu().aLl();
            SpannableString aJ = am.aJ(eVar.cvu());
            if (!StringUtils.isNull(eVar.cvu().getTitle())) {
                if (aJ != null) {
                    aLl.append((CharSequence) aJ);
                    this.jCI.setText(aLl, TextView.BufferType.SPANNABLE);
                } else {
                    this.jCI.setText(aLl);
                }
                y(eVar);
                this.jCI.setVisibility(0);
                this.jCI.setMaxLines(3);
                this.jCI.setEllipsize(TextUtils.TruncateAt.END);
                this.jCI.invalidate();
                return;
            }
            this.jCI.setVisibility(8);
        }
    }

    public void y(com.baidu.tieba.pb.data.e eVar) {
        if (this.jCI != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (eVar.cvS()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.jCI.setLayoutParams(layoutParams);
        }
    }

    public void z(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvu() != null) {
            SpannableStringBuilder aLl = eVar.cvu().aLl();
            this.jCI.setOnTouchListener(new i(aLl));
            this.jCI.setText(aLl);
            this.jCI.setVisibility(0);
        }
    }

    public void c(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.cvu() != null && eVar.cvu().aKT() == 0 && !eVar.cvu().aJr()) {
            if (eVar.jnz) {
                this.jCJ.setImageResource(R.drawable.pic_frs_headlines_n);
                this.jCJ.setVisibility(0);
            } else if (z && z2) {
                this.jCJ.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.jCJ.setVisibility(0);
            } else if (z) {
                this.jCJ.setImageResource(R.drawable.pic_pb_refined_n);
                this.jCJ.setVisibility(0);
            } else if (z2) {
                this.jCJ.setImageResource(R.drawable.pic_pb_stick_n);
                this.jCJ.setVisibility(0);
            } else {
                this.jCJ.setVisibility(8);
            }
            if (this.jCJ.getVisibility() == 0 && this.jCJ.getLayoutParams() != null) {
                this.jCJ.getLayoutParams().height = am.cAf() - am.cAe();
            }
        }
    }
}
