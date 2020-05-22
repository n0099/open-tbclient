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
    private TbRichTextView.i eBC;
    private c efF;
    private int jHC;
    private e jHu;
    private boolean jHv;
    private boolean jHw;
    private boolean jJm;
    private final boolean jJn;
    private boolean kgP;
    private int kgQ;
    private int kgR;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.jHC = 0;
        this.jHv = true;
        this.kgP = true;
        this.jHu = null;
        this.jHw = true;
        this.aIH = null;
        this.eBC = null;
        this.efF = null;
        this.mOnLongClickListener = null;
        this.jJm = false;
        this.jJn = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.m
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.kgQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.kgR = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cj */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.kgP, this.jHv, this.jHC, false);
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
            a(bVar.jJw, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.jJw.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.jJw.setLayoutParams(layoutParams);
            bVar.jJw.setPadding(0, 0, 0, 0);
            bVar.jJw.ze(null);
            postData.aRK();
            if (postData.ddu() == 1) {
                bVar.kgV.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aQx() != null) {
                    j = postData.aQx().getUserIdLong();
                    str = postData.aQx().getUserName();
                    str2 = postData.aQx().getName_show();
                }
                bVar.kgV.a(postData.ddC(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.jHu.cCi().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.kgV.onChangeSkinType();
                if (this.jHw) {
                    PraiseData aQi = this.jHu.cCi().aQi();
                    if (aQi != null && aQi.getUser() != null && aQi.getUser().size() > 0) {
                        bVar.kgW.setVisibility(0);
                        bVar.kgU.setVisibility(0);
                        bVar.kgX.setVisibility(0);
                        bVar.kgW.setIsFromPb(true);
                        bVar.kgW.setData(aQi, this.jHu.cCi().getId(), aQi.getPostId(), true);
                        bVar.kgW.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.kgW.setVisibility(8);
                        bVar.kgU.setVisibility(8);
                        bVar.kgX.setVisibility(8);
                    }
                } else {
                    bVar.kgW.setVisibility(8);
                    bVar.kgU.setVisibility(8);
                    bVar.kgX.setVisibility(8);
                }
                bVar.kgW.setVisibility(0);
                bVar.kgU.setVisibility(0);
                bVar.kgX.setVisibility(0);
                a(bVar.jJw, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.kgV.setVisibility(8);
            }
            bVar.jJw.getLayoutStrategy().nY(R.drawable.pic_video);
            bVar.jJw.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.jJw.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.jJw.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.jHv) {
                bVar.jJw.getLayoutStrategy().ob(R.drawable.transparent_bg);
            } else {
                bVar.jJw.getLayoutStrategy().ob(R.drawable.icon_click);
            }
            bVar.jJw.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.ddw();
            }
            if (this.jJm || !this.jJn) {
                bVar.jJw.setText(tbRichText, false);
            } else {
                bVar.jJw.setText(tbRichText, true);
            }
            bi aQd = this.jHu.cCi().aQd();
            if (aQd != null) {
                bVar.kgT.startLoad(this.jHu.cCi().aQd().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float aPT = aQd.aPT() / aQd.aPS();
                if (aPT > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (aPT < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * aPT);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.kgT.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.kgT.setLayoutParams(layoutParams2);
            } else {
                bVar.kgT.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.jHv) {
            bVar.jJw.setOnClickListener(null);
        } else {
            bVar.jJw.setOnClickListener(this.aIH);
        }
        bVar.jJw.setTextViewCheckSelection(false);
        bVar.jJw.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().nZ(this.kgR - (i - this.kgQ));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.jJw.setOnLongClickListener(this.mOnLongClickListener);
        bVar.jJw.setOnTouchListener(this.efF);
        bVar.jJw.setOnImageClickListener(this.eBC);
        if (this.jJa != null && this.jJa.cFc() != null) {
            bVar.jJw.setOnEmotionClickListener(this.jJa.cFc().jGR.jWf);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(e eVar) {
        this.jHu = eVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void fl(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.jHC = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void re(boolean z) {
        this.jHv = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void rf(boolean z) {
        this.jHw = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void rg(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void Q(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBC = iVar;
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
