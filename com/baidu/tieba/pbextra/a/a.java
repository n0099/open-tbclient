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
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class a extends k<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnLongClickListener aPP;
    private TbRichTextView.h bop;
    private c boq;
    private int fOB;
    private d fOt;
    private boolean fOu;
    private boolean fOv;
    private boolean fPJ;
    private final boolean fPK;
    private boolean gbU;
    private int gfN;
    private int gfO;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fOB = 0;
        this.fOu = true;
        this.gbU = true;
        this.fOt = null;
        this.fOv = true;
        this.mCommonClickListener = null;
        this.bop = null;
        this.boq = null;
        this.aPP = null;
        this.fPJ = false;
        this.fPK = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        ap(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void ap(PbActivity pbActivity) {
        super.ap(pbActivity);
        if (pbActivity != null) {
            this.gfN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds30);
            this.gfO = l.aO(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(e.h.pb_interview_normal_item, viewGroup, false), this.gbU, this.fOu, this.fOB, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, bVar);
        al.j(view, e.d.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.fPS, (int) this.mContext.getResources().getDimension(e.C0200e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fPS.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fPS.setLayoutParams(layoutParams);
            bVar.fPS.setPadding(0, 0, 0, 0);
            bVar.fPS.iI(null);
            postData.zz();
            if (postData.bBx() == 1) {
                bVar.gfS.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.yC() != null) {
                    j = postData.yC().getUserIdLong();
                    str = postData.yC().getUserName();
                    str2 = postData.yC().getName_show();
                }
                bVar.gfS.a(postData.bBF(), str, str2, j, com.baidu.adp.lib.g.b.d(this.fOt.bet().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                bVar.gfS.onChangeSkinType();
                if (this.fOv) {
                    PraiseData yp = this.fOt.bet().yp();
                    if (yp != null && yp.getUser() != null && yp.getUser().size() > 0) {
                        bVar.gfT.setVisibility(0);
                        bVar.gfR.setVisibility(0);
                        bVar.gfU.setVisibility(0);
                        bVar.gfT.setIsFromPb(true);
                        bVar.gfT.setData(yp, this.fOt.bet().getId(), yp.getPostId(), true);
                        bVar.gfT.eo(this.mSkinType);
                    } else {
                        bVar.gfT.setVisibility(8);
                        bVar.gfR.setVisibility(8);
                        bVar.gfU.setVisibility(8);
                    }
                } else {
                    bVar.gfT.setVisibility(8);
                    bVar.gfR.setVisibility(8);
                    bVar.gfU.setVisibility(8);
                }
                bVar.gfT.setVisibility(0);
                bVar.gfR.setVisibility(0);
                bVar.gfU.setVisibility(0);
                a(bVar.fPS, (int) this.mContext.getResources().getDimension(e.C0200e.ds30));
            } else {
                bVar.gfS.setVisibility(8);
            }
            bVar.fPS.getLayoutStrategy().gv(e.f.pic_video);
            bVar.fPS.setTextColor(al.getColor(e.d.common_color_10039));
            bVar.fPS.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            bVar.fPS.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            if (this.fOu) {
                bVar.fPS.getLayoutStrategy().gy(e.f.transparent_bg);
            } else {
                bVar.fPS.getLayoutStrategy().gy(e.f.icon_click);
            }
            bVar.fPS.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bBz();
            }
            if (this.fPJ || !this.fPK) {
                bVar.fPS.setText(tbRichText, false);
            } else {
                bVar.fPS.setText(tbRichText, true);
            }
            ba yj = this.fOt.bet().yj();
            if (yj != null) {
                bVar.gfQ.startLoad(this.fOt.bet().yj().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int aO = l.aO(this.mContext);
                float yh = yj.yh() / yj.yg();
                if (yh > 1.0f) {
                    i = (int) (1.0f * aO);
                } else if (yh < 0.2f) {
                    i = (int) (aO * 0.2f);
                } else {
                    i = (int) (aO * yh);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.gfQ.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = aO;
                bVar.gfQ.setLayoutParams(layoutParams2);
            } else {
                bVar.gfQ.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fOu) {
            bVar.fPS.setOnClickListener(null);
        } else {
            bVar.fPS.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fPS.setTextViewCheckSelection(false);
        bVar.fPS.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().gw(this.gfO - (i - this.gfN));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fPS.setOnLongClickListener(this.aPP);
        bVar.fPS.setOnTouchListener(this.boq);
        bVar.fPS.setOnImageClickListener(this.bop);
        bVar.fPS.setOnEmotionClickListener(((PbActivity) this.fOe.getPageContext().getOrignalPage()).fMi.fZx);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(d dVar) {
        this.fOt = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.fOB = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kw(boolean z) {
        this.fOu = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kx(boolean z) {
        this.fOv = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void ky(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void I(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bop = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aPP = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
