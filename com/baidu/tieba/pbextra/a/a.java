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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class a extends k<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnClickListener ZX;
    private TbRichTextView.h cUE;
    private c czv;
    private d hOn;
    private boolean hOp;
    private boolean hOq;
    private int hOw;
    private boolean hPI;
    private final boolean hPJ;
    private boolean icr;
    private int igD;
    private int igE;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hOw = 0;
        this.hOp = true;
        this.icr = true;
        this.hOn = null;
        this.hOq = true;
        this.ZX = null;
        this.cUE = null;
        this.czv = null;
        this.mOnLongClickListener = null;
        this.hPI = false;
        this.hPJ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        av(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void av(PbActivity pbActivity) {
        super.av(pbActivity);
        if (pbActivity != null) {
            this.igD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.igE = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bP */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.icr, this.hOp, this.hOw, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
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
            a(bVar.hPS, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hPS.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.hPS.setLayoutParams(layoutParams);
            bVar.hPS.setPadding(0, 0, 0, 0);
            bVar.hPS.qx(null);
            postData.ajK();
            if (postData.cop() == 1) {
                bVar.igI.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aiG() != null) {
                    j = postData.aiG().getUserIdLong();
                    str = postData.aiG().getUserName();
                    str2 = postData.aiG().getName_show();
                }
                bVar.igI.a(postData.cox(), str, str2, j, com.baidu.adp.lib.g.b.toLong(this.hOn.bQz().getId(), 0L), com.baidu.adp.lib.g.b.toLong(postData.getId(), 0L));
                bVar.igI.onChangeSkinType();
                if (this.hOq) {
                    PraiseData ais = this.hOn.bQz().ais();
                    if (ais != null && ais.getUser() != null && ais.getUser().size() > 0) {
                        bVar.igJ.setVisibility(0);
                        bVar.igH.setVisibility(0);
                        bVar.igK.setVisibility(0);
                        bVar.igJ.setIsFromPb(true);
                        bVar.igJ.setData(ais, this.hOn.bQz().getId(), ais.getPostId(), true);
                        bVar.igJ.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.igJ.setVisibility(8);
                        bVar.igH.setVisibility(8);
                        bVar.igK.setVisibility(8);
                    }
                } else {
                    bVar.igJ.setVisibility(8);
                    bVar.igH.setVisibility(8);
                    bVar.igK.setVisibility(8);
                }
                bVar.igJ.setVisibility(0);
                bVar.igH.setVisibility(0);
                bVar.igK.setVisibility(0);
                a(bVar.hPS, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.igI.setVisibility(8);
            }
            bVar.hPS.getLayoutStrategy().kC(R.drawable.pic_video);
            bVar.hPS.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.hPS.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.hPS.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.hOp) {
                bVar.hPS.getLayoutStrategy().kF(R.drawable.transparent_bg);
            } else {
                bVar.hPS.getLayoutStrategy().kF(R.drawable.icon_click);
            }
            bVar.hPS.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cor();
            }
            if (this.hPI || !this.hPJ) {
                bVar.hPS.setText(tbRichText, false);
            } else {
                bVar.hPS.setText(tbRichText, true);
            }
            bf aim = this.hOn.bQz().aim();
            if (aim != null) {
                bVar.igG.startLoad(this.hOn.bQz().aim().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float aic = aim.aic() / aim.aib();
                if (aic > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (aic < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * aic);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.igG.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.igG.setLayoutParams(layoutParams2);
            } else {
                bVar.igG.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hOp) {
            bVar.hPS.setOnClickListener(null);
        } else {
            bVar.hPS.setOnClickListener(this.ZX);
        }
        bVar.hPS.setTextViewCheckSelection(false);
        bVar.hPS.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().kD(this.igE - (i - this.igD));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.hPS.setOnLongClickListener(this.mOnLongClickListener);
        bVar.hPS.setOnTouchListener(this.czv);
        bVar.hPS.setOnImageClickListener(this.cUE);
        bVar.hPS.setOnEmotionClickListener(((PbActivity) this.hNY.getPageContext().getOrignalPage()).hLX.hZv);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(d dVar) {
        this.hOn = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void cD(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void wq(int i) {
        this.hOw = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nT(boolean z) {
        this.hOp = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nU(boolean z) {
        this.hOq = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nV(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void O(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cUE = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void w(View.OnClickListener onClickListener) {
        this.ZX = onClickListener;
    }
}
