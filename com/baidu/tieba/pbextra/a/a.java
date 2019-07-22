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
    private TbRichTextView.h cKh;
    private c clt;
    private View.OnLongClickListener cmy;
    private d hMS;
    private boolean hMT;
    private boolean hMU;
    private int hNa;
    private boolean hOm;
    private final boolean hOn;
    private boolean iaN;
    private int ieS;
    private int ieT;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hNa = 0;
        this.hMT = true;
        this.iaN = true;
        this.hMS = null;
        this.hMU = true;
        this.mCommonClickListener = null;
        this.cKh = null;
        this.clt = null;
        this.cmy = null;
        this.hOm = false;
        this.hOn = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        au(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void au(PbActivity pbActivity) {
        super.au(pbActivity);
        if (pbActivity != null) {
            this.ieS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.ieT = l.af(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.iaN, this.hMT, this.hNa, false);
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
            a(bVar.hOw, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hOw.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.hOw.setLayoutParams(layoutParams);
            bVar.hOw.setPadding(0, 0, 0, 0);
            bVar.hOw.rC(null);
            postData.afB();
            if (postData.cpp() == 1) {
                bVar.ieX.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aex() != null) {
                    j = postData.aex().getUserIdLong();
                    str = postData.aex().getUserName();
                    str2 = postData.aex().getName_show();
                }
                bVar.ieX.a(postData.cpx(), str, str2, j, com.baidu.adp.lib.g.b.c(this.hMS.bSx().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.ieX.onChangeSkinType();
                if (this.hMU) {
                    PraiseData aej = this.hMS.bSx().aej();
                    if (aej != null && aej.getUser() != null && aej.getUser().size() > 0) {
                        bVar.ieY.setVisibility(0);
                        bVar.ieW.setVisibility(0);
                        bVar.ieZ.setVisibility(0);
                        bVar.ieY.setIsFromPb(true);
                        bVar.ieY.setData(aej, this.hMS.bSx().getId(), aej.getPostId(), true);
                        bVar.ieY.jc(this.mSkinType);
                    } else {
                        bVar.ieY.setVisibility(8);
                        bVar.ieW.setVisibility(8);
                        bVar.ieZ.setVisibility(8);
                    }
                } else {
                    bVar.ieY.setVisibility(8);
                    bVar.ieW.setVisibility(8);
                    bVar.ieZ.setVisibility(8);
                }
                bVar.ieY.setVisibility(0);
                bVar.ieW.setVisibility(0);
                bVar.ieZ.setVisibility(0);
                a(bVar.hOw, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.ieX.setVisibility(8);
            }
            bVar.hOw.getLayoutStrategy().ls(R.drawable.pic_video);
            bVar.hOw.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.hOw.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.hOw.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.hMT) {
                bVar.hOw.getLayoutStrategy().lv(R.drawable.transparent_bg);
            } else {
                bVar.hOw.getLayoutStrategy().lv(R.drawable.icon_click);
            }
            bVar.hOw.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cpr();
            }
            if (this.hOm || !this.hOn) {
                bVar.hOw.setText(tbRichText, false);
            } else {
                bVar.hOw.setText(tbRichText, true);
            }
            be aed = this.hMS.bSx().aed();
            if (aed != null) {
                bVar.ieV.startLoad(this.hMS.bSx().aed().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int af = l.af(this.mContext);
                float adT = aed.adT() / aed.adS();
                if (adT > 1.0f) {
                    i = (int) (1.0f * af);
                } else if (adT < 0.2f) {
                    i = (int) (af * 0.2f);
                } else {
                    i = (int) (af * adT);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.ieV.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = af;
                bVar.ieV.setLayoutParams(layoutParams2);
            } else {
                bVar.ieV.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hMT) {
            bVar.hOw.setOnClickListener(null);
        } else {
            bVar.hOw.setOnClickListener(this.mCommonClickListener);
        }
        bVar.hOw.setTextViewCheckSelection(false);
        bVar.hOw.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().lt(this.ieT - (i - this.ieS));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.hOw.setOnLongClickListener(this.cmy);
        bVar.hOw.setOnTouchListener(this.clt);
        bVar.hOw.setOnImageClickListener(this.cKh);
        bVar.hOw.setOnEmotionClickListener(((PbActivity) this.hMD.getPageContext().getOrignalPage()).hKD.hXV);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(d dVar) {
        this.hMS = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void xG(int i) {
        this.hNa = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void og(boolean z) {
        this.hMT = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void oh(boolean z) {
        this.hMU = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void oi(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void N(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cKh = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmy = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
