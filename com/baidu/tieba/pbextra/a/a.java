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
/* loaded from: classes6.dex */
public class a extends m<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnClickListener ahD;
    private TbRichTextView.i dIi;
    private c dmm;
    private boolean iBi;
    private final boolean iBj;
    private boolean iXN;
    private int iXO;
    private int iXP;
    private int izD;
    private f izv;
    private boolean izw;
    private boolean izx;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.izD = 0;
        this.izw = true;
        this.iXN = true;
        this.izv = null;
        this.izx = true;
        this.ahD = null;
        this.dIi = null;
        this.dmm = null;
        this.mOnLongClickListener = null;
        this.iBi = false;
        this.iBj = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.m
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.iXO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.iXP = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bQ */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.iXN, this.izw, this.izD, false);
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
            a(bVar.iBs, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.iBs.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.iBs.setLayoutParams(layoutParams);
            bVar.iBs.setPadding(0, 0, 0, 0);
            bVar.iBs.vJ(null);
            postData.aAO();
            if (postData.cIt() == 1) {
                bVar.iXT.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.azE() != null) {
                    j = postData.azE().getUserIdLong();
                    str = postData.azE().getUserName();
                    str2 = postData.azE().getName_show();
                }
                bVar.iXT.a(postData.cIB(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.izv.chK().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.iXT.onChangeSkinType();
                if (this.izx) {
                    PraiseData azp = this.izv.chK().azp();
                    if (azp != null && azp.getUser() != null && azp.getUser().size() > 0) {
                        bVar.iXU.setVisibility(0);
                        bVar.iXS.setVisibility(0);
                        bVar.iXV.setVisibility(0);
                        bVar.iXU.setIsFromPb(true);
                        bVar.iXU.setData(azp, this.izv.chK().getId(), azp.getPostId(), true);
                        bVar.iXU.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.iXU.setVisibility(8);
                        bVar.iXS.setVisibility(8);
                        bVar.iXV.setVisibility(8);
                    }
                } else {
                    bVar.iXU.setVisibility(8);
                    bVar.iXS.setVisibility(8);
                    bVar.iXV.setVisibility(8);
                }
                bVar.iXU.setVisibility(0);
                bVar.iXS.setVisibility(0);
                bVar.iXV.setVisibility(0);
                a(bVar.iBs, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.iXT.setVisibility(8);
            }
            bVar.iBs.getLayoutStrategy().mQ(R.drawable.pic_video);
            bVar.iBs.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.iBs.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.iBs.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.izw) {
                bVar.iBs.getLayoutStrategy().mT(R.drawable.transparent_bg);
            } else {
                bVar.iBs.getLayoutStrategy().mT(R.drawable.icon_click);
            }
            bVar.iBs.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cIv();
            }
            if (this.iBi || !this.iBj) {
                bVar.iBs.setText(tbRichText, false);
            } else {
                bVar.iBs.setText(tbRichText, true);
            }
            bh azj = this.izv.chK().azj();
            if (azj != null) {
                bVar.iXR.startLoad(this.izv.chK().azj().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float ayZ = azj.ayZ() / azj.ayY();
                if (ayZ > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (ayZ < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * ayZ);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.iXR.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.iXR.setLayoutParams(layoutParams2);
            } else {
                bVar.iXR.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.izw) {
            bVar.iBs.setOnClickListener(null);
        } else {
            bVar.iBs.setOnClickListener(this.ahD);
        }
        bVar.iBs.setTextViewCheckSelection(false);
        bVar.iBs.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().mR(this.iXP - (i - this.iXO));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.iBs.setOnLongClickListener(this.mOnLongClickListener);
        bVar.iBs.setOnTouchListener(this.dmm);
        bVar.iBs.setOnImageClickListener(this.dIi);
        if (this.iAW != null && this.iAW.ckE() != null) {
            bVar.iBs.setOnEmotionClickListener(this.iAW.ckE().iyV.iNF);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(f fVar) {
        this.izv = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void dv(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.izD = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void ph(boolean z) {
        this.izw = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void pi(boolean z) {
        this.izx = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void pj(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void P(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIi = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void y(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
    }
}
