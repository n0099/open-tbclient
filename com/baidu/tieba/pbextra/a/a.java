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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class a extends k<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private TbRichTextView.h aWx;
    private c aWy;
    private View.OnLongClickListener axX;
    private int fAa;
    private int fAb;
    private d fig;
    private boolean fih;
    private boolean fii;
    private int fio;
    private boolean fjG;
    private final boolean fjH;
    private boolean fvO;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fio = 0;
        this.fih = true;
        this.fvO = true;
        this.fig = null;
        this.fii = true;
        this.mCommonClickListener = null;
        this.aWx = null;
        this.aWy = null;
        this.axX = null;
        this.fjG = false;
        this.fjH = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        aq(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void aq(PbActivity pbActivity) {
        super.aq(pbActivity);
        if (pbActivity != null) {
            this.fAa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds30);
            this.fAb = l.af(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(d.i.pb_interview_normal_item, viewGroup, false), this.fvO, this.fih, this.fio, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view2, viewGroup, postData, bVar);
        ak.j(view2, d.C0126d.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view2;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.fjR, (int) this.mContext.getResources().getDimension(d.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fjR.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fjR.setLayoutParams(layoutParams);
            bVar.fjR.setPadding(0, 0, 0, 0);
            bVar.fjR.hv(null);
            postData.sJ();
            if (postData.brX() == 1) {
                bVar.fjS.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rP() != null) {
                    j = postData.rP().getUserIdLong();
                    str = postData.rP().getUserName();
                    str2 = postData.rP().getName_show();
                }
                bVar.fjS.a(postData.bsf(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fig.aVs().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.fjS.onChangeSkinType();
                if (this.fii) {
                    PraiseData rE = this.fig.aVs().rE();
                    if (rE != null && rE.getUser() != null && rE.getUser().size() > 0) {
                        bVar.fAf.setVisibility(0);
                        bVar.fAe.setVisibility(0);
                        bVar.fAg.setVisibility(0);
                        bVar.fAf.setIsFromPb(true);
                        bVar.fAf.setData(rE, this.fig.aVs().getId(), rE.getPostId(), true);
                        bVar.fAf.dA(this.mSkinType);
                    } else {
                        bVar.fAf.setVisibility(8);
                        bVar.fAe.setVisibility(8);
                        bVar.fAg.setVisibility(8);
                    }
                } else {
                    bVar.fAf.setVisibility(8);
                    bVar.fAe.setVisibility(8);
                    bVar.fAg.setVisibility(8);
                }
                bVar.fAf.setVisibility(0);
                bVar.fAe.setVisibility(0);
                bVar.fAg.setVisibility(0);
                a(bVar.fjR, (int) this.mContext.getResources().getDimension(d.e.ds30));
            } else {
                bVar.fjS.setVisibility(8);
            }
            bVar.fjR.getLayoutStrategy().fL(d.f.pic_video);
            bVar.fjR.setTextColor(ak.getColor(d.C0126d.common_color_10039));
            bVar.fjR.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
            bVar.fjR.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
            if (this.fih) {
                bVar.fjR.getLayoutStrategy().fO(d.f.transparent_bg);
            } else {
                bVar.fjR.getLayoutStrategy().fO(d.f.icon_click);
            }
            bVar.fjR.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.brZ();
            }
            if (this.fjG || !this.fjH) {
                bVar.fjR.setText(tbRichText, false);
            } else {
                bVar.fjR.setText(tbRichText, true);
            }
            bb rz = this.fig.aVs().rz();
            if (rz != null) {
                bVar.fAd.startLoad(this.fig.aVs().rz().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int af = l.af(this.mContext);
                float rx = rz.rx() / rz.rw();
                if (rx > 1.0f) {
                    i = (int) (1.0f * af);
                } else if (rx < 0.2f) {
                    i = (int) (af * 0.2f);
                } else {
                    i = (int) (af * rx);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fAd.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = af;
                bVar.fAd.setLayoutParams(layoutParams2);
            } else {
                bVar.fAd.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fih) {
            bVar.fjR.setOnClickListener(null);
        } else {
            bVar.fjR.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fjR.setTextViewCheckSelection(false);
        bVar.fjR.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().fM(this.fAb - (i - this.fAa));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fjR.setOnLongClickListener(this.axX);
        bVar.fjR.setOnTouchListener(this.aWy);
        bVar.fjR.setOnImageClickListener(this.aWx);
        bVar.fjR.setOnEmotionClickListener(((PbActivity) this.fhQ.getPageContext().getOrignalPage()).ffT.ftr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fig = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void pZ(int i) {
        this.fio = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jr(boolean z) {
        this.fih = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void js(boolean z) {
        this.fii = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jt(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void F(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.aWx = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axX = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void n(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
