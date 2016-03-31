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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.db;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends db<com.baidu.tieba.tbadkCore.data.s, c> implements View.OnClickListener {
    private TbRichTextView.d aJc;
    private View.OnLongClickListener aoa;
    private View.OnClickListener brL;
    private int ddn;
    private boolean ddo;
    private boolean ddp;
    private com.baidu.tieba.pb.data.e ddq;
    private boolean ddr;
    private com.baidu.tieba.pb.a.c dds;
    private int ddt;
    private int ddv;
    private boolean ddw;
    private final boolean ddx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ddn = 0;
        this.ddo = true;
        this.ddp = true;
        this.ddq = null;
        this.ddr = true;
        this.brL = null;
        this.aJc = null;
        this.dds = null;
        this.aoa = null;
        this.ddw = false;
        this.ddx = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.ddt = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds30);
        this.ddv = com.baidu.adp.lib.util.k.B(this.mContext) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public c b(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(t.h.pb_interview_normal_item, viewGroup, false), this.ddp, this.ddo, this.ddn, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.db, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) cVar);
        a(cVar);
        a(cVar, sVar);
        return view;
    }

    private void a(c cVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        int i;
        if (cVar != null && sVar != null) {
            a(cVar.ddA, (int) this.mContext.getResources().getDimension(t.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.ddA.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            cVar.ddA.setLayoutParams(layoutParams);
            cVar.ddA.setPadding(0, 0, 0, 0);
            cVar.ddA.gu(null);
            if (sVar.aTs() == 1) {
                cVar.ddC.setVisibility(0);
                String str = null;
                long j = 0;
                if (sVar.getAuthor() != null) {
                    j = sVar.getAuthor().getUserIdLong();
                    str = sVar.getAuthor().getUserName();
                }
                cVar.ddC.a(sVar.aTB(), str, j, com.baidu.adp.lib.h.b.c(this.ddq.avv().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                cVar.ddC.uA();
                if (this.ddr) {
                    PraiseData praise = this.ddq.avv().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        cVar.ddD.setVisibility(0);
                        cVar.ddB.setVisibility(0);
                        cVar.ddE.setVisibility(0);
                        cVar.ddD.setIsFromPb(true);
                        cVar.ddD.a(praise, this.ddq.avv().getId(), praise.getPostId(), true);
                        cVar.ddD.dn(this.mSkinType);
                    } else {
                        cVar.ddD.setVisibility(8);
                        cVar.ddB.setVisibility(8);
                        cVar.ddE.setVisibility(8);
                    }
                } else {
                    cVar.ddD.setVisibility(8);
                    cVar.ddB.setVisibility(8);
                    cVar.ddE.setVisibility(8);
                }
                com.baidu.tieba.graffiti.d.af(cVar.ddD);
                com.baidu.tieba.graffiti.d.af(cVar.ddB);
                com.baidu.tieba.graffiti.d.af(cVar.ddE);
                a(cVar.ddA, (int) this.mContext.getResources().getDimension(t.e.ds30));
            } else {
                cVar.ddC.setVisibility(8);
            }
            cVar.ddA.setVideoImageId(t.f.pic_video);
            cVar.ddA.setTextColor(at.getColor(t.d.pb_listitem_content));
            cVar.ddA.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            cVar.ddA.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            if (this.ddo) {
                cVar.ddA.setDefaultImageId(t.f.transparent_bg);
            } else {
                cVar.ddA.setDefaultImageId(t.f.icon_click);
            }
            cVar.ddA.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = sVar.amn();
            }
            if (this.ddw || !this.ddx) {
                cVar.ddA.a(aVar, false);
            } else {
                cVar.ddA.a(aVar, true);
            }
            com.baidu.tbadk.core.data.aq tg = this.ddq.avv().tg();
            if (tg != null) {
                cVar.ddz.c(this.ddq.avv().tg().tc(), this.mIsFromCDN ? 17 : 18, false);
                int B = (com.baidu.adp.lib.util.k.B(this.mContext) - com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30)) - com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30);
                float te = tg.te() / tg.td();
                if (te > 1.0f) {
                    i = (int) (1.0f * B);
                } else if (te < 0.2f) {
                    i = (int) (B * 0.2f);
                } else {
                    i = (int) (B * te);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.ddz.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = B;
                cVar.ddz.setLayoutParams(layoutParams2);
            } else {
                cVar.ddz.setVisibility(8);
            }
            b(cVar, sVar);
        }
    }

    private void b(c cVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.ddo) {
            cVar.ddA.setOnClickListener(null);
        } else {
            cVar.ddA.setOnClickListener(this.brL);
        }
        cVar.ddA.setTextViewCheckSelection(false);
        cVar.ddA.setTextViewOnClickListener(new b(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.ddv - (i - this.ddt));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(c cVar) {
        cVar.ddA.setOnLongClickListener(this.aoa);
        cVar.ddA.setOnTouchListener(this.dds);
        cVar.ddA.setOnImageClickListener(this.aJc);
        cVar.ddA.setOnEmotionClickListener(((PbActivity) this.dfw.getPageContext().getOrignalPage()).dgG.dny);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        this.ddq = eVar;
    }

    public void lP(int i) {
        this.ddn = i;
    }

    public void fQ(boolean z) {
        this.ddo = z;
    }

    public void fR(boolean z) {
        this.ddp = z;
    }

    public void fS(boolean z) {
        this.ddr = z;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aJc = dVar;
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.dds = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoa = onLongClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.brL = onClickListener;
    }
}
