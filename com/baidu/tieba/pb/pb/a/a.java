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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cm;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends cm<com.baidu.tieba.tbadkCore.data.s, c> implements View.OnClickListener {
    private TbRichTextView.d aFe;
    private View.OnLongClickListener ajO;
    private View.OnClickListener bnn;
    private int dfH;
    private boolean dfI;
    private boolean dfJ;
    private com.baidu.tieba.pb.data.e dfK;
    private boolean dfL;
    private com.baidu.tieba.pb.a.d dfM;
    private int dfN;
    private int dfO;
    private boolean dfP;
    private final boolean dfQ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.dfH = 0;
        this.dfI = true;
        this.dfJ = true;
        this.dfK = null;
        this.dfL = true;
        this.bnn = null;
        this.aFe = null;
        this.dfM = null;
        this.ajO = null;
        this.dfP = false;
        this.dfQ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        init();
    }

    private void init() {
        this.dfN = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds30);
        this.dfO = com.baidu.adp.lib.util.k.B(this.mContext) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds60);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public c b(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(t.h.pb_interview_normal_item, viewGroup, false), this.dfJ, this.dfI, this.dfH, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.cm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.data.s sVar, c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tieba.tbadkCore.data.s) cVar);
        a(cVar);
        a(cVar, sVar);
        return view;
    }

    private void a(c cVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        int i;
        if (cVar != null && sVar != null) {
            a(cVar.dfT, (int) this.mContext.getResources().getDimension(t.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.dfT.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            cVar.dfT.setLayoutParams(layoutParams);
            cVar.dfT.setPadding(0, 0, 0, 0);
            cVar.dfT.gv(null);
            if (sVar.aTY() == 1) {
                cVar.dfV.setVisibility(0);
                String str = null;
                long j = 0;
                if (sVar.getAuthor() != null) {
                    j = sVar.getAuthor().getUserIdLong();
                    str = sVar.getAuthor().getUserName();
                }
                cVar.dfV.a(sVar.aUh(), str, j, com.baidu.adp.lib.h.b.c(this.dfK.avE().getId(), 0L), com.baidu.adp.lib.h.b.c(sVar.getId(), 0L));
                cVar.dfV.sg();
                if (this.dfL) {
                    PraiseData praise = this.dfK.avE().getPraise();
                    if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                        cVar.dfW.setVisibility(0);
                        cVar.dfU.setVisibility(0);
                        cVar.dfX.setVisibility(0);
                        cVar.dfW.setIsFromPb(true);
                        cVar.dfW.a(praise, this.dfK.avE().getId(), praise.getPostId(), true);
                        cVar.dfW.cV(this.mSkinType);
                    } else {
                        cVar.dfW.setVisibility(8);
                        cVar.dfU.setVisibility(8);
                        cVar.dfX.setVisibility(8);
                    }
                } else {
                    cVar.dfW.setVisibility(8);
                    cVar.dfU.setVisibility(8);
                    cVar.dfX.setVisibility(8);
                }
                com.baidu.tieba.graffiti.d.aj(cVar.dfW);
                com.baidu.tieba.graffiti.d.aj(cVar.dfU);
                com.baidu.tieba.graffiti.d.aj(cVar.dfX);
                a(cVar.dfT, (int) this.mContext.getResources().getDimension(t.e.ds30));
            } else {
                cVar.dfV.setVisibility(8);
            }
            cVar.dfT.setVideoImageId(t.f.pic_video);
            cVar.dfT.setTextColor(at.getColor(t.d.pb_listitem_content));
            cVar.dfT.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            cVar.dfT.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            if (this.dfI) {
                cVar.dfT.setDefaultImageId(t.f.transparent_bg);
            } else {
                cVar.dfT.setDefaultImageId(t.f.icon_click);
            }
            cVar.dfT.setIsFromCDN(this.mIsFromCDN);
            com.baidu.tbadk.widget.richText.a aVar = null;
            if (0 == 0) {
                aVar = sVar.amz();
            }
            if (this.dfP || !this.dfQ) {
                cVar.dfT.a(aVar, false);
            } else {
                cVar.dfT.a(aVar, true);
            }
            av qF = this.dfK.avE().qF();
            if (qF != null) {
                cVar.dfS.c(this.dfK.avE().qF().qB(), this.mIsFromCDN ? 17 : 18, false);
                int B = (com.baidu.adp.lib.util.k.B(this.mContext) - com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30)) - com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30);
                float qD = qF.qD() / qF.qC();
                if (qD > 1.0f) {
                    i = (int) (1.0f * B);
                } else if (qD < 0.2f) {
                    i = (int) (B * 0.2f);
                } else {
                    i = (int) (B * qD);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.dfS.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = B;
                cVar.dfS.setLayoutParams(layoutParams2);
            } else {
                cVar.dfS.setVisibility(8);
            }
            b(cVar, sVar);
        }
    }

    private void b(c cVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        if (TextUtils.isEmpty(sVar.getBimg_url()) || !this.dfI) {
            cVar.dfT.setOnClickListener(null);
        } else {
            cVar.dfT.setOnClickListener(this.bnn);
        }
        cVar.dfT.setTextViewCheckSelection(false);
        cVar.dfT.setTextViewOnClickListener(new b(this));
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.dfO - (i - this.dfN));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(c cVar) {
        cVar.dfT.setOnLongClickListener(this.ajO);
        cVar.dfT.setOnTouchListener(this.dfM);
        cVar.dfT.setOnImageClickListener(this.aFe);
        cVar.dfT.setOnEmotionClickListener(((PbActivity) this.dhY.getPageContext().getOrignalPage()).diS.dpL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void b(com.baidu.tieba.pb.data.e eVar) {
        this.dfK = eVar;
    }

    public void lD(int i) {
        this.dfH = i;
    }

    public void gq(boolean z) {
        this.dfI = z;
    }

    public void gr(boolean z) {
        this.dfJ = z;
    }

    public void gs(boolean z) {
        this.dfL = z;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFe = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dfM = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajO = onLongClickListener;
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bnn = onClickListener;
    }
}
