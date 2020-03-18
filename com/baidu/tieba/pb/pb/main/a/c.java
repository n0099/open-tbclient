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
    private com.baidu.tieba.pb.a.c drk;
    private PbFragment iFL;
    private ImageView iSA;
    private RelativeLayout iSy = null;
    private TextView iSz = null;
    private CustomMessageListener iSB = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.iSz != null) {
                c.this.iSz.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.iFL = pbFragment;
        this.drk = cVar;
        this.iFL.registerListener(this.iSB);
        initView();
    }

    private void initView() {
        if (this.iSy == null) {
            this.iSy = (RelativeLayout) LayoutInflater.from(this.iFL.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.iSA = (ImageView) this.iSy.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.iSA.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -am.cpy());
            this.iSA.setImageMatrix(matrix);
            this.iSz = (TextView) this.iSy.findViewById(R.id.tv_pb_title);
            this.iSz.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
            this.iSz.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.iSz.getPaint().setFakeBoldText(true);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iSz, (int) R.color.cp_cont_b);
            this.iSz.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.iSz.setVisibility(8);
            if (this.iSz.getParent() == null) {
                this.iSy.addView(this.iSz);
            }
            this.iSy.setOnTouchListener(this.drk);
            this.iSy.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iSz != null) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iSz, (int) R.color.cp_cont_b);
            this.iSz.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_link_tip_c));
        }
    }

    public void w(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && !eVar.ckP().aBe() && this.iSz.getText() != null && this.iSz.getText().length() > 0) {
            this.iSz.setVisibility(0);
        } else {
            this.iSz.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.iSy.setVisibility(8);
            bdTypeListView.removeHeaderView(this.iSy);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.iSy.setVisibility(0);
            bdTypeListView.addHeaderView(this.iSy);
        }
    }

    public void x(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckP() != null) {
            SpannableStringBuilder aCY = eVar.ckP().aCY();
            SpannableString aI = am.aI(eVar.ckP());
            if (!StringUtils.isNull(eVar.ckP().getTitle())) {
                if (aI != null) {
                    aCY.append((CharSequence) aI);
                    this.iSz.setText(aCY, TextView.BufferType.SPANNABLE);
                } else {
                    this.iSz.setText(aCY);
                }
                y(eVar);
                this.iSz.setVisibility(0);
                this.iSz.setMaxLines(3);
                this.iSz.setEllipsize(TextUtils.TruncateAt.END);
                this.iSz.invalidate();
                return;
            }
            this.iSz.setVisibility(8);
        }
    }

    public void y(com.baidu.tieba.pb.data.e eVar) {
        if (this.iSz != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (eVar.cln()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.iSz.setLayoutParams(layoutParams);
        }
    }

    public void z(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckP() != null) {
            SpannableStringBuilder aCY = eVar.ckP().aCY();
            this.iSz.setOnTouchListener(new h(aCY));
            this.iSz.setText(aCY);
            this.iSz.setVisibility(0);
        }
    }

    public void c(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.ckP() != null && eVar.ckP().aCG() == 0 && !eVar.ckP().aBe()) {
            if (eVar.iDt) {
                this.iSA.setImageResource(R.drawable.pic_frs_headlines_n);
                this.iSA.setVisibility(0);
            } else if (z && z2) {
                this.iSA.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.iSA.setVisibility(0);
            } else if (z) {
                this.iSA.setImageResource(R.drawable.pic_pb_refined_n);
                this.iSA.setVisibility(0);
            } else if (z2) {
                this.iSA.setImageResource(R.drawable.pic_pb_stick_n);
                this.iSA.setVisibility(0);
            } else {
                this.iSA.setVisibility(8);
            }
            if (this.iSA.getVisibility() == 0 && this.iSA.getLayoutParams() != null) {
                this.iSA.getLayoutParams().height = am.cpz() - am.cpy();
            }
        }
    }
}
