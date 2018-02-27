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
    private TbRichTextView.h bLF;
    private c bLG;
    private View.OnLongClickListener bmh;
    private int fIB;
    private boolean fIC;
    private boolean fID;
    private d fIE;
    private boolean fII;
    private final boolean fIJ;
    private int fIK;
    private int fIL;
    private boolean gan;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fIB = 0;
        this.fIC = true;
        this.gan = true;
        this.fIE = null;
        this.fID = true;
        this.mCommonClickListener = null;
        this.bLF = null;
        this.bLG = null;
        this.bmh = null;
        this.fII = false;
        this.fIJ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        ao(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void ao(PbActivity pbActivity) {
        super.ao(pbActivity);
        if (pbActivity != null) {
            this.fIK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds30);
            this.fIL = l.ao(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(d.h.pb_interview_normal_item, viewGroup, false), this.gan, this.fIC, this.fIB, false);
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
            a(bVar.fJb, (int) this.mContext.getResources().getDimension(d.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fJb.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fJb.setLayoutParams(layoutParams);
            bVar.fJb.setPadding(0, 0, 0, 0);
            bVar.fJb.hB(null);
            postData.Ai();
            if (postData.bwT() == 1) {
                bVar.fJe.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zn() != null) {
                    j = postData.zn().getUserIdLong();
                    str = postData.zn().getUserName();
                    str2 = postData.zn().getName_show();
                }
                bVar.fJe.a(postData.bxc(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fIE.bat().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.fJe.onChangeSkinType();
                if (this.fID) {
                    PraiseData zc = this.fIE.bat().zc();
                    if (zc != null && zc.getUser() != null && zc.getUser().size() > 0) {
                        bVar.fJc.setVisibility(0);
                        bVar.geu.setVisibility(0);
                        bVar.fJd.setVisibility(0);
                        bVar.fJc.setIsFromPb(true);
                        bVar.fJc.a(zc, this.fIE.bat().getId(), zc.getPostId(), true);
                        bVar.fJc.gB(this.mSkinType);
                    } else {
                        bVar.fJc.setVisibility(8);
                        bVar.geu.setVisibility(8);
                        bVar.fJd.setVisibility(8);
                    }
                } else {
                    bVar.fJc.setVisibility(8);
                    bVar.geu.setVisibility(8);
                    bVar.fJd.setVisibility(8);
                }
                bVar.fJc.setVisibility(0);
                bVar.geu.setVisibility(0);
                bVar.fJd.setVisibility(0);
                a(bVar.fJb, (int) this.mContext.getResources().getDimension(d.e.ds30));
            } else {
                bVar.fJe.setVisibility(8);
            }
            bVar.fJb.getLayoutStrategy().iK(d.f.pic_video);
            bVar.fJb.setTextColor(aj.getColor(d.C0141d.common_color_10039));
            bVar.fJb.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
            bVar.fJb.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
            if (this.fIC) {
                bVar.fJb.getLayoutStrategy().iN(d.f.transparent_bg);
            } else {
                bVar.fJb.getLayoutStrategy().iN(d.f.icon_click);
            }
            bVar.fJb.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bwW();
            }
            if (this.fII || !this.fIJ) {
                bVar.fJb.a(tbRichText, false);
            } else {
                bVar.fJb.a(tbRichText, true);
            }
            bb yV = this.fIE.bat().yV();
            if (yV != null) {
                bVar.get.startLoad(this.fIE.bat().yV().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int ao = l.ao(this.mContext);
                float yT = yV.yT() / yV.yS();
                if (yT > 1.0f) {
                    i = (int) (1.0f * ao);
                } else if (yT < 0.2f) {
                    i = (int) (ao * 0.2f);
                } else {
                    i = (int) (ao * yT);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.get.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = ao;
                bVar.get.setLayoutParams(layoutParams2);
            } else {
                bVar.get.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fIC) {
            bVar.fJb.setOnClickListener(null);
        } else {
            bVar.fJb.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fJb.setTextViewCheckSelection(false);
        bVar.fJb.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().iL(this.fIL - (i - this.fIK));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fJb.setOnLongClickListener(this.bmh);
        bVar.fJb.setOnTouchListener(this.bLG);
        bVar.fJb.setOnImageClickListener(this.bLF);
        bVar.fJb.setOnEmotionClickListener(((PbActivity) this.fMQ.getPageContext().getOrignalPage()).fKU.fXR);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fIE = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void sF(int i) {
        this.fIB = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jP(boolean z) {
        this.fIC = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jQ(boolean z) {
        this.fID = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jR(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void E(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLF = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmh = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
