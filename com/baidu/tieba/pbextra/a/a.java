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
    private TbRichTextView.h bLS;
    private c bLT;
    private View.OnLongClickListener bmu;
    private int fIM;
    private boolean fIN;
    private boolean fIO;
    private d fIP;
    private boolean fIT;
    private final boolean fIU;
    private int fIV;
    private int fIW;
    private boolean gay;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fIM = 0;
        this.fIN = true;
        this.gay = true;
        this.fIP = null;
        this.fIO = true;
        this.mCommonClickListener = null;
        this.bLS = null;
        this.bLT = null;
        this.bmu = null;
        this.fIT = false;
        this.fIU = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        ao(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void ao(PbActivity pbActivity) {
        super.ao(pbActivity);
        if (pbActivity != null) {
            this.fIV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds30);
            this.fIW = l.ao(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(d.h.pb_interview_normal_item, viewGroup, false), this.gay, this.fIN, this.fIM, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, bVar);
        aj.t(view, d.C0140d.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.fJm, (int) this.mContext.getResources().getDimension(d.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fJm.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fJm.setLayoutParams(layoutParams);
            bVar.fJm.setPadding(0, 0, 0, 0);
            bVar.fJm.hB(null);
            postData.Ai();
            if (postData.bwU() == 1) {
                bVar.fJp.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zn() != null) {
                    j = postData.zn().getUserIdLong();
                    str = postData.zn().getUserName();
                    str2 = postData.zn().getName_show();
                }
                bVar.fJp.a(postData.bxd(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fIP.bau().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.fJp.onChangeSkinType();
                if (this.fIO) {
                    PraiseData zc = this.fIP.bau().zc();
                    if (zc != null && zc.getUser() != null && zc.getUser().size() > 0) {
                        bVar.fJn.setVisibility(0);
                        bVar.geF.setVisibility(0);
                        bVar.fJo.setVisibility(0);
                        bVar.fJn.setIsFromPb(true);
                        bVar.fJn.a(zc, this.fIP.bau().getId(), zc.getPostId(), true);
                        bVar.fJn.gB(this.mSkinType);
                    } else {
                        bVar.fJn.setVisibility(8);
                        bVar.geF.setVisibility(8);
                        bVar.fJo.setVisibility(8);
                    }
                } else {
                    bVar.fJn.setVisibility(8);
                    bVar.geF.setVisibility(8);
                    bVar.fJo.setVisibility(8);
                }
                bVar.fJn.setVisibility(0);
                bVar.geF.setVisibility(0);
                bVar.fJo.setVisibility(0);
                a(bVar.fJm, (int) this.mContext.getResources().getDimension(d.e.ds30));
            } else {
                bVar.fJp.setVisibility(8);
            }
            bVar.fJm.getLayoutStrategy().iK(d.f.pic_video);
            bVar.fJm.setTextColor(aj.getColor(d.C0140d.common_color_10039));
            bVar.fJm.setLinkTextColor(aj.getColor(d.C0140d.cp_link_tip_c));
            bVar.fJm.setLinkTextColor(aj.getColor(d.C0140d.cp_link_tip_c));
            if (this.fIN) {
                bVar.fJm.getLayoutStrategy().iN(d.f.transparent_bg);
            } else {
                bVar.fJm.getLayoutStrategy().iN(d.f.icon_click);
            }
            bVar.fJm.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bwX();
            }
            if (this.fIT || !this.fIU) {
                bVar.fJm.a(tbRichText, false);
            } else {
                bVar.fJm.a(tbRichText, true);
            }
            bb yV = this.fIP.bau().yV();
            if (yV != null) {
                bVar.geE.startLoad(this.fIP.bau().yV().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int ao = l.ao(this.mContext);
                float yT = yV.yT() / yV.yS();
                if (yT > 1.0f) {
                    i = (int) (1.0f * ao);
                } else if (yT < 0.2f) {
                    i = (int) (ao * 0.2f);
                } else {
                    i = (int) (ao * yT);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.geE.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = ao;
                bVar.geE.setLayoutParams(layoutParams2);
            } else {
                bVar.geE.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fIN) {
            bVar.fJm.setOnClickListener(null);
        } else {
            bVar.fJm.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fJm.setTextViewCheckSelection(false);
        bVar.fJm.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().iL(this.fIW - (i - this.fIV));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fJm.setOnLongClickListener(this.bmu);
        bVar.fJm.setOnTouchListener(this.bLT);
        bVar.fJm.setOnImageClickListener(this.bLS);
        bVar.fJm.setOnEmotionClickListener(((PbActivity) this.fNb.getPageContext().getOrignalPage()).fLf.fYc);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fIP = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void sE(int i) {
        this.fIM = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jP(boolean z) {
        this.fIN = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jQ(boolean z) {
        this.fIO = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jR(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void E(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLS = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmu = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void l(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
