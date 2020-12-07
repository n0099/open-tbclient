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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class a extends o<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnClickListener bbH;
    private TbRichTextView.i fNk;
    private c fos;
    private int lEB;
    private f lEt;
    private boolean lEu;
    private boolean lEv;
    private boolean lGA;
    private final boolean lGB;
    private View.OnLongClickListener mOnLongClickListener;
    private boolean mfF;
    private int mfG;
    private int mfH;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lEB = 0;
        this.lEu = true;
        this.mfF = true;
        this.lEt = null;
        this.lEv = true;
        this.bbH = null;
        this.fNk = null;
        this.fos = null;
        this.mOnLongClickListener = null;
        this.lGA = false;
        this.lGB = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.o
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.mfG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.mfH = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cz */
    public b c(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.mfF, this.lEu, this.lEB, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) bVar);
        ap.setBackgroundColor(view, R.color.CAM_X0201);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.lGK, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.lGK.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.lGK.setLayoutParams(layoutParams);
            bVar.lGK.setPadding(0, 0, 0, 0);
            bVar.lGK.EZ(null);
            postData.bqd();
            if (postData.dPg() == 1) {
                bVar.mfL.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.boP() != null) {
                    j = postData.boP().getUserIdLong();
                    str = postData.boP().getUserName();
                    str2 = postData.boP().getName_show();
                }
                bVar.mfL.a(postData.dPo(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lEt.dmT().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.mfL.onChangeSkinType();
                if (this.lEv) {
                    PraiseData boA = this.lEt.dmT().boA();
                    if (boA != null && boA.getUser() != null && boA.getUser().size() > 0) {
                        bVar.mfM.setVisibility(0);
                        bVar.mfK.setVisibility(0);
                        bVar.mfN.setVisibility(0);
                        bVar.mfM.setIsFromPb(true);
                        bVar.mfM.setData(boA, this.lEt.dmT().getId(), boA.getPostId(), true);
                        bVar.mfM.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.mfM.setVisibility(8);
                        bVar.mfK.setVisibility(8);
                        bVar.mfN.setVisibility(8);
                    }
                } else {
                    bVar.mfM.setVisibility(8);
                    bVar.mfK.setVisibility(8);
                    bVar.mfN.setVisibility(8);
                }
                bVar.mfM.setVisibility(0);
                bVar.mfK.setVisibility(0);
                bVar.mfN.setVisibility(0);
                a(bVar.lGK, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.mfL.setVisibility(8);
            }
            bVar.lGK.getLayoutStrategy().tn(R.drawable.pic_video);
            bVar.lGK.setTextColor(ap.getColor(R.color.common_color_10039));
            bVar.lGK.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            bVar.lGK.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            if (this.lEu) {
                bVar.lGK.getLayoutStrategy().tq(R.drawable.transparent_bg);
            } else {
                bVar.lGK.getLayoutStrategy().tq(R.drawable.icon_click);
            }
            bVar.lGK.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dPi();
            }
            if (this.lGA || !this.lGB) {
                bVar.lGK.setText(tbRichText, false);
            } else {
                bVar.lGK.setText(tbRichText, true);
            }
            bw bov = this.lEt.dmT().bov();
            if (bov != null) {
                bVar.mfJ.startLoad(this.lEt.dmT().bov().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float bok = bov.bok() / bov.boj();
                if (bok > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (bok < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * bok);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.mfJ.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.mfJ.setLayoutParams(layoutParams2);
            } else {
                bVar.mfJ.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lEu) {
            bVar.lGK.setOnClickListener(null);
        } else {
            bVar.lGK.setOnClickListener(this.bbH);
        }
        bVar.lGK.setTextViewCheckSelection(false);
        bVar.lGK.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().to(this.mfH - (i - this.mfG));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.lGK.setOnLongClickListener(this.mOnLongClickListener);
        bVar.lGK.setOnTouchListener(this.fos);
        bVar.lGK.setOnImageClickListener(this.fNk);
        if (this.lGo != null && this.lGo.dpQ() != null) {
            bVar.lGK.setOnEmotionClickListener(this.lGo.dpQ().lDS.lUm);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(f fVar) {
        this.lEt = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void hY(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.lEB = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void uy(boolean z) {
        this.lEu = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void uz(boolean z) {
        this.lEv = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void uA(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void S(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fNk = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void B(View.OnClickListener onClickListener) {
        this.bbH = onClickListener;
    }
}
