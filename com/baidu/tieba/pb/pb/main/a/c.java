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
/* loaded from: classes16.dex */
public class c {
    private com.baidu.tieba.pb.a.c eFj;
    private ImageView kNU;
    private PbFragment kzA;
    private RelativeLayout kNS = null;
    private TextView kNT = null;
    private CustomMessageListener kNV = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.kNT != null) {
                c.this.kNT.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };

    public c(PbFragment pbFragment, com.baidu.tieba.pb.a.c cVar) {
        this.kzA = pbFragment;
        this.eFj = cVar;
        this.kzA.registerListener(this.kNV);
        initView();
    }

    private void initView() {
        if (this.kNS == null) {
            this.kNS = (RelativeLayout) LayoutInflater.from(this.kzA.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.kNU = (ImageView) this.kNS.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.kNU.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -ay.daj());
            this.kNU.setImageMatrix(matrix);
            this.kNT = (TextView) this.kNS.findViewById(R.id.tv_pb_title);
            this.kNT.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            this.kNT.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.kNT.getPaint().setFakeBoldText(true);
            ap.setViewTextColor(this.kNT, R.color.cp_cont_b);
            this.kNT.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.kNT.setVisibility(8);
            if (this.kNT.getParent() == null) {
                this.kNS.addView(this.kNT);
            }
            this.kNS.setOnTouchListener(this.eFj);
            this.kNS.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.c.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kNT != null) {
            ap.setViewTextColor(this.kNT, R.color.cp_cont_b);
            this.kNT.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        }
    }

    public void A(f fVar) {
        if (fVar != null && !fVar.cVm().bdk() && this.kNT.getText() != null && this.kNT.getText().length() > 0) {
            this.kNT.setVisibility(0);
        } else {
            this.kNT.setVisibility(8);
        }
    }

    public void c(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.kNS.setVisibility(8);
            bdTypeListView.removeHeaderView(this.kNS);
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            this.kNS.setVisibility(0);
            bdTypeListView.addHeaderView(this.kNS);
        }
    }

    public void B(f fVar) {
        if (fVar != null && fVar.cVm() != null) {
            SpannableStringBuilder bfo = fVar.cVm().bfo();
            SpannableString aI = ay.aI(fVar.cVm());
            if (!StringUtils.isNull(fVar.cVm().getTitle())) {
                if (aI != null) {
                    bfo.append((CharSequence) aI);
                    this.kNT.setText(bfo, TextView.BufferType.SPANNABLE);
                } else {
                    this.kNT.setText(bfo);
                }
                C(fVar);
                this.kNT.setVisibility(0);
                this.kNT.setMaxLines(3);
                this.kNT.setEllipsize(TextUtils.TruncateAt.END);
                this.kNT.invalidate();
                return;
            }
            this.kNT.setVisibility(8);
        }
    }

    public void C(f fVar) {
        if (this.kNT != null) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds37);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimens;
            layoutParams.leftMargin = dimens2;
            layoutParams.rightMargin = dimens2;
            if (fVar.cVP()) {
                dimens3 = 0;
            }
            layoutParams.bottomMargin = dimens3;
            this.kNT.setLayoutParams(layoutParams);
        }
    }

    public void D(f fVar) {
        if (fVar != null && fVar.cVm() != null) {
            SpannableStringBuilder bfo = fVar.cVm().bfo();
            this.kNT.setOnTouchListener(new i(bfo));
            this.kNT.setText(bfo);
            this.kNT.setVisibility(0);
        }
    }

    public void c(f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.cVm() != null && fVar.cVm().beS() == 0 && !fVar.cVm().bdk()) {
            if (fVar.kwS) {
                this.kNU.setImageResource(R.drawable.pic_frs_headlines_n);
                this.kNU.setVisibility(0);
            } else if (z && z2) {
                this.kNU.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.kNU.setVisibility(0);
            } else if (z) {
                this.kNU.setImageResource(R.drawable.pic_pb_refined_n);
                this.kNU.setVisibility(0);
            } else if (z2) {
                this.kNU.setImageResource(R.drawable.pic_pb_stick_n);
                this.kNU.setVisibility(0);
            } else {
                this.kNU.setVisibility(8);
            }
            if (this.kNU.getVisibility() == 0 && this.kNU.getLayoutParams() != null) {
                this.kNU.getLayoutParams().height = ay.dak() - ay.daj();
            }
        }
    }
}
