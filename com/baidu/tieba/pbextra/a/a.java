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
    private View.OnClickListener ZF;
    private TbRichTextView.h cTN;
    private c cyE;
    private int hNF;
    private d hNw;
    private boolean hNy;
    private boolean hNz;
    private boolean hOR;
    private final boolean hOS;
    private boolean ibA;
    private int ifM;
    private int ifN;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.hNF = 0;
        this.hNy = true;
        this.ibA = true;
        this.hNw = null;
        this.hNz = true;
        this.ZF = null;
        this.cTN = null;
        this.cyE = null;
        this.mOnLongClickListener = null;
        this.hOR = false;
        this.hOS = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        av(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void av(PbActivity pbActivity) {
        super.av(pbActivity);
        if (pbActivity != null) {
            this.ifM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.ifN = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bP */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.ibA, this.hNy, this.hNF, false);
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
            a(bVar.hPb, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.hPb.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.hPb.setLayoutParams(layoutParams);
            bVar.hPb.setPadding(0, 0, 0, 0);
            bVar.hPb.qx(null);
            postData.ajI();
            if (postData.con() == 1) {
                bVar.ifR.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aiE() != null) {
                    j = postData.aiE().getUserIdLong();
                    str = postData.aiE().getUserName();
                    str2 = postData.aiE().getName_show();
                }
                bVar.ifR.a(postData.cov(), str, str2, j, com.baidu.adp.lib.g.b.toLong(this.hNw.bQx().getId(), 0L), com.baidu.adp.lib.g.b.toLong(postData.getId(), 0L));
                bVar.ifR.onChangeSkinType();
                if (this.hNz) {
                    PraiseData aiq = this.hNw.bQx().aiq();
                    if (aiq != null && aiq.getUser() != null && aiq.getUser().size() > 0) {
                        bVar.ifS.setVisibility(0);
                        bVar.ifQ.setVisibility(0);
                        bVar.ifT.setVisibility(0);
                        bVar.ifS.setIsFromPb(true);
                        bVar.ifS.setData(aiq, this.hNw.bQx().getId(), aiq.getPostId(), true);
                        bVar.ifS.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.ifS.setVisibility(8);
                        bVar.ifQ.setVisibility(8);
                        bVar.ifT.setVisibility(8);
                    }
                } else {
                    bVar.ifS.setVisibility(8);
                    bVar.ifQ.setVisibility(8);
                    bVar.ifT.setVisibility(8);
                }
                bVar.ifS.setVisibility(0);
                bVar.ifQ.setVisibility(0);
                bVar.ifT.setVisibility(0);
                a(bVar.hPb, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.ifR.setVisibility(8);
            }
            bVar.hPb.getLayoutStrategy().kB(R.drawable.pic_video);
            bVar.hPb.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.hPb.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.hPb.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.hNy) {
                bVar.hPb.getLayoutStrategy().kE(R.drawable.transparent_bg);
            } else {
                bVar.hPb.getLayoutStrategy().kE(R.drawable.icon_click);
            }
            bVar.hPb.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cop();
            }
            if (this.hOR || !this.hOS) {
                bVar.hPb.setText(tbRichText, false);
            } else {
                bVar.hPb.setText(tbRichText, true);
            }
            bf aik = this.hNw.bQx().aik();
            if (aik != null) {
                bVar.ifP.startLoad(this.hNw.bQx().aik().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float aia = aik.aia() / aik.ahZ();
                if (aia > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (aia < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * aia);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.ifP.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.ifP.setLayoutParams(layoutParams2);
            } else {
                bVar.ifP.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.hNy) {
            bVar.hPb.setOnClickListener(null);
        } else {
            bVar.hPb.setOnClickListener(this.ZF);
        }
        bVar.hPb.setTextViewCheckSelection(false);
        bVar.hPb.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().kC(this.ifN - (i - this.ifM));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.hPb.setOnLongClickListener(this.mOnLongClickListener);
        bVar.hPb.setOnTouchListener(this.cyE);
        bVar.hPb.setOnImageClickListener(this.cTN);
        bVar.hPb.setOnEmotionClickListener(((PbActivity) this.hNh.getPageContext().getOrignalPage()).hLg.hYE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(d dVar) {
        this.hNw = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void cD(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void wp(int i) {
        this.hNF = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nT(boolean z) {
        this.hNy = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nU(boolean z) {
        this.hNz = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void nV(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void O(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cTN = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void w(View.OnClickListener onClickListener) {
        this.ZF = onClickListener;
    }
}
