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
import com.baidu.tbadk.core.util.an;
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
import com.baidu.tieba.pb.pb.main.ca;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t {
    private static final int cmD = TbadkCoreApplication.m411getInst().getListItemRule().wm();
    private NoNetworkView aRa;
    private View.OnClickListener aZw;
    private RelativeLayout ceO;
    private com.baidu.tbadk.core.view.a clx;
    private View cmE;
    private ai cmF;
    private NewSubPbActivity cmG;
    private RelativeLayout cmH;
    private aj cmM;
    private View cmN;
    private ArrayList<com.baidu.tieba.tbadkCore.data.k> cmT;
    private String cmU;
    private com.baidu.tieba.pb.a.c cmV;
    private BdListView mListView;
    private ProgressBar mProgress;
    private com.baidu.tbadk.core.view.m mNoDataView = null;
    private View.OnClickListener Si = null;
    private NavigationBar mNavigationBar = null;
    private TextView cmI = null;
    private TextView WO = null;
    private HeadImageView chj = null;
    private TextView aHY = null;
    private ImageView chk = null;
    private ImageView chl = null;
    private TextView cmJ = null;
    private ImageView chn = null;
    private TextView bpL = null;
    private TbRichTextView chp = null;
    private ImageView cho = null;
    private TextView cmK = null;
    private TextView cmL = null;
    private MorePopupWindow ciq = null;
    private ca cir = null;
    private com.baidu.tbadk.core.dialog.c clj = null;
    private UserIconBox bcN = null;
    private UserIconBox aTi = null;
    private Dialog ckQ = null;
    private com.baidu.tbadk.core.dialog.a ckS = null;
    private boolean cgK = true;
    private boolean cgL = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cmO = null;
    private NewSubPbActivity.a cmP = null;
    private NewSubPbActivity.a cmQ = null;
    private ArrayList<IconData> cgQ = null;
    private ArrayList<IconData> aSQ = null;
    private com.baidu.tbadk.editortools.c.n caU = null;
    private String cmR = null;
    private int cmS = 0;
    private View.OnClickListener cgR = new u(this);
    private com.baidu.tieba.pb.b.c cgS = new com.baidu.tieba.pb.b.c(new aa(this));
    protected AdapterView.OnItemClickListener cmW = new ab(this);
    protected AdapterView.OnItemLongClickListener Hy = new ac(this);

    public t(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.ceO = null;
        this.cmE = null;
        this.mListView = null;
        this.cmF = null;
        this.cmG = null;
        this.aRa = null;
        this.cmH = null;
        this.cmM = null;
        this.cmN = null;
        this.aZw = null;
        this.mProgress = null;
        this.cmG = newSubPbActivity;
        this.aZw = onClickListener;
        this.ceO = (RelativeLayout) LayoutInflater.from(this.cmG.getPageContext().getPageActivity()).inflate(i.g.new_sub_pb_layout, (ViewGroup) null);
        this.cmE = LayoutInflater.from(this.cmG.getPageContext().getPageActivity()).inflate(i.g.new_sub_pb_head, (ViewGroup) null);
        this.aRa = (NoNetworkView) this.ceO.findViewById(i.f.view_no_network);
        ahh();
        HD();
        this.cmH = (RelativeLayout) this.ceO.findViewById(i.f.sub_pb_body_layout);
        this.mListView = (BdListView) this.ceO.findViewById(i.f.new_sub_pb_list);
        this.mListView.addHeaderView(this.cmE);
        this.cmF = new ai(this.cmG.getPageContext().getPageActivity());
        this.cmF.D(this.cgR);
        this.cmF.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.cmF);
        this.cmM = new aj(this.cmG.getPageContext());
        this.cmN = this.cmM.getView();
        this.mListView.setNextPage(this.cmM);
        this.cmM.setOnClickListener(this.aZw);
        this.mListView.setOnItemClickListener(this.cmW);
        this.mListView.setOnItemLongClickListener(this.Hy);
        this.mListView.setOnTouchListener(this.cgS);
        this.mProgress = (ProgressBar) this.ceO.findViewById(i.f.progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.cmE != null) {
            this.cmE.setVisibility(4);
        }
        if (this.cmH != null) {
            this.cmH.setVisibility(4);
        }
    }

    public void HD() {
        this.chj = (HeadImageView) this.cmE.findViewById(i.f.photo);
        this.chj.setOnClickListener(this.aZw);
        this.aHY = (TextView) this.cmE.findViewById(i.f.user_name);
        this.chk = (ImageView) this.cmE.findViewById(i.f.user_rank);
        this.chl = (ImageView) this.cmE.findViewById(i.f.user_gender);
        this.cho = (ImageView) this.cmE.findViewById(i.f.reply);
        this.cmK = (TextView) this.cmE.findViewById(i.f.manage_btn);
        this.cmJ = (TextView) this.cmE.findViewById(i.f.floor);
        this.chn = (ImageView) this.cmE.findViewById(i.f.floor_owner);
        this.bpL = (TextView) this.cmE.findViewById(i.f.time);
        this.bcN = (UserIconBox) this.cmE.findViewById(i.f.user_icon_box);
        this.aTi = (UserIconBox) this.cmE.findViewById(i.f.user_tshow_icon_box);
        this.chp = (TbRichTextView) this.cmE.findViewById(i.f.richText);
        this.chp.Fq();
        this.chp.f(this.cgK, true);
        this.chp.setIsFromCDN(this.mIsFromCDN);
        this.chp.setImageViewStretch(true);
        this.chp.setTextSize(TbConfig.getContentSize());
        this.chp.setVoiceViewRes(i.g.voice_play_btn);
        this.cmE.setOnTouchListener(this.cgS);
        this.cmE.setOnClickListener(this.aZw);
        this.cmL = (TextView) this.cmE.findViewById(i.f.pb_item_tail_content);
        this.cmL.setOnClickListener(this.aZw);
    }

    public void ahh() {
        this.mNavigationBar = (NavigationBar) this.ceO.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.WO = this.mNavigationBar.setTitleText("");
        this.cmI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cmG.getResources().getString(i.h.view_subject), this.aZw);
        this.cmI.setVisibility(8);
    }

    public void afl() {
        this.cir = new ca(this.cmG.getPageContext(), this.aZw);
        this.cir.eD(TbadkCoreApplication.isLogin());
        this.ciq = new MorePopupWindow(this.cmG.getPageContext().getPageActivity(), this.cir.getView(), this.cmG.getResources().getDrawable(i.e.bg_collect), null);
        this.ciq.setTouchInterceptor(new ad(this));
        this.ciq.onChangeSkinType(this.cmG, TbadkCoreApplication.m411getInst().getSkinType(), an.getDrawable(i.e.bg_collect));
    }

    public void ac(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.ckQ == null) {
            this.ckQ = new Dialog(this.cmG.getPageContext().getPageActivity(), i.C0057i.common_alert_dialog);
            this.ckQ.setCanceledOnTouchOutside(true);
            this.ckQ.setCancelable(true);
            View inflate = LayoutInflater.from(this.cmG.getPageContext().getPageActivity()).inflate(i.g.forum_manage_dialog, (ViewGroup) null);
            this.cmG.getLayoutMode().k(inflate);
            this.ckQ.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ckQ.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cmG.getPageContext().getPageActivity()) * 0.9d);
            this.ckQ.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ckQ.findViewById(i.f.del_post_btn);
        TextView textView2 = (TextView) this.ckQ.findViewById(i.f.forbid_user_btn);
        TextView textView3 = (TextView) this.ckQ.findViewById(i.f.disable_reply_btn);
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
            textView.setOnClickListener(new ae(this));
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
            textView2.setOnClickListener(new af(this));
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
            textView3.setOnClickListener(new ag(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.ckQ, this.cmG.getPageContext());
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
        this.ckS = new com.baidu.tbadk.core.dialog.a(this.cmG.getPageContext().getPageActivity());
        this.ckS.bF(i3);
        this.ckS.x(sparseArray);
        this.ckS.a(i.h.dialog_ok, new ah(this, sparseArray));
        this.ckS.b(i.h.dialog_cancel, new v(this));
        this.ckS.aj(true);
        this.ckS.b(this.cmG.getPageContext());
        this.ckS.sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new w(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.clj != null) {
            this.clj.dismiss();
            this.clj = null;
        }
        if (z) {
            string = this.cmG.getResources().getString(i.h.remove_mark);
        } else {
            string = this.cmG.getResources().getString(i.h.mark);
        }
        this.clj = new com.baidu.tbadk.core.dialog.c(this.cmG.getPageContext().getPageActivity());
        this.clj.bI(i.h.operation);
        this.clj.a(new String[]{this.cmG.getResources().getString(i.h.copy), string}, bVar);
        this.clj.d(this.cmG.getPageContext());
        this.clj.sU();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.cmP = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.cmQ = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.cmG.showToast(this.cmG.getResources().getString(i.h.success));
        } else if (str != null && z2) {
            this.cmG.showToast(str);
        }
    }

    public void ab(View view) {
        if (this.mNavigationBar.getVisibility() == 0) {
            this.mNavigationBar.setVisibility(8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                bd.a((View) this.ceO, i.c.cp_link_tip_b, true);
                return;
            }
            return;
        }
        this.mNavigationBar.setVisibility(0);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bd.r(this.ceO);
        }
    }

    public void e(com.baidu.tbadk.editortools.c.n nVar) {
        if (nVar != null && nVar.Ax() != null) {
            this.caU = nVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ceO.addView(nVar.Ax(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i, View view) {
        new Handler().postDelayed(new x(this, view, i), 300L);
    }

    public void eq(boolean z) {
        this.cgL = z;
        this.cmF.eq(z);
    }

    public void iW(int i) {
        this.chp.setMaxImageWidth(i);
        this.chp.setMaxImageHeight((int) (i * 1.618f));
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.ceO;
    }

    public void aY(String str, String str2) {
        this.cmU = str2;
        new Handler().postDelayed(new y(this, str2, str), 200L);
    }

    public void agM() {
        if (this.ciq != null) {
            com.baidu.adp.lib.g.j.a(this.ciq, this.cmG.getPageContext().getPageActivity());
        }
        if (this.clj != null) {
            this.clj.dismiss();
        }
        if (this.ckS != null) {
            this.ckS.dismiss();
        }
        if (this.ckQ != null) {
            com.baidu.adp.lib.g.j.b(this.ckQ, this.cmG.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void ahi() {
        this.mListView.setNextPage(this.cmM);
        this.cmM.startLoadData();
    }

    public void ep(boolean z) {
        this.cgK = z;
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z = false;
        if (cVar != null) {
            this.cmV = cVar;
            this.cmF.e(this.cmV.afi());
            if (this.cmE != null) {
                this.cmE.setVisibility(0);
            }
            if (this.cmH != null) {
                this.cmH.setVisibility(0);
            }
            if (cVar.aeZ() != null) {
                this.cmR = cVar.aeZ().getId();
                this.cmS = cVar.aeZ().awI();
                if (this.cmS > 0) {
                    this.WO.setText(String.format(this.cmG.getPageContext().getString(i.h.is_floor), Integer.valueOf(this.cmS)));
                } else {
                    this.WO.setText((CharSequence) null);
                }
            }
            if (cVar.hasMore()) {
                this.cmM.startLoadData();
                this.cmF.setHasMoreData(true);
            } else {
                this.cmM.vy();
                this.cmF.setHasMoreData(false);
            }
            this.cmT = cVar.afd();
            if (this.cmT == null || this.cmT.size() == 0) {
                this.mListView.setNextPage(null);
            } else {
                this.mListView.setNextPage(this.cmM);
            }
            if (this.cmT == null || this.cmT.size() <= cmD) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.cmT.size() - cmD;
                iX(i4);
                i3 = this.mListView.getFirstVisiblePosition() - i4;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
            }
            this.cmF.setDatas(this.cmT);
            if (cVar.afi() != null && cVar.afi().getAuthor() != null && (userId = cVar.afi().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            this.cmF.p(i, z);
            this.cmF.notifyDataSetChanged();
            a(cVar.aeZ(), cVar.WK(), cVar.qk(), i);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View ahj() {
        return this.cho;
    }

    private void iX(int i) {
        if (this.cmT != null) {
            if (this.cmT.size() <= i) {
                this.cmT.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.k> it = this.cmT.iterator();
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

    public boolean ahk() {
        return this.cmF.cne;
    }

    protected void a(com.baidu.tieba.tbadkCore.data.k kVar, boolean z, boolean z2, int i) {
        int i2;
        if (kVar != null) {
            this.chj.setTag(null);
            this.chj.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.cmE.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.cmE.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(i.f.tag_clip_board, kVar);
            sparseArray.put(i.f.tag_is_subpb, false);
            a(kVar, i, sparseArray);
            this.cho.setTag(sparseArray);
            if (!this.cgL) {
                this.chj.setVisibility(8);
            }
            this.aHY.setOnClickListener(this.aZw);
            this.aHY.setText((CharSequence) null);
            this.chn.setVisibility(8);
            this.cmJ.setText((CharSequence) null);
            this.cho.setOnClickListener(this.aZw);
            an.b(this.bpL, i.c.pb_listitem_post_time, 1);
            this.bpL.setText(as.o(kVar.getTime()));
            if (z) {
                this.chn.setVisibility(0);
                an.c(this.chn, i.e.icon_floorhost);
            }
            if (this.cgK) {
                i2 = i.e.img_default_100;
            } else {
                i2 = i.e.icon_click;
            }
            this.chp.setDefaultImageId(i2);
            this.cmJ.setText(String.format(this.cmG.getPageContext().getString(i.h.is_floor), Integer.valueOf(kVar.awI())));
            String portrait = kVar.getAuthor().getPortrait();
            if (kVar.getAuthor() != null) {
                String name_show = kVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.n.fO(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.n.e(name_show, 0, 14)) + "...";
                }
                this.aHY.setText(name_show);
                ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    an.b(this.aHY, i.c.cp_cont_h, 1);
                } else {
                    an.b(this.aHY, i.c.cp_cont_f, 1);
                }
                int level_id = kVar.getAuthor().getLevel_id();
                int is_bawu = kVar.getAuthor().getIs_bawu();
                String bawu_type = kVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    this.chk.setVisibility(0);
                    an.c(this.chk, com.baidu.tbadk.core.util.c.ci(level_id));
                    this.chk.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.chk.setVisibility(8);
                }
                if (is_bawu != 0) {
                    this.chk.setOnClickListener(this.aZw);
                    if (bawu_type.equals("manager")) {
                        an.c(this.chk, i.e.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        an.c(this.chk, i.e.pb_assist);
                    }
                }
                if (kVar.getAuthor().getGender() == 2) {
                    an.c(this.chl, i.e.icon_pb_pop_girl);
                    this.chl.setVisibility(0);
                } else if (kVar.getAuthor().getGender() == 1) {
                    an.c(this.chl, i.e.icon_pb_pop_boy);
                    this.chl.setVisibility(0);
                } else {
                    this.chl.setVisibility(8);
                }
                this.cgQ = kVar.getAuthor().getIconInfo();
                this.aSQ = kVar.getAuthor().getTShowInfo();
                if (this.bcN != null) {
                    this.bcN.setOnClickListener(this.aZw);
                    this.bcN.a(this.cgQ, i3, this.cmG.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.cmG.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.cmG.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                }
                if (this.aTi != null) {
                    this.aTi.setOnClickListener(this.aZw);
                    this.aTi.a(this.aSQ, 2, this.cmG.getResources().getDimensionPixelSize(i.d.small_icon_width), this.cmG.getResources().getDimensionPixelSize(i.d.small_icon_height), this.cmG.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                }
            }
            this.chj.setUserId(kVar.getAuthor().getUserId());
            this.chj.setUserName(kVar.getAuthor().getUserName());
            this.aHY.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
            this.aHY.setTag(i.f.tag_user_name, kVar.getAuthor().getUserName());
            this.chj.setDefaultResource(i.e.icon_default_avatar100);
            this.chj.d(portrait, 28, false);
            this.chp.setText(kVar.awJ());
            this.cmK.setVisibility(8);
            if (!TextUtils.isEmpty(kVar.getBimg_url())) {
                this.chp.setBackgroundDrawable(null);
                this.chp.setTag(kVar.getBimg_url());
                this.chp.setOnClickListener(this.aZw);
                this.chp.setTextViewOnClickListener(this.aZw);
                this.chp.setTextViewCheckSelection(false);
                com.baidu.adp.lib.f.c.ha().a(kVar.getBimg_url(), 19, new z(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.chp.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.chp.setPadding(0, 0, 0, 0);
                this.chp.setLayoutParams(layoutParams);
                this.chp.setBackgroundDrawable(null);
            }
            if (kVar != null) {
                com.baidu.tieba.pb.view.d.a(kVar.ahO(), this.cmL, true, false, false);
            }
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cmG.getPageContext().getString(i.h.refresh_view_title_text), this.Si));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.cmG.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.cmH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds140)), dVar, a, false);
        }
        this.cmH.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.caU.BM();
        an.j(this.mNoDataView, i.c.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.cmG.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gh(int i) {
        a(NoDataViewFactory.d.C(i, i.h.refresh_view_title_text));
    }

    public void jT(String str) {
        a(NoDataViewFactory.d.ag(str, this.cmG.getPageContext().getString(i.h.refresh_view_title_text)));
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.Si = onClickListener;
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
    public void a(com.baidu.tieba.tbadkCore.data.k kVar, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        if (kVar != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = kVar.getAuthor().getUserId();
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
            if (this.cmV != null && this.cmV.afi() != null && this.cmV.afi().getAuthor() != null && kVar.getAuthor() != null) {
                String userId3 = this.cmV.afi().getAuthor().getUserId();
                String userId4 = kVar.getAuthor().getUserId();
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
                    userId = kVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = kVar.awI() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_forbid_user_name, kVar.getAuthor().getUserName());
                        sparseArray.put(i.f.tag_forbid_user_post_id, kVar.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(i.f.tag_forbid_user_name, "");
                        z6 = false;
                    }
                    if (!z4) {
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_del_post_is_self, true);
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(i.f.tag_del_post_id, kVar.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(i.f.tag_del_post_is_self, false);
                        sparseArray.put(i.f.tag_del_post_type, 0);
                        sparseArray.put(i.f.tag_del_post_id, "");
                    }
                    sparseArray.put(i.f.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(i.f.tag_forbid_user_post_id, kVar.getId());
                    if (!z2) {
                        sparseArray.put(i.f.tag_should_manage_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_forbid_user_name, kVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(i.f.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(i.f.tag_display_reply_visible, true);
                        sparseArray.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (kVar.getAuthor() != null) {
                            sparseArray.put(i.f.tag_disable_reply_mute_userid, kVar.getAuthor().getUserId());
                            sparseArray.put(i.f.tag_disable_reply_mute_username, kVar.getAuthor().getUserName());
                        }
                        if (this.cmV.afi() != null) {
                            sparseArray.put(i.f.tag_disable_reply_thread_id, this.cmV.afi().getId());
                        }
                        sparseArray.put(i.f.tag_disable_reply_post_id, kVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_display_reply_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(i.f.tag_should_delete_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(i.f.tag_del_post_id, kVar.getId());
                        return;
                    }
                    sparseArray.put(i.f.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = kVar.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (kVar.awI() != 1) {
            }
            if (!z2) {
            }
            if (!z4) {
            }
            sparseArray.put(i.f.tag_should_manage_visible, Boolean.valueOf(z6));
            sparseArray.put(i.f.tag_forbid_user_post_id, kVar.getId());
            if (!z2) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public View ahl() {
        return this.cmN;
    }

    public void onChangeSkinType(int i) {
        this.cmG.getLayoutMode().ad(i == 1);
        this.cmG.getLayoutMode().k(this.ceO);
        this.cmG.getLayoutMode().k(this.cmE);
        this.mNavigationBar.onChangeSkinType(this.cmG.getPageContext(), i);
        this.aRa.onChangeSkinType(this.cmG.getPageContext(), i);
        this.cmG.getLayoutMode().k(this.cmN);
        an.c(this.cho, i.e.btn_pb_reply_selector);
        this.chp.setTextColor(an.getColor(i.c.pb_listitem_content));
        this.chp.setVideoImageId(i.e.pic_video);
        if (this.caU != null && this.caU.Ax() != null) {
            this.caU.Ax().onChangeSkinType(i);
        }
    }

    public void ahm() {
        this.mProgress.setVisibility(0);
    }

    public void ahn() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.cmM.vy();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmO = onLongClickListener;
        this.cmE.setOnLongClickListener(this.cmO);
    }

    public View aho() {
        return this.cmE;
    }

    public void jU(String str) {
        int jV = this.cmF.jV(str);
        if (jV > -1) {
            this.mListView.setSelection(jV + 1);
            this.mListView.invalidate();
        }
    }

    public View ahp() {
        return this.cmI;
    }

    public ca ahq() {
        return this.cir;
    }

    public MorePopupWindow ahr() {
        return this.ciq;
    }

    public HeadImageView ahs() {
        return this.chj;
    }

    public TextView getUserNameView() {
        return this.aHY;
    }

    public UserIconBox aht() {
        return this.bcN;
    }

    public ImageView ahu() {
        return this.chk;
    }

    public UserIconBox ahv() {
        return this.aTi;
    }

    public void Zf() {
        if (this.clx == null) {
            this.clx = new com.baidu.tbadk.core.view.a(this.cmG.getPageContext());
        }
        this.clx.av(true);
    }

    public void agS() {
        if (this.clx != null) {
            this.clx.av(false);
        }
    }

    public TextView ahw() {
        return this.cmL;
    }

    public TbRichTextView ahx() {
        return this.chp;
    }

    public TextView ahy() {
        if (this.chp == null) {
            return null;
        }
        return this.chp.getTextView();
    }
}
