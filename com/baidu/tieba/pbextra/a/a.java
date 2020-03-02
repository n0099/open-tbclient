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
    private View.OnClickListener akt;
    private TbRichTextView.i dMx;
    private c dqK;
    private e iEI;
    private boolean iEJ;
    private boolean iEK;
    private int iEQ;
    private boolean iGs;
    private final boolean iGt;
    private boolean jdd;
    private int jde;
    private int jdf;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.iEQ = 0;
        this.iEJ = true;
        this.jdd = true;
        this.iEI = null;
        this.iEK = true;
        this.akt = null;
        this.dMx = null;
        this.dqK = null;
        this.mOnLongClickListener = null;
        this.iGs = false;
        this.iGt = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.l
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.jde = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.jdf = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bT */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.jdd, this.iEJ, this.iEQ, false);
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
            a(bVar.iGC, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.iGC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.iGC.setLayoutParams(layoutParams);
            bVar.iGC.setPadding(0, 0, 0, 0);
            bVar.iGC.wh(null);
            postData.aDw();
            if (postData.cLa() == 1) {
                bVar.jdj.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aCo() != null) {
                    j = postData.aCo().getUserIdLong();
                    str = postData.aCo().getUserName();
                    str2 = postData.aCo().getName_show();
                }
                bVar.jdj.a(postData.cLi(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.iEI.cku().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.jdj.onChangeSkinType();
                if (this.iEK) {
                    PraiseData aBZ = this.iEI.cku().aBZ();
                    if (aBZ != null && aBZ.getUser() != null && aBZ.getUser().size() > 0) {
                        bVar.jdk.setVisibility(0);
                        bVar.jdi.setVisibility(0);
                        bVar.jdl.setVisibility(0);
                        bVar.jdk.setIsFromPb(true);
                        bVar.jdk.setData(aBZ, this.iEI.cku().getId(), aBZ.getPostId(), true);
                        bVar.jdk.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.jdk.setVisibility(8);
                        bVar.jdi.setVisibility(8);
                        bVar.jdl.setVisibility(8);
                    }
                } else {
                    bVar.jdk.setVisibility(8);
                    bVar.jdi.setVisibility(8);
                    bVar.jdl.setVisibility(8);
                }
                bVar.jdk.setVisibility(0);
                bVar.jdi.setVisibility(0);
                bVar.jdl.setVisibility(0);
                a(bVar.iGC, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.jdj.setVisibility(8);
            }
            bVar.iGC.getLayoutStrategy().nh(R.drawable.pic_video);
            bVar.iGC.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.iGC.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.iGC.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.iEJ) {
                bVar.iGC.getLayoutStrategy().nk(R.drawable.transparent_bg);
            } else {
                bVar.iGC.getLayoutStrategy().nk(R.drawable.icon_click);
            }
            bVar.iGC.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cLc();
            }
            if (this.iGs || !this.iGt) {
                bVar.iGC.setText(tbRichText, false);
            } else {
                bVar.iGC.setText(tbRichText, true);
            }
            bh aBU = this.iEI.cku().aBU();
            if (aBU != null) {
                bVar.jdh.startLoad(this.iEI.cku().aBU().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
                float aBK = aBU.aBK() / aBU.aBJ();
                if (aBK > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (aBK < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * aBK);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.jdh.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.jdh.setLayoutParams(layoutParams2);
            } else {
                bVar.jdh.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iEJ) {
            bVar.iGC.setOnClickListener(null);
        } else {
            bVar.iGC.setOnClickListener(this.akt);
        }
        bVar.iGC.setTextViewCheckSelection(false);
        bVar.iGC.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().ni(this.jdf - (i - this.jde));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.iGC.setOnLongClickListener(this.mOnLongClickListener);
        bVar.iGC.setOnTouchListener(this.dqK);
        bVar.iGC.setOnImageClickListener(this.dMx);
        if (this.iGg != null && this.iGg.cni() != null) {
            bVar.iGC.setOnEmotionClickListener(this.iGg.cni().iEk.iSG);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(e eVar) {
        this.iEI = eVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void dI(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.iEQ = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void pw(boolean z) {
        this.iEJ = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void px(boolean z) {
        this.iEK = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void py(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void P(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMx = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void y(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }
}
