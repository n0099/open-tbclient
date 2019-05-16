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
    private d hGB;
    private boolean hGC;
    private boolean hGD;
    private int hGJ;
    private boolean hHV;
    private final boolean hHW;
    private boolean hUw;
    private int hYy;
    private int hYz;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hGJ = 0;
        this.hGC = true;
        this.hUw = true;
        this.hGB = null;
        this.hGD = true;
        this.mCommonClickListener = null;
        this.cIM = null;
        this.ckg = null;
        this.clk = null;
        this.hHV = false;
        this.hHW = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        au(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void au(PbActivity pbActivity) {
        super.au(pbActivity);
        if (pbActivity != null) {
            this.hYy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.hYz = l.af(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.hUw, this.hGC, this.hGJ, false);
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
            a(bVar.hIf, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hIf.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.hIf.setLayoutParams(layoutParams);
            bVar.hIf.setPadding(0, 0, 0, 0);
            bVar.hIf.rl(null);
            postData.aez();
            if (postData.cmu() == 1) {
                bVar.hYD.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.adv() != null) {
                    j = postData.adv().getUserIdLong();
                    str = postData.adv().getUserName();
                    str2 = postData.adv().getName_show();
                }
                bVar.hYD.a(postData.cmC(), str, str2, j, com.baidu.adp.lib.g.b.c(this.hGB.bPI().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.hYD.onChangeSkinType();
                if (this.hGD) {
                    PraiseData adh = this.hGB.bPI().adh();
                    if (adh != null && adh.getUser() != null && adh.getUser().size() > 0) {
                        bVar.hYE.setVisibility(0);
                        bVar.hYC.setVisibility(0);
                        bVar.hYF.setVisibility(0);
                        bVar.hYE.setIsFromPb(true);
                        bVar.hYE.setData(adh, this.hGB.bPI().getId(), adh.getPostId(), true);
                        bVar.hYE.iW(this.mSkinType);
                    } else {
                        bVar.hYE.setVisibility(8);
                        bVar.hYC.setVisibility(8);
                        bVar.hYF.setVisibility(8);
                    }
                } else {
                    bVar.hYE.setVisibility(8);
                    bVar.hYC.setVisibility(8);
                    bVar.hYF.setVisibility(8);
                }
                bVar.hYE.setVisibility(0);
                bVar.hYC.setVisibility(0);
                bVar.hYF.setVisibility(0);
                a(bVar.hIf, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.hYD.setVisibility(8);
            }
            bVar.hIf.getLayoutStrategy().lm(R.drawable.pic_video);
            bVar.hIf.setTextColor(al.getColor(R.color.common_color_10039));
            bVar.hIf.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
            bVar.hIf.setLinkTextColor(al.getColor(R.color.cp_link_tip_c));
            if (this.hGC) {
                bVar.hIf.getLayoutStrategy().lp(R.drawable.transparent_bg);
            } else {
                bVar.hIf.getLayoutStrategy().lp(R.drawable.icon_click);
            }
            bVar.hIf.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cmw();
            }
            if (this.hHV || !this.hHW) {
                bVar.hIf.setText(tbRichText, false);
            } else {
                bVar.hIf.setText(tbRichText, true);
            }
            be adb = this.hGB.bPI().adb();
            if (adb != null) {
                bVar.hYB.startLoad(this.hGB.bPI().adb().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int af = l.af(this.mContext);
                float acR = adb.acR() / adb.acQ();
                if (acR > 1.0f) {
                    i = (int) (1.0f * af);
                } else if (acR < 0.2f) {
                    i = (int) (af * 0.2f);
                } else {
                    i = (int) (af * acR);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.hYB.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = af;
                bVar.hYB.setLayoutParams(layoutParams2);
            } else {
                bVar.hYB.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hGC) {
            bVar.hIf.setOnClickListener(null);
        } else {
            bVar.hIf.setOnClickListener(this.mCommonClickListener);
        }
        bVar.hIf.setTextViewCheckSelection(false);
        bVar.hIf.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().ln(this.hYz - (i - this.hYy));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.hIf.setOnLongClickListener(this.clk);
        bVar.hIf.setOnTouchListener(this.ckg);
        bVar.hIf.setOnImageClickListener(this.cIM);
        bVar.hIf.setOnEmotionClickListener(((PbActivity) this.hGm.getPageContext().getOrignalPage()).hEm.hRE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(d dVar) {
        this.hGB = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void xc(int i) {
        this.hGJ = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nR(boolean z) {
        this.hGC = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nS(boolean z) {
        this.hGD = z;
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
