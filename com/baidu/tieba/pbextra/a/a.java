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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes7.dex */
public class a extends m<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnClickListener ain;
    private TbRichTextView.i dIr;
    private c dmA;
    private f iCZ;
    private boolean iDa;
    private boolean iDb;
    private int iDh;
    private boolean iEM;
    private final boolean iEN;
    private boolean jbv;
    private int jbw;
    private int jbx;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.iDh = 0;
        this.iDa = true;
        this.jbv = true;
        this.iCZ = null;
        this.iDb = true;
        this.ain = null;
        this.dIr = null;
        this.dmA = null;
        this.mOnLongClickListener = null;
        this.iEM = false;
        this.iEN = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.m
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.jbw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.jbx = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bU */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.jbv, this.iDa, this.iDh, false);
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
            a(bVar.iEW, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.iEW.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.iEW.setLayoutParams(layoutParams);
            bVar.iEW.setPadding(0, 0, 0, 0);
            bVar.iEW.vN(null);
            postData.aBh();
            if (postData.cJz() == 1) {
                bVar.jbB.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.azX() != null) {
                    j = postData.azX().getUserIdLong();
                    str = postData.azX().getUserName();
                    str2 = postData.azX().getName_show();
                }
                bVar.jbB.a(postData.cJH(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.iCZ.ciS().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.jbB.onChangeSkinType();
                if (this.iDb) {
                    PraiseData azI = this.iCZ.ciS().azI();
                    if (azI != null && azI.getUser() != null && azI.getUser().size() > 0) {
                        bVar.jbC.setVisibility(0);
                        bVar.jbA.setVisibility(0);
                        bVar.jbD.setVisibility(0);
                        bVar.jbC.setIsFromPb(true);
                        bVar.jbC.setData(azI, this.iCZ.ciS().getId(), azI.getPostId(), true);
                        bVar.jbC.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.jbC.setVisibility(8);
                        bVar.jbA.setVisibility(8);
                        bVar.jbD.setVisibility(8);
                    }
                } else {
                    bVar.jbC.setVisibility(8);
                    bVar.jbA.setVisibility(8);
                    bVar.jbD.setVisibility(8);
                }
                bVar.jbC.setVisibility(0);
                bVar.jbA.setVisibility(0);
                bVar.jbD.setVisibility(0);
                a(bVar.iEW, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.jbB.setVisibility(8);
            }
            bVar.iEW.getLayoutStrategy().mQ(R.drawable.pic_video);
            bVar.iEW.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.iEW.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.iEW.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.iDa) {
                bVar.iEW.getLayoutStrategy().mT(R.drawable.transparent_bg);
            } else {
                bVar.iEW.getLayoutStrategy().mT(R.drawable.icon_click);
            }
            bVar.iEW.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cJB();
            }
            if (this.iEM || !this.iEN) {
                bVar.iEW.setText(tbRichText, false);
            } else {
                bVar.iEW.setText(tbRichText, true);
            }
            bh azC = this.iCZ.ciS().azC();
            if (azC != null) {
                bVar.jbz.startLoad(this.iCZ.ciS().azC().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float azs = azC.azs() / azC.azr();
                if (azs > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (azs < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * azs);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.jbz.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.jbz.setLayoutParams(layoutParams2);
            } else {
                bVar.jbz.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iDa) {
            bVar.iEW.setOnClickListener(null);
        } else {
            bVar.iEW.setOnClickListener(this.ain);
        }
        bVar.iEW.setTextViewCheckSelection(false);
        bVar.iEW.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().mR(this.jbx - (i - this.jbw));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.iEW.setOnLongClickListener(this.mOnLongClickListener);
        bVar.iEW.setOnTouchListener(this.dmA);
        bVar.iEW.setOnImageClickListener(this.dIr);
        if (this.iEA != null && this.iEA.clM() != null) {
            bVar.iEW.setOnEmotionClickListener(this.iEA.clM().iCz.iRj);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(f fVar) {
        this.iCZ = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void dx(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.iDh = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void pt(boolean z) {
        this.iDa = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void pu(boolean z) {
        this.iDb = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void pv(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void O(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIr = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void x(View.OnClickListener onClickListener) {
        this.ain = onClickListener;
    }
}
