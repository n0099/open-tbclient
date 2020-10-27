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
/* loaded from: classes22.dex */
public class c {
    private com.baidu.tieba.pb.a.c fbT;
    private PbFragment ljH;
    private ImageView lyk;
    private RelativeLayout lyi = null;
    private TextView lyj = null;
    private CustomMessageListener lyl = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.lyj != null) {
                c.this.lyj.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.ljH = pbFragment;
        this.fbT = cVar;
        this.ljH.registerListener(this.lyl);
        initView();
    }

    private void initView() {
        if (this.lyi == null) {
            this.lyi = (RelativeLayout) LayoutInflater.from(this.ljH.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.lyk = (ImageView) this.lyi.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.lyk.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ay.dkC());
            this.lyk.setImageMatrix(matrix);
            this.lyj = (TextView) this.lyi.findViewById(R.id.tv_pb_title);
            this.lyj.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            this.lyj.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.lyj.getPaint().setFakeBoldText(true);
            ap.setViewTextColor(this.lyj, R.color.cp_cont_b);
            this.lyj.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.lyj.setVisibility(8);
            if (this.lyj.getParent() == null) {
                this.lyi.addView(this.lyj);
            }
            this.lyi.setOnTouchListener(this.fbT);
            this.lyi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lyj != null) {
            ap.setViewTextColor(this.lyj, R.color.cp_cont_b);
            this.lyj.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        }
    }

    public void A(f fVar) {
        if (fVar != null && !fVar.dfI().biG() && this.lyj.getText() != null && this.lyj.getText().length() > 0) {
            this.lyj.setVisibility(0);
        } else {
            this.lyj.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lyi.setVisibility(8);
            bdTypeListView.removeHeaderView(this.lyi);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.lyi.setVisibility(0);
            bdTypeListView.addHeaderView(this.lyi);
        }
    }

    public void B(f fVar) {
        if (fVar != null && fVar.dfI() != null) {
            SpannableStringBuilder bkK = fVar.dfI().bkK();
            SpannableString aJ = ay.aJ(fVar.dfI());
            if (!StringUtils.isNull(fVar.dfI().getTitle())) {
                if (aJ != null) {
                    bkK.append((CharSequence) aJ);
                    this.lyj.setText(bkK, TextView.BufferType.SPANNABLE);
                } else {
                    this.lyj.setText(bkK);
                }
                C(fVar);
                this.lyj.setVisibility(0);
                this.lyj.setMaxLines(3);
                this.lyj.setEllipsize(TextUtils.TruncateAt.END);
                this.lyj.invalidate();
                return;
            }
            this.lyj.setVisibility(8);
        }
    }

    public void C(f fVar) {
        if (this.lyj != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (fVar.dgl()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.lyj.setLayoutParams(layoutParams);
        }
    }

    public void D(f fVar) {
        if (fVar != null && fVar.dfI() != null) {
            SpannableStringBuilder bkK = fVar.dfI().bkK();
            this.lyj.setOnTouchListener(new i(bkK));
            this.lyj.setText(bkK);
            this.lyj.setVisibility(0);
        }
    }

    public void c(f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.dfI() != null && fVar.dfI().bko() == 0 && !fVar.dfI().biG()) {
            if (fVar.lhb) {
                this.lyk.setImageResource(R.drawable.pic_frs_headlines_n);
                this.lyk.setVisibility(0);
            } else if (z && z2) {
                this.lyk.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.lyk.setVisibility(0);
            } else if (z) {
                this.lyk.setImageResource(R.drawable.pic_pb_refined_n);
                this.lyk.setVisibility(0);
            } else if (z2) {
                this.lyk.setImageResource(R.drawable.pic_pb_stick_n);
                this.lyk.setVisibility(0);
            } else {
                this.lyk.setVisibility(8);
            }
            if (this.lyk.getVisibility() == 0 && this.lyk.getLayoutParams() != null) {
                this.lyk.getLayoutParams().height = ay.dkD() - ay.dkC();
            }
        }
    }
}
