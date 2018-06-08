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
import com.baidu.tbadk.core.util.al;
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
    private View.OnLongClickListener aGs;
    private TbRichTextView.h beD;
    private c beE;
    private boolean fHj;
    private int fLv;
    private int fLw;
    private d ftE;
    private boolean ftF;
    private boolean ftG;
    private int ftM;
    private boolean fvb;
    private final boolean fvc;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.ftM = 0;
        this.ftF = true;
        this.fHj = true;
        this.ftE = null;
        this.ftG = true;
        this.mCommonClickListener = null;
        this.beD = null;
        this.beE = null;
        this.aGs = null;
        this.fvb = false;
        this.fvc = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        ap(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void ap(PbActivity pbActivity) {
        super.ap(pbActivity);
        if (pbActivity != null) {
            this.fLv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds30);
            this.fLw = l.ah(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(d.i.pb_interview_normal_item, viewGroup, false), this.fHj, this.ftF, this.ftM, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, bVar);
        al.j(view, d.C0141d.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.fvm, (int) this.mContext.getResources().getDimension(d.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fvm.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fvm.setLayoutParams(layoutParams);
            bVar.fvm.setPadding(0, 0, 0, 0);
            bVar.fvm.hT(null);
            postData.wg();
            if (postData.bwZ() == 1) {
                bVar.fvn.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.vm() != null) {
                    j = postData.vm().getUserIdLong();
                    str = postData.vm().getUserName();
                    str2 = postData.vm().getName_show();
                }
                bVar.fvn.a(postData.bxh(), str, str2, j, com.baidu.adp.lib.g.b.c(this.ftE.bao().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.fvn.onChangeSkinType();
                if (this.ftG) {
                    PraiseData va = this.ftE.bao().va();
                    if (va != null && va.getUser() != null && va.getUser().size() > 0) {
                        bVar.fLA.setVisibility(0);
                        bVar.fLz.setVisibility(0);
                        bVar.fLB.setVisibility(0);
                        bVar.fLA.setIsFromPb(true);
                        bVar.fLA.setData(va, this.ftE.bao().getId(), va.getPostId(), true);
                        bVar.fLA.dC(this.mSkinType);
                    } else {
                        bVar.fLA.setVisibility(8);
                        bVar.fLz.setVisibility(8);
                        bVar.fLB.setVisibility(8);
                    }
                } else {
                    bVar.fLA.setVisibility(8);
                    bVar.fLz.setVisibility(8);
                    bVar.fLB.setVisibility(8);
                }
                bVar.fLA.setVisibility(0);
                bVar.fLz.setVisibility(0);
                bVar.fLB.setVisibility(0);
                a(bVar.fvm, (int) this.mContext.getResources().getDimension(d.e.ds30));
            } else {
                bVar.fvn.setVisibility(8);
            }
            bVar.fvm.getLayoutStrategy().fM(d.f.pic_video);
            bVar.fvm.setTextColor(al.getColor(d.C0141d.common_color_10039));
            bVar.fvm.setLinkTextColor(al.getColor(d.C0141d.cp_link_tip_c));
            bVar.fvm.setLinkTextColor(al.getColor(d.C0141d.cp_link_tip_c));
            if (this.ftF) {
                bVar.fvm.getLayoutStrategy().fP(d.f.transparent_bg);
            } else {
                bVar.fvm.getLayoutStrategy().fP(d.f.icon_click);
            }
            bVar.fvm.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bxb();
            }
            if (this.fvb || !this.fvc) {
                bVar.fvm.setText(tbRichText, false);
            } else {
                bVar.fvm.setText(tbRichText, true);
            }
            bb uV = this.ftE.bao().uV();
            if (uV != null) {
                bVar.fLy.startLoad(this.ftE.bao().uV().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int ah = l.ah(this.mContext);
                float uT = uV.uT() / uV.uS();
                if (uT > 1.0f) {
                    i = (int) (1.0f * ah);
                } else if (uT < 0.2f) {
                    i = (int) (ah * 0.2f);
                } else {
                    i = (int) (ah * uT);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fLy.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = ah;
                bVar.fLy.setLayoutParams(layoutParams2);
            } else {
                bVar.fLy.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.ftF) {
            bVar.fvm.setOnClickListener(null);
        } else {
            bVar.fvm.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fvm.setTextViewCheckSelection(false);
        bVar.fvm.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().fN(this.fLw - (i - this.fLv));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fvm.setOnLongClickListener(this.aGs);
        bVar.fvm.setOnTouchListener(this.beE);
        bVar.fvm.setOnImageClickListener(this.beD);
        bVar.fvm.setOnEmotionClickListener(((PbActivity) this.ftp.getPageContext().getOrignalPage()).frr.fEI);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.ftE = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void ql(int i) {
        this.ftM = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jx(boolean z) {
        this.ftF = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jy(boolean z) {
        this.ftG = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jz(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void F(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.beD = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aGs = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void n(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
