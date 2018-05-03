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
    private d fgY;
    private boolean fgZ;
    private boolean fha;
    private int fhg;
    private final boolean fiA;
    private boolean fiz;
    private boolean fuI;
    private int fyU;
    private int fyV;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fhg = 0;
        this.fgZ = true;
        this.fuI = true;
        this.fgY = null;
        this.fha = true;
        this.mCommonClickListener = null;
        this.aWw = null;
        this.aWx = null;
        this.axW = null;
        this.fiz = false;
        this.fiA = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        aq(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void aq(PbActivity pbActivity) {
        super.aq(pbActivity);
        if (pbActivity != null) {
            this.fyU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds30);
            this.fyV = l.af(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bv */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(d.i.pb_interview_normal_item, viewGroup, false), this.fuI, this.fgZ, this.fhg, false);
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
            a(bVar.fiK, (int) this.mContext.getResources().getDimension(d.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fiK.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fiK.setLayoutParams(layoutParams);
            bVar.fiK.setPadding(0, 0, 0, 0);
            bVar.fiK.hu(null);
            postData.sK();
            if (postData.brZ() == 1) {
                bVar.fiL.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.rQ() != null) {
                    j = postData.rQ().getUserIdLong();
                    str = postData.rQ().getUserName();
                    str2 = postData.rQ().getName_show();
                }
                bVar.fiL.a(postData.bsh(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fgY.aVs().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.fiL.onChangeSkinType();
                if (this.fha) {
                    PraiseData rF = this.fgY.aVs().rF();
                    if (rF != null && rF.getUser() != null && rF.getUser().size() > 0) {
                        bVar.fyZ.setVisibility(0);
                        bVar.fyY.setVisibility(0);
                        bVar.fza.setVisibility(0);
                        bVar.fyZ.setIsFromPb(true);
                        bVar.fyZ.setData(rF, this.fgY.aVs().getId(), rF.getPostId(), true);
                        bVar.fyZ.dz(this.mSkinType);
                    } else {
                        bVar.fyZ.setVisibility(8);
                        bVar.fyY.setVisibility(8);
                        bVar.fza.setVisibility(8);
                    }
                } else {
                    bVar.fyZ.setVisibility(8);
                    bVar.fyY.setVisibility(8);
                    bVar.fza.setVisibility(8);
                }
                bVar.fyZ.setVisibility(0);
                bVar.fyY.setVisibility(0);
                bVar.fza.setVisibility(0);
                a(bVar.fiK, (int) this.mContext.getResources().getDimension(d.e.ds30));
            } else {
                bVar.fiL.setVisibility(8);
            }
            bVar.fiK.getLayoutStrategy().fK(d.f.pic_video);
            bVar.fiK.setTextColor(ak.getColor(d.C0126d.common_color_10039));
            bVar.fiK.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
            bVar.fiK.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
            if (this.fgZ) {
                bVar.fiK.getLayoutStrategy().fN(d.f.transparent_bg);
            } else {
                bVar.fiK.getLayoutStrategy().fN(d.f.icon_click);
            }
            bVar.fiK.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bsb();
            }
            if (this.fiz || !this.fiA) {
                bVar.fiK.setText(tbRichText, false);
            } else {
                bVar.fiK.setText(tbRichText, true);
            }
            bb rA = this.fgY.aVs().rA();
            if (rA != null) {
                bVar.fyX.startLoad(this.fgY.aVs().rA().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int af = l.af(this.mContext);
                float ry = rA.ry() / rA.rx();
                if (ry > 1.0f) {
                    i = (int) (1.0f * af);
                } else if (ry < 0.2f) {
                    i = (int) (af * 0.2f);
                } else {
                    i = (int) (af * ry);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fyX.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = af;
                bVar.fyX.setLayoutParams(layoutParams2);
            } else {
                bVar.fyX.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fgZ) {
            bVar.fiK.setOnClickListener(null);
        } else {
            bVar.fiK.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fiK.setTextViewCheckSelection(false);
        bVar.fiK.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().fL(this.fyV - (i - this.fyU));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fiK.setOnLongClickListener(this.axW);
        bVar.fiK.setOnTouchListener(this.aWx);
        bVar.fiK.setOnImageClickListener(this.aWw);
        bVar.fiK.setOnEmotionClickListener(((PbActivity) this.fgJ.getPageContext().getOrignalPage()).feM.fsk);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fgY = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void qa(int i) {
        this.fhg = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jq(boolean z) {
        this.fgZ = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jr(boolean z) {
        this.fha = z;
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
