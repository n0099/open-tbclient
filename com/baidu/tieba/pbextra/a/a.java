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
    private View.OnLongClickListener aTr;
    private TbRichTextView.h brP;
    private c brQ;
    private d fYb;
    private boolean fYc;
    private boolean fYd;
    private int fYj;
    private boolean fZr;
    private final boolean fZs;
    private boolean glD;
    private int gpv;
    private int gpw;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fYj = 0;
        this.fYc = true;
        this.glD = true;
        this.fYb = null;
        this.fYd = true;
        this.mCommonClickListener = null;
        this.brP = null;
        this.brQ = null;
        this.aTr = null;
        this.fZr = false;
        this.fZs = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        aq(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void aq(PbActivity pbActivity) {
        super.aq(pbActivity);
        if (pbActivity != null) {
            this.gpv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds30);
            this.gpw = l.aO(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(e.h.pb_interview_normal_item, viewGroup, false), this.glD, this.fYc, this.fYj, false);
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
            a(bVar.fZA, (int) this.mContext.getResources().getDimension(e.C0210e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fZA.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fZA.setLayoutParams(layoutParams);
            bVar.fZA.setPadding(0, 0, 0, 0);
            bVar.fZA.jb(null);
            postData.AD();
            if (postData.bEj() == 1) {
                bVar.gpA.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zG() != null) {
                    j = postData.zG().getUserIdLong();
                    str = postData.zG().getUserName();
                    str2 = postData.zG().getName_show();
                }
                bVar.gpA.a(postData.bEr(), str, str2, j, com.baidu.adp.lib.g.b.d(this.fYb.bgV().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                bVar.gpA.onChangeSkinType();
                if (this.fYd) {
                    PraiseData zt = this.fYb.bgV().zt();
                    if (zt != null && zt.getUser() != null && zt.getUser().size() > 0) {
                        bVar.gpB.setVisibility(0);
                        bVar.gpz.setVisibility(0);
                        bVar.gpC.setVisibility(0);
                        bVar.gpB.setIsFromPb(true);
                        bVar.gpB.setData(zt, this.fYb.bgV().getId(), zt.getPostId(), true);
                        bVar.gpB.eD(this.mSkinType);
                    } else {
                        bVar.gpB.setVisibility(8);
                        bVar.gpz.setVisibility(8);
                        bVar.gpC.setVisibility(8);
                    }
                } else {
                    bVar.gpB.setVisibility(8);
                    bVar.gpz.setVisibility(8);
                    bVar.gpC.setVisibility(8);
                }
                bVar.gpB.setVisibility(0);
                bVar.gpz.setVisibility(0);
                bVar.gpC.setVisibility(0);
                a(bVar.fZA, (int) this.mContext.getResources().getDimension(e.C0210e.ds30));
            } else {
                bVar.gpA.setVisibility(8);
            }
            bVar.fZA.getLayoutStrategy().gK(e.f.pic_video);
            bVar.fZA.setTextColor(al.getColor(e.d.common_color_10039));
            bVar.fZA.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            bVar.fZA.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            if (this.fYc) {
                bVar.fZA.getLayoutStrategy().gN(e.f.transparent_bg);
            } else {
                bVar.fZA.getLayoutStrategy().gN(e.f.icon_click);
            }
            bVar.fZA.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bEl();
            }
            if (this.fZr || !this.fZs) {
                bVar.fZA.setText(tbRichText, false);
            } else {
                bVar.fZA.setText(tbRichText, true);
            }
            ba zn = this.fYb.bgV().zn();
            if (zn != null) {
                bVar.gpy.startLoad(this.fYb.bgV().zn().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int aO = l.aO(this.mContext);
                float zl = zn.zl() / zn.zk();
                if (zl > 1.0f) {
                    i = (int) (1.0f * aO);
                } else if (zl < 0.2f) {
                    i = (int) (aO * 0.2f);
                } else {
                    i = (int) (aO * zl);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.gpy.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = aO;
                bVar.gpy.setLayoutParams(layoutParams2);
            } else {
                bVar.gpy.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fYc) {
            bVar.fZA.setOnClickListener(null);
        } else {
            bVar.fZA.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fZA.setTextViewCheckSelection(false);
        bVar.fZA.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().gL(this.gpw - (i - this.gpv));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fZA.setOnLongClickListener(this.aTr);
        bVar.fZA.setOnTouchListener(this.brQ);
        bVar.fZA.setOnImageClickListener(this.brP);
        bVar.fZA.setOnEmotionClickListener(((PbActivity) this.fXM.getPageContext().getOrignalPage()).fVQ.gjh);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(d dVar) {
        this.fYb = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.fYj = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kC(boolean z) {
        this.fYc = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kD(boolean z) {
        this.fYd = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kE(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void I(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.brP = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTr = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
