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
    private TbRichTextView.i dMw;
    private c dqJ;
    private e iEG;
    private boolean iEH;
    private boolean iEI;
    private int iEO;
    private boolean iGq;
    private final boolean iGr;
    private boolean jdb;
    private int jdc;
    private int jdd;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        boolean z = true;
        this.iEO = 0;
        this.iEH = true;
        this.jdb = true;
        this.iEG = null;
        this.iEI = true;
        this.akt = null;
        this.dMw = null;
        this.dqJ = null;
        this.mOnLongClickListener = null;
        this.iGq = false;
        this.iGr = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        a(pbFragment);
    }

    @Override // com.baidu.tieba.pb.pb.main.l
    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        super.a(bVar);
        if (bVar != null) {
            this.jdc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.jdd = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bT */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(R.layout.pb_interview_normal_item, viewGroup, false), this.jdb, this.iEH, this.iEO, false);
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
            a(bVar.iGA, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.iGA.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.iGA.setLayoutParams(layoutParams);
            bVar.iGA.setPadding(0, 0, 0, 0);
            bVar.iGA.wh(null);
            postData.aDu();
            if (postData.cKY() == 1) {
                bVar.jdh.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.aCm() != null) {
                    j = postData.aCm().getUserIdLong();
                    str = postData.aCm().getUserName();
                    str2 = postData.aCm().getName_show();
                }
                bVar.jdh.a(postData.cLg(), str, str2, j, com.baidu.adp.lib.f.b.toLong(this.iEG.cks().getId(), 0L), com.baidu.adp.lib.f.b.toLong(postData.getId(), 0L));
                bVar.jdh.onChangeSkinType();
                if (this.iEI) {
                    PraiseData aBX = this.iEG.cks().aBX();
                    if (aBX != null && aBX.getUser() != null && aBX.getUser().size() > 0) {
                        bVar.jdi.setVisibility(0);
                        bVar.jdg.setVisibility(0);
                        bVar.jdj.setVisibility(0);
                        bVar.jdi.setIsFromPb(true);
                        bVar.jdi.setData(aBX, this.iEG.cks().getId(), aBX.getPostId(), true);
                        bVar.jdi.onChangeSkin(this.mSkinType);
                    } else {
                        bVar.jdi.setVisibility(8);
                        bVar.jdg.setVisibility(8);
                        bVar.jdj.setVisibility(8);
                    }
                } else {
                    bVar.jdi.setVisibility(8);
                    bVar.jdg.setVisibility(8);
                    bVar.jdj.setVisibility(8);
                }
                bVar.jdi.setVisibility(0);
                bVar.jdg.setVisibility(0);
                bVar.jdj.setVisibility(0);
                a(bVar.iGA, (int) this.mContext.getResources().getDimension(R.dimen.ds30));
            } else {
                bVar.jdh.setVisibility(8);
            }
            bVar.iGA.getLayoutStrategy().nh(R.drawable.pic_video);
            bVar.iGA.setTextColor(am.getColor(R.color.common_color_10039));
            bVar.iGA.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            bVar.iGA.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            if (this.iEH) {
                bVar.iGA.getLayoutStrategy().nk(R.drawable.transparent_bg);
            } else {
                bVar.iGA.getLayoutStrategy().nk(R.drawable.icon_click);
            }
            bVar.iGA.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.cLa();
            }
            if (this.iGq || !this.iGr) {
                bVar.iGA.setText(tbRichText, false);
            } else {
                bVar.iGA.setText(tbRichText, true);
            }
            bh aBS = this.iEG.cks().aBS();
            if (aBS != null) {
                bVar.jdf.startLoad(this.iEG.cks().aBS().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
                float aBI = aBS.aBI() / aBS.aBH();
                if (aBI > 1.0f) {
                    i = (int) (1.0f * equipmentWidth);
                } else if (aBI < 0.2f) {
                    i = (int) (equipmentWidth * 0.2f);
                } else {
                    i = (int) (equipmentWidth * aBI);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.jdf.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = equipmentWidth;
                bVar.jdf.setLayoutParams(layoutParams2);
            } else {
                bVar.jdf.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.iEH) {
            bVar.iGA.setOnClickListener(null);
        } else {
            bVar.iGA.setOnClickListener(this.akt);
        }
        bVar.iGA.setTextViewCheckSelection(false);
        bVar.iGA.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().ni(this.jdd - (i - this.jdc));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.iGA.setOnLongClickListener(this.mOnLongClickListener);
        bVar.iGA.setOnTouchListener(this.dqJ);
        bVar.iGA.setOnImageClickListener(this.dMw);
        if (this.iGe != null && this.iGe.cng() != null) {
            bVar.iGA.setOnEmotionClickListener(this.iGe.cng().iEi.iSE);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setData(e eVar) {
        this.iEG = eVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void dI(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setImageMaxWidth(int i) {
        this.iEO = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void pw(boolean z) {
        this.iEH = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void px(boolean z) {
        this.iEI = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void py(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void P(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMw = iVar;
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
