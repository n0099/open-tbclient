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
    private boolean kKM;
    private int kKN;
    private int kKO;
    private f kkO;
    private boolean kkP;
    private boolean kkQ;
    private int kkW;
    private boolean kmQ;
    private final boolean kmR;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.kkW = 0;
        this.kkP = true;
        this.kKM = true;
        this.kkO = null;
        this.kkQ = true;
        this.aMH = null;
        this.eRR = null;
        this.euG = null;
        this.mOnLongClickListener = null;
        this.kmQ = false;
        this.kmR = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.o
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.kKN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.kKO = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cy */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.kKM, this.kkP, this.kkW, false);
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
            a(bVar.knb, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.knb.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.knb.setLayoutParams(layoutParams);
            bVar.knb.setPadding(0, 0, 0, 0);
            bVar.knb.AF(null);
            postData.aXx();
            if (postData.dli() == 1) {
                bVar.kKS.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aWl() != null) {
                    j = postData.aWl().getUserIdLong();
                    str = postData.aWl().getUserName();
                    str2 = postData.aWl().getName_show();
                }
                bVar.kKS.a(postData.dlq(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.kkO.cKx().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.kKS.onChangeSkinType();
                if (this.kkQ) {
                    PraiseData aVW = this.kkO.cKx().aVW();
                    if (aVW != null && aVW.getUser() != null && aVW.getUser().size() > 0) {
                        bVar.kKT.setVisibility(0);
                        bVar.kKR.setVisibility(0);
                        bVar.kKU.setVisibility(0);
                        bVar.kKT.setIsFromPb(true);
                        bVar.kKT.setData(aVW, this.kkO.cKx().getId(), aVW.getPostId(), true);
                        bVar.kKT.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.kKT.setVisibility(8);
                        bVar.kKR.setVisibility(8);
                        bVar.kKU.setVisibility(8);
                    }
                } else {
                    bVar.kKT.setVisibility(8);
                    bVar.kKR.setVisibility(8);
                    bVar.kKU.setVisibility(8);
                }
                bVar.kKT.setVisibility(0);
                bVar.kKR.setVisibility(0);
                bVar.kKU.setVisibility(0);
                a(bVar.knb, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.kKS.setVisibility(8);
            }
            bVar.knb.getLayoutStrategy().oQ(R.drawable.pic_video);
            bVar.knb.setTextColor(ao.getColor(R.color.common_color_10039));
            bVar.knb.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
            bVar.knb.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
            if (this.kkP) {
                bVar.knb.getLayoutStrategy().oT(R.drawable.transparent_bg);
            } else {
                bVar.knb.getLayoutStrategy().oT(R.drawable.icon_click);
            }
            bVar.knb.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dlk();
            }
            if (this.kmQ || !this.kmR) {
                bVar.knb.setText(tbRichText, false);
            } else {
                bVar.knb.setText(tbRichText, true);
            }
            bt aVR = this.kkO.cKx().aVR();
            if (aVR != null) {
                bVar.kKQ.startLoad(this.kkO.cKx().aVR().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float aVG = aVR.aVG() / aVR.aVF();
                if (aVG > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (aVG < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * aVG);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.kKQ.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.kKQ.setLayoutParams(layoutParams2);
            } else {
                bVar.kKQ.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kkP) {
            bVar.knb.setOnClickListener(null);
        } else {
            bVar.knb.setOnClickListener(this.aMH);
        }
        bVar.knb.setTextViewCheckSelection(false);
        bVar.knb.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().oR(this.kKO - (i - this.kKN));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.knb.setOnLongClickListener(this.mOnLongClickListener);
        bVar.knb.setOnTouchListener(this.euG);
        bVar.knb.setOnImageClickListener(this.eRR);
        if (this.kmE != null && this.kmE.cNt() != null) {
            bVar.knb.setOnEmotionClickListener(this.kmE.cNt().kkn.kAb);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(f fVar) {
        this.kkO = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void fq(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.kkW = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void rW(boolean z) {
        this.kkP = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void rX(boolean z) {
        this.kkQ = z;
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
