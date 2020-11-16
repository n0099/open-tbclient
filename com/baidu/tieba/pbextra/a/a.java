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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes21.dex */
public class a extends o<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnClickListener aYm;
    private TbRichTextView.i fFy;
    private c fgS;
    private boolean lRA;
    private int lRB;
    private int lRC;
    private f lqK;
    private boolean lqL;
    private boolean lqM;
    private int lqS;
    private boolean lsO;
    private final boolean lsP;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lqS = 0;
        this.lqL = true;
        this.lRA = true;
        this.lqK = null;
        this.lqM = true;
        this.aYm = null;
        this.fFy = null;
        this.fgS = null;
        this.mOnLongClickListener = null;
        this.lsO = false;
        this.lsP = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.o
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.lRB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.lRC = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cw */
    public b c(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.lRA, this.lqL, this.lqS, false);
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
            a(bVar.lsY, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.lsY.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.lsY.setLayoutParams(layoutParams);
            bVar.lsY.setPadding(0, 0, 0, 0);
            bVar.lsY.El(null);
            postData.bmQ();
            if (postData.dJQ() == 1) {
                bVar.lRG.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.blC() != null) {
                    j = postData.blC().getUserIdLong();
                    str = postData.blC().getUserName();
                    str2 = postData.blC().getName_show();
                }
                bVar.lRG.a(postData.dJY(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lqK.dhH().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.lRG.onChangeSkinType();
                if (this.lqM) {
                    PraiseData bln = this.lqK.dhH().bln();
                    if (bln != null && bln.getUser() != null && bln.getUser().size() > 0) {
                        bVar.lRH.setVisibility(0);
                        bVar.lRF.setVisibility(0);
                        bVar.lRI.setVisibility(0);
                        bVar.lRH.setIsFromPb(true);
                        bVar.lRH.setData(bln, this.lqK.dhH().getId(), bln.getPostId(), true);
                        bVar.lRH.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.lRH.setVisibility(8);
                        bVar.lRF.setVisibility(8);
                        bVar.lRI.setVisibility(8);
                    }
                } else {
                    bVar.lRH.setVisibility(8);
                    bVar.lRF.setVisibility(8);
                    bVar.lRI.setVisibility(8);
                }
                bVar.lRH.setVisibility(0);
                bVar.lRF.setVisibility(0);
                bVar.lRI.setVisibility(0);
                a(bVar.lsY, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.lRG.setVisibility(8);
            }
            bVar.lsY.getLayoutStrategy().sK(R.drawable.pic_video);
            bVar.lsY.setTextColor(ap.getColor(R.color.common_color_10039));
            bVar.lsY.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            bVar.lsY.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
            if (this.lqL) {
                bVar.lsY.getLayoutStrategy().sN(R.drawable.transparent_bg);
            } else {
                bVar.lsY.getLayoutStrategy().sN(R.drawable.icon_click);
            }
            bVar.lsY.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dJS();
            }
            if (this.lsO || !this.lsP) {
                bVar.lsY.setText(tbRichText, false);
            } else {
                bVar.lsY.setText(tbRichText, true);
            }
            bv bli = this.lqK.dhH().bli();
            if (bli != null) {
                bVar.lRE.startLoad(this.lqK.dhH().bli().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float bkX = bli.bkX() / bli.bkW();
                if (bkX > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (bkX < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * bkX);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.lRE.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.lRE.setLayoutParams(layoutParams2);
            } else {
                bVar.lRE.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lqL) {
            bVar.lsY.setOnClickListener(null);
        } else {
            bVar.lsY.setOnClickListener(this.aYm);
        }
        bVar.lsY.setTextViewCheckSelection(false);
        bVar.lsY.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().sL(this.lRC - (i - this.lRB));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.lsY.setOnLongClickListener(this.mOnLongClickListener);
        bVar.lsY.setOnTouchListener(this.fgS);
        bVar.lsY.setOnImageClickListener(this.fFy);
        if (this.lsC != null && this.lsC.dkB() != null) {
            bVar.lsY.setOnEmotionClickListener(this.lsC.dkB().lqj.lGt);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(f fVar) {
        this.lqK = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void hy(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.lqS = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void tW(boolean z) {
        this.lqL = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void tX(boolean z) {
        this.lqM = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void tY(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void S(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFy = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void B(View.OnClickListener onClickListener) {
        this.aYm = onClickListener;
    }
}
