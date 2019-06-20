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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class a extends k<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private TbRichTextView.h cIN;
    private c ckh;
    private View.OnLongClickListener cll;
    private d hGF;
    private boolean hGG;
    private boolean hGH;
    private int hGN;
    private boolean hHZ;
    private final boolean hIa;
    private boolean hUA;
    private int hYC;
    private int hYD;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hGN = 0;
        this.hGG = true;
        this.hUA = true;
        this.hGF = null;
        this.hGH = true;
        this.mCommonClickListener = null;
        this.cIN = null;
        this.ckh = null;
        this.cll = null;
        this.hHZ = false;
        this.hIa = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        au(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void au(PbActivity pbActivity) {
        super.au(pbActivity);
        if (pbActivity != null) {
            this.hYC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.hYD = l.af(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.hUA, this.hGG, this.hGN, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, bVar);
        al.l(view, R.color.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.hIj, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hIj.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.hIj.setLayoutParams(layoutParams);
            bVar.hIj.setPadding(0, 0, 0, 0);
            bVar.hIj.rk(null);
            postData.aez();
            if (postData.cmx() == 1) {
                bVar.hYH.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.adv() != null) {
                    j = postData.adv().getUserIdLong();
                    str = postData.adv().getUserName();
                    str2 = postData.adv().getName_show();
                }
                bVar.hYH.a(postData.cmF(), str, str2, j, com.baidu.adp.lib.g.b.c(this.hGF.bPM().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.hYH.onChangeSkinType();
                if (this.hGH) {
                    PraiseData adh = this.hGF.bPM().adh();
                    if (adh != null && adh.getUser() != null && adh.getUser().size() > 0) {
                        bVar.hYI.setVisibility(0);
                        bVar.hYG.setVisibility(0);
                        bVar.hYJ.setVisibility(0);
                        bVar.hYI.setIsFromPb(true);
                        bVar.hYI.setData(adh, this.hGF.bPM().getId(), adh.getPostId(), true);
                        bVar.hYI.iW(this.mSkinType);
                    } else {
                        bVar.hYI.setVisibility(8);
                        bVar.hYG.setVisibility(8);
                        bVar.hYJ.setVisibility(8);
                    }
                } else {
                    bVar.hYI.setVisibility(8);
                    bVar.hYG.setVisibility(8);
                    bVar.hYJ.setVisibility(8);
                }
                bVar.hYI.setVisibility(0);
                bVar.hYG.setVisibility(0);
                bVar.hYJ.setVisibility(0);
                a(bVar.hIj, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.hYH.setVisibility(8);
            }
            bVar.hIj.getLayoutStrategy().lm(R.drawable.pic_video);
            bVar.hIj.setTextColor(al.getColor(R.color.common_color_10039));
            bVar.hIj.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
            bVar.hIj.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
            if (this.hGG) {
                bVar.hIj.getLayoutStrategy().lp(R.drawable.transparent_bg);
            } else {
                bVar.hIj.getLayoutStrategy().lp(R.drawable.icon_click);
            }
            bVar.hIj.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cmz();
            }
            if (this.hHZ || !this.hIa) {
                bVar.hIj.setText(tbRichText, false);
            } else {
                bVar.hIj.setText(tbRichText, true);
            }
            be adb = this.hGF.bPM().adb();
            if (adb != null) {
                bVar.hYF.startLoad(this.hGF.bPM().adb().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int af = l.af(this.mContext);
                float acR = adb.acR() / adb.acQ();
                if (acR > 1.0f) {
                    i = (int) (1.0f * af);
                } else if (acR < 0.2f) {
                    i = (int) (af * 0.2f);
                } else {
                    i = (int) (af * acR);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.hYF.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = af;
                bVar.hYF.setLayoutParams(layoutParams2);
            } else {
                bVar.hYF.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hGG) {
            bVar.hIj.setOnClickListener(null);
        } else {
            bVar.hIj.setOnClickListener(this.mCommonClickListener);
        }
        bVar.hIj.setTextViewCheckSelection(false);
        bVar.hIj.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().ln(this.hYD - (i - this.hYC));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.hIj.setOnLongClickListener(this.cll);
        bVar.hIj.setOnTouchListener(this.ckh);
        bVar.hIj.setOnImageClickListener(this.cIN);
        bVar.hIj.setOnEmotionClickListener(((PbActivity) this.hGq.getPageContext().getOrignalPage()).hEq.hRI);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(d dVar) {
        this.hGF = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void xc(int i) {
        this.hGN = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nS(boolean z) {
        this.hGG = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nT(boolean z) {
        this.hGH = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nU(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void L(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cIN = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cll = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
