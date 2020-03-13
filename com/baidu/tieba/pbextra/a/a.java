package com.baidu.tieba.pbextra.a;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class a extends l<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnClickListener aku;
    private TbRichTextView.i dMK;
    private c dqX;
    private e iEU;
    private boolean iEV;
    private boolean iEW;
    private int iFc;
    private boolean iGE;
    private final boolean iGF;
    private boolean jdp;
    private int jdq;
    private int jdr;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.iFc = 0;
        this.iEV = true;
        this.jdp = true;
        this.iEU = null;
        this.iEW = true;
        this.aku = null;
        this.dMK = null;
        this.dqX = null;
        this.mOnLongClickListener = null;
        this.iGE = false;
        this.iGF = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.l
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.jdq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.jdr = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bT */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.jdp, this.iEV, this.iFc, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.l, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) bVar);
        am.setBackgroundColor(view, R.color.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.iGO, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.iGO.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.iGO.setLayoutParams(layoutParams);
            bVar.iGO.setPadding(0, 0, 0, 0);
            bVar.iGO.wi(null);
            postData.aDw();
            if (postData.cLb() == 1) {
                bVar.jdv.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aCo() != null) {
                    j = postData.aCo().getUserIdLong();
                    str = postData.aCo().getUserName();
                    str2 = postData.aCo().getName_show();
                }
                bVar.jdv.a(postData.cLj(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.iEU.ckv().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.jdv.onChangeSkinType();
                if (this.iEW) {
                    PraiseData aBZ = this.iEU.ckv().aBZ();
                    if (aBZ != null && aBZ.getUser() != null && aBZ.getUser().size() > 0) {
                        bVar.jdw.setVisibility(0);
                        bVar.jdu.setVisibility(0);
                        bVar.jdx.setVisibility(0);
                        bVar.jdw.setIsFromPb(true);
                        bVar.jdw.setData(aBZ, this.iEU.ckv().getId(), aBZ.getPostId(), true);
                        bVar.jdw.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.jdw.setVisibility(8);
                        bVar.jdu.setVisibility(8);
                        bVar.jdx.setVisibility(8);
                    }
                } else {
                    bVar.jdw.setVisibility(8);
                    bVar.jdu.setVisibility(8);
                    bVar.jdx.setVisibility(8);
                }
                bVar.jdw.setVisibility(0);
                bVar.jdu.setVisibility(0);
                bVar.jdx.setVisibility(0);
                a(bVar.iGO, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.jdv.setVisibility(8);
            }
            bVar.iGO.getLayoutStrategy().nh(R.drawable.pic_video);
            bVar.iGO.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.iGO.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.iGO.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.iEV) {
                bVar.iGO.getLayoutStrategy().nk(R.drawable.transparent_bg);
            } else {
                bVar.iGO.getLayoutStrategy().nk(R.drawable.icon_click);
            }
            bVar.iGO.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cLd();
            }
            if (this.iGE || !this.iGF) {
                bVar.iGO.setText(tbRichText, false);
            } else {
                bVar.iGO.setText(tbRichText, true);
            }
            bh aBU = this.iEU.ckv().aBU();
            if (aBU != null) {
                bVar.jdt.startLoad(this.iEU.ckv().aBU().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
                float aBK = aBU.aBK() / aBU.aBJ();
                if (aBK > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (aBK < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * aBK);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.jdt.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.jdt.setLayoutParams(layoutParams2);
            } else {
                bVar.jdt.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iEV) {
            bVar.iGO.setOnClickListener(null);
        } else {
            bVar.iGO.setOnClickListener(this.aku);
        }
        bVar.iGO.setTextViewCheckSelection(false);
        bVar.iGO.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().ni(this.jdr - (i - this.jdq));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.iGO.setOnLongClickListener(this.mOnLongClickListener);
        bVar.iGO.setOnTouchListener(this.dqX);
        bVar.iGO.setOnImageClickListener(this.dMK);
        if (this.iGs != null && this.iGs.cnj() != null) {
            bVar.iGO.setOnEmotionClickListener(this.iGs.cnj().iEw.iSS);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(e eVar) {
        this.iEU = eVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void dI(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.iFc = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void pw(boolean z) {
        this.iEV = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void px(boolean z) {
        this.iEW = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void py(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void P(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMK = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void y(View.OnClickListener onClickListener) {
        this.aku = onClickListener;
    }
}
