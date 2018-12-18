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
    private View.OnLongClickListener aTo;
    private TbRichTextView.h brM;
    private c brN;
    private d fVj;
    private boolean fVk;
    private boolean fVl;
    private int fVr;
    private final boolean fWA;
    private boolean fWz;
    private boolean giM;
    private int gmE;
    private int gmF;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fVr = 0;
        this.fVk = true;
        this.giM = true;
        this.fVj = null;
        this.fVl = true;
        this.mCommonClickListener = null;
        this.brM = null;
        this.brN = null;
        this.aTo = null;
        this.fWz = false;
        this.fWA = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        aq(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void aq(PbActivity pbActivity) {
        super.aq(pbActivity);
        if (pbActivity != null) {
            this.gmE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds30);
            this.gmF = l.aO(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(e.h.pb_interview_normal_item, viewGroup, false), this.giM, this.fVk, this.fVr, false);
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
            a(bVar.fWI, (int) this.mContext.getResources().getDimension(e.C0210e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fWI.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fWI.setLayoutParams(layoutParams);
            bVar.fWI.setPadding(0, 0, 0, 0);
            bVar.fWI.ja(null);
            postData.AD();
            if (postData.bDr() == 1) {
                bVar.gmJ.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zG() != null) {
                    j = postData.zG().getUserIdLong();
                    str = postData.zG().getUserName();
                    str2 = postData.zG().getName_show();
                }
                bVar.gmJ.a(postData.bDz(), str, str2, j, com.baidu.adp.lib.g.b.d(this.fVj.bgj().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                bVar.gmJ.onChangeSkinType();
                if (this.fVl) {
                    PraiseData zt = this.fVj.bgj().zt();
                    if (zt != null && zt.getUser() != null && zt.getUser().size() > 0) {
                        bVar.gmK.setVisibility(0);
                        bVar.gmI.setVisibility(0);
                        bVar.gmL.setVisibility(0);
                        bVar.gmK.setIsFromPb(true);
                        bVar.gmK.setData(zt, this.fVj.bgj().getId(), zt.getPostId(), true);
                        bVar.gmK.eC(this.mSkinType);
                    } else {
                        bVar.gmK.setVisibility(8);
                        bVar.gmI.setVisibility(8);
                        bVar.gmL.setVisibility(8);
                    }
                } else {
                    bVar.gmK.setVisibility(8);
                    bVar.gmI.setVisibility(8);
                    bVar.gmL.setVisibility(8);
                }
                bVar.gmK.setVisibility(0);
                bVar.gmI.setVisibility(0);
                bVar.gmL.setVisibility(0);
                a(bVar.fWI, (int) this.mContext.getResources().getDimension(e.C0210e.ds30));
            } else {
                bVar.gmJ.setVisibility(8);
            }
            bVar.fWI.getLayoutStrategy().gJ(e.f.pic_video);
            bVar.fWI.setTextColor(al.getColor(e.d.common_color_10039));
            bVar.fWI.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            bVar.fWI.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            if (this.fVk) {
                bVar.fWI.getLayoutStrategy().gM(e.f.transparent_bg);
            } else {
                bVar.fWI.getLayoutStrategy().gM(e.f.icon_click);
            }
            bVar.fWI.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bDt();
            }
            if (this.fWz || !this.fWA) {
                bVar.fWI.setText(tbRichText, false);
            } else {
                bVar.fWI.setText(tbRichText, true);
            }
            ba zn = this.fVj.bgj().zn();
            if (zn != null) {
                bVar.gmH.startLoad(this.fVj.bgj().zn().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int aO = l.aO(this.mContext);
                float zl = zn.zl() / zn.zk();
                if (zl > 1.0f) {
                    i = (int) (1.0f * aO);
                } else if (zl < 0.2f) {
                    i = (int) (aO * 0.2f);
                } else {
                    i = (int) (aO * zl);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.gmH.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = aO;
                bVar.gmH.setLayoutParams(layoutParams2);
            } else {
                bVar.gmH.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fVk) {
            bVar.fWI.setOnClickListener(null);
        } else {
            bVar.fWI.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fWI.setTextViewCheckSelection(false);
        bVar.fWI.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().gK(this.gmF - (i - this.gmE));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fWI.setOnLongClickListener(this.aTo);
        bVar.fWI.setOnTouchListener(this.brN);
        bVar.fWI.setOnImageClickListener(this.brM);
        bVar.fWI.setOnEmotionClickListener(((PbActivity) this.fUU.getPageContext().getOrignalPage()).fSY.ggo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(d dVar) {
        this.fVj = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.fVr = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kz(boolean z) {
        this.fVk = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kA(boolean z) {
        this.fVl = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kB(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void I(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.brM = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTo = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
