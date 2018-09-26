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
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class a extends k<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnLongClickListener aKx;
    private c bjA;
    private TbRichTextView.h bjz;
    private int fFA;
    private d fFs;
    private boolean fFt;
    private boolean fFu;
    private boolean fGI;
    private final boolean fGJ;
    private boolean fSX;
    private int fWP;
    private int fWQ;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fFA = 0;
        this.fFt = true;
        this.fSX = true;
        this.fFs = null;
        this.fFu = true;
        this.mCommonClickListener = null;
        this.bjz = null;
        this.bjA = null;
        this.aKx = null;
        this.fGI = false;
        this.fGJ = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        ap(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void ap(PbActivity pbActivity) {
        super.ap(pbActivity);
        if (pbActivity != null) {
            this.fWP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds30);
            this.fWQ = l.aO(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bu */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(e.h.pb_interview_normal_item, viewGroup, false), this.fSX, this.fFt, this.fFA, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, bVar);
        al.j(view, e.d.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.fGR, (int) this.mContext.getResources().getDimension(e.C0141e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fGR.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fGR.setLayoutParams(layoutParams);
            bVar.fGR.setPadding(0, 0, 0, 0);
            bVar.fGR.it(null);
            postData.xj();
            if (postData.byM() == 1) {
                bVar.fWU.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.wm() != null) {
                    j = postData.wm().getUserIdLong();
                    str = postData.wm().getUserName();
                    str2 = postData.wm().getName_show();
                }
                bVar.fWU.a(postData.byU(), str, str2, j, com.baidu.adp.lib.g.b.d(this.fFs.bbJ().getId(), 0L), com.baidu.adp.lib.g.b.d(postData.getId(), 0L));
                bVar.fWU.onChangeSkinType();
                if (this.fFu) {
                    PraiseData vZ = this.fFs.bbJ().vZ();
                    if (vZ != null && vZ.getUser() != null && vZ.getUser().size() > 0) {
                        bVar.fWV.setVisibility(0);
                        bVar.fWT.setVisibility(0);
                        bVar.fWW.setVisibility(0);
                        bVar.fWV.setIsFromPb(true);
                        bVar.fWV.setData(vZ, this.fFs.bbJ().getId(), vZ.getPostId(), true);
                        bVar.fWV.dQ(this.mSkinType);
                    } else {
                        bVar.fWV.setVisibility(8);
                        bVar.fWT.setVisibility(8);
                        bVar.fWW.setVisibility(8);
                    }
                } else {
                    bVar.fWV.setVisibility(8);
                    bVar.fWT.setVisibility(8);
                    bVar.fWW.setVisibility(8);
                }
                bVar.fWV.setVisibility(0);
                bVar.fWT.setVisibility(0);
                bVar.fWW.setVisibility(0);
                a(bVar.fGR, (int) this.mContext.getResources().getDimension(e.C0141e.ds30));
            } else {
                bVar.fWU.setVisibility(8);
            }
            bVar.fGR.getLayoutStrategy().fZ(e.f.pic_video);
            bVar.fGR.setTextColor(al.getColor(e.d.common_color_10039));
            bVar.fGR.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            bVar.fGR.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            if (this.fFt) {
                bVar.fGR.getLayoutStrategy().gc(e.f.transparent_bg);
            } else {
                bVar.fGR.getLayoutStrategy().gc(e.f.icon_click);
            }
            bVar.fGR.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.byO();
            }
            if (this.fGI || !this.fGJ) {
                bVar.fGR.setText(tbRichText, false);
            } else {
                bVar.fGR.setText(tbRichText, true);
            }
            ba vT = this.fFs.bbJ().vT();
            if (vT != null) {
                bVar.fWS.startLoad(this.fFs.bbJ().vT().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int aO = l.aO(this.mContext);
                float vR = vT.vR() / vT.vQ();
                if (vR > 1.0f) {
                    i = (int) (1.0f * aO);
                } else if (vR < 0.2f) {
                    i = (int) (aO * 0.2f);
                } else {
                    i = (int) (aO * vR);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fWS.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = aO;
                bVar.fWS.setLayoutParams(layoutParams2);
            } else {
                bVar.fWS.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fFt) {
            bVar.fGR.setOnClickListener(null);
        } else {
            bVar.fGR.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fGR.setTextViewCheckSelection(false);
        bVar.fGR.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().ga(this.fWQ - (i - this.fWP));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fGR.setOnLongClickListener(this.aKx);
        bVar.fGR.setOnTouchListener(this.bjA);
        bVar.fGR.setOnImageClickListener(this.bjz);
        bVar.fGR.setOnEmotionClickListener(((PbActivity) this.fFd.getPageContext().getOrignalPage()).fDh.fQx);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(d dVar) {
        this.fFs = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void qQ(int i) {
        this.fFA = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jU(boolean z) {
        this.fFt = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jV(boolean z) {
        this.fFu = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jW(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void G(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bjz = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aKx = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
