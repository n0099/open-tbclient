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
import com.baidu.tbadk.core.util.aj;
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
    private TbRichTextView.h bLI;
    private c bLJ;
    private View.OnLongClickListener bmk;
    private int fIR;
    private boolean fIS;
    private boolean fIT;
    private d fIU;
    private boolean fIY;
    private final boolean fIZ;
    private int fJa;
    private int fJb;
    private boolean gaD;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fIR = 0;
        this.fIS = true;
        this.gaD = true;
        this.fIU = null;
        this.fIT = true;
        this.mCommonClickListener = null;
        this.bLI = null;
        this.bLJ = null;
        this.bmk = null;
        this.fIY = false;
        this.fIZ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        ao(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void ao(PbActivity pbActivity) {
        super.ao(pbActivity);
        if (pbActivity != null) {
            this.fJa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds30);
            this.fJb = l.ao(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(d.h.pb_interview_normal_item, viewGroup, false), this.gaD, this.fIS, this.fIR, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, bVar);
        aj.t(view, d.C0141d.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.fJr, (int) this.mContext.getResources().getDimension(d.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fJr.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fJr.setLayoutParams(layoutParams);
            bVar.fJr.setPadding(0, 0, 0, 0);
            bVar.fJr.hB(null);
            postData.Ai();
            if (postData.bwY() == 1) {
                bVar.fJu.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zn() != null) {
                    j = postData.zn().getUserIdLong();
                    str = postData.zn().getUserName();
                    str2 = postData.zn().getName_show();
                }
                bVar.fJu.a(postData.bxh(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fIU.bau().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.fJu.onChangeSkinType();
                if (this.fIT) {
                    PraiseData zc = this.fIU.bau().zc();
                    if (zc != null && zc.getUser() != null && zc.getUser().size() > 0) {
                        bVar.fJs.setVisibility(0);
                        bVar.geK.setVisibility(0);
                        bVar.fJt.setVisibility(0);
                        bVar.fJs.setIsFromPb(true);
                        bVar.fJs.a(zc, this.fIU.bau().getId(), zc.getPostId(), true);
                        bVar.fJs.gB(this.mSkinType);
                    } else {
                        bVar.fJs.setVisibility(8);
                        bVar.geK.setVisibility(8);
                        bVar.fJt.setVisibility(8);
                    }
                } else {
                    bVar.fJs.setVisibility(8);
                    bVar.geK.setVisibility(8);
                    bVar.fJt.setVisibility(8);
                }
                bVar.fJs.setVisibility(0);
                bVar.geK.setVisibility(0);
                bVar.fJt.setVisibility(0);
                a(bVar.fJr, (int) this.mContext.getResources().getDimension(d.e.ds30));
            } else {
                bVar.fJu.setVisibility(8);
            }
            bVar.fJr.getLayoutStrategy().iK(d.f.pic_video);
            bVar.fJr.setTextColor(aj.getColor(d.C0141d.common_color_10039));
            bVar.fJr.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
            bVar.fJr.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
            if (this.fIS) {
                bVar.fJr.getLayoutStrategy().iN(d.f.transparent_bg);
            } else {
                bVar.fJr.getLayoutStrategy().iN(d.f.icon_click);
            }
            bVar.fJr.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bxb();
            }
            if (this.fIY || !this.fIZ) {
                bVar.fJr.a(tbRichText, false);
            } else {
                bVar.fJr.a(tbRichText, true);
            }
            bb yV = this.fIU.bau().yV();
            if (yV != null) {
                bVar.geJ.startLoad(this.fIU.bau().yV().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int ao = l.ao(this.mContext);
                float yT = yV.yT() / yV.yS();
                if (yT > 1.0f) {
                    i = (int) (1.0f * ao);
                } else if (yT < 0.2f) {
                    i = (int) (ao * 0.2f);
                } else {
                    i = (int) (ao * yT);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.geJ.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = ao;
                bVar.geJ.setLayoutParams(layoutParams2);
            } else {
                bVar.geJ.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fIS) {
            bVar.fJr.setOnClickListener(null);
        } else {
            bVar.fJr.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fJr.setTextViewCheckSelection(false);
        bVar.fJr.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().iL(this.fJb - (i - this.fJa));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fJr.setOnLongClickListener(this.bmk);
        bVar.fJr.setOnTouchListener(this.bLJ);
        bVar.fJr.setOnImageClickListener(this.bLI);
        bVar.fJr.setOnEmotionClickListener(((PbActivity) this.fNg.getPageContext().getOrignalPage()).fLk.fYh);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fIU = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void sF(int i) {
        this.fIR = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jU(boolean z) {
        this.fIS = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jV(boolean z) {
        this.fIT = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jW(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void E(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLI = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmk = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
