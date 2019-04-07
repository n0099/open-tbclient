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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class a extends k<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private TbRichTextView.h cAD;
    private c cca;
    private View.OnLongClickListener cdf;
    private boolean hCv;
    private int hGx;
    private int hGy;
    private d hoY;
    private boolean hoZ;
    private boolean hpa;
    private int hpg;
    private boolean hqs;
    private final boolean hqt;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hpg = 0;
        this.hoZ = true;
        this.hCv = true;
        this.hoY = null;
        this.hpa = true;
        this.mCommonClickListener = null;
        this.cAD = null;
        this.cca = null;
        this.cdf = null;
        this.hqs = false;
        this.hqt = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        as(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void as(PbActivity pbActivity) {
        super.as(pbActivity);
        if (pbActivity != null) {
            this.hGx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds30);
            this.hGy = l.aO(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(d.h.pb_interview_normal_item, viewGroup, false), this.hCv, this.hoZ, this.hpg, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, bVar);
        al.l(view, d.C0277d.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.hqC, (int) this.mContext.getResources().getDimension(d.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hqC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.hqC.setLayoutParams(layoutParams);
            bVar.hqC.setPadding(0, 0, 0, 0);
            bVar.hqC.qc(null);
            postData.ZS();
            if (postData.cep() == 1) {
                bVar.hGC.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.YO() != null) {
                    j = postData.YO().getUserIdLong();
                    str = postData.YO().getUserName();
                    str2 = postData.YO().getName_show();
                }
                bVar.hGC.a(postData.cex(), str, str2, j, com.baidu.adp.lib.g.b.d(this.hoY.bHW().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                bVar.hGC.onChangeSkinType();
                if (this.hpa) {
                    PraiseData YA = this.hoY.bHW().YA();
                    if (YA != null && YA.getUser() != null && YA.getUser().size() > 0) {
                        bVar.hGD.setVisibility(0);
                        bVar.hGB.setVisibility(0);
                        bVar.hGE.setVisibility(0);
                        bVar.hGD.setIsFromPb(true);
                        bVar.hGD.setData(YA, this.hoY.bHW().getId(), YA.getPostId(), true);
                        bVar.hGD.ii(this.mSkinType);
                    } else {
                        bVar.hGD.setVisibility(8);
                        bVar.hGB.setVisibility(8);
                        bVar.hGE.setVisibility(8);
                    }
                } else {
                    bVar.hGD.setVisibility(8);
                    bVar.hGB.setVisibility(8);
                    bVar.hGE.setVisibility(8);
                }
                bVar.hGD.setVisibility(0);
                bVar.hGB.setVisibility(0);
                bVar.hGE.setVisibility(0);
                a(bVar.hqC, (int) this.mContext.getResources().getDimension(d.e.ds30));
            } else {
                bVar.hGC.setVisibility(8);
            }
            bVar.hqC.getLayoutStrategy().kx(d.f.pic_video);
            bVar.hqC.setTextColor(al.getColor(d.C0277d.common_color_10039));
            bVar.hqC.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            bVar.hqC.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            if (this.hoZ) {
                bVar.hqC.getLayoutStrategy().kA(d.f.transparent_bg);
            } else {
                bVar.hqC.getLayoutStrategy().kA(d.f.icon_click);
            }
            bVar.hqC.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cer();
            }
            if (this.hqs || !this.hqt) {
                bVar.hqC.setText(tbRichText, false);
            } else {
                bVar.hqC.setText(tbRichText, true);
            }
            be Yu = this.hoY.bHW().Yu();
            if (Yu != null) {
                bVar.hGA.startLoad(this.hoY.bHW().Yu().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int aO = l.aO(this.mContext);
                float Yk = Yu.Yk() / Yu.Yj();
                if (Yk > 1.0f) {
                    i = (int) (1.0f * aO);
                } else if (Yk < 0.2f) {
                    i = (int) (aO * 0.2f);
                } else {
                    i = (int) (aO * Yk);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.hGA.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = aO;
                bVar.hGA.setLayoutParams(layoutParams2);
            } else {
                bVar.hGA.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hoZ) {
            bVar.hqC.setOnClickListener(null);
        } else {
            bVar.hqC.setOnClickListener(this.mCommonClickListener);
        }
        bVar.hqC.setTextViewCheckSelection(false);
        bVar.hqC.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().ky(this.hGy - (i - this.hGx));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.hqC.setOnLongClickListener(this.cdf);
        bVar.hqC.setOnTouchListener(this.cca);
        bVar.hqC.setOnImageClickListener(this.cAD);
        bVar.hqC.setOnEmotionClickListener(((PbActivity) this.hoJ.getPageContext().getOrignalPage()).hmK.hzT);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hoY = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void vW(int i) {
        this.hpg = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nc(boolean z) {
        this.hoZ = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nd(boolean z) {
        this.hpa = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void ne(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void J(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAD = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdf = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
