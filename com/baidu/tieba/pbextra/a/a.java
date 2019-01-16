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
    private View.OnLongClickListener aTZ;
    private TbRichTextView.h bsD;
    private c bsE;
    private d fYY;
    private boolean fYZ;
    private boolean fZa;
    private int fZg;
    private boolean gao;
    private final boolean gap;
    private boolean gmG;
    private int gqA;
    private int gqz;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fZg = 0;
        this.fYZ = true;
        this.gmG = true;
        this.fYY = null;
        this.fZa = true;
        this.mCommonClickListener = null;
        this.bsD = null;
        this.bsE = null;
        this.aTZ = null;
        this.gao = false;
        this.gap = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        aq(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void aq(PbActivity pbActivity) {
        super.aq(pbActivity);
        if (pbActivity != null) {
            this.gqz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds30);
            this.gqA = l.aO(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(e.h.pb_interview_normal_item, viewGroup, false), this.gmG, this.fYZ, this.fZg, false);
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
            a(bVar.gax, (int) this.mContext.getResources().getDimension(e.C0210e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gax.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.gax.setLayoutParams(layoutParams);
            bVar.gax.setPadding(0, 0, 0, 0);
            bVar.gax.jr(null);
            postData.AQ();
            if (postData.bES() == 1) {
                bVar.gqE.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.zT() != null) {
                    j = postData.zT().getUserIdLong();
                    str = postData.zT().getUserName();
                    str2 = postData.zT().getName_show();
                }
                bVar.gqE.a(postData.bFa(), str, str2, j, com.baidu.adp.lib.g.b.d(this.fYY.bhz().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                bVar.gqE.onChangeSkinType();
                if (this.fZa) {
                    PraiseData zG = this.fYY.bhz().zG();
                    if (zG != null && zG.getUser() != null && zG.getUser().size() > 0) {
                        bVar.gqF.setVisibility(0);
                        bVar.gqD.setVisibility(0);
                        bVar.gqG.setVisibility(0);
                        bVar.gqF.setIsFromPb(true);
                        bVar.gqF.setData(zG, this.fYY.bhz().getId(), zG.getPostId(), true);
                        bVar.gqF.eD(this.mSkinType);
                    } else {
                        bVar.gqF.setVisibility(8);
                        bVar.gqD.setVisibility(8);
                        bVar.gqG.setVisibility(8);
                    }
                } else {
                    bVar.gqF.setVisibility(8);
                    bVar.gqD.setVisibility(8);
                    bVar.gqG.setVisibility(8);
                }
                bVar.gqF.setVisibility(0);
                bVar.gqD.setVisibility(0);
                bVar.gqG.setVisibility(0);
                a(bVar.gax, (int) this.mContext.getResources().getDimension(e.C0210e.ds30));
            } else {
                bVar.gqE.setVisibility(8);
            }
            bVar.gax.getLayoutStrategy().gK(e.f.pic_video);
            bVar.gax.setTextColor(al.getColor(e.d.common_color_10039));
            bVar.gax.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            bVar.gax.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            if (this.fYZ) {
                bVar.gax.getLayoutStrategy().gN(e.f.transparent_bg);
            } else {
                bVar.gax.getLayoutStrategy().gN(e.f.icon_click);
            }
            bVar.gax.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bEU();
            }
            if (this.gao || !this.gap) {
                bVar.gax.setText(tbRichText, false);
            } else {
                bVar.gax.setText(tbRichText, true);
            }
            ba zA = this.fYY.bhz().zA();
            if (zA != null) {
                bVar.gqC.startLoad(this.fYY.bhz().zA().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int aO = l.aO(this.mContext);
                float zy = zA.zy() / zA.zx();
                if (zy > 1.0f) {
                    i = (int) (1.0f * aO);
                } else if (zy < 0.2f) {
                    i = (int) (aO * 0.2f);
                } else {
                    i = (int) (aO * zy);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.gqC.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = aO;
                bVar.gqC.setLayoutParams(layoutParams2);
            } else {
                bVar.gqC.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fYZ) {
            bVar.gax.setOnClickListener(null);
        } else {
            bVar.gax.setOnClickListener(this.mCommonClickListener);
        }
        bVar.gax.setTextViewCheckSelection(false);
        bVar.gax.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().gL(this.gqA - (i - this.gqz));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.gax.setOnLongClickListener(this.aTZ);
        bVar.gax.setOnTouchListener(this.bsE);
        bVar.gax.setOnImageClickListener(this.bsD);
        bVar.gax.setOnEmotionClickListener(((PbActivity) this.fYJ.getPageContext().getOrignalPage()).fWN.gkk);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(d dVar) {
        this.fYY = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.fZg = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kC(boolean z) {
        this.fYZ = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kD(boolean z) {
        this.fZa = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void kE(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void I(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bsD = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTZ = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
