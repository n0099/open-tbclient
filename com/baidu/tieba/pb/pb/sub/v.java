package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.cr;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class v {
    private static final int cnT = TbadkCoreApplication.m411getInst().getListItemRule().wo();
    private NoNetworkView aRi;
    private View.OnClickListener aZI;
    private RelativeLayout cfp;
    public RelativeLayout ckt;
    public LinearLayout cku;
    public ImageView ckv;
    public TextView ckw;
    public ImageView ckx;
    private com.baidu.tbadk.core.view.a cmL;
    private int cnU;
    private View cnV;
    private ak cnW;
    private NewSubPbActivity cnX;
    private RelativeLayout cnY;
    private al cod;
    private View coe;
    private ArrayList<com.baidu.tieba.tbadkCore.data.o> cok;
    private String col;

    /* renamed from: com  reason: collision with root package name */
    private com.baidu.tieba.pb.a.d f128com;
    private BdListView mListView;
    private ProgressBar mProgress;
    private com.baidu.tbadk.core.view.m mNoDataView = null;
    private TbRichTextView.d cnM = null;
    private View.OnClickListener Sj = null;
    private TbRichTextView.e cnL = null;
    private NavigationBar mNavigationBar = null;
    private TextView cnZ = null;
    private TextView WR = null;
    private HeadImageView cim = null;
    private TextView aGS = null;
    private ImageView cin = null;
    private ImageView cip = null;
    private TextView coa = null;
    private ImageView cir = null;
    private TextView bqp = null;
    private TbRichTextView chB = null;
    private ImageView cis = null;
    private TextView cob = null;
    private TextView coc = null;
    private MorePopupWindow cjs = null;
    private cr cjt = null;
    private com.baidu.tbadk.core.dialog.c cmx = null;
    private UserIconBox bds = null;
    private UserIconBox aTq = null;
    private Dialog cme = null;
    private com.baidu.tbadk.core.dialog.a cmg = null;
    private boolean chp = true;
    private boolean chO = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cof = null;
    private NewSubPbActivity.a cog = null;
    private NewSubPbActivity.a coh = null;
    private ArrayList<IconData> chX = null;
    private ArrayList<IconData> aSY = null;
    private com.baidu.tbadk.editortools.c.p cbv = null;
    private String coi = null;
    private int coj = 0;
    private View.OnClickListener chY = new w(this);
    private com.baidu.tieba.pb.b.c chs = new com.baidu.tieba.pb.b.c(new ac(this));
    protected AdapterView.OnItemClickListener con = new ad(this);
    protected AdapterView.OnItemLongClickListener Hz = new ae(this);

    public v(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.cfp = null;
        this.cnV = null;
        this.mListView = null;
        this.cnW = null;
        this.cnX = null;
        this.aRi = null;
        this.cnY = null;
        this.cod = null;
        this.coe = null;
        this.aZI = null;
        this.mProgress = null;
        this.cnX = newSubPbActivity;
        this.aZI = onClickListener;
        this.cfp = (RelativeLayout) LayoutInflater.from(this.cnX.getPageContext().getPageActivity()).inflate(i.g.new_sub_pb_layout, (ViewGroup) null);
        this.cnV = LayoutInflater.from(this.cnX.getPageContext().getPageActivity()).inflate(i.g.new_sub_pb_head, (ViewGroup) null);
        this.aRi = (NoNetworkView) this.cfp.findViewById(i.f.view_no_network);
        this.cnU = com.baidu.adp.lib.util.k.K(this.cnX.getBaseContext()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
        ahJ();
        Hw();
        this.cnY = (RelativeLayout) this.cfp.findViewById(i.f.sub_pb_body_layout);
        this.mListView = (BdListView) this.cfp.findViewById(i.f.new_sub_pb_list);
        this.mListView.addHeaderView(this.cnV);
        this.cnW = new ak(this.cnX.getPageContext().getPageActivity());
        this.cnW.D(this.chY);
        this.cnW.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.cnW);
        this.cod = new al(this.cnX.getPageContext());
        this.coe = this.cod.getView();
        this.mListView.setNextPage(this.cod);
        this.cod.setOnClickListener(this.aZI);
        this.mListView.setOnItemClickListener(this.con);
        this.mListView.setOnItemLongClickListener(this.Hz);
        this.mListView.setOnTouchListener(this.chs);
        this.mProgress = (ProgressBar) this.cfp.findViewById(i.f.progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.cnV != null) {
            this.cnV.setVisibility(4);
        }
        if (this.cnY != null) {
            this.cnY.setVisibility(4);
        }
    }

    public void Hw() {
        this.cim = (HeadImageView) this.cnV.findViewById(i.f.photo);
        this.cim.setOnClickListener(this.aZI);
        this.aGS = (TextView) this.cnV.findViewById(i.f.user_name);
        this.cin = (ImageView) this.cnV.findViewById(i.f.user_rank);
        this.cip = (ImageView) this.cnV.findViewById(i.f.user_gender);
        this.cis = (ImageView) this.cnV.findViewById(i.f.reply);
        this.cob = (TextView) this.cnV.findViewById(i.f.manage_btn);
        this.coa = (TextView) this.cnV.findViewById(i.f.floor);
        this.cir = (ImageView) this.cnV.findViewById(i.f.floor_owner);
        this.bqp = (TextView) this.cnV.findViewById(i.f.time);
        this.bds = (UserIconBox) this.cnV.findViewById(i.f.user_icon_box);
        this.aTq = (UserIconBox) this.cnV.findViewById(i.f.user_tshow_icon_box);
        this.chB = (TbRichTextView) this.cnV.findViewById(i.f.richText);
        this.chB.Fj();
        this.chB.f(this.chp, true);
        this.chB.setIsFromCDN(this.mIsFromCDN);
        this.chB.setImageViewStretch(true);
        this.chB.setTextSize(TbConfig.getContentSize());
        this.chB.setVoiceViewRes(i.g.voice_play_btn);
        this.cnV.setOnTouchListener(this.chs);
        this.cnV.setOnClickListener(this.aZI);
        this.coc = (TextView) this.cnV.findViewById(i.f.pb_item_tail_content);
        this.coc.setOnClickListener(this.aZI);
        this.ckt = (RelativeLayout) this.cnV.findViewById(i.f.chudian_info_container);
        this.cku = (LinearLayout) this.cnV.findViewById(i.f.landmark_container);
        this.ckv = (ImageView) this.cnV.findViewById(i.f.landmark_icon);
        this.ckw = (TextView) this.cnV.findViewById(i.f.landmark_content);
        this.ckx = (ImageView) this.cnV.findViewById(i.f.ad_icon);
    }

    public void ahJ() {
        this.mNavigationBar = (NavigationBar) this.cfp.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.WR = this.mNavigationBar.setTitleText("");
        this.cnZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cnX.getResources().getString(i.h.view_subject), this.aZI);
        this.cnZ.setVisibility(8);
    }

    public void afK() {
        this.cjt = new cr(this.cnX.getPageContext(), this.aZI);
        this.cjt.eG(TbadkCoreApplication.isLogin());
        this.cjs = new MorePopupWindow(this.cnX.getPageContext().getPageActivity(), this.cjt.getView(), this.cnX.getResources().getDrawable(i.e.bg_collect), null);
        this.cjs.setTouchInterceptor(new af(this));
        this.cjs.onChangeSkinType(this.cnX, TbadkCoreApplication.m411getInst().getSkinType(), com.baidu.tbadk.core.util.an.getDrawable(i.e.bg_collect));
    }

    public void ab(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.cme == null) {
            this.cme = new Dialog(this.cnX.getPageContext().getPageActivity(), i.C0057i.common_alert_dialog);
            this.cme.setCanceledOnTouchOutside(true);
            this.cme.setCancelable(true);
            View inflate = LayoutInflater.from(this.cnX.getPageContext().getPageActivity()).inflate(i.g.forum_manage_dialog, (ViewGroup) null);
            this.cnX.getLayoutMode().k(inflate);
            this.cme.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cme.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cnX.getPageContext().getPageActivity()) * 0.9d);
            this.cme.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.cme.findViewById(i.f.del_post_btn);
        TextView textView2 = (TextView) this.cme.findViewById(i.f.forbid_user_btn);
        TextView textView3 = (TextView) this.cme.findViewById(i.f.disable_reply_btn);
        if ("".equals(sparseArray.get(i.f.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(i.f.tag_del_post_id, sparseArray.get(i.f.tag_del_post_id));
            sparseArray2.put(i.f.tag_del_post_type, sparseArray.get(i.f.tag_del_post_type));
            sparseArray2.put(i.f.tag_del_post_is_self, sparseArray.get(i.f.tag_del_post_is_self));
            sparseArray2.put(i.f.tag_manage_user_identity, sparseArray.get(i.f.tag_manage_user_identity));
            textView.setOnClickListener(new ag(this));
        }
        if ("".equals(sparseArray.get(i.f.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(i.f.tag_forbid_user_name, sparseArray.get(i.f.tag_forbid_user_name));
            sparseArray3.put(i.f.tag_manage_user_identity, sparseArray.get(i.f.tag_manage_user_identity));
            sparseArray3.put(i.f.tag_forbid_user_post_id, sparseArray.get(i.f.tag_forbid_user_post_id));
            textView2.setOnClickListener(new ah(this));
        }
        if (!((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(i.h.un_mute);
            } else {
                textView3.setText(i.h.mute);
            }
            sparseArray4.put(i.f.tag_is_mem, sparseArray.get(i.f.tag_is_mem));
            sparseArray4.put(i.f.tag_disable_reply_mute_userid, sparseArray.get(i.f.tag_disable_reply_mute_userid));
            sparseArray4.put(i.f.tag_disable_reply_mute_username, sparseArray.get(i.f.tag_disable_reply_mute_username));
            sparseArray4.put(i.f.tag_disable_reply_post_id, sparseArray.get(i.f.tag_disable_reply_post_id));
            sparseArray4.put(i.f.tag_disable_reply_thread_id, sparseArray.get(i.f.tag_disable_reply_thread_id));
            textView3.setOnClickListener(new ai(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.cme, this.cnX.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(i.f.tag_del_post_id, str);
        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = i.h.del_post_confirm;
        if (i == 0) {
            i3 = i.h.del_thread_confirm;
        }
        this.cmg = new com.baidu.tbadk.core.dialog.a(this.cnX.getPageContext().getPageActivity());
        this.cmg.bF(i3);
        this.cmg.x(sparseArray);
        this.cmg.a(i.h.dialog_ok, new aj(this, sparseArray));
        this.cmg.b(i.h.dialog_cancel, new x(this));
        this.cmg.aj(true);
        this.cmg.b(this.cnX.getPageContext());
        this.cmg.sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new y(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.cmx != null) {
            this.cmx.dismiss();
            this.cmx = null;
        }
        if (z) {
            string = this.cnX.getResources().getString(i.h.remove_mark);
        } else {
            string = this.cnX.getResources().getString(i.h.mark);
        }
        this.cmx = new com.baidu.tbadk.core.dialog.c(this.cnX.getPageContext().getPageActivity());
        this.cmx.bI(i.h.operation);
        this.cmx.a(new String[]{this.cnX.getResources().getString(i.h.copy), string}, bVar);
        this.cmx.d(this.cnX.getPageContext());
        this.cmx.sU();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.cog = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.coh = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.cnX.showToast(this.cnX.getResources().getString(i.h.success));
        } else if (str != null && z2) {
            this.cnX.showToast(str);
        }
    }

    public void aa(View view) {
        if (this.mNavigationBar.getVisibility() == 0) {
            this.mNavigationBar.setVisibility(8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                bd.a((View) this.cfp, i.c.cp_link_tip_b, true);
                return;
            }
            return;
        }
        this.mNavigationBar.setVisibility(0);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bd.r(this.cfp);
        }
    }

    public void e(com.baidu.tbadk.editortools.c.p pVar) {
        if (pVar != null && pVar.Az() != null) {
            this.cbv = pVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cfp.addView(pVar.Az(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i, View view) {
        new Handler().postDelayed(new z(this, view, i), 300L);
    }

    public void et(boolean z) {
        this.chO = z;
        this.cnW.et(z);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.cfp;
    }

    public void aX(String str, String str2) {
        this.col = str2;
        new Handler().postDelayed(new aa(this, str2, str), 200L);
    }

    public void aho() {
        if (this.cjs != null) {
            com.baidu.adp.lib.g.j.a(this.cjs, this.cnX.getPageContext().getPageActivity());
        }
        if (this.cmx != null) {
            this.cmx.dismiss();
        }
        if (this.cmg != null) {
            this.cmg.dismiss();
        }
        if (this.cme != null) {
            com.baidu.adp.lib.g.j.b(this.cme, this.cnX.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void ahK() {
        this.mListView.setNextPage(this.cod);
        this.cod.startLoadData();
    }

    public void er(boolean z) {
        this.chp = z;
    }

    public void a(com.baidu.tieba.pb.a.d dVar, int i) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z = false;
        if (dVar != null) {
            this.f128com = dVar;
            this.cnW.e(this.f128com.afB());
            if (this.cnV != null) {
                this.cnV.setVisibility(0);
            }
            if (this.cnY != null) {
                this.cnY.setVisibility(0);
            }
            if (dVar.afs() != null) {
                this.coi = dVar.afs().getId();
                this.coj = dVar.afs().axt();
                if (this.coj > 0) {
                    this.WR.setText(String.format(this.cnX.getPageContext().getString(i.h.is_floor), Integer.valueOf(this.coj)));
                } else {
                    this.WR.setText((CharSequence) null);
                }
            }
            if (dVar.hasMore()) {
                this.cod.startLoadData();
                this.cnW.setHasMoreData(true);
            } else {
                this.cod.vz();
                this.cnW.setHasMoreData(false);
            }
            this.cok = dVar.afw();
            if (this.cok == null || this.cok.size() == 0) {
                this.mListView.setNextPage(null);
            } else {
                this.mListView.setNextPage(this.cod);
            }
            if (this.cok == null || this.cok.size() <= cnT) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.cok.size() - cnT;
                jl(i4);
                i3 = this.mListView.getFirstVisiblePosition() - i4;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
            }
            this.cnW.setDatas(this.cok);
            if (dVar.afB() != null && dVar.afB().getAuthor() != null && (userId = dVar.afB().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            this.cnW.p(i, z);
            this.cnW.notifyDataSetChanged();
            a(dVar.afs(), dVar.Xb(), dVar.qi(), i);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View ahL() {
        return this.cis;
    }

    private void jl(int i) {
        if (this.cok != null) {
            if (this.cok.size() <= i) {
                this.cok.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.o> it = this.cok.iterator();
            while (it.hasNext()) {
                it.next();
                i2++;
                it.remove();
                if (i2 >= i) {
                    return;
                }
            }
        }
    }

    public boolean ahM() {
        return this.cnW.cov;
    }

    protected void a(com.baidu.tieba.tbadkCore.data.o oVar, boolean z, boolean z2, int i) {
        int i2;
        if (oVar != null) {
            com.baidu.tieba.tbadkCore.data.g axC = oVar.axC();
            if (axC != null && axC.daD) {
                this.ckt.setVisibility(0);
                this.ckx.setBackgroundDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_tuiguang));
                String position = axC.getPosition();
                if (!TextUtils.isEmpty(position)) {
                    this.cku.setVisibility(0);
                    this.ckw.setText(position);
                }
                this.chB.setOnLinkImageClickListener(this.cnL);
                this.chB.setOnImageClickListener(this.cnM);
            } else {
                this.ckt.setVisibility(8);
            }
            this.cim.setTag(null);
            this.cim.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.cnV.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.cnV.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(i.f.tag_clip_board, oVar);
            sparseArray.put(i.f.tag_is_subpb, false);
            a(oVar, i, sparseArray);
            this.cis.setTag(sparseArray);
            if (!this.chO) {
                this.cim.setVisibility(8);
            }
            this.aGS.setOnClickListener(this.aZI);
            this.aGS.setText((CharSequence) null);
            this.cir.setVisibility(8);
            this.coa.setText((CharSequence) null);
            this.cis.setOnClickListener(this.aZI);
            com.baidu.tbadk.core.util.an.b(this.bqp, i.c.pb_listitem_post_time, 1);
            this.bqp.setText(as.m(oVar.getTime()));
            if (z) {
                this.cir.setVisibility(0);
                com.baidu.tbadk.core.util.an.c(this.cir, i.e.icon_floorhost);
            }
            if (this.chp) {
                i2 = i.e.img_default_100;
            } else {
                i2 = i.e.icon_click;
            }
            this.chB.setDefaultImageId(i2);
            this.coa.setText(String.format(this.cnX.getPageContext().getString(i.h.is_floor), Integer.valueOf(oVar.axt())));
            String portrait = oVar.getAuthor().getPortrait();
            if (oVar.getAuthor() != null) {
                String name_show = oVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.n.fQ(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.n.e(name_show, 0, 14)) + "...";
                }
                this.aGS.setText(name_show);
                ArrayList<IconData> tShowInfo = oVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.an.b(this.aGS, i.c.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.an.b(this.aGS, i.c.cp_cont_f, 1);
                }
                int level_id = oVar.getAuthor().getLevel_id();
                int is_bawu = oVar.getAuthor().getIs_bawu();
                String bawu_type = oVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    this.cin.setVisibility(0);
                    com.baidu.tbadk.core.util.an.c(this.cin, com.baidu.tbadk.core.util.c.ci(level_id));
                    this.cin.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.cin.setVisibility(8);
                }
                if (is_bawu != 0) {
                    this.cin.setOnClickListener(this.aZI);
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.an.c(this.cin, i.e.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.an.c(this.cin, i.e.pb_assist);
                    }
                }
                if (oVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.an.c(this.cip, i.e.icon_pb_pop_girl);
                    this.cip.setVisibility(0);
                } else if (oVar.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.an.c(this.cip, i.e.icon_pb_pop_boy);
                    this.cip.setVisibility(0);
                } else {
                    this.cip.setVisibility(8);
                }
                this.chX = oVar.getAuthor().getIconInfo();
                this.aSY = oVar.getAuthor().getTShowInfo();
                if (this.bds != null) {
                    this.bds.setOnClickListener(this.aZI);
                    this.bds.a(this.chX, i3, this.cnX.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.cnX.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.cnX.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                }
                if (this.aTq != null) {
                    this.aTq.setOnClickListener(this.aZI);
                    this.aTq.a(this.aSY, 2, this.cnX.getResources().getDimensionPixelSize(i.d.small_icon_width), this.cnX.getResources().getDimensionPixelSize(i.d.small_icon_height), this.cnX.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                }
            }
            a(this.chB, (int) this.cnX.getResources().getDimension(i.d.ds76));
            this.cim.setUserId(oVar.getAuthor().getUserId());
            this.cim.setUserName(oVar.getAuthor().getUserName());
            this.aGS.setTag(i.f.tag_user_id, oVar.getAuthor().getUserId());
            this.aGS.setTag(i.f.tag_user_name, oVar.getAuthor().getUserName());
            this.cim.setDefaultResource(i.e.icon_default_avatar100);
            this.cim.d(portrait, 28, false);
            this.chB.setText(oVar.axu());
            this.cob.setVisibility(8);
            if (!TextUtils.isEmpty(oVar.getBimg_url())) {
                this.chB.setBackgroundDrawable(null);
                this.chB.setTag(oVar.getBimg_url());
                this.chB.setOnClickListener(this.aZI);
                this.chB.setTextViewOnClickListener(this.aZI);
                this.chB.setTextViewCheckSelection(false);
                com.baidu.adp.lib.f.c.hb().a(oVar.getBimg_url(), 19, new ab(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.chB.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.chB.setPadding(0, 0, 0, 0);
                this.chB.setLayoutParams(layoutParams);
                this.chB.setBackgroundDrawable(null);
            }
            if (oVar != null) {
                com.baidu.tieba.pb.view.d.a(oVar.aiq(), this.coc, true, false, false);
            }
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cnU - i);
            this.chB.setMaxImageHeight((int) ((this.cnU - i) * 1.618f));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cnX.getPageContext().getString(i.h.refresh_view_title_text), this.Sj));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.cnX.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.cnY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds140)), dVar, a, false);
        }
        this.cnY.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.cbv.BC();
        com.baidu.tbadk.core.util.an.j(this.mNoDataView, i.c.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.cnX.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gu(int i) {
        a(NoDataViewFactory.d.C(i, i.h.refresh_view_title_text));
    }

    public void jW(String str) {
        a(NoDataViewFactory.d.ag(str, this.cnX.getPageContext().getString(i.h.refresh_view_title_text)));
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.Sj = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.tbadkCore.data.o oVar, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        if (oVar != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = oVar.getAuthor().getUserId();
                boolean z7 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z = true;
                    z2 = false;
                } else {
                    z2 = z7;
                    z = true;
                }
            } else {
                z = false;
                z2 = false;
            }
            if (this.f128com != null && this.f128com.afB() != null && this.f128com.afB().getAuthor() != null && oVar.getAuthor() != null) {
                String userId3 = this.f128com.afB().getAuthor().getUserId();
                String userId4 = oVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = false;
                        z3 = true;
                        z4 = true;
                    } else {
                        z5 = true;
                        z3 = false;
                        z4 = true;
                    }
                    userId = oVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = oVar.axt() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_forbid_user_name, oVar.getAuthor().getUserName());
                        sparseArray.put(i.f.tag_forbid_user_post_id, oVar.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(i.f.tag_forbid_user_name, "");
                        z6 = false;
                    }
                    if (!z4) {
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_del_post_is_self, true);
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(i.f.tag_del_post_id, oVar.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(i.f.tag_del_post_is_self, false);
                        sparseArray.put(i.f.tag_del_post_type, 0);
                        sparseArray.put(i.f.tag_del_post_id, "");
                    }
                    sparseArray.put(i.f.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(i.f.tag_forbid_user_post_id, oVar.getId());
                    if (!z2) {
                        sparseArray.put(i.f.tag_should_manage_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_forbid_user_name, oVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(i.f.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(i.f.tag_display_reply_visible, true);
                        sparseArray.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (oVar.getAuthor() != null) {
                            sparseArray.put(i.f.tag_disable_reply_mute_userid, oVar.getAuthor().getUserId());
                            sparseArray.put(i.f.tag_disable_reply_mute_username, oVar.getAuthor().getUserName());
                        }
                        if (this.f128com.afB() != null) {
                            sparseArray.put(i.f.tag_disable_reply_thread_id, this.f128com.afB().getId());
                        }
                        sparseArray.put(i.f.tag_disable_reply_post_id, oVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_display_reply_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(i.f.tag_should_delete_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(i.f.tag_del_post_id, oVar.getId());
                        return;
                    }
                    sparseArray.put(i.f.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = oVar.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (oVar.axt() != 1) {
            }
            if (!z2) {
            }
            if (!z4) {
            }
            sparseArray.put(i.f.tag_should_manage_visible, Boolean.valueOf(z6));
            sparseArray.put(i.f.tag_forbid_user_post_id, oVar.getId());
            if (!z2) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public View ahN() {
        return this.coe;
    }

    public void onChangeSkinType(int i) {
        this.cnX.getLayoutMode().ad(i == 1);
        this.cnX.getLayoutMode().k(this.cfp);
        this.cnX.getLayoutMode().k(this.cnV);
        this.mNavigationBar.onChangeSkinType(this.cnX.getPageContext(), i);
        this.aRi.onChangeSkinType(this.cnX.getPageContext(), i);
        this.cnX.getLayoutMode().k(this.coe);
        com.baidu.tbadk.core.util.an.c(this.cis, i.e.btn_pb_reply_selector);
        this.chB.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.pb_listitem_content));
        this.chB.setVideoImageId(i.e.pic_video);
        if (this.cbv != null && this.cbv.Az() != null) {
            this.cbv.Az().onChangeSkinType(i);
        }
    }

    public void ahO() {
        this.mProgress.setVisibility(0);
    }

    public void ahP() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.cod.vz();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cof = onLongClickListener;
        this.cnV.setOnLongClickListener(this.cof);
    }

    public View ahQ() {
        return this.cnV;
    }

    public void jX(String str) {
        int jY = this.cnW.jY(str);
        if (jY > -1) {
            this.mListView.setSelection(jY + 1);
            this.mListView.invalidate();
        }
    }

    public View ahR() {
        return this.cnZ;
    }

    public cr ahS() {
        return this.cjt;
    }

    public MorePopupWindow ahT() {
        return this.cjs;
    }

    public HeadImageView ahU() {
        return this.cim;
    }

    public TextView getUserNameView() {
        return this.aGS;
    }

    public UserIconBox ahV() {
        return this.bds;
    }

    public ImageView ahW() {
        return this.cin;
    }

    public UserIconBox ahX() {
        return this.aTq;
    }

    public void Zw() {
        if (this.cmL == null) {
            this.cmL = new com.baidu.tbadk.core.view.a(this.cnX.getPageContext());
        }
        this.cmL.av(true);
    }

    public void ahu() {
        if (this.cmL != null) {
            this.cmL.av(false);
        }
    }

    public TextView ahY() {
        return this.coc;
    }

    public TbRichTextView ahZ() {
        return this.chB;
    }

    public TextView aia() {
        if (this.chB == null) {
            return null;
        }
        return this.chB.getTextView();
    }

    public void setOnLinkImageClickListener(TbRichTextView.e eVar) {
        this.cnL = eVar;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.cnM = dVar;
    }
}
