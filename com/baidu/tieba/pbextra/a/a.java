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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class a extends k<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnLongClickListener aUa;
    private TbRichTextView.h bsE;
    private c bsF;
    private d fYZ;
    private boolean fZa;
    private boolean fZb;
    private int fZh;
    private boolean gap;
    private final boolean gaq;
    private boolean gmH;
    private int gqA;
    private int gqB;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fZh = 0;
        this.fZa = true;
        this.gmH = true;
        this.fYZ = null;
        this.fZb = true;
        this.mCommonClickListener = null;
        this.bsE = null;
        this.bsF = null;
        this.aUa = null;
        this.gap = false;
        this.gaq = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        aq(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void aq(PbActivity pbActivity) {
        super.aq(pbActivity);
        if (pbActivity != null) {
            this.gqA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds30);
            this.gqB = l.aO(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(e.h.pb_interview_normal_item, viewGroup, false), this.gmH, this.fZa, this.fZh, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, bVar);
        al.j(view, e.d.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.gay, (int) this.mContext.getResources().getDimension(e.C0210e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gay.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.gay.setLayoutParams(layoutParams);
            bVar.gay.setPadding(0, 0, 0, 0);
            bVar.gay.jr(null);
            postData.AQ();
            if (postData.bES() == 1) {
                bVar.gqF.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zT() != null) {
                    j = postData.zT().getUserIdLong();
                    str = postData.zT().getUserName();
                    str2 = postData.zT().getName_show();
                }
                bVar.gqF.a(postData.bFa(), str, str2, j, com.baidu.adp.lib.g.b.d(this.fYZ.bhz().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                bVar.gqF.onChangeSkinType();
                if (this.fZb) {
                    PraiseData zG = this.fYZ.bhz().zG();
                    if (zG != null && zG.getUser() != null && zG.getUser().size() > 0) {
                        bVar.gqG.setVisibility(0);
                        bVar.gqE.setVisibility(0);
                        bVar.gqH.setVisibility(0);
                        bVar.gqG.setIsFromPb(true);
                        bVar.gqG.setData(zG, this.fYZ.bhz().getId(), zG.getPostId(), true);
                        bVar.gqG.eD(this.mSkinType);
                    } else {
                        bVar.gqG.setVisibility(8);
                        bVar.gqE.setVisibility(8);
                        bVar.gqH.setVisibility(8);
                    }
                } else {
                    bVar.gqG.setVisibility(8);
                    bVar.gqE.setVisibility(8);
                    bVar.gqH.setVisibility(8);
                }
                bVar.gqG.setVisibility(0);
                bVar.gqE.setVisibility(0);
                bVar.gqH.setVisibility(0);
                a(bVar.gay, (int) this.mContext.getResources().getDimension(e.C0210e.ds30));
            } else {
                bVar.gqF.setVisibility(8);
            }
            bVar.gay.getLayoutStrategy().gK(e.f.pic_video);
            bVar.gay.setTextColor(al.getColor(e.d.common_color_10039));
            bVar.gay.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            bVar.gay.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            if (this.fZa) {
                bVar.gay.getLayoutStrategy().gN(e.f.transparent_bg);
            } else {
                bVar.gay.getLayoutStrategy().gN(e.f.icon_click);
            }
            bVar.gay.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bEU();
            }
            if (this.gap || !this.gaq) {
                bVar.gay.setText(tbRichText, false);
            } else {
                bVar.gay.setText(tbRichText, true);
            }
            ba zA = this.fYZ.bhz().zA();
            if (zA != null) {
                bVar.gqD.startLoad(this.fYZ.bhz().zA().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int aO = l.aO(this.mContext);
                float zy = zA.zy() / zA.zx();
                if (zy > 1.0f) {
                    i = (int) (1.0f * aO);
                } else if (zy < 0.2f) {
                    i = (int) (aO * 0.2f);
                } else {
                    i = (int) (aO * zy);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.gqD.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = aO;
                bVar.gqD.setLayoutParams(layoutParams2);
            } else {
                bVar.gqD.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fZa) {
            bVar.gay.setOnClickListener(null);
        } else {
            bVar.gay.setOnClickListener(this.mCommonClickListener);
        }
        bVar.gay.setTextViewCheckSelection(false);
        bVar.gay.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().gL(this.gqB - (i - this.gqA));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.gay.setOnLongClickListener(this.aUa);
        bVar.gay.setOnTouchListener(this.bsF);
        bVar.gay.setOnImageClickListener(this.bsE);
        bVar.gay.setOnEmotionClickListener(((PbActivity) this.fYK.getPageContext().getOrignalPage()).fWO.gkl);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(d dVar) {
        this.fYZ = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.fZh = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kC(boolean z) {
        this.fZa = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kD(boolean z) {
        this.fZb = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kE(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void I(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bsE = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aUa = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
