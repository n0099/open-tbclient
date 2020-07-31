package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class m extends o<PostData, n> implements View.OnClickListener {
    private View.OnClickListener aMH;
    private String aTI;
    private int aTp;
    private LayerDrawable ahB;
    private LayerDrawable ahC;
    private int azq;
    private TbRichTextView.i eRR;
    private boolean eVb;
    private com.baidu.tieba.pb.a.c euG;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hLg;
    private com.baidu.adp.lib.d.b<TbImageView> hLh;
    private int ilI;
    private int imj;
    private int kjp;
    private LayerDrawable kjq;
    protected com.baidu.tieba.pb.data.f kkM;
    private boolean kkN;
    private View.OnClickListener kkW;
    private TbRichTextView.c klC;
    private com.baidu.tieba.pb.pb.sub.b klD;
    private boolean klE;
    private boolean klF;
    private com.baidu.tieba.pb.a.c klG;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(View view) {
        if (view != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (this.klE && nVar.kmk != null && nVar.kmk.getData() != null) {
                nVar.kmk.bbK();
            }
            if (nVar.klT != null && nVar.klT.getData() != null) {
                nVar.klT.bbK();
            }
        }
    }

    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.aTp = 0;
        this.ilI = 0;
        this.kjp = 0;
        this.imj = 0;
        this.klC = null;
        this.kkN = true;
        this.aTI = null;
        this.kkM = null;
        this.kkW = null;
        this.aMH = null;
        this.eRR = null;
        this.euG = null;
        this.mOnLongClickListener = null;
        this.klD = null;
        this.eVb = true;
        this.klE = com.baidu.tbadk.a.d.aRO();
        this.klF = com.baidu.tbadk.a.d.aRP();
        this.hLg = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cdX */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(m.this.mContext);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.hLh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bcD */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(m.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.ao.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.klG = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.m.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (m.this.kjZ == null || m.this.kjZ.cMF() == null || m.this.kjZ.cMF().cPB())) {
                    if (view instanceof RelativeLayout) {
                        m.this.cH(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                m.this.cH((RelativeLayout) parent);
                                break;
                            } else {
                                i++;
                                parent = parent.getParent();
                            }
                        }
                    }
                }
                return true;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
                if (m.this.euG != null) {
                    if (!(view instanceof TbListTextView) || m.this.aMH == null) {
                        m.this.euG.W(view);
                        m.this.euG.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    m.this.aMH.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.cLP() != null) {
            this.azq = bVar.cLP().cOv();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cg */
    public n b(ViewGroup viewGroup) {
        n nVar = new n(this.kmC.cNt().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.azq, this.klE, this.klF);
        nVar.klW.setConstrainLayoutPool(this.hLg);
        nVar.klW.setImageViewPool(this.hLh);
        if (nVar.klY != null) {
            nVar.klY.setShowChildComment(this.klF);
        }
        a(nVar);
        this.aTp = getDimensionPixelSize(R.dimen.tbds10);
        this.ilI = getDimensionPixelSize(R.dimen.tbds14);
        this.kjp = getDimensionPixelSize(R.dimen.tbds36);
        this.imj = getDimensionPixelSize(R.dimen.tbds6);
        if (nVar.klV != null) {
            nVar.klV.setDuiEnabled(this.eVb);
        }
        sv();
        return nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.o, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, n nVar) {
        super.a(i, view, viewGroup, (ViewGroup) postData, (PostData) nVar);
        a(nVar);
        b(nVar);
        c(nVar);
        PostData postData2 = (PostData) getItem(i);
        if (postData2 != null) {
            postData2.locate = i + 1;
            j(postData2);
            l(postData2);
            postData2.aXx();
            i(postData2);
            a(nVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.eVb = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.lNV) {
                i = 2;
            }
            com.baidu.tbadk.core.util.ap b = com.baidu.tieba.pb.c.a.b(this.kkM, postData, postData.locate, i, 6);
            postData.lNW = b;
            if (!com.baidu.tbadk.core.util.x.isEmpty(postData.dle())) {
                Iterator<PostData> it = postData.dle().iterator();
                while (it.hasNext()) {
                    it.next().lNW = b;
                }
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            if (this.klE && this.klF) {
                nVar.klX.setVisibility(8);
                nVar.kmc.setVisibility(0);
            } else if (this.klE) {
                nVar.kmc.setVisibility(0);
                nVar.klX.setVisibility(0);
                nVar.kmb.setVisibility(8);
                nVar.iEP.setVisibility(8);
                nVar.klT.setVisibility(8);
            } else {
                nVar.kmc.setVisibility(8);
                nVar.klX.setVisibility(0);
                nVar.kmb.setVisibility(0);
                nVar.iEP.setVisibility(0);
                nVar.klT.setVisibility(0);
            }
            b(nVar, postData, view, i);
            f(nVar, postData);
            b(nVar, postData, this.klE);
            a(nVar, postData, view);
            c(nVar, postData, view, i);
            g(nVar, postData);
            a(nVar, postData);
            h(nVar, postData);
            c(nVar, postData);
            e(nVar, postData);
            i(nVar, postData);
            b(nVar, postData);
        }
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.klN != null) {
            if (this.kmC != null && this.kmC.cLP() != null && this.kmC.cLP().cOD() && com.baidu.tbadk.core.util.as.equals(this.kmC.cLP().cNK(), postData.getId())) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(nVar.klN, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(nVar.klN, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, boolean z, String str) {
        if (z) {
            nVar.kmx.setVisibility(8);
            if (StringUtils.isNull(str)) {
                nVar.kmz.setText(R.string.expand_content);
                return;
            } else {
                nVar.kmz.setText(str);
                return;
            }
        }
        nVar.kmx.setVisibility(0);
        nVar.kmz.setText(R.string.close_content);
    }

    private void c(final n nVar, final PostData postData) {
        if (postData.dlt() == 2 || postData.dlt() == 4) {
            nVar.kmy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = nVar.kmx.getVisibility() == 8;
                    m.this.a(nVar, !z, postData.cKI());
                    postData.vk(z ? false : true);
                    m.this.d(nVar, postData);
                    if (m.this.kjZ != null && m.this.kjZ.cMF() != null && m.this.kjZ.cMF().cQD() != null && m.this.kjZ.cMF().getListView() != null && !z && nVar.getView().getTop() < m.this.kjZ.cMF().cQD().getMeasuredHeight()) {
                        m.this.kjZ.cMF().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.x.getPosition(m.this.kjZ.cMF().getListView().getData(), postData) + m.this.kjZ.cMF().getListView().getHeaderViewsCount(), m.this.kjZ.cMF().cQD().getMeasuredHeight());
                    }
                }
            });
            nVar.kmy.setVisibility(0);
            a(nVar, postData.dlc(), postData.cKI());
            a(true, nVar, postData);
        } else {
            nVar.kmy.setVisibility(8);
            nVar.kmx.setVisibility(0);
            a(false, nVar, postData);
        }
        d(nVar, postData);
    }

    private void a(boolean z, n nVar, PostData postData) {
        if (nVar != null && nVar.mBottomLine != null && nVar.kmy != null && (nVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (nVar.kmy.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.x.isEmpty(postData.dle());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) nVar.kmy.getLayoutParams();
            if (z) {
                nVar.klV.getLayoutStrategy().oZ(0);
                if (z2) {
                    nVar.klV.getLayoutStrategy().oY(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    nVar.klV.getLayoutStrategy().oY(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                nVar.kmy.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    nVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            nVar.klV.getLayoutStrategy().oY(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            nVar.klV.getLayoutStrategy().oZ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                if (this.klE) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds0);
                } else {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38);
                }
                nVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(n nVar, PostData postData) {
        TbRichText dlj = postData.dlj();
        dlj.isChanged = true;
        nVar.klV.setText(dlj, true, this.klC);
    }

    private void j(PostData postData) {
        if (postData.dTc == 0 && postData.hND) {
            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c12203");
            apVar.dn("post_id", postData.getId());
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.dn("cuid", TbadkCoreApplication.getInst().getCuid());
            apVar.dn("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            apVar.dn("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            apVar.dn("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            apVar.t(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.kmC != null) {
                int cOv = this.kmC.cLP().cOv();
                if (1 == cOv || 2 == cOv) {
                    apVar.dn("obj_source", "1");
                } else if (3 == cOv) {
                    apVar.dn("obj_source", "2");
                } else {
                    apVar.dn("obj_source", "0");
                }
            }
            TiebaStatic.log(apVar);
            if (postData.aWl() != null && postData.aWl().getAlaInfo() != null && postData.aWl().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.aWl().getUserId();
        String forumId = this.kkM != null ? this.kkM.getForumId() : "";
        String forumName = this.kkM != null ? this.kkM.getForumName() : "";
        int dlh = postData.dlh();
        String id = postData.getId();
        com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13714");
        apVar.dn("fid", forumId);
        apVar.dn("fname", forumName);
        apVar.dn("obj_param1", userId);
        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
        apVar.dn("tid", id);
        apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, dlh);
        TiebaStatic.log(apVar);
    }

    private void l(PostData postData) {
        if (this.kkM != null) {
            if (this.kkM.cKX()) {
                if (this.kmD != null) {
                    com.baidu.tieba.pb.c.a.a(this.kmD.getUniqueId(), this.kkM, postData, postData.locate, postData.lNV ? 2 : 8);
                }
            } else if (this.kjZ != null) {
                com.baidu.tieba.pb.c.a.a(this.kjZ.getUniqueId(), this.kkM, postData, postData.locate, postData.lNV ? 2 : 8);
            }
        }
    }

    private void a(n nVar, PostData postData) {
        if (postData == null || postData.cSs() == null) {
            nVar.kmr.setVisibility(8);
            return;
        }
        TbRichText dlj = postData.dlj();
        com.baidu.tieba.pb.view.b.a(postData.cSs(), nVar.kmr, false, false, dlj != null && StringUtils.isNull(dlj.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(n nVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kkN) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.klV.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.klV.setLayoutParams(layoutParams);
            nVar.klV.setPadding(0, 0, 0, 0);
            nVar.klV.AF(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.klV.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.klV.setLayoutParams(layoutParams2);
            nVar.klV.AF(postData.getBimg_url());
        }
        nVar.klV.setTextViewOnTouchListener(this.klG);
        nVar.klV.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x05e9  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0951  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x095d  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0975  */
    /* JADX WARN: Removed duplicated region for block: B:309:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(n nVar, PostData postData, View view, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String userId;
        if (nVar != null && postData != null) {
            if (postData.aWl() == null || postData.aWl().isBaijiahaoUser()) {
            }
            if (postData.lNM) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            nVar.klU.setTag(null);
            nVar.klU.setUserId(null);
            nVar.gJq.setText((CharSequence) null);
            nVar.kmn.getHeadView().setUserId(null);
            nVar.klV.setIsHost(false);
            if (postData.aWl() != null) {
                if (this.aTI != null && !this.aTI.equals("0") && this.aTI.equals(postData.aWl().getUserId())) {
                    nVar.klV.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aWl().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aWl().getTShowInfoNew();
                if (nVar.kmp != null) {
                    nVar.kmp.setTag(R.id.tag_user_id, postData.aWl().getUserId());
                    if (this.kmC != null && this.kmC.cNt() != null) {
                        nVar.kmp.setOnClickListener(this.kmC.cNt().kkl.kzX);
                    }
                    nVar.kmp.a(iconInfo, 2, this.kjp, this.kjp, this.aTp);
                }
                if (nVar.kmo != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.kmo.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.kmC != null && this.kmC.cNt() != null) {
                        nVar.kmo.setOnClickListener(this.kmC.cNt().kkl.kzY);
                    }
                    nVar.kmo.a(tShowInfoNew, 3, this.kjp, this.kjp, this.aTp, true);
                }
                if (!com.baidu.tbadk.core.util.x.isEmpty(tShowInfoNew) || postData.aWl().isBigV()) {
                    com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.gJq, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.gJq, R.color.cp_cont_j, 1);
                }
                String avater = postData.aWl().getAvater();
                int i2 = 8;
                if (postData.lNV) {
                    i2 = 2;
                }
                nVar.gJq.setTag(R.id.tag_user_id, postData.aWl().getUserId());
                nVar.gJq.setTag(R.id.tag_user_name, postData.aWl().getUserName());
                nVar.gJq.setTag(R.id.tag_virtual_user_url, postData.aWl().getVirtualUserUrl());
                nVar.gJq.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kkM, postData, postData.locate, i2, 2));
                String name_show = postData.aWl().getName_show();
                String userName = postData.aWl().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.gJq.setText(com.baidu.tieba.pb.c.aJ(this.mContext, nVar.gJq.getText().toString()));
                    nVar.gJq.setGravity(16);
                    nVar.gJq.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cKh());
                    com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.gJq, R.color.cp_other_f, 1);
                }
                if (postData.aWl().getPendantData() != null && !StringUtils.isNull(postData.aWl().getPendantData().aUh())) {
                    nVar.kmn.setBigVDimenSize(R.dimen.tbds32);
                    nVar.kmn.a(postData.aWl(), 4);
                    nVar.klU.setVisibility(8);
                    nVar.kmn.setVisibility(0);
                    nVar.kmn.getHeadView().startLoad(avater, 28, false);
                    nVar.kmn.getHeadView().setUserId(postData.aWl().getUserId());
                    nVar.kmn.getHeadView().setUserName(postData.aWl().getUserName());
                    nVar.kmn.getHeadView().setFid(this.kkM != null ? this.kkM.getForumId() : "");
                    nVar.kmn.getHeadView().setFName(this.kkM != null ? this.kkM.getForumName() : "");
                    nVar.kmn.getHeadView().setFloor(postData.dlh());
                    nVar.kmn.getHeadView().setTid(postData.getId());
                    nVar.kmn.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kkM, postData, postData.locate, i2, 2));
                    nVar.kmn.yl(postData.aWl().getPendantData().aUh());
                } else {
                    nVar.klU.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.klU, postData.aWl(), 4);
                    nVar.klU.setUserId(postData.aWl().getUserId());
                    nVar.klU.setFid(this.kkM != null ? this.kkM.getForumId() : "");
                    nVar.klU.setFName(this.kkM != null ? this.kkM.getForumName() : "");
                    nVar.klU.setFloor(postData.dlh());
                    nVar.klU.setTid(postData.getId());
                    nVar.klU.setUserName(postData.aWl().getUserName(), postData.dlr());
                    nVar.klU.setTag(R.id.tag_virtual_user_url, postData.aWl().getVirtualUserUrl());
                    nVar.klU.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kkM, postData, postData.locate, i2, 2));
                    nVar.klU.setImageDrawable(null);
                    nVar.klU.startLoad(avater, 28, false);
                    nVar.klU.setVisibility(0);
                    nVar.kmn.setVisibility(8);
                }
                if (postData.aWl() != null && postData.aWl().getAlaInfo() != null && postData.aWl().getAlaUserData() != null && postData.aWl().getAlaUserData().live_status == 1) {
                    nVar.qN(true);
                    nVar.klU.setLiveStatus(1);
                    nVar.klU.setAlaInfo(postData.aWl().getAlaInfo());
                    nVar.kmn.getHeadView().setLiveStatus(1);
                    nVar.kmn.getHeadView().setAlaInfo(postData.aWl().getAlaInfo());
                } else {
                    nVar.qN(false);
                    nVar.klU.setLiveStatus(0);
                    nVar.klU.setAlaInfo(null);
                    nVar.kmn.getHeadView().setLiveStatus(0);
                    nVar.kmn.getHeadView().setAlaInfo(null);
                }
                if (this.kkM != null && this.kkM.cLa()) {
                    nVar.klO.setVisibility(8);
                    nVar.klO.setTag(null);
                } else if (postData.aWl() != null) {
                    MetaData aWl = postData.aWl();
                    com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.klO, R.color.cp_cont_a);
                    if (this.aTI != null && !this.aTI.equals("0") && this.aTI.equals(aWl.getUserId())) {
                        nVar.klO.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (this.kjq.getDrawable(1) != null) {
                                this.kjq.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.kjq.getDrawable(1) != null) {
                            this.kjq.getDrawable(1).setAlpha(0);
                        }
                        nVar.klO.setBackgroundDrawable(this.kjq);
                        nVar.klO.setVisibility(0);
                        nVar.klO.setText(R.string.host_name);
                    } else if (aWl.getIs_bawu() == 1 && postData.dkZ()) {
                        int i3 = R.drawable.brand_official_btn;
                        com.baidu.tbadk.core.util.ao.setBackgroundResource(nVar.klO, i3);
                        nVar.klO.setTag(Integer.valueOf(i3));
                        nVar.klO.setVisibility(0);
                        nVar.klO.setText(R.string.brand_Official);
                    } else if (aWl.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aWl.getBawu_type())) {
                        nVar.klO.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.ahB.getDrawable(1) != null) {
                                this.ahB.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ahB.getDrawable(1) != null) {
                            this.ahB.getDrawable(1).setAlpha(0);
                        }
                        nVar.klO.setBackgroundDrawable(this.ahB);
                        nVar.klO.setVisibility(0);
                        nVar.klO.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aWl.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aWl.getBawu_type())) {
                        nVar.klO.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.ahC.getDrawable(1) != null) {
                                this.ahC.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ahC.getDrawable(1) != null) {
                            this.ahC.getDrawable(1).setAlpha(0);
                        }
                        nVar.klO.setBackgroundDrawable(this.ahC);
                        nVar.klO.setVisibility(0);
                        nVar.klO.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aWl.getIs_bawu() == 1 && "pri_content_assist".equals(aWl.getBawu_type())) {
                        int lL = com.baidu.tbadk.core.util.ao.lL(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ao.setBackgroundResource(nVar.klO, lL);
                        nVar.klO.setTag(Integer.valueOf(lL));
                        nVar.klO.setVisibility(0);
                        nVar.klO.setText(R.string.bawu_content_assist_tip);
                    } else if (aWl.getIs_bawu() == 1 && "pri_manage_assist".equals(aWl.getBawu_type())) {
                        int lL2 = com.baidu.tbadk.core.util.ao.lL(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ao.setBackgroundResource(nVar.klO, lL2);
                        nVar.klO.setTag(Integer.valueOf(lL2));
                        nVar.klO.setVisibility(0);
                        nVar.klO.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.klO.setVisibility(8);
                        nVar.klO.setTag(null);
                    }
                } else {
                    nVar.klO.setVisibility(8);
                    nVar.klO.setTag(null);
                }
            }
            int i4 = 0;
            if (this.kmC != null && this.kmC.cNt() != null && this.kmC.cNt().cLF() && postData.aWl() != null) {
                i4 = postData.aWl().getLevel_id();
            }
            if (this.kkM != null && this.kkM.cLa()) {
                i4 = 0;
            }
            if (i4 > 0) {
                nVar.kmm.setVisibility(0);
                com.baidu.tbadk.core.util.ao.setImageResource(nVar.kmm, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                nVar.kmm.setVisibility(8);
            }
            int i5 = 15;
            if (nVar.kmp.getChildCount() == 1) {
                i5 = 13;
            } else if (nVar.kmp.getChildCount() > 1) {
                i5 = 11;
            }
            if (nVar.klO.getVisibility() == 0) {
                i5 -= 2;
            }
            if (nVar.kmo.getChildCount() > 0) {
                i5 -= 2;
            }
            if (postData.aXK() > 1000) {
                i5 -= 2;
            }
            if (postData.aXK() > 10) {
                i5 -= 2;
            }
            if (i5 < 10) {
                nVar.kmp.setVisibility(8);
                if (nVar.kmp.getChildCount() == 1) {
                    i5 += 2;
                } else if (nVar.kmp.getChildCount() > 1) {
                    i5 += 4;
                }
                if (i5 < 10 && nVar.klO.getVisibility() == 0) {
                    i5 += 2;
                    nVar.klO.setVisibility(8);
                }
                if (i5 < 10 && nVar.kmm.getVisibility() == 0) {
                    i5 += 2;
                    nVar.kmm.setVisibility(8);
                }
            }
            String name_show2 = postData.aWl() != null ? postData.aWl().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ae.getTextLengthWithEmoji(name_show2);
            if (postData.aWl() != null && !StringUtils.isNull(postData.aWl().getSealPrefix())) {
                if (textLengthWithEmoji > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i5 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i5) {
                name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i5) + StringHelper.STRING_MORE;
            }
            if (postData.aWl() != null && !StringUtils.isNull(postData.aWl().getSealPrefix())) {
                nVar.gJq.setText(dp(postData.aWl().getSealPrefix(), name_show2));
            } else {
                nVar.gJq.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dlh()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aWl() != null && !StringUtils.isNull(postData.aWl().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.kkM != null && this.kkM.cKM() != 0) {
                if (this.kkM.cKM() != 1002 && this.kkM.cKM() != 3) {
                    z10 = true;
                }
                if (this.kkM.cKM() != 3 && !this.kkM.cLa()) {
                    z11 = true;
                }
                if (postData != null && postData.aWl() != null) {
                    String userId2 = postData.aWl().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.kkM != null && this.kkM.cKx() != null && this.kkM.cKx().aWl() != null && postData.aWl() != null) {
                            userId = this.kkM.cKx().aWl().getUserId();
                            String userId3 = postData.aWl().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.aWl() != null && UtilHelper.isCurrentAccount(postData.aWl().getUserId())) {
                                    z5 = true;
                                    z6 = true;
                                } else {
                                    boolean z14 = z12;
                                    z5 = z3;
                                    z6 = z14;
                                }
                                if (z9) {
                                    z = false;
                                    z8 = false;
                                    z7 = false;
                                } else {
                                    z7 = z4;
                                    z8 = z5;
                                }
                                int i6 = 1;
                                if (postData.dlh() == 1) {
                                    i6 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kkM.cKM()));
                                    if (postData.aWl() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.aWl().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.aWl().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.aWl().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.aWl() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aWl().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.aWl().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aWl().getName_show());
                                    }
                                    if (this.kkM.cKx() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.kkM.cKx().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kkM.cKM()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.klV.setTag(sparseArray);
                                if (this.klE) {
                                    nVar.kmq.setTag(sparseArray);
                                    return;
                                }
                                return;
                            }
                        }
                        z3 = z2;
                        z4 = false;
                        if (postData == null) {
                        }
                        boolean z142 = z12;
                        z5 = z3;
                        z6 = z142;
                        if (z9) {
                        }
                        int i62 = 1;
                        if (postData.dlh() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        nVar.klV.setTag(sparseArray);
                        if (this.klE) {
                        }
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.kkM != null) {
                userId = this.kkM.cKx().aWl().getUserId();
                String userId32 = postData.aWl().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                }
            }
            z3 = z2;
            z4 = false;
            if (postData == null) {
            }
            boolean z1422 = z12;
            z5 = z3;
            z6 = z1422;
            if (z9) {
            }
            int i622 = 1;
            if (postData.dlh() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            nVar.klV.setTag(sparseArray);
            if (this.klE) {
            }
        }
    }

    private void f(n nVar, PostData postData) {
        if (nVar != null && postData != null && nVar.kmq != null && this.kkM != null) {
            if (this.klE && !this.kkM.cLa()) {
                nVar.kmq.setVisibility(0);
                nVar.kmq.setOnClickListener(this.aMH);
                return;
            }
            nVar.kmq.setVisibility(8);
        }
    }

    private void b(n nVar, PostData postData, boolean z) {
        if (nVar != null && postData != null && postData.aYc() != null) {
            postData.aYc().threadId = this.kmC.cLP().cNL();
            postData.aYc().objType = 1;
            postData.aYc().isInPost = true;
            bv bvVar = null;
            if (this.kkM != null && this.kkM.cKx() != null) {
                bvVar = this.kkM.cKx();
            }
            if (z) {
                nVar.kmk.setAgreeAlone(true);
                nVar.kmk.setThreadData(bvVar);
                nVar.kmk.setData(postData.aYc());
            }
            if (bvVar != null && bvVar.aUV()) {
                nVar.klT.setAgreeAlone(true);
            }
            nVar.klT.setThreadData(bvVar);
            nVar.klT.setData(postData.aYc());
        }
    }

    private void g(n nVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dlh() > 0 && this.kkM != null && !this.kkM.cLa()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dlh()));
                nVar.kml.setVisibility(0);
                nVar.kml.setText(format);
                z = true;
            } else {
                nVar.kml.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dlk = postData.dlk();
            boolean z2 = (dlk == null || StringUtils.isNull(dlk.getName()) || this.kkM == null || this.kkM.cLa()) ? false : true;
            if (z) {
                nVar.klQ.setVisibility(0);
                i = this.ilI;
            } else {
                nVar.klQ.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.klR.setVisibility(0);
                i2 = this.ilI;
            } else {
                nVar.klR.setVisibility(8);
                i2 = 0;
            }
            nVar.klP.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.klP.setText(com.baidu.tbadk.core.util.as.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.klP.setText(com.baidu.tbadk.core.util.as.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.klS.setVisibility(0);
                nVar.klS.setPadding(this.ilI, 0, 0, 0);
                if (postData.lNU) {
                    nVar.klS.setText(com.baidu.tbadk.core.util.as.cutStringWithSuffix(dlk.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    nVar.klS.setText(dlk.getName());
                    return;
                }
            }
            nVar.klS.setVisibility(8);
        }
    }

    private void a(n nVar, PostData postData, View view) {
        if (nVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.klV.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            nVar.klV.setPadding(0, 0, 0, 0);
            if (!this.kkN) {
                nVar.klV.getLayoutStrategy().oT(R.drawable.icon_click);
            } else {
                nVar.klV.AF(null);
                nVar.klV.setBackgroundDrawable(null);
                nVar.klV.getLayoutStrategy().oT(R.drawable.transparent_bg);
            }
            nVar.klV.getLayoutStrategy().oQ(R.drawable.pic_video);
            a(nVar.klV, view, !StringUtils.isNull(postData.getBimg_url()));
            nVar.klV.setLayoutParams(layoutParams);
            nVar.klV.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_link_tip_c));
            nVar.klV.setIsFromCDN(this.mIsFromCDN);
            nVar.klV.setText(postData.dlj(), true, this.klC);
            SparseArray sparseArray = (SparseArray) nVar.klV.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            nVar.klV.setTag(sparseArray);
            nVar.klN.setTag(R.id.tag_from, sparseArray);
        }
    }

    private void a(TbRichTextView tbRichTextView, View view, boolean z) {
        if (tbRichTextView != null && view != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            int dimensionPixelSize = z ? getDimensionPixelSize(R.dimen.tbds115) : 0;
            tbRichTextView.getLayoutStrategy().oR(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().eTU = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().oS((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(n nVar, PostData postData, View view, int i) {
        String string;
        if (nVar != null && postData != null) {
            if (postData.dll() > 0) {
                nVar.kma.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) nVar.kma.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.kma.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dlt() == 2) {
                    nVar.kma.setVisibility(8);
                } else if (this.klE) {
                    nVar.klX.setVisibility(8);
                } else {
                    nVar.kma.setVisibility(0);
                }
                nVar.klZ.setVisibility(8);
            }
            if (this.klE) {
                if (com.baidu.tbadk.a.d.aRG()) {
                    string = postData.dll() > 0 ? String.valueOf(postData.dll()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.reply);
                }
                nVar.kmj.setText(string);
                if (nVar.kme != null) {
                    SparseArray sparseArray2 = (SparseArray) nVar.kme.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        nVar.kme.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.kmd != null) {
                    SparseArray sparseArray3 = (SparseArray) nVar.kmd.getTag();
                    if (sparseArray3 == null) {
                        sparseArray3 = new SparseArray();
                        nVar.kmd.setTag(sparseArray3);
                    }
                    sparseArray3.put(R.id.tag_load_sub_data, postData);
                }
            } else {
                if (nVar.kmb != null) {
                    SparseArray sparseArray4 = (SparseArray) nVar.kmb.getTag();
                    if (sparseArray4 == null) {
                        sparseArray4 = new SparseArray();
                        nVar.kmb.setTag(sparseArray4);
                    }
                    sparseArray4.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.iEP != null) {
                    SparseArray sparseArray5 = (SparseArray) nVar.iEP.getTag();
                    if (sparseArray5 == null) {
                        sparseArray5 = new SparseArray();
                        nVar.iEP.setTag(sparseArray5);
                    }
                    sparseArray5.put(R.id.tag_load_sub_data, postData);
                }
            }
            if (postData.dll() > 0 && !this.klF) {
                nVar.klZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dll())));
                SparseArray sparseArray6 = (SparseArray) nVar.klZ.getTag();
                if (sparseArray6 == null) {
                    sparseArray6 = new SparseArray();
                    nVar.klZ.setTag(sparseArray6);
                }
                sparseArray6.put(R.id.tag_load_sub_data, postData);
                nVar.klZ.setVisibility(0);
                nVar.kma.setVisibility(8);
                nVar.klY.setVisibility(8);
            } else {
                nVar.klZ.setVisibility(8);
                if (this.klF) {
                    nVar.kma.setVisibility(8);
                }
                if (postData.dll() > 0 && postData.dle() != null && postData.dle().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.klY.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    nVar.klY.setLayoutParams(layoutParams);
                    if (this.klD == null) {
                        this.klD = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.klD.setIsFromCDN(this.mIsFromCDN);
                        this.klD.setOnLongClickListener(this.mOnLongClickListener);
                        this.klD.V(this.kkW);
                        this.klD.z(this.aMH);
                        String str = null;
                        if (this.kkM != null && this.kkM.cKx() != null && this.kkM.cKx().aWl() != null) {
                            str = this.kkM.cKx().aWl().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.kkM != null) {
                            this.klD.aa(this.kkM.cKM(), z);
                            this.klD.setThreadData(this.kkM.cKx());
                        }
                    }
                    this.klD.Lf(postData.getId());
                    nVar.klY.setSubPbAdapter(this.klD);
                    nVar.klY.setVisibility(0);
                    nVar.klY.setData(postData, view);
                    nVar.klY.setChildOnClickListener(this.aMH);
                    nVar.klY.setChildOnLongClickListener(this.mOnLongClickListener);
                    nVar.klY.setChildOnTouchListener(this.klG);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.klY.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    nVar.klY.setLayoutParams(layoutParams2);
                    nVar.klY.setVisibility(8);
                }
            }
            if (postData.lNK) {
                nVar.mBottomLine.setVisibility(0);
            } else {
                nVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(n nVar, PostData postData) {
        if (nVar != null && nVar.kmv != null && nVar.kms != null) {
            if (postData == null || postData.lNO == null || StringUtils.isNull(postData.lNO.liveTitle)) {
                nVar.kms.setVisibility(8);
                return;
            }
            nVar.kmv.setText(postData.lNO.liveTitle);
            nVar.kms.setTag(postData.lNO);
            nVar.kms.setVisibility(0);
            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(apVar);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.kmA.setVisibility(postData.lNU ? 0 : 8);
        }
    }

    private void a(n nVar) {
        LayerDrawable layerDrawable;
        if (nVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (nVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.gJq, R.color.cp_cont_d, 1);
                if (nVar.klO.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.ao.setBackgroundResource(nVar.klO, ((Integer) nVar.klO.getTag()).intValue());
                } else if (nVar.klO.getTag() instanceof String) {
                    if (nVar.klO.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.ahB;
                    } else if (nVar.klO.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.ahC;
                    } else {
                        layerDrawable = nVar.klO.getTag().equals("HOST") ? this.kjq : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.klO.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.klP, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.klQ, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.klR, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kml, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.klS, R.color.cp_cont_d, 1);
                nVar.klV.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.ao.c(nVar.klY, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.klZ, R.color.cp_cont_c);
                nVar.klZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kma, R.color.cp_cont_c);
                if (this.klE) {
                    SvgManager.baR().a(nVar.kmq, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.baR().a(nVar.kmi, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.baR().a(nVar.kmg, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    nVar.kmk.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kmh, R.color.cp_cont_d);
                    com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kmj, R.color.cp_cont_d);
                } else {
                    SvgManager.baR().a(nVar.kmb, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.baR().a(nVar.iEP, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                nVar.klY.onChangeSkinType();
                nVar.klW.onChangeSkinType();
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kmv, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kmt, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(nVar.kms, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(nVar.kmu, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ao.setImageResource(nVar.kmw, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kmz, R.color.cp_cont_c);
                if (nVar.kmx.getVisibility() == 8) {
                    nVar.kmz.setText(R.string.close_content);
                } else if (this.kkM != null && StringUtils.isNull(this.kkM.cKI())) {
                    nVar.kmz.setText(this.kkM.cKI());
                } else {
                    nVar.kmz.setText(R.string.expand_content);
                }
                nVar.klT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                nVar.zJ(skinType);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = skinType;
        }
    }

    private void b(final n nVar) {
        nVar.klN.setOnTouchListener(this.klG);
        nVar.klN.setOnLongClickListener(this.mOnLongClickListener);
        if (this.kmC.cNt() != null && this.kmC.cNt().getPageContext() != null && this.kmC.cNt().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.kmC.cNt().kkl;
            nVar.gJq.setOnClickListener(aVar.hps);
            nVar.klU.setOnClickListener(aVar.hps);
            nVar.kmn.setOnClickListener(aVar.hps);
            nVar.kmn.getHeadView().setOnClickListener(aVar.hps);
            nVar.klV.setOnLongClickListener(this.mOnLongClickListener);
            nVar.klV.setOnTouchListener(this.klG);
            nVar.klV.setCommonTextViewOnClickListener(this.aMH);
            nVar.klV.setOnImageClickListener(this.eRR);
            nVar.klV.setOnImageTouchListener(this.klG);
            nVar.klV.setOnEmotionClickListener(aVar.kzZ);
            nVar.klV.setOnVoiceAfterClickListener(this.aMH);
            nVar.kmr.setOnClickListener(this.aMH);
            nVar.kms.setOnClickListener(this.aMH);
            nVar.klZ.setOnClickListener(this.aMH);
            nVar.kma.setOnClickListener(this.aMH);
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.kmC.cNt().kkm;
            if (this.klE) {
                nVar.kme.setOnClickListener(this.aMH);
                nVar.kmd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.klN != null && cVar != null) {
                                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.kAo.a(m.this.kkM, null, postData, nVar.klN);
                                    }
                                }, 100L);
                                String threadId = m.this.kkM.getThreadId();
                                if ((StringUtils.isNull(threadId) || "0".equals(m.this.kkM.getThreadId())) && m.this.kkM.cKx() != null) {
                                    threadId = m.this.kkM.cKx().getNid();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13700").dn("tid", threadId).dn("fid", m.this.kkM.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", postData.getId()).ah("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.kmk.eeJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && m.this.kkM != null && nVar != null && nVar.kmk != null && nVar.kmk.getData() != null) {
                            int i = view == nVar.kmk.getImgAgree() ? 1 : 2;
                            String threadId = m.this.kkM.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.kkM.getThreadId())) && m.this.kkM.cKx() != null) {
                                threadId = m.this.kkM.cKx().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13700").dn("tid", threadId).dn("fid", m.this.kkM.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", nVar.kmk.getData().postId).ah("obj_type", i));
                        }
                    }
                };
                return;
            }
            nVar.kmb.setOnClickListener(this.aMH);
            nVar.iEP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.klN != null && cVar != null) {
                            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.kAo.a(m.this.kkM, null, postData, nVar.klN);
                                }
                            }, 100L);
                            String threadId = m.this.kkM.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.kkM.getThreadId())) && m.this.kkM.cKx() != null) {
                                threadId = m.this.kkM.cKx().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13700").dn("tid", threadId).dn("fid", m.this.kkM.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", postData.getId()).ah("obj_type", 4));
                        }
                    }
                }
            });
            nVar.klT.eeJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && m.this.kkM != null && nVar != null && nVar.klT != null && nVar.klT.getData() != null) {
                        int i = view == nVar.klT.getImgAgree() ? 1 : 2;
                        String threadId = m.this.kkM.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(m.this.kkM.getThreadId())) && m.this.kkM.cKx() != null) {
                            threadId = m.this.kkM.cKx().getNid();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13700").dn("tid", threadId).dn("fid", m.this.kkM.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", nVar.klT.getData().postId).ah("obj_type", i));
                    }
                }
            };
        }
    }

    private void sv() {
        this.ahB = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(this.imj).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bbx(), com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(this.imj).yi("#4D000000").bbx()});
        this.ahC = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(this.imj).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bbx(), com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(this.imj).yi("#4D000000").bbx()});
        this.kjq = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(this.imj).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).bbx(), com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(this.imj).yi("#4D000000").bbx()});
    }

    public void a(TbRichTextView.c cVar) {
        this.klC = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kkM = fVar;
    }

    public void fq(String str) {
        this.aTI = str;
    }

    public void rW(boolean z) {
        this.kkN = z;
    }

    private SpannableStringBuilder dp(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.kmC.cNt(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(n nVar) {
        nVar.klV.setTextViewOnTouchListener(this.euG);
        nVar.klV.setTextViewCheckSelection(false);
    }

    public void R(View.OnClickListener onClickListener) {
        this.kkW = onClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.aMH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eRR = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.euG = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
