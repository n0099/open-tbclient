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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class a extends k<PostData, b> implements View.OnClickListener, com.baidu.tieba.pb.pb.a.a {
    private View.OnLongClickListener aHk;
    private TbRichTextView.h bgd;
    private c bge;
    private boolean fLy;
    private int fPH;
    private int fPI;
    private d fxI;
    private boolean fxJ;
    private boolean fxK;
    private int fxQ;
    private boolean fze;
    private final boolean fzf;
    private View.OnClickListener mCommonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
        boolean z = true;
        this.fxQ = 0;
        this.fxJ = true;
        this.fLy = true;
        this.fxI = null;
        this.fxK = true;
        this.mCommonClickListener = null;
        this.bgd = null;
        this.bge = null;
        this.aHk = null;
        this.fze = false;
        this.fzf = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT > 16) ? false : z;
        ap(pbActivity);
    }

    @Override // com.baidu.tieba.pb.pb.main.k
    public void ap(PbActivity pbActivity) {
        super.ap(pbActivity);
        if (pbActivity != null) {
            this.fPH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds30);
            this.fPI = l.ah(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds60);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(d.h.pb_interview_normal_item, viewGroup, false), this.fLy, this.fxJ, this.fxQ, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, PostData postData, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, postData, bVar);
        am.j(view, d.C0140d.cp_bg_line_d);
        a(bVar);
        a(bVar, postData);
        return view;
    }

    private void a(b bVar, PostData postData) {
        int i;
        if (bVar != null && postData != null) {
            a(bVar.fzm, (int) this.mContext.getResources().getDimension(d.e.ds30));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fzm.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            bVar.fzm.setLayoutParams(layoutParams);
            bVar.fzm.setPadding(0, 0, 0, 0);
            bVar.fzm.hU(null);
            postData.wf();
            if (postData.bwf() == 1) {
                bVar.fPM.setVisibility(0);
                String str = null;
                String str2 = null;
                long j = 0;
                if (postData.vk() != null) {
                    j = postData.vk().getUserIdLong();
                    str = postData.vk().getUserName();
                    str2 = postData.vk().getName_show();
                }
                bVar.fPM.a(postData.bwn(), str, str2, j, com.baidu.adp.lib.g.b.c(this.fxI.aZn().getId(), 0L), com.baidu.adp.lib.g.b.c(postData.getId(), 0L));
                bVar.fPM.onChangeSkinType();
                if (this.fxK) {
                    PraiseData uX = this.fxI.aZn().uX();
                    if (uX != null && uX.getUser() != null && uX.getUser().size() > 0) {
                        bVar.fPN.setVisibility(0);
                        bVar.fPL.setVisibility(0);
                        bVar.fPO.setVisibility(0);
                        bVar.fPN.setIsFromPb(true);
                        bVar.fPN.setData(uX, this.fxI.aZn().getId(), uX.getPostId(), true);
                        bVar.fPN.dG(this.mSkinType);
                    } else {
                        bVar.fPN.setVisibility(8);
                        bVar.fPL.setVisibility(8);
                        bVar.fPO.setVisibility(8);
                    }
                } else {
                    bVar.fPN.setVisibility(8);
                    bVar.fPL.setVisibility(8);
                    bVar.fPO.setVisibility(8);
                }
                bVar.fPN.setVisibility(0);
                bVar.fPL.setVisibility(0);
                bVar.fPO.setVisibility(0);
                a(bVar.fzm, (int) this.mContext.getResources().getDimension(d.e.ds30));
            } else {
                bVar.fPM.setVisibility(8);
            }
            bVar.fzm.getLayoutStrategy().fO(d.f.pic_video);
            bVar.fzm.setTextColor(am.getColor(d.C0140d.common_color_10039));
            bVar.fzm.setLinkTextColor(am.getColor(d.C0140d.cp_link_tip_c));
            bVar.fzm.setLinkTextColor(am.getColor(d.C0140d.cp_link_tip_c));
            if (this.fxJ) {
                bVar.fzm.getLayoutStrategy().fR(d.f.transparent_bg);
            } else {
                bVar.fzm.getLayoutStrategy().fR(d.f.icon_click);
            }
            bVar.fzm.setIsFromCDN(this.mIsFromCDN);
            TbRichText tbRichText = null;
            if (0 == 0) {
                tbRichText = postData.bwh();
            }
            if (this.fze || !this.fzf) {
                bVar.fzm.setText(tbRichText, false);
            } else {
                bVar.fzm.setText(tbRichText, true);
            }
            ba uR = this.fxI.aZn().uR();
            if (uR != null) {
                bVar.fPK.startLoad(this.fxI.aZn().uR().getThreadImgUrl(), this.mIsFromCDN ? 17 : 18, false);
                int ah = l.ah(this.mContext);
                float uP = uR.uP() / uR.uO();
                if (uP > 1.0f) {
                    i = (int) (1.0f * ah);
                } else if (uP < 0.2f) {
                    i = (int) (ah * 0.2f);
                } else {
                    i = (int) (ah * uP);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fPK.getLayoutParams();
                layoutParams2.height = i;
                layoutParams2.width = ah;
                bVar.fPK.setLayoutParams(layoutParams2);
            } else {
                bVar.fPK.setVisibility(8);
            }
            b(bVar, postData);
        }
    }

    private void b(b bVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.fxJ) {
            bVar.fzm.setOnClickListener(null);
        } else {
            bVar.fzm.setOnClickListener(this.mCommonClickListener);
        }
        bVar.fzm.setTextViewCheckSelection(false);
        bVar.fzm.setTextViewOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.getLayoutStrategy().fP(this.fPI - (i - this.fPH));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(b bVar) {
        bVar.fzm.setOnLongClickListener(this.aHk);
        bVar.fzm.setOnTouchListener(this.bge);
        bVar.fzm.setOnImageClickListener(this.bgd);
        bVar.fzm.setOnEmotionClickListener(((PbActivity) this.fxt.getPageContext().getOrignalPage()).fvw.fIY);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.fxI = dVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setHostId(String str) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void qp(int i) {
        this.fxQ = i;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jt(boolean z) {
        this.fxJ = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void ju(boolean z) {
        this.fxK = z;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void jv(boolean z) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void G(View.OnClickListener onClickListener) {
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bgd = hVar;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHk = onLongClickListener;
    }

    @Override // com.baidu.tieba.pb.pb.a.a
    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
