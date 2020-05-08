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
    private View.OnClickListener aDi;
    private c dRm;
    private TbRichTextView.i emX;
    private boolean jOX;
    private int jOY;
    private int jOZ;
    private e jqG;
    private boolean jqH;
    private boolean jqI;
    private int jqO;
    private boolean jsq;
    private final boolean jsr;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.jqO = 0;
        this.jqH = true;
        this.jOX = true;
        this.jqG = null;
        this.jqI = true;
        this.aDi = null;
        this.emX = null;
        this.dRm = null;
        this.mOnLongClickListener = null;
        this.jsq = false;
        this.jsr = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.l
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.jOY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.jOZ = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bW */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.jOX, this.jqH, this.jqO, false);
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
            a(bVar.jsA, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.jsA.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.jsA.setLayoutParams(layoutParams);
            bVar.jsA.setPadding(0, 0, 0, 0);
            bVar.jsA.xy(null);
            postData.aLL();
            if (postData.cWo() == 1) {
                bVar.jPd.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aKC() != null) {
                    j = postData.aKC().getUserIdLong();
                    str = postData.aKC().getUserName();
                    str2 = postData.aKC().getName_show();
                }
                bVar.jPd.a(postData.cWw(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.jqG.cvr().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.jPd.onChangeSkinType();
                if (this.jqI) {
                    PraiseData aKn = this.jqG.cvr().aKn();
                    if (aKn != null && aKn.getUser() != null && aKn.getUser().size() > 0) {
                        bVar.jPe.setVisibility(0);
                        bVar.jPc.setVisibility(0);
                        bVar.jPf.setVisibility(0);
                        bVar.jPe.setIsFromPb(true);
                        bVar.jPe.setData(aKn, this.jqG.cvr().getId(), aKn.getPostId(), true);
                        bVar.jPe.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.jPe.setVisibility(8);
                        bVar.jPc.setVisibility(8);
                        bVar.jPf.setVisibility(8);
                    }
                } else {
                    bVar.jPe.setVisibility(8);
                    bVar.jPc.setVisibility(8);
                    bVar.jPf.setVisibility(8);
                }
                bVar.jPe.setVisibility(0);
                bVar.jPc.setVisibility(0);
                bVar.jPf.setVisibility(0);
                a(bVar.jsA, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.jPd.setVisibility(8);
            }
            bVar.jsA.getLayoutStrategy().nv(R.drawable.pic_video);
            bVar.jsA.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.jsA.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.jsA.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.jqH) {
                bVar.jsA.getLayoutStrategy().ny(R.drawable.transparent_bg);
            } else {
                bVar.jsA.getLayoutStrategy().ny(R.drawable.icon_click);
            }
            bVar.jsA.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cWq();
            }
            if (this.jsq || !this.jsr) {
                bVar.jsA.setText(tbRichText, false);
            } else {
                bVar.jsA.setText(tbRichText, true);
            }
            bh aKi = this.jqG.cvr().aKi();
            if (aKi != null) {
                bVar.jPb.startLoad(this.jqG.cvr().aKi().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
                float aJY = aKi.aJY() / aKi.aJX();
                if (aJY > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (aJY < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * aJY);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.jPb.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.jPb.setLayoutParams(layoutParams2);
            } else {
                bVar.jPb.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.jqH) {
            bVar.jsA.setOnClickListener(null);
        } else {
            bVar.jsA.setOnClickListener(this.aDi);
        }
        bVar.jsA.setTextViewCheckSelection(false);
        bVar.jsA.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().nw(this.jOZ - (i - this.jOY));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.jsA.setOnLongClickListener(this.mOnLongClickListener);
        bVar.jsA.setOnTouchListener(this.dRm);
        bVar.jsA.setOnImageClickListener(this.emX);
        if (this.jse != null && this.jse.cyh() != null) {
            bVar.jsA.setOnEmotionClickListener(this.jse.cyh().jqi.jEG);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(e eVar) {
        this.jqG = eVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void eA(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.jqO = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void qG(boolean z) {
        this.jqH = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void qH(boolean z) {
        this.jqI = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void qI(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void Q(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.emX = iVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void z(View.OnClickListener onClickListener) {
        this.aDi = onClickListener;
    }
}
