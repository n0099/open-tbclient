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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class a extends m<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnClickListener aIH;
    private TbRichTextView.i eBN;
    private c efF;
    private e jIA;
    private boolean jIB;
    private boolean jIC;
    private int jII;
    private boolean jKs;
    private final boolean jKt;
    private boolean khV;
    private int khW;
    private int khX;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.jII = 0;
        this.jIB = true;
        this.khV = true;
        this.jIA = null;
        this.jIC = true;
        this.aIH = null;
        this.eBN = null;
        this.efF = null;
        this.mOnLongClickListener = null;
        this.jKs = false;
        this.jKt = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.m
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.khW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.khX = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cj */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.khV, this.jIB, this.jII, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
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
            a(bVar.jKC, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.jKC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.jKC.setLayoutParams(layoutParams);
            bVar.jKC.setPadding(0, 0, 0, 0);
            bVar.jKC.ze(null);
            postData.aRK();
            if (postData.ddJ() == 1) {
                bVar.kib.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aQx() != null) {
                    j = postData.aQx().getUserIdLong();
                    str = postData.aQx().getUserName();
                    str2 = postData.aQx().getName_show();
                }
                bVar.kib.a(postData.ddR(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.jIA.cCy().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.kib.onChangeSkinType();
                if (this.jIC) {
                    PraiseData aQi = this.jIA.cCy().aQi();
                    if (aQi != null && aQi.getUser() != null && aQi.getUser().size() > 0) {
                        bVar.kic.setVisibility(0);
                        bVar.kia.setVisibility(0);
                        bVar.kie.setVisibility(0);
                        bVar.kic.setIsFromPb(true);
                        bVar.kic.setData(aQi, this.jIA.cCy().getId(), aQi.getPostId(), true);
                        bVar.kic.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.kic.setVisibility(8);
                        bVar.kia.setVisibility(8);
                        bVar.kie.setVisibility(8);
                    }
                } else {
                    bVar.kic.setVisibility(8);
                    bVar.kia.setVisibility(8);
                    bVar.kie.setVisibility(8);
                }
                bVar.kic.setVisibility(0);
                bVar.kia.setVisibility(0);
                bVar.kie.setVisibility(0);
                a(bVar.jKC, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.kib.setVisibility(8);
            }
            bVar.jKC.getLayoutStrategy().oa(R.drawable.pic_video);
            bVar.jKC.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.jKC.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.jKC.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.jIB) {
                bVar.jKC.getLayoutStrategy().od(R.drawable.transparent_bg);
            } else {
                bVar.jKC.getLayoutStrategy().od(R.drawable.icon_click);
            }
            bVar.jKC.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.ddL();
            }
            if (this.jKs || !this.jKt) {
                bVar.jKC.setText(tbRichText, false);
            } else {
                bVar.jKC.setText(tbRichText, true);
            }
            bi aQd = this.jIA.cCy().aQd();
            if (aQd != null) {
                bVar.khZ.startLoad(this.jIA.cCy().aQd().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float aPT = aQd.aPT() / aQd.aPS();
                if (aPT > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (aPT < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * aPT);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.khZ.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.khZ.setLayoutParams(layoutParams2);
            } else {
                bVar.khZ.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.jIB) {
            bVar.jKC.setOnClickListener(null);
        } else {
            bVar.jKC.setOnClickListener(this.aIH);
        }
        bVar.jKC.setTextViewCheckSelection(false);
        bVar.jKC.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().ob(this.khX - (i - this.khW));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.jKC.setOnLongClickListener(this.mOnLongClickListener);
        bVar.jKC.setOnTouchListener(this.efF);
        bVar.jKC.setOnImageClickListener(this.eBN);
        if (this.jKg != null && this.jKg.cFs() != null) {
            bVar.jKC.setOnEmotionClickListener(this.jKg.cFs().jHX.jXl);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(e eVar) {
        this.jIA = eVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void fl(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.jII = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void re(boolean z) {
        this.jIB = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void rf(boolean z) {
        this.jIC = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void rg(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void Q(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBN = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void y(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }
}
