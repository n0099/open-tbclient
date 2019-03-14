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
    private TbRichTextView.h cAB;
    private c cbY;
    private View.OnLongClickListener cdd;
    private boolean hCJ;
    private int hGL;
    private int hGM;
    private d hpl;
    private boolean hpm;
    private boolean hpn;
    private int hpt;
    private boolean hqF;
    private final boolean hqG;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hpt = 0;
        this.hpm = true;
        this.hCJ = true;
        this.hpl = null;
        this.hpn = true;
        this.mCommonClickListener = null;
        this.cAB = null;
        this.cbY = null;
        this.cdd = null;
        this.hqF = false;
        this.hqG = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        as(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void as(PbActivity pbActivity) {
        super.as(pbActivity);
        if (pbActivity != null) {
            this.hGL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds30);
            this.hGM = l.aO(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(d.h.pb_interview_normal_item, viewGroup, false), this.hCJ, this.hpm, this.hpt, false);
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
            a(bVar.hqP, (int) this.mContext.getResources().getDimension(d.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hqP.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.hqP.setLayoutParams(layoutParams);
            bVar.hqP.setPadding(0, 0, 0, 0);
            bVar.hqP.qb(null);
            postData.ZV();
            if (postData.cet() == 1) {
                bVar.hGQ.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.YR() != null) {
                    j = postData.YR().getUserIdLong();
                    str = postData.YR().getUserName();
                    str2 = postData.YR().getName_show();
                }
                bVar.hGQ.a(postData.ceB(), str, str2, j, com.baidu.adp.lib.g.b.d(this.hpl.bHZ().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                bVar.hGQ.onChangeSkinType();
                if (this.hpn) {
                    PraiseData YD = this.hpl.bHZ().YD();
                    if (YD != null && YD.getUser() != null && YD.getUser().size() > 0) {
                        bVar.hGR.setVisibility(0);
                        bVar.hGP.setVisibility(0);
                        bVar.hGS.setVisibility(0);
                        bVar.hGR.setIsFromPb(true);
                        bVar.hGR.setData(YD, this.hpl.bHZ().getId(), YD.getPostId(), true);
                        bVar.hGR.ij(this.mSkinType);
                    } else {
                        bVar.hGR.setVisibility(8);
                        bVar.hGP.setVisibility(8);
                        bVar.hGS.setVisibility(8);
                    }
                } else {
                    bVar.hGR.setVisibility(8);
                    bVar.hGP.setVisibility(8);
                    bVar.hGS.setVisibility(8);
                }
                bVar.hGR.setVisibility(0);
                bVar.hGP.setVisibility(0);
                bVar.hGS.setVisibility(0);
                a(bVar.hqP, (int) this.mContext.getResources().getDimension(d.e.ds30));
            } else {
                bVar.hGQ.setVisibility(8);
            }
            bVar.hqP.getLayoutStrategy().ky(d.f.pic_video);
            bVar.hqP.setTextColor(al.getColor(d.C0277d.common_color_10039));
            bVar.hqP.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            bVar.hqP.setLinkTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            if (this.hpm) {
                bVar.hqP.getLayoutStrategy().kB(d.f.transparent_bg);
            } else {
                bVar.hqP.getLayoutStrategy().kB(d.f.icon_click);
            }
            bVar.hqP.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cev();
            }
            if (this.hqF || !this.hqG) {
                bVar.hqP.setText(tbRichText, false);
            } else {
                bVar.hqP.setText(tbRichText, true);
            }
            be Yx = this.hpl.bHZ().Yx();
            if (Yx != null) {
                bVar.hGO.startLoad(this.hpl.bHZ().Yx().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int aO = l.aO(this.mContext);
                float Yn = Yx.Yn() / Yx.Ym();
                if (Yn > 1.0f) {
                    i = (int) (1.0f * aO);
                } else if (Yn < 0.2f) {
                    i = (int) (aO * 0.2f);
                } else {
                    i = (int) (aO * Yn);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.hGO.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = aO;
                bVar.hGO.setLayoutParams(layoutParams2);
            } else {
                bVar.hGO.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hpm) {
            bVar.hqP.setOnClickListener(null);
        } else {
            bVar.hqP.setOnClickListener(this.mCommonClickListener);
        }
        bVar.hqP.setTextViewCheckSelection(false);
        bVar.hqP.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().kz(this.hGM - (i - this.hGL));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.hqP.setOnLongClickListener(this.cdd);
        bVar.hqP.setOnTouchListener(this.cbY);
        bVar.hqP.setOnImageClickListener(this.cAB);
        bVar.hqP.setOnEmotionClickListener(((PbActivity) this.hoW.getPageContext().getOrignalPage()).hmX.hAh);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.hpl = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void wa(int i) {
        this.hpt = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nc(boolean z) {
        this.hpm = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nd(boolean z) {
        this.hpn = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void ne(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void J(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAB = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdd = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
