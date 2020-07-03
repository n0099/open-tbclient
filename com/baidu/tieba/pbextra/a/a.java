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
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.util.an;
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
    private View.OnClickListener aLl;
    private TbRichTextView.i eLw;
    private c eor;
    private boolean kBI;
    private int kBJ;
    private int kBK;
    private e kck;
    private boolean kcl;
    private boolean kcm;
    private int kcs;
    private boolean kea;
    private final boolean keb;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.kcs = 0;
        this.kcl = true;
        this.kBI = true;
        this.kck = null;
        this.kcm = true;
        this.aLl = null;
        this.eLw = null;
        this.eor = null;
        this.mOnLongClickListener = null;
        this.kea = false;
        this.keb = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.m
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.kBJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.kBK = l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cv */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.kBI, this.kcl, this.kcs, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.m, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) bVar);
        an.setBackgroundColor(view, R.color.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.kel, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.kel.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.kel.setLayoutParams(layoutParams);
            bVar.kel.setPadding(0, 0, 0, 0);
            bVar.kel.zx(null);
            postData.aTB();
            if (postData.dhY() == 1) {
                bVar.kBO.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aSp() != null) {
                    j = postData.aSp().getUserIdLong();
                    str = postData.aSp().getUserName();
                    str2 = postData.aSp().getName_show();
                }
                bVar.kBO.a(postData.dig(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.kck.cGN().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.kBO.onChangeSkinType();
                if (this.kcm) {
                    PraiseData aSa = this.kck.cGN().aSa();
                    if (aSa != null && aSa.getUser() != null && aSa.getUser().size() > 0) {
                        bVar.kBP.setVisibility(0);
                        bVar.kBN.setVisibility(0);
                        bVar.kBQ.setVisibility(0);
                        bVar.kBP.setIsFromPb(true);
                        bVar.kBP.setData(aSa, this.kck.cGN().getId(), aSa.getPostId(), true);
                        bVar.kBP.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.kBP.setVisibility(8);
                        bVar.kBN.setVisibility(8);
                        bVar.kBQ.setVisibility(8);
                    }
                } else {
                    bVar.kBP.setVisibility(8);
                    bVar.kBN.setVisibility(8);
                    bVar.kBQ.setVisibility(8);
                }
                bVar.kBP.setVisibility(0);
                bVar.kBN.setVisibility(0);
                bVar.kBQ.setVisibility(0);
                a(bVar.kel, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.kBO.setVisibility(8);
            }
            bVar.kel.getLayoutStrategy().ox(R.drawable.pic_video);
            bVar.kel.setTextColor(an.getColor(R.color.common_color_10039));
            bVar.kel.setLinkTextColor(an.getColor(R.color.cp_link_tip_c));
            bVar.kel.setLinkTextColor(an.getColor(R.color.cp_link_tip_c));
            if (this.kcl) {
                bVar.kel.getLayoutStrategy().oA(R.drawable.transparent_bg);
            } else {
                bVar.kel.getLayoutStrategy().oA(R.drawable.icon_click);
            }
            bVar.kel.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.dia();
            }
            if (this.kea || !this.keb) {
                bVar.kel.setText(tbRichText, false);
            } else {
                bVar.kel.setText(tbRichText, true);
            }
            bs aRV = this.kck.cGN().aRV();
            if (aRV != null) {
                bVar.kBM.startLoad(this.kck.cGN().aRV().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext);
                float aRK = aRV.aRK() / aRV.aRJ();
                if (aRK > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (aRK < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * aRK);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.kBM.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.kBM.setLayoutParams(layoutParams2);
            } else {
                bVar.kBM.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kcl) {
            bVar.kel.setOnClickListener(null);
        } else {
            bVar.kel.setOnClickListener(this.aLl);
        }
        bVar.kel.setTextViewCheckSelection(false);
        bVar.kel.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().oy(this.kBK - (i - this.kBJ));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.kel.setOnLongClickListener(this.mOnLongClickListener);
        bVar.kel.setOnTouchListener(this.eor);
        bVar.kel.setOnImageClickListener(this.eLw);
        if (this.kdO != null && this.kdO.cJI() != null) {
            bVar.kel.setOnEmotionClickListener(this.kdO.cJI().kbH.krb);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(e eVar) {
        this.kck = eVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void fr(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.kcs = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void rr(boolean z) {
        this.kcl = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void rs(boolean z) {
        this.kcm = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void rt(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void R(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eLw = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void z(View.OnClickListener onClickListener) {
        this.aLl = onClickListener;
    }
}
