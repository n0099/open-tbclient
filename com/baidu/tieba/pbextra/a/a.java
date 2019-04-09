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
    private TbRichTextView.h cAE;
    private c ccb;
    private View.OnLongClickListener cdg;
    private boolean hCw;
    private int hGy;
    private int hGz;
    private d hoZ;
    private boolean hpa;
    private boolean hpb;
    private int hph;
    private boolean hqt;
    private final boolean hqu;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hph = 0;
        this.hpa = true;
        this.hCw = true;
        this.hoZ = null;
        this.hpb = true;
        this.mCommonClickListener = null;
        this.cAE = null;
        this.ccb = null;
        this.cdg = null;
        this.hqt = false;
        this.hqu = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        as(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void as(PbActivity pbActivity) {
        super.as(pbActivity);
        if (pbActivity != null) {
            this.hGy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds30);
            this.hGz = l.aO(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(d.h.pb_interview_normal_item, viewGroup, false), this.hCw, this.hpa, this.hph, false);
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
            a(bVar.hqD, (int) this.mContext.getResources().getDimension(d.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hqD.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.hqD.setLayoutParams(layoutParams);
            bVar.hqD.setPadding(0, 0, 0, 0);
            bVar.hqD.qc(null);
            postData.ZS();
            if (postData.cep() == 1) {
                bVar.hGD.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.YO() != null) {
                    j = postData.YO().getUserIdLong();
                    str = postData.YO().getUserName();
                    str2 = postData.YO().getName_show();
                }
                bVar.hGD.a(postData.cex(), str, str2, j, com.baidu.adp.lib.g.b.d(this.hoZ.bHW().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                bVar.hGD.onChangeSkinType();
                if (this.hpb) {
                    PraiseData YA = this.hoZ.bHW().YA();
                    if (YA != null && YA.getUser() != null && YA.getUser().size() > 0) {
                        bVar.hGE.setVisibility(0);
                        bVar.hGC.setVisibility(0);
                        bVar.hGF.setVisibility(0);
                        bVar.hGE.setIsFromPb(true);
                        bVar.hGE.setData(YA, this.hoZ.bHW().getId(), YA.getPostId(), true);
                        bVar.hGE.ii(this.mSkinType);
                    } else {
                        bVar.hGE.setVisibility(8);
                        bVar.hGC.setVisibility(8);
                        bVar.hGF.setVisibility(8);
                    }
                } else {
                    bVar.hGE.setVisibility(8);
                    bVar.hGC.setVisibility(8);
                    bVar.hGF.setVisibility(8);
                }
                bVar.hGE.setVisibility(0);
                bVar.hGC.setVisibility(0);
                bVar.hGF.setVisibility(0);
                a(bVar.hqD, (int) this.mContext.getResources().getDimension(d.e.ds30));
            } else {
                bVar.hGD.setVisibility(8);
            }
            bVar.hqD.getLayoutStrategy().kx(d.f.pic_video);
            bVar.hqD.setTextColor(al.getColor(d.C0277d.common_color_10039));
            bVar.hqD.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            bVar.hqD.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            if (this.hpa) {
                bVar.hqD.getLayoutStrategy().kA(d.f.transparent_bg);
            } else {
                bVar.hqD.getLayoutStrategy().kA(d.f.icon_click);
            }
            bVar.hqD.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cer();
            }
            if (this.hqt || !this.hqu) {
                bVar.hqD.setText(tbRichText, false);
            } else {
                bVar.hqD.setText(tbRichText, true);
            }
            be Yu = this.hoZ.bHW().Yu();
            if (Yu != null) {
                bVar.hGB.startLoad(this.hoZ.bHW().Yu().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int aO = l.aO(this.mContext);
                float Yk = Yu.Yk() / Yu.Yj();
                if (Yk > 1.0f) {
                    i = (int) (1.0f * aO);
                } else if (Yk < 0.2f) {
                    i = (int) (aO * 0.2f);
                } else {
                    i = (int) (aO * Yk);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.hGB.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = aO;
                bVar.hGB.setLayoutParams(layoutParams2);
            } else {
                bVar.hGB.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hpa) {
            bVar.hqD.setOnClickListener(null);
        } else {
            bVar.hqD.setOnClickListener(this.mCommonClickListener);
        }
        bVar.hqD.setTextViewCheckSelection(false);
        bVar.hqD.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().ky(this.hGz - (i - this.hGy));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.hqD.setOnLongClickListener(this.cdg);
        bVar.hqD.setOnTouchListener(this.ccb);
        bVar.hqD.setOnImageClickListener(this.cAE);
        bVar.hqD.setOnEmotionClickListener(((PbActivity) this.hoK.getPageContext().getOrignalPage()).hmL.hzU);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hoZ = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void vW(int i) {
        this.hph = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nc(boolean z) {
        this.hpa = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nd(boolean z) {
        this.hpb = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void ne(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void J(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAE = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdg = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
