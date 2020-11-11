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
import com.baidu.tbadk.core.data.bw;
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
import com.baidu.tieba.card.n;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class m extends o<PostData, n> implements View.OnClickListener {
    private int aKu;
    private View.OnClickListener aZX;
    private LayerDrawable ajE;
    private LayerDrawable ajF;
    private String bhP;
    private int bhw;
    private TbRichTextView.i fFW;
    private boolean fJg;
    private com.baidu.tieba.pb.a.c fhK;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iNL;
    private com.baidu.adp.lib.d.b<TbImageView> iNM;
    private int joZ;
    private int joz;
    private int loY;
    private LayerDrawable loZ;
    private View.OnClickListener lqF;
    protected com.baidu.tieba.pb.data.f lqv;
    private boolean lqw;
    private TbRichTextView.c lrl;
    private com.baidu.tieba.pb.pb.sub.b lrm;
    private boolean lrn;
    private boolean lro;
    private boolean lrp;
    private com.baidu.tieba.pb.a.c lrq;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(View view) {
        if (view != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (this.lrn && nVar.lrU != null && nVar.lrU.getData() != null) {
                nVar.lrU.bse();
            }
            if (nVar.lrD != null && nVar.lrD.getData() != null) {
                nVar.lrD.bse();
            }
        }
    }

    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.bhw = 0;
        this.joz = 0;
        this.loY = 0;
        this.joZ = 0;
        this.lrl = null;
        this.lqw = true;
        this.bhP = null;
        this.lqv = null;
        this.lqF = null;
        this.aZX = null;
        this.fFW = null;
        this.fhK = null;
        this.mOnLongClickListener = null;
        this.lrm = null;
        this.fJg = true;
        this.lrn = com.baidu.tbadk.a.d.bhV();
        this.lro = com.baidu.tbadk.a.d.bhW();
        this.lrp = com.baidu.tbadk.a.d.bhR();
        this.iNL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cAV */
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
        this.iNM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bsZ */
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
        this.lrq = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.m.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (m.this.lpI == null || m.this.lpI.dkp() == null || m.this.lpI.dkp().dnn())) {
                    if (view instanceof RelativeLayout) {
                        m.this.dh(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                m.this.dh((RelativeLayout) parent);
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
                if (m.this.fhK != null) {
                    if (!(view instanceof TbListTextView) || m.this.aZX == null) {
                        m.this.fhK.ad(view);
                        m.this.fhK.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    m.this.aZX.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.djz() != null) {
            this.aKu = bVar.djz().dmh();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ci */
    public n c(ViewGroup viewGroup) {
        n nVar = new n(this.lsm.dle().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aKu, this.lrn, this.lro);
        nVar.lrG.setConstrainLayoutPool(this.iNL);
        nVar.lrG.setImageViewPool(this.iNM);
        if (nVar.lrI != null) {
            nVar.lrI.setShowChildComment(this.lro);
        }
        a(nVar);
        this.bhw = getDimensionPixelSize(R.dimen.tbds10);
        this.joz = getDimensionPixelSize(R.dimen.tbds14);
        this.loY = getDimensionPixelSize(R.dimen.tbds36);
        this.joZ = getDimensionPixelSize(R.dimen.tbds6);
        if (nVar.lrF != null) {
            nVar.lrF.setDuiEnabled(this.fJg);
        }
        uo();
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
            postData2.bnM();
            i(postData2);
            a(nVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.fJg = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.mXL) {
                i = 2;
            }
            com.baidu.tbadk.core.util.aq b = com.baidu.tieba.pb.c.a.b(this.lqv, postData, postData.locate, i, 6);
            postData.mXM = b;
            if (!com.baidu.tbadk.core.util.y.isEmpty(postData.dJW())) {
                Iterator<PostData> it = postData.dJW().iterator();
                while (it.hasNext()) {
                    it.next().mXM = b;
                }
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            if (this.lrn && this.lro) {
                nVar.lrH.setVisibility(8);
                nVar.lrM.setVisibility(0);
            } else if (this.lrn) {
                nVar.lrM.setVisibility(0);
                nVar.lrH.setVisibility(0);
                nVar.lrL.setVisibility(8);
                nVar.jJY.setVisibility(8);
                nVar.lrD.setVisibility(8);
            } else {
                nVar.lrM.setVisibility(8);
                nVar.lrH.setVisibility(0);
                nVar.lrL.setVisibility(0);
                nVar.jJY.setVisibility(0);
                nVar.lrD.setVisibility(0);
            }
            b(nVar, postData, view, i);
            f(nVar, postData);
            b(nVar, postData, this.lrn);
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
        if (nVar != null && nVar.lrx != null) {
            if (this.lsm != null && this.lsm.djz() != null && this.lsm.djz().dmp() && com.baidu.tbadk.core.util.at.equals(this.lsm.djz().dlw(), postData.getId())) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.lrx, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.lrx, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, boolean z, String str) {
        if (z) {
            nVar.lsh.setVisibility(8);
            if (StringUtils.isNull(str)) {
                nVar.lsj.setText(R.string.expand_content);
                return;
            } else {
                nVar.lsj.setText(str);
                return;
            }
        }
        nVar.lsh.setVisibility(0);
        nVar.lsj.setText(R.string.close_content);
    }

    private void c(final n nVar, final PostData postData) {
        if (postData.dKl() == 2 || postData.dKl() == 4) {
            nVar.lsi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = nVar.lsh.getVisibility() == 8;
                    m.this.a(nVar, !z, postData.div());
                    postData.xr(z ? false : true);
                    m.this.d(nVar, postData);
                    if (m.this.lpI != null && m.this.lpI.dkp() != null && m.this.lpI.dkp().doq() != null && m.this.lpI.dkp().getListView() != null && !z && nVar.getView().getTop() < m.this.lpI.dkp().doq().getMeasuredHeight()) {
                        m.this.lpI.dkp().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.y.getPosition(m.this.lpI.dkp().getListView().getData(), postData) + m.this.lpI.dkp().getListView().getHeaderViewsCount(), m.this.lpI.dkp().doq().getMeasuredHeight());
                    }
                }
            });
            nVar.lsi.setVisibility(0);
            a(nVar, postData.dJU(), postData.div());
            a(true, nVar, postData);
        } else {
            nVar.lsi.setVisibility(8);
            nVar.lsh.setVisibility(0);
            a(false, nVar, postData);
        }
        d(nVar, postData);
    }

    private void a(boolean z, n nVar, PostData postData) {
        if (nVar != null && nVar.mBottomLine != null && nVar.lsi != null && (nVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (nVar.lsi.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.y.isEmpty(postData.dJW());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) nVar.lsi.getLayoutParams();
            if (z) {
                nVar.lrF.getLayoutStrategy().sv(0);
                if (z2) {
                    nVar.lrF.getLayoutStrategy().su(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    nVar.lrF.getLayoutStrategy().su(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                nVar.lsi.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    nVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            nVar.lrF.getLayoutStrategy().su(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            nVar.lrF.getLayoutStrategy().sv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                if (this.lrn) {
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
        TbRichText dKb = postData.dKb();
        dKb.isChanged = true;
        nVar.lrF.setText(dKb, true, this.lrl);
    }

    private void j(PostData postData) {
        if (postData.eFh == 0 && postData.iQk) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12203");
            aqVar.dR("post_id", postData.getId());
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dR("cuid", TbadkCoreApplication.getInst().getCuid());
            aqVar.dR("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            aqVar.dR("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            aqVar.dR("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            aqVar.w(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.lsm != null) {
                int dmh = this.lsm.djz().dmh();
                if (1 == dmh || 2 == dmh) {
                    aqVar.dR("obj_source", "1");
                } else if (3 == dmh) {
                    aqVar.dR("obj_source", "2");
                } else {
                    aqVar.dR("obj_source", "0");
                }
            }
            TiebaStatic.log(aqVar);
            if (postData.bmA() != null && postData.bmA().getAlaInfo() != null && postData.bmA().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.bmA().getUserId();
        String forumId = this.lqv != null ? this.lqv.getForumId() : "";
        String forumName = this.lqv != null ? this.lqv.getForumName() : "";
        int dJZ = postData.dJZ();
        String id = postData.getId();
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13714");
        aqVar.dR("fid", forumId);
        aqVar.dR("fname", forumName);
        aqVar.dR("obj_param1", userId);
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dR("tid", id);
        aqVar.al(TiebaInitialize.Params.OBJ_PARAM2, dJZ);
        TiebaStatic.log(aqVar);
    }

    private void l(PostData postData) {
        if (this.lqv != null) {
            if (this.lqv.diK()) {
                if (this.lsn != null) {
                    com.baidu.tieba.pb.c.a.a(this.lsn.getUniqueId(), this.lqv, postData, postData.locate, postData.mXL ? 2 : 8);
                }
            } else if (this.lpI != null) {
                com.baidu.tieba.pb.c.a.a(this.lpI.getUniqueId(), this.lqv, postData, postData.locate, postData.mXL ? 2 : 8);
            }
        }
    }

    private void a(n nVar, PostData postData) {
        if (postData == null || postData.dqh() == null) {
            nVar.lsb.setVisibility(8);
            return;
        }
        TbRichText dKb = postData.dKb();
        com.baidu.tieba.pb.view.b.a(postData.dqh(), nVar.lsb, false, false, dKb != null && StringUtils.isNull(dKb.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(n nVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.lqw) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lrF.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.lrF.setLayoutParams(layoutParams);
            nVar.lrF.setPadding(0, 0, 0, 0);
            nVar.lrF.EK(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.lrF.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.lrF.setLayoutParams(layoutParams2);
            nVar.lrF.EK(postData.getBimg_url());
        }
        nVar.lrF.setTextViewOnTouchListener(this.lrq);
        nVar.lrF.setTextViewCheckSelection(false);
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
            if (postData.bmA() == null || postData.bmA().isBaijiahaoUser()) {
            }
            if (postData.mXC) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            nVar.lrE.setTag(null);
            nVar.lrE.setUserId(null);
            nVar.hGx.setText((CharSequence) null);
            nVar.lrX.getHeadView().setUserId(null);
            nVar.lrF.setIsHost(false);
            if (postData.bmA() != null) {
                if (this.bhP != null && !this.bhP.equals("0") && this.bhP.equals(postData.bmA().getUserId())) {
                    nVar.lrF.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.bmA().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.bmA().getTShowInfoNew();
                if (nVar.lrZ != null) {
                    nVar.lrZ.setTag(R.id.tag_user_id, postData.bmA().getUserId());
                    if (this.lsm != null && this.lsm.dle() != null) {
                        nVar.lrZ.setOnClickListener(this.lsm.dle().lpU.lGa);
                    }
                    nVar.lrZ.a(iconInfo, 2, this.loY, this.loY, this.bhw);
                }
                if (nVar.lrY != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.lrY.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.lsm != null && this.lsm.dle() != null) {
                        nVar.lrY.setOnClickListener(this.lsm.dle().lpU.lGb);
                    }
                    nVar.lrY.a(tShowInfoNew, 3, this.loY, this.loY, this.bhw, true);
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(tShowInfoNew) || postData.bmA().isBigV()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hGx, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hGx, R.color.cp_cont_j, 1);
                }
                String avater = postData.bmA().getAvater();
                int i2 = 8;
                if (postData.mXL) {
                    i2 = 2;
                }
                nVar.hGx.setTag(R.id.tag_user_id, postData.bmA().getUserId());
                nVar.hGx.setTag(R.id.tag_user_name, postData.bmA().getUserName());
                nVar.hGx.setTag(R.id.tag_virtual_user_url, postData.bmA().getVirtualUserUrl());
                nVar.hGx.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lqv, postData, postData.locate, i2, 2));
                String name_show = postData.bmA().getName_show();
                String userName = postData.bmA().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.hGx.setText(com.baidu.tieba.pb.c.aU(this.mContext, nVar.hGx.getText().toString()));
                    nVar.hGx.setGravity(16);
                    nVar.hGx.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dhU());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hGx, R.color.cp_other_f, 1);
                }
                if (postData.bmA().getPendantData() != null && !StringUtils.isNull(postData.bmA().getPendantData().bkw())) {
                    nVar.lrX.setBigVDimenSize(R.dimen.tbds32);
                    nVar.lrX.a(postData.bmA(), 4);
                    nVar.lrE.setVisibility(8);
                    nVar.lrX.setVisibility(0);
                    nVar.lrX.getHeadView().startLoad(avater, 28, false);
                    nVar.lrX.getHeadView().setUserId(postData.bmA().getUserId());
                    nVar.lrX.getHeadView().setUserName(postData.bmA().getUserName());
                    nVar.lrX.getHeadView().setFid(this.lqv != null ? this.lqv.getForumId() : "");
                    nVar.lrX.getHeadView().setFName(this.lqv != null ? this.lqv.getForumName() : "");
                    nVar.lrX.getHeadView().setFloor(postData.dJZ());
                    nVar.lrX.getHeadView().setTid(postData.getId());
                    nVar.lrX.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lqv, postData, postData.locate, i2, 2));
                    nVar.lrX.Cp(postData.bmA().getPendantData().bkw());
                } else {
                    nVar.lrE.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.lrE, postData.bmA(), 4);
                    nVar.lrE.setUserId(postData.bmA().getUserId());
                    nVar.lrE.setFid(this.lqv != null ? this.lqv.getForumId() : "");
                    nVar.lrE.setFName(this.lqv != null ? this.lqv.getForumName() : "");
                    nVar.lrE.setFloor(postData.dJZ());
                    nVar.lrE.setTid(postData.getId());
                    nVar.lrE.setUserName(postData.bmA().getUserName(), postData.dKj());
                    nVar.lrE.setTag(R.id.tag_virtual_user_url, postData.bmA().getVirtualUserUrl());
                    nVar.lrE.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.lqv, postData, postData.locate, i2, 2));
                    nVar.lrE.setImageDrawable(null);
                    nVar.lrE.startLoad(avater, 28, false);
                    nVar.lrE.setVisibility(0);
                    nVar.lrX.setVisibility(8);
                }
                if (postData.bmA() != null && postData.bmA().getAlaInfo() != null && postData.bmA().getAlaUserData() != null && postData.bmA().getAlaUserData().live_status == 1) {
                    nVar.sK(true);
                    nVar.lrE.setLiveStatus(1);
                    nVar.lrE.setAlaInfo(postData.bmA().getAlaInfo());
                    nVar.lrX.getHeadView().setLiveStatus(1);
                    nVar.lrX.getHeadView().setAlaInfo(postData.bmA().getAlaInfo());
                } else {
                    nVar.sK(false);
                    nVar.lrE.setLiveStatus(0);
                    nVar.lrE.setAlaInfo(null);
                    nVar.lrX.getHeadView().setLiveStatus(0);
                    nVar.lrX.getHeadView().setAlaInfo(null);
                }
                if (this.lqv != null && this.lqv.diN()) {
                    nVar.lry.setVisibility(8);
                    nVar.lry.setTag(null);
                } else if (postData.bmA() != null) {
                    MetaData bmA = postData.bmA();
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lry, R.color.cp_cont_a);
                    if (this.bhP != null && !this.bhP.equals("0") && this.bhP.equals(bmA.getUserId())) {
                        nVar.lry.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (this.loZ.getDrawable(1) != null) {
                                this.loZ.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.loZ.getDrawable(1) != null) {
                            this.loZ.getDrawable(1).setAlpha(0);
                        }
                        nVar.lry.setBackgroundDrawable(this.loZ);
                        nVar.lry.setVisibility(0);
                        nVar.lry.setText(R.string.host_name);
                    } else if (bmA.getIs_bawu() == 1 && postData.dJR()) {
                        int i3 = R.drawable.brand_official_btn;
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lry, i3);
                        nVar.lry.setTag(Integer.valueOf(i3));
                        nVar.lry.setVisibility(0);
                        nVar.lry.setText(R.string.brand_Official);
                    } else if (bmA.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bmA.getBawu_type())) {
                        nVar.lry.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.ajE.getDrawable(1) != null) {
                                this.ajE.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajE.getDrawable(1) != null) {
                            this.ajE.getDrawable(1).setAlpha(0);
                        }
                        nVar.lry.setBackgroundDrawable(this.ajE);
                        nVar.lry.setVisibility(0);
                        nVar.lry.setText(R.string.bawu_member_bazhu_tip);
                    } else if (bmA.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bmA.getBawu_type())) {
                        nVar.lry.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.ajF.getDrawable(1) != null) {
                                this.ajF.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.ajF.getDrawable(1) != null) {
                            this.ajF.getDrawable(1).setAlpha(0);
                        }
                        nVar.lry.setBackgroundDrawable(this.ajF);
                        nVar.lry.setVisibility(0);
                        nVar.lry.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (bmA.getIs_bawu() == 1 && "pri_content_assist".equals(bmA.getBawu_type())) {
                        int oW = com.baidu.tbadk.core.util.ap.oW(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lry, oW);
                        nVar.lry.setTag(Integer.valueOf(oW));
                        nVar.lry.setVisibility(0);
                        nVar.lry.setText(R.string.bawu_content_assist_tip);
                    } else if (bmA.getIs_bawu() == 1 && "pri_manage_assist".equals(bmA.getBawu_type())) {
                        int oW2 = com.baidu.tbadk.core.util.ap.oW(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lry, oW2);
                        nVar.lry.setTag(Integer.valueOf(oW2));
                        nVar.lry.setVisibility(0);
                        nVar.lry.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.lry.setVisibility(8);
                        nVar.lry.setTag(null);
                    }
                } else {
                    nVar.lry.setVisibility(8);
                    nVar.lry.setTag(null);
                }
            }
            int i4 = 0;
            if (this.lsm != null && this.lsm.dle() != null && this.lsm.dle().djq() && postData.bmA() != null) {
                i4 = postData.bmA().getLevel_id();
            }
            if (this.lqv != null && this.lqv.diN()) {
                i4 = 0;
            }
            if (i4 > 0) {
                nVar.lrW.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.lrW, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                nVar.lrW.setVisibility(8);
            }
            int i5 = 15;
            if (nVar.lrZ.getChildCount() == 1) {
                i5 = 13;
            } else if (nVar.lrZ.getChildCount() > 1) {
                i5 = 11;
            }
            if (nVar.lry.getVisibility() == 0) {
                i5 -= 2;
            }
            if (nVar.lrY.getChildCount() > 0) {
                i5 -= 2;
            }
            if (postData.bnZ() > 1000) {
                i5 -= 2;
            }
            if (postData.bnZ() > 10) {
                i5 -= 2;
            }
            if (i5 < 10) {
                nVar.lrZ.setVisibility(8);
                if (nVar.lrZ.getChildCount() == 1) {
                    i5 += 2;
                } else if (nVar.lrZ.getChildCount() > 1) {
                    i5 += 4;
                }
                if (i5 < 10 && nVar.lry.getVisibility() == 0) {
                    i5 += 2;
                    nVar.lry.setVisibility(8);
                }
                if (i5 < 10 && nVar.lrW.getVisibility() == 0) {
                    i5 += 2;
                    nVar.lrW.setVisibility(8);
                }
            }
            String name_show2 = postData.bmA() != null ? postData.bmA().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.af.getTextLengthWithEmoji(name_show2);
            if (postData.bmA() != null && !StringUtils.isNull(postData.bmA().getSealPrefix())) {
                if (textLengthWithEmoji > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.af.subStringWithEmoji(name_show2, i5 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i5) {
                name_show2 = com.baidu.tbadk.util.af.subStringWithEmoji(name_show2, i5) + StringHelper.STRING_MORE;
            }
            if (postData.bmA() != null && !StringUtils.isNull(postData.bmA().getSealPrefix())) {
                nVar.hGx.setText(dT(postData.bmA().getSealPrefix(), name_show2));
            } else {
                nVar.hGx.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dJZ()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.bmA() != null && !StringUtils.isNull(postData.bmA().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.lqv != null && this.lqv.diz() != 0) {
                if (this.lqv.diz() != 1002 && this.lqv.diz() != 3) {
                    z10 = true;
                }
                if (this.lqv.diz() != 3 && !this.lqv.diN()) {
                    z11 = true;
                }
                if (postData != null && postData.bmA() != null) {
                    String userId2 = postData.bmA().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.lqv != null && this.lqv.dik() != null && this.lqv.dik().bmA() != null && postData.bmA() != null) {
                            userId = this.lqv.dik().bmA().getUserId();
                            String userId3 = postData.bmA().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.bmA() != null && UtilHelper.isCurrentAccount(postData.bmA().getUserId())) {
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
                                if (postData.dJZ() == 1) {
                                    i6 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lqv.diz()));
                                    if (postData.bmA() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.bmA().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.bmA().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.bmA().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.bmA() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bmA().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bmA().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bmA().getName_show());
                                    }
                                    if (this.lqv.dik() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.lqv.dik().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lqv.diz()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.lrF.setTag(sparseArray);
                                if (this.lrn) {
                                    nVar.lsa.setTag(sparseArray);
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
                        if (postData.dJZ() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        nVar.lrF.setTag(sparseArray);
                        if (this.lrn) {
                        }
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.lqv != null) {
                userId = this.lqv.dik().bmA().getUserId();
                String userId32 = postData.bmA().getUserId();
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
            if (postData.dJZ() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            nVar.lrF.setTag(sparseArray);
            if (this.lrn) {
            }
        }
    }

    private void f(n nVar, PostData postData) {
        if (nVar != null && postData != null && nVar.lsa != null && this.lqv != null) {
            if (this.lrn && !this.lqv.diN()) {
                nVar.lsa.setVisibility(0);
                nVar.lsa.setOnClickListener(this.aZX);
                return;
            }
            nVar.lsa.setVisibility(8);
        }
    }

    private void b(n nVar, PostData postData, boolean z) {
        if (nVar != null && postData != null && postData.bor() != null) {
            postData.bor().threadId = this.lsm.djz().dlx();
            postData.bor().objType = 1;
            postData.bor().isInPost = true;
            bw bwVar = null;
            if (this.lqv != null && this.lqv.dik() != null) {
                bwVar = this.lqv.dik();
            }
            if (z) {
                nVar.lrU.setAgreeAlone(true);
                nVar.lrU.setThreadData(bwVar);
                nVar.lrU.setData(postData.bor());
            }
            if (bwVar != null && bwVar.blk()) {
                nVar.lrD.setAgreeAlone(true);
            }
            nVar.lrD.setThreadData(bwVar);
            nVar.lrD.setData(postData.bor());
        }
    }

    private void g(n nVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dJZ() > 0 && this.lqv != null && !this.lqv.diN()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dJZ()));
                nVar.lrV.setVisibility(0);
                nVar.lrV.setText(format);
                z = true;
            } else {
                nVar.lrV.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dKc = postData.dKc();
            boolean z2 = (dKc == null || StringUtils.isNull(dKc.getName()) || this.lqv == null || this.lqv.diN()) ? false : true;
            if (z) {
                nVar.lrA.setVisibility(0);
                i = this.joz;
            } else {
                nVar.lrA.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.lrB.setVisibility(0);
                i2 = this.joz;
            } else {
                nVar.lrB.setVisibility(8);
                i2 = 0;
            }
            nVar.lrz.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.lrz.setText(com.baidu.tbadk.core.util.at.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.lrz.setText(com.baidu.tbadk.core.util.at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.lrC.setVisibility(0);
                nVar.lrC.setPadding(this.joz, 0, 0, 0);
                if (postData.mXK) {
                    nVar.lrC.setText(com.baidu.tbadk.core.util.at.cutStringWithSuffix(dKc.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    nVar.lrC.setText(dKc.getName());
                    return;
                }
            }
            nVar.lrC.setVisibility(8);
        }
    }

    private void a(n nVar, PostData postData, View view) {
        if (nVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lrF.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            nVar.lrF.setPadding(0, 0, 0, 0);
            if (!this.lqw) {
                nVar.lrF.getLayoutStrategy().sp(R.drawable.icon_click);
            } else {
                nVar.lrF.EK(null);
                nVar.lrF.setBackgroundDrawable(null);
                nVar.lrF.getLayoutStrategy().sp(R.drawable.transparent_bg);
            }
            nVar.lrF.getLayoutStrategy().sm(R.drawable.pic_video);
            a(nVar.lrF, view, !StringUtils.isNull(postData.getBimg_url()));
            nVar.lrF.setLayoutParams(layoutParams);
            nVar.lrF.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_c));
            nVar.lrF.setIsFromCDN(this.mIsFromCDN);
            nVar.lrF.setText(postData.dKb(), true, this.lrl);
            SparseArray sparseArray = (SparseArray) nVar.lrF.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            nVar.lrF.setTag(sparseArray);
            nVar.lrx.setTag(R.id.tag_from, sparseArray);
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
            if (this.lrp) {
                tbRichTextView.getLayoutStrategy().sn(((equipmentWidth - dimensionPixelSize) * 2) / 3);
            } else {
                tbRichTextView.getLayoutStrategy().sn(equipmentWidth - dimensionPixelSize);
            }
            tbRichTextView.getLayoutStrategy().fHZ = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            if (this.lrp) {
                tbRichTextView.getLayoutStrategy().so((int) (((equipmentWidth * 1.618f) * 2.0f) / 3.0f));
            } else {
                tbRichTextView.getLayoutStrategy().so((int) (equipmentWidth * 1.618f));
            }
        }
    }

    private void c(n nVar, PostData postData, View view, int i) {
        String string;
        if (nVar != null && postData != null) {
            if (postData.dKd() > 0) {
                nVar.lrK.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) nVar.lrK.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.lrK.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dKl() == 2) {
                    nVar.lrK.setVisibility(8);
                } else if (this.lrn) {
                    nVar.lrH.setVisibility(8);
                } else {
                    nVar.lrK.setVisibility(0);
                }
                nVar.lrJ.setVisibility(8);
            }
            if (this.lrn) {
                if (com.baidu.tbadk.a.d.bhM()) {
                    string = postData.dKd() > 0 ? String.valueOf(postData.dKd()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.reply);
                }
                nVar.lrT.setText(string);
                if (nVar.lrO != null) {
                    SparseArray sparseArray2 = (SparseArray) nVar.lrO.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        nVar.lrO.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.lrN != null) {
                    SparseArray sparseArray3 = (SparseArray) nVar.lrN.getTag();
                    if (sparseArray3 == null) {
                        sparseArray3 = new SparseArray();
                        nVar.lrN.setTag(sparseArray3);
                    }
                    sparseArray3.put(R.id.tag_load_sub_data, postData);
                }
            } else {
                if (nVar.lrL != null) {
                    SparseArray sparseArray4 = (SparseArray) nVar.lrL.getTag();
                    if (sparseArray4 == null) {
                        sparseArray4 = new SparseArray();
                        nVar.lrL.setTag(sparseArray4);
                    }
                    sparseArray4.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.jJY != null) {
                    SparseArray sparseArray5 = (SparseArray) nVar.jJY.getTag();
                    if (sparseArray5 == null) {
                        sparseArray5 = new SparseArray();
                        nVar.jJY.setTag(sparseArray5);
                    }
                    sparseArray5.put(R.id.tag_load_sub_data, postData);
                }
            }
            if (postData.dKd() > 0 && !this.lro) {
                nVar.lrJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dKd())));
                SparseArray sparseArray6 = (SparseArray) nVar.lrJ.getTag();
                if (sparseArray6 == null) {
                    sparseArray6 = new SparseArray();
                    nVar.lrJ.setTag(sparseArray6);
                }
                sparseArray6.put(R.id.tag_load_sub_data, postData);
                nVar.lrJ.setVisibility(0);
                nVar.lrK.setVisibility(8);
                nVar.lrI.setVisibility(8);
            } else {
                nVar.lrJ.setVisibility(8);
                if (this.lro) {
                    nVar.lrK.setVisibility(8);
                }
                if (postData.dKd() > 0 && postData.dJW() != null && postData.dJW().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.lrI.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    nVar.lrI.setLayoutParams(layoutParams);
                    if (this.lrm == null) {
                        this.lrm = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.lrm.setIsFromCDN(this.mIsFromCDN);
                        this.lrm.setOnLongClickListener(this.mOnLongClickListener);
                        this.lrm.X(this.lqF);
                        this.lrm.B(this.aZX);
                        String str = null;
                        if (this.lqv != null && this.lqv.dik() != null && this.lqv.dik().bmA() != null) {
                            str = this.lqv.dik().bmA().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.lqv != null) {
                            this.lrm.af(this.lqv.diz(), z);
                            this.lrm.setThreadData(this.lqv.dik());
                        }
                    }
                    this.lrm.Qe(postData.getId());
                    nVar.lrI.setSubPbAdapter(this.lrm);
                    nVar.lrI.setVisibility(0);
                    nVar.lrI.setData(postData, view);
                    nVar.lrI.setChildOnClickListener(this.aZX);
                    nVar.lrI.setChildOnLongClickListener(this.mOnLongClickListener);
                    nVar.lrI.setChildOnTouchListener(this.lrq);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.lrI.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    nVar.lrI.setLayoutParams(layoutParams2);
                    nVar.lrI.setVisibility(8);
                }
            }
            if (postData.mXA) {
                nVar.mBottomLine.setVisibility(0);
            } else {
                nVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(n nVar, PostData postData) {
        if (nVar != null && nVar.lsf != null && nVar.lsc != null) {
            if (postData == null || postData.mXE == null || StringUtils.isNull(postData.mXE.liveTitle)) {
                nVar.lsc.setVisibility(8);
                return;
            }
            nVar.lsf.setText(postData.mXE.liveTitle);
            nVar.lsc.setTag(postData.mXE);
            nVar.lsc.setVisibility(0);
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.lsk.setVisibility(postData.mXK ? 0 : 8);
        }
    }

    private void a(n nVar) {
        LayerDrawable layerDrawable;
        if (nVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (nVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.hGx, R.color.cp_cont_d, 1);
                if (nVar.lry.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lry, ((Integer) nVar.lry.getTag()).intValue());
                } else if (nVar.lry.getTag() instanceof String) {
                    if (nVar.lry.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.ajE;
                    } else if (nVar.lry.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.ajF;
                    } else {
                        layerDrawable = nVar.lry.getTag().equals("HOST") ? this.loZ : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.lry.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrz, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrA, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrB, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrV, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrC, R.color.cp_cont_d, 1);
                nVar.lrF.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.ap.c(nVar.lrI, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrJ, R.color.cp_cont_c);
                nVar.lrJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrK, R.color.cp_cont_c);
                if (this.lrn) {
                    SvgManager.brn().a(nVar.lsa, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.brn().a(nVar.lrS, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.brn().a(nVar.lrQ, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    nVar.lrU.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrR, R.color.cp_cont_d);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lrT, R.color.cp_cont_d);
                } else {
                    SvgManager.brn().a(nVar.lrL, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.brn().a(nVar.jJY, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                nVar.lrI.onChangeSkinType();
                nVar.lrG.onChangeSkinType();
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lsf, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lsd, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lsc, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.lse, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.lsg, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.lsj, R.color.cp_cont_c);
                if (nVar.lsh.getVisibility() == 8) {
                    nVar.lsj.setText(R.string.close_content);
                } else if (this.lqv != null && StringUtils.isNull(this.lqv.div())) {
                    nVar.lsj.setText(this.lqv.div());
                } else {
                    nVar.lsj.setText(R.string.expand_content);
                }
                nVar.lrD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                nVar.DP(skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = skinType;
        }
    }

    private void b(final n nVar) {
        nVar.lrx.setOnTouchListener(this.lrq);
        nVar.lrx.setOnLongClickListener(this.mOnLongClickListener);
        if (this.lsm.dle() != null && this.lsm.dle().getPageContext() != null && this.lsm.dle().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.lsm.dle().lpU;
            nVar.hGx.setOnClickListener(aVar.iqL);
            nVar.lrE.setOnClickListener(aVar.iqL);
            nVar.lrX.setOnClickListener(aVar.iqL);
            nVar.lrX.getHeadView().setOnClickListener(aVar.iqL);
            nVar.lrF.setOnLongClickListener(this.mOnLongClickListener);
            nVar.lrF.setOnTouchListener(this.lrq);
            nVar.lrF.setCommonTextViewOnClickListener(this.aZX);
            nVar.lrF.setOnImageClickListener(this.fFW);
            nVar.lrF.setOnImageTouchListener(this.lrq);
            nVar.lrF.setOnEmotionClickListener(aVar.lGc);
            nVar.lrF.setOnVoiceAfterClickListener(this.aZX);
            nVar.lsb.setOnClickListener(this.aZX);
            nVar.lsc.setOnClickListener(this.aZX);
            nVar.lrJ.setOnClickListener(this.aZX);
            nVar.lrK.setOnClickListener(this.aZX);
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.lsm.dle().lpV;
            if (this.lrn) {
                nVar.lrO.setOnClickListener(this.aZX);
                nVar.lrN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lrx != null && cVar != null) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.lGr.a(m.this.lqv, null, postData, nVar.lrF.getLayoutStrategy());
                                    }
                                }, 100L);
                                String threadId = m.this.lqv.getThreadId();
                                if ((StringUtils.isNull(threadId) || "0".equals(m.this.lqv.getThreadId())) && m.this.lqv.dik() != null) {
                                    threadId = m.this.lqv.dik().getNid();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dR("tid", threadId).dR("fid", m.this.lqv.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).al("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.lrU.eRb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && m.this.lqv != null && nVar != null && nVar.lrU != null && nVar.lrU.getData() != null) {
                            int i = view == nVar.lrU.getImgAgree() ? 1 : 2;
                            String threadId = m.this.lqv.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.lqv.getThreadId())) && m.this.lqv.dik() != null) {
                                threadId = m.this.lqv.dik().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dR("tid", threadId).dR("fid", m.this.lqv.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", nVar.lrU.getData().postId).al("obj_type", i));
                        }
                    }
                };
                return;
            }
            nVar.lrL.setOnClickListener(this.aZX);
            nVar.jJY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.lrx != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.lGr.a(m.this.lqv, null, postData, nVar.lrF.getLayoutStrategy());
                                }
                            }, 100L);
                            String threadId = m.this.lqv.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.lqv.getThreadId())) && m.this.lqv.dik() != null) {
                                threadId = m.this.lqv.dik().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dR("tid", threadId).dR("fid", m.this.lqv.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).al("obj_type", 4));
                        }
                    }
                }
            });
            nVar.lrD.eRb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && m.this.lqv != null && nVar != null && nVar.lrD != null && nVar.lrD.getData() != null) {
                        int i = view == nVar.lrD.getImgAgree() ? 1 : 2;
                        String threadId = m.this.lqv.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(m.this.lqv.getThreadId())) && m.this.lqv.dik() != null) {
                            threadId = m.this.lqv.dik().getNid();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dR("tid", threadId).dR("fid", m.this.lqv.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", nVar.lrD.getData().postId).al("obj_type", i));
                    }
                }
            };
        }
    }

    private void uo() {
        this.ajE = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(this.joZ).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).brR(), com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(this.joZ).Cm("#4D000000").brR()});
        this.ajF = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(this.joZ).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).brR(), com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(this.joZ).Cm("#4D000000").brR()});
        this.loZ = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(this.joZ).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).brR(), com.baidu.tbadk.core.util.e.a.b.brP().pj(0).ab(this.joZ).Cm("#4D000000").brR()});
    }

    public void a(TbRichTextView.c cVar) {
        this.lrl = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.lqv = fVar;
    }

    public void hE(String str) {
        this.bhP = str;
    }

    public void tT(boolean z) {
        this.lqw = z;
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a((Context) this.lsm.dle(), str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(n nVar) {
        nVar.lrF.setTextViewOnTouchListener(this.fhK);
        nVar.lrF.setTextViewCheckSelection(false);
    }

    public void T(View.OnClickListener onClickListener) {
        this.lqF = onClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.aZX = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFW = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fhK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
