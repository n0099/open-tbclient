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
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class m extends o<PostData, n> implements View.OnClickListener {
    private int aEB;
    private View.OnClickListener aRU;
    private int aYD;
    private String aYW;
    private LayerDrawable aiP;
    private LayerDrawable aiQ;
    private com.baidu.tieba.pb.a.c eFf;
    private TbRichTextView.i fcy;
    private boolean ffJ;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hZl;
    private com.baidu.adp.lib.d.b<TbImageView> hZm;
    private int iAn;
    private int izN;
    private TbRichTextView.c kAW;
    private com.baidu.tieba.pb.pb.sub.b kAX;
    private boolean kAY;
    private boolean kAZ;
    protected com.baidu.tieba.pb.data.f kAg;
    private boolean kAh;
    private View.OnClickListener kAq;
    private com.baidu.tieba.pb.a.c kBa;
    private int kyJ;
    private LayerDrawable kyK;
    private View.OnLongClickListener mOnLongClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(View view) {
        if (view != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (this.kAY && nVar.kBE != null && nVar.kBE.getData() != null) {
                nVar.kBE.bkg();
            }
            if (nVar.kBn != null && nVar.kBn.getData() != null) {
                nVar.kBn.bkg();
            }
        }
    }

    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        this.aYD = 0;
        this.izN = 0;
        this.kyJ = 0;
        this.iAn = 0;
        this.kAW = null;
        this.kAh = true;
        this.aYW = null;
        this.kAg = null;
        this.kAq = null;
        this.aRU = null;
        this.fcy = null;
        this.eFf = null;
        this.mOnLongClickListener = null;
        this.kAX = null;
        this.ffJ = true;
        this.kAY = com.baidu.tbadk.a.d.baf();
        this.kAZ = com.baidu.tbadk.a.d.bag();
        this.hZl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.pb.pb.main.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: coB */
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
        this.hZm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.pb.pb.main.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blb */
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
        this.kBa = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.m.3
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (view != null && (m.this.kzt == null || m.this.kzt.cXt() == null || m.this.kzt.cXt().dar())) {
                    if (view instanceof RelativeLayout) {
                        m.this.cL(view);
                    } else {
                        ViewParent parent = view.getParent();
                        int i = 0;
                        while (true) {
                            if (parent == null || i >= 10) {
                                break;
                            } else if (parent instanceof RelativeLayout) {
                                m.this.cL((RelativeLayout) parent);
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
                if (m.this.eFf != null) {
                    if (!(view instanceof TbListTextView) || m.this.aRU == null) {
                        m.this.eFf.X(view);
                        m.this.eFf.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    m.this.aRU.onClick(view);
                    return true;
                }
                return true;
            }
        });
        if (bVar != null && bVar.cWD() != null) {
            this.aEB = bVar.cWD().cZl();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cc */
    public n b(ViewGroup viewGroup) {
        n nVar = new n(this.kBW.cYi().getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false), this.aEB, this.kAY, this.kAZ);
        nVar.kBq.setConstrainLayoutPool(this.hZl);
        nVar.kBq.setImageViewPool(this.hZm);
        if (nVar.kBs != null) {
            nVar.kBs.setShowChildComment(this.kAZ);
        }
        a(nVar);
        this.aYD = getDimensionPixelSize(R.dimen.tbds10);
        this.izN = getDimensionPixelSize(R.dimen.tbds14);
        this.kyJ = getDimensionPixelSize(R.dimen.tbds36);
        this.iAn = getDimensionPixelSize(R.dimen.tbds6);
        if (nVar.kBp != null) {
            nVar.kBp.setDuiEnabled(this.ffJ);
        }
        ui();
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
            postData2.bfQ();
            i(postData2);
            a(nVar, postData2, view, i);
        }
        return view;
    }

    public void setDuiEnabled(boolean z) {
        this.ffJ = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void i(PostData postData) {
        if (postData != null) {
            int i = 8;
            if (postData.mfH) {
                i = 2;
            }
            com.baidu.tbadk.core.util.aq b = com.baidu.tieba.pb.c.a.b(this.kAg, postData, postData.locate, i, 6);
            postData.mfI = b;
            if (!com.baidu.tbadk.core.util.y.isEmpty(postData.dwC())) {
                Iterator<PostData> it = postData.dwC().iterator();
                while (it.hasNext()) {
                    it.next().mfI = b;
                }
            }
        }
    }

    private void a(n nVar, PostData postData, View view, int i) {
        if (nVar != null && postData != null) {
            if (this.kAY && this.kAZ) {
                nVar.kBr.setVisibility(8);
                nVar.kBw.setVisibility(0);
            } else if (this.kAY) {
                nVar.kBw.setVisibility(0);
                nVar.kBr.setVisibility(0);
                nVar.kBv.setVisibility(8);
                nVar.iTP.setVisibility(8);
                nVar.kBn.setVisibility(8);
            } else {
                nVar.kBw.setVisibility(8);
                nVar.kBr.setVisibility(0);
                nVar.kBv.setVisibility(0);
                nVar.iTP.setVisibility(0);
                nVar.kBn.setVisibility(0);
            }
            b(nVar, postData, view, i);
            f(nVar, postData);
            b(nVar, postData, this.kAY);
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
        if (nVar != null && nVar.kBh != null) {
            if (this.kBW != null && this.kBW.cWD() != null && this.kBW.cWD().cZt() && com.baidu.tbadk.core.util.at.equals(this.kBW.cWD().cYA(), postData.getId())) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.kBh, R.color.cp_other_g);
            } else {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.kBh, R.color.cp_bg_line_e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, boolean z, String str) {
        if (z) {
            nVar.kBR.setVisibility(8);
            if (StringUtils.isNull(str)) {
                nVar.kBT.setText(R.string.expand_content);
                return;
            } else {
                nVar.kBT.setText(str);
                return;
            }
        }
        nVar.kBR.setVisibility(0);
        nVar.kBT.setText(R.string.close_content);
    }

    private void c(final n nVar, final PostData postData) {
        if (postData.dwR() == 2 || postData.dwR() == 4) {
            nVar.kBS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    boolean z = nVar.kBR.getVisibility() == 8;
                    m.this.a(nVar, !z, postData.cVw());
                    postData.vZ(z ? false : true);
                    m.this.d(nVar, postData);
                    if (m.this.kzt != null && m.this.kzt.cXt() != null && m.this.kzt.cXt().dbt() != null && m.this.kzt.cXt().getListView() != null && !z && nVar.getView().getTop() < m.this.kzt.cXt().dbt().getMeasuredHeight()) {
                        m.this.kzt.cXt().getListView().setSelectionFromTop(com.baidu.tbadk.core.util.y.getPosition(m.this.kzt.cXt().getListView().getData(), postData) + m.this.kzt.cXt().getListView().getHeaderViewsCount(), m.this.kzt.cXt().dbt().getMeasuredHeight());
                    }
                }
            });
            nVar.kBS.setVisibility(0);
            a(nVar, postData.dwA(), postData.cVw());
            a(true, nVar, postData);
        } else {
            nVar.kBS.setVisibility(8);
            nVar.kBR.setVisibility(0);
            a(false, nVar, postData);
        }
        d(nVar, postData);
    }

    private void a(boolean z, n nVar, PostData postData) {
        if (nVar != null && nVar.mBottomLine != null && nVar.kBS != null && (nVar.mBottomLine.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (nVar.kBS.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !com.baidu.tbadk.core.util.y.isEmpty(postData.dwC());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nVar.mBottomLine.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) nVar.kBS.getLayoutParams();
            if (z) {
                nVar.kBp.getLayoutStrategy().rl(0);
                if (z2) {
                    nVar.kBp.getLayoutStrategy().rk(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    nVar.kBp.getLayoutStrategy().rk(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                nVar.kBS.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    nVar.mBottomLine.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            nVar.kBp.getLayoutStrategy().rk(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            nVar.kBp.getLayoutStrategy().rl(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                if (this.kAY) {
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
        TbRichText dwH = postData.dwH();
        dwH.isChanged = true;
        nVar.kBp.setText(dwH, true, this.kAW);
    }

    private void j(PostData postData) {
        if (postData.ecy == 0 && postData.ibK) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12203");
            aqVar.dD("post_id", postData.getId());
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dD("cuid", TbadkCoreApplication.getInst().getCuid());
            aqVar.dD("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            aqVar.dD("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            aqVar.dD("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
            aqVar.u(TiebaInitialize.Params.EXPOSURE_TIME, System.currentTimeMillis());
            if (this.kBW != null) {
                int cZl = this.kBW.cWD().cZl();
                if (1 == cZl || 2 == cZl) {
                    aqVar.dD("obj_source", "1");
                } else if (3 == cZl) {
                    aqVar.dD("obj_source", "2");
                } else {
                    aqVar.dD("obj_source", "0");
                }
            }
            TiebaStatic.log(aqVar);
            if (postData.beE() != null && postData.beE().getAlaInfo() != null && postData.beE().getAlaInfo().live_status == 1) {
                k(postData);
            }
        }
    }

    private void k(PostData postData) {
        String userId = postData.beE().getUserId();
        String forumId = this.kAg != null ? this.kAg.getForumId() : "";
        String forumName = this.kAg != null ? this.kAg.getForumName() : "";
        int dwF = postData.dwF();
        String id = postData.getId();
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13714");
        aqVar.dD("fid", forumId);
        aqVar.dD("fname", forumName);
        aqVar.dD("obj_param1", userId);
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dD("tid", id);
        aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, dwF);
        TiebaStatic.log(aqVar);
    }

    private void l(PostData postData) {
        if (this.kAg != null) {
            if (this.kAg.cVL()) {
                if (this.kBX != null) {
                    com.baidu.tieba.pb.c.a.a(this.kBX.getUniqueId(), this.kAg, postData, postData.locate, postData.mfH ? 2 : 8);
                }
            } else if (this.kzt != null) {
                com.baidu.tieba.pb.c.a.a(this.kzt.getUniqueId(), this.kAg, postData, postData.locate, postData.mfH ? 2 : 8);
            }
        }
    }

    private void a(n nVar, PostData postData) {
        if (postData == null || postData.ddj() == null) {
            nVar.kBL.setVisibility(8);
            return;
        }
        TbRichText dwH = postData.dwH();
        com.baidu.tieba.pb.view.b.a(postData.ddj(), nVar.kBL, false, false, dwH != null && StringUtils.isNull(dwH.toString()) && StringUtils.isNull(postData.getBimg_url()));
    }

    private void e(n nVar, PostData postData) {
        if (TextUtils.isEmpty(postData.getBimg_url()) || !this.kAh) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kBp.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            nVar.kBp.setLayoutParams(layoutParams);
            nVar.kBp.setPadding(0, 0, 0, 0);
            nVar.kBp.CU(null);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.kBp.getLayoutParams();
            layoutParams2.topMargin = getDimensionPixelSize(R.dimen.ds20);
            layoutParams2.bottomMargin = getDimensionPixelSize(R.dimen.ds20);
            nVar.kBp.setLayoutParams(layoutParams2);
            nVar.kBp.CU(postData.getBimg_url());
        }
        nVar.kBp.setTextViewOnTouchListener(this.kBa);
        nVar.kBp.setTextViewCheckSelection(false);
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
            if (postData.beE() == null || postData.beE().isBaijiahaoUser()) {
            }
            if (postData.mfy) {
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mTopLine, R.color.cp_bg_line_c);
                nVar.mTopLine.setVisibility(0);
            } else {
                nVar.mTopLine.setVisibility(8);
            }
            nVar.kBo.setTag(null);
            nVar.kBo.setUserId(null);
            nVar.gVT.setText((CharSequence) null);
            nVar.kBH.getHeadView().setUserId(null);
            nVar.kBp.setIsHost(false);
            if (postData.beE() != null) {
                if (this.aYW != null && !this.aYW.equals("0") && this.aYW.equals(postData.beE().getUserId())) {
                    nVar.kBp.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.beE().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.beE().getTShowInfoNew();
                if (nVar.kBJ != null) {
                    nVar.kBJ.setTag(R.id.tag_user_id, postData.beE().getUserId());
                    if (this.kBW != null && this.kBW.cYi() != null) {
                        nVar.kBJ.setOnClickListener(this.kBW.cYi().kzF.kPE);
                    }
                    nVar.kBJ.a(iconInfo, 2, this.kyJ, this.kyJ, this.aYD);
                }
                if (nVar.kBI != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        nVar.kBI.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.kBW != null && this.kBW.cYi() != null) {
                        nVar.kBI.setOnClickListener(this.kBW.cYi().kzF.kPF);
                    }
                    nVar.kBI.a(tShowInfoNew, 3, this.kyJ, this.kyJ, this.aYD, true);
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(tShowInfoNew) || postData.beE().isBigV()) {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.gVT, R.color.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.gVT, R.color.cp_cont_j, 1);
                }
                String avater = postData.beE().getAvater();
                int i2 = 8;
                if (postData.mfH) {
                    i2 = 2;
                }
                nVar.gVT.setTag(R.id.tag_user_id, postData.beE().getUserId());
                nVar.gVT.setTag(R.id.tag_user_name, postData.beE().getUserName());
                nVar.gVT.setTag(R.id.tag_virtual_user_url, postData.beE().getVirtualUserUrl());
                nVar.gVT.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kAg, postData, postData.locate, i2, 2));
                String name_show = postData.beE().getName_show();
                String userName = postData.beE().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    nVar.gVT.setText(com.baidu.tieba.pb.c.aN(this.mContext, nVar.gVT.getText().toString()));
                    nVar.gVT.setGravity(16);
                    nVar.gVT.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cUV());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.gVT, R.color.cp_other_f, 1);
                }
                if (postData.beE().getPendantData() != null && !StringUtils.isNull(postData.beE().getPendantData().bcA())) {
                    nVar.kBH.setBigVDimenSize(R.dimen.tbds32);
                    nVar.kBH.a(postData.beE(), 4);
                    nVar.kBo.setVisibility(8);
                    nVar.kBH.setVisibility(0);
                    nVar.kBH.getHeadView().startLoad(avater, 28, false);
                    nVar.kBH.getHeadView().setUserId(postData.beE().getUserId());
                    nVar.kBH.getHeadView().setUserName(postData.beE().getUserName());
                    nVar.kBH.getHeadView().setFid(this.kAg != null ? this.kAg.getForumId() : "");
                    nVar.kBH.getHeadView().setFName(this.kAg != null ? this.kAg.getForumName() : "");
                    nVar.kBH.getHeadView().setFloor(postData.dwF());
                    nVar.kBH.getHeadView().setTid(postData.getId());
                    nVar.kBH.getHeadView().setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kAg, postData, postData.locate, i2, 2));
                    nVar.kBH.Az(postData.beE().getPendantData().bcA());
                } else {
                    nVar.kBo.setGodIconWidth(R.dimen.tbds32);
                    UtilHelper.showHeadImageViewBigV(nVar.kBo, postData.beE(), 4);
                    nVar.kBo.setUserId(postData.beE().getUserId());
                    nVar.kBo.setFid(this.kAg != null ? this.kAg.getForumId() : "");
                    nVar.kBo.setFName(this.kAg != null ? this.kAg.getForumName() : "");
                    nVar.kBo.setFloor(postData.dwF());
                    nVar.kBo.setTid(postData.getId());
                    nVar.kBo.setUserName(postData.beE().getUserName(), postData.dwP());
                    nVar.kBo.setTag(R.id.tag_virtual_user_url, postData.beE().getVirtualUserUrl());
                    nVar.kBo.setTag(R.id.tag_statistic_item, com.baidu.tieba.pb.c.a.b(this.kAg, postData, postData.locate, i2, 2));
                    nVar.kBo.setImageDrawable(null);
                    nVar.kBo.startLoad(avater, 28, false);
                    nVar.kBo.setVisibility(0);
                    nVar.kBH.setVisibility(8);
                }
                if (postData.beE() != null && postData.beE().getAlaInfo() != null && postData.beE().getAlaUserData() != null && postData.beE().getAlaUserData().live_status == 1) {
                    nVar.rt(true);
                    nVar.kBo.setLiveStatus(1);
                    nVar.kBo.setAlaInfo(postData.beE().getAlaInfo());
                    nVar.kBH.getHeadView().setLiveStatus(1);
                    nVar.kBH.getHeadView().setAlaInfo(postData.beE().getAlaInfo());
                } else {
                    nVar.rt(false);
                    nVar.kBo.setLiveStatus(0);
                    nVar.kBo.setAlaInfo(null);
                    nVar.kBH.getHeadView().setLiveStatus(0);
                    nVar.kBH.getHeadView().setAlaInfo(null);
                }
                if (this.kAg != null && this.kAg.cVO()) {
                    nVar.kBi.setVisibility(8);
                    nVar.kBi.setTag(null);
                } else if (postData.beE() != null) {
                    MetaData beE = postData.beE();
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBi, R.color.cp_cont_a);
                    if (this.aYW != null && !this.aYW.equals("0") && this.aYW.equals(beE.getUserId())) {
                        nVar.kBi.setTag("HOST");
                        if (nVar.mSkinType == 1) {
                            if (this.kyK.getDrawable(1) != null) {
                                this.kyK.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.kyK.getDrawable(1) != null) {
                            this.kyK.getDrawable(1).setAlpha(0);
                        }
                        nVar.kBi.setBackgroundDrawable(this.kyK);
                        nVar.kBi.setVisibility(0);
                        nVar.kBi.setText(R.string.host_name);
                    } else if (beE.getIs_bawu() == 1 && postData.dwx()) {
                        int i3 = R.drawable.brand_official_btn;
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kBi, i3);
                        nVar.kBi.setTag(Integer.valueOf(i3));
                        nVar.kBi.setVisibility(0);
                        nVar.kBi.setText(R.string.brand_Official);
                    } else if (beE.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(beE.getBawu_type())) {
                        nVar.kBi.setTag("BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.aiP.getDrawable(1) != null) {
                                this.aiP.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.aiP.getDrawable(1) != null) {
                            this.aiP.getDrawable(1).setAlpha(0);
                        }
                        nVar.kBi.setBackgroundDrawable(this.aiP);
                        nVar.kBi.setVisibility(0);
                        nVar.kBi.setText(R.string.bawu_member_bazhu_tip);
                    } else if (beE.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(beE.getBawu_type())) {
                        nVar.kBi.setTag("XIAO_BA_ZHU_BG");
                        if (nVar.mSkinType == 1) {
                            if (this.aiQ.getDrawable(1) != null) {
                                this.aiQ.getDrawable(1).setAlpha(255);
                            }
                        } else if (this.aiQ.getDrawable(1) != null) {
                            this.aiQ.getDrawable(1).setAlpha(0);
                        }
                        nVar.kBi.setBackgroundDrawable(this.aiQ);
                        nVar.kBi.setVisibility(0);
                        nVar.kBi.setText(R.string.bawu_member_xbazhu_tip);
                    } else if (beE.getIs_bawu() == 1 && "pri_content_assist".equals(beE.getBawu_type())) {
                        int nS = com.baidu.tbadk.core.util.ap.nS(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kBi, nS);
                        nVar.kBi.setTag(Integer.valueOf(nS));
                        nVar.kBi.setVisibility(0);
                        nVar.kBi.setText(R.string.bawu_content_assist_tip);
                    } else if (beE.getIs_bawu() == 1 && "pri_manage_assist".equals(beE.getBawu_type())) {
                        int nS2 = com.baidu.tbadk.core.util.ap.nS(R.drawable.bg_user_identity_btn);
                        com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kBi, nS2);
                        nVar.kBi.setTag(Integer.valueOf(nS2));
                        nVar.kBi.setVisibility(0);
                        nVar.kBi.setText(R.string.bawu_manage_assist_tip);
                    } else {
                        nVar.kBi.setVisibility(8);
                        nVar.kBi.setTag(null);
                    }
                } else {
                    nVar.kBi.setVisibility(8);
                    nVar.kBi.setTag(null);
                }
            }
            int i4 = 0;
            if (this.kBW != null && this.kBW.cYi() != null && this.kBW.cYi().cWt() && postData.beE() != null) {
                i4 = postData.beE().getLevel_id();
            }
            if (this.kAg != null && this.kAg.cVO()) {
                i4 = 0;
            }
            if (i4 > 0) {
                nVar.kBG.setVisibility(0);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.kBG, BitmapHelper.getGradeResourceIdInEnterForum(i4));
            } else {
                nVar.kBG.setVisibility(8);
            }
            int i5 = 15;
            if (nVar.kBJ.getChildCount() == 1) {
                i5 = 13;
            } else if (nVar.kBJ.getChildCount() > 1) {
                i5 = 11;
            }
            if (nVar.kBi.getVisibility() == 0) {
                i5 -= 2;
            }
            if (nVar.kBI.getChildCount() > 0) {
                i5 -= 2;
            }
            if (postData.bgd() > 1000) {
                i5 -= 2;
            }
            if (postData.bgd() > 10) {
                i5 -= 2;
            }
            if (i5 < 10) {
                nVar.kBJ.setVisibility(8);
                if (nVar.kBJ.getChildCount() == 1) {
                    i5 += 2;
                } else if (nVar.kBJ.getChildCount() > 1) {
                    i5 += 4;
                }
                if (i5 < 10 && nVar.kBi.getVisibility() == 0) {
                    i5 += 2;
                    nVar.kBi.setVisibility(8);
                }
                if (i5 < 10 && nVar.kBG.getVisibility() == 0) {
                    i5 += 2;
                    nVar.kBG.setVisibility(8);
                }
            }
            String name_show2 = postData.beE() != null ? postData.beE().getName_show() : "";
            int textLengthWithEmoji = com.baidu.tbadk.util.ae.getTextLengthWithEmoji(name_show2);
            if (postData.beE() != null && !StringUtils.isNull(postData.beE().getSealPrefix())) {
                if (textLengthWithEmoji > i5 - 2) {
                    name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i5 - 2) + StringHelper.STRING_MORE;
                }
            } else if (textLengthWithEmoji > i5) {
                name_show2 = com.baidu.tbadk.util.ae.subStringWithEmoji(name_show2, i5) + StringHelper.STRING_MORE;
            }
            if (postData.beE() != null && !StringUtils.isNull(postData.beE().getSealPrefix())) {
                nVar.gVT.setText(dF(postData.beE().getSealPrefix(), name_show2));
            } else {
                nVar.gVT.setText(name_show2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_load_sub_data, postData);
            sparseArray.put(R.id.tag_load_sub_view, view);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.dwF()));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            boolean z9 = false;
            if (postData.beE() != null && !StringUtils.isNull(postData.beE().getVirtualUserUrl())) {
                z9 = true;
            }
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            if (this.kAg != null && this.kAg.cVA() != 0) {
                if (this.kAg.cVA() != 1002 && this.kAg.cVA() != 3) {
                    z10 = true;
                }
                if (this.kAg.cVA() != 3 && !this.kAg.cVO()) {
                    z11 = true;
                }
                if (postData != null && postData.beE() != null) {
                    String userId2 = postData.beE().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z10 = false;
                    }
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        boolean z13 = z11;
                        z = false;
                        z2 = z13;
                        if (this.kAg != null && this.kAg.cVl() != null && this.kAg.cVl().beE() != null && postData.beE() != null) {
                            userId = this.kAg.cVl().beE().getUserId();
                            String userId3 = postData.beE().getUserId();
                            if (UtilHelper.isCurrentAccount(userId)) {
                                z3 = true;
                                z4 = true;
                                if (UtilHelper.isCurrentAccount(userId3)) {
                                    z4 = false;
                                    z12 = true;
                                }
                                if (postData == null && postData.beE() != null && UtilHelper.isCurrentAccount(postData.beE().getUserId())) {
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
                                if (postData.dwF() == 1) {
                                    i6 = 0;
                                }
                                if (z) {
                                    sparseArray.put(R.id.tag_should_manage_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kAg.cVA()));
                                    if (postData.beE() != null) {
                                        sparseArray.put(R.id.tag_forbid_user_name, postData.beE().getUserName());
                                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.beE().getName_show());
                                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.beE().getPortrait());
                                    }
                                } else {
                                    sparseArray.put(R.id.tag_should_manage_visible, false);
                                }
                                if (z7) {
                                    sparseArray.put(R.id.tag_user_mute_visible, true);
                                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                                    if (postData.beE() != null) {
                                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.beE().getUserId());
                                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.beE().getUserName());
                                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.beE().getName_show());
                                    }
                                    if (this.kAg.cVl() != null) {
                                        sparseArray.put(R.id.tag_user_mute_thread_id, this.kAg.cVl().getId());
                                    }
                                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_user_mute_visible, false);
                                }
                                if (z8) {
                                    sparseArray.put(R.id.tag_should_delete_visible, true);
                                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.kAg.cVA()));
                                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                                    sparseArray.put(R.id.tag_del_post_id, postData.getId());
                                } else {
                                    sparseArray.put(R.id.tag_should_delete_visible, false);
                                }
                                nVar.kBp.setTag(sparseArray);
                                if (this.kAY) {
                                    nVar.kBK.setTag(sparseArray);
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
                        if (postData.dwF() == 1) {
                        }
                        if (z) {
                        }
                        if (z7) {
                        }
                        if (z8) {
                        }
                        nVar.kBp.setTag(sparseArray);
                        if (this.kAY) {
                        }
                    }
                }
            }
            boolean z15 = z11;
            z = z10;
            z2 = z15;
            if (this.kAg != null) {
                userId = this.kAg.cVl().beE().getUserId();
                String userId32 = postData.beE().getUserId();
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
            if (postData.dwF() == 1) {
            }
            if (z) {
            }
            if (z7) {
            }
            if (z8) {
            }
            nVar.kBp.setTag(sparseArray);
            if (this.kAY) {
            }
        }
    }

    private void f(n nVar, PostData postData) {
        if (nVar != null && postData != null && nVar.kBK != null && this.kAg != null) {
            if (this.kAY && !this.kAg.cVO()) {
                nVar.kBK.setVisibility(0);
                nVar.kBK.setOnClickListener(this.aRU);
                return;
            }
            nVar.kBK.setVisibility(8);
        }
    }

    private void b(n nVar, PostData postData, boolean z) {
        if (nVar != null && postData != null && postData.bgv() != null) {
            postData.bgv().threadId = this.kBW.cWD().cYB();
            postData.bgv().objType = 1;
            postData.bgv().isInPost = true;
            bw bwVar = null;
            if (this.kAg != null && this.kAg.cVl() != null) {
                bwVar = this.kAg.cVl();
            }
            if (z) {
                nVar.kBE.setAgreeAlone(true);
                nVar.kBE.setThreadData(bwVar);
                nVar.kBE.setData(postData.bgv());
            }
            if (bwVar != null && bwVar.bdo()) {
                nVar.kBn.setAgreeAlone(true);
            }
            nVar.kBn.setThreadData(bwVar);
            nVar.kBn.setData(postData.bgv());
        }
    }

    private void g(n nVar, PostData postData) {
        boolean z;
        int i;
        int i2;
        if (nVar != null && postData != null) {
            if (postData.dwF() > 0 && this.kAg != null && !this.kAg.cVO()) {
                String format = String.format(this.mContext.getString(R.string.is_floor), Integer.valueOf(postData.dwF()));
                nVar.kBF.setVisibility(0);
                nVar.kBF.setText(format);
                z = true;
            } else {
                nVar.kBF.setVisibility(8);
                z = false;
            }
            com.baidu.tbadk.data.f dwI = postData.dwI();
            boolean z2 = (dwI == null || StringUtils.isNull(dwI.getName()) || this.kAg == null || this.kAg.cVO()) ? false : true;
            if (z) {
                nVar.kBk.setVisibility(0);
                i = this.izN;
            } else {
                nVar.kBk.setVisibility(8);
                i = 0;
            }
            if (z2) {
                nVar.kBl.setVisibility(0);
                i2 = this.izN;
            } else {
                nVar.kBl.setVisibility(8);
                i2 = 0;
            }
            nVar.kBj.setPadding(i, 0, i2, 0);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                nVar.kBj.setText(com.baidu.tbadk.core.util.at.getFormatTimeShort(postData.getTime()));
            } else {
                nVar.kBj.setText(com.baidu.tbadk.core.util.at.getFormatTime(postData.getTime()));
            }
            if (z2) {
                nVar.kBm.setVisibility(0);
                nVar.kBm.setPadding(this.izN, 0, 0, 0);
                if (postData.mfG) {
                    nVar.kBm.setText(com.baidu.tbadk.core.util.at.cutStringWithSuffix(dwI.getName(), 7, StringHelper.STRING_MORE));
                    return;
                } else {
                    nVar.kBm.setText(dwI.getName());
                    return;
                }
            }
            nVar.kBm.setVisibility(8);
        }
    }

    private void a(n nVar, PostData postData, View view) {
        if (nVar != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kBp.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            nVar.kBp.setPadding(0, 0, 0, 0);
            if (!this.kAh) {
                nVar.kBp.getLayoutStrategy().rf(R.drawable.icon_click);
            } else {
                nVar.kBp.CU(null);
                nVar.kBp.setBackgroundDrawable(null);
                nVar.kBp.getLayoutStrategy().rf(R.drawable.transparent_bg);
            }
            nVar.kBp.getLayoutStrategy().rc(R.drawable.pic_video);
            a(nVar.kBp, view, !StringUtils.isNull(postData.getBimg_url()));
            nVar.kBp.setLayoutParams(layoutParams);
            nVar.kBp.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_link_tip_c));
            nVar.kBp.setIsFromCDN(this.mIsFromCDN);
            nVar.kBp.setText(postData.dwH(), true, this.kAW);
            SparseArray sparseArray = (SparseArray) nVar.kBp.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            nVar.kBp.setTag(sparseArray);
            nVar.kBh.setTag(R.id.tag_from, sparseArray);
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
            tbRichTextView.getLayoutStrategy().rd(equipmentWidth - dimensionPixelSize);
            tbRichTextView.getLayoutStrategy().feB = (equipmentWidth - dimensionPixelSize) - getDimensionPixelSize(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().re((int) (equipmentWidth * 1.618f));
        }
    }

    private void c(n nVar, PostData postData, View view, int i) {
        String string;
        if (nVar != null && postData != null) {
            if (postData.dwJ() > 0) {
                nVar.kBu.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) nVar.kBu.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    nVar.kBu.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, postData);
                if (postData.dwR() == 2) {
                    nVar.kBu.setVisibility(8);
                } else if (this.kAY) {
                    nVar.kBr.setVisibility(8);
                } else {
                    nVar.kBu.setVisibility(0);
                }
                nVar.kBt.setVisibility(8);
            }
            if (this.kAY) {
                if (com.baidu.tbadk.a.d.aZW()) {
                    string = postData.dwJ() > 0 ? String.valueOf(postData.dwJ()) : TbadkCoreApplication.getInst().getString(R.string.reply);
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.reply);
                }
                nVar.kBD.setText(string);
                if (nVar.kBy != null) {
                    SparseArray sparseArray2 = (SparseArray) nVar.kBy.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        nVar.kBy.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.kBx != null) {
                    SparseArray sparseArray3 = (SparseArray) nVar.kBx.getTag();
                    if (sparseArray3 == null) {
                        sparseArray3 = new SparseArray();
                        nVar.kBx.setTag(sparseArray3);
                    }
                    sparseArray3.put(R.id.tag_load_sub_data, postData);
                }
            } else {
                if (nVar.kBv != null) {
                    SparseArray sparseArray4 = (SparseArray) nVar.kBv.getTag();
                    if (sparseArray4 == null) {
                        sparseArray4 = new SparseArray();
                        nVar.kBv.setTag(sparseArray4);
                    }
                    sparseArray4.put(R.id.tag_load_sub_data, postData);
                }
                if (nVar.iTP != null) {
                    SparseArray sparseArray5 = (SparseArray) nVar.iTP.getTag();
                    if (sparseArray5 == null) {
                        sparseArray5 = new SparseArray();
                        nVar.iTP.setTag(sparseArray5);
                    }
                    sparseArray5.put(R.id.tag_load_sub_data, postData);
                }
            }
            if (postData.dwJ() > 0 && !this.kAZ) {
                nVar.kBt.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.sub_pb_load_more, Integer.valueOf(postData.dwJ())));
                SparseArray sparseArray6 = (SparseArray) nVar.kBt.getTag();
                if (sparseArray6 == null) {
                    sparseArray6 = new SparseArray();
                    nVar.kBt.setTag(sparseArray6);
                }
                sparseArray6.put(R.id.tag_load_sub_data, postData);
                nVar.kBt.setVisibility(0);
                nVar.kBu.setVisibility(8);
                nVar.kBs.setVisibility(8);
            } else {
                nVar.kBt.setVisibility(8);
                if (this.kAZ) {
                    nVar.kBu.setVisibility(8);
                }
                if (postData.dwJ() > 0 && postData.dwC() != null && postData.dwC().size() > 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) nVar.kBs.getLayoutParams();
                    layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10);
                    layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds166);
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
                    layoutParams.bottomMargin = 0;
                    nVar.kBs.setLayoutParams(layoutParams);
                    if (this.kAX == null) {
                        this.kAX = new com.baidu.tieba.pb.pb.sub.b(this.mContext);
                        this.kAX.setIsFromCDN(this.mIsFromCDN);
                        this.kAX.setOnLongClickListener(this.mOnLongClickListener);
                        this.kAX.W(this.kAq);
                        this.kAX.A(this.aRU);
                        String str = null;
                        if (this.kAg != null && this.kAg.cVl() != null && this.kAg.cVl().beE() != null) {
                            str = this.kAg.cVl().beE().getUserId();
                        }
                        boolean z = str != null && str.equals(TbadkCoreApplication.getCurrentAccount());
                        if (this.kAg != null) {
                            this.kAX.ac(this.kAg.cVA(), z);
                            this.kAX.setThreadData(this.kAg.cVl());
                        }
                    }
                    this.kAX.NY(postData.getId());
                    nVar.kBs.setSubPbAdapter(this.kAX);
                    nVar.kBs.setVisibility(0);
                    nVar.kBs.setData(postData, view);
                    nVar.kBs.setChildOnClickListener(this.aRU);
                    nVar.kBs.setChildOnLongClickListener(this.mOnLongClickListener);
                    nVar.kBs.setChildOnTouchListener(this.kBa);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.kBs.getLayoutParams();
                    layoutParams2.topMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    nVar.kBs.setLayoutParams(layoutParams2);
                    nVar.kBs.setVisibility(8);
                }
            }
            if (postData.mfw) {
                nVar.mBottomLine.setVisibility(0);
            } else {
                nVar.mBottomLine.setVisibility(4);
            }
        }
    }

    private void h(n nVar, PostData postData) {
        if (nVar != null && nVar.kBP != null && nVar.kBM != null) {
            if (postData == null || postData.mfA == null || StringUtils.isNull(postData.mfA.liveTitle)) {
                nVar.kBM.setVisibility(8);
                return;
            }
            nVar.kBP.setText(postData.mfA.liveTitle);
            nVar.kBM.setTag(postData.mfA);
            nVar.kBM.setVisibility(0);
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void i(n nVar, PostData postData) {
        if (nVar != null && postData != null) {
            nVar.kBU.setVisibility(postData.mfG ? 0 : 8);
        }
    }

    private void a(n nVar) {
        LayerDrawable layerDrawable;
        if (nVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (nVar.mSkinType != skinType) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.gVT, R.color.cp_cont_d, 1);
                if (nVar.kBi.getTag() instanceof Integer) {
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kBi, ((Integer) nVar.kBi.getTag()).intValue());
                } else if (nVar.kBi.getTag() instanceof String) {
                    if (nVar.kBi.getTag().equals("BA_ZHU_BG")) {
                        layerDrawable = this.aiP;
                    } else if (nVar.kBi.getTag().equals("XIAO_BA_ZHU_BG")) {
                        layerDrawable = this.aiQ;
                    } else {
                        layerDrawable = nVar.kBi.getTag().equals("HOST") ? this.kyK : null;
                    }
                    if (layerDrawable != null && layerDrawable.getDrawable(1) != null) {
                        if (nVar.mSkinType == 1) {
                            layerDrawable.getDrawable(1).setAlpha(255);
                        } else {
                            layerDrawable.getDrawable(1).setAlpha(0);
                        }
                        nVar.kBi.setBackgroundDrawable(layerDrawable);
                    }
                }
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBj, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBk, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBl, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBF, R.color.cp_cont_d, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBm, R.color.cp_cont_d, 1);
                nVar.kBp.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
                com.baidu.tbadk.core.util.ap.c(nVar.kBs, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBt, R.color.cp_cont_c);
                nVar.kBt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBu, R.color.cp_cont_c);
                if (this.kAY) {
                    SvgManager.bjq().a(nVar.kBK, R.drawable.ic_icon_pure_close24, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(nVar.kBC, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(nVar.kBA, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    nVar.kBE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBB, R.color.cp_cont_d);
                    com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBD, R.color.cp_cont_d);
                } else {
                    SvgManager.bjq().a(nVar.kBv, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(nVar.iTP, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                nVar.kBs.onChangeSkinType();
                nVar.kBq.onChangeSkinType();
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBP, R.color.cp_link_tip_c, 1);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBN, R.color.cp_cont_f, 1);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kBM, R.color.cp_bg_line_e);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(nVar.kBO, R.color.cp_cont_d);
                com.baidu.tbadk.core.util.ap.setImageResource(nVar.kBQ, R.drawable.icon_arrow_more_gray);
                com.baidu.tbadk.core.util.ap.setViewTextColor(nVar.kBT, R.color.cp_cont_c);
                if (nVar.kBR.getVisibility() == 8) {
                    nVar.kBT.setText(R.string.close_content);
                } else if (this.kAg != null && StringUtils.isNull(this.kAg.cVw())) {
                    nVar.kBT.setText(this.kAg.cVw());
                } else {
                    nVar.kBT.setText(R.string.expand_content);
                }
                nVar.kBn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                nVar.Cc(skinType);
                com.baidu.tbadk.core.util.ap.setBackgroundColor(nVar.mBottomLine, R.color.cp_bg_line_b);
            }
            nVar.mSkinType = skinType;
        }
    }

    private void b(final n nVar) {
        nVar.kBh.setOnTouchListener(this.kBa);
        nVar.kBh.setOnLongClickListener(this.mOnLongClickListener);
        if (this.kBW.cYi() != null && this.kBW.cYi().getPageContext() != null && this.kBW.cYi().getPageContext().getOrignalPage() != 0) {
            com.baidu.tieba.pb.pb.main.b.a aVar = this.kBW.cYi().kzF;
            nVar.gVT.setOnClickListener(aVar.hCj);
            nVar.kBo.setOnClickListener(aVar.hCj);
            nVar.kBH.setOnClickListener(aVar.hCj);
            nVar.kBH.getHeadView().setOnClickListener(aVar.hCj);
            nVar.kBp.setOnLongClickListener(this.mOnLongClickListener);
            nVar.kBp.setOnTouchListener(this.kBa);
            nVar.kBp.setCommonTextViewOnClickListener(this.aRU);
            nVar.kBp.setOnImageClickListener(this.fcy);
            nVar.kBp.setOnImageTouchListener(this.kBa);
            nVar.kBp.setOnEmotionClickListener(aVar.kPG);
            nVar.kBp.setOnVoiceAfterClickListener(this.aRU);
            nVar.kBL.setOnClickListener(this.aRU);
            nVar.kBM.setOnClickListener(this.aRU);
            nVar.kBt.setOnClickListener(this.aRU);
            nVar.kBu.setOnClickListener(this.aRU);
            final com.baidu.tieba.pb.pb.main.b.c cVar = this.kBW.cYi().kzG;
            if (this.kAY) {
                nVar.kBy.setOnClickListener(this.aRU);
                nVar.kBx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        final PostData postData;
                        if (view.getTag() instanceof SparseArray) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kBh != null && cVar != null) {
                                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.kPV.a(m.this.kAg, null, postData, nVar.kBh);
                                    }
                                }, 100L);
                                String threadId = m.this.kAg.getThreadId();
                                if ((StringUtils.isNull(threadId) || "0".equals(m.this.kAg.getThreadId())) && m.this.kAg.cVl() != null) {
                                    threadId = m.this.kAg.cVl().getNid();
                                }
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dD("tid", threadId).dD("fid", m.this.kAg.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData.getId()).ai("obj_type", 4));
                            }
                        }
                    }
                });
                nVar.kBE.eok = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && m.this.kAg != null && nVar != null && nVar.kBE != null && nVar.kBE.getData() != null) {
                            int i = view == nVar.kBE.getImgAgree() ? 1 : 2;
                            String threadId = m.this.kAg.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.kAg.getThreadId())) && m.this.kAg.cVl() != null) {
                                threadId = m.this.kAg.cVl().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dD("tid", threadId).dD("fid", m.this.kAg.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", nVar.kBE.getData().postId).ai("obj_type", i));
                        }
                    }
                };
                return;
            }
            nVar.kBv.setOnClickListener(this.aRU);
            nVar.iTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    final PostData postData;
                    if (view.getTag() instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) view.getTag();
                        if ((sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) != null && nVar.kBh != null && cVar != null) {
                            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.m.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    cVar.kPV.a(m.this.kAg, null, postData, nVar.kBh);
                                }
                            }, 100L);
                            String threadId = m.this.kAg.getThreadId();
                            if ((StringUtils.isNull(threadId) || "0".equals(m.this.kAg.getThreadId())) && m.this.kAg.cVl() != null) {
                                threadId = m.this.kAg.cVl().getNid();
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dD("tid", threadId).dD("fid", m.this.kAg.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData.getId()).ai("obj_type", 4));
                        }
                    }
                }
            });
            nVar.kBn.eok = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.m.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null && m.this.kAg != null && nVar != null && nVar.kBn != null && nVar.kBn.getData() != null) {
                        int i = view == nVar.kBn.getImgAgree() ? 1 : 2;
                        String threadId = m.this.kAg.getThreadId();
                        if ((StringUtils.isNull(threadId) || "0".equals(m.this.kAg.getThreadId())) && m.this.kAg.cVl() != null) {
                            threadId = m.this.kAg.cVl().getNid();
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dD("tid", threadId).dD("fid", m.this.kAg.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", nVar.kBn.getData().postId).ai("obj_type", i));
                    }
                }
            };
        }
    }

    private void ui() {
        this.aiP = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAn).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAn).Aw("#4D000000").bjT()});
        this.aiQ = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAn).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAn).Aw("#4D000000").bjT()});
        this.kyK = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAn).b("TL_BR", R.color.floor_host_start, R.color.floor_host_end).bjT(), com.baidu.tbadk.core.util.e.a.b.bjR().oe(0).V(this.iAn).Aw("#4D000000").bjT()});
    }

    public void a(TbRichTextView.c cVar) {
        this.kAW = cVar;
    }

    public void setData(com.baidu.tieba.pb.data.f fVar) {
        this.kAg = fVar;
    }

    public void gL(String str) {
        this.aYW = str;
    }

    public void sD(boolean z) {
        this.kAh = z;
    }

    private SpannableStringBuilder dF(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.kBW.cYi(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void c(n nVar) {
        nVar.kBp.setTextViewOnTouchListener(this.eFf);
        nVar.kBp.setTextViewCheckSelection(false);
    }

    public void S(View.OnClickListener onClickListener) {
        this.kAq = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.aRU = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcy = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eFf = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
