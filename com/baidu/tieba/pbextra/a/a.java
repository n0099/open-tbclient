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
    private View.OnLongClickListener aOZ;
    private TbRichTextView.h bnD;
    private c bnE;
    private d fMT;
    private boolean fMU;
    private boolean fMV;
    private int fNb;
    private boolean fOj;
    private final boolean fOk;
    private boolean gax;
    private int geq;
    private int ger;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fNb = 0;
        this.fMU = true;
        this.gax = true;
        this.fMT = null;
        this.fMV = true;
        this.mCommonClickListener = null;
        this.bnD = null;
        this.bnE = null;
        this.aOZ = null;
        this.fOj = false;
        this.fOk = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        ap(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void ap(PbActivity pbActivity) {
        super.ap(pbActivity);
        if (pbActivity != null) {
            this.geq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds30);
            this.ger = l.aO(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bu */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(e.h.pb_interview_normal_item, viewGroup, false), this.gax, this.fMU, this.fNb, false);
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
            a(bVar.fOs, (int) this.mContext.getResources().getDimension(e.C0175e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fOs.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fOs.setLayoutParams(layoutParams);
            bVar.fOs.setPadding(0, 0, 0, 0);
            bVar.fOs.iG(null);
            postData.zs();
            if (postData.bCb() == 1) {
                bVar.gev.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.yv() != null) {
                    j = postData.yv().getUserIdLong();
                    str = postData.yv().getUserName();
                    str2 = postData.yv().getName_show();
                }
                bVar.gev.a(postData.bCj(), str, str2, j, com.baidu.adp.lib.g.b.d(this.fMT.beV().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                bVar.gev.onChangeSkinType();
                if (this.fMV) {
                    PraiseData yi = this.fMT.beV().yi();
                    if (yi != null && yi.getUser() != null && yi.getUser().size() > 0) {
                        bVar.gew.setVisibility(0);
                        bVar.geu.setVisibility(0);
                        bVar.gex.setVisibility(0);
                        bVar.gew.setIsFromPb(true);
                        bVar.gew.setData(yi, this.fMT.beV().getId(), yi.getPostId(), true);
                        bVar.gew.ea(this.mSkinType);
                    } else {
                        bVar.gew.setVisibility(8);
                        bVar.geu.setVisibility(8);
                        bVar.gex.setVisibility(8);
                    }
                } else {
                    bVar.gew.setVisibility(8);
                    bVar.geu.setVisibility(8);
                    bVar.gex.setVisibility(8);
                }
                bVar.gew.setVisibility(0);
                bVar.geu.setVisibility(0);
                bVar.gex.setVisibility(0);
                a(bVar.fOs, (int) this.mContext.getResources().getDimension(e.C0175e.ds30));
            } else {
                bVar.gev.setVisibility(8);
            }
            bVar.fOs.getLayoutStrategy().gh(e.f.pic_video);
            bVar.fOs.setTextColor(al.getColor(e.d.common_color_10039));
            bVar.fOs.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            bVar.fOs.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            if (this.fMU) {
                bVar.fOs.getLayoutStrategy().gk(e.f.transparent_bg);
            } else {
                bVar.fOs.getLayoutStrategy().gk(e.f.icon_click);
            }
            bVar.fOs.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bCd();
            }
            if (this.fOj || !this.fOk) {
                bVar.fOs.setText(tbRichText, false);
            } else {
                bVar.fOs.setText(tbRichText, true);
            }
            ba yc = this.fMT.beV().yc();
            if (yc != null) {
                bVar.get.startLoad(this.fMT.beV().yc().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int aO = l.aO(this.mContext);
                float ya = yc.ya() / yc.xZ();
                if (ya > 1.0f) {
                    i = (int) (1.0f * aO);
                } else if (ya < 0.2f) {
                    i = (int) (aO * 0.2f);
                } else {
                    i = (int) (aO * ya);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.get.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = aO;
                bVar.get.setLayoutParams(layoutParams2);
            } else {
                bVar.get.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fMU) {
            bVar.fOs.setOnClickListener(null);
        } else {
            bVar.fOs.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fOs.setTextViewCheckSelection(false);
        bVar.fOs.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().gi(this.ger - (i - this.geq));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fOs.setOnLongClickListener(this.aOZ);
        bVar.fOs.setOnTouchListener(this.bnE);
        bVar.fOs.setOnImageClickListener(this.bnD);
        bVar.fOs.setOnEmotionClickListener(((PbActivity) this.fME.getPageContext().getOrignalPage()).fKI.fXX);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(d dVar) {
        this.fMT = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.fNb = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kl(boolean z) {
        this.fMU = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void km(boolean z) {
        this.fMV = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kn(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void G(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bnD = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aOZ = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
