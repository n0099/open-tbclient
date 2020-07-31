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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class a extends o<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnClickListener aMH;
    private TbRichTextView.i eRR;
    private c euG;
    private boolean kKK;
    private int kKL;
    private int kKM;
    private f kkM;
    private boolean kkN;
    private boolean kkO;
    private int kkU;
    private boolean kmO;
    private final boolean kmP;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.kkU = 0;
        this.kkN = true;
        this.kKK = true;
        this.kkM = null;
        this.kkO = true;
        this.aMH = null;
        this.eRR = null;
        this.euG = null;
        this.mOnLongClickListener = null;
        this.kmO = false;
        this.kmP = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.o
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.kKL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.kKM = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cy */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.kKK, this.kkN, this.kkU, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) bVar);
        ao.setBackgroundColor(view, R.color.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.kmZ, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.kmZ.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.kmZ.setLayoutParams(layoutParams);
            bVar.kmZ.setPadding(0, 0, 0, 0);
            bVar.kmZ.AF(null);
            postData.aXx();
            if (postData.dlh() == 1) {
                bVar.kKQ.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aWl() != null) {
                    j = postData.aWl().getUserIdLong();
                    str = postData.aWl().getUserName();
                    str2 = postData.aWl().getName_show();
                }
                bVar.kKQ.a(postData.dlp(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.kkM.cKx().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.kKQ.onChangeSkinType();
                if (this.kkO) {
                    PraiseData aVW = this.kkM.cKx().aVW();
                    if (aVW != null && aVW.getUser() != null && aVW.getUser().size() > 0) {
                        bVar.kKR.setVisibility(0);
                        bVar.kKP.setVisibility(0);
                        bVar.kKS.setVisibility(0);
                        bVar.kKR.setIsFromPb(true);
                        bVar.kKR.setData(aVW, this.kkM.cKx().getId(), aVW.getPostId(), true);
                        bVar.kKR.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.kKR.setVisibility(8);
                        bVar.kKP.setVisibility(8);
                        bVar.kKS.setVisibility(8);
                    }
                } else {
                    bVar.kKR.setVisibility(8);
                    bVar.kKP.setVisibility(8);
                    bVar.kKS.setVisibility(8);
                }
                bVar.kKR.setVisibility(0);
                bVar.kKP.setVisibility(0);
                bVar.kKS.setVisibility(0);
                a(bVar.kmZ, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.kKQ.setVisibility(8);
            }
            bVar.kmZ.getLayoutStrategy().oQ(R.drawable.pic_video);
            bVar.kmZ.setTextColor(ao.getColor(R.color.common_color_10039));
            bVar.kmZ.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
            bVar.kmZ.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
            if (this.kkN) {
                bVar.kmZ.getLayoutStrategy().oT(R.drawable.transparent_bg);
            } else {
                bVar.kmZ.getLayoutStrategy().oT(R.drawable.icon_click);
            }
            bVar.kmZ.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dlj();
            }
            if (this.kmO || !this.kmP) {
                bVar.kmZ.setText(tbRichText, false);
            } else {
                bVar.kmZ.setText(tbRichText, true);
            }
            bt aVR = this.kkM.cKx().aVR();
            if (aVR != null) {
                bVar.kKO.startLoad(this.kkM.cKx().aVR().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float aVG = aVR.aVG() / aVR.aVF();
                if (aVG > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (aVG < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * aVG);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.kKO.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.kKO.setLayoutParams(layoutParams2);
            } else {
                bVar.kKO.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kkN) {
            bVar.kmZ.setOnClickListener(null);
        } else {
            bVar.kmZ.setOnClickListener(this.aMH);
        }
        bVar.kmZ.setTextViewCheckSelection(false);
        bVar.kmZ.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().oR(this.kKM - (i - this.kKL));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.kmZ.setOnLongClickListener(this.mOnLongClickListener);
        bVar.kmZ.setOnTouchListener(this.euG);
        bVar.kmZ.setOnImageClickListener(this.eRR);
        if (this.kmC != null && this.kmC.cNt() != null) {
            bVar.kmZ.setOnEmotionClickListener(this.kmC.cNt().kkl.kzZ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(f fVar) {
        this.kkM = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void fq(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.kkU = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void rW(boolean z) {
        this.kkN = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void rX(boolean z) {
        this.kkO = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void rY(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void R(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eRR = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void z(View.OnClickListener onClickListener) {
        this.aMH = onClickListener;
    }
}
