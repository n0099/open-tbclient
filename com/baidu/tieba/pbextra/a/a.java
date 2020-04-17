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
    private View.OnClickListener aDc;
    private c dRh;
    private TbRichTextView.i emS;
    private boolean jOT;
    private int jOU;
    private int jOV;
    private e jqC;
    private boolean jqD;
    private boolean jqE;
    private int jqK;
    private boolean jsm;
    private final boolean jsn;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.jqK = 0;
        this.jqD = true;
        this.jOT = true;
        this.jqC = null;
        this.jqE = true;
        this.aDc = null;
        this.emS = null;
        this.dRh = null;
        this.mOnLongClickListener = null;
        this.jsm = false;
        this.jsn = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.l
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.jOU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.jOV = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bW */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.jOT, this.jqD, this.jqK, false);
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
            a(bVar.jsw, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.jsw.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.jsw.setLayoutParams(layoutParams);
            bVar.jsw.setPadding(0, 0, 0, 0);
            bVar.jsw.xv(null);
            postData.aLN();
            if (postData.cWr() == 1) {
                bVar.jOZ.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aKE() != null) {
                    j = postData.aKE().getUserIdLong();
                    str = postData.aKE().getUserName();
                    str2 = postData.aKE().getName_show();
                }
                bVar.jOZ.a(postData.cWz(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.jqC.cvu().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.jOZ.onChangeSkinType();
                if (this.jqE) {
                    PraiseData aKp = this.jqC.cvu().aKp();
                    if (aKp != null && aKp.getUser() != null && aKp.getUser().size() > 0) {
                        bVar.jPa.setVisibility(0);
                        bVar.jOY.setVisibility(0);
                        bVar.jPb.setVisibility(0);
                        bVar.jPa.setIsFromPb(true);
                        bVar.jPa.setData(aKp, this.jqC.cvu().getId(), aKp.getPostId(), true);
                        bVar.jPa.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.jPa.setVisibility(8);
                        bVar.jOY.setVisibility(8);
                        bVar.jPb.setVisibility(8);
                    }
                } else {
                    bVar.jPa.setVisibility(8);
                    bVar.jOY.setVisibility(8);
                    bVar.jPb.setVisibility(8);
                }
                bVar.jPa.setVisibility(0);
                bVar.jOY.setVisibility(0);
                bVar.jPb.setVisibility(0);
                a(bVar.jsw, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.jOZ.setVisibility(8);
            }
            bVar.jsw.getLayoutStrategy().nv(R.drawable.pic_video);
            bVar.jsw.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.jsw.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.jsw.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.jqD) {
                bVar.jsw.getLayoutStrategy().ny(R.drawable.transparent_bg);
            } else {
                bVar.jsw.getLayoutStrategy().ny(R.drawable.icon_click);
            }
            bVar.jsw.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cWt();
            }
            if (this.jsm || !this.jsn) {
                bVar.jsw.setText(tbRichText, false);
            } else {
                bVar.jsw.setText(tbRichText, true);
            }
            bh aKk = this.jqC.cvu().aKk();
            if (aKk != null) {
                bVar.jOX.startLoad(this.jqC.cvu().aKk().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
                float aKa = aKk.aKa() / aKk.aJZ();
                if (aKa > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (aKa < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * aKa);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.jOX.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.jOX.setLayoutParams(layoutParams2);
            } else {
                bVar.jOX.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.jqD) {
            bVar.jsw.setOnClickListener(null);
        } else {
            bVar.jsw.setOnClickListener(this.aDc);
        }
        bVar.jsw.setTextViewCheckSelection(false);
        bVar.jsw.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().nw(this.jOV - (i - this.jOU));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.jsw.setOnLongClickListener(this.mOnLongClickListener);
        bVar.jsw.setOnTouchListener(this.dRh);
        bVar.jsw.setOnImageClickListener(this.emS);
        if (this.jsa != null && this.jsa.cyk() != null) {
            bVar.jsw.setOnEmotionClickListener(this.jsa.cyk().jqe.jEC);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(e eVar) {
        this.jqC = eVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void eA(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.jqK = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void qG(boolean z) {
        this.jqD = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void qH(boolean z) {
        this.jqE = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void qI(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void Q(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.emS = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void z(View.OnClickListener onClickListener) {
        this.aDc = onClickListener;
    }
}
