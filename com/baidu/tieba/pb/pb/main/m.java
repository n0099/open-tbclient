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
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iZp;
    private com.baidu.adp.lib.d.b<TbImageView> iZq;
    private int jjt;
    private View.OnClickListener lED;
    protected com.baidu.tieba.pb.data.f lEt;
    private boolean lEu;
    private TbRichTextView.c lFj;
    private com.baidu.tieba.pb.pb.sub.b lFk;
    private boolean lFl;
    private com.baidu.tieba.pb.a.c lFm;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void ds(View view) {
        if (view != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (nVar.lFy != null && nVar.lFy.getData() != null) {
                nVar.lFy.buP();
            }
        }
    }

    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.jjt = 0;
        this.lFj = null;
        this.lEu = true;
        this.bkt = null;
        this.lEt = null;
        this.lED = null;
        this.bbH = null;
        this.fNk = null;
        this.fos = null;
        this.mOnLongClickListener = null;
        this.lFk = null;
        this.fQu = true;
        this.lFl = com.baidu.tbadk.a.d.bks();
        this.iZp = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cEO */
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
        this.iZq = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.m.2
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
        this.lFm = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.m.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (m.this.lDG == null || m.this.lDG.dpb() == null || m.this.lDG.dpb().dsc())) {
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
        if (bVar != null && bVar.dok() != null) {
            this.aLC = bVar.dok().dqU();
        }
        this.jjt = getDimensionPixelSize(R.dimen.tbds14);
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
        n nVar = new n(this.lGo.dpQ().getPageContext(), inflate2, this.aLC, this.lFl);
        nVar.lFB.setConstrainLayoutPool(this.iZp);
        nVar.lFB.setImageViewPool(this.iZq);
        if (nVar.lFD != null) {
            nVar.lFD.setShowChildComment(this.lFl);
        }
        a(nVar);
        if (nVar.lFA != null) {
            nVar.lFA.setDuiEnabled(this.fQu);
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
            if (postData.nmB) {
                i = 2;
            }
            com.baidu.tbadk.core.util.ar b = com.baidu.tieba.pb.c.a.b(this.lEt, postData, postData.locate, i, 6);
            postData.nmC = b;
            if (!com.baidu.tbadk.core.util.y.isEmpty(postData.dPd())) {
                Iterator<PostData> it = postData.dPd().iterator();
                while (it.hasNext()) {
                    it.next().nmC = b;
                }
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            nVar.lFH.setVisibility(8);
            if (com.baidu.tbadk.a.d.bkD()) {
                nVar.lGg.setVisibility(0);
                nVar.lFC.setVisibility(0);
                nVar.lGj.setVisibility(8);
                nVar.lFG.setVisibility(8);
                nVar.jYm.setVisibility(8);
                nVar.lFy.setVisibility(8);
                nVar.lGm.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bkE()) {
                nVar.lGg.setVisibility(0);
                nVar.lFC.setVisibility(0);
                nVar.lGj.setVisibility(0);
                nVar.lFG.setVisibility(8);
                nVar.jYm.setVisibility(8);
                nVar.lFy.setVisibility(8);
                nVar.lGm.setVisibility(8);
            } else if (com.baidu.tbadk.a.d.bkF()) {
                nVar.lGj.setVisibility(8);
                nVar.lGg.setVisibility(8);
                nVar.lFC.setVisibility(0);
                nVar.lFG.setVisibility(0);
                nVar.jYm.setVisibility(0);
                nVar.lFy.setVisibility(0);
                nVar.lGm.setVisibility(0);
            } else {
                nVar.lGg.setVisibility(8);
                nVar.lGj.setVisibility(8);
                nVar.lFC.setVisibility(0);
                nVar.lFG.setVisibility(0);
                nVar.jYm.setVisibility(0);
                nVar.lFy.setVisibility(0);
                nVar.lGm.setVisibility(8);
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
        if (nVar != null && nVar.lFs != null) {
            if (this.lGo != null && this.lGo.dok() != null && this.lGo.dok().drc() && com.baidu.tbadk.core.util.au.equals(this.lGo.dok().dqi(), postData.getId())) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.lFs, R.color.CAM_X0313);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.lFs, R.color.CAM_X0205);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, boolean z, String str) {
        if (z) {
            nVar.lGc.setVisibility(8);
            if (StringUtils.isNull(str)) {
                nVar.lGe.setText(R.string.expand_content);
                return;
            } else {
                nVar.lGe.setText(str);
                return;
            }
        }
        nVar.lGc.setVisibility(0);
        nVar.lGe.setText(R.string.close_content);
    }

    private void c(final n nVar, final PostData postData) {
        if (postData.dPs() == 2 || postData.dPs() == 4) {
            nVar.lGd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = nVar.lGc.getVisibility() == 8;
                    m.this.a(nVar, !z, postData.dne());
                    postData.xZ(z ? false : true);
                    m.this.d(nVar, postData);
                    if (m.this.lDG != null && m.this.lDG.dpb() != null && m.this.lDG.dpb().dtf() != null && m.this.lDG.dpb().getListView() != null && !z && nVar.getView().getTop() < m.this.lDG.dpb().dtf().getMeasuredHeight()) {
                        m.this.lDG.dpb().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.y.getPosition(m.this.lDG.dpb().getListView().getData(), postData) + m.this.lDG.dpb().getListView().getHeaderViewsCount(), m.this.lDG.dpb().dtf().getMeasuredHeight());
                    }
                }
            });
            nVar.lGd.setVisibility(0);
            a(nVar, postData.dPb(), postData.dne());
            a(true, nVar, postData);
        } else {
            nVar.lGd.setVisibility(8);
            nVar.lGc.setVisibility(0);
            a(false, nVar, postData);
        }
        d(nVar, postData);
    }

    private void a(boolean z, n nVar, PostData postData) {
        if (nVar != null && nVar.mBottomLine != null && nVar.lGd != null && (nVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (nVar.lGd.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.y.isEmpty(postData.dPd());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) nVar.lGd.getLayoutParams();
            if (z) {
                nVar.lFA.getLayoutStrategy().tw(0);
                if (z2) {
                    nVar.lFA.getLayoutStrategy().tv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    nVar.lFA.getLayoutStrategy().tv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                nVar.lGd.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    nVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            nVar.lFA.getLayoutStrategy().tv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            nVar.lFA.getLayoutStrategy().tw(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds14);
                nVar.mBottomLine.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(n nVar, PostData postData) {
        TbRichText dPi = postData.dPi();
        dPi.isChanged = true;
        nVar.lFA.setText(dPi, true, this.lFj);
    }

    private void j(PostData postData) {
        if (postData.eKB == 0 && postData.jbP) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12203");
            arVar.dY("post_id", postData.getId());
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dY("cuid", TbadkCoreApplication.getInst().getCuid());
            arVar.dY("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            arVar.dY("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            arVar.dY("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            arVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.lGo != null) {
                int dqU = this.lGo.dok().dqU();
                if (1 == dqU || 2 == dqU) {
                    arVar.dY("obj_source", "1");
                } else if (3 == dqU) {
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
        String forumId = this.lEt != null ? this.lEt.getForumId() : "";
        String forumName = this.lEt != null ? this.lEt.getForumName() : "";
        int dPg = postData.dPg();
        String id = postData.getId();
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13714");
        arVar.dY("fid", forumId);
        arVar.dY("fname", forumName);
        arVar.dY("obj_param1", userId);
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dY("tid", id);
        arVar.al(TiebaInitialize.Params.OBJ_PARAM2, dPg);
        TiebaStatic.log(arVar);
    }

    private void l(PostData postData) {
        if (this.lEt != null) {
            if (this.lEt.dnu()) {
                if (this.lGp != null) {
                    com.baidu.tieba.pb.c.a.a(this.lGp.getUniqueId(), this.lEt, postData, postData.locate, postData.nmB ? 2 : 8);
                }
            } else if (this.lDG != null) {
                com.baidu.tieba.pb.c.a.a(this.lDG.getUniqueId(), this.lEt, postData, postData.locate, postData.nmB ? 2 : 8);
            }
        }
    }

    private void a(n nVar, PostData postData) {
        if (postData == null || postData.duY() == null) {
            nVar.lFW.setVisibility(8);
            return;
        }
        TbRichText dPi = postData.dPi();
        com.baidu.tieba.pb.view.b.a(postData.duY(), nVar.lFW, false, false, dPi != null && StringUtils.isNull(dPi.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(n nVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lEu) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lFA.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.lFA.setLayoutParams(layoutParams);
            nVar.lFA.setPadding(0, 0, 0, 0);
            nVar.lFA.EZ(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.lFA.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.lFA.setLayoutParams(layoutParams2);
            nVar.lFA.EZ(postData.getBimg_url());
        }
        nVar.lFA.setTextViewOnTouchListener(this.lFm);
        nVar.lFA.setTextViewCheckSelection(false);
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
            if (postData.nms) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mTopLine, R.color.CAM_X0204);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            nVar.lFz.setTag(null);
            nVar.lFz.setUserId(null);
            nVar.hPL.setText((CharSequence) null);
            nVar.lFS.getHeadView().setUserId(null);
            nVar.lFA.setIsHost(false);
            if (postData.boP() != null) {
                if (this.bkt != null && !this.bkt.equals("0") && this.bkt.equals(postData.boP().getUserId())) {
                    nVar.lFA.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.boP().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.boP().getTShowInfoNew();
                if (nVar.lFU != null) {
                    nVar.lFU.setTag(R.id.tag_user_id, postData.boP().getUserId());
                    if (this.lGo != null && this.lGo.dpQ() != null) {
                        nVar.lFU.setOnClickListener(this.lGo.dpQ().lDS.lUk);
                    }
                    int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    nVar.lFU.a(iconInfo, 2, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (nVar.lFT != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.lFT.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.lGo != null && this.lGo.dpQ() != null) {
                        nVar.lFT.setOnClickListener(this.lGo.dpQ().lDS.lUl);
                    }
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    nVar.lFT.a(tShowInfoNew, 3, dimens2, dimens2, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(tShowInfoNew) || postData.boP().isBigV()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hPL, R.color.CAM_X0301, 1);
                } else {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hPL, R.color.CAM_X0107, 1);
                }
                String avater = postData.boP().getAvater();
                int i2 = 8;
                if (postData.nmB) {
                    i2 = 2;
                }
                nVar.hPL.setTag(R.id.tag_user_id, postData.boP().getUserId());
                nVar.hPL.setTag(R.id.tag_user_name, postData.boP().getUserName());
                nVar.hPL.setTag(R.id.tag_virtual_user_url, postData.boP().getVirtualUserUrl());
                nVar.hPL.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lEt, postData, postData.locate, i2, 2));
                String name_show = postData.boP().getName_show();
                String userName = postData.boP().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.hPL.setText(com.baidu.tieba.pb.c.aV(this.mContext, nVar.hPL.getText().toString()));
                    nVar.hPL.setGravity(16);
                    nVar.hPL.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmD());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hPL, R.color.CAM_X0312, 1);
                }
                if (postData.boP().getPendantData() != null && !StringUtils.isNull(postData.boP().getPendantData().bmL())) {
                    nVar.lFS.setBigVDimenSize(R.dimen.tbds32);
                    nVar.lFS.a(postData.boP(), 4);
                    nVar.lFz.setVisibility(8);
                    nVar.lFS.setVisibility(0);
                    nVar.lFS.getHeadView().startLoad(avater, 28, false);
                    nVar.lFS.getHeadView().setUserId(postData.boP().getUserId());
                    nVar.lFS.getHeadView().setUserName(postData.boP().getUserName());
                    nVar.lFS.getHeadView().setFid(this.lEt != null ? this.lEt.getForumId() : "");
                    nVar.lFS.getHeadView().setFName(this.lEt != null ? this.lEt.getForumName() : "");
                    nVar.lFS.getHeadView().setFloor(postData.dPg());
                    nVar.lFS.getHeadView().setTid(postData.getId());
                    nVar.lFS.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lEt, postData, postData.locate, i2, 2));
                    nVar.lFS.Cw(postData.boP().getPendantData().bmL());
                } else {
                    nVar.lFz.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.lFz, postData.boP(), 4);
                    nVar.lFz.setUserId(postData.boP().getUserId());
                    nVar.lFz.setFid(this.lEt != null ? this.lEt.getForumId() : "");
                    nVar.lFz.setFName(this.lEt != null ? this.lEt.getForumName() : "");
                    nVar.lFz.setFloor(postData.dPg());
                    nVar.lFz.setTid(postData.getId());
                    nVar.lFz.setUserName(postData.boP().getUserName(), postData.dPq());
                    nVar.lFz.setTag(R.id.tag_virtual_user_url, postData.boP().getVirtualUserUrl());
                    nVar.lFz.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lEt, postData, postData.locate, i2, 2));
                    nVar.lFz.setImageDrawable(null);
                    nVar.lFz.startLoad(avater, 28, false);
                    nVar.lFz.setVisibility(0);
                    nVar.lFS.setVisibility(8);
                }
                if (postData.boP() != null && postData.boP().getAlaInfo() != null && postData.boP().getAlaUserData() != null && postData.boP().getAlaUserData().live_status == 1) {
                    nVar.tp(true);
                    nVar.lFz.setLiveStatus(1);
                    nVar.lFz.setAlaInfo(postData.boP().getAlaInfo());
                    nVar.lFS.getHeadView().setLiveStatus(1);
                    nVar.lFS.getHeadView().setAlaInfo(postData.boP().getAlaInfo());
                } else {
                    nVar.tp(false);
                    nVar.lFz.setLiveStatus(0);
                    nVar.lFz.setAlaInfo(null);
                    nVar.lFS.getHeadView().setLiveStatus(0);
                    nVar.lFS.getHeadView().setAlaInfo(null);
                }
                a(nVar.lFt, postData);
            }
            int i3 = 0;
            if (this.lGo != null && this.lGo.dpQ() != null && this.lGo.dpQ().doc() && postData.boP() != null) {
                i3 = postData.boP().getLevel_id();
            }
            if (this.lEt != null && this.lEt.dnx()) {
                i3 = 0;
            }
            if (i3 > 0) {
                nVar.lFR.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.lFR, BitmapHelper.getGradeResourceIdInEnterForum(i3));
            } else {
                nVar.lFR.setVisibility(8);
            }
            int i4 = 15;
            if (nVar.lFU.getChildCount() == 1) {
                i4 = 13;
            } else if (nVar.lFU.getChildCount() > 1) {
                i4 = 11;
            }
            if (nVar.lFt.getVisibility() == 0) {
                i4 -= 2;
            }
            if (nVar.lFT.getChildCount() > 0) {
                i4 -= 2;
            }
            if (postData.bqq() > 1000) {
                i4 -= 2;
            }
            if (postData.bqq() > 10) {
                i4 -= 2;
            }
            if (i4 < 10) {
                nVar.lFU.setVisibility(8);
                if (nVar.lFU.getChildCount() == 1) {
                    i4 += 2;
                } else if (nVar.lFU.getChildCount() > 1) {
                    i4 += 4;
                }
                if (i4 < 10 && nVar.lFt.getVisibility() == 0) {
                    i4 += 2;
                    nVar.lFt.setVisibility(8);
                }
                if (i4 < 10 && nVar.lFR.getVisibility() == 0) {
                    i4 += 2;
                    nVar.lFR.setVisibility(8);
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
                nVar.hPL.setText(ea(postData.boP().getSealPrefix(), name_show2));
            } else {
                nVar.hPL.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dPg()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(R.id.pb_dialog_item_zan_1, nVar.lFy);
            sparseArray.put(R.id.pb_dialog_item_zan_2, nVar.lGh);
            sparseArray.put(R.id.pb_dialog_item_reply, nVar.lFG);
            sparseArray.put(R.id.pb_dialog_item_share, nVar.jYm);
            by byVar = null;
            if (this.lEt != null && this.lEt.dmT() != null) {
                byVar = this.lEt.dmT();
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
            if (this.lEt != null && this.lEt.dni() != 0) {
                if (this.lEt.dni() != 1002 && this.lEt.dni() != 3) {
                    z10 = true;
                }
                if (this.lEt.dni() != 3 && !this.lEt.dnx()) {
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
                        if (this.lEt != null && this.lEt.dmT() != null && this.lEt.dmT().boP() != null && postData.boP() != null) {
                            userId = this.lEt.dmT().boP().getUserId();
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
                                if (postData.dPg() == 1) {
                                    i5 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lEt.dni()));
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
                                    if (this.lEt.dmT() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.lEt.dmT().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lEt.dni()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.lFA.setTag(sparseArray);
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
                        if (postData.dPg() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        nVar.lFA.setTag(sparseArray);
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.lEt != null) {
                userId = this.lEt.dmT().boP().getUserId();
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
            if (postData.dPg() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            nVar.lFA.setTag(sparseArray);
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
            if (this.lEt != null && this.lEt.dnx()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.boP() != null) {
                MetaData boP = postData.boP();
                if (this.bkt != null && !this.bkt.equals("0") && this.bkt.equals(boP.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).pA(R.string.J_X04).pD(R.dimen.L_X01).ps(R.color.CAM_X0302).pC(R.color.CAM_X0302);
                } else if (boP.getIs_bawu() == 1 && postData.dOY()) {
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
        if (nVar != null && postData != null && nVar.lFV != null && this.lEt != null) {
            nVar.lFV.setVisibility(8);
        }
    }

    private void g(n nVar, PostData postData) {
        if (nVar != null && postData != null && postData.bqI() != null) {
            postData.bqI().threadId = this.lGo.dok().dqj();
            postData.bqI().objType = 1;
            postData.bqI().isInPost = true;
            by byVar = null;
            if (this.lEt != null && this.lEt.dmT() != null) {
                byVar = this.lEt.dmT();
            }
            if (byVar != null && byVar.bnz()) {
                nVar.lFy.setAgreeAlone(true);
            }
            nVar.lFy.setThreadData(byVar);
            nVar.lFy.setData(postData.bqI());
            nVar.lGh.setThreadData(byVar);
            nVar.lGh.setData(postData.bqI());
        }
    }

    private void h(n nVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dPg() > 0 && this.lEt != null && !this.lEt.dnx()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dPg()));
                nVar.lFQ.setVisibility(0);
                nVar.lFQ.setText(format);
                z = true;
            } else {
                nVar.lFQ.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.g dPj = postData.dPj();
            boolean z2 = (dPj == null || StringUtils.isNull(dPj.getName()) || this.lEt == null || this.lEt.dnx()) ? false : true;
            if (z) {
                nVar.lFv.setVisibility(0);
                i = this.jjt;
            } else {
                nVar.lFv.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.lFw.setVisibility(0);
                i2 = this.jjt;
            } else {
                nVar.lFw.setVisibility(8);
                i2 = 0;
            }
            nVar.lFu.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.lFu.setText(com.baidu.tbadk.core.util.au.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.lFu.setText(com.baidu.tbadk.core.util.au.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.lFx.setVisibility(0);
                nVar.lFx.setPadding(this.jjt, 0, 0, 0);
                if (postData.nmA) {
                    nVar.lFx.setText(com.baidu.tbadk.core.util.au.cutStringWithSuffix(dPj.getName(), 7, StringHelper.STRING_MORE));
                } else {
                    nVar.lFx.setText(dPj.getName());
                }
            } else {
                nVar.lFx.setVisibility(8);
            }
            nVar.lGk.setText(((Object) nVar.lFu.getText()) + "  • ");
            if (com.baidu.tbadk.a.d.bkE()) {
                if (z) {
                    nVar.lGk.setVisibility(0);
                    nVar.lFu.setVisibility(8);
                    nVar.lFv.setVisibility(8);
                    return;
                }
                nVar.lGk.setVisibility(8);
                nVar.lFu.setVisibility(0);
            }
        }
    }

    private void a(n nVar, PostData postData, View view) {
        if (nVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lFA.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            nVar.lFA.setPadding(0, 0, 0, 0);
            if (!this.lEu) {
                nVar.lFA.getLayoutStrategy().tq(R.drawable.icon_click);
            } else {
                nVar.lFA.EZ(null);
                nVar.lFA.setBackgroundDrawable(null);
                nVar.lFA.getLayoutStrategy().tq(R.drawable.transparent_bg);
            }
            nVar.lFA.getLayoutStrategy().tn(R.drawable.pic_video);
            a(nVar.lFA, view, !StringUtils.isNull(postData.getBimg_url()));
            nVar.lFA.setLayoutParams(layoutParams);
            nVar.lFA.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304));
            nVar.lFA.setIsFromCDN(this.mIsFromCDN);
            nVar.lFA.setText(postData.dPi(), true, this.lFj);
            SparseArray sparseArray = (SparseArray) nVar.lFA.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            nVar.lFA.setTag(sparseArray);
            nVar.lFs.setTag(R.id.tag_from, sparseArray);
            nVar.lGm.setTag(sparseArray);
            nVar.lGi.setTag(sparseArray);
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
            if (postData.dPk() > 0) {
                nVar.lFF.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) nVar.lFF.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.lFF.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dPs() == 2) {
                    nVar.lFF.setVisibility(8);
                } else {
                    nVar.lFF.setVisibility(0);
                }
                nVar.lFE.setVisibility(8);
            }
            if (nVar.lFG != null) {
                SparseArray sparseArray2 = (SparseArray) nVar.lFG.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    nVar.lFG.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, postData);
            }
            if (nVar.jYm != null) {
                SparseArray sparseArray3 = (SparseArray) nVar.jYm.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    nVar.jYm.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, postData);
            }
            if (postData.dPk() > 0 && !this.lFl) {
                nVar.lFE.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dPk())));
                SparseArray sparseArray4 = (SparseArray) nVar.lFE.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    nVar.lFE.setTag(sparseArray4);
                }
                sparseArray4.put(R.id.tag_load_sub_data, postData);
                nVar.lFE.setVisibility(0);
                nVar.lFF.setVisibility(8);
                nVar.lFD.setVisibility(8);
            } else {
                nVar.lFE.setVisibility(8);
                if (postData.dPk() > 0 && postData.dPd() != null && postData.dPd().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lFD.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds148);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X007);
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20);
                    nVar.lFD.setLayoutParams(layoutParams);
                    if (this.lFk == null) {
                        this.lFk = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.lFk.setIsFromCDN(this.mIsFromCDN);
                        this.lFk.setOnLongClickListener(this.mOnLongClickListener);
                        this.lFk.W(this.lED);
                        this.lFk.B(this.bbH);
                        String str = null;
                        if (this.lEt != null && this.lEt.dmT() != null && this.lEt.dmT().boP() != null) {
                            str = this.lEt.dmT().boP().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.lEt != null) {
                            this.lFk.af(this.lEt.dni(), z);
                            this.lFk.setThreadData(this.lEt.dmT());
                        }
                    }
                    this.lFk.QI(postData.getId());
                    nVar.lFD.setSubPbAdapter(this.lFk);
                    nVar.lFD.setVisibility(0);
                    nVar.lFD.setData(postData, view);
                    nVar.lFD.setChildOnClickListener(this.bbH);
                    nVar.lFD.setChildOnLongClickListener(this.mOnLongClickListener);
                    nVar.lFD.setChildOnTouchListener(this.lFm);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.lFD.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    nVar.lFD.setLayoutParams(layoutParams2);
                    nVar.lFD.setVisibility(8);
                }
            }
            if (postData.nmq) {
                nVar.mBottomLine.setVisibility(0);
            } else {
                nVar.mBottomLine.setVisibility(4);
            }
            if (com.baidu.tbadk.a.d.bkG()) {
                nVar.lFF.setVisibility(8);
            }
            if (com.baidu.tbadk.a.d.bkD()) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) nVar.lFC.getLayoutParams();
                layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (nVar.lFE.getVisibility() == 8) {
                    nVar.lFC.setVisibility(8);
                } else {
                    nVar.lFC.setVisibility(0);
                }
            } else if (com.baidu.tbadk.a.d.bkE()) {
                ((LinearLayout.LayoutParams) nVar.lFC.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
                if (nVar.lFE.getVisibility() == 8) {
                    nVar.lFC.setVisibility(8);
                    ((LinearLayout.LayoutParams) nVar.lGj.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
                } else {
                    nVar.lFC.setVisibility(0);
                    ((LinearLayout.LayoutParams) nVar.lGj.getLayoutParams()).bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
                }
            } else if (com.baidu.tbadk.a.d.bkF()) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) nVar.lFC.getLayoutParams();
                if (nVar.lFE.getVisibility() == 8) {
                    layoutParams4.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_12);
                } else {
                    layoutParams4.bottomMargin = 0;
                }
            }
            nVar.lGl.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && nVar.lGa != null && nVar.lFX != null) {
            if (postData == null || postData.nmu == null || StringUtils.isNull(postData.nmu.liveTitle)) {
                nVar.lFX.setVisibility(8);
                return;
            }
            nVar.lGa.setText(postData.nmu.liveTitle);
            nVar.lFX.setTag(postData.nmu);
            nVar.lFX.setVisibility(0);
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(arVar);
        }
    }

    private void j(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.lGf.setVisibility(postData.nmA ? 0 : 8);
        }
    }

    private void a(n nVar) {
        if (nVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (nVar.mSkinType != skinType) {
                l(nVar.lFt);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hPL, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFu, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFv, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFw, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFQ, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFx, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFF, R.color.CAM_X0108);
                nVar.lFA.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lGk, R.color.CAM_X0109, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lGl, R.color.CAM_X0107, 1);
                com.baidu.tbadk.core.util.ap.d(nVar.lFD, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                int color = com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0107);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFE, R.color.CAM_X0107);
                if (com.baidu.tbadk.a.d.bkG()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFE, R.color.CAM_X0304);
                    color = com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0304);
                }
                nVar.lFE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.a(R.drawable.icon_pure_arrow12_right, color, (WebPManager.ResourceStateType) null), (Drawable) null);
                WebPManager.a(nVar.lFG, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(nVar.jYm, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                nVar.lFD.onChangeSkinType();
                nVar.lFB.onChangeSkinType();
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lGa, R.color.CAM_X0304, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lFY, R.color.CAM_X0106, 1);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lFX, R.color.CAM_X0205);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lFZ, R.color.CAM_X0109);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.lGb, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lGe, R.color.CAM_X0107);
                if (nVar.lGc.getVisibility() == 8) {
                    nVar.lGe.setText(R.string.close_content);
                } else if (this.lEt != null && StringUtils.isNull(this.lEt.dne())) {
                    nVar.lGe.setText(this.lEt.dne());
                } else {
                    nVar.lGe.setText(R.string.expand_content);
                }
                nVar.lFy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                nVar.Fc(skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mBottomLine, R.color.CAM_X0203);
                WebPManager.a(nVar.lGi, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.a(nVar.lGm, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            nVar.mSkinType = skinType;
        }
    }

    private void b(final n nVar) {
        nVar.lFs.setOnTouchListener(this.lFm);
        nVar.lFs.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lGo.dpQ() != null && this.lGo.dpQ().getPageContext() != null && this.lGo.dpQ().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.lGo.dpQ().lDS;
            nVar.hPL.setOnClickListener(aVar.iCq);
            nVar.lFz.setOnClickListener(aVar.iCq);
            nVar.lFS.setOnClickListener(aVar.iCq);
            nVar.lFS.getHeadView().setOnClickListener(aVar.iCq);
            nVar.lFA.setOnLongClickListener(this.mOnLongClickListener);
            nVar.lFA.setOnTouchListener(this.lFm);
            nVar.lFA.setCommonTextViewOnClickListener(this.bbH);
            nVar.lFA.setOnImageClickListener(this.fNk);
            nVar.lFA.setOnImageTouchListener(this.lFm);
            nVar.lFA.setOnEmotionClickListener(aVar.lUm);
            nVar.lFA.setOnVoiceAfterClickListener(this.bbH);
            nVar.lFW.setOnClickListener(this.bbH);
            nVar.lFX.setOnClickListener(this.bbH);
            nVar.lFE.setOnClickListener(this.bbH);
            nVar.lFF.setOnClickListener(this.bbH);
            nVar.lGi.setOnClickListener(this.bbH);
            nVar.lGm.setOnClickListener(this.bbH);
            nVar.lGj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    nVar.lFG.performClick();
                }
            });
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.lGo.dpQ().lDT;
            nVar.lFG.setOnClickListener(this.bbH);
            nVar.jYm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lFs != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.lUB.a(m.this.lEt, null, postData, nVar.lFA.getLayoutStrategy());
                                }
                            }, 100L);
                            String threadId = m.this.lEt.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.lEt.getThreadId())) && m.this.lEt.dmT() != null) {
                                threadId = m.this.lEt.dmT().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dY("tid", threadId).dY("fid", m.this.lEt.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", postData.getId()).dY("obj_source", m.this.dt(view)).al("obj_type", 4));
                        }
                    }
                }
            });
            nVar.lFy.eXr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && m.this.lEt != null && nVar != null && nVar.lFy != null && nVar.lFy.getData() != null) {
                        int i = view == nVar.lFy.getImgAgree() ? 1 : 2;
                        String threadId = m.this.lEt.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(m.this.lEt.getThreadId())) && m.this.lEt.dmT() != null) {
                            threadId = m.this.lEt.dmT().getNid();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dY("tid", threadId).dY("fid", m.this.lEt.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", nVar.lFy.getData().postId).dY("obj_source", m.this.dt(nVar.lFy)).al("obj_type", i));
                    }
                }
            };
            nVar.lGh.eXr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && m.this.lEt != null && nVar != null && nVar.lGh != null && nVar.lGh.getData() != null) {
                        int i = view == nVar.lGh.getImgAgree() ? 1 : 2;
                        String threadId = m.this.lEt.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(m.this.lEt.getThreadId())) && m.this.lEt.dmT() != null) {
                            threadId = m.this.lEt.dmT().getNid();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dY("tid", threadId).dY("fid", m.this.lEt.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", nVar.lGh.getData().postId).dY("obj_source", m.this.dt(nVar.lGh)).al("obj_type", i));
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
        this.lFj = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lEt = fVar;
    }

    public void hY(String str) {
        this.bkt = str;
    }

    public void uy(boolean z) {
        this.lEu = z;
    }

    private SpannableStringBuilder ea(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.lGo.dpQ(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(n nVar) {
        nVar.lFA.setTextViewOnTouchListener(this.fos);
        nVar.lFA.setTextViewCheckSelection(false);
    }

    public void S(View.OnClickListener onClickListener) {
        this.lED = onClickListener;
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
