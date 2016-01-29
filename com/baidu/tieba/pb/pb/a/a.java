package com.baidu.tieba.pb.pb.a;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cl;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends cl<com.baidu.tieba.tbadkCore.data.r, c> implements View.OnClickListener {
    private TbRichTextView.d aGi;
    private View.OnLongClickListener anJ;
    private View.OnClickListener bmy;
    private int cJW;
    private boolean cJX;
    private boolean cJY;
    private com.baidu.tieba.pb.a.c cJZ;
    private boolean cKa;
    private com.baidu.tieba.pb.b.c cKb;
    private int cKc;
    private int cKd;
    private boolean cKe;
    private final boolean cKf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.cJW = 0;
        this.cJX = true;
        this.cJY = true;
        this.cJZ = null;
        this.cKa = true;
        this.bmy = null;
        this.aGi = null;
        this.cKb = null;
        this.anJ = null;
        this.cKe = false;
        this.cKf = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.cKc = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds30);
        this.cKd = com.baidu.adp.lib.util.k.K(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ag */
    public c b(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(t.h.pb_interview_normal_item, viewGroup, false), this.cJY, this.cJX, this.cJW, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cl, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.r rVar, c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) rVar, (com.baidu.tieba.tbadkCore.data.r) cVar);
        a(cVar);
        a(cVar, rVar);
        return view;
    }

    private void a(c cVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        int i;
        if (cVar != null && rVar != null) {
            a(cVar.cKi, (int) this.mContext.getResources().getDimension(t.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.cKi.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            cVar.cKi.setLayoutParams(layoutParams);
            cVar.cKi.setPadding(0, 0, 0, 0);
            cVar.cKi.gi(null);
            if (rVar.aMw() == 1) {
                cVar.cKk.setVisibility(0);
                String str = null;
                long j = 0;
                if (rVar.getAuthor() != null) {
                    j = rVar.getAuthor().getUserIdLong();
                    str = rVar.getAuthor().getUserName();
                }
                cVar.cKk.a(rVar.aME(), str, j, com.baidu.adp.lib.h.b.c(this.cJZ.aoF().getId(), 0L), com.baidu.adp.lib.h.b.c(rVar.getId(), 0L));
                cVar.cKk.uv();
                if (this.cKa) {
                    PraiseData praise = this.cJZ.aoF().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        cVar.cKl.setVisibility(0);
                        cVar.cKj.setVisibility(0);
                        cVar.cKm.setVisibility(0);
                        cVar.cKl.setIsFromPb(true);
                        cVar.cKl.a(praise, this.cJZ.aoF().getId(), praise.getPostId(), true);
                        cVar.cKl.dk(this.mSkinType);
                    } else {
                        cVar.cKl.setVisibility(8);
                        cVar.cKj.setVisibility(8);
                        cVar.cKm.setVisibility(8);
                    }
                } else {
                    cVar.cKl.setVisibility(8);
                    cVar.cKj.setVisibility(8);
                    cVar.cKm.setVisibility(8);
                }
                a(cVar.cKi, (int) this.mContext.getResources().getDimension(t.e.ds30));
            } else {
                cVar.cKk.setVisibility(8);
            }
            cVar.cKi.setVideoImageId(t.f.pic_video);
            cVar.cKi.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.pb_listitem_content));
            cVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            cVar.cKi.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_link_tip_c));
            if (this.cJX) {
                cVar.cKi.setDefaultImageId(t.f.img_default_100);
            } else {
                cVar.cKi.setDefaultImageId(t.f.icon_click);
            }
            cVar.cKi.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = rVar.aiT();
            }
            if (this.cKe || !this.cKf) {
                cVar.cKi.a(aVar, false);
            } else {
                cVar.cKi.a(aVar, true);
            }
            com.baidu.tbadk.core.data.af te = this.cJZ.aoF().te();
            if (te != null) {
                cVar.cKh.d(this.cJZ.aoF().te().tb(), this.mIsFromCDN ? 17 : 18, false);
                int K = (com.baidu.adp.lib.util.k.K(this.mContext) - com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30)) - com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30);
                float td = te.td() / te.tc();
                if (td > 1.0f) {
                    i = (int) (1.0f * K);
                } else if (td < 0.2f) {
                    i = (int) (K * 0.2f);
                } else {
                    i = (int) (K * td);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.cKh.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = K;
                cVar.cKh.setLayoutParams(layoutParams2);
            } else {
                cVar.cKh.setVisibility(8);
            }
            b(cVar, rVar);
        }
    }

    private void b(c cVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        if (TextUtils.isEmpty(rVar.getBimg_url()) || !this.cJX) {
            cVar.cKi.setOnClickListener(null);
        } else {
            cVar.cKi.setOnClickListener(this.bmy);
        }
        cVar.cKi.setTextViewCheckSelection(false);
        cVar.cKi.setTextViewOnClickListener(new b(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cKd - (i - this.cKc));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(c cVar) {
        cVar.cKi.setOnLongClickListener(this.anJ);
        cVar.cKi.setOnTouchListener(this.cKb);
        cVar.cKi.setOnImageClickListener(this.aGi);
        cVar.cKi.setOnEmotionClickListener(((PbActivity) this.cNL.getPageContext().getOrignalPage()).cML.cSG);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.cJZ = cVar;
    }

    public void setImageMaxWidth(int i) {
        this.cJW = i;
    }

    public void fg(boolean z) {
        this.cJX = z;
    }

    public void fh(boolean z) {
        this.cJY = z;
    }

    public void fi(boolean z) {
        this.cKa = z;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aGi = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cKb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anJ = onLongClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bmy = onClickListener;
    }
}
