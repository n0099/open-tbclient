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
    private TbRichTextView.h cIM;
    private c ckg;
    private View.OnLongClickListener clk;
    private d hGE;
    private boolean hGF;
    private boolean hGG;
    private int hGM;
    private boolean hHY;
    private final boolean hHZ;
    private boolean hUz;
    private int hYB;
    private int hYC;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hGM = 0;
        this.hGF = true;
        this.hUz = true;
        this.hGE = null;
        this.hGG = true;
        this.mCommonClickListener = null;
        this.cIM = null;
        this.ckg = null;
        this.clk = null;
        this.hHY = false;
        this.hHZ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        au(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void au(PbActivity pbActivity) {
        super.au(pbActivity);
        if (pbActivity != null) {
            this.hYB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.hYC = l.af(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.hUz, this.hGF, this.hGM, false);
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
            a(bVar.hIi, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hIi.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.hIi.setLayoutParams(layoutParams);
            bVar.hIi.setPadding(0, 0, 0, 0);
            bVar.hIi.rl(null);
            postData.aez();
            if (postData.cmw() == 1) {
                bVar.hYG.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.adv() != null) {
                    j = postData.adv().getUserIdLong();
                    str = postData.adv().getUserName();
                    str2 = postData.adv().getName_show();
                }
                bVar.hYG.a(postData.cmE(), str, str2, j, com.baidu.adp.lib.g.b.c(this.hGE.bPL().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.hYG.onChangeSkinType();
                if (this.hGG) {
                    PraiseData adh = this.hGE.bPL().adh();
                    if (adh != null && adh.getUser() != null && adh.getUser().size() > 0) {
                        bVar.hYH.setVisibility(0);
                        bVar.hYF.setVisibility(0);
                        bVar.hYI.setVisibility(0);
                        bVar.hYH.setIsFromPb(true);
                        bVar.hYH.setData(adh, this.hGE.bPL().getId(), adh.getPostId(), true);
                        bVar.hYH.iW(this.mSkinType);
                    } else {
                        bVar.hYH.setVisibility(8);
                        bVar.hYF.setVisibility(8);
                        bVar.hYI.setVisibility(8);
                    }
                } else {
                    bVar.hYH.setVisibility(8);
                    bVar.hYF.setVisibility(8);
                    bVar.hYI.setVisibility(8);
                }
                bVar.hYH.setVisibility(0);
                bVar.hYF.setVisibility(0);
                bVar.hYI.setVisibility(0);
                a(bVar.hIi, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.hYG.setVisibility(8);
            }
            bVar.hIi.getLayoutStrategy().lm(R.drawable.pic_video);
            bVar.hIi.setTextColor(al.getColor(R.color.common_color_10039));
            bVar.hIi.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
            bVar.hIi.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
            if (this.hGF) {
                bVar.hIi.getLayoutStrategy().lp(R.drawable.transparent_bg);
            } else {
                bVar.hIi.getLayoutStrategy().lp(R.drawable.icon_click);
            }
            bVar.hIi.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cmy();
            }
            if (this.hHY || !this.hHZ) {
                bVar.hIi.setText(tbRichText, false);
            } else {
                bVar.hIi.setText(tbRichText, true);
            }
            be adb = this.hGE.bPL().adb();
            if (adb != null) {
                bVar.hYE.startLoad(this.hGE.bPL().adb().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int af = l.af(this.mContext);
                float acR = adb.acR() / adb.acQ();
                if (acR > 1.0f) {
                    i = (int) (1.0f * af);
                } else if (acR < 0.2f) {
                    i = (int) (af * 0.2f);
                } else {
                    i = (int) (af * acR);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.hYE.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = af;
                bVar.hYE.setLayoutParams(layoutParams2);
            } else {
                bVar.hYE.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hGF) {
            bVar.hIi.setOnClickListener(null);
        } else {
            bVar.hIi.setOnClickListener(this.mCommonClickListener);
        }
        bVar.hIi.setTextViewCheckSelection(false);
        bVar.hIi.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().ln(this.hYC - (i - this.hYB));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.hIi.setOnLongClickListener(this.clk);
        bVar.hIi.setOnTouchListener(this.ckg);
        bVar.hIi.setOnImageClickListener(this.cIM);
        bVar.hIi.setOnEmotionClickListener(((PbActivity) this.hGp.getPageContext().getOrignalPage()).hEp.hRH);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(d dVar) {
        this.hGE = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void xc(int i) {
        this.hGM = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nR(boolean z) {
        this.hGF = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nS(boolean z) {
        this.hGG = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nT(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void L(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cIM = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.clk = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
