package com.baidu.tieba.pbextra.a;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class a extends o<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnClickListener aZX;
    private TbRichTextView.i fFW;
    private c fhK;
    private boolean lRk;
    private int lRl;
    private int lRm;
    private int lqD;
    private f lqv;
    private boolean lqw;
    private boolean lqx;
    private boolean lsy;
    private final boolean lsz;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lqD = 0;
        this.lqw = true;
        this.lRk = true;
        this.lqv = null;
        this.lqx = true;
        this.aZX = null;
        this.fFW = null;
        this.fhK = null;
        this.mOnLongClickListener = null;
        this.lsy = false;
        this.lsz = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.o
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.lRl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.lRm = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cA */
    public b c(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.lRk, this.lqw, this.lqD, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) bVar);
        ap.setBackgroundColor(view, R.color.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.lsI, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.lsI.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.lsI.setLayoutParams(layoutParams);
            bVar.lsI.setPadding(0, 0, 0, 0);
            bVar.lsI.EK(null);
            postData.bnM();
            if (postData.dJZ() == 1) {
                bVar.lRq.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bmA() != null) {
                    j = postData.bmA().getUserIdLong();
                    str = postData.bmA().getUserName();
                    str2 = postData.bmA().getName_show();
                }
                bVar.lRq.a(postData.dKh(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lqv.dik().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.lRq.onChangeSkinType();
                if (this.lqx) {
                    PraiseData bml = this.lqv.dik().bml();
                    if (bml != null && bml.getUser() != null && bml.getUser().size() > 0) {
                        bVar.lRr.setVisibility(0);
                        bVar.lRp.setVisibility(0);
                        bVar.lRs.setVisibility(0);
                        bVar.lRr.setIsFromPb(true);
                        bVar.lRr.setData(bml, this.lqv.dik().getId(), bml.getPostId(), true);
                        bVar.lRr.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.lRr.setVisibility(8);
                        bVar.lRp.setVisibility(8);
                        bVar.lRs.setVisibility(8);
                    }
                } else {
                    bVar.lRr.setVisibility(8);
                    bVar.lRp.setVisibility(8);
                    bVar.lRs.setVisibility(8);
                }
                bVar.lRr.setVisibility(0);
                bVar.lRp.setVisibility(0);
                bVar.lRs.setVisibility(0);
                a(bVar.lsI, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.lRq.setVisibility(8);
            }
            bVar.lsI.getLayoutStrategy().sm(R.drawable.pic_video);
            bVar.lsI.setTextColor(ap.getColor(R.color.common_color_10039));
            bVar.lsI.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            bVar.lsI.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            if (this.lqw) {
                bVar.lsI.getLayoutStrategy().sp(R.drawable.transparent_bg);
            } else {
                bVar.lsI.getLayoutStrategy().sp(R.drawable.icon_click);
            }
            bVar.lsI.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dKb();
            }
            if (this.lsy || !this.lsz) {
                bVar.lsI.setText(tbRichText, false);
            } else {
                bVar.lsI.setText(tbRichText, true);
            }
            bu bmg = this.lqv.dik().bmg();
            if (bmg != null) {
                bVar.lRo.startLoad(this.lqv.dik().bmg().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float blV = bmg.blV() / bmg.blU();
                if (blV > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (blV < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * blV);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.lRo.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.lRo.setLayoutParams(layoutParams2);
            } else {
                bVar.lRo.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lqw) {
            bVar.lsI.setOnClickListener(null);
        } else {
            bVar.lsI.setOnClickListener(this.aZX);
        }
        bVar.lsI.setTextViewCheckSelection(false);
        bVar.lsI.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().sn(this.lRm - (i - this.lRl));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.lsI.setOnLongClickListener(this.mOnLongClickListener);
        bVar.lsI.setOnTouchListener(this.fhK);
        bVar.lsI.setOnImageClickListener(this.fFW);
        if (this.lsm != null && this.lsm.dle() != null) {
            bVar.lsI.setOnEmotionClickListener(this.lsm.dle().lpU.lGc);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(f fVar) {
        this.lqv = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void hE(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.lqD = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void tT(boolean z) {
        this.lqw = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void tU(boolean z) {
        this.lqx = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void tV(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void T(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFW = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void B(View.OnClickListener onClickListener) {
        this.aZX = onClickListener;
    }
}
