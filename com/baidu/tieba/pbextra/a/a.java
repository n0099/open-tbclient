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
import com.baidu.tbadk.core.data.bu;
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
    private View.OnClickListener aYF;
    private TbRichTextView.i fAg;
    private c fbT;
    private boolean lLo;
    private int lLp;
    private int lLq;
    private int lkC;
    private f lku;
    private boolean lkv;
    private boolean lkw;
    private boolean lmx;
    private final boolean lmy;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.lkC = 0;
        this.lkv = true;
        this.lLo = true;
        this.lku = null;
        this.lkw = true;
        this.aYF = null;
        this.fAg = null;
        this.fbT = null;
        this.mOnLongClickListener = null;
        this.lmx = false;
        this.lmy = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.o
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.lLp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.lLq = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cy */
    public b c(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.lLo, this.lkv, this.lkC, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) bVar);
        ap.setBackgroundColor(view, R.color.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.lmH, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.lmH.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.lmH.setLayoutParams(layoutParams);
            bVar.lmH.setPadding(0, 0, 0, 0);
            bVar.lmH.Ew(null);
            postData.blm();
            if (postData.dHx() == 1) {
                bVar.lLu.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.bka() != null) {
                    j = postData.bka().getUserIdLong();
                    str = postData.bka().getUserName();
                    str2 = postData.bka().getName_show();
                }
                bVar.lLu.a(postData.dHF(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.lku.dfI().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.lLu.onChangeSkinType();
                if (this.lkw) {
                    PraiseData bjL = this.lku.dfI().bjL();
                    if (bjL != null && bjL.getUser() != null && bjL.getUser().size() > 0) {
                        bVar.lLv.setVisibility(0);
                        bVar.lLt.setVisibility(0);
                        bVar.lLw.setVisibility(0);
                        bVar.lLv.setIsFromPb(true);
                        bVar.lLv.setData(bjL, this.lku.dfI().getId(), bjL.getPostId(), true);
                        bVar.lLv.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.lLv.setVisibility(8);
                        bVar.lLt.setVisibility(8);
                        bVar.lLw.setVisibility(8);
                    }
                } else {
                    bVar.lLv.setVisibility(8);
                    bVar.lLt.setVisibility(8);
                    bVar.lLw.setVisibility(8);
                }
                bVar.lLv.setVisibility(0);
                bVar.lLt.setVisibility(0);
                bVar.lLw.setVisibility(0);
                a(bVar.lmH, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.lLu.setVisibility(8);
            }
            bVar.lmH.getLayoutStrategy().sc(R.drawable.pic_video);
            bVar.lmH.setTextColor(ap.getColor(R.color.common_color_10039));
            bVar.lmH.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            bVar.lmH.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
            if (this.lkv) {
                bVar.lmH.getLayoutStrategy().sf(R.drawable.transparent_bg);
            } else {
                bVar.lmH.getLayoutStrategy().sf(R.drawable.icon_click);
            }
            bVar.lmH.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dHz();
            }
            if (this.lmx || !this.lmy) {
                bVar.lmH.setText(tbRichText, false);
            } else {
                bVar.lmH.setText(tbRichText, true);
            }
            bu bjG = this.lku.dfI().bjG();
            if (bjG != null) {
                bVar.lLs.startLoad(this.lku.dfI().bjG().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float bjv = bjG.bjv() / bjG.bju();
                if (bjv > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (bjv < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * bjv);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.lLs.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.lLs.setLayoutParams(layoutParams2);
            } else {
                bVar.lLs.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lkv) {
            bVar.lmH.setOnClickListener(null);
        } else {
            bVar.lmH.setOnClickListener(this.aYF);
        }
        bVar.lmH.setTextViewCheckSelection(false);
        bVar.lmH.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().sd(this.lLq - (i - this.lLp));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.lmH.setOnLongClickListener(this.mOnLongClickListener);
        bVar.lmH.setOnTouchListener(this.fbT);
        bVar.lmH.setOnImageClickListener(this.fAg);
        if (this.lml != null && this.lml.diC() != null) {
            bVar.lmH.setOnEmotionClickListener(this.lml.diC().ljT.lAg);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(f fVar) {
        this.lku = fVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void hx(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.lkC = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void tK(boolean z) {
        this.lkv = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void tL(boolean z) {
        this.lkw = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void tM(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void S(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fAg = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void A(View.OnClickListener onClickListener) {
        this.aYF = onClickListener;
    }
}
