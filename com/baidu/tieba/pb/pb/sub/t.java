package com.baidu.tieba.pb.pb.sub;

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.bz;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t {
    private static final int cfZ = TbadkCoreApplication.m411getInst().getListItemRule().ww();
    private NoNetworkView aRF;
    private View.OnClickListener aZc;
    private RelativeLayout bYB;
    private com.baidu.tbadk.core.view.a ceW;
    private View cga;
    private ai cgb;
    private NewSubPbActivity cgc;
    private RelativeLayout cgd;
    private aj cgh;
    private View cgi;
    private ArrayList<com.baidu.tieba.tbadkCore.data.i> cgo;
    private String cgp;
    private com.baidu.tieba.pb.a.c cgq;
    private com.baidu.tieba.pb.view.d cgr;
    private BdListView mListView;
    private ProgressBar mProgress;
    private com.baidu.tbadk.core.view.u mNoDataView = null;
    private View.OnClickListener Sy = null;
    private NavigationBar mNavigationBar = null;
    private TextView cge = null;
    private TextView WL = null;
    private HeadImageView ccV = null;
    private TextView aII = null;
    private ImageView ccW = null;
    private ImageView ccX = null;
    private TextView cgf = null;
    private ImageView cda = null;
    private TextView ccZ = null;
    private TbRichTextView cdc = null;
    private ImageView cdb = null;
    private TextView cgg = null;
    private MorePopupWindow caU = null;
    private bz caV = null;
    private com.baidu.tbadk.core.dialog.c ceI = null;
    private UserIconBox bco = null;
    private UserIconBox aTN = null;
    private Dialog cep = null;
    private com.baidu.tbadk.core.dialog.a cer = null;
    private boolean cbE = true;
    private boolean cbF = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cgj = null;
    private NewSubPbActivity.a cgk = null;
    private NewSubPbActivity.a cgl = null;
    private ArrayList<IconData> ccE = null;
    private ArrayList<IconData> aTv = null;
    private com.baidu.tbadk.editortools.c.n bWp = null;
    private String cgm = null;
    private int cgn = 0;
    private View.OnClickListener cbJ = new u(this);
    private com.baidu.tieba.pb.b.c cbb = new com.baidu.tieba.pb.b.c(new aa(this));
    protected AdapterView.OnItemClickListener cgs = new ab(this);
    protected AdapterView.OnItemLongClickListener Hx = new ac(this);

    public t(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.bYB = null;
        this.cga = null;
        this.mListView = null;
        this.cgb = null;
        this.cgc = null;
        this.aRF = null;
        this.cgd = null;
        this.cgh = null;
        this.cgi = null;
        this.aZc = null;
        this.mProgress = null;
        this.cgc = newSubPbActivity;
        this.aZc = onClickListener;
        this.bYB = (RelativeLayout) LayoutInflater.from(this.cgc.getPageContext().getPageActivity()).inflate(i.g.new_sub_pb_layout, (ViewGroup) null);
        this.cga = LayoutInflater.from(this.cgc.getPageContext().getPageActivity()).inflate(i.g.new_sub_pb_head, (ViewGroup) null);
        this.aRF = (NoNetworkView) this.bYB.findViewById(i.f.view_no_network);
        aeW();
        HV();
        this.cgd = (RelativeLayout) this.bYB.findViewById(i.f.sub_pb_body_layout);
        this.mListView = (BdListView) this.bYB.findViewById(i.f.new_sub_pb_list);
        this.mListView.addHeaderView(this.cga);
        this.cgb = new ai(this.cgc.getPageContext().getPageActivity());
        this.cgb.D(this.cbJ);
        this.cgb.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.cgb);
        this.cgh = new aj(this.cgc.getPageContext());
        this.cgi = this.cgh.getView();
        this.mListView.setNextPage(this.cgh);
        this.cgh.setOnClickListener(this.aZc);
        this.mListView.setOnItemClickListener(this.cgs);
        this.mListView.setOnItemLongClickListener(this.Hx);
        this.mListView.setOnTouchListener(this.cbb);
        this.mProgress = (ProgressBar) this.bYB.findViewById(i.f.progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.cga != null) {
            this.cga.setVisibility(4);
        }
        if (this.cgd != null) {
            this.cgd.setVisibility(4);
        }
    }

    public void HV() {
        this.ccV = (HeadImageView) this.cga.findViewById(i.f.photo);
        this.ccV.setOnClickListener(this.aZc);
        this.aII = (TextView) this.cga.findViewById(i.f.user_name);
        this.ccW = (ImageView) this.cga.findViewById(i.f.user_rank);
        this.ccX = (ImageView) this.cga.findViewById(i.f.user_gender);
        this.cdb = (ImageView) this.cga.findViewById(i.f.reply);
        this.cgg = (TextView) this.cga.findViewById(i.f.manage_btn);
        this.cgf = (TextView) this.cga.findViewById(i.f.floor);
        this.cda = (ImageView) this.cga.findViewById(i.f.floor_owner);
        this.ccZ = (TextView) this.cga.findViewById(i.f.time);
        this.bco = (UserIconBox) this.cga.findViewById(i.f.user_icon_box);
        this.aTN = (UserIconBox) this.cga.findViewById(i.f.user_tshow_icon_box);
        this.cdc = (TbRichTextView) this.cga.findViewById(i.f.richText);
        this.cdc.Fs();
        this.cdc.f(this.cbE, true);
        this.cdc.setIsFromCDN(this.mIsFromCDN);
        this.cdc.setImageViewStretch(true);
        this.cdc.setTextSize(TbConfig.getContentSize());
        this.cdc.setVoiceViewRes(i.g.voice_play_btn);
        this.cga.setOnTouchListener(this.cbb);
        this.cga.setOnClickListener(this.aZc);
        this.cgr = new com.baidu.tieba.pb.view.d((TextView) this.cga.findViewById(i.f.pb_item_tail_content), true, false, false);
    }

    public void aeW() {
        this.mNavigationBar = (NavigationBar) this.bYB.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.WL = this.mNavigationBar.setTitleText("");
        this.cge = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cgc.getResources().getString(i.C0057i.view_subject), this.aZc);
        this.cge.setVisibility(8);
    }

    public void ada() {
        this.caV = new bz(this.cgc.getPageContext(), this.aZc);
        this.caV.eq(TbadkCoreApplication.isLogin());
        this.caU = new MorePopupWindow(this.cgc.getPageContext().getPageActivity(), this.caV.getView(), this.cgc.getResources().getDrawable(i.e.bg_collect), null);
        this.caU.setTouchInterceptor(new ad(this));
        this.caU.onChangeSkinType(this.cgc, TbadkCoreApplication.m411getInst().getSkinType(), com.baidu.tbadk.core.util.al.getDrawable(i.e.bg_collect));
    }

    public void aa(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.cep == null) {
            this.cep = new Dialog(this.cgc.getPageContext().getPageActivity(), i.j.common_alert_dialog);
            this.cep.setCanceledOnTouchOutside(true);
            this.cep.setCancelable(true);
            View inflate = LayoutInflater.from(this.cgc.getPageContext().getPageActivity()).inflate(i.g.forum_manage_dialog, (ViewGroup) null);
            this.cgc.getLayoutMode().k(inflate);
            this.cep.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cep.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cgc.getPageContext().getPageActivity()) * 0.9d);
            this.cep.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.cep.findViewById(i.f.del_post_btn);
        TextView textView2 = (TextView) this.cep.findViewById(i.f.forbid_user_btn);
        TextView textView3 = (TextView) this.cep.findViewById(i.f.disable_reply_btn);
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
                textView3.setText(i.C0057i.un_mute);
            } else {
                textView3.setText(i.C0057i.mute);
            }
            sparseArray4.put(i.f.tag_is_mem, sparseArray.get(i.f.tag_is_mem));
            sparseArray4.put(i.f.tag_disable_reply_mute_userid, sparseArray.get(i.f.tag_disable_reply_mute_userid));
            sparseArray4.put(i.f.tag_disable_reply_mute_username, sparseArray.get(i.f.tag_disable_reply_mute_username));
            sparseArray4.put(i.f.tag_disable_reply_post_id, sparseArray.get(i.f.tag_disable_reply_post_id));
            sparseArray4.put(i.f.tag_disable_reply_thread_id, sparseArray.get(i.f.tag_disable_reply_thread_id));
            textView3.setOnClickListener(new ag(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.cep, this.cgc.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(i.f.tag_del_post_id, str);
        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = i.C0057i.del_post_confirm;
        if (i == 0) {
            i3 = i.C0057i.del_thread_confirm;
        }
        this.cer = new com.baidu.tbadk.core.dialog.a(this.cgc.getPageContext().getPageActivity());
        this.cer.bC(i3);
        this.cer.w(sparseArray);
        this.cer.a(i.C0057i.dialog_ok, new ah(this, sparseArray));
        this.cer.b(i.C0057i.dialog_cancel, new v(this));
        this.cer.aj(true);
        this.cer.b(this.cgc.getPageContext());
        this.cer.sP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(boolean z) {
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
        if (this.ceI != null) {
            this.ceI.dismiss();
            this.ceI = null;
        }
        if (z) {
            string = this.cgc.getResources().getString(i.C0057i.remove_mark);
        } else {
            string = this.cgc.getResources().getString(i.C0057i.mark);
        }
        this.ceI = new com.baidu.tbadk.core.dialog.c(this.cgc.getPageContext().getPageActivity());
        this.ceI.bF(i.C0057i.operation);
        this.ceI.a(new String[]{this.cgc.getResources().getString(i.C0057i.copy), string}, bVar);
        this.ceI.d(this.cgc.getPageContext());
        this.ceI.sS();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.cgk = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.cgl = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.cgc.showToast(this.cgc.getResources().getString(i.C0057i.success));
        } else if (str != null && z2) {
            this.cgc.showToast(str);
        }
    }

    public void Z(View view) {
        if (this.mNavigationBar.getVisibility() == 0) {
            this.mNavigationBar.setVisibility(8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                bb.a((View) this.bYB, i.c.cp_link_tip_b, true);
                return;
            }
            return;
        }
        this.mNavigationBar.setVisibility(0);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bb.r(this.bYB);
        }
    }

    public void e(com.baidu.tbadk.editortools.c.n nVar) {
        if (nVar != null && nVar.Ay() != null) {
            this.bWp = nVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bYB.addView(nVar.Ay(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i, View view) {
        new Handler().postDelayed(new x(this, view, i), 300L);
    }

    public void ei(boolean z) {
        this.cbF = z;
        this.cgb.ei(z);
    }

    public void iA(int i) {
        this.cdc.setMaxImageWidth(i);
        this.cdc.setMaxImageHeight((int) (i * 1.618f));
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.bYB;
    }

    public void aV(String str, String str2) {
        this.cgp = str2;
        new Handler().postDelayed(new y(this, str2, str), 200L);
    }

    public void aeA() {
        if (this.caU != null) {
            com.baidu.adp.lib.g.j.a(this.caU, this.cgc.getPageContext().getPageActivity());
        }
        if (this.ceI != null) {
            this.ceI.dismiss();
        }
        if (this.cer != null) {
            this.cer.dismiss();
        }
        if (this.cep != null) {
            com.baidu.adp.lib.g.j.b(this.cep, this.cgc.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void aeX() {
        this.mListView.setNextPage(this.cgh);
        this.cgh.startLoadData();
    }

    public void eh(boolean z) {
        this.cbE = z;
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z = false;
        if (cVar != null) {
            this.cgq = cVar;
            this.cgb.d(this.cgq.acX());
            if (this.cga != null) {
                this.cga.setVisibility(0);
            }
            if (this.cgd != null) {
                this.cgd.setVisibility(0);
            }
            if (cVar.acQ() != null) {
                this.cgm = cVar.acQ().getId();
                this.cgn = cVar.acQ().apV();
                if (this.cgn > 0) {
                    this.WL.setText(String.format(this.cgc.getPageContext().getString(i.C0057i.is_floor), Integer.valueOf(this.cgn)));
                } else {
                    this.WL.setText((CharSequence) null);
                }
            }
            if (cVar.hasMore()) {
                this.cgh.startLoadData();
                this.cgb.setHasMoreData(true);
            } else {
                this.cgh.vB();
                this.cgb.setHasMoreData(false);
            }
            this.cgo = cVar.acS();
            if (this.cgo == null || this.cgo.size() == 0) {
                this.mListView.setNextPage(null);
            } else {
                this.mListView.setNextPage(this.cgh);
            }
            if (this.cgo == null || this.cgo.size() <= cfZ) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.cgo.size() - cfZ;
                iB(i4);
                i3 = this.mListView.getFirstVisiblePosition() - i4;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
            }
            this.cgb.setDatas(this.cgo);
            if (cVar.acX() != null && cVar.acX().getAuthor() != null && (userId = cVar.acX().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            this.cgb.n(i, z);
            this.cgb.notifyDataSetChanged();
            a(cVar.acQ(), cVar.VZ(), cVar.qr(), i);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View aeY() {
        return this.cdb;
    }

    private void iB(int i) {
        if (this.cgo != null) {
            if (this.cgo.size() <= i) {
                this.cgo.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.i> it = this.cgo.iterator();
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

    public boolean aeZ() {
        return this.cgb.cgA;
    }

    protected void a(com.baidu.tieba.tbadkCore.data.i iVar, boolean z, boolean z2, int i) {
        int i2;
        if (iVar != null) {
            this.ccV.setTag(null);
            this.ccV.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.cga.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.cga.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(i.f.tag_clip_board, iVar);
            sparseArray.put(i.f.tag_is_subpb, false);
            a(iVar, i, sparseArray);
            this.cdb.setTag(sparseArray);
            if (!this.cbF) {
                this.ccV.setVisibility(8);
            }
            this.aII.setOnClickListener(this.aZc);
            this.aII.setText((CharSequence) null);
            this.cda.setVisibility(8);
            this.cgf.setText((CharSequence) null);
            this.cdb.setOnClickListener(this.aZc);
            com.baidu.tbadk.core.util.al.b(this.ccZ, i.c.pb_listitem_post_time, 1);
            this.ccZ.setText(aq.m(iVar.getTime()));
            if (z) {
                this.cda.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(this.cda, i.e.icon_floorhost);
            }
            if (this.cbE) {
                i2 = i.e.img_default_100;
            } else {
                i2 = i.e.icon_click;
            }
            this.cdc.setDefaultImageId(i2);
            this.cgf.setText(String.format(this.cgc.getPageContext().getString(i.C0057i.is_floor), Integer.valueOf(iVar.apV())));
            String portrait = iVar.getAuthor().getPortrait();
            if (iVar.getAuthor() != null) {
                this.aII.setText(iVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfo = iVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.al.b(this.aII, i.c.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.b(this.aII, i.c.cp_cont_f, 1);
                }
                int level_id = iVar.getAuthor().getLevel_id();
                int is_bawu = iVar.getAuthor().getIs_bawu();
                String bawu_type = iVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    this.ccW.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.ccW, com.baidu.tbadk.core.util.c.cc(level_id));
                    this.ccW.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.ccW.setVisibility(8);
                }
                if (is_bawu != 0) {
                    this.ccW.setOnClickListener(this.aZc);
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.al.c(this.ccW, i.e.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.al.c(this.ccW, i.e.pb_assist);
                    }
                }
                if (iVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.al.c(this.ccX, i.e.icon_pop_girl_square);
                    this.ccX.setVisibility(0);
                } else {
                    this.ccX.setVisibility(8);
                }
                this.ccE = iVar.getAuthor().getIconInfo();
                this.aTv = iVar.getAuthor().getTShowInfo();
                if (this.bco != null) {
                    this.bco.setOnClickListener(this.aZc);
                    this.bco.a(this.ccE, i3, this.cgc.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.cgc.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.cgc.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                }
                if (this.aTN != null) {
                    this.aTN.setOnClickListener(this.aZc);
                    this.aTN.a(this.aTv, 2, this.cgc.getResources().getDimensionPixelSize(i.d.big_icon_width), this.cgc.getResources().getDimensionPixelSize(i.d.big_icon_height), this.cgc.getResources().getDimensionPixelSize(i.d.big_icon_margin), true);
                }
            }
            this.ccV.setUserId(iVar.getAuthor().getUserId());
            this.ccV.setUserName(iVar.getAuthor().getUserName());
            this.aII.setTag(i.f.tag_user_id, iVar.getAuthor().getUserId());
            this.aII.setTag(i.f.tag_user_name, iVar.getAuthor().getUserName());
            this.ccV.setDefaultResource(i.e.icon_default_avatar100);
            this.ccV.d(portrait, 28, false);
            this.cdc.setText(iVar.apW());
            this.cgg.setVisibility(8);
            if (!TextUtils.isEmpty(iVar.getBimg_url())) {
                this.cdc.setBackgroundDrawable(null);
                this.cdc.setTag(iVar.getBimg_url());
                this.cdc.setOnClickListener(this.aZc);
                this.cdc.setTextViewOnClickListener(this.aZc);
                this.cdc.setTextViewCheckSelection(false);
                com.baidu.adp.lib.f.c.hc().a(iVar.getBimg_url(), 19, new z(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cdc.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.cdc.setPadding(0, 0, 0, 0);
                this.cdc.setLayoutParams(layoutParams);
                this.cdc.setBackgroundDrawable(null);
            }
            if (this.cgr != null && iVar != null) {
                this.cgr.a(iVar.afz());
            }
        }
    }

    public void fT(int i) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cgc.getPageContext().getString(i.C0057i.refresh_view_title_text), this.Sy));
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cgc.getPageContext().getPageActivity(), this.cgd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 140), NoDataViewFactory.d.cD(i), a, false);
            this.mNoDataView.setOnClickListener(this.Sy);
        }
        this.cgd.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i));
        this.mNoDataView.onChangeSkinType(this.cgc.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.bWp.BL();
        this.mNoDataView.setVisibility(0);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.Sy = onClickListener;
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
    public void a(com.baidu.tieba.tbadkCore.data.i iVar, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        if (iVar != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = iVar.getAuthor().getUserId();
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
            if (this.cgq != null && this.cgq.acX() != null && this.cgq.acX().getAuthor() != null && iVar.getAuthor() != null) {
                String userId3 = this.cgq.acX().getAuthor().getUserId();
                String userId4 = iVar.getAuthor().getUserId();
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
                    userId = iVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = iVar.apV() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_forbid_user_name, iVar.getAuthor().getUserName());
                        sparseArray.put(i.f.tag_forbid_user_post_id, iVar.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(i.f.tag_forbid_user_name, "");
                        z6 = false;
                    }
                    if (!z4) {
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_del_post_is_self, true);
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(i.f.tag_del_post_id, iVar.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(i.f.tag_del_post_is_self, false);
                        sparseArray.put(i.f.tag_del_post_type, 0);
                        sparseArray.put(i.f.tag_del_post_id, "");
                    }
                    sparseArray.put(i.f.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(i.f.tag_forbid_user_post_id, iVar.getId());
                    if (!z2) {
                        sparseArray.put(i.f.tag_should_manage_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_forbid_user_name, iVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(i.f.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(i.f.tag_display_reply_visible, true);
                        sparseArray.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (iVar.getAuthor() != null) {
                            sparseArray.put(i.f.tag_disable_reply_mute_userid, iVar.getAuthor().getUserId());
                            sparseArray.put(i.f.tag_disable_reply_mute_username, iVar.getAuthor().getUserName());
                        }
                        if (this.cgq.acX() != null) {
                            sparseArray.put(i.f.tag_disable_reply_thread_id, this.cgq.acX().getId());
                        }
                        sparseArray.put(i.f.tag_disable_reply_post_id, iVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_display_reply_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(i.f.tag_should_delete_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(i.f.tag_del_post_id, iVar.getId());
                        return;
                    }
                    sparseArray.put(i.f.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = iVar.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (iVar.apV() != 1) {
            }
            if (!z2) {
            }
            if (!z4) {
            }
            sparseArray.put(i.f.tag_should_manage_visible, Boolean.valueOf(z6));
            sparseArray.put(i.f.tag_forbid_user_post_id, iVar.getId());
            if (!z2) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public View afa() {
        return this.cgi;
    }

    public void onChangeSkinType(int i) {
        this.cgc.getLayoutMode().ad(i == 1);
        this.cgc.getLayoutMode().k(this.bYB);
        this.cgc.getLayoutMode().k(this.cga);
        this.mNavigationBar.onChangeSkinType(this.cgc.getPageContext(), i);
        this.aRF.onChangeSkinType(this.cgc.getPageContext(), i);
        this.cgc.getLayoutMode().k(this.cgi);
        com.baidu.tbadk.core.util.al.c(this.cdb, i.e.btn_pb_reply_selector);
        this.cdc.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.pb_listitem_content));
        this.cdc.setVideoImageId(i.e.pic_video);
        if (this.bWp != null && this.bWp.Ay() != null) {
            this.bWp.Ay().onChangeSkinType(i);
        }
    }

    public void afb() {
        this.mProgress.setVisibility(0);
    }

    public void afc() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.cgh.vB();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cgj = onLongClickListener;
        this.cga.setOnLongClickListener(this.cgj);
    }

    public View afd() {
        return this.cga;
    }

    public void jr(String str) {
        int js = this.cgb.js(str);
        if (js > -1) {
            this.mListView.setSelection(js + 1);
            this.mListView.invalidate();
        }
    }

    public View afe() {
        return this.cge;
    }

    public bz aff() {
        return this.caV;
    }

    public MorePopupWindow afg() {
        return this.caU;
    }

    public HeadImageView afh() {
        return this.ccV;
    }

    public TextView getUserNameView() {
        return this.aII;
    }

    public UserIconBox afi() {
        return this.bco;
    }

    public ImageView afj() {
        return this.ccW;
    }

    public UserIconBox afk() {
        return this.aTN;
    }

    public void Yv() {
        if (this.ceW == null) {
            this.ceW = new com.baidu.tbadk.core.view.a(this.cgc.getPageContext());
        }
        this.ceW.av(true);
    }

    public void aeG() {
        if (this.ceW != null) {
            this.ceW.av(false);
        }
    }

    public TbRichTextView afl() {
        return this.cdc;
    }

    public TextView afm() {
        if (this.cdc == null) {
            return null;
        }
        return this.cdc.getTextView();
    }
}
