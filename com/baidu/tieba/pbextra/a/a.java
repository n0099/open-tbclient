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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class a extends k<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnLongClickListener aHk;
    private TbRichTextView.h bfR;
    private c bfS;
    private boolean fLk;
    private int fPx;
    private int fPy;
    private int fxE;
    private d fxw;
    private boolean fxx;
    private boolean fxy;
    private boolean fyS;
    private final boolean fyT;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fxE = 0;
        this.fxx = true;
        this.fLk = true;
        this.fxw = null;
        this.fxy = true;
        this.mCommonClickListener = null;
        this.bfR = null;
        this.bfS = null;
        this.aHk = null;
        this.fyS = false;
        this.fyT = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        ap(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void ap(PbActivity pbActivity) {
        super.ap(pbActivity);
        if (pbActivity != null) {
            this.fPx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds30);
            this.fPy = l.ah(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bu */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(d.i.pb_interview_normal_item, viewGroup, false), this.fLk, this.fxx, this.fxE, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, bVar);
        am.j(view, d.C0142d.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.fza, (int) this.mContext.getResources().getDimension(d.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fza.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fza.setLayoutParams(layoutParams);
            bVar.fza.setPadding(0, 0, 0, 0);
            bVar.fza.hX(null);
            postData.wq();
            if (postData.bxC() == 1) {
                bVar.fPC.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.vw() != null) {
                    j = postData.vw().getUserIdLong();
                    str = postData.vw().getUserName();
                    str2 = postData.vw().getName_show();
                }
                bVar.fPC.a(postData.bxK(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fxw.baV().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.fPC.onChangeSkinType();
                if (this.fxy) {
                    PraiseData vj = this.fxw.baV().vj();
                    if (vj != null && vj.getUser() != null && vj.getUser().size() > 0) {
                        bVar.fPD.setVisibility(0);
                        bVar.fPB.setVisibility(0);
                        bVar.fPE.setVisibility(0);
                        bVar.fPD.setIsFromPb(true);
                        bVar.fPD.setData(vj, this.fxw.baV().getId(), vj.getPostId(), true);
                        bVar.fPD.dD(this.mSkinType);
                    } else {
                        bVar.fPD.setVisibility(8);
                        bVar.fPB.setVisibility(8);
                        bVar.fPE.setVisibility(8);
                    }
                } else {
                    bVar.fPD.setVisibility(8);
                    bVar.fPB.setVisibility(8);
                    bVar.fPE.setVisibility(8);
                }
                bVar.fPD.setVisibility(0);
                bVar.fPB.setVisibility(0);
                bVar.fPE.setVisibility(0);
                a(bVar.fza, (int) this.mContext.getResources().getDimension(d.e.ds30));
            } else {
                bVar.fPC.setVisibility(8);
            }
            bVar.fza.getLayoutStrategy().fN(d.f.pic_video);
            bVar.fza.setTextColor(am.getColor(d.C0142d.common_color_10039));
            bVar.fza.setLinkTextColor(am.getColor(d.C0142d.cp_link_tip_c));
            bVar.fza.setLinkTextColor(am.getColor(d.C0142d.cp_link_tip_c));
            if (this.fxx) {
                bVar.fza.getLayoutStrategy().fQ(d.f.transparent_bg);
            } else {
                bVar.fza.getLayoutStrategy().fQ(d.f.icon_click);
            }
            bVar.fza.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bxE();
            }
            if (this.fyS || !this.fyT) {
                bVar.fza.setText(tbRichText, false);
            } else {
                bVar.fza.setText(tbRichText, true);
            }
            bb vd = this.fxw.baV().vd();
            if (vd != null) {
                bVar.fPA.startLoad(this.fxw.baV().vd().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int ah = l.ah(this.mContext);
                float vb = vd.vb() / vd.va();
                if (vb > 1.0f) {
                    i = (int) (1.0f * ah);
                } else if (vb < 0.2f) {
                    i = (int) (ah * 0.2f);
                } else {
                    i = (int) (ah * vb);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fPA.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = ah;
                bVar.fPA.setLayoutParams(layoutParams2);
            } else {
                bVar.fPA.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fxx) {
            bVar.fza.setOnClickListener(null);
        } else {
            bVar.fza.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fza.setTextViewCheckSelection(false);
        bVar.fza.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().fO(this.fPy - (i - this.fPx));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fza.setOnLongClickListener(this.aHk);
        bVar.fza.setOnTouchListener(this.bfS);
        bVar.fza.setOnImageClickListener(this.bfR);
        bVar.fza.setOnEmotionClickListener(((PbActivity) this.fxh.getPageContext().getOrignalPage()).fvk.fIJ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fxw = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void qs(int i) {
        this.fxE = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jH(boolean z) {
        this.fxx = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jI(boolean z) {
        this.fxy = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jJ(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void I(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bfR = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHk = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
