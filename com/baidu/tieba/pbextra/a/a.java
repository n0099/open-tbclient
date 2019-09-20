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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.util.am;
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
    private TbRichTextView.h cLe;
    private c cmw;
    private View.OnLongClickListener cnB;
    private d hPJ;
    private boolean hPK;
    private boolean hPL;
    private int hPR;
    private boolean hRd;
    private final boolean hRe;
    private boolean idM;
    private int ihT;
    private int ihU;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hPR = 0;
        this.hPK = true;
        this.idM = true;
        this.hPJ = null;
        this.hPL = true;
        this.mCommonClickListener = null;
        this.cLe = null;
        this.cmw = null;
        this.cnB = null;
        this.hRd = false;
        this.hRe = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        av(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void av(PbActivity pbActivity) {
        super.av(pbActivity);
        if (pbActivity != null) {
            this.ihT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.ihU = l.af(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.idM, this.hPK, this.hPR, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, bVar);
        am.l(view, R.color.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.hRn, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hRn.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.hRn.setLayoutParams(layoutParams);
            bVar.hRn.setPadding(0, 0, 0, 0);
            bVar.hRn.rN(null);
            postData.afG();
            if (postData.cqz() == 1) {
                bVar.ihY.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aeC() != null) {
                    j = postData.aeC().getUserIdLong();
                    str = postData.aeC().getUserName();
                    str2 = postData.aeC().getName_show();
                }
                bVar.ihY.a(postData.cqH(), str, str2, j, com.baidu.adp.lib.g.b.e(this.hPJ.bTy().getId(), 0L), com.baidu.adp.lib.g.b.e(postData.getId(), 0L));
                bVar.ihY.onChangeSkinType();
                if (this.hPL) {
                    PraiseData aeo = this.hPJ.bTy().aeo();
                    if (aeo != null && aeo.getUser() != null && aeo.getUser().size() > 0) {
                        bVar.ihZ.setVisibility(0);
                        bVar.ihX.setVisibility(0);
                        bVar.iia.setVisibility(0);
                        bVar.ihZ.setIsFromPb(true);
                        bVar.ihZ.setData(aeo, this.hPJ.bTy().getId(), aeo.getPostId(), true);
                        bVar.ihZ.jg(this.mSkinType);
                    } else {
                        bVar.ihZ.setVisibility(8);
                        bVar.ihX.setVisibility(8);
                        bVar.iia.setVisibility(8);
                    }
                } else {
                    bVar.ihZ.setVisibility(8);
                    bVar.ihX.setVisibility(8);
                    bVar.iia.setVisibility(8);
                }
                bVar.ihZ.setVisibility(0);
                bVar.ihX.setVisibility(0);
                bVar.iia.setVisibility(0);
                a(bVar.hRn, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.ihY.setVisibility(8);
            }
            bVar.hRn.getLayoutStrategy().lx(R.drawable.pic_video);
            bVar.hRn.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.hRn.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.hRn.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.hPK) {
                bVar.hRn.getLayoutStrategy().lA(R.drawable.transparent_bg);
            } else {
                bVar.hRn.getLayoutStrategy().lA(R.drawable.icon_click);
            }
            bVar.hRn.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cqB();
            }
            if (this.hRd || !this.hRe) {
                bVar.hRn.setText(tbRichText, false);
            } else {
                bVar.hRn.setText(tbRichText, true);
            }
            bf aei = this.hPJ.bTy().aei();
            if (aei != null) {
                bVar.ihW.startLoad(this.hPJ.bTy().aei().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int af = l.af(this.mContext);
                float adY = aei.adY() / aei.adX();
                if (adY > 1.0f) {
                    i = (int) (1.0f * af);
                } else if (adY < 0.2f) {
                    i = (int) (af * 0.2f);
                } else {
                    i = (int) (af * adY);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.ihW.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = af;
                bVar.ihW.setLayoutParams(layoutParams2);
            } else {
                bVar.ihW.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hPK) {
            bVar.hRn.setOnClickListener(null);
        } else {
            bVar.hRn.setOnClickListener(this.mCommonClickListener);
        }
        bVar.hRn.setTextViewCheckSelection(false);
        bVar.hRn.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().ly(this.ihU - (i - this.ihT));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.hRn.setOnLongClickListener(this.cnB);
        bVar.hRn.setOnTouchListener(this.cmw);
        bVar.hRn.setOnImageClickListener(this.cLe);
        bVar.hRn.setOnEmotionClickListener(((PbActivity) this.hPu.getPageContext().getOrignalPage()).hNu.iaO);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(d dVar) {
        this.hPJ = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void xL(int i) {
        this.hPR = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void ok(boolean z) {
        this.hPK = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void ol(boolean z) {
        this.hPL = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void om(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void N(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cLe = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnB = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
