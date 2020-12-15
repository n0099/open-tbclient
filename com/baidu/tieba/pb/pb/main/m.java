package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class m extends o<PostData, n> implements View.OnClickListener {
    private int aLC;
    private View.OnClickListener bbH;
    private String bkt;
    private TbRichTextView.i fNk;
    private boolean fQu;
    private com.baidu.tieba.pb.a.c fos;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iZr;
    private com.baidu.adp.lib.d.b<TbImageView> iZs;
    private int jjv;
    private View.OnClickListener lEF;
    protected com.baidu.tieba.pb.data.f lEv;
    private boolean lEw;
    private TbRichTextView.c lFl;
    private com.baidu.tieba.pb.pb.sub.b lFm;
    private boolean lFn;
    private com.baidu.tieba.pb.a.c lFo;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void ds(View view) {
        if (view != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (nVar.lFA != null && nVar.lFA.getData() != null) {
                nVar.lFA.buP();
            }
        }
    }

    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jjv = 0;
        this.lFl = null;
        this.lEw = true;
        this.bkt = null;
        this.lEv = null;
        this.lEF = null;
        this.bbH = null;
        this.fNk = null;
        this.fos = null;
        this.mOnLongClickListener = null;
        this.lFm = null;
        this.fQu = true;
        this.lFn = com.baidu.tbadk.a.d.bks();
        this.iZr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cEP */
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
        this.iZs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bvP */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(m.this.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.common_color_10043));
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
        this.lFo = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.m.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (m.this.lDI == null || m.this.lDI.dpc() == null || m.this.lDI.dpc().dsd())) {
                    if (view instanceof RelativeLayout) {
                        m.this.ds(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                m.this.ds((RelativeLayout) parent);
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
                if (m.this.fos != null) {
                    if (!(view instanceof TbListTextView) || m.this.bbH == null) {
                        m.this.fos.ad(view);
                        m.this.fos.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    m.this.bbH.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.dol() != null) {
            this.aLC = bVar.dol().dqV();
        }
        this.jjv = getDimensionPixelSize(R.dimen.tbds14);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ch */
    public n c(ViewGroup viewGroup) {
        View inflate;
        View inflate2 = LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate2.findViewById(R.id.pb_post_reply_container);
        if (com.baidu.tbadk.a.d.bkF()) {
            inflate = LayoutInflater.from(inflate2.getContext()).inflate(R.layout.pb_op_stragtery_c, (ViewGroup) null);
        } else {
            inflate = LayoutInflater.from(inflate2.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null);
        }
        viewGroup2.addView(inflate);
        n nVar = new n(this.lGq.dpR().getPageContext(), inflate2, this.aLC, this.lFn);
        nVar.lFD.setConstrainLayoutPool(this.iZr);
        nVar.lFD.setImageViewPool(this.iZs);
        if (nVar.lFF != null) {
            nVar.lFF.setShowChildComment(this.lFn);
        }
        a(nVar);
        if (nVar.lFC != null) {
            nVar.lFC.setDuiEnabled(this.fQu);
        }
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
            postData2.bqd();
            i(postData2);
            a(nVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.fQu = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.nmD) {
                i = 2;
            }
            com.baidu.tbadk.core.util.ar b = com.baidu.tieba.pb.c.a.b(this.lEv, postData, postData.locate, i, 6);
            postData.nmE = b;
            if (!com.baidu.tbadk.core.util.y.isEmpty(postData.dPe())) {
                Iterator<PostData> it = postData.dPe().iterator();
                while (it.hasNext()) {
                    it.next().nmE = b;
                }
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            nVar.lFJ.setVisibility(8);
            if (com.baidu.tbadk.a.d.bkD()) {
                nVar.lGi.setVisibility(0);
                nVar.lFE.setVisibility(0);
                nVar.lGl.setVisibility(8);
                nVar.lFI.setVisibility(8);
                nVar.jYo.setVisibility(8);
                nVar.lFA.setVisibility(8);
                nVar.lGo.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bkE()) {
                nVar.lGi.setVisibility(0);
                nVar.lFE.setVisibility(0);
                nVar.lGl.setVisibility(0);
                nVar.lFI.setVisibility(8);
                nVar.jYo.setVisibility(8);
                nVar.lFA.setVisibility(8);
                nVar.lGo.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bkF()) {
                nVar.lGl.setVisibility(8);
                nVar.lGi.setVisibility(8);
                nVar.lFE.setVisibility(0);
                nVar.lFI.setVisibility(0);
                nVar.jYo.setVisibility(0);
                nVar.lFA.setVisibility(0);
                nVar.lGo.setVisibility(0);
            } else {
                nVar.lGi.setVisibility(8);
                nVar.lGl.setVisibility(8);
                nVar.lFE.setVisibility(0);
                nVar.lFI.setVisibility(0);
                nVar.jYo.setVisibility(0);
                nVar.lFA.setVisibility(0);
                nVar.lGo.setVisibility(8);
            }
            b(nVar, postData, view, i);
            f(nVar, postData);
            g(nVar, postData);
            a(nVar, postData, view);
            c(nVar, postData, view, i);
            h(nVar, postData);
            a(nVar, postData);
            i(nVar, postData);
            c(nVar, postData);
            e(nVar, postData);
            j(nVar, postData);
            b(nVar, postData);
        }
    }

    private void b(n nVar, PostData postData) {
        if (nVar != null && nVar.lFu != null) {
            if (this.lGq != null && this.lGq.dol() != null && this.lGq.dol().drd() && com.baidu.tbadk.core.util.au.equals(this.lGq.dol().dqj(), postData.getId())) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.lFu, R.color.CAM_X0313);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.lFu, R.color.CAM_X0205);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, boolean z, String str) {
        if (z) {
            nVar.lGe.setVisibility(8);
            if (StringUtils.isNull(str)) {
                nVar.lGg.setText(R.string.expand_content);
                return;
            } else {
                nVar.lGg.setText(str);
                return;
            }
        }
        nVar.lGe.setVisibility(0);
        nVar.lGg.setText(R.string.close_content);
    }

    private void c(final n nVar, final PostData postData) {
        if (postData.dPt() == 2 || postData.dPt() == 4) {
            nVar.lGf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = nVar.lGe.getVisibility() == 8;
                    m.this.a(nVar, !z, postData.dnf());
                    postData.xZ(z ? false : true);
                    m.this.d(nVar, postData);
                    if (m.this.lDI != null && m.this.lDI.dpc() != null && m.this.lDI.dpc().dtg() != null && m.this.lDI.dpc().getListView() != null && !z && nVar.getView().getTop() < m.this.lDI.dpc().dtg().getMeasuredHeight()) {
                        m.this.lDI.dpc().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.y.getPosition(m.this.lDI.dpc().getListView().getData(), postData) + m.this.lDI.dpc().getListView().getHeaderViewsCount(), m.this.lDI.dpc().dtg().getMeasuredHeight());
                    }
                }
            });
            nVar.lGf.setVisibility(0);
            a(nVar, postData.dPc(), postData.dnf());
            a(true, nVar, postData);
        } else {
            nVar.lGf.setVisibility(8);
            nVar.lGe.setVisibility(0);
            a(false, nVar, postData);
        }
        d(nVar, postData);
    }

    private void a(boolean z, n nVar, PostData postData) {
        if (nVar != null && nVar.mBottomLine != null && nVar.lGf != null && (nVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (nVar.lGf.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.y.isEmpty(postData.dPe());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) nVar.lGf.getLayoutParams();
            if (z) {
                nVar.lFC.getLayoutStrategy().tw(0);
                if (z2) {
                    nVar.lFC.getLayoutStrategy().tv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    nVar.lFC.getLayoutStrategy().tv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                nVar.lGf.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    nVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            nVar.lFC.getLayoutStrategy().tv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            nVar.lFC.getLayoutStrategy().tw(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
                nVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(n nVar, PostData postData) {
        TbRichText dPj = postData.dPj();
        dPj.isChanged = true;
        nVar.lFC.setText(dPj, true, this.lFl);
    }

    private void j(PostData postData) {
        if (postData.eKB == 0 && postData.jbR) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12203");
            arVar.dY("post_id", postData.getId());
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dY("cuid", TbadkCoreApplication.getInst().getCuid());
            arVar.dY("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            arVar.dY("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            arVar.dY("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            arVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.lGq != null) {
                int dqV = this.lGq.dol().dqV();
                if (1 == dqV || 2 == dqV) {
                    arVar.dY("obj_source", "1");
                } else if (3 == dqV) {
                    arVar.dY("obj_source", "2");
                } else {
                    arVar.dY("obj_source", "0");
                }
            }
            TiebaStatic.log(arVar);
            if (postData.boP() != null && postData.boP().getAlaInfo() != null && postData.boP().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.boP().getUserId();
        String forumId = this.lEv != null ? this.lEv.getForumId() : "";
        String forumName = this.lEv != null ? this.lEv.getForumName() : "";
        int dPh = postData.dPh();
        String id = postData.getId();
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13714");
        arVar.dY("fid", forumId);
        arVar.dY("fname", forumName);
        arVar.dY("obj_param1", userId);
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dY("tid", id);
        arVar.al(TiebaInitialize.Params.OBJ_PARAM2, dPh);
        TiebaStatic.log(arVar);
    }

    private void l(PostData postData) {
        if (this.lEv != null) {
            if (this.lEv.dnv()) {
                if (this.lGr != null) {
                    com.baidu.tieba.pb.c.a.a(this.lGr.getUniqueId(), this.lEv, postData, postData.locate, postData.nmD ? 2 : 8);
                }
            } else if (this.lDI != null) {
                com.baidu.tieba.pb.c.a.a(this.lDI.getUniqueId(), this.lEv, postData, postData.locate, postData.nmD ? 2 : 8);
            }
        }
    }

    private void a(n nVar, PostData postData) {
        if (postData == null || postData.duZ() == null) {
            nVar.lFY.setVisibility(8);
            return;
        }
        TbRichText dPj = postData.dPj();
        com.baidu.tieba.pb.view.b.a(postData.duZ(), nVar.lFY, false, false, dPj != null && StringUtils.isNull(dPj.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(n nVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lEw) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lFC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.lFC.setLayoutParams(layoutParams);
            nVar.lFC.setPadding(0, 0, 0, 0);
            nVar.lFC.EZ(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.lFC.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.lFC.setLayoutParams(layoutParams2);
            nVar.lFC.EZ(postData.getBimg_url());
        }
        nVar.lFC.setTextViewOnTouchListener(this.lFo);
        nVar.lFC.setTextViewCheckSelection(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:189:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0634  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x07ac  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x07b8  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x07c4  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x07d0  */
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
            if (postData.boP() == null || postData.boP().isBaijiahaoUser()) {
            }
            if (postData.nmu) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mTopLine, R.color.CAM_X0204);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            nVar.lFB.setTag(null);
            nVar.lFB.setUserId(null);
            nVar.hPN.setText((CharSequence) null);
            nVar.lFU.getHeadView().setUserId(null);
            nVar.lFC.setIsHost(false);
            if (postData.boP() != null) {
                if (this.bkt != null && !this.bkt.equals("0") && this.bkt.equals(postData.boP().getUserId())) {
                    nVar.lFC.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.boP().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.boP().getTShowInfoNew();
                if (nVar.lFW != null) {
                    nVar.lFW.setTag(R.id.tag_user_id, postData.boP().getUserId());
                    if (this.lGq != null && this.lGq.dpR() != null) {
                        nVar.lFW.setOnClickListener(this.lGq.dpR().lDU.lUm);
                    }
                    int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    nVar.lFW.a(iconInfo, 2, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (nVar.lFV != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.lFV.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.lGq != null && this.lGq.dpR() != null) {
                        nVar.lFV.setOnClickListener(this.lGq.dpR().lDU.lUn);
                    }
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    nVar.lFV.a(tShowInfoNew, 3, dimens2, dimens2, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(tShowInfoNew) || postData.boP().isBigV()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hPN, R.color.CAM_X0301, 1);
                } else {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hPN, R.color.CAM_X0107, 1);
                }
                String avater = postData.boP().getAvater();
                int i2 = 8;
                if (postData.nmD) {
                    i2 = 2;
                }
                nVar.hPN.setTag(R.id.tag_user_id, postData.boP().getUserId());
                nVar.hPN.setTag(R.id.tag_user_name, postData.boP().getUserName());
                nVar.hPN.setTag(R.id.tag_virtual_user_url, postData.boP().getVirtualUserUrl());
                nVar.hPN.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lEv, postData, postData.locate, i2, 2));
                String name_show = postData.boP().getName_show();
                String userName = postData.boP().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.hPN.setText(com.baidu.tieba.pb.c.aV(this.mContext, nVar.hPN.getText().toString()));
                    nVar.hPN.setGravity(16);
                    nVar.hPN.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmE());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hPN, R.color.CAM_X0312, 1);
                }
                if (postData.boP().getPendantData() != null && !StringUtils.isNull(postData.boP().getPendantData().bmL())) {
                    nVar.lFU.setBigVDimenSize(R.dimen.tbds32);
                    nVar.lFU.a(postData.boP(), 4);
                    nVar.lFB.setVisibility(8);
                    nVar.lFU.setVisibility(0);
                    nVar.lFU.getHeadView().startLoad(avater, 28, false);
                    nVar.lFU.getHeadView().setUserId(postData.boP().getUserId());
                    nVar.lFU.getHeadView().setUserName(postData.boP().getUserName());
                    nVar.lFU.getHeadView().setFid(this.lEv != null ? this.lEv.getForumId() : "");
                    nVar.lFU.getHeadView().setFName(this.lEv != null ? this.lEv.getForumName() : "");
                    nVar.lFU.getHeadView().setFloor(postData.dPh());
                    nVar.lFU.getHeadView().setTid(postData.getId());
                    nVar.lFU.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lEv, postData, postData.locate, i2, 2));
                    nVar.lFU.Cw(postData.boP().getPendantData().bmL());
                } else {
                    nVar.lFB.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.lFB, postData.boP(), 4);
                    nVar.lFB.setUserId(postData.boP().getUserId());
                    nVar.lFB.setFid(this.lEv != null ? this.lEv.getForumId() : "");
                    nVar.lFB.setFName(this.lEv != null ? this.lEv.getForumName() : "");
                    nVar.lFB.setFloor(postData.dPh());
                    nVar.lFB.setTid(postData.getId());
                    nVar.lFB.setUserName(postData.boP().getUserName(), postData.dPr());
                    nVar.lFB.setTag(R.id.tag_virtual_user_url, postData.boP().getVirtualUserUrl());
                    nVar.lFB.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lEv, postData, postData.locate, i2, 2));
                    nVar.lFB.setImageDrawable(null);
                    nVar.lFB.startLoad(avater, 28, false);
                    nVar.lFB.setVisibility(0);
                    nVar.lFU.setVisibility(8);
                }
                if (postData.boP() != null && postData.boP().getAlaInfo() != null && postData.boP().getAlaUserData() != null && postData.boP().getAlaUserData().live_status == 1) {
                    nVar.tp(true);
                    nVar.lFB.setLiveStatus(1);
                    nVar.lFB.setAlaInfo(postData.boP().getAlaInfo());
                    nVar.lFU.getHeadView().setLiveStatus(1);
                    nVar.lFU.getHeadView().setAlaInfo(postData.boP().getAlaInfo());
                } else {
                    nVar.tp(false);
                    nVar.lFB.setLiveStatus(0);
                    nVar.lFB.setAlaInfo(null);
                    nVar.lFU.getHeadView().setLiveStatus(0);
                    nVar.lFU.getHeadView().setAlaInfo(null);
                }
                a(nVar.lFv, postData);
            }
            int i3 = 0;
            if (this.lGq != null && this.lGq.dpR() != null && this.lGq.dpR().dod() && postData.boP() != null) {
                i3 = postData.boP().getLevel_id();
            }
            if (this.lEv != null && this.lEv.dny()) {
                i3 = 0;
            }
            if (i3 > 0) {
                nVar.lFT.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.lFT, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                nVar.lFT.setVisibility(8);
            }
            int i4 = 15;
            if (nVar.lFW.getChildCount() == 1) {
                i4 = 13;
            } else if (nVar.lFW.getChildCount() > 1) {
                i4 = 11;
            }
            if (nVar.lFv.getVisibility() == 0) {
                i4 -= 2;
            }
            if (nVar.lFV.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.bqq() > 1000) {
                i4 -= 2;
            }
            if (postData.bqq() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                nVar.lFW.setVisibility(8);
                if (nVar.lFW.getChildCount() == 1) {
                    i4 += 2;
                } else if (nVar.lFW.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && nVar.lFv.getVisibility() == 0) {
                    i4 += 2;
                    nVar.lFv.setVisibility(8);
                }
                if (i4 < 10 && nVar.lFT.getVisibility() == 0) {
                    i4 += 2;
                    nVar.lFT.setVisibility(8);
                }
            }
            String name_show2 = postData.boP() != null ? postData.boP().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ae.getTextLengthWithEmoji(name_show2);
            if (postData.boP() != null && !StringUtils.isNull(postData.boP().getSealPrefix())) {
                if (textLengthWithEmoji > i4 - 2) {
                    name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i4 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i4) {
                name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i4) + StringHelper.STRING_MORE;
            }
            if (postData.boP() != null && !StringUtils.isNull(postData.boP().getSealPrefix())) {
                nVar.hPN.setText(ea(postData.boP().getSealPrefix(), name_show2));
            } else {
                nVar.hPN.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dPh()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(R.id.pb_dialog_item_zan_1, nVar.lFA);
            sparseArray.put(R.id.pb_dialog_item_zan_2, nVar.lGj);
            sparseArray.put(R.id.pb_dialog_item_reply, nVar.lFI);
            sparseArray.put(R.id.pb_dialog_item_share, nVar.jYo);
            by byVar = null;
            if (this.lEv != null && this.lEv.dmU() != null) {
                byVar = this.lEv.dmU();
            }
            if (byVar != null && byVar.bnz()) {
                sparseArray.put(R.id.pb_dialog_item_isugc, true);
            } else {
                sparseArray.put(R.id.pb_dialog_item_isugc, false);
            }
            boolean z9 = false;
            if (postData.boP() != null && !StringUtils.isNull(postData.boP().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.lEv != null && this.lEv.dnj() != 0) {
                if (this.lEv.dnj() != 1002 && this.lEv.dnj() != 3) {
                    z10 = true;
                }
                if (this.lEv.dnj() != 3 && !this.lEv.dny()) {
                    z11 = true;
                }
                if (postData != null && postData.boP() != null) {
                    String userId2 = postData.boP().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.lEv != null && this.lEv.dmU() != null && this.lEv.dmU().boP() != null && postData.boP() != null) {
                            userId = this.lEv.dmU().boP().getUserId();
                            String userId3 = postData.boP().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.boP() != null && UtilHelper.isCurrentAccount(postData.boP().getUserId())) {
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
                                int i5 = 1;
                                if (postData.dPh() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lEv.dnj()));
                                    if (postData.boP() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.boP().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.boP().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.boP().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.boP() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.boP().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.boP().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.boP().getName_show());
                                    }
                                    if (this.lEv.dmU() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.lEv.dmU().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lEv.dnj()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.lFC.setTag(sparseArray);
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
                        int i52 = 1;
                        if (postData.dPh() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        nVar.lFC.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.lEv != null) {
                userId = this.lEv.dmU().boP().getUserId();
                String userId32 = postData.boP().getUserId();
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
            int i522 = 1;
            if (postData.dPh() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            nVar.lFC.setTag(sparseArray);
        }
    }

    private void l(TextView textView) {
        if (textView != null) {
            Object tag = textView.getTag();
            if (tag instanceof PostData) {
                a(textView, (PostData) tag);
            }
        }
    }

    private void a(TextView textView, PostData postData) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (this.lEv != null && this.lEv.dny()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.boP() != null) {
                MetaData boP = postData.boP();
                if (this.bkt != null && !this.bkt.equals("0") && this.bkt.equals(boP.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).pA(R.string.J_X04).pD(R.dimen.L_X01).ps(R.color.CAM_X0302).pC(R.color.CAM_X0302);
                } else if (boP.getIs_bawu() == 1 && postData.dOZ()) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (boP.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(boP.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (boP.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(boP.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (boP.getIs_bawu() == 1 && "pri_content_assist".equals(boP.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (boP.getIs_bawu() == 1 && "pri_manage_assist".equals(boP.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    private void f(n nVar, PostData postData) {
        if (nVar != null && postData != null && nVar.lFX != null && this.lEv != null) {
            nVar.lFX.setVisibility(8);
        }
    }

    private void g(n nVar, PostData postData) {
        if (nVar != null && postData != null && postData.bqI() != null) {
            postData.bqI().threadId = this.lGq.dol().dqk();
            postData.bqI().objType = 1;
            postData.bqI().isInPost = true;
            by byVar = null;
            if (this.lEv != null && this.lEv.dmU() != null) {
                byVar = this.lEv.dmU();
            }
            if (byVar != null && byVar.bnz()) {
                nVar.lFA.setAgreeAlone(true);
            }
            nVar.lFA.setThreadData(byVar);
            nVar.lFA.setData(postData.bqI());
            nVar.lGj.setThreadData(byVar);
            nVar.lGj.setData(postData.bqI());
        }
    }

    private void h(n nVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dPh() > 0 && this.lEv != null && !this.lEv.dny()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dPh()));
                nVar.lFS.setVisibility(0);
                nVar.lFS.setText(format);
                z = true;
            } else {
                nVar.lFS.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.g dPk = postData.dPk();
            boolean z2 = (dPk == null || StringUtils.isNull(dPk.getName()) || this.lEv == null || this.lEv.dny()) ? false : true;
            if (z) {
                nVar.lFx.setVisibility(0);
                i = this.jjv;
            } else {
                nVar.lFx.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.lFy.setVisibility(0);
                i2 = this.jjv;
            } else {
                nVar.lFy.setVisibility(8);
                i2 = 0;
            }
            nVar.lFw.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.lFw.setText(com.baidu.tbadk.core.util.au.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.lFw.setText(com.baidu.tbadk.core.util.au.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.lFz.setVisibility(0);
                nVar.lFz.setPadding(this.jjv, 0, 0, 0);
                if (postData.nmC) {
                    nVar.lFz.setText(com.baidu.tbadk.core.util.au.cutStringWithSuffix(dPk.getName(), 7, StringHelper.STRING_MORE));
                } else {
                    nVar.lFz.setText(dPk.getName());
                }
            } else {
                nVar.lFz.setVisibility(8);
            }
            nVar.lGm.setText(((Object) nVar.lFw.getText()) + "  • ");
            if (com.baidu.tbadk.a.d.bkE()) {
                if (z) {
                    nVar.lGm.setVisibility(0);
                    nVar.lFw.setVisibility(8);
                    nVar.lFx.setVisibility(8);
                    return;
                }
                nVar.lGm.setVisibility(8);
                nVar.lFw.setVisibility(0);
            }
        }
    }

    private void a(n nVar, PostData postData, View view) {
        if (nVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lFC.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            nVar.lFC.setPadding(0, 0, 0, 0);
            if (!this.lEw) {
                nVar.lFC.getLayoutStrategy().tq(R.drawable.icon_click);
            } else {
                nVar.lFC.EZ(null);
                nVar.lFC.setBackgroundDrawable(null);
                nVar.lFC.getLayoutStrategy().tq(R.drawable.transparent_bg);
            }
            nVar.lFC.getLayoutStrategy().tn(R.drawable.pic_video);
            a(nVar.lFC, view, !StringUtils.isNull(postData.getBimg_url()));
            nVar.lFC.setLayoutParams(layoutParams);
            nVar.lFC.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304));
            nVar.lFC.setIsFromCDN(this.mIsFromCDN);
            nVar.lFC.setText(postData.dPj(), true, this.lFl);
            SparseArray sparseArray = (SparseArray) nVar.lFC.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            nVar.lFC.setTag(sparseArray);
            nVar.lFu.setTag(R.id.tag_from, sparseArray);
            nVar.lGo.setTag(sparseArray);
            nVar.lGk.setTag(sparseArray);
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
            tbRichTextView.getLayoutStrategy().to(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().fPo = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().tp((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            if (postData.dPl() > 0) {
                nVar.lFH.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) nVar.lFH.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.lFH.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dPt() == 2) {
                    nVar.lFH.setVisibility(8);
                } else {
                    nVar.lFH.setVisibility(0);
                }
                nVar.lFG.setVisibility(8);
            }
            if (nVar.lFI != null) {
                SparseArray sparseArray2 = (SparseArray) nVar.lFI.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    nVar.lFI.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
            if (nVar.jYo != null) {
                SparseArray sparseArray3 = (SparseArray) nVar.jYo.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    nVar.jYo.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, postData);
            }
            if (postData.dPl() > 0 && !this.lFn) {
                nVar.lFG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dPl())));
                SparseArray sparseArray4 = (SparseArray) nVar.lFG.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    nVar.lFG.setTag(sparseArray4);
                }
                sparseArray4.put(R.id.tag_load_sub_data, postData);
                nVar.lFG.setVisibility(0);
                nVar.lFH.setVisibility(8);
                nVar.lFF.setVisibility(8);
            } else {
                nVar.lFG.setVisibility(8);
                if (postData.dPl() > 0 && postData.dPe() != null && postData.dPe().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lFF.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    nVar.lFF.setLayoutParams(layoutParams);
                    if (this.lFm == null) {
                        this.lFm = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.lFm.setIsFromCDN(this.mIsFromCDN);
                        this.lFm.setOnLongClickListener(this.mOnLongClickListener);
                        this.lFm.W(this.lEF);
                        this.lFm.B(this.bbH);
                        String str = null;
                        if (this.lEv != null && this.lEv.dmU() != null && this.lEv.dmU().boP() != null) {
                            str = this.lEv.dmU().boP().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.lEv != null) {
                            this.lFm.af(this.lEv.dnj(), z);
                            this.lFm.setThreadData(this.lEv.dmU());
                        }
                    }
                    this.lFm.QI(postData.getId());
                    nVar.lFF.setSubPbAdapter(this.lFm);
                    nVar.lFF.setVisibility(0);
                    nVar.lFF.setData(postData, view);
                    nVar.lFF.setChildOnClickListener(this.bbH);
                    nVar.lFF.setChildOnLongClickListener(this.mOnLongClickListener);
                    nVar.lFF.setChildOnTouchListener(this.lFo);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.lFF.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    nVar.lFF.setLayoutParams(layoutParams2);
                    nVar.lFF.setVisibility(8);
                }
            }
            if (postData.nms) {
                nVar.mBottomLine.setVisibility(0);
            } else {
                nVar.mBottomLine.setVisibility(4);
            }
            if (com.baidu.tbadk.a.d.bkG()) {
                nVar.lFH.setVisibility(8);
            }
            if (com.baidu.tbadk.a.d.bkD()) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) nVar.lFE.getLayoutParams();
                layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (nVar.lFG.getVisibility() == 8) {
                    nVar.lFE.setVisibility(8);
                } else {
                    nVar.lFE.setVisibility(0);
                }
            } else if (com.baidu.tbadk.a.d.bkE()) {
                ((LinearLayout.LayoutParams) nVar.lFE.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (nVar.lFG.getVisibility() == 8) {
                    nVar.lFE.setVisibility(8);
                    ((LinearLayout.LayoutParams) nVar.lGl.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
                } else {
                    nVar.lFE.setVisibility(0);
                    ((LinearLayout.LayoutParams) nVar.lGl.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
                }
            } else if (com.baidu.tbadk.a.d.bkF()) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) nVar.lFE.getLayoutParams();
                if (nVar.lFG.getVisibility() == 8) {
                    layoutParams4.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_12);
                } else {
                    layoutParams4.bottomMargin = 0;
                }
            }
            nVar.lGn.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && nVar.lGc != null && nVar.lFZ != null) {
            if (postData == null || postData.nmw == null || StringUtils.isNull(postData.nmw.liveTitle)) {
                nVar.lFZ.setVisibility(8);
                return;
            }
            nVar.lGc.setText(postData.nmw.liveTitle);
            nVar.lFZ.setTag(postData.nmw);
            nVar.lFZ.setVisibility(0);
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(arVar);
        }
    }

    private void j(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.lGh.setVisibility(postData.nmC ? 0 : 8);
        }
    }

    private void a(n nVar) {
        if (nVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (nVar.mSkinType != skinType) {
                l(nVar.lFv);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hPN, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFw, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFx, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFy, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFS, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFz, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFH, R.color.CAM_X0108);
                nVar.lFC.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lGm, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lGn, R.color.CAM_X0107, 1);
                com.baidu.tbadk.core.util.ap.d(nVar.lFF, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                int color = com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFG, R.color.CAM_X0107);
                if (com.baidu.tbadk.a.d.bkG()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFG, R.color.CAM_X0304);
                    color = com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304);
                }
                nVar.lFG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, color, (WebPManager.ResourceStateType) null), (Drawable) null);
                WebPManager.a(nVar.lFI, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(nVar.jYo, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                nVar.lFF.onChangeSkinType();
                nVar.lFD.onChangeSkinType();
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lGc, R.color.CAM_X0304, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lGa, R.color.CAM_X0106, 1);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lFZ, R.color.CAM_X0205);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lGb, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.lGd, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lGg, R.color.CAM_X0107);
                if (nVar.lGe.getVisibility() == 8) {
                    nVar.lGg.setText(R.string.close_content);
                } else if (this.lEv != null && StringUtils.isNull(this.lEv.dnf())) {
                    nVar.lGg.setText(this.lEv.dnf());
                } else {
                    nVar.lGg.setText(R.string.expand_content);
                }
                nVar.lFA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                nVar.Fc(skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mBottomLine, R.color.CAM_X0203);
                WebPManager.a(nVar.lGk, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(nVar.lGo, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            nVar.mSkinType = skinType;
        }
    }

    private void b(final n nVar) {
        nVar.lFu.setOnTouchListener(this.lFo);
        nVar.lFu.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lGq.dpR() != null && this.lGq.dpR().getPageContext() != null && this.lGq.dpR().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.lGq.dpR().lDU;
            nVar.hPN.setOnClickListener(aVar.iCs);
            nVar.lFB.setOnClickListener(aVar.iCs);
            nVar.lFU.setOnClickListener(aVar.iCs);
            nVar.lFU.getHeadView().setOnClickListener(aVar.iCs);
            nVar.lFC.setOnLongClickListener(this.mOnLongClickListener);
            nVar.lFC.setOnTouchListener(this.lFo);
            nVar.lFC.setCommonTextViewOnClickListener(this.bbH);
            nVar.lFC.setOnImageClickListener(this.fNk);
            nVar.lFC.setOnImageTouchListener(this.lFo);
            nVar.lFC.setOnEmotionClickListener(aVar.lUo);
            nVar.lFC.setOnVoiceAfterClickListener(this.bbH);
            nVar.lFY.setOnClickListener(this.bbH);
            nVar.lFZ.setOnClickListener(this.bbH);
            nVar.lFG.setOnClickListener(this.bbH);
            nVar.lFH.setOnClickListener(this.bbH);
            nVar.lGk.setOnClickListener(this.bbH);
            nVar.lGo.setOnClickListener(this.bbH);
            nVar.lGl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    nVar.lFI.performClick();
                }
            });
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.lGq.dpR().lDV;
            nVar.lFI.setOnClickListener(this.bbH);
            nVar.jYo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lFu != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.lUD.a(m.this.lEv, null, postData, nVar.lFC.getLayoutStrategy());
                                }
                            }, 100L);
                            String threadId = m.this.lEv.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.lEv.getThreadId())) && m.this.lEv.dmU() != null) {
                                threadId = m.this.lEv.dmU().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dY("tid", threadId).dY("fid", m.this.lEv.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", postData.getId()).dY("obj_source", m.this.dt(view)).al("obj_type", 4));
                        }
                    }
                }
            });
            nVar.lFA.eXr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && m.this.lEv != null && nVar != null && nVar.lFA != null && nVar.lFA.getData() != null) {
                        int i = view == nVar.lFA.getImgAgree() ? 1 : 2;
                        String threadId = m.this.lEv.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(m.this.lEv.getThreadId())) && m.this.lEv.dmU() != null) {
                            threadId = m.this.lEv.dmU().getNid();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dY("tid", threadId).dY("fid", m.this.lEv.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", nVar.lFA.getData().postId).dY("obj_source", m.this.dt(nVar.lFA)).al("obj_type", i));
                    }
                }
            };
            nVar.lGj.eXr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && m.this.lEv != null && nVar != null && nVar.lGj != null && nVar.lGj.getData() != null) {
                        int i = view == nVar.lGj.getImgAgree() ? 1 : 2;
                        String threadId = m.this.lEv.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(m.this.lEv.getThreadId())) && m.this.lEv.dmU() != null) {
                            threadId = m.this.lEv.dmU().getNid();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dY("tid", threadId).dY("fid", m.this.lEv.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", nVar.lGj.getData().postId).dY("obj_source", m.this.dt(nVar.lGj)).al("obj_type", i));
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dt(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return "1";
        }
        Object obj = sparseArray.get(R.id.pb_track_more_obj_source);
        if (obj == null) {
            obj = "1";
        }
        sparseArray.remove(R.id.pb_track_more_obj_source);
        view.setTag(sparseArray);
        return obj.toString();
    }

    public void a(TbRichTextView.c cVar) {
        this.lFl = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lEv = fVar;
    }

    public void hY(String str) {
        this.bkt = str;
    }

    public void uy(boolean z) {
        this.lEw = z;
    }

    private SpannableStringBuilder ea(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.lGq.dpR(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(n nVar) {
        nVar.lFC.setTextViewOnTouchListener(this.fos);
        nVar.lFC.setTextViewCheckSelection(false);
    }

    public void S(View.OnClickListener onClickListener) {
        this.lEF = onClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.bbH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fNk = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fos = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
