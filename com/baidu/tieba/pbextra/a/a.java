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
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class a extends k<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnLongClickListener aHj;
    private TbRichTextView.h bge;
    private c bgf;
    private boolean fLr;
    private int fPA;
    private int fPz;
    private d fxB;
    private boolean fxC;
    private boolean fxD;
    private int fxJ;
    private boolean fyX;
    private final boolean fyY;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fxJ = 0;
        this.fxC = true;
        this.fLr = true;
        this.fxB = null;
        this.fxD = true;
        this.mCommonClickListener = null;
        this.bge = null;
        this.bgf = null;
        this.aHj = null;
        this.fyX = false;
        this.fyY = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        ap(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void ap(PbActivity pbActivity) {
        super.ap(pbActivity);
        if (pbActivity != null) {
            this.fPz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds30);
            this.fPA = l.ah(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(f.h.pb_interview_normal_item, viewGroup, false), this.fLr, this.fxC, this.fxJ, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, bVar);
        am.j(view, f.d.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.fzf, (int) this.mContext.getResources().getDimension(f.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fzf.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fzf.setLayoutParams(layoutParams);
            bVar.fzf.setPadding(0, 0, 0, 0);
            bVar.fzf.hV(null);
            postData.we();
            if (postData.bwg() == 1) {
                bVar.fPE.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.vj() != null) {
                    j = postData.vj().getUserIdLong();
                    str = postData.vj().getUserName();
                    str2 = postData.vj().getName_show();
                }
                bVar.fPE.a(postData.bwo(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fxB.aZi().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.fPE.onChangeSkinType();
                if (this.fxD) {
                    PraiseData uW = this.fxB.aZi().uW();
                    if (uW != null && uW.getUser() != null && uW.getUser().size() > 0) {
                        bVar.fPF.setVisibility(0);
                        bVar.fPD.setVisibility(0);
                        bVar.fPG.setVisibility(0);
                        bVar.fPF.setIsFromPb(true);
                        bVar.fPF.setData(uW, this.fxB.aZi().getId(), uW.getPostId(), true);
                        bVar.fPF.dF(this.mSkinType);
                    } else {
                        bVar.fPF.setVisibility(8);
                        bVar.fPD.setVisibility(8);
                        bVar.fPG.setVisibility(8);
                    }
                } else {
                    bVar.fPF.setVisibility(8);
                    bVar.fPD.setVisibility(8);
                    bVar.fPG.setVisibility(8);
                }
                bVar.fPF.setVisibility(0);
                bVar.fPD.setVisibility(0);
                bVar.fPG.setVisibility(0);
                a(bVar.fzf, (int) this.mContext.getResources().getDimension(f.e.ds30));
            } else {
                bVar.fPE.setVisibility(8);
            }
            bVar.fzf.getLayoutStrategy().fN(f.C0146f.pic_video);
            bVar.fzf.setTextColor(am.getColor(f.d.common_color_10039));
            bVar.fzf.setLinkTextColor(am.getColor(f.d.cp_link_tip_c));
            bVar.fzf.setLinkTextColor(am.getColor(f.d.cp_link_tip_c));
            if (this.fxC) {
                bVar.fzf.getLayoutStrategy().fQ(f.C0146f.transparent_bg);
            } else {
                bVar.fzf.getLayoutStrategy().fQ(f.C0146f.icon_click);
            }
            bVar.fzf.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bwi();
            }
            if (this.fyX || !this.fyY) {
                bVar.fzf.setText(tbRichText, false);
            } else {
                bVar.fzf.setText(tbRichText, true);
            }
            ba uQ = this.fxB.aZi().uQ();
            if (uQ != null) {
                bVar.fPC.startLoad(this.fxB.aZi().uQ().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int ah = l.ah(this.mContext);
                float uO = uQ.uO() / uQ.uN();
                if (uO > 1.0f) {
                    i = (int) (1.0f * ah);
                } else if (uO < 0.2f) {
                    i = (int) (ah * 0.2f);
                } else {
                    i = (int) (ah * uO);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fPC.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = ah;
                bVar.fPC.setLayoutParams(layoutParams2);
            } else {
                bVar.fPC.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fxC) {
            bVar.fzf.setOnClickListener(null);
        } else {
            bVar.fzf.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fzf.setTextViewCheckSelection(false);
        bVar.fzf.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().fO(this.fPA - (i - this.fPz));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fzf.setOnLongClickListener(this.aHj);
        bVar.fzf.setOnTouchListener(this.bgf);
        bVar.fzf.setOnImageClickListener(this.bge);
        bVar.fzf.setOnEmotionClickListener(((PbActivity) this.fxm.getPageContext().getOrignalPage()).fvp.fIR);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(d dVar) {
        this.fxB = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void qp(int i) {
        this.fxJ = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jt(boolean z) {
        this.fxC = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void ju(boolean z) {
        this.fxD = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jv(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void G(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bge = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHj = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
