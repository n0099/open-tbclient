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
    private int ilK;
    private int iml;
    private int kjr;
    private LayerDrawable kjs;
    protected com.baidu.tieba.pb.data.f kkO;
    private boolean kkP;
    private View.OnClickListener kkY;
    private TbRichTextView.c klE;
    private com.baidu.tieba.pb.pb.sub.b klF;
    private boolean klG;
    private boolean klH;
    private com.baidu.tieba.pb.a.c klI;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(View view) {
        if (view != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (this.klG && nVar.kmm != null && nVar.kmm.getData() != null) {
                nVar.kmm.bbK();
            }
            if (nVar.klV != null && nVar.klV.getData() != null) {
                nVar.klV.bbK();
            }
        }
    }

    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.aTp = 0;
        this.ilK = 0;
        this.kjr = 0;
        this.iml = 0;
        this.klE = null;
        this.kkP = true;
        this.aTI = null;
        this.kkO = null;
        this.kkY = null;
        this.aMH = null;
        this.eRR = null;
        this.euG = null;
        this.mOnLongClickListener = null;
        this.klF = null;
        this.eVb = true;
        this.klG = com.baidu.tbadk.a.d.aRO();
        this.klH = com.baidu.tbadk.a.d.aRP();
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
        this.klI = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.m.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (m.this.kkb == null || m.this.kkb.cMF() == null || m.this.kkb.cMF().cPB())) {
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
        n nVar = new n(this.kmE.cNt().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.azq, this.klG, this.klH);
        nVar.klY.setConstrainLayoutPool(this.hLg);
        nVar.klY.setImageViewPool(this.hLh);
        if (nVar.kma != null) {
            nVar.kma.setShowChildComment(this.klH);
        }
        a(nVar);
        this.aTp = getDimensionPixelSize(R.dimen.tbds10);
        this.ilK = getDimensionPixelSize(R.dimen.tbds14);
        this.kjr = getDimensionPixelSize(R.dimen.tbds36);
        this.iml = getDimensionPixelSize(R.dimen.tbds6);
        if (nVar.klX != null) {
            nVar.klX.setDuiEnabled(this.eVb);
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
            if (postData.lNX) {
                i = 2;
            }
            com.baidu.tbadk.core.util.ap b = com.baidu.tieba.pb.c.a.b(this.kkO, postData, postData.locate, i, 6);
            postData.lNY = b;
            if (!com.baidu.tbadk.core.util.x.isEmpty(postData.dlf())) {
                Iterator<PostData> it = postData.dlf().iterator();
                while (it.hasNext()) {
                    it.next().lNY = b;
                }
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            if (this.klG && this.klH) {
                nVar.klZ.setVisibility(8);
                nVar.kme.setVisibility(0);
            } else if (this.klG) {
                nVar.kme.setVisibility(0);
                nVar.klZ.setVisibility(0);
                nVar.kmd.setVisibility(8);
                nVar.iER.setVisibility(8);
                nVar.klV.setVisibility(8);
            } else {
                nVar.kme.setVisibility(8);
                nVar.klZ.setVisibility(0);
                nVar.kmd.setVisibility(0);
                nVar.iER.setVisibility(0);
                nVar.klV.setVisibility(0);
            }
            b(nVar, postData, view, i);
            f(nVar, postData);
            b(nVar, postData, this.klG);
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
        if (nVar != null && nVar.klP != null) {
            if (this.kmE != null && this.kmE.cLP() != null && this.kmE.cLP().cOD() && com.baidu.tbadk.core.util.as.equals(this.kmE.cLP().cNK(), postData.getId())) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(nVar.klP, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(nVar.klP, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, boolean z, String str) {
        if (z) {
            nVar.kmz.setVisibility(8);
            if (StringUtils.isNull(str)) {
                nVar.kmB.setText(R.string.expand_content);
                return;
            } else {
                nVar.kmB.setText(str);
                return;
            }
        }
        nVar.kmz.setVisibility(0);
        nVar.kmB.setText(R.string.close_content);
    }

    private void c(final n nVar, final PostData postData) {
        if (postData.dlu() == 2 || postData.dlu() == 4) {
            nVar.kmA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = nVar.kmz.getVisibility() == 8;
                    m.this.a(nVar, !z, postData.cKI());
                    postData.vk(z ? false : true);
                    m.this.d(nVar, postData);
                    if (m.this.kkb != null && m.this.kkb.cMF() != null && m.this.kkb.cMF().cQD() != null && m.this.kkb.cMF().getListView() != null && !z && nVar.getView().getTop() < m.this.kkb.cMF().cQD().getMeasuredHeight()) {
                        m.this.kkb.cMF().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.x.getPosition(m.this.kkb.cMF().getListView().getData(), postData) + m.this.kkb.cMF().getListView().getHeaderViewsCount(), m.this.kkb.cMF().cQD().getMeasuredHeight());
                    }
                }
            });
            nVar.kmA.setVisibility(0);
            a(nVar, postData.dld(), postData.cKI());
            a(true, nVar, postData);
        } else {
            nVar.kmA.setVisibility(8);
            nVar.kmz.setVisibility(0);
            a(false, nVar, postData);
        }
        d(nVar, postData);
    }

    private void a(boolean z, n nVar, PostData postData) {
        if (nVar != null && nVar.mBottomLine != null && nVar.kmA != null && (nVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (nVar.kmA.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.x.isEmpty(postData.dlf());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) nVar.kmA.getLayoutParams();
            if (z) {
                nVar.klX.getLayoutStrategy().oZ(0);
                if (z2) {
                    nVar.klX.getLayoutStrategy().oY(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    nVar.klX.getLayoutStrategy().oY(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                nVar.kmA.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    nVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            nVar.klX.getLayoutStrategy().oY(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            nVar.klX.getLayoutStrategy().oZ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                if (this.klG) {
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
        TbRichText dlk = postData.dlk();
        dlk.isChanged = true;
        nVar.klX.setText(dlk, true, this.klE);
    }

    private void j(PostData postData) {
        if (postData.dTc == 0 && postData.hNF) {
            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c12203");
            apVar.dn("post_id", postData.getId());
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.dn("cuid", TbadkCoreApplication.getInst().getCuid());
            apVar.dn("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            apVar.dn("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            apVar.dn("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            apVar.t(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.kmE != null) {
                int cOv = this.kmE.cLP().cOv();
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
        String forumId = this.kkO != null ? this.kkO.getForumId() : "";
        String forumName = this.kkO != null ? this.kkO.getForumName() : "";
        int dli = postData.dli();
        String id = postData.getId();
        com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13714");
        apVar.dn("fid", forumId);
        apVar.dn("fname", forumName);
        apVar.dn("obj_param1", userId);
        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
        apVar.dn("tid", id);
        apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, dli);
        TiebaStatic.log(apVar);
    }

    private void l(PostData postData) {
        if (this.kkO != null) {
            if (this.kkO.cKX()) {
                if (this.kmF != null) {
                    com.baidu.tieba.pb.c.a.a(this.kmF.getUniqueId(), this.kkO, postData, postData.locate, postData.lNX ? 2 : 8);
                }
            } else if (this.kkb != null) {
                com.baidu.tieba.pb.c.a.a(this.kkb.getUniqueId(), this.kkO, postData, postData.locate, postData.lNX ? 2 : 8);
            }
        }
    }

    private void a(n nVar, PostData postData) {
        if (postData == null || postData.cSs() == null) {
            nVar.kmt.setVisibility(8);
            return;
        }
        TbRichText dlk = postData.dlk();
        com.baidu.tieba.pb.view.b.a(postData.cSs(), nVar.kmt, false, false, dlk != null && StringUtils.isNull(dlk.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(n nVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kkP) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.klX.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.klX.setLayoutParams(layoutParams);
            nVar.klX.setPadding(0, 0, 0, 0);
            nVar.klX.AF(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.klX.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.klX.setLayoutParams(layoutParams2);
            nVar.klX.AF(postData.getBimg_url());
        }
        nVar.klX.setTextViewOnTouchListener(this.klI);
        nVar.klX.setTextViewCheckSelection(false);
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
            if (postData.lNO) {
                com.baidu.tbadk.core.util.ao.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            nVar.klW.setTag(null);
            nVar.klW.setUserId(null);
            nVar.gJq.setText((CharSequence) null);
            nVar.kmp.getHeadView().setUserId(null);
            nVar.klX.setIsHost(false);
            if (postData.aWl() != null) {
                if (this.aTI != null && !this.aTI.equals("0") && this.aTI.equals(postData.aWl().getUserId())) {
                    nVar.klX.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.aWl().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.aWl().getTShowInfoNew();
                if (nVar.kmr != null) {
                    nVar.kmr.setTag(R.id.tag_user_id, postData.aWl().getUserId());
                    if (this.kmE != null && this.kmE.cNt() != null) {
                        nVar.kmr.setOnClickListener(this.kmE.cNt().kkn.kzZ);
                    }
                    nVar.kmr.a(iconInfo, 2, this.kjr, this.kjr, this.aTp);
                }
                if (nVar.kmq != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.kmq.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.kmE != null && this.kmE.cNt() != null) {
                        nVar.kmq.setOnClickListener(this.kmE.cNt().kkn.kAa);
                    }
                    nVar.kmq.a(tShowInfoNew, 3, this.kjr, this.kjr, this.aTp, true);
                }
                if (!com.baidu.tbadk.core.util.x.isEmpty(tShowInfoNew) || postData.aWl().isBigV()) {
                    com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.gJq, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.gJq, R.color.cp_cont_j, 1);
                }
                String avater = postData.aWl().getAvater();
                int i2 = 8;
                if (postData.lNX) {
                    i2 = 2;
                }
                nVar.gJq.setTag(R.id.tag_user_id, postData.aWl().getUserId());
                nVar.gJq.setTag(R.id.tag_user_name, postData.aWl().getUserName());
                nVar.gJq.setTag(R.id.tag_virtual_user_url, postData.aWl().getVirtualUserUrl());
                nVar.gJq.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kkO, postData, postData.locate, i2, 2));
                String name_show = postData.aWl().getName_show();
                String userName = postData.aWl().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.gJq.setText(com.baidu.tieba.pb.c.aJ(this.mContext, nVar.gJq.getText().toString()));
                    nVar.gJq.setGravity(16);
                    nVar.gJq.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cKh());
                    com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.gJq, R.color.cp_other_f, 1);
                }
                if (postData.aWl().getPendantData() != null && !StringUtils.isNull(postData.aWl().getPendantData().aUh())) {
                    nVar.kmp.setBigVDimenSize(R.dimen.tbds32);
                    nVar.kmp.a(postData.aWl(), 4);
                    nVar.klW.setVisibility(8);
                    nVar.kmp.setVisibility(0);
                    nVar.kmp.getHeadView().startLoad(avater, 28, false);
                    nVar.kmp.getHeadView().setUserId(postData.aWl().getUserId());
                    nVar.kmp.getHeadView().setUserName(postData.aWl().getUserName());
                    nVar.kmp.getHeadView().setFid(this.kkO != null ? this.kkO.getForumId() : "");
                    nVar.kmp.getHeadView().setFName(this.kkO != null ? this.kkO.getForumName() : "");
                    nVar.kmp.getHeadView().setFloor(postData.dli());
                    nVar.kmp.getHeadView().setTid(postData.getId());
                    nVar.kmp.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kkO, postData, postData.locate, i2, 2));
                    nVar.kmp.yl(postData.aWl().getPendantData().aUh());
                } else {
                    nVar.klW.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.klW, postData.aWl(), 4);
                    nVar.klW.setUserId(postData.aWl().getUserId());
                    nVar.klW.setFid(this.kkO != null ? this.kkO.getForumId() : "");
                    nVar.klW.setFName(this.kkO != null ? this.kkO.getForumName() : "");
                    nVar.klW.setFloor(postData.dli());
                    nVar.klW.setTid(postData.getId());
                    nVar.klW.setUserName(postData.aWl().getUserName(), postData.dls());
                    nVar.klW.setTag(R.id.tag_virtual_user_url, postData.aWl().getVirtualUserUrl());
                    nVar.klW.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kkO, postData, postData.locate, i2, 2));
                    nVar.klW.setImageDrawable(null);
                    nVar.klW.startLoad(avater, 28, false);
                    nVar.klW.setVisibility(0);
                    nVar.kmp.setVisibility(8);
                }
                if (postData.aWl() != null && postData.aWl().getAlaInfo() != null && postData.aWl().getAlaUserData() != null && postData.aWl().getAlaUserData().live_status == 1) {
                    nVar.qN(true);
                    nVar.klW.setLiveStatus(1);
                    nVar.klW.setAlaInfo(postData.aWl().getAlaInfo());
                    nVar.kmp.getHeadView().setLiveStatus(1);
                    nVar.kmp.getHeadView().setAlaInfo(postData.aWl().getAlaInfo());
                } else {
                    nVar.qN(false);
                    nVar.klW.setLiveStatus(0);
                    nVar.klW.setAlaInfo(null);
                    nVar.kmp.getHeadView().setLiveStatus(0);
                    nVar.kmp.getHeadView().setAlaInfo(null);
                }
                if (this.kkO != null && this.kkO.cLa()) {
                    nVar.klQ.setVisibility(8);
                    nVar.klQ.setTag(null);
                } else if (postData.aWl() != null) {
                    MetaData aWl = postData.aWl();
                    com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.klQ, R.color.cp_cont_a);
                    if (this.aTI != null && !this.aTI.equals("0") && this.aTI.equals(aWl.getUserId())) {
                        nVar.klQ.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (this.kjs.getDrawable(1) != null) {
                                this.kjs.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.kjs.getDrawable(1) != null) {
                            this.kjs.getDrawable(1).setAlpha(0);
                        }
                        nVar.klQ.setBackgroundDrawable(this.kjs);
                        nVar.klQ.setVisibility(0);
                        nVar.klQ.setText(R.string.host_name);
                    } else if (aWl.getIs_bawu() == 1 && postData.dla()) {
                        int i3 = R.drawable.brand_official_btn;
                        com.baidu.tbadk.core.util.ao.setBackgroundResource(nVar.klQ, i3);
                        nVar.klQ.setTag(Integer.valueOf(i3));
                        nVar.klQ.setVisibility(0);
                        nVar.klQ.setText(R.string.brand_Official);
                    } else if (aWl.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(aWl.getBawu_type())) {
                        nVar.klQ.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.ahB.getDrawable(1) != null) {
                                this.ahB.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ahB.getDrawable(1) != null) {
                            this.ahB.getDrawable(1).setAlpha(0);
                        }
                        nVar.klQ.setBackgroundDrawable(this.ahB);
                        nVar.klQ.setVisibility(0);
                        nVar.klQ.setText(R.string.bawu_member_bazhu_tip);
                    } else if (aWl.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(aWl.getBawu_type())) {
                        nVar.klQ.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.ahC.getDrawable(1) != null) {
                                this.ahC.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ahC.getDrawable(1) != null) {
                            this.ahC.getDrawable(1).setAlpha(0);
                        }
                        nVar.klQ.setBackgroundDrawable(this.ahC);
                        nVar.klQ.setVisibility(0);
                        nVar.klQ.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (aWl.getIs_bawu() == 1 && "pri_content_assist".equals(aWl.getBawu_type())) {
                        int lL = com.baidu.tbadk.core.util.ao.lL(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ao.setBackgroundResource(nVar.klQ, lL);
                        nVar.klQ.setTag(Integer.valueOf(lL));
                        nVar.klQ.setVisibility(0);
                        nVar.klQ.setText(R.string.bawu_content_assist_tip);
                    } else if (aWl.getIs_bawu() == 1 && "pri_manage_assist".equals(aWl.getBawu_type())) {
                        int lL2 = com.baidu.tbadk.core.util.ao.lL(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ao.setBackgroundResource(nVar.klQ, lL2);
                        nVar.klQ.setTag(Integer.valueOf(lL2));
                        nVar.klQ.setVisibility(0);
                        nVar.klQ.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.klQ.setVisibility(8);
                        nVar.klQ.setTag(null);
                    }
                } else {
                    nVar.klQ.setVisibility(8);
                    nVar.klQ.setTag(null);
                }
            }
            int i4 = 0;
            if (this.kmE != null && this.kmE.cNt() != null && this.kmE.cNt().cLF() && postData.aWl() != null) {
                i4 = postData.aWl().getLevel_id();
            }
            if (this.kkO != null && this.kkO.cLa()) {
                i4 = 0;
            }
            if (i4 > 0) {
                nVar.kmo.setVisibility(0);
                com.baidu.tbadk.core.util.ao.setImageResource(nVar.kmo, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                nVar.kmo.setVisibility(8);
            }
            int i5 = 15;
            if (nVar.kmr.getChildCount() == 1) {
                i5 = 13;
            } else if (nVar.kmr.getChildCount() > 1) {
                i5 = 11;
            }
            if (nVar.klQ.getVisibility() == 0) {
                i5 -= 2;
            }
            if (nVar.kmq.getChildCount() > 0) {
                i5 -= 2;
            }
            if (postData.aXK() > 1000) {
                i5 -= 2;
            }
            if (postData.aXK() > 10) {
                i5 -= 2;
            }
            if (i5 < 10) {
                nVar.kmr.setVisibility(8);
                if (nVar.kmr.getChildCount() == 1) {
                    i5 += 2;
                } else if (nVar.kmr.getChildCount() > 1) {
                    i5 += 4;
                }
                if (i5 < 10 && nVar.klQ.getVisibility() == 0) {
                    i5 += 2;
                    nVar.klQ.setVisibility(8);
                }
                if (i5 < 10 && nVar.kmo.getVisibility() == 0) {
                    i5 += 2;
                    nVar.kmo.setVisibility(8);
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
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dli()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.aWl() != null && !StringUtils.isNull(postData.aWl().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.kkO != null && this.kkO.cKM() != 0) {
                if (this.kkO.cKM() != 1002 && this.kkO.cKM() != 3) {
                    z10 = true;
                }
                if (this.kkO.cKM() != 3 && !this.kkO.cLa()) {
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
                        if (this.kkO != null && this.kkO.cKx() != null && this.kkO.cKx().aWl() != null && postData.aWl() != null) {
                            userId = this.kkO.cKx().aWl().getUserId();
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
                                if (postData.dli() == 1) {
                                    i6 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kkO.cKM()));
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
                                    if (this.kkO.cKx() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.kkO.cKx().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kkO.cKM()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.klX.setTag(sparseArray);
                                if (this.klG) {
                                    nVar.kms.setTag(sparseArray);
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
                        if (postData.dli() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        nVar.klX.setTag(sparseArray);
                        if (this.klG) {
                        }
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.kkO != null) {
                userId = this.kkO.cKx().aWl().getUserId();
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
            if (postData.dli() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            nVar.klX.setTag(sparseArray);
            if (this.klG) {
            }
        }
    }

    private void f(n nVar, PostData postData) {
        if (nVar != null && postData != null && nVar.kms != null && this.kkO != null) {
            if (this.klG && !this.kkO.cLa()) {
                nVar.kms.setVisibility(0);
                nVar.kms.setOnClickListener(this.aMH);
                return;
            }
            nVar.kms.setVisibility(8);
        }
    }

    private void b(n nVar, PostData postData, boolean z) {
        if (nVar != null && postData != null && postData.aYc() != null) {
            postData.aYc().threadId = this.kmE.cLP().cNL();
            postData.aYc().objType = 1;
            postData.aYc().isInPost = true;
            bv bvVar = null;
            if (this.kkO != null && this.kkO.cKx() != null) {
                bvVar = this.kkO.cKx();
            }
            if (z) {
                nVar.kmm.setAgreeAlone(true);
                nVar.kmm.setThreadData(bvVar);
                nVar.kmm.setData(postData.aYc());
            }
            if (bvVar != null && bvVar.aUV()) {
                nVar.klV.setAgreeAlone(true);
            }
            nVar.klV.setThreadData(bvVar);
            nVar.klV.setData(postData.aYc());
        }
    }

    private void g(n nVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dli() > 0 && this.kkO != null && !this.kkO.cLa()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dli()));
                nVar.kmn.setVisibility(0);
                nVar.kmn.setText(format);
                z = true;
            } else {
                nVar.kmn.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dll = postData.dll();
            boolean z2 = (dll == null || StringUtils.isNull(dll.getName()) || this.kkO == null || this.kkO.cLa()) ? false : true;
            if (z) {
                nVar.klS.setVisibility(0);
                i = this.ilK;
            } else {
                nVar.klS.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.klT.setVisibility(0);
                i2 = this.ilK;
            } else {
                nVar.klT.setVisibility(8);
                i2 = 0;
            }
            nVar.klR.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.klR.setText(com.baidu.tbadk.core.util.as.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.klR.setText(com.baidu.tbadk.core.util.as.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.klU.setVisibility(0);
                nVar.klU.setPadding(this.ilK, 0, 0, 0);
                if (postData.lNW) {
                    nVar.klU.setText(com.baidu.tbadk.core.util.as.cutStringWithSuffix(dll.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    nVar.klU.setText(dll.getName());
                    return;
                }
            }
            nVar.klU.setVisibility(8);
        }
    }

    private void a(n nVar, PostData postData, View view) {
        if (nVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.klX.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            nVar.klX.setPadding(0, 0, 0, 0);
            if (!this.kkP) {
                nVar.klX.getLayoutStrategy().oT(R.drawable.icon_click);
            } else {
                nVar.klX.AF(null);
                nVar.klX.setBackgroundDrawable(null);
                nVar.klX.getLayoutStrategy().oT(R.drawable.transparent_bg);
            }
            nVar.klX.getLayoutStrategy().oQ(R.drawable.pic_video);
            a(nVar.klX, view, !StringUtils.isNull(postData.getBimg_url()));
            nVar.klX.setLayoutParams(layoutParams);
            nVar.klX.setLinkTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_link_tip_c));
            nVar.klX.setIsFromCDN(this.mIsFromCDN);
            nVar.klX.setText(postData.dlk(), true, this.klE);
            SparseArray sparseArray = (SparseArray) nVar.klX.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            nVar.klX.setTag(sparseArray);
            nVar.klP.setTag(R.id.tag_from, sparseArray);
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
            if (postData.dlm() > 0) {
                nVar.kmc.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) nVar.kmc.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.kmc.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dlu() == 2) {
                    nVar.kmc.setVisibility(8);
                } else if (this.klG) {
                    nVar.klZ.setVisibility(8);
                } else {
                    nVar.kmc.setVisibility(0);
                }
                nVar.kmb.setVisibility(8);
            }
            if (this.klG) {
                if (com.baidu.tbadk.a.d.aRG()) {
                    string = postData.dlm() > 0 ? String.valueOf(postData.dlm()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.reply);
                }
                nVar.kml.setText(string);
                if (nVar.kmg != null) {
                    SparseArray sparseArray2 = (SparseArray) nVar.kmg.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        nVar.kmg.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.kmf != null) {
                    SparseArray sparseArray3 = (SparseArray) nVar.kmf.getTag();
                    if (sparseArray3 == null) {
                        sparseArray3 = new SparseArray();
                        nVar.kmf.setTag(sparseArray3);
                    }
                    sparseArray3.put(R.id.tag_load_sub_data, postData);
                }
            } else {
                if (nVar.kmd != null) {
                    SparseArray sparseArray4 = (SparseArray) nVar.kmd.getTag();
                    if (sparseArray4 == null) {
                        sparseArray4 = new SparseArray();
                        nVar.kmd.setTag(sparseArray4);
                    }
                    sparseArray4.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.iER != null) {
                    SparseArray sparseArray5 = (SparseArray) nVar.iER.getTag();
                    if (sparseArray5 == null) {
                        sparseArray5 = new SparseArray();
                        nVar.iER.setTag(sparseArray5);
                    }
                    sparseArray5.put(R.id.tag_load_sub_data, postData);
                }
            }
            if (postData.dlm() > 0 && !this.klH) {
                nVar.kmb.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dlm())));
                SparseArray sparseArray6 = (SparseArray) nVar.kmb.getTag();
                if (sparseArray6 == null) {
                    sparseArray6 = new SparseArray();
                    nVar.kmb.setTag(sparseArray6);
                }
                sparseArray6.put(R.id.tag_load_sub_data, postData);
                nVar.kmb.setVisibility(0);
                nVar.kmc.setVisibility(8);
                nVar.kma.setVisibility(8);
            } else {
                nVar.kmb.setVisibility(8);
                if (this.klH) {
                    nVar.kmc.setVisibility(8);
                }
                if (postData.dlm() > 0 && postData.dlf() != null && postData.dlf().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kma.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    nVar.kma.setLayoutParams(layoutParams);
                    if (this.klF == null) {
                        this.klF = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.klF.setIsFromCDN(this.mIsFromCDN);
                        this.klF.setOnLongClickListener(this.mOnLongClickListener);
                        this.klF.V(this.kkY);
                        this.klF.z(this.aMH);
                        String str = null;
                        if (this.kkO != null && this.kkO.cKx() != null && this.kkO.cKx().aWl() != null) {
                            str = this.kkO.cKx().aWl().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.kkO != null) {
                            this.klF.aa(this.kkO.cKM(), z);
                            this.klF.setThreadData(this.kkO.cKx());
                        }
                    }
                    this.klF.Lf(postData.getId());
                    nVar.kma.setSubPbAdapter(this.klF);
                    nVar.kma.setVisibility(0);
                    nVar.kma.setData(postData, view);
                    nVar.kma.setChildOnClickListener(this.aMH);
                    nVar.kma.setChildOnLongClickListener(this.mOnLongClickListener);
                    nVar.kma.setChildOnTouchListener(this.klI);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.kma.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    nVar.kma.setLayoutParams(layoutParams2);
                    nVar.kma.setVisibility(8);
                }
            }
            if (postData.lNM) {
                nVar.mBottomLine.setVisibility(0);
            } else {
                nVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(n nVar, PostData postData) {
        if (nVar != null && nVar.kmx != null && nVar.kmu != null) {
            if (postData == null || postData.lNQ == null || StringUtils.isNull(postData.lNQ.liveTitle)) {
                nVar.kmu.setVisibility(8);
                return;
            }
            nVar.kmx.setText(postData.lNQ.liveTitle);
            nVar.kmu.setTag(postData.lNQ);
            nVar.kmu.setVisibility(0);
            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(apVar);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.kmC.setVisibility(postData.lNW ? 0 : 8);
        }
    }

    private void a(n nVar) {
        LayerDrawable layerDrawable;
        if (nVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (nVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.gJq, R.color.cp_cont_d, 1);
                if (nVar.klQ.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.ao.setBackgroundResource(nVar.klQ, ((Integer) nVar.klQ.getTag()).intValue());
                } else if (nVar.klQ.getTag() instanceof String) {
                    if (nVar.klQ.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.ahB;
                    } else if (nVar.klQ.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.ahC;
                    } else {
                        layerDrawable = nVar.klQ.getTag().equals("HOST") ? this.kjs : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.klQ.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.klR, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.klS, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.klT, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kmn, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.klU, R.color.cp_cont_d, 1);
                nVar.klX.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.ao.c(nVar.kma, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kmb, R.color.cp_cont_c);
                nVar.kmb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kmc, R.color.cp_cont_c);
                if (this.klG) {
                    SvgManager.baR().a(nVar.kms, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.baR().a(nVar.kmk, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.baR().a(nVar.kmi, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    nVar.kmm.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kmj, R.color.cp_cont_d);
                    com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kml, R.color.cp_cont_d);
                } else {
                    SvgManager.baR().a(nVar.kmd, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.baR().a(nVar.iER, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                nVar.kma.onChangeSkinType();
                nVar.klY.onChangeSkinType();
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kmx, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kmv, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(nVar.kmu, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(nVar.kmw, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ao.setImageResource(nVar.kmy, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ao.setViewTextColor(nVar.kmB, R.color.cp_cont_c);
                if (nVar.kmz.getVisibility() == 8) {
                    nVar.kmB.setText(R.string.close_content);
                } else if (this.kkO != null && StringUtils.isNull(this.kkO.cKI())) {
                    nVar.kmB.setText(this.kkO.cKI());
                } else {
                    nVar.kmB.setText(R.string.expand_content);
                }
                nVar.klV.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                nVar.zJ(skinType);
                com.baidu.tbadk.core.util.ao.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = skinType;
        }
    }

    private void b(final n nVar) {
        nVar.klP.setOnTouchListener(this.klI);
        nVar.klP.setOnLongClickListener(this.mOnLongClickListener);
        if (this.kmE.cNt() != null && this.kmE.cNt().getPageContext() != null && this.kmE.cNt().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.kmE.cNt().kkn;
            nVar.gJq.setOnClickListener(aVar.hps);
            nVar.klW.setOnClickListener(aVar.hps);
            nVar.kmp.setOnClickListener(aVar.hps);
            nVar.kmp.getHeadView().setOnClickListener(aVar.hps);
            nVar.klX.setOnLongClickListener(this.mOnLongClickListener);
            nVar.klX.setOnTouchListener(this.klI);
            nVar.klX.setCommonTextViewOnClickListener(this.aMH);
            nVar.klX.setOnImageClickListener(this.eRR);
            nVar.klX.setOnImageTouchListener(this.klI);
            nVar.klX.setOnEmotionClickListener(aVar.kAb);
            nVar.klX.setOnVoiceAfterClickListener(this.aMH);
            nVar.kmt.setOnClickListener(this.aMH);
            nVar.kmu.setOnClickListener(this.aMH);
            nVar.kmb.setOnClickListener(this.aMH);
            nVar.kmc.setOnClickListener(this.aMH);
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.kmE.cNt().kko;
            if (this.klG) {
                nVar.kmg.setOnClickListener(this.aMH);
                nVar.kmf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.klP != null && cVar != null) {
                                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.kAq.a(m.this.kkO, null, postData, nVar.klP);
                                    }
                                }, 100L);
                                String threadId = m.this.kkO.getThreadId();
                                if ((StringUtils.isNull(threadId) || "0".equals(m.this.kkO.getThreadId())) && m.this.kkO.cKx() != null) {
                                    threadId = m.this.kkO.cKx().getNid();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13700").dn("tid", threadId).dn("fid", m.this.kkO.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", postData.getId()).ah("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.kmm.eeJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && m.this.kkO != null && nVar != null && nVar.kmm != null && nVar.kmm.getData() != null) {
                            int i = view == nVar.kmm.getImgAgree() ? 1 : 2;
                            String threadId = m.this.kkO.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.kkO.getThreadId())) && m.this.kkO.cKx() != null) {
                                threadId = m.this.kkO.cKx().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13700").dn("tid", threadId).dn("fid", m.this.kkO.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", nVar.kmm.getData().postId).ah("obj_type", i));
                        }
                    }
                };
                return;
            }
            nVar.kmd.setOnClickListener(this.aMH);
            nVar.iER.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.klP != null && cVar != null) {
                            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.kAq.a(m.this.kkO, null, postData, nVar.klP);
                                }
                            }, 100L);
                            String threadId = m.this.kkO.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.kkO.getThreadId())) && m.this.kkO.cKx() != null) {
                                threadId = m.this.kkO.cKx().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13700").dn("tid", threadId).dn("fid", m.this.kkO.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", postData.getId()).ah("obj_type", 4));
                        }
                    }
                }
            });
            nVar.klV.eeJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && m.this.kkO != null && nVar != null && nVar.klV != null && nVar.klV.getData() != null) {
                        int i = view == nVar.klV.getImgAgree() ? 1 : 2;
                        String threadId = m.this.kkO.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(m.this.kkO.getThreadId())) && m.this.kkO.cKx() != null) {
                            threadId = m.this.kkO.cKx().getNid();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13700").dn("tid", threadId).dn("fid", m.this.kkO.getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", nVar.klV.getData().postId).ah("obj_type", i));
                    }
                }
            };
        }
    }

    private void sv() {
        this.ahB = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(this.iml).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bbx(), com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(this.iml).yi("#4D000000").bbx()});
        this.ahC = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(this.iml).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bbx(), com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(this.iml).yi("#4D000000").bbx()});
        this.kjs = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(this.iml).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).bbx(), com.baidu.tbadk.core.util.e.a.c.bbv().ma(0).Q(this.iml).yi("#4D000000").bbx()});
    }

    public void a(TbRichTextView.c cVar) {
        this.klE = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kkO = fVar;
    }

    public void fq(String str) {
        this.aTI = str;
    }

    public void rW(boolean z) {
        this.kkP = z;
    }

    private SpannableStringBuilder dp(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.kmE.cNt(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(n nVar) {
        nVar.klX.setTextViewOnTouchListener(this.euG);
        nVar.klX.setTextViewCheckSelection(false);
    }

    public void R(View.OnClickListener onClickListener) {
        this.kkY = onClickListener;
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
