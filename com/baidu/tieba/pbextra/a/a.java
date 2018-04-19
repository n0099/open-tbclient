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
import com.baidu.tbadk.core.util.ak;
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
    private TbRichTextView.h aWw;
    private c aWx;
    private View.OnLongClickListener axW;
    private d fhb;
    private boolean fhc;
    private boolean fhd;
    private int fhj;
    private boolean fiC;
    private final boolean fiD;
    private boolean fuL;
    private int fyX;
    private int fyY;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fhj = 0;
        this.fhc = true;
        this.fuL = true;
        this.fhb = null;
        this.fhd = true;
        this.mCommonClickListener = null;
        this.aWw = null;
        this.aWx = null;
        this.axW = null;
        this.fiC = false;
        this.fiD = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        aq(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void aq(PbActivity pbActivity) {
        super.aq(pbActivity);
        if (pbActivity != null) {
            this.fyX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds30);
            this.fyY = l.af(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(d.i.pb_interview_normal_item, viewGroup, false), this.fuL, this.fhc, this.fhj, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view2, viewGroup, postData, bVar);
        ak.j(view2, d.C0126d.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view2;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.fiN, (int) this.mContext.getResources().getDimension(d.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fiN.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fiN.setLayoutParams(layoutParams);
            bVar.fiN.setPadding(0, 0, 0, 0);
            bVar.fiN.hu(null);
            postData.sK();
            if (postData.brZ() == 1) {
                bVar.fiO.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rQ() != null) {
                    j = postData.rQ().getUserIdLong();
                    str = postData.rQ().getUserName();
                    str2 = postData.rQ().getName_show();
                }
                bVar.fiO.a(postData.bsh(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fhb.aVs().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.fiO.onChangeSkinType();
                if (this.fhd) {
                    PraiseData rF = this.fhb.aVs().rF();
                    if (rF != null && rF.getUser() != null && rF.getUser().size() > 0) {
                        bVar.fzc.setVisibility(0);
                        bVar.fzb.setVisibility(0);
                        bVar.fzd.setVisibility(0);
                        bVar.fzc.setIsFromPb(true);
                        bVar.fzc.setData(rF, this.fhb.aVs().getId(), rF.getPostId(), true);
                        bVar.fzc.dz(this.mSkinType);
                    } else {
                        bVar.fzc.setVisibility(8);
                        bVar.fzb.setVisibility(8);
                        bVar.fzd.setVisibility(8);
                    }
                } else {
                    bVar.fzc.setVisibility(8);
                    bVar.fzb.setVisibility(8);
                    bVar.fzd.setVisibility(8);
                }
                bVar.fzc.setVisibility(0);
                bVar.fzb.setVisibility(0);
                bVar.fzd.setVisibility(0);
                a(bVar.fiN, (int) this.mContext.getResources().getDimension(d.e.ds30));
            } else {
                bVar.fiO.setVisibility(8);
            }
            bVar.fiN.getLayoutStrategy().fK(d.f.pic_video);
            bVar.fiN.setTextColor(ak.getColor(d.C0126d.common_color_10039));
            bVar.fiN.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
            bVar.fiN.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
            if (this.fhc) {
                bVar.fiN.getLayoutStrategy().fN(d.f.transparent_bg);
            } else {
                bVar.fiN.getLayoutStrategy().fN(d.f.icon_click);
            }
            bVar.fiN.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bsb();
            }
            if (this.fiC || !this.fiD) {
                bVar.fiN.setText(tbRichText, false);
            } else {
                bVar.fiN.setText(tbRichText, true);
            }
            bb rA = this.fhb.aVs().rA();
            if (rA != null) {
                bVar.fza.startLoad(this.fhb.aVs().rA().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int af = l.af(this.mContext);
                float ry = rA.ry() / rA.rx();
                if (ry > 1.0f) {
                    i = (int) (1.0f * af);
                } else if (ry < 0.2f) {
                    i = (int) (af * 0.2f);
                } else {
                    i = (int) (af * ry);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fza.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = af;
                bVar.fza.setLayoutParams(layoutParams2);
            } else {
                bVar.fza.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fhc) {
            bVar.fiN.setOnClickListener(null);
        } else {
            bVar.fiN.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fiN.setTextViewCheckSelection(false);
        bVar.fiN.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().fL(this.fyY - (i - this.fyX));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fiN.setOnLongClickListener(this.axW);
        bVar.fiN.setOnTouchListener(this.aWx);
        bVar.fiN.setOnImageClickListener(this.aWw);
        bVar.fiN.setOnEmotionClickListener(((PbActivity) this.fgM.getPageContext().getOrignalPage()).feP.fsn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fhb = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void qa(int i) {
        this.fhj = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jq(boolean z) {
        this.fhc = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jr(boolean z) {
        this.fhd = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void js(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void F(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.aWw = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axW = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void n(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
