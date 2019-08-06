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
    private TbRichTextView.h cKo;
    private c clA;
    private View.OnLongClickListener cmF;
    private d hNM;
    private boolean hNN;
    private boolean hNO;
    private int hNU;
    private boolean hPg;
    private final boolean hPh;
    private boolean ibK;
    private int ifU;
    private int ifV;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hNU = 0;
        this.hNN = true;
        this.ibK = true;
        this.hNM = null;
        this.hNO = true;
        this.mCommonClickListener = null;
        this.cKo = null;
        this.clA = null;
        this.cmF = null;
        this.hPg = false;
        this.hPh = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        av(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void av(PbActivity pbActivity) {
        super.av(pbActivity);
        if (pbActivity != null) {
            this.ifU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.ifV = l.af(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.ibK, this.hNN, this.hNU, false);
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
            a(bVar.hPq, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hPq.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.hPq.setLayoutParams(layoutParams);
            bVar.hPq.setPadding(0, 0, 0, 0);
            bVar.hPq.rC(null);
            postData.afC();
            if (postData.cpL() == 1) {
                bVar.ifZ.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aey() != null) {
                    j = postData.aey().getUserIdLong();
                    str = postData.aey().getUserName();
                    str2 = postData.aey().getName_show();
                }
                bVar.ifZ.a(postData.cpT(), str, str2, j, com.baidu.adp.lib.g.b.c(this.hNM.bSL().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.ifZ.onChangeSkinType();
                if (this.hNO) {
                    PraiseData aek = this.hNM.bSL().aek();
                    if (aek != null && aek.getUser() != null && aek.getUser().size() > 0) {
                        bVar.iga.setVisibility(0);
                        bVar.ifY.setVisibility(0);
                        bVar.igb.setVisibility(0);
                        bVar.iga.setIsFromPb(true);
                        bVar.iga.setData(aek, this.hNM.bSL().getId(), aek.getPostId(), true);
                        bVar.iga.jd(this.mSkinType);
                    } else {
                        bVar.iga.setVisibility(8);
                        bVar.ifY.setVisibility(8);
                        bVar.igb.setVisibility(8);
                    }
                } else {
                    bVar.iga.setVisibility(8);
                    bVar.ifY.setVisibility(8);
                    bVar.igb.setVisibility(8);
                }
                bVar.iga.setVisibility(0);
                bVar.ifY.setVisibility(0);
                bVar.igb.setVisibility(0);
                a(bVar.hPq, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.ifZ.setVisibility(8);
            }
            bVar.hPq.getLayoutStrategy().lt(R.drawable.pic_video);
            bVar.hPq.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.hPq.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.hPq.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.hNN) {
                bVar.hPq.getLayoutStrategy().lw(R.drawable.transparent_bg);
            } else {
                bVar.hPq.getLayoutStrategy().lw(R.drawable.icon_click);
            }
            bVar.hPq.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cpN();
            }
            if (this.hPg || !this.hPh) {
                bVar.hPq.setText(tbRichText, false);
            } else {
                bVar.hPq.setText(tbRichText, true);
            }
            bf aee = this.hNM.bSL().aee();
            if (aee != null) {
                bVar.ifX.startLoad(this.hNM.bSL().aee().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int af = l.af(this.mContext);
                float adU = aee.adU() / aee.adT();
                if (adU > 1.0f) {
                    i = (int) (1.0f * af);
                } else if (adU < 0.2f) {
                    i = (int) (af * 0.2f);
                } else {
                    i = (int) (af * adU);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.ifX.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = af;
                bVar.ifX.setLayoutParams(layoutParams2);
            } else {
                bVar.ifX.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hNN) {
            bVar.hPq.setOnClickListener(null);
        } else {
            bVar.hPq.setOnClickListener(this.mCommonClickListener);
        }
        bVar.hPq.setTextViewCheckSelection(false);
        bVar.hPq.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().lu(this.ifV - (i - this.ifU));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.hPq.setOnLongClickListener(this.cmF);
        bVar.hPq.setOnTouchListener(this.clA);
        bVar.hPq.setOnImageClickListener(this.cKo);
        bVar.hPq.setOnEmotionClickListener(((PbActivity) this.hNx.getPageContext().getOrignalPage()).hLx.hYR);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(d dVar) {
        this.hNM = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void xI(int i) {
        this.hNU = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void og(boolean z) {
        this.hNN = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void oh(boolean z) {
        this.hNO = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void oi(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void N(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cKo = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmF = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void v(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
